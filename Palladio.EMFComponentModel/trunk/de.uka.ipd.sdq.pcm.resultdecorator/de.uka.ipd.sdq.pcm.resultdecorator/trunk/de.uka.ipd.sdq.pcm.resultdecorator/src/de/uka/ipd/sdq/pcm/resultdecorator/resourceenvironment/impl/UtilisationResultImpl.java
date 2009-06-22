/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.UtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Utilisation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl.UtilisationResultImpl#getNormalisedResourceUtilisation <em>Normalised Resource Utilisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl.UtilisationResultImpl#getNormalisedDemandedTime <em>Normalised Demanded Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl.UtilisationResultImpl#getNormalisedWaitTime <em>Normalised Wait Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UtilisationResultImpl extends EObjectImpl implements UtilisationResult {
	/**
	 * The default value of the '{@link #getNormalisedResourceUtilisation() <em>Normalised Resource Utilisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResourceUtilisation()
	 * @generated
	 * @ordered
	 */
	protected static final double NORMALISED_RESOURCE_UTILISATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNormalisedResourceUtilisation() <em>Normalised Resource Utilisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResourceUtilisation()
	 * @generated
	 * @ordered
	 */
	protected double normalisedResourceUtilisation = NORMALISED_RESOURCE_UTILISATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalisedDemandedTime() <em>Normalised Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected static final double NORMALISED_DEMANDED_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNormalisedDemandedTime() <em>Normalised Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected double normalisedDemandedTime = NORMALISED_DEMANDED_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalisedWaitTime() <em>Normalised Wait Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedWaitTime()
	 * @generated
	 * @ordered
	 */
	protected static final double NORMALISED_WAIT_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNormalisedWaitTime() <em>Normalised Wait Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedWaitTime()
	 * @generated
	 * @ordered
	 */
	protected double normalisedWaitTime = NORMALISED_WAIT_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UtilisationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return resourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNormalisedResourceUtilisation() {
		return normalisedResourceUtilisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalisedResourceUtilisation(double newNormalisedResourceUtilisation) {
		double oldNormalisedResourceUtilisation = normalisedResourceUtilisation;
		normalisedResourceUtilisation = newNormalisedResourceUtilisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION, oldNormalisedResourceUtilisation, normalisedResourceUtilisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNormalisedDemandedTime() {
		return normalisedDemandedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalisedDemandedTime(double newNormalisedDemandedTime) {
		double oldNormalisedDemandedTime = normalisedDemandedTime;
		normalisedDemandedTime = newNormalisedDemandedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_DEMANDED_TIME, oldNormalisedDemandedTime, normalisedDemandedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNormalisedWaitTime() {
		return normalisedWaitTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalisedWaitTime(double newNormalisedWaitTime) {
		double oldNormalisedWaitTime = normalisedWaitTime;
		normalisedWaitTime = newNormalisedWaitTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME, oldNormalisedWaitTime, normalisedWaitTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				return new Double(getNormalisedResourceUtilisation());
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				return new Double(getNormalisedDemandedTime());
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				return new Double(getNormalisedWaitTime());
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
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				setNormalisedResourceUtilisation(((Double)newValue).doubleValue());
				return;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				setNormalisedDemandedTime(((Double)newValue).doubleValue());
				return;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				setNormalisedWaitTime(((Double)newValue).doubleValue());
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
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				setNormalisedResourceUtilisation(NORMALISED_RESOURCE_UTILISATION_EDEFAULT);
				return;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				setNormalisedDemandedTime(NORMALISED_DEMANDED_TIME_EDEFAULT);
				return;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				setNormalisedWaitTime(NORMALISED_WAIT_TIME_EDEFAULT);
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
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				return normalisedResourceUtilisation != NORMALISED_RESOURCE_UTILISATION_EDEFAULT;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				return normalisedDemandedTime != NORMALISED_DEMANDED_TIME_EDEFAULT;
			case resourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				return normalisedWaitTime != NORMALISED_WAIT_TIME_EDEFAULT;
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
		result.append(" (normalisedResourceUtilisation: ");
		result.append(normalisedResourceUtilisation);
		result.append(", normalisedDemandedTime: ");
		result.append(normalisedDemandedTime);
		result.append(", normalisedWaitTime: ");
		result.append(normalisedWaitTime);
		result.append(')');
		return result.toString();
	}

} //UtilisationResultImpl
