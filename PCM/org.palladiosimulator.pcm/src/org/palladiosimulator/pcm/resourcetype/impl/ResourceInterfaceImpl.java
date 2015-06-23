/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourcetype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourceSignature;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceInterfaceImpl#getResourceRepository__ResourceInterface <em>Resource Repository Resource Interface</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceInterfaceImpl#getResourceSignatures__ResourceInterface <em>Resource Signatures Resource Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceInterfaceImpl extends EntityImpl implements ResourceInterface {

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
    protected ResourceInterfaceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.RESOURCE_INTERFACE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRepository getResourceRepository__ResourceInterface() {
        return (ResourceRepository) eDynamicGet(
                ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE,
                ResourcetypePackage.Literals.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceRepository__ResourceInterface(
            ResourceRepository newResourceRepository__ResourceInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceRepository__ResourceInterface,
                ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceRepository__ResourceInterface(ResourceRepository newResourceRepository__ResourceInterface) {
        eDynamicSet(ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE,
                ResourcetypePackage.Literals.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE,
                newResourceRepository__ResourceInterface);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ResourceSignature> getResourceSignatures__ResourceInterface() {
        return (EList<ResourceSignature>) eDynamicGet(
                ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE,
                ResourcetypePackage.Literals.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE, true, true);
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceRepository__ResourceInterface((ResourceRepository) otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getResourceSignatures__ResourceInterface())
                    .basicAdd(otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            return basicSetResourceRepository__ResourceInterface(null, msgs);
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            return ((InternalEList<?>) getResourceSignatures__ResourceInterface()).basicRemove(otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            return eInternalContainer().eInverseRemove(this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY,
                    ResourceRepository.class, msgs);
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            return getResourceRepository__ResourceInterface();
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            return getResourceSignatures__ResourceInterface();
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            setResourceRepository__ResourceInterface((ResourceRepository) newValue);
            return;
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            getResourceSignatures__ResourceInterface().clear();
            getResourceSignatures__ResourceInterface().addAll((Collection<? extends ResourceSignature>) newValue);
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            setResourceRepository__ResourceInterface((ResourceRepository) null);
            return;
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            getResourceSignatures__ResourceInterface().clear();
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
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE:
            return getResourceRepository__ResourceInterface() != null;
        case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE:
            return !getResourceSignatures__ResourceInterface().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ResourceInterfaceImpl
