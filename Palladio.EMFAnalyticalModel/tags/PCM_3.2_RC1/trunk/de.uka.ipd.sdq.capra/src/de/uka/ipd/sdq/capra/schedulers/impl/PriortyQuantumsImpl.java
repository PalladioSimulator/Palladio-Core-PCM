/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.PriortyQuantums;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priorty Quantums</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl#getNumberOfQuantums <em>Number Of Quantums</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriortyQuantumsImpl extends EObjectImpl implements PriortyQuantums {
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfQuantums() <em>Number Of Quantums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfQuantums()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_QUANTUMS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfQuantums() <em>Number Of Quantums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfQuantums()
	 * @generated
	 * @ordered
	 */
	protected int numberOfQuantums = NUMBER_OF_QUANTUMS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriortyQuantumsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulersPackage.Literals.PRIORTY_QUANTUMS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfQuantums() {
		return numberOfQuantums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfQuantums(int newNumberOfQuantums) {
		int oldNumberOfQuantums = numberOfQuantums;
		numberOfQuantums = newNumberOfQuantums;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS, oldNumberOfQuantums, numberOfQuantums));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY:
				return new Integer(getPriority());
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				return new Integer(getNumberOfQuantums());
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
			case SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY:
				setPriority(((Integer)newValue).intValue());
				return;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				setNumberOfQuantums(((Integer)newValue).intValue());
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
			case SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				setNumberOfQuantums(NUMBER_OF_QUANTUMS_EDEFAULT);
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
			case SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				return numberOfQuantums != NUMBER_OF_QUANTUMS_EDEFAULT;
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", numberOfQuantums: ");
		result.append(numberOfQuantums);
		result.append(')');
		return result.toString();
	}

} //PriortyQuantumsImpl
