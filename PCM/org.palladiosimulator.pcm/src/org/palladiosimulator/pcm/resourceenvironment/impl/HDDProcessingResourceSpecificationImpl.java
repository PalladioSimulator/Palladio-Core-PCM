/**
 * Copyright 2005-2015 by palladiosimulator.org
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>HDD Processing Resource
 * Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getWriteProcessingRate
 * <em>Write Processing Rate</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getReadProcessingRate
 * <em>Read Processing Rate</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HDDProcessingResourceSpecificationImpl extends ProcessingResourceSpecificationImpl
        implements HDDProcessingResourceSpecification {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2017 by palladiosimulator.org";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected HDDProcessingResourceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getWriteProcessingRate() {
        return (PCMRandomVariable) this.eDynamicGet(
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetWriteProcessingRate(final PCMRandomVariable newWriteProcessingRate,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newWriteProcessingRate,
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setWriteProcessingRate(final PCMRandomVariable newWriteProcessingRate) {
        this.eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
                newWriteProcessingRate);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getReadProcessingRate() {
        return (PCMRandomVariable) this.eDynamicGet(
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetReadProcessingRate(final PCMRandomVariable newReadProcessingRate,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newReadProcessingRate,
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setReadProcessingRate(final PCMRandomVariable newReadProcessingRate) {
        this.eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
                newReadProcessingRate);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResourceContainer(final ResourceContainer newResourceContainer,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newResourceContainer,
                ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceContainer(final ResourceContainer newResourceContainer) {
        this.eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
                newResourceContainer);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            final ResourceContainer resourceContainer = this.basicGetResourceContainer();
            if (resourceContainer != null) {
                msgs = ((InternalEObject) resourceContainer).eInverseRemove(this,
                        ResourceenvironmentPackage.RESOURCE_CONTAINER__HDD_RESOURCE_SPECIFICATIONS,
                        ResourceContainer.class, msgs);
            }
            return this.basicSetResourceContainer((ResourceContainer) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
            return this.basicSetWriteProcessingRate(null, msgs);
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
            return this.basicSetReadProcessingRate(null, msgs);
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            return this.basicSetResourceContainer(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
            return this.getWriteProcessingRate();
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
            return this.getReadProcessingRate();
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            if (resolve) {
                return this.getResourceContainer();
            }
            return this.basicGetResourceContainer();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
            this.setWriteProcessingRate((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
            this.setReadProcessingRate((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
            this.setWriteProcessingRate((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
            this.setReadProcessingRate((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
            return this.getWriteProcessingRate() != null;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
            return this.getReadProcessingRate() != null;
        case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
            return this.basicGetResourceContainer() != null;
        }
        return super.eIsSet(featureID);
    }

} // HDDProcessingResourceSpecificationImpl
