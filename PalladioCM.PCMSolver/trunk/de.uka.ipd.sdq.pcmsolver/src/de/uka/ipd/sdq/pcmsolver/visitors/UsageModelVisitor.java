package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.Context;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.PCMRandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseEntryLevelSystemCall(de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall)
	 */
	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall elsc) {
		logger.info("VisitEntryLevelSystemCall");
		logger.info("Called System Method "
				+ elsc.getSignature_EntryLevelSystemCall().getServiceName());
		
		ContextWrapper ctxWrp = createContextWrapper(elsc);
		ServiceEffectSpecification seff = ctxWrp.getNextSEFF(elsc);
		SeffVisitor visitor = new SeffVisitor(ctxWrp);
		try {
			visitor.doSwitch((ResourceDemandingSEFF) seff);
		} catch (Exception e) {
			logger.error("Error while visiting RDSEFF");
			e.printStackTrace();
		}
		
		doSwitch(elsc.getSuccessor());

		return elsc;
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

	/**
	 * @param call
	 * @return
	 */
	private ContextWrapper createContextWrapper(EntryLevelSystemCall call) {
		ComputedUsageContext compUsgCtx = compUsageFactory
				.createComputedUsageContext();
		Input input = compUsageFactory.createInput();
		compUsgCtx.setInput_ComputedUsageContext(input);
		EList<VariableUsage> parList = call
				.getInputParameterUsages_EntryLevelSystemCall();
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copyVariableUsageToInput(input, vu);
		}
		
		ComputedAllocationContext compAllCtx = compAllocationFactory
				.createComputedAllocationContext();
		compAllCtx.setUsageContext_ComputedAllocationContext(compUsgCtx);

		ContextWrapper contextWrapper = new ContextWrapper(call, pcmInstance, compUsgCtx, compAllCtx);

		//TODO: add default component parameters by component developer
		EList<VariableUsage> confParList = contextWrapper.getAssCtx().getConfigParameterUsages_AssemblyContext();
		for (VariableUsage vu : confParList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(input, contextWrapper, vu);
		}
		
		UsageModel um = contextWrapper.getPcmInstance().getUsageModel();
		EList<UserData> userDataList = um.getUserData_UsageModel();
		for (UserData ud : userDataList){
			if (ud.getAssemblyContext_userData().getId().equals(
					contextWrapper.getAssCtx().getId())) {
				EList<VariableUsage> userParList = ud.getUserDataParameterUsages_UserData();
				for (VariableUsage vu : userParList){
					VariableUsageHelper.copySolvedVariableUsageToInput(input, contextWrapper, vu);
				}
			}
		}
		
		return contextWrapper;
		
	}

}
