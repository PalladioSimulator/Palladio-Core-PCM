/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Specified Qo SAnnotation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getSignature_SpecifiedQoSAnnation
 * <em>Signature Specified Qo SAnnation</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getRole_SpecifiedQoSAnnotation
 * <em>Role Specified Qo SAnnotation</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getQosAnnotations_SpecifiedQoSAnnotation
 * <em>Qos Annotations Specified Qo SAnnotation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class SpecifiedQoSAnnotationImpl extends EStereotypableObjectImpl implements SpecifiedQoSAnnotation {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSignature_SpecifiedQoSAnnation()
     * <em>Signature Specified Qo SAnnation</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSignature_SpecifiedQoSAnnation()
     * @generated
     * @ordered
     */
    protected Signature signature_SpecifiedQoSAnnation;

    /**
     * The cached value of the '{@link #getRole_SpecifiedQoSAnnotation()
     * <em>Role Specified Qo SAnnotation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getRole_SpecifiedQoSAnnotation()
     * @generated
     * @ordered
     */
    protected Role role_SpecifiedQoSAnnotation;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SpecifiedQoSAnnotationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosannotationsPackage.Literals.SPECIFIED_QO_SANNOTATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Signature getSignature_SpecifiedQoSAnnation() {
        if (this.signature_SpecifiedQoSAnnation != null && ((EObject) this.signature_SpecifiedQoSAnnation).eIsProxy()) {
            final InternalEObject oldSignature_SpecifiedQoSAnnation = (InternalEObject) this.signature_SpecifiedQoSAnnation;
            this.signature_SpecifiedQoSAnnation = (Signature) this.eResolveProxy(oldSignature_SpecifiedQoSAnnation);
            if (this.signature_SpecifiedQoSAnnation != oldSignature_SpecifiedQoSAnnation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION,
                            oldSignature_SpecifiedQoSAnnation, this.signature_SpecifiedQoSAnnation));
                }
            }
        }
        return this.signature_SpecifiedQoSAnnation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Signature basicGetSignature_SpecifiedQoSAnnation() {
        return this.signature_SpecifiedQoSAnnation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature_SpecifiedQoSAnnation(final Signature newSignature_SpecifiedQoSAnnation) {
        final Signature oldSignature_SpecifiedQoSAnnation = this.signature_SpecifiedQoSAnnation;
        this.signature_SpecifiedQoSAnnation = newSignature_SpecifiedQoSAnnation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION,
                    oldSignature_SpecifiedQoSAnnation, this.signature_SpecifiedQoSAnnation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Role getRole_SpecifiedQoSAnnotation() {
        if (this.role_SpecifiedQoSAnnotation != null && ((EObject) this.role_SpecifiedQoSAnnotation).eIsProxy()) {
            final InternalEObject oldRole_SpecifiedQoSAnnotation = (InternalEObject) this.role_SpecifiedQoSAnnotation;
            this.role_SpecifiedQoSAnnotation = (Role) this.eResolveProxy(oldRole_SpecifiedQoSAnnotation);
            if (this.role_SpecifiedQoSAnnotation != oldRole_SpecifiedQoSAnnotation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION,
                            oldRole_SpecifiedQoSAnnotation, this.role_SpecifiedQoSAnnotation));
                }
            }
        }
        return this.role_SpecifiedQoSAnnotation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Role basicGetRole_SpecifiedQoSAnnotation() {
        return this.role_SpecifiedQoSAnnotation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRole_SpecifiedQoSAnnotation(final Role newRole_SpecifiedQoSAnnotation) {
        final Role oldRole_SpecifiedQoSAnnotation = this.role_SpecifiedQoSAnnotation;
        this.role_SpecifiedQoSAnnotation = newRole_SpecifiedQoSAnnotation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION,
                    oldRole_SpecifiedQoSAnnotation, this.role_SpecifiedQoSAnnotation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QoSAnnotations getQosAnnotations_SpecifiedQoSAnnotation() {
        if (this.eContainerFeatureID() != QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION) {
            return null;
        }
        return (QoSAnnotations) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQosAnnotations_SpecifiedQoSAnnotation(
            final QoSAnnotations newQosAnnotations_SpecifiedQoSAnnotation, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQosAnnotations_SpecifiedQoSAnnotation,
                QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQosAnnotations_SpecifiedQoSAnnotation(final QoSAnnotations newQosAnnotations_SpecifiedQoSAnnotation) {
        if (newQosAnnotations_SpecifiedQoSAnnotation != this.eInternalContainer()
                || (this.eContainerFeatureID() != QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION && newQosAnnotations_SpecifiedQoSAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQosAnnotations_SpecifiedQoSAnnotation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQosAnnotations_SpecifiedQoSAnnotation != null) {
                msgs = ((InternalEObject) newQosAnnotations_SpecifiedQoSAnnotation).eInverseAdd(this,
                        QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS,
                        QoSAnnotations.class, msgs);
            }
            msgs = this.basicSetQosAnnotations_SpecifiedQoSAnnotation(newQosAnnotations_SpecifiedQoSAnnotation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION,
                    newQosAnnotations_SpecifiedQoSAnnotation, newQosAnnotations_SpecifiedQoSAnnotation));
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQosAnnotations_SpecifiedQoSAnnotation((QoSAnnotations) otherEnd, msgs);
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            return this.basicSetQosAnnotations_SpecifiedQoSAnnotation(null, msgs);
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS,
                    QoSAnnotations.class, msgs);
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
            if (resolve) {
                return this.getSignature_SpecifiedQoSAnnation();
            }
            return this.basicGetSignature_SpecifiedQoSAnnation();
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
            if (resolve) {
                return this.getRole_SpecifiedQoSAnnotation();
            }
            return this.basicGetRole_SpecifiedQoSAnnotation();
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            return this.getQosAnnotations_SpecifiedQoSAnnotation();
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
            this.setSignature_SpecifiedQoSAnnation((Signature) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
            this.setRole_SpecifiedQoSAnnotation((Role) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            this.setQosAnnotations_SpecifiedQoSAnnotation((QoSAnnotations) newValue);
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
            this.setSignature_SpecifiedQoSAnnation((Signature) null);
            return;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
            this.setRole_SpecifiedQoSAnnotation((Role) null);
            return;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            this.setQosAnnotations_SpecifiedQoSAnnotation((QoSAnnotations) null);
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
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
            return this.signature_SpecifiedQoSAnnation != null;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
            return this.role_SpecifiedQoSAnnotation != null;
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION:
            return this.getQosAnnotations_SpecifiedQoSAnnotation() != null;
        }
        return super.eIsSet(featureID);
    }

} // SpecifiedQoSAnnotationImpl
