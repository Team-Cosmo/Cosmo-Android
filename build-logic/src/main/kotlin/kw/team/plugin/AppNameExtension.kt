package kw.team.plugin

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "kw.team.cosmo.$name"
    }
}
