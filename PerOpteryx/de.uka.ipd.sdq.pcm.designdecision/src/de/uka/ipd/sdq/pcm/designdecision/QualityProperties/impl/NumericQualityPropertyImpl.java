/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl;

import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.ConfidenceInterval;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.NumericQualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Quality Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.NumericQualityPropertyImpl#getResultDecoratorRepository <em>Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.NumericQualityPropertyImpl#getConfidenceInterval <em>Confidence Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NumericQualityPropertyImpl extends QualityPropertyImpl implements NumericQualityProperty {
	/**
	 * The cached value of the '{@link #getResultDecoratorRepository() <em>Result Decorator Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultDecoratorRepository()
	 * @generated
	 * @ordered
	 */
	protected ResultDecoratorRepository resultDecoratorRepository;

	/**
	 * The cached value of the '{@link #getConfidenceInterval() <em>Confidence Interval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidenceInterval()
	 * @generated
	 * @ordered
	 */
	protected ConfidenceInterval confidenceInterval;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericQualityPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityPropertiesPackage.Literals.NUMERIC_QUALITY_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDecoratorRepository getResultDecoratorRepository() {
		if (resultDecoratorRepository != null && resultDecoratorRepository.eIsProxy()) {
			InternalEObject oldResultDecoratorRepository = (InternalEObject)resultDecoratorRepository;
			resultDecoratorRepository = (ResultDecoratorRepository)eResolveProxy(oldResultDecoratorRepository);
			if (resultDecoratorRepository != oldResultDecoratorRepository) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY, oldResultDecoratorRepository, resultDecoratorRepository));
			}
		}
		return resultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDecoratorRepository basicGetResultDecoratorRepository() {
		return resultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultDecoratorRepository(ResultDecoratorRepository newResultDecoratorRepository) {
		ResultDecoratorRepository oldResultDecoratorRepository = resultDecoratorRepository;
		resultDecoratorRepository = newResultDecoratorRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY, oldResultDecoratorRepository, resultDecoratorRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidenceInterval getConfidenceInterval() {
		if (confidenceInterval != null && confidenceInterval.eIsProxy()) {
			InternalEObject oldConfidenceInterval = (InternalEObject)confidenceInterval;
			confidenceInterval = (ConfidenceInterval)eResolveProxy(oldConfidenceInterval);
			if (confidenceInterval != oldConfidenceInterval) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL, oldConfidenceInterval, confidenceInterval));
			}
		}
		return confidenceInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidenceInterval basicGetConfidenceInterval() {
		return confidenceInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidenceInterval(ConfidenceInterval newConfidenceInterval) {
		ConfidenceInterval oldConfidenceInterval = confidenceInterval;
		confidenceInterval = newConfidenceInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL, oldConfidenceInterval, confidenceInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY:
				if (resolve) return getResultDecoratorRepository();
				return basicGetResultDecoratorRepository();
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL:
				if (resolve) return getConfidenceInterval();
				return basicGetConfidenceInterval();
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
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY:
				setResultDecoratorRepository((ResultDecoratorRepository)newValue);
				return;
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL:
				setConfidenceInterval((ConfidenceInterval)newValue);
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
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY:
				setResultDecoratorRepository((ResultDecoratorRepository)null);
				return;
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL:
				setConfidenceInterval((ConfidenceInterval)null);
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
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__RESULT_DECORATOR_REPOSITORY:
				return resultDecoratorRepository != null;
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY__CONFIDENCE_INTERVAL:
				return confidenceInterval != null;
		}
		return super.eIsSet(featureID);
	}

} //NumericQualityPropertyImpl
