import kw.team.plugin.setNamespace

plugins {
    id("cosmo.android.library")
    id("kotlinx-serialization")
}

android {
    setNamespace("core.network")
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
}
