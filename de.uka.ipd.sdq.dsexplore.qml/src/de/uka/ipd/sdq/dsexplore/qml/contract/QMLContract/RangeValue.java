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
 * A representation of the model object '<em><b>Range Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getRangeLimitLiteral <em>Range Limit Literal</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRangeValue()
 * @model
 * @generated
 */
public interface RangeValue extends Identifier {
	/**
	 * Returns the value of the '<em><b>Range Limit Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range Limit Literal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range Limit Literal</em>' containment reference.
	 * @see #setRangeLimitLiteral(ValueLiteral)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRangeValue_RangeLimitLiteral()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ValueLiteral getRangeLimitLiteral();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getRangeLimitLiteral <em>Range Limit Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Limit Literal</em>' containment reference.
	 * @see #getRangeLimitLiteral()
	 * @generated
	 */
	void setRangeLimitLiteral(ValueLiteral value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType
	 * @see #setType(EnumRangeValueType)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRangeValue_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumRangeValueType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType
	 * @see #getType()
	 * @generated
	 */
	void setType(EnumRangeValueType value);

} // RangeValue
