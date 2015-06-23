/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.EventChannelSourceConnector;

import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Channel Source Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getSourceRole__EventChannelSourceRole <em>Source Role Event Channel Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getAssemblyContext__EventChannelSourceConnector <em>Assembly Context Event Channel Source Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getEventChannel__EventChannelSourceConnector <em>Event Channel Event Channel Source Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventChannelSourceConnectorImpl extends ConnectorImpl implements EventChannelSourceConnector {

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
    protected EventChannelSourceConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole getSourceRole__EventChannelSourceRole() {
        return (SourceRole) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole basicGetSourceRole__EventChannelSourceRole() {
        return (SourceRole) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceRole__EventChannelSourceRole(SourceRole newSourceRole__EventChannelSourceRole) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
                newSourceRole__EventChannelSourceRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__EventChannelSourceConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__EventChannelSourceConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__EventChannelSourceConnector(
            AssemblyContext newAssemblyContext__EventChannelSourceConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
                newAssemblyContext__EventChannelSourceConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannel getEventChannel__EventChannelSourceConnector() {
        return (EventChannel) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannel basicGetEventChannel__EventChannelSourceConnector() {
        return (EventChannel) eDynamicGet(
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEventChannel__EventChannelSourceConnector(
            EventChannel newEventChannel__EventChannelSourceConnector, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newEventChannel__EventChannelSourceConnector,
                CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventChannel__EventChannelSourceConnector(
            EventChannel newEventChannel__EventChannelSourceConnector) {
        eDynamicSet(CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
                newEventChannel__EventChannelSourceConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            EventChannel eventChannel__EventChannelSourceConnector = basicGetEventChannel__EventChannelSourceConnector();
            if (eventChannel__EventChannelSourceConnector != null)
                msgs = ((InternalEObject) eventChannel__EventChannelSourceConnector).eInverseRemove(this,
                        CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
                        EventChannel.class, msgs);
            return basicSetEventChannel__EventChannelSourceConnector((EventChannel) otherEnd, msgs);
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
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            return basicSetEventChannel__EventChannelSourceConnector(null, msgs);
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
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
            if (resolve)
                return getSourceRole__EventChannelSourceRole();
            return basicGetSourceRole__EventChannelSourceRole();
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
            if (resolve)
                return getAssemblyContext__EventChannelSourceConnector();
            return basicGetAssemblyContext__EventChannelSourceConnector();
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            if (resolve)
                return getEventChannel__EventChannelSourceConnector();
            return basicGetEventChannel__EventChannelSourceConnector();
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
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
            setSourceRole__EventChannelSourceRole((SourceRole) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
            setAssemblyContext__EventChannelSourceConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            setEventChannel__EventChannelSourceConnector((EventChannel) newValue);
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
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
            setSourceRole__EventChannelSourceRole((SourceRole) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
            setAssemblyContext__EventChannelSourceConnector((AssemblyContext) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            setEventChannel__EventChannelSourceConnector((EventChannel) null);
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
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
            return basicGetSourceRole__EventChannelSourceRole() != null;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
            return basicGetAssemblyContext__EventChannelSourceConnector() != null;
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
            return basicGetEventChannel__EventChannelSourceConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //EventChannelSourceConnectorImpl
