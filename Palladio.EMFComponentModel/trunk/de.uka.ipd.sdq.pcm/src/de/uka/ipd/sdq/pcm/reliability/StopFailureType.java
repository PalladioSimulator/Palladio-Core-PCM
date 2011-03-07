/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stop Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Abstract super class that&nbsp;provides a type definition for&nbsp;failure-on-demand occurrences during service
 *     execution.&nbsp;A StopFailureType occurrence cancels the current control and data flow and leads to an immediate stop
 *     of the service execution, unless handled on any level upwards the caller hierarchy. Inherits from FailureType.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.StopFailureType#getExternalFailureOccurrenceDescriptions__StopFailureType <em>External Failure Occurrence Descriptions Stop Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getStopFailureType()
 * @model abstract="true"
 * @generated
 */
public interface StopFailureType extends FailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>External Failure Occurrence Descriptions Stop Failure Type</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getStopFailureType__ExternalFailureOccurrenceDescription <em>Stop Failure Type External Failure Occurrence Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Failure Occurrence Descriptions Stop Failure Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Failure Occurrence Descriptions Stop Failure Type</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getStopFailureType_ExternalFailureOccurrenceDescriptions__StopFailureType()
	 * @see de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getStopFailureType__ExternalFailureOccurrenceDescription
	 * @model opposite="stopFailureType__ExternalFailureOccurrenceDescription" ordered="false"
	 * @generated
	 */
	EList<ExternalFailureOccurrenceDescription> getExternalFailureOccurrenceDescriptions__StopFailureType();

} // StopFailureType
