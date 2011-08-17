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
 * A representation of the model object '<em><b>Source Code ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Unique position identifier for a source code artefact, class, package, method, branch, loop statement, or internal action.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID#getSourceCodeID <em>Source Code ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeID()
 * @model abstract="true"
 * @generated
 */
public interface SourceCodeID extends Identifier {
	/**
	 * Returns the value of the '<em><b>Source Code ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * unique identifier for a certain position in code
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Code ID</em>' attribute.
	 * @see #setSourceCodeID(String)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeID_SourceCodeID()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSourceCodeID();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID#getSourceCodeID <em>Source Code ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code ID</em>' attribute.
	 * @see #getSourceCodeID()
	 * @generated
	 */
	void setSourceCodeID(String value);

} // SourceCodeID
