/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.impl.QualityStatementImpl;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Quality Annotation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#isValid <em>Is Valid
 * </em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getForServiceSpecification
 * <em>For Service Specification</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getStipulatedREPrecisions
 * <em>Stipulated RE Precisions</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getInternalStateInfluenceAnalysisResults
 * <em>Internal State Influence Analysis Results</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getProbabilisticElements
 * <em>Probabilistic Elements</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getValidForParameterPartitions
 * <em>Valid For Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityAnnotationImpl extends QualityStatementImpl implements QualityAnnotation {

    /**
     * The default value of the '{@link #isValid() <em>Is Valid</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isValid()
     * @generated
     * @ordered
     */
    protected static final boolean IS_VALID_EDEFAULT = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected QualityAnnotationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.QUALITY_ANNOTATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isValid() {
        return (Boolean) this.eDynamicGet(QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__IS_VALID, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIsValid(final boolean newIsValid) {
        this.eDynamicSet(QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__IS_VALID, newIsValid);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ServiceSpecification getForServiceSpecification() {
        return (ServiceSpecification) this.eDynamicGet(
                QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetForServiceSpecification(final ServiceSpecification newForServiceSpecification,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newForServiceSpecification,
                QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setForServiceSpecification(final ServiceSpecification newForServiceSpecification) {
        this.eDynamicSet(QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION,
                newForServiceSpecification);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<RequiredElement> getStipulatedREPrecisions() {
        return (EList<RequiredElement>) this.eDynamicGet(
                QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisResults() {
        return (EList<InternalStateInfluenceAnalysisAggregation>) this.eDynamicGet(
                QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ProbabilisticElement> getProbabilisticElements() {
        return (EList<ProbabilisticElement>) this.eDynamicGet(
                QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterPartition> getValidForParameterPartitions() {
        return (EList<ParameterPartition>) this.eDynamicGet(
                QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS,
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, true, true);
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            final ServiceSpecification forServiceSpecification = this.getForServiceSpecification();
            if (forServiceSpecification != null) {
                msgs = ((InternalEObject) forServiceSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, null, msgs);
            }
            return this.basicSetForServiceSpecification((ServiceSpecification) otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getStipulatedREPrecisions()).basicAdd(
                    otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInternalStateInfluenceAnalysisResults())
                    .basicAdd(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getProbabilisticElements()).basicAdd(
                    otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getValidForParameterPartitions())
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
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.basicSetForServiceSpecification(null, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return ((InternalEList<?>) this.getStipulatedREPrecisions()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return ((InternalEList<?>) this.getInternalStateInfluenceAnalysisResults()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return ((InternalEList<?>) this.getProbabilisticElements()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return ((InternalEList<?>) this.getValidForParameterPartitions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            return this.isValid();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.getForServiceSpecification();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return this.getStipulatedREPrecisions();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return this.getInternalStateInfluenceAnalysisResults();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return this.getProbabilisticElements();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return this.getValidForParameterPartitions();
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            this.setIsValid((Boolean) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            this.setForServiceSpecification((ServiceSpecification) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            this.getStipulatedREPrecisions().clear();
            this.getStipulatedREPrecisions().addAll((Collection<? extends RequiredElement>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            this.getInternalStateInfluenceAnalysisResults().clear();
            this.getInternalStateInfluenceAnalysisResults().addAll(
                    (Collection<? extends InternalStateInfluenceAnalysisAggregation>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            this.getProbabilisticElements().clear();
            this.getProbabilisticElements().addAll((Collection<? extends ProbabilisticElement>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            this.getValidForParameterPartitions().clear();
            this.getValidForParameterPartitions().addAll((Collection<? extends ParameterPartition>) newValue);
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            this.setIsValid(IS_VALID_EDEFAULT);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            this.setForServiceSpecification((ServiceSpecification) null);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            this.getStipulatedREPrecisions().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            this.getInternalStateInfluenceAnalysisResults().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            this.getProbabilisticElements().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            this.getValidForParameterPartitions().clear();
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            return this.isValid() != IS_VALID_EDEFAULT;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.getForServiceSpecification() != null;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return !this.getStipulatedREPrecisions().isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return !this.getInternalStateInfluenceAnalysisResults().isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return !this.getProbabilisticElements().isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return !this.getValidForParameterPartitions().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // QualityAnnotationImpl
