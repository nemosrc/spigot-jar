package com.nemosw.spigot.jar

import org.gradle.api.Project

class SpigotJarExtension {
    private boolean changeIncludes
    private Project[] includes = []
    private Project[] excludes = []

    SpigotJarExtension(Collection<Project> c) {
        this.includes += c
    }

    Project[] getIncludes() {
        Project[] excludes = this.excludes
        return this.includes.findAll { !excludes.contains(it) }
    }

    void include(Object projects) {
        include0(projects.collect())
    }

    void include(Project... projects) {
        include0(projects.collect())
    }

    void include(Collection<Project> projects) {
        include0(projects)
    }

    private void include0(Collection<Project> projects) {
        if (!changeIncludes.booleanValue()) {
            changeIncludes = true
            this.includes = []
        }

        this.includes += projects
    }

    void exclude(Object projects) {
        exclude0(projects.collect())
    }

    void exclude(Project... projects) {
        exclude0(projects.collect())
    }

    void exclude(Collection<Project> projects) {
        exclude0(projects)
    }

    private void exclude0(Collection<Project> projects) {
        this.excludes += projects
    }
}
