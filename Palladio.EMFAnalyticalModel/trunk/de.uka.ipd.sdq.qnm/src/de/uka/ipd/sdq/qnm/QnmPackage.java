/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.qnm.QnmFactory
 * @model kind="package"
 * @generated
 */
public interface QnmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qnm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/QueueingNetworkModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qnm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QnmPackage eINSTANCE = de.uka.ipd.sdq.qnm.impl.QnmPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl <em>QN Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.QNModelImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getQNModel()
	 * @generated
	 */
	int QN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL__CUSTOMERS = 0;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL__SERVERS = 1;

	/**
	 * The feature id for the '<em><b>INFINITE</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL__INFINITE = 2;

	/**
	 * The number of structural features of the '<em>QN Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.CustomerImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NAME = 2;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.DemandImpl <em>Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.DemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDemand()
	 * @generated
	 */
	int DEMAND = 2;

	/**
	 * The number of structural features of the '<em>Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.ServerImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 3;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.DeviceServerImpl <em>Device Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.DeviceServerImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDeviceServer()
	 * @generated
	 */
	int DEVICE_SERVER = 4;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_SERVER__NUMBER = SERVER__NUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_SERVER__NAME = SERVER__NAME;

	/**
	 * The number of structural features of the '<em>Device Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_SERVER_FEATURE_COUNT = SERVER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.LogicalServerImpl <em>Logical Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.LogicalServerImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getLogicalServer()
	 * @generated
	 */
	int LOGICAL_SERVER = 5;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_SERVER__NUMBER = SERVER__NUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_SERVER__NAME = SERVER__NAME;

	/**
	 * The number of structural features of the '<em>Logical Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_SERVER_FEATURE_COUNT = SERVER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl <em>Logical Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getLogicalDemand()
	 * @generated
	 */
	int LOGICAL_DEMAND = 6;

	/**
	 * The feature id for the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_DEMAND__LOGICALSERVER = DEMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Demands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_DEMAND__DEMANDS = DEMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Logical Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_DEMAND_FEATURE_COUNT = DEMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl <em>Device Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDeviceDemand()
	 * @generated
	 */
	int DEVICE_DEMAND = 7;

	/**
	 * The feature id for the '<em><b>Device Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_DEMAND__DEVICE_SERVER = DEMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_DEMAND__SERVICE_TIME = DEMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Device Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_DEMAND_FEATURE_COUNT = DEMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.SequentialDemandImpl <em>Sequential Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.SequentialDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getSequentialDemand()
	 * @generated
	 */
	int SEQUENTIAL_DEMAND = 8;

	/**
	 * The feature id for the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_DEMAND__LOGICALSERVER = LOGICAL_DEMAND__LOGICALSERVER;

	/**
	 * The feature id for the '<em><b>Demands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_DEMAND__DEMANDS = LOGICAL_DEMAND__DEMANDS;

	/**
	 * The number of structural features of the '<em>Sequential Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_DEMAND_FEATURE_COUNT = LOGICAL_DEMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.AlternativeDemandImpl <em>Alternative Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.AlternativeDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getAlternativeDemand()
	 * @generated
	 */
	int ALTERNATIVE_DEMAND = 9;

	/**
	 * The feature id for the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_DEMAND__LOGICALSERVER = LOGICAL_DEMAND__LOGICALSERVER;

	/**
	 * The feature id for the '<em><b>Demands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_DEMAND__DEMANDS = LOGICAL_DEMAND__DEMANDS;

	/**
	 * The number of structural features of the '<em>Alternative Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_DEMAND_FEATURE_COUNT = LOGICAL_DEMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.IterativeDemandImpl <em>Iterative Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.IterativeDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getIterativeDemand()
	 * @generated
	 */
	int ITERATIVE_DEMAND = 10;

	/**
	 * The feature id for the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_DEMAND__LOGICALSERVER = LOGICAL_DEMAND__LOGICALSERVER;

	/**
	 * The feature id for the '<em><b>Demands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_DEMAND__DEMANDS = LOGICAL_DEMAND__DEMANDS;

	/**
	 * The number of structural features of the '<em>Iterative Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_DEMAND_FEATURE_COUNT = LOGICAL_DEMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.ParallelDemandImpl <em>Parallel Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.ParallelDemandImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getParallelDemand()
	 * @generated
	 */
	int PARALLEL_DEMAND = 11;

	/**
	 * The feature id for the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_DEMAND__LOGICALSERVER = LOGICAL_DEMAND__LOGICALSERVER;

	/**
	 * The feature id for the '<em><b>Demands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_DEMAND__DEMANDS = LOGICAL_DEMAND__DEMANDS;

	/**
	 * The number of structural features of the '<em>Parallel Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_DEMAND_FEATURE_COUNT = LOGICAL_DEMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>Managed PDF</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPDF
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getManagedPDF()
	 * @generated
	 */
	int MANAGED_PDF = 12;

	/**
	 * The meta object id for the '<em>Managed PMF</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPMF
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getManagedPMF()
	 * @generated
	 */
	int MANAGED_PMF = 13;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.QNModel <em>QN Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QN Model</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel
	 * @generated
	 */
	EClass getQNModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.QNModel#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel#getCustomers()
	 * @see #getQNModel()
	 * @generated
	 */
	EReference getQNModel_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.QNModel#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servers</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel#getServers()
	 * @see #getQNModel()
	 * @generated
	 */
	EReference getQNModel_Servers();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.QNModel#getINFINITE <em>INFINITE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>INFINITE</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel#getINFINITE()
	 * @see #getQNModel()
	 * @generated
	 */
	EAttribute getQNModel_INFINITE();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see de.uka.ipd.sdq.qnm.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Customer#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.uka.ipd.sdq.qnm.Customer#getNumber()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Number();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.qnm.Customer#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.Customer#getDemand()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Demand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Customer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.qnm.Customer#getName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.Demand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.Demand
	 * @generated
	 */
	EClass getDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Server#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.uka.ipd.sdq.qnm.Server#getNumber()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Number();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Server#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.qnm.Server#getName()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.DeviceServer <em>Device Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.DeviceServer
	 * @generated
	 */
	EClass getDeviceServer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.LogicalServer <em>Logical Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.LogicalServer
	 * @generated
	 */
	EClass getLogicalServer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.LogicalDemand <em>Logical Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.LogicalDemand
	 * @generated
	 */
	EClass getLogicalDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.LogicalDemand#getLogicalserver <em>Logicalserver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Logicalserver</em>'.
	 * @see de.uka.ipd.sdq.qnm.LogicalDemand#getLogicalserver()
	 * @see #getLogicalDemand()
	 * @generated
	 */
	EReference getLogicalDemand_Logicalserver();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.LogicalDemand#getDemands <em>Demands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Demands</em>'.
	 * @see de.uka.ipd.sdq.qnm.LogicalDemand#getDemands()
	 * @see #getLogicalDemand()
	 * @generated
	 */
	EReference getLogicalDemand_Demands();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.DeviceDemand <em>Device Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.DeviceDemand
	 * @generated
	 */
	EClass getDeviceDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.DeviceDemand#getDeviceServer <em>Device Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Device Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.DeviceDemand#getDeviceServer()
	 * @see #getDeviceDemand()
	 * @generated
	 */
	EReference getDeviceDemand_DeviceServer();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.DeviceDemand#getServiceTime <em>Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.DeviceDemand#getServiceTime()
	 * @see #getDeviceDemand()
	 * @generated
	 */
	EAttribute getDeviceDemand_ServiceTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.SequentialDemand <em>Sequential Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequential Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.SequentialDemand
	 * @generated
	 */
	EClass getSequentialDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.AlternativeDemand <em>Alternative Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.AlternativeDemand
	 * @generated
	 */
	EClass getAlternativeDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.IterativeDemand <em>Iterative Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterative Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.IterativeDemand
	 * @generated
	 */
	EClass getIterativeDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.ParallelDemand <em>Parallel Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.ParallelDemand
	 * @generated
	 */
	EClass getParallelDemand();

	/**
	 * Returns the meta object for data type '{@link de.uka.ipd.sdq.probfunction.math.ManagedPDF <em>Managed PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Managed PDF</em>'.
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPDF
	 * @model instanceClass="de.uka.ipd.sdq.probfunction.math.ManagedPDF"
	 *        extendedMetaData="name='ManagedPDF'" 
	 * @generated
	 */
	EDataType getManagedPDF();

	/**
	 * Returns the meta object for data type '{@link de.uka.ipd.sdq.probfunction.math.ManagedPMF <em>Managed PMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Managed PMF</em>'.
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPMF
	 * @model instanceClass="de.uka.ipd.sdq.probfunction.math.ManagedPMF"
	 *        extendedMetaData="name='ManagedPMF'" 
	 * @generated
	 */
	EDataType getManagedPMF();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QnmFactory getQnmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl <em>QN Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.QNModelImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getQNModel()
		 * @generated
		 */
		EClass QN_MODEL = eINSTANCE.getQNModel();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_MODEL__CUSTOMERS = eINSTANCE.getQNModel_Customers();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_MODEL__SERVERS = eINSTANCE.getQNModel_Servers();

		/**
		 * The meta object literal for the '<em><b>INFINITE</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QN_MODEL__INFINITE = eINSTANCE.getQNModel_INFINITE();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.CustomerImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NUMBER = eINSTANCE.getCustomer_Number();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__DEMAND = eINSTANCE.getCustomer_Demand();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NAME = eINSTANCE.getCustomer_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.DemandImpl <em>Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.DemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDemand()
		 * @generated
		 */
		EClass DEMAND = eINSTANCE.getDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.ServerImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__NUMBER = eINSTANCE.getServer_Number();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__NAME = eINSTANCE.getServer_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.DeviceServerImpl <em>Device Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.DeviceServerImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDeviceServer()
		 * @generated
		 */
		EClass DEVICE_SERVER = eINSTANCE.getDeviceServer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.LogicalServerImpl <em>Logical Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.LogicalServerImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getLogicalServer()
		 * @generated
		 */
		EClass LOGICAL_SERVER = eINSTANCE.getLogicalServer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl <em>Logical Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getLogicalDemand()
		 * @generated
		 */
		EClass LOGICAL_DEMAND = eINSTANCE.getLogicalDemand();

		/**
		 * The meta object literal for the '<em><b>Logicalserver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_DEMAND__LOGICALSERVER = eINSTANCE.getLogicalDemand_Logicalserver();

		/**
		 * The meta object literal for the '<em><b>Demands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_DEMAND__DEMANDS = eINSTANCE.getLogicalDemand_Demands();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl <em>Device Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getDeviceDemand()
		 * @generated
		 */
		EClass DEVICE_DEMAND = eINSTANCE.getDeviceDemand();

		/**
		 * The meta object literal for the '<em><b>Device Server</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_DEMAND__DEVICE_SERVER = eINSTANCE.getDeviceDemand_DeviceServer();

		/**
		 * The meta object literal for the '<em><b>Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_DEMAND__SERVICE_TIME = eINSTANCE.getDeviceDemand_ServiceTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.SequentialDemandImpl <em>Sequential Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.SequentialDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getSequentialDemand()
		 * @generated
		 */
		EClass SEQUENTIAL_DEMAND = eINSTANCE.getSequentialDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.AlternativeDemandImpl <em>Alternative Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.AlternativeDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getAlternativeDemand()
		 * @generated
		 */
		EClass ALTERNATIVE_DEMAND = eINSTANCE.getAlternativeDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.IterativeDemandImpl <em>Iterative Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.IterativeDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getIterativeDemand()
		 * @generated
		 */
		EClass ITERATIVE_DEMAND = eINSTANCE.getIterativeDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.ParallelDemandImpl <em>Parallel Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.ParallelDemandImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getParallelDemand()
		 * @generated
		 */
		EClass PARALLEL_DEMAND = eINSTANCE.getParallelDemand();

		/**
		 * The meta object literal for the '<em>Managed PDF</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.math.ManagedPDF
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getManagedPDF()
		 * @generated
		 */
		EDataType MANAGED_PDF = eINSTANCE.getManagedPDF();

		/**
		 * The meta object literal for the '<em>Managed PMF</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.math.ManagedPMF
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getManagedPMF()
		 * @generated
		 */
		EDataType MANAGED_PMF = eINSTANCE.getManagedPMF();

	}

} //QnmPackage
