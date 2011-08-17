/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.probespec.BinaryCalculator;
import de.uka.ipd.sdq.probespec.ProbeSet;
import de.uka.ipd.sdq.probespec.probespecPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Calculator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.BinaryCalculatorImpl#getProbeSet <em>Probe Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BinaryCalculatorImpl extends CalculatorImpl implements BinaryCalculator {
	/**
	 * The cached value of the '{@link #getProbeSet() <em>Probe Set</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeSet()
	 * @generated
	 * @ordered
	 */
	protected EList<ProbeSet> probeSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryCalculatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return probespecPackage.Literals.BINARY_CALCULATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProbeSet> getProbeSet() {
		if (probeSet == null) {
			probeSet = new EObjectContainmentEList<ProbeSet>(ProbeSet.class, this, probespecPackage.BINARY_CALCULATOR__PROBE_SET);
		}
		return probeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case probespecPackage.BINARY_CALCULATOR__PROBE_SET:
				return ((InternalEList<?>)getProbeSet()).basicRemove(otherEnd, msgs);
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
			case probespecPackage.BINARY_CALCULATOR__PROBE_SET:
				return getProbeSet();
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
			case probespecPackage.BINARY_CALCULATOR__PROBE_SET:
				getProbeSet().clear();
				getProbeSet().addAll((Collection<? extends ProbeSet>)newValue);
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
			case probespecPackage.BINARY_CALCULATOR__PROBE_SET:
				getProbeSet().clear();
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
			case probespecPackage.BINARY_CALCULATOR__PROBE_SET:
				return probeSet != null && !probeSet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BinaryCalculatorImpl
