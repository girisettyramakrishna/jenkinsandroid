pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        // jcenter() // deprecated, add only if you really need it
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // jcenter() // deprecated, add only if needed
    }
}

rootProject.name = "free"  // Change this to your actual root project name if different
include(":app")
