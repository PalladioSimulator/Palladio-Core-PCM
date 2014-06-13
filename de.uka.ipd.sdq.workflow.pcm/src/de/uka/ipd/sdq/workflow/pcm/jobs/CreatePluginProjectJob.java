package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Creates an Eclipse plug-in project with default folders for source code and
 * models. The project can be used to store analysis date, e.g. (transformed)
 * PCM models, simulation code and so on.
 *
 * @author groenda
 */
public class CreatePluginProjectJob implements IJob {

	/** Logger for this class. */
	private Logger logger = Logger.getLogger(CreatePluginProjectJob.class);

	private boolean deleteProject;
	private String myProjectId;
	private boolean overwriteWithoutAsking;

	public CreatePluginProjectJob(
			AbstractPCMWorkflowRunConfiguration configuration) {
		super();

		this.myProjectId = configuration.getStoragePluginID();
		this.deleteProject = configuration.isDeleteTemporaryDataAfterAnalysis();
		this.overwriteWithoutAsking = configuration.isOverwriteWithoutAsking();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#execute()
	 */
	public void execute(IProgressMonitor monitor) throws UserCanceledException,
			JobFailedException {
		ensurePluginProjectNotExisting(monitor);
		createContainerPlugin(monitor);
	}

	/**
	 * @throws UserCanceledException
	 * @throws JobFailedException
	 */
	private void ensurePluginProjectNotExisting(IProgressMonitor monitor)
			throws UserCanceledException, JobFailedException {
		if (pluginFolderExists() || getProject(this.myProjectId).exists()) {
			if (!overwriteWithoutAsking && !userAcceptsDelete()) {
				// abort execution
				throw new UserCanceledException("Aborted by user");
			} else {
				try {
					deleteProject(monitor, getProject(this.myProjectId));
				} catch (CoreException e) {
					throw new JobFailedException("Removing old project failed",
							e);
				}
			}
		}
	}

	/**
	 * @return true, if the folder used for the simulation plugin exists in the
	 *         filesystem, false otherwise
	 */
	private boolean pluginFolderExists() {
		File pluginFolder = ResourcesPlugin.getWorkspace().getRoot()
				.getRawLocation().append(myProjectId).toFile();

		return pluginFolder.exists();
	}

	/**
	 * ask the user if the plugin folder should be deleted using a message
	 * dialog
	 *
	 * @return true, if the user selected "delete", false otherwise
	 */
	private boolean userAcceptsDelete() {
		UserMessageRunner runner = new UserMessageRunner();
		PlatformUI.getWorkbench().getDisplay().syncExec(runner);

		return runner.shouldDelete();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#getName()
	 */
	public String getName() {
		return "Create Plugin Project";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#cleanup()
	 */
	public void cleanup(IProgressMonitor monitor)
			throws CleanupFailedException {
		if (deleteProject) {
			IProject myProject = getProject(this.myProjectId);
			if (myProject == null) {
				return;
			}

			try {
				deleteProject(monitor, myProject);
			} catch (CoreException e) {
				throw new CleanupFailedException("Delete project failed", e);
			}
		}
	}

	/**
	 * @param monitor
	 * @param myProject
	 * @throws RollbackFailedException
	 */
	private void deleteProject(IProgressMonitor monitor, IProject myProject)
			throws CoreException {
		if(logger.isEnabledFor(Level.INFO))
			logger.info("Deleting project " + myProject.getName());

		myProject.close(monitor);
		myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT, monitor);
		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(1, monitor);

		if (pluginFolderExists()) {
			// Eclipse failed in fully cleaning the directory
			clearPluginFolder();
		}
	}

	/**
	 * deletes a folder and all of its contents recursively
	 *
	 * @param folder
	 *            the folder to be deleted
	 * @return true on success, false otherwise
	 */
	private boolean deleteFolder(File folder) {
		if (folder.isDirectory()) {
			for (File child : folder.listFiles()) {
				if (!deleteFolder(child)) {
					return false;
				}
			}
		}

		// empty folders can be deleted directly
		return folder.delete();
	}

	/**
	 * clears the simulation plugin folder
	 */
	private void clearPluginFolder() {
		File pluginFolder = ResourcesPlugin.getWorkspace().getRoot()
				.getRawLocation().append(this.myProjectId).toFile();

		deleteFolder(pluginFolder);
	}

	/**
	 * returns a new project to be used for the simulation
	 *
	 * @return a handle to the project to be used for the simulation
	 */
	public static IProject getProject(String projectId) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectId);
	}

	/**
	 * The function implements all steps, which are necessary for the creation
	 * of a Plugin Project
	 *
	 * @param projectId
	 *            The ID of the new project
	 * @param monitor
	 *            The progress monitor which displays progress
	 * @return - container project (Plug-In)
	 */
	public void createContainerPlugin(IProgressMonitor monitor)
			throws JobFailedException {
		try {
			IProject project = getProject(this.myProjectId);

			IFolder srcFolder = project.getFolder("src");
			IFolder manifestFolder = project.getFolder("META-INF");

			// create resources
			createProject(project, monitor);
			createFolder(project, srcFolder);
			createFolder(project, manifestFolder);
		} catch (CoreException e) {
			throw new JobFailedException(
					"Generation of the Eclipse project failed", e);
		}
	}

	private void createFolder(IProject project, IFolder folder)
			throws CoreException {
		if (project.isOpen() && !folder.exists()) {
			if(logger.isDebugEnabled())
				logger.debug("Creating folder " + folder.getName());
			folder.create(false, true, null);
		}
	}

	private void createProject(IProject project, IProgressMonitor monitor)
			throws CoreException, JobFailedException {
		if (project.exists())
			throw new JobFailedException(
					"Tried to create an existing project. Preceeding cleanup failed");

		if(logger.isDebugEnabled())
			logger.debug("Creating Eclipse workspace project " + project.getName());
		project.create(monitor);
		project.open(monitor);
	}

	/**
	 * Helper class that allows a message box to appear from a non user
	 * interface thread because the workbench shell is otherwise not accessible.
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
			String[] options = { "Delete and Continue", "Abort" };
			MessageDialog dlg = new MessageDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(),
					"Temporary analysis project folder already exists", null,
					"The project used for the analysis already exists. Should "
							+ myProjectId
							+ " and all of its contents be deleted?",
					MessageDialog.QUESTION, options, 1);

			// check if the user selected Delete
			if (dlg.open() == 0) {
				myshouldDelete = true;
			} else {
				myshouldDelete = false;
			}

		}

	}
}
