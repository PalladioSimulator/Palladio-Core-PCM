/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.AssemblyEventConnector;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Event Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSinkRole__AssemblyEventConnector <em>Sink Role Assembly Event Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSourceRole__AssemblyEventConnector <em>Source Role Assembly Event Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSinkAssemblyContext__AssemblyEventConnector <em>Sink Assembly Context Assembly Event Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSourceAssemblyContext__AssemblyEventConnector <em>Source Assembly Context Assembly Event Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyEventConnectorImpl#getFilterCondition__AssemblyEventConnector <em>Filter Condition Assembly Event Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyEventConnectorImpl extends ConnectorImpl implements AssemblyEventConnector {

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
    protected AssemblyEventConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getSinkRole__AssemblyEventConnector() {
        return (SinkRole) eDynamicGet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetSinkRole__AssemblyEventConnector() {
        return (SinkRole) eDynamicGet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSinkRole__AssemblyEventConnector(SinkRole newSinkRole__AssemblyEventConnector) {
        eDynamicSet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                newSinkRole__AssemblyEventConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole getSourceRole__AssemblyEventConnector() {
        return (SourceRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole basicGetSourceRole__AssemblyEventConnector() {
        return (SourceRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR, false,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceRole__AssemblyEventConnector(SourceRole newSourceRole__AssemblyEventConnector) {
        eDynamicSet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                newSourceRole__AssemblyEventConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getSinkAssemblyContext__AssemblyEventConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetSinkAssemblyContext__AssemblyEventConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSinkAssemblyContext__AssemblyEventConnector(
            AssemblyContext newSinkAssemblyContext__AssemblyEventConnector) {
        eDynamicSet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                newSinkAssemblyContext__AssemblyEventConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getSourceAssemblyContext__AssemblyEventConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetSourceAssemblyContext__AssemblyEventConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceAssemblyContext__AssemblyEventConnector(
            AssemblyContext newSourceAssemblyContext__AssemblyEventConnector) {
        eDynamicSet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                newSourceAssemblyContext__AssemblyEventConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getFilterCondition__AssemblyEventConnector() {
        return (PCMRandomVariable) eDynamicGet(
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFilterCondition__AssemblyEventConnector(
            PCMRandomVariable newFilterCondition__AssemblyEventConnector, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newFilterCondition__AssemblyEventConnector,
                CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilterCondition__AssemblyEventConnector(
            PCMRandomVariable newFilterCondition__AssemblyEventConnector) {
        eDynamicSet(CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                newFilterCondition__AssemblyEventConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            PCMRandomVariable filterCondition__AssemblyEventConnector = getFilterCondition__AssemblyEventConnector();
            if (filterCondition__AssemblyEventConnector != null)
                msgs = ((InternalEObject) filterCondition__AssemblyEventConnector).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                        null, msgs);
            return basicSetFilterCondition__AssemblyEventConnector((PCMRandomVariable) otherEnd, msgs);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return basicSetFilterCondition__AssemblyEventConnector(null, msgs);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSinkRole__AssemblyEventConnector();
            return basicGetSinkRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSourceRole__AssemblyEventConnector();
            return basicGetSourceRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSinkAssemblyContext__AssemblyEventConnector();
            return basicGetSinkAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSourceAssemblyContext__AssemblyEventConnector();
            return basicGetSourceAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return getFilterCondition__AssemblyEventConnector();
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSinkRole__AssemblyEventConnector((SinkRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSourceRole__AssemblyEventConnector((SourceRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            setFilterCondition__AssemblyEventConnector((PCMRandomVariable) newValue);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSinkRole__AssemblyEventConnector((SinkRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSourceRole__AssemblyEventConnector((SourceRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            setFilterCondition__AssemblyEventConnector((PCMRandomVariable) null);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return basicGetSinkRole__AssemblyEventConnector() != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return basicGetSourceRole__AssemblyEventConnector() != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return basicGetSinkAssemblyContext__AssemblyEventConnector() != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return basicGetSourceAssemblyContext__AssemblyEventConnector() != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return getFilterCondition__AssemblyEventConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //AssemblyEventConnectorImpl
