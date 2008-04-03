/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.AbstractResourceUsage;
import de.uka.ipd.sdq.capra.core.Action;
import de.uka.ipd.sdq.capra.core.BoundedLoop;
import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.Choice;
import de.uka.ipd.sdq.capra.core.CommunicationEventAction;
import de.uka.ipd.sdq.capra.core.CommunicationIdentifier;
import de.uka.ipd.sdq.capra.core.CoreFactory;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.DemandAction;
import de.uka.ipd.sdq.capra.core.DemandIdentifier;
import de.uka.ipd.sdq.capra.core.EventAction;
import de.uka.ipd.sdq.capra.core.ExternalSelector;
import de.uka.ipd.sdq.capra.core.Identifier;
import de.uka.ipd.sdq.capra.core.InputEventAction;
import de.uka.ipd.sdq.capra.core.InstantaneousAction;
import de.uka.ipd.sdq.capra.core.InternalSelector;
import de.uka.ipd.sdq.capra.core.Mapping;
import de.uka.ipd.sdq.capra.core.Operator;
import de.uka.ipd.sdq.capra.core.OutputEventAction;
import de.uka.ipd.sdq.capra.core.ParallelComposition;
import de.uka.ipd.sdq.capra.core.ProbabilisticPrefix;
import de.uka.ipd.sdq.capra.core.ProcessVariable;
import de.uka.ipd.sdq.capra.core.ProcessVariableUsage;
import de.uka.ipd.sdq.capra.core.Renaming;
import de.uka.ipd.sdq.capra.core.ReplicatedProcess;
import de.uka.ipd.sdq.capra.core.ResourceUsage;
import de.uka.ipd.sdq.capra.core.Restriction;
import de.uka.ipd.sdq.capra.core.SilentIdentifier;
import de.uka.ipd.sdq.capra.core.SuccessfulTermination;
import de.uka.ipd.sdq.capra.core.Terminal;
import de.uka.ipd.sdq.capra.core.VariableResourceUsage;

import de.uka.ipd.sdq.capra.experiment.ExperimentPackage;

import de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl;

import de.uka.ipd.sdq.capra.extension.ExtensionPackage;

import de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl;

import de.uka.ipd.sdq.capra.impl.CapraPackageImpl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

import de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl;

import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replicatedProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capraExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantaneousActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demandActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demandIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractResourceUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass successfulTerminationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probabilisticPrefixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEventActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEventActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationEventActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundedLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelCompositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renamingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass silentIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processVariableUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableResourceUsageEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		SchedulerPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CapraPackageImpl theCapraPackage = (CapraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) instanceof CapraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) : CapraPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		ResourcesPackageImpl theResourcesPackage = (ResourcesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) instanceof ResourcesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) : ResourcesPackage.eINSTANCE);
		SchedulersPackageImpl theSchedulersPackage = (SchedulersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) instanceof SchedulersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) : SchedulersPackage.eINSTANCE);
		MeasurementPackageImpl theMeasurementPackage = (MeasurementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) instanceof MeasurementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) : MeasurementPackage.eINSTANCE);
		ExtensionPackageImpl theExtensionPackage = (ExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) instanceof ExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) : ExtensionPackage.eINSTANCE);

		// Create package meta-data objects
		theCorePackage.createPackageContents();
		theCapraPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theResourcesPackage.createPackageContents();
		theSchedulersPackage.createPackageContents();
		theMeasurementPackage.createPackageContents();
		theExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();
		theCapraPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theResourcesPackage.initializePackageContents();
		theSchedulersPackage.initializePackageContents();
		theMeasurementPackage.initializePackageContents();
		theExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

		return theCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplicatedProcess() {
		return replicatedProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplicatedProcess_NumReplicas() {
		return (EAttribute)replicatedProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplicatedProcess_Processvariable() {
		return (EReference)replicatedProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessVariable() {
		return processVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessVariable_Process() {
		return (EReference)processVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessVariable_Name() {
		return (EAttribute)processVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapraExpression() {
		return capraExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantaneousAction() {
		return instantaneousActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminal() {
		return terminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventAction() {
		return eventActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventAction_Identifier() {
		return (EReference)eventActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationIdentifier() {
		return communicationIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifier_Name() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemandAction() {
		return demandActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandAction_Identifier() {
		return (EReference)demandActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandAction_ResourceUsage() {
		return (EReference)demandActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemandIdentifier() {
		return demandIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractResourceUsage() {
		return abstractResourceUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuccessfulTermination() {
		return successfulTerminationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbabilisticPrefix() {
		return probabilisticPrefixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbabilisticPrefix_Action() {
		return (EReference)probabilisticPrefixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbabilisticPrefix_TargetOptions() {
		return (EReference)probabilisticPrefixEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalSelector() {
		return internalSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalSelector_Probability() {
		return (EAttribute)internalSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalSelector_Process() {
		return (EReference)internalSelectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_Options() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalSelector() {
		return externalSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalSelector_Input() {
		return (EReference)externalSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalSelector_TargetProcess() {
		return (EReference)externalSelectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputEventAction() {
		return inputEventActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputEventAction() {
		return outputEventActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationEventAction() {
		return communicationEventActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundedLoop() {
		return boundedLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundedLoop_RepeatedProcess() {
		return (EReference)boundedLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundedLoop_TargetProcess() {
		return (EReference)boundedLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundedLoop_NumberOfIterations() {
		return (EReference)boundedLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelComposition() {
		return parallelCompositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParallelComposition_ParallelProcesses() {
		return (EReference)parallelCompositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParallelComposition_TargetProcess() {
		return (EReference)parallelCompositionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelComposition_IsSynchronised() {
		return (EAttribute)parallelCompositionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestriction() {
		return restrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestriction_RestrictedProcess() {
		return (EReference)restrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestriction_RestrictedIdentifiers() {
		return (EReference)restrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceUsage() {
		return resourceUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsage_Resource() {
		return (EReference)resourceUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsage_UsageTime() {
		return (EReference)resourceUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceUsage_UsageTimeSpecification() {
		return (EAttribute)resourceUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenaming() {
		return renamingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenaming_RenamedProcess() {
		return (EReference)renamingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenaming_Mapping() {
		return (EReference)renamingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Source() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Target() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSilentIdentifier() {
		return silentIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessVariableUsage() {
		return processVariableUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessVariableUsage_ProcessVariable() {
		return (EReference)processVariableUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableResourceUsage() {
		return variableResourceUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableResourceUsage_Name() {
		return (EAttribute)variableResourceUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		replicatedProcessEClass = createEClass(REPLICATED_PROCESS);
		createEAttribute(replicatedProcessEClass, REPLICATED_PROCESS__NUM_REPLICAS);
		createEReference(replicatedProcessEClass, REPLICATED_PROCESS__PROCESSVARIABLE);

		processVariableEClass = createEClass(PROCESS_VARIABLE);
		createEReference(processVariableEClass, PROCESS_VARIABLE__PROCESS);
		createEAttribute(processVariableEClass, PROCESS_VARIABLE__NAME);

		capraExpressionEClass = createEClass(CAPRA_EXPRESSION);

		instantaneousActionEClass = createEClass(INSTANTANEOUS_ACTION);

		actionEClass = createEClass(ACTION);

		terminalEClass = createEClass(TERMINAL);

		operatorEClass = createEClass(OPERATOR);

		eventActionEClass = createEClass(EVENT_ACTION);
		createEReference(eventActionEClass, EVENT_ACTION__IDENTIFIER);

		communicationIdentifierEClass = createEClass(COMMUNICATION_IDENTIFIER);

		identifierEClass = createEClass(IDENTIFIER);
		createEAttribute(identifierEClass, IDENTIFIER__NAME);

		demandActionEClass = createEClass(DEMAND_ACTION);
		createEReference(demandActionEClass, DEMAND_ACTION__IDENTIFIER);
		createEReference(demandActionEClass, DEMAND_ACTION__RESOURCE_USAGE);

		demandIdentifierEClass = createEClass(DEMAND_IDENTIFIER);

		abstractResourceUsageEClass = createEClass(ABSTRACT_RESOURCE_USAGE);

		successfulTerminationEClass = createEClass(SUCCESSFUL_TERMINATION);

		probabilisticPrefixEClass = createEClass(PROBABILISTIC_PREFIX);
		createEReference(probabilisticPrefixEClass, PROBABILISTIC_PREFIX__ACTION);
		createEReference(probabilisticPrefixEClass, PROBABILISTIC_PREFIX__TARGET_OPTIONS);

		internalSelectorEClass = createEClass(INTERNAL_SELECTOR);
		createEAttribute(internalSelectorEClass, INTERNAL_SELECTOR__PROBABILITY);
		createEReference(internalSelectorEClass, INTERNAL_SELECTOR__PROCESS);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__OPTIONS);

		externalSelectorEClass = createEClass(EXTERNAL_SELECTOR);
		createEReference(externalSelectorEClass, EXTERNAL_SELECTOR__INPUT);
		createEReference(externalSelectorEClass, EXTERNAL_SELECTOR__TARGET_PROCESS);

		inputEventActionEClass = createEClass(INPUT_EVENT_ACTION);

		outputEventActionEClass = createEClass(OUTPUT_EVENT_ACTION);

		communicationEventActionEClass = createEClass(COMMUNICATION_EVENT_ACTION);

		boundedLoopEClass = createEClass(BOUNDED_LOOP);
		createEReference(boundedLoopEClass, BOUNDED_LOOP__REPEATED_PROCESS);
		createEReference(boundedLoopEClass, BOUNDED_LOOP__TARGET_PROCESS);
		createEReference(boundedLoopEClass, BOUNDED_LOOP__NUMBER_OF_ITERATIONS);

		parallelCompositionEClass = createEClass(PARALLEL_COMPOSITION);
		createEReference(parallelCompositionEClass, PARALLEL_COMPOSITION__PARALLEL_PROCESSES);
		createEReference(parallelCompositionEClass, PARALLEL_COMPOSITION__TARGET_PROCESS);
		createEAttribute(parallelCompositionEClass, PARALLEL_COMPOSITION__IS_SYNCHRONISED);

		restrictionEClass = createEClass(RESTRICTION);
		createEReference(restrictionEClass, RESTRICTION__RESTRICTED_PROCESS);
		createEReference(restrictionEClass, RESTRICTION__RESTRICTED_IDENTIFIERS);

		resourceUsageEClass = createEClass(RESOURCE_USAGE);
		createEReference(resourceUsageEClass, RESOURCE_USAGE__RESOURCE);
		createEReference(resourceUsageEClass, RESOURCE_USAGE__USAGE_TIME);
		createEAttribute(resourceUsageEClass, RESOURCE_USAGE__USAGE_TIME_SPECIFICATION);

		renamingEClass = createEClass(RENAMING);
		createEReference(renamingEClass, RENAMING__RENAMED_PROCESS);
		createEReference(renamingEClass, RENAMING__MAPPING);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__SOURCE);
		createEReference(mappingEClass, MAPPING__TARGET);

		silentIdentifierEClass = createEClass(SILENT_IDENTIFIER);

		processVariableUsageEClass = createEClass(PROCESS_VARIABLE_USAGE);
		createEReference(processVariableUsageEClass, PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE);

		variableResourceUsageEClass = createEClass(VARIABLE_RESOURCE_USAGE);
		createEAttribute(variableResourceUsageEClass, VARIABLE_RESOURCE_USAGE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ProbfunctionPackage theProbfunctionPackage = (ProbfunctionPackage)EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI);
		ResourcesPackage theResourcesPackage = (ResourcesPackage)EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		instantaneousActionEClass.getESuperTypes().add(this.getAction());
		terminalEClass.getESuperTypes().add(this.getCapraExpression());
		operatorEClass.getESuperTypes().add(this.getCapraExpression());
		eventActionEClass.getESuperTypes().add(this.getInstantaneousAction());
		communicationIdentifierEClass.getESuperTypes().add(this.getIdentifier());
		demandActionEClass.getESuperTypes().add(this.getAction());
		demandIdentifierEClass.getESuperTypes().add(this.getIdentifier());
		successfulTerminationEClass.getESuperTypes().add(this.getTerminal());
		probabilisticPrefixEClass.getESuperTypes().add(this.getOperator());
		choiceEClass.getESuperTypes().add(this.getOperator());
		inputEventActionEClass.getESuperTypes().add(this.getEventAction());
		outputEventActionEClass.getESuperTypes().add(this.getEventAction());
		communicationEventActionEClass.getESuperTypes().add(this.getEventAction());
		boundedLoopEClass.getESuperTypes().add(this.getOperator());
		parallelCompositionEClass.getESuperTypes().add(this.getOperator());
		restrictionEClass.getESuperTypes().add(this.getOperator());
		resourceUsageEClass.getESuperTypes().add(this.getAbstractResourceUsage());
		renamingEClass.getESuperTypes().add(this.getOperator());
		silentIdentifierEClass.getESuperTypes().add(this.getCommunicationIdentifier());
		silentIdentifierEClass.getESuperTypes().add(this.getDemandIdentifier());
		processVariableUsageEClass.getESuperTypes().add(this.getCapraExpression());
		variableResourceUsageEClass.getESuperTypes().add(this.getAbstractResourceUsage());

		// Initialize classes and features; add operations and parameters
		initEClass(replicatedProcessEClass, ReplicatedProcess.class, "ReplicatedProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplicatedProcess_NumReplicas(), ecorePackage.getEInt(), "numReplicas", null, 0, 1, ReplicatedProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReplicatedProcess_Processvariable(), this.getProcessVariable(), null, "processvariable", null, 1, 1, ReplicatedProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processVariableEClass, ProcessVariable.class, "ProcessVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessVariable_Process(), this.getCapraExpression(), null, "process", null, 1, 1, ProcessVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcessVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, ProcessVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(capraExpressionEClass, CapraExpression.class, "CapraExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instantaneousActionEClass, InstantaneousAction.class, "InstantaneousAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(terminalEClass, Terminal.class, "Terminal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operatorEClass, Operator.class, "Operator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventActionEClass, EventAction.class, "EventAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventAction_Identifier(), this.getCommunicationIdentifier(), null, "identifier", null, 1, 1, EventAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(communicationIdentifierEClass, CommunicationIdentifier.class, "CommunicationIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifierEClass, Identifier.class, "Identifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifier_Name(), ecorePackage.getEString(), "name", null, 1, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(demandActionEClass, DemandAction.class, "DemandAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDemandAction_Identifier(), this.getDemandIdentifier(), null, "identifier", null, 1, 1, DemandAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDemandAction_ResourceUsage(), this.getAbstractResourceUsage(), null, "resourceUsage", null, 1, 1, DemandAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(demandIdentifierEClass, DemandIdentifier.class, "DemandIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractResourceUsageEClass, AbstractResourceUsage.class, "AbstractResourceUsage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(successfulTerminationEClass, SuccessfulTermination.class, "SuccessfulTermination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(probabilisticPrefixEClass, ProbabilisticPrefix.class, "ProbabilisticPrefix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProbabilisticPrefix_Action(), this.getAction(), null, "action", null, 1, 1, ProbabilisticPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProbabilisticPrefix_TargetOptions(), this.getInternalSelector(), null, "targetOptions", null, 0, -1, ProbabilisticPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalSelectorEClass, InternalSelector.class, "InternalSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalSelector_Probability(), ecorePackage.getEDouble(), "probability", "1", 1, 1, InternalSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInternalSelector_Process(), this.getCapraExpression(), null, "process", null, 1, 1, InternalSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_Options(), this.getExternalSelector(), null, "options", null, 0, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalSelectorEClass, ExternalSelector.class, "ExternalSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalSelector_Input(), this.getInputEventAction(), null, "input", null, 1, 1, ExternalSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExternalSelector_TargetProcess(), this.getCapraExpression(), null, "targetProcess", null, 1, 1, ExternalSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputEventActionEClass, InputEventAction.class, "InputEventAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputEventActionEClass, OutputEventAction.class, "OutputEventAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(communicationEventActionEClass, CommunicationEventAction.class, "CommunicationEventAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundedLoopEClass, BoundedLoop.class, "BoundedLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundedLoop_RepeatedProcess(), this.getCapraExpression(), null, "repeatedProcess", null, 1, 1, BoundedLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBoundedLoop_TargetProcess(), this.getCapraExpression(), null, "targetProcess", null, 1, 1, BoundedLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBoundedLoop_NumberOfIterations(), theProbfunctionPackage.getProbabilityMassFunction(), null, "numberOfIterations", null, 1, 1, BoundedLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parallelCompositionEClass, ParallelComposition.class, "ParallelComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParallelComposition_ParallelProcesses(), this.getCapraExpression(), null, "parallelProcesses", null, 0, -1, ParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParallelComposition_TargetProcess(), this.getCapraExpression(), null, "targetProcess", null, 1, 1, ParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParallelComposition_IsSynchronised(), ecorePackage.getEBoolean(), "isSynchronised", null, 1, 1, ParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(restrictionEClass, Restriction.class, "Restriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestriction_RestrictedProcess(), this.getCapraExpression(), null, "restrictedProcess", null, 1, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRestriction_RestrictedIdentifiers(), this.getCommunicationIdentifier(), null, "restrictedIdentifiers", null, 0, -1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceUsageEClass, ResourceUsage.class, "ResourceUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceUsage_Resource(), theResourcesPackage.getProcessingResource(), null, "resource", null, 1, 1, ResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceUsage_UsageTime(), theProbfunctionPackage.getProbabilityDensityFunction(), null, "usageTime", null, 1, 1, ResourceUsage.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getResourceUsage_UsageTimeSpecification(), ecorePackage.getEString(), "usageTimeSpecification", null, 1, 1, ResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(renamingEClass, Renaming.class, "Renaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenaming_RenamedProcess(), this.getCapraExpression(), null, "renamedProcess", null, 1, 1, Renaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRenaming_Mapping(), this.getMapping(), null, "mapping", null, 0, -1, Renaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Source(), this.getIdentifier(), null, "source", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_Target(), this.getIdentifier(), null, "target", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(silentIdentifierEClass, SilentIdentifier.class, "SilentIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processVariableUsageEClass, ProcessVariableUsage.class, "ProcessVariableUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessVariableUsage_ProcessVariable(), this.getProcessVariable(), null, "processVariable", null, 1, 1, ProcessVariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableResourceUsageEClass, VariableResourceUsage.class, "VariableResourceUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableResourceUsage_Name(), ecorePackage.getEString(), "name", null, 1, 1, VariableResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //CorePackageImpl
