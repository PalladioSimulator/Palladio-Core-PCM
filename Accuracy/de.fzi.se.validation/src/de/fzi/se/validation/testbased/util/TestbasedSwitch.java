/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.util;

import de.fzi.se.quality.QualityStatement;

import de.fzi.se.validation.testbased.*;

import de.uka.ipd.sdq.identifier.Identifier;

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
 * @see de.fzi.se.validation.testbased.TestbasedPackage
 * @generated
 */
public class TestbasedSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestbasedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbasedSwitch() {
		if (modelPackage == null) {
			modelPackage = TestbasedPackage.eINSTANCE;
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
			case TestbasedPackage.TB_VALIDATION_QUALITY: {
				TBValidationQuality tbValidationQuality = (TBValidationQuality)theEObject;
				T result = caseTBValidationQuality(tbValidationQuality);
				if (result == null) result = caseQualityStatement(tbValidationQuality);
				if (result == null) result = caseIdentifier(tbValidationQuality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.TESTCASE_EXECUTION_STOP_STRATEGY: {
				TestcaseExecutionStopStrategy testcaseExecutionStopStrategy = (TestcaseExecutionStopStrategy)theEObject;
				T result = caseTestcaseExecutionStopStrategy(testcaseExecutionStopStrategy);
				if (result == null) result = caseIdentifier(testcaseExecutionStopStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.TESTCASE_GENERATION_STRATEGY: {
				TestcaseGenerationStrategy testcaseGenerationStrategy = (TestcaseGenerationStrategy)theEObject;
				T result = caseTestcaseGenerationStrategy(testcaseGenerationStrategy);
				if (result == null) result = caseIdentifier(testcaseGenerationStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY: {
				InternalStateInfluenceAnalysisStrategy internalStateInfluenceAnalysisStrategy = (InternalStateInfluenceAnalysisStrategy)theEObject;
				T result = caseInternalStateInfluenceAnalysisStrategy(internalStateInfluenceAnalysisStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM: {
				EquidistantPartitionsRandom equidistantPartitionsRandom = (EquidistantPartitionsRandom)theEObject;
				T result = caseEquidistantPartitionsRandom(equidistantPartitionsRandom);
				if (result == null) result = caseTestcaseGenerationStrategy(equidistantPartitionsRandom);
				if (result == null) result = caseIdentifier(equidistantPartitionsRandom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.NUMBER_TESTCASES: {
				NumberTestcases numberTestcases = (NumberTestcases)theEObject;
				T result = caseNumberTestcases(numberTestcases);
				if (result == null) result = caseTestcaseExecutionStopStrategy(numberTestcases);
				if (result == null) result = caseIdentifier(numberTestcases);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.NUMBER_GENERATION_RUNS: {
				NumberGenerationRuns numberGenerationRuns = (NumberGenerationRuns)theEObject;
				T result = caseNumberGenerationRuns(numberGenerationRuns);
				if (result == null) result = caseTestcaseExecutionStopStrategy(numberGenerationRuns);
				if (result == null) result = caseIdentifier(numberGenerationRuns);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.NO_ISIA: {
				NoISIA noISIA = (NoISIA)theEObject;
				T result = caseNoISIA(noISIA);
				if (result == null) result = caseInternalStateInfluenceAnalysisStrategy(noISIA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbasedPackage.REUSE_INSTANCE_ISIA: {
				ReuseInstanceISIA reuseInstanceISIA = (ReuseInstanceISIA)theEObject;
				T result = caseReuseInstanceISIA(reuseInstanceISIA);
				if (result == null) result = caseInternalStateInfluenceAnalysisStrategy(reuseInstanceISIA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TB Validation Quality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TB Validation Quality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBValidationQuality(TBValidationQuality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Testcase Execution Stop Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Testcase Execution Stop Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestcaseExecutionStopStrategy(TestcaseExecutionStopStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Testcase Generation Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Testcase Generation Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestcaseGenerationStrategy(TestcaseGenerationStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal State Influence Analysis Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal State Influence Analysis Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equidistant Partitions Random</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equidistant Partitions Random</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquidistantPartitionsRandom(EquidistantPartitionsRandom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Testcases</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Testcases</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberTestcases(NumberTestcases object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Generation Runs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Generation Runs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberGenerationRuns(NumberGenerationRuns object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No ISIA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No ISIA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoISIA(NoISIA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reuse Instance ISIA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reuse Instance ISIA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReuseInstanceISIA(ReuseInstanceISIA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualityStatement(QualityStatement object) {
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

} //TestbasedSwitch
