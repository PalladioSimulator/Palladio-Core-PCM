/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.qosannotations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.qosannotations.QosannotationsPackage;
import org.palladiosimulator.pcm.qosannotations.SpecifiedOutputParameterAbstraction;

import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specified Output Parameter Abstraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getSignature_SpecifiedOutputParameterAbstraction <em>Signature Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getRole_SpecifiedOutputParameterAbstraction <em>Role Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction <em>Expected External Outputs Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.qosannotations.impl.SpecifiedOutputParameterAbstractionImpl#getQosAnnotations_SpecifiedOutputParameterAbstraction <em>Qos Annotations Specified Output Parameter Abstraction</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SpecifiedOutputParameterAbstractionImpl extends CDOObjectImpl
        implements SpecifiedOutputParameterAbstraction {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecifiedOutputParameterAbstractionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature getSignature_SpecifiedOutputParameterAbstraction() {
        return (Signature) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature basicGetSignature_SpecifiedOutputParameterAbstraction() {
        return (Signature) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSignature_SpecifiedOutputParameterAbstraction(
            Signature newSignature_SpecifiedOutputParameterAbstraction) {
        eDynamicSet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                newSignature_SpecifiedOutputParameterAbstraction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Role getRole_SpecifiedOutputParameterAbstraction() {
        return (Role) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Role basicGetRole_SpecifiedOutputParameterAbstraction() {
        return (Role) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole_SpecifiedOutputParameterAbstraction(Role newRole_SpecifiedOutputParameterAbstraction) {
        eDynamicSet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                newRole_SpecifiedOutputParameterAbstraction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction() {
        return (EList<VariableUsage>) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QoSAnnotations getQosAnnotations_SpecifiedOutputParameterAbstraction() {
        return (QoSAnnotations) eDynamicGet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(
            QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newQosAnnotations_SpecifiedOutputParameterAbstraction,
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQosAnnotations_SpecifiedOutputParameterAbstraction(
            QoSAnnotations newQosAnnotations_SpecifiedOutputParameterAbstraction) {
        eDynamicSet(
                QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                QosannotationsPackage.Literals.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                newQosAnnotations_SpecifiedOutputParameterAbstraction);
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return ((InternalEList<?>) getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction())
                    .basicRemove(otherEnd, msgs);
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return basicSetQosAnnotations_SpecifiedOutputParameterAbstraction(null, msgs);
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
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return eInternalContainer().eInverseRemove(this,
                    QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS,
                    QoSAnnotations.class, msgs);
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
            getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction()
                    .addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            setQosAnnotations_SpecifiedOutputParameterAbstraction((QoSAnnotations) newValue);
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__SIGNATURE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return basicGetSignature_SpecifiedOutputParameterAbstraction() != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__ROLE_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return basicGetRole_SpecifiedOutputParameterAbstraction() != null;
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return !getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction().isEmpty();
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION:
            return getQosAnnotations_SpecifiedOutputParameterAbstraction() != null;
        }
        return super.eIsSet(featureID);
    }

} //SpecifiedOutputParameterAbstractionImpl
