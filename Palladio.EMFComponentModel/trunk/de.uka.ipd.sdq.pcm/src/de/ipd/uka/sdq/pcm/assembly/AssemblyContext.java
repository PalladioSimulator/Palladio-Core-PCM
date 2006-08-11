/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.assembly;

import de.ipd.uka.sdq.pcm.core.entity.Entity;

import de.ipd.uka.sdq.pcm.repository.ProvidesComponentType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * the attribute "description" is only used for identifikation by human
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.assembly.AssemblyContext#getEncapsulatedComponent__AssemblyContext <em>Encapsulated Component Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.assembly.AssemblyPackage#getAssemblyContext()
 * @model
 * @generated
 */
public interface AssemblyContext extends Entity {
	/**
	 * Returns the value of the '<em><b>Encapsulated Component Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulated Component Assembly Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulated Component Assembly Context</em>' reference.
	 * @see #setEncapsulatedComponent__AssemblyContext(ProvidesComponentType)
	 * @see de.ipd.uka.sdq.pcm.assembly.AssemblyPackage#getAssemblyContext_EncapsulatedComponent__AssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidesComponentType getEncapsulatedComponent__AssemblyContext();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.assembly.AssemblyContext#getEncapsulatedComponent__AssemblyContext <em>Encapsulated Component Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encapsulated Component Assembly Context</em>' reference.
	 * @see #getEncapsulatedComponent__AssemblyContext()
	 * @generated
	 */
	void setEncapsulatedComponent__AssemblyContext(ProvidesComponentType value);

} // AssemblyContext