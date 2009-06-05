/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.Preemptive;
import de.uka.ipd.sdq.capra.schedulers.Quantum;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preemptive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl#isImmediate <em>Immediate</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl#getQuantum <em>Quantum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreemptiveImpl extends AssignmentImpl implements Preemptive {
	/**
	 * The default value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean immediate = IMMEDIATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQuantum() <em>Quantum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantum()
	 * @generated
	 * @ordered
	 */
	protected Quantum quantum;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreemptiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulersPackage.Literals.PREEMPTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediate() {
		return immediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediate(boolean newImmediate) {
		boolean oldImmediate = immediate;
		immediate = newImmediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PREEMPTIVE__IMMEDIATE, oldImmediate, immediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantum getQuantum() {
		return quantum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuantum(Quantum newQuantum, NotificationChain msgs) {
		Quantum oldQuantum = quantum;
		quantum = newQuantum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulersPackage.PREEMPTIVE__QUANTUM, oldQuantum, newQuantum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantum(Quantum newQuantum) {
		if (newQuantum != quantum) {
			NotificationChain msgs = null;
			if (quantum != null)
				msgs = ((InternalEObject)quantum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.PREEMPTIVE__QUANTUM, null, msgs);
			if (newQuantum != null)
				msgs = ((InternalEObject)newQuantum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.PREEMPTIVE__QUANTUM, null, msgs);
			msgs = basicSetQuantum(newQuantum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PREEMPTIVE__QUANTUM, newQuantum, newQuantum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulersPackage.PREEMPTIVE__QUANTUM:
				return basicSetQuantum(null, msgs);
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
			case SchedulersPackage.PREEMPTIVE__IMMEDIATE:
				return isImmediate() ? Boolean.TRUE : Boolean.FALSE;
			case SchedulersPackage.PREEMPTIVE__QUANTUM:
				return getQuantum();
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
			case SchedulersPackage.PREEMPTIVE__IMMEDIATE:
				setImmediate(((Boolean)newValue).booleanValue());
				return;
			case SchedulersPackage.PREEMPTIVE__QUANTUM:
				setQuantum((Quantum)newValue);
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
			case SchedulersPackage.PREEMPTIVE__IMMEDIATE:
				setImmediate(IMMEDIATE_EDEFAULT);
				return;
			case SchedulersPackage.PREEMPTIVE__QUANTUM:
				setQuantum((Quantum)null);
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
			case SchedulersPackage.PREEMPTIVE__IMMEDIATE:
				return immediate != IMMEDIATE_EDEFAULT;
			case SchedulersPackage.PREEMPTIVE__QUANTUM:
				return quantum != null;
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
		result.append(" (immediate: ");
		result.append(immediate);
		result.append(')');
		return result.toString();
	}

} //PreemptiveImpl
