/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.util;

import de.fzi.se.controlflowdescription.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage
 * @generated
 */
public class ControlFlowDescriptionValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ControlFlowDescriptionValidator INSTANCE = new ControlFlowDescriptionValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.controlflowdescription";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Graph Must Be Defined If JJn Paths Present' of 'Control Flow Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTROL_FLOW_DESCRIPTION__GRAPH_MUST_BE_DEFINED_IF_JJN_PATHS_PRESENT = 1;

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
	public ControlFlowDescriptionValidator() {
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
	  return ControlFlowDescriptionPackage.eINSTANCE;
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION:
				return validateControlFlowDescription((ControlFlowDescription)value, diagnostics, context);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS:
				return validateControlFlowDescriptions((ControlFlowDescriptions)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlowDescription(ControlFlowDescription controlFlowDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(controlFlowDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateControlFlowDescription_GraphMustBeDefinedIfJJnPathsPresent(controlFlowDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the GraphMustBeDefinedIfJJnPathsPresent constraint of '<em>Control Flow Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlowDescription_GraphMustBeDefinedIfJJnPathsPresent(ControlFlowDescription controlFlowDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return controlFlowDescription.GraphMustBeDefinedIfJJnPathsPresent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlowDescriptions(ControlFlowDescriptions controlFlowDescriptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(controlFlowDescriptions, diagnostics, context);
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

} //ControlFlowDescriptionValidator
