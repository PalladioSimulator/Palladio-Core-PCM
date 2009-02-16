/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qo SAnnotations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedExecutionTimes_QoSAnnotations <em>Specified Execution Times Qo SAnnotations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedOutputParameterAbstractions_QoSAnnotations <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}</li>
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
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SpecifiedExecutionTime> getSpecifiedExecutionTimes_QoSAnnotations();

	/**
	 * Returns the value of the '<em><b>Specified Output Parameter Abstractions Qo SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Output Parameter Abstractions Qo SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Output Parameter Abstractions Qo SAnnotations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getQoSAnnotations_SpecifiedOutputParameterAbstractions_QoSAnnotations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SpecifiedOutputParameterAbstraction> getSpecifiedOutputParameterAbstractions_QoSAnnotations();

} // QoSAnnotations
