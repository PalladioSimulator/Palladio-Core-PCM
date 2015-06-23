/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.EventChannelSinkConnector;
import org.palladiosimulator.pcm.core.composition.EventChannelSourceConnector;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl#getEventGroup__EventChannel <em>Event Group Event Channel</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl#getEventChannelSourceConnector__EventChannel <em>Event Channel Source Connector Event Channel</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl#getEventChannelSinkConnector__EventChannel <em>Event Channel Sink Connector Event Channel</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl#getParentStructure__EventChannel <em>Parent Structure Event Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventChannelImpl extends EntityImpl implements EventChannel {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventChannelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventGroup getEventGroup__EventChannel() {
        return (EventGroup) eDynamicGet(CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventGroup basicGetEventGroup__EventChannel() {
        return (EventGroup) eDynamicGet(CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventGroup__EventChannel(EventGroup newEventGroup__EventChannel) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL, newEventGroup__EventChannel);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<EventChannelSourceConnector> getEventChannelSourceConnector__EventChannel() {
        return (EList<EventChannelSourceConnector>) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<EventChannelSinkConnector> getEventChannelSinkConnector__EventChannel() {
        return (EList<EventChannelSinkConnector>) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposedStructure getParentStructure__EventChannel() {
        return (ComposedStructure) eDynamicGet(CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParentStructure__EventChannel(ComposedStructure newParentStructure__EventChannel,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newParentStructure__EventChannel,
                CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentStructure__EventChannel(ComposedStructure newParentStructure__EventChannel) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL,
                CompositionPackage.Literals.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL,
                newParentStructure__EventChannel);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getEventChannelSourceConnector__EventChannel())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getEventChannelSinkConnector__EventChannel())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParentStructure__EventChannel((ComposedStructure) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<?>) getEventChannelSourceConnector__EventChannel()).basicRemove(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return ((InternalEList<?>) getEventChannelSinkConnector__EventChannel()).basicRemove(otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return basicSetParentStructure__EventChannel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return eInternalContainer().eInverseRemove(this,
                    CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, ComposedStructure.class,
                    msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            if (resolve)
                return getEventGroup__EventChannel();
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            setEventGroup__EventChannel((EventGroup) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            getEventChannelSourceConnector__EventChannel().clear();
            getEventChannelSourceConnector__EventChannel()
                    .addAll((Collection<? extends EventChannelSourceConnector>) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            getEventChannelSinkConnector__EventChannel().clear();
            getEventChannelSinkConnector__EventChannel()
                    .addAll((Collection<? extends EventChannelSinkConnector>) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            setParentStructure__EventChannel((ComposedStructure) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            setEventGroup__EventChannel((EventGroup) null);
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            getEventChannelSourceConnector__EventChannel().clear();
            return;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            getEventChannelSinkConnector__EventChannel().clear();
            return;
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            setParentStructure__EventChannel((ComposedStructure) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL:
            return basicGetEventGroup__EventChannel() != null;
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL:
            return !getEventChannelSourceConnector__EventChannel().isEmpty();
        case CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL:
            return !getEventChannelSinkConnector__EventChannel().isEmpty();
        case CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL:
            return getParentStructure__EventChannel() != null;
        }
        return super.eIsSet(featureID);
    }

} //EventChannelImpl
