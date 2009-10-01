/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.probespec.Calculator;
import de.uka.ipd.sdq.probespec.ProbeSpecRepository;
import de.uka.ipd.sdq.probespec.probespecPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probe Spec Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.ProbeSpecRepositoryImpl#getCalculator <em>Calculator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbeSpecRepositoryImpl extends EObjectImpl implements ProbeSpecRepository {
	/**
	 * The cached value of the '{@link #getCalculator() <em>Calculator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalculator()
	 * @generated
	 * @ordered
	 */
	protected EList<Calculator> calculator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbeSpecRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return probespecPackage.Literals.PROBE_SPEC_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Calculator> getCalculator() {
		if (calculator == null) {
			calculator = new EObjectContainmentEList<Calculator>(Calculator.class, this, probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR);
		}
		return calculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
				return ((InternalEList<?>)getCalculator()).basicRemove(otherEnd, msgs);
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
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
				return getCalculator();
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
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
				getCalculator().clear();
				getCalculator().addAll((Collection<? extends Calculator>)newValue);
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
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
				getCalculator().clear();
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
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
				return calculator != null && !calculator.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProbeSpecRepositoryImpl
