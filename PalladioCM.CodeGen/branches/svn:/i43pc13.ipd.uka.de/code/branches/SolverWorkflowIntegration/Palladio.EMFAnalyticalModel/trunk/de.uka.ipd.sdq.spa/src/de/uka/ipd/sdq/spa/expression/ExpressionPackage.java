/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

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
 * @see de.uka.ipd.sdq.spa.expression.ExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Analytical/Expression/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spa.expression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getExpression()
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.TerminalImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 0;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.SymbolImpl <em>Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.SymbolImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getSymbol()
	 * @generated
	 */
	int SYMBOL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__NAME = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__RESOURCE_USAGES = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.OperationImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 4;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.SequenceImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Left Reg Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__LEFT_REG_EXP = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Reg Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__RIGHT_REG_EXP = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.ReleaseImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 5;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__RESOURCE = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.ParallelImpl <em>Parallel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.ParallelImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getParallel()
	 * @generated
	 */
	int PARALLEL = 6;

	/**
	 * The feature id for the '<em><b>Left Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__LEFT_TASK = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__RIGHT_TASK = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parallel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.OptionImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 7;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Regexp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__REGEXP = 1;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.LoopImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 8;

	/**
	 * The feature id for the '<em><b>Reg Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__REG_EXP = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterations PMF</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ITERATIONS_PMF = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Iterations String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ITERATIONS_STRING = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getAlternative()
	 * @generated
	 */
	int ALTERNATIVE = 9;

	/**
	 * The feature id for the '<em><b>Left Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__LEFT_OPTION = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__RIGHT_OPTION = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.expression.impl.AcquireImpl <em>Acquire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.expression.impl.AcquireImpl
	 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getAcquire()
	 * @generated
	 */
	int ACQUIRE = 10;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__RESOURCE = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Acquire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Symbol
	 * @generated
	 */
	EClass getSymbol();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.expression.Symbol#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Symbol#getName()
	 * @see #getSymbol()
	 * @generated
	 */
	EAttribute getSymbol_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.expression.Symbol#getResourceUsages <em>Resource Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Usages</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Symbol#getResourceUsages()
	 * @see #getSymbol()
	 * @generated
	 */
	EReference getSymbol_ResourceUsages();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Sequence#getLeftRegExp <em>Left Reg Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Reg Exp</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Sequence#getLeftRegExp()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_LeftRegExp();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Sequence#getRightRegExp <em>Right Reg Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Reg Exp</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Sequence#getRightRegExp()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_RightRegExp();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.spa.expression.Release#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Release#getResource()
	 * @see #getRelease()
	 * @generated
	 */
	EReference getRelease_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Parallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Parallel
	 * @generated
	 */
	EClass getParallel();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Parallel#getLeftTask <em>Left Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Task</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Parallel#getLeftTask()
	 * @see #getParallel()
	 * @generated
	 */
	EReference getParallel_LeftTask();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Parallel#getRightTask <em>Right Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Task</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Parallel#getRightTask()
	 * @see #getParallel()
	 * @generated
	 */
	EReference getParallel_RightTask();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.expression.Option#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Option#getProbability()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Probability();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Option#getRegexp <em>Regexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Regexp</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Option#getRegexp()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_Regexp();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Loop#getRegExp <em>Reg Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reg Exp</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Loop#getRegExp()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_RegExp();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsPMF <em>Iterations PMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterations PMF</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Loop#getIterationsPMF()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_IterationsPMF();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsString <em>Iterations String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterations String</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Loop#getIterationsString()
	 * @see #getLoop()
	 * @generated
	 */
	EAttribute getLoop_IterationsString();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Alternative
	 * @generated
	 */
	EClass getAlternative();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Alternative#getLeftOption <em>Left Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Option</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Alternative#getLeftOption()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_LeftOption();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.expression.Alternative#getRightOption <em>Right Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Option</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Alternative#getRightOption()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_RightOption();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.expression.Acquire <em>Acquire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acquire</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Acquire
	 * @generated
	 */
	EClass getAcquire();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.spa.expression.Acquire#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.expression.Acquire#getResource()
	 * @see #getAcquire()
	 * @generated
	 */
	EReference getAcquire_Resource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionFactory getExpressionFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.TerminalImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.SymbolImpl <em>Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.SymbolImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getSymbol()
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
		 * The meta object literal for the '<em><b>Resource Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOL__RESOURCE_USAGES = eINSTANCE.getSymbol_ResourceUsages();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.SequenceImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Left Reg Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__LEFT_REG_EXP = eINSTANCE.getSequence_LeftRegExp();

		/**
		 * The meta object literal for the '<em><b>Right Reg Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__RIGHT_REG_EXP = eINSTANCE.getSequence_RightRegExp();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.OperationImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.ReleaseImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE__RESOURCE = eINSTANCE.getRelease_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.ParallelImpl <em>Parallel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.ParallelImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getParallel()
		 * @generated
		 */
		EClass PARALLEL = eINSTANCE.getParallel();

		/**
		 * The meta object literal for the '<em><b>Left Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL__LEFT_TASK = eINSTANCE.getParallel_LeftTask();

		/**
		 * The meta object literal for the '<em><b>Right Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL__RIGHT_TASK = eINSTANCE.getParallel_RightTask();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.OptionImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__PROBABILITY = eINSTANCE.getOption_Probability();

		/**
		 * The meta object literal for the '<em><b>Regexp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__REGEXP = eINSTANCE.getOption_Regexp();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.LoopImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Reg Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__REG_EXP = eINSTANCE.getLoop_RegExp();

		/**
		 * The meta object literal for the '<em><b>Iterations PMF</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__ITERATIONS_PMF = eINSTANCE.getLoop_IterationsPMF();

		/**
		 * The meta object literal for the '<em><b>Iterations String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP__ITERATIONS_STRING = eINSTANCE.getLoop_IterationsString();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getAlternative()
		 * @generated
		 */
		EClass ALTERNATIVE = eINSTANCE.getAlternative();

		/**
		 * The meta object literal for the '<em><b>Left Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE__LEFT_OPTION = eINSTANCE.getAlternative_LeftOption();

		/**
		 * The meta object literal for the '<em><b>Right Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE__RIGHT_OPTION = eINSTANCE.getAlternative_RightOption();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.expression.impl.AcquireImpl <em>Acquire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.expression.impl.AcquireImpl
		 * @see de.uka.ipd.sdq.spa.expression.impl.ExpressionPackageImpl#getAcquire()
		 * @generated
		 */
		EClass ACQUIRE = eINSTANCE.getAcquire();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACQUIRE__RESOURCE = eINSTANCE.getAcquire_Resource();

	}

} //ExpressionPackage
