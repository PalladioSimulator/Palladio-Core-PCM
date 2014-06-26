/**
 */
package de.uka.ipd.sdq.experimentautomation.variation.impl;

import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationType;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl#getStrategyClass <em>Strategy Class</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl#getVariedEntityInterface <em>Varied Entity Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariationTypeImpl extends IdentifierImpl implements VariationType {
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
	 * The default value of the '{@link #getStrategyClass() <em>Strategy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategyClass()
	 * @generated
	 * @ordered
	 */
	protected static final String STRATEGY_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStrategyClass() <em>Strategy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategyClass()
	 * @generated
	 * @ordered
	 */
	protected String strategyClass = STRATEGY_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariedEntityInterface() <em>Varied Entity Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariedEntityInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIED_ENTITY_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariedEntityInterface() <em>Varied Entity Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariedEntityInterface()
	 * @generated
	 * @ordered
	 */
	protected String variedEntityInterface = VARIED_ENTITY_INTERFACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VariationPackage.Literals.VARIATION_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariationPackage.VARIATION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStrategyClass() {
		return strategyClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrategyClass(String newStrategyClass) {
		String oldStrategyClass = strategyClass;
		strategyClass = newStrategyClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariationPackage.VARIATION_TYPE__STRATEGY_CLASS, oldStrategyClass, strategyClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariedEntityInterface() {
		return variedEntityInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariedEntityInterface(String newVariedEntityInterface) {
		String oldVariedEntityInterface = variedEntityInterface;
		variedEntityInterface = newVariedEntityInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE, oldVariedEntityInterface, variedEntityInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariationPackage.VARIATION_TYPE__NAME:
				return getName();
			case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
				return getStrategyClass();
			case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
				return getVariedEntityInterface();
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
			case VariationPackage.VARIATION_TYPE__NAME:
				setName((String)newValue);
				return;
			case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
				setStrategyClass((String)newValue);
				return;
			case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
				setVariedEntityInterface((String)newValue);
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
			case VariationPackage.VARIATION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
				setStrategyClass(STRATEGY_CLASS_EDEFAULT);
				return;
			case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
				setVariedEntityInterface(VARIED_ENTITY_INTERFACE_EDEFAULT);
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
			case VariationPackage.VARIATION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VariationPackage.VARIATION_TYPE__STRATEGY_CLASS:
				return STRATEGY_CLASS_EDEFAULT == null ? strategyClass != null : !STRATEGY_CLASS_EDEFAULT.equals(strategyClass);
			case VariationPackage.VARIATION_TYPE__VARIED_ENTITY_INTERFACE:
				return VARIED_ENTITY_INTERFACE_EDEFAULT == null ? variedEntityInterface != null : !VARIED_ENTITY_INTERFACE_EDEFAULT.equals(variedEntityInterface);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", strategyClass: ");
		result.append(strategyClass);
		result.append(", variedEntityInterface: ");
		result.append(variedEntityInterface);
		result.append(')');
		return result.toString();
	}

} //VariationTypeImpl
