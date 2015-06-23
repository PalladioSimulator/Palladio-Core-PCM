/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.RequiredInfrastructureDelegationConnector;

import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Infrastructure Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getInnerRequiredRole__RequiredInfrastructureDelegationConnector <em>Inner Required Role Required Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getOuterRequiredRole__RequiredInfrastructureDelegationConnector <em>Outer Required Role Required Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getAssemblyContext__RequiredInfrastructureDelegationConnector <em>Assembly Context Required Infrastructure Delegation Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequiredInfrastructureDelegationConnectorImpl extends DelegationConnectorImpl
        implements RequiredInfrastructureDelegationConnector {

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
    protected RequiredInfrastructureDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole getInnerRequiredRole__RequiredInfrastructureDelegationConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole basicGetInnerRequiredRole__RequiredInfrastructureDelegationConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerRequiredRole__RequiredInfrastructureDelegationConnector(
            InfrastructureRequiredRole newInnerRequiredRole__RequiredInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newInnerRequiredRole__RequiredInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole getOuterRequiredRole__RequiredInfrastructureDelegationConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole basicGetOuterRequiredRole__RequiredInfrastructureDelegationConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuterRequiredRole__RequiredInfrastructureDelegationConnector(
            InfrastructureRequiredRole newOuterRequiredRole__RequiredInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newOuterRequiredRole__RequiredInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__RequiredInfrastructureDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__RequiredInfrastructureDelegationConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__RequiredInfrastructureDelegationConnector(
            AssemblyContext newAssemblyContext__RequiredInfrastructureDelegationConnector) {
        eDynamicSet(
                CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                newAssemblyContext__RequiredInfrastructureDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getInnerRequiredRole__RequiredInfrastructureDelegationConnector();
            return basicGetInnerRequiredRole__RequiredInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getOuterRequiredRole__RequiredInfrastructureDelegationConnector();
            return basicGetOuterRequiredRole__RequiredInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve)
                return getAssemblyContext__RequiredInfrastructureDelegationConnector();
            return basicGetAssemblyContext__RequiredInfrastructureDelegationConnector();
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setInnerRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setOuterRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setAssemblyContext__RequiredInfrastructureDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setInnerRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setOuterRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            setAssemblyContext__RequiredInfrastructureDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetInnerRequiredRole__RequiredInfrastructureDelegationConnector() != null;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetOuterRequiredRole__RequiredInfrastructureDelegationConnector() != null;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return basicGetAssemblyContext__RequiredInfrastructureDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //RequiredInfrastructureDelegationConnectorImpl
