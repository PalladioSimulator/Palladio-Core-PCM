package org.palladiosimulator.protocom

import de.uka.ipd.sdq.workflow.jobs.JobFailedException
import org.apache.log4j.Logger
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor

/**@author Sebastian Lehrig, Daria Giacinto
 * TODO Modify JavaDoc
 */
class ProtoComProject {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(ProtoComProject);
	
	private val String projectURI
	private val String filePath
	private val IProject iProject;
	
	
	new(String projectURI, String filePath) {
		this.projectURI = projectURI
		this.filePath = filePath
		this.iProject = createProject(projectURI, new NullProgressMonitor)
	}
	
	def private IProject createProject(String projectURI, IProgressMonitor monitor)
			throws JobFailedException {
		val iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectURI);		
		
		if (iProject.exists())
			throw new JobFailedException(
					"Tried to create an existing project. Preceeding cleanup failed");

		if(logger.isDebugEnabled())
			logger.debug("Creating Eclipse workspace project " + this.iProject.getName());
		iProject.create(monitor);
		iProject.open(monitor);
		
		return iProject;
	}
	
	def getIProject() {
		iProject
	}
}
