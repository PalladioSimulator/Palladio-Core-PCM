package org.palladiosimulator.protocom.lang

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtext.generator.AbstractFileSystemAccess2

/**
 * Abstract class representing generated files.
 * 
 * Generic type defines the common interface for language and provider classes. 
 * 
 * @author Thomas Zolynski
 */
abstract class GeneratedFile<L extends ICompilationUnit> implements ICompilationUnit { 
	
	@Inject
	protected Injector injector 
	
	/**
	 * File System Access used for storing this file.
	 */
	@Inject
	protected AbstractFileSystemAccess2 fsa
	
	/**
	 * Provider for this compilation unit. Providers need to implement the language interface, 
	 * since these are used for delegation.
	 * 
	 * TODO: Add (Xtend) annotations which generate the boilerplate code for provider delegation.
	 *       e.g. @Provided
	 */
	protected L provider
		
	override String filePath() {
		provider.filePath
	}

	/**
	 * Inject the provider for this generated file.
	 */
	def createFor(L concept) {	
		provider = concept
		this
	}
	
	/**
	 * Generate the source code for this compilation unit.
	 */
	def String generate()
	
	/**
	 * Store the generated file using Xtext/Xtend file system access.
	 */
	 def void store() {
		fsa.generateFile(filePath, "PCM", generate)
	}

	
}