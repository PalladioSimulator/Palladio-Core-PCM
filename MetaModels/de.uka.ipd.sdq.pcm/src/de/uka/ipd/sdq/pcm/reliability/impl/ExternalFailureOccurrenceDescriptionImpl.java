/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.util.ReliabilityValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Failure Occurrence Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription
 * <em>Specified Reliability Annotation External Failure Occurrence Description</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getFailureType__ExternalFailureOccurrenceDescription
 * <em>Failure Type External Failure Occurrence Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalFailureOccurrenceDescriptionImpl extends FailureOccurrenceDescriptionImpl implements
ExternalFailureOccurrenceDescription {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getFailureType__ExternalFailureOccurrenceDescription()
     * <em>Failure Type External Failure Occurrence Description</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFailureType__ExternalFailureOccurrenceDescription()
     * @generated
     * @ordered
     */
    protected FailureType failureType__ExternalFailureOccurrenceDescription;

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
        if (this.eContainerFeatureID() != ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION) {
            return null;
        }
        return (SpecifiedReliabilityAnnotation) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
            final SpecifiedReliabilityAnnotation newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription,
            NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
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
        if (newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != this.eInternalContainer()
                || (this.eContainerFeatureID() != ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION && newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != null)) {
            if (EcoreUtil.isAncestor(this, newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != null) {
                msgs = ((InternalEObject) newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription)
                        .eInverseAdd(
                                this,
                                QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION,
                                SpecifiedReliabilityAnnotation.class, msgs);
            }
            msgs = this.basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(
                    newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                    newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription,
                    newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FailureType getFailureType__ExternalFailureOccurrenceDescription() {
        if (this.failureType__ExternalFailureOccurrenceDescription != null
                && this.failureType__ExternalFailureOccurrenceDescription.eIsProxy()) {
            final InternalEObject oldFailureType__ExternalFailureOccurrenceDescription = (InternalEObject) this.failureType__ExternalFailureOccurrenceDescription;
            this.failureType__ExternalFailureOccurrenceDescription = (FailureType) this
                    .eResolveProxy(oldFailureType__ExternalFailureOccurrenceDescription);
            if (this.failureType__ExternalFailureOccurrenceDescription != oldFailureType__ExternalFailureOccurrenceDescription) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                            oldFailureType__ExternalFailureOccurrenceDescription,
                            this.failureType__ExternalFailureOccurrenceDescription));
                }
            }
        }
        return this.failureType__ExternalFailureOccurrenceDescription;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public FailureType basicGetFailureType__ExternalFailureOccurrenceDescription() {
        return this.failureType__ExternalFailureOccurrenceDescription;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFailureType__ExternalFailureOccurrenceDescription(
            final FailureType newFailureType__ExternalFailureOccurrenceDescription) {
        final FailureType oldFailureType__ExternalFailureOccurrenceDescription = this.failureType__ExternalFailureOccurrenceDescription;
        this.failureType__ExternalFailureOccurrenceDescription = newFailureType__ExternalFailureOccurrenceDescription;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                    oldFailureType__ExternalFailureOccurrenceDescription,
                    this.failureType__ExternalFailureOccurrenceDescription));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>No Resource Timeout Failure Allowed For External Failure Occurrence Description</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.failureType__ExternalFailureOccurrenceDescription.oclIsTypeOf(ResourceTimeoutFailureType)";

    /**
     * The cached OCL invariant for the '
     * {@link #NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>No Resource Timeout Failure Allowed For External Failure Occurrence Description</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION);
            try {
                NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        ReliabilityValidator.DIAGNOSTIC_SOURCE,
                        ReliabilityValidator.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription",
                                EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
            return this
                    .eInternalContainer()
                    .eInverseRemove(
                            this,
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
            this.setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription((SpecifiedReliabilityAnnotation) newValue);
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
            this.setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription((SpecifiedReliabilityAnnotation) null);
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
            return this.failureType__ExternalFailureOccurrenceDescription != null;
        }
        return super.eIsSet(featureID);
    }

} // ExternalFailureOccurrenceDescriptionImpl
