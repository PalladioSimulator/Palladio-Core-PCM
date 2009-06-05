/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory
 * @model kind="package"
 * @generated
 */
public interface StochasticsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stochastics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/Stochastics/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.core.stochastics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StochasticsPackage eINSTANCE = de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl <em>Random Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getRandomVariable()
	 * @generated
	 */
	int RANDOM_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Specification Random Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Random Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ExpressionImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ComparisonImpl <em>Comparison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ComparisonImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getComparison()
	 * @generated
	 */
	int COMPARISON = 2;

	/**
	 * The number of structural features of the '<em>Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.TermImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 3;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 4;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.PowerImpl <em>Power</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.PowerImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getPower()
	 * @generated
	 */
	int POWER = 5;

	/**
	 * The number of structural features of the '<em>Power</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_FEATURE_COUNT = PRODUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.AtomImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 6;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = POWER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ParantesisImpl <em>Parantesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ParantesisImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getParantesis()
	 * @generated
	 */
	int PARANTESIS = 8;

	/**
	 * The feature id for the '<em><b>Inner Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTESIS__INNER_EXPRESSION = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parantesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARANTESIS_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.NumericLiteralImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 9;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = ATOM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.IntLiteralImpl <em>Int Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.IntLiteralImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getIntLiteral()
	 * @generated
	 */
	int INT_LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.DoubleLiteralImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.CompareExpressionImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getCompareExpression()
	 * @generated
	 */
	int COMPARE_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__LEFT = COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__RIGHT = COMPARISON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__OPERATION = COMPARISON_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Compare Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION_FEATURE_COUNT = COMPARISON_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.TermExpressionImpl <em>Term Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.TermExpressionImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTermExpression()
	 * @generated
	 */
	int TERM_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_EXPRESSION__LEFT = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_EXPRESSION__RIGHT = TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_EXPRESSION__OPERATION = TERM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Term Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_EXPRESSION_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductExpressionImpl <em>Product Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductExpressionImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProductExpression()
	 * @generated
	 */
	int PRODUCT_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_EXPRESSION__LEFT = PRODUCT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_EXPRESSION__RIGHT = PRODUCT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_EXPRESSION__OPERATION = PRODUCT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Product Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_EXPRESSION_FEATURE_COUNT = PRODUCT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProbabilityFunctionLiteralImpl <em>Probability Function Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProbabilityFunctionLiteralImpl
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProbabilityFunctionLiteral()
	 * @generated
	 */
	int PROBABILITY_FUNCTION_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Function Probability Function Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Probability Function Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION_LITERAL_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations <em>Compare Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getCompareOperations()
	 * @generated
	 */
	int COMPARE_OPERATIONS = 16;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermOperations <em>Term Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermOperations
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTermOperations()
	 * @generated
	 */
	int TERM_OPERATIONS = 17;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations <em>Product Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProductOperations()
	 * @generated
	 */
	int PRODUCT_OPERATIONS = 18;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable <em>Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable
	 * @generated
	 */
	EClass getRandomVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification()
	 * @see #getRandomVariable()
	 * @generated
	 */
	EAttribute getRandomVariable_Specification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification_RandomVariable <em>Specification Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specification Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification_RandomVariable()
	 * @see #getRandomVariable()
	 * @generated
	 */
	EReference getRandomVariable_Specification_RandomVariable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Comparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Comparison
	 * @generated
	 */
	EClass getComparison();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Power <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Power
	 * @generated
	 */
	EClass getPower();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Variable#getId()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Id();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.Parantesis <em>Parantesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parantesis</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Parantesis
	 * @generated
	 */
	EClass getParantesis();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.Parantesis#getInnerExpression <em>Inner Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner Expression</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.Parantesis#getInnerExpression()
	 * @see #getParantesis()
	 * @generated
	 */
	EReference getParantesis_InnerExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral
	 * @generated
	 */
	EClass getIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral#getValue()
	 * @see #getIntLiteral()
	 * @generated
	 */
	EAttribute getIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression <em>Compare Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Expression</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression
	 * @generated
	 */
	EClass getCompareExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getLeft()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EReference getCompareExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getRight()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EReference getCompareExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression#getOperation()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EAttribute getCompareExpression_Operation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermExpression <em>Term Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Expression</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermExpression
	 * @generated
	 */
	EClass getTermExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getLeft()
	 * @see #getTermExpression()
	 * @generated
	 */
	EReference getTermExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getRight()
	 * @see #getTermExpression()
	 * @generated
	 */
	EReference getTermExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermExpression#getOperation()
	 * @see #getTermExpression()
	 * @generated
	 */
	EAttribute getTermExpression_Operation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression <em>Product Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Expression</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression
	 * @generated
	 */
	EClass getProductExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getLeft()
	 * @see #getProductExpression()
	 * @generated
	 */
	EReference getProductExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getRight()
	 * @see #getProductExpression()
	 * @generated
	 */
	EReference getProductExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getOperation()
	 * @see #getProductExpression()
	 * @generated
	 */
	EAttribute getProductExpression_Operation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral <em>Probability Function Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Function Literal</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral
	 * @generated
	 */
	EClass getProbabilityFunctionLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral <em>Function Probability Function Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function Probability Function Literal</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral()
	 * @see #getProbabilityFunctionLiteral()
	 * @generated
	 */
	EReference getProbabilityFunctionLiteral_Function_ProbabilityFunctionLiteral();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations <em>Compare Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compare Operations</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations
	 * @generated
	 */
	EEnum getCompareOperations();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermOperations <em>Term Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Term Operations</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermOperations
	 * @generated
	 */
	EEnum getTermOperations();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations <em>Product Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Product Operations</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations
	 * @generated
	 */
	EEnum getProductOperations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StochasticsFactory getStochasticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl <em>Random Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getRandomVariable()
		 * @generated
		 */
		EClass RANDOM_VARIABLE = eINSTANCE.getRandomVariable();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_VARIABLE__SPECIFICATION = eINSTANCE.getRandomVariable_Specification();

		/**
		 * The meta object literal for the '<em><b>Specification Random Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE = eINSTANCE.getRandomVariable_Specification_RandomVariable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ExpressionImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ComparisonImpl <em>Comparison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ComparisonImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getComparison()
		 * @generated
		 */
		EClass COMPARISON = eINSTANCE.getComparison();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.TermImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.PowerImpl <em>Power</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.PowerImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getPower()
		 * @generated
		 */
		EClass POWER = eINSTANCE.getPower();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.AtomImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__ID = eINSTANCE.getVariable_Id();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ParantesisImpl <em>Parantesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ParantesisImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getParantesis()
		 * @generated
		 */
		EClass PARANTESIS = eINSTANCE.getParantesis();

		/**
		 * The meta object literal for the '<em><b>Inner Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARANTESIS__INNER_EXPRESSION = eINSTANCE.getParantesis_InnerExpression();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.NumericLiteralImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.IntLiteralImpl <em>Int Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.IntLiteralImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getIntLiteral()
		 * @generated
		 */
		EClass INT_LITERAL = eINSTANCE.getIntLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.DoubleLiteralImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.CompareExpressionImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getCompareExpression()
		 * @generated
		 */
		EClass COMPARE_EXPRESSION = eINSTANCE.getCompareExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARE_EXPRESSION__LEFT = eINSTANCE.getCompareExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARE_EXPRESSION__RIGHT = eINSTANCE.getCompareExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_EXPRESSION__OPERATION = eINSTANCE.getCompareExpression_Operation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.TermExpressionImpl <em>Term Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.TermExpressionImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTermExpression()
		 * @generated
		 */
		EClass TERM_EXPRESSION = eINSTANCE.getTermExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_EXPRESSION__LEFT = eINSTANCE.getTermExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_EXPRESSION__RIGHT = eINSTANCE.getTermExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_EXPRESSION__OPERATION = eINSTANCE.getTermExpression_Operation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductExpressionImpl <em>Product Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProductExpressionImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProductExpression()
		 * @generated
		 */
		EClass PRODUCT_EXPRESSION = eINSTANCE.getProductExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_EXPRESSION__LEFT = eINSTANCE.getProductExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_EXPRESSION__RIGHT = eINSTANCE.getProductExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_EXPRESSION__OPERATION = eINSTANCE.getProductExpression_Operation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ProbabilityFunctionLiteralImpl <em>Probability Function Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.ProbabilityFunctionLiteralImpl
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProbabilityFunctionLiteral()
		 * @generated
		 */
		EClass PROBABILITY_FUNCTION_LITERAL = eINSTANCE.getProbabilityFunctionLiteral();

		/**
		 * The meta object literal for the '<em><b>Function Probability Function Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL = eINSTANCE.getProbabilityFunctionLiteral_Function_ProbabilityFunctionLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations <em>Compare Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getCompareOperations()
		 * @generated
		 */
		EEnum COMPARE_OPERATIONS = eINSTANCE.getCompareOperations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.TermOperations <em>Term Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.TermOperations
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getTermOperations()
		 * @generated
		 */
		EEnum TERM_OPERATIONS = eINSTANCE.getTermOperations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations <em>Product Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations
		 * @see de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getProductOperations()
		 * @generated
		 */
		EEnum PRODUCT_OPERATIONS = eINSTANCE.getProductOperations();

	}

} //StochasticsPackage
