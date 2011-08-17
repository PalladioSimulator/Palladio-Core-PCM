package de.uka.ipd.sdq.pcm.pcm2taskmodel.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig.PCM2TaskModelWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class RunDSolverJob implements IBlackboardInteractingJob<MDSDBlackboard> {

	private MDSDBlackboard blackboard;
	
	public static final String PCM_CONTEXT_MODEL_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.context";

	public RunDSolverJob(PCM2TaskModelWorkflowRunConfiguration config) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) blackboard
			.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		
		ResourceSetPartition contextPartition = createContextModelPartition();

		PCMInstance pcmInstance = new PCMInstance(pcmPartition);
		runDSolver(pcmInstance);

		//put resulting context model into blackboard.
		String prefix = "C:\\temp\\taskmodel\\context";
		
		List<EObject> aggrUsageList = new ArrayList<EObject>(1);
		aggrUsageList.add(pcmInstance.getComputedAggregatedUsage());
		contextPartition.setContents(URI.createFileURI(prefix + ".aggregatedusage"), aggrUsageList);
		
		List<EObject> compAllocList = new ArrayList<EObject>(1);
		compAllocList.add(pcmInstance.getComputedAllocation());
		contextPartition.setContents(URI.createFileURI(prefix + ".computedallocation"), compAllocList);
		
		List<EObject> compUsageList = new ArrayList<EObject>(1);
		compUsageList.add(pcmInstance.getComputedUsage());
		contextPartition.setContents(URI.createFileURI(prefix + ".computedusage"), compUsageList);
		
		
		
		
	}
	
	private ResourceSetPartition createContextModelPartition() {
		ResourceSetPartition contextModelPartition = new ResourceSetPartition();
		this.blackboard.addPartition(PCM_CONTEXT_MODEL_PARTITION_ID, contextModelPartition);
		//not needed here, only for OAW or QVT.
		//contextModelPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		return contextModelPartition;
	}

	private void runDSolver(PCMInstance model) {
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		for (UsageScenario us : model.getUsageModel()
				.getUsageScenario_UsageModel())
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
	}

	@Override
	public String getName() {
		return this.getClass().getCanonicalName();
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Auto-generated method stub
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}

}
