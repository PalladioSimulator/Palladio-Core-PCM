/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EssentialOCL;

import EMOF.Property;
import EMOF.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EssentialOCL.TupleLiteralPart#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link EssentialOCL.TupleLiteralPart#getTupleLiteralExp <em>Tuple Literal Exp</em>}</li>
 *   <li>{@link EssentialOCL.TupleLiteralPart#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see EssentialOCL.EssentialOCLPackage#getTupleLiteralPart()
 * @model
 * @generated
 */
public interface TupleLiteralPart extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(Property)
	 * @see EssentialOCL.EssentialOCLPackage#getTupleLiteralPart_Attribute()
	 * @model
	 * @generated
	 */
	Property getAttribute();

	/**
	 * Sets the value of the '{@link EssentialOCL.TupleLiteralPart#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Property value);

	/**
	 * Returns the value of the '<em><b>Tuple Literal Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EssentialOCL.TupleLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuple Literal Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple Literal Exp</em>' container reference.
	 * @see #setTupleLiteralExp(TupleLiteralExp)
	 * @see EssentialOCL.EssentialOCLPackage#getTupleLiteralPart_TupleLiteralExp()
	 * @see EssentialOCL.TupleLiteralExp#getPart
	 * @model opposite="part" resolveProxies="false"
	 * @generated
	 */
	TupleLiteralExp getTupleLiteralExp();

	/**
	 * Sets the value of the '{@link EssentialOCL.TupleLiteralPart#getTupleLiteralExp <em>Tuple Literal Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuple Literal Exp</em>' container reference.
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	void setTupleLiteralExp(TupleLiteralExp value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see EssentialOCL.EssentialOCLPackage#getTupleLiteralPart_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link EssentialOCL.TupleLiteralPart#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

} // TupleLiteralPart
