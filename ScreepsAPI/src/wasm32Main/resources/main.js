let heap;
let wasmInstance;

function utf8encode(s) {
    return unescape(encodeURIComponent(s));
}

function utf8decode(s) {
    return decodeURIComponent(escape(s));
}

function fromString(string, pointer) {
    for (let i = 0; i < string.length; i++) {
        heap[pointer + i] = string.charCodeAt(i);
    }
    heap[pointer + string.length] = 0;
}

function toString(pointer) {
    let string = "";
    for (let i = pointer; heap[i] !== 0; i++) {
        string += String.fromCharCode(heap[i]);
    }
    return string;
}

function toUTF16String(pointer, size) {
    let string = '';
    for (let i = pointer; i < pointer + size; i += 2) {
        string += String.fromCharCode(heap[i] + heap[i + 1] * 256);
    }
    return string;
}

function twoIntsToDouble(upper, lower) {
    const buffer = new ArrayBuffer(8);
    const ints = new Int32Array(buffer);
    const doubles = new Float64Array(buffer);
    ints[1] = upper;
    ints[0] = lower;
    return doubles[0];
}

function doubleToTwoInts(value) {
    const buffer = new ArrayBuffer(8);
    const ints = new Int32Array(buffer);
    const doubles = new Float64Array(buffer);
    doubles[0] = value;
    return {upper: ints[1], lower: ints[0]}
}

function int32ToHeap(value, pointer) {
    heap[pointer] = value & 0xff;
    heap[pointer + 1] = (value & 0xff00) >>> 8;
    heap[pointer + 2] = (value & 0xff0000) >>> 16;
    heap[pointer + 3] = (value & 0xff000000) >>> 24;
}

const env = {
    Konan_js_arg_size: () => -1,
    Konan_js_fetch_arg: () => "",
    write: (fd, str) => {
        if (fd !== 1 && fd !== 2) throw (`write(${fd}, ...)`);
        console.log(utf8decode(toString(str)));
    },
    abort: () => {
        throw new Error("abort()")
    },
    Konan_notify_memory_grow: () => heap = new Uint8Array(wasmInstance.exports.memory.buffer),
    Konan_date_now: pointer => {
        const now = Date.now();
        const high = Math.floor(now / 0xffffffff);
        const low = Math.floor(now % 0xffffffff);
        int32ToHeap(low, pointer);
        int32ToHeap(high, pointer + 4);
    },
    Konan_abort: pointer => {
        throw new Error(`Konan_abort(${utf8decodeallocateArenajsinteropallocateArenajsinterop(toString(pointer))})`)
    },
    Konan_exit: status => {
        throw new Error(`Konan_exit(${status})`)
    },
    exit: status => {
        throw Error(`Kotlin process called exit (${status})`)
    },
    arenas: new Map(),
    nextArena: 0,
    Konan_js_allocateArena: array => {
        const index = env.nextArena++;
        env.arenas.set(index, array || []);
        return index;
    },
    Konan_js_freeArena: arenaIndex => {
        const arena = env.arenas.get(arenaIndex);
        arena.forEach((element, index) => {
            arena[index] = null;
        });
        env.arenas.delete(arenaIndex);
    },
    Konan_js_pushIntToArena: (arenaIndex, value) => {
        const arena = env.arenas.get(arenaIndex);
        arena.push(value);
        return arena.length - 1;
    },
    Konan_js_addObjectToArena: (arenaIndex, object) => {
        const arena = env.arenas.get(arenaIndex);
        arena.push(object);
        return arena.length - 1;
    },
    Konan_js_wrapLambda: (functionArenaIndex, index) => () => {
        const functionArena = env.arenas.get(functionArenaIndex);
        const argumentArenaIndex = env.Konan_js_allocateArena(Array.prototype.slice.call(arguments));
        const resultIndex = wasmInstance.exports.Konan_js_runLambda(index, argumentArenaIndex, arguments.length);
        const result = kotlinObject(argumentArenaIndex, resultIndex);
        env.Konan_js_freeArena(argumentArenaIndex);
        return result;
    },
    Konan_js_getInt: (arenaIndex, objIndex, propertyNamePtr, propertyNameLength) => {
        const property = toUTF16String(propertyNamePtr, propertyNameLength);
        return kotlinObject(arenaIndex, objIndex)[property];
    },
    Konan_js_getProperty: (arenaIndex, objIndex, propertyNamePtr, propertyNameLength) => {
        const property = toUTF16String(propertyNamePtr, propertyNameLength);
        const arena = env.arenas.get(arenaIndex);
        const value = arena[objIndex][property];
        arena.push(value);
        return arena.length - 1;
    },
    Konan_js_setFunction: (arena, obj, propertyName, propertyNameLength, func) => {
        const name = toUTF16String(propertyName, propertyNameLength);
        kotlinObject(arena, obj)[name] = env.Konan_js_wrapLambda(arena, func);
    },
    Konan_js_setString: (arena, obj, propertyName, propertyNameLength, stringPtr, stringLength) => {
        const name = toUTF16String(propertyName, propertyNameLength);
        kotlinObject(arena, obj)[name] = toUTF16String(stringPtr, stringLength);
    }
};

function kotlinObject(arenaIndex, objectIndex) {
    const arena = env.arenas.get(arenaIndex);
    if (typeof arena == "undefined") {
        console.log(`No arena index ${arenaIndex}for object ${objectIndex}`);
    }
    return arena[objectIndex]
}

function toArena(arenaIndex, object) {
    return env.Konan_js_addObjectToArena(arenaIndex, object);
}

const screepsImports = {
    knjs_get____Global_Game: resultArena => {
        return toArena(resultArena, Game);
    },
    knjs_get__Game_time: (arena, obj) => {
        return kotlinObject(arena, obj).time
    }
};
Object.assign(env, screepsImports);

const wasmModule = new WebAssembly.Module(require("compiled"));
wasmInstance = new WebAssembly.Instance(wasmModule, {env});
const initAndRunStart = wasmInstance.exports.Init_and_run_start;

module.exports.loop = () => {
    //https://github.com/JetBrains/kotlin-native/blob/master/runtime/src/launcher/cpp/launcher.cpp
    //argc must greater equal than 1
    initAndRunStart(1, [""], 0);
};
