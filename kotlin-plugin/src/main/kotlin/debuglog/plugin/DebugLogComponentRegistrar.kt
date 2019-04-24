package debuglog.plugin

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(ComponentRegistrar::class)
class DebugLogComponentRegistrar : ComponentRegistrar {
  override fun registerProjectComponents(
      project: MockProject,
      configuration: CompilerConfiguration
  ) {
    if (configuration[KEY_ENABLED] == false) {
      return
    }

    val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

    messageCollector.report(
            CompilerMessageSeverity.WARNING,
            "!!! DebugLogComponentRegistrar execute !!!"
    )

//    ClassBuilderInterceptorExtension.registerExtension(
//        project,
//        DebugLogClassGenerationInterceptor(
//            debugLogAnnotations = configuration[KEY_ANNOTATIONS]
//                ?: error("debuglog plugin requires at least one annotation class option passed to it")
//        )
//    )
    // TODO: IrGenerationExtension.registerExtension for Kotlin Native :)
  }
}

