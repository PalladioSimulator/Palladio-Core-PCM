/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.CallParameterDeviation;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal State Influence Analysis Aggregation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getQualityAnnotation <em>Quality Annotation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getCallParameterDeviation <em>Call Parameter Deviation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.InternalStateInfluenceAnalysisAggregationImpl#getNumberOfCallsDeviation <em>Number Of Calls Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalStateInfluenceAnalysisAggregationImpl extends IdentifierImpl implements InternalStateInfluenceAnalysisAggregation {
	/**
	 * The cached value of the '{@link #getCallParameterDeviation() <em>Call Parameter Deviation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallParameterDeviation()
	 * @generated
	 * @ordered
	 */
	protected EList<CallParameterDeviation> callParameterDeviation;

	/**
	 * The cached value of the '{@link #getNumberOfCallsDeviation() <em>Number Of Calls Deviation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfCallsDeviation()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberOfCallsDeviation> numberOfCallsDeviation;

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
		return (QualityAnnotation)eContainer();
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
				msgs = ((InternalEObject)newQualityAnnotation).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT, QualityAnnotation.class, msgs);
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
	public EList<CallParameterDeviation> getCallParameterDeviation() {
		if (callParameterDeviation == null) {
			callParameterDeviation = new EObjectContainmentWithInverseEList<CallParameterDeviation>(CallParameterDeviation.class, this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
		}
		return callParameterDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberOfCallsDeviation> getNumberOfCallsDeviation() {
		if (numberOfCallsDeviation == null) {
			numberOfCallsDeviation = new EObjectContainmentWithInverseEList<NumberOfCallsDeviation>(NumberOfCallsDeviation.class, this, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION, QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
		}
		return numberOfCallsDeviation;
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCallParameterDeviation()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNumberOfCallsDeviation()).basicAdd(otherEnd, msgs);
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				return ((InternalEList<?>)getCallParameterDeviation()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				return ((InternalEList<?>)getNumberOfCallsDeviation()).basicRemove(otherEnd, msgs);
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
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT, QualityAnnotation.class, msgs);
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				return getCallParameterDeviation();
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				return getNumberOfCallsDeviation();
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				getCallParameterDeviation().clear();
				getCallParameterDeviation().addAll((Collection<? extends CallParameterDeviation>)newValue);
				return;
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				getNumberOfCallsDeviation().clear();
				getNumberOfCallsDeviation().addAll((Collection<? extends NumberOfCallsDeviation>)newValue);
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				getCallParameterDeviation().clear();
				return;
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				getNumberOfCallsDeviation().clear();
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
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION:
				return callParameterDeviation != null && !callParameterDeviation.isEmpty();
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION:
				return numberOfCallsDeviation != null && !numberOfCallsDeviation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InternalStateInfluenceAnalysisAggregationImpl
