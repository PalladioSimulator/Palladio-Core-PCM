/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.CallParameterDeviation;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Parameter Deviation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CallParameterDeviationImpl#getParameterReference <em>Parameter Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CallParameterDeviationImpl#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CallParameterDeviationImpl#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallParameterDeviationImpl extends EObjectImpl implements CallParameterDeviation {
	/**
	 * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterReference()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterReference> parameterReference;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallParameterDeviationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.CALL_PARAMETER_DEVIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterReference> getParameterReference() {
		if (parameterReference == null) {
			parameterReference = new EObjectContainmentWithInverseEList<ParameterReference>(ParameterReference.class, this, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE, ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION);
		}
		return parameterReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
		if (eContainerFeatureID() != QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION) return null;
		return (InternalStateInfluenceAnalysisAggregation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInternalStateInfluenceAnalysisAggregation, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
		if (newInternalStateInfluenceAnalysisAggregation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION && newInternalStateInfluenceAnalysisAggregation != null)) {
			if (EcoreUtil.isAncestor(this, newInternalStateInfluenceAnalysisAggregation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInternalStateInfluenceAnalysisAggregation != null)
				msgs = ((InternalEObject)newInternalStateInfluenceAnalysisAggregation).eInverseAdd(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION, InternalStateInfluenceAnalysisAggregation.class, msgs);
			msgs = basicSetInternalStateInfluenceAnalysisAggregation(newInternalStateInfluenceAnalysisAggregation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION, newInternalStateInfluenceAnalysisAggregation, newInternalStateInfluenceAnalysisAggregation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__MAXIMUM, oldMaximum, maximum));
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterReference()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)otherEnd, msgs);
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				return ((InternalEList<?>)getParameterReference()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION, InternalStateInfluenceAnalysisAggregation.class, msgs);
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				return getParameterReference();
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return getInternalStateInfluenceAnalysisAggregation();
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__MAXIMUM:
				return getMaximum();
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				getParameterReference().clear();
				getParameterReference().addAll((Collection<? extends ParameterReference>)newValue);
				return;
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)newValue);
				return;
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__MAXIMUM:
				setMaximum((Double)newValue);
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				getParameterReference().clear();
				return;
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)null);
				return;
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE:
				return parameterReference != null && !parameterReference.isEmpty();
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return getInternalStateInfluenceAnalysisAggregation() != null;
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__MAXIMUM:
				return maximum != MAXIMUM_EDEFAULT;
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

} //CallParameterDeviationImpl
