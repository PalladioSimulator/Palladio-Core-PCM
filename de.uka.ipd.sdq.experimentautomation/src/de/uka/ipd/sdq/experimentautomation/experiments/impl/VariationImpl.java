/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.experimentautomation.variation.VariationType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getValueProvider <em>Value Provider</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getMaxVariations <em>Max Variations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getVariedObjectId <em>Varied Object Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariationImpl extends EObjectImpl implements Variation {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected VariationType type;

	/**
	 * The cached value of the '{@link #getValueProvider() <em>Value Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueProvider()
	 * @generated
	 * @ordered
	 */
	protected ValueProvider valueProvider;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final long MIN_VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected long minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected long maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxVariations() <em>Max Variations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxVariations()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_VARIATIONS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxVariations() <em>Max Variations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxVariations()
	 * @generated
	 * @ordered
	 */
	protected long maxVariations = MAX_VARIATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariedObjectId() <em>Varied Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariedObjectId()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIED_OBJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariedObjectId() <em>Varied Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariedObjectId()
	 * @generated
	 * @ordered
	 */
	protected String variedObjectId = VARIED_OBJECT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentsPackage.Literals.VARIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (VariationType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentsPackage.VARIATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(VariationType newType) {
		VariationType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueProvider getValueProvider() {
		return valueProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueProvider(ValueProvider newValueProvider, NotificationChain msgs) {
		ValueProvider oldValueProvider = valueProvider;
		valueProvider = newValueProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__VALUE_PROVIDER, oldValueProvider, newValueProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueProvider(ValueProvider newValueProvider) {
		if (newValueProvider != valueProvider) {
			NotificationChain msgs = null;
			if (valueProvider != null)
				msgs = ((InternalEObject)valueProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.VARIATION__VALUE_PROVIDER, null, msgs);
			if (newValueProvider != null)
				msgs = ((InternalEObject)newValueProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.VARIATION__VALUE_PROVIDER, null, msgs);
			msgs = basicSetValueProvider(newValueProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__VALUE_PROVIDER, newValueProvider, newValueProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(long newMinValue) {
		long oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(long newMaxValue) {
		long oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxVariations() {
		return maxVariations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxVariations(long newMaxVariations) {
		long oldMaxVariations = maxVariations;
		maxVariations = newMaxVariations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__MAX_VARIATIONS, oldMaxVariations, maxVariations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariedObjectId() {
		return variedObjectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariedObjectId(String newVariedObjectId) {
		String oldVariedObjectId = variedObjectId;
		variedObjectId = newVariedObjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__VARIED_OBJECT_ID, oldVariedObjectId, variedObjectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.VARIATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
				return basicSetValueProvider(null, msgs);
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
			case ExperimentsPackage.VARIATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
				return getValueProvider();
			case ExperimentsPackage.VARIATION__MIN_VALUE:
				return getMinValue();
			case ExperimentsPackage.VARIATION__MAX_VALUE:
				return getMaxValue();
			case ExperimentsPackage.VARIATION__MAX_VARIATIONS:
				return getMaxVariations();
			case ExperimentsPackage.VARIATION__VARIED_OBJECT_ID:
				return getVariedObjectId();
			case ExperimentsPackage.VARIATION__NAME:
				return getName();
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
			case ExperimentsPackage.VARIATION__TYPE:
				setType((VariationType)newValue);
				return;
			case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
				setValueProvider((ValueProvider)newValue);
				return;
			case ExperimentsPackage.VARIATION__MIN_VALUE:
				setMinValue((Long)newValue);
				return;
			case ExperimentsPackage.VARIATION__MAX_VALUE:
				setMaxValue((Long)newValue);
				return;
			case ExperimentsPackage.VARIATION__MAX_VARIATIONS:
				setMaxVariations((Long)newValue);
				return;
			case ExperimentsPackage.VARIATION__VARIED_OBJECT_ID:
				setVariedObjectId((String)newValue);
				return;
			case ExperimentsPackage.VARIATION__NAME:
				setName((String)newValue);
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
			case ExperimentsPackage.VARIATION__TYPE:
				setType((VariationType)null);
				return;
			case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
				setValueProvider((ValueProvider)null);
				return;
			case ExperimentsPackage.VARIATION__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case ExperimentsPackage.VARIATION__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case ExperimentsPackage.VARIATION__MAX_VARIATIONS:
				setMaxVariations(MAX_VARIATIONS_EDEFAULT);
				return;
			case ExperimentsPackage.VARIATION__VARIED_OBJECT_ID:
				setVariedObjectId(VARIED_OBJECT_ID_EDEFAULT);
				return;
			case ExperimentsPackage.VARIATION__NAME:
				setName(NAME_EDEFAULT);
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
			case ExperimentsPackage.VARIATION__TYPE:
				return type != null;
			case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
				return valueProvider != null;
			case ExperimentsPackage.VARIATION__MIN_VALUE:
				return minValue != MIN_VALUE_EDEFAULT;
			case ExperimentsPackage.VARIATION__MAX_VALUE:
				return maxValue != MAX_VALUE_EDEFAULT;
			case ExperimentsPackage.VARIATION__MAX_VARIATIONS:
				return maxVariations != MAX_VARIATIONS_EDEFAULT;
			case ExperimentsPackage.VARIATION__VARIED_OBJECT_ID:
				return VARIED_OBJECT_ID_EDEFAULT == null ? variedObjectId != null : !VARIED_OBJECT_ID_EDEFAULT.equals(variedObjectId);
			case ExperimentsPackage.VARIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", maxVariations: ");
		result.append(maxVariations);
		result.append(", variedObjectId: ");
		result.append(variedObjectId);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //VariationImpl
