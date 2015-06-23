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

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Utilisation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getNormalisedResourceUtilisation <em>Normalised Resource Utilisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getNormalisedWaitTime <em>Normalised Wait Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getResourceUtilisation <em>Resource Utilisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getAverageWaitTime <em>Average Wait Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getAverageQueueLength <em>Average Queue Length</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getMaxQueueLength <em>Max Queue Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UtilisationResultImpl extends NamedElementImpl implements UtilisationResult {
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
	 * The default value of the '{@link #getResourceUtilisation() <em>Resource Utilisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUtilisation()
	 * @generated
	 * @ordered
	 */
	protected static final double RESOURCE_UTILISATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getResourceUtilisation() <em>Resource Utilisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUtilisation()
	 * @generated
	 * @ordered
	 */
	protected double resourceUtilisation = RESOURCE_UTILISATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverageWaitTime() <em>Average Wait Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageWaitTime()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_WAIT_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageWaitTime() <em>Average Wait Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageWaitTime()
	 * @generated
	 * @ordered
	 */
	protected double averageWaitTime = AVERAGE_WAIT_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverageQueueLength() <em>Average Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageQueueLength()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_QUEUE_LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageQueueLength() <em>Average Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageQueueLength()
	 * @generated
	 * @ordered
	 */
	protected double averageQueueLength = AVERAGE_QUEUE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxQueueLength() <em>Max Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxQueueLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_QUEUE_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxQueueLength() <em>Max Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxQueueLength()
	 * @generated
	 * @ordered
	 */
	protected int maxQueueLength = MAX_QUEUE_LENGTH_EDEFAULT;

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
		return ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION, oldNormalisedResourceUtilisation, normalisedResourceUtilisation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME, oldNormalisedWaitTime, normalisedWaitTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResourceUtilisation() {
		return resourceUtilisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUtilisation(double newResourceUtilisation) {
		double oldResourceUtilisation = resourceUtilisation;
		resourceUtilisation = newResourceUtilisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION, oldResourceUtilisation, resourceUtilisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageWaitTime() {
		return averageWaitTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageWaitTime(double newAverageWaitTime) {
		double oldAverageWaitTime = averageWaitTime;
		averageWaitTime = newAverageWaitTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME, oldAverageWaitTime, averageWaitTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageQueueLength() {
		return averageQueueLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageQueueLength(double newAverageQueueLength) {
		double oldAverageQueueLength = averageQueueLength;
		averageQueueLength = newAverageQueueLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH, oldAverageQueueLength, averageQueueLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxQueueLength() {
		return maxQueueLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxQueueLength(int newMaxQueueLength) {
		int oldMaxQueueLength = maxQueueLength;
		maxQueueLength = newMaxQueueLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH, oldMaxQueueLength, maxQueueLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				return getNormalisedResourceUtilisation();
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				return getNormalisedWaitTime();
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
				return getResourceUtilisation();
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
				return getAverageWaitTime();
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
				return getAverageQueueLength();
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
				return getMaxQueueLength();
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
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				setNormalisedResourceUtilisation((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				setNormalisedWaitTime((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
				setResourceUtilisation((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
				setAverageWaitTime((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
				setAverageQueueLength((Double)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
				setMaxQueueLength((Integer)newValue);
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
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				setNormalisedResourceUtilisation(NORMALISED_RESOURCE_UTILISATION_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				setNormalisedWaitTime(NORMALISED_WAIT_TIME_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
				setResourceUtilisation(RESOURCE_UTILISATION_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
				setAverageWaitTime(AVERAGE_WAIT_TIME_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
				setAverageQueueLength(AVERAGE_QUEUE_LENGTH_EDEFAULT);
				return;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
				setMaxQueueLength(MAX_QUEUE_LENGTH_EDEFAULT);
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
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
				return normalisedResourceUtilisation != NORMALISED_RESOURCE_UTILISATION_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
				return normalisedWaitTime != NORMALISED_WAIT_TIME_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
				return resourceUtilisation != RESOURCE_UTILISATION_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
				return averageWaitTime != AVERAGE_WAIT_TIME_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
				return averageQueueLength != AVERAGE_QUEUE_LENGTH_EDEFAULT;
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
				return maxQueueLength != MAX_QUEUE_LENGTH_EDEFAULT;
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
		result.append(", normalisedWaitTime: ");
		result.append(normalisedWaitTime);
		result.append(", resourceUtilisation: ");
		result.append(resourceUtilisation);
		result.append(", averageWaitTime: ");
		result.append(averageWaitTime);
		result.append(", averageQueueLength: ");
		result.append(averageQueueLength);
		result.append(", maxQueueLength: ");
		result.append(maxQueueLength);
		result.append(')');
		return result.toString();
	}

} //UtilisationResultImpl
