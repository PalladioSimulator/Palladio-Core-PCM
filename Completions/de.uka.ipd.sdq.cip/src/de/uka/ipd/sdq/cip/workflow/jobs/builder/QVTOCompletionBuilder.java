package de.uka.ipd.sdq.cip.workflow.jobs.builder;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.workflow.jobs.CreateCopyOfModelsJob;
import de.uka.ipd.sdq.cip.workflow.jobs.CreateWorkingCopyOfModelsJob;
import de.uka.ipd.sdq.cip.workflow.jobs.QVTOConfigurationJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Job Builder for a plain QVTO transformation completion.
 *  
 * 
 * 
 * @author Benjamin Klatt
 *
 */
public class QVTOCompletionBuilder implements CompletionBuilder {

	private CompletionConfiguration completionConfiguration;
	private Transformation transformation;

	/**
	 * Constructor to hand over the required configurations to the super type.
	 * 
	 * @param completionConfiguration 	The configuration for the completion
	 * @param transformation			The transformation to execute
	 */
	public QVTOCompletionBuilder(	CompletionConfiguration completionConfiguration, 
										Transformation transformation) {
		this.completionConfiguration = completionConfiguration;
		this.transformation = transformation;
	}

	/**
	 * Build the transformation job itself.
	 * @return The prepared jobs created by this builder.
	 */
	public Collection<IJob> buildJobs() {
		
		Collection<IJob> jobs = new ArrayList<IJob>();
		
		// The configuration for a QVTO completion
		QVTOTransformationJobConfiguration qvtoConfig = new QVTOTransformationJobConfiguration();
		
		// copy models for in-place transformation
		jobs.add(new CreateWorkingCopyOfModelsJob(completionConfiguration, transformation));
		
		// configure the QVTO Job
		jobs.add(new QVTOConfigurationJob(qvtoConfig, completionConfiguration, transformation));
		
		// create and add the qvto job
		jobs.add(new QVTOTransformationJob(qvtoConfig));
		
		// dump the partition to disk
		jobs.add(new SavePartitionToDiskJob(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		
		return jobs;
	}

	

}
