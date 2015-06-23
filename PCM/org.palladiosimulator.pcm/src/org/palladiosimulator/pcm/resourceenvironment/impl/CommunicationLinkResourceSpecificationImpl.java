/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Link Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getLinkingResource_CommunicationLinkResourceSpecification <em>Linking Resource Communication Link Resource Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification <em>Communication Link Resource Type Communication Link Resource Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getLatency_CommunicationLinkResourceSpecification <em>Latency Communication Link Resource Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getThroughput_CommunicationLinkResourceSpecification <em>Throughput Communication Link Resource Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommunicationLinkResourceSpecificationImpl extends IdentifierImpl
        implements CommunicationLinkResourceSpecification {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFailureProbability()
     * @generated
     * @ordered
     */
    protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CommunicationLinkResourceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkingResource getLinkingResource_CommunicationLinkResourceSpecification() {
        return (LinkingResource) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLinkingResource_CommunicationLinkResourceSpecification(
            LinkingResource newLinkingResource_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newLinkingResource_CommunicationLinkResourceSpecification,
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLinkingResource_CommunicationLinkResourceSpecification(
            LinkingResource newLinkingResource_CommunicationLinkResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                newLinkingResource_CommunicationLinkResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getFailureProbability() {
        return (Double) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFailureProbability(double newFailureProbability) {
        eDynamicSet(ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY,
                newFailureProbability);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationLinkResourceType getCommunicationLinkResourceType_CommunicationLinkResourceSpecification() {
        return (CommunicationLinkResourceType) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationLinkResourceType basicGetCommunicationLinkResourceType_CommunicationLinkResourceSpecification() {
        return (CommunicationLinkResourceType) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(
            CommunicationLinkResourceType newCommunicationLinkResourceType_CommunicationLinkResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                newCommunicationLinkResourceType_CommunicationLinkResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getLatency_CommunicationLinkResourceSpecification() {
        return (PCMRandomVariable) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLatency_CommunicationLinkResourceSpecification(
            PCMRandomVariable newLatency_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newLatency_CommunicationLinkResourceSpecification,
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLatency_CommunicationLinkResourceSpecification(
            PCMRandomVariable newLatency_CommunicationLinkResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                newLatency_CommunicationLinkResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getThroughput_CommunicationLinkResourceSpecification() {
        return (PCMRandomVariable) eDynamicGet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetThroughput_CommunicationLinkResourceSpecification(
            PCMRandomVariable newThroughput_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newThroughput_CommunicationLinkResourceSpecification,
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setThroughput_CommunicationLinkResourceSpecification(
            PCMRandomVariable newThroughput_CommunicationLinkResourceSpecification) {
        eDynamicSet(
                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                newThroughput_CommunicationLinkResourceSpecification);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) otherEnd, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            PCMRandomVariable latency_CommunicationLinkResourceSpecification = getLatency_CommunicationLinkResourceSpecification();
            if (latency_CommunicationLinkResourceSpecification != null)
                msgs = ((InternalEObject) latency_CommunicationLinkResourceSpecification).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                        null, msgs);
            return basicSetLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) otherEnd, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            PCMRandomVariable throughput_CommunicationLinkResourceSpecification = getThroughput_CommunicationLinkResourceSpecification();
            if (throughput_CommunicationLinkResourceSpecification != null)
                msgs = ((InternalEObject) throughput_CommunicationLinkResourceSpecification).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                        null, msgs);
            return basicSetThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) otherEnd, msgs);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return basicSetLinkingResource_CommunicationLinkResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return basicSetLatency_CommunicationLinkResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return basicSetThroughput_CommunicationLinkResourceSpecification(null, msgs);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                    LinkingResource.class, msgs);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getLinkingResource_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            return getFailureProbability();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (resolve)
                return getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
            return basicGetCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getLatency_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getThroughput_CommunicationLinkResourceSpecification();
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            setFailureProbability((Double) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(
                    (CommunicationLinkResourceType) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) newValue);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(
                    (CommunicationLinkResourceType) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            setThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) null);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getLinkingResource_CommunicationLinkResourceSpecification() != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            return getFailureProbability() != FAILURE_PROBABILITY_EDEFAULT;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return basicGetCommunicationLinkResourceType_CommunicationLinkResourceSpecification() != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getLatency_CommunicationLinkResourceSpecification() != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return getThroughput_CommunicationLinkResourceSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

} //CommunicationLinkResourceSpecificationImpl
