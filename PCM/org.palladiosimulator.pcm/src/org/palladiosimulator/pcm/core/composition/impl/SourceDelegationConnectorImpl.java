/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.SourceDelegationConnector;

import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SourceDelegationConnectorImpl#getInnerSourceRole__SourceRole <em>Inner Source Role Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SourceDelegationConnectorImpl#getOuterSourceRole__SourceRole <em>Outer Source Role Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.SourceDelegationConnectorImpl#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceDelegationConnectorImpl extends DelegationConnectorImpl implements SourceDelegationConnector {

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
    protected SourceDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole getInnerSourceRole__SourceRole() {
        return (SourceRole) eDynamicGet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole basicGetInnerSourceRole__SourceRole() {
        return (SourceRole) eDynamicGet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerSourceRole__SourceRole(SourceRole newInnerSourceRole__SourceRole) {
        eDynamicSet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                newInnerSourceRole__SourceRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole getOuterSourceRole__SourceRole() {
        return (SourceRole) eDynamicGet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole basicGetOuterSourceRole__SourceRole() {
        return (SourceRole) eDynamicGet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuterSourceRole__SourceRole(SourceRole newOuterSourceRole__SourceRole) {
        eDynamicSet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                newOuterSourceRole__SourceRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__SourceDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__SourceDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__SourceDelegationConnector(
            AssemblyContext newAssemblyContext__SourceDelegationConnector) {
        eDynamicSet(CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                newAssemblyContext__SourceDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            if (resolve)
                return getInnerSourceRole__SourceRole();
            return basicGetInnerSourceRole__SourceRole();
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            if (resolve)
                return getOuterSourceRole__SourceRole();
            return basicGetOuterSourceRole__SourceRole();
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            if (resolve)
                return getAssemblyContext__SourceDelegationConnector();
            return basicGetAssemblyContext__SourceDelegationConnector();
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            setInnerSourceRole__SourceRole((SourceRole) newValue);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            setOuterSourceRole__SourceRole((SourceRole) newValue);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            setAssemblyContext__SourceDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            setInnerSourceRole__SourceRole((SourceRole) null);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            setOuterSourceRole__SourceRole((SourceRole) null);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            setAssemblyContext__SourceDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            return basicGetInnerSourceRole__SourceRole() != null;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            return basicGetOuterSourceRole__SourceRole() != null;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            return basicGetAssemblyContext__SourceDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //SourceDelegationConnectorImpl
