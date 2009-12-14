/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Constraint;
import de.uka.ipd.sdq.featuremodel.DefaultValue;
import de.uka.ipd.sdq.featuremodel.DisambiguationRule;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.FeatureState;
import de.uka.ipd.sdq.featuremodel.NamedElement;
import de.uka.ipd.sdq.featuremodel.ProhibitsConstraint;
import de.uka.ipd.sdq.featuremodel.RequiredConstraint;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

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
	public static final int FEATURE_GROUP__XO_ROR_OR_IMPLIES_CHILDREN_ARE_MANDATORY = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'ALL Implies Cardinalities To Be Minus One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__ALL_IMPLIES_CARDINALITIES_TO_BE_MINUS_ONE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'OR Implies Cardinalities Min To Be One And Max To Be Minus One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__OR_IMPLIES_CARDINALITIES_MIN_TO_BE_ONE_AND_MAX_TO_BE_MINUS_ONE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'XOR Implies Cardinalities To Be One' of 'Feature Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_GROUP__XOR_IMPLIES_CARDINALITIES_TO_BE_ONE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Child' of 'Simple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIMPLE__AT_LEAST_ONE_CHILD = 1;

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
	public featuremodelValidator() {
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
			case featuremodelPackage.DEFAULT_VALUE:
				return validateDefaultValue((DefaultValue)value, diagnostics, context);
			case featuremodelPackage.CHILD_RELATION:
				return validateChildRelation((ChildRelation)value, diagnostics, context);
			case featuremodelPackage.DISAMBIGUATION_RULE:
				return validateDisambiguationRule((DisambiguationRule)value, diagnostics, context);
			case featuremodelPackage.SIMPLE:
				return validateSimple((Simple)value, diagnostics, context);
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
			case featuremodelPackage.FEATURE_STATE:
				return validateFeatureState((FeatureState)value, diagnostics, context);
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
		boolean result = validate_EveryMultiplicityConforms(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(feature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(feature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(namedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(attribute, diagnostics, context);
		return result;
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
	public boolean validateDisambiguationRule(DisambiguationRule disambiguationRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(disambiguationRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultValue(DefaultValue defaultValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(defaultValue, diagnostics, context);
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
		boolean result = validate_EveryMultiplicityConforms(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(featureDiagram, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(constraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredConstraint(RequiredConstraint requiredConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProhibitsConstraint(ProhibitsConstraint prohibitsConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(prohibitsConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(prohibitsConstraint, diagnostics, context);
		return result;
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
	public boolean validateFeatureState(FeatureState featureState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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
