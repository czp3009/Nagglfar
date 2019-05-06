konan.libraries.push({

    knjs_get__Cpu_limit: (arena, obj) => {
        const result = kotlinObject(arena, obj).limit;
        return result;
    },

    knjs_get__Cpu_tickLimit: (arena, obj) => {
        const result = kotlinObject(arena, obj).tickLimit;
        return result;
    },

    knjs_get__Cpu_bucket: (arena, obj) => {
        const result = kotlinObject(arena, obj).bucket;
        return result;
    },

    knjs_get__Cpu_shardLimits: (arena, obj, resultArena) => {
        const result = kotlinObject(arena, obj).shardLimits;
        return toArena(resultArena, result);
    },

    knjs_get__Gcl_level: (arena, obj) => {
        const result = kotlinObject(arena, obj).level;
        return result;
    },

    knjs_get__Gcl_progress: (arena, obj) => {
        const result = kotlinObject(arena, obj).progress;
        return result;
    },

    knjs_get__Gcl_progressTotal: (arena, obj) => {
        const result = kotlinObject(arena, obj).progressTotal;
        return result;
    },

    knjs_get__Gpl_level: (arena, obj) => {
        const result = kotlinObject(arena, obj).level;
        return result;
    },

    knjs_get__Gpl_progress: (arena, obj) => {
        const result = kotlinObject(arena, obj).progress;
        return result;
    },

    knjs_get__Gpl_progressTotal: (arena, obj) => {
        const result = kotlinObject(arena, obj).progressTotal;
        return result;
    },

    knjs_get__Game_cpu: (resultArena) => {
        const result = Game.cpu;
        return toArena(resultArena, result);
    },

    knjs_get__Game_gcl: (resultArena) => {
        const result = Game.gcl;
        return toArena(resultArena, result);
    },

    knjs_get__Game_gpl: (resultArena) => {
        const result = Game.gpl;
        return toArena(resultArena, result);
    },

    knjs_get__Game_time: () => {
        const result = Game.time;
        return result;
    },

    knjs__Game_notify: (messagePtr, messageLen, groupInterval) => {
        const message = toUTF16String(messagePtr, messageLen);
        const result = Game.notify(message, groupInterval);
        return;
    }
});
