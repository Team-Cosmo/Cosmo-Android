import kw.team.plugin.configureCoroutineAndroid
import kw.team.plugin.configureHiltAndroid
import kw.team.plugin.configureKotlinAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
