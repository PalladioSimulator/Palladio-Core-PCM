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

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

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
public abstract class SpecifiedOutputParameterAbstractionImpl extends EStereotypableObjectImpl implements
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
    public QoSAnnotations getQosAnnotations_SpecifiedOutputParameterAbstraction() {
        if (eContainerFeatureID() != QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION)
            return null;
        return (QoSAnnotations) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(
            QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction, NotificationChain msgs) {
        msgs = eBasicSetContainer(
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
    public void setQosAnnotations_SpecifiedOutputParameterAbstraction(
            QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction) {
        if (newQosAnnotations_SpecifiedOutputParameterAbstraction != eInternalContainer()
                || (eContainerFeatureID() != QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION && newQosAnnotations_SpecifiedOutputParameterAbstraction != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newQosAnnotations_SpecifiedOutputParameterAbstraction))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newQosAnnotations_SpecifiedOutputParameterAbstraction != null)
                msgs = ((InternalEObject) newQosAnnotations_SpecifiedOutputParameterAbstraction).eInverseAdd(this,
                        QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS,
                        QoSAnnotations.class, msgs);
            msgs = basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(
                    newQosAnnotations_SpecifiedOutputParameterAbstraction, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    newQosAnnotations_SpecifiedOutputParameterAbstraction,
                    newQosAnnotations_SpecifiedOutputParameterAbstraction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Signature getSignature_SpecifiedOutputParameterAbstraction() {
        if (signature_SpecifiedOutputParameterAbstraction != null
                && ((EObject) signature_SpecifiedOutputParameterAbstraction).eIsProxy()) {
            InternalEObject oldSignature_SpecifiedOutputParameterAbstraction = (InternalEObject) signature_SpecifiedOutputParameterAbstraction;
            signature_SpecifiedOutputParameterAbstraction = (Signature) eResolveProxy(oldSignature_SpecifiedOutputParameterAbstraction);
            if (signature_SpecifiedOutputParameterAbstraction != oldSignature_SpecifiedOutputParameterAbstraction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                            oldSignature_SpecifiedOutputParameterAbstraction,
                            signature_SpecifiedOutputParameterAbstraction));
            }
        }
        return signature_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Signature basicGetSignature_SpecifiedOutputParameterAbstraction() {
        return signature_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSignature_SpecifiedOutputParameterAbstraction(
            Signature newSignature_SpecifiedOutputParameterAbstraction) {
        Signature oldSignature_SpecifiedOutputParameterAbstraction = signature_SpecifiedOutputParameterAbstraction;
        signature_SpecifiedOutputParameterAbstraction = newSignature_SpecifiedOutputParameterAbstraction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    oldSignature_SpecifiedOutputParameterAbstraction, signature_SpecifiedOutputParameterAbstraction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Role getRole_SpecifiedOutputParameterAbstraction() {
        if (role_SpecifiedOutputParameterAbstraction != null
                && ((EObject) role_SpecifiedOutputParameterAbstraction).eIsProxy()) {
            InternalEObject oldRole_SpecifiedOutputParameterAbstraction = (InternalEObject) role_SpecifiedOutputParameterAbstraction;
            role_SpecifiedOutputParameterAbstraction = (Role) eResolveProxy(oldRole_SpecifiedOutputParameterAbstraction);
            if (role_SpecifiedOutputParameterAbstraction != oldRole_SpecifiedOutputParameterAbstraction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                            oldRole_SpecifiedOutputParameterAbstraction, role_SpecifiedOutputParameterAbstraction));
            }
        }
        return role_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Role basicGetRole_SpecifiedOutputParameterAbstraction() {
        return role_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRole_SpecifiedOutputParameterAbstraction(Role newRole_SpecifiedOutputParameterAbstraction) {
        Role oldRole_SpecifiedOutputParameterAbstraction = role_SpecifiedOutputParameterAbstraction;
        role_SpecifiedOutputParameterAbstraction = newRole_SpecifiedOutputParameterAbstraction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    oldRole_SpecifiedOutputParameterAbstraction, role_SpecifiedOutputParameterAbstraction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<VariableUsage> getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction() {
        if (expectedExternalOutputs_SpecifiedOutputParameterAbstraction == null) {
            expectedExternalOutputs_SpecifiedOutputParameterAbstraction = new EObjectContainmentWithInverseEList<VariableUsage>(
                    VariableUsage.class,
                    this,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE);
        }
        return expectedExternalOutputs_SpecifiedOutputParameterAbstraction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction())
                    .basicAdd(otherEnd, msgs);
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) otherEnd, msgs);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return ((InternalEList<?>) getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()).basicRemove(
                    otherEnd, msgs);
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(null, msgs);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return eInternalContainer().eInverseRemove(this,
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
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (resolve)
                return getSignature_SpecifiedOutputParameterAbstraction();
            return basicGetSignature_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            if (resolve)
                return getRole_SpecifiedOutputParameterAbstraction();
            return basicGetRole_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return getQosAnnotations_SpecifiedOutputParameterAbstraction();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setSignature_SpecifiedOutputParameterAbstraction((Signature) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setRole_SpecifiedOutputParameterAbstraction((Role) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().clear();
            getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().addAll(
                    (Collection<? extends VariableUsage>) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) newValue);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setSignature_SpecifiedOutputParameterAbstraction((Signature) null);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setRole_SpecifiedOutputParameterAbstraction((Role) null);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().clear();
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) null);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return signature_SpecifiedOutputParameterAbstraction != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return role_SpecifiedOutputParameterAbstraction != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return expectedExternalOutputs_SpecifiedOutputParameterAbstraction != null
                    && !expectedExternalOutputs_SpecifiedOutputParameterAbstraction.isEmpty();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return getQosAnnotations_SpecifiedOutputParameterAbstraction() != null;
        }
        return super.eIsSet(featureID);
    }

} // SpecifiedOutputParameterAbstractionImpl
