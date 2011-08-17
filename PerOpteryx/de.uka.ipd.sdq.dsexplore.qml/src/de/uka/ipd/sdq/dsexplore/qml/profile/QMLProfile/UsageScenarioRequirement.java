/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Scenario Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A&nbsp;usage scenrio requirement is a requirement on an usage scenario.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement#getUsageScenario <em>Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getUsageScenarioRequirement()
 * @model
 * @generated
 */
public interface UsageScenarioRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Usage Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Scenario</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Scenario</em>' reference.
	 * @see #setUsageScenario(UsageScenario)
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getUsageScenarioRequirement_UsageScenario()
	 * @model ordered="false"
	 * @generated
	 */
	UsageScenario getUsageScenario();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement#getUsageScenario <em>Usage Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Scenario</em>' reference.
	 * @see #getUsageScenario()
	 * @generated
	 */
	void setUsageScenario(UsageScenario value);

} // UsageScenarioRequirement
