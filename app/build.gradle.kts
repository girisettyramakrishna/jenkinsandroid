plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.myapplication"  // <- Mandatory now, replace with your app's package name
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"  // Your app ID
        minSdk = 21
        targetSdk = 34
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
    implementation(fileTree("libs") {
        include("*.jar")
    })

    implementation("com.google.zxing:core:3.5.2")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("me.dm7.barcodescanner:zbar:1.9.13")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
}
