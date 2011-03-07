/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.probespec.ProbeSet;
import de.uka.ipd.sdq.probespec.UnaryCalculator;
import de.uka.ipd.sdq.probespec.probespecPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Calculator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.UnaryCalculatorImpl#getProbeSet <em>Probe Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UnaryCalculatorImpl extends CalculatorImpl implements UnaryCalculator {
	/**
	 * The cached value of the '{@link #getProbeSet() <em>Probe Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeSet()
	 * @generated
	 * @ordered
	 */
	protected ProbeSet probeSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryCalculatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return probespecPackage.Literals.UNARY_CALCULATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSet getProbeSet() {
		return probeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProbeSet(ProbeSet newProbeSet, NotificationChain msgs) {
		ProbeSet oldProbeSet = probeSet;
		probeSet = newProbeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, probespecPackage.UNARY_CALCULATOR__PROBE_SET, oldProbeSet, newProbeSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeSet(ProbeSet newProbeSet) {
		if (newProbeSet != probeSet) {
			NotificationChain msgs = null;
			if (probeSet != null)
				msgs = ((InternalEObject)probeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - probespecPackage.UNARY_CALCULATOR__PROBE_SET, null, msgs);
			if (newProbeSet != null)
				msgs = ((InternalEObject)newProbeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - probespecPackage.UNARY_CALCULATOR__PROBE_SET, null, msgs);
			msgs = basicSetProbeSet(newProbeSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, probespecPackage.UNARY_CALCULATOR__PROBE_SET, newProbeSet, newProbeSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case probespecPackage.UNARY_CALCULATOR__PROBE_SET:
				return basicSetProbeSet(null, msgs);
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
			case probespecPackage.UNARY_CALCULATOR__PROBE_SET:
				return getProbeSet();
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
			case probespecPackage.UNARY_CALCULATOR__PROBE_SET:
				setProbeSet((ProbeSet)newValue);
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
			case probespecPackage.UNARY_CALCULATOR__PROBE_SET:
				setProbeSet((ProbeSet)null);
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
			case probespecPackage.UNARY_CALCULATOR__PROBE_SET:
				return probeSet != null;
		}
		return super.eIsSet(featureID);
	}

} //UnaryCalculatorImpl
