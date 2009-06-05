/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.Preference;
import de.uka.ipd.sdq.capra.schedulers.Priority;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl#isHasDynamicPriority <em>Has Dynamic Priority</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl#getPreference <em>Preference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityImpl extends SelectionPolicyImpl implements Priority {
	/**
	 * The default value of the '{@link #isHasDynamicPriority() <em>Has Dynamic Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDynamicPriority()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_DYNAMIC_PRIORITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasDynamicPriority() <em>Has Dynamic Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDynamicPriority()
	 * @generated
	 * @ordered
	 */
	protected boolean hasDynamicPriority = HAS_DYNAMIC_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreference() <em>Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreference()
	 * @generated
	 * @ordered
	 */
	protected static final Preference PREFERENCE_EDEFAULT = Preference.HARD;

	/**
	 * The cached value of the '{@link #getPreference() <em>Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreference()
	 * @generated
	 * @ordered
	 */
	protected Preference preference = PREFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriorityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulersPackage.Literals.PRIORITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasDynamicPriority() {
		return hasDynamicPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasDynamicPriority(boolean newHasDynamicPriority) {
		boolean oldHasDynamicPriority = hasDynamicPriority;
		hasDynamicPriority = newHasDynamicPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PRIORITY__HAS_DYNAMIC_PRIORITY, oldHasDynamicPriority, hasDynamicPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preference getPreference() {
		return preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreference(Preference newPreference) {
		Preference oldPreference = preference;
		preference = newPreference == null ? PREFERENCE_EDEFAULT : newPreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PRIORITY__PREFERENCE, oldPreference, preference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulersPackage.PRIORITY__HAS_DYNAMIC_PRIORITY:
				return isHasDynamicPriority() ? Boolean.TRUE : Boolean.FALSE;
			case SchedulersPackage.PRIORITY__PREFERENCE:
				return getPreference();
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
			case SchedulersPackage.PRIORITY__HAS_DYNAMIC_PRIORITY:
				setHasDynamicPriority(((Boolean)newValue).booleanValue());
				return;
			case SchedulersPackage.PRIORITY__PREFERENCE:
				setPreference((Preference)newValue);
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
			case SchedulersPackage.PRIORITY__HAS_DYNAMIC_PRIORITY:
				setHasDynamicPriority(HAS_DYNAMIC_PRIORITY_EDEFAULT);
				return;
			case SchedulersPackage.PRIORITY__PREFERENCE:
				setPreference(PREFERENCE_EDEFAULT);
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
			case SchedulersPackage.PRIORITY__HAS_DYNAMIC_PRIORITY:
				return hasDynamicPriority != HAS_DYNAMIC_PRIORITY_EDEFAULT;
			case SchedulersPackage.PRIORITY__PREFERENCE:
				return preference != PREFERENCE_EDEFAULT;
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
		result.append(" (hasDynamicPriority: ");
		result.append(hasDynamicPriority);
		result.append(", preference: ");
		result.append(preference);
		result.append(')');
		return result.toString();
	}

} //PriorityImpl
