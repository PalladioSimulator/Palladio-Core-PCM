/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.ResourceRequiredDelegationConnector;

import org.palladiosimulator.pcm.core.entity.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector <em>Inner Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector <em>Outer Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceRequiredDelegationConnectorImpl extends CDOObjectImpl
        implements ResourceRequiredDelegationConnector {

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
    protected ResourceRequiredDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRequiredRole getInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return (ResourceRequiredRole) eDynamicGet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRequiredRole basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return (ResourceRequiredRole) eDynamicGet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(
            ResourceRequiredRole newInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
        eDynamicSet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                newInnerResourceRequiredRole_ResourceRequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRequiredRole getOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return (ResourceRequiredRole) eDynamicGet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRequiredRole basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return (ResourceRequiredRole) eDynamicGet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(
            ResourceRequiredRole newOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
        eDynamicSet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                newOuterResourceRequiredRole_ResourceRequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposedStructure getParentStructure_ResourceRequiredDelegationConnector() {
        return (ComposedStructure) eDynamicGet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParentStructure_ResourceRequiredDelegationConnector(
            ComposedStructure newParentStructure_ResourceRequiredDelegationConnector, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newParentStructure_ResourceRequiredDelegationConnector,
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentStructure_ResourceRequiredDelegationConnector(
            ComposedStructure newParentStructure_ResourceRequiredDelegationConnector) {
        eDynamicSet(
                CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                newParentStructure_ResourceRequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) otherEnd, msgs);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return basicSetParentStructure_ResourceRequiredDelegationConnector(null, msgs);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return eInternalContainer().eInverseRemove(this,
                    CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                    ComposedStructure.class, msgs);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve)
                return getInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
            return basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve)
                return getOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
            return basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return getParentStructure_ResourceRequiredDelegationConnector();
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) newValue);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) newValue);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) newValue);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) null);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) null);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) null);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() != null;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() != null;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return getParentStructure_ResourceRequiredDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceRequiredDelegationConnectorImpl
