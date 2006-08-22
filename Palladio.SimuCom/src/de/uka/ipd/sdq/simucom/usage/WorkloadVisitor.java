package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

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
import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.behaviour.BehaviourVisitor;
import de.uka.ipd.sdq.simucom.behaviour.SimulatedStackFrame;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.history.HistoryElement;
import de.uka.ipd.sdq.simucom.history.HistoryHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class WorkloadVisitor 
extends ReflectiveVisitor {
	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();
	protected SimProcess myParentProcess = null;
	protected de.uka.ipd.sdq.pcm.system.System mySystem;
	protected Context myContext = null;

	
	public WorkloadVisitor(SimProcess parent, Context workloadContext) {
		super();
		this.myParentProcess = parent;
		mySystem = ((SimuComModel)myParentProcess.getModel()).getSystem();
		myContext = workloadContext;
	}

	public void visitScenarioBehaviour(ScenarioBehaviour behaviour) throws Exception {
		Start startAction = (Start)EMFHelper.getObjectByType(behaviour.getActions_ScenarioBehaviour(), Start.class);
		visit(startAction);
	}

	public void visitStart(Start s) throws Exception
	{
		AbstractUserAction next = s.getSuccessor();
		visit(next);
	}

	public void visitStop(Stop s) throws Exception
	{
		HistoryHelper.dumpHistory("WorkloadVisitor",myHistory);
	}
	
	public void visitEntryLevelSystemCall(EntryLevelSystemCall call) throws Exception
	{
		Signature method = call.getSignature_EntryLevelSystemCall();
		SystemProvidedRole role = call.getSystemProvidedRole_EntryLevelSystemCall();
		myHistory.add(new HistoryElement(SimTime.NOW,"Called System method <"+role.getInterface_SystemProvidedRole().getEntityName()+"/"+method.getServiceName()+">"));
		SystemProvidedDelegationConnector delegationConnector = 
			(SystemProvidedDelegationConnector) EMFHelper.executeOCLQuery(
				mySystem,
				"self.providedDelegationConnector_System->select(dc|dc.systemProvidedRole_SystemProvidedDelegationConnector.interface_SystemProvidedRole.id = '"+role.getInterface_SystemProvidedRole().getId()+"')->first()");
		ProvidesComponentType offeringComponent = delegationConnector.getAssemblyContext_SystemProvidedDelegationConnector().getEncapsulatedComponent__AssemblyContext();
		if (offeringComponent.eClass() == RepositoryPackage.eINSTANCE.getBasicComponent())
		{
			BasicComponent basicComponent = (BasicComponent)offeringComponent;
			//TODO: Über Interfaces suchen...
			ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper.executeOCLQuery(
					basicComponent,
					"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"+method.getServiceName()+"')->first()");

			Context callContext = new Context();
			SimulatedStackFrame stackFrame = new SimulatedStackFrame();
			callContext.setSystem(myContext.getSystem());
			callContext.setDerivedAssemblyContext(delegationConnector.getAssemblyContext_SystemProvidedDelegationConnector());
			// callContext.setDerivedUsageContext(DerivedContextFactory.eINSTANCE.createUsageContext());
			
			stackFrame.buildParameterContext(call.getActualParamterUsage_EntryLevelSystemCall());
			
			ResourceDemandingBehaviour b = (ResourceDemandingBehaviour)seff;
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess, callContext, stackFrame);
			visitor.visitResourceDemandingSEFF((ResourceDemandingSEFF)b);
		}
		else
			throw new Exception("Component type not supported by visitor yet!");
		
		visit(call.getSuccessor());
	}
}

