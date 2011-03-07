/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability;

import de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedReliabilityAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription <em>Specified Reliability Annotation External Failure Occurrence Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getStopFailureType__ExternalFailureOccurrenceDescription <em>Stop Failure Type External Failure Occurrence Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getExternalFailureOccurrenceDescription()
 * @model
 * @generated
 */
public interface ExternalFailureOccurrenceDescription extends FailureOccurrenceDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Specified Reliability Annotation External Failure Occurrence Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedReliabilityAnnotation#getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation <em>External Failure Occurrence Descriptions Specified Reliability Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Reliability Annotation External Failure Occurrence Description</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Reliability Annotation External Failure Occurrence Description</em>' container reference.
	 * @see #setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(SpecifiedReliabilityAnnotation)
	 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getExternalFailureOccurrenceDescription_SpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription()
	 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedReliabilityAnnotation#getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation
	 * @model opposite="externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SpecifiedReliabilityAnnotation getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription <em>Specified Reliability Annotation External Failure Occurrence Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Reliability Annotation External Failure Occurrence Description</em>' container reference.
	 * @see #getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription()
	 * @generated
	 */
	void setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(SpecifiedReliabilityAnnotation value);

	/**
	 * Returns the value of the '<em><b>Stop Failure Type External Failure Occurrence Description</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.reliability.StopFailureType#getExternalFailureOccurrenceDescriptions__StopFailureType <em>External Failure Occurrence Descriptions Stop Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Failure Type External Failure Occurrence Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Failure Type External Failure Occurrence Description</em>' reference.
	 * @see #setStopFailureType__ExternalFailureOccurrenceDescription(StopFailureType)
	 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getExternalFailureOccurrenceDescription_StopFailureType__ExternalFailureOccurrenceDescription()
	 * @see de.uka.ipd.sdq.pcm.reliability.StopFailureType#getExternalFailureOccurrenceDescriptions__StopFailureType
	 * @model opposite="externalFailureOccurrenceDescriptions__StopFailureType" required="true" ordered="false"
	 * @generated
	 */
	StopFailureType getStopFailureType__ExternalFailureOccurrenceDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription#getStopFailureType__ExternalFailureOccurrenceDescription <em>Stop Failure Type External Failure Occurrence Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Failure Type External Failure Occurrence Description</em>' reference.
	 * @see #getStopFailureType__ExternalFailureOccurrenceDescription()
	 * @generated
	 */
	void setStopFailureType__ExternalFailureOccurrenceDescription(StopFailureType value);

} // ExternalFailureOccurrenceDescription
