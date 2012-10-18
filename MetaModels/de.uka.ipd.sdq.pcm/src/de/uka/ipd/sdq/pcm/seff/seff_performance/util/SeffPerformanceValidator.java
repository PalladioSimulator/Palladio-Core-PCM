/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage
 * @generated
 */
public class SeffPerformanceValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SeffPerformanceValidator INSTANCE = new SeffPerformanceValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.seff.seff_performance";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signature Must Belong To Used Required Role' of 'Infrastructure Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_CALL__SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Resource Signature Belongs To Resource Required Role' of 'Resource Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_CALL__RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

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
	public SeffPerformanceValidator() {
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
	  return SeffPerformancePackage.eINSTANCE;
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
			case SeffPerformancePackage.INFRASTRUCTURE_CALL:
				return validateInfrastructureCall((InfrastructureCall)value, diagnostics, context);
			case SeffPerformancePackage.RESOURCE_CALL:
				return validateResourceCall((ResourceCall)value, diagnostics, context);
			case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND:
				return validateParametricResourceDemand((ParametricResourceDemand)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureCall(InfrastructureCall infrastructureCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureCall, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureCall_SignatureMustBelongToUsedRequiredRole(infrastructureCall, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SignatureMustBelongToUsedRequiredRole constraint of '<em>Infrastructure Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureCall_SignatureMustBelongToUsedRequiredRole(InfrastructureCall infrastructureCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureCall.SignatureMustBelongToUsedRequiredRole(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceCall(ResourceCall resourceCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(resourceCall, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceCall_ResourceSignatureBelongsToResourceRequiredRole(resourceCall, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ResourceSignatureBelongsToResourceRequiredRole constraint of '<em>Resource Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceCall_ResourceSignatureBelongsToResourceRequiredRole(ResourceCall resourceCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceCall.ResourceSignatureBelongsToResourceRequiredRole(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParametricResourceDemand(ParametricResourceDemand parametricResourceDemand, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parametricResourceDemand, diagnostics, context);
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

} //SeffPerformanceValidator
