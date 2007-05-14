package de.uka.ipd.sdq.simucom.behaviour;

import java.util.ArrayList;
import java.util.Iterator;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption;
import de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;
import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.history.HistoryElement;
import de.uka.ipd.sdq.simucom.history.HistoryHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simucom.stochastics.RandomVariableHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class BehaviourVisitor extends ReflectiveVisitor {

	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();

	protected SimProcess myParentProcess = null;

	protected Context myContext = null;
	
	protected SimulatedStackFrame myStackFrame = null;
	
	protected SimTime startTime, stopTime;

	private String histogramId;

	public BehaviourVisitor(SimProcess parent, Context callContext, SimulatedStackFrame stackFrame) {
		super();
		this.myParentProcess = parent;
		myContext = callContext;
		myStackFrame = stackFrame;
	}

	public void visitResourceDemandingSEFF(ResourceDemandingSEFF behaviour) throws Exception {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		SimuComModel model = (SimuComModel)myParentProcess.getModel();

		this.histogramId = myContext.getDerivedAssemblyContext().getEntityName()+"_"+
			myContext.getDerivedAssemblyContext().getEncapsulatedComponent__AssemblyContext().getEntityName()+"_"+
			behaviour.getDescribedService__SEFF().getServiceName();
		
		if (!model.getSensorFactory().hasHistogram(histogramId))
			model.getSensorFactory().createHistogramSensor(histogramId);
		visit(startAction);
	}

	public void visitResourceDemandingBehaviour(ResourceDemandingBehaviour behaviour) throws Exception {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);

		visit(startAction);
	}

	public void visitStartAction(StartAction start) throws Exception {
		// Remember when we started
		startTime = myParentProcess.getModel().currentTime(); 
		
		visit(start.getSuccessor_AbstractAction());
	}

	public void visitStopAction(StopAction stop) throws Exception {
		HistoryHelper.dumpHistory("Behaviour visitor", myHistory);

		// Remember when we started
		stopTime = myParentProcess.getModel().currentTime();
		SimuComModel model = (SimuComModel)myParentProcess.getModel();
		if (histogramId != null)
		{
			model.getSensorFactory().getValueSupplierForSensor(histogramId).newResponseTimeMeassurment(
					SimTime.diff(stopTime, startTime).getTimeValue());
		}
	}

	public void visitInternalAction(InternalAction action) throws Exception {
		myHistory.add(new HistoryElement(SimTime.NOW,
				"Executing internal action " + action.getEntityName()));
		SimuComModel myModel = (SimuComModel)myParentProcess.getModel();
		
		Iterator resourceDemands = action.getResourceDemand_Action().iterator();
		while(resourceDemands.hasNext())
		{
			ParametricResourceDemand paramResDemand = (ParametricResourceDemand) resourceDemands.next();
			AllocationContext myAllocationContext = findAllocationContext(myContext.getDerivedAssemblyContext());
			SimulatedActiveResource activeResource = myModel.getSimulatedResources().getResourceContainer(myAllocationContext.getResourceContainer_AllocationContext().getId()).getActiveResource(paramResDemand.getRequiredResource_ParametricResourceDemand());
			double demand = RandomVariableHelper.getDoubleSample(paramResDemand.getDemand(),myStackFrame);
			activeResource.consumeResource(myParentProcess, demand);
		}
		visit(action.getSuccessor_AbstractAction());
	}

	private AllocationContext findAllocationContext(AssemblyContext assemblyContext)
	{
		Iterator allocationContexts = myContext.getSystem().getAllocation_System().getAllocationContexts().iterator();
		while(allocationContexts.hasNext())
		{
			AllocationContext context = (AllocationContext)allocationContexts.next();
			if (context.getReferencedAssemblyContext_AllocationContext() == assemblyContext)
				return context;
		}
		return null;
	}

	public void visitLoopAction(LoopAction loop) throws Exception {
		myHistory.add(new HistoryElement(SimTime.NOW, "Executing loop "
				+ loop.getEntityName()));
		int actualLoopCount=RandomVariableHelper.getIntSample(loop.getIterations(), myStackFrame);
		for (int i=0; i<actualLoopCount; i++)
		{
			myHistory.add(new HistoryElement(SimTime.NOW, "Executing loop "+loop.getEntityName()+" iteration: "+i));
			BehaviourVisitor loopBodyVisitor = new BehaviourVisitor(myParentProcess, myContext,myStackFrame);
			loopBodyVisitor.visit (loop.getBodyBehaviour_Loop());
		}
		visit(loop.getSuccessor_AbstractAction());
	}
	
	public void visitAquire(AquireAction aquire) throws Exception{
		SimuComModel myModel = (SimuComModel)myParentProcess.getModel();
		AllocationContext myAllocationContext = findAllocationContext(myContext.getDerivedAssemblyContext());

		myModel.getSimulatedResources().getResourceContainer(myAllocationContext.getResourceContainer_AllocationContext().getId()).
			getPassiveResource(aquire.getResourceType_Aquire()).aquire(myParentProcess);
		visit(aquire.getSuccessor_AbstractAction());
	}
	
	public void visitRelease(ReleaseAction release) throws Exception{
		SimuComModel myModel = (SimuComModel)myParentProcess.getModel();
		AllocationContext myAllocationContext = findAllocationContext(myContext.getDerivedAssemblyContext());

		myModel.getSimulatedResources().getResourceContainer(myAllocationContext.getResourceContainer_AllocationContext().getId()).
			getPassiveResource(release.getResourceType_Release()).release();
		visit(release.getSuccessor_AbstractAction());
	}
	
	public void visitExternalCallAction(ExternalCallAction call) throws Exception {
		myHistory.add(new HistoryElement(SimTime.NOW,
				"Calling component service "
						+ call.getCalledService_ExternalService()
								.getServiceName()));

		Signature serviceToBeCalled = call.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();

		// Search assembly Connector
		SystemAssemblyConnector foundAssemblyConnector = findSystemAssemblyConnector(requiredInterface);
		if (foundAssemblyConnector == null) {
			SystemRequiredDelegationConnector foundSystemRequiredDelegationConnector = findSystemRequiredDelegationConnector(requiredInterface);
			assert foundSystemRequiredDelegationConnector != null;
			performSimulatedSystemExternalCall(serviceToBeCalled, foundSystemRequiredDelegationConnector);
		} else {
			// Found assembly Connector -> Perform Component Call
			ResourceDemandingSEFF b = getTargetBehaviourFromAssemblyConnector(foundAssemblyConnector, serviceToBeCalled);
			SimulatedStackFrame newStackFrame = new SimulatedStackFrame();
			newStackFrame.buildParametricParameterContext(call.getParametricParameterUsage_ParametricParameterUsage(),myStackFrame);
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess,
					initializeCallContext(foundAssemblyConnector),
					newStackFrame);
			visitor.visitResourceDemandingSEFF(b);
		}
		visit(call.getSuccessor_AbstractAction());
	}

	/**
	 * @param calledService
	 * @param foundSystemRequiredDelegationConnector
	 * @throws Exception 
	 */
	private void performSimulatedSystemExternalCall(Signature calledService, SystemRequiredDelegationConnector foundSystemRequiredDelegationConnector) throws Exception {
		SystemRequiredRole externalRole = foundSystemRequiredDelegationConnector
				.getSystemRequiredRole_SystemRequiredDelegationConnector();
		Iterator timeConsumptions = externalRole
				.getSpecifiedTimeConsumption_SystemRequiredRole()
				.iterator();
		SimuComModel model = (SimuComModel)myParentProcess.getModel();

		while (timeConsumptions.hasNext()) {
			SpecifiedTimeConsumption consumption = (SpecifiedTimeConsumption) timeConsumptions
					.next();
			if (consumption.getSignature_SpecifiedTimeConsumption().getServiceName().equals(calledService.getServiceName())) {
				String serviceHistogramId = "External_"+myContext.getDerivedAssemblyContext().getEntityName()+"_"+
					externalRole.getInterface_SystemRequiredRole().getEntityName()+"_"+
					calledService.getServiceName();
				if (!model.getSensorFactory().hasHistogram(serviceHistogramId))
					model.getSensorFactory().createHistogramSensor(serviceHistogramId);
				SimTime externalCallStartTime = model.currentTime();
				waitForSpecifiedTimeSpan(consumption);
				model.getSensorFactory().getValueSupplierForSensor(serviceHistogramId).newResponseTimeMeassurment(
						SimTime.diff(model.currentTime(), externalCallStartTime).getTimeValue());
				return;
			}
		}

		throw new Exception("No timing information found on system required role!");
	}

	private ResourceDemandingSEFF getTargetBehaviourFromAssemblyConnector(SystemAssemblyConnector connector, Signature targetMethod) {
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

	/**
	 * @param connector
	 */
	private Context initializeCallContext(SystemAssemblyConnector connector) {
		Context callContext = new Context();
		callContext.setSystem(myContext.getSystem());
		callContext.setDerivedAssemblyContext(connector
				.getProvidingContext_SystemAssemblyConnector());
		return callContext;
	}

	/**
	 * @param requiredRole
	 * @return
	 */
	private SystemRequiredDelegationConnector findSystemRequiredDelegationConnector(
			Interface requiredRole) {
		Iterator delegationIterator = myContext.getSystem()
				.getRequiredDelegationConnector_System().iterator();
		SystemRequiredDelegationConnector result2 = null;
		while (result2 == null && delegationIterator.hasNext()) {
			SystemRequiredDelegationConnector delegationCon = (SystemRequiredDelegationConnector) delegationIterator
					.next();
			if (delegationCon
					.getAssemblyContext_SystemRequiredDelegationConnector()
					.getId().equals(
							myContext.getDerivedAssemblyContext().getId())
					&& delegationCon
							.getRequiredRole_SystemRequiredDelegationConnector()
							.getRequiredInterface__RequiredRole().getId()
							.equals(requiredRole.getId())) {
				result2 = delegationCon;
			}
		}
		return result2;
	}

	/**
	 * @param requiredRole
	 * @return
	 */
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
	 * @param consumption
	 * @throws TokenStreamException 
	 * @throws RecognitionException 
	 */
	private void waitForSpecifiedTimeSpan(SpecifiedTimeConsumption consumption) throws Exception, TokenStreamException {
		double randomSample = RandomVariableHelper.getDoubleSample(consumption.getSpecification(),myStackFrame);
		if (randomSample > 0)
			myParentProcess.hold(new SimTime(randomSample));
	}
}
