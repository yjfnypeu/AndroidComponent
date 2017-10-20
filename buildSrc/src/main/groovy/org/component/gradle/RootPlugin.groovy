package org.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class RootPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if (project != project.rootProject) {
            throw new RuntimeException("You must apply the plugin : 'haoge.speedup' on root build.gradle")
        }
        project.extensions.create("speedup", SpeedupExtension)
        project.subprojects {
            it.plugins.apply(UploadPlugin)
        }
    }

}
