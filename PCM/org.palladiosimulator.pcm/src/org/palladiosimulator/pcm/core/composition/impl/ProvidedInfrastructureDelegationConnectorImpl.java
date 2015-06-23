/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.ProvidedInfrastructureDelegationConnector;

import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Infrastructure Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getInnerProvidedRole__ProvidedInfrastructureDelegationConnector <em>Inner Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getOuterProvidedRole__ProvidedInfrastructureDelegationConnector <em>Outer Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getAssemblyContext__ProvidedInfrastructureDelegationConnector <em>Assembly Context Provided Infrastructure Delegation Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProvidedInfrastructureDelegationConnectorImpl extends DelegationConnectorImpl
        implements ProvidedInfrastructureDelegationConnector {

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
    protected ProvidedInfrastructureDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole getInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerProvidedRole__ProvidedInfrastructureDelegationConnector(
            InfrastructureProvidedRole newInnerProvidedRole__ProvidedInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newInnerProvidedRole__ProvidedInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole getOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuterProvidedRole__ProvidedInfrastructureDelegationConnector(
            InfrastructureProvidedRole newOuterProvidedRole__ProvidedInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newOuterProvidedRole__ProvidedInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__ProvidedInfrastructureDelegationConnector(
            AssemblyContext newAssemblyContext__ProvidedInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newAssemblyContext__ProvidedInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
            return basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
            return basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getAssemblyContext__ProvidedInfrastructureDelegationConnector();
            return basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector();
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector() != null;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector() != null;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //ProvidedInfrastructureDelegationConnectorImpl
