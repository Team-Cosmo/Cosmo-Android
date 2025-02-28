import kw.team.plugin.setNamespace

plugins {
    id("cosmo.android.feature")
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("feature.home")
}

dependencies {
    implementation(projects.domain.subject)

    // kotlinx-serialization
    implementation(libs.kotlinx.serialization.json)
}
