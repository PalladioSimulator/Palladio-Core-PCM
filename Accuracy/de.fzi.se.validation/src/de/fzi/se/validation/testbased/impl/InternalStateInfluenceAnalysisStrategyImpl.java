/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy;
import de.fzi.se.validation.testbased.TBValidationQuality;
import de.fzi.se.validation.testbased.TestbasedPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal State Influence Analysis Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.impl.InternalStateInfluenceAnalysisStrategyImpl#getTbValidationQuality <em>Tb Validation Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InternalStateInfluenceAnalysisStrategyImpl extends EObjectImpl implements InternalStateInfluenceAnalysisStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalStateInfluenceAnalysisStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbasedPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBValidationQuality getTbValidationQuality() {
		if (eContainerFeatureID() != TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY) return null;
		return (TBValidationQuality)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTbValidationQuality(TBValidationQuality newTbValidationQuality, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTbValidationQuality, TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTbValidationQuality(TBValidationQuality newTbValidationQuality) {
		if (newTbValidationQuality != eInternalContainer() || (eContainerFeatureID() != TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY && newTbValidationQuality != null)) {
			if (EcoreUtil.isAncestor(this, newTbValidationQuality))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTbValidationQuality != null)
				msgs = ((InternalEObject)newTbValidationQuality).eInverseAdd(this, TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY, TBValidationQuality.class, msgs);
			msgs = basicSetTbValidationQuality(newTbValidationQuality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY, newTbValidationQuality, newTbValidationQuality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTbValidationQuality((TBValidationQuality)otherEnd, msgs);
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				return basicSetTbValidationQuality(null, msgs);
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				return eInternalContainer().eInverseRemove(this, TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY, TBValidationQuality.class, msgs);
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				return getTbValidationQuality();
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				setTbValidationQuality((TBValidationQuality)newValue);
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				setTbValidationQuality((TBValidationQuality)null);
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
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY:
				return getTbValidationQuality() != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalStateInfluenceAnalysisStrategyImpl
