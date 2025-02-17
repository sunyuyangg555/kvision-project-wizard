package tech.stonks.kvizard.step.library_choice

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import tech.stonks.kvizard.KVisionModuleBuilder
import javax.swing.JComponent

class LibraryChoiceStep(private val _builder: KVisionModuleBuilder) : ModuleWizardStep() {
    private val _view: LibraryChoiceView by lazy {
        LibraryChoiceView(
            _builder.projectType,
            _builder.groupId,
            _builder.artifactId,
            _builder.compilerBackend,
            _builder.selectedModules,
            _builder.selectedInitializers,
            _builder.versionData.modules
        ).apply {
            onChanged = {
                updateDataModel()
            }
        }
    }

    override fun getComponent(): JComponent {
        return _view
    }

    override fun updateDataModel() {
        _builder.projectType = _view.projectType
        _builder.groupId = _view.groupId
        _builder.artifactId = _view.artifactId
        _builder.compilerBackend = _view.compilerBackend
        _builder.selectedModules = _view.selectedModules
        _builder.selectedInitializers = _view.selectedInitializers
    }
}
