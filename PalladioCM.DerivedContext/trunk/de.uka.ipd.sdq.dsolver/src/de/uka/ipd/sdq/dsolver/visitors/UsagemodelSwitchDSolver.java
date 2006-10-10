package de.uka.ipd.sdq.dsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;

/**
 * @author Koziolek
 * 
 */
public class UsagemodelSwitchDSolver extends UsagemodelSwitch {

	private static Logger logger = Logger.getLogger(UsagemodelSwitchDSolver.class
			.getName());

	private PCMInstance pcmInstance;

	private UsageFactory usageFactory;

	private AllocationFactory actualAllocationFactory;

	/**
	 * @param inst
	 *            an instance of the Palladio Component Metamodel
	 */
	public UsagemodelSwitchDSolver(PCMInstance inst) {
		pcmInstance = inst;
		usageFactory = UsageFactory.eINSTANCE;
		actualAllocationFactory = AllocationFactory.eINSTANCE;
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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseEntryLevelSystemCall(de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall)
	 */
	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall call) {

		logger.debug("VisitEntryLevelSystemCall");
		Signature method = call.getSignature_EntryLevelSystemCall();
		SystemProvidedRole role = call
				.getSystemProvidedRole_EntryLevelSystemCall();

		logger.debug("Called System Method "
				+ role.getInterface_SystemProvidedRole().getEntityName() + "/"
				+ method.getServiceName());

		SystemProvidedDelegationConnector delegationConnector = getDelegationConnector(role);

		ProvidesComponentType offeringComponent = delegationConnector
				.getAssemblyContext_SystemProvidedDelegationConnector()
				.getEncapsulatedComponent__AssemblyContext();

		if (offeringComponent.eClass() == RepositoryPackage.eINSTANCE
				.getBasicComponent()) {
			handleBasicComponent(call, method, delegationConnector,
					offeringComponent);
		} else {
			// handleCompositeComponent(call, method, delegationConnector,
			// offeringComponent);
			logger.error("Component type not yet supported by visitor.");
			System.exit(-1);
		}

		doSwitch(call.getSuccessor());

		return call;
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
	 * @param role
	 * @return
	 */
	private SystemProvidedDelegationConnector getDelegationConnector(
			SystemProvidedRole role) {
		SystemProvidedDelegationConnector delegationConnector = 
			(SystemProvidedDelegationConnector) EMFHelper
				.executeOCLQuery(
						pcmInstance.getSystem(),
						"self.providedDelegationConnector_System->select(dc|dc.systemProvidedRole_SystemProvidedDelegationConnector.interface_SystemProvidedRole.id = '"
								+ role.getInterface_SystemProvidedRole()
										.getId()
								+ "')->asOrderedSet()->first()");
		return delegationConnector;
	}

	/**
	 * @param call
	 * @param method
	 * @param delegationConnector
	 * @param offeringComponent
	 */
	private void handleBasicComponent(EntryLevelSystemCall call,
			Signature method,
			SystemProvidedDelegationConnector delegationConnector,
			ProvidesComponentType offeringComponent) {
		BasicComponent basicComponent = (BasicComponent) offeringComponent;
		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = getSeff(method, basicComponent);
		ResourceDemandingBehaviour b = (ResourceDemandingBehaviour) seff;

		Context callContext = createCallContext(call, delegationConnector);
		
		SeffSwitchDSolver visitor = new SeffSwitchDSolver(pcmInstance, callContext);
		try {
			visitor.doSwitch((ResourceDemandingSEFF) b);
		} catch (Exception e) {
			logger.error("Error while visiting RDSEFF");
			e.printStackTrace();
		}
	}

	/**
	 * @param method
	 * @param basicComponent
	 * @return
	 */
	private ServiceEffectSpecification getSeff(Signature method,
			BasicComponent basicComponent) {
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						basicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ method.getServiceName()
								+ "')->asOrderedSet()->first()");
		return seff;
	}

	/**
	 * @param call
	 * @param delegationConnector
	 * @return
	 */
	private Context createCallContext(EntryLevelSystemCall call,
			SystemProvidedDelegationConnector delegationConnector) {
		Context callContext = new Context();

		callContext.setSystem(pcmInstance.getSystem());
		callContext.setDerivedAssemblyContext(delegationConnector
				.getAssemblyContext_SystemProvidedDelegationConnector());

		UsageContext uc = usageFactory.createUsageContext();
		EList parList = call.getActualParameterUsage_EntryLevelSystemCall();
		uc.getActualParameterUsage_UsageContext().addAll(parList);
		callContext.setUsageContext(uc);

		ActualAllocationContext aac = actualAllocationFactory
				.createActualAllocationContext();
		aac.setUsageContext_ActualAllocationContext(uc);
		callContext.setActualAllocationContext(aac);

		return callContext;
	}

}
