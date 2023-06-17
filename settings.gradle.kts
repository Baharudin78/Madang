pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}
rootProject.name = "Madang"
include(":app")
include(":core-network")
include(":core")
include(":core-infrastructure")
include(":core-domain")
include(":core-datasource")
include(":core-cache")
include(":feat-common")
