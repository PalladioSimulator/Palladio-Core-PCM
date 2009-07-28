/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Methods</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.Methods#getRelativePathInFile <em>Relative Path In File</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.Methods#getMethodName <em>Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethods()
 * @model
 * @generated
 */
public interface Methods extends Identifier {
	/**
	 * Returns the value of the '<em><b>Relative Path In File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Path In File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Path In File</em>' attribute.
	 * @see #setRelativePathInFile(String)
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethods_RelativePathInFile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getRelativePathInFile();

	/**
	 * Sets the value of the '{@link SourceCodeDecorator.sourcecodedecorator.Methods#getRelativePathInFile <em>Relative Path In File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Path In File</em>' attribute.
	 * @see #getRelativePathInFile()
	 * @generated
	 */
	void setRelativePathInFile(String value);

	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethods_MethodName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link SourceCodeDecorator.sourcecodedecorator.Methods#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

} // Methods
