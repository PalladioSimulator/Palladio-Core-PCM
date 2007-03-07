
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getQosAnnotations_System <em>Qos Annotations System</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends Entity, ComposedStructure, InterfaceProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Qos Annotations System</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qos Annotations System</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qos Annotations System</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem_QosAnnotations_System()
	 * @model type="de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations" containment="true" ordered="false"
	 * @generated
	 */
	EList getQosAnnotations_System();

} // System