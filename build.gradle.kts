plugins {
    kotlin("multiplatform") version "1.3.31"
}

repositories {
    mavenCentral()
}

kotlin {
    wasm32 {
        binaries {
            executable {
                entryPoint = "screeps.main"
            }
        }
    }
}
