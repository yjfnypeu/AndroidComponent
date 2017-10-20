package org.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency

public class ReplacePlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        def log = project.logger
        project.configurations.all { configuration ->
            if (configuration.dependencies.size() == 0) {
                return
            }
            configuration.dependencies.all { dependency ->
                def dependencyProject = dependency.properties.get("dependencyProject")
                if (dependencyProject == null) {
                    return
                }

                String name = dependency.name

                if (project.rootProject.excludes.contains(name)) {
                    log.debug "ignore module $name"
                    return
                }

                File repoDir = new File(project.rootDir, ".repo/com/local/maven/$name")
                if (!repoDir.exists()) {
                    log.error "compile project with name : $dependency.name wasn't be upload to local"
                    return
                }
                configuration.dependencies.remove(dependency)
                configuration.dependencies.add(new DefaultExternalModuleDependency("com.local.maven", dependency.name, "local"))
                log.debug("$project.name Replace dependency $dependency.name with local name [com.local.maven:$dependency.name:local] successful!")
            }
        }
    }
}
