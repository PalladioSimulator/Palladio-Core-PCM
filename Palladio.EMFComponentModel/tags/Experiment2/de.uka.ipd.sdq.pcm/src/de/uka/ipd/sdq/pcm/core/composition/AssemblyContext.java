
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_ChildComponentContext <em>Encapsulated Component Child Component Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getComponentParameterUsage_AssemblyContext <em>Component Parameter Usage Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext()
 * @model
 * @generated
 */
public interface AssemblyContext extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Encapsulated Component Child Component Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulated Component Child Component Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulated Component Child Component Context</em>' reference.
	 * @see #setEncapsulatedComponent_ChildComponentContext(ProvidesComponentType)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_EncapsulatedComponent_ChildComponentContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidesComponentType getEncapsulatedComponent_ChildComponentContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_ChildComponentContext <em>Encapsulated Component Child Component Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encapsulated Component Child Component Context</em>' reference.
	 * @see #getEncapsulatedComponent_ChildComponentContext()
	 * @generated
	 */
	void setEncapsulatedComponent_ChildComponentContext(ProvidesComponentType value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Assembly Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getChildComponentContexts_ComposedStructure <em>Child Component Contexts Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Assembly Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Assembly Context</em>' container reference.
	 * @see #setParentStructure_AssemblyContext(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_ParentStructure_AssemblyContext()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getChildComponentContexts_ComposedStructure
	 * @model opposite="childComponentContexts_ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_AssemblyContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Assembly Context</em>' container reference.
	 * @see #getParentStructure_AssemblyContext()
	 * @generated
	 */
	void setParentStructure_AssemblyContext(ComposedStructure value);

	/**
	 * Returns the value of the '<em><b>Component Parameter Usage Assembly Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Parameter Usage Assembly Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Parameter Usage Assembly Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_ComponentParameterUsage_AssemblyContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getComponentParameterUsage_AssemblyContext();

} // AssemblyContext
