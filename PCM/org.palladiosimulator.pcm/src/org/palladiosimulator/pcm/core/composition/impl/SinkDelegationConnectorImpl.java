/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.SinkDelegationConnector;

import org.palladiosimulator.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sink Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SinkDelegationConnectorImpl#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SinkDelegationConnectorImpl#getInnerSinkRole__SinkRole <em>Inner Sink Role Sink Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SinkDelegationConnectorImpl#getOuterSinkRole__SinkRole <em>Outer Sink Role Sink Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SinkDelegationConnectorImpl extends DelegationConnectorImpl implements SinkDelegationConnector {

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
    protected SinkDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__SinkDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__SinkDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__SinkDelegationConnector(
            AssemblyContext newAssemblyContext__SinkDelegationConnector) {
        eDynamicSet(CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                newAssemblyContext__SinkDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getInnerSinkRole__SinkRole() {
        return (SinkRole) eDynamicGet(CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetInnerSinkRole__SinkRole() {
        return (SinkRole) eDynamicGet(CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerSinkRole__SinkRole(SinkRole newInnerSinkRole__SinkRole) {
        eDynamicSet(CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                newInnerSinkRole__SinkRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getOuterSinkRole__SinkRole() {
        return (SinkRole) eDynamicGet(CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetOuterSinkRole__SinkRole() {
        return (SinkRole) eDynamicGet(CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuterSinkRole__SinkRole(SinkRole newOuterSinkRole__SinkRole) {
        eDynamicSet(CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                newOuterSinkRole__SinkRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            if (resolve)
                return getAssemblyContext__SinkDelegationConnector();
            return basicGetAssemblyContext__SinkDelegationConnector();
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            if (resolve)
                return getInnerSinkRole__SinkRole();
            return basicGetInnerSinkRole__SinkRole();
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            if (resolve)
                return getOuterSinkRole__SinkRole();
            return basicGetOuterSinkRole__SinkRole();
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            setAssemblyContext__SinkDelegationConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            setInnerSinkRole__SinkRole((SinkRole) newValue);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            setOuterSinkRole__SinkRole((SinkRole) newValue);
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            setAssemblyContext__SinkDelegationConnector((AssemblyContext) null);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            setInnerSinkRole__SinkRole((SinkRole) null);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            setOuterSinkRole__SinkRole((SinkRole) null);
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            return basicGetAssemblyContext__SinkDelegationConnector() != null;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            return basicGetInnerSinkRole__SinkRole() != null;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            return basicGetOuterSinkRole__SinkRole() != null;
        }
        return super.eIsSet(featureID);
    }

} //SinkDelegationConnectorImpl
