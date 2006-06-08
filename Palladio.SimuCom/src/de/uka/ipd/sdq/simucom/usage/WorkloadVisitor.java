package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;
import java.util.Iterator;

import DerivedContext.Context;
import DerivedContext.DerivedContextFactory;
import DerivedContext.IntegerCharacterisationValue;
import PalladioCM.RepositoryPackage.BasicComponent;
import PalladioCM.RepositoryPackage.ProvidesComponentType;
import PalladioCM.RepositoryPackage.RepositoryPackagePackage;
import PalladioCM.RepositoryPackage.Signature;
import PalladioCM.SEFFPackage.Behaviour;
import PalladioCM.SEFFPackage.ServiceEffectSpecification;
import ParameterPackage.CharacterisationKind;
import ParameterPackage.CollectionParameterCharacterisation;
import ParameterPackage.CollectionParameterUsage;
import ParameterPackage.NumericProbabilityMassFunctionCharacterisation;
import ParameterPackage.ParameterCharacterisationValue;
import ParameterPackage.ParameterPackageFactory;
import ParameterPackage.ParameterUsage;
import ParameterPackage.PrimitiveParameterCharacterisation;
import Statistics.NumericProbabilityMassFunction;
import Statistics.NumericSample;
import SystemPackage.SystemProvidedDelegationConnector;
import SystemPackage.SystemProvidedRole;
import UsageModelPackage.AbstractUserAction;
import UsageModelPackage.EntryLevelSystemCall;
import UsageModelPackage.ScenarioBehaviour;
import UsageModelPackage.Start;
import UsageModelPackage.Stop;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.behaviour.BehaviourVisitor;
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
			callContext.setSystem(myContext.getSystem());
			callContext.setDerivedAssemblyContext(delegationConnector.getAssemblyContext_SystemProvidedDelegationConnector());
			callContext.setDerivedUsageContext(DerivedContextFactory.eINSTANCE.createUsageContext());
			
			if (call.getActualParamterUsage_EntryLevelSystemCall().size()>0)
			{
				buildParameterContext(call, callContext);
			}
			
			Behaviour b = (Behaviour)seff;
			BehaviourVisitor visitor = new BehaviourVisitor(myParentProcess, callContext);
			visitor.visitBehaviour(b);
		}
		else
			throw new Exception("Component type not supported by visitor yet!");
		
		visit(call.getSuccessor());
	}

	/**
	 * @param call 
	 * @param callContext
	 * @throws Exception 
	 */
	private void buildParameterContext(EntryLevelSystemCall call, Context callContext) throws Exception {
		Iterator parameterUsages = call.getActualParamterUsage_EntryLevelSystemCall().iterator();
		while(parameterUsages.hasNext())
		{
			ParameterUsage specifiedParameter = (ParameterUsage) parameterUsages.next();
			ParameterUsage derivedParameter = createDerivedParameterUsage(specifiedParameter);
			derivedParameter.setParameter_ParameterUsage(specifiedParameter.getParameter_ParameterUsage());
			callContext.getDerivedUsageContext().getParameter().add(derivedParameter);
		}
	}

	/**
	 * @param specifiedParameter
	 * @return
	 * @throws Exception
	 */
	private ParameterUsage createDerivedParameterUsage(ParameterUsage specifiedParameter) throws Exception {
		ParameterUsage derivedParameter = null;
		if (specifiedParameter instanceof CollectionParameterUsage)
		{
			CollectionParameterUsage derivedUsage = ParameterPackageFactory.eINSTANCE.createCollectionParameterUsage();
			deriveCollectionCharacteristics((CollectionParameterUsage)specifiedParameter, derivedUsage);
			derivedUsage.setInnerElement_ParameterUsage(createDerivedParameterUsage(((CollectionParameterUsage)specifiedParameter).getInnerElement_ParameterUsage()));
			derivedParameter = derivedUsage;
		} else if (specifiedParameter instanceof ParameterUsage) {
			ParameterUsage derivedUsage = ParameterPackageFactory.eINSTANCE.createParameterUsage();
			deriveCharacteristics(specifiedParameter,derivedUsage);
			derivedParameter = derivedUsage;
		}
		else
			throw new Exception ("unknown parameter usage");
		return derivedParameter;
	}

	private void deriveCharacteristics(ParameterUsage specifiedParameter, ParameterUsage derivedParameter) throws Exception {
		Iterator specifiedCharacterisations = specifiedParameter.getParameterCharacterisation_ParameterUsage().iterator();
		while (specifiedCharacterisations.hasNext())
		{
			PrimitiveParameterCharacterisation specifiedCharacterisation = (PrimitiveParameterCharacterisation)specifiedCharacterisations.next();
			PrimitiveParameterCharacterisation derivedCharacterisation = ParameterPackageFactory.eINSTANCE.createPrimitiveParameterCharacterisation();
			derivedCharacterisation.setKind(CharacterisationKind.CONSTANT_LITERAL);
			derivedCharacterisation.setType(specifiedCharacterisation.getType());
			derivedCharacterisation.setValue_PrimitiveParameterCharacterisation(getValue(specifiedCharacterisation.getValue_PrimitiveParameterCharacterisation()));
			derivedParameter.getParameterCharacterisation_ParameterUsage().add(derivedCharacterisation);
		}
	}

	private void deriveCollectionCharacteristics(CollectionParameterUsage usage, CollectionParameterUsage derivedUsage) {
		Iterator specifiedCharacterisations = usage.getCharacterisation_CollectionParameterUsage().iterator();
		while (specifiedCharacterisations.hasNext())
		{
			CollectionParameterCharacterisation specifiedCharacterisation = (CollectionParameterCharacterisation)specifiedCharacterisations.next();
			CollectionParameterCharacterisation derivedCharacterisation = ParameterPackageFactory.eINSTANCE.createCollectionParameterCharacterisation();
			derivedCharacterisation.setKind(CharacterisationKind.CONSTANT_LITERAL);
			derivedCharacterisation.setType(specifiedCharacterisation.getType());
			derivedCharacterisation.setValue_CollectionParameterCharacterisation(getValue(specifiedCharacterisation.getValue_CollectionParameterCharacterisation()));
			derivedUsage.getCharacterisation_CollectionParameterUsage().add(derivedCharacterisation);
		}
	}

	private ParameterCharacterisationValue getValue(ParameterCharacterisationValue value) {
		ParameterCharacterisationValue result = null;
		
		// TODO: Gescheite Pattern verwenden!	
		if (value instanceof NumericProbabilityMassFunctionCharacterisation)
		{
			NumericProbabilityMassFunction distribution = (NumericProbabilityMassFunction) value;
			SimuComModel model = (SimuComModel) myParentProcess.getModel();
			int index = (int)model.getDistributionObjectsStorage().getIntDistribution(distribution).sample();
			IntegerCharacterisationValue resultValue = DerivedContextFactory.eINSTANCE.createIntegerCharacterisationValue();
			NumericSample sample = (NumericSample) distribution.getSamples_DistributionFunction().get(index);
			resultValue.setIntValue((int)sample.getValue());
			result = resultValue;
		}
		return result;
	}
}

