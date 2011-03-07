/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refined QML Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A refinement must be stronger that the profile it refines.
 * <p>
 *     Additional OCL needed:<br />
 *     all entities must be of the same whole&nbsp;entityas the refined profile
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.RefinedQMLProfile#getBaseProfile <em>Base Profile</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.RefinedQMLProfile#getRefinedBy <em>Refined By</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getRefinedQMLProfile()
 * @model
 * @generated
 */
public interface RefinedQMLProfile extends GenericQMLProfile {
	/**
	 * Returns the value of the '<em><b>Base Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Profile</em>' reference.
	 * @see #setBaseProfile(GenericQMLProfile)
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getRefinedQMLProfile_BaseProfile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenericQMLProfile getBaseProfile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.RefinedQMLProfile#getBaseProfile <em>Base Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Profile</em>' reference.
	 * @see #getBaseProfile()
	 * @generated
	 */
	void setBaseProfile(GenericQMLProfile value);

	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined By</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#getRefinedQMLProfile_RefinedBy()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getRefinedBy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.baseProfile <> self
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.baseProfile <> self'"
	 * @generated
	 */
	boolean profile_cannot_refine_itself(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RefinedQMLProfile
