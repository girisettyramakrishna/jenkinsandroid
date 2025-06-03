pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io") // 🔥 Add this here
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // 🔥 And here too
    }
}

rootProject.name = "YourProjectName"
include(":app")
