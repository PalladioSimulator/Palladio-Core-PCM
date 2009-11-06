/**
 * 
 */
package de.uka.ipd.sdq.cip.workflow.jobs;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.completions.CompletionEntry;
import de.uka.ipd.sdq.cip.runconfig.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * @author thomasS
 *
 */
public class CompletionTransformationChainJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		IBlackboardInteractingJob<MDSDBlackboard> {
	private CompletionConfiguration configuration;

	public CompletionTransformationChainJob(CompletionConfiguration configuration) {
		super();
		this.configuration = configuration;
		
		configuration.setLastPartition(configuration.getModelPartition());
		
		Iterator<CompletionEntry> iterator = configuration.getCompletionEntrys().iterator();
		while(iterator.hasNext()) {
			CompletionEntry completionEntry = iterator.next();
			
			if(!completionEntry.isActive())
				continue;
			
			this.addJob(new CompletionTransformationJob(completionEntry, configuration));
		}
		
		this.addJob(new SplitJob(configuration));
		
		
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		// get project from first model file
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(ConstantsContainer.outputPartition);
		//URI uri = this.myBlackboard.getPartition(configuration.getModelPartition()).getResourceSet().getResources().get(1).getURI();
		//IProject project = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(uri.toFileString())).getProject();
		
		try {
			if(project.exists())
				project.delete(true, true, monitor);
			project.create(monitor);
			project.open(monitor);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		configuration.setProject(project);
		
		this.myBlackboard.getPartition(configuration.getModelPartition()).initialiseResourceSetEPackages(ConstantsContainer.PCM_EPACKAGES);
		super.execute(monitor);
	}
	
	

}
