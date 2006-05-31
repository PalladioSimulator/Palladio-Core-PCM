package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

import PalladioCM.RepositoryPackage.BasicComponent;
import PalladioCM.RepositoryPackage.ProvidesComponentType;
import PalladioCM.RepositoryPackage.RepositoryPackagePackage;
import PalladioCM.RepositoryPackage.Signature;
import PalladioCM.SEFFPackage.Behaviour;
import PalladioCM.SEFFPackage.ServiceEffectSpecification;
import SystemPackage.SystemProvidedDelegationConnector;
import SystemPackage.SystemProvidedRole;
import UsageModelPackage.AbstractUserAction;
import UsageModelPackage.EntryLevelComponentCall;
import UsageModelPackage.ScenarioBehaviour;
import UsageModelPackage.Start;
import UsageModelPackage.Stop;
import de.uka.ipd.sdq.simucom.ModelLoader;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.behaviour.BehaviourVisitor;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import de.uka.ipd.sdq.simucom.threads.history.HistoryHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class WorkloadVisitor 
extends ReflectiveVisitor {
	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();
	protected SimProcess myParentProcess = null;
	protected SystemPackage.System mySystem;

	
	public WorkloadVisitor(SimProcess parent) {
		super();
		this.myParentProcess = parent;
		mySystem = ((SimuComModel)myParentProcess.getModel()).getSystem();
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
	
	public void visitEntryLevelComponentCall(EntryLevelComponentCall call) throws Exception
	{
		Signature method = call.getSignature_EntryLevelComponentCall();
		SystemProvidedRole role = call.getSystemProvidedRole_EntryLevelComponentCall();
		myHistory.add(new HistoryElement(SimTime.NOW,"Called System method <"+role.getInterface_SystemProvidedRole().getEntityName()+"/"+method.getServiceName()+">"));
		SystemProvidedDelegationConnector delegationConnector = 
			(SystemProvidedDelegationConnector) EMFHelper.executeOCLQuery(ModelLoader.getSystemResourceSet(),
				mySystem,
				"self.providedDelegationConnector_System->select(dc|dc.systemProvidedRole_SystemProvidedDelegationConnector.interface_SystemProvidedRole.id = '"+role.getInterface_SystemProvidedRole().getId()+"')->first()");
		ProvidesComponentType offeringComponent = delegationConnector.getAssemblyContext_SystemProvidedDelegationConnector().getEncapsulatedComponent__AssemblyContext();
		if (offeringComponent.eClass() == RepositoryPackagePackage.eINSTANCE.getBasicComponent())
		{
			BasicComponent basicComponent = (BasicComponent)offeringComponent;
			//TODO: Über Interfaces suchen...
			ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper.executeOCLQuery(ModelLoader.getSystemResourceSet(),
					basicComponent,
					"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"+method.getServiceName()+"')->first()");
			Behaviour b = (Behaviour)seff;
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess);
			visitor.visitBehaviour(b);
			
		}
		else
			throw new Exception("Component type not supported by visitor yet!");
		
		myParentProcess.hold(new SimTime(1));
		visit(call.getSuccessor());
	}
}

