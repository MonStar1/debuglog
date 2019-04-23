package debuglog

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

class DebugLogGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        /*
         * Users can configure this extension in their build.gradle like this:
         * debugLog {
         *   enabled = false
         *   // ... set other members on the DebugLogGradleExtension class
         * }
         */
        project.extensions.create(
                "debugLog",
                DebugLogGradleExtension::class.java
        )

        project.tasks.create("HelloTask", Task::class.java) {
            it.exec()
        }
    }
}

open class Task : DefaultTask() {

    @TaskAction
    open fun exec() {
        System.out.printf("Task executed. Hello world")
    }
}