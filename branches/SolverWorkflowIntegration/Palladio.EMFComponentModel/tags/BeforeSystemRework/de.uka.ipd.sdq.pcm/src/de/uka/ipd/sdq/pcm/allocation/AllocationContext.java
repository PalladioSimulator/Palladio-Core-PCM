
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getReferencedAssemblyContext_AllocationContext <em>Referenced Assembly Context Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext()
 * @model
 * @generated
 */
public interface AllocationContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Referenced Assembly Context Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Assembly Context Allocation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Assembly Context Allocation Context</em>' reference.
	 * @see #setReferencedAssemblyContext_AllocationContext(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext_ReferencedAssemblyContext_AllocationContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getReferencedAssemblyContext_AllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getReferencedAssemblyContext_AllocationContext <em>Referenced Assembly Context Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Assembly Context Allocation Context</em>' reference.
	 * @see #getReferencedAssemblyContext_AllocationContext()
	 * @generated
	 */
	void setReferencedAssemblyContext_AllocationContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Resource Container Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container Allocation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Container Allocation Context</em>' reference.
	 * @see #setResourceContainer_AllocationContext(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext_ResourceContainer_AllocationContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceContainer getResourceContainer_AllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Container Allocation Context</em>' reference.
	 * @see #getResourceContainer_AllocationContext()
	 * @generated
	 */
	void setResourceContainer_AllocationContext(ResourceContainer value);

} // AllocationContext