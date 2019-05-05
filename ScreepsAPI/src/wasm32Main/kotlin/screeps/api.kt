@file:Suppress("FunctionName", "SpellCheckingInspection")

package screeps

import kotlinx.wasm.jsinterop.ArenaManager
import kotlinx.wasm.jsinterop.JsValue

@SymbolName("knjs_get__Game_time")
external fun knjs_get__Game_time(arena: Int, index: Int, resultArena: Int): Int

class Game(arena: Int, index: Int) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    val time: Int
        get() = knjs_get__Game_time(this.arena, this.index, ArenaManager.currentArena)
}

@SymbolName("knjs_get____Global_Game")
external fun knjs_get____Global_Game(resultArena: Int): Int

val game = Game(ArenaManager.currentArena, knjs_get____Global_Game(ArenaManager.currentArena))
