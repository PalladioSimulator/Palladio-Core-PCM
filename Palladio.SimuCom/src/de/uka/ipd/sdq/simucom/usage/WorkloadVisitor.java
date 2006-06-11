package de.uka.ipd.sdq.simucom.usage;

import java.io.DataInputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;

import stoex.parser.ExpressionLexer;
import stoex.parser.ExpressionParser;
import stoex.stochastics.RandomVariable;
import stoex.visitors.DefinitionTreeParser;

import DerivedContext.Context;
import DerivedContext.DerivedContextFactory;
import PalladioCM.RepositoryPackage.BasicComponent;
import PalladioCM.RepositoryPackage.ProvidesComponentType;
import PalladioCM.RepositoryPackage.RepositoryPackagePackage;
import PalladioCM.RepositoryPackage.Signature;
import PalladioCM.SEFFPackage.Behaviour;
import PalladioCM.SEFFPackage.ServiceEffectSpecification;
import ParameterPackage.CollectionParameterCharacterisation;
import ParameterPackage.CollectionParameterUsage;
import ParameterPackage.ParameterPackageFactory;
import ParameterPackage.ParameterUsage;
import ParameterPackage.PrimitiveParameterCharacterisation;
import SystemPackage.SystemProvidedDelegationConnector;
import SystemPackage.SystemProvidedRole;
import UsageModelPackage.AbstractUserAction;
import UsageModelPackage.EntryLevelSystemCall;
import UsageModelPackage.ScenarioBehaviour;
import UsageModelPackage.Start;
import UsageModelPackage.Stop;
import de.uka.ipd.sdq.simucom.DistributionObjectsStorage;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.behaviour.BehaviourVisitor;
import de.uka.ipd.sdq.simucom.behaviour.SimulatedStackFrame;
import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;
import de.uka.ipd.sdq.simucom.history.HistoryElement;
import de.uka.ipd.sdq.simucom.history.HistoryHelper;
import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.stochastics.RandomVariableHelper;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class WorkloadVisitor 
extends ReflectiveVisitor {
	protected ArrayList<HistoryElement> myHistory = new ArrayList<HistoryElement>();
	protected SimProcess myParentProcess = null;
	protected SystemPackage.System mySystem;
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
		if (offeringComponent.eClass() == RepositoryPackagePackage.eINSTANCE.getBasicComponent())
		{
			BasicComponent basicComponent = (BasicComponent)offeringComponent;
			//TODO: Über Interfaces suchen...
			ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper.executeOCLQuery(
					basicComponent,
					"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"+method.getServiceName()+"')->first()");

			Context callContext = DerivedContextFactory.eINSTANCE.createContext();
			SimulatedStackFrame stackFrame = new SimulatedStackFrame();
			callContext.setSystem(myContext.getSystem());
			callContext.setDerivedAssemblyContext(delegationConnector.getAssemblyContext_SystemProvidedDelegationConnector());
			callContext.setDerivedUsageContext(DerivedContextFactory.eINSTANCE.createUsageContext());
			
			stackFrame.buildParameterContext(call.getActualParamterUsage_EntryLevelSystemCall());
			
			Behaviour b = (Behaviour)seff;
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess, callContext, stackFrame);
			visitor.visitBehaviour(b);
		}
		else
			throw new Exception("Component type not supported by visitor yet!");
		
		visit(call.getSuccessor());
	}
}

