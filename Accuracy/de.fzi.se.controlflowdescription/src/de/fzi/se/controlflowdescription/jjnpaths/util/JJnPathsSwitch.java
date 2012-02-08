/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.util;

import de.fzi.se.controlflowdescription.jjnpaths.*;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage
 * @generated
 */
public class JJnPathsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JJnPathsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsSwitch() {
		if (modelPackage == null) {
			modelPackage = JJnPathsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JJnPathsPackage.JJN_PATH_TEST_SUITE: {
				JJnPathTestSuite jJnPathTestSuite = (JJnPathTestSuite)theEObject;
				T result = caseJJnPathTestSuite(jJnPathTestSuite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JJnPathsPackage.JJN_PATH: {
				JJnPath jJnPath = (JJnPath)theEObject;
				T result = caseJJnPath(jJnPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JJnPathsPackage.JJ_PATH: {
				JJPath jjPath = (JJPath)theEObject;
				T result = caseJJPath(jjPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JJnPathsPackage.JJN_PATH_TEST_CASE: {
				JJnPathTestCase jJnPathTestCase = (JJnPathTestCase)theEObject;
				T result = caseJJnPathTestCase(jJnPathTestCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JJnPathsPackage.JJN_PATHS_EFFORT_ESTIMATION_RESULT: {
				JJnPathsEffortEstimationResult jJnPathsEffortEstimationResult = (JJnPathsEffortEstimationResult)theEObject;
				T result = caseJJnPathsEffortEstimationResult(jJnPathsEffortEstimationResult);
				if (result == null) result = caseEffortEstimationResult(jJnPathsEffortEstimationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JJnPathsPackage.JJN_PATH_SET: {
				JJnPathSet jJnPathSet = (JJnPathSet)theEObject;
				T result = caseJJnPathSet(jJnPathSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JJn Path Test Suite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JJn Path Test Suite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJnPathTestSuite(JJnPathTestSuite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JJn Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JJn Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJnPath(JJnPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JJ Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JJ Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJPath(JJPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JJn Path Test Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JJn Path Test Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJnPathTestCase(JJnPathTestCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effort Estimation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effort Estimation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJnPathsEffortEstimationResult(JJnPathsEffortEstimationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JJn Path Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JJn Path Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJJnPathSet(JJnPathSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effort Estimation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effort Estimation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffortEstimationResult(EffortEstimationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //JJnPathsSwitch
