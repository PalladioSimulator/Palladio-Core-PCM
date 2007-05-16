package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;


public class CreatePluginProjectJob implements ISimulationJob {

	private IProject myProject;

	public CreatePluginProjectJob() {
		myProject = null;
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
			myProject.close(new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Closing plugin project failed", e);
		}

		try {
			myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT,
					new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Deleting plugin project failed", e);
		}
	}
}
