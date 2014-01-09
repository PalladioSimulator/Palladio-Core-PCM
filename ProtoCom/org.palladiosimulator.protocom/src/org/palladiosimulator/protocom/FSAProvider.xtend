package org.palladiosimulator.protocom

import com.google.inject.Provider
import org.eclipse.xtext.generator.AbstractFileSystemAccess2
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import java.util.Map
import org.eclipse.xtext.generator.OutputConfiguration
import java.util.HashMap
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.name.Named

/**
 * Google Guice provider for FileSystemAccess. It configures and
 * injects into FSA objects.
 * 
 * TODO: Class is unfinished. Read configuration from wizard pages.
 * 
 * @author Thomas Zolynski
 */
class FSAProvider implements Provider<AbstractFileSystemAccess2> {
	
	@Inject
	Injector injector
	
	@Inject
	@Named("ProjectURI")
	String projectURI
	
	override AbstractFileSystemAccess2 get() {

		val IWorkspaceRoot root = ResourcesPlugin::getWorkspace().getRoot()
		val IProject project = root.getProject(projectURI)
		project.open(new NullProgressMonitor)	

		val EclipseResourceFileSystemAccess2 fsa = injector.getInstance(typeof(EclipseResourceFileSystemAccess2)) 
		
		// Inject into FSA...
		fsa.setOutputConfigurations(defaultConfig())
		fsa.setProject(project)
		fsa.setMonitor(new NullProgressMonitor)	
		fsa
	}
	
	def Map<String, OutputConfiguration> defaultConfig() {

		val OutputConfiguration defaultOutput = new OutputConfiguration("PCM")
		defaultOutput.setDescription("Output Folder")
		defaultOutput.setOutputDirectory("./src")
		defaultOutput.setOverrideExistingResources(true)
		defaultOutput.setCreateOutputDirectory(true)
		defaultOutput.setCleanUpDerivedResources(true)
		defaultOutput.setSetDerivedProperty(true)

		val Map<String, OutputConfiguration> map = new HashMap<String, OutputConfiguration>()
		map.put("PCM", defaultOutput)
		map
	}
	
}