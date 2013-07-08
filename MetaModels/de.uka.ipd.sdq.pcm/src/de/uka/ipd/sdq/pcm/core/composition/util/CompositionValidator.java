/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.core.composition.*;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.DelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage
 * @generated
 */
public class CompositionValidator extends EObjectValidator {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final CompositionValidator INSTANCE = new CompositionValidator();

    /**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
    public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.core.composition";

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int PROVIDED_DELEGATION_CONNECTOR__PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE = 3;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Component Of Assembly Context And Inner Role Providing Component Need To Be The Same' of 'Provided Delegation Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int PROVIDED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME = 4;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Required Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int REQUIRED_DELEGATION_CONNECTOR__REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE = 5;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Component Of Assembly Context And Inner Role Requiring Component Need To Be The Same' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME = 6;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Requiring Entity Of Outer Required Role Must Be The Same As The Parent Of The Required Delegation Connector' of 'Required Delegation Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int REQUIRED_DELEGATION_CONNECTOR__REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR = 7;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assembly Connectors Referenced Provided Roles And Child Context Must Match' of 'Assembly Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH = 8;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assembly Connectors Referenced Required Role And Child Context Must Match' of 'Assembly Connector'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH = 9;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assembly Connectors Referenced Interfaces Must Match' of 'Assembly Connector'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final int ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH = 10;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Multiple Connectors Constraint' of 'Composed Structure'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT = 1;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Multiple Connectors Constraint For Assembly Connectors' of 'Composed Structure'.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS = 2;

    /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 10;

    /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected IdentifierValidator identifierValidator;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CompositionValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

    /**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EPackage getEPackage() {
	  return CompositionPackage.eINSTANCE;
	}

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case CompositionPackage.DELEGATION_CONNECTOR:
				return validateDelegationConnector((DelegationConnector)value, diagnostics, context);
			case CompositionPackage.CONNECTOR:
				return validateConnector((Connector)value, diagnostics, context);
			case CompositionPackage.COMPOSED_STRUCTURE:
				return validateComposedStructure((ComposedStructure)value, diagnostics, context);
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return validateResourceRequiredDelegationConnector((ResourceRequiredDelegationConnector)value, diagnostics, context);
			case CompositionPackage.EVENT_CHANNEL:
				return validateEventChannel((EventChannel)value, diagnostics, context);
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR:
				return validateEventChannelSourceConnector((EventChannelSourceConnector)value, diagnostics, context);
			case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR:
				return validateEventChannelSinkConnector((EventChannelSinkConnector)value, diagnostics, context);
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR:
				return validateProvidedDelegationConnector((ProvidedDelegationConnector)value, diagnostics, context);
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR:
				return validateRequiredDelegationConnector((RequiredDelegationConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONNECTOR:
				return validateAssemblyConnector((AssemblyConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR:
				return validateAssemblyEventConnector((AssemblyEventConnector)value, diagnostics, context);
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR:
				return validateSourceDelegationConnector((SourceDelegationConnector)value, diagnostics, context);
			case CompositionPackage.SINK_DELEGATION_CONNECTOR:
				return validateSinkDelegationConnector((SinkDelegationConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
				return validateAssemblyInfrastructureConnector((AssemblyInfrastructureConnector)value, diagnostics, context);
			case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
				return validateProvidedInfrastructureDelegationConnector((ProvidedInfrastructureDelegationConnector)value, diagnostics, context);
			case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
				return validateRequiredInfrastructureDelegationConnector((RequiredInfrastructureDelegationConnector)value, diagnostics, context);
			case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
				return validateRequiredResourceDelegationConnector((RequiredResourceDelegationConnector)value, diagnostics, context);
			case CompositionPackage.ASSEMBLY_CONTEXT:
				return validateAssemblyContext((AssemblyContext)value, diagnostics, context);
			default:
				return true;
		}
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateDelegationConnector(DelegationConnector delegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(delegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(delegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(delegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateConnector(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(connector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(connector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidedDelegationConnector(ProvidedDelegationConnector providedDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(providedDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(providedDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidedDelegationConnector_ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(providedDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * Validates the ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidedDelegationConnector_ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(
            ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return providedDelegationConnector.ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(diagnostics, context);
	}

    /**
	 * Validates the ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame constraint of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidedDelegationConnector_ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(
            ProvidedDelegationConnector providedDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return providedDelegationConnector.ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyContext(AssemblyContext assemblyContext, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assemblyContext, diagnostics, context)) return false;
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
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredDelegationConnector(RequiredDelegationConnector requiredDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(requiredDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(requiredDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredDelegationConnector_RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(requiredDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * Validates the RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredDelegationConnector_RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(
            RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return requiredDelegationConnector.RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(diagnostics, context);
	}

    /**
	 * Validates the ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredDelegationConnector_ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(
            RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return requiredDelegationConnector.ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(diagnostics, context);
	}

    /**
	 * Validates the RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector constraint of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredDelegationConnector_RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(
            RequiredDelegationConnector requiredDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return requiredDelegationConnector.RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyConnector(AssemblyConnector assemblyConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assemblyConnector, diagnostics, context)) return false;
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
		if (result || diagnostics != null) result &= validateAssemblyConnector_AssemblyConnectorsReferencedInterfacesMustMatch(assemblyConnector, diagnostics, context);
		return result;
	}

    /**
	 * Validates the AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch constraint of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyConnector_AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(
            AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assemblyConnector.AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(diagnostics, context);
	}

    /**
	 * Validates the AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch constraint of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyConnector_AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(
            AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assemblyConnector.AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(diagnostics, context);
	}

    /**
	 * Validates the AssemblyConnectorsReferencedInterfacesMustMatch constraint of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyConnector_AssemblyConnectorsReferencedInterfacesMustMatch(
            AssemblyConnector assemblyConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assemblyConnector.AssemblyConnectorsReferencedInterfacesMustMatch(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateResourceRequiredDelegationConnector(
            ResourceRequiredDelegationConnector resourceRequiredDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceRequiredDelegationConnector, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateEventChannel(EventChannel eventChannel, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventChannel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventChannel, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(eventChannel, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyEventConnector(AssemblyEventConnector assemblyEventConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assemblyEventConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assemblyEventConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyEventConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateSourceDelegationConnector(SourceDelegationConnector sourceDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(sourceDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateSinkDelegationConnector(SinkDelegationConnector sinkDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sinkDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sinkDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(sinkDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateAssemblyInfrastructureConnector(
            AssemblyInfrastructureConnector assemblyInfrastructureConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assemblyInfrastructureConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assemblyInfrastructureConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(assemblyInfrastructureConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredInfrastructureDelegationConnector(
            RequiredInfrastructureDelegationConnector requiredInfrastructureDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(requiredInfrastructureDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredInfrastructureDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidedInfrastructureDelegationConnector(
            ProvidedInfrastructureDelegationConnector providedInfrastructureDelegationConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(providedInfrastructureDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(providedInfrastructureDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedInfrastructureDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredResourceDelegationConnector(
            RequiredResourceDelegationConnector requiredResourceDelegationConnector, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(requiredResourceDelegationConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredResourceDelegationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredResourceDelegationConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateEventChannelSinkConnector(EventChannelSinkConnector eventChannelSinkConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventChannelSinkConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventChannelSinkConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(eventChannelSinkConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateEventChannelSourceConnector(EventChannelSourceConnector eventChannelSourceConnector,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventChannelSourceConnector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventChannelSourceConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(eventChannelSourceConnector, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateComposedStructure(ComposedStructure composedStructure, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(composedStructure, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedStructure_MultipleConnectorsConstraint(composedStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedStructure_MultipleConnectorsConstraintForAssemblyConnectors(composedStructure, diagnostics, context);
		return result;
	}

    /**
     * Validates the MultipleConnectorsConstraint constraint of '<em>Composed Structure</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateComposedStructure_MultipleConnectorsConstraint(ComposedStructure composedStructure,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		return composedStructure.MultipleConnectorsConstraint(diagnostics, context);
	}

    /**
	 * Validates the MultipleConnectorsConstraintForAssemblyConnectors constraint of '<em>Composed Structure</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateComposedStructure_MultipleConnectorsConstraintForAssemblyConnectors(
            ComposedStructure composedStructure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return composedStructure.MultipleConnectorsConstraintForAssemblyConnectors(diagnostics, context);
	}

} // CompositionValidator
