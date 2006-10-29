
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Demanding SEFF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getSeffTypeID <em>Seff Type ID</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getDescribedService__SEFF <em>Described Service SEFF</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandingSEFFImpl extends ResourceDemandingBehaviourImpl implements ResourceDemandingSEFF {
	/**
	 * The default value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeffTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final String SEFF_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeffTypeID()
	 * @generated
	 * @ordered
	 */
	protected String seffTypeID = SEFF_TYPE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescribedService__SEFF() <em>Described Service SEFF</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribedService__SEFF()
	 * @generated
	 * @ordered
	 */
	protected Signature describedService__SEFF = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandingSEFFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RESOURCE_DEMANDING_SEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeffTypeID() {
		return seffTypeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeffTypeID(String newSeffTypeID) {
		String oldSeffTypeID = seffTypeID;
		seffTypeID = newSeffTypeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID, oldSeffTypeID, seffTypeID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getDescribedService__SEFF() {
		if (describedService__SEFF != null && describedService__SEFF.eIsProxy()) {
			InternalEObject oldDescribedService__SEFF = (InternalEObject)describedService__SEFF;
			describedService__SEFF = (Signature)eResolveProxy(oldDescribedService__SEFF);
			if (describedService__SEFF != oldDescribedService__SEFF) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF, oldDescribedService__SEFF, describedService__SEFF));
			}
		}
		return describedService__SEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetDescribedService__SEFF() {
		return describedService__SEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescribedService__SEFF(Signature newDescribedService__SEFF) {
		Signature oldDescribedService__SEFF = describedService__SEFF;
		describedService__SEFF = newDescribedService__SEFF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF, oldDescribedService__SEFF, describedService__SEFF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
				return getSeffTypeID();
			case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
				if (resolve) return getDescribedService__SEFF();
				return basicGetDescribedService__SEFF();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
				setSeffTypeID((String)newValue);
				return;
			case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
				setDescribedService__SEFF((Signature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
				setSeffTypeID(SEFF_TYPE_ID_EDEFAULT);
				return;
			case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
				setDescribedService__SEFF((Signature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
				return SEFF_TYPE_ID_EDEFAULT == null ? seffTypeID != null : !SEFF_TYPE_ID_EDEFAULT.equals(seffTypeID);
			case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
				return describedService__SEFF != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ServiceEffectSpecification.class) {
			switch (derivedFeatureID) {
				case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID: return SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID;
				case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF: return SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == ServiceEffectSpecification.class) {
			switch (baseFeatureID) {
				case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID: return SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID;
				case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF: return SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (seffTypeID: ");
		result.append(seffTypeID);
		result.append(')');
		return result.toString();
	}

} //ResourceDemandingSEFFImpl