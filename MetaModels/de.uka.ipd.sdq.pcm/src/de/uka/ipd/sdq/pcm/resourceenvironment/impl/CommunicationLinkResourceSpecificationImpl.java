/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Communication Link Resource Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getLinkingResource_CommunicationLinkResourceSpecification
 * <em>Linking Resource Communication Link Resource Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getFailureProbability
 * <em>Failure Probability</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification
 * <em>Communication Link Resource Type Communication Link Resource Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getLatency_CommunicationLinkResourceSpecification
 * <em>Latency Communication Link Resource Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl#getThroughput_CommunicationLinkResourceSpecification
 * <em>Throughput Communication Link Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationLinkResourceSpecificationImpl extends IdentifierImpl implements
CommunicationLinkResourceSpecification {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFailureProbability()
     * @generated
     * @ordered
     */
    protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getFailureProbability() <em>Failure Probability</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFailureProbability()
     * @generated
     * @ordered
     */
    protected double failureProbability = FAILURE_PROBABILITY_EDEFAULT;

    /**
     * The cached value of the '
     * {@link #getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()
     * <em>Communication Link Resource Type Communication Link Resource Specification</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()
     * @generated
     * @ordered
     */
    protected CommunicationLinkResourceType communicationLinkResourceType_CommunicationLinkResourceSpecification;

    /**
     * The cached value of the '{@link #getLatency_CommunicationLinkResourceSpecification()
     * <em>Latency Communication Link Resource Specification</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLatency_CommunicationLinkResourceSpecification()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable latency_CommunicationLinkResourceSpecification;

    /**
     * The cached value of the '{@link #getThroughput_CommunicationLinkResourceSpecification()
     * <em>Throughput Communication Link Resource Specification</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getThroughput_CommunicationLinkResourceSpecification()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable throughput_CommunicationLinkResourceSpecification;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CommunicationLinkResourceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.COMMUNICATION_LINK_RESOURCE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LinkingResource getLinkingResource_CommunicationLinkResourceSpecification() {
        if (this.eContainerFeatureID() != ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION) {
            return null;
        }
        return (LinkingResource) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetLinkingResource_CommunicationLinkResourceSpecification(
            final LinkingResource newLinkingResource_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newLinkingResource_CommunicationLinkResourceSpecification,
                        ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLinkingResource_CommunicationLinkResourceSpecification(
            final LinkingResource newLinkingResource_CommunicationLinkResourceSpecification) {
        if (newLinkingResource_CommunicationLinkResourceSpecification != this.eInternalContainer()
                || (this.eContainerFeatureID() != ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION && newLinkingResource_CommunicationLinkResourceSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newLinkingResource_CommunicationLinkResourceSpecification)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newLinkingResource_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) newLinkingResource_CommunicationLinkResourceSpecification)
                        .eInverseAdd(
                                this,
                                ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                                LinkingResource.class, msgs);
            }
            msgs = this.basicSetLinkingResource_CommunicationLinkResourceSpecification(
                    newLinkingResource_CommunicationLinkResourceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    newLinkingResource_CommunicationLinkResourceSpecification,
                    newLinkingResource_CommunicationLinkResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getFailureProbability() {
        return this.failureProbability;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFailureProbability(final double newFailureProbability) {
        final double oldFailureProbability = this.failureProbability;
        this.failureProbability = newFailureProbability;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY,
                    oldFailureProbability, this.failureProbability));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CommunicationLinkResourceType getCommunicationLinkResourceType_CommunicationLinkResourceSpecification() {
        if (this.communicationLinkResourceType_CommunicationLinkResourceSpecification != null
                && ((EObject) this.communicationLinkResourceType_CommunicationLinkResourceSpecification).eIsProxy()) {
            final InternalEObject oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification = (InternalEObject) this.communicationLinkResourceType_CommunicationLinkResourceSpecification;
            this.communicationLinkResourceType_CommunicationLinkResourceSpecification = (CommunicationLinkResourceType) this
                    .eResolveProxy(oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification);
            if (this.communicationLinkResourceType_CommunicationLinkResourceSpecification != oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                            oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification,
                            this.communicationLinkResourceType_CommunicationLinkResourceSpecification));
                }
            }
        }
        return this.communicationLinkResourceType_CommunicationLinkResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public CommunicationLinkResourceType basicGetCommunicationLinkResourceType_CommunicationLinkResourceSpecification() {
        return this.communicationLinkResourceType_CommunicationLinkResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(
            final CommunicationLinkResourceType newCommunicationLinkResourceType_CommunicationLinkResourceSpecification) {
        final CommunicationLinkResourceType oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification = this.communicationLinkResourceType_CommunicationLinkResourceSpecification;
        this.communicationLinkResourceType_CommunicationLinkResourceSpecification = newCommunicationLinkResourceType_CommunicationLinkResourceSpecification;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    oldCommunicationLinkResourceType_CommunicationLinkResourceSpecification,
                    this.communicationLinkResourceType_CommunicationLinkResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getLatency_CommunicationLinkResourceSpecification() {
        return this.latency_CommunicationLinkResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetLatency_CommunicationLinkResourceSpecification(
            final PCMRandomVariable newLatency_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        final PCMRandomVariable oldLatency_CommunicationLinkResourceSpecification = this.latency_CommunicationLinkResourceSpecification;
        this.latency_CommunicationLinkResourceSpecification = newLatency_CommunicationLinkResourceSpecification;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    oldLatency_CommunicationLinkResourceSpecification,
                    newLatency_CommunicationLinkResourceSpecification);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLatency_CommunicationLinkResourceSpecification(
            final PCMRandomVariable newLatency_CommunicationLinkResourceSpecification) {
        if (newLatency_CommunicationLinkResourceSpecification != this.latency_CommunicationLinkResourceSpecification) {
            NotificationChain msgs = null;
            if (this.latency_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) this.latency_CommunicationLinkResourceSpecification)
                        .eInverseRemove(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            if (newLatency_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) newLatency_CommunicationLinkResourceSpecification)
                        .eInverseAdd(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetLatency_CommunicationLinkResourceSpecification(
                    newLatency_CommunicationLinkResourceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    newLatency_CommunicationLinkResourceSpecification,
                    newLatency_CommunicationLinkResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getThroughput_CommunicationLinkResourceSpecification() {
        return this.throughput_CommunicationLinkResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetThroughput_CommunicationLinkResourceSpecification(
            final PCMRandomVariable newThroughput_CommunicationLinkResourceSpecification, NotificationChain msgs) {
        final PCMRandomVariable oldThroughput_CommunicationLinkResourceSpecification = this.throughput_CommunicationLinkResourceSpecification;
        this.throughput_CommunicationLinkResourceSpecification = newThroughput_CommunicationLinkResourceSpecification;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    oldThroughput_CommunicationLinkResourceSpecification,
                    newThroughput_CommunicationLinkResourceSpecification);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setThroughput_CommunicationLinkResourceSpecification(
            final PCMRandomVariable newThroughput_CommunicationLinkResourceSpecification) {
        if (newThroughput_CommunicationLinkResourceSpecification != this.throughput_CommunicationLinkResourceSpecification) {
            NotificationChain msgs = null;
            if (this.throughput_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) this.throughput_CommunicationLinkResourceSpecification)
                        .eInverseRemove(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            if (newThroughput_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) newThroughput_CommunicationLinkResourceSpecification)
                        .eInverseAdd(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetThroughput_CommunicationLinkResourceSpecification(
                    newThroughput_CommunicationLinkResourceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                    newThroughput_CommunicationLinkResourceSpecification,
                    newThroughput_CommunicationLinkResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this
                    .basicSetLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) otherEnd, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (this.latency_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) this.latency_CommunicationLinkResourceSpecification)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                - ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                                null, msgs);
            }
            return this.basicSetLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) otherEnd, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (this.throughput_CommunicationLinkResourceSpecification != null) {
                msgs = ((InternalEObject) this.throughput_CommunicationLinkResourceSpecification)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                - ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                                null, msgs);
            }
            return this.basicSetThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) otherEnd, msgs);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.basicSetLinkingResource_CommunicationLinkResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.basicSetLatency_CommunicationLinkResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.basicSetThroughput_CommunicationLinkResourceSpecification(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this
                    .eInternalContainer()
                    .eInverseRemove(
                            this,
                            ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                            LinkingResource.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.getLinkingResource_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            return this.getFailureProbability();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            if (resolve) {
                return this.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
            }
            return this.basicGetCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.getLatency_CommunicationLinkResourceSpecification();
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.getThroughput_CommunicationLinkResourceSpecification();
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            this.setFailureProbability((Double) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setCommunicationLinkResourceType_CommunicationLinkResourceSpecification((CommunicationLinkResourceType) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) newValue);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setLinkingResource_CommunicationLinkResourceSpecification((LinkingResource) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            this.setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setCommunicationLinkResourceType_CommunicationLinkResourceSpecification((CommunicationLinkResourceType) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setLatency_CommunicationLinkResourceSpecification((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            this.setThroughput_CommunicationLinkResourceSpecification((PCMRandomVariable) null);
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
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.getLinkingResource_CommunicationLinkResourceSpecification() != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY:
            return this.failureProbability != FAILURE_PROBABILITY_EDEFAULT;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.communicationLinkResourceType_CommunicationLinkResourceSpecification != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.latency_CommunicationLinkResourceSpecification != null;
        case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
            return this.throughput_CommunicationLinkResourceSpecification != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (failureProbability: ");
        result.append(this.failureProbability);
        result.append(')');
        return result.toString();
    }

} // CommunicationLinkResourceSpecificationImpl
