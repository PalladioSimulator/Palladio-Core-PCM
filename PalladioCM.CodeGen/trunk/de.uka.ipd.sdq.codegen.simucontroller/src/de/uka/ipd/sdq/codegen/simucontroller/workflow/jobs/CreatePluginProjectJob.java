package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;


public class CreatePluginProjectJob 
implements IJob {

	private Logger logger = Logger.getLogger(CreatePluginProjectJob.class);
		
	private boolean deleteProject;
	private String myProjectId;

	public CreatePluginProjectJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
		super();
		
		this.myProjectId = configuration.getPluginID();
		this.deleteProject = configuration.shouldDeleteGeneratedCodeOnCleanup();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#execute()
	 */
	public void execute(IProgressMonitor monitor) throws UserCanceledException, JobFailedException{
		ensurePluginProjectNotExisting(monitor);
		createContainerPlugin(monitor);
	}

	/**
	 * @throws UserCanceledException
	 * @throws JobFailedException 
	 */
	private void ensurePluginProjectNotExisting(IProgressMonitor monitor) throws UserCanceledException, JobFailedException {
		if (pluginFolderExists()) {
			if (!userAcceptsDelete()) {
				// abort execution
				throw new UserCanceledException("Aborted by user");
			} else {
				try {
					deleteProject(monitor, getProject(this.myProjectId));
				} catch (CoreException e) {
					throw new JobFailedException("Removing old project failed",e);
				}
			}
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
		.append(myProjectId)
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
	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		if (deleteProject) {
			IProject myProject = getProject(this.myProjectId);
			if (myProject == null) {
				return;
			}
			
			try {
				deleteProject(monitor, myProject);
			} catch (CoreException e) {
				throw new RollbackFailedException("Delete project failed",e);
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
		logger.info("Deleting project "+myProject.getName());
		
		myProject.close(monitor);
		myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT,
					monitor);
		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(1,
				monitor);
		
		if (pluginFolderExists()) {
			// Eclipse failed in fully cleaning the directory
			clearPluginFolder();
		}
	}
	
	/**
	 * deletes a folder and all of its contents recursively
	 * 
	 * @param folder the folder to be deleted
	 * @return true on success, false otherwise
	 */
	private boolean deleteFolder(File folder) {
		if (folder.isDirectory()) {
			for(File child:folder.listFiles()) {
				System.out.println(child.toString());
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
		File pluginFolder = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getRawLocation()
		.append(this.myProjectId)
		.toFile();
	
		deleteFolder(pluginFolder);
	}	
	
	/**
	 * returns a new project to be used for the simulation
	 * 
	 * @return a handle to the project to be used for the simulation
	 */
	public static IProject getProject(String projectId) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectId);
	}
	
	/**
	 * The function implements all steps, which are necessary for the creation of
	 * a Plugin Project
	 * @param projectId The ID of the new project
	 * @param monitor The progress monitor which displays progress
	 * @return - container project (Plug-In)
	 */
	public void createContainerPlugin(IProgressMonitor monitor) throws JobFailedException {
		try {
			IProject project = getProject(this.myProjectId);
	
			IFolder srcFolder = project.getFolder("src");
			IFolder manifestFolder = project.getFolder("META-INF");
	
			// create resources
			createProject(project, monitor);
			createFolder(project, srcFolder);
			createFolder(project, manifestFolder);		
		} catch (CoreException e) {
			throw new JobFailedException("Generation of the Eclipse project failed",e);
		}
	}

	private void createFolder(IProject project, IFolder folder)
			throws CoreException {
		if (project.isOpen() && !folder.exists()) {
			logger.debug("Creating folder " + folder.getName());
			folder.create(false, true, null);
		}
	}

	private void createProject(IProject project, IProgressMonitor monitor)
			throws CoreException {
		if (!project.exists()) {
			logger.debug("Creating Eclipse workspace project " + project.getName());
			project.create(monitor);
		}
		project.open(monitor);
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
					"The folder used for the simulation project already exists. Should " + myProjectId + " and all of its contents be deleted?",
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
