/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.assembly.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage
 * @generated
 */
public class AssemblyValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AssemblyValidator INSTANCE = new AssemblyValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.assembly";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Context IDs Of Provides Role Not Equal Requires Role' of 'System Assembly Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SYSTEM_ASSEMBLY_CONNECTOR__CONTEXT_IDS_OF_PROVIDES_ROLE_NOT_EQUAL_REQUIRES_ROLE = 1;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
	  return AssemblyPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR:
				return validateSystemAssemblyConnector((SystemAssemblyConnector)value, diagnostics, context);
			case AssemblyPackage.ASSEMBLY_CONTEXT:
				return validateAssemblyContext((AssemblyContext)value, diagnostics, context);
			case AssemblyPackage.ASSEMBLY:
				return validateAssembly((Assembly)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemAssemblyConnector(SystemAssemblyConnector systemAssemblyConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(systemAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(systemAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(systemAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(systemAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(systemAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateSystemAssemblyConnector_contextIDsOfProvidesRoleNotEqualRequiresRole(systemAssemblyConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the contextIDsOfProvidesRoleNotEqualRequiresRole constraint of '<em>System Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemAssemblyConnector_contextIDsOfProvidesRoleNotEqualRequiresRole(SystemAssemblyConnector systemAssemblyConnector, DiagnosticChain diagnostics, Map context) {
		return systemAssemblyConnector.contextIDsOfProvidesRoleNotEqualRequiresRole(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssemblyContext(AssemblyContext assemblyContext, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyContext, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssembly(Assembly assembly, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(assembly, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assembly, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assembly, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assembly, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assembly, diagnostics, context);
		return result;
	}

} //AssemblyValidator
