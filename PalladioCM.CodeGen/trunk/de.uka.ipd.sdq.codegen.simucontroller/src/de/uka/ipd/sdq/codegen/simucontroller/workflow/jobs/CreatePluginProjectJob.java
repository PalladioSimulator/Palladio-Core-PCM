package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;


public class CreatePluginProjectJob implements IJob {

	private IProject myProject;
	private boolean deleteProject;

	public CreatePluginProjectJob(ILaunchConfiguration configuration) {
		myProject = null;
		try {
			deleteProject = configuration.getAttribute(ConstantsContainer.DELETE_PLUGIN, true);
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
	public void execute() throws UserCanceledException, JobFailedException{
		if (pluginFolderExists()) {
			if (!userAcceptsDelete()) {
				// abort execution
				throw new UserCanceledException("Aborted by user");
			}
		}
			
		try {			
			myProject = PluginProject.createInstance().createContainerPlugin(
					new NullProgressMonitor());
		} catch (CoreException e) {
			throw new JobFailedException("Creating plugin project failed", e);
		}
	}
	
	/** 
	 * @return true, if the folder used for the simulation plugin exists
	 * in the filesystem, false otherwise
	 */
	private boolean pluginFolderExists() {
		File pluginFolder = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getRawLocation()
		.append(PluginProject.PROJECT_ID)
		.toFile();
		
		return pluginFolder.exists();
	}
	
	/**
	 * ask the user if the plugin folder should be deleted using
	 * a message dialog
	 * @return true, if the user selected "delete", false otherwise
	 */
	private boolean userAcceptsDelete() {
		UserMessageRunner runner = new UserMessageRunner();
		PlatformUI.getWorkbench().getDisplay().syncExec(runner);
		
		return runner.shouldDelete();
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
	public void rollback() throws RollbackFailedException {
		if (myProject == null) {
			return;
		}
		try {
			if (deleteProject)
				myProject.close(new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RollbackFailedException("Closing plugin project failed", e);
		}

		try {
			if (deleteProject)
				myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT,
						new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RollbackFailedException("Deleting plugin project failed", e);
		}
	}
	
	/**
	 * Helper class that allows a message box to
	 * appear from a non user interface thread because the
	 * workbench shell is otherwise not accessible.
	 * 
	 * @author Philipp Meier
	 */
	private class UserMessageRunner implements Runnable {
		private boolean myshouldDelete = false;

		
		public UserMessageRunner() {
			super();
		}
		
		public boolean shouldDelete() {
			return myshouldDelete;
		}

		public void run() {
			String[] options = {"Delete and Continue", "Abort"};
			MessageDialog dlg = new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Simulation project folder already exists",
					null,
					"The folder used for the simulation project already exists. Should " + PluginProject.PROJECT_ID + " and all of its contents be deleted?",
					MessageDialog.QUESTION,
					options,
					1
					);
			
			// check if the user selected Delete
			if(dlg.open() == 0) {
				myshouldDelete = true;
			}
			else {
				myshouldDelete = false;
			}
			
		}

	}
}
