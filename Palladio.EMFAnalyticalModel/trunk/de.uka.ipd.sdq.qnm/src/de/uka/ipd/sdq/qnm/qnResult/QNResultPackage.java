/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultFactory
 * @model kind="package"
 * @generated
 */
public interface QNResultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qnResult";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/QueueingNetworkModel/QNResult/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qnm.qnResult";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QNResultPackage eINSTANCE = de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl <em>Demand Server Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getDemandServerUsage()
	 * @generated
	 */
	int DEMAND_SERVER_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_SERVER_USAGE__DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_SERVER_USAGE__SERVER = 1;

	/**
	 * The feature id for the '<em><b>Usage Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_SERVER_USAGE__USAGE_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Mean Usage Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_SERVER_USAGE__MEAN_USAGE_TIME = 3;

	/**
	 * The number of structural features of the '<em>Demand Server Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_SERVER_USAGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl <em>Demand Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getDemandResult()
	 * @generated
	 */
	int DEMAND_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_RESULT__RESPONSE_TIME = 0;

	/**
	 * The feature id for the '<em><b>Server Usages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_RESULT__SERVER_USAGES = 1;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_RESULT__DEMAND = 2;

	/**
	 * The feature id for the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_RESULT__SERVICE_TIME = 3;

	/**
	 * The number of structural features of the '<em>Demand Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_RESULT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl <em>Server Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getServerResult()
	 * @generated
	 */
	int SERVER_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Using Customers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_RESULT__USING_CUSTOMERS = 0;

	/**
	 * The feature id for the '<em><b>Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_RESULT__SERVER = 1;

	/**
	 * The feature id for the '<em><b>Usage Demands</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_RESULT__USAGE_DEMANDS = 2;

	/**
	 * The number of structural features of the '<em>Server Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl <em>Customer Server Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getCustomerServerUsage()
	 * @generated
	 */
	int CUSTOMER_SERVER_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Customer Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Server Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__SERVER_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Caused Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME = 2;

	/**
	 * The feature id for the '<em><b>Caused Waiting Time One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS = 3;

	/**
	 * The feature id for the '<em><b>Queue Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__QUEUE_LENGTH = 4;

	/**
	 * The feature id for the '<em><b>Queue Length One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS = 5;

	/**
	 * The feature id for the '<em><b>Demands To Server</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER = 6;

	/**
	 * The feature id for the '<em><b>Customer Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME = 7;

	/**
	 * The number of structural features of the '<em>Customer Server Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SERVER_USAGE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerResultImpl <em>Customer Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.CustomerResultImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getCustomerResult()
	 * @generated
	 */
	int CUSTOMER_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_RESULT__CUSTOMER = 0;

	/**
	 * The feature id for the '<em><b>Server Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_RESULT__SERVER_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Customer Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_RESULT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl
	 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getQNResultModel()
	 * @generated
	 */
	int QN_RESULT_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Customer Server Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Qn Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__QN_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Customer Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__CUSTOMER_RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Server Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__SERVER_RESULTS = 3;

	/**
	 * The feature id for the '<em><b>Demand Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__DEMAND_RESULTS = 4;

	/**
	 * The feature id for the '<em><b>Demand Server Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL__DEMAND_SERVER_USAGES = 5;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_RESULT_MODEL_FEATURE_COUNT = 6;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage <em>Demand Server Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand Server Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage
	 * @generated
	 */
	EClass getDemandServerUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand()
	 * @see #getDemandServerUsage()
	 * @generated
	 */
	EReference getDemandServerUsage_Demand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer()
	 * @see #getDemandServerUsage()
	 * @generated
	 */
	EReference getDemandServerUsage_Server();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getUsageProbability <em>Usage Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Probability</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getUsageProbability()
	 * @see #getDemandServerUsage()
	 * @generated
	 */
	EAttribute getDemandServerUsage_UsageProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getMeanUsageTime <em>Mean Usage Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean Usage Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getMeanUsageTime()
	 * @see #getDemandServerUsage()
	 * @generated
	 */
	EAttribute getDemandServerUsage_MeanUsageTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult <em>Demand Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult
	 * @generated
	 */
	EClass getDemandResult();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult#getResponseTime()
	 * @see #getDemandResult()
	 * @generated
	 */
	EAttribute getDemandResult_ResponseTime();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServerUsages <em>Server Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Server Usages</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServerUsages()
	 * @see #getDemandResult()
	 * @generated
	 */
	EReference getDemandResult_ServerUsages();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult#getDemand()
	 * @see #getDemandResult()
	 * @generated
	 */
	EReference getDemandResult_Demand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServiceTime <em>Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServiceTime()
	 * @see #getDemandResult()
	 * @generated
	 */
	EAttribute getDemandResult_ServiceTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult <em>Server Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult
	 * @generated
	 */
	EClass getServerResult();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsingCustomers <em>Using Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Using Customers</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsingCustomers()
	 * @see #getServerResult()
	 * @generated
	 */
	EReference getServerResult_UsingCustomers();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult#getServer()
	 * @see #getServerResult()
	 * @generated
	 */
	EReference getServerResult_Server();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsageDemands <em>Usage Demands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Usage Demands</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsageDemands()
	 * @see #getServerResult()
	 * @generated
	 */
	EReference getServerResult_UsageDemands();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage <em>Customer Server Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Server Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage
	 * @generated
	 */
	EClass getCustomerServerUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult <em>Customer Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EReference getCustomerServerUsage_CustomerResult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult <em>Server Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EReference getCustomerServerUsage_ServerResult();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTime <em>Caused Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caused Waiting Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTime()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EAttribute getCustomerServerUsage_CausedWaitingTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTimeOneLess <em>Caused Waiting Time One Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caused Waiting Time One Less</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTimeOneLess()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EAttribute getCustomerServerUsage_CausedWaitingTimeOneLess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLength <em>Queue Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Length</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLength()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EAttribute getCustomerServerUsage_QueueLength();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Length One Less</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLengthOneLess()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EAttribute getCustomerServerUsage_QueueLengthOneLess();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getDemandsToServer <em>Demands To Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Demands To Server</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getDemandsToServer()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EReference getCustomerServerUsage_DemandsToServer();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerServiceTime <em>Customer Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Service Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerServiceTime()
	 * @see #getCustomerServerUsage()
	 * @generated
	 */
	EAttribute getCustomerServerUsage_CustomerServiceTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult <em>Customer Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerResult
	 * @generated
	 */
	EClass getCustomerResult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getCustomer()
	 * @see #getCustomerResult()
	 * @generated
	 */
	EReference getCustomerResult_Customer();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getServerUsage <em>Server Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Server Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getServerUsage()
	 * @see #getCustomerResult()
	 * @generated
	 */
	EReference getCustomerResult_ServerUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel
	 * @generated
	 */
	EClass getQNResultModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerServerUsage <em>Customer Server Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customer Server Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerServerUsage()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_CustomerServerUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getQnModel <em>Qn Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Qn Model</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getQnModel()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_QnModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerResults <em>Customer Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customer Results</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerResults()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_CustomerResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getServerResults <em>Server Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Server Results</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getServerResults()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_ServerResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandResults <em>Demand Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Demand Results</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandResults()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_DemandResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandServerUsages <em>Demand Server Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Demand Server Usages</em>'.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandServerUsages()
	 * @see #getQNResultModel()
	 * @generated
	 */
	EReference getQNResultModel_DemandServerUsages();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QNResultFactory getQNResultFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl <em>Demand Server Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getDemandServerUsage()
		 * @generated
		 */
		EClass DEMAND_SERVER_USAGE = eINSTANCE.getDemandServerUsage();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_SERVER_USAGE__DEMAND = eINSTANCE.getDemandServerUsage_Demand();

		/**
		 * The meta object literal for the '<em><b>Server</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_SERVER_USAGE__SERVER = eINSTANCE.getDemandServerUsage_Server();

		/**
		 * The meta object literal for the '<em><b>Usage Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEMAND_SERVER_USAGE__USAGE_PROBABILITY = eINSTANCE.getDemandServerUsage_UsageProbability();

		/**
		 * The meta object literal for the '<em><b>Mean Usage Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEMAND_SERVER_USAGE__MEAN_USAGE_TIME = eINSTANCE.getDemandServerUsage_MeanUsageTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl <em>Demand Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getDemandResult()
		 * @generated
		 */
		EClass DEMAND_RESULT = eINSTANCE.getDemandResult();

		/**
		 * The meta object literal for the '<em><b>Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEMAND_RESULT__RESPONSE_TIME = eINSTANCE.getDemandResult_ResponseTime();

		/**
		 * The meta object literal for the '<em><b>Server Usages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_RESULT__SERVER_USAGES = eINSTANCE.getDemandResult_ServerUsages();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_RESULT__DEMAND = eINSTANCE.getDemandResult_Demand();

		/**
		 * The meta object literal for the '<em><b>Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEMAND_RESULT__SERVICE_TIME = eINSTANCE.getDemandResult_ServiceTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl <em>Server Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getServerResult()
		 * @generated
		 */
		EClass SERVER_RESULT = eINSTANCE.getServerResult();

		/**
		 * The meta object literal for the '<em><b>Using Customers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_RESULT__USING_CUSTOMERS = eINSTANCE.getServerResult_UsingCustomers();

		/**
		 * The meta object literal for the '<em><b>Server</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_RESULT__SERVER = eINSTANCE.getServerResult_Server();

		/**
		 * The meta object literal for the '<em><b>Usage Demands</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_RESULT__USAGE_DEMANDS = eINSTANCE.getServerResult_UsageDemands();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl <em>Customer Server Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getCustomerServerUsage()
		 * @generated
		 */
		EClass CUSTOMER_SERVER_USAGE = eINSTANCE.getCustomerServerUsage();

		/**
		 * The meta object literal for the '<em><b>Customer Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT = eINSTANCE.getCustomerServerUsage_CustomerResult();

		/**
		 * The meta object literal for the '<em><b>Server Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_SERVER_USAGE__SERVER_RESULT = eINSTANCE.getCustomerServerUsage_ServerResult();

		/**
		 * The meta object literal for the '<em><b>Caused Waiting Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME = eINSTANCE.getCustomerServerUsage_CausedWaitingTime();

		/**
		 * The meta object literal for the '<em><b>Caused Waiting Time One Less</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS = eINSTANCE.getCustomerServerUsage_CausedWaitingTimeOneLess();

		/**
		 * The meta object literal for the '<em><b>Queue Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SERVER_USAGE__QUEUE_LENGTH = eINSTANCE.getCustomerServerUsage_QueueLength();

		/**
		 * The meta object literal for the '<em><b>Queue Length One Less</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS = eINSTANCE.getCustomerServerUsage_QueueLengthOneLess();

		/**
		 * The meta object literal for the '<em><b>Demands To Server</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER = eINSTANCE.getCustomerServerUsage_DemandsToServer();

		/**
		 * The meta object literal for the '<em><b>Customer Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME = eINSTANCE.getCustomerServerUsage_CustomerServiceTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerResultImpl <em>Customer Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.CustomerResultImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getCustomerResult()
		 * @generated
		 */
		EClass CUSTOMER_RESULT = eINSTANCE.getCustomerResult();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_RESULT__CUSTOMER = eINSTANCE.getCustomerResult_Customer();

		/**
		 * The meta object literal for the '<em><b>Server Usage</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_RESULT__SERVER_USAGE = eINSTANCE.getCustomerResult_ServerUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl
		 * @see de.uka.ipd.sdq.qnm.qnResult.impl.QNResultPackageImpl#getQNResultModel()
		 * @generated
		 */
		EClass QN_RESULT_MODEL = eINSTANCE.getQNResultModel();

		/**
		 * The meta object literal for the '<em><b>Customer Server Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE = eINSTANCE.getQNResultModel_CustomerServerUsage();

		/**
		 * The meta object literal for the '<em><b>Qn Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__QN_MODEL = eINSTANCE.getQNResultModel_QnModel();

		/**
		 * The meta object literal for the '<em><b>Customer Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__CUSTOMER_RESULTS = eINSTANCE.getQNResultModel_CustomerResults();

		/**
		 * The meta object literal for the '<em><b>Server Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__SERVER_RESULTS = eINSTANCE.getQNResultModel_ServerResults();

		/**
		 * The meta object literal for the '<em><b>Demand Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__DEMAND_RESULTS = eINSTANCE.getQNResultModel_DemandResults();

		/**
		 * The meta object literal for the '<em><b>Demand Server Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_RESULT_MODEL__DEMAND_SERVER_USAGES = eINSTANCE.getQNResultModel_DemandServerUsages();

	}

} //QNResultPackage
