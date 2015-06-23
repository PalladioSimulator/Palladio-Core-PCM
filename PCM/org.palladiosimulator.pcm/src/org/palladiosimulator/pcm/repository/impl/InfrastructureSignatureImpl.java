/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.InfrastructureSignatureImpl#getParameters__InfrastructureSignature <em>Parameters Infrastructure Signature</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.InfrastructureSignatureImpl#getInfrastructureInterface__InfrastructureSignature <em>Infrastructure Interface Infrastructure Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfrastructureSignatureImpl extends SignatureImpl implements InfrastructureSignature {

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
    protected InfrastructureSignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INFRASTRUCTURE_SIGNATURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<Parameter> getParameters__InfrastructureSignature() {
        return (EList<Parameter>) eDynamicGet(
                RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE,
                RepositoryPackage.Literals.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureInterface getInfrastructureInterface__InfrastructureSignature() {
        return (InfrastructureInterface) eDynamicGet(
                RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE,
                RepositoryPackage.Literals.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInfrastructureInterface__InfrastructureSignature(
            InfrastructureInterface newInfrastructureInterface__InfrastructureSignature, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newInfrastructureInterface__InfrastructureSignature,
                RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInfrastructureInterface__InfrastructureSignature(
            InfrastructureInterface newInfrastructureInterface__InfrastructureSignature) {
        eDynamicSet(RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE,
                RepositoryPackage.Literals.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE,
                newInfrastructureInterface__InfrastructureSignature);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getParameters__InfrastructureSignature())
                    .basicAdd(otherEnd, msgs);
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) otherEnd, msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return ((InternalEList<?>) getParameters__InfrastructureSignature()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return basicSetInfrastructureInterface__InfrastructureSignature(null, msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.INFRASTRUCTURE_INTERFACE__INFRASTRUCTURE_SIGNATURES_INFRASTRUCTURE_INTERFACE,
                    InfrastructureInterface.class, msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return getParameters__InfrastructureSignature();
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return getInfrastructureInterface__InfrastructureSignature();
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            getParameters__InfrastructureSignature().clear();
            getParameters__InfrastructureSignature().addAll((Collection<? extends Parameter>) newValue);
            return;
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            setInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) newValue);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            getParameters__InfrastructureSignature().clear();
            return;
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            setInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) null);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return !getParameters__InfrastructureSignature().isEmpty();
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return getInfrastructureInterface__InfrastructureSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} //InfrastructureSignatureImpl
