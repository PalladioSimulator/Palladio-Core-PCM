/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ControllerAllocationConnector is a special AllocationConnector which connects a component ("fromAssemblyContext_AllocationConnector") or controller ("fromControllerInstance_ControllerAllocationConnector") with a controller ("toControllerInstance_ControllerAllocationConnector").
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector#getToControllerInstance_ControllerAllocationConnector <em>To Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerAllocationConnector()
 * @model
 * @generated
 */
public interface ControllerAllocationConnector extends ResourceProvidedRoleConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>To Controller Instance Controller Allocation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getUpperControllerAllocationConnectors_ControllerInstance <em>Upper Controller Allocation Connectors Controller Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Controller Instance Controller Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #setToControllerInstance_ControllerAllocationConnector(ControllerInstance)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerAllocationConnector_ToControllerInstance_ControllerAllocationConnector()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getUpperControllerAllocationConnectors_ControllerInstance
	 * @model opposite="upperControllerAllocationConnectors_ControllerInstance" ordered="false"
	 * @generated
	 */
	ControllerInstance getToControllerInstance_ControllerAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector#getToControllerInstance_ControllerAllocationConnector <em>To Controller Instance Controller Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #getToControllerInstance_ControllerAllocationConnector()
	 * @generated
	 */
	void setToControllerInstance_ControllerAllocationConnector(ControllerInstance value);

} // ControllerAllocationConnector
