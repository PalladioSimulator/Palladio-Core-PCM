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
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getAverageResourceDemand <em>Average Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getMeanResponseTime <em>Mean Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getAverageNumberOfSentMessages <em>Average Number Of Sent Messages</em>}</li>
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
	 * The default value of the '{@link #getAverageResourceDemand() <em>Average Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_RESOURCE_DEMAND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageResourceDemand() <em>Average Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected double averageResourceDemand = AVERAGE_RESOURCE_DEMAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeanResponseTime() <em>Mean Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanResponseTime()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_RESPONSE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMeanResponseTime() <em>Mean Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanResponseTime()
	 * @generated
	 * @ordered
	 */
	protected double meanResponseTime = MEAN_RESPONSE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverageNumberOfSentMessages() <em>Average Number Of Sent Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageNumberOfSentMessages()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageNumberOfSentMessages() <em>Average Number Of Sent Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageNumberOfSentMessages()
	 * @generated
	 * @ordered
	 */
	protected double averageNumberOfSentMessages = AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT;

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
	public double getAverageResourceDemand() {
		return averageResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageResourceDemand(double newAverageResourceDemand) {
		double oldAverageResourceDemand = averageResourceDemand;
		averageResourceDemand = newAverageResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND, oldAverageResourceDemand, averageResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeanResponseTime() {
		return meanResponseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanResponseTime(double newMeanResponseTime) {
		double oldMeanResponseTime = meanResponseTime;
		meanResponseTime = newMeanResponseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME, oldMeanResponseTime, meanResponseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageNumberOfSentMessages() {
		return averageNumberOfSentMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageNumberOfSentMessages(double newAverageNumberOfSentMessages) {
		double oldAverageNumberOfSentMessages = averageNumberOfSentMessages;
		averageNumberOfSentMessages = newAverageNumberOfSentMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES, oldAverageNumberOfSentMessages, averageNumberOfSentMessages));
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
				return getNormalisedResourceDemand();
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				return getNormalisedResponseTime();
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
				return getAverageResourceDemand();
			case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
				return getMeanResponseTime();
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
				return getAverageNumberOfSentMessages();
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
				setNormalisedResourceDemand((Double)newValue);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
				setNormalisedResponseTime((Double)newValue);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
				setAverageResourceDemand((Double)newValue);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
				setMeanResponseTime((Double)newValue);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
				setAverageNumberOfSentMessages((Double)newValue);
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
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
				setAverageResourceDemand(AVERAGE_RESOURCE_DEMAND_EDEFAULT);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
				setMeanResponseTime(MEAN_RESPONSE_TIME_EDEFAULT);
				return;
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
				setAverageNumberOfSentMessages(AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT);
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
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
				return averageResourceDemand != AVERAGE_RESOURCE_DEMAND_EDEFAULT;
			case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
				return meanResponseTime != MEAN_RESPONSE_TIME_EDEFAULT;
			case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
				return averageNumberOfSentMessages != AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT;
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
		result.append(", averageResourceDemand: ");
		result.append(averageResourceDemand);
		result.append(", meanResponseTime: ");
		result.append(meanResponseTime);
		result.append(", averageNumberOfSentMessages: ");
		result.append(averageNumberOfSentMessages);
		result.append(')');
		return result.toString();
	}

} //ComponentResultImpl
