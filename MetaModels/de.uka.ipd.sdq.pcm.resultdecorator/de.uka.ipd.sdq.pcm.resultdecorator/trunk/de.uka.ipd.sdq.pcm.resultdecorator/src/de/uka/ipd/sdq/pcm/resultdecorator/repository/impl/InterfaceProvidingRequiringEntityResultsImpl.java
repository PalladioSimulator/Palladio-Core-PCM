/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Providing Requiring Entity Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl#getNormalisedResponseTime <em>Normalised Response Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceProvidingRequiringEntityResultsImpl extends EObjectImpl implements InterfaceProvidingRequiringEntityResults {
	/**
	 * The cached value of the '{@link #getInterfaceprovidingrequiringentity() <em>Interfaceprovidingrequiringentity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceprovidingrequiringentity()
	 * @generated
	 * @ordered
	 */
	protected InterfaceProvidingRequiringEntity interfaceprovidingrequiringentity;

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
	protected InterfaceProvidingRequiringEntityResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return repositorydecoratorPackage.Literals.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntity getInterfaceprovidingrequiringentity() {
		if (interfaceprovidingrequiringentity != null && interfaceprovidingrequiringentity.eIsProxy()) {
			InternalEObject oldInterfaceprovidingrequiringentity = (InternalEObject)interfaceprovidingrequiringentity;
			interfaceprovidingrequiringentity = (InterfaceProvidingRequiringEntity)eResolveProxy(oldInterfaceprovidingrequiringentity);
			if (interfaceprovidingrequiringentity != oldInterfaceprovidingrequiringentity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY, oldInterfaceprovidingrequiringentity, interfaceprovidingrequiringentity));
			}
		}
		return interfaceprovidingrequiringentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntity basicGetInterfaceprovidingrequiringentity() {
		return interfaceprovidingrequiringentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceprovidingrequiringentity(InterfaceProvidingRequiringEntity newInterfaceprovidingrequiringentity) {
		InterfaceProvidingRequiringEntity oldInterfaceprovidingrequiringentity = interfaceprovidingrequiringentity;
		interfaceprovidingrequiringentity = newInterfaceprovidingrequiringentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY, oldInterfaceprovidingrequiringentity, interfaceprovidingrequiringentity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND, oldNormalisedResourceDemand, normalisedResourceDemand));
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
			eNotify(new ENotificationImpl(this, Notification.SET, repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME, oldNormalisedResponseTime, normalisedResponseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				if (resolve) return getInterfaceprovidingrequiringentity();
				return basicGetInterfaceprovidingrequiringentity();
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND:
				return new Double(getNormalisedResourceDemand());
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME:
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
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				setInterfaceprovidingrequiringentity((InterfaceProvidingRequiringEntity)newValue);
				return;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND:
				setNormalisedResourceDemand(((Double)newValue).doubleValue());
				return;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME:
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
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				setInterfaceprovidingrequiringentity((InterfaceProvidingRequiringEntity)null);
				return;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND:
				setNormalisedResourceDemand(NORMALISED_RESOURCE_DEMAND_EDEFAULT);
				return;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME:
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
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				return interfaceprovidingrequiringentity != null;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND:
				return normalisedResourceDemand != NORMALISED_RESOURCE_DEMAND_EDEFAULT;
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME:
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

} //InterfaceProvidingRequiringEntityResultsImpl
