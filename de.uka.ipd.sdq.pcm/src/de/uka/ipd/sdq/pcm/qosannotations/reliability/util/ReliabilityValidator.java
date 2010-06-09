/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.reliability.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedFailureProbability;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage
 * @generated
 */
public class ReliabilityValidator extends EObjectValidator {
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
	public static final ReliabilityValidator INSTANCE = new ReliabilityValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.qosannotations.reliability";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Ensure Valid Parameter Range' of 'Specified Failure Probability'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SPECIFIED_FAILURE_PROBABILITY__ENSURE_VALID_PARAMETER_RANGE = 1;

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
	public ReliabilityValidator() {
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
	  return ReliabilityPackage.eINSTANCE;
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
			case ReliabilityPackage.SPECIFIED_FAILURE_PROBABILITY:
				return validateSpecifiedFailureProbability((SpecifiedFailureProbability)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecifiedFailureProbability(SpecifiedFailureProbability specifiedFailureProbability, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(specifiedFailureProbability, diagnostics, context);
		if (result || diagnostics != null) result &= validateSpecifiedFailureProbability_EnsureValidParameterRange(specifiedFailureProbability, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EnsureValidParameterRange constraint of '<em>Specified Failure Probability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecifiedFailureProbability_EnsureValidParameterRange(SpecifiedFailureProbability specifiedFailureProbability, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return specifiedFailureProbability.EnsureValidParameterRange(diagnostics, context);
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

} //ReliabilityValidator
