/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.QnmPackage;

import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelFactory;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;

import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

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
public class ResultModelPackageImpl extends EPackageImpl implements ResultModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qnmResultModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskResourceUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceUsageTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceTimeBreakDownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType managedPMFEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType managedPDFEDataType = null;

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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResultModelPackageImpl() {
		super(eNS_URI, ResultModelFactory.eINSTANCE);
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
	public static ResultModelPackage init() {
		if (isInited) return (ResultModelPackage)EPackage.Registry.INSTANCE.getEPackage(ResultModelPackage.eNS_URI);

		// Obtain or create and register package
		ResultModelPackageImpl theResultModelPackage = (ResultModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ResultModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ResultModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ProbfunctionPackage.eINSTANCE.eClass();
		QnmPackage.eINSTANCE.eClass();
		ResourceModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theResultModelPackage.createPackageContents();

		// Initialize created meta-data
		theResultModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResultModelPackage.freeze();

		return theResultModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQNMResultModel() {
		return qnmResultModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNMResultModel_Qnmodel() {
		return (EReference)qnmResultModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNMResultModel_TaskResourceUsages() {
		return (EReference)qnmResultModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNMResultModel_ResourceUsageTimes() {
		return (EReference)qnmResultModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskResourceUsage() {
		return taskResourceUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskResourceUsage_QueueLengthOneLess() {
		return (EAttribute)taskResourceUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskResourceUsage_QueueLength() {
		return (EAttribute)taskResourceUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskResourceUsage_TaskServiceTime() {
		return (EAttribute)taskResourceUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskResourceUsage_WaitingTimeOneLess() {
		return (EAttribute)taskResourceUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskResourceUsage_WaitingTime() {
		return (EAttribute)taskResourceUsageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskResourceUsage_Task() {
		return (EReference)taskResourceUsageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskResourceUsage_Resource() {
		return (EReference)taskResourceUsageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceUsageTime() {
		return resourceUsageTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsageTime_ResourceUsage() {
		return (EReference)resourceUsageTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceUsageTime_ServiceTime() {
		return (EAttribute)resourceUsageTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceUsageTime_ResponseTime() {
		return (EAttribute)resourceUsageTimeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsageTime_ServiceTimeBreakDowns() {
		return (EReference)resourceUsageTimeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceTimeBreakDown() {
		return serviceTimeBreakDownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTimeBreakDown_UsageProbability() {
		return (EAttribute)serviceTimeBreakDownEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTimeBreakDown_UsageTime() {
		return (EAttribute)serviceTimeBreakDownEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTimeBreakDown_UsedResource() {
		return (EReference)serviceTimeBreakDownEClass.getEStructuralFeatures().get(2);
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
	public EDataType getManagedPDF() {
		return managedPDFEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultModelFactory getResultModelFactory() {
		return (ResultModelFactory)getEFactoryInstance();
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
		qnmResultModelEClass = createEClass(QNM_RESULT_MODEL);
		createEReference(qnmResultModelEClass, QNM_RESULT_MODEL__QNMODEL);
		createEReference(qnmResultModelEClass, QNM_RESULT_MODEL__TASK_RESOURCE_USAGES);
		createEReference(qnmResultModelEClass, QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES);

		taskResourceUsageEClass = createEClass(TASK_RESOURCE_USAGE);
		createEAttribute(taskResourceUsageEClass, TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS);
		createEAttribute(taskResourceUsageEClass, TASK_RESOURCE_USAGE__QUEUE_LENGTH);
		createEAttribute(taskResourceUsageEClass, TASK_RESOURCE_USAGE__TASK_SERVICE_TIME);
		createEAttribute(taskResourceUsageEClass, TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS);
		createEAttribute(taskResourceUsageEClass, TASK_RESOURCE_USAGE__WAITING_TIME);
		createEReference(taskResourceUsageEClass, TASK_RESOURCE_USAGE__TASK);
		createEReference(taskResourceUsageEClass, TASK_RESOURCE_USAGE__RESOURCE);

		resourceUsageTimeEClass = createEClass(RESOURCE_USAGE_TIME);
		createEReference(resourceUsageTimeEClass, RESOURCE_USAGE_TIME__RESOURCE_USAGE);
		createEAttribute(resourceUsageTimeEClass, RESOURCE_USAGE_TIME__SERVICE_TIME);
		createEAttribute(resourceUsageTimeEClass, RESOURCE_USAGE_TIME__RESPONSE_TIME);
		createEReference(resourceUsageTimeEClass, RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWNS);

		serviceTimeBreakDownEClass = createEClass(SERVICE_TIME_BREAK_DOWN);
		createEAttribute(serviceTimeBreakDownEClass, SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY);
		createEAttribute(serviceTimeBreakDownEClass, SERVICE_TIME_BREAK_DOWN__USAGE_TIME);
		createEReference(serviceTimeBreakDownEClass, SERVICE_TIME_BREAK_DOWN__USED_RESOURCE);

		// Create data types
		managedPMFEDataType = createEDataType(MANAGED_PMF);
		managedPDFEDataType = createEDataType(MANAGED_PDF);
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
		QnmPackage theQnmPackage = (QnmPackage)EPackage.Registry.INSTANCE.getEPackage(QnmPackage.eNS_URI);
		ResourceModelPackage theResourceModelPackage = (ResourceModelPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceModelPackage.eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(qnmResultModelEClass, QNMResultModel.class, "QNMResultModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQNMResultModel_Qnmodel(), theQnmPackage.getQNModel(), null, "qnmodel", null, 1, 1, QNMResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNMResultModel_TaskResourceUsages(), this.getTaskResourceUsage(), null, "taskResourceUsages", null, 0, -1, QNMResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNMResultModel_ResourceUsageTimes(), this.getResourceUsageTime(), null, "resourceUsageTimes", null, 0, -1, QNMResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskResourceUsageEClass, TaskResourceUsage.class, "TaskResourceUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskResourceUsage_QueueLengthOneLess(), this.getManagedPMF(), "queueLengthOneLess", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskResourceUsage_QueueLength(), this.getManagedPMF(), "queueLength", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskResourceUsage_TaskServiceTime(), this.getManagedPDF(), "taskServiceTime", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskResourceUsage_WaitingTimeOneLess(), this.getManagedPDF(), "waitingTimeOneLess", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskResourceUsage_WaitingTime(), this.getManagedPDF(), "waitingTime", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskResourceUsage_Task(), theQnmPackage.getTask(), null, "task", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskResourceUsage_Resource(), theResourceModelPackage.getResource(), null, "resource", null, 1, 1, TaskResourceUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceUsageTimeEClass, ResourceUsageTime.class, "ResourceUsageTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceUsageTime_ResourceUsage(), theResourceModelPackage.getAbstractResourceUsage(), null, "resourceUsage", null, 1, 1, ResourceUsageTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceUsageTime_ServiceTime(), this.getManagedPDF(), "serviceTime", null, 1, 1, ResourceUsageTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceUsageTime_ResponseTime(), this.getManagedPDF(), "responseTime", null, 1, 1, ResourceUsageTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceUsageTime_ServiceTimeBreakDowns(), this.getServiceTimeBreakDown(), null, "serviceTimeBreakDowns", null, 0, -1, ResourceUsageTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceTimeBreakDownEClass, ServiceTimeBreakDown.class, "ServiceTimeBreakDown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceTimeBreakDown_UsageProbability(), ecorePackage.getEDouble(), "usageProbability", "0", 1, 1, ServiceTimeBreakDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceTimeBreakDown_UsageTime(), ecorePackage.getEDouble(), "usageTime", "0", 1, 1, ServiceTimeBreakDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTimeBreakDown_UsedResource(), theResourceModelPackage.getResource(), null, "usedResource", null, 1, 1, ServiceTimeBreakDown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(managedPMFEDataType, ManagedPMF.class, "ManagedPMF", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(managedPDFEDataType, ManagedPDF.class, "ManagedPDF", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (managedPMFEDataType, 
		   source, 
		   new String[] {
			 "name", "ManagedPMF"
		   });		
		addAnnotation
		  (managedPDFEDataType, 
		   source, 
		   new String[] {
			 "name", "ManagedPDF"
		   });
	}

} //ResultModelPackageImpl
