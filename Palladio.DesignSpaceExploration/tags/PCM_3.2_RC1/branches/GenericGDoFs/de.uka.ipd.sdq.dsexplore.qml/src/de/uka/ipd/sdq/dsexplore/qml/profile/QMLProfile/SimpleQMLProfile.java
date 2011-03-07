/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile;

import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple QML Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     A profile defines requirements on an Usage Model.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile#getUsageModel <em>Usage Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getSimpleQMLProfile()
 * @model
 * @generated
 */
public interface SimpleQMLProfile extends GenericQMLProfile {
	/**
	 * Returns the value of the '<em><b>Usage Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Model</em>' reference.
	 * @see #setUsageModel(UsageModel)
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getSimpleQMLProfile_UsageModel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UsageModel getUsageModel();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile#getUsageModel <em>Usage Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Model</em>' reference.
	 * @see #getUsageModel()
	 * @generated
	 */
	void setUsageModel(UsageModel value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getSimpleQMLProfile_Requirements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getRequirements();

} // SimpleQMLProfile
