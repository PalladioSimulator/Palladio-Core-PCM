package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

/**
 * @author Koziolek
 * 
 */
public class UsageModelVisitor extends UsagemodelSwitch {

	private static Logger logger = Logger.getLogger(UsageModelVisitor.class
			.getName());

	private PCMInstance pcmInstance;
	private ComputedUsageFactory compUsageFactory;
	private ComputedAllocationFactory compAllocationFactory;
	private ParameterFactory parameterFactory;
			
	private ContextWrapper contextWrapper = null;
	
	/**
	 * @param inst
	 *            an instance of the Palladio Component Metamodel
	 */
	public UsageModelVisitor(PCMInstance inst) {
		pcmInstance = inst;
		compUsageFactory = ComputedUsageFactory.eINSTANCE;
		compAllocationFactory = ComputedAllocationFactory.eINSTANCE;
		parameterFactory = ParameterFactory.eINSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseScenarioBehaviour(de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour)
	 */
	@Override
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		logger.debug("VisitScenarioBehaviour");
		doSwitch(getStartAction(object));
		return object;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseStart(de.uka.ipd.sdq.pcm.usagemodel.Start)
	 */
	@Override
	public Object caseStart(Start object) {
		logger.debug("VisitStart");
		doSwitch(object.getSuccessor());
		return object;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseStop(de.uka.ipd.sdq.pcm.usagemodel.Stop)
	 */
	@Override
	public Object caseStop(Stop object) {
		logger.debug("VisitStop");
		return object;
	}

	
	
	@Override
	public Object caseBranch(Branch object) {
		logger.debug("VisitBranch");
		EList<BranchTransition> btList = object.getBranchTransitions_Branch();
		for(BranchTransition bt : btList){
			doSwitch(bt.getBranchedBehaviour_BranchTransition());
		}
		doSwitch(object.getSuccessor());
		return object;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseEntryLevelSystemCall(de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall)
	 */
	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall elsc) {
		logger.debug("VisitEntryLevelSystemCall");
		logger.debug("Called System Method "
				+ elsc.getSignature_EntryLevelSystemCall().getServiceName());
		
		if (contextWrapper == null)
			contextWrapper = new ContextWrapper(elsc, pcmInstance);
		else
			contextWrapper = contextWrapper.getContextWrapperFor(elsc);

		ServiceEffectSpecification seff = contextWrapper.getNextSEFF(elsc);
		SeffVisitor visitor = new SeffVisitor(contextWrapper);
		//try {
			visitor.doSwitch((ResourceDemandingSEFF) seff);
		/*} catch (Exception e) {
			logger.error("Error while visiting RDSEFF");
			e.printStackTrace();
		}*/
		
		doSwitch(elsc.getSuccessor());
		return elsc;
	}

	
	
	@Override
	public Object caseDelay(Delay object) {
		logger.debug("VisitDelay");
		doSwitch(object.getSuccessor());
		return object;
	}

	@Override
	public Object caseLoop(Loop object) {
		logger.debug("VisitLoop");
		doSwitch(object.getBodyBehaviour_Loop());
		doSwitch(object.getSuccessor());
		return object;
	}

	/**
	 * @param object
	 * @return
	 */
	private Start getStartAction(ScenarioBehaviour object) {
		Start startAction = (Start) EMFHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Start.class);
		return startAction;
	}

}
