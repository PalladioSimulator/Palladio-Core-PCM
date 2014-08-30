/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Element Deviation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getMaximumDeviationNumberOfCalls <em>Maximum Deviation Number Of Calls</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getMaximumDeviationCallParameterValues <em>Maximum Deviation Call Parameter Values</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementDeviationImpl#getRequiredElement <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredElementDeviationImpl extends EObjectImpl implements RequiredElementDeviation {
	/**
     * The cached value of the '{@link #getMaximumDeviationNumberOfCalls() <em>Maximum Deviation Number Of Calls</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMaximumDeviationNumberOfCalls()
     * @generated
     * @ordered
     */
	protected Precision maximumDeviationNumberOfCalls;

	/**
     * The cached value of the '{@link #getMaximumDeviationCallParameterValues() <em>Maximum Deviation Call Parameter Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMaximumDeviationCallParameterValues()
     * @generated
     * @ordered
     */
	protected EList<ParameterValueDeviation> maximumDeviationCallParameterValues;

	/**
     * The cached value of the '{@link #getRequiredElement() <em>Required Element</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRequiredElement()
     * @generated
     * @ordered
     */
	protected RequiredElement requiredElement;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RequiredElementDeviationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.REQUIRED_ELEMENT_DEVIATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
        if (eContainerFeatureID() != QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION) return null;
        return (InternalStateInfluenceAnalysisAggregation)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInternalStateInfluenceAnalysisAggregation, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
        if (newInternalStateInfluenceAnalysisAggregation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION && newInternalStateInfluenceAnalysisAggregation != null)) {
            if (EcoreUtil.isAncestor(this, newInternalStateInfluenceAnalysisAggregation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInternalStateInfluenceAnalysisAggregation != null)
                msgs = ((InternalEObject)newInternalStateInfluenceAnalysisAggregation).eInverseAdd(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS, InternalStateInfluenceAnalysisAggregation.class, msgs);
            msgs = basicSetInternalStateInfluenceAnalysisAggregation(newInternalStateInfluenceAnalysisAggregation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, newInternalStateInfluenceAnalysisAggregation, newInternalStateInfluenceAnalysisAggregation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Precision getMaximumDeviationNumberOfCalls() {
        if (maximumDeviationNumberOfCalls != null && maximumDeviationNumberOfCalls.eIsProxy()) {
            InternalEObject oldMaximumDeviationNumberOfCalls = (InternalEObject)maximumDeviationNumberOfCalls;
            maximumDeviationNumberOfCalls = (Precision)eResolveProxy(oldMaximumDeviationNumberOfCalls);
            if (maximumDeviationNumberOfCalls != oldMaximumDeviationNumberOfCalls) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS, oldMaximumDeviationNumberOfCalls, maximumDeviationNumberOfCalls));
            }
        }
        return maximumDeviationNumberOfCalls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Precision basicGetMaximumDeviationNumberOfCalls() {
        return maximumDeviationNumberOfCalls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMaximumDeviationNumberOfCalls(Precision newMaximumDeviationNumberOfCalls) {
        Precision oldMaximumDeviationNumberOfCalls = maximumDeviationNumberOfCalls;
        maximumDeviationNumberOfCalls = newMaximumDeviationNumberOfCalls;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS, oldMaximumDeviationNumberOfCalls, maximumDeviationNumberOfCalls));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ParameterValueDeviation> getMaximumDeviationCallParameterValues() {
        if (maximumDeviationCallParameterValues == null) {
            maximumDeviationCallParameterValues = new EObjectContainmentWithInverseEList<ParameterValueDeviation>(ParameterValueDeviation.class, this, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION);
        }
        return maximumDeviationCallParameterValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RequiredElement getRequiredElement() {
        return requiredElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRequiredElement(RequiredElement newRequiredElement, NotificationChain msgs) {
        RequiredElement oldRequiredElement = requiredElement;
        requiredElement = newRequiredElement;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, oldRequiredElement, newRequiredElement);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRequiredElement(RequiredElement newRequiredElement) {
        if (newRequiredElement != requiredElement) {
            NotificationChain msgs = null;
            if (requiredElement != null)
                msgs = ((InternalEObject)requiredElement).eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION, RequiredElement.class, msgs);
            if (newRequiredElement != null)
                msgs = ((InternalEObject)newRequiredElement).eInverseAdd(this, QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION, RequiredElement.class, msgs);
            msgs = basicSetRequiredElement(newRequiredElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, newRequiredElement, newRequiredElement));
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)otherEnd, msgs);
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMaximumDeviationCallParameterValues()).basicAdd(otherEnd, msgs);
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                if (requiredElement != null)
                    msgs = ((InternalEObject)requiredElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT, null, msgs);
                return basicSetRequiredElement((RequiredElement)otherEnd, msgs);
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                return ((InternalEList<?>)getMaximumDeviationCallParameterValues()).basicRemove(otherEnd, msgs);
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                return basicSetRequiredElement(null, msgs);
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS, InternalStateInfluenceAnalysisAggregation.class, msgs);
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return getInternalStateInfluenceAnalysisAggregation();
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
                if (resolve) return getMaximumDeviationNumberOfCalls();
                return basicGetMaximumDeviationNumberOfCalls();
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                return getMaximumDeviationCallParameterValues();
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                return getRequiredElement();
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)newValue);
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
                setMaximumDeviationNumberOfCalls((Precision)newValue);
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                getMaximumDeviationCallParameterValues().clear();
                getMaximumDeviationCallParameterValues().addAll((Collection<? extends ParameterValueDeviation>)newValue);
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                setRequiredElement((RequiredElement)newValue);
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)null);
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
                setMaximumDeviationNumberOfCalls((Precision)null);
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                getMaximumDeviationCallParameterValues().clear();
                return;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                setRequiredElement((RequiredElement)null);
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
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return getInternalStateInfluenceAnalysisAggregation() != null;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS:
                return maximumDeviationNumberOfCalls != null;
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES:
                return maximumDeviationCallParameterValues != null && !maximumDeviationCallParameterValues.isEmpty();
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT:
                return requiredElement != null;
        }
        return super.eIsSet(featureID);
    }

} //RequiredElementDeviationImpl
