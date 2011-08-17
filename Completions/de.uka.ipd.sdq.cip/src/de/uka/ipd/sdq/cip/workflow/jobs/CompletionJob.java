package de.uka.ipd.sdq.cip.workflow.jobs;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.CompletionConfigurationProvider;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.workflow.jobs.builder.QVTOCompletionBuilder;
import de.uka.ipd.sdq.cip.workflow.jobs.builder.QVTRCompletionBuilder;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * CompletionJob iterates over all configured completions and creates the required jobs
 * 
 * @author Thomas Schuischel
 * 
 */
public class CompletionJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		IBlackboardInteractingJob<MDSDBlackboard> {
	
	/**
	 * Creates a composite job for completions from a {@link CompletionConfigurationProvider}
	 * 
	 * @param configurationProvider		A class providing a {@link CompletionConfiguration} through 
	 * 									the interface {@link CompletionConfigurationProvider}
	 */
	public CompletionJob(CompletionConfigurationProvider configurationProvider) {
		this(configurationProvider.getCompletionConfiguration());
	}

	/**
	 * Creates a composite job for completions from a {@link CompletionConfiguration}
	 * 
	 * @param configuration				The configuration for all completions
	 */
	public CompletionJob(CompletionConfiguration configuration) {
		super();
		
		// only continue if there is a configuration and 
		// at least one transformation configured
		if(configuration == null || configuration.getTransformations().size() < 1)
			return;
		
		// Prepare the necessary preconditions for completions
		add(new PrepareTransformationsJob(configuration));
		
		for(Transformation transformation : configuration.getTransformations()) {
			switch(transformation.getQVTType()) {
			
			// Handle QVTR completions
			case QVTR:
				addAll(new QVTRCompletionBuilder(
						configuration, 
						transformation)
				.buildJobs());
			break;

			// Handle QVTO completions
			case QVTO:
				addAll(new QVTOCompletionBuilder( 
						configuration, 
						transformation)
				.buildJobs());
				break;
				
			// Handle wrong completion type
			default:
				JobFailedException e = new JobFailedException("Unable to create ComplitionJob");
				logger.error("unknown QVT type: " + transformation.getQVTType(), e);
			}
				
		}
		
	}
}