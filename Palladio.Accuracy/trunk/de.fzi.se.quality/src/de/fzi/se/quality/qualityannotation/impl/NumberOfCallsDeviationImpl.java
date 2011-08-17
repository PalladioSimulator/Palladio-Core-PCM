/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Of Calls Deviation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.NumberOfCallsDeviationImpl#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.NumberOfCallsDeviationImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.NumberOfCallsDeviationImpl#getRequiredElement <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberOfCallsDeviationImpl extends EObjectImpl implements NumberOfCallsDeviation {
	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected double maximum = MAXIMUM_EDEFAULT;

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
	protected NumberOfCallsDeviationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.NUMBER_OF_CALLS_DEVIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
		if (eContainerFeatureID() != QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION) return null;
		return (InternalStateInfluenceAnalysisAggregation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInternalStateInfluenceAnalysisAggregation, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
		if (newInternalStateInfluenceAnalysisAggregation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION && newInternalStateInfluenceAnalysisAggregation != null)) {
			if (EcoreUtil.isAncestor(this, newInternalStateInfluenceAnalysisAggregation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInternalStateInfluenceAnalysisAggregation != null)
				msgs = ((InternalEObject)newInternalStateInfluenceAnalysisAggregation).eInverseAdd(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION, InternalStateInfluenceAnalysisAggregation.class, msgs);
			msgs = basicSetInternalStateInfluenceAnalysisAggregation(newInternalStateInfluenceAnalysisAggregation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, newInternalStateInfluenceAnalysisAggregation, newInternalStateInfluenceAnalysisAggregation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(double newMaximum) {
		double oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__MAXIMUM, oldMaximum, maximum));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT, oldRequiredElement, newRequiredElement);
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
				msgs = ((InternalEObject)requiredElement).eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT__NUMBER_OF_CALLS_DEVIATION, RequiredElement.class, msgs);
			if (newRequiredElement != null)
				msgs = ((InternalEObject)newRequiredElement).eInverseAdd(this, QualityAnnotationPackage.REQUIRED_ELEMENT__NUMBER_OF_CALLS_DEVIATION, RequiredElement.class, msgs);
			msgs = basicSetRequiredElement(newRequiredElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT, newRequiredElement, newRequiredElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)otherEnd, msgs);
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
				if (requiredElement != null)
					msgs = ((InternalEObject)requiredElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT, null, msgs);
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION, InternalStateInfluenceAnalysisAggregation.class, msgs);
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return getInternalStateInfluenceAnalysisAggregation();
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__MAXIMUM:
				return getMaximum();
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
				return getRequiredElement();
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)newValue);
				return;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__MAXIMUM:
				setMaximum((Double)newValue);
				return;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)null);
				return;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
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
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return getInternalStateInfluenceAnalysisAggregation() != null;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__MAXIMUM:
				return maximum != MAXIMUM_EDEFAULT;
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT:
				return requiredElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maximum: ");
		result.append(maximum);
		result.append(')');
		return result.toString();
	}

} //NumberOfCallsDeviationImpl
