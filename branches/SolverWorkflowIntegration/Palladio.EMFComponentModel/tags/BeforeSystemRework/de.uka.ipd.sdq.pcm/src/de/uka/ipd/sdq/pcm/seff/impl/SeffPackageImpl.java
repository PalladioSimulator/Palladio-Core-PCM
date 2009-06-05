/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl;
import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;
import de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.IterationCount;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SeffPackageImpl extends EPackageImpl implements SeffPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stopActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractResourceDemandingActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricResourceDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDemandingSEFFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDemandingBehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricParameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass releaseActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveParametricParameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationCountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forkActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalCallActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionParametricParameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aquireActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEffectSpecificationEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SeffPackageImpl() {
		super(eNS_URI, SeffFactory.eINSTANCE);
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
	public static SeffPackage init() {
		if (isInited) return (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Obtain or create and register package
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SeffPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AssemblyPackageImpl theAssemblyPackage = (AssemblyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) instanceof AssemblyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) : AssemblyPackage.eINSTANCE);
		StochasticsPackageImpl theStochasticsPackage = (StochasticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) instanceof StochasticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) : StochasticsPackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);

		// Create package meta-data objects
		theSeffPackage.createPackageContents();
		theAssemblyPackage.createPackageContents();
		theStochasticsPackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theSystemPackage.createPackageContents();

		// Initialize created meta-data
		theSeffPackage.initializePackageContents();
		theAssemblyPackage.initializePackageContents();
		theStochasticsPackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSeffPackage.freeze();

		return theSeffPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStopAction() {
		return stopActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractResourceDemandingAction() {
		return abstractResourceDemandingActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractResourceDemandingAction_ResourceDemand_Action() {
		return (EReference)abstractResourceDemandingActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAction() {
		return abstractActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Predecessor_AbstractAction() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Successor_AbstractAction() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricResourceDemand() {
		return parametricResourceDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametricResourceDemand_Demand() {
		return (EAttribute)parametricResourceDemandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametricResourceDemand_Unit() {
		return (EAttribute)parametricResourceDemandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricResourceDemand_RequiredResource_ParametricResourceDemand() {
		return (EReference)parametricResourceDemandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricResourceDemand_Action_ParametricResourceDemand() {
		return (EReference)parametricResourceDemandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartAction() {
		return startActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDemandingSEFF() {
		return resourceDemandingSEFFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDemandingBehaviour() {
		return resourceDemandingBehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDemandingBehaviour_Steps_Behaviour() {
		return (EReference)resourceDemandingBehaviourEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDemandingBehaviour_ParametricResourceDemands_Behaviour() {
		return (EReference)resourceDemandingBehaviourEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDemandingBehaviour_ParametricParameterUsage_Behaviour() {
		return (EReference)resourceDemandingBehaviourEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricParameterUsage() {
		return parametricParameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricParameterUsage_CharacterisedParameter_ParametricParameterUsage() {
		return (EReference)parametricParameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReleaseAction() {
		return releaseActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReleaseAction_ResourceType_Release() {
		return (EReference)releaseActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveParametricParameterUsage() {
		return primitiveParametricParameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveParametricParameterUsage_Type() {
		return (EAttribute)primitiveParametricParameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopAction() {
		return loopActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopAction_Iterations() {
		return (EAttribute)loopActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopAction_BodyBehaviour_Loop() {
		return (EReference)loopActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopAction_Iterations_LoopAction() {
		return (EReference)loopActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterationCount() {
		return iterationCountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalAction() {
		return internalActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalAction_FailureProbability() {
		return (EAttribute)internalActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForkAction() {
		return forkActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForkAction_ForkedBehaviours_Fork() {
		return (EReference)forkActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalCallAction() {
		return externalCallActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallAction_CalledService_ExternalService() {
		return (EReference)externalCallActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallAction_ParametricParameterUsage_ParametricParameterUsage() {
		return (EReference)externalCallActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionParametricParameterUsage() {
		return collectionParametricParameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionParametricParameterUsage_Type() {
		return (EAttribute)collectionParametricParameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchTransition() {
		return branchTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchTransition_BranchCondition() {
		return (EAttribute)branchTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchTransition_BranchBehaviour_BranchTransition() {
		return (EReference)branchTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchAction() {
		return branchActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchAction_Branches_Branch() {
		return (EReference)branchActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAquireAction() {
		return aquireActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAquireAction_ResourceType_Aquire() {
		return (EReference)aquireActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceEffectSpecification() {
		return serviceEffectSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceEffectSpecification_SeffTypeID() {
		return (EAttribute)serviceEffectSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceEffectSpecification_DescribedService__SEFF() {
		return (EReference)serviceEffectSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffFactory getSeffFactory() {
		return (SeffFactory)getEFactoryInstance();
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
		stopActionEClass = createEClass(STOP_ACTION);

		abstractResourceDemandingActionEClass = createEClass(ABSTRACT_RESOURCE_DEMANDING_ACTION);
		createEReference(abstractResourceDemandingActionEClass, ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION);

		abstractActionEClass = createEClass(ABSTRACT_ACTION);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION);

		parametricResourceDemandEClass = createEClass(PARAMETRIC_RESOURCE_DEMAND);
		createEAttribute(parametricResourceDemandEClass, PARAMETRIC_RESOURCE_DEMAND__DEMAND);
		createEAttribute(parametricResourceDemandEClass, PARAMETRIC_RESOURCE_DEMAND__UNIT);
		createEReference(parametricResourceDemandEClass, PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND);
		createEReference(parametricResourceDemandEClass, PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);

		startActionEClass = createEClass(START_ACTION);

		resourceDemandingSEFFEClass = createEClass(RESOURCE_DEMANDING_SEFF);

		resourceDemandingBehaviourEClass = createEClass(RESOURCE_DEMANDING_BEHAVIOUR);
		createEReference(resourceDemandingBehaviourEClass, RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR);
		createEReference(resourceDemandingBehaviourEClass, RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR);
		createEReference(resourceDemandingBehaviourEClass, RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR);

		parametricParameterUsageEClass = createEClass(PARAMETRIC_PARAMETER_USAGE);
		createEReference(parametricParameterUsageEClass, PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE);

		releaseActionEClass = createEClass(RELEASE_ACTION);
		createEReference(releaseActionEClass, RELEASE_ACTION__RESOURCE_TYPE_RELEASE);

		primitiveParametricParameterUsageEClass = createEClass(PRIMITIVE_PARAMETRIC_PARAMETER_USAGE);
		createEAttribute(primitiveParametricParameterUsageEClass, PRIMITIVE_PARAMETRIC_PARAMETER_USAGE__TYPE);

		loopActionEClass = createEClass(LOOP_ACTION);
		createEAttribute(loopActionEClass, LOOP_ACTION__ITERATIONS);
		createEReference(loopActionEClass, LOOP_ACTION__BODY_BEHAVIOUR_LOOP);
		createEReference(loopActionEClass, LOOP_ACTION__ITERATIONS_LOOP_ACTION);

		iterationCountEClass = createEClass(ITERATION_COUNT);

		internalActionEClass = createEClass(INTERNAL_ACTION);
		createEAttribute(internalActionEClass, INTERNAL_ACTION__FAILURE_PROBABILITY);

		forkActionEClass = createEClass(FORK_ACTION);
		createEReference(forkActionEClass, FORK_ACTION__FORKED_BEHAVIOURS_FORK);

		externalCallActionEClass = createEClass(EXTERNAL_CALL_ACTION);
		createEReference(externalCallActionEClass, EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE);
		createEReference(externalCallActionEClass, EXTERNAL_CALL_ACTION__PARAMETRIC_PARAMETER_USAGE_PARAMETRIC_PARAMETER_USAGE);

		collectionParametricParameterUsageEClass = createEClass(COLLECTION_PARAMETRIC_PARAMETER_USAGE);
		createEAttribute(collectionParametricParameterUsageEClass, COLLECTION_PARAMETRIC_PARAMETER_USAGE__TYPE);

		branchTransitionEClass = createEClass(BRANCH_TRANSITION);
		createEAttribute(branchTransitionEClass, BRANCH_TRANSITION__BRANCH_CONDITION);
		createEReference(branchTransitionEClass, BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION);

		branchActionEClass = createEClass(BRANCH_ACTION);
		createEReference(branchActionEClass, BRANCH_ACTION__BRANCHES_BRANCH);

		aquireActionEClass = createEClass(AQUIRE_ACTION);
		createEReference(aquireActionEClass, AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE);

		serviceEffectSpecificationEClass = createEClass(SERVICE_EFFECT_SPECIFICATION);
		createEAttribute(serviceEffectSpecificationEClass, SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID);
		createEReference(serviceEffectSpecificationEClass, SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		StochasticsPackage theStochasticsPackage = (StochasticsPackage)EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Add supertypes to classes
		stopActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		abstractResourceDemandingActionEClass.getESuperTypes().add(this.getAbstractAction());
		abstractActionEClass.getESuperTypes().add(theEntityPackage.getEntity());
		parametricResourceDemandEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());
		startActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		resourceDemandingSEFFEClass.getESuperTypes().add(this.getResourceDemandingBehaviour());
		resourceDemandingSEFFEClass.getESuperTypes().add(this.getServiceEffectSpecification());
		parametricParameterUsageEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());
		releaseActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		primitiveParametricParameterUsageEClass.getESuperTypes().add(this.getParametricParameterUsage());
		loopActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		iterationCountEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());
		internalActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		forkActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		externalCallActionEClass.getESuperTypes().add(this.getAbstractAction());
		collectionParametricParameterUsageEClass.getESuperTypes().add(this.getParametricParameterUsage());
		branchActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());
		aquireActionEClass.getESuperTypes().add(this.getAbstractResourceDemandingAction());

		// Initialize classes and features; add operations and parameters
		initEClass(stopActionEClass, StopAction.class, "StopAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractResourceDemandingActionEClass, AbstractResourceDemandingAction.class, "AbstractResourceDemandingAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractResourceDemandingAction_ResourceDemand_Action(), this.getParametricResourceDemand(), this.getParametricResourceDemand_Action_ParametricResourceDemand(), "resourceDemand_Action", null, 0, -1, AbstractResourceDemandingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractActionEClass, AbstractAction.class, "AbstractAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractAction_Predecessor_AbstractAction(), this.getAbstractAction(), this.getAbstractAction_Successor_AbstractAction(), "predecessor_AbstractAction", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractAction_Successor_AbstractAction(), this.getAbstractAction(), this.getAbstractAction_Predecessor_AbstractAction(), "successor_AbstractAction", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricResourceDemandEClass, ParametricResourceDemand.class, "ParametricResourceDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParametricResourceDemand_Demand(), ecorePackage.getEString(), "demand", null, 1, 1, ParametricResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParametricResourceDemand_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, ParametricResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParametricResourceDemand_RequiredResource_ParametricResourceDemand(), theResourcetypePackage.getProcessingResourceType(), null, "requiredResource_ParametricResourceDemand", null, 1, 1, ParametricResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParametricResourceDemand_Action_ParametricResourceDemand(), this.getAbstractResourceDemandingAction(), this.getAbstractResourceDemandingAction_ResourceDemand_Action(), "action_ParametricResourceDemand", null, 1, 1, ParametricResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(startActionEClass, StartAction.class, "StartAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceDemandingSEFFEClass, ResourceDemandingSEFF.class, "ResourceDemandingSEFF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceDemandingBehaviourEClass, ResourceDemandingBehaviour.class, "ResourceDemandingBehaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceDemandingBehaviour_Steps_Behaviour(), this.getAbstractAction(), null, "steps_Behaviour", null, 0, -1, ResourceDemandingBehaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceDemandingBehaviour_ParametricResourceDemands_Behaviour(), this.getParametricResourceDemand(), null, "parametricResourceDemands_Behaviour", null, 0, -1, ResourceDemandingBehaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceDemandingBehaviour_ParametricParameterUsage_Behaviour(), this.getParametricParameterUsage(), null, "parametricParameterUsage_Behaviour", null, 0, -1, ResourceDemandingBehaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricParameterUsageEClass, ParametricParameterUsage.class, "ParametricParameterUsage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParametricParameterUsage_CharacterisedParameter_ParametricParameterUsage(), theRepositoryPackage.getParameter(), null, "characterisedParameter_ParametricParameterUsage", null, 1, 1, ParametricParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(releaseActionEClass, ReleaseAction.class, "ReleaseAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReleaseAction_ResourceType_Release(), theResourcetypePackage.getPassiveResourceType(), null, "resourceType_Release", null, 1, 1, ReleaseAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveParametricParameterUsageEClass, PrimitiveParametricParameterUsage.class, "PrimitiveParametricParameterUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveParametricParameterUsage_Type(), theParameterPackage.getPrimitiveParameterCharacterisationType(), "type", null, 1, 1, PrimitiveParametricParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loopActionEClass, LoopAction.class, "LoopAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopAction_Iterations(), ecorePackage.getEString(), "iterations", null, 1, 1, LoopAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoopAction_BodyBehaviour_Loop(), this.getResourceDemandingBehaviour(), null, "bodyBehaviour_Loop", null, 1, 1, LoopAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoopAction_Iterations_LoopAction(), this.getIterationCount(), null, "iterations_LoopAction", null, 1, 1, LoopAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(iterationCountEClass, IterationCount.class, "IterationCount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalActionEClass, InternalAction.class, "InternalAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalAction_FailureProbability(), ecorePackage.getEString(), "failureProbability", null, 1, 1, InternalAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(forkActionEClass, ForkAction.class, "ForkAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForkAction_ForkedBehaviours_Fork(), this.getResourceDemandingBehaviour(), null, "forkedBehaviours_Fork", null, 0, -1, ForkAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalCallActionEClass, ExternalCallAction.class, "ExternalCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalCallAction_CalledService_ExternalService(), theRepositoryPackage.getSignature(), null, "calledService_ExternalService", null, 1, 1, ExternalCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExternalCallAction_ParametricParameterUsage_ParametricParameterUsage(), this.getParametricParameterUsage(), null, "parametricParameterUsage_ParametricParameterUsage", null, 0, -1, ExternalCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionParametricParameterUsageEClass, CollectionParametricParameterUsage.class, "CollectionParametricParameterUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionParametricParameterUsage_Type(), theParameterPackage.getCollectionParameterCharacterisationType(), "type", null, 1, 1, CollectionParametricParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(branchTransitionEClass, BranchTransition.class, "BranchTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranchTransition_BranchCondition(), ecorePackage.getEString(), "branchCondition", null, 1, 1, BranchTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBranchTransition_BranchBehaviour_BranchTransition(), this.getResourceDemandingBehaviour(), null, "branchBehaviour_BranchTransition", null, 1, 1, BranchTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(branchActionEClass, BranchAction.class, "BranchAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchAction_Branches_Branch(), this.getBranchTransition(), null, "branches_Branch", null, 0, -1, BranchAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(aquireActionEClass, AquireAction.class, "AquireAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAquireAction_ResourceType_Aquire(), theResourcetypePackage.getPassiveResourceType(), null, "resourceType_Aquire", null, 1, 1, AquireAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceEffectSpecificationEClass, ServiceEffectSpecification.class, "ServiceEffectSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceEffectSpecification_SeffTypeID(), ecorePackage.getEString(), "seffTypeID", null, 1, 1, ServiceEffectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceEffectSpecification_DescribedService__SEFF(), theRepositoryPackage.getSignature(), null, "describedService__SEFF", null, 1, 1, ServiceEffectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SeffPackageImpl
