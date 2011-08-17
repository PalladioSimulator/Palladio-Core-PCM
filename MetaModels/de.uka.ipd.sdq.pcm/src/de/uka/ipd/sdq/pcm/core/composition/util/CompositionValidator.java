/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.core.composition.*;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;

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
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Component Of Child Component Context And Inner Role Providing Component Need To Be The Same' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDED_DELEGATION_CONNECTOR__COMPONENT_OF_CHILD_COMPONENT_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Required Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Component Of Child Component Context And Inner Role Requiring Component Need To Be The Same' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_CHILD_COMPONENT_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assembly Connectors Referenced Provided Roles And Child Context Must Match' of 'Assembly Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assembly Connectors Referenced Required Role And Child Context Must Match' of 'Assembly Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Resource Required Delegation Connector And The Connected Component Must Be Part Of The Same Composite Structure' of 'Resource Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_REQUIRED_DELEGATION_CONNECTOR__RESOURCE_REQUIRED_DELEGATION_CONNECTOR_AND_THE_CONNECTED_COMPONENT_MUST_BE_PART_OF_THE_SAME_COMPOSITE_STRUCTURE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Component Of Child Component Context And Inner Role Resource Requiring Component Need To Be The Same' of 'Resource Required Delegation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_CHILD_COMPONENT_CONTEXT_AND_INNER_ROLE_RESOURCE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME = 8;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 8;

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
	@Override
	protected EPackage getEPackage() {
	  return CompositionPackage.eINSTANCE;
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR:
				return validateProvidedDelegationConnector((ProvidedDelegationConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONTEXT:
				return validateAssemblyContext((AssemblyContext)value, diagnostics, context);
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR:
				return validateRequiredDelegationConnector((RequiredDelegationConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONNECTOR:
				return validateAssemblyConnector((AssemblyConnector)value, diagnostics, context);
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return validateResourceRequiredDelegationConnector((ResourceRequiredDelegationConnector)value, diagnostics, context);
			case CompositionPackage.COMPOSED_STRUCTURE:
				return validateComposedStructure((ComposedStructure)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_ComponentOfChildComponentContextAndInnerRoleProvidingComponentNeedToBeTheSame(providedDelegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector_ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return providedDelegationConnector.ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(diagnostics, context);
	}

	/**
	 * Validates the ComponentOfChildComponentContextAndInnerRoleProvidingComponentNeedToBeTheSame constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedDelegationConnector_ComponentOfChildComponentContextAndInnerRoleProvidingComponentNeedToBeTheSame(ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return providedDelegationConnector.ComponentOfChildComponentContextAndInnerRoleProvidingComponentNeedToBeTheSame(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssemblyContext(AssemblyContext assemblyContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assemblyContext, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyContext, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_ComponentOfChildComponentContextAndInnerRoleRequiringComponentNeedToBeTheSame(requiredDelegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector_RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return requiredDelegationConnector.RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(diagnostics, context);
	}

	/**
	 * Validates the ComponentOfChildComponentContextAndInnerRoleRequiringComponentNeedToBeTheSame constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredDelegationConnector_ComponentOfChildComponentContextAndInnerRoleRequiringComponentNeedToBeTheSame(RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return requiredDelegationConnector.ComponentOfChildComponentContextAndInnerRoleRequiringComponentNeedToBeTheSame(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssemblyConnector(AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssemblyConnector_AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(assemblyConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssemblyConnector_AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(assemblyConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch constraint of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssemblyConnector_AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assemblyConnector.AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(diagnostics, context);
	}

	/**
	 * Validates the AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch constraint of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssemblyConnector_AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assemblyConnector.AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceRequiredDelegationConnector(ResourceRequiredDelegationConnector resourceRequiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceRequiredDelegationConnector_ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure(resourceRequiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceRequiredDelegationConnector_ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame(resourceRequiredDelegationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure constraint of '<em>Resource Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceRequiredDelegationConnector_ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure(ResourceRequiredDelegationConnector resourceRequiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceRequiredDelegationConnector.ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure(diagnostics, context);
	}

	/**
	 * Validates the ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame constraint of '<em>Resource Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceRequiredDelegationConnector_ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame(ResourceRequiredDelegationConnector resourceRequiredDelegationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceRequiredDelegationConnector.ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComposedStructure(ComposedStructure composedStructure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(composedStructure, diagnostics, context);
		return result;
	}

} //CompositionValidator
