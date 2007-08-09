/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.units.impl;

import de.uka.ipd.sdq.units.BaseUnit;
import de.uka.ipd.sdq.units.UnitLiteral;
import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.units.impl.UnitLiteralImpl#getBaseUnit <em>Base Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitLiteralImpl extends UnitImpl implements UnitLiteral {
	/**
	 * The cached value of the '{@link #getBaseUnit() <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUnit()
	 * @generated
	 * @ordered
	 */
	protected BaseUnit baseUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnitsPackage.Literals.UNIT_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseUnit getBaseUnit() {
		if (baseUnit != null && baseUnit.eIsProxy()) {
			InternalEObject oldBaseUnit = (InternalEObject)baseUnit;
			baseUnit = (BaseUnit)eResolveProxy(oldBaseUnit);
			if (baseUnit != oldBaseUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnitsPackage.UNIT_LITERAL__BASE_UNIT, oldBaseUnit, baseUnit));
			}
		}
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseUnit basicGetBaseUnit() {
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseUnit(BaseUnit newBaseUnit) {
		BaseUnit oldBaseUnit = baseUnit;
		baseUnit = newBaseUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnitsPackage.UNIT_LITERAL__BASE_UNIT, oldBaseUnit, baseUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnitsPackage.UNIT_LITERAL__BASE_UNIT:
				if (resolve) return getBaseUnit();
				return basicGetBaseUnit();
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
			case UnitsPackage.UNIT_LITERAL__BASE_UNIT:
				setBaseUnit((BaseUnit)newValue);
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
			case UnitsPackage.UNIT_LITERAL__BASE_UNIT:
				setBaseUnit((BaseUnit)null);
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
			case UnitsPackage.UNIT_LITERAL__BASE_UNIT:
				return baseUnit != null;
		}
		return super.eIsSet(featureID);
	}

} //UnitLiteralImpl
