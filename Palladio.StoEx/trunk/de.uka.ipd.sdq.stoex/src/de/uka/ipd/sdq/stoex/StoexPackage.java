/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;

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
 * @see de.uka.ipd.sdq.stoex.StoexFactory
 * @model kind="package"
 * @generated
 */
public interface StoexPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stoex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/StochasticExpressions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stoex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoexPackage eINSTANCE = de.uka.ipd.sdq.stoex.impl.StoexPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.AbstractNamedReferenceImpl <em>Abstract Named Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.AbstractNamedReferenceImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getAbstractNamedReference()
	 * @generated
	 */
	int ABSTRACT_NAMED_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMED_REFERENCE__REFERENCE_NAME = 0;

	/**
	 * The number of structural features of the '<em>Abstract Named Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMED_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.VariableReferenceImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__REFERENCE_NAME = ABSTRACT_NAMED_REFERENCE__REFERENCE_NAME;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = ABSTRACT_NAMED_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.NamespaceReferenceImpl <em>Namespace Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.NamespaceReferenceImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getNamespaceReference()
	 * @generated
	 */
	int NAMESPACE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_REFERENCE__REFERENCE_NAME = ABSTRACT_NAMED_REFERENCE__REFERENCE_NAME;

	/**
	 * The feature id for the '<em><b>Inner Reference Namespace Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_REFERENCE__INNER_REFERENCE_NAMESPACE_REFERENCE = ABSTRACT_NAMED_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Namespace Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_REFERENCE_FEATURE_COUNT = ABSTRACT_NAMED_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ExpressionImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 9;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ComparisonImpl <em>Comparison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ComparisonImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getComparison()
	 * @generated
	 */
	int COMPARISON = 8;

	/**
	 * The number of structural features of the '<em>Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.TermImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 7;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ProductImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 6;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.PowerImpl <em>Power</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.PowerImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getPower()
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.AtomImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 4;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = POWER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.VariableImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Id Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID_VARIABLE = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.TermExpressionImpl <em>Term Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.TermExpressionImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTermExpression()
	 * @generated
	 */
	int TERM_EXPRESSION = 10;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.RandomVariableImpl <em>Random Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.RandomVariableImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getRandomVariable()
	 * @generated
	 */
	int RANDOM_VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE__SPECIFICATION = 0;

	/**
	 * The number of structural features of the '<em>Random Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ProductExpressionImpl <em>Product Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ProductExpressionImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProductExpression()
	 * @generated
	 */
	int PRODUCT_EXPRESSION = 12;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ProbabilityFunctionLiteralImpl <em>Probability Function Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ProbabilityFunctionLiteralImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProbabilityFunctionLiteral()
	 * @generated
	 */
	int PROBABILITY_FUNCTION_LITERAL = 13;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.ParantesisImpl <em>Parantesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.ParantesisImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getParantesis()
	 * @generated
	 */
	int PARANTESIS = 14;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.NumericLiteralImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 15;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = ATOM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.IntLiteralImpl <em>Int Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.IntLiteralImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getIntLiteral()
	 * @generated
	 */
	int INT_LITERAL = 16;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.DoubleLiteralImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 17;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.impl.CompareExpressionImpl
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getCompareExpression()
	 * @generated
	 */
	int COMPARE_EXPRESSION = 18;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.TermOperations <em>Term Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.TermOperations
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTermOperations()
	 * @generated
	 */
	int TERM_OPERATIONS = 19;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.ProductOperations <em>Product Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.ProductOperations
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProductOperations()
	 * @generated
	 */
	int PRODUCT_OPERATIONS = 20;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.stoex.CompareOperations <em>Compare Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.stoex.CompareOperations
	 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getCompareOperations()
	 * @generated
	 */
	int COMPARE_OPERATIONS = 21;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see de.uka.ipd.sdq.stoex.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.AbstractNamedReference <em>Abstract Named Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Named Reference</em>'.
	 * @see de.uka.ipd.sdq.stoex.AbstractNamedReference
	 * @generated
	 */
	EClass getAbstractNamedReference();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.AbstractNamedReference#getReferenceName <em>Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Name</em>'.
	 * @see de.uka.ipd.sdq.stoex.AbstractNamedReference#getReferenceName()
	 * @see #getAbstractNamedReference()
	 * @generated
	 */
	EAttribute getAbstractNamedReference_ReferenceName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.NamespaceReference <em>Namespace Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace Reference</em>'.
	 * @see de.uka.ipd.sdq.stoex.NamespaceReference
	 * @generated
	 */
	EClass getNamespaceReference();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.NamespaceReference#getInnerReference_NamespaceReference <em>Inner Reference Namespace Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner Reference Namespace Reference</em>'.
	 * @see de.uka.ipd.sdq.stoex.NamespaceReference#getInnerReference_NamespaceReference()
	 * @see #getNamespaceReference()
	 * @generated
	 */
	EReference getNamespaceReference_InnerReference_NamespaceReference();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see de.uka.ipd.sdq.stoex.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.stoex.Variable#getId_Variable <em>Id Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Id Variable</em>'.
	 * @see de.uka.ipd.sdq.stoex.Variable#getId_Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Id_Variable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see de.uka.ipd.sdq.stoex.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Power <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power</em>'.
	 * @see de.uka.ipd.sdq.stoex.Power
	 * @generated
	 */
	EClass getPower();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see de.uka.ipd.sdq.stoex.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see de.uka.ipd.sdq.stoex.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Comparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison</em>'.
	 * @see de.uka.ipd.sdq.stoex.Comparison
	 * @generated
	 */
	EClass getComparison();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.uka.ipd.sdq.stoex.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.TermExpression <em>Term Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Expression</em>'.
	 * @see de.uka.ipd.sdq.stoex.TermExpression
	 * @generated
	 */
	EClass getTermExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.TermExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.stoex.TermExpression#getLeft()
	 * @see #getTermExpression()
	 * @generated
	 */
	EReference getTermExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.TermExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.stoex.TermExpression#getRight()
	 * @see #getTermExpression()
	 * @generated
	 */
	EReference getTermExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.TermExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.stoex.TermExpression#getOperation()
	 * @see #getTermExpression()
	 * @generated
	 */
	EAttribute getTermExpression_Operation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.RandomVariable <em>Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Variable</em>'.
	 * @see de.uka.ipd.sdq.stoex.RandomVariable
	 * @generated
	 */
	EClass getRandomVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.RandomVariable#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see de.uka.ipd.sdq.stoex.RandomVariable#getSpecification()
	 * @see #getRandomVariable()
	 * @generated
	 */
	EAttribute getRandomVariable_Specification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.ProductExpression <em>Product Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Expression</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProductExpression
	 * @generated
	 */
	EClass getProductExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.ProductExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProductExpression#getLeft()
	 * @see #getProductExpression()
	 * @generated
	 */
	EReference getProductExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.ProductExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProductExpression#getRight()
	 * @see #getProductExpression()
	 * @generated
	 */
	EReference getProductExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.ProductExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProductExpression#getOperation()
	 * @see #getProductExpression()
	 * @generated
	 */
	EAttribute getProductExpression_Operation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral <em>Probability Function Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Function Literal</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral
	 * @generated
	 */
	EClass getProbabilityFunctionLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral <em>Function Probability Function Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function Probability Function Literal</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral()
	 * @see #getProbabilityFunctionLiteral()
	 * @generated
	 */
	EReference getProbabilityFunctionLiteral_Function_ProbabilityFunctionLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.Parantesis <em>Parantesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parantesis</em>'.
	 * @see de.uka.ipd.sdq.stoex.Parantesis
	 * @generated
	 */
	EClass getParantesis();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.Parantesis#getInnerExpression <em>Inner Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner Expression</em>'.
	 * @see de.uka.ipd.sdq.stoex.Parantesis#getInnerExpression()
	 * @see #getParantesis()
	 * @generated
	 */
	EReference getParantesis_InnerExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see de.uka.ipd.sdq.stoex.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal</em>'.
	 * @see de.uka.ipd.sdq.stoex.IntLiteral
	 * @generated
	 */
	EClass getIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.IntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.stoex.IntLiteral#getValue()
	 * @see #getIntLiteral()
	 * @generated
	 */
	EAttribute getIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see de.uka.ipd.sdq.stoex.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.stoex.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.stoex.CompareExpression <em>Compare Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Expression</em>'.
	 * @see de.uka.ipd.sdq.stoex.CompareExpression
	 * @generated
	 */
	EClass getCompareExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.CompareExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see de.uka.ipd.sdq.stoex.CompareExpression#getLeft()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EReference getCompareExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.stoex.CompareExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see de.uka.ipd.sdq.stoex.CompareExpression#getRight()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EReference getCompareExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.stoex.CompareExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.stoex.CompareExpression#getOperation()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EAttribute getCompareExpression_Operation();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.stoex.TermOperations <em>Term Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Term Operations</em>'.
	 * @see de.uka.ipd.sdq.stoex.TermOperations
	 * @generated
	 */
	EEnum getTermOperations();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.stoex.ProductOperations <em>Product Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Product Operations</em>'.
	 * @see de.uka.ipd.sdq.stoex.ProductOperations
	 * @generated
	 */
	EEnum getProductOperations();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.stoex.CompareOperations <em>Compare Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compare Operations</em>'.
	 * @see de.uka.ipd.sdq.stoex.CompareOperations
	 * @generated
	 */
	EEnum getCompareOperations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoexFactory getStoexFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.VariableReferenceImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.AbstractNamedReferenceImpl <em>Abstract Named Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.AbstractNamedReferenceImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getAbstractNamedReference()
		 * @generated
		 */
		EClass ABSTRACT_NAMED_REFERENCE = eINSTANCE.getAbstractNamedReference();

		/**
		 * The meta object literal for the '<em><b>Reference Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NAMED_REFERENCE__REFERENCE_NAME = eINSTANCE.getAbstractNamedReference_ReferenceName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.NamespaceReferenceImpl <em>Namespace Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.NamespaceReferenceImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getNamespaceReference()
		 * @generated
		 */
		EClass NAMESPACE_REFERENCE = eINSTANCE.getNamespaceReference();

		/**
		 * The meta object literal for the '<em><b>Inner Reference Namespace Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE_REFERENCE__INNER_REFERENCE_NAMESPACE_REFERENCE = eINSTANCE.getNamespaceReference_InnerReference_NamespaceReference();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.VariableImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Id Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__ID_VARIABLE = eINSTANCE.getVariable_Id_Variable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.AtomImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.PowerImpl <em>Power</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.PowerImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getPower()
		 * @generated
		 */
		EClass POWER = eINSTANCE.getPower();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ProductImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.TermImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ComparisonImpl <em>Comparison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ComparisonImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getComparison()
		 * @generated
		 */
		EClass COMPARISON = eINSTANCE.getComparison();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ExpressionImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.TermExpressionImpl <em>Term Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.TermExpressionImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTermExpression()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.RandomVariableImpl <em>Random Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.RandomVariableImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getRandomVariable()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ProductExpressionImpl <em>Product Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ProductExpressionImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProductExpression()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ProbabilityFunctionLiteralImpl <em>Probability Function Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ProbabilityFunctionLiteralImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProbabilityFunctionLiteral()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.ParantesisImpl <em>Parantesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.ParantesisImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getParantesis()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.NumericLiteralImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.IntLiteralImpl <em>Int Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.IntLiteralImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getIntLiteral()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.DoubleLiteralImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getDoubleLiteral()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.impl.CompareExpressionImpl
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getCompareExpression()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.TermOperations <em>Term Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.TermOperations
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getTermOperations()
		 * @generated
		 */
		EEnum TERM_OPERATIONS = eINSTANCE.getTermOperations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.ProductOperations <em>Product Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.ProductOperations
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getProductOperations()
		 * @generated
		 */
		EEnum PRODUCT_OPERATIONS = eINSTANCE.getProductOperations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.stoex.CompareOperations <em>Compare Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.stoex.CompareOperations
		 * @see de.uka.ipd.sdq.stoex.impl.StoexPackageImpl#getCompareOperations()
		 * @generated
		 */
		EEnum COMPARE_OPERATIONS = eINSTANCE.getCompareOperations();

	}

} //StoexPackage
