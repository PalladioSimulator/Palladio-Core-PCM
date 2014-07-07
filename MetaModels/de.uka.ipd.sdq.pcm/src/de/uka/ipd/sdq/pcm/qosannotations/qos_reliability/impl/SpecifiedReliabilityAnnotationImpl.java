/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.util.QosReliabilityValidator;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Specified Reliability Annotation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl.SpecifiedReliabilityAnnotationImpl#getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation
 * <em>External Failure Occurrence Descriptions Specified Reliability Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecifiedReliabilityAnnotationImpl extends SpecifiedQoSAnnotationImpl implements
        SpecifiedReliabilityAnnotation {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation()
     * <em>External Failure Occurrence Descriptions Specified Reliability Annotation</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation()
     * @generated
     * @ordered
     */
    protected EList<ExternalFailureOccurrenceDescription> externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SpecifiedReliabilityAnnotationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosReliabilityPackage.Literals.SPECIFIED_RELIABILITY_ANNOTATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ExternalFailureOccurrenceDescription> getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation() {
        if (externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation == null) {
            externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation = new EObjectContainmentWithInverseEList<ExternalFailureOccurrenceDescription>(
                    ExternalFailureOccurrenceDescription.class,
                    this,
                    QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION,
                    ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION);
        }
        return externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Specified Reliability Annotation Must Reference Required Role Of ASystem</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.role_SpecifiedQoSAnnotation.oclIsTypeOf(pcm::repository::OperationRequiredRole)) and (self.role_SpecifiedQoSAnnotation.oclAsType(pcm::repository::OperationRequiredRole).requiringEntity_RequiredRole.oclIsTypeOf(pcm::system::System))\n"
            + "\n" + "\n" + "";

    /**
     * The cached OCL invariant for the '
     * {@link #SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Specified Reliability Annotation Must Reference Required Role Of ASystem</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QosReliabilityPackage.Literals.SPECIFIED_RELIABILITY_ANNOTATION);
            try {
                SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QosReliabilityValidator.DIAGNOSTIC_SOURCE,
                                QosReliabilityValidator.SPECIFIED_RELIABILITY_ANNOTATION__SPECIFIED_RELIABILITY_ANNOTATION_MUST_REFERENCE_REQUIRED_ROLE_OF_ASYSTEM,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "SpecifiedReliabilityAnnotationMustReferenceRequiredRoleOfASystem",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Sum Of Reliability Annotation Failure Probabilities Must Not Exceed1</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation.failureProbability.oclAsType(Real)->sum()<=1.0";

    /**
     * The cached OCL invariant for the '
     * {@link #SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Sum Of Reliability Annotation Failure Probabilities Must Not Exceed1</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QosReliabilityPackage.Literals.SPECIFIED_RELIABILITY_ANNOTATION);
            try {
                SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QosReliabilityValidator.DIAGNOSTIC_SOURCE,
                                QosReliabilityValidator.SPECIFIED_RELIABILITY_ANNOTATION__SUM_OF_RELIABILITY_ANNOTATION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "SumOfReliabilityAnnotationFailureProbabilitiesMustNotExceed1",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple External Occurrence Descriptions Per Failure Type Not Allowed</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation->forAll(x:pcm::reliability::ExternalFailureOccurrenceDescription,y:pcm::reliability::ExternalFailureOccurrenceDescription  | x<>y implies x.failureType__ExternalFailureOccurrenceDescription <> y.failureType__ExternalFailureOccurrenceDescription )";

    /**
     * The cached OCL invariant for the '
     * {@link #MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple External Occurrence Descriptions Per Failure Type Not Allowed</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QosReliabilityPackage.Literals.SPECIFIED_RELIABILITY_ANNOTATION);
            try {
                MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QosReliabilityValidator.DIAGNOSTIC_SOURCE,
                                QosReliabilityValidator.SPECIFIED_RELIABILITY_ANNOTATION__MULTIPLE_EXTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "MultipleExternalOccurrenceDescriptionsPerFailureTypeNotAllowed",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation())
                    .basicAdd(otherEnd, msgs);
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
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            return ((InternalEList<?>) getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation())
                    .basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            return getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation();
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
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation().clear();
            getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation().addAll(
                    (Collection<? extends ExternalFailureOccurrenceDescription>) newValue);
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
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation().clear();
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
        case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION:
            return externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation != null
                    && !externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // SpecifiedReliabilityAnnotationImpl
