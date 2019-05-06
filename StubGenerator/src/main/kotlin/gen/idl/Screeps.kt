package gen.idl

val idlScreeps = listOf(
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
        "Game",
        Attribute("cpu", idlInterfaceRef("Cpu"), readOnly = true, isStatic = true),
        Attribute("gcl", idlInterfaceRef("Gcl"), readOnly = true, isStatic = true),
        Attribute("gpl", idlInterfaceRef("Gpl"), readOnly = true, isStatic = true),
        Attribute("time", idlInt, readOnly = true, isStatic = true),
        Operation(
            "notify", idlVoid, true,
            Arg("message", idlString),
            Arg("groupInterval", idlInt)
        )
    )
)
