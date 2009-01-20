/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Stack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ControllerStack bundels several controller layers for reuse. Therefore, a ControllerStack is stored in a ResourceRepository.
 * If a ControllerStack should be reused, it is referenced from a ResourceContainer. The corresponding ControllerInstances of the 
 * ResourceContainer have to be created anyway (if possible, automatically?).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerStack#getControllerLayers_ControllerStack <em>Controller Layers Controller Stack</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerStack()
 * @model
 * @generated
 */
public interface ControllerStack extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Controller Layers Controller Stack</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Layers Controller Stack</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Layers Controller Stack</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerStack_ControllerLayers_ControllerStack()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ControllerLayer> getControllerLayers_ControllerStack();

} // ControllerStack
