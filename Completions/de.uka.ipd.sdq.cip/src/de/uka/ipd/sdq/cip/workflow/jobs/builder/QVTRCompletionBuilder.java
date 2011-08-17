package de.uka.ipd.sdq.cip.workflow.jobs.builder;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.workflow.jobs.PrettyPrintQvtJob;
import de.uka.ipd.sdq.cip.workflow.jobs.QVTRConfigurationJob;
import de.uka.ipd.sdq.cip.workflow.jobs.QVTRHotConfigurationJob;
import de.uka.ipd.sdq.cip.workflow.jobs.SplitTransformationResultJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJobConfiguration;

/**
 * Job Builder for a QVTR transformation completion.
 * This builder can create plain, mark, and feature completions. 
 * 
 * It creates the jobs for a given {@link Transformation} and {@link CompletionConfiguration}.
 *  
 * @author Thomas Schuischel
 *
 */
public class QVTRCompletionBuilder implements CompletionBuilder {

	private CompletionConfiguration completionConfiguration;
	private Transformation transformation;

	/**
	 * Creates a new QVTRCompletionBuilder and stores the configuration parameters.
	 * 
	 * @param completionConfiguration a {@link CompletionConfiguration}
	 * @param transformation 		  a {@link Transformation}
	 */
	public QVTRCompletionBuilder(CompletionConfiguration completionConfiguration, 
			Transformation transformation) {
		this.completionConfiguration = completionConfiguration;
		this.transformation = transformation;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.cip.workflow.jobs.builder.CompletionBuilder#buildJobs()
	 */
	public
	Collection<IJob> buildJobs() {
		
		Collection<IJob> jobs = new ArrayList<IJob>();
		
		// HOT Completion: FeatureConfig -> HOT ->  Generated QVT Completion Script
		if(transformation.getType() == TransformationType.FEATURE)
		{
			// The configuration for a QVTR hot completion
			QVTRTransformationJobConfiguration qvtrHotConfig = new QVTRTransformationJobConfiguration();
		
			// configure the QVTR Job for hot completion
			jobs.add(new QVTRHotConfigurationJob(qvtrHotConfig, completionConfiguration, transformation));
		
			// create the QVT-R model from a feature configuration
			jobs.add(new QVTRTransformationJob(qvtrHotConfig));
		
			// create a QVT-R script file from a QVT-R model
			jobs.add(new PrettyPrintQvtJob(qvtrHotConfig, completionConfiguration, transformation));
		}
		
		// Completion: Input Model -> Generated QVT Completion Script -> Output Model  
		{
			// configure the QVTR Job
			// The configuration for a QVTR completion
			QVTRTransformationJobConfiguration qvtrConfig = new QVTRTransformationJobConfiguration();
			
			// configure the QVTR Job for completion
			jobs.add(new QVTRConfigurationJob(qvtrConfig, completionConfiguration, transformation));
			
			// execute the completion
			jobs.add(new QVTRTransformationJob(qvtrConfig));
			
			// split the created output Resources for each top level element
			jobs.add(new SplitTransformationResultJob(qvtrConfig, completionConfiguration, transformation));
			
			// dump the partition to disk
			jobs.add(new SavePartitionToDiskJob(completionConfiguration.getInputPartitionName()));
		}
		
		return jobs;
		
	}

}
