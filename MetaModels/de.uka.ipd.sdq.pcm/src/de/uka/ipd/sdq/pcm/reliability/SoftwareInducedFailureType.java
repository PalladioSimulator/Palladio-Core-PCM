/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Induced Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Type definition for a software-induced failure, i.e. a failure-on-demand occurrence&nbsp;due to a software fault. Type
 *     definitions are created by modellers for a certain PCM instance to distinguish&nbsp;different types of software
 *     failure-on-demand occurrences. Possible examples are: "EncryptionFailure", "ProtocolFailure", "WebServerFailure".
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType#getInternalFailureOccurrenceDescriptions__SoftwareInducedFailureType <em>Internal Failure Occurrence Descriptions Software Induced Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getSoftwareInducedFailureType()
 * @model
 * @generated
 */
public interface SoftwareInducedFailureType extends FailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Internal Failure Occurrence Descriptions Software Induced Failure Type</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription#getSoftwareInducedFailureType__InternalFailureOccurrenceDescription <em>Software Induced Failure Type Internal Failure Occurrence Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Failure Occurrence Descriptions Software Induced Failure Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Failure Occurrence Descriptions Software Induced Failure Type</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getSoftwareInducedFailureType_InternalFailureOccurrenceDescriptions__SoftwareInducedFailureType()
	 * @see de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription#getSoftwareInducedFailureType__InternalFailureOccurrenceDescription
	 * @model opposite="softwareInducedFailureType__InternalFailureOccurrenceDescription" ordered="false"
	 * @generated
	 */
	EList<InternalFailureOccurrenceDescription> getInternalFailureOccurrenceDescriptions__SoftwareInducedFailureType();

} // SoftwareInducedFailureType
