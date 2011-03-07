/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getSetLiteral()
 * @model
 * @generated
 */
public interface SetLiteral extends ValueLiteral {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getSetLiteral_Values()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Element> getValues();

} // SetLiteral
