/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents an instance of a ControllerType. It is allocated on a ResourceContainer and references a ControllerLayer which references the ControllerType of this instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getUpperControllerAllocationConnectors_ControllerInstance <em>Upper Controller Allocation Connectors Controller Instance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getControllerLayer_ControllerInstance <em>Controller Layer Controller Instance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getLowerControllerAllocationConnectors_ControllerInstance <em>Lower Controller Allocation Connectors Controller Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerInstance()
 * @model
 * @generated
 */
public interface ControllerInstance extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Controller Layer Controller Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Layer Controller Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Layer Controller Instance</em>' reference.
	 * @see #setControllerLayer_ControllerInstance(ControllerLayer)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerInstance_ControllerLayer_ControllerInstance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControllerLayer getControllerLayer_ControllerInstance();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getControllerLayer_ControllerInstance <em>Controller Layer Controller Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Layer Controller Instance</em>' reference.
	 * @see #getControllerLayer_ControllerInstance()
	 * @generated
	 */
	void setControllerLayer_ControllerInstance(ControllerLayer value);

	/**
	 * Returns the value of the '<em><b>Upper Controller Allocation Connectors Controller Instance</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector#getToControllerInstance_ControllerAllocationConnector <em>To Controller Instance Controller Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Controller Allocation Connectors Controller Instance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Controller Allocation Connectors Controller Instance</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerInstance_UpperControllerAllocationConnectors_ControllerInstance()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector#getToControllerInstance_ControllerAllocationConnector
	 * @model opposite="toControllerInstance_ControllerAllocationConnector" ordered="false"
	 * @generated
	 */
	EList<ControllerAllocationConnector> getUpperControllerAllocationConnectors_ControllerInstance();

	/**
	 * Returns the value of the '<em><b>Lower Controller Allocation Connectors Controller Instance</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector <em>From Controller Instance Controller Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Controller Allocation Connectors Controller Instance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Controller Allocation Connectors Controller Instance</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getControllerInstance_LowerControllerAllocationConnectors_ControllerInstance()
	 * @see de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector
	 * @model opposite="fromControllerInstance_ControllerAllocationConnector" ordered="false"
	 * @generated
	 */
	EList<ResourceProvidedRoleConnector> getLowerControllerAllocationConnectors_ControllerInstance();

} // ControllerInstance
