/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.core.composition.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage
 * @generated
 */
public class CompositionValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CompositionValidator INSTANCE = new CompositionValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.core.composition";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner And Outer Role Need To Have Different Context IDs' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__INNER_AND_OUTER_ROLE_NEED_TO_HAVE_DIFFERENT_CONTEXT_IDS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner Containing Component Equal Outer Providing Component' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_PROVIDING_COMPONENT = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner And Outer Role Need To Have Different Context IDs' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__INNER_AND_OUTER_ROLE_NEED_TO_HAVE_DIFFERENT_CONTEXT_IDS = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner Containing Component Equal Outer Requiring Component' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_REQUIRING_COMPONENT = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

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
	public CompositionValidator() {
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
	  return CompositionPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR:
				return validateProvidedDelegationConnector((ProvidedDelegationConnector)value, diagnostics, context);
			case CompositionPackage.COMPOSED_STRUCTURE:
				return validateComposedStructure((ComposedStructure)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONTEXT:
				return validateAssemblyContext((AssemblyContext)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONNECTOR:
				return validateAssemblyConnector((AssemblyConnector)value, diagnostics, context);
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR:
				return validateRequiredDelegationConnector((RequiredDelegationConnector)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_innerAndOuterRoleNeedToHaveDifferentContextIDs(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_InnerContainingComponentEqualOuterProvidingComponent(providedDelegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the innerAndOuterRoleNeedToHaveDifferentContextIDs constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector_innerAndOuterRoleNeedToHaveDifferentContextIDs(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map context) {
		return providedDelegationConnector.innerAndOuterRoleNeedToHaveDifferentContextIDs(diagnostics, context);
	}

	/**
	 * Validates the InnerContainingComponentEqualOuterProvidingComponent constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector_InnerContainingComponentEqualOuterProvidingComponent(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map context) {
		return providedDelegationConnector.InnerContainingComponentEqualOuterProvidingComponent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComposedStructure(ComposedStructure composedStructure, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(composedStructure, diagnostics, context);
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
	public boolean validateAssemblyConnector(AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyConnector, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_innerAndOuterRoleNeedToHaveDifferentContextIDs(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_InnerContainingComponentEqualOuterRequiringComponent(requiredDelegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the innerAndOuterRoleNeedToHaveDifferentContextIDs constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector_innerAndOuterRoleNeedToHaveDifferentContextIDs(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map context) {
		return requiredDelegationConnector.innerAndOuterRoleNeedToHaveDifferentContextIDs(diagnostics, context);
	}

	/**
	 * Validates the InnerContainingComponentEqualOuterRequiringComponent constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector_InnerContainingComponentEqualOuterRequiringComponent(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map context) {
		return requiredDelegationConnector.InnerContainingComponentEqualOuterRequiringComponent(diagnostics, context);
	}

} //CompositionValidator
