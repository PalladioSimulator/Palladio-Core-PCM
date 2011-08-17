package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory;

public class DetermineTaskSwitch extends SeffSwitch<List<AlternativeTask>> {

	private TaskmodelBuilder builder = new TaskmodelBuilder();
	private taskmodelFactory factory = taskmodelFactory.eINSTANCE;
	private List<AlternativeTask> alternatives = new ArrayList<AlternativeTask>();
	
	@Override
	public List<AlternativeTask> caseAbstractAction(AbstractAction object) {
		if (object.getSuccessor_AbstractAction() != null){
			return this.doSwitch(object.getSuccessor_AbstractAction());
		} else 
			return null;
	}
	
	


	@Override
	public List<AlternativeTask> caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour object) {
		return this.doSwitch(this.builder.getStartAction(object));
	}

	@Override
	public List<AlternativeTask> caseAbstractLoopAction(AbstractLoopAction object) {
		doSwitch(object.getBodyBehaviour_Loop());
		caseAbstractAction(object);
		return this.alternatives;
	}

	@Override
	public List<AlternativeTask> caseBranchAction(BranchAction object) {

		for (AbstractBranchTransition branch : object.getBranches_Branch()) {
			doSwitch(branch.getBranchBehaviour_BranchTransition());
		}
		
		caseAbstractAction(object);
		return this.alternatives;
	}

	@Override
	public List<AlternativeTask> caseInternalAction(InternalAction object) {
		
		AlternativeTask task = factory.createAlternativeTask();
		this.alternatives.add(task);

		task.setName(object.getEntityName()+" "+object.getId());
		task.setFailureProbability(this.builder.getFailureProbability(object));
		task.setAbstractaction(object);
		
		caseAbstractAction(object);
		
		return this.alternatives;
	}

	
	
}
