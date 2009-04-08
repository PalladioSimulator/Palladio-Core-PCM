package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import edu.rice.cs.util.jar.JarBuilder;


public class CompilePluginCodeJob implements IJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;

	public CompilePluginCodeJob(CreatePluginProjectJob createPluginProjectJob) {
		myCreatePluginProjectJob = createPluginProjectJob;
	}

	public void execute() throws JobFailedException {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());

		} catch (Exception e) {
			throw new JobFailedException("Refreshing plugin project failed", e);
		}

		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD,
					new NullProgressMonitor());
		} catch (Exception e) {
			throw new JobFailedException("Building plugin project failed", e);
		}
		try {
			if (project
					.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length > 0) {
				boolean failed = false;
				IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true,
						IResource.DEPTH_INFINITE);
				String errorList = "";
				for (IMarker marker : markers) {
					if (((Integer) marker.getAttribute(IMarker.SEVERITY)) == IMarker.SEVERITY_ERROR) {
						errorList += marker.getAttribute(IMarker.MESSAGE) + "\n";
						failed = true;
					}
				}
				if (failed)
					throw new JobFailedException(
							"Unable to build the simulation plugin. Failure Messages: "
									+ errorList);
			}
		} catch (CoreException e) {
			throw new JobFailedException("Compile Plugin failed. Error finding project markers.", e);
		}
		URI location = null;
		try {
			// location The location identifier of the bundle to install.
			location = project.getLocationURI();
		} catch (Exception e) {
			throw new JobFailedException("Getting project location failed", e);
		}
		try {
			String jarLocation = new File(location).getAbsolutePath() + File.separator + "simucominstance.jar";
			JarBuilder builder = new JarBuilder(new File(jarLocation));
			builder.addDirectoryRecursive(new File(location).listFiles(new FilenameFilter(){
				public boolean accept(File dir, String name) {
					return name.contains("bin");
				}
			})[0], "");
			builder.addDirectoryRecursive(new File(location),"",new FileFilter(){
				public boolean accept(File pathname) {
					return pathname.getName().toUpperCase().contains("META-INF") || pathname.getName().toUpperCase().contains("MANIFEST") || pathname.getName().contains("plugin.xml");
				}
			});
			builder.close();
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (IOException e) {
			throw new JobFailedException("Compile Plugin failed. Error creating JAR archive.", e);
		} catch (CoreException e) {
			throw new JobFailedException("Compile Plugin failed. Error creating JAR archive.", e);
		}
	}

	public String getName() {
		return "Compile Plugin Code";
	}

	public void rollback() {
		// do nothing
	}
}
