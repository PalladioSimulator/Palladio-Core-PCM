/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
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
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;
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
import de.uka.ipd.sdq.stoex.StoexPackage;

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
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

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
	private EClass composedStructureEClass = null;

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
	private EClass requiredDelegationConnectorEClass = null;

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
	private EClass assemblyEventConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sinkDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyContextEClass = null;

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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CompositionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompositionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		PerformancePackageImpl thePerformancePackage = (PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) instanceof PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) : PerformancePackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) : QosannotationsPackage.eINSTANCE);
		de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl thePerformancePackage_1 = (de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) instanceof de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) : de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eINSTANCE);
		ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) : ReliabilityPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) : SubsystemPackage.eINSTANCE);

		// Create package meta-data objects
		theCompositionPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		thePerformancePackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theQosannotationsPackage.createPackageContents();
		thePerformancePackage_1.createPackageContents();
		theReliabilityPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theSubsystemPackage.createPackageContents();

		// Initialize created meta-data
		theCompositionPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		thePerformancePackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theQosannotationsPackage.initializePackageContents();
		thePerformancePackage_1.initializePackageContents();
		theReliabilityPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
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

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompositionPackage.eNS_URI, theCompositionPackage);
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
	public EReference getProvidedDelegationConnector_AssemblyContext_ProvidedDelegationConnector() {
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
	public EClass getComposedStructure() {
		return composedStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_AssemblyContexts_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_AssemblyConnectors_ComposedStructure() {
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
	public EReference getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_AssemblyEventConnector__ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_SinkDelegationConnectors__ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_SourceDelegationConnectors__ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedStructure_ProvidedDelegationConnectors_ComposedStructure() {
		return (EReference)composedStructureEClass.getEStructuralFeatures().get(7);
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
	public EReference getAssemblyConnector_RequiringAssemblyContext_AssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_ProvidingAssemblyContext_AssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_ProvidedRole__AssemblyConnector() {
		return (EReference)assemblyConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyConnector_RequiredRole__AssemblyConnector() {
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
	public EReference getRequiredDelegationConnector_AssemblyContext_RequiredDelegationConnector() {
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
	public EClass getResourceRequiredDelegationConnector() {
		return resourceRequiredDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector() {
		return (EReference)resourceRequiredDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssemblyEventConnector() {
		return assemblyEventConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyEventConnector_SinkRole__AssemblyEventConnector() {
		return (EReference)assemblyEventConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyEventConnector_SourceRole__AssemblyEventConnector() {
		return (EReference)assemblyEventConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyEventConnector_SinkAssemblyContext__AssemblyEventConnector() {
		return (EReference)assemblyEventConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyEventConnector_SourceAssemblyContext__AssemblyEventConnector() {
		return (EReference)assemblyEventConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyEventConnector_ParentStructure__AssemblyEventConnector() {
		return (EReference)assemblyEventConnectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSinkDelegationConnector() {
		return sinkDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinkDelegationConnector_InnerSinkRole__SinkDelegationConnector() {
		return (EReference)sinkDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinkDelegationConnector_OuterSinkRole__SinkDelegationConnector() {
		return (EReference)sinkDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinkDelegationConnector_AssemblyContext__SinkDelegationConnector() {
		return (EReference)sinkDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinkDelegationConnector_ParentStructure_SinkDelegationConnector() {
		return (EReference)sinkDelegationConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceDelegationConnector() {
		return sourceDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceDelegationConnector_InnerSourceRole__SourceDelegationConnector() {
		return (EReference)sourceDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceDelegationConnector_OuterSourceRole__SourceDelegationConnector() {
		return (EReference)sourceDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceDelegationConnector_AssemblyContext__SourceDelegationConnector() {
		return (EReference)sourceDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceDelegationConnector_ParentStructure_SourceDelegationConnector() {
		return (EReference)sourceDelegationConnectorEClass.getEStructuralFeatures().get(3);
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
	public EReference getAssemblyContext_ParentStructure_AssemblyContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyContext_EncapsulatedComponent_AssemblyContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssemblyContext_ConfigVariableSetters__AssemblyContext() {
		return (EReference)assemblyContextEClass.getEStructuralFeatures().get(2);
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
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR);

		composedStructureEClass = createEClass(COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		createEReference(composedStructureEClass, COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);

		assemblyConnectorEClass = createEClass(ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR);
		createEReference(assemblyConnectorEClass, ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR);

		requiredDelegationConnectorEClass = createEClass(REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR);

		resourceRequiredDelegationConnectorEClass = createEClass(RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(resourceRequiredDelegationConnectorEClass, RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);

		assemblyEventConnectorEClass = createEClass(ASSEMBLY_EVENT_CONNECTOR);
		createEReference(assemblyEventConnectorEClass, ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR);
		createEReference(assemblyEventConnectorEClass, ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR);
		createEReference(assemblyEventConnectorEClass, ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR);
		createEReference(assemblyEventConnectorEClass, ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR);
		createEReference(assemblyEventConnectorEClass, ASSEMBLY_EVENT_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_EVENT_CONNECTOR);

		sinkDelegationConnectorEClass = createEClass(SINK_DELEGATION_CONNECTOR);
		createEReference(sinkDelegationConnectorEClass, SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR);
		createEReference(sinkDelegationConnectorEClass, SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR);
		createEReference(sinkDelegationConnectorEClass, SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR);
		createEReference(sinkDelegationConnectorEClass, SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR);

		sourceDelegationConnectorEClass = createEClass(SOURCE_DELEGATION_CONNECTOR);
		createEReference(sourceDelegationConnectorEClass, SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR);
		createEReference(sourceDelegationConnectorEClass, SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR);
		createEReference(sourceDelegationConnectorEClass, SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR);
		createEReference(sourceDelegationConnectorEClass, SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR);

		assemblyContextEClass = createEClass(ASSEMBLY_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT);
		createEReference(assemblyContextEClass, ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT);
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
		ConnectorsPackage theConnectorsPackage = (ConnectorsPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		providedDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		composedStructureEClass.getESuperTypes().add(theEntityPackage.getEntity());
		assemblyConnectorEClass.getESuperTypes().add(theConnectorsPackage.getConnector());
		requiredDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		assemblyEventConnectorEClass.getESuperTypes().add(theConnectorsPackage.getConnector());
		sinkDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		sourceDelegationConnectorEClass.getESuperTypes().add(theRepositoryPackage.getDelegationConnector());
		assemblyContextEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(providedDelegationConnectorEClass, ProvidedDelegationConnector.class, "ProvidedDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector(), theRepositoryPackage.getOperationProvidedRole(), null, "innerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector(), theRepositoryPackage.getOperationProvidedRole(), null, "outerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_AssemblyContext_ProvidedDelegationConnector(), this.getAssemblyContext(), null, "assemblyContext_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_ProvidedDelegationConnectors_ComposedStructure(), "parentStructure_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(composedStructureEClass, ComposedStructure.class, "ComposedStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedStructure_AssemblyContexts_ComposedStructure(), this.getAssemblyContext(), this.getAssemblyContext_ParentStructure_AssemblyContext(), "assemblyContexts_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_AssemblyConnectors_ComposedStructure(), this.getAssemblyConnector(), this.getAssemblyConnector_ParentStructure_AssemblyConnector(), "assemblyConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_RequiredDelegationConnectors_ComposedStructure(), this.getRequiredDelegationConnector(), this.getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector(), "requiredDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure(), this.getResourceRequiredDelegationConnector(), this.getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector(), "resourceRequiredDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_AssemblyEventConnector__ComposedStructure(), this.getAssemblyEventConnector(), this.getAssemblyEventConnector_ParentStructure__AssemblyEventConnector(), "assemblyEventConnector__ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_SinkDelegationConnectors__ComposedStructure(), this.getSinkDelegationConnector(), this.getSinkDelegationConnector_ParentStructure_SinkDelegationConnector(), "sinkDelegationConnectors__ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_SourceDelegationConnectors__ComposedStructure(), this.getSourceDelegationConnector(), this.getSourceDelegationConnector_ParentStructure_SourceDelegationConnector(), "sourceDelegationConnectors__ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComposedStructure_ProvidedDelegationConnectors_ComposedStructure(), this.getProvidedDelegationConnector(), this.getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector(), "providedDelegationConnectors_ComposedStructure", null, 0, -1, ComposedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(composedStructureEClass, ecorePackage.getEBoolean(), "MultipleConnectorsConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(composedStructureEClass, ecorePackage.getEBoolean(), "MultipleConnectorConstraintForAssembyConnectors", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assemblyConnectorEClass, AssemblyConnector.class, "AssemblyConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyConnector_RequiringAssemblyContext_AssemblyConnector(), this.getAssemblyContext(), null, "requiringAssemblyContext_AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ProvidingAssemblyContext_AssemblyConnector(), this.getAssemblyContext(), null, "providingAssemblyContext_AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ProvidedRole__AssemblyConnector(), theRepositoryPackage.getOperationProvidedRole(), null, "providedRole__AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_RequiredRole__AssemblyConnector(), theRepositoryPackage.getOperationRequiredRole(), null, "requiredRole__AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyConnector_ParentStructure_AssemblyConnector(), this.getComposedStructure(), this.getComposedStructure_AssemblyConnectors_ComposedStructure(), "parentStructure_AssemblyConnector", null, 1, 1, AssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		op = addEOperation(assemblyConnectorEClass, ecorePackage.getEBoolean(), "AssemblyConnectorsReferencedInterfacesMustMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(requiredDelegationConnectorEClass, RequiredDelegationConnector.class, "RequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector(), theRepositoryPackage.getOperationRequiredRole(), null, "innerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector(), theRepositoryPackage.getOperationRequiredRole(), null, "outerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_AssemblyContext_RequiredDelegationConnector(), this.getAssemblyContext(), null, "assemblyContext_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_RequiredDelegationConnectors_ComposedStructure(), "parentStructure_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceRequiredDelegationConnectorEClass, ResourceRequiredDelegationConnector.class, "ResourceRequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector(), theRepositoryPackage.getResourceRequiredRole(), null, "innerResourceRequiredRole_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector(), theRepositoryPackage.getResourceRequiredRole(), null, "outerResourceRequiredRole_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure(), "parentStructure_ResourceRequiredDelegationConnector", null, 1, 1, ResourceRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyEventConnectorEClass, AssemblyEventConnector.class, "AssemblyEventConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyEventConnector_SinkRole__AssemblyEventConnector(), theRepositoryPackage.getSinkRole(), null, "sinkRole__AssemblyEventConnector", null, 1, 1, AssemblyEventConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyEventConnector_SourceRole__AssemblyEventConnector(), theRepositoryPackage.getSourceRole(), null, "sourceRole__AssemblyEventConnector", null, 1, 1, AssemblyEventConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyEventConnector_SinkAssemblyContext__AssemblyEventConnector(), this.getAssemblyContext(), null, "sinkAssemblyContext__AssemblyEventConnector", null, 1, 1, AssemblyEventConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyEventConnector_SourceAssemblyContext__AssemblyEventConnector(), this.getAssemblyContext(), null, "sourceAssemblyContext__AssemblyEventConnector", null, 1, 1, AssemblyEventConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyEventConnector_ParentStructure__AssemblyEventConnector(), this.getComposedStructure(), this.getComposedStructure_AssemblyEventConnector__ComposedStructure(), "parentStructure__AssemblyEventConnector", null, 1, 1, AssemblyEventConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sinkDelegationConnectorEClass, SinkDelegationConnector.class, "SinkDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSinkDelegationConnector_InnerSinkRole__SinkDelegationConnector(), theRepositoryPackage.getSinkRole(), null, "innerSinkRole__SinkDelegationConnector", null, 1, 1, SinkDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSinkDelegationConnector_OuterSinkRole__SinkDelegationConnector(), theRepositoryPackage.getSinkRole(), null, "outerSinkRole__SinkDelegationConnector", null, 1, 1, SinkDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSinkDelegationConnector_AssemblyContext__SinkDelegationConnector(), this.getAssemblyContext(), null, "assemblyContext__SinkDelegationConnector", null, 1, 1, SinkDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSinkDelegationConnector_ParentStructure_SinkDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_SinkDelegationConnectors__ComposedStructure(), "parentStructure_SinkDelegationConnector", null, 1, 1, SinkDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sourceDelegationConnectorEClass, SourceDelegationConnector.class, "SourceDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceDelegationConnector_InnerSourceRole__SourceDelegationConnector(), theRepositoryPackage.getSourceRole(), null, "innerSourceRole__SourceDelegationConnector", null, 1, 1, SourceDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSourceDelegationConnector_OuterSourceRole__SourceDelegationConnector(), theRepositoryPackage.getSourceRole(), null, "outerSourceRole__SourceDelegationConnector", null, 1, 1, SourceDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSourceDelegationConnector_AssemblyContext__SourceDelegationConnector(), this.getAssemblyContext(), null, "assemblyContext__SourceDelegationConnector", null, 1, 1, SourceDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSourceDelegationConnector_ParentStructure_SourceDelegationConnector(), this.getComposedStructure(), this.getComposedStructure_SourceDelegationConnectors__ComposedStructure(), "parentStructure_SourceDelegationConnector", null, 1, 1, SourceDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyContextEClass, AssemblyContext.class, "AssemblyContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyContext_ParentStructure_AssemblyContext(), this.getComposedStructure(), this.getComposedStructure_AssemblyContexts_ComposedStructure(), "parentStructure_AssemblyContext", null, 1, 1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyContext_EncapsulatedComponent_AssemblyContext(), theRepositoryPackage.getRepositoryComponent(), null, "encapsulatedComponent_AssemblyContext", null, 1, 1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyContext_ConfigVariableSetters__AssemblyContext(), theParameterPackage.getVariableSetter(), theParameterPackage.getVariableSetter_AssemblyContext__VariableSetter(), "configVariableSetters__AssemblyContext", null, 0, -1, AssemblyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //CompositionPackageImpl
