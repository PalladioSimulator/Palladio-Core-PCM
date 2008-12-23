/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceContainer_AllocationConnector <em>Resource Container Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getAssemblyContext_AllocationConnector <em>Assembly Context Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationConnector()
 * @model abstract="true"
 * @generated
 */
public interface AllocationConnector extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Required Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Required Role Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Required Role Allocation Connector</em>' reference.
	 * @see #setResourceRequiredRole_AllocationConnector(ResourceRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationConnector_ResourceRequiredRole_AllocationConnector()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ResourceRequiredRole getResourceRequiredRole_AllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Required Role Allocation Connector</em>' reference.
	 * @see #getResourceRequiredRole_AllocationConnector()
	 * @generated
	 */
	void setResourceRequiredRole_AllocationConnector(ResourceRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Resource Container Allocation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getAllocationConnectors_ResourceContainer <em>Allocation Connectors Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Container Allocation Connector</em>' reference.
	 * @see #setResourceContainer_AllocationConnector(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationConnector_ResourceContainer_AllocationConnector()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getAllocationConnectors_ResourceContainer
	 * @model opposite="allocationConnectors_ResourceContainer" required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ResourceContainer getResourceContainer_AllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceContainer_AllocationConnector <em>Resource Container Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Container Allocation Connector</em>' reference.
	 * @see #getResourceContainer_AllocationConnector()
	 * @generated
	 */
	void setResourceContainer_AllocationConnector(ResourceContainer value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Allocation Connector</em>' reference.
	 * @see #setAssemblyContext_AllocationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationConnector_AssemblyContext_AllocationConnector()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_AllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getAssemblyContext_AllocationConnector <em>Assembly Context Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Allocation Connector</em>' reference.
	 * @see #getAssemblyContext_AllocationConnector()
	 * @generated
	 */
	void setAssemblyContext_AllocationConnector(AssemblyContext value);

} // AllocationConnector
