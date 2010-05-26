/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.repository.ApplicationFailureType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Describes the occurrence probability of failures of a specified type.&nbsp;In one&nbsp;InternalAction the&nbsp;sum of
 *     all failure probabilities must&nbsp;be less than&nbsp;or&nbsp;equal 1.0. Internal actions may only have one failure
 *     occurrence descripton for a failure type. (see constraints)
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureType <em>Failure Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getInternalAction_FailureOccurenceDescription <em>Internal Action Failure Occurence Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureOccurrenceDescription()
 * @model
 * @generated
 */
public interface FailureOccurrenceDescription extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Failure Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Type</em>' reference.
	 * @see #setFailureType(FailureType)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureOccurrenceDescription_FailureType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FailureType getFailureType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureType <em>Failure Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Type</em>' reference.
	 * @see #getFailureType()
	 * @generated
	 */
	void setFailureType(FailureType value);

	/**
	 * Returns the value of the '<em><b>Internal Action Failure Occurence Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.InternalAction#getFailureOccurrenceDescriptions <em>Failure Occurrence Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Action Failure Occurence Description</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Action Failure Occurence Description</em>' container reference.
	 * @see #setInternalAction_FailureOccurenceDescription(InternalAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureOccurrenceDescription_InternalAction_FailureOccurenceDescription()
	 * @see de.uka.ipd.sdq.pcm.seff.InternalAction#getFailureOccurrenceDescriptions
	 * @model opposite="failureOccurrenceDescriptions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InternalAction getInternalAction_FailureOccurenceDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getInternalAction_FailureOccurenceDescription <em>Internal Action Failure Occurence Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Action Failure Occurence Description</em>' container reference.
	 * @see #getInternalAction_FailureOccurenceDescription()
	 * @generated
	 */
	void setInternalAction_FailureOccurenceDescription(InternalAction value);

	/**
	 * Returns the value of the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Probability</em>' attribute.
	 * @see #setFailureProbability(double)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureOccurrenceDescription_FailureProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getFailureProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureProbability <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Probability</em>' attribute.
	 * @see #getFailureProbability()
	 * @generated
	 */
	void setFailureProbability(double value);

} // FailureOccurrenceDescription
