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
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Processing Resource Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getMTTR
 * <em>MTTR</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getMTTF
 * <em>MTTF</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#isRequiredByContainer
 * <em>Required By Container</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getSchedulingPolicy
 * <em>Scheduling Policy</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getActiveResourceType_ActiveResourceSpecification
 * <em>Active Resource Type Active Resource Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getProcessingRate_ProcessingResourceSpecification
 * <em>Processing Rate Processing Resource Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getNumberOfReplicas
 * <em>Number Of Replicas</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getResourceContainer_ProcessingResourceSpecification
 * <em>Resource Container Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessingResourceSpecificationImpl extends IdentifierImpl implements ProcessingResourceSpecification {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getMTTR() <em>MTTR</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMTTR()
     * @generated
     * @ordered
     */
    protected static final double MTTR_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMTTR() <em>MTTR</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMTTR()
     * @generated
     * @ordered
     */
    protected double mttr = MTTR_EDEFAULT;

    /**
     * The default value of the '{@link #getMTTF() <em>MTTF</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMTTF()
     * @generated
     * @ordered
     */
    protected static final double MTTF_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMTTF() <em>MTTF</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMTTF()
     * @generated
     * @ordered
     */
    protected double mttf = MTTF_EDEFAULT;

    /**
     * The default value of the '{@link #isRequiredByContainer() <em>Required By Container</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isRequiredByContainer()
     * @generated
     * @ordered
     */
    protected static final boolean REQUIRED_BY_CONTAINER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRequiredByContainer() <em>Required By Container</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isRequiredByContainer()
     * @generated
     * @ordered
     */
    protected boolean requiredByContainer = REQUIRED_BY_CONTAINER_EDEFAULT;

    /**
     * The cached value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSchedulingPolicy()
     * @generated
     * @ordered
     */
    protected SchedulingPolicy schedulingPolicy;

    /**
     * The cached value of the ' {@link #getActiveResourceType_ActiveResourceSpecification()
     * <em>Active Resource Type Active Resource Specification</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getActiveResourceType_ActiveResourceSpecification()
     * @generated
     * @ordered
     */
    protected ProcessingResourceType activeResourceType_ActiveResourceSpecification;

    /**
     * The cached value of the ' {@link #getProcessingRate_ProcessingResourceSpecification()
     * <em>Processing Rate Processing Resource Specification</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProcessingRate_ProcessingResourceSpecification()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable processingRate_ProcessingResourceSpecification;

    /**
     * The default value of the '{@link #getNumberOfReplicas() <em>Number Of Replicas</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumberOfReplicas()
     * @generated
     * @ordered
     */
    protected static final int NUMBER_OF_REPLICAS_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getNumberOfReplicas() <em>Number Of Replicas</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumberOfReplicas()
     * @generated
     * @ordered
     */
    protected int numberOfReplicas = NUMBER_OF_REPLICAS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProcessingResourceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public double getMTTR() {
        return this.mttr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMTTR(final double newMTTR) {
        final double oldMTTR = this.mttr;
        this.mttr = newMTTR;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR, oldMTTR, this.mttr));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public double getMTTF() {
        return this.mttf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMTTF(final double newMTTF) {
        final double oldMTTF = this.mttf;
        this.mttf = newMTTF;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF, oldMTTF, this.mttf));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isRequiredByContainer() {
        return this.requiredByContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredByContainer(final boolean newRequiredByContainer) {
        final boolean oldRequiredByContainer = this.requiredByContainer;
        this.requiredByContainer = newRequiredByContainer;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER,
                    oldRequiredByContainer, this.requiredByContainer));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SchedulingPolicy getSchedulingPolicy() {
        if (this.schedulingPolicy != null && ((EObject) this.schedulingPolicy).eIsProxy()) {
            final InternalEObject oldSchedulingPolicy = (InternalEObject) this.schedulingPolicy;
            this.schedulingPolicy = (SchedulingPolicy) this.eResolveProxy(oldSchedulingPolicy);
            if (this.schedulingPolicy != oldSchedulingPolicy) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                            oldSchedulingPolicy, this.schedulingPolicy));
                }
            }
        }
        return this.schedulingPolicy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SchedulingPolicy basicGetSchedulingPolicy() {
        return this.schedulingPolicy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSchedulingPolicy(final SchedulingPolicy newSchedulingPolicy) {
        final SchedulingPolicy oldSchedulingPolicy = this.schedulingPolicy;
        this.schedulingPolicy = newSchedulingPolicy;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                    oldSchedulingPolicy, this.schedulingPolicy));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProcessingResourceType getActiveResourceType_ActiveResourceSpecification() {
        if (this.activeResourceType_ActiveResourceSpecification != null
                && ((EObject) this.activeResourceType_ActiveResourceSpecification).eIsProxy()) {
            final InternalEObject oldActiveResourceType_ActiveResourceSpecification = (InternalEObject) this.activeResourceType_ActiveResourceSpecification;
            this.activeResourceType_ActiveResourceSpecification = (ProcessingResourceType) this
                    .eResolveProxy(oldActiveResourceType_ActiveResourceSpecification);
            if (this.activeResourceType_ActiveResourceSpecification != oldActiveResourceType_ActiveResourceSpecification) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                            oldActiveResourceType_ActiveResourceSpecification,
                            this.activeResourceType_ActiveResourceSpecification));
                }
            }
        }
        return this.activeResourceType_ActiveResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceType basicGetActiveResourceType_ActiveResourceSpecification() {
        return this.activeResourceType_ActiveResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setActiveResourceType_ActiveResourceSpecification(
            final ProcessingResourceType newActiveResourceType_ActiveResourceSpecification) {
        final ProcessingResourceType oldActiveResourceType_ActiveResourceSpecification = this.activeResourceType_ActiveResourceSpecification;
        this.activeResourceType_ActiveResourceSpecification = newActiveResourceType_ActiveResourceSpecification;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                    oldActiveResourceType_ActiveResourceSpecification,
                    this.activeResourceType_ActiveResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getProcessingRate_ProcessingResourceSpecification() {
        return this.processingRate_ProcessingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProcessingRate_ProcessingResourceSpecification(
            final PCMRandomVariable newProcessingRate_ProcessingResourceSpecification, NotificationChain msgs) {
        final PCMRandomVariable oldProcessingRate_ProcessingResourceSpecification = this.processingRate_ProcessingResourceSpecification;
        this.processingRate_ProcessingResourceSpecification = newProcessingRate_ProcessingResourceSpecification;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                    oldProcessingRate_ProcessingResourceSpecification,
                    newProcessingRate_ProcessingResourceSpecification);
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
    public void setProcessingRate_ProcessingResourceSpecification(
            final PCMRandomVariable newProcessingRate_ProcessingResourceSpecification) {
        if (newProcessingRate_ProcessingResourceSpecification != this.processingRate_ProcessingResourceSpecification) {
            NotificationChain msgs = null;
            if (this.processingRate_ProcessingResourceSpecification != null) {
                msgs = ((InternalEObject) this.processingRate_ProcessingResourceSpecification)
                        .eInverseRemove(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            if (newProcessingRate_ProcessingResourceSpecification != null) {
                msgs = ((InternalEObject) newProcessingRate_ProcessingResourceSpecification)
                        .eInverseAdd(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetProcessingRate_ProcessingResourceSpecification(
                    newProcessingRate_ProcessingResourceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                    newProcessingRate_ProcessingResourceSpecification,
                    newProcessingRate_ProcessingResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getNumberOfReplicas() {
        return this.numberOfReplicas;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNumberOfReplicas(final int newNumberOfReplicas) {
        final int oldNumberOfReplicas = this.numberOfReplicas;
        this.numberOfReplicas = newNumberOfReplicas;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS,
                    oldNumberOfReplicas, this.numberOfReplicas));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer_ProcessingResourceSpecification() {
        if (this.eContainerFeatureID() != ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION) {
            return null;
        }
        return (ResourceContainer) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceContainer_ProcessingResourceSpecification(
            final ResourceContainer newResourceContainer_ProcessingResourceSpecification, NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newResourceContainer_ProcessingResourceSpecification,
                        ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceContainer_ProcessingResourceSpecification(
            final ResourceContainer newResourceContainer_ProcessingResourceSpecification) {
        if (newResourceContainer_ProcessingResourceSpecification != this.eInternalContainer()
                || (this.eContainerFeatureID() != ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION && newResourceContainer_ProcessingResourceSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newResourceContainer_ProcessingResourceSpecification)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceContainer_ProcessingResourceSpecification != null) {
                msgs = ((InternalEObject) newResourceContainer_ProcessingResourceSpecification)
                        .eInverseAdd(
                                this,
                                ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                                ResourceContainer.class, msgs);
            }
            msgs = this.basicSetResourceContainer_ProcessingResourceSpecification(
                    newResourceContainer_ProcessingResourceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                    newResourceContainer_ProcessingResourceSpecification,
                    newResourceContainer_ProcessingResourceSpecification));
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            if (this.processingRate_ProcessingResourceSpecification != null) {
                msgs = ((InternalEObject) this.processingRate_ProcessingResourceSpecification)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                                null, msgs);
            }
            return this.basicSetProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) otherEnd, msgs);
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceContainer_ProcessingResourceSpecification((ResourceContainer) otherEnd, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return this.basicSetProcessingRate_ProcessingResourceSpecification(null, msgs);
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return this.basicSetResourceContainer_ProcessingResourceSpecification(null, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return this.eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                    ResourceContainer.class, msgs);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            return this.getMTTR();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            return this.getMTTF();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            return this.isRequiredByContainer();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            if (resolve) {
                return this.getSchedulingPolicy();
            }
            return this.basicGetSchedulingPolicy();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            if (resolve) {
                return this.getActiveResourceType_ActiveResourceSpecification();
            }
            return this.basicGetActiveResourceType_ActiveResourceSpecification();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return this.getProcessingRate_ProcessingResourceSpecification();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            return this.getNumberOfReplicas();
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return this.getResourceContainer_ProcessingResourceSpecification();
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            this.setMTTR((Double) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            this.setMTTF((Double) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            this.setRequiredByContainer((Boolean) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            this.setSchedulingPolicy((SchedulingPolicy) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            this.setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            this.setNumberOfReplicas((Integer) newValue);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            this.setResourceContainer_ProcessingResourceSpecification((ResourceContainer) newValue);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            this.setMTTR(MTTR_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            this.setMTTF(MTTF_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            this.setRequiredByContainer(REQUIRED_BY_CONTAINER_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            this.setSchedulingPolicy((SchedulingPolicy) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            this.setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable) null);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            this.setNumberOfReplicas(NUMBER_OF_REPLICAS_EDEFAULT);
            return;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            this.setResourceContainer_ProcessingResourceSpecification((ResourceContainer) null);
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
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            return this.mttr != MTTR_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            return this.mttf != MTTF_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            return this.requiredByContainer != REQUIRED_BY_CONTAINER_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            return this.schedulingPolicy != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            return this.activeResourceType_ActiveResourceSpecification != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return this.processingRate_ProcessingResourceSpecification != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            return this.numberOfReplicas != NUMBER_OF_REPLICAS_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return this.getResourceContainer_ProcessingResourceSpecification() != null;
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
        result.append(" (MTTR: ");
        result.append(this.mttr);
        result.append(", MTTF: ");
        result.append(this.mttf);
        result.append(", requiredByContainer: ");
        result.append(this.requiredByContainer);
        result.append(", numberOfReplicas: ");
        result.append(this.numberOfReplicas);
        result.append(')');
        return result.toString();
    }

} // ProcessingResourceSpecificationImpl
