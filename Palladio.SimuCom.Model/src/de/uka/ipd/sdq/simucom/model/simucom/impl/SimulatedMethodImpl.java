/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom.impl;

import de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect;
import de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulated Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedMethodImpl#getServiceEffect <em>Service Effect</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedMethodImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulatedMethodImpl extends EObjectImpl implements SimulatedMethod {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getServiceEffect() <em>Service Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEffect()
	 * @generated
	 * @ordered
	 */
	protected ServiceEffect serviceEffect = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulatedMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SimuComModelPackage.eINSTANCE.getSimulatedMethod();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffect getServiceEffect() {
		return serviceEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceEffect(ServiceEffect newServiceEffect, NotificationChain msgs) {
		ServiceEffect oldServiceEffect = serviceEffect;
		serviceEffect = newServiceEffect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT, oldServiceEffect, newServiceEffect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEffect(ServiceEffect newServiceEffect) {
		if (newServiceEffect != serviceEffect) {
			NotificationChain msgs = null;
			if (serviceEffect != null)
				msgs = ((InternalEObject)serviceEffect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT, null, msgs);
			if (newServiceEffect != null)
				msgs = ((InternalEObject)newServiceEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT, null, msgs);
			msgs = basicSetServiceEffect(newServiceEffect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT, newServiceEffect, newServiceEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimuComModelPackage.SIMULATED_METHOD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT:
					return basicSetServiceEffect(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT:
				return getServiceEffect();
			case SimuComModelPackage.SIMULATED_METHOD__NAME:
				return getName();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT:
				setServiceEffect((ServiceEffect)newValue);
				return;
			case SimuComModelPackage.SIMULATED_METHOD__NAME:
				setName((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT:
				setServiceEffect((ServiceEffect)null);
				return;
			case SimuComModelPackage.SIMULATED_METHOD__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SIMULATED_METHOD__SERVICE_EFFECT:
				return serviceEffect != null;
			case SimuComModelPackage.SIMULATED_METHOD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SimulatedMethodImpl
