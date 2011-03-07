/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.impl;

import de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeTaskImpl#getTask_AlternativeTask <em>Task Alternative Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeTaskImpl extends TaskImpl implements AlternativeTask {
	/**
	 * The cached value of the '{@link #getTask_AlternativeTask() <em>Task Alternative Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask_AlternativeTask()
	 * @generated
	 * @ordered
	 */
	protected Task task_AlternativeTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlternativeTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return taskmodelPackage.Literals.ALTERNATIVE_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getTask_AlternativeTask() {
		if (task_AlternativeTask != null && task_AlternativeTask.eIsProxy()) {
			InternalEObject oldTask_AlternativeTask = (InternalEObject)task_AlternativeTask;
			task_AlternativeTask = (Task)eResolveProxy(oldTask_AlternativeTask);
			if (task_AlternativeTask != oldTask_AlternativeTask) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK, oldTask_AlternativeTask, task_AlternativeTask));
			}
		}
		return task_AlternativeTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetTask_AlternativeTask() {
		return task_AlternativeTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask_AlternativeTask(Task newTask_AlternativeTask) {
		Task oldTask_AlternativeTask = task_AlternativeTask;
		task_AlternativeTask = newTask_AlternativeTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK, oldTask_AlternativeTask, task_AlternativeTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK:
				if (resolve) return getTask_AlternativeTask();
				return basicGetTask_AlternativeTask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK:
				setTask_AlternativeTask((Task)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK:
				setTask_AlternativeTask((Task)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case taskmodelPackage.ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK:
				return task_AlternativeTask != null;
		}
		return super.eIsSet(featureID);
	}

} //AlternativeTaskImpl
