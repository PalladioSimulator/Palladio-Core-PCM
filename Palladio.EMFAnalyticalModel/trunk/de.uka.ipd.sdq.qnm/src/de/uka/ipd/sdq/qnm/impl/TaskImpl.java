/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.qnm.QnmPackage;
import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.TaskImpl#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.TaskImpl#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends EObjectImpl implements Task {
	/**
	 * The default value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumReplicas()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_REPLICAS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumReplicas()
	 * @generated
	 * @ordered
	 */
	protected int numReplicas = NUM_REPLICAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceUsage() <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractResourceUsage resourceUsage = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QnmPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumReplicas() {
		return numReplicas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumReplicas(int newNumReplicas) {
		int oldNumReplicas = numReplicas;
		numReplicas = newNumReplicas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.TASK__NUM_REPLICAS, oldNumReplicas, numReplicas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResourceUsage getResourceUsage() {
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceUsage(AbstractResourceUsage newResourceUsage, NotificationChain msgs) {
		AbstractResourceUsage oldResourceUsage = resourceUsage;
		resourceUsage = newResourceUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QnmPackage.TASK__RESOURCE_USAGE, oldResourceUsage, newResourceUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUsage(AbstractResourceUsage newResourceUsage) {
		if (newResourceUsage != resourceUsage) {
			NotificationChain msgs = null;
			if (resourceUsage != null)
				msgs = ((InternalEObject)resourceUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QnmPackage.TASK__RESOURCE_USAGE, null, msgs);
			if (newResourceUsage != null)
				msgs = ((InternalEObject)newResourceUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QnmPackage.TASK__RESOURCE_USAGE, null, msgs);
			msgs = basicSetResourceUsage(newResourceUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.TASK__RESOURCE_USAGE, newResourceUsage, newResourceUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QnmPackage.TASK__RESOURCE_USAGE:
				return basicSetResourceUsage(null, msgs);
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
			case QnmPackage.TASK__NUM_REPLICAS:
				return new Integer(getNumReplicas());
			case QnmPackage.TASK__NAME:
				return getName();
			case QnmPackage.TASK__RESOURCE_USAGE:
				return getResourceUsage();
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
			case QnmPackage.TASK__NUM_REPLICAS:
				setNumReplicas(((Integer)newValue).intValue());
				return;
			case QnmPackage.TASK__NAME:
				setName((String)newValue);
				return;
			case QnmPackage.TASK__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)newValue);
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
			case QnmPackage.TASK__NUM_REPLICAS:
				setNumReplicas(NUM_REPLICAS_EDEFAULT);
				return;
			case QnmPackage.TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case QnmPackage.TASK__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)null);
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
			case QnmPackage.TASK__NUM_REPLICAS:
				return numReplicas != NUM_REPLICAS_EDEFAULT;
			case QnmPackage.TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case QnmPackage.TASK__RESOURCE_USAGE:
				return resourceUsage != null;
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
		result.append(" (numReplicas: ");
		result.append(numReplicas);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TaskImpl