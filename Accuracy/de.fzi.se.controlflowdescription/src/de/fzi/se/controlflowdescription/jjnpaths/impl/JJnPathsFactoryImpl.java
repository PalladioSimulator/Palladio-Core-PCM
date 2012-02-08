/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.jjnpaths.*;

import org.eclipse.emf.ecore.EClass;
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
public class JJnPathsFactoryImpl extends EFactoryImpl implements JJnPathsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JJnPathsFactory init() {
		try {
			JJnPathsFactory theJJnPathsFactory = (JJnPathsFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.fzi.de/ControlFlowDescription/jjnpaths/0.6"); 
			if (theJJnPathsFactory != null) {
				return theJJnPathsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JJnPathsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsFactoryImpl() {
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE: return createJJnPathTestSuite();
			case JJnPathsPackage.JJN_PATH: return createJJnPath();
			case JJnPathsPackage.JJ_PATH: return createJJPath();
			case JJnPathsPackage.JJN_PATH_TEST_CASE: return createJJnPathTestCase();
			case JJnPathsPackage.JJN_PATHS_EFFORT_ESTIMATION_RESULT: return createJJnPathsEffortEstimationResult();
			case JJnPathsPackage.JJN_PATH_SET: return createJJnPathSet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathTestSuite createJJnPathTestSuite() {
		JJnPathTestSuiteImpl jJnPathTestSuite = new JJnPathTestSuiteImpl();
		return jJnPathTestSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPath createJJnPath() {
		JJnPathImpl jJnPath = new JJnPathImpl();
		return jJnPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJPath createJJPath() {
		JJPathImpl jjPath = new JJPathImpl();
		return jjPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathTestCase createJJnPathTestCase() {
		JJnPathTestCaseImpl jJnPathTestCase = new JJnPathTestCaseImpl();
		return jJnPathTestCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsEffortEstimationResult createJJnPathsEffortEstimationResult() {
		JJnPathsEffortEstimationResultImpl jJnPathsEffortEstimationResult = new JJnPathsEffortEstimationResultImpl();
		return jJnPathsEffortEstimationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathSet createJJnPathSet() {
		JJnPathSetImpl jJnPathSet = new JJnPathSetImpl();
		return jJnPathSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsPackage getJJnPathsPackage() {
		return (JJnPathsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JJnPathsPackage getPackage() {
		return JJnPathsPackage.eINSTANCE;
	}

} //JJnPathsFactoryImpl
