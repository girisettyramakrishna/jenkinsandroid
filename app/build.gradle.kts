plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.free"  // Change to your app's actual namespace
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.free"  // Change to your app's package ID
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.21")
    // Add your other dependencies here
    implementation("me.dm7.barcodescanner:zbar:1.9.13") // Add this if needed, verify if this artifact exists or needs a different repo
}
