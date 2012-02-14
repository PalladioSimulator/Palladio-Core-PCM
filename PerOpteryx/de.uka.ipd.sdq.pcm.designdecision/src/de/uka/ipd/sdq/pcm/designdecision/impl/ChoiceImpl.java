/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#isActive <em>Is Active</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#getDegreeOfFreedomInstance <em>Degree Of Freedom Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceImpl extends EObjectImpl implements Choice {
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
	 * The cached value of the '{@link #getDegreeOfFreedomInstance() <em>Degree Of Freedom Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegreeOfFreedomInstance()
	 * @generated
	 * @ordered
	 */
	protected DegreeOfFreedomInstance degreeOfFreedomInstance;
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
	public DegreeOfFreedomInstance getDegreeOfFreedomInstance() {
		if (degreeOfFreedomInstance != null && degreeOfFreedomInstance.eIsProxy()) {
			InternalEObject oldDegreeOfFreedomInstance = (InternalEObject)degreeOfFreedomInstance;
			degreeOfFreedomInstance = (DegreeOfFreedomInstance)eResolveProxy(oldDegreeOfFreedomInstance);
			if (degreeOfFreedomInstance != oldDegreeOfFreedomInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE, oldDegreeOfFreedomInstance, degreeOfFreedomInstance));
			}
		}
		return degreeOfFreedomInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedomInstance basicGetDegreeOfFreedomInstance() {
		return degreeOfFreedomInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegreeOfFreedomInstance(DegreeOfFreedomInstance newDegreeOfFreedomInstance) {
		DegreeOfFreedomInstance oldDegreeOfFreedomInstance = degreeOfFreedomInstance;
		degreeOfFreedomInstance = newDegreeOfFreedomInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE, oldDegreeOfFreedomInstance, degreeOfFreedomInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				return isActive();
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE:
				if (resolve) return getDegreeOfFreedomInstance();
				return basicGetDegreeOfFreedomInstance();
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
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE:
				setDegreeOfFreedomInstance((DegreeOfFreedomInstance)newValue);
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
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE:
				setDegreeOfFreedomInstance((DegreeOfFreedomInstance)null);
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
			case designdecisionPackage.CHOICE__IS_ACTIVE:
				return isActive != IS_ACTIVE_EDEFAULT;
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM_INSTANCE:
				return degreeOfFreedomInstance != null;
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
