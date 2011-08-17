package de.uka.ipd.sdq.cip.workflow.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class PrepareTransformationsJob implements IJob{

	/** The logger for this class */
	private Logger logger = Logger.getLogger(PrepareTransformationsJob.class);
	
	/** The project id where to create folders */
	private String projectID;
	
	public PrepareTransformationsJob(CompletionConfiguration configuration) {
		this.projectID = configuration.getProjectID();
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		// Create necessary folders for completion
		
		createFolder(getModelFolder(projectID), logger);
		createFolder(getTracesFolder(projectID), logger);
		createFolder(getHOTTracesFolder(projectID), logger);
		createFolder(getLogFolder(projectID), logger);
	}
	

	/**
	 * returns a new project to be used for the simulation
	 * 
	 * @return a handle to the project to be used for the simulation
	 */
	protected static IProject getProject(String projectId) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectId);
	}
	
	public static IFolder getModelFolder(String projectID) {
		return getProject(projectID).getFolder(ConstantsContainer.MODELFOLDER);
	}
	
	public static IFolder getTracesFolder(String projectID) {
		return getProject(projectID).getFolder(ConstantsContainer.TRACESFOLDER);
	}
	
	public static IFolder getHOTTracesFolder(String projectID) {
		return getProject(projectID).getFolder(ConstantsContainer.HOTTRACESFOLDER);
	}
	
	public static IFolder getLogFolder(String projectID) {
		return getProject(projectID).getFolder(ConstantsContainer.LOGFOLDER);
	}
	
	public static IFolder createFolder(IFolder folder,Logger logger) throws JobFailedException {
		if (folder.getProject().isOpen() && !folder.exists()) {
			logger.debug("Creating folder " + folder.getName());
			try {
				folder.create(false, true, null);
			} catch (CoreException e) {
				logger.error("unable to create model folder");
				throw new JobFailedException(e);
			}
		}
		return folder;
	}

	@Override
	public String getName() {
		return "Prepare project for completion";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {} // nothing to roll back


}
