/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResult;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl#getTask <em>Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.TaskResultImpl#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskResultImpl extends EObjectImpl implements TaskResult {
	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected Task task = null;

	/**
	 * The cached value of the '{@link #getTaskresourceusages() <em>Taskresourceusages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskresourceusages()
	 * @generated
	 * @ordered
	 */
	protected EList taskresourceusages = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultModelPackage.Literals.TASK_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getTask() {
		if (task != null && task.eIsProxy()) {
			InternalEObject oldTask = (InternalEObject)task;
			task = (Task)eResolveProxy(oldTask);
			if (task != oldTask) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.TASK_RESULT__TASK, oldTask, task));
			}
		}
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetTask() {
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask(Task newTask) {
		Task oldTask = task;
		task = newTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.TASK_RESULT__TASK, oldTask, task));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTaskresourceusages() {
		if (taskresourceusages == null) {
			taskresourceusages = new EObjectWithInverseResolvingEList(TaskResourceUsage.class, this, ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES, ResultModelPackage.TASK_RESOURCE_USAGE__TASKRESULT);
		}
		return taskresourceusages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				return ((InternalEList)getTaskresourceusages()).basicAdd(otherEnd, msgs);
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
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				return ((InternalEList)getTaskresourceusages()).basicRemove(otherEnd, msgs);
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
			case ResultModelPackage.TASK_RESULT__TASK:
				if (resolve) return getTask();
				return basicGetTask();
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				return getTaskresourceusages();
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
			case ResultModelPackage.TASK_RESULT__TASK:
				setTask((Task)newValue);
				return;
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
				getTaskresourceusages().addAll((Collection)newValue);
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
			case ResultModelPackage.TASK_RESULT__TASK:
				setTask((Task)null);
				return;
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
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
			case ResultModelPackage.TASK_RESULT__TASK:
				return task != null;
			case ResultModelPackage.TASK_RESULT__TASKRESOURCEUSAGES:
				return taskresourceusages != null && !taskresourceusages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaskResultImpl