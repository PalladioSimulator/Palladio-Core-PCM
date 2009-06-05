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
 * <!-- begin-model-doc -->
 * An AllocationConnector is being used to explicitly connect the ResourceRequiredRole of an allocated component to another allocated component, which serves as an infrastructure component (such as middleware), to a controller or a resource.
 * Before analysis,AllocationeConnectors have to be created (automatically). This means that deployed infrastructure components or controllers are being checked if a corresponding ResourceInterface is provided and a connector is created which connects a component with the appropriate element (i.e., an InfrastructureComponentScope, a ControllerInstance or a ProcessingResourceSpecification).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getFromAssemblyContext_AllocationConnector <em>From Assembly Context Allocation Connector</em>}</li>
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
	 * @model required="true" ordered="false"
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
	 * Returns the value of the '<em><b>From Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Assembly Context Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Assembly Context Allocation Connector</em>' reference.
	 * @see #setFromAssemblyContext_AllocationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocationConnector_FromAssemblyContext_AllocationConnector()
	 * @model ordered="false"
	 * @generated
	 */
	AssemblyContext getFromAssemblyContext_AllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getFromAssemblyContext_AllocationConnector <em>From Assembly Context Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Assembly Context Allocation Connector</em>' reference.
	 * @see #getFromAssemblyContext_AllocationConnector()
	 * @generated
	 */
	void setFromAssemblyContext_AllocationConnector(AssemblyContext value);

} // AllocationConnector
