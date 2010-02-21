/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.AttributeValue;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;

import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.PrimitiveAttribute;
import de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl;
import de.uka.ipd.sdq.featuremodel.impl.PrimitiveAttributeImpl;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

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
public class AttributeValueImpl extends NamedElementImpl implements AttributeValue {
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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getValue() {
		//begin user defined
		System.err.println(this.getConfignode().getConfigState());
		if (this.getConfignode().getConfigState().equals(ConfigState.DEFAULT)){
			for (Attribute a: this.getConfignode().getOrigin().getAttributes()){
				if (a.getClass().equals(PrimitiveAttributeImpl.class)){
					PrimitiveAttribute pa = PrimitiveAttribute.class.cast(a);
					System.err.println(pa.getName() + " " + this.getName());
					if (pa.getName().equals(this.getName())){
						return pa.getDefaultvalue().getValue();
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
	 * The cached OCL expression body for the '{@link #AttributeIsDefinedInFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Is Defined In Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeIsDefinedInFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.confignode.origin.attributes.name->includes(self.name) ";

	/**
	 * The cached OCL invariant for the '{@link #AttributeIsDefinedInFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Is Defined In Feature</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeIsDefinedInFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AttributeIsDefinedInFeature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.ATTRIBUTE_VALUE);
			try {
				ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ATTRIBUTE_IS_DEFINED_IN_FEATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.ATTRIBUTE_VALUE__ATTRIBUTE_IS_DEFINED_IN_FEATURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AttributeIsDefinedInFeature", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //AttributeValueImpl
