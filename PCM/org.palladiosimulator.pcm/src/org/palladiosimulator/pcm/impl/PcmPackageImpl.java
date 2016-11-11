/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.pcm.DummyClass;
import org.palladiosimulator.pcm.PcmFactory;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.allocation.AllocationPackage;
import org.palladiosimulator.pcm.allocation.impl.AllocationPackageImpl;
import org.palladiosimulator.pcm.core.CorePackage;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.core.entity.impl.EntityPackageImpl;
import org.palladiosimulator.pcm.core.impl.CorePackageImpl;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.parameter.impl.ParameterPackageImpl;
import org.palladiosimulator.pcm.protocol.ProtocolPackage;
import org.palladiosimulator.pcm.protocol.impl.ProtocolPackageImpl;
import org.palladiosimulator.pcm.qosannotations.QosannotationsPackage;
import org.palladiosimulator.pcm.qosannotations.impl.QosannotationsPackageImpl;
import org.palladiosimulator.pcm.qosannotations.qos_performance.QosPerformancePackage;
import org.palladiosimulator.pcm.qosannotations.qos_performance.impl.QosPerformancePackageImpl;
import org.palladiosimulator.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import org.palladiosimulator.pcm.qosannotations.qos_reliability.impl.QosReliabilityPackageImpl;
import org.palladiosimulator.pcm.reliability.ReliabilityPackage;
import org.palladiosimulator.pcm.reliability.impl.ReliabilityPackageImpl;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.impl.RepositoryPackageImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;
import org.palladiosimulator.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.impl.ResourcetypePackageImpl;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.impl.SeffPackageImpl;
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage;
import org.palladiosimulator.pcm.seff.seff_performance.impl.SeffPerformancePackageImpl;
import org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage;
import org.palladiosimulator.pcm.seff.seff_reliability.impl.SeffReliabilityPackageImpl;
import org.palladiosimulator.pcm.subsystem.SubsystemPackage;
import org.palladiosimulator.pcm.subsystem.impl.SubsystemPackageImpl;
import org.palladiosimulator.pcm.system.SystemPackage;
import org.palladiosimulator.pcm.system.impl.SystemPackageImpl;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.impl.UsagemodelPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class PcmPackageImpl extends EPackageImpl implements PcmPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dummyClassEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.palladiosimulator.pcm.PcmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PcmPackageImpl() {
		super(eNS_URI, PcmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PcmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PcmPackage init() {
		if (isInited)
			return (PcmPackage) EPackage.Registry.INSTANCE.getEPackage(PcmPackage.eNS_URI);

		// Obtain or create and register package
		PcmPackageImpl thePcmPackage = (PcmPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof PcmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new PcmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CompositionPackage.eNS_URI) instanceof CompositionPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI)
						: CompositionPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI)
						: UsagemodelPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI)
						: RepositoryPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI)
						: ResourcetypePackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI)
						: ParameterPackage.eINSTANCE);
		ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI)
						: ReliabilityPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		SeffPerformancePackageImpl theSeffPerformancePackage = (SeffPerformancePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffPerformancePackage.eNS_URI) instanceof SeffPerformancePackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(SeffPerformancePackage.eNS_URI)
						: SeffPerformancePackage.eINSTANCE);
		SeffReliabilityPackageImpl theSeffReliabilityPackage = (SeffReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffReliabilityPackage.eNS_URI) instanceof SeffReliabilityPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(SeffReliabilityPackage.eNS_URI)
						: SeffReliabilityPackage.eINSTANCE);
		QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI)
						: QosannotationsPackage.eINSTANCE);
		QosPerformancePackageImpl theQosPerformancePackage = (QosPerformancePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosPerformancePackage.eNS_URI) instanceof QosPerformancePackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(QosPerformancePackage.eNS_URI)
						: QosPerformancePackage.eINSTANCE);
		QosReliabilityPackageImpl theQosReliabilityPackage = (QosReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosReliabilityPackage.eNS_URI) instanceof QosReliabilityPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(QosReliabilityPackage.eNS_URI)
						: QosReliabilityPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI)
						: ResourceenvironmentPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI)
						: AllocationPackage.eINSTANCE);
		SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI)
						: SubsystemPackage.eINSTANCE);

		// Create package meta-data objects
		thePcmPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theReliabilityPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		theSeffPerformancePackage.createPackageContents();
		theSeffReliabilityPackage.createPackageContents();
		theQosannotationsPackage.createPackageContents();
		theQosPerformancePackage.createPackageContents();
		theQosReliabilityPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theSubsystemPackage.createPackageContents();

		// Initialize created meta-data
		thePcmPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theReliabilityPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		theSeffPerformancePackage.initializePackageContents();
		theSeffReliabilityPackage.initializePackageContents();
		theQosannotationsPackage.initializePackageContents();
		theQosPerformancePackage.initializePackageContents();
		theQosReliabilityPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theSubsystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePcmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PcmPackage.eNS_URI, thePcmPackage);
		return thePcmPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDummyClass() {
		return dummyClassEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PcmFactory getPcmFactory() {
		return (PcmFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		dummyClassEClass = createEClass(DUMMY_CLASS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(UsagemodelPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourcetypePackage.eNS_URI);
		ProtocolPackage theProtocolPackage = (ProtocolPackage) EPackage.Registry.INSTANCE
				.getEPackage(ProtocolPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage) EPackage.Registry.INSTANCE
				.getEPackage(ParameterPackage.eNS_URI);
		ReliabilityPackage theReliabilityPackage = (ReliabilityPackage) EPackage.Registry.INSTANCE
				.getEPackage(ReliabilityPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		QosannotationsPackage theQosannotationsPackage = (QosannotationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(QosannotationsPackage.eNS_URI);
		SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourceenvironmentPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
				.getEPackage(AllocationPackage.eNS_URI);
		SubsystemPackage theSubsystemPackage = (SubsystemPackage) EPackage.Registry.INSTANCE
				.getEPackage(SubsystemPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCorePackage);
		getESubpackages().add(theUsagemodelPackage);
		getESubpackages().add(theRepositoryPackage);
		getESubpackages().add(theResourcetypePackage);
		getESubpackages().add(theProtocolPackage);
		getESubpackages().add(theParameterPackage);
		getESubpackages().add(theReliabilityPackage);
		getESubpackages().add(theSeffPackage);
		getESubpackages().add(theQosannotationsPackage);
		getESubpackages().add(theSystemPackage);
		getESubpackages().add(theResourceenvironmentPackage);
		getESubpackages().add(theAllocationPackage);
		getESubpackages().add(theSubsystemPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(dummyClassEClass, DummyClass.class, "DummyClass", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // PcmPackageImpl
