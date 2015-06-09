/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Element Deviation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getInternalStateInfluenceAnalysisAggregation
 * <em>Internal State Influence Analysis Aggregation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getMaximumDeviationNumberOfCalls
 * <em>Maximum Deviation Number Of Calls</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getMaximumDeviationCallParameterValues
 * <em>Maximum Deviation Call Parameter Values</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getRequiredElement
 * <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredElementDeviationImpl extends CDOObjectImpl implements RequiredElementDeviation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequiredElementDeviationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION;
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
    public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
        return (InternalStateInfluenceAnalysisAggregation) this
                .eDynamicGet(
                        QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                        QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
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
        msgs = this.eBasicSetContainer((InternalEObject) newInternalStateInfluenceAnalysisAggregation,
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
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
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                newInternalStateInfluenceAnalysisAggregation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Precision getMaximumDeviationNumberOfCalls() {
        return (Precision) this.eDynamicGet(
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Precision basicGetMaximumDeviationNumberOfCalls() {
        return (Precision) this.eDynamicGet(
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMaximumDeviationNumberOfCalls(final Precision newMaximumDeviationNumberOfCalls) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS,
                newMaximumDeviationNumberOfCalls);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterValueDeviation> getMaximumDeviationCallParameterValues() {
        return (EList<ParameterValueDeviation>) this.eDynamicGet(
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElement getRequiredElement() {
        return (RequiredElement) this.eDynamicGet(
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRequiredElement(final RequiredElement newRequiredElement, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newRequiredElement,
                QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredElement(final RequiredElement newRequiredElement) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, newRequiredElement);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInternalStateInfluenceAnalysisAggregation(
                    (InternalStateInfluenceAnalysisAggregation) otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getMaximumDeviationCallParameterValues())
                    .basicAdd(otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            final RequiredElement requiredElement = this.getRequiredElement();
            if (requiredElement != null) {
                msgs = ((InternalEObject) requiredElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, null, msgs);
            }
            return this.basicSetRequiredElement((RequiredElement) otherEnd, msgs);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            return ((InternalEList<?>) this.getMaximumDeviationCallParameterValues()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            return this.basicSetRequiredElement(null, msgs);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this
                    .eInternalContainer()
                    .eInverseRemove(
                            this,
                            QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS,
                            InternalStateInfluenceAnalysisAggregation.class, msgs);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation();
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
            if (resolve) {
                return this.getMaximumDeviationNumberOfCalls();
            }
            return this.basicGetMaximumDeviationNumberOfCalls();
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            return this.getMaximumDeviationCallParameterValues();
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            return this.getRequiredElement();
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
            this.setMaximumDeviationNumberOfCalls((Precision) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            this.getMaximumDeviationCallParameterValues().clear();
            this.getMaximumDeviationCallParameterValues().addAll(
                    (Collection<? extends ParameterValueDeviation>) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            this.setRequiredElement((RequiredElement) newValue);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) null);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
            this.setMaximumDeviationNumberOfCalls((Precision) null);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            this.getMaximumDeviationCallParameterValues().clear();
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            this.setRequiredElement((RequiredElement) null);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation() != null;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
            return this.basicGetMaximumDeviationNumberOfCalls() != null;
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
            return !this.getMaximumDeviationCallParameterValues().isEmpty();
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
            return this.getRequiredElement() != null;
        }
        return super.eIsSet(featureID);
    }

} // RequiredElementDeviationImpl
