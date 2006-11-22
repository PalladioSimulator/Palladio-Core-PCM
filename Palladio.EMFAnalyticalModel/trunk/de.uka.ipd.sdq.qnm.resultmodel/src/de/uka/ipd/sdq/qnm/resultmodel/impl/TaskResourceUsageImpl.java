/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.resultmodel.ResourceResult;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResult;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

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
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResourceUsageImpl#getTaskresult <em>Taskresult</em>}</li>
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
	 * The cached value of the '{@link #getTaskresult() <em>Taskresult</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskresult()
	 * @generated
	 * @ordered
	 */
	protected TaskResult taskresult = null;

	/**
	 * The cached value of the '{@link #getResourceResult() <em>Resource Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceResult()
	 * @generated
	 * @ordered
	 */
	protected ResourceResult resourceResult = null;

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
	public TaskResult getTaskresult() {
		if (taskresult != null && taskresult.eIsProxy()) {
			InternalEObject oldTaskresult = (InternalEObject)taskresult;
			taskresult = (TaskResult)eResolveProxy(oldTaskresult);
			if (taskresult != oldTaskresult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT, oldTaskresult, taskresult));
			}
		}
		return taskresult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskResult basicGetTaskresult() {
		return taskresult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskresult(TaskResult newTaskresult, NotificationChain msgs) {
		TaskResult oldTaskresult = taskresult;
		taskresult = newTaskresult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT, oldTaskresult, newTaskresult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskresult(TaskResult newTaskresult) {
		if (newTaskresult != taskresult) {
			NotificationChain msgs = null;
			if (taskresult != null)
				msgs = ((InternalEObject)taskresult).eInverseRemove(this, ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES, TaskResult.class, msgs);
			if (newTaskresult != null)
				msgs = ((InternalEObject)newTaskresult).eInverseAdd(this, ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES, TaskResult.class, msgs);
			msgs = basicSetTaskresult(newTaskresult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT, newTaskresult, newTaskresult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceResult getResourceResult() {
		if (resourceResult != null && resourceResult.eIsProxy()) {
			InternalEObject oldResourceResult = (InternalEObject)resourceResult;
			resourceResult = (ResourceResult)eResolveProxy(oldResourceResult);
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
	public ResourceResult basicGetResourceResult() {
		return resourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceResult(ResourceResult newResourceResult, NotificationChain msgs) {
		ResourceResult oldResourceResult = resourceResult;
		resourceResult = newResourceResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT, oldResourceResult, newResourceResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceResult(ResourceResult newResourceResult) {
		if (newResourceResult != resourceResult) {
			NotificationChain msgs = null;
			if (resourceResult != null)
				msgs = ((InternalEObject)resourceResult).eInverseRemove(this, ResultModelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES, ResourceResult.class, msgs);
			if (newResourceResult != null)
				msgs = ((InternalEObject)newResourceResult).eInverseAdd(this, ResultModelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES, ResourceResult.class, msgs);
			msgs = basicSetResourceResult(newResourceResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT, newResourceResult, newResourceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				if (taskresult != null)
					msgs = ((InternalEObject)taskresult).eInverseRemove(this, ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES, TaskResult.class, msgs);
				return basicSetTaskresult((TaskResult)otherEnd, msgs);
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				if (resourceResult != null)
					msgs = ((InternalEObject)resourceResult).eInverseRemove(this, ResultModelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES, ResourceResult.class, msgs);
				return basicSetResourceResult((ResourceResult)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				return basicSetTaskresult(null, msgs);
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				return basicSetResourceResult(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				if (resolve) return getTaskresult();
				return basicGetTaskresult();
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
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				setTaskresult((TaskResult)newValue);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				setResourceResult((ResourceResult)newValue);
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
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				setTaskresult((TaskResult)null);
				return;
			case ResultModelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT:
				setResourceResult((ResourceResult)null);
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
			case ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT:
				return taskresult != null;
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