/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;

import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Object Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ExternalObjectAttributeValueImpl#getReferencedObject <em>Referenced Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalObjectAttributeValueImpl extends AttributeValueImpl implements ExternalObjectAttributeValue {
	/**
	 * The cached value of the '{@link #getReferencedObject() <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject referencedObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalObjectAttributeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.EXTERNAL_OBJECT_ATTRIBUTE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getReferencedObject() {
		if (referencedObject != null && referencedObject.eIsProxy()) {
			InternalEObject oldReferencedObject = (InternalEObject)referencedObject;
			referencedObject = eResolveProxy(oldReferencedObject);
			if (referencedObject != oldReferencedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
			}
		}
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetReferencedObject() {
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedObject(EObject newReferencedObject) {
		EObject oldReferencedObject = referencedObject;
		referencedObject = newReferencedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
	}

	/**
	 * The cached OCL expression body for the '{@link #AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Value Is Defined In Feature And Equals Type External Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.confignode.origin.attributes->one(a | a.name = self.name)"+
" and"+
" self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::ExternalObjectAttribute)";

	/**
	 * The cached OCL invariant for the '{@link #AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Value Is Defined In Feature And Equals Type External Object</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.EXTERNAL_OBJECT_ATTRIBUTE_VALUE);
			try {
				ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject", EObjectValidator.getObjectLabel(this, context) }),
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT:
				if (resolve) return getReferencedObject();
				return basicGetReferencedObject();
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
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT:
				setReferencedObject((EObject)newValue);
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
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT:
				setReferencedObject((EObject)null);
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
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT:
				return referencedObject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //ExternalObjectAttributeValueImpl
