/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.repository.FailureType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailuretype <em>Failuretype</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Failuretype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failuretype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failuretype</em>' reference.
	 * @see #setFailuretype(FailureType)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureOccurrenceDescription_Failuretype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FailureType getFailuretype();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailuretype <em>Failuretype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failuretype</em>' reference.
	 * @see #getFailuretype()
	 * @generated
	 */
	void setFailuretype(FailureType value);

} // FailureOccurrenceDescription
