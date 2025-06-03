apply plugin: 'com.android.application'

android {
    compileSdkVersion 33
    defaultConfig {
        applicationId "com.ramki.jenkins"
        minSdkVersion 21
        targetSdkVersion 33
        versionCode 1
        versionName "1.0"

        // Enable Java 8 features if needed
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    // ZXing barcode scanner core library
    implementation 'com.google.zxing:core:3.4.1'

    // ZXing Android integration library
    implementation 'com.journeyapps:zxing-android-embedded:4.3.0'  // Alternative to manual integration, supports BarcodeFormat

    // ZBar barcode scanner library for Symbol class
    implementation 'me.dm7.barcodescanner:zbar:1.9'

    // AndroidX libraries (update if you use androidx)
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    // Other dependencies you might have
    // implementation 'com.google.android.material:material:1.8.0'
}

