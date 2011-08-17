/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement#getAspectRequirementLiteral <em>Aspect Requirement Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getAspectRequirement()
 * @model abstract="true"
 * @generated
 */
public interface AspectRequirement extends Identifier {
	/**
	 * Returns the value of the '<em><b>Aspect Requirement Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspect Requirement Literal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect Requirement Literal</em>' containment reference.
	 * @see #setAspectRequirementLiteral(ValueLiteral)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getAspectRequirement_AspectRequirementLiteral()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ValueLiteral getAspectRequirementLiteral();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement#getAspectRequirementLiteral <em>Aspect Requirement Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect Requirement Literal</em>' containment reference.
	 * @see #getAspectRequirementLiteral()
	 * @generated
	 */
	void setAspectRequirementLiteral(ValueLiteral value);

} // AspectRequirement
