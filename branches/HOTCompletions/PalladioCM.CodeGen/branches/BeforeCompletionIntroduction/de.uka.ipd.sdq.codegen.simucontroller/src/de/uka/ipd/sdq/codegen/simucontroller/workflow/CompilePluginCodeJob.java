package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.NullProgressMonitor;


public class CompilePluginCodeJob implements ISimulationJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;

	public CompilePluginCodeJob(CreatePluginProjectJob createPluginProjectJob) {
		myCreatePluginProjectJob = createPluginProjectJob;
	}

	public void execute() throws Exception {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());

		} catch (Exception e) {
			throw new Exception("Refreshing plugin project failed", e);
		}

		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD,
					new NullProgressMonitor());
		} catch (Exception e) {
			throw new Exception("Building plugin project failed", e);
		}
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
				throw new Exception(
						"Unable to build the simulation plugin. Failure Messages: "
								+ errorList);
		}
	}

	public String getName() {
		return "Compile Plugin Code";
	}

	public void rollback() throws Exception {
	}
}
