/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.reliability.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import org.palladiosimulator.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;
import org.palladiosimulator.pcm.reliability.ExternalFailureOccurrenceDescription;
import org.palladiosimulator.pcm.reliability.FailureType;
import org.palladiosimulator.pcm.reliability.ReliabilityPackage;
import org.palladiosimulator.pcm.reliability.util.ReliabilityValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Failure Occurrence Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription
 * <em>Specified Reliability Annotation External Failure Occurrence Description</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getFailureType__ExternalFailureOccurrenceDescription
 * <em>Failure Type External Failure Occurrence Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalFailureOccurrenceDescriptionImpl extends FailureOccurrenceDescriptionImpl
        implements ExternalFailureOccurrenceDescription {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ExternalFailureOccurrenceDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SpecifiedReliabilityAnnotation getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription() {
        return (SpecifiedReliabilityAnnotation) this.eDynamicGet(
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
            final SpecifiedReliabilityAnnotation newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer(
                (InternalEObject) newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription,
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
            final SpecifiedReliabilityAnnotation newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription) {
        this.eDynamicSet(
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FailureType getFailureType__ExternalFailureOccurrenceDescription() {
        return (FailureType) this.eDynamicGet(
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public FailureType basicGetFailureType__ExternalFailureOccurrenceDescription() {
        return (FailureType) this.eDynamicGet(
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFailureType__ExternalFailureOccurrenceDescription(
            final FailureType newFailureType__ExternalFailureOccurrenceDescription) {
        this.eDynamicSet(
                ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                newFailureType__ExternalFailureOccurrenceDescription);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, ReliabilityValidator.DIAGNOSTIC_SOURCE,
                                ReliabilityValidator.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] {
                                                "NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
                    (SpecifiedReliabilityAnnotation) otherEnd, msgs);
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return this.basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(null, msgs);
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return this.eInternalContainer().eInverseRemove(this,
                    QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION,
                    SpecifiedReliabilityAnnotation.class, msgs);
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return this.getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription();
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            if (resolve) {
                return this.getFailureType__ExternalFailureOccurrenceDescription();
            }
            return this.basicGetFailureType__ExternalFailureOccurrenceDescription();
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            this.setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
                    (SpecifiedReliabilityAnnotation) newValue);
            return;
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            this.setFailureType__ExternalFailureOccurrenceDescription((FailureType) newValue);
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            this.setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
                    (SpecifiedReliabilityAnnotation) null);
            return;
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            this.setFailureType__ExternalFailureOccurrenceDescription((FailureType) null);
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
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return this.getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription() != null;
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return this.basicGetFailureType__ExternalFailureOccurrenceDescription() != null;
        }
        return super.eIsSet(featureID);
    }

} // ExternalFailureOccurrenceDescriptionImpl
