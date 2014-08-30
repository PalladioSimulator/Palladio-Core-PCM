/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Value Deviation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterReference <em>Parameter Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getRequiredElementDeviation <em>Required Element Deviation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterValue <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterValueDeviationImpl extends EObjectImpl implements ParameterValueDeviation {
	/**
     * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterReference()
     * @generated
     * @ordered
     */
	protected ParameterReference parameterReference;

	/**
     * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterValue()
     * @generated
     * @ordered
     */
	protected ParameterValue parameterValue;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterValueDeviationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterReference getParameterReference() {
        return parameterReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterReference(ParameterReference newParameterReference, NotificationChain msgs) {
        ParameterReference oldParameterReference = parameterReference;
        parameterReference = newParameterReference;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, oldParameterReference, newParameterReference);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterReference(ParameterReference newParameterReference) {
        if (newParameterReference != parameterReference) {
            NotificationChain msgs = null;
            if (parameterReference != null)
                msgs = ((InternalEObject)parameterReference).eInverseRemove(this, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, ParameterReference.class, msgs);
            if (newParameterReference != null)
                msgs = ((InternalEObject)newParameterReference).eInverseAdd(this, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, ParameterReference.class, msgs);
            msgs = basicSetParameterReference(newParameterReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, newParameterReference, newParameterReference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
        if (eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION) return null;
        return (InternalStateInfluenceAnalysisAggregation)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInternalStateInfluenceAnalysisAggregation, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
        if (newInternalStateInfluenceAnalysisAggregation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION && newInternalStateInfluenceAnalysisAggregation != null)) {
            if (EcoreUtil.isAncestor(this, newInternalStateInfluenceAnalysisAggregation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInternalStateInfluenceAnalysisAggregation != null)
                msgs = ((InternalEObject)newInternalStateInfluenceAnalysisAggregation).eInverseAdd(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS, InternalStateInfluenceAnalysisAggregation.class, msgs);
            msgs = basicSetInternalStateInfluenceAnalysisAggregation(newInternalStateInfluenceAnalysisAggregation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, newInternalStateInfluenceAnalysisAggregation, newInternalStateInfluenceAnalysisAggregation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RequiredElementDeviation getRequiredElementDeviation() {
        if (eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION) return null;
        return (RequiredElementDeviation)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRequiredElementDeviation(RequiredElementDeviation newRequiredElementDeviation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRequiredElementDeviation, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRequiredElementDeviation(RequiredElementDeviation newRequiredElementDeviation) {
        if (newRequiredElementDeviation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION && newRequiredElementDeviation != null)) {
            if (EcoreUtil.isAncestor(this, newRequiredElementDeviation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRequiredElementDeviation != null)
                msgs = ((InternalEObject)newRequiredElementDeviation).eInverseAdd(this, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES, RequiredElementDeviation.class, msgs);
            msgs = basicSetRequiredElementDeviation(newRequiredElementDeviation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION, newRequiredElementDeviation, newRequiredElementDeviation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterValue getParameterValue() {
        return parameterValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterValue(ParameterValue newParameterValue, NotificationChain msgs) {
        ParameterValue oldParameterValue = parameterValue;
        parameterValue = newParameterValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, oldParameterValue, newParameterValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterValue(ParameterValue newParameterValue) {
        if (newParameterValue != parameterValue) {
            NotificationChain msgs = null;
            if (parameterValue != null)
                msgs = ((InternalEObject)parameterValue).eInverseRemove(this, ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, ParameterValue.class, msgs);
            if (newParameterValue != null)
                msgs = ((InternalEObject)newParameterValue).eInverseAdd(this, ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, ParameterValue.class, msgs);
            msgs = basicSetParameterValue(newParameterValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, newParameterValue, newParameterValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                if (parameterReference != null)
                    msgs = ((InternalEObject)parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, null, msgs);
                return basicSetParameterReference((ParameterReference)otherEnd, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)otherEnd, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRequiredElementDeviation((RequiredElementDeviation)otherEnd, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                if (parameterValue != null)
                    msgs = ((InternalEObject)parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, null, msgs);
                return basicSetParameterValue((ParameterValue)otherEnd, msgs);
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                return basicSetParameterReference(null, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                return basicSetRequiredElementDeviation(null, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                return basicSetParameterValue(null, msgs);
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS, InternalStateInfluenceAnalysisAggregation.class, msgs);
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES, RequiredElementDeviation.class, msgs);
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                return getParameterReference();
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return getInternalStateInfluenceAnalysisAggregation();
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                return getRequiredElementDeviation();
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                return getParameterValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                setParameterReference((ParameterReference)newValue);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)newValue);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                setRequiredElementDeviation((RequiredElementDeviation)newValue);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                setParameterValue((ParameterValue)newValue);
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                setParameterReference((ParameterReference)null);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)null);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                setRequiredElementDeviation((RequiredElementDeviation)null);
                return;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                setParameterValue((ParameterValue)null);
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
                return parameterReference != null;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return getInternalStateInfluenceAnalysisAggregation() != null;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
                return getRequiredElementDeviation() != null;
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
                return parameterValue != null;
        }
        return super.eIsSet(featureID);
    }

} //ParameterValueDeviationImpl
