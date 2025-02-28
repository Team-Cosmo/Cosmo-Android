pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Cosmo"

include(":app")

// core
include(
    ":core:designsystem",
    ":core:network",
    ":core:common",
)

// Feature
include(
    ":feature:main",
    ":feature:home",
    ":feature:solving"
)

// domain
include(
    ":domain:subject",
    ":domain:ai",
)

// data
include(
    ":data:ai-gpt",
)
