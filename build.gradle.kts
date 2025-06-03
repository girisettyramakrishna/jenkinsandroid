// Root-level build.gradle.kts

plugins {
    // Define any top-level plugins if necessary, e.g. Kotlin DSL plugin, etc.
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
