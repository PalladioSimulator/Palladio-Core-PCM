/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage
 * @generated
 */
public class SeffPerformanceValidator extends EObjectValidator {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final SeffPerformanceValidator INSTANCE = new SeffPerformanceValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.seff.seff_performance";

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signature
     * Must Belong To Used Required Role' of 'Infrastructure Call'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int INFRASTRUCTURE_CALL__SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Referenced
     * Required Role Must Be Required By Component' of 'Infrastructure Call'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int INFRASTRUCTURE_CALL__REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signature
     * Role Combination Must Be Unique Within Abstract Internal Control Flow Action' of
     * 'Infrastructure Call'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int INFRASTRUCTURE_CALL__SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Resource
     * Signature Belongs To Resource Required Role' of 'Resource Call'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int RESOURCE_CALL__RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE = 4;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Resource
     * Required Role Must Be Referenced By Component' of 'Resource Call'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT = 5;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signature
     * Role Combination Must Be Unique Within Abstract Internal Control Flow Action' of 'Resource
     * Call'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int RESOURCE_CALL__SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION = 6;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Demanded
     * Processing Resource Must Be Unique Within Abstract Internal Control Flow Action' of
     * 'Parametric Resource Demand'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PARAMETRIC_RESOURCE_DEMAND__DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION = 7;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 7;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SeffPerformanceValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return SeffPerformancePackage.eINSTANCE;
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL:
            return validateInfrastructureCall((InfrastructureCall) value, diagnostics, context);
        case SeffPerformancePackage.RESOURCE_CALL:
            return validateResourceCall((ResourceCall) value, diagnostics, context);
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND:
            return validateParametricResourceDemand((ParametricResourceDemand) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInfrastructureCall(InfrastructureCall infrastructureCall, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) infrastructureCall, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) infrastructureCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInfrastructureCall_SignatureMustBelongToUsedRequiredRole(infrastructureCall, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validateInfrastructureCall_ReferencedRequiredRoleMustBeRequiredByComponent(infrastructureCall,
                    diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInfrastructureCall_SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
                    infrastructureCall, diagnostics, context);
        return result;
    }

    /**
     * Validates the SignatureMustBelongToUsedRequiredRole constraint of '
     * <em>Infrastructure Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInfrastructureCall_SignatureMustBelongToUsedRequiredRole(
            InfrastructureCall infrastructureCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return infrastructureCall.SignatureMustBelongToUsedRequiredRole(diagnostics, context);
    }

    /**
     * Validates the ReferencedRequiredRoleMustBeRequiredByComponent constraint of '
     * <em>Infrastructure Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInfrastructureCall_ReferencedRequiredRoleMustBeRequiredByComponent(
            InfrastructureCall infrastructureCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return infrastructureCall.ReferencedRequiredRoleMustBeRequiredByComponent(diagnostics, context);
    }

    /**
     * Validates the SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction
     * constraint of '<em>Infrastructure Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInfrastructureCall_SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
            InfrastructureCall infrastructureCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return infrastructureCall.SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
                diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateResourceCall(ResourceCall resourceCall, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) resourceCall, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) resourceCall, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateResourceCall_ResourceSignatureBelongsToResourceRequiredRole(resourceCall, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validateResourceCall_ResourceRequiredRoleMustBeReferencedByComponent(resourceCall, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validateResourceCall_SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
                    resourceCall, diagnostics, context);
        return result;
    }

    /**
     * Validates the ResourceSignatureBelongsToResourceRequiredRole constraint of '
     * <em>Resource Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateResourceCall_ResourceSignatureBelongsToResourceRequiredRole(ResourceCall resourceCall,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return resourceCall.ResourceSignatureBelongsToResourceRequiredRole(diagnostics, context);
    }

    /**
     * Validates the ResourceRequiredRoleMustBeReferencedByComponent constraint of '
     * <em>Resource Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateResourceCall_ResourceRequiredRoleMustBeReferencedByComponent(ResourceCall resourceCall,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return resourceCall.ResourceRequiredRoleMustBeReferencedByComponent(diagnostics, context);
    }

    /**
     * Validates the SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction
     * constraint of '<em>Resource Call</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateResourceCall_SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
            ResourceCall resourceCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return resourceCall.SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(diagnostics,
                context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateParametricResourceDemand(ParametricResourceDemand parametricResourceDemand,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) parametricResourceDemand, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) parametricResourceDemand, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateParametricResourceDemand_DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(
                    parametricResourceDemand, diagnostics, context);
        return result;
    }

    /**
     * Validates the DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction
     * constraint of '<em>Parametric Resource Demand</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public boolean validateParametricResourceDemand_DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(
            ParametricResourceDemand parametricResourceDemand, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return parametricResourceDemand.DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(
                diagnostics, context);
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's
     * diagnostics. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} // SeffPerformanceValidator
