/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.util;

import de.uka.ipd.sdq.pcm.designdecision.*;

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
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage
 * @generated
 */
public class designdecisionSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static designdecisionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionSwitch() {
		if (modelPackage == null) {
			modelPackage = designdecisionPackage.eINSTANCE;
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
			case designdecisionPackage.DEGREE_OF_FREEDOM: {
				DegreeOfFreedom degreeOfFreedom = (DegreeOfFreedom)theEObject;
				T result = caseDegreeOfFreedom(degreeOfFreedom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.RANGE_DEGREE: {
				RangeDegree rangeDegree = (RangeDegree)theEObject;
				T result = caseRangeDegree(rangeDegree);
				if (result == null) result = caseDegreeOfFreedom(rangeDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ENUMERATION_DEGREE: {
				EnumerationDegree enumerationDegree = (EnumerationDegree)theEObject;
				T result = caseEnumerationDegree(enumerationDegree);
				if (result == null) result = caseDegreeOfFreedom(enumerationDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ENUMERATION_CHOICE: {
				EnumerationChoice enumerationChoice = (EnumerationChoice)theEObject;
				T result = caseEnumerationChoice(enumerationChoice);
				if (result == null) result = caseChoice(enumerationChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE: {
				ContinousRangeChoice continousRangeChoice = (ContinousRangeChoice)theEObject;
				T result = caseContinousRangeChoice(continousRangeChoice);
				if (result == null) result = caseChoice(continousRangeChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.PROCESSING_RATE_DEGREE: {
				ProcessingRateDegree processingRateDegree = (ProcessingRateDegree)theEObject;
				T result = caseProcessingRateDegree(processingRateDegree);
				if (result == null) result = caseContinuousRangeDegree(processingRateDegree);
				if (result == null) result = caseRangeDegree(processingRateDegree);
				if (result == null) result = caseDegreeOfFreedom(processingRateDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CONTINUOUS_RANGE_DEGREE: {
				ContinuousRangeDegree continuousRangeDegree = (ContinuousRangeDegree)theEObject;
				T result = caseContinuousRangeDegree(continuousRangeDegree);
				if (result == null) result = caseRangeDegree(continuousRangeDegree);
				if (result == null) result = caseDegreeOfFreedom(continuousRangeDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ALLOCATION_DEGREE: {
				AllocationDegree allocationDegree = (AllocationDegree)theEObject;
				T result = caseAllocationDegree(allocationDegree);
				if (result == null) result = caseEnumerationDegree(allocationDegree);
				if (result == null) result = caseDegreeOfFreedom(allocationDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ASSEMBLED_COMPONENT_DEGREE: {
				AssembledComponentDegree assembledComponentDegree = (AssembledComponentDegree)theEObject;
				T result = caseAssembledComponentDegree(assembledComponentDegree);
				if (result == null) result = caseEnumerationDegree(assembledComponentDegree);
				if (result == null) result = caseDegreeOfFreedom(assembledComponentDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.DISCRETE_RANGE_DEGREE: {
				DiscreteRangeDegree discreteRangeDegree = (DiscreteRangeDegree)theEObject;
				T result = caseDiscreteRangeDegree(discreteRangeDegree);
				if (result == null) result = caseRangeDegree(discreteRangeDegree);
				if (result == null) result = caseDegreeOfFreedom(discreteRangeDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.DISCRETE_RANGE_CHOICE: {
				DiscreteRangeChoice discreteRangeChoice = (DiscreteRangeChoice)theEObject;
				T result = caseDiscreteRangeChoice(discreteRangeChoice);
				if (result == null) result = caseChoice(discreteRangeChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DEGREE: {
				ResourceContainerReplicationDegree resourceContainerReplicationDegree = (ResourceContainerReplicationDegree)theEObject;
				T result = caseResourceContainerReplicationDegree(resourceContainerReplicationDegree);
				if (result == null) result = caseDiscreteRangeDegree(resourceContainerReplicationDegree);
				if (result == null) result = caseRangeDegree(resourceContainerReplicationDegree);
				if (result == null) result = caseDegreeOfFreedom(resourceContainerReplicationDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.PROBLEM: {
				Problem problem = (Problem)theEObject;
				T result = caseProblem(problem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CONNECTOR_CONFIG_DEGREE: {
				ConnectorConfigDegree connectorConfigDegree = (ConnectorConfigDegree)theEObject;
				T result = caseConnectorConfigDegree(connectorConfigDegree);
				if (result == null) result = caseEnumerationDegree(connectorConfigDegree);
				if (result == null) result = caseDegreeOfFreedom(connectorConfigDegree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CANDIDATE: {
				Candidate candidate = (Candidate)theEObject;
				T result = caseCandidate(candidate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CANDIDATES: {
				Candidates candidates = (Candidates)theEObject;
				T result = caseCandidates(candidates);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Degree Of Freedom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Degree Of Freedom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDegreeOfFreedom(DegreeOfFreedom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeDegree(RangeDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationDegree(EnumerationDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationChoice(EnumerationChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continous Range Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continous Range Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinousRangeChoice(ContinousRangeChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Rate Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Rate Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingRateDegree(ProcessingRateDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continuous Range Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continuous Range Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinuousRangeDegree(ContinuousRangeDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocationDegree(AllocationDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembled Component Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembled Component Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssembledComponentDegree(AssembledComponentDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discrete Range Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discrete Range Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscreteRangeDegree(DiscreteRangeDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discrete Range Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discrete Range Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscreteRangeChoice(DiscreteRangeChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Container Replication Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Container Replication Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceContainerReplicationDegree(ResourceContainerReplicationDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProblem(Problem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Config Degree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Config Degree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorConfigDegree(ConnectorConfigDegree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Candidate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Candidate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCandidate(Candidate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Candidates</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Candidates</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCandidates(Candidates object) {
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

} //designdecisionSwitch
