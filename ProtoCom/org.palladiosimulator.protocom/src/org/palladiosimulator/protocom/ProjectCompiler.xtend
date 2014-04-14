package org.palladiosimulator.protocom

import de.uka.ipd.sdq.workflow.jobs.JobFailedException
import org.eclipse.core.resources.ICommand
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.JavaModelException
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.pde.core.plugin.PluginRegistry
import org.eclipse.pde.internal.core.ClasspathComputer
import org.eclipse.pde.internal.core.natures.PDE

class ProjectCompiler {
	static var IProjectDescription description
	
	def public static void compileProject(IProject project, IProgressMonitor monitor, String projectType){
		if (project != null){
			
			// create description
			createDescription(project, monitor,projectType);
	
			// create JavaProject
			setProjectToJavaProject(project);
			
			// set Plug-In class path
			setClasspath(project);
	
			refreshPluginInWorkspace(monitor, project);
			
			buildProject(monitor, project);
			
			checkForErrors(project);
		}
		
		else throw new Error("Compiling the project failed because it does not exist")
	}
	
	/**
	 * Create a project description and set the JavaCore.NATURE_ID and
	 * PDE.PLUGIN_NATURE
	 */
	def private static void createDescription(IProject project, IProgressMonitor monitor, String projectType)
			throws JobFailedException {
		if(projectType == "PROTO" || projectType == "POJO"){
			var String [] natures = #[JavaCore.NATURE_ID,PDE.PLUGIN_NATURE ]
			description = ResourcesPlugin.getWorkspace()
					.newProjectDescription(project.getName());
			description.setNatureIds(natures);
			description.setLocation(null);
			// set java builders
			var  command = description.newCommand();
			command.setBuilderName(JavaCore.BUILDER_ID);
			var ICommand [] buildCommand = #[command]
			description.setBuildSpec(buildCommand);
			try {
				project.setDescription(description, monitor);
			} catch (CoreException e) {
				throw new JobFailedException("Failed setting Java and PDE nature and builders",e);
			}
		}
		else if(projectType == "EJB3"){
			var String [] natures = #["org.eclipse.jem.workbench.JavaEMFNature","org.eclipse.wst.common.modulecore.ModuleCoreNature","org.eclipse.wst.common.project.facet.core.nature","org.eclipse.jdt.core.javanature"]
			description = ResourcesPlugin.getWorkspace()
					.newProjectDescription(project.getName());
			description.setNatureIds(natures);
			description.setLocation(null);
			// set java builders
			var  command = description.newCommand();
			var commandFacet= description.newCommand();
			var commandValidationBuilder = description.newCommand()
			command.setBuilderName(JavaCore.BUILDER_ID);
			commandFacet.setBuilderName("org.eclipse.wst.common.project.facet.core.builder");
			commandValidationBuilder.setBuilderName("org.eclipse.wst.validation.validationbuilder");
			var ICommand [] buildCommand = #[command,commandFacet,commandValidationBuilder]
			description.setBuildSpec(buildCommand);
			try {
				project.setDescription(description, monitor);
			} catch (CoreException e) {
				throw new JobFailedException("Failed setting Java EE nature and builders",e);
			}
		}
	}
	
		/**
	 * Create the Java-Project from IProject and set "src", "bin" folder to
	 * classpath
	 */
	def private static void setProjectToJavaProject(IProject project)
			throws JobFailedException {
		// create class path entry
		var IJavaProject javaProject = JavaCore.create(project);
		var IPath srcPath = javaProject.getPath().append("src");
		var IPath binPath = javaProject.getPath().append("bin");
		var IClasspathEntry[] buildPath = #[ JavaCore.newSourceEntry(srcPath),
				JavaRuntime.getDefaultJREContainerEntry() ]
		try {
			javaProject.setRawClasspath(buildPath, binPath, null);
		} catch (JavaModelException e) {
			throw new JobFailedException("Failed setting up JDT project",e);
		}
	}
	
	/* (non-Javadoc)
	 * @See org.eclipse.pde.internal.ui.wizards.plugin.ClasspathComputer.setClasspath(IProject)
	 */
	def private static void setClasspath(IProject project) throws JobFailedException {
		try {
			ClasspathComputer.setClasspath(project, PluginRegistry
					.findModel(project));
		} catch (CoreException e) {
			throw new JobFailedException("Failed to set JDT classpath",e);
		}
	}
	
	/**
	 * @param monitor
	 * @param project
	 * @throws JobFailedException
	 */
	def private static void refreshPluginInWorkspace(IProgressMonitor monitor,
			IProject project) throws JobFailedException {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (Exception e) {
			throw new JobFailedException("Refreshing plugin project failed", e);
		}
	}
	
	/**
	 * @param monitor
	 * @param project
	 * @throws JobFailedException
	 */
	def  private static void buildProject(IProgressMonitor monitor, IProject project)
			throws JobFailedException {
		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		} catch (Exception e) {
			throw new JobFailedException("Building plugin project failed", e);
		}
	}
	
	/**
	 * @param project
	 * @throws JobFailedException
	 */
	def private static void checkForErrors(IProject project) throws JobFailedException {
		try {
			if (project.findMarkers(IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE).length > 0) {
				var failed = false;
				var IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true,
						IResource.DEPTH_INFINITE);
				var errorList = "";
				for (marker : markers) {
					if ((marker.getAttribute(IMarker.SEVERITY)) == IMarker.SEVERITY_ERROR) {
						errorList = errorList + marker.getAttribute(IMarker.MESSAGE)
								+ "\n";
						failed = true;
					}
				}
				if (failed)
					throw new JobFailedException(
							"Unable to build the simulation plugin. Failure Messages: "
									+ errorList);
			}
		} catch (CoreException e) {
			throw new JobFailedException(
					"Compile Plugin failed. Error finding project markers.", e);
		}
	}
	
	
}