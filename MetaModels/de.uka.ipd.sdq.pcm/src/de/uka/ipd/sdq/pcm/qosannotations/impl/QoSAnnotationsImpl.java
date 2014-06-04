/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.util.QosannotationsValidator;
import de.uka.ipd.sdq.pcm.system.SystemPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Qo SAnnotations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl#getSpecifiedOutputParameterAbstractions_QoSAnnotations <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl#getSystem_QoSAnnotations <em>System Qo SAnnotations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl#getSpecifiedQoSAnnotations_QoSAnnotations <em>Specified Qo SAnnotations Qo SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QoSAnnotationsImpl extends EntityImpl implements QoSAnnotations {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSpecifiedOutputParameterAbstractions_QoSAnnotations() <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getSpecifiedOutputParameterAbstractions_QoSAnnotations()
     * @generated
     * @ordered
     */
    protected EList<SpecifiedOutputParameterAbstraction> specifiedOutputParameterAbstractions_QoSAnnotations;

    /**
     * The cached value of the '{@link #getSpecifiedQoSAnnotations_QoSAnnotations()
     * <em>Specified Qo SAnnotations Qo SAnnotations</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecifiedQoSAnnotations_QoSAnnotations()
     * @generated
     * @ordered
     */
    protected EList<SpecifiedQoSAnnotation> specifiedQoSAnnotations_QoSAnnotations;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected QoSAnnotationsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosannotationsPackage.Literals.QO_SANNOTATIONS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<SpecifiedOutputParameterAbstraction> getSpecifiedOutputParameterAbstractions_QoSAnnotations() {
        if (specifiedOutputParameterAbstractions_QoSAnnotations == null) {
            specifiedOutputParameterAbstractions_QoSAnnotations = new EObjectContainmentWithInverseEList<SpecifiedOutputParameterAbstraction>(SpecifiedOutputParameterAbstraction.class, this, QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS, QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__QOS_ANNOTATIONS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION);
        }
        return specifiedOutputParameterAbstractions_QoSAnnotations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System getSystem_QoSAnnotations() {
        if (eContainerFeatureID() != QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS) return null;
        return (de.uka.ipd.sdq.pcm.system.System)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSystem_QoSAnnotations(de.uka.ipd.sdq.pcm.system.System newSystem_QoSAnnotations,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSystem_QoSAnnotations, QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSystem_QoSAnnotations(de.uka.ipd.sdq.pcm.system.System newSystem_QoSAnnotations) {
        if (newSystem_QoSAnnotations != eInternalContainer() || (eContainerFeatureID() != QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS && newSystem_QoSAnnotations != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newSystem_QoSAnnotations))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSystem_QoSAnnotations != null)
                msgs = ((InternalEObject)newSystem_QoSAnnotations).eInverseAdd(this, SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
            msgs = basicSetSystem_QoSAnnotations(newSystem_QoSAnnotations, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS, newSystem_QoSAnnotations, newSystem_QoSAnnotations));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<SpecifiedQoSAnnotation> getSpecifiedQoSAnnotations_QoSAnnotations() {
        if (specifiedQoSAnnotations_QoSAnnotations == null) {
            specifiedQoSAnnotations_QoSAnnotations = new EObjectContainmentWithInverseEList<SpecifiedQoSAnnotation>(SpecifiedQoSAnnotation.class, this, QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__QOS_ANNOTATIONS_SPECIFIED_QO_SANNOTATION);
        }
        return specifiedQoSAnnotations_QoSAnnotations;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleReliabilityAnnotationsPerExternalCallNotAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Reliability Annotations Per External Call Not Allowed</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #MultipleReliabilityAnnotationsPerExternalCallNotAllowed(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.specifiedQoSAnnotations_QoSAnnotations->select(oclIsTypeOf(pcm::qosannotations::qos_reliability::SpecifiedReliabilityAnnotation))->forAll( x, y | ( x<>y ) implies ( ( x.role_SpecifiedQoSAnnotation <> y.role_SpecifiedQoSAnnotation )  or ( x.signature_SpecifiedQoSAnnation <> y.signature_SpecifiedQoSAnnation ) ) )";

    /**
     * The cached OCL invariant for the '{@link #MultipleReliabilityAnnotationsPerExternalCallNotAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiple Reliability Annotations Per External Call Not Allowed</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #MultipleReliabilityAnnotationsPerExternalCallNotAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean MultipleReliabilityAnnotationsPerExternalCallNotAllowed(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QosannotationsPackage.Literals.QO_SANNOTATIONS);
            try {
                MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         QosannotationsValidator.DIAGNOSTIC_SOURCE,
                         QosannotationsValidator.QO_SANNOTATIONS__MULTIPLE_RELIABILITY_ANNOTATIONS_PER_EXTERNAL_CALL_NOT_ALLOWED,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MultipleReliabilityAnnotationsPerExternalCallNotAllowed", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecifiedOutputParameterAbstractions_QoSAnnotations()).basicAdd(otherEnd, msgs);
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSystem_QoSAnnotations((de.uka.ipd.sdq.pcm.system.System)otherEnd, msgs);
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecifiedQoSAnnotations_QoSAnnotations()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                return ((InternalEList<?>)getSpecifiedOutputParameterAbstractions_QoSAnnotations()).basicRemove(otherEnd, msgs);
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                return basicSetSystem_QoSAnnotations(null, msgs);
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                return ((InternalEList<?>)getSpecifiedQoSAnnotations_QoSAnnotations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                return eInternalContainer().eInverseRemove(this, SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                return getSpecifiedOutputParameterAbstractions_QoSAnnotations();
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                return getSystem_QoSAnnotations();
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                return getSpecifiedQoSAnnotations_QoSAnnotations();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                getSpecifiedOutputParameterAbstractions_QoSAnnotations().clear();
                getSpecifiedOutputParameterAbstractions_QoSAnnotations().addAll((Collection<? extends SpecifiedOutputParameterAbstraction>)newValue);
                return;
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                setSystem_QoSAnnotations((de.uka.ipd.sdq.pcm.system.System)newValue);
                return;
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                getSpecifiedQoSAnnotations_QoSAnnotations().clear();
                getSpecifiedQoSAnnotations_QoSAnnotations().addAll((Collection<? extends SpecifiedQoSAnnotation>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                getSpecifiedOutputParameterAbstractions_QoSAnnotations().clear();
                return;
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                setSystem_QoSAnnotations((de.uka.ipd.sdq.pcm.system.System)null);
                return;
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                getSpecifiedQoSAnnotations_QoSAnnotations().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
                return specifiedOutputParameterAbstractions_QoSAnnotations != null && !specifiedOutputParameterAbstractions_QoSAnnotations.isEmpty();
            case QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS:
                return getSystem_QoSAnnotations() != null;
            case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
                return specifiedQoSAnnotations_QoSAnnotations != null && !specifiedQoSAnnotations_QoSAnnotations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // QoSAnnotationsImpl
