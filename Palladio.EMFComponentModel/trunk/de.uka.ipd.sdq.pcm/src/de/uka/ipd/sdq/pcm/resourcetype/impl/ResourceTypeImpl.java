/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.units.Unit;
import de.uka.ipd.sdq.units.UnitCarryingElement;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getUnitSpecification <em>Unit Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceTypeImpl extends EntityImpl implements ResourceType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

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
	protected ResourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.RESOURCE_TYPE;
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
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(Unit newUnit) {
		// TODO: implement this method to set the 'Unit' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION, oldUnitSpecification, unitSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_TYPE__UNIT:
				if (resolve) return getUnit();
				return basicGetUnit();
			case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
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
			case ResourcetypePackage.RESOURCE_TYPE__UNIT:
				setUnit((Unit)newValue);
				return;
			case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
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
			case ResourcetypePackage.RESOURCE_TYPE__UNIT:
				setUnit((Unit)null);
				return;
			case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
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
			case ResourcetypePackage.RESOURCE_TYPE__UNIT:
				return basicGetUnit() != null;
			case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == UnitCarryingElement.class) {
			switch (derivedFeatureID) {
				case ResourcetypePackage.RESOURCE_TYPE__UNIT: return UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT;
				case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION: return UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION;
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
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == UnitCarryingElement.class) {
			switch (baseFeatureID) {
				case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT: return ResourcetypePackage.RESOURCE_TYPE__UNIT;
				case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION: return ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION;
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
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unitSpecification: ");
		result.append(unitSpecification);
		result.append(')');
		return result.toString();
	}

} //ResourceTypeImpl
