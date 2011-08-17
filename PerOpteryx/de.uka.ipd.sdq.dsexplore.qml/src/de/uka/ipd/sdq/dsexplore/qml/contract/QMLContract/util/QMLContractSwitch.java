/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.*;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclaration;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

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
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage
 * @generated
 */
public class QMLContractSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QMLContractPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractSwitch() {
		if (modelPackage == null) {
			modelPackage = QMLContractPackage.eINSTANCE;
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT: {
				SimpleQMLContract simpleQMLContract = (SimpleQMLContract)theEObject;
				T result = caseSimpleQMLContract(simpleQMLContract);
				if (result == null) result = caseGenericQMLContract(simpleQMLContract);
				if (result == null) result = caseQMLDeclaration(simpleQMLContract);
				if (result == null) result = caseEntity(simpleQMLContract);
				if (result == null) result = caseIdentifier(simpleQMLContract);
				if (result == null) result = caseNamedElement(simpleQMLContract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.CRITERION: {
				Criterion criterion = (Criterion)theEObject;
				T result = caseCriterion(criterion);
				if (result == null) result = caseIdentifier(criterion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.EVALUATION_ASPECT: {
				EvaluationAspect evaluationAspect = (EvaluationAspect)theEObject;
				T result = caseEvaluationAspect(evaluationAspect);
				if (result == null) result = caseIdentifier(evaluationAspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.ASPECT_REQUIREMENT: {
				AspectRequirement aspectRequirement = (AspectRequirement)theEObject;
				T result = caseAspectRequirement(aspectRequirement);
				if (result == null) result = caseIdentifier(aspectRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.VALUE_LITERAL: {
				ValueLiteral valueLiteral = (ValueLiteral)theEObject;
				T result = caseValueLiteral(valueLiteral);
				if (result == null) result = caseIdentifier(valueLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.PERCENTILE: {
				Percentile percentile = (Percentile)theEObject;
				T result = casePercentile(percentile);
				if (result == null) result = casePointEstimator(percentile);
				if (result == null) result = caseStochasticEvaluationAspect(percentile);
				if (result == null) result = caseEvaluationAspect(percentile);
				if (result == null) result = caseIdentifier(percentile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.POINT_ESTIMATOR: {
				PointEstimator pointEstimator = (PointEstimator)theEObject;
				T result = casePointEstimator(pointEstimator);
				if (result == null) result = caseStochasticEvaluationAspect(pointEstimator);
				if (result == null) result = caseEvaluationAspect(pointEstimator);
				if (result == null) result = caseIdentifier(pointEstimator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.STOCHASTIC_EVALUATION_ASPECT: {
				StochasticEvaluationAspect stochasticEvaluationAspect = (StochasticEvaluationAspect)theEObject;
				T result = caseStochasticEvaluationAspect(stochasticEvaluationAspect);
				if (result == null) result = caseEvaluationAspect(stochasticEvaluationAspect);
				if (result == null) result = caseIdentifier(stochasticEvaluationAspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.FREQUENCY: {
				Frequency frequency = (Frequency)theEObject;
				T result = caseFrequency(frequency);
				if (result == null) result = caseStochasticEvaluationAspect(frequency);
				if (result == null) result = caseEvaluationAspect(frequency);
				if (result == null) result = caseIdentifier(frequency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.RANGE_VALUE: {
				RangeValue rangeValue = (RangeValue)theEObject;
				T result = caseRangeValue(rangeValue);
				if (result == null) result = caseIdentifier(rangeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.MEAN: {
				Mean mean = (Mean)theEObject;
				T result = caseMean(mean);
				if (result == null) result = casePointEstimator(mean);
				if (result == null) result = caseStochasticEvaluationAspect(mean);
				if (result == null) result = caseEvaluationAspect(mean);
				if (result == null) result = caseIdentifier(mean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.VARIANCE: {
				Variance variance = (Variance)theEObject;
				T result = caseVariance(variance);
				if (result == null) result = casePointEstimator(variance);
				if (result == null) result = caseStochasticEvaluationAspect(variance);
				if (result == null) result = caseEvaluationAspect(variance);
				if (result == null) result = caseIdentifier(variance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseValueLiteral(numericLiteral);
				if (result == null) result = caseIdentifier(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.ENUM_LITERAL: {
				EnumLiteral enumLiteral = (EnumLiteral)theEObject;
				T result = caseEnumLiteral(enumLiteral);
				if (result == null) result = caseValueLiteral(enumLiteral);
				if (result == null) result = caseIdentifier(enumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.SET_LITERAL: {
				SetLiteral setLiteral = (SetLiteral)theEObject;
				T result = caseSetLiteral(setLiteral);
				if (result == null) result = caseValueLiteral(setLiteral);
				if (result == null) result = caseIdentifier(setLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.REFINED_QML_CONTRACT: {
				RefinedQMLContract refinedQMLContract = (RefinedQMLContract)theEObject;
				T result = caseRefinedQMLContract(refinedQMLContract);
				if (result == null) result = caseGenericQMLContract(refinedQMLContract);
				if (result == null) result = caseQMLDeclaration(refinedQMLContract);
				if (result == null) result = caseEntity(refinedQMLContract);
				if (result == null) result = caseIdentifier(refinedQMLContract);
				if (result == null) result = caseNamedElement(refinedQMLContract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseDeterministicEvaluationAspect(value);
				if (result == null) result = caseEvaluationAspect(value);
				if (result == null) result = caseIdentifier(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.DETERMINISTIC_EVALUATION_ASPECT: {
				DeterministicEvaluationAspect deterministicEvaluationAspect = (DeterministicEvaluationAspect)theEObject;
				T result = caseDeterministicEvaluationAspect(deterministicEvaluationAspect);
				if (result == null) result = caseEvaluationAspect(deterministicEvaluationAspect);
				if (result == null) result = caseIdentifier(deterministicEvaluationAspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.OBJECTIVE: {
				Objective objective = (Objective)theEObject;
				T result = caseObjective(objective);
				if (result == null) result = caseCriterion(objective);
				if (result == null) result = caseIdentifier(objective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseCriterion(constraint);
				if (result == null) result = caseIdentifier(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.RESTRICTION: {
				Restriction restriction = (Restriction)theEObject;
				T result = caseRestriction(restriction);
				if (result == null) result = caseAspectRequirement(restriction);
				if (result == null) result = caseIdentifier(restriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.GOAL: {
				Goal goal = (Goal)theEObject;
				T result = caseGoal(goal);
				if (result == null) result = caseAspectRequirement(goal);
				if (result == null) result = caseIdentifier(goal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QMLContractPackage.GENERIC_QML_CONTRACT: {
				GenericQMLContract genericQMLContract = (GenericQMLContract)theEObject;
				T result = caseGenericQMLContract(genericQMLContract);
				if (result == null) result = caseQMLDeclaration(genericQMLContract);
				if (result == null) result = caseEntity(genericQMLContract);
				if (result == null) result = caseIdentifier(genericQMLContract);
				if (result == null) result = caseNamedElement(genericQMLContract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple QML Contract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple QML Contract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleQMLContract(SimpleQMLContract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Criterion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCriterion(Criterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationAspect(EvaluationAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectRequirement(AspectRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueLiteral(ValueLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Percentile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Percentile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePercentile(Percentile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Estimator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Estimator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointEstimator(PointEstimator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic Evaluation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic Evaluation Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStochasticEvaluationAspect(StochasticEvaluationAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frequency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frequency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFrequency(Frequency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeValue(RangeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMean(Mean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariance(Variance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteral(NumericLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetLiteral(SetLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refined QML Contract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refined QML Contract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinedQMLContract(RefinedQMLContract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deterministic Evaluation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deterministic Evaluation Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeterministicEvaluationAspect(DeterministicEvaluationAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjective(Objective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestriction(Restriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoal(Goal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic QML Contract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic QML Contract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericQMLContract(GenericQMLContract object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QML Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QML Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQMLDeclaration(QMLDeclaration object) {
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

} //QMLContractSwitch
