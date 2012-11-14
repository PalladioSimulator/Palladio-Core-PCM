/**
 * 
 */
package de.uka.ipd.sdq.workflow.pcm.jobs;

import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.emf.CheckEMFConstraintsJob;
import de.uka.ipd.sdq.workflow.mdsd.oaw.PerformOAWCheckValidation;
import de.uka.ipd.sdq.workflow.mdsd.validation.ModelValidationJob;
import de.uka.ipd.sdq.workflow.mdsd.validation.ShowValidationErrorsJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;


/**
 * A job for running model validation checks. The job executes both, OCL and oAW check, validations on a PCM model instance.
 * If errors are found, they are reported to the user for corrections.
 * @author Steffen Becker
 */
public class ValidatePCMModelsJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> {

	private static final String PCM_CHECK_FILENAME = "pcm";
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#execute()
	 */
	public ValidatePCMModelsJob(AbstractPCMWorkflowRunConfiguration configuration) {
		super();
		this.setName("Checking PCM model constraints");
		this.addJob(new PerformOAWCheckValidation(
				LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, 
				PCM_CHECK_FILENAME, 
				AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES));
		this.addJob(new CheckEMFConstraintsJob(SeverityEnum.WARNING,LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		this.addJob(new ShowValidationErrorsJob(configuration, this.toArray(new ModelValidationJob[]{})));
	}
}
