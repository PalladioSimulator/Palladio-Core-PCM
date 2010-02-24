/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.DefaultValue;
import de.uka.ipd.sdq.featuremodel.PrimitiveAttribute;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

import de.uka.ipd.sdq.featuremodel.util.featuremodelValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DefaultValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DefaultValueImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DefaultValueImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultValueImpl extends EObjectImpl implements DefaultValue {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeTypes TYPE_EDEFAULT = AttributeTypes.INT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.DEFAULT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
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
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.DEFAULT_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns the result of showType()
	 * showType is defined by an OCL expression.
	 * The type of a DefaultValue equals the type of its corresponding PrimitiveAttribute
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public AttributeTypes getType() {
		return showType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveAttribute getAttribute() {
		if (eContainerFeatureID() != featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE) return null;
		return (PrimitiveAttribute)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttribute(PrimitiveAttribute newAttribute, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAttribute, featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(PrimitiveAttribute newAttribute) {
		if (newAttribute != eInternalContainer() || (eContainerFeatureID() != featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE && newAttribute != null)) {
			if (EcoreUtil.isAncestor(this, newAttribute))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE, PrimitiveAttribute.class, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE, newAttribute, newAttribute));
	}

	/**
	 * The cached OCL expression body for the '{@link #DefaultValueMustBeOfSpecifiedType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Default Value Must Be Of Specified Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DefaultValueMustBeOfSpecifiedType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "--self.value.oclIsKindOf(self.attribute.type) --does not work, but this should be expressed somehow.";

	/**
	 * The cached OCL invariant for the '{@link #DefaultValueMustBeOfSpecifiedType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Default Value Must Be Of Specified Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DefaultValueMustBeOfSpecifiedType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DefaultValueMustBeOfSpecifiedType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featuremodelPackage.Literals.DEFAULT_VALUE);
			try {
				DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.DEFAULT_VALUE__DEFAULT_VALUE_MUST_BE_OF_SPECIFIED_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DefaultValueMustBeOfSpecifiedType", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #showType() <em>Show Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showType()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_TYPE__EOCL_EXP = "attribute.type";

	/**
	 * The cached OCL query for the '{@link #showType() <em>Show Type</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showType()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> SHOW_TYPE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeTypes showType() {
		if (SHOW_TYPE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(featuremodelPackage.Literals.DEFAULT_VALUE, featuremodelPackage.Literals.DEFAULT_VALUE.getEAllOperations().get(1));
			try {
				SHOW_TYPE__EOCL_QRY = helper.createQuery(SHOW_TYPE__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(SHOW_TYPE__EOCL_QRY);
		return (AttributeTypes) query.evaluate(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAttribute((PrimitiveAttribute)otherEnd, msgs);
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
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
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
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				return eInternalContainer().eInverseRemove(this, featuremodelPackage.PRIMITIVE_ATTRIBUTE__DEFAULTVALUE, PrimitiveAttribute.class, msgs);
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
			case featuremodelPackage.DEFAULT_VALUE__VALUE:
				return getValue();
			case featuremodelPackage.DEFAULT_VALUE__TYPE:
				return getType();
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				return getAttribute();
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
			case featuremodelPackage.DEFAULT_VALUE__VALUE:
				setValue((String)newValue);
				return;
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				setAttribute((PrimitiveAttribute)newValue);
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
			case featuremodelPackage.DEFAULT_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				setAttribute((PrimitiveAttribute)null);
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
			case featuremodelPackage.DEFAULT_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case featuremodelPackage.DEFAULT_VALUE__TYPE:
				return getType() != TYPE_EDEFAULT;
			case featuremodelPackage.DEFAULT_VALUE__ATTRIBUTE:
				return getAttribute() != null;
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

} //DefaultValueImpl
