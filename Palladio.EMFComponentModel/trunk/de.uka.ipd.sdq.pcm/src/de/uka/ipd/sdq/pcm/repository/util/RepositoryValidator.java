/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.repository.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositoryValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final RepositoryValidator INSTANCE = new RepositoryValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.repository";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Names Have To Be Unique For ASignature' of 'Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIGNATURE__PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Protocol Type ID Used Twice' of 'Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signatures Have To Be Unique For An Interface' of 'Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERFACE__SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner And Outer Role Need To Have Different Context IDs' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__INNER_AND_OUTER_ROLE_NEED_TO_HAVE_DIFFERENT_CONTEXT_IDS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner Containing Component Equal Outer Requiring Component' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_REQUIRING_COMPONENT = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Grant First Class Entity Type Composite Component' of 'Repository'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPOSITORY__GRANT_FIRST_CLASS_ENTITY_TYPE_COMPOSITE_COMPONENT = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Grant First Class Entity Type Provides Component Type' of 'Repository'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPOSITORY__GRANT_FIRST_CLASS_ENTITY_TYPE_PROVIDES_COMPONENT_TYPE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Grant First Class Entity Type Complete Component Type' of 'Repository'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPOSITORY__GRANT_FIRST_CLASS_ENTITY_TYPE_COMPLETE_COMPONENT_TYPE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Grant First Class Entity Type Implementation Component Type' of 'Repository'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPOSITORY__GRANT_FIRST_CLASS_ENTITY_TYPE_IMPLEMENTATION_COMPONENT_TYPE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Grant First Class Entity Type Basic Component' of 'Repository'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPOSITORY__GRANT_FIRST_CLASS_ENTITY_TYPE_BASIC_COMPONENT = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner And Outer Role Need To Have Different Context IDs' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__INNER_AND_OUTER_ROLE_NEED_TO_HAVE_DIFFERENT_CONTEXT_IDS = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner Containing Component Equal Outer Providing Component' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_PROVIDING_COMPONENT = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Required Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided Or Required By AUsefull Complete Component Type' of 'Complete Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPLETE_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_OR_REQUIRED_BY_AUSEFULL_COMPLETE_COMPONENT_TYPE = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided Interfaces Have To Conform To Provided Type2' of 'Complete Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPLETE_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_PROVIDED_TYPE2 = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provide Same Interfaces' of 'Composite Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPOSITE_COMPONENT__PROVIDE_SAME_INTERFACES = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Require Same Interfaces' of 'Composite Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPOSITE_COMPONENT__REQUIRE_SAME_INTERFACES = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Seff Type Used Twice' of 'Basic Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BASIC_COMPONENT__NO_SEFF_TYPE_USED_TWICE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provide Same Interfaces' of 'Basic Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BASIC_COMPONENT__PROVIDE_SAME_INTERFACES = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Require Same Interfaces' of 'Basic Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BASIC_COMPONENT__REQUIRE_SAME_INTERFACES = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided By AUsefull Provides Component Type' of 'Provides Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDES_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_BY_AUSEFULL_PROVIDES_COMPONENT_TYPE = 22;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 22;

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
	public RepositoryValidator() {
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
	  return RepositoryPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case RepositoryPackage.SIGNATURE:
				return validateSignature((Signature)value, diagnostics, context);
			case RepositoryPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case RepositoryPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case RepositoryPackage.EXCEPTION_TYPE:
				return validateExceptionType((ExceptionType)value, diagnostics, context);
			case RepositoryPackage.ROLE:
				return validateRole((Role)value, diagnostics, context);
			case RepositoryPackage.REQUIRED_ROLE:
				return validateRequiredRole((RequiredRole)value, diagnostics, context);
			case RepositoryPackage.INTERFACE:
				return validateInterface((Interface)value, diagnostics, context);
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR:
				return validateRequiredDelegationConnector((RequiredDelegationConnector)value, diagnostics, context);
			case RepositoryPackage.DELEGATION_CONNECTOR:
				return validateDelegationConnector((DelegationConnector)value, diagnostics, context);
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT:
				return validateChildComponentContext((ChildComponentContext)value, diagnostics, context);
			case RepositoryPackage.REPOSITORY:
				return validateRepository((Repository)value, diagnostics, context);
			case RepositoryPackage.PROVIDED_ROLE:
				return validateProvidedRole((ProvidedRole)value, diagnostics, context);
			case RepositoryPackage.PROVIDED_DELEGATION_CONNECTOR:
				return validateProvidedDelegationConnector((ProvidedDelegationConnector)value, diagnostics, context);
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE:
				return validateImplementationComponentType((ImplementationComponentType)value, diagnostics, context);
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE:
				return validateCompleteComponentType((CompleteComponentType)value, diagnostics, context);
			case RepositoryPackage.COMPOSITE_COMPONENT:
				return validateCompositeComponent((CompositeComponent)value, diagnostics, context);
			case RepositoryPackage.COMPOSITE_ASSEMBLY_CONNECTOR:
				return validateCompositeAssemblyConnector((CompositeAssemblyConnector)value, diagnostics, context);
			case RepositoryPackage.BASIC_COMPONENT:
				return validateBasicComponent((BasicComponent)value, diagnostics, context);
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE:
				return validateProvidesComponentType((ProvidesComponentType)value, diagnostics, context);
			case RepositoryPackage.PARAMETER_MODIFIER:
				return validateParameterModifier((ParameterModifier)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validateSignature_ParameterNamesHaveToBeUniqueForASignature(signature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ParameterNamesHaveToBeUniqueForASignature constraint of '<em>Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignature_ParameterNamesHaveToBeUniqueForASignature(Signature signature, DiagnosticChain diagnostics, Map context) {
		return signature.ParameterNamesHaveToBeUniqueForASignature(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(dataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionType(ExceptionType exceptionType, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(exceptionType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(role, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(role, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredRole(RequiredRole requiredRole, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredRole, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface(Interface interface_, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_noProtocolTypeIDUsedTwice(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_SignaturesHaveToBeUniqueForAnInterface(interface_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noProtocolTypeIDUsedTwice constraint of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface_noProtocolTypeIDUsedTwice(Interface interface_, DiagnosticChain diagnostics, Map context) {
		return interface_.noProtocolTypeIDUsedTwice(diagnostics, context);
	}

	/**
	 * Validates the SignaturesHaveToBeUniqueForAnInterface constraint of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface_SignaturesHaveToBeUniqueForAnInterface(Interface interface_, DiagnosticChain diagnostics, Map context) {
		return interface_.SignaturesHaveToBeUniqueForAnInterface(diagnostics, context);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDelegationConnector(DelegationConnector delegationConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(delegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChildComponentContext(ChildComponentContext childComponentContext, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(childComponentContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(childComponentContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(childComponentContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(childComponentContext, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(childComponentContext, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository(Repository repository, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_GrantFirstClassEntityTypeCompositeComponent(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_GrantFirstClassEntityTypeProvidesComponentType(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_GrantFirstClassEntityTypeCompleteComponentType(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_GrantFirstClassEntityTypeImplementationComponentType(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_GrantFirstClassEntityTypeBasicComponent(repository, diagnostics, context);
		return result;
	}

	/**
	 * Validates the GrantFirstClassEntityTypeCompositeComponent constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_GrantFirstClassEntityTypeCompositeComponent(Repository repository, DiagnosticChain diagnostics, Map context) {
		return repository.GrantFirstClassEntityTypeCompositeComponent(diagnostics, context);
	}

	/**
	 * Validates the GrantFirstClassEntityTypeProvidesComponentType constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_GrantFirstClassEntityTypeProvidesComponentType(Repository repository, DiagnosticChain diagnostics, Map context) {
		return repository.GrantFirstClassEntityTypeProvidesComponentType(diagnostics, context);
	}

	/**
	 * Validates the GrantFirstClassEntityTypeCompleteComponentType constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_GrantFirstClassEntityTypeCompleteComponentType(Repository repository, DiagnosticChain diagnostics, Map context) {
		return repository.GrantFirstClassEntityTypeCompleteComponentType(diagnostics, context);
	}

	/**
	 * Validates the GrantFirstClassEntityTypeImplementationComponentType constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_GrantFirstClassEntityTypeImplementationComponentType(Repository repository, DiagnosticChain diagnostics, Map context) {
		return repository.GrantFirstClassEntityTypeImplementationComponentType(diagnostics, context);
	}

	/**
	 * Validates the GrantFirstClassEntityTypeBasicComponent constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_GrantFirstClassEntityTypeBasicComponent(Repository repository, DiagnosticChain diagnostics, Map context) {
		return repository.GrantFirstClassEntityTypeBasicComponent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedRole(ProvidedRole providedRole, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedRole, diagnostics, context);
		return result;
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
	public boolean validateImplementationComponentType(ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(implementationComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RequiredInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics, Map context) {
		return implementationComponentType.RequiredInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

	/**
	 * Validates the providedInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics, Map context) {
		return implementationComponentType.providedInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteComponentType(CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(completeComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType constraint of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map context) {
		return completeComponentType.AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(diagnostics, context);
	}

	/**
	 * Validates the providedInterfacesHaveToConformToProvidedType2 constraint of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map context) {
		return completeComponentType.providedInterfacesHaveToConformToProvidedType2(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent(CompositeComponent compositeComponent, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeComponent_ProvideSameInterfaces(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeComponent_RequireSameInterfaces(compositeComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ProvideSameInterfaces constraint of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent_ProvideSameInterfaces(CompositeComponent compositeComponent, DiagnosticChain diagnostics, Map context) {
		return compositeComponent.ProvideSameInterfaces(diagnostics, context);
	}

	/**
	 * Validates the RequireSameInterfaces constraint of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent_RequireSameInterfaces(CompositeComponent compositeComponent, DiagnosticChain diagnostics, Map context) {
		return compositeComponent.RequireSameInterfaces(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeAssemblyConnector(CompositeAssemblyConnector compositeAssemblyConnector, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(compositeAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeAssemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(compositeAssemblyConnector, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent(BasicComponent basicComponent, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateBasicComponent_noSeffTypeUsedTwice(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateBasicComponent_ProvideSameInterfaces(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateBasicComponent_RequireSameInterfaces(basicComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noSeffTypeUsedTwice constraint of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent_noSeffTypeUsedTwice(BasicComponent basicComponent, DiagnosticChain diagnostics, Map context) {
		return basicComponent.noSeffTypeUsedTwice(diagnostics, context);
	}

	/**
	 * Validates the ProvideSameInterfaces constraint of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent_ProvideSameInterfaces(BasicComponent basicComponent, DiagnosticChain diagnostics, Map context) {
		return basicComponent.ProvideSameInterfaces(diagnostics, context);
	}

	/**
	 * Validates the RequireSameInterfaces constraint of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent_RequireSameInterfaces(BasicComponent basicComponent, DiagnosticChain diagnostics, Map context) {
		return basicComponent.RequireSameInterfaces(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidesComponentType(ProvidesComponentType providesComponentType, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(providesComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType constraint of '<em>Provides Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(ProvidesComponentType providesComponentType, DiagnosticChain diagnostics, Map context) {
		return providesComponentType.AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterModifier(ParameterModifier parameterModifier, DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //RepositoryValidator
