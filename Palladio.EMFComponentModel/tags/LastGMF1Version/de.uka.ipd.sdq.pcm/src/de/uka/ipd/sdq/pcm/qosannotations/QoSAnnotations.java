
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qo SAnnotations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedExecutionTimes_QoSAnnotations <em>Specified Execution Times Qo SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getQoSAnnotations()
 * @model
 * @generated
 */
public interface QoSAnnotations extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Specified Execution Times Qo SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Execution Times Qo SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Execution Times Qo SAnnotations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getQoSAnnotations_SpecifiedExecutionTimes_QoSAnnotations()
	 * @model type="de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime" containment="true" ordered="false"
	 * @generated
	 */
	EList getSpecifiedExecutionTimes_QoSAnnotations();

} // QoSAnnotations