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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

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
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected EObject priority;

	/**
	 * The cached value of the '{@link #getNumberOfQuantums() <em>Number Of Quantums</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfQuantums()
	 * @generated
	 * @ordered
	 */
	protected EObject numberOfQuantums;

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
	public EObject getPriority() {
		if (priority != null && priority.eIsProxy()) {
			InternalEObject oldPriority = (InternalEObject)priority;
			priority = eResolveProxy(oldPriority);
			if (priority != oldPriority) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY, oldPriority, priority));
			}
		}
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(EObject newPriority) {
		EObject oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.PRIORTY_QUANTUMS__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getNumberOfQuantums() {
		if (numberOfQuantums != null && numberOfQuantums.eIsProxy()) {
			InternalEObject oldNumberOfQuantums = (InternalEObject)numberOfQuantums;
			numberOfQuantums = eResolveProxy(oldNumberOfQuantums);
			if (numberOfQuantums != oldNumberOfQuantums) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS, oldNumberOfQuantums, numberOfQuantums));
			}
		}
		return numberOfQuantums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetNumberOfQuantums() {
		return numberOfQuantums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfQuantums(EObject newNumberOfQuantums) {
		EObject oldNumberOfQuantums = numberOfQuantums;
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
				if (resolve) return getPriority();
				return basicGetPriority();
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				if (resolve) return getNumberOfQuantums();
				return basicGetNumberOfQuantums();
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
				setPriority((EObject)newValue);
				return;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				setNumberOfQuantums((EObject)newValue);
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
				setPriority((EObject)null);
				return;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				setNumberOfQuantums((EObject)null);
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
				return priority != null;
			case SchedulersPackage.PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS:
				return numberOfQuantums != null;
		}
		return super.eIsSet(featureID);
	}

} //PriortyQuantumsImpl
