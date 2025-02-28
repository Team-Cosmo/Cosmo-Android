import kw.team.plugin.configureHiltAndroid
import kw.team.plugin.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
