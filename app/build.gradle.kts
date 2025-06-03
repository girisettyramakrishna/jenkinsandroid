plugins {
    id("com.android.application") version "YOUR_GRADLE_PLUGIN_VERSION" apply false
    kotlin("android") version "YOUR_KOTLIN_VERSION" apply false
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.yourapp"
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

// Note: No repositories block here!
// Dependencies go here if needed:
dependencies {
    implementation(kotlin("stdlib"))
    // other dependencies ...
}
