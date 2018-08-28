package com.nemosw.spigot.jar

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer

class SpigotJarPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {

        target.allprojects.forEach {
            println it.name
            TaskContainer tasks = it.tasks

            it.pluginManager.withPlugin('java', {
                Task processResources = tasks.processResources
                processResources.doFirst {
                    processResources.expand target.properties
                }
            })

            println it.name
        }

        SpigotJarExtension ext = target.extensions.create('spigotJar', SpigotJarExtension, target.allprojects.collect())

        target.pluginManager.withPlugin('java', {
            // setup properties for plugin.yml
            target.tasks.processResources.doFirst {
                target.tasks.processResources.expand target.properties
            }
            // setup uber jar
            if (target == target.getRootProject()) {
                target.jar {
                    from { ext.getIncludes().collect { it.sourceSets.main.output } }
                    includeEmptyDirs false
                }
            }
        })
    }
}
