apply plugin: 'com.android.application'

android {
    compileSdkVersion 34

    defaultConfig {
        applicationId "com.example.myapplication"
        minSdkVersion 21
        targetSdkVersion 34
        versionCode 1
        versionName "1.0"

        // For Kotlin projects, enable Compose compiler or other features here if needed
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])

    // ZXing core library for BarcodeFormat, WriterException
    implementation 'com.google.zxing:core:3.5.2'

    // ZXing Android Embedded (scanner UI helper)
    implementation 'com.journeyapps:zxing-android-embedded:4.3.0'

    // Apache HttpClient (legacy HTTP support)
    implementation 'org.apache.httpcomponents:httpclient:4.5.13'

    // ZBar scanner (if your project uses it)
    implementation 'me.dm7.barcodescanner:zbar:1.9.13'

    // AndroidX dependencies, adjust according to your project
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    // Kotlin standard library if using Kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.9.0"

    // Other dependencies your project requires...
}
