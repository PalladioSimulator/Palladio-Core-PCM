/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.validation.testbased.TBValidationQuality;
import de.fzi.se.validation.testbased.TestbasedPackage;
import de.fzi.se.validation.testbased.TestcaseGenerationStrategy;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testcase Generation Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TestcaseGenerationStrategyImpl#getValidationQuality <em>Validation Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TestcaseGenerationStrategyImpl extends IdentifierImpl implements TestcaseGenerationStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestcaseGenerationStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbasedPackage.Literals.TESTCASE_GENERATION_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBValidationQuality getValidationQuality() {
		if (eContainerFeatureID() != TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY) return null;
		return (TBValidationQuality)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidationQuality(TBValidationQuality newValidationQuality, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newValidationQuality, TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationQuality(TBValidationQuality newValidationQuality) {
		if (newValidationQuality != eInternalContainer() || (eContainerFeatureID() != TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY && newValidationQuality != null)) {
			if (EcoreUtil.isAncestor(this, newValidationQuality))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newValidationQuality != null)
				msgs = ((InternalEObject)newValidationQuality).eInverseAdd(this, TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY, TBValidationQuality.class, msgs);
			msgs = basicSetValidationQuality(newValidationQuality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY, newValidationQuality, newValidationQuality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetValidationQuality((TBValidationQuality)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				return basicSetValidationQuality(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				return eInternalContainer().eInverseRemove(this, TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY, TBValidationQuality.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				return getValidationQuality();
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
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				setValidationQuality((TBValidationQuality)newValue);
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
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				setValidationQuality((TBValidationQuality)null);
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
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY:
				return getValidationQuality() != null;
		}
		return super.eIsSet(featureID);
	}

} //TestcaseGenerationStrategyImpl
