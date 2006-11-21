/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

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
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ResultmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resultmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/QueueingNetworkModel/ResultModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resultmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultmodelPackage eINSTANCE = de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl <em>QNM Result Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getQNMResultModel()
	 * @generated
	 */
	int QNM_RESULT_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Qnmodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL__QNMODEL = 0;

	/**
	 * The feature id for the '<em><b>Resource Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL__RESOURCE_RESULTS = 1;

	/**
	 * The feature id for the '<em><b>Task Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL__TASK_RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Taskresourceusages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL__TASKRESOURCEUSAGES = 3;

	/**
	 * The feature id for the '<em><b>Resource Usage Times</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES = 4;

	/**
	 * The number of structural features of the '<em>QNM Result Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNM_RESULT_MODEL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl <em>Resource Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getResourceResult()
	 * @generated
	 */
	int RESOURCE_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESULT__RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Taskresourceusages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESULT__TASKRESOURCEUSAGES = 1;

	/**
	 * The number of structural features of the '<em>Resource Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESULT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl <em>Task Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getTaskResourceUsage()
	 * @generated
	 */
	int TASK_RESOURCE_USAGE = 2;

	/**
	 * The feature id for the '<em><b>Queue Length One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS = 0;

	/**
	 * The feature id for the '<em><b>Queue Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__QUEUE_LENGTH = 1;

	/**
	 * The feature id for the '<em><b>Task Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__TASK_SERVICE_TIME = 2;

	/**
	 * The feature id for the '<em><b>Waiting Time One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS = 3;

	/**
	 * The feature id for the '<em><b>Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__WAITING_TIME = 4;

	/**
	 * The feature id for the '<em><b>Taskresult</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__TASKRESULT = 5;

	/**
	 * The feature id for the '<em><b>Resource Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE__RESOURCE_RESULT = 6;

	/**
	 * The number of structural features of the '<em>Task Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESOURCE_USAGE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl <em>Task Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getTaskResult()
	 * @generated
	 */
	int TASK_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESULT__TASK = 0;

	/**
	 * The feature id for the '<em><b>Taskresourceusages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESULT__TASKRESOURCEUSAGES = 1;

	/**
	 * The number of structural features of the '<em>Task Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_RESULT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl <em>Resource Usage Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getResourceUsageTime()
	 * @generated
	 */
	int RESOURCE_USAGE_TIME = 4;

	/**
	 * The feature id for the '<em><b>Resource Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_TIME__RESOURCE_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_TIME__SERVICE_TIME = 1;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_TIME__RESPONSE_TIME = 2;

	/**
	 * The feature id for the '<em><b>Service Time Break Down</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN = 3;

	/**
	 * The number of structural features of the '<em>Resource Usage Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_TIME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl <em>Service Time Break Down</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getServiceTimeBreakDown()
	 * @generated
	 */
	int SERVICE_TIME_BREAK_DOWN = 5;

	/**
	 * The feature id for the '<em><b>Usage Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Usage Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TIME_BREAK_DOWN__USAGE_TIME = 1;

	/**
	 * The feature id for the '<em><b>Used Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TIME_BREAK_DOWN__USED_RESOURCE = 2;

	/**
	 * The number of structural features of the '<em>Service Time Break Down</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TIME_BREAK_DOWN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '<em>Managed PMF</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPMF
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getManagedPMF()
	 * @generated
	 */
	int MANAGED_PMF = 6;

	/**
	 * The meta object id for the '<em>Managed PDF</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.math.ManagedPDF
	 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getManagedPDF()
	 * @generated
	 */
	int MANAGED_PDF = 7;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel <em>QNM Result Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QNM Result Model</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel
	 * @generated
	 */
	EClass getQNMResultModel();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getQnmodel <em>Qnmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Qnmodel</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getQnmodel()
	 * @see #getQNMResultModel()
	 * @generated
	 */
	EReference getQNMResultModel_Qnmodel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceResults <em>Resource Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Results</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceResults()
	 * @see #getQNMResultModel()
	 * @generated
	 */
	EReference getQNMResultModel_ResourceResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskResults <em>Task Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Results</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskResults()
	 * @see #getQNMResultModel()
	 * @generated
	 */
	EReference getQNMResultModel_TaskResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskresourceusages <em>Taskresourceusages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Taskresourceusages</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskresourceusages()
	 * @see #getQNMResultModel()
	 * @generated
	 */
	EReference getQNMResultModel_Taskresourceusages();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceUsageTimes <em>Resource Usage Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Usage Times</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceUsageTimes()
	 * @see #getQNMResultModel()
	 * @generated
	 */
	EReference getQNMResultModel_ResourceUsageTimes();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult <em>Resource Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceResult
	 * @generated
	 */
	EClass getResourceResult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getResource()
	 * @see #getResourceResult()
	 * @generated
	 */
	EReference getResourceResult_Resource();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getTaskresourceusages <em>Taskresourceusages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Taskresourceusages</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getTaskresourceusages()
	 * @see #getResourceResult()
	 * @generated
	 */
	EReference getResourceResult_Taskresourceusages();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage <em>Task Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage
	 * @generated
	 */
	EClass getTaskResourceUsage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Length One Less</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLengthOneLess()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EAttribute getTaskResourceUsage_QueueLengthOneLess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLength <em>Queue Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Length</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLength()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EAttribute getTaskResourceUsage_QueueLength();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskServiceTime <em>Task Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Service Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskServiceTime()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EAttribute getTaskResourceUsage_TaskServiceTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTimeOneLess <em>Waiting Time One Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Waiting Time One Less</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTimeOneLess()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EAttribute getTaskResourceUsage_WaitingTimeOneLess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTime <em>Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Waiting Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTime()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EAttribute getTaskResourceUsage_WaitingTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskresult <em>Taskresult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Taskresult</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskresult()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EReference getTaskResourceUsage_Taskresult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResourceResult <em>Resource Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResourceResult()
	 * @see #getTaskResourceUsage()
	 * @generated
	 */
	EReference getTaskResourceUsage_ResourceResult();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult <em>Task Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Result</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResult
	 * @generated
	 */
	EClass getTaskResult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Task</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTask()
	 * @see #getTaskResult()
	 * @generated
	 */
	EReference getTaskResult_Task();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTaskresourceusages <em>Taskresourceusages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Taskresourceusages</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTaskresourceusages()
	 * @see #getTaskResult()
	 * @generated
	 */
	EReference getTaskResult_Taskresourceusages();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime <em>Resource Usage Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Usage Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime
	 * @generated
	 */
	EClass getResourceUsageTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResourceUsage()
	 * @see #getResourceUsageTime()
	 * @generated
	 */
	EReference getResourceUsageTime_ResourceUsage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTime <em>Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTime()
	 * @see #getResourceUsageTime()
	 * @generated
	 */
	EAttribute getResourceUsageTime_ServiceTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResponseTime()
	 * @see #getResourceUsageTime()
	 * @generated
	 */
	EAttribute getResourceUsageTime_ResponseTime();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTimeBreakDown <em>Service Time Break Down</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Time Break Down</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTimeBreakDown()
	 * @see #getResourceUsageTime()
	 * @generated
	 */
	EReference getResourceUsageTime_ServiceTimeBreakDown();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown <em>Service Time Break Down</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Time Break Down</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown
	 * @generated
	 */
	EClass getServiceTimeBreakDown();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageProbability <em>Usage Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Probability</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageProbability()
	 * @see #getServiceTimeBreakDown()
	 * @generated
	 */
	EAttribute getServiceTimeBreakDown_UsageProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageTime <em>Usage Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Time</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageTime()
	 * @see #getServiceTimeBreakDown()
	 * @generated
	 */
	EAttribute getServiceTimeBreakDown_UsageTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsedResource <em>Used Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Resource</em>'.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsedResource()
	 * @see #getServiceTimeBreakDown()
	 * @generated
	 */
	EReference getServiceTimeBreakDown_UsedResource();

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
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResultmodelFactory getResultmodelFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl <em>QNM Result Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getQNMResultModel()
		 * @generated
		 */
		EClass QNM_RESULT_MODEL = eINSTANCE.getQNMResultModel();

		/**
		 * The meta object literal for the '<em><b>Qnmodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QNM_RESULT_MODEL__QNMODEL = eINSTANCE.getQNMResultModel_Qnmodel();

		/**
		 * The meta object literal for the '<em><b>Resource Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QNM_RESULT_MODEL__RESOURCE_RESULTS = eINSTANCE.getQNMResultModel_ResourceResults();

		/**
		 * The meta object literal for the '<em><b>Task Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QNM_RESULT_MODEL__TASK_RESULTS = eINSTANCE.getQNMResultModel_TaskResults();

		/**
		 * The meta object literal for the '<em><b>Taskresourceusages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QNM_RESULT_MODEL__TASKRESOURCEUSAGES = eINSTANCE.getQNMResultModel_Taskresourceusages();

		/**
		 * The meta object literal for the '<em><b>Resource Usage Times</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES = eINSTANCE.getQNMResultModel_ResourceUsageTimes();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl <em>Resource Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getResourceResult()
		 * @generated
		 */
		EClass RESOURCE_RESULT = eINSTANCE.getResourceResult();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_RESULT__RESOURCE = eINSTANCE.getResourceResult_Resource();

		/**
		 * The meta object literal for the '<em><b>Taskresourceusages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_RESULT__TASKRESOURCEUSAGES = eINSTANCE.getResourceResult_Taskresourceusages();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl <em>Task Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getTaskResourceUsage()
		 * @generated
		 */
		EClass TASK_RESOURCE_USAGE = eINSTANCE.getTaskResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Queue Length One Less</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS = eINSTANCE.getTaskResourceUsage_QueueLengthOneLess();

		/**
		 * The meta object literal for the '<em><b>Queue Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_RESOURCE_USAGE__QUEUE_LENGTH = eINSTANCE.getTaskResourceUsage_QueueLength();

		/**
		 * The meta object literal for the '<em><b>Task Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_RESOURCE_USAGE__TASK_SERVICE_TIME = eINSTANCE.getTaskResourceUsage_TaskServiceTime();

		/**
		 * The meta object literal for the '<em><b>Waiting Time One Less</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS = eINSTANCE.getTaskResourceUsage_WaitingTimeOneLess();

		/**
		 * The meta object literal for the '<em><b>Waiting Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_RESOURCE_USAGE__WAITING_TIME = eINSTANCE.getTaskResourceUsage_WaitingTime();

		/**
		 * The meta object literal for the '<em><b>Taskresult</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_RESOURCE_USAGE__TASKRESULT = eINSTANCE.getTaskResourceUsage_Taskresult();

		/**
		 * The meta object literal for the '<em><b>Resource Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_RESOURCE_USAGE__RESOURCE_RESULT = eINSTANCE.getTaskResourceUsage_ResourceResult();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl <em>Task Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getTaskResult()
		 * @generated
		 */
		EClass TASK_RESULT = eINSTANCE.getTaskResult();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_RESULT__TASK = eINSTANCE.getTaskResult_Task();

		/**
		 * The meta object literal for the '<em><b>Taskresourceusages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_RESULT__TASKRESOURCEUSAGES = eINSTANCE.getTaskResult_Taskresourceusages();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl <em>Resource Usage Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getResourceUsageTime()
		 * @generated
		 */
		EClass RESOURCE_USAGE_TIME = eINSTANCE.getResourceUsageTime();

		/**
		 * The meta object literal for the '<em><b>Resource Usage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE_TIME__RESOURCE_USAGE = eINSTANCE.getResourceUsageTime_ResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE_TIME__SERVICE_TIME = eINSTANCE.getResourceUsageTime_ServiceTime();

		/**
		 * The meta object literal for the '<em><b>Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE_TIME__RESPONSE_TIME = eINSTANCE.getResourceUsageTime_ResponseTime();

		/**
		 * The meta object literal for the '<em><b>Service Time Break Down</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN = eINSTANCE.getResourceUsageTime_ServiceTimeBreakDown();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl <em>Service Time Break Down</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getServiceTimeBreakDown()
		 * @generated
		 */
		EClass SERVICE_TIME_BREAK_DOWN = eINSTANCE.getServiceTimeBreakDown();

		/**
		 * The meta object literal for the '<em><b>Usage Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY = eINSTANCE.getServiceTimeBreakDown_UsageProbability();

		/**
		 * The meta object literal for the '<em><b>Usage Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TIME_BREAK_DOWN__USAGE_TIME = eINSTANCE.getServiceTimeBreakDown_UsageTime();

		/**
		 * The meta object literal for the '<em><b>Used Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_TIME_BREAK_DOWN__USED_RESOURCE = eINSTANCE.getServiceTimeBreakDown_UsedResource();

		/**
		 * The meta object literal for the '<em>Managed PMF</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.math.ManagedPMF
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getManagedPMF()
		 * @generated
		 */
		EDataType MANAGED_PMF = eINSTANCE.getManagedPMF();

		/**
		 * The meta object literal for the '<em>Managed PDF</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.math.ManagedPDF
		 * @see de.uka.ipd.sdq.qnm.resultmodel.impl.ResultmodelPackageImpl#getManagedPDF()
		 * @generated
		 */
		EDataType MANAGED_PDF = eINSTANCE.getManagedPDF();

	}

} //ResultmodelPackage
