/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Value Deviation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterReference
 * <em>Parameter Reference</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getInternalStateInfluenceAnalysisAggregation
 * <em>Internal State Influence Analysis Aggregation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getRequiredElementDeviation
 * <em>Required Element Deviation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterValue
 * <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterValueDeviationImpl extends CDOObjectImpl implements ParameterValueDeviation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParameterValueDeviationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterReference getParameterReference() {
        return (ParameterReference) this.eDynamicGet(
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterReference(final ParameterReference newParameterReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newParameterReference,
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterReference(final ParameterReference newParameterReference) {
        this.eDynamicSet(QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, newParameterReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
        return (InternalStateInfluenceAnalysisAggregation) this
                .eDynamicGet(
                        QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                        QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                        true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(
            final InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation,
            NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newInternalStateInfluenceAnalysisAggregation,
                        QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInternalStateInfluenceAnalysisAggregation(
            final InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
        this.eDynamicSet(
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                newInternalStateInfluenceAnalysisAggregation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElementDeviation getRequiredElementDeviation() {
        return (RequiredElementDeviation) this.eDynamicGet(
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRequiredElementDeviation(
            final RequiredElementDeviation newRequiredElementDeviation, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRequiredElementDeviation,
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredElementDeviation(final RequiredElementDeviation newRequiredElementDeviation) {
        this.eDynamicSet(QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION,
                newRequiredElementDeviation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterValue getParameterValue() {
        return (ParameterValue) this.eDynamicGet(QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterValue(final ParameterValue newParameterValue, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newParameterValue,
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterValue(final ParameterValue newParameterValue) {
        this.eDynamicSet(QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE,
                QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, newParameterValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            final ParameterReference parameterReference = this.getParameterReference();
            if (parameterReference != null) {
                msgs = ((InternalEObject) parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, null, msgs);
            }
            return this.basicSetParameterReference((ParameterReference) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInternalStateInfluenceAnalysisAggregation(
                    (InternalStateInfluenceAnalysisAggregation) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRequiredElementDeviation((RequiredElementDeviation) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            final ParameterValue parameterValue = this.getParameterValue();
            if (parameterValue != null) {
                msgs = ((InternalEObject) parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, null, msgs);
            }
            return this.basicSetParameterValue((ParameterValue) otherEnd, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.basicSetParameterReference(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.basicSetRequiredElementDeviation(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.basicSetParameterValue(null, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS,
                    InternalStateInfluenceAnalysisAggregation.class, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES,
                    RequiredElementDeviation.class, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.getParameterReference();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.getParameterValue();
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) newValue);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) null);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.getParameterReference() != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation() != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation() != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.getParameterValue() != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterValueDeviationImpl
