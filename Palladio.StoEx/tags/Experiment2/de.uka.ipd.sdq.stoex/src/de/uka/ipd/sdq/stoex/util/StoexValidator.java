/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.util;

import de.uka.ipd.sdq.stoex.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.stoex.StoexPackage
 * @generated
 */
public class StoexValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StoexValidator INSTANCE = new StoexValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.stoex";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Specification Must Not Be NULL' of 'Random Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANDOM_VARIABLE__SPECIFICATION_MUST_NOT_BE_NULL = 1;

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
	public StoexValidator() {
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
	  return StoexPackage.eINSTANCE;
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
			case StoexPackage.VARIABLE_REFERENCE:
				return validateVariableReference((VariableReference)value, diagnostics, context);
			case StoexPackage.ABSTRACT_NAMED_REFERENCE:
				return validateAbstractNamedReference((AbstractNamedReference)value, diagnostics, context);
			case StoexPackage.NAMESPACE_REFERENCE:
				return validateNamespaceReference((NamespaceReference)value, diagnostics, context);
			case StoexPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case StoexPackage.ATOM:
				return validateAtom((Atom)value, diagnostics, context);
			case StoexPackage.UNARY:
				return validateUnary((Unary)value, diagnostics, context);
			case StoexPackage.POWER:
				return validatePower((Power)value, diagnostics, context);
			case StoexPackage.PRODUCT:
				return validateProduct((Product)value, diagnostics, context);
			case StoexPackage.TERM:
				return validateTerm((Term)value, diagnostics, context);
			case StoexPackage.COMPARISON:
				return validateComparison((Comparison)value, diagnostics, context);
			case StoexPackage.BOOLEAN_EXPRESSION:
				return validateBooleanExpression((BooleanExpression)value, diagnostics, context);
			case StoexPackage.IF_ELSE:
				return validateIfElse((IfElse)value, diagnostics, context);
			case StoexPackage.EXPRESSION:
				return validateExpression((Expression)value, diagnostics, context);
			case StoexPackage.TERM_EXPRESSION:
				return validateTermExpression((TermExpression)value, diagnostics, context);
			case StoexPackage.RANDOM_VARIABLE:
				return validateRandomVariable((RandomVariable)value, diagnostics, context);
			case StoexPackage.PRODUCT_EXPRESSION:
				return validateProductExpression((ProductExpression)value, diagnostics, context);
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL:
				return validateProbabilityFunctionLiteral((ProbabilityFunctionLiteral)value, diagnostics, context);
			case StoexPackage.PARENTHESIS:
				return validateParenthesis((Parenthesis)value, diagnostics, context);
			case StoexPackage.NUMERIC_LITERAL:
				return validateNumericLiteral((NumericLiteral)value, diagnostics, context);
			case StoexPackage.INT_LITERAL:
				return validateIntLiteral((IntLiteral)value, diagnostics, context);
			case StoexPackage.DOUBLE_LITERAL:
				return validateDoubleLiteral((DoubleLiteral)value, diagnostics, context);
			case StoexPackage.COMPARE_EXPRESSION:
				return validateCompareExpression((CompareExpression)value, diagnostics, context);
			case StoexPackage.BOOL_LITERAL:
				return validateBoolLiteral((BoolLiteral)value, diagnostics, context);
			case StoexPackage.STRING_LITERAL:
				return validateStringLiteral((StringLiteral)value, diagnostics, context);
			case StoexPackage.POWER_EXPRESSION:
				return validatePowerExpression((PowerExpression)value, diagnostics, context);
			case StoexPackage.BOOLEAN_OPERATOR_EXPRESSION:
				return validateBooleanOperatorExpression((BooleanOperatorExpression)value, diagnostics, context);
			case StoexPackage.NOT_EXPRESSION:
				return validateNotExpression((NotExpression)value, diagnostics, context);
			case StoexPackage.NEGATIVE_EXPRESSION:
				return validateNegativeExpression((NegativeExpression)value, diagnostics, context);
			case StoexPackage.FUNCTION_LITERAL:
				return validateFunctionLiteral((FunctionLiteral)value, diagnostics, context);
			case StoexPackage.IF_ELSE_EXPRESSION:
				return validateIfElseExpression((IfElseExpression)value, diagnostics, context);
			case StoexPackage.TERM_OPERATIONS:
				return validateTermOperations((TermOperations)value, diagnostics, context);
			case StoexPackage.PRODUCT_OPERATIONS:
				return validateProductOperations((ProductOperations)value, diagnostics, context);
			case StoexPackage.COMPARE_OPERATIONS:
				return validateCompareOperations((CompareOperations)value, diagnostics, context);
			case StoexPackage.BOOLEAN_OPERATIONS:
				return validateBooleanOperations((BooleanOperations)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableReference(VariableReference variableReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractNamedReference(AbstractNamedReference abstractNamedReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractNamedReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceReference(NamespaceReference namespaceReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namespaceReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAtom(Atom atom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(atom, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnary(Unary unary, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unary, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePower(Power power, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(power, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProduct(Product product, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(product, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTerm(Term term, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(term, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComparison(Comparison comparison, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(comparison, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanExpression(BooleanExpression booleanExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfElse(IfElse ifElse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ifElse, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTermExpression(TermExpression termExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(termExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRandomVariable(RandomVariable randomVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(randomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateRandomVariable_SpecificationMustNotBeNULL(randomVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SpecificationMustNotBeNULL constraint of '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRandomVariable_SpecificationMustNotBeNULL(RandomVariable randomVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return randomVariable.SpecificationMustNotBeNULL(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProductExpression(ProductExpression productExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(productExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbabilityFunctionLiteral(ProbabilityFunctionLiteral probabilityFunctionLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(probabilityFunctionLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParenthesis(Parenthesis parenthesis, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parenthesis, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteral(NumericLiteral numericLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numericLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntLiteral(IntLiteral intLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleLiteral(DoubleLiteral doubleLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(doubleLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompareExpression(CompareExpression compareExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compareExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoolLiteral(BoolLiteral boolLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(boolLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePowerExpression(PowerExpression powerExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(powerExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanOperatorExpression(BooleanOperatorExpression booleanOperatorExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanOperatorExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNotExpression(NotExpression notExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(notExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNegativeExpression(NegativeExpression negativeExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(negativeExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionLiteral(FunctionLiteral functionLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(functionLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfElseExpression(IfElseExpression ifElseExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ifElseExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTermOperations(TermOperations termOperations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProductOperations(ProductOperations productOperations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompareOperations(CompareOperations compareOperations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanOperations(BooleanOperations booleanOperations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

} //StoexValidator
