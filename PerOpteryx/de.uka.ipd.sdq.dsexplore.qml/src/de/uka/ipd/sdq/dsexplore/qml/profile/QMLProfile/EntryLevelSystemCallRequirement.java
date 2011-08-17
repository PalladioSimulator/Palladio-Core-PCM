/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Level System Call Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A&nbsp;entry&nbsp;level&nbsp;system&nbsp;call&nbsp;requirement&nbsp;is&nbsp;a&nbsp;requirement&nbsp;on&nbsp;an&nbsp;entry&nbsp;level&nbsp;system&nbsp;call.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement#getEntryLevelSystemCall <em>Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getEntryLevelSystemCallRequirement()
 * @model
 * @generated
 */
public interface EntryLevelSystemCallRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Entry Level System Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call</em>' reference.
	 * @see #setEntryLevelSystemCall(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getEntryLevelSystemCallRequirement_EntryLevelSystemCall()
	 * @model ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement#getEntryLevelSystemCall <em>Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call</em>' reference.
	 * @see #getEntryLevelSystemCall()
	 * @generated
	 */
	void setEntryLevelSystemCall(EntryLevelSystemCall value);

} // EntryLevelSystemCallRequirement
