package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ResourceManagerTab;


public class CreatePluginProjectJob implements ISimulationJob {

	private IProject myProject;
	private boolean deleteProject;

	public CreatePluginProjectJob(ILaunchConfiguration configuration) {
		myProject = null;
		try {
			deleteProject = configuration.getAttribute(ResourceManagerTab.DELETE_PLUGIN, true);
		} catch (CoreException e) {
			deleteProject = true;
		}
	}

	public IProject getProject() {
		return myProject;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#execute()
	 */
	public void execute() throws Exception {
		try {
			myProject = PluginProject.createInstance().createContainerPlugin(
					new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Creating plugin project failed", e);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#getName()
	 */
	public String getName() {
		return "Create Plugin Project";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#rollback()
	 */
	public void rollback() throws Exception {
		if (myProject == null) {
			return;
		}
		try {
			if (deleteProject)
				myProject.close(new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Closing plugin project failed", e);
		}

		try {
			if (deleteProject)
				myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT,
						new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Deleting plugin project failed", e);
		}
	}
}
