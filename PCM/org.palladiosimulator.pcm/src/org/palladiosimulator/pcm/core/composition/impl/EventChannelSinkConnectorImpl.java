/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.EventChannelSinkConnector;

import org.palladiosimulator.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getSinkRole__EventChannelSinkConnector <em>Sink Role Event Channel Sink Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getFilterCondition__EventChannelSinkConnector <em>Filter Condition Event Channel Sink Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getAssemblyContext__EventChannelSinkConnector <em>Assembly Context Event Channel Sink Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getEventChannel__EventChannelSinkConnector <em>Event Channel Event Channel Sink Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventChannelSinkConnectorImpl extends ConnectorImpl implements EventChannelSinkConnector {

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
    protected EventChannelSinkConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getSinkRole__EventChannelSinkConnector() {
        return (SinkRole) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetSinkRole__EventChannelSinkConnector() {
        return (SinkRole) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR, false,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSinkRole__EventChannelSinkConnector(SinkRole newSinkRole__EventChannelSinkConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                newSinkRole__EventChannelSinkConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getFilterCondition__EventChannelSinkConnector() {
        return (PCMRandomVariable) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFilterCondition__EventChannelSinkConnector(
            PCMRandomVariable newFilterCondition__EventChannelSinkConnector, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newFilterCondition__EventChannelSinkConnector,
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilterCondition__EventChannelSinkConnector(
            PCMRandomVariable newFilterCondition__EventChannelSinkConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                newFilterCondition__EventChannelSinkConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__EventChannelSinkConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__EventChannelSinkConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__EventChannelSinkConnector(
            AssemblyContext newAssemblyContext__EventChannelSinkConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                newAssemblyContext__EventChannelSinkConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannel getEventChannel__EventChannelSinkConnector() {
        return (EventChannel) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannel basicGetEventChannel__EventChannelSinkConnector() {
        return (EventChannel) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEventChannel__EventChannelSinkConnector(
            EventChannel newEventChannel__EventChannelSinkConnector, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newEventChannel__EventChannelSinkConnector,
                CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventChannel__EventChannelSinkConnector(EventChannel newEventChannel__EventChannelSinkConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                newEventChannel__EventChannelSinkConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            PCMRandomVariable filterCondition__EventChannelSinkConnector = getFilterCondition__EventChannelSinkConnector();
            if (filterCondition__EventChannelSinkConnector != null)
                msgs = ((InternalEObject) filterCondition__EventChannelSinkConnector).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                        null, msgs);
            return basicSetFilterCondition__EventChannelSinkConnector((PCMRandomVariable) otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            EventChannel eventChannel__EventChannelSinkConnector = basicGetEventChannel__EventChannelSinkConnector();
            if (eventChannel__EventChannelSinkConnector != null)
                msgs = ((InternalEObject) eventChannel__EventChannelSinkConnector).eInverseRemove(this,
                        CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                        EventChannel.class, msgs);
            return basicSetEventChannel__EventChannelSinkConnector((EventChannel) otherEnd, msgs);
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
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return basicSetFilterCondition__EventChannelSinkConnector(null, msgs);
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            return basicSetEventChannel__EventChannelSinkConnector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve)
                return getSinkRole__EventChannelSinkConnector();
            return basicGetSinkRole__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return getFilterCondition__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve)
                return getAssemblyContext__EventChannelSinkConnector();
            return basicGetAssemblyContext__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve)
                return getEventChannel__EventChannelSinkConnector();
            return basicGetEventChannel__EventChannelSinkConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            setSinkRole__EventChannelSinkConnector((SinkRole) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            setFilterCondition__EventChannelSinkConnector((PCMRandomVariable) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            setAssemblyContext__EventChannelSinkConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            setEventChannel__EventChannelSinkConnector((EventChannel) newValue);
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
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            setSinkRole__EventChannelSinkConnector((SinkRole) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            setFilterCondition__EventChannelSinkConnector((PCMRandomVariable) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            setAssemblyContext__EventChannelSinkConnector((AssemblyContext) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            setEventChannel__EventChannelSinkConnector((EventChannel) null);
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
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            return basicGetSinkRole__EventChannelSinkConnector() != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return getFilterCondition__EventChannelSinkConnector() != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            return basicGetAssemblyContext__EventChannelSinkConnector() != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            return basicGetEventChannel__EventChannelSinkConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //EventChannelSinkConnectorImpl
