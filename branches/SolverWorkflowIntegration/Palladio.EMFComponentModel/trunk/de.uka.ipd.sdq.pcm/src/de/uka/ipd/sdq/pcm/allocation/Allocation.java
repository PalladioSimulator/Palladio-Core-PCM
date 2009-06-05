/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation()
 * @model
 * @generated
 */
public interface Allocation extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Allocation Contexts Allocation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.AllocationContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Contexts Allocation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Contexts Allocation</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_AllocationContexts_Allocation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AllocationContext> getAllocationContexts_Allocation();

	/**
	 * Returns the value of the '<em><b>Target Resource Environment Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource Environment Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #setTargetResourceEnvironment_Allocation(ResourceEnvironment)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_TargetResourceEnvironment_Allocation()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceEnvironment getTargetResourceEnvironment_Allocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #getTargetResourceEnvironment_Allocation()
	 * @generated
	 */
	void setTargetResourceEnvironment_Allocation(ResourceEnvironment value);

	/**
	 * Returns the value of the '<em><b>System Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Allocation</em>' reference.
	 * @see #setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_System_Allocation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	de.uka.ipd.sdq.pcm.system.System getSystem_Allocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Allocation</em>' reference.
	 * @see #getSystem_Allocation()
	 * @generated
	 */
	void setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.system_Allocation.assemblyContexts_ComposedStructure->forAll(assemblyCtx|self.allocationContexts_Allocation->select(allocationCtx|allocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.system_Allocation.assemblyContexts_ComposedStructure->forAll(assemblyCtx|self.allocationContexts_Allocation->select(allocationCtx|allocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1)'"
	 * @generated
	 */
	boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Allocation
