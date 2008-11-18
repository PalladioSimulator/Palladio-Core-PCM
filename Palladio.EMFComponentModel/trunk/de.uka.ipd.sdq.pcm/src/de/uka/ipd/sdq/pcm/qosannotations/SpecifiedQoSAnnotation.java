/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specified Qo SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SpecifiedQoSAnnotations (as an abstract class) associate specified (see QoSAnnotation) QoS properties to services of components. A service is thereby determined by a Signature and a Role (i.e., an interface bound to a component). Whatever concrete QoS characteristic is specified, it has to be given in terms of a PCMRandomVariable which may depend on component or input parameters of the service.
 * 
 * Notes:
 * - Is it correct that the PCMRandomvariable can depend on parameters?
 * - How is the relation of the specified QoS to the input parameters established?
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getSignature_SpecifiedQoSAnnation <em>Signature Specified Qo SAnnation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getRole_SpecifiedQoSAnnotation <em>Role Specified Qo SAnnotation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getSpecification_SpecifiedExecutionTime <em>Specification Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedQoSAnnotation()
 * @model abstract="true"
 * @generated
 */
public interface SpecifiedQoSAnnotation extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Signature Specified Qo SAnnation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Specified Qo SAnnation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Specified Qo SAnnation</em>' reference.
	 * @see #setSignature_SpecifiedQoSAnnation(Signature)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedQoSAnnotation_Signature_SpecifiedQoSAnnation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature_SpecifiedQoSAnnation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getSignature_SpecifiedQoSAnnation <em>Signature Specified Qo SAnnation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Specified Qo SAnnation</em>' reference.
	 * @see #getSignature_SpecifiedQoSAnnation()
	 * @generated
	 */
	void setSignature_SpecifiedQoSAnnation(Signature value);

	/**
	 * Returns the value of the '<em><b>Role Specified Qo SAnnotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Specified Qo SAnnotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Specified Qo SAnnotation</em>' reference.
	 * @see #setRole_SpecifiedQoSAnnotation(Role)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedQoSAnnotation_Role_SpecifiedQoSAnnotation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Role getRole_SpecifiedQoSAnnotation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getRole_SpecifiedQoSAnnotation <em>Role Specified Qo SAnnotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Specified Qo SAnnotation</em>' reference.
	 * @see #getRole_SpecifiedQoSAnnotation()
	 * @generated
	 */
	void setRole_SpecifiedQoSAnnotation(Role value);

	/**
	 * Returns the value of the '<em><b>Specification Specified Execution Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Specified Execution Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Specified Execution Time</em>' containment reference.
	 * @see #setSpecification_SpecifiedExecutionTime(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedQoSAnnotation_Specification_SpecifiedExecutionTime()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getSpecification_SpecifiedExecutionTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation#getSpecification_SpecifiedExecutionTime <em>Specification Specified Execution Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Specified Execution Time</em>' containment reference.
	 * @see #getSpecification_SpecifiedExecutionTime()
	 * @generated
	 */
	void setSpecification_SpecifiedExecutionTime(PCMRandomVariable value);

} // SpecifiedQoSAnnotation
