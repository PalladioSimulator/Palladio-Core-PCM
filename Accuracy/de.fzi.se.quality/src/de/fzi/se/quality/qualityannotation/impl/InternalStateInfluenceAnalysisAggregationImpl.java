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

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Internal State Influence Analysis Aggregation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getQualityAnnotation
 * <em>Quality Annotation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getParameterValueDeviations
 * <em>Parameter Value Deviations</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getRequiredElementDeviations
 * <em>Required Element Deviations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalStateInfluenceAnalysisAggregationImpl extends IdentifierImpl implements
InternalStateInfluenceAnalysisAggregation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InternalStateInfluenceAnalysisAggregationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        return (QualityAnnotation) this.eDynamicGet(
                QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQualityAnnotation(final QualityAnnotation newQualityAnnotation,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQualityAnnotation,
                QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualityAnnotation(final QualityAnnotation newQualityAnnotation) {
        this.eDynamicSet(QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION,
                newQualityAnnotation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterValueDeviation> getParameterValueDeviations() {
        return (EList<ParameterValueDeviation>) this
                .eDynamicGet(
                        QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS,
                        QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS,
                        true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<RequiredElementDeviation> getRequiredElementDeviations() {
        return (EList<RequiredElementDeviation>) this
                .eDynamicGet(
                        QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS,
                        QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS,
                        true, true);
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityAnnotation((QualityAnnotation) otherEnd, msgs);
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getParameterValueDeviations()).basicAdd(
                    otherEnd, msgs);
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getRequiredElementDeviations()).basicAdd(
                    otherEnd, msgs);
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            return this.basicSetQualityAnnotation(null, msgs);
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            return ((InternalEList<?>) this.getParameterValueDeviations()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            return ((InternalEList<?>) this.getRequiredElementDeviations()).basicRemove(otherEnd, msgs);
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS,
                    QualityAnnotation.class, msgs);
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation();
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            return this.getParameterValueDeviations();
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            return this.getRequiredElementDeviations();
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) newValue);
            return;
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            this.getParameterValueDeviations().clear();
            this.getParameterValueDeviations().addAll((Collection<? extends ParameterValueDeviation>) newValue);
            return;
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            this.getRequiredElementDeviations().clear();
            this.getRequiredElementDeviations().addAll((Collection<? extends RequiredElementDeviation>) newValue);
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) null);
            return;
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            this.getParameterValueDeviations().clear();
            return;
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            this.getRequiredElementDeviations().clear();
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
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
            return !this.getParameterValueDeviations().isEmpty();
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
            return !this.getRequiredElementDeviations().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // InternalStateInfluenceAnalysisAggregationImpl
