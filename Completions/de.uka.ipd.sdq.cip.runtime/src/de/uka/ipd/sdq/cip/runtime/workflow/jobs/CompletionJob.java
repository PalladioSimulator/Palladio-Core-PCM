package de.uka.ipd.sdq.cip.runtime.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.workflow.jobs.PrepareTransformationsJob;
import de.uka.ipd.sdq.cip.workflow.jobs.builder.QVTOCompletionBuilder;
import de.uka.ipd.sdq.cip.workflow.jobs.builder.QVTRCompletionBuilder;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * CompletionJob iterates over all configured completions and creates the required jobs
 * 
 * @author Thomas Schuischel
 * 
 */
public class CompletionJob extends AbstractSimuComExtensionJob  {
		
	@Override
    public final void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		CompletionExtensionConfiguration compConfiguration = (CompletionExtensionConfiguration) getJobConfiguration();
		compConfiguration.getCompletionConfiguration().setProjectID(configuration.getStoragePluginID());
        // only continue if there is a configuration and 
     		// at least one transformation configured
     		if(compConfiguration == null || compConfiguration.getCompletionConfiguration().getTransformations().size() < 1)
     			return;
     		
     		// Prepare the necessary preconditions for completions
     		add(new PrepareTransformationsJob(compConfiguration.getCompletionConfiguration()));
     		
     		for(Transformation transformation : compConfiguration.getCompletionConfiguration().getTransformations()) {
     			switch(transformation.getQVTType()) {
     			
     			// Handle QVTR completions
     			case QVTR:
     				addAll(new QVTRCompletionBuilder(
     						compConfiguration.getCompletionConfiguration(), 
     						transformation)
     				.buildJobs());
     			break;

     			// Handle QVTO completions
     			case QVTO:
     				addAll(new QVTOCompletionBuilder( 
     						compConfiguration.getCompletionConfiguration(), 
     						transformation)
     				.buildJobs());
     				break;
     				
     			// Handle wrong completion type
     			default:
     				JobFailedException e = new JobFailedException("Unable to create ComplitionJob");
     				logger.error("unknown QVT type: " + transformation.getQVTType(), e);
     			}
     				
     		}
     		super.execute(monitor);
       
    }

}