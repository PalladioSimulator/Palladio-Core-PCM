/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getMeanResponseTime <em>Mean Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getThroughput <em>Throughput</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getServiceEffectSpecification_ServiceResult <em>Service Effect Specification Service Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceResultImpl extends EObjectImpl implements ServiceResult {
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
	 * The default value of the '{@link #getThroughput() <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThroughput()
	 * @generated
	 * @ordered
	 */
	protected static final double THROUGHPUT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getThroughput() <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThroughput()
	 * @generated
	 * @ordered
	 */
	protected double throughput = THROUGHPUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServiceEffectSpecification_ServiceResult() <em>Service Effect Specification Service Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEffectSpecification_ServiceResult()
	 * @generated
	 * @ordered
	 */
	protected ServiceEffectSpecification serviceEffectSpecification_ServiceResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositorydecoratorPackage.Literals.SERVICE_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME, oldMeanResponseTime, meanResponseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThroughput() {
		return throughput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThroughput(double newThroughput) {
		double oldThroughput = throughput;
		throughput = newThroughput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT, oldThroughput, throughput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification getServiceEffectSpecification_ServiceResult() {
		if (serviceEffectSpecification_ServiceResult != null && serviceEffectSpecification_ServiceResult.eIsProxy()) {
			InternalEObject oldServiceEffectSpecification_ServiceResult = (InternalEObject)serviceEffectSpecification_ServiceResult;
			serviceEffectSpecification_ServiceResult = (ServiceEffectSpecification)eResolveProxy(oldServiceEffectSpecification_ServiceResult);
			if (serviceEffectSpecification_ServiceResult != oldServiceEffectSpecification_ServiceResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT, oldServiceEffectSpecification_ServiceResult, serviceEffectSpecification_ServiceResult));
			}
		}
		return serviceEffectSpecification_ServiceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification basicGetServiceEffectSpecification_ServiceResult() {
		return serviceEffectSpecification_ServiceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEffectSpecification_ServiceResult(ServiceEffectSpecification newServiceEffectSpecification_ServiceResult) {
		ServiceEffectSpecification oldServiceEffectSpecification_ServiceResult = serviceEffectSpecification_ServiceResult;
		serviceEffectSpecification_ServiceResult = newServiceEffectSpecification_ServiceResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT, oldServiceEffectSpecification_ServiceResult, serviceEffectSpecification_ServiceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
				return getMeanResponseTime();
			case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
				return getThroughput();
			case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
				if (resolve) return getServiceEffectSpecification_ServiceResult();
				return basicGetServiceEffectSpecification_ServiceResult();
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
			case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
				setMeanResponseTime((Double)newValue);
				return;
			case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
				setThroughput((Double)newValue);
				return;
			case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
				setServiceEffectSpecification_ServiceResult((ServiceEffectSpecification)newValue);
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
			case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
				setMeanResponseTime(MEAN_RESPONSE_TIME_EDEFAULT);
				return;
			case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
				setThroughput(THROUGHPUT_EDEFAULT);
				return;
			case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
				setServiceEffectSpecification_ServiceResult((ServiceEffectSpecification)null);
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
			case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
				return meanResponseTime != MEAN_RESPONSE_TIME_EDEFAULT;
			case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
				return throughput != THROUGHPUT_EDEFAULT;
			case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
				return serviceEffectSpecification_ServiceResult != null;
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
		result.append(" (meanResponseTime: ");
		result.append(meanResponseTime);
		result.append(", throughput: ");
		result.append(throughput);
		result.append(')');
		return result.toString();
	}

} //ServiceResultImpl
