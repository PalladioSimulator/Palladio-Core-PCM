/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Event Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventGroup__EventChannel <em>Event Group Event Channel</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventChannelSourceConnector__EventChannel <em>Event Channel Source Connector Event Channel</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventChannelSinkConnector__EventChannel <em>Event Channel Sink Connector Event Channel</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getParentStructure__EventChannel <em>Parent Structure Event Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventChannelImpl extends EntityImpl implements EventChannel {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getEventGroup__EventChannel() <em>Event Group Event Channel</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getEventGroup__EventChannel()
     * @generated
     * @ordered
     */
    protected EventGroup eventGroup__EventChannel;

    /**
     * The cached value of the '{@link #getEventChannelSourceConnector__EventChannel() <em>Event Channel Source Connector Event Channel</em>}' reference list.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getEventChannelSourceConnector__EventChannel()
     * @generated
     * @ordered
     */
    protected EList<EventChannelSourceConnector> eventChannelSourceConnector__EventChannel;

    /**
     * The cached value of the '{@link #getEventChannelSinkConnector__EventChannel() <em>Event Channel Sink Connector Event Channel</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventChannelSinkConnector__EventChannel()
     * @generated
     * @ordered
     */
    protected EList<EventChannelSinkConnector> eventChannelSinkConnector__EventChannel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EventChannelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EventGroup getEventGroup__EventChannel() {
        if (eventGroup__EventChannel != null && eventGroup__EventChannel.eIsProxy()) {
            InternalEObject oldEventGroup__EventChannel = (InternalEObject)eventGroup__EventChannel;
            eventGroup__EventChannel = (EventGroup)eResolveProxy(oldEventGroup__EventChannel);
            if (eventGroup__EventChannel != oldEventGroup__EventChannel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, oldEventGroup__EventChannel, eventGroup__EventChannel));
            }
        }
        return eventGroup__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EventGroup basicGetEventGroup__EventChannel() {
        return eventGroup__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setEventGroup__EventChannel(EventGroup newEventGroup__EventChannel) {
        EventGroup oldEventGroup__EventChannel = eventGroup__EventChannel;
        eventGroup__EventChannel = newEventGroup__EventChannel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, oldEventGroup__EventChannel, eventGroup__EventChannel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<EventChannelSourceConnector> getEventChannelSourceConnector__EventChannel() {
        if (eventChannelSourceConnector__EventChannel == null) {
            eventChannelSourceConnector__EventChannel = new EObjectWithInverseResolvingEList<EventChannelSourceConnector>(EventChannelSourceConnector.class, this, CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL, CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR);
        }
        return eventChannelSourceConnector__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<EventChannelSinkConnector> getEventChannelSinkConnector__EventChannel() {
        if (eventChannelSinkConnector__EventChannel == null) {
            eventChannelSinkConnector__EventChannel = new EObjectWithInverseResolvingEList<EventChannelSinkConnector>(EventChannelSinkConnector.class, this, CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL, CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR);
        }
        return eventChannelSinkConnector__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ComposedStructure getParentStructure__EventChannel() {
        if (eContainerFeatureID() != CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL) return null;
        return (ComposedStructure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParentStructure__EventChannel(ComposedStructure newParentStructure__EventChannel,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParentStructure__EventChannel, CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParentStructure__EventChannel(ComposedStructure newParentStructure__EventChannel) {
        if (newParentStructure__EventChannel != eInternalContainer() || (eContainerFeatureID() != CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL && newParentStructure__EventChannel != null)) {
            if (EcoreUtil.isAncestor(this, newParentStructure__EventChannel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParentStructure__EventChannel != null)
                msgs = ((InternalEObject)newParentStructure__EventChannel).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
            msgs = basicSetParentStructure__EventChannel(newParentStructure__EventChannel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, newParentStructure__EventChannel, newParentStructure__EventChannel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEventChannelSourceConnector__EventChannel()).basicAdd(otherEnd, msgs);
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEventChannelSinkConnector__EventChannel()).basicAdd(otherEnd, msgs);
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParentStructure__EventChannel((ComposedStructure)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                return ((InternalEList<?>)getEventChannelSourceConnector__EventChannel()).basicRemove(otherEnd, msgs);
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                return ((InternalEList<?>)getEventChannelSinkConnector__EventChannel()).basicRemove(otherEnd, msgs);
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                return basicSetParentStructure__EventChannel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
                if (resolve) return getEventGroup__EventChannel();
                return basicGetEventGroup__EventChannel();
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                return getEventChannelSourceConnector__EventChannel();
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                return getEventChannelSinkConnector__EventChannel();
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                return getParentStructure__EventChannel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
                setEventGroup__EventChannel((EventGroup)newValue);
                return;
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                getEventChannelSourceConnector__EventChannel().clear();
                getEventChannelSourceConnector__EventChannel().addAll((Collection<? extends EventChannelSourceConnector>)newValue);
                return;
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                getEventChannelSinkConnector__EventChannel().clear();
                getEventChannelSinkConnector__EventChannel().addAll((Collection<? extends EventChannelSinkConnector>)newValue);
                return;
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                setParentStructure__EventChannel((ComposedStructure)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
                setEventGroup__EventChannel((EventGroup)null);
                return;
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                getEventChannelSourceConnector__EventChannel().clear();
                return;
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                getEventChannelSinkConnector__EventChannel().clear();
                return;
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                setParentStructure__EventChannel((ComposedStructure)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
                return eventGroup__EventChannel != null;
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
                return eventChannelSourceConnector__EventChannel != null && !eventChannelSourceConnector__EventChannel.isEmpty();
            case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
                return eventChannelSinkConnector__EventChannel != null && !eventChannelSinkConnector__EventChannel.isEmpty();
            case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
                return getParentStructure__EventChannel() != null;
        }
        return super.eIsSet(featureID);
    }

} // EventChannelImpl
