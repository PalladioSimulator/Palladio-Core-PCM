/**
 * 
 */
package de.uka.ipd.sdq.dsolver.visitors;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;

/**
 * @author Koziolek
 * 
 */
public class SeffSwitchDS extends SeffSwitch {

	private static Logger logger = Logger.getLogger(SeffSwitchDS.class
			.getName());

	private Context myContext;

	private PCMInstance pcmInstance;

	private UsageFactory usageFactory;

	private AllocationFactory actualAllocationFactory;

	public SeffSwitchDS(PCMInstance inst, Context callContext) {
		pcmInstance = inst;
		myContext = callContext;
		usageFactory = UsageFactory.eINSTANCE;
		actualAllocationFactory = AllocationFactory.eINSTANCE;
	}

	@Override
	public Object caseBranchAction(BranchAction branch) {
		logger.debug("VisitBranchAction");
	
		EList btList = branch.getBranches_Branch();
		for (Iterator i = btList.iterator(); i.hasNext();) {
			BranchTransition bt = (BranchTransition) i.next();
			ResourceDemandingBehaviour rdb = bt
					.getBranchBehaviour_BranchTransition();
			doSwitch(rdb);
		}
	
		doSwitch(branch.getSuccessor_AbstractAction());
		return branch;
	}

	@Override
	public Object caseInternalAction(InternalAction action) {
		logger.debug("VisitInternalAction");
		// myHistory.add(new HistoryElement(SimTime.NOW,
		// "Executing internal action " + action.getEntityName()));
		// SimuComModel myModel = (SimuComModel)myParentProcess.getModel();
		//		
		// Iterator resourceDemands =
		// action.getResourceDemand_Action().iterator();
		// while(resourceDemands.hasNext())
		// {
		// ParametricResourceDemand paramResDemand = (ParametricResourceDemand)
		// resourceDemands.next();
		// AllocationContext myAllocationContext =
		// findAllocationContext(myContext.getDerivedAssemblyContext());
		// SimulatedActiveResource activeResource =
		// myModel.getSimulatedResources().getResourceContainer(myAllocationContext.getResourceContainer_AllocationContext().getId()).getActiveResource(paramResDemand.getRequiredResource_ParametricResourceDemand());
		// double demand =
		// RandomVariableHelper.getDoubleSample(paramResDemand.getDemand(),myStackFrame);
		// activeResource.consumeResource(myParentProcess, demand);
		// }
	
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF seff) {
		logger.debug("VisitRDSEFF");
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour) seff;
		doSwitch(getStartAction(rdb));
		return seff;
	}

	@Override
	public Object caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour behaviour) {
		logger.debug("VisitRDBehaviour");
		doSwitch(getStartAction(behaviour));
		return behaviour;
	}

	@Override
	public Object caseStartAction(StartAction object) {
		logger.debug("VisitStartAction");
		doSwitch(object.getSuccessor_AbstractAction());
		return object;
	}

	@Override
	public Object caseStopAction(StopAction object) {
		logger.debug("VisitStopAction");
		saveContexts();
		// no more doSwitch, visitor ends here!
		return object;
	}

	@Override
	public Object caseLoopAction(LoopAction loop) {
		logger.debug("VisitLoopAction");
		doSwitch(loop.getSuccessor_AbstractAction());
		return super.caseLoopAction(loop);
	}

	@Override
	public Object caseAquireAction(AquireAction object) {
		logger.debug("VisitAcquire");
		doSwitch(object.getSuccessor_AbstractAction());
		return object;
	}

	@Override
	public Object caseReleaseAction(ReleaseAction object) {
		logger.debug("VisitRelease");
		doSwitch(object.getSuccessor_AbstractAction());
		return object;
	}

	@Override
	public Object caseExternalCallAction(ExternalCallAction call) {
		logger.debug("VisitExternalCallAction");
		logger.debug("Calling "
				+ call.getCalledService_ExternalService().getServiceName());

		Signature serviceToBeCalled = call.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled
				.eContainer();

		// Search assembly Connector
		SystemAssemblyConnector foundAssemblyConnector = findSystemAssemblyConnector(requiredInterface);
		if (foundAssemblyConnector == null) {
			logger.debug("Found System External Call");
		} else {
			logger.debug("Found Assembly Connector");
			visitNextSeff(serviceToBeCalled, foundAssemblyConnector);
		}

		doSwitch(call.getSuccessor_AbstractAction());
		return call;
	}

	/**
	 * Stores the just built usage and actual allocation context to pcminstance
	 */
	private void saveContexts() {
		UsageContext usageContext = myContext.getUsageContext();
		pcmInstance.getUsage().getUsageContexts().add(usageContext);
		ActualAllocationContext actAll = myContext.getActualAllocationContext();
		pcmInstance.getActualAllocation().getActualAllocationContexts().add(
				actAll);
	}

	/**
	 * @param serviceToBeCalled
	 * @param foundAssemblyConnector
	 */
	private void visitNextSeff(Signature serviceToBeCalled,
			SystemAssemblyConnector foundAssemblyConnector) {
		// Found assembly Connector -> Perform Component Call

		Context callContext = createCallContext(foundAssemblyConnector);

		// SimulatedStackFrame newStackFrame = new SimulatedStackFrame();
		// newStackFrame.buildParametricParameterContext(call.getParametricParameterUsage_ParametricParameterUsage(),myStackFrame);

		SeffSwitch visitor = new SeffSwitchDS(pcmInstance, callContext);
		ResourceDemandingSEFF b = getTargetBehaviourFromAssemblyConnector(
				foundAssemblyConnector, serviceToBeCalled);
		visitor.doSwitch(b);
	}

	/**
	 * @param foundAssemblyConnector
	 * @return
	 */
	private Context createCallContext(
			SystemAssemblyConnector foundAssemblyConnector) {
		Context callContext = new Context();
		
		callContext.setSystem(myContext.getSystem());
		callContext.setDerivedAssemblyContext(foundAssemblyConnector
				.getProvidingContext_SystemAssemblyConnector());

		UsageContext uc = usageFactory.createUsageContext();
		EList parList = myContext.getUsageContext()
				.getActualParameterUsage_UsageContext();
		Iterator paramListIter = parList.iterator();
		EList actualParList = uc.getActualParameterUsage_UsageContext();
		while (paramListIter.hasNext()) {
			ParameterUsage pu = (ParameterUsage) paramListIter.next();
			// uc.getActualParameterUsage_UsageContext().add(pu);
			//actualParList.add(pu);
		}
		callContext.setUsageContext(uc);

		
		ActualAllocationContext aac = actualAllocationFactory
				.createActualAllocationContext();
		aac.setUsageContext_ActualAllocationContext(uc);
		callContext.setActualAllocationContext(aac);
		
		return callContext;
	}

	private SystemAssemblyConnector findSystemAssemblyConnector(
			Interface requiredRole) {
		Iterator connectorIterator = myContext.getSystem().getAssembly_System()
				.getAssemblyConnectors_Assembly().iterator();
		SystemAssemblyConnector result = null;
		while (result == null && connectorIterator.hasNext()) {
			SystemAssemblyConnector connector = (SystemAssemblyConnector) connectorIterator
					.next();
			if (connector.getRequiringContext_SystemAssemblyConnector().getId()
					.equals(myContext.getDerivedAssemblyContext().getId())
					&& connector.getRequiredRole_SystemAssemblyConnector()
							.getRequiredInterface__RequiredRole().getId()
							.equals(requiredRole.getId())) {
				result = connector;
			}
		}
		return result;
	}

	/**
	 * @param behaviour
	 * @return
	 */
	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

	private ResourceDemandingSEFF getTargetBehaviourFromAssemblyConnector(
			SystemAssemblyConnector connector, Signature targetMethod) {
		BasicComponent targetBasicComponent = (BasicComponent) connector
				.getProvidedRole_SystemAssemblyConnector()
				.getProvidingComponent__ProvidedRole();

		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						targetBasicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ targetMethod.getServiceName()
								+ "')->asOrderedSet()->first()");

		return (ResourceDemandingSEFF) seff;
	}

	public PCMInstance getPcmInstance() {
		return pcmInstance;
	}

	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}

}
