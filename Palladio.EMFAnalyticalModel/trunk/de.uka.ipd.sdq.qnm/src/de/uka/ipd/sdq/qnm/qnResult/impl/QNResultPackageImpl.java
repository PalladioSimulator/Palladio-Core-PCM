/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.qnm.QnmPackage;

import de.uka.ipd.sdq.qnm.impl.QnmPackageImpl;

import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultFactory;
import de.uka.ipd.sdq.qnm.qnResult.QNResultModel;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QNResultPackageImpl extends EPackageImpl implements QNResultPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demandServerUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demandResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerServerUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qnResultModelEClass = null;

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
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QNResultPackageImpl() {
		super(eNS_URI, QNResultFactory.eINSTANCE);
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
	public static QNResultPackage init() {
		if (isInited) return (QNResultPackage)EPackage.Registry.INSTANCE.getEPackage(QNResultPackage.eNS_URI);

		// Obtain or create and register package
		QNResultPackageImpl theQNResultPackage = (QNResultPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QNResultPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QNResultPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		QnmPackageImpl theQnmPackage = (QnmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QnmPackage.eNS_URI) instanceof QnmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QnmPackage.eNS_URI) : QnmPackage.eINSTANCE);

		// Create package meta-data objects
		theQNResultPackage.createPackageContents();
		theQnmPackage.createPackageContents();

		// Initialize created meta-data
		theQNResultPackage.initializePackageContents();
		theQnmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQNResultPackage.freeze();

		return theQNResultPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemandServerUsage() {
		return demandServerUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandServerUsage_Demand() {
		return (EReference)demandServerUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandServerUsage_Server() {
		return (EReference)demandServerUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDemandServerUsage_UsageProbability() {
		return (EAttribute)demandServerUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDemandServerUsage_MeanUsageTime() {
		return (EAttribute)demandServerUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemandResult() {
		return demandResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDemandResult_ResponseTime() {
		return (EAttribute)demandResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandResult_ServerUsages() {
		return (EReference)demandResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemandResult_Demand() {
		return (EReference)demandResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDemandResult_ServiceTime() {
		return (EAttribute)demandResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerResult() {
		return serverResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerResult_UsingCustomers() {
		return (EReference)serverResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerResult_Server() {
		return (EReference)serverResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerResult_UsageDemands() {
		return (EReference)serverResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerServerUsage() {
		return customerServerUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerServerUsage_CustomerResult() {
		return (EReference)customerServerUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerServerUsage_ServerResult() {
		return (EReference)customerServerUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerServerUsage_CausedWaitingTime() {
		return (EAttribute)customerServerUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerServerUsage_CausedWaitingTimeOneLess() {
		return (EAttribute)customerServerUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerServerUsage_QueueLength() {
		return (EAttribute)customerServerUsageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerServerUsage_QueueLengthOneLess() {
		return (EAttribute)customerServerUsageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerServerUsage_DemandsToServer() {
		return (EReference)customerServerUsageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerServerUsage_CustomerServiceTime() {
		return (EAttribute)customerServerUsageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerResult() {
		return customerResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerResult_Customer() {
		return (EReference)customerResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerResult_ServerUsage() {
		return (EReference)customerResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQNResultModel() {
		return qnResultModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_CustomerServerUsage() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_QnModel() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_CustomerResults() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_ServerResults() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_DemandResults() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQNResultModel_DemandServerUsages() {
		return (EReference)qnResultModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNResultFactory getQNResultFactory() {
		return (QNResultFactory)getEFactoryInstance();
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
		demandServerUsageEClass = createEClass(DEMAND_SERVER_USAGE);
		createEReference(demandServerUsageEClass, DEMAND_SERVER_USAGE__DEMAND);
		createEReference(demandServerUsageEClass, DEMAND_SERVER_USAGE__SERVER);
		createEAttribute(demandServerUsageEClass, DEMAND_SERVER_USAGE__USAGE_PROBABILITY);
		createEAttribute(demandServerUsageEClass, DEMAND_SERVER_USAGE__MEAN_USAGE_TIME);

		demandResultEClass = createEClass(DEMAND_RESULT);
		createEAttribute(demandResultEClass, DEMAND_RESULT__RESPONSE_TIME);
		createEReference(demandResultEClass, DEMAND_RESULT__SERVER_USAGES);
		createEReference(demandResultEClass, DEMAND_RESULT__DEMAND);
		createEAttribute(demandResultEClass, DEMAND_RESULT__SERVICE_TIME);

		serverResultEClass = createEClass(SERVER_RESULT);
		createEReference(serverResultEClass, SERVER_RESULT__USING_CUSTOMERS);
		createEReference(serverResultEClass, SERVER_RESULT__SERVER);
		createEReference(serverResultEClass, SERVER_RESULT__USAGE_DEMANDS);

		customerServerUsageEClass = createEClass(CUSTOMER_SERVER_USAGE);
		createEReference(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT);
		createEReference(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__SERVER_RESULT);
		createEAttribute(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME);
		createEAttribute(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS);
		createEAttribute(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__QUEUE_LENGTH);
		createEAttribute(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS);
		createEReference(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER);
		createEAttribute(customerServerUsageEClass, CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME);

		customerResultEClass = createEClass(CUSTOMER_RESULT);
		createEReference(customerResultEClass, CUSTOMER_RESULT__CUSTOMER);
		createEReference(customerResultEClass, CUSTOMER_RESULT__SERVER_USAGE);

		qnResultModelEClass = createEClass(QN_RESULT_MODEL);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__QN_MODEL);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__CUSTOMER_RESULTS);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__SERVER_RESULTS);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__DEMAND_RESULTS);
		createEReference(qnResultModelEClass, QN_RESULT_MODEL__DEMAND_SERVER_USAGES);
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

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(demandServerUsageEClass, DemandServerUsage.class, "DemandServerUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDemandServerUsage_Demand(), this.getDemandResult(), this.getDemandResult_ServerUsages(), "demand", null, 1, 1, DemandServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDemandServerUsage_Server(), this.getServerResult(), this.getServerResult_UsageDemands(), "server", null, 1, 1, DemandServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDemandServerUsage_UsageProbability(), ecorePackage.getEDouble(), "usageProbability", null, 1, 1, DemandServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDemandServerUsage_MeanUsageTime(), ecorePackage.getEDouble(), "meanUsageTime", null, 1, 1, DemandServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(demandResultEClass, DemandResult.class, "DemandResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDemandResult_ResponseTime(), theQnmPackage.getManagedPDF(), "responseTime", null, 1, 1, DemandResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDemandResult_ServerUsages(), this.getDemandServerUsage(), this.getDemandServerUsage_Demand(), "serverUsages", null, 0, -1, DemandResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDemandResult_Demand(), theQnmPackage.getDemand(), null, "demand", null, 1, 1, DemandResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDemandResult_ServiceTime(), theQnmPackage.getManagedPDF(), "serviceTime", null, 1, 1, DemandResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverResultEClass, ServerResult.class, "ServerResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServerResult_UsingCustomers(), this.getCustomerServerUsage(), this.getCustomerServerUsage_ServerResult(), "usingCustomers", null, 0, -1, ServerResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerResult_Server(), theQnmPackage.getServer(), null, "server", null, 1, 1, ServerResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerResult_UsageDemands(), this.getDemandServerUsage(), this.getDemandServerUsage_Server(), "usageDemands", null, 0, -1, ServerResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(serverResultEClass, this.getCustomerServerUsage(), "getUsageByCustomer", 0, 1);
		addEParameter(op, theQnmPackage.getCustomer(), "customer", 0, 1);

		initEClass(customerServerUsageEClass, CustomerServerUsage.class, "CustomerServerUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCustomerServerUsage_CustomerResult(), this.getCustomerResult(), this.getCustomerResult_ServerUsage(), "customerResult", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomerServerUsage_ServerResult(), this.getServerResult(), this.getServerResult_UsingCustomers(), "serverResult", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerServerUsage_CausedWaitingTime(), theQnmPackage.getManagedPDF(), "causedWaitingTime", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerServerUsage_CausedWaitingTimeOneLess(), theQnmPackage.getManagedPDF(), "causedWaitingTimeOneLess", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerServerUsage_QueueLength(), theQnmPackage.getManagedPMF(), "queueLength", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerServerUsage_QueueLengthOneLess(), theQnmPackage.getManagedPMF(), "queueLengthOneLess", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomerServerUsage_DemandsToServer(), this.getDemandResult(), null, "demandsToServer", null, 0, -1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerServerUsage_CustomerServiceTime(), theQnmPackage.getManagedPDF(), "customerServiceTime", null, 1, 1, CustomerServerUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerResultEClass, CustomerResult.class, "CustomerResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCustomerResult_Customer(), theQnmPackage.getCustomer(), null, "customer", null, 1, 1, CustomerResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomerResult_ServerUsage(), this.getCustomerServerUsage(), this.getCustomerServerUsage_CustomerResult(), "serverUsage", null, 0, -1, CustomerResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(customerResultEClass, this.getCustomerServerUsage(), "getServerUsage", 0, 1);
		addEParameter(op, theQnmPackage.getServer(), "server", 0, 1);

		initEClass(qnResultModelEClass, QNResultModel.class, "QNResultModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQNResultModel_CustomerServerUsage(), this.getCustomerServerUsage(), null, "customerServerUsage", null, 0, -1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNResultModel_QnModel(), theQnmPackage.getQNModel(), null, "qnModel", null, 1, 1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNResultModel_CustomerResults(), this.getCustomerResult(), null, "customerResults", null, 0, -1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNResultModel_ServerResults(), this.getServerResult(), null, "serverResults", null, 0, -1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNResultModel_DemandResults(), this.getDemandResult(), null, "demandResults", null, 0, -1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQNResultModel_DemandServerUsages(), this.getDemandServerUsage(), null, "demandServerUsages", null, 0, -1, QNResultModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(qnResultModelEClass, this.getServerResult(), "getResultForServer", 0, 1);
		addEParameter(op, theQnmPackage.getServer(), "server", 0, 1);

		op = addEOperation(qnResultModelEClass, this.getCustomerResult(), "getResultForCustomer", 0, 1);
		addEParameter(op, theQnmPackage.getCustomer(), "customer", 0, 1);

		op = addEOperation(qnResultModelEClass, this.getDemandResult(), "getResultForDemand", 0, 1);
		addEParameter(op, theQnmPackage.getDemand(), "demand", 0, 1);
	}

} //QNResultPackageImpl
