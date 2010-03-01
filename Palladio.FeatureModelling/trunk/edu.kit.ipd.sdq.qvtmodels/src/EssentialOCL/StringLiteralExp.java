/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EssentialOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EssentialOCL.StringLiteralExp#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see EssentialOCL.EssentialOCLPackage#getStringLiteralExp()
 * @model
 * @generated
 */
public interface StringLiteralExp extends PrimitiveLiteralExp {
	/**
	 * Returns the value of the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Symbol</em>' attribute.
	 * @see #setStringSymbol(String)
	 * @see EssentialOCL.EssentialOCLPackage#getStringLiteralExp_StringSymbol()
	 * @model dataType="EMOF.String"
	 * @generated
	 */
	String getStringSymbol();

	/**
	 * Sets the value of the '{@link EssentialOCL.StringLiteralExp#getStringSymbol <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Symbol</em>' attribute.
	 * @see #getStringSymbol()
	 * @generated
	 */
	void setStringSymbol(String value);

} // StringLiteralExp
