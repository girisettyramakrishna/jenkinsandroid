plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.yourapp" // Replace with your actual namespace
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.yourapp"  // Replace with your actual app ID
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

repositories {
    google()
    mavenCentral()
    jcenter()  // Add this line to resolve me.dm7.barcodescanner:zbar dependency
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0") // adjust Kotlin version
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    // Your barcode scanner dependency causing the issue
    implementation("me.dm7.barcodescanner:zbar:1.9.13")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
