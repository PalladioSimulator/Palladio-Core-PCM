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
     * The cached value of the '{@link #getActiveResourceType_ActiveResourceSpecification()
     * <em>Active Resource Type Active Resource Specification</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getActiveResourceType_ActiveResourceSpecification()
     * @generated
     * @ordered
     */
    protected ProcessingResourceType activeResourceType_ActiveResourceSpecification;

    /**
     * The cached value of the '{@link #getProcessingRate_ProcessingResourceSpecification()
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
    public double getMTTR() {
        return mttr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMTTR(double newMTTR) {
        double oldMTTR = mttr;
        mttr = newMTTR;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR, oldMTTR, mttr));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getMTTF() {
        return mttf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMTTF(double newMTTF) {
        double oldMTTF = mttf;
        mttf = newMTTF;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF, oldMTTF, mttf));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isRequiredByContainer() {
        return requiredByContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRequiredByContainer(boolean newRequiredByContainer) {
        boolean oldRequiredByContainer = requiredByContainer;
        requiredByContainer = newRequiredByContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER,
                    oldRequiredByContainer, requiredByContainer));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SchedulingPolicy getSchedulingPolicy() {
        if (schedulingPolicy != null && ((EObject) schedulingPolicy).eIsProxy()) {
            InternalEObject oldSchedulingPolicy = (InternalEObject) schedulingPolicy;
            schedulingPolicy = (SchedulingPolicy) eResolveProxy(oldSchedulingPolicy);
            if (schedulingPolicy != oldSchedulingPolicy) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                            oldSchedulingPolicy, schedulingPolicy));
            }
        }
        return schedulingPolicy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SchedulingPolicy basicGetSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSchedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        SchedulingPolicy oldSchedulingPolicy = schedulingPolicy;
        schedulingPolicy = newSchedulingPolicy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY,
                    oldSchedulingPolicy, schedulingPolicy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceType getActiveResourceType_ActiveResourceSpecification() {
        if (activeResourceType_ActiveResourceSpecification != null
                && ((EObject) activeResourceType_ActiveResourceSpecification).eIsProxy()) {
            InternalEObject oldActiveResourceType_ActiveResourceSpecification = (InternalEObject) activeResourceType_ActiveResourceSpecification;
            activeResourceType_ActiveResourceSpecification = (ProcessingResourceType) eResolveProxy(oldActiveResourceType_ActiveResourceSpecification);
            if (activeResourceType_ActiveResourceSpecification != oldActiveResourceType_ActiveResourceSpecification) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                            oldActiveResourceType_ActiveResourceSpecification,
                            activeResourceType_ActiveResourceSpecification));
            }
        }
        return activeResourceType_ActiveResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceType basicGetActiveResourceType_ActiveResourceSpecification() {
        return activeResourceType_ActiveResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setActiveResourceType_ActiveResourceSpecification(
            ProcessingResourceType newActiveResourceType_ActiveResourceSpecification) {
        ProcessingResourceType oldActiveResourceType_ActiveResourceSpecification = activeResourceType_ActiveResourceSpecification;
        activeResourceType_ActiveResourceSpecification = newActiveResourceType_ActiveResourceSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION,
                    oldActiveResourceType_ActiveResourceSpecification, activeResourceType_ActiveResourceSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMRandomVariable getProcessingRate_ProcessingResourceSpecification() {
        return processingRate_ProcessingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProcessingRate_ProcessingResourceSpecification(
            PCMRandomVariable newProcessingRate_ProcessingResourceSpecification, NotificationChain msgs) {
        PCMRandomVariable oldProcessingRate_ProcessingResourceSpecification = processingRate_ProcessingResourceSpecification;
        processingRate_ProcessingResourceSpecification = newProcessingRate_ProcessingResourceSpecification;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                    oldProcessingRate_ProcessingResourceSpecification,
                    newProcessingRate_ProcessingResourceSpecification);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProcessingRate_ProcessingResourceSpecification(
            PCMRandomVariable newProcessingRate_ProcessingResourceSpecification) {
        if (newProcessingRate_ProcessingResourceSpecification != processingRate_ProcessingResourceSpecification) {
            NotificationChain msgs = null;
            if (processingRate_ProcessingResourceSpecification != null)
                msgs = ((InternalEObject) processingRate_ProcessingResourceSpecification)
                        .eInverseRemove(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            if (newProcessingRate_ProcessingResourceSpecification != null)
                msgs = ((InternalEObject) newProcessingRate_ProcessingResourceSpecification)
                        .eInverseAdd(
                                this,
                                CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
                                PCMRandomVariable.class, msgs);
            msgs = basicSetProcessingRate_ProcessingResourceSpecification(
                    newProcessingRate_ProcessingResourceSpecification, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
                    newProcessingRate_ProcessingResourceSpecification,
                    newProcessingRate_ProcessingResourceSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getNumberOfReplicas() {
        return numberOfReplicas;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNumberOfReplicas(int newNumberOfReplicas) {
        int oldNumberOfReplicas = numberOfReplicas;
        numberOfReplicas = newNumberOfReplicas;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS,
                    oldNumberOfReplicas, numberOfReplicas));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceContainer getResourceContainer_ProcessingResourceSpecification() {
        if (eContainerFeatureID() != ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION)
            return null;
        return (ResourceContainer) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceContainer_ProcessingResourceSpecification(
            ResourceContainer newResourceContainer_ProcessingResourceSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer(
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
    public void setResourceContainer_ProcessingResourceSpecification(
            ResourceContainer newResourceContainer_ProcessingResourceSpecification) {
        if (newResourceContainer_ProcessingResourceSpecification != eInternalContainer()
                || (eContainerFeatureID() != ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION && newResourceContainer_ProcessingResourceSpecification != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newResourceContainer_ProcessingResourceSpecification))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newResourceContainer_ProcessingResourceSpecification != null)
                msgs = ((InternalEObject) newResourceContainer_ProcessingResourceSpecification)
                        .eInverseAdd(
                                this,
                                ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                                ResourceContainer.class, msgs);
            msgs = basicSetResourceContainer_ProcessingResourceSpecification(
                    newResourceContainer_ProcessingResourceSpecification, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION,
                    newResourceContainer_ProcessingResourceSpecification,
                    newResourceContainer_ProcessingResourceSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            if (processingRate_ProcessingResourceSpecification != null)
                msgs = ((InternalEObject) processingRate_ProcessingResourceSpecification)
                        .eInverseRemove(
                                this,
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTR:
            return mttr != MTTR_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__MTTF:
            return mttf != MTTF_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER:
            return requiredByContainer != REQUIRED_BY_CONTAINER_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
            return schedulingPolicy != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
            return activeResourceType_ActiveResourceSpecification != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
            return processingRate_ProcessingResourceSpecification != null;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS:
            return numberOfReplicas != NUMBER_OF_REPLICAS_EDEFAULT;
        case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION:
            return getResourceContainer_ProcessingResourceSpecification() != null;
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
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (MTTR: ");
        result.append(mttr);
        result.append(", MTTF: ");
        result.append(mttf);
        result.append(", requiredByContainer: ");
        result.append(requiredByContainer);
        result.append(", numberOfReplicas: ");
        result.append(numberOfReplicas);
        result.append(')');
        return result.toString();
    }

} // ProcessingResourceSpecificationImpl
