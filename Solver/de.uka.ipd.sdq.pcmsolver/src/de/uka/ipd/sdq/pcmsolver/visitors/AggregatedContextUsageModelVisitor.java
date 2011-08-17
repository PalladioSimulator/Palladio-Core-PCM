package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

/**
 * Visitor that builds up the context model including the aggregated usage context. 
 * Extends the UsageModelVisitor and adds the calculation of execution frequencies. 
 * Uses the {@link AggregatedContextSEFFVisitor} instead of the {@link SeffVisitor}.
 * @author martens
 *
 */
public class AggregatedContextUsageModelVisitor extends UsageModelVisitor {
	
	private double currentFrequency = 1;
	private UsageScenario currentScenario = null;

	public AggregatedContextUsageModelVisitor(PCMInstance inst) {
		super(inst);
		logger = Logger.getLogger(AggregatedContextUsageModelVisitor.class.getName());
	}
	
	

	@Override
	public Object caseUsageModel(UsageModel object) {
		List<UsageScenario> scenarios = object.getUsageScenario_UsageModel();
		for (UsageScenario usageScenario : scenarios) {
			currentScenario = usageScenario;
			doSwitch(usageScenario.getScenarioBehaviour_UsageScenario());
		}
		return null;

	}



	/**
	 * Extends {@link UsageModelVisitor#caseScenarioBehaviour(ScenarioBehaviour)}. Gets the frequency 
	 * of the container of the object, then stores that frequency while calling 
	 * {@link UsageModelVisitor#caseScenarioBehaviour(ScenarioBehaviour)}.
	 * Finally resets the frequency for handling the next action.
	 */
	@Override
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		
		// to avoid rounding errors, reset probability after the call. 
		double oldProbability = this.currentFrequency;
		
		
		//determine container type
		EObject container = object.eContainer();
		
		if (container instanceof BranchTransition){
			BranchTransition branchTransition = (BranchTransition)container;
			this.currentFrequency = this.currentFrequency * branchTransition.getBranchProbability();
		} else if (container instanceof Loop){
			Loop loop = (Loop)container;
			this.currentFrequency = this.currentFrequency * ExpressionHelper.meanValue(ExpressionHelper.getSolvedExpression(loop.getLoopIteration_Loop().getSpecification(), myContextWrapper));
		}
		
		Object result = super.caseScenarioBehaviour(object);
		
		this.currentFrequency = oldProbability;
		
		return result;
	}

	/**
	 * Overwrites {@link UsageModelVisitor#caseEntryLevelSystemCall(EntryLevelSystemCall)}: Created an
	 * {@link AggregatedContextSEFFVisitor} for visiting the next SEFF. 
	 */
	@Override
	//Copied from superclass and adjusted. 
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall elsc) {
		logger.debug("VisitEntryLevelSystemCall");
		logger.debug("Called System Method "
				+ elsc.getOperationSignature__EntryLevelSystemCall().getEntityName());
		
		// Get List of ContextWrappers, one for each called component instance
		List<ContextWrapper> contextWrapperList;
		if (myContextWrapper == null)
			contextWrapperList = ContextWrapper.getContextWrapperFor(elsc, pcmInstance);
		else
			contextWrapperList = myContextWrapper.getContextWrapperFor(elsc);

		for (ContextWrapper contextWrapper : contextWrapperList) {
			ServiceEffectSpecification seff = contextWrapper.getNextSEFF(elsc);
			AggregatedContextSEFFVisitor visitor = new AggregatedContextSEFFVisitor(contextWrapper, this.currentFrequency, seff, this.currentScenario);
			visitor.doSwitch((ResourceDemandingSEFF) seff);
		}
		
		//XXX: The internal myContextWrapper is not affected by the handling of the
		// EntryLevelSystem call because the copies of it handle it. This was different 
		// before allowing replication, when only one ContextWrapper instance was used. 
		doSwitch(elsc.getSuccessor());
		return elsc;
	}


}
