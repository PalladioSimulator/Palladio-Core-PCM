/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mapping between AssemblyContext and Resource. Sometimes referred to as "Deployment".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAssemblyContext_AllocationContext <em>Assembly Context Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAllocation_AllocationContext <em>Allocation Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext()
 * @model
 * @generated
 */
public interface AllocationContext extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

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

	/**
	 * Returns the value of the '<em><b>Assembly Context Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Allocation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Allocation Context</em>' reference.
	 * @see #setAssemblyContext_AllocationContext(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext_AssemblyContext_AllocationContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_AllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAssemblyContext_AllocationContext <em>Assembly Context Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Allocation Context</em>' reference.
	 * @see #getAssemblyContext_AllocationContext()
	 * @generated
	 */
	void setAssemblyContext_AllocationContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Allocation Allocation Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Allocation Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Allocation Context</em>' container reference.
	 * @see #setAllocation_AllocationContext(Allocation)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationContext_Allocation_AllocationContext()
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation
	 * @model opposite="allocationContexts_Allocation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Allocation getAllocation_AllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAllocation_AllocationContext <em>Allocation Allocation Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Allocation Context</em>' container reference.
	 * @see #getAllocation_AllocationContext()
	 * @generated
	 */
	void setAllocation_AllocationContext(Allocation value);

} // AllocationContext
