/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.util;

import de.fzi.se.controlflowdescription.jjnpaths.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage
 * @generated
 */
public class JJnPathsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final JJnPathsValidator INSTANCE = new JJnPathsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.controlflowdescription.jjnpaths";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'NMust Be Greater Or Equal To One' of 'JJn Path Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int JJN_PATH_SET__NMUST_BE_GREATER_OR_EQUAL_TO_ONE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return JJnPathsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case JJnPathsPackage.JJN_PATH_TEST_SUITE:
				return validateJJnPathTestSuite((JJnPathTestSuite)value, diagnostics, context);
			case JJnPathsPackage.JJN_PATH:
				return validateJJnPath((JJnPath)value, diagnostics, context);
			case JJnPathsPackage.JJ_PATH:
				return validateJJPath((JJPath)value, diagnostics, context);
			case JJnPathsPackage.JJN_PATH_TEST_CASE:
				return validateJJnPathTestCase((JJnPathTestCase)value, diagnostics, context);
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER:
				return validateJJnPathsCreationParameter((JJnPathsCreationParameter)value, diagnostics, context);
			case JJnPathsPackage.JJN_PATH_SET:
				return validateJJnPathSet((JJnPathSet)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPathTestSuite(JJnPathTestSuite jJnPathTestSuite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jJnPathTestSuite, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPath(JJnPath jJnPath, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jJnPath, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJPath(JJPath jjPath, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jjPath, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPathTestCase(JJnPathTestCase jJnPathTestCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jJnPathTestCase, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPathsCreationParameter(JJnPathsCreationParameter jJnPathsCreationParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jJnPathsCreationParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPathSet(JJnPathSet jJnPathSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(jJnPathSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateJJnPathSet_NMustBeGreaterOrEqualToOne(jJnPathSet, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NMustBeGreaterOrEqualToOne constraint of '<em>JJn Path Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJJnPathSet_NMustBeGreaterOrEqualToOne(JJnPathSet jJnPathSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return jJnPathSet.NMustBeGreaterOrEqualToOne(diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //JJnPathsValidator
