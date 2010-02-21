/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.DefaultValue;
import de.uka.ipd.sdq.featuremodel.IntervalRange;
import de.uka.ipd.sdq.featuremodel.PrimitiveAttribute;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.PrimitiveAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.PrimitiveAttributeImpl#getRange <em>Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.PrimitiveAttributeImpl#getDefaultvalue <em>Defaultvalue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveAttributeImpl extends AttributeImpl implements PrimitiveAttribute {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeTypes TYPE_EDEFAULT = AttributeTypes.INT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttributeTypes type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected IntervalRange range;

	/**
	 * The cached value of the '{@link #getDefaultvalue() <em>Defaultvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultvalue()
	 * @generated
	 * @ordered
	 */
	protected DefaultValue defaultvalue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.PRIMITIVE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeTypes getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AttributeTypes newType) {
		AttributeTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.PRIMITIVE_ATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntervalRange getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRange(IntervalRange newRange, NotificationChain msgs) {
		IntervalRange oldRange = range;
		range = newRange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE, oldRange, newRange);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(IntervalRange newRange) {
		if (newRange != range) {
			NotificationChain msgs = null;
			if (range != null)
				msgs = ((InternalEObject)range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE, null, msgs);
			if (newRange != null)
				msgs = ((InternalEObject)newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE, null, msgs);
			msgs = basicSetRange(newRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE, newRange, newRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultValue getDefaultvalue() {
		return defaultvalue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultvalue(DefaultValue newDefaultvalue, NotificationChain msgs) {
		DefaultValue oldDefaultvalue = defaultvalue;
		defaultvalue = newDefaultvalue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE, oldDefaultvalue, newDefaultvalue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultvalue(DefaultValue newDefaultvalue) {
		if (newDefaultvalue != defaultvalue) {
			NotificationChain msgs = null;
			if (defaultvalue != null)
				msgs = ((InternalEObject)defaultvalue).eInverseRemove(this, featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE, DefaultValue.class, msgs);
			if (newDefaultvalue != null)
				msgs = ((InternalEObject)newDefaultvalue).eInverseAdd(this, featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE, DefaultValue.class, msgs);
			msgs = basicSetDefaultvalue(newDefaultvalue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE, newDefaultvalue, newDefaultvalue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				if (defaultvalue != null)
					msgs = ((InternalEObject)defaultvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE, null, msgs);
				return basicSetDefaultvalue((DefaultValue)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE:
				return basicSetRange(null, msgs);
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				return basicSetDefaultvalue(null, msgs);
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
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__TYPE:
				return getType();
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE:
				return getRange();
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				return getDefaultvalue();
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
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__TYPE:
				setType((AttributeTypes)newValue);
				return;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE:
				setRange((IntervalRange)newValue);
				return;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				setDefaultvalue((DefaultValue)newValue);
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
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE:
				setRange((IntervalRange)null);
				return;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				setDefaultvalue((DefaultValue)null);
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
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__TYPE:
				return type != TYPE_EDEFAULT;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__RANGE:
				return range != null;
			case featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE:
				return defaultvalue != null;
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

} //PrimitiveAttributeImpl
