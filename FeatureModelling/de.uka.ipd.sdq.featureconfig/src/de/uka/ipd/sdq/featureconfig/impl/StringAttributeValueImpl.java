/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.StringAttributeValue;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;

import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StringAttributeValueImpl extends AttributeValueImpl implements StringAttributeValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringAttributeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.STRING_ATTRIBUTE_VALUE;
	}

	/**
	 * The cached OCL expression body for the '{@link #AttributeValueIsDefinedInFeatureAndEqualsTypeString(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Value Is Defined In Feature And Equals Type String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeValueIsDefinedInFeatureAndEqualsTypeString(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.confignode.origin.attributes->one(a | a.name = self.name)"+
" and"+
" self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::StringAttribute)";

	/**
	 * The cached OCL invariant for the '{@link #AttributeValueIsDefinedInFeatureAndEqualsTypeString(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attribute Value Is Defined In Feature And Equals Type String</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AttributeValueIsDefinedInFeatureAndEqualsTypeString(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AttributeValueIsDefinedInFeatureAndEqualsTypeString(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.STRING_ATTRIBUTE_VALUE);
			try {
				ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.STRING_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AttributeValueIsDefinedInFeatureAndEqualsTypeString", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //StringAttributeValueImpl
