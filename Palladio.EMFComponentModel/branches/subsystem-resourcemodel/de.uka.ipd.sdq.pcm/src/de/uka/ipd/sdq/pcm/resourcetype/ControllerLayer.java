/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Layer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity is used for stacking Controllers. A ControllerScope is deployed on a ResourceContainer. Any resource access on this ResourceContainer first has to go through the 
 * ControllerScope before it is issued to resources: If a Component specifies a ResourceDemand, it has to specify the ResourceService of the corresponding ResourceInterface.
 * Then, the outest ControllerScope is being checked if its ControllerType provides the same ResourceInterface. If it provides the ResourceInterface, the resource demand is being issued 
 * to the Controller. Otherwise, the search is being repeated for the next ControllerScope (innerScope). The last ControllerScope does not have a further innerScope reference. Instead, the 
 * ProcessingResourceType is being accessed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer <em>Upper Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getControllerType_ControllerScope <em>Controller Type Controller Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerLayer()
 * @model
 * @generated
 */
public interface ControllerLayer extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Upper Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer <em>Lower Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Layer</em>' reference.
	 * @see #setUpperLayer(ControllerLayer)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerLayer_UpperLayer()
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer
	 * @model opposite="lowerLayer" ordered="false"
	 * @generated
	 */
	ControllerLayer getUpperLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Layer</em>' reference.
	 * @see #getUpperLayer()
	 * @generated
	 */
	void setUpperLayer(ControllerLayer value);

	/**
	 * Returns the value of the '<em><b>Lower Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer <em>Upper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Layer</em>' reference.
	 * @see #setLowerLayer(ControllerLayer)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerLayer_LowerLayer()
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer
	 * @model opposite="upperLayer" ordered="false"
	 * @generated
	 */
	ControllerLayer getLowerLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Layer</em>' reference.
	 * @see #getLowerLayer()
	 * @generated
	 */
	void setLowerLayer(ControllerLayer value);

	/**
	 * Returns the value of the '<em><b>Controller Type Controller Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Type Controller Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Type Controller Scope</em>' reference.
	 * @see #setControllerType_ControllerScope(ControllerType)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerLayer_ControllerType_ControllerScope()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControllerType getControllerType_ControllerScope();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getControllerType_ControllerScope <em>Controller Type Controller Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Type Controller Scope</em>' reference.
	 * @see #getControllerType_ControllerScope()
	 * @generated
	 */
	void setControllerType_ControllerScope(ControllerType value);

} // ControllerLayer
