/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.impl;

import de.uka.ipd.sdq.pcm.taskmodel.Alternative;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl#getTask_TaskList <em>Task Task List</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl#getStartTask_TaskList <em>Start Task Task List</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl#getAlternative_TaskList <em>Alternative Task List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskListImpl extends EObjectImpl implements TaskList {
	/**
	 * The cached value of the '{@link #getTask_TaskList() <em>Task Task List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask_TaskList()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> task_TaskList;

	/**
	 * The cached value of the '{@link #getStartTask_TaskList() <em>Start Task Task List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTask_TaskList()
	 * @generated
	 * @ordered
	 */
	protected Task startTask_TaskList;

	/**
	 * The cached value of the '{@link #getAlternative_TaskList() <em>Alternative Task List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternative_TaskList()
	 * @generated
	 * @ordered
	 */
	protected EList<Alternative> alternative_TaskList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return taskmodelPackage.Literals.TASK_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTask_TaskList() {
		if (task_TaskList == null) {
			task_TaskList = new EObjectContainmentEList<Task>(Task.class, this, taskmodelPackage.TASK_LIST__TASK_TASK_LIST);
		}
		return task_TaskList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getStartTask_TaskList() {
		if (startTask_TaskList != null && startTask_TaskList.eIsProxy()) {
			InternalEObject oldStartTask_TaskList = (InternalEObject)startTask_TaskList;
			startTask_TaskList = (Task)eResolveProxy(oldStartTask_TaskList);
			if (startTask_TaskList != oldStartTask_TaskList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST, oldStartTask_TaskList, startTask_TaskList));
			}
		}
		return startTask_TaskList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetStartTask_TaskList() {
		return startTask_TaskList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTask_TaskList(Task newStartTask_TaskList) {
		Task oldStartTask_TaskList = startTask_TaskList;
		startTask_TaskList = newStartTask_TaskList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST, oldStartTask_TaskList, startTask_TaskList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Alternative> getAlternative_TaskList() {
		if (alternative_TaskList == null) {
			alternative_TaskList = new EObjectContainmentEList<Alternative>(Alternative.class, this, taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST);
		}
		return alternative_TaskList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case taskmodelPackage.TASK_LIST__TASK_TASK_LIST:
				return ((InternalEList<?>)getTask_TaskList()).basicRemove(otherEnd, msgs);
			case taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST:
				return ((InternalEList<?>)getAlternative_TaskList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case taskmodelPackage.TASK_LIST__TASK_TASK_LIST:
				return getTask_TaskList();
			case taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST:
				if (resolve) return getStartTask_TaskList();
				return basicGetStartTask_TaskList();
			case taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST:
				return getAlternative_TaskList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case taskmodelPackage.TASK_LIST__TASK_TASK_LIST:
				getTask_TaskList().clear();
				getTask_TaskList().addAll((Collection<? extends Task>)newValue);
				return;
			case taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST:
				setStartTask_TaskList((Task)newValue);
				return;
			case taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST:
				getAlternative_TaskList().clear();
				getAlternative_TaskList().addAll((Collection<? extends Alternative>)newValue);
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
			case taskmodelPackage.TASK_LIST__TASK_TASK_LIST:
				getTask_TaskList().clear();
				return;
			case taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST:
				setStartTask_TaskList((Task)null);
				return;
			case taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST:
				getAlternative_TaskList().clear();
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
			case taskmodelPackage.TASK_LIST__TASK_TASK_LIST:
				return task_TaskList != null && !task_TaskList.isEmpty();
			case taskmodelPackage.TASK_LIST__START_TASK_TASK_LIST:
				return startTask_TaskList != null;
			case taskmodelPackage.TASK_LIST__ALTERNATIVE_TASK_LIST:
				return alternative_TaskList != null && !alternative_TaskList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaskListImpl
