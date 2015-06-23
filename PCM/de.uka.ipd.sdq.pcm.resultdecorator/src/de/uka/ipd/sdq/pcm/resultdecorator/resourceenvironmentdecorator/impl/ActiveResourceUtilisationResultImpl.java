/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Resource Utilisation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl#getNormalisedDemandedTime <em>Normalised Demanded Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl#getDemandedTime <em>Demanded Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActiveResourceUtilisationResultImpl extends UtilisationResultImpl implements ActiveResourceUtilisationResult {
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
	 * The default value of the '{@link #getDemandedTime() <em>Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected static final double DEMANDED_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDemandedTime() <em>Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected double demandedTime = DEMANDED_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActiveResourceUtilisationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentdecoratorPackage.Literals.ACTIVE_RESOURCE_UTILISATION_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME, oldNormalisedDemandedTime, normalisedDemandedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDemandedTime() {
		return demandedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDemandedTime(double newDemandedTime) {
		double oldDemandedTime = demandedTime;
		demandedTime = newDemandedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME, oldDemandedTime, demandedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				return getNormalisedDemandedTime();
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
				return getDemandedTime();
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
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				setNormalisedDemandedTime((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
				setDemandedTime((Double)newValue);
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
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				setNormalisedDemandedTime(NORMALISED_DEMANDED_TIME_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
				setDemandedTime(DEMANDED_TIME_EDEFAULT);
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
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
				return normalisedDemandedTime != NORMALISED_DEMANDED_TIME_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
				return demandedTime != DEMANDED_TIME_EDEFAULT;
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
		result.append(" (normalisedDemandedTime: ");
		result.append(normalisedDemandedTime);
		result.append(", demandedTime: ");
		result.append(demandedTime);
		result.append(')');
		return result.toString();
	}

} //ActiveResourceUtilisationResultImpl
