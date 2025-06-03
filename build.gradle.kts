// build.gradle.kts (project-level)
plugins {
    // Use the Gradle plugin portal to get Android plugin version
    id("com.android.application") version "8.1.1" apply false
    kotlin("android") version "1.9.0" apply false
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
