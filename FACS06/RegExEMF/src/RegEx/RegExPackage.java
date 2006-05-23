/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see RegEx.RegExFactory
 * @model kind="package"
 * @generated
 */
public interface RegExPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RegEx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "null";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "null";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RegExPackage eINSTANCE = RegEx.impl.RegExPackageImpl.init();

	/**
	 * The meta object id for the '{@link RegEx.Expression <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.Expression
	 * @see RegEx.impl.RegExPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__DISTRIBUTION_FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__DISTRIBUTION_FUNCTION_FREQ = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link RegEx.impl.SymbolImpl <em>Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.SymbolImpl
	 * @see RegEx.impl.RegExPackageImpl#getSymbol()
	 * @generated
	 */
	int SYMBOL = 1;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__DISTRIBUTION_FUNCTION = EXPRESSION__DISTRIBUTION_FUNCTION;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__DISTRIBUTION_FUNCTION_FREQ = EXPRESSION__DISTRIBUTION_FUNCTION_FREQ;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link RegEx.impl.AlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.AlternativeImpl
	 * @see RegEx.impl.RegExPackageImpl#getAlternative()
	 * @generated
	 */
	int ALTERNATIVE = 2;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__DISTRIBUTION_FUNCTION = EXPRESSION__DISTRIBUTION_FUNCTION;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ = EXPRESSION__DISTRIBUTION_FUNCTION_FREQ;

	/**
	 * The feature id for the '<em><b>Alt One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__ALT_ONE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alt Two</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__ALT_TWO = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prob One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__PROB_ONE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prob Two</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__PROB_TWO = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link RegEx.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.SequenceImpl
	 * @see RegEx.impl.RegExPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__DISTRIBUTION_FUNCTION = EXPRESSION__DISTRIBUTION_FUNCTION;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__DISTRIBUTION_FUNCTION_FREQ = EXPRESSION__DISTRIBUTION_FUNCTION_FREQ;

	/**
	 * The feature id for the '<em><b>Pre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__PRE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Post</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__POST = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link RegEx.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.LoopImpl
	 * @see RegEx.impl.RegExPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 4;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__DISTRIBUTION_FUNCTION = EXPRESSION__DISTRIBUTION_FUNCTION;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__DISTRIBUTION_FUNCTION_FREQ = EXPRESSION__DISTRIBUTION_FUNCTION_FREQ;

	/**
	 * The feature id for the '<em><b>Inner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__INNER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reiteration Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__REITERATION_DISTRIBUTION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link RegEx.impl.ParallelImpl <em>Parallel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.ParallelImpl
	 * @see RegEx.impl.RegExPackageImpl#getParallel()
	 * @generated
	 */
	int PARALLEL = 5;

	/**
	 * The feature id for the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__DISTRIBUTION_FUNCTION = EXPRESSION__DISTRIBUTION_FUNCTION;

	/**
	 * The feature id for the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__DISTRIBUTION_FUNCTION_FREQ = EXPRESSION__DISTRIBUTION_FUNCTION_FREQ;

	/**
	 * The feature id for the '<em><b>Task One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__TASK_ONE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task Two</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__TASK_TWO = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parallel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link RegEx.impl.DistributionFunctionImpl <em>Distribution Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.DistributionFunctionImpl
	 * @see RegEx.impl.RegExPackageImpl#getDistributionFunction()
	 * @generated
	 */
	int DISTRIBUTION_FUNCTION = 6;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FUNCTION__DISTANCE = 0;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FUNCTION__POINTS = 1;

	/**
	 * The feature id for the '<em><b>Is Fourier Transformed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED = 2;

	/**
	 * The number of structural features of the '<em>Distribution Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FUNCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link RegEx.impl.ComplexImpl <em>Complex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see RegEx.impl.ComplexImpl
	 * @see RegEx.impl.RegExPackageImpl#getComplex()
	 * @generated
	 */
	int COMPLEX = 7;

	/**
	 * The feature id for the '<em><b>Re</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__RE = 0;

	/**
	 * The feature id for the '<em><b>Im</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__IM = 1;

	/**
	 * The number of structural features of the '<em>Complex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link RegEx.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see RegEx.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Expression#getDistributionFunction <em>Distribution Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution Function</em>'.
	 * @see RegEx.Expression#getDistributionFunction()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_DistributionFunction();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Expression#getDistributionFunctionFreq <em>Distribution Function Freq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution Function Freq</em>'.
	 * @see RegEx.Expression#getDistributionFunctionFreq()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_DistributionFunctionFreq();

	/**
	 * Returns the meta object for class '{@link RegEx.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol</em>'.
	 * @see RegEx.Symbol
	 * @generated
	 */
	EClass getSymbol();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.Symbol#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see RegEx.Symbol#getName()
	 * @see #getSymbol()
	 * @generated
	 */
	EAttribute getSymbol_Name();

	/**
	 * Returns the meta object for class '{@link RegEx.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see RegEx.Alternative
	 * @generated
	 */
	EClass getAlternative();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Alternative#getAltOne <em>Alt One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alt One</em>'.
	 * @see RegEx.Alternative#getAltOne()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_AltOne();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Alternative#getAltTwo <em>Alt Two</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alt Two</em>'.
	 * @see RegEx.Alternative#getAltTwo()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_AltTwo();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.Alternative#getProbOne <em>Prob One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob One</em>'.
	 * @see RegEx.Alternative#getProbOne()
	 * @see #getAlternative()
	 * @generated
	 */
	EAttribute getAlternative_ProbOne();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.Alternative#getProbTwo <em>Prob Two</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob Two</em>'.
	 * @see RegEx.Alternative#getProbTwo()
	 * @see #getAlternative()
	 * @generated
	 */
	EAttribute getAlternative_ProbTwo();

	/**
	 * Returns the meta object for class '{@link RegEx.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see RegEx.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Sequence#getPre <em>Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pre</em>'.
	 * @see RegEx.Sequence#getPre()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Pre();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Sequence#getPost <em>Post</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post</em>'.
	 * @see RegEx.Sequence#getPost()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Post();

	/**
	 * Returns the meta object for class '{@link RegEx.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see RegEx.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Loop#getInner <em>Inner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner</em>'.
	 * @see RegEx.Loop#getInner()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Inner();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Loop#getReiterationDistribution <em>Reiteration Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reiteration Distribution</em>'.
	 * @see RegEx.Loop#getReiterationDistribution()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_ReiterationDistribution();

	/**
	 * Returns the meta object for class '{@link RegEx.Parallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel</em>'.
	 * @see RegEx.Parallel
	 * @generated
	 */
	EClass getParallel();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Parallel#getTaskOne <em>Task One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task One</em>'.
	 * @see RegEx.Parallel#getTaskOne()
	 * @see #getParallel()
	 * @generated
	 */
	EReference getParallel_TaskOne();

	/**
	 * Returns the meta object for the containment reference '{@link RegEx.Parallel#getTaskTwo <em>Task Two</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Two</em>'.
	 * @see RegEx.Parallel#getTaskTwo()
	 * @see #getParallel()
	 * @generated
	 */
	EReference getParallel_TaskTwo();

	/**
	 * Returns the meta object for class '{@link RegEx.DistributionFunction <em>Distribution Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution Function</em>'.
	 * @see RegEx.DistributionFunction
	 * @generated
	 */
	EClass getDistributionFunction();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.DistributionFunction#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see RegEx.DistributionFunction#getDistance()
	 * @see #getDistributionFunction()
	 * @generated
	 */
	EAttribute getDistributionFunction_Distance();

	/**
	 * Returns the meta object for the containment reference list '{@link RegEx.DistributionFunction#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see RegEx.DistributionFunction#getPoints()
	 * @see #getDistributionFunction()
	 * @generated
	 */
	EReference getDistributionFunction_Points();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.DistributionFunction#isIsFourierTransformed <em>Is Fourier Transformed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Fourier Transformed</em>'.
	 * @see RegEx.DistributionFunction#isIsFourierTransformed()
	 * @see #getDistributionFunction()
	 * @generated
	 */
	EAttribute getDistributionFunction_IsFourierTransformed();

	/**
	 * Returns the meta object for class '{@link RegEx.Complex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex</em>'.
	 * @see RegEx.Complex
	 * @generated
	 */
	EClass getComplex();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.Complex#getRe <em>Re</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Re</em>'.
	 * @see RegEx.Complex#getRe()
	 * @see #getComplex()
	 * @generated
	 */
	EAttribute getComplex_Re();

	/**
	 * Returns the meta object for the attribute '{@link RegEx.Complex#getIm <em>Im</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Im</em>'.
	 * @see RegEx.Complex#getIm()
	 * @see #getComplex()
	 * @generated
	 */
	EAttribute getComplex_Im();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RegExFactory getRegExFactory();

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
		 * The meta object literal for the '{@link RegEx.Expression <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.Expression
		 * @see RegEx.impl.RegExPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Distribution Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__DISTRIBUTION_FUNCTION = eINSTANCE.getExpression_DistributionFunction();

		/**
		 * The meta object literal for the '<em><b>Distribution Function Freq</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__DISTRIBUTION_FUNCTION_FREQ = eINSTANCE.getExpression_DistributionFunctionFreq();

		/**
		 * The meta object literal for the '{@link RegEx.impl.SymbolImpl <em>Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.SymbolImpl
		 * @see RegEx.impl.RegExPackageImpl#getSymbol()
		 * @generated
		 */
		EClass SYMBOL = eINSTANCE.getSymbol();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOL__NAME = eINSTANCE.getSymbol_Name();

		/**
		 * The meta object literal for the '{@link RegEx.impl.AlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.AlternativeImpl
		 * @see RegEx.impl.RegExPackageImpl#getAlternative()
		 * @generated
		 */
		EClass ALTERNATIVE = eINSTANCE.getAlternative();

		/**
		 * The meta object literal for the '<em><b>Alt One</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE__ALT_ONE = eINSTANCE.getAlternative_AltOne();

		/**
		 * The meta object literal for the '<em><b>Alt Two</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE__ALT_TWO = eINSTANCE.getAlternative_AltTwo();

		/**
		 * The meta object literal for the '<em><b>Prob One</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALTERNATIVE__PROB_ONE = eINSTANCE.getAlternative_ProbOne();

		/**
		 * The meta object literal for the '<em><b>Prob Two</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALTERNATIVE__PROB_TWO = eINSTANCE.getAlternative_ProbTwo();

		/**
		 * The meta object literal for the '{@link RegEx.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.SequenceImpl
		 * @see RegEx.impl.RegExPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Pre</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__PRE = eINSTANCE.getSequence_Pre();

		/**
		 * The meta object literal for the '<em><b>Post</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__POST = eINSTANCE.getSequence_Post();

		/**
		 * The meta object literal for the '{@link RegEx.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.LoopImpl
		 * @see RegEx.impl.RegExPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Inner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__INNER = eINSTANCE.getLoop_Inner();

		/**
		 * The meta object literal for the '<em><b>Reiteration Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__REITERATION_DISTRIBUTION = eINSTANCE.getLoop_ReiterationDistribution();

		/**
		 * The meta object literal for the '{@link RegEx.impl.ParallelImpl <em>Parallel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.ParallelImpl
		 * @see RegEx.impl.RegExPackageImpl#getParallel()
		 * @generated
		 */
		EClass PARALLEL = eINSTANCE.getParallel();

		/**
		 * The meta object literal for the '<em><b>Task One</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL__TASK_ONE = eINSTANCE.getParallel_TaskOne();

		/**
		 * The meta object literal for the '<em><b>Task Two</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL__TASK_TWO = eINSTANCE.getParallel_TaskTwo();

		/**
		 * The meta object literal for the '{@link RegEx.impl.DistributionFunctionImpl <em>Distribution Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.DistributionFunctionImpl
		 * @see RegEx.impl.RegExPackageImpl#getDistributionFunction()
		 * @generated
		 */
		EClass DISTRIBUTION_FUNCTION = eINSTANCE.getDistributionFunction();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_FUNCTION__DISTANCE = eINSTANCE.getDistributionFunction_Distance();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION_FUNCTION__POINTS = eINSTANCE.getDistributionFunction_Points();

		/**
		 * The meta object literal for the '<em><b>Is Fourier Transformed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED = eINSTANCE.getDistributionFunction_IsFourierTransformed();

		/**
		 * The meta object literal for the '{@link RegEx.impl.ComplexImpl <em>Complex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see RegEx.impl.ComplexImpl
		 * @see RegEx.impl.RegExPackageImpl#getComplex()
		 * @generated
		 */
		EClass COMPLEX = eINSTANCE.getComplex();

		/**
		 * The meta object literal for the '<em><b>Re</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX__RE = eINSTANCE.getComplex_Re();

		/**
		 * The meta object literal for the '<em><b>Im</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX__IM = eINSTANCE.getComplex_Im();

	}

} //RegExPackage
