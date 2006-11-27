package de.uka.ipd.sdq.dsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.allocation.ActualAllocation;
import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.context.usage.Usage;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.stochasticexpressions.StoExPrettyPrintVisitor;
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
public class UsageModelVisitor extends UsagemodelSwitch {

	private static Logger logger = Logger.getLogger(UsageModelVisitor.class
			.getName());

	private PCMInstance pcmInstance;

	private UsageFactory usageFactory;

	private AllocationFactory actualAllocationFactory;

	/**
	 * @param inst
	 *            an instance of the Palladio Component Metamodel
	 */
	public UsageModelVisitor(PCMInstance inst) {
		pcmInstance = inst;
		usageFactory = UsageFactory.eINSTANCE;
		actualAllocationFactory = AllocationFactory.eINSTANCE;
		ActualAllocation all = actualAllocationFactory.createActualAllocation();
		Usage usage = usageFactory.createUsage();
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
		Signature signature = call.getSignature_EntryLevelSystemCall();
		ProvidedRole role = call.getProvidedRole_EntryLevelSystemCall();

		logger.debug("Called System Method "
				+ role.getProvidedInterface__ProvidedRole().getEntityName() + "/"
				+ signature.getServiceName());

		ProvidedDelegationConnector delegationConnector = getDelegationConnector(role);
	
		ProvidesComponentType offeringComponent = delegationConnector
				.getChildComponentContext_ProvidedDelegationConnector()
				.getEncapsulatedComponent_ChildComponentContext();

		if (offeringComponent.eClass() == RepositoryPackage.eINSTANCE
				.getBasicComponent()) {
			handleBasicComponent(call, signature, delegationConnector,
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
	private ProvidedDelegationConnector getDelegationConnector(
			ProvidedRole role) {
		ProvidedDelegationConnector delegationConnector = 
			(ProvidedDelegationConnector) EMFHelper
				.executeOCLQuery(
						pcmInstance.getSystem(),
						"self.providedDelegationConnectors_ComposedStructure->select(dc|dc.outerProvidedRole_ProvidedDelegationConnector.providedInterface__ProvidedRole.id = '"
								+ role.getProvidedInterface__ProvidedRole()
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
			ProvidedDelegationConnector delegationConnector,
			ProvidesComponentType offeringComponent) {
		BasicComponent basicComponent = (BasicComponent) offeringComponent;
		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = getSeff(method, basicComponent);
		ResourceDemandingBehaviour b = (ResourceDemandingBehaviour) seff;

		Context callContext = createCallContext(call, delegationConnector);
		
		SeffVisitor visitor = new SeffVisitor(pcmInstance, callContext);
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
			ProvidedDelegationConnector delegationConnector) {
		Context callContext = new Context();

		callContext.setSystem(pcmInstance.getSystem());
		callContext.setAllocation(pcmInstance.getAllocation());
		callContext.setDerivedAssemblyContext(delegationConnector
				.getChildComponentContext_ProvidedDelegationConnector());

		
		UsageContext uc = usageFactory.createUsageContext();
		EList parList = call.getActualParameterUsage_EntryLevelSystemCall();
		
		// hmm... while copying parList, some of the inner elements were
		// not initialized. Added the following for-loop to ensure this.
		// Probably because of EMF's lazy loading? Any nice solution possible?
		for (Object o : parList){
//			ParameterUsage pu = (ParameterUsage)o;
////			EList parChar = pu.getParameterCharacterisation_ParameterUsage();
////			for (Object p : parChar){
////				ParameterCharacterisation pc = (ParameterCharacterisation) p;
////				Expression expr = pc.getSpecification_RandomVariable();
////				StoExPrettyPrintVisitor printer = new StoExPrettyPrintVisitor();
////				String exprStr = (String)printer.doSwitch(expr);
////				pc.setSpecification(exprStr);
////			}
//			pu.getParameter_ParameterUsage().getParameterName();
		}
			
		
		uc.getActualParameterUsage_UsageContext().addAll(parList);
		callContext.setUsageContext(uc);

		ActualAllocationContext aac = actualAllocationFactory
				.createActualAllocationContext();
		aac.setUsageContext_ActualAllocationContext(uc);
		callContext.setActualAllocationContext(aac);

		return callContext;
	}

}
