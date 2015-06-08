/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Specified Output Parameter Abstraction</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getSignature_SpecifiedOutputParameterAbstraction
 * <em>Signature Specified Output Parameter Abstraction</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getRole_SpecifiedOutputParameterAbstraction
 * <em>Role Specified Output Parameter Abstraction</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction
 * <em>Expected External Outputs Specified Output Parameter Abstraction</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getQosAnnotations_SpecifiedOutputParameterAbstraction
 * <em>Qos Annotations Specified Output Parameter Abstraction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SpecifiedOutputParameterAbstractionImpl extends CDOObjectImpl implements
SpecifiedOutputParameterAbstraction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSignature_SpecifiedOutputParameterAbstraction()
     * <em>Signature Specified Output Parameter Abstraction</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getSignature_SpecifiedOutputParameterAbstraction()
     * @generated
     * @ordered
     */
    protected Signature signature_SpecifiedOutputParameterAbstraction;

    /**
     * The cached value of the '{@link #getRole_SpecifiedOutputParameterAbstraction()
     * <em>Role Specified Output Parameter Abstraction</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRole_SpecifiedOutputParameterAbstraction()
     * @generated
     * @ordered
     */
    protected Role role_SpecifiedOutputParameterAbstraction;

    /**
     * The cached value of the '
     * {@link #getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()
     * <em>Expected External Outputs Specified Output Parameter Abstraction</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> expectedExternalOutputs_SpecifiedOutputParameterAbstraction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SpecifiedOutputParameterAbstractionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public QoSAnnotations getQosAnnotations_SpecifiedOutputParameterAbstraction() {
        if (this.eContainerFeatureID() != QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION) {
            return null;
        }
        return (QoSAnnotations) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(
            final QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction, NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newQosAnnotations_SpecifiedOutputParameterAbstraction,
                        QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setQosAnnotations_SpecifiedOutputParameterAbstraction(
            final QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction) {
        if (newQosAnnotations_SpecifiedOutputParameterAbstraction != this.eInternalContainer()
                || (this.eContainerFeatureID() != QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION && newQosAnnotations_SpecifiedOutputParameterAbstraction != null)) {
            if (EcoreUtil.isAncestor(this, newQosAnnotations_SpecifiedOutputParameterAbstraction)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQosAnnotations_SpecifiedOutputParameterAbstraction != null) {
                msgs = ((InternalEObject) newQosAnnotations_SpecifiedOutputParameterAbstraction).eInverseAdd(this,
                        QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS,
                        QoSAnnotations.class, msgs);
            }
            msgs = this.basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(
                    newQosAnnotations_SpecifiedOutputParameterAbstraction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    newQosAnnotations_SpecifiedOutputParameterAbstraction,
                    newQosAnnotations_SpecifiedOutputParameterAbstraction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getSignature_SpecifiedOutputParameterAbstraction() {
        if (this.signature_SpecifiedOutputParameterAbstraction != null
                && ((EObject) this.signature_SpecifiedOutputParameterAbstraction).eIsProxy()) {
            final InternalEObject oldSignature_SpecifiedOutputParameterAbstraction = (InternalEObject) this.signature_SpecifiedOutputParameterAbstraction;
            this.signature_SpecifiedOutputParameterAbstraction = (Signature) this
                    .eResolveProxy(oldSignature_SpecifiedOutputParameterAbstraction);
            if (this.signature_SpecifiedOutputParameterAbstraction != oldSignature_SpecifiedOutputParameterAbstraction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                            oldSignature_SpecifiedOutputParameterAbstraction,
                            this.signature_SpecifiedOutputParameterAbstraction));
                }
            }
        }
        return this.signature_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetSignature_SpecifiedOutputParameterAbstraction() {
        return this.signature_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSignature_SpecifiedOutputParameterAbstraction(
            final Signature newSignature_SpecifiedOutputParameterAbstraction) {
        final Signature oldSignature_SpecifiedOutputParameterAbstraction = this.signature_SpecifiedOutputParameterAbstraction;
        this.signature_SpecifiedOutputParameterAbstraction = newSignature_SpecifiedOutputParameterAbstraction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    oldSignature_SpecifiedOutputParameterAbstraction,
                    this.signature_SpecifiedOutputParameterAbstraction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole_SpecifiedOutputParameterAbstraction() {
        if (this.role_SpecifiedOutputParameterAbstraction != null
                && ((EObject) this.role_SpecifiedOutputParameterAbstraction).eIsProxy()) {
            final InternalEObject oldRole_SpecifiedOutputParameterAbstraction = (InternalEObject) this.role_SpecifiedOutputParameterAbstraction;
            this.role_SpecifiedOutputParameterAbstraction = (Role) this
                    .eResolveProxy(oldRole_SpecifiedOutputParameterAbstraction);
            if (this.role_SpecifiedOutputParameterAbstraction != oldRole_SpecifiedOutputParameterAbstraction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                            oldRole_SpecifiedOutputParameterAbstraction, this.role_SpecifiedOutputParameterAbstraction));
                }
            }
        }
        return this.role_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole_SpecifiedOutputParameterAbstraction() {
        return this.role_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole_SpecifiedOutputParameterAbstraction(final Role newRole_SpecifiedOutputParameterAbstraction) {
        final Role oldRole_SpecifiedOutputParameterAbstraction = this.role_SpecifiedOutputParameterAbstraction;
        this.role_SpecifiedOutputParameterAbstraction = newRole_SpecifiedOutputParameterAbstraction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    oldRole_SpecifiedOutputParameterAbstraction, this.role_SpecifiedOutputParameterAbstraction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<VariableUsage> getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction() {
        if (this.expectedExternalOutputs_SpecifiedOutputParameterAbstraction == null) {
            this.expectedExternalOutputs_SpecifiedOutputParameterAbstraction = new EObjectContainmentWithInverseEList<VariableUsage>(
                    VariableUsage.class,
                    this,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE);
        }
        return this.expectedExternalOutputs_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()).basicAdd(otherEnd, msgs);
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) otherEnd, msgs);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return ((InternalEList<?>) this.getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction())
                    .basicRemove(otherEnd, msgs);
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(null, msgs);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.eInternalContainer().eInverseRemove(this,
                    QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS,
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (resolve) {
                return this.getSignature_SpecifiedOutputParameterAbstraction();
            }
            return this.basicGetSignature_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (resolve) {
                return this.getRole_SpecifiedOutputParameterAbstraction();
            }
            return this.basicGetRole_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.getQosAnnotations_SpecifiedOutputParameterAbstraction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setSignature_SpecifiedOutputParameterAbstraction((Signature) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setRole_SpecifiedOutputParameterAbstraction((Role) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().clear();
            this.getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().addAll(
                    (Collection<? extends VariableUsage>) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) newValue);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setSignature_SpecifiedOutputParameterAbstraction((Signature) null);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setRole_SpecifiedOutputParameterAbstraction((Role) null);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().clear();
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            this.setQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.signature_SpecifiedOutputParameterAbstraction != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.role_SpecifiedOutputParameterAbstraction != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.expectedExternalOutputs_SpecifiedOutputParameterAbstraction != null
            && !this.expectedExternalOutputs_SpecifiedOutputParameterAbstraction.isEmpty();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return this.getQosAnnotations_SpecifiedOutputParameterAbstraction() != null;
        }
        return super.eIsSet(featureID);
    }

} // SpecifiedOutputParameterAbstractionImpl
