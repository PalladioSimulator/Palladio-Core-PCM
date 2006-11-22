/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getQueueLengthOneLess <em>Queue Length One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getQueueLength <em>Queue Length</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getTaskServiceTime <em>Task Service Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getWaitingTimeOneLess <em>Waiting Time One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getTaskResult <em>Task Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getResourceResult <em>Resource Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskResourceUsageImpl extends EObjectImpl implements TaskResourceUsage {
	/**
	 * The default value of the '{@link #getQueueLengthOneLess() <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLengthOneLess()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPMF QUEUE_LENGTH_ONE_LESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueLengthOneLess() <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLengthOneLess()
	 * @generated
	 * @ordered
	 */
	protected ManagedPMF queueLengthOneLess = QUEUE_LENGTH_ONE_LESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueLength() <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLength()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPMF QUEUE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueLength() <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLength()
	 * @generated
	 * @ordered
	 */
	protected ManagedPMF queueLength = QUEUE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskServiceTime() <em>Task Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskServiceTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF TASK_SERVICE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskServiceTime() <em>Task Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskServiceTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF taskServiceTime = TASK_SERVICE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWaitingTimeOneLess() <em>Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTimeOneLess()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF WAITING_TIME_ONE_LESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWaitingTimeOneLess() <em>Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTimeOneLess()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF waitingTimeOneLess = WAITING_TIME_ONE_LESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF WAITING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF waitingTime = WAITING_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaskResult() <em>Task Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskResult()
	 * @generated
	 * @ordered
	 */
	protected Task taskResult = null;

	/**
	 * The cached value of the '{@link #getResourceResult() <em>Resource Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceResult()
	 * @generated
	 * @ordered
	 */
	protected Resource resourceResult = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultModelPackage.Literals.TASK_RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPMF getQueueLengthOneLess() {
		return queueLengthOneLess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueLengthOneLess(ManagedPMF newQueueLengthOneLess) {
		ManagedPMF oldQueueLengthOneLess = queueLengthOneLess;
		queueLengthOneLess = newQueueLengthOneLess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS, oldQueueLengthOneLess, queueLengthOneLess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPMF getQueueLength() {
		return queueLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueLength(ManagedPMF newQueueLength) {
		ManagedPMF oldQueueLength = queueLength;
		queueLength = newQueueLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH, oldQueueLength, queueLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getTaskServiceTime() {
		return taskServiceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskServiceTime(ManagedPDF newTaskServiceTime) {
		ManagedPDF oldTaskServiceTime = taskServiceTime;
		taskServiceTime = newTaskServiceTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__TASK_SERVICE_TIME, oldTaskServiceTime, taskServiceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getWaitingTimeOneLess() {
		return waitingTimeOneLess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaitingTimeOneLess(ManagedPDF newWaitingTimeOneLess) {
		ManagedPDF oldWaitingTimeOneLess = waitingTimeOneLess;
		waitingTimeOneLess = newWaitingTimeOneLess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS, oldWaitingTimeOneLess, waitingTimeOneLess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getWaitingTime() {
		return waitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaitingTime(ManagedPDF newWaitingTime) {
		ManagedPDF oldWaitingTime = waitingTime;
		waitingTime = newWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME, oldWaitingTime, waitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getTaskResult() {
		if (taskResult != null && taskResult.eIsProxy()) {
			InternalEObject oldTaskResult = (InternalEObject)taskResult;
			taskResult = (Task)eResolveProxy(oldTaskResult);
			if (taskResult != oldTaskResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT, oldTaskResult, taskResult));
			}
		}
		return taskResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetTaskResult() {
		return taskResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskResult(Task newTaskResult) {
		Task oldTaskResult = taskResult;
		taskResult = newTaskResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT, oldTaskResult, taskResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResourceResult() {
		if (resourceResult != null && resourceResult.eIsProxy()) {
			InternalEObject oldResourceResult = (InternalEObject)resourceResult;
			resourceResult = (Resource)eResolveProxy(oldResourceResult);
			if (resourceResult != oldResourceResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT, oldResourceResult, resourceResult));
			}
		}
		return resourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResourceResult() {
		return resourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceResult(Resource newResourceResult) {
		Resource oldResourceResult = resourceResult;
		resourceResult = newResourceResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT, oldResourceResult, resourceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS:
				return getQueueLengthOneLess();
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH:
				return getQueueLength();
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_SERVICE_TIME:
				return getTaskServiceTime();
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS:
				return getWaitingTimeOneLess();
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME:
				return getWaitingTime();
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT:
				if (resolve) return getTaskResult();
				return basicGetTaskResult();
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				if (resolve) return getResourceResult();
				return basicGetResourceResult();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS:
				setQueueLengthOneLess((ManagedPMF)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH:
				setQueueLength((ManagedPMF)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_SERVICE_TIME:
				setTaskServiceTime((ManagedPDF)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS:
				setWaitingTimeOneLess((ManagedPDF)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME:
				setWaitingTime((ManagedPDF)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT:
				setTaskResult((Task)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				setResourceResult((Resource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS:
				setQueueLengthOneLess(QUEUE_LENGTH_ONE_LESS_EDEFAULT);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH:
				setQueueLength(QUEUE_LENGTH_EDEFAULT);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_SERVICE_TIME:
				setTaskServiceTime(TASK_SERVICE_TIME_EDEFAULT);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS:
				setWaitingTimeOneLess(WAITING_TIME_ONE_LESS_EDEFAULT);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME:
				setWaitingTime(WAITING_TIME_EDEFAULT);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT:
				setTaskResult((Task)null);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				setResourceResult((Resource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH_ONE_LESS:
				return QUEUE_LENGTH_ONE_LESS_EDEFAULT == null ? queueLengthOneLess != null : !QUEUE_LENGTH_ONE_LESS_EDEFAULT.equals(queueLengthOneLess);
			case ResultModelPackage.TASK_RESOURCE_USAGE__QUEUE_LENGTH:
				return QUEUE_LENGTH_EDEFAULT == null ? queueLength != null : !QUEUE_LENGTH_EDEFAULT.equals(queueLength);
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_SERVICE_TIME:
				return TASK_SERVICE_TIME_EDEFAULT == null ? taskServiceTime != null : !TASK_SERVICE_TIME_EDEFAULT.equals(taskServiceTime);
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME_ONE_LESS:
				return WAITING_TIME_ONE_LESS_EDEFAULT == null ? waitingTimeOneLess != null : !WAITING_TIME_ONE_LESS_EDEFAULT.equals(waitingTimeOneLess);
			case ResultModelPackage.TASK_RESOURCE_USAGE__WAITING_TIME:
				return WAITING_TIME_EDEFAULT == null ? waitingTime != null : !WAITING_TIME_EDEFAULT.equals(waitingTime);
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASK_RESULT:
				return taskResult != null;
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				return resourceResult != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (queueLengthOneLess: ");
		result.append(queueLengthOneLess);
		result.append(", queueLength: ");
		result.append(queueLength);
		result.append(", taskServiceTime: ");
		result.append(taskServiceTime);
		result.append(", waitingTimeOneLess: ");
		result.append(waitingTimeOneLess);
		result.append(", waitingTime: ");
		result.append(waitingTime);
		result.append(')');
		return result.toString();
	}

} //TaskResourceUsageImpl