package gen.idl

val idlScreeps = listOf(
    Interface(
        "Game",
        Attribute("time", idlInt, readOnly = true, isStatic = true)
    )
)
