/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#isActive <em>Is Active</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#getDegreeOfFreedom <em>Degree Of Freedom</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceImpl extends EObjectImpl implements Choice {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ACTIVE_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean isActive = IS_ACTIVE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDegreeOfFreedom() <em>Degree Of Freedom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegreeOfFreedom()
	 * @generated
	 * @ordered
	 */
	protected DegreeOfFreedom degreeOfFreedom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public abstract Object getValue(); /* {
		// TODO: implement this method to return the 'Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}*/

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsActive(boolean newIsActive) {
		boolean oldIsActive = isActive;
		isActive = newIsActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CHOICE__IS_ACTIVE, oldIsActive, isActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom getDegreeOfFreedom() {
		if (degreeOfFreedom != null && degreeOfFreedom.eIsProxy()) {
			InternalEObject oldDegreeOfFreedom = (InternalEObject)degreeOfFreedom;
			degreeOfFreedom = (DegreeOfFreedom)eResolveProxy(oldDegreeOfFreedom);
			if (degreeOfFreedom != oldDegreeOfFreedom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM, oldDegreeOfFreedom, degreeOfFreedom));
			}
		}
		return degreeOfFreedom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom basicGetDegreeOfFreedom() {
		return degreeOfFreedom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegreeOfFreedom(DegreeOfFreedom newDegreeOfFreedom) {
		DegreeOfFreedom oldDegreeOfFreedom = degreeOfFreedom;
		degreeOfFreedom = newDegreeOfFreedom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM, oldDegreeOfFreedom, degreeOfFreedom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CHOICE__VALUE:
				return getValue();
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				return isActive();
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				if (resolve) return getDegreeOfFreedom();
				return basicGetDegreeOfFreedom();
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
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				setDegreeOfFreedom((DegreeOfFreedom)newValue);
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
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				setDegreeOfFreedom((DegreeOfFreedom)null);
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
			case designdecisionPackage.CHOICE__VALUE:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				return isActive != IS_ACTIVE_EDEFAULT;
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				return degreeOfFreedom != null;
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
		result.append(" (isActive: ");
		result.append(isActive);
		result.append(')');
		return result.toString();
	}

} //ChoiceImpl
