package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;


public class MoveInitialPCMModelPartitionJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	public static final String INITIAL_PCM_MODEL_PARTITION_ID = "initialPCModelPartitionID";
	MDSDBlackboard blackboard;
	
	public MoveInitialPCMModelPartitionJob() {
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		String id = LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID;
		PCMResourceSetPartition partition = (PCMResourceSetPartition)this.blackboard.getPartition(id);
		this.blackboard.removePartition(id);
		this.blackboard.addPartition(MoveInitialPCMModelPartitionJob.INITIAL_PCM_MODEL_PARTITION_ID, partition);
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		this.blackboard.removePartition(MoveInitialPCMModelPartitionJob.INITIAL_PCM_MODEL_PARTITION_ID);
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	
	


}
