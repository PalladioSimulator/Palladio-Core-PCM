/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.util;

import de.uka.ipd.sdq.featuremodel.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage
 * @generated
 */
public class featuremodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final featuremodelValidator INSTANCE = new featuremodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.featuremodel";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'XO Ror OR Implies Children Are Mandatory' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__XO_ROR_OR_IMPLIES_CHILDREN_ARE_MANDATORY = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'ALL Implies Cardinalities To Be Minus One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__ALL_IMPLIES_CARDINALITIES_TO_BE_MINUS_ONE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'OR Implies Cardinalities Min To Be One And Max To Be Minus One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__OR_IMPLIES_CARDINALITIES_MIN_TO_BE_ONE_AND_MAX_TO_BE_MINUS_ONE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'XOR Implies Cardinalities To Be One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__XOR_IMPLIES_CARDINALITIES_TO_BE_ONE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Child' of 'Simple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIMPLE__AT_LEAST_ONE_CHILD = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

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
	public featuremodelValidator() {
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
	  return featuremodelPackage.eINSTANCE;
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
			case featuremodelPackage.FEATURE:
				return validateFeature((Feature)value, diagnostics, context);
			case featuremodelPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case featuremodelPackage.ATTRIBUTE:
				return validateAttribute((Attribute)value, diagnostics, context);
			case featuremodelPackage.CHILD_RELATION:
				return validateChildRelation((ChildRelation)value, diagnostics, context);
			case featuremodelPackage.FEATURE_GROUP:
				return validateFeatureGroup((FeatureGroup)value, diagnostics, context);
			case featuremodelPackage.FEATURE_DIAGRAM:
				return validateFeatureDiagram((FeatureDiagram)value, diagnostics, context);
			case featuremodelPackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case featuremodelPackage.REQUIRED_CONSTRAINT:
				return validateRequiredConstraint((RequiredConstraint)value, diagnostics, context);
			case featuremodelPackage.PROHIBITS_CONSTRAINT:
				return validateProhibitsConstraint((ProhibitsConstraint)value, diagnostics, context);
			case featuremodelPackage.SIMPLE:
				return validateSimple((Simple)value, diagnostics, context);
			case featuremodelPackage.ATTRIBUTE_TYPES:
				return validateAttributeTypes((AttributeTypes)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(feature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChildRelation(ChildRelation childRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(childRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup(FeatureGroup featureGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureGroup_XORorORImpliesChildrenAreMandatory(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureGroup_ALLImpliesCardinalitiesToBeMinusOne(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureGroup_ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne(featureGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureGroup_XORImpliesCardinalitiesToBeOne(featureGroup, diagnostics, context);
		return result;
	}

	/**
	 * Validates the XORorORImpliesChildrenAreMandatory constraint of '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup_XORorORImpliesChildrenAreMandatory(FeatureGroup featureGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureGroup.XORorORImpliesChildrenAreMandatory(diagnostics, context);
	}

	/**
	 * Validates the ALLImpliesCardinalitiesToBeMinusOne constraint of '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup_ALLImpliesCardinalitiesToBeMinusOne(FeatureGroup featureGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureGroup.ALLImpliesCardinalitiesToBeMinusOne(diagnostics, context);
	}

	/**
	 * Validates the ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne constraint of '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup_ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne(FeatureGroup featureGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureGroup.ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne(diagnostics, context);
	}

	/**
	 * Validates the XORImpliesCardinalitiesToBeOne constraint of '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup_XORImpliesCardinalitiesToBeOne(FeatureGroup featureGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureGroup.XORImpliesCardinalitiesToBeOne(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureDiagram(FeatureDiagram featureDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredConstraint(RequiredConstraint requiredConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requiredConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProhibitsConstraint(ProhibitsConstraint prohibitsConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(prohibitsConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimple(Simple simple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simple, diagnostics, context);
		if (result || diagnostics != null) result &= validateSimple_atLeastOneChild(simple, diagnostics, context);
		return result;
	}

	/**
	 * Validates the atLeastOneChild constraint of '<em>Simple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimple_atLeastOneChild(Simple simple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return simple.atLeastOneChild(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeTypes(AttributeTypes attributeTypes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //featuremodelValidator
