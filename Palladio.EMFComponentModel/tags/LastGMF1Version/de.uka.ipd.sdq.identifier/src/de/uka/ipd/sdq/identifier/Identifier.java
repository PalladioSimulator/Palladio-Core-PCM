/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.identifier;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Identifiers are not fixed to one realization.
 * GUIDs are recommend. GUIDs are described in their own model. See GUIDModel (GUID.emx).
 * Identifier implementations can be found in external projects only.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.identifier.Identifier#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.identifier.IdentifierPackage#getIdentifier()
 * @model abstract="true"
 * @generated
 */
public interface Identifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.uka.ipd.sdq.identifier.IdentifierPackage#getIdentifier_Id()
	 * @model id="true" required="true" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.identifier.Identifier#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.allInstances()->isUnique(p | p.id)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean idHasToBeUnique(DiagnosticChain diagnostics, Map context);

} // Identifier