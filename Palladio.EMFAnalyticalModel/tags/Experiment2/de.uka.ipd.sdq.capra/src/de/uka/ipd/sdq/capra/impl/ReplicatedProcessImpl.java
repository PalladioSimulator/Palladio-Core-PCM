/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.impl;

import de.uka.ipd.sdq.capra.CapraPackage;
import de.uka.ipd.sdq.capra.ReplicatedProcess;

import de.uka.ipd.sdq.capra.core.ProcessVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replicated Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl#getProcessvariable <em>Processvariable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplicatedProcessImpl extends EObjectImpl implements ReplicatedProcess {
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
	 * The cached value of the '{@link #getProcessvariable() <em>Processvariable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessvariable()
	 * @generated
	 * @ordered
	 */
	protected ProcessVariable processvariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplicatedProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapraPackage.Literals.REPLICATED_PROCESS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.REPLICATED_PROCESS__NUM_REPLICAS, oldNumReplicas, numReplicas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable getProcessvariable() {
		return processvariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessvariable(ProcessVariable newProcessvariable, NotificationChain msgs) {
		ProcessVariable oldProcessvariable = processvariable;
		processvariable = newProcessvariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE, oldProcessvariable, newProcessvariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessvariable(ProcessVariable newProcessvariable) {
		if (newProcessvariable != processvariable) {
			NotificationChain msgs = null;
			if (processvariable != null)
				msgs = ((InternalEObject)processvariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE, null, msgs);
			if (newProcessvariable != null)
				msgs = ((InternalEObject)newProcessvariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE, null, msgs);
			msgs = basicSetProcessvariable(newProcessvariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE, newProcessvariable, newProcessvariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE:
				return basicSetProcessvariable(null, msgs);
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
			case CapraPackage.REPLICATED_PROCESS__NUM_REPLICAS:
				return new Integer(getNumReplicas());
			case CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE:
				return getProcessvariable();
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
			case CapraPackage.REPLICATED_PROCESS__NUM_REPLICAS:
				setNumReplicas(((Integer)newValue).intValue());
				return;
			case CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE:
				setProcessvariable((ProcessVariable)newValue);
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
			case CapraPackage.REPLICATED_PROCESS__NUM_REPLICAS:
				setNumReplicas(NUM_REPLICAS_EDEFAULT);
				return;
			case CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE:
				setProcessvariable((ProcessVariable)null);
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
			case CapraPackage.REPLICATED_PROCESS__NUM_REPLICAS:
				return numReplicas != NUM_REPLICAS_EDEFAULT;
			case CapraPackage.REPLICATED_PROCESS__PROCESSVARIABLE:
				return processvariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numReplicas: ");
		result.append(numReplicas);
		result.append(')');
		return result.toString();
	}

} //ReplicatedProcessImpl
