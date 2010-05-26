/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An AssemblyContext uniquely identifies an assembly instance of an AssemblyContext.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_AssemblyContext <em>Encapsulated Component Assembly Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext <em>Config Parameter Usages Assembly Context</em>}</li>
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
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Encapsulated Component Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulated Component Assembly Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulated Component Assembly Context</em>' reference.
	 * @see #setEncapsulatedComponent_AssemblyContext(RepositoryComponent)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_EncapsulatedComponent_AssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryComponent getEncapsulatedComponent_AssemblyContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_AssemblyContext <em>Encapsulated Component Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encapsulated Component Assembly Context</em>' reference.
	 * @see #getEncapsulatedComponent_AssemblyContext()
	 * @generated
	 */
	void setEncapsulatedComponent_AssemblyContext(RepositoryComponent value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Assembly Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyContexts_ComposedStructure <em>Assembly Contexts Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Assembly Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Assembly Context</em>' container reference.
	 * @see #setParentStructure_AssemblyContext(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_ParentStructure_AssemblyContext()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyContexts_ComposedStructure
	 * @model opposite="assemblyContexts_ComposedStructure" required="true" transient="false" ordered="false"
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
	 * Returns the value of the '<em><b>Config Parameter Usages Assembly Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Parameter Usages Assembly Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Parameter Usages Assembly Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyContext_ConfigParameterUsages_AssemblyContext()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getAssemblyContext_VariableUsage
	 * @model opposite="assemblyContext_VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getConfigParameterUsages_AssemblyContext();

} // AssemblyContext
