/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage
 * @generated
 */
public class Seff_reliabilityValidator extends EObjectValidator {
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
	public static final Seff_reliabilityValidator INSTANCE = new Seff_reliabilityValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.seff.seff_reliability";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Alternativesformachain' of 'Recovery Block Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECOVERY_BLOCK_ACTION__ALTERNATIVESFORMACHAIN = 1;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeffValidator seffValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seff_reliabilityValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
		seffValidator = SeffValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return Seff_reliabilityPackage.eINSTANCE;
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				return validateRecoveryBlockAlternativeBehaviour((RecoveryBlockAlternativeBehaviour)value, diagnostics, context);
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION:
				return validateRecoveryBlockAction((RecoveryBlockAction)value, diagnostics, context);
			case Seff_reliabilityPackage.FAILURE_HANDLING_ENTITY:
				return validateFailureHandlingEntity((FailureHandlingEntity)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecoveryBlockAlternativeBehaviour(RecoveryBlockAlternativeBehaviour recoveryBlockAlternativeBehaviour, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= seffValidator.validateResourceDemandingBehaviour_ExactlyOneStopAction(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= seffValidator.validateResourceDemandingBehaviour_ExactlyOneStartAction(recoveryBlockAlternativeBehaviour, diagnostics, context);
		if (result || diagnostics != null) result &= seffValidator.validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(recoveryBlockAlternativeBehaviour, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecoveryBlockAction(RecoveryBlockAction recoveryBlockAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(recoveryBlockAction, diagnostics, context);
		if (result || diagnostics != null) result &= validateRecoveryBlockAction_Alternativesformachain(recoveryBlockAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Alternativesformachain constraint of '<em>Recovery Block Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecoveryBlockAction_Alternativesformachain(RecoveryBlockAction recoveryBlockAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return recoveryBlockAction.Alternativesformachain(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFailureHandlingEntity(FailureHandlingEntity failureHandlingEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(failureHandlingEntity, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(failureHandlingEntity, diagnostics, context);
		return result;
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

} //Seff_reliabilityValidator
