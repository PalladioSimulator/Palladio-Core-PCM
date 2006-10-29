/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.impl;

import de.uka.ipd.sdq.pcm.core.stochastics.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StochasticsFactoryImpl extends EFactoryImpl implements StochasticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StochasticsFactory init() {
		try {
			StochasticsFactory theStochasticsFactory = (StochasticsFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/Core/Stochastics/1.0"); 
			if (theStochasticsFactory != null) {
				return theStochasticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StochasticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StochasticsPackage.RANDOM_VARIABLE: return createRandomVariable();
			case StochasticsPackage.VARIABLE: return createVariable();
			case StochasticsPackage.PARANTESIS: return createParantesis();
			case StochasticsPackage.INT_LITERAL: return createIntLiteral();
			case StochasticsPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case StochasticsPackage.COMPARE_EXPRESSION: return createCompareExpression();
			case StochasticsPackage.TERM_EXPRESSION: return createTermExpression();
			case StochasticsPackage.PRODUCT_EXPRESSION: return createProductExpression();
			case StochasticsPackage.PROBABILITY_FUNCTION_LITERAL: return createProbabilityFunctionLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StochasticsPackage.COMPARE_OPERATIONS:
				return createCompareOperationsFromString(eDataType, initialValue);
			case StochasticsPackage.TERM_OPERATIONS:
				return createTermOperationsFromString(eDataType, initialValue);
			case StochasticsPackage.PRODUCT_OPERATIONS:
				return createProductOperationsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StochasticsPackage.COMPARE_OPERATIONS:
				return convertCompareOperationsToString(eDataType, instanceValue);
			case StochasticsPackage.TERM_OPERATIONS:
				return convertTermOperationsToString(eDataType, instanceValue);
			case StochasticsPackage.PRODUCT_OPERATIONS:
				return convertProductOperationsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parantesis createParantesis() {
		ParantesisImpl parantesis = new ParantesisImpl();
		return parantesis;
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
	public TermExpression createTermExpression() {
		TermExpressionImpl termExpression = new TermExpressionImpl();
		return termExpression;
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
	public StochasticsPackage getStochasticsPackage() {
		return (StochasticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static StochasticsPackage getPackage() {
		return StochasticsPackage.eINSTANCE;
	}

} //StochasticsFactoryImpl
