/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ValueLiteral;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl#getRangeLimitLiteral <em>Range Limit Literal</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeValueImpl extends IdentifierImpl implements RangeValue {
	/**
	 * The cached value of the '{@link #getRangeLimitLiteral() <em>Range Limit Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeLimitLiteral()
	 * @generated
	 * @ordered
	 */
	protected ValueLiteral rangeLimitLiteral;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EnumRangeValueType TYPE_EDEFAULT = EnumRangeValueType.INCLUSIVE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EnumRangeValueType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractPackage.Literals.RANGE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueLiteral getRangeLimitLiteral() {
		return rangeLimitLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRangeLimitLiteral(ValueLiteral newRangeLimitLiteral, NotificationChain msgs) {
		ValueLiteral oldRangeLimitLiteral = rangeLimitLiteral;
		rangeLimitLiteral = newRangeLimitLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL, oldRangeLimitLiteral, newRangeLimitLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeLimitLiteral(ValueLiteral newRangeLimitLiteral) {
		if (newRangeLimitLiteral != rangeLimitLiteral) {
			NotificationChain msgs = null;
			if (rangeLimitLiteral != null)
				msgs = ((InternalEObject)rangeLimitLiteral).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL, null, msgs);
			if (newRangeLimitLiteral != null)
				msgs = ((InternalEObject)newRangeLimitLiteral).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL, null, msgs);
			msgs = basicSetRangeLimitLiteral(newRangeLimitLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL, newRangeLimitLiteral, newRangeLimitLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumRangeValueType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EnumRangeValueType newType) {
		EnumRangeValueType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractPackage.RANGE_VALUE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL:
				return basicSetRangeLimitLiteral(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL:
				return getRangeLimitLiteral();
			case QMLContractPackage.RANGE_VALUE__TYPE:
				return getType();
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
			case QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL:
				setRangeLimitLiteral((ValueLiteral)newValue);
				return;
			case QMLContractPackage.RANGE_VALUE__TYPE:
				setType((EnumRangeValueType)newValue);
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
			case QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL:
				setRangeLimitLiteral((ValueLiteral)null);
				return;
			case QMLContractPackage.RANGE_VALUE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case QMLContractPackage.RANGE_VALUE__RANGE_LIMIT_LITERAL:
				return rangeLimitLiteral != null;
			case QMLContractPackage.RANGE_VALUE__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //RangeValueImpl
