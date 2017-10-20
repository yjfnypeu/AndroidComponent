package org.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class RootPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if (project != project.rootProject) {
            throw new RuntimeException("You must apply the plugin : 'haoge.speedup' on root build.gradle")
        }
        def logger = project.logger
        Properties local = new Properties()
        def is =project.rootProject.file('local.properties').newInputStream()
        local.load(is)
        boolean enable = local.get("speedup.enable", false)
        if (!enable) {
            logger.debug("speedup plugin is disable")
            return
        }
        project.ext {
            excludes = (local.get("excludeModules", "") as String).split(',')
        }
        logger.debug("exclude modules === $project.excludes")
        project.subprojects {
            it.plugins.apply(UploadPlugin)
        }
    }

}
