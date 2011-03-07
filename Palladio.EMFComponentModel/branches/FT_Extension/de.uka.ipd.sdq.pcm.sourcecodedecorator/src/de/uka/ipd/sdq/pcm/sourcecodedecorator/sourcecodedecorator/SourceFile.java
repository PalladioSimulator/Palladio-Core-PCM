/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile#getFullQualifiedName <em>Full Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceFile()
 * @model
 * @generated
 */
public interface SourceFile extends Identifier {
	/**
	 * Returns the value of the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * for classes: full qualified class name; for C/C++ code: relative path to file + file name; if representing a method link do NOT add path information for inside file navigation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Full Qualified Name</em>' attribute.
	 * @see #setFullQualifiedName(String)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceFile_FullQualifiedName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFullQualifiedName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile#getFullQualifiedName <em>Full Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Qualified Name</em>' attribute.
	 * @see #getFullQualifiedName()
	 * @generated
	 */
	void setFullQualifiedName(String value);

} // SourceFile
