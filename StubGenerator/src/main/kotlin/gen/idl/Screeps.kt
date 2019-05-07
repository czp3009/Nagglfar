package gen.idl

val idlScreeps = listOf(
    //GLOBAL OBJECTS
    Interface(
        "Game",
        Attribute("constructionSites", idlObject, readOnly = true, isStatic = true),
        Attribute("cpu", idlInterfaceRef("Cpu"), readOnly = true, isStatic = true),
        Attribute("creeps", idlObject, readOnly = true, isStatic = true),
        Attribute("flags", idlObject, readOnly = true, isStatic = true),
        Attribute("gcl", idlInterfaceRef("Gcl"), readOnly = true, isStatic = true),
        Attribute("gpl", idlInterfaceRef("Gpl"), readOnly = true, isStatic = true),
        Attribute("map", idlInterfaceRef("GameMap"), readOnly = true, isStatic = true),
        Attribute("time", idlInt, readOnly = true, isStatic = true),
        Operation(
            "notify", idlVoid, true,
            Arg("message", idlString),
            Arg("groupInterval", idlInt)
        )
    ),
    Interface(
        "Cpu",
        Attribute("limit", idlInt, true),
        Attribute("tickLimit", idlInt, true),
        Attribute("bucket", idlInt, true),
        Attribute("shardLimits", idlObject, true)
    ),
    Interface(
        "Gcl",
        Attribute("level", idlInt, true),
        Attribute("progress", idlInt, true),
        Attribute("progressTotal", idlInt, true)
    ),
    Interface(
        "Gpl",
        Attribute("level", idlInt, true),
        Attribute("progress", idlInt, true),
        Attribute("progressTotal", idlInt, true)
    ),
    Interface(
        "GameMap",
        Operation(
            "describeExits", idlInterfaceRef("ExistDescriptor"), false,
            Arg("roomName", idlString)
        ),
        Operation(
            "findExit", idlInt, false,
            Arg("fromRoom", idlString),
            Arg("toRoom", idlString)
        ),
        Operation(
            "findRoute", idlObject, false,
            Arg("fromRoom", idlString),
            Arg("toRoom", idlString)
        ),
        Operation(
            "getRoomLinearDistance", idlInt, false,
            Arg("roomName1", idlString),
            Arg("roomName2", idlString)
        )
    ),
    Interface(
        "ExistDescriptor",
        Attribute("1", idlString, readOnly = true),
        Attribute("3", idlString, readOnly = true),
        Attribute("5", idlString, readOnly = true),
        Attribute("7", idlString, readOnly = true)
    )
)
