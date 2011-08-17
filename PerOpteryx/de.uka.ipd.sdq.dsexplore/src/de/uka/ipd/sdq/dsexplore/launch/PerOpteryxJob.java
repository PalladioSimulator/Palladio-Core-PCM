package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import de.uka.ipd.sdq.workflow.ICompositeJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.PreparePCMBlackboardPartionJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

public class PerOpteryxJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		ICompositeJob {
	
	//DSECandidateConfiguration candidateConfig; 

	public  PerOpteryxJob(DSEWorkflowConfiguration config, DSELaunch launch) throws CoreException {
		super();
		
		// 1. Load PCM Models into memory
		this.addJob(new LoadPCMModelsIntoBlackboardJob(config));
		
		// 2. Validate PCM Models
		this.addJob(new ValidatePCMModelsJob(config));
		
		//TODO remove step 3 and 5, there should be no need 
		//anymore to save the models under a different name. 
		//Do I ever need the initial model? 
		// 3. Create model files for candidate models
		//this.candidateConfig = createCandidateSetup(config);
		
		// 4. Copy initial instance to separate blackboard partition
		this.add(new MoveInitialPCMModelPartitionJob());
		
		// create the PCM partition anew but empty
		this.add(new PreparePCMBlackboardPartionJob());
		
		// 5. Load the candidate models again from updated files
		//this.addJob(new LoadPCMModelsIntoBlackboardJob(candidateConfig));
		
		// 6. Run Optimisation on Loaded Models
		this.add(new OptimisationJob(config, launch));

	}

	@Override
	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		super.rollback(monitor);
		/*try {
			this.candidateConfig.getRawConfiguration().delete();
		} catch (CoreException e) {
			throw new RollbackFailedException("Could not delete launch configuration "+this.candidateConfig.getRawConfiguration().getName(),e);
		}*/
		monitor.worked(1);
	}
	
	
}
