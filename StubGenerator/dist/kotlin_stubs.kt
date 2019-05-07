package screeps

import kotlinx.wasm.jsinterop.*

@SymbolName("knjs_get__Game_constructionSites")
external fun knjs_get__Game_constructionSites(resultArena: Int): Int

@SymbolName("knjs_get__Game_cpu")
external fun knjs_get__Game_cpu(resultArena: Int): Int

@SymbolName("knjs_get__Game_creeps")
external fun knjs_get__Game_creeps(resultArena: Int): Int

@SymbolName("knjs_get__Game_flags")
external fun knjs_get__Game_flags(resultArena: Int): Int

@SymbolName("knjs_get__Game_gcl")
external fun knjs_get__Game_gcl(resultArena: Int): Int

@SymbolName("knjs_get__Game_gpl")
external fun knjs_get__Game_gpl(resultArena: Int): Int

@SymbolName("knjs_get__Game_map")
external fun knjs_get__Game_map(resultArena: Int): Int

@SymbolName("knjs_get__Game_time")
external fun knjs_get__Game_time(resultArena: Int): Int

@SymbolName("knjs__Game_notify")
external fun knjs__Game_notify(messagePtr: Int, messageLen: Int, groupInterval: Int, resultArena: Int): Unit

open class Game(arena: Int, index: Int) : JsValue(arena, index) {
  constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

  companion object {
    val constructionSites: JsValue
      get() {
        val wasmRetVal = knjs_get__Game_constructionSites(ArenaManager.currentArena)
        return JsValue(ArenaManager.currentArena, wasmRetVal)
      }

    val cpu: Cpu
      get() {
        val wasmRetVal = knjs_get__Game_cpu(ArenaManager.currentArena)
        return Cpu(ArenaManager.currentArena, wasmRetVal)
      }

    val creeps: JsValue
      get() {
        val wasmRetVal = knjs_get__Game_creeps(ArenaManager.currentArena)
        return JsValue(ArenaManager.currentArena, wasmRetVal)
      }

    val flags: JsValue
      get() {
        val wasmRetVal = knjs_get__Game_flags(ArenaManager.currentArena)
        return JsValue(ArenaManager.currentArena, wasmRetVal)
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

    val map: GameMap
      get() {
        val wasmRetVal = knjs_get__Game_map(ArenaManager.currentArena)
        return GameMap(ArenaManager.currentArena, wasmRetVal)
      }

    val time: Int
      get() {
        val wasmRetVal = knjs_get__Game_time(ArenaManager.currentArena)
        return wasmRetVal
      }

    fun notify(message: String, groupInterval: Int): Unit {
      knjs__Game_notify(stringPointer(message), stringLengthBytes(message), groupInterval, ArenaManager.currentArena)
      return
    }

  }
}

val JsValue.asGame: Game
  get() {
    return Game(this.arena, this.index)
  }

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

@SymbolName("knjs__GameMap_describeExits")
external fun knjs__GameMap_describeExits(
  arena: Int,
  index: Int,
  roomNamePtr: Int,
  roomNameLen: Int,
  resultArena: Int
): Int

@SymbolName("knjs__GameMap_findExit")
external fun knjs__GameMap_findExit(
  arena: Int,
  index: Int,
  fromRoomPtr: Int,
  fromRoomLen: Int,
  toRoomPtr: Int,
  toRoomLen: Int,
  resultArena: Int
): Int

@SymbolName("knjs__GameMap_findRoute")
external fun knjs__GameMap_findRoute(
  arena: Int,
  index: Int,
  fromRoomPtr: Int,
  fromRoomLen: Int,
  toRoomPtr: Int,
  toRoomLen: Int,
  resultArena: Int
): Int

open class GameMap(arena: Int, index: Int) : JsValue(arena, index) {
  constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

  fun describeExits(roomName: String): ExistDescriptor {
    val wasmRetVal = knjs__GameMap_describeExits(
      this.arena,
      this.index,
      stringPointer(roomName),
      stringLengthBytes(roomName),
      ArenaManager.currentArena
    )
    return ExistDescriptor(ArenaManager.currentArena, wasmRetVal)
  }

  fun findExit(fromRoom: String, toRoom: String): Int {
    val wasmRetVal = knjs__GameMap_findExit(
      this.arena,
      this.index,
      stringPointer(fromRoom),
      stringLengthBytes(fromRoom),
      stringPointer(toRoom),
      stringLengthBytes(toRoom),
      ArenaManager.currentArena
    )
    return wasmRetVal
  }

  fun findRoute(fromRoom: String, toRoom: String): JsValue {
    val wasmRetVal = knjs__GameMap_findRoute(
      this.arena,
      this.index,
      stringPointer(fromRoom),
      stringLengthBytes(fromRoom),
      stringPointer(toRoom),
      stringLengthBytes(toRoom),
      ArenaManager.currentArena
    )
    return JsValue(ArenaManager.currentArena, wasmRetVal)
  }

    companion object {
    }
}

val JsValue.asGameMap: GameMap
  get() {
    return GameMap(this.arena, this.index)
  }

@SymbolName("knjs_get__ExistDescriptor_1")
external fun knjs_get__ExistDescriptor_1(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__ExistDescriptor_3")
external fun knjs_get__ExistDescriptor_3(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__ExistDescriptor_5")
external fun knjs_get__ExistDescriptor_5(arena: Int, index: Int, resultArena: Int): Int

@SymbolName("knjs_get__ExistDescriptor_7")
external fun knjs_get__ExistDescriptor_7(arena: Int, index: Int, resultArena: Int): Int

open class ExistDescriptor(arena: Int, index: Int) : JsValue(arena, index) {
  constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

  val `1`: String
    get() {
      val wasmRetVal = knjs_get__ExistDescriptor_1(this.arena, this.index, ArenaManager.currentArena)
      return TODO("Implement me")
    }

  val `3`: String
    get() {
      val wasmRetVal = knjs_get__ExistDescriptor_3(this.arena, this.index, ArenaManager.currentArena)
      return TODO("Implement me")
    }

  val `5`: String
    get() {
      val wasmRetVal = knjs_get__ExistDescriptor_5(this.arena, this.index, ArenaManager.currentArena)
      return TODO("Implement me")
    }

  val `7`: String
    get() {
      val wasmRetVal = knjs_get__ExistDescriptor_7(this.arena, this.index, ArenaManager.currentArena)
      return TODO("Implement me")
    }

  companion object {
  }
}

val JsValue.asExistDescriptor: ExistDescriptor
  get() {
    return ExistDescriptor(this.arena, this.index)
  }
