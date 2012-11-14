package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.natures.PDE;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.CreatePluginProjectJob;

@SuppressWarnings("restriction")
public class CompilePluginCodeJob implements IJob {

	private AbstractCodeGenerationWorkflowRunConfiguration configuration;

	public CompilePluginCodeJob(
			AbstractCodeGenerationWorkflowRunConfiguration configuration) {
		super();

		this.configuration = configuration;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException {
		assert (this.configuration != null);

		IProject project = CreatePluginProjectJob.getProject(this.configuration
				.getStoragePluginID());
		assert (project != null);

		// create description
		createDescription(project, monitor);

		// create JavaProject
		setProjectToJavaProject(project);

		// set Plug-In class path
		setClasspath(project);

		refreshPluginInWorkspace(monitor, project);
		
		buildProject(monitor, project);
		
		checkForErrors(project);
	}

	/* (non-Javadoc)
	 * @See org.eclipse.pde.internal.ui.wizards.plugin.ClasspathComputer.setClasspath(IProject)
	 */
	private void setClasspath(IProject project) throws JobFailedException {
		try {
			ClasspathComputer.setClasspath(project, PluginRegistry
					.findModel(project));
		} catch (CoreException e) {
			throw new JobFailedException("Failed to set JDT classpath",e);
		}
	}

	/**
	 * Create the Java-Project from IProject and set "src", "bin" folder to
	 * classpath
	 */
	private void setProjectToJavaProject(IProject project)
			throws JobFailedException {
		// create class path entry
		IJavaProject javaProject = JavaCore.create(project);
		IPath srcPath = javaProject.getPath().append("src");
		IPath binPath = javaProject.getPath().append("bin");
		IClasspathEntry[] buildPath = { JavaCore.newSourceEntry(srcPath),
				JavaRuntime.getDefaultJREContainerEntry() };
		try {
			javaProject.setRawClasspath(buildPath, binPath, null);
		} catch (JavaModelException e) {
			throw new JobFailedException("Failed setting up JDT project",e);
		}
	}

	/**
	 * Create a project description and set the JavaCore.NATURE_ID and
	 * PDE.PLUGIN_NATURE
	 */
	private void createDescription(IProject project, IProgressMonitor monitor)
			throws JobFailedException {
		IProjectDescription description = ResourcesPlugin.getWorkspace()
				.newProjectDescription(project.getName());
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				PDE.PLUGIN_NATURE });
		description.setLocation(null);
		// set java builders
		ICommand command = description.newCommand();
		command.setBuilderName(JavaCore.BUILDER_ID);
		description.setBuildSpec(new BuildCommand[] { (BuildCommand) command });
		try {
			project.setDescription(description, monitor);
		} catch (CoreException e) {
			throw new JobFailedException("Failed setting Java and PDE nature and builders",e);
		}
	}

	/**
	 * @param monitor
	 * @param project
	 * @throws JobFailedException
	 */
	private void buildProject(IProgressMonitor monitor, IProject project)
			throws JobFailedException {
		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		} catch (Exception e) {
			throw new JobFailedException("Building plugin project failed", e);
		}
	}

	/**
	 * @param monitor
	 * @param project
	 * @throws JobFailedException
	 */
	private void refreshPluginInWorkspace(IProgressMonitor monitor,
			IProject project) throws JobFailedException {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (Exception e) {
			throw new JobFailedException("Refreshing plugin project failed", e);
		}
	}

	/**
	 * @param project
	 * @throws JobFailedException
	 */
	private void checkForErrors(IProject project) throws JobFailedException {
		try {
			if (project.findMarkers(IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE).length > 0) {
				boolean failed = false;
				IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true,
						IResource.DEPTH_INFINITE);
				String errorList = "";
				for (IMarker marker : markers) {
					if (((Integer) marker.getAttribute(IMarker.SEVERITY)) == IMarker.SEVERITY_ERROR) {
						errorList += marker.getAttribute(IMarker.MESSAGE)
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

	public String getName() {
		return "Compile Plugin Code";
	}

	public void rollback(IProgressMonitor monitor) {
		// do nothing
	}
}
