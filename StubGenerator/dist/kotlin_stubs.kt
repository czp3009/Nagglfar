package screeps

import kotlinx.wasm.jsinterop.*

@SymbolName("knjs_get__Game_time")
external public fun knjs_get__Game_time(resultArena: Int): Int

open class Game(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    companion object {
        val time: Int
            get() {
                val wasmRetVal = knjs_get__Game_time(ArenaManager.currentArena)
                return wasmRetVal
            }

    }
}

val JsValue.asGame: Game
    get() {
        return Game(this.arena, this.index)
    }
