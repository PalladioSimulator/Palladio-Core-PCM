/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.AlternativeDemand;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.ResourceUsage;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.DeviceServer;
import de.uka.ipd.sdq.qnm.IterativeDemand;
import de.uka.ipd.sdq.qnm.CompositeResourceUsage;
import de.uka.ipd.sdq.qnm.LogicalServer;
import de.uka.ipd.sdq.qnm.ParallelDemand;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.QnmFactory;
import de.uka.ipd.sdq.qnm.QnmPackage;
import de.uka.ipd.sdq.qnm.SequentialDemand;
import de.uka.ipd.sdq.qnm.Resource;

import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;

import de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QnmPackageImpl extends EPackageImpl implements QnmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qnModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequentialDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterativeDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType managedPDFEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType managedPMFEDataType = null;

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
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QnmPackageImpl() {
		super(eNS_URI, QnmFactory.eINSTANCE);
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
	public static QnmPackage init() {
		if (isInited) return (QnmPackage)EPackage.Registry.INSTANCE.getEPackage(QnmPackage.eNS_URI);

		// Obtain or create and register package
		QnmPackageImpl theQnmPackage = (QnmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QnmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QnmPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		QNResultPackageImpl theQNResultPackage = (QNResultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QNResultPackage.eNS_URI) instanceof QNResultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QNResultPackage.eNS_URI) : QNResultPackage.eINSTANCE);

		// Create package meta-data objects
		theQnmPackage.createPackageContents();
		theQNResultPackage.createPackageContents();

		// Initialize created meta-data
		theQnmPackage.initializePackageContents();
		theQNResultPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQnmPackage.freeze();

		return theQnmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQNModel() {
		return qnModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNModel_Customers() {
		return (EReference)qnModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNModel_Servers() {
		return (EReference)qnModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQNModel_INFINITE() {
		return (EAttribute)qnModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Number() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomer_Demand() {
		return (EReference)customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Name() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemand() {
		return demandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServer() {
		return serverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Number() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Name() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceServer() {
		return deviceServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalServer() {
		return logicalServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalDemand() {
		return logicalDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalDemand_Logicalserver() {
		return (EReference)logicalDemandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalDemand_Demands() {
		return (EReference)logicalDemandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceDemand() {
		return deviceDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceDemand_DeviceServer() {
		return (EReference)deviceDemandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceDemand_ServiceTime() {
		return (EAttribute)deviceDemandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequentialDemand() {
		return sequentialDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternativeDemand() {
		return alternativeDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterativeDemand() {
		return iterativeDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelDemand() {
		return parallelDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getManagedPDF() {
		return managedPDFEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getManagedPMF() {
		return managedPMFEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QnmFactory getQnmFactory() {
		return (QnmFactory)getEFactoryInstance();
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
		qnModelEClass = createEClass(QN_MODEL);
		createEReference(qnModelEClass, QN_MODEL__CUSTOMERS);
		createEReference(qnModelEClass, QN_MODEL__SERVERS);
		createEAttribute(qnModelEClass, QN_MODEL__INFINITE);

		customerEClass = createEClass(CUSTOMER);
		createEAttribute(customerEClass, CUSTOMER__NUMBER);
		createEReference(customerEClass, CUSTOMER__DEMAND);
		createEAttribute(customerEClass, CUSTOMER__NAME);

		demandEClass = createEClass(DEMAND);

		serverEClass = createEClass(SERVER);
		createEAttribute(serverEClass, SERVER__NUMBER);
		createEAttribute(serverEClass, SERVER__NAME);

		deviceServerEClass = createEClass(DEVICE_SERVER);

		logicalServerEClass = createEClass(LOGICAL_SERVER);

		logicalDemandEClass = createEClass(LOGICAL_DEMAND);
		createEReference(logicalDemandEClass, LOGICAL_DEMAND__LOGICALSERVER);
		createEReference(logicalDemandEClass, LOGICAL_DEMAND__DEMANDS);

		deviceDemandEClass = createEClass(DEVICE_DEMAND);
		createEReference(deviceDemandEClass, DEVICE_DEMAND__DEVICE_SERVER);
		createEAttribute(deviceDemandEClass, DEVICE_DEMAND__SERVICE_TIME);

		sequentialDemandEClass = createEClass(SEQUENTIAL_DEMAND);

		alternativeDemandEClass = createEClass(ALTERNATIVE_DEMAND);

		iterativeDemandEClass = createEClass(ITERATIVE_DEMAND);

		parallelDemandEClass = createEClass(PARALLEL_DEMAND);

		// Create data types
		managedPDFEDataType = createEDataType(MANAGED_PDF);
		managedPMFEDataType = createEDataType(MANAGED_PMF);
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
		QNResultPackage theQNResultPackage = (QNResultPackage)EPackage.Registry.INSTANCE.getEPackage(QNResultPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theQNResultPackage);

		// Add supertypes to classes
		deviceServerEClass.getESuperTypes().add(this.getServer());
		logicalServerEClass.getESuperTypes().add(this.getServer());
		logicalDemandEClass.getESuperTypes().add(this.getDemand());
		deviceDemandEClass.getESuperTypes().add(this.getDemand());
		sequentialDemandEClass.getESuperTypes().add(this.getLogicalDemand());
		alternativeDemandEClass.getESuperTypes().add(this.getLogicalDemand());
		iterativeDemandEClass.getESuperTypes().add(this.getLogicalDemand());
		parallelDemandEClass.getESuperTypes().add(this.getLogicalDemand());

		// Initialize classes and features; add operations and parameters
		initEClass(qnModelEClass, QNModel.class, "QNModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQNModel_Customers(), this.getCustomer(), null, "customers", null, 0, -1, QNModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNModel_Servers(), this.getServer(), null, "servers", null, 0, -1, QNModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQNModel_INFINITE(), ecorePackage.getEInt(), "INFINITE", "-1", 1, 1, QNModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerEClass, Task.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomer_Number(), ecorePackage.getEInt(), "number", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomer_Demand(), this.getDemand(), null, "demand", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Name(), ecorePackage.getEString(), "name", "", 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(customerEClass, ecorePackage.getEEList(), "getAllDemands", 0, 1);

		initEClass(demandEClass, ResourceUsage.class, "Demand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(demandEClass, ecorePackage.getEEList(), "getUsedResources", 0, 1);

		initEClass(serverEClass, Resource.class, "Server", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServer_Number(), ecorePackage.getEInt(), "number", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Name(), ecorePackage.getEString(), "name", "", 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceServerEClass, DeviceServer.class, "DeviceServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalServerEClass, LogicalServer.class, "LogicalServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalDemandEClass, CompositeResourceUsage.class, "LogicalDemand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicalDemand_Logicalserver(), this.getLogicalServer(), null, "logicalserver", null, 1, 1, CompositeResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogicalDemand_Demands(), this.getDemand(), null, "demands", null, 0, -1, CompositeResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceDemandEClass, DeviceDemand.class, "DeviceDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeviceDemand_DeviceServer(), this.getDeviceServer(), null, "deviceServer", null, 1, 1, DeviceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeviceDemand_ServiceTime(), this.getManagedPDF(), "serviceTime", null, 1, 1, DeviceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequentialDemandEClass, SequentialDemand.class, "SequentialDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alternativeDemandEClass, AlternativeDemand.class, "AlternativeDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterativeDemandEClass, IterativeDemand.class, "IterativeDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parallelDemandEClass, ParallelDemand.class, "ParallelDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(managedPDFEDataType, ManagedPDF.class, "ManagedPDF", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(managedPMFEDataType, ManagedPMF.class, "ManagedPMF", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (managedPDFEDataType, 
		   source, 
		   new String[] {
			 "name", "ManagedPDF"
		   });		
		addAnnotation
		  (managedPMFEDataType, 
		   source, 
		   new String[] {
			 "name", "ManagedPMF"
		   });
	}

} //QnmPackageImpl
