/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import de.uka.ipd.sdq.stoex.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperations;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.CompareOperations;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoexFactoryImpl extends EFactoryImpl implements StoexFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoexFactory init() {
		try {
			StoexFactory theStoexFactory = (StoexFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/StochasticExpressions/1.0"); 
			if (theStoexFactory != null) {
				return theStoexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoexFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StoexPackage.VARIABLE_REFERENCE: return createVariableReference();
			case StoexPackage.NAMESPACE_REFERENCE: return createNamespaceReference();
			case StoexPackage.VARIABLE: return createVariable();
			case StoexPackage.TERM_EXPRESSION: return createTermExpression();
			case StoexPackage.PRODUCT_EXPRESSION: return createProductExpression();
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL: return createProbabilityFunctionLiteral();
			case StoexPackage.PARENTHESIS: return createParenthesis();
			case StoexPackage.INT_LITERAL: return createIntLiteral();
			case StoexPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case StoexPackage.COMPARE_EXPRESSION: return createCompareExpression();
			case StoexPackage.BOOL_LITERAL: return createBoolLiteral();
			case StoexPackage.STRING_LITERAL: return createStringLiteral();
			case StoexPackage.POWER_EXPRESSION: return createPowerExpression();
			case StoexPackage.BOOLEAN_OPERATOR_EXPRESSION: return createBooleanOperatorExpression();
			case StoexPackage.NOT_EXPRESSION: return createNotExpression();
			case StoexPackage.NEGATIVE_EXPRESSION: return createNegativeExpression();
			case StoexPackage.FUNCTION_LITERAL: return createFunctionLiteral();
			case StoexPackage.IF_ELSE_EXPRESSION: return createIfElseExpression();
			case StoexPackage.RANDOM_VARIABLE: return createRandomVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StoexPackage.TERM_OPERATIONS:
				return createTermOperationsFromString(eDataType, initialValue);
			case StoexPackage.PRODUCT_OPERATIONS:
				return createProductOperationsFromString(eDataType, initialValue);
			case StoexPackage.COMPARE_OPERATIONS:
				return createCompareOperationsFromString(eDataType, initialValue);
			case StoexPackage.BOOLEAN_OPERATIONS:
				return createBooleanOperationsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StoexPackage.TERM_OPERATIONS:
				return convertTermOperationsToString(eDataType, instanceValue);
			case StoexPackage.PRODUCT_OPERATIONS:
				return convertProductOperationsToString(eDataType, instanceValue);
			case StoexPackage.COMPARE_OPERATIONS:
				return convertCompareOperationsToString(eDataType, instanceValue);
			case StoexPackage.BOOLEAN_OPERATIONS:
				return convertBooleanOperationsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceReference createNamespaceReference() {
		NamespaceReferenceImpl namespaceReference = new NamespaceReferenceImpl();
		return namespaceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermExpression createTermExpression() {
		TermExpressionImpl termExpression = new TermExpressionImpl();
		return termExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomVariable createRandomVariable() {
		RandomVariableImpl randomVariable = new RandomVariableImpl();
		return randomVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductExpression createProductExpression() {
		ProductExpressionImpl productExpression = new ProductExpressionImpl();
		return productExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityFunctionLiteral createProbabilityFunctionLiteral() {
		ProbabilityFunctionLiteralImpl probabilityFunctionLiteral = new ProbabilityFunctionLiteralImpl();
		return probabilityFunctionLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parenthesis createParenthesis() {
		ParenthesisImpl parenthesis = new ParenthesisImpl();
		return parenthesis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntLiteral createIntLiteral() {
		IntLiteralImpl intLiteral = new IntLiteralImpl();
		return intLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareExpression createCompareExpression() {
		CompareExpressionImpl compareExpression = new CompareExpressionImpl();
		return compareExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolLiteral createBoolLiteral() {
		BoolLiteralImpl boolLiteral = new BoolLiteralImpl();
		return boolLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerExpression createPowerExpression() {
		PowerExpressionImpl powerExpression = new PowerExpressionImpl();
		return powerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOperatorExpression createBooleanOperatorExpression() {
		BooleanOperatorExpressionImpl booleanOperatorExpression = new BooleanOperatorExpressionImpl();
		return booleanOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegativeExpression createNegativeExpression() {
		NegativeExpressionImpl negativeExpression = new NegativeExpressionImpl();
		return negativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionLiteral createFunctionLiteral() {
		FunctionLiteralImpl functionLiteral = new FunctionLiteralImpl();
		return functionLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfElseExpression createIfElseExpression() {
		IfElseExpressionImpl ifElseExpression = new IfElseExpressionImpl();
		return ifElseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermOperations createTermOperationsFromString(EDataType eDataType, String initialValue) {
		TermOperations result = TermOperations.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTermOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductOperations createProductOperationsFromString(EDataType eDataType, String initialValue) {
		ProductOperations result = ProductOperations.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProductOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareOperations createCompareOperationsFromString(EDataType eDataType, String initialValue) {
		CompareOperations result = CompareOperations.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompareOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOperations createBooleanOperationsFromString(EDataType eDataType, String initialValue) {
		BooleanOperations result = BooleanOperations.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoexPackage getStoexPackage() {
		return (StoexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StoexPackage getPackage() {
		return StoexPackage.eINSTANCE;
	}

} //StoexFactoryImpl
