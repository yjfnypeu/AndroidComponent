package org.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.MavenPlugin

public class UploadPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        project.plugins.apply(MavenPlugin)
        project.afterEvaluate {
            def speedup = project.rootProject.extensions.getByType(SpeedupExtension)
            if (!speedup.enable) {
                logger.debug("plugin speedup disable")
                return
            }
            String[] excludes = speedup.excludes
            project.plugins.apply(ReplacePlugin)

            if (project == project.rootProject
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
