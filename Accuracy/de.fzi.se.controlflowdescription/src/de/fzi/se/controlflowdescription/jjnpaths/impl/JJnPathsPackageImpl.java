/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;

import de.fzi.se.controlflowdescription.graph.GraphPackage;

import de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl;

import de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl;

import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsFactory;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import de.fzi.se.controlflowdescription.jjnpaths.util.JJnPathsValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JJnPathsPackageImpl extends EPackageImpl implements JJnPathsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jJnPathTestSuiteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jJnPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jjPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jJnPathTestCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jJnPathsCreationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jJnPathSetEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JJnPathsPackageImpl() {
		super(eNS_URI, JJnPathsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JJnPathsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JJnPathsPackage init() {
		if (isInited) return (JJnPathsPackage)EPackage.Registry.INSTANCE.getEPackage(JJnPathsPackage.eNS_URI);

		// Obtain or create and register package
		JJnPathsPackageImpl theJJnPathsPackage = (JJnPathsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JJnPathsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JJnPathsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ControlFlowDescriptionPackageImpl theControlFlowDescriptionPackage = (ControlFlowDescriptionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ControlFlowDescriptionPackage.eNS_URI) instanceof ControlFlowDescriptionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ControlFlowDescriptionPackage.eNS_URI) : ControlFlowDescriptionPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);

		// Create package meta-data objects
		theJJnPathsPackage.createPackageContents();
		theControlFlowDescriptionPackage.createPackageContents();
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theJJnPathsPackage.initializePackageContents();
		theControlFlowDescriptionPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theJJnPathsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return JJnPathsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theJJnPathsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JJnPathsPackage.eNS_URI, theJJnPathsPackage);
		return theJJnPathsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJnPathTestSuite() {
		return jJnPathTestSuiteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathTestSuite_Jjnhelperpaths() {
		return (EReference)jJnPathTestSuiteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathTestSuite_Jjnpathset() {
		return (EReference)jJnPathTestSuiteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathTestSuite_Testcases() {
		return (EReference)jJnPathTestSuiteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJJnPathTestSuite_RequiredTests() {
		return (EAttribute)jJnPathTestSuiteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJnPath() {
		return jJnPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPath_Jjnpathset() {
		return (EReference)jJnPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPath_Jjpaths() {
		return (EReference)jJnPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPath_From() {
		return (EReference)jJnPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPath_JumpTo() {
		return (EReference)jJnPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPath_Jjnpathtestset() {
		return (EReference)jJnPathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJPath() {
		return jjPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJPath_From() {
		return (EReference)jjPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJPath_To() {
		return (EReference)jjPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJPath_JumpTo() {
		return (EReference)jjPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJPath_Controlflowdescription() {
		return (EReference)jjPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJPath_Jjnpath() {
		return (EReference)jjPathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJnPathTestCase() {
		return jJnPathTestCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathTestCase_Jjnpaths() {
		return (EReference)jJnPathTestCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathTestCase_Jjnpathtestset() {
		return (EReference)jJnPathTestCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJnPathsCreationParameter() {
		return jJnPathsCreationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJJnPathsCreationParameter_N() {
		return (EAttribute)jJnPathsCreationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJJnPathsCreationParameter_TargetId() {
		return (EAttribute)jJnPathsCreationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJJnPathsCreationParameter_Alpha() {
		return (EAttribute)jJnPathsCreationParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJJnPathSet() {
		return jJnPathSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathSet_Jjnpaths() {
		return (EReference)jJnPathSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathSet_Jjnpathtestset() {
		return (EReference)jJnPathSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJJnPathSet_N() {
		return (EAttribute)jJnPathSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJJnPathSet_Controlflowdescription() {
		return (EReference)jJnPathSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsFactory getJJnPathsFactory() {
		return (JJnPathsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		jJnPathTestSuiteEClass = createEClass(JJN_PATH_TEST_SUITE);
		createEReference(jJnPathTestSuiteEClass, JJN_PATH_TEST_SUITE__JJNHELPERPATHS);
		createEReference(jJnPathTestSuiteEClass, JJN_PATH_TEST_SUITE__JJNPATHSET);
		createEReference(jJnPathTestSuiteEClass, JJN_PATH_TEST_SUITE__TESTCASES);
		createEAttribute(jJnPathTestSuiteEClass, JJN_PATH_TEST_SUITE__REQUIRED_TESTS);

		jJnPathEClass = createEClass(JJN_PATH);
		createEReference(jJnPathEClass, JJN_PATH__JJNPATHSET);
		createEReference(jJnPathEClass, JJN_PATH__JJPATHS);
		createEReference(jJnPathEClass, JJN_PATH__FROM);
		createEReference(jJnPathEClass, JJN_PATH__JUMP_TO);
		createEReference(jJnPathEClass, JJN_PATH__JJNPATHTESTSET);

		jjPathEClass = createEClass(JJ_PATH);
		createEReference(jjPathEClass, JJ_PATH__FROM);
		createEReference(jjPathEClass, JJ_PATH__TO);
		createEReference(jjPathEClass, JJ_PATH__JUMP_TO);
		createEReference(jjPathEClass, JJ_PATH__CONTROLFLOWDESCRIPTION);
		createEReference(jjPathEClass, JJ_PATH__JJNPATH);

		jJnPathTestCaseEClass = createEClass(JJN_PATH_TEST_CASE);
		createEReference(jJnPathTestCaseEClass, JJN_PATH_TEST_CASE__JJNPATHS);
		createEReference(jJnPathTestCaseEClass, JJN_PATH_TEST_CASE__JJNPATHTESTSET);

		jJnPathsCreationParameterEClass = createEClass(JJN_PATHS_CREATION_PARAMETER);
		createEAttribute(jJnPathsCreationParameterEClass, JJN_PATHS_CREATION_PARAMETER__N);
		createEAttribute(jJnPathsCreationParameterEClass, JJN_PATHS_CREATION_PARAMETER__TARGET_ID);
		createEAttribute(jJnPathsCreationParameterEClass, JJN_PATHS_CREATION_PARAMETER__ALPHA);

		jJnPathSetEClass = createEClass(JJN_PATH_SET);
		createEReference(jJnPathSetEClass, JJN_PATH_SET__JJNPATHS);
		createEReference(jJnPathSetEClass, JJN_PATH_SET__JJNPATHTESTSET);
		createEAttribute(jJnPathSetEClass, JJN_PATH_SET__N);
		createEReference(jJnPathSetEClass, JJN_PATH_SET__CONTROLFLOWDESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		ControlFlowDescriptionPackage theControlFlowDescriptionPackage = (ControlFlowDescriptionPackage)EPackage.Registry.INSTANCE.getEPackage(ControlFlowDescriptionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(jJnPathTestSuiteEClass, JJnPathTestSuite.class, "JJnPathTestSuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJJnPathTestSuite_Jjnhelperpaths(), this.getJJnPath(), this.getJJnPath_Jjnpathtestset(), "jjnhelperpaths", null, 0, -1, JJnPathTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJJnPathTestSuite_Jjnpathset(), this.getJJnPathSet(), this.getJJnPathSet_Jjnpathtestset(), "jjnpathset", null, 1, 1, JJnPathTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPathTestSuite_Testcases(), this.getJJnPathTestCase(), this.getJJnPathTestCase_Jjnpathtestset(), "testcases", null, 0, -1, JJnPathTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJJnPathTestSuite_RequiredTests(), ecorePackage.getEInt(), "requiredTests", null, 0, 1, JJnPathTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jJnPathEClass, JJnPath.class, "JJnPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJJnPath_Jjnpathset(), this.getJJnPathSet(), this.getJJnPathSet_Jjnpaths(), "jjnpathset", null, 0, 1, JJnPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPath_Jjpaths(), this.getJJPath(), this.getJJPath_Jjnpath(), "jjpaths", null, 1, -1, JJnPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJJnPath_From(), theGraphPackage.getVertex(), null, "from", null, 1, 1, JJnPath.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPath_JumpTo(), theGraphPackage.getVertex(), null, "jumpTo", null, 1, 1, JJnPath.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPath_Jjnpathtestset(), this.getJJnPathTestSuite(), this.getJJnPathTestSuite_Jjnhelperpaths(), "jjnpathtestset", null, 0, 1, JJnPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jjPathEClass, JJPath.class, "JJPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJJPath_From(), theGraphPackage.getVertex(), null, "from", null, 1, 1, JJPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJPath_To(), theGraphPackage.getVertex(), null, "to", null, 1, 1, JJPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJPath_JumpTo(), theGraphPackage.getVertex(), null, "jumpTo", null, 1, 1, JJPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJPath_Controlflowdescription(), theControlFlowDescriptionPackage.getControlFlowDescription(), theControlFlowDescriptionPackage.getControlFlowDescription_Jjpaths(), "controlflowdescription", null, 0, 1, JJPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJPath_Jjnpath(), this.getJJnPath(), this.getJJnPath_Jjpaths(), "jjnpath", null, 0, 1, JJPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jJnPathTestCaseEClass, JJnPathTestCase.class, "JJnPathTestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJJnPathTestCase_Jjnpaths(), this.getJJnPath(), null, "jjnpaths", null, 0, -1, JJnPathTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJJnPathTestCase_Jjnpathtestset(), this.getJJnPathTestSuite(), this.getJJnPathTestSuite_Testcases(), "jjnpathtestset", null, 1, 1, JJnPathTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jJnPathsCreationParameterEClass, JJnPathsCreationParameter.class, "JJnPathsCreationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJJnPathsCreationParameter_N(), ecorePackage.getEInt(), "n", null, 1, 1, JJnPathsCreationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJJnPathsCreationParameter_TargetId(), ecorePackage.getEString(), "targetId", null, 1, 1, JJnPathsCreationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJJnPathsCreationParameter_Alpha(), ecorePackage.getEDouble(), "alpha", null, 1, 1, JJnPathsCreationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jJnPathSetEClass, JJnPathSet.class, "JJnPathSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJJnPathSet_Jjnpaths(), this.getJJnPath(), this.getJJnPath_Jjnpathset(), "jjnpaths", null, 0, -1, JJnPathSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPathSet_Jjnpathtestset(), this.getJJnPathTestSuite(), this.getJJnPathTestSuite_Jjnpathset(), "jjnpathtestset", null, 0, 1, JJnPathSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJJnPathSet_N(), ecorePackage.getEInt(), "n", null, 1, 1, JJnPathSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJJnPathSet_Controlflowdescription(), theControlFlowDescriptionPackage.getControlFlowDescription(), theControlFlowDescriptionPackage.getControlFlowDescription_Jjnpathsets(), "controlflowdescription", null, 1, 1, JJnPathSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(jJnPathSetEClass, ecorePackage.getEBoolean(), "NMustBeGreaterOrEqualToOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";					
		addAnnotation
		  (getJJnPath_From(), 
		   source, 
		   new String[] {
			 "name", "from"
		   });			
		addAnnotation
		  (getJJnPath_JumpTo(), 
		   source, 
		   new String[] {
			 "name", "jumpTo"
		   });												
	}

} //JJnPathsPackageImpl
