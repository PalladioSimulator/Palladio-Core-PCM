package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.completions.CompletionRepository
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.system.System
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.repository.RepositoryComponent",
	"pcm.system.System",
	"completions.Completion",
	"completions.CompletionRepository"
])
class CompletionsXpt {
	@Inject M2TFileSystemAccess fsa
	
	@Inject extension PCMext
	@Inject extension RepositoryXpt
	@Inject extension ComposedStructureXpt
	@Inject extension ProvidedPortsXpt
	@Inject extension ContextPatternXpt
	@Inject extension JavaNamesExt
	
	def void root(CompletionRepository repository) {
		repository.completions_CompletionRepository.forEach[it.completionRoot]
	}

	def expandCompletions(System system) {
		system.allCompletions.forEach [
			completionRoot(it)
		]
	}

	def void completionRoot(Completion completion) {
		val fileName = completion.getFileName
		val fileContent = '''
			«completion.composedStructureStart»
			«completion.providedPorts»
			«completion.requiredInterfaces»
			«completion.composedStructureEnd»
		'''
		
		fsa.generateFile(fileName, fileContent)
		
		completion.assemblyContexts__ComposedStructure.map[encapsulatedComponent__AssemblyContext].forEach[innerCompletionComponent(it)]
	}
	
	def dispatch innerCompletionComponent(RepositoryComponent comp) '''
		«comp.componentRoot»
	'''
	
	def dispatch innerCompletionComponent(Completion comp) '''
		«comp.completionRoot»
	'''
}