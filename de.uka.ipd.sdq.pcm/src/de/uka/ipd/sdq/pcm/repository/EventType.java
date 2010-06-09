/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.parameter.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The EventType represents a single class of events that can be emited by a source or consumed by a sink. The characteristics of the event are defined by the variable included in the EventType.
 * Due to the extension of the signature class, the EventType is also accessible for ServiceEffectSpecifications (SEFF). By this, a SEFF is able to represent an event handler for this type of events.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.EventType#getEventGroup__EventType <em>Event Group Event Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.EventType#getPayload__EventType <em>Payload Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getEventType()
 * @model
 * @generated
 */
public interface EventType extends Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Payload Event Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable <em>Event Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Event Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Event Type</em>' containment reference.
	 * @see #setPayload__EventType(Variable)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getEventType_Payload__EventType()
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable
	 * @model opposite="eventType__Variable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Variable getPayload__EventType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.EventType#getPayload__EventType <em>Payload Event Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Event Type</em>' containment reference.
	 * @see #getPayload__EventType()
	 * @generated
	 */
	void setPayload__EventType(Variable value);

	/**
	 * Returns the value of the '<em><b>Event Group Event Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.EventGroup#getEventTypes__EventGroup <em>Event Types Event Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Group Event Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Group Event Type</em>' container reference.
	 * @see #setEventGroup__EventType(EventGroup)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getEventType_EventGroup__EventType()
	 * @see de.uka.ipd.sdq.pcm.repository.EventGroup#getEventTypes__EventGroup
	 * @model opposite="eventTypes__EventGroup" required="true" transient="false" ordered="false"
	 * @generated
	 */
	EventGroup getEventGroup__EventType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.EventType#getEventGroup__EventType <em>Event Group Event Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Group Event Type</em>' container reference.
	 * @see #getEventGroup__EventType()
	 * @generated
	 */
	void setEventGroup__EventType(EventGroup value);

} // EventType
