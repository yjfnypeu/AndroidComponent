package org.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.MavenPlugin

public class UploadPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        def root = project.rootProject
        project.plugins.apply(MavenPlugin)
        project.afterEvaluate {
            String[] excludes = root.excludes
            project.plugins.apply(ReplacePlugin)

            if (project == root
                    || excludes.contains(project.name)
                    || project.plugins.hasPlugin('com.android.application')) {
                return
            }

            project.uploadArchives {
                repositories {
                    mavenDeployer {
                        pom.groupId = "com.local.maven"
                        pom.artifactId = project.name
                        pom.version = "local"
                        repository(url: project.uri(project.rootDir.absolutePath + "/.repo"))

                        pom.whenConfigured { pom ->
                            pom.dependencies.forEach { dep ->
                                if (dep.getVersion() == "unspecified") {
                                    dep.setGroupId("com.local.maven")
                                    dep.setVersion("local")
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
