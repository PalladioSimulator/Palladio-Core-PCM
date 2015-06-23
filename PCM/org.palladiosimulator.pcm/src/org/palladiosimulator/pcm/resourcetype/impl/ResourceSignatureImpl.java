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

import org.palladiosimulator.pcm.repository.Parameter;

import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceSignature;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceSignatureImpl#getParameter__ResourceSignature <em>Parameter Resource Signature</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceSignatureImpl#getResourceServiceId <em>Resource Service Id</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceSignatureImpl#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceSignatureImpl extends EntityImpl implements ResourceSignature {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getResourceServiceId() <em>Resource Service Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceServiceId()
     * @generated
     * @ordered
     */
    protected static final int RESOURCE_SERVICE_ID_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceSignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.RESOURCE_SIGNATURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<Parameter> getParameter__ResourceSignature() {
        return (EList<Parameter>) eDynamicGet(ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE,
                ResourcetypePackage.Literals.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getResourceServiceId() {
        return (Integer) eDynamicGet(ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID,
                ResourcetypePackage.Literals.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceServiceId(int newResourceServiceId) {
        eDynamicSet(ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID,
                ResourcetypePackage.Literals.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID, newResourceServiceId);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceInterface getResourceInterface__ResourceSignature() {
        return (ResourceInterface) eDynamicGet(
                ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE,
                ResourcetypePackage.Literals.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceInterface__ResourceSignature(
            ResourceInterface newResourceInterface__ResourceSignature, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceInterface__ResourceSignature,
                ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceInterface__ResourceSignature(ResourceInterface newResourceInterface__ResourceSignature) {
        eDynamicSet(ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE,
                ResourcetypePackage.Literals.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE,
                newResourceInterface__ResourceSignature);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getParameter__ResourceSignature())
                    .basicAdd(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceInterface__ResourceSignature((ResourceInterface) otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            return ((InternalEList<?>) getParameter__ResourceSignature()).basicRemove(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            return basicSetResourceInterface__ResourceSignature(null, msgs);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            return eInternalContainer().eInverseRemove(this,
                    ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE,
                    ResourceInterface.class, msgs);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            return getParameter__ResourceSignature();
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID:
            return getResourceServiceId();
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            return getResourceInterface__ResourceSignature();
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            getParameter__ResourceSignature().clear();
            getParameter__ResourceSignature().addAll((Collection<? extends Parameter>) newValue);
            return;
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID:
            setResourceServiceId((Integer) newValue);
            return;
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            setResourceInterface__ResourceSignature((ResourceInterface) newValue);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            getParameter__ResourceSignature().clear();
            return;
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID:
            setResourceServiceId(RESOURCE_SERVICE_ID_EDEFAULT);
            return;
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            setResourceInterface__ResourceSignature((ResourceInterface) null);
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
        case ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
            return !getParameter__ResourceSignature().isEmpty();
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_SERVICE_ID:
            return getResourceServiceId() != RESOURCE_SERVICE_ID_EDEFAULT;
        case ResourcetypePackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
            return getResourceInterface__ResourceSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceSignatureImpl
