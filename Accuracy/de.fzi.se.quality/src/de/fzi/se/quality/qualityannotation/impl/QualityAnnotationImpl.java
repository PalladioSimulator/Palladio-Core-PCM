/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.impl.QualityStatementImpl;

import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quality Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#isValid <em>Is Valid</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getForServiceSpecification <em>For Service Specification</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getStipulatedREPrecisions <em>Stipulated RE Precisions</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getInternalStateInfluenceAnalysisResult <em>Internal State Influence Analysis Result</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getValidForParameterPartitions <em>Valid For Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityAnnotationImpl extends QualityStatementImpl implements QualityAnnotation {
	/**
	 * The default value of the '{@link #isValid() <em>Is Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValid() <em>Is Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean isValid = IS_VALID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForServiceSpecification() <em>For Service Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForServiceSpecification()
	 * @generated
	 * @ordered
	 */
	protected ServiceSpecification forServiceSpecification;

	/**
	 * The cached value of the '{@link #getStipulatedREPrecisions() <em>Stipulated RE Precisions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStipulatedREPrecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredElement> stipulatedREPrecisions;

	/**
	 * The cached value of the '{@link #getInternalStateInfluenceAnalysisResult() <em>Internal State Influence Analysis Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalStateInfluenceAnalysisResult()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalStateInfluenceAnalysisAggregation> internalStateInfluenceAnalysisResult;

	/**
	 * The cached value of the '{@link #getValidForParameterPartitions() <em>Valid For Parameter Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidForParameterPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterPartition> validForParameterPartitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.QUALITY_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsValid(boolean newIsValid) {
		boolean oldIsValid = isValid;
		isValid = newIsValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID, oldIsValid, isValid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSpecification getForServiceSpecification() {
		return forServiceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForServiceSpecification(ServiceSpecification newForServiceSpecification, NotificationChain msgs) {
		ServiceSpecification oldForServiceSpecification = forServiceSpecification;
		forServiceSpecification = newForServiceSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, oldForServiceSpecification, newForServiceSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForServiceSpecification(ServiceSpecification newForServiceSpecification) {
		if (newForServiceSpecification != forServiceSpecification) {
			NotificationChain msgs = null;
			if (forServiceSpecification != null)
				msgs = ((InternalEObject)forServiceSpecification).eInverseRemove(this, QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, ServiceSpecification.class, msgs);
			if (newForServiceSpecification != null)
				msgs = ((InternalEObject)newForServiceSpecification).eInverseAdd(this, QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, ServiceSpecification.class, msgs);
			msgs = basicSetForServiceSpecification(newForServiceSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, newForServiceSpecification, newForServiceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredElement> getStipulatedREPrecisions() {
		if (stipulatedREPrecisions == null) {
			stipulatedREPrecisions = new EObjectContainmentWithInverseEList<RequiredElement>(RequiredElement.class, this, QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS, QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION);
		}
		return stipulatedREPrecisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisResult() {
		if (internalStateInfluenceAnalysisResult == null) {
			internalStateInfluenceAnalysisResult = new EObjectContainmentWithInverseEList<InternalStateInfluenceAnalysisAggregation>(InternalStateInfluenceAnalysisAggregation.class, this, QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT, QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION);
		}
		return internalStateInfluenceAnalysisResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterPartition> getValidForParameterPartitions() {
		if (validForParameterPartitions == null) {
			validForParameterPartitions = new EObjectContainmentWithInverseEList<ParameterPartition>(ParameterPartition.class, this, QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION);
		}
		return validForParameterPartitions;
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
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				if (forServiceSpecification != null)
					msgs = ((InternalEObject)forServiceSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, null, msgs);
				return basicSetForServiceSpecification((ServiceSpecification)otherEnd, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStipulatedREPrecisions()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInternalStateInfluenceAnalysisResult()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValidForParameterPartitions()).basicAdd(otherEnd, msgs);
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
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				return basicSetForServiceSpecification(null, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				return ((InternalEList<?>)getStipulatedREPrecisions()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				return ((InternalEList<?>)getInternalStateInfluenceAnalysisResult()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				return ((InternalEList<?>)getValidForParameterPartitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
				return isValid();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				return getForServiceSpecification();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				return getStipulatedREPrecisions();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				return getInternalStateInfluenceAnalysisResult();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				return getValidForParameterPartitions();
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
			case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
				setIsValid((Boolean)newValue);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				setForServiceSpecification((ServiceSpecification)newValue);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				getStipulatedREPrecisions().clear();
				getStipulatedREPrecisions().addAll((Collection<? extends RequiredElement>)newValue);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				getInternalStateInfluenceAnalysisResult().clear();
				getInternalStateInfluenceAnalysisResult().addAll((Collection<? extends InternalStateInfluenceAnalysisAggregation>)newValue);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				getValidForParameterPartitions().clear();
				getValidForParameterPartitions().addAll((Collection<? extends ParameterPartition>)newValue);
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
			case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
				setIsValid(IS_VALID_EDEFAULT);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				setForServiceSpecification((ServiceSpecification)null);
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				getStipulatedREPrecisions().clear();
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				getInternalStateInfluenceAnalysisResult().clear();
				return;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				getValidForParameterPartitions().clear();
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
			case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
				return isValid != IS_VALID_EDEFAULT;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
				return forServiceSpecification != null;
			case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
				return stipulatedREPrecisions != null && !stipulatedREPrecisions.isEmpty();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT:
				return internalStateInfluenceAnalysisResult != null && !internalStateInfluenceAnalysisResult.isEmpty();
			case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
				return validForParameterPartitions != null && !validForParameterPartitions.isEmpty();
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
		result.append(" (isValid: ");
		result.append(isValid);
		result.append(')');
		return result.toString();
	}

} //QualityAnnotationImpl
