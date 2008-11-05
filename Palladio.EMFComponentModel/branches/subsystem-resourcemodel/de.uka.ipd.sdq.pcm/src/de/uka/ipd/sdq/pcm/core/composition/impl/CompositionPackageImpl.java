/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.ReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;
import de.uka.ipd.sdq.pcm.seff.performance.impl.PerformancePackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.subsystem.impl.SubsystemPackageImpl;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionPackageImpl extends EPackageImpl implements CompositionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providedDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceRequiredDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedStructureEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompositionPackageImpl() {
		super(eNS_URI, CompositionFactory.eINSTANCE);
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
	public static CompositionPackage init() {
		if (isInited) return (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Obtain or create and register package
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CompositionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		PerformancePackageImpl thePerformancePackage = (PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) instanceof PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) : PerformancePackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) : QosannotationsPackage.eINSTANCE);
		de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl thePerformancePackage_1 = (de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) instanceof de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) : de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eINSTANCE);
		ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) : ReliabilityPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) : SubsystemPackage.eINSTANCE);

		// Create package meta-data objects
		theCompositionPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		thePerformancePackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theQosannotationsPackage.createPackageContents();
		thePerformancePackage_1.createPackageContents();
		theReliabilityPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theSubsystemPackage.createPackageContents();

		// Initialize created meta-data
		theCompositionPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		thePerformancePackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theQosannotationsPackage.initializePackageContents();
		thePerformancePackage_1.initializePackageContents();
		theReliabilityPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theSubsystemPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCompositionPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return CompositionValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCompositionPackage.freeze();

		return theCompositionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidedDelegationConnector() {
		return providedDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_ChildComponentContext_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssemblyContext() {
		return assemblyContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyContext_EncapsulatedComponent_ChildComponentContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyContext_ParentStructure_AssemblyContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyContext_ConfigParameterUsages_AssemblyContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredDelegationConnector() {
		return requiredDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_ChildComponentContext_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssemblyConnector() {
		return assemblyConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_ProvidedRole_CompositeAssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_RequiredRole_CompositeAssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_ParentStructure_AssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceRequiredDelegationConnector() {
		return resourceRequiredDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposedStructure() {
		return composedStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_ChildComponentContexts_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_ProvidedDelegationConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_RequiredDelegationConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_CompositeAssemblyConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionFactory getCompositionFactory() {
		return (CompositionFactory)getEFactoryInstance();
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
		providedDelegationConnectorEClass = createEClass(PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR);

		assemblyContextEClass = createEClass(ASSEMBLY_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT);

		requiredDelegationConnectorEClass = createEClass(REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR);

		assemblyConnectorEClass = createEClass(ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR);

		resourceRequiredDelegationConnectorEClass = createEClass(RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);

		composedStructureEClass = createEClass(COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
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
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);
		ConnectorsPackage theConnectorsPackage = (ConnectorsPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		providedDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		assemblyContextEClass.getESuperTypes().add(theEntityPackage.getEntity());
		requiredDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		assemblyConnectorEClass.getESuperTypes().add(theConnectorsPackage.getConnector());
		assemblyConnectorEClass.getESuperTypes().add(theEntityPackage.getEntity());
		composedStructureEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(providedDelegationConnectorEClass, ProvidedDelegationConnector.class, "ProvidedDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector(), theRepositoryPackage.getProvidedRole(), null, "innerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector(), theRepositoryPackage.getProvidedRole(), null, "outerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_ChildComponentContext_ProvidedDelegationConnector(), this.getAssemblyContext(), null, "childComponentContext_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_ProvidedDelegationConnectors_ComposedStructure(), "parentStructure_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "ComponentOfChildComponentContextAndInnerRoleProvidingComponentNeedToBeTheSame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assemblyContextEClass, AssemblyContext.class, "AssemblyContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyContext_EncapsulatedComponent_ChildComponentContext(), theEntityPackage.getInterfaceProvidingRequiringEntity(), null, "encapsulatedComponent_ChildComponentContext", null, 1, 1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyContext_ParentStructure_AssemblyContext(), this.getComposedStructure(), this.getComposedStructure_ChildComponentContexts_ComposedStructure(), "parentStructure_AssemblyContext", null, 1, 1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyContext_ConfigParameterUsages_AssemblyContext(), theParameterPackage.getVariableUsage(), null, "configParameterUsages_AssemblyContext", null, 0, -1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(requiredDelegationConnectorEClass, RequiredDelegationConnector.class, "RequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector(), theRepositoryPackage.getRequiredRole(), null, "innerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector(), theRepositoryPackage.getRequiredRole(), null, "outerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_ChildComponentContext_RequiredDelegationConnector(), this.getAssemblyContext(), null, "childComponentContext_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_RequiredDelegationConnectors_ComposedStructure(), "parentStructure_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "ComponentOfChildComponentContextAndInnerRoleRequiringComponentNeedToBeTheSame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assemblyConnectorEClass, AssemblyConnector.class, "AssemblyConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector(), this.getAssemblyContext(), null, "requiringChildComponentContext_CompositeAssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector(), this.getAssemblyContext(), null, "providingChildComponentContext_CompositeAssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ProvidedRole_CompositeAssemblyConnector(), theRepositoryPackage.getProvidedRole(), null, "providedRole_CompositeAssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_RequiredRole_CompositeAssemblyConnector(), theRepositoryPackage.getRequiredRole(), null, "requiredRole_CompositeAssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ParentStructure_AssemblyConnector(), this.getComposedStructure(), this.getComposedStructure_CompositeAssemblyConnectors_ComposedStructure(), "parentStructure_AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(assemblyConnectorEClass, ecorePackage.getEBoolean(), "AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(assemblyConnectorEClass, ecorePackage.getEBoolean(), "AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceRequiredDelegationConnectorEClass, ResourceRequiredDelegationConnector.class, "ResourceRequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure(), "parentStructure_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector(), theRepositoryPackage.getResourceRequiredRole(), null, "innerResourceRequiredRole_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector(), theRepositoryPackage.getResourceRequiredRole(), null, "outerResourceRequiredRole_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(composedStructureEClass, ComposedStructure.class, "ComposedStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedStructure_ChildComponentContexts_ComposedStructure(), this.getAssemblyContext(), this.getAssemblyContext_ParentStructure_AssemblyContext(), "childComponentContexts_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_ProvidedDelegationConnectors_ComposedStructure(), this.getProvidedDelegationConnector(), this.getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector(), "providedDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_RequiredDelegationConnectors_ComposedStructure(), this.getRequiredDelegationConnector(), this.getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector(), "requiredDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_CompositeAssemblyConnectors_ComposedStructure(), this.getAssemblyConnector(), this.getAssemblyConnector_ParentStructure_AssemblyConnector(), "compositeAssemblyConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure(), this.getResourceRequiredDelegationConnector(), this.getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector(), "resourceRequiredDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //CompositionPackageImpl
