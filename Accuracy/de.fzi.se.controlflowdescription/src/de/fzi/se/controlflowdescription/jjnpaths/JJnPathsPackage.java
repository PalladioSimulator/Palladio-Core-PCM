/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

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
 * <!-- begin-model-doc -->
 * Model for the JJn-Paths of a control-flow graph.
 * <!-- end-model-doc -->
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsFactory
 * @model kind="package"
 * @generated
 */
public interface JJnPathsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jjnpaths";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.fzi.de/ControlFlowDescription/jjnpaths/0.6";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jjnpaths";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JJnPathsPackage eINSTANCE = de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl <em>JJn Path Test Suite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathTestSuite()
	 * @generated
	 */
	int JJN_PATH_TEST_SUITE = 0;

	/**
	 * The feature id for the '<em><b>Jjnhelperpaths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_SUITE__JJNHELPERPATHS = 0;

	/**
	 * The feature id for the '<em><b>Jjnpathset</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_SUITE__JJNPATHSET = 1;

	/**
	 * The feature id for the '<em><b>Testcases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_SUITE__TESTCASES = 2;

	/**
	 * The feature id for the '<em><b>Required Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_SUITE__REQUIRED_TESTS = 3;

	/**
	 * The number of structural features of the '<em>JJn Path Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_SUITE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl <em>JJn Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPath()
	 * @generated
	 */
	int JJN_PATH = 1;

	/**
	 * The feature id for the '<em><b>Jjnpathset</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH__JJNPATHSET = 0;

	/**
	 * The feature id for the '<em><b>Jjpaths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH__JJPATHS = 1;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH__FROM = 2;

	/**
	 * The feature id for the '<em><b>Jump To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH__JUMP_TO = 3;

	/**
	 * The feature id for the '<em><b>Jjnpathtestset</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH__JJNPATHTESTSET = 4;

	/**
	 * The number of structural features of the '<em>JJn Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl <em>JJ Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJPath()
	 * @generated
	 */
	int JJ_PATH = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH__TO = 1;

	/**
	 * The feature id for the '<em><b>Jump To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH__JUMP_TO = 2;

	/**
	 * The feature id for the '<em><b>Controlflowdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH__CONTROLFLOWDESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Jjnpath</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH__JJNPATH = 4;

	/**
	 * The number of structural features of the '<em>JJ Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJ_PATH_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl <em>JJn Path Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathTestCase()
	 * @generated
	 */
	int JJN_PATH_TEST_CASE = 3;

	/**
	 * The feature id for the '<em><b>Jjnpaths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_CASE__JJNPATHS = 0;

	/**
	 * The feature id for the '<em><b>Jjnpathtestset</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_CASE__JJNPATHTESTSET = 1;

	/**
	 * The number of structural features of the '<em>JJn Path Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_TEST_CASE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl <em>Creation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathsCreationParameter()
	 * @generated
	 */
	int JJN_PATHS_CREATION_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATHS_CREATION_PARAMETER__N = 0;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATHS_CREATION_PARAMETER__TARGET_ID = 1;

	/**
	 * The number of structural features of the '<em>Creation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATHS_CREATION_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl <em>JJn Path Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl
	 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathSet()
	 * @generated
	 */
	int JJN_PATH_SET = 5;

	/**
	 * The feature id for the '<em><b>Jjnpaths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_SET__JJNPATHS = 0;

	/**
	 * The feature id for the '<em><b>Jjnpathtestset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_SET__JJNPATHTESTSET = 1;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_SET__N = 2;

	/**
	 * The feature id for the '<em><b>Controlflowdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_SET__CONTROLFLOWDESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>JJn Path Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JJN_PATH_SET_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite <em>JJn Path Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JJn Path Test Suite</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite
	 * @generated
	 */
	EClass getJJnPathTestSuite();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnhelperpaths <em>Jjnhelperpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jjnhelperpaths</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnhelperpaths()
	 * @see #getJJnPathTestSuite()
	 * @generated
	 */
	EReference getJJnPathTestSuite_Jjnhelperpaths();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset <em>Jjnpathset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Jjnpathset</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset()
	 * @see #getJJnPathTestSuite()
	 * @generated
	 */
	EReference getJJnPathTestSuite_Jjnpathset();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getTestcases <em>Testcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Testcases</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getTestcases()
	 * @see #getJJnPathTestSuite()
	 * @generated
	 */
	EReference getJJnPathTestSuite_Testcases();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getRequiredTests <em>Required Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Tests</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getRequiredTests()
	 * @see #getJJnPathTestSuite()
	 * @generated
	 */
	EAttribute getJJnPathTestSuite_RequiredTests();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath <em>JJn Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JJn Path</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath
	 * @generated
	 */
	EClass getJJnPath();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset <em>Jjnpathset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Jjnpathset</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset()
	 * @see #getJJnPath()
	 * @generated
	 */
	EReference getJJnPath_Jjnpathset();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjpaths <em>Jjpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jjpaths</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjpaths()
	 * @see #getJJnPath()
	 * @generated
	 */
	EReference getJJnPath_Jjpaths();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getFrom()
	 * @see #getJJnPath()
	 * @generated
	 */
	EReference getJJnPath_From();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJumpTo <em>Jump To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jump To</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJumpTo()
	 * @see #getJJnPath()
	 * @generated
	 */
	EReference getJJnPath_JumpTo();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Jjnpathtestset</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset()
	 * @see #getJJnPath()
	 * @generated
	 */
	EReference getJJnPath_Jjnpathtestset();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath <em>JJ Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JJ Path</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath
	 * @generated
	 */
	EClass getJJPath();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getFrom()
	 * @see #getJJPath()
	 * @generated
	 */
	EReference getJJPath_From();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getTo()
	 * @see #getJJPath()
	 * @generated
	 */
	EReference getJJPath_To();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJumpTo <em>Jump To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jump To</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJumpTo()
	 * @see #getJJPath()
	 * @generated
	 */
	EReference getJJPath_JumpTo();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Controlflowdescription</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription()
	 * @see #getJJPath()
	 * @generated
	 */
	EReference getJJPath_Controlflowdescription();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath <em>Jjnpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Jjnpath</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath()
	 * @see #getJJPath()
	 * @generated
	 */
	EReference getJJPath_Jjnpath();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase <em>JJn Path Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JJn Path Test Case</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase
	 * @generated
	 */
	EClass getJJnPathTestCase();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpaths <em>Jjnpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Jjnpaths</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpaths()
	 * @see #getJJnPathTestCase()
	 * @generated
	 */
	EReference getJJnPathTestCase_Jjnpaths();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Jjnpathtestset</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset()
	 * @see #getJJnPathTestCase()
	 * @generated
	 */
	EReference getJJnPathTestCase_Jjnpathtestset();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter <em>Creation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creation Parameter</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter
	 * @generated
	 */
	EClass getJJnPathsCreationParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getN()
	 * @see #getJJnPathsCreationParameter()
	 * @generated
	 */
	EAttribute getJJnPathsCreationParameter_N();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getTargetId <em>Target Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Id</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getTargetId()
	 * @see #getJJnPathsCreationParameter()
	 * @generated
	 */
	EAttribute getJJnPathsCreationParameter_TargetId();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet <em>JJn Path Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JJn Path Set</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet
	 * @generated
	 */
	EClass getJJnPathSet();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpaths <em>Jjnpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jjnpaths</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpaths()
	 * @see #getJJnPathSet()
	 * @generated
	 */
	EReference getJJnPathSet_Jjnpaths();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Jjnpathtestset</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset()
	 * @see #getJJnPathSet()
	 * @generated
	 */
	EReference getJJnPathSet_Jjnpathtestset();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getN()
	 * @see #getJJnPathSet()
	 * @generated
	 */
	EAttribute getJJnPathSet_N();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Controlflowdescription</em>'.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription()
	 * @see #getJJnPathSet()
	 * @generated
	 */
	EReference getJJnPathSet_Controlflowdescription();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JJnPathsFactory getJJnPathsFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl <em>JJn Path Test Suite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathTestSuite()
		 * @generated
		 */
		EClass JJN_PATH_TEST_SUITE = eINSTANCE.getJJnPathTestSuite();

		/**
		 * The meta object literal for the '<em><b>Jjnhelperpaths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_TEST_SUITE__JJNHELPERPATHS = eINSTANCE.getJJnPathTestSuite_Jjnhelperpaths();

		/**
		 * The meta object literal for the '<em><b>Jjnpathset</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_TEST_SUITE__JJNPATHSET = eINSTANCE.getJJnPathTestSuite_Jjnpathset();

		/**
		 * The meta object literal for the '<em><b>Testcases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_TEST_SUITE__TESTCASES = eINSTANCE.getJJnPathTestSuite_Testcases();

		/**
		 * The meta object literal for the '<em><b>Required Tests</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JJN_PATH_TEST_SUITE__REQUIRED_TESTS = eINSTANCE.getJJnPathTestSuite_RequiredTests();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl <em>JJn Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPath()
		 * @generated
		 */
		EClass JJN_PATH = eINSTANCE.getJJnPath();

		/**
		 * The meta object literal for the '<em><b>Jjnpathset</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH__JJNPATHSET = eINSTANCE.getJJnPath_Jjnpathset();

		/**
		 * The meta object literal for the '<em><b>Jjpaths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH__JJPATHS = eINSTANCE.getJJnPath_Jjpaths();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH__FROM = eINSTANCE.getJJnPath_From();

		/**
		 * The meta object literal for the '<em><b>Jump To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH__JUMP_TO = eINSTANCE.getJJnPath_JumpTo();

		/**
		 * The meta object literal for the '<em><b>Jjnpathtestset</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH__JJNPATHTESTSET = eINSTANCE.getJJnPath_Jjnpathtestset();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl <em>JJ Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJPath()
		 * @generated
		 */
		EClass JJ_PATH = eINSTANCE.getJJPath();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJ_PATH__FROM = eINSTANCE.getJJPath_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJ_PATH__TO = eINSTANCE.getJJPath_To();

		/**
		 * The meta object literal for the '<em><b>Jump To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJ_PATH__JUMP_TO = eINSTANCE.getJJPath_JumpTo();

		/**
		 * The meta object literal for the '<em><b>Controlflowdescription</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJ_PATH__CONTROLFLOWDESCRIPTION = eINSTANCE.getJJPath_Controlflowdescription();

		/**
		 * The meta object literal for the '<em><b>Jjnpath</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJ_PATH__JJNPATH = eINSTANCE.getJJPath_Jjnpath();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl <em>JJn Path Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathTestCase()
		 * @generated
		 */
		EClass JJN_PATH_TEST_CASE = eINSTANCE.getJJnPathTestCase();

		/**
		 * The meta object literal for the '<em><b>Jjnpaths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_TEST_CASE__JJNPATHS = eINSTANCE.getJJnPathTestCase_Jjnpaths();

		/**
		 * The meta object literal for the '<em><b>Jjnpathtestset</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_TEST_CASE__JJNPATHTESTSET = eINSTANCE.getJJnPathTestCase_Jjnpathtestset();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl <em>Creation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathsCreationParameter()
		 * @generated
		 */
		EClass JJN_PATHS_CREATION_PARAMETER = eINSTANCE.getJJnPathsCreationParameter();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JJN_PATHS_CREATION_PARAMETER__N = eINSTANCE.getJJnPathsCreationParameter_N();

		/**
		 * The meta object literal for the '<em><b>Target Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JJN_PATHS_CREATION_PARAMETER__TARGET_ID = eINSTANCE.getJJnPathsCreationParameter_TargetId();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl <em>JJn Path Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl
		 * @see de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl#getJJnPathSet()
		 * @generated
		 */
		EClass JJN_PATH_SET = eINSTANCE.getJJnPathSet();

		/**
		 * The meta object literal for the '<em><b>Jjnpaths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_SET__JJNPATHS = eINSTANCE.getJJnPathSet_Jjnpaths();

		/**
		 * The meta object literal for the '<em><b>Jjnpathtestset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_SET__JJNPATHTESTSET = eINSTANCE.getJJnPathSet_Jjnpathtestset();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JJN_PATH_SET__N = eINSTANCE.getJJnPathSet_N();

		/**
		 * The meta object literal for the '<em><b>Controlflowdescription</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JJN_PATH_SET__CONTROLFLOWDESCRIPTION = eINSTANCE.getJJnPathSet_Controlflowdescription();

	}

} //JJnPathsPackage
