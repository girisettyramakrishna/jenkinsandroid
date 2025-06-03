// build.gradle.kts (Project level)

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")  // Use Kotlin syntax for URL
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")  // Use parentheses and quotes
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
