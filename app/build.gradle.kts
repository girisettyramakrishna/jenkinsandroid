plugins {
    id("com.android.application") version "7.4.0" apply false
    kotlin("android") version "1.8.0" apply false
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

// no repositories here!
dependencies {
    implementation(kotlin("stdlib"))
}
