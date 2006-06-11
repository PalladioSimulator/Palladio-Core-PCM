package de.uka.ipd.sdq.simucom.behaviour;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeResourceImpl.StackFrame;
import org.eclipse.emf.ocl.expressions.EvaluationVisitor;

import stoex.parser.ExpressionLexer;
import stoex.parser.ExpressionParser;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;

import AssemblyPackage.SystemAssemblyConnector;
import DerivedContext.Context;
import DerivedContext.DerivedContextFactory;
import PalladioCM.RepositoryPackage.BasicComponent;
import PalladioCM.RepositoryPackage.Interface;
import PalladioCM.RepositoryPackage.Signature;
import PalladioCM.SEFFPackage.Behaviour;
import PalladioCM.SEFFPackage.ExternalCall;
import PalladioCM.SEFFPackage.InternalAction;
import PalladioCM.SEFFPackage.Loop;
import PalladioCM.SEFFPackage.ParametricResourceDemand;
import PalladioCM.SEFFPackage.ServiceEffectSpecification;
import PalladioCM.SEFFPackage.StartAction;
import PalladioCM.SEFFPackage.StopAction;
import SystemPackage.SpecifiedTimeConsumption;
import SystemPackage.SystemRequiredDelegationConnector;
import SystemPackage.SystemRequiredRole;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.history.HistoryElement;
import de.uka.ipd.sdq.simucom.history.HistoryHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simucom.stochastics.RandomVariableHelper;
import de.uka.ipd.sdq.simucom.stochastics.StoExEvaluationVisitor;
import de.uka.ipd.sdq.simucom.stochastics.TypeEnum;
import de.uka.ipd.sdq.simucom.stochastics.TypeInferenceVisitor;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class BehaviourVisitor extends ReflectiveVisitor {

	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();

	protected SimProcess myParentProcess = null;

	protected Context myContext = null;
	
	protected SimulatedStackFrame myStackFrame = null;

	public BehaviourVisitor(SimProcess parent, Context callContext, SimulatedStackFrame stackFrame) {
		super();
		this.myParentProcess = parent;
		myContext = callContext;
		myStackFrame = stackFrame;
	}

	public void visitBehaviour(Behaviour behaviour) throws Exception {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		visit(startAction);
	}

	public void visitStartAction(StartAction start) throws Exception {
		visit(start.getSuccessor_AbstractAction());
	}

	public void visitStopAction(StopAction stop) throws Exception {
		HistoryHelper.dumpHistory("Behaviour visitor", myHistory);
	}

	public void visitInternalAction(InternalAction action) throws Exception {
		myHistory.add(new HistoryElement(SimTime.NOW,
				"Executing internal action " + action.getEntityName()));
		SimuComModel myModel = (SimuComModel)myParentProcess.getModel();
		if (action.getResourceDemand_Action().size()>0)
		{
			ParametricResourceDemand paramResDemand = (ParametricResourceDemand) action.getResourceDemand_Action().get(0);
			SimulatedActiveResource activeResource = myModel.getSimulatedResources().getResourceContainer("Application Server").getActiveResource(paramResDemand.getRequiredResource_ParametricResourceDemand());
			double demand = RandomVariableHelper.getDoubleSample(paramResDemand.getDemand(),myStackFrame);
			activeResource.consumeResource(myParentProcess, demand);
		}
		visit(action.getSuccessor_AbstractAction());
	}

	public void visitLoop(Loop loop) throws Exception {
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
	
	public void visitExternalCall(ExternalCall call) throws Exception {
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
			Behaviour b = getTargetBehaviourFromAssemblyConnector(foundAssemblyConnector, serviceToBeCalled);
			SimulatedStackFrame newStackFrame = new SimulatedStackFrame();
			newStackFrame.buildParametricParameterContext(call.getParametricParameterUsage_ParametricParameterUsage(),myStackFrame);
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess,
					initializeCallContext(foundAssemblyConnector),
					newStackFrame);
			visitor.visitBehaviour(b);
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
		while (timeConsumptions.hasNext()) {
			SpecifiedTimeConsumption consumption = (SpecifiedTimeConsumption) timeConsumptions
					.next();
			if (consumption.getSignature_SpecifiedTimeConsumption()
					.getServiceName()
					.equals(calledService.getServiceName())) {
				waitForSpecifiedTimeSpan(consumption);
				return;
			}
		}
		throw new Exception("No timing information found on system required role!");
	}

	private Behaviour getTargetBehaviourFromAssemblyConnector(SystemAssemblyConnector connector, Signature targetMethod) {
		BasicComponent targetBasicComponent = (BasicComponent) connector
				.getProvidedRole_SystemAssemblyConnector()
				.getProvidingComponent__ProvidedRole();

		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						targetBasicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ targetMethod.getServiceName()
								+ "')->first()");

		return (Behaviour) seff;
	}

	/**
	 * @param connector
	 */
	private Context initializeCallContext(SystemAssemblyConnector connector) {
		Context callContext = DerivedContextFactory.eINSTANCE.createContext();
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
