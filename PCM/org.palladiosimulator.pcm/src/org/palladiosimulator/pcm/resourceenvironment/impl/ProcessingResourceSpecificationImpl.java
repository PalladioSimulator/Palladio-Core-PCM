/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.palladiosimulator.pcm.resourcetype.ProcessingResourceType;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getMTTR <em>MTTR</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getMTTF <em>MTTF</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#isRequiredByContainer <em>Required By Container</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getProcessingRate_ProcessingResourceSpecification <em>Processing Rate Processing Resource Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getNumberOfReplicas <em>Number Of Replicas</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getResourceContainer_ProcessingResourceSpecification <em>Resource Container Processing Resource Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessingResourceSpecificationImpl extends IdentifierImpl implements ProcessingResourceSpecification {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getMTTR() <em>MTTR</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMTTR()
     * @generated
     * @ordered
     */
    protected static final double MTTR_EDEFAULT = 0.0;

    /**
     * The default value of the '{@link #getMTTF() <em>MTTF</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMTTF()
     * @generated
     * @ordered
     */
    protected static final double MTTF_EDEFAULT = 0.0;

    /**
     * The default value of the '{@link #isRequiredByContainer() <em>Required By Container</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRequiredByContainer()
     * @generated
     * @ordered
     */
    protected static final boolean REQUIRED_BY_CONTAINER_EDEFAULT = false;

    /**
     * The default value of the '{@link #getNumberOfReplicas() <em>Number Of Replicas</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNumberOfReplicas()
     * @generated
     * @ordered
     */
    protected static final int NUMBER_OF_REPLICAS_EDEFAULT = 1;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProcessingResourceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getMTTR() {
        return (Double) eDynamicGet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__MTTR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMTTR(double newMTTR) {
        eDynamicSet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__MTTR, newMTTR);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getMTTF() {
        return (Double) eDynamicGet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__MTTF, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMTTF(double newMTTF) {
        eDynamicSet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__MTTF, newMTTF);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRequiredByContainer() {
        return (Boolean) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiredByContainer(boolean newRequiredByContainer) {
        eDynamicSet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER,
                newRequiredByContainer);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SchedulingPolicy getSchedulingPolicy() {
        return (SchedulingPolicy) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SchedulingPolicy basicGetSchedulingPolicy() {
        return (SchedulingPolicy) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSchedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        eDynamicSet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                newSchedulingPolicy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceType getActiveResourceType_ActiveResourceSpecification() {
        return (ProcessingResourceType) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceType basicGetActiveResourceType_ActiveResourceSpecification() {
        return (ProcessingResourceType) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActiveResourceType_ActiveResourceSpecification(
            ProcessingResourceType newActiveResourceType_ActiveResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                newActiveResourceType_ActiveResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getProcessingRate_ProcessingResourceSpecification() {
        return (PCMRandomVariable) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcessingRate_ProcessingResourceSpecification(
            PCMRandomVariable newProcessingRate_ProcessingResourceSpecification, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newProcessingRate_ProcessingResourceSpecification,
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcessingRate_ProcessingResourceSpecification(
            PCMRandomVariable newProcessingRate_ProcessingResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                newProcessingRate_ProcessingResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getNumberOfReplicas() {
        return (Integer) eDynamicGet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNumberOfReplicas(int newNumberOfReplicas) {
        eDynamicSet(ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS,
                newNumberOfReplicas);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer getResourceContainer_ProcessingResourceSpecification() {
        return (ResourceContainer) eDynamicGet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceContainer_ProcessingResourceSpecification(
            ResourceContainer newResourceContainer_ProcessingResourceSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceContainer_ProcessingResourceSpecification,
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceContainer_ProcessingResourceSpecification(
            ResourceContainer newResourceContainer_ProcessingResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                newResourceContainer_ProcessingResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            PCMRandomVariable processingRate_ProcessingResourceSpecification = getProcessingRate_ProcessingResourceSpecification();
            if (processingRate_ProcessingResourceSpecification != null)
                msgs = ((InternalEObject) processingRate_ProcessingResourceSpecification).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                        null, msgs);
            return basicSetProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) otherEnd, msgs);
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceContainer_ProcessingResourceSpecification((ResourceContainer) otherEnd, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return basicSetProcessingRate_ProcessingResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return basicSetResourceContainer_ProcessingResourceSpecification(null, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                    ResourceContainer.class, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            return getMTTR();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            return getMTTF();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            return isRequiredByContainer();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            if (resolve)
                return getSchedulingPolicy();
            return basicGetSchedulingPolicy();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            if (resolve)
                return getActiveResourceType_ActiveResourceSpecification();
            return basicGetActiveResourceType_ActiveResourceSpecification();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return getProcessingRate_ProcessingResourceSpecification();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            return getNumberOfReplicas();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return getResourceContainer_ProcessingResourceSpecification();
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            setMTTR((Double) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            setMTTF((Double) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            setRequiredByContainer((Boolean) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            setSchedulingPolicy((SchedulingPolicy) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            setNumberOfReplicas((Integer) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            setResourceContainer_ProcessingResourceSpecification((ResourceContainer) newValue);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            setMTTR(MTTR_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            setMTTF(MTTF_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            setRequiredByContainer(REQUIRED_BY_CONTAINER_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            setSchedulingPolicy((SchedulingPolicy) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            setNumberOfReplicas(NUMBER_OF_REPLICAS_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            setResourceContainer_ProcessingResourceSpecification((ResourceContainer) null);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            return getMTTR() != MTTR_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            return getMTTF() != MTTF_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            return isRequiredByContainer() != REQUIRED_BY_CONTAINER_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            return basicGetSchedulingPolicy() != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            return basicGetActiveResourceType_ActiveResourceSpecification() != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return getProcessingRate_ProcessingResourceSpecification() != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            return getNumberOfReplicas() != NUMBER_OF_REPLICAS_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return getResourceContainer_ProcessingResourceSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

} //ProcessingResourceSpecificationImpl
