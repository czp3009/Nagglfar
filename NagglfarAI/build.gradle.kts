plugins {
    kotlin("multiplatform") version Kotlin.version
}

kotlin {
    wasm32 {
        binaries {
            executable("compiled")
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
