plugins {
    id("cosmo.android.application")
}

android {
    namespace = "kw.team.cosmo"

    defaultConfig {
        applicationId = "kw.team.cosmo"
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }
}

dependencies {
    // feature
    implementation(projects.feature.main)
    implementation(projects.feature.home)
    implementation(projects.feature.solving)

    // domain
    implementation(projects.domain.subject)
    implementation(projects.domain.ai)

    // data
    implementation(projects.data.aiGpt)

    // core
    implementation(projects.core.designsystem)
    implementation(projects.core.network)
}
