/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specified Output Parameter Abstraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * To specify the output parameters of a service (without associated RD-SEFF), software architects can associate a SpecifiedOutputParameterAbstraction to services (signature + role). SpecifiedOutputParameterAbstractions assign a single VariableUsage to that service that determines the output parameters in depency of its input parameters. Software architects can use stochastic expressions (package StoEx) to define the dependencies.
 * 
 * Note:
 * - Is it actually possible to define the output in dependency on the input parameters?
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getSignature_SpecifiedOutputParameterAbstraction <em>Signature Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getRole_SpecifiedOutputParameterAbstraction <em>Role Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction <em>Expected External Outputs Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getQosAnnotations_SpecifiedOutputParameterAbstraction <em>Qos Annotations Specified Output Parameter Abstraction</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction()
 * @model abstract="true"
 * @generated
 */
public interface SpecifiedOutputParameterAbstraction extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Qos Annotations Specified Output Parameter Abstraction</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedOutputParameterAbstractions_QoSAnnotations <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qos Annotations Specified Output Parameter Abstraction</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qos Annotations Specified Output Parameter Abstraction</em>' container reference.
	 * @see #setQosAnnotations_SpecifiedOutputParameterAbstraction(QoSAnnotations)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_QosAnnotations_SpecifiedOutputParameterAbstraction()
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedOutputParameterAbstractions_QoSAnnotations
	 * @model opposite="specifiedOutputParameterAbstractions_QoSAnnotations" required="true" transient="false" ordered="false"
	 * @generated
	 */
	QoSAnnotations getQosAnnotations_SpecifiedOutputParameterAbstraction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getQosAnnotations_SpecifiedOutputParameterAbstraction <em>Qos Annotations Specified Output Parameter Abstraction</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qos Annotations Specified Output Parameter Abstraction</em>' container reference.
	 * @see #getQosAnnotations_SpecifiedOutputParameterAbstraction()
	 * @generated
	 */
	void setQosAnnotations_SpecifiedOutputParameterAbstraction(QoSAnnotations value);

	/**
	 * Returns the value of the '<em><b>Signature Specified Output Parameter Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Specified Output Parameter Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Specified Output Parameter Abstraction</em>' reference.
	 * @see #setSignature_SpecifiedOutputParameterAbstraction(Signature)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_Signature_SpecifiedOutputParameterAbstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature_SpecifiedOutputParameterAbstraction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getSignature_SpecifiedOutputParameterAbstraction <em>Signature Specified Output Parameter Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Specified Output Parameter Abstraction</em>' reference.
	 * @see #getSignature_SpecifiedOutputParameterAbstraction()
	 * @generated
	 */
	void setSignature_SpecifiedOutputParameterAbstraction(Signature value);

	/**
	 * Returns the value of the '<em><b>Role Specified Output Parameter Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Specified Output Parameter Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Specified Output Parameter Abstraction</em>' reference.
	 * @see #setRole_SpecifiedOutputParameterAbstraction(Role)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_Role_SpecifiedOutputParameterAbstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Role getRole_SpecifiedOutputParameterAbstraction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getRole_SpecifiedOutputParameterAbstraction <em>Role Specified Output Parameter Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Specified Output Parameter Abstraction</em>' reference.
	 * @see #getRole_SpecifiedOutputParameterAbstraction()
	 * @generated
	 */
	void setRole_SpecifiedOutputParameterAbstraction(Role value);

	/**
	 * Returns the value of the '<em><b>Expected External Outputs Specified Output Parameter Abstraction</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected External Outputs Specified Output Parameter Abstraction</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected External Outputs Specified Output Parameter Abstraction</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_ExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage
	 * @model opposite="specifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction();

} // SpecifiedOutputParameterAbstraction
