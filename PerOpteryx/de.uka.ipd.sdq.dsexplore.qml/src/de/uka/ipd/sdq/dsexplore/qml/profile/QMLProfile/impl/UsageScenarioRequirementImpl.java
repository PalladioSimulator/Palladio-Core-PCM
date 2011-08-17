/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Scenario Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl.UsageScenarioRequirementImpl#getUsageScenario <em>Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageScenarioRequirementImpl extends RequirementImpl implements UsageScenarioRequirement {
	/**
	 * The cached value of the '{@link #getUsageScenario() <em>Usage Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageScenario()
	 * @generated
	 * @ordered
	 */
	protected UsageScenario usageScenario;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageScenarioRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLProfilePackage.Literals.USAGE_SCENARIO_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageScenario getUsageScenario() {
		if (usageScenario != null && usageScenario.eIsProxy()) {
			InternalEObject oldUsageScenario = (InternalEObject)usageScenario;
			usageScenario = (UsageScenario)eResolveProxy(oldUsageScenario);
			if (usageScenario != oldUsageScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO, oldUsageScenario, usageScenario));
			}
		}
		return usageScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageScenario basicGetUsageScenario() {
		return usageScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageScenario(UsageScenario newUsageScenario) {
		UsageScenario oldUsageScenario = usageScenario;
		usageScenario = newUsageScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO, oldUsageScenario, usageScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO:
				if (resolve) return getUsageScenario();
				return basicGetUsageScenario();
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
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO:
				setUsageScenario((UsageScenario)newValue);
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
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO:
				setUsageScenario((UsageScenario)null);
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
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO:
				return usageScenario != null;
		}
		return super.eIsSet(featureID);
	}

} //UsageScenarioRequirementImpl
