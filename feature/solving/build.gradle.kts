import kw.team.plugin.setNamespace

plugins {
    id("cosmo.android.feature")
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("feature.solving")
}

dependencies {
    // domain
    implementation(projects.domain.subject)
    implementation(projects.domain.ai)

    // kotlinx-serialization
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.immutable)
}
