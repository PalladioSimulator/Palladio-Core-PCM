/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getRange <em>Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getDefaultvalue <em>Defaultvalue</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getPrimitiveAttribute()
 * @model
 * @generated
 */
public interface PrimitiveAttribute extends Attribute {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featuremodel.AttributeTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see #setType(AttributeTypes)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getPrimitiveAttribute_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AttributeTypes getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(AttributeTypes value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(IntervalRange)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getPrimitiveAttribute_Range()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	IntervalRange getRange();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(IntervalRange value);

	/**
	 * Returns the value of the '<em><b>Defaultvalue</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaultvalue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaultvalue</em>' containment reference.
	 * @see #setDefaultvalue(DefaultValue)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getPrimitiveAttribute_Defaultvalue()
	 * @see de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute
	 * @model opposite="attribute" containment="true" required="true" ordered="false"
	 * @generated
	 */
	DefaultValue getDefaultvalue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.PrimitiveAttribute#getDefaultvalue <em>Defaultvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaultvalue</em>' containment reference.
	 * @see #getDefaultvalue()
	 * @generated
	 */
	void setDefaultvalue(DefaultValue value);

} // PrimitiveAttribute
