/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal State Influence Analysis Aggregation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getQualityAnnotation <em>Quality Annotation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getParameterValueDeviations <em>Parameter Value Deviations</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getRequiredElementDeviations <em>Required Element Deviations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalStateInfluenceAnalysisAggregationImpl extends IdentifierImpl implements InternalStateInfluenceAnalysisAggregation {
	/**
     * The cached value of the '{@link #getParameterValueDeviations() <em>Parameter Value Deviations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterValueDeviations()
     * @generated
     * @ordered
     */
	protected EList<ParameterValueDeviation> parameterValueDeviations;

	/**
     * The cached value of the '{@link #getRequiredElementDeviations() <em>Required Element Deviations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRequiredElementDeviations()
     * @generated
     * @ordered
     */
	protected EList<RequiredElementDeviation> requiredElementDeviations;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected InternalStateInfluenceAnalysisAggregationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QualityAnnotation getQualityAnnotation() {
        if (eContainerFeatureID() != QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION) return null;
        return (QualityAnnotation)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetQualityAnnotation(QualityAnnotation newQualityAnnotation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newQualityAnnotation, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setQualityAnnotation(QualityAnnotation newQualityAnnotation) {
        if (newQualityAnnotation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQualityAnnotation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newQualityAnnotation != null)
                msgs = ((InternalEObject)newQualityAnnotation).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS, QualityAnnotation.class, msgs);
            msgs = basicSetQualityAnnotation(newQualityAnnotation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION, newQualityAnnotation, newQualityAnnotation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ParameterValueDeviation> getParameterValueDeviations() {
        if (parameterValueDeviations == null) {
            parameterValueDeviations = new EObjectContainmentWithInverseEList<ParameterValueDeviation>(ParameterValueDeviation.class, this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
        }
        return parameterValueDeviations;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<RequiredElementDeviation> getRequiredElementDeviations() {
        if (requiredElementDeviations == null) {
            requiredElementDeviations = new EObjectContainmentWithInverseEList<RequiredElementDeviation>(RequiredElementDeviation.class, this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
        }
        return requiredElementDeviations;
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetQualityAnnotation((QualityAnnotation)otherEnd, msgs);
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterValueDeviations()).basicAdd(otherEnd, msgs);
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredElementDeviations()).basicAdd(otherEnd, msgs);
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                return basicSetQualityAnnotation(null, msgs);
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                return ((InternalEList<?>)getParameterValueDeviations()).basicRemove(otherEnd, msgs);
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                return ((InternalEList<?>)getRequiredElementDeviations()).basicRemove(otherEnd, msgs);
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS, QualityAnnotation.class, msgs);
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                return getQualityAnnotation();
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                return getParameterValueDeviations();
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                return getRequiredElementDeviations();
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                setQualityAnnotation((QualityAnnotation)newValue);
                return;
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                getParameterValueDeviations().clear();
                getParameterValueDeviations().addAll((Collection<? extends ParameterValueDeviation>)newValue);
                return;
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                getRequiredElementDeviations().clear();
                getRequiredElementDeviations().addAll((Collection<? extends RequiredElementDeviation>)newValue);
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                setQualityAnnotation((QualityAnnotation)null);
                return;
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                getParameterValueDeviations().clear();
                return;
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                getRequiredElementDeviations().clear();
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
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION:
                return getQualityAnnotation() != null;
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS:
                return parameterValueDeviations != null && !parameterValueDeviations.isEmpty();
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS:
                return requiredElementDeviations != null && !requiredElementDeviations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //InternalStateInfluenceAnalysisAggregationImpl
