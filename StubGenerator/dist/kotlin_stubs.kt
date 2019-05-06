package screeps

import kotlinx.wasm.jsinterop.*

@SymbolName("knjs_get__Cpu_limit")
external fun knjs_get__Cpu_limit(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Cpu_tickLimit")
external fun knjs_get__Cpu_tickLimit(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Cpu_bucket")
external fun knjs_get__Cpu_bucket(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Cpu_shardLimits")
external fun knjs_get__Cpu_shardLimits(arena: Int, index: Int, resultArena: Int): Int

open class Cpu(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    val limit: Int
        get() {
            val wasmRetVal = knjs_get__Cpu_limit(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val tickLimit: Int
        get() {
            val wasmRetVal = knjs_get__Cpu_tickLimit(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val bucket: Int
        get() {
            val wasmRetVal = knjs_get__Cpu_bucket(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val shardLimits: JsValue
        get() {
            val wasmRetVal = knjs_get__Cpu_shardLimits(this.arena, this.index, ArenaManager.currentArena)
            return JsValue(ArenaManager.currentArena, wasmRetVal)
        }

    companion object {
    }
}

val JsValue.asCpu: Cpu
    get() {
        return Cpu(this.arena, this.index)
    }

@SymbolName("knjs_get__Gcl_level")
external fun knjs_get__Gcl_level(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Gcl_progress")
external fun knjs_get__Gcl_progress(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Gcl_progressTotal")
external fun knjs_get__Gcl_progressTotal(arena: Int, index: Int, resultArena: Int): Int

open class Gcl(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    val level: Int
        get() {
            val wasmRetVal = knjs_get__Gcl_level(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val progress: Int
        get() {
            val wasmRetVal = knjs_get__Gcl_progress(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val progressTotal: Int
        get() {
            val wasmRetVal = knjs_get__Gcl_progressTotal(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    companion object {
    }
}

val JsValue.asGcl: Gcl
    get() {
        return Gcl(this.arena, this.index)
    }

@SymbolName("knjs_get__Gpl_level")
external fun knjs_get__Gpl_level(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Gpl_progress")
external fun knjs_get__Gpl_progress(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__Gpl_progressTotal")
external fun knjs_get__Gpl_progressTotal(arena: Int, index: Int, resultArena: Int): Int

open class Gpl(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    val level: Int
        get() {
            val wasmRetVal = knjs_get__Gpl_level(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val progress: Int
        get() {
            val wasmRetVal = knjs_get__Gpl_progress(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    val progressTotal: Int
        get() {
            val wasmRetVal = knjs_get__Gpl_progressTotal(this.arena, this.index, ArenaManager.currentArena)
            return wasmRetVal
        }

    companion object {
    }
}

val JsValue.asGpl: Gpl
    get() {
        return Gpl(this.arena, this.index)
    }

@SymbolName("knjs_get__Game_cpu")
external fun knjs_get__Game_cpu(resultArena: Int): Int

@SymbolName("knjs_get__Game_gcl")
external fun knjs_get__Game_gcl(resultArena: Int): Int

@SymbolName("knjs_get__Game_gpl")
external fun knjs_get__Game_gpl(resultArena: Int): Int

@SymbolName("knjs_get__Game_time")
external fun knjs_get__Game_time(resultArena: Int): Int

@SymbolName("knjs__Game_notify")
external fun knjs__Game_notify(messagePtr: Int, messageLen: Int, groupInterval: Int, resultArena: Int): Unit

open class Game(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)
    companion object {
        val cpu: Cpu
            get() {
                val wasmRetVal = knjs_get__Game_cpu(ArenaManager.currentArena)
                return Cpu(ArenaManager.currentArena, wasmRetVal)
            }

        val gcl: Gcl
            get() {
                val wasmRetVal = knjs_get__Game_gcl(ArenaManager.currentArena)
                return Gcl(ArenaManager.currentArena, wasmRetVal)
            }

        val gpl: Gpl
            get() {
                val wasmRetVal = knjs_get__Game_gpl(ArenaManager.currentArena)
                return Gpl(ArenaManager.currentArena, wasmRetVal)
            }

        val time: Int
            get() {
                val wasmRetVal = knjs_get__Game_time(ArenaManager.currentArena)
                return wasmRetVal
            }

        fun notify(message: String, groupInterval: Int): Unit {
            knjs__Game_notify(
                stringPointer(message),
                stringLengthBytes(message),
                groupInterval,
                ArenaManager.currentArena
            )
            return
        }

    }
}
val JsValue.asGame: Game
    get() {
        return Game(this.arena, this.index)
    }
