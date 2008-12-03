/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.units.impl;

import de.uka.ipd.sdq.units.Unit;
import de.uka.ipd.sdq.units.UnitCarryingElement;
import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Carrying Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl#getUnitSpecification <em>Unit Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UnitCarryingElementImpl extends EObjectImpl implements UnitCarryingElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * The default value of the '{@link #getUnitSpecification() <em>Unit Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitSpecification() <em>Unit Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSpecification()
	 * @generated
	 * @ordered
	 */
	protected String unitSpecification = UNIT_SPECIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCarryingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnitsPackage.Literals.UNIT_CARRYING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnit() {
		Unit unit = basicGetUnit();
		return unit != null && unit.eIsProxy() ? (Unit)eResolveProxy((InternalEObject)unit) : unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public Unit basicGetUnit() {
		// TODO: implement this method to return the 'Unit' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnitSpecification() {
		return unitSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSpecification(String newUnitSpecification) {
		String oldUnitSpecification = unitSpecification;
		unitSpecification = newUnitSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION, oldUnitSpecification, unitSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT:
				if (resolve) return getUnit();
				return basicGetUnit();
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION:
				return getUnitSpecification();
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
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION:
				setUnitSpecification((String)newValue);
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
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION:
				setUnitSpecification(UNIT_SPECIFICATION_EDEFAULT);
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
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT:
				return basicGetUnit() != null;
			case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION:
				return UNIT_SPECIFICATION_EDEFAULT == null ? unitSpecification != null : !UNIT_SPECIFICATION_EDEFAULT.equals(unitSpecification);
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
		result.append(" (unitSpecification: ");
		result.append(unitSpecification);
		result.append(')');
		return result.toString();
	}

} //UnitCarryingElementImpl
