import kw.team.plugin.setNamespace

plugins {
    id("cosmo.android.library")
}

android {
    setNamespace("data.ai_gpt")
}

dependencies {
    // domain
    implementation(projects.domain.ai)

    // core
    implementation(projects.core.network)
    implementation(projects.core.common)
}

dependencies {
}
