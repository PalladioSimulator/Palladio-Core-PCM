/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.featureconfig.AttributeValue;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.DoubleAttribute;
import de.uka.ipd.sdq.featuremodel.IntegerAttribute;
import de.uka.ipd.sdq.featuremodel.impl.DoubleAttributeImpl;
import de.uka.ipd.sdq.featuremodel.impl.IntegerAttributeImpl;
import de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl#getConfignode <em>Confignode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AttributeValueImpl extends NamedElementImpl implements AttributeValue {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.ATTRIBUTE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Code added, although value is not marked as derived.
	 * Return the features default attribute value if ConfigState of ConfigNode equals "DEFAULT"
	 * The default attribute value is not returned, if its type does not match the attributeValues type
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getValue() {
		//begin user defined
		if ((this.getConfignode() != null) && (this.getConfignode().getConfigState() != null)) {
			if (this.getConfignode().getConfigState().equals(ConfigState.DEFAULT)
					&& this.getClass().equals(IntegerAttributeValueImpl.class)){
				if ((this.getConfignode() != null) && (this.getConfignode().getOrigin() != null)) {
					for (Attribute a: this.getConfignode().getOrigin().getAttributes()){
						if (a.getClass().equals(IntegerAttributeImpl.class)){
							IntegerAttribute ia = IntegerAttribute.class.cast(a);
							if (ia.getName().equals(this.getName())){
								return String.valueOf(ia.getDefaultValue());
							}
						}
					}
				}
			}
		}
		if ((this.getConfignode() != null) && (this.getConfignode().getConfigState() != null)) {
			if (this.getConfignode().getConfigState().equals(ConfigState.DEFAULT)
					&& this.getClass().equals(DoubleAttributeValueImpl.class)){
				if ((this.getConfignode() != null) && (this.getConfignode().getOrigin() != null)) {
					for (Attribute a: this.getConfignode().getOrigin().getAttributes()){
						if (a.getClass().equals(DoubleAttributeImpl.class)){
							DoubleAttribute da = DoubleAttribute.class.cast(a);
							if (da.getName().equals(this.getName())){
								return String.valueOf(da.getDefaultValue());
							}
						}
					}
				}
			}
		}
		//end user defined
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.ATTRIBUTE_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigNode getConfignode() {
		if (eContainerFeatureID() != featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE) return null;
		return (ConfigNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfignode(ConfigNode newConfignode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfignode, featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfignode(ConfigNode newConfignode) {
		if (newConfignode != eInternalContainer() || (eContainerFeatureID() != featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE && newConfignode != null)) {
			if (EcoreUtil.isAncestor(this, newConfignode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfignode != null)
				msgs = ((InternalEObject)newConfignode).eInverseAdd(this, featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE, ConfigNode.class, msgs);
			msgs = basicSetConfignode(newConfignode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE, newConfignode, newConfignode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfignode((ConfigNode)otherEnd, msgs);
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
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				return basicSetConfignode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				return eInternalContainer().eInverseRemove(this, featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE, ConfigNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.ATTRIBUTE_VALUE__VALUE:
				return getValue();
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				return getConfignode();
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
			case featureconfigPackage.ATTRIBUTE_VALUE__VALUE:
				setValue((String)newValue);
				return;
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				setConfignode((ConfigNode)newValue);
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
			case featureconfigPackage.ATTRIBUTE_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				setConfignode((ConfigNode)null);
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
			case featureconfigPackage.ATTRIBUTE_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE:
				return getConfignode() != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //AttributeValueImpl
