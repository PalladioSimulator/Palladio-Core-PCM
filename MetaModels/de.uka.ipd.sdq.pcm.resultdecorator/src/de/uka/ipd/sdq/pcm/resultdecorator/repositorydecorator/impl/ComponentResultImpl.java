/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getNormalisedResponseTime <em>Normalised Response Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentResultImpl extends NamedElementImpl implements ComponentResult {
	/**
	 * The default value of the '{@link #getNormalisedResourceDemand() <em>Normalised Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected static final double NORMALISED_RESOURCE_DEMAND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNormalisedResourceDemand() <em>Normalised Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected double normalisedResourceDemand = NORMALISED_RESOURCE_DEMAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalisedResponseTime() <em>Normalised Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResponseTime()
	 * @generated
	 * @ordered
	 */
	protected static final double NORMALISED_RESPONSE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNormalisedResponseTime() <em>Normalised Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalisedResponseTime()
	 * @generated
	 * @ordered
	 */
	protected double normalisedResponseTime = NORMALISED_RESPONSE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositorydecoratorPackage.Literals.COMPONENT_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNormalisedResourceDemand() {
		return normalisedResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalisedResourceDemand(double newNormalisedResourceDemand) {
		double oldNormalisedResourceDemand = normalisedResourceDemand;
		normalisedResourceDemand = newNormalisedResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND, oldNormalisedResourceDemand, normalisedResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNormalisedResponseTime() {
		return normalisedResponseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalisedResponseTime(double newNormalisedResponseTime) {
		double oldNormalisedResponseTime = normalisedResponseTime;
		normalisedResponseTime = newNormalisedResponseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME, oldNormalisedResponseTime, normalisedResponseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
				return new Double(getNormalisedResourceDemand());
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				return new Double(getNormalisedResponseTime());
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
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
				setNormalisedResourceDemand(((Double)newValue).doubleValue());
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				setNormalisedResponseTime(((Double)newValue).doubleValue());
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
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
				setNormalisedResourceDemand(NORMALISED_RESOURCE_DEMAND_EDEFAULT);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				setNormalisedResponseTime(NORMALISED_RESPONSE_TIME_EDEFAULT);
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
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
				return normalisedResourceDemand != NORMALISED_RESOURCE_DEMAND_EDEFAULT;
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				return normalisedResponseTime != NORMALISED_RESPONSE_TIME_EDEFAULT;
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
		result.append(" (normalisedResourceDemand: ");
		result.append(normalisedResourceDemand);
		result.append(", normalisedResponseTime: ");
		result.append(normalisedResponseTime);
		result.append(')');
		return result.toString();
	}

} //ComponentResultImpl
