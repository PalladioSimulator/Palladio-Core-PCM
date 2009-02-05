package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
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
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
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
		logger.info("VisitScenarioBehaviour");
		doSwitch(getStartAction(object));
		return object;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseStart(de.uka.ipd.sdq.pcm.usagemodel.Start)
	 */
	@Override
	public Object caseStart(Start object) {
		logger.info("VisitStart");
		doSwitch(object.getSuccessor());
		return object;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseStop(de.uka.ipd.sdq.pcm.usagemodel.Stop)
	 */
	@Override
	public Object caseStop(Stop object) {
		logger.info("VisitStop");
		return object;
	}

	
	
	@Override
	public Object caseBranch(Branch object) {
		logger.info("VisitBranch");
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
		logger.info("VisitEntryLevelSystemCall");
		logger.info("Called System Method "
				+ elsc.getSignature_EntryLevelSystemCall().getServiceName());
		
		if (contextWrapper == null)
			contextWrapper = new ContextWrapper(elsc, pcmInstance);
		else
			contextWrapper = contextWrapper.getContextWrapperFor(elsc);

		ServiceEffectSpecification seff = contextWrapper.getNextSEFF(elsc);
		SeffVisitor visitor = new SeffVisitor(contextWrapper);
		try {
			visitor.doSwitch((ResourceDemandingSEFF) seff);
		} catch (Exception e) {
			logger.error("Error while visiting RDSEFF");
			e.printStackTrace();
		}
		
		doSwitch(elsc.getSuccessor());
		return elsc;
	}

	
	
	@Override
	public Object caseDelay(Delay object) {
		logger.info("VisitDelay");
		doSwitch(object.getSuccessor());
		return object;
	}

	@Override
	public Object caseLoop(Loop object) {
		logger.info("VisitLoop");
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
