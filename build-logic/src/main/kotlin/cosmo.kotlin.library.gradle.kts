import kw.team.plugin.configureCoroutineKotlin
import kw.team.plugin.configureKotlin

// need to refactor toolchain

plugins {
    kotlin("jvm")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

configureKotlin()
configureCoroutineKotlin()
