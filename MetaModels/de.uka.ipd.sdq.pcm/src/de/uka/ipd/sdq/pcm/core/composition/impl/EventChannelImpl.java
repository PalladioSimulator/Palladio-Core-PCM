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
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Event Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventGroup__EventChannel
 * <em>Event Group Event Channel</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventChannelSourceConnector__EventChannel
 * <em>Event Channel Source Connector Event Channel</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getEventChannelSinkConnector__EventChannel
 * <em>Event Channel Sink Connector Event Channel</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelImpl#getParentStructure__EventChannel
 * <em>Parent Structure Event Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventChannelImpl extends EntityImpl implements EventChannel {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getEventGroup__EventChannel()
     * <em>Event Group Event Channel</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEventGroup__EventChannel()
     * @generated
     * @ordered
     */
    protected EventGroup eventGroup__EventChannel;
    /**
     * The cached value of the '{@link #getEventChannelSourceConnector__EventChannel()
     * <em>Event Channel Source Connector Event Channel</em>}' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getEventChannelSourceConnector__EventChannel()
     * @generated
     * @ordered
     */
    protected EList<EventChannelSourceConnector> eventChannelSourceConnector__EventChannel;
    /**
     * The cached value of the '{@link #getEventChannelSinkConnector__EventChannel()
     * <em>Event Channel Sink Connector Event Channel</em>}' reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getEventChannelSinkConnector__EventChannel()
     * @generated
     * @ordered
     */
    protected EList<EventChannelSinkConnector> eventChannelSinkConnector__EventChannel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EventChannelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getEventGroup__EventChannel() {
        if (this.eventGroup__EventChannel != null && this.eventGroup__EventChannel.eIsProxy()) {
            final InternalEObject oldEventGroup__EventChannel = (InternalEObject) this.eventGroup__EventChannel;
            this.eventGroup__EventChannel = (EventGroup) this.eResolveProxy(oldEventGroup__EventChannel);
            if (this.eventGroup__EventChannel != oldEventGroup__EventChannel) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, oldEventGroup__EventChannel,
                            this.eventGroup__EventChannel));
                }
            }
        }
        return this.eventGroup__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventGroup basicGetEventGroup__EventChannel() {
        return this.eventGroup__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventGroup__EventChannel(final EventGroup newEventGroup__EventChannel) {
        final EventGroup oldEventGroup__EventChannel = this.eventGroup__EventChannel;
        this.eventGroup__EventChannel = newEventGroup__EventChannel;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, oldEventGroup__EventChannel,
                    this.eventGroup__EventChannel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<EventChannelSourceConnector> getEventChannelSourceConnector__EventChannel() {
        if (this.eventChannelSourceConnector__EventChannel == null) {
            this.eventChannelSourceConnector__EventChannel = new EObjectWithInverseResolvingEList<EventChannelSourceConnector>(
                    EventChannelSourceConnector.class, this,
                    CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
                    CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR);
        }
        return this.eventChannelSourceConnector__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<EventChannelSinkConnector> getEventChannelSinkConnector__EventChannel() {
        if (this.eventChannelSinkConnector__EventChannel == null) {
            this.eventChannelSinkConnector__EventChannel = new EObjectWithInverseResolvingEList<EventChannelSinkConnector>(
                    EventChannelSinkConnector.class, this,
                    CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR);
        }
        return this.eventChannelSinkConnector__EventChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComposedStructure getParentStructure__EventChannel() {
        if (this.eContainerFeatureID() != CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL) {
            return null;
        }
        return (ComposedStructure) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParentStructure__EventChannel(
            final ComposedStructure newParentStructure__EventChannel, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParentStructure__EventChannel,
                CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentStructure__EventChannel(final ComposedStructure newParentStructure__EventChannel) {
        if (newParentStructure__EventChannel != this.eInternalContainer()
                || (this.eContainerFeatureID() != CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL && newParentStructure__EventChannel != null)) {
            if (EcoreUtil.isAncestor(this, newParentStructure__EventChannel)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParentStructure__EventChannel != null) {
                msgs = ((InternalEObject) newParentStructure__EventChannel).eInverseAdd(this,
                        CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE,
                        ComposedStructure.class, msgs);
            }
            msgs = this.basicSetParentStructure__EventChannel(newParentStructure__EventChannel, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, newParentStructure__EventChannel,
                    newParentStructure__EventChannel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getEventChannelSourceConnector__EventChannel()).basicAdd(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getEventChannelSinkConnector__EventChannel()).basicAdd(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParentStructure__EventChannel((ComposedStructure) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<?>) this.getEventChannelSourceConnector__EventChannel()).basicRemove(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<?>) this.getEventChannelSinkConnector__EventChannel()).basicRemove(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return this.basicSetParentStructure__EventChannel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return this.eInternalContainer().eInverseRemove(this,
                    CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, ComposedStructure.class,
                    msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            if (resolve) {
                return this.getEventGroup__EventChannel();
            }
            return this.basicGetEventGroup__EventChannel();
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return this.getEventChannelSourceConnector__EventChannel();
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return this.getEventChannelSinkConnector__EventChannel();
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return this.getParentStructure__EventChannel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            this.setEventGroup__EventChannel((EventGroup) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            this.getEventChannelSourceConnector__EventChannel().clear();
            this.getEventChannelSourceConnector__EventChannel().addAll(
                    (Collection<? extends EventChannelSourceConnector>) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            this.getEventChannelSinkConnector__EventChannel().clear();
            this.getEventChannelSinkConnector__EventChannel().addAll(
                    (Collection<? extends EventChannelSinkConnector>) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            this.setParentStructure__EventChannel((ComposedStructure) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            this.setEventGroup__EventChannel((EventGroup) null);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            this.getEventChannelSourceConnector__EventChannel().clear();
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            this.getEventChannelSinkConnector__EventChannel().clear();
            return;
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            this.setParentStructure__EventChannel((ComposedStructure) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            return this.eventGroup__EventChannel != null;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return this.eventChannelSourceConnector__EventChannel != null
            && !this.eventChannelSourceConnector__EventChannel.isEmpty();
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return this.eventChannelSinkConnector__EventChannel != null
            && !this.eventChannelSinkConnector__EventChannel.isEmpty();
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return this.getParentStructure__EventChannel() != null;
        }
        return super.eIsSet(featureID);
    }

} // EventChannelImpl
