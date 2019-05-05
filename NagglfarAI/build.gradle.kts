plugins {
    kotlin("multiplatform") version Kotlin.version
}

kotlin {
    wasm32 {
        binaries {
            executable("compiled", listOf(RELEASE))
        }

        compilations {
            val main by getting {
                defaultSourceSet {
                    dependencies {
                        implementation(project(":ScreepsAPI"))
                    }
                }
            }
        }
    }
}
