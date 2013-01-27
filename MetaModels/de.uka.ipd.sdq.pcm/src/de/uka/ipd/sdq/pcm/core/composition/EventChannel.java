/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Event Channel</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getEventGroup__EventChannel <em>Event
 * Group Event Channel</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getEventChannelSourceConnector__EventChannel
 * <em>Event Channel Source Connector Event Channel</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getEventChannelSinkConnector__EventChannel
 * <em>Event Channel Sink Connector Event Channel</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getParentStructure__EventChannel <em>
 * Parent Structure Event Channel</em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannel()
 * @model
 * @generated
 */
public interface EventChannel extends Entity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Event Group Event Channel</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Group Event Channel</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Event Group Event Channel</em>' reference.
     * @see #setEventGroup__EventChannel(EventGroup)
     * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannel_EventGroup__EventChannel()
     * @model required="true" ordered="false"
     * @generated
     */
    EventGroup getEventGroup__EventChannel();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getEventGroup__EventChannel
     * <em>Event Group Event Channel</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Event Group Event Channel</em>' reference.
     * @see #getEventGroup__EventChannel()
     * @generated
     */
    void setEventGroup__EventChannel(EventGroup value);

    /**
     * Returns the value of the '<em><b>Event Channel Source Connector Event Channel</b></em>'
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector}. It is bidirectional
     * and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getEventChannel__EventChannelSourceConnector
     * <em>Event Channel Event Channel Source Connector</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Channel Source Connector Event Channel</em>' reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Event Channel Source Connector Event Channel</em>' reference
     *         list.
     * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannel_EventChannelSourceConnector__EventChannel()
     * @see de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getEventChannel__EventChannelSourceConnector
     * @model opposite="eventChannel__EventChannelSourceConnector" ordered="false"
     * @generated
     */
    EList<EventChannelSourceConnector> getEventChannelSourceConnector__EventChannel();

    /**
     * Returns the value of the '<em><b>Event Channel Sink Connector Event Channel</b></em>'
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector}. It is bidirectional
     * and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector#getEventChannel__EventChannelSinkConnector
     * <em>Event Channel Event Channel Sink Connector</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Channel Sink Connector Event Channel</em>' reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Event Channel Sink Connector Event Channel</em>' reference
     *         list.
     * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannel_EventChannelSinkConnector__EventChannel()
     * @see de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector#getEventChannel__EventChannelSinkConnector
     * @model opposite="eventChannel__EventChannelSinkConnector" ordered="false"
     * @generated
     */
    EList<EventChannelSinkConnector> getEventChannelSinkConnector__EventChannel();

    /**
     * Returns the value of the '<em><b>Parent Structure Event Channel</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getEventChannel__ComposedStructure
     * <em>Event Channel Composed Structure</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Structure Event Channel</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parent Structure Event Channel</em>' container reference.
     * @see #setParentStructure__EventChannel(ComposedStructure)
     * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannel_ParentStructure__EventChannel()
     * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getEventChannel__ComposedStructure
     * @model opposite="eventChannel__ComposedStructure" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    ComposedStructure getParentStructure__EventChannel();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.core.composition.EventChannel#getParentStructure__EventChannel
     * <em>Parent Structure Event Channel</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Parent Structure Event Channel</em>' container
     *            reference.
     * @see #getParentStructure__EventChannel()
     * @generated
     */
    void setParentStructure__EventChannel(ComposedStructure value);

} // EventChannel
