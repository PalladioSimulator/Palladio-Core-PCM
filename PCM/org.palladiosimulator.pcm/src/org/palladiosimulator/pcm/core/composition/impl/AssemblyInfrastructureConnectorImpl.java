/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.AssemblyInfrastructureConnector;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Infrastructure Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getProvidedRole__AssemblyInfrastructureConnector <em>Provided Role Assembly Infrastructure Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getRequiredRole__AssemblyInfrastructureConnector <em>Required Role Assembly Infrastructure Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getProvidingAssemblyContext__AssemblyInfrastructureConnector <em>Providing Assembly Context Assembly Infrastructure Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getRequiringAssemblyContext__AssemblyInfrastructureConnector <em>Requiring Assembly Context Assembly Infrastructure Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyInfrastructureConnectorImpl extends ConnectorImpl implements AssemblyInfrastructureConnector {

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
    protected AssemblyInfrastructureConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole getProvidedRole__AssemblyInfrastructureConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole basicGetProvidedRole__AssemblyInfrastructureConnector() {
        return (InfrastructureProvidedRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProvidedRole__AssemblyInfrastructureConnector(
            InfrastructureProvidedRole newProvidedRole__AssemblyInfrastructureConnector) {
        eDynamicSet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                newProvidedRole__AssemblyInfrastructureConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole getRequiredRole__AssemblyInfrastructureConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureRequiredRole basicGetRequiredRole__AssemblyInfrastructureConnector() {
        return (InfrastructureRequiredRole) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiredRole__AssemblyInfrastructureConnector(
            InfrastructureRequiredRole newRequiredRole__AssemblyInfrastructureConnector) {
        eDynamicSet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                newRequiredRole__AssemblyInfrastructureConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getProvidingAssemblyContext__AssemblyInfrastructureConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetProvidingAssemblyContext__AssemblyInfrastructureConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProvidingAssemblyContext__AssemblyInfrastructureConnector(
            AssemblyContext newProvidingAssemblyContext__AssemblyInfrastructureConnector) {
        eDynamicSet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                newProvidingAssemblyContext__AssemblyInfrastructureConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getRequiringAssemblyContext__AssemblyInfrastructureConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetRequiringAssemblyContext__AssemblyInfrastructureConnector() {
        return (AssemblyContext) eDynamicGet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiringAssemblyContext__AssemblyInfrastructureConnector(
            AssemblyContext newRequiringAssemblyContext__AssemblyInfrastructureConnector) {
        eDynamicSet(
                CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                newRequiringAssemblyContext__AssemblyInfrastructureConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve)
                return getProvidedRole__AssemblyInfrastructureConnector();
            return basicGetProvidedRole__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve)
                return getRequiredRole__AssemblyInfrastructureConnector();
            return basicGetRequiredRole__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve)
                return getProvidingAssemblyContext__AssemblyInfrastructureConnector();
            return basicGetProvidingAssemblyContext__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve)
                return getRequiringAssemblyContext__AssemblyInfrastructureConnector();
            return basicGetRequiringAssemblyContext__AssemblyInfrastructureConnector();
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setProvidedRole__AssemblyInfrastructureConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setRequiredRole__AssemblyInfrastructureConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setProvidingAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setRequiringAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) newValue);
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setProvidedRole__AssemblyInfrastructureConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setRequiredRole__AssemblyInfrastructureConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setProvidingAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            setRequiringAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) null);
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return basicGetProvidedRole__AssemblyInfrastructureConnector() != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return basicGetRequiredRole__AssemblyInfrastructureConnector() != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return basicGetProvidingAssemblyContext__AssemblyInfrastructureConnector() != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return basicGetRequiringAssemblyContext__AssemblyInfrastructureConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //AssemblyInfrastructureConnectorImpl
