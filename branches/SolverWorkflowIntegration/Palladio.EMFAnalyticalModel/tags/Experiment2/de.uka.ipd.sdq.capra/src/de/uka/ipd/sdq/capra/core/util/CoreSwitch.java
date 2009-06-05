/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.util;

import de.uka.ipd.sdq.capra.core.*;

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
 * @see de.uka.ipd.sdq.capra.core.CorePackage
 * @generated
 */
public class CoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
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
			case CorePackage.CAPRA_EXPRESSION: {
				CapraExpression capraExpression = (CapraExpression)theEObject;
				T result = caseCapraExpression(capraExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.TERMINAL: {
				Terminal terminal = (Terminal)theEObject;
				T result = caseTerminal(terminal);
				if (result == null) result = caseCapraExpression(terminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.OPERATOR: {
				Operator operator = (Operator)theEObject;
				T result = caseOperator(operator);
				if (result == null) result = caseCapraExpression(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EVENT_ACTION: {
				EventAction eventAction = (EventAction)theEObject;
				T result = caseEventAction(eventAction);
				if (result == null) result = caseAction(eventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMMUNICATION_IDENTIFIER: {
				CommunicationIdentifier communicationIdentifier = (CommunicationIdentifier)theEObject;
				T result = caseCommunicationIdentifier(communicationIdentifier);
				if (result == null) result = caseIdentifier(communicationIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEMAND_ACTION: {
				DemandAction demandAction = (DemandAction)theEObject;
				T result = caseDemandAction(demandAction);
				if (result == null) result = caseAction(demandAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEMAND_IDENTIFIER: {
				DemandIdentifier demandIdentifier = (DemandIdentifier)theEObject;
				T result = caseDemandIdentifier(demandIdentifier);
				if (result == null) result = caseIdentifier(demandIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RESOURCE_USAGE: {
				ResourceUsage resourceUsage = (ResourceUsage)theEObject;
				T result = caseResourceUsage(resourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SUCCESSFUL_TERMINATION: {
				SuccessfulTermination successfulTermination = (SuccessfulTermination)theEObject;
				T result = caseSuccessfulTermination(successfulTermination);
				if (result == null) result = caseTerminal(successfulTermination);
				if (result == null) result = caseCapraExpression(successfulTermination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROBABILISTIC_PREFIX: {
				ProbabilisticPrefix probabilisticPrefix = (ProbabilisticPrefix)theEObject;
				T result = caseProbabilisticPrefix(probabilisticPrefix);
				if (result == null) result = caseOperator(probabilisticPrefix);
				if (result == null) result = caseCapraExpression(probabilisticPrefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INTERNAL_SELECTOR: {
				InternalSelector internalSelector = (InternalSelector)theEObject;
				T result = caseInternalSelector(internalSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseOperator(choice);
				if (result == null) result = caseCapraExpression(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXTERNAL_SELECTOR: {
				ExternalSelector externalSelector = (ExternalSelector)theEObject;
				T result = caseExternalSelector(externalSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INPUT_EVENT_ACTION: {
				InputEventAction inputEventAction = (InputEventAction)theEObject;
				T result = caseInputEventAction(inputEventAction);
				if (result == null) result = caseEventAction(inputEventAction);
				if (result == null) result = caseAction(inputEventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.OUTPUT_EVENT_ACTION: {
				OutputEventAction outputEventAction = (OutputEventAction)theEObject;
				T result = caseOutputEventAction(outputEventAction);
				if (result == null) result = caseEventAction(outputEventAction);
				if (result == null) result = caseAction(outputEventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMMUNICATION_EVENT_ACTION: {
				CommunicationEventAction communicationEventAction = (CommunicationEventAction)theEObject;
				T result = caseCommunicationEventAction(communicationEventAction);
				if (result == null) result = caseEventAction(communicationEventAction);
				if (result == null) result = caseAction(communicationEventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BOUNDED_LOOP: {
				BoundedLoop boundedLoop = (BoundedLoop)theEObject;
				T result = caseBoundedLoop(boundedLoop);
				if (result == null) result = caseOperator(boundedLoop);
				if (result == null) result = caseCapraExpression(boundedLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PARALLEL_COMPOSITION: {
				ParallelComposition parallelComposition = (ParallelComposition)theEObject;
				T result = caseParallelComposition(parallelComposition);
				if (result == null) result = caseOperator(parallelComposition);
				if (result == null) result = caseCapraExpression(parallelComposition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RESTRICTION: {
				Restriction restriction = (Restriction)theEObject;
				T result = caseRestriction(restriction);
				if (result == null) result = caseOperator(restriction);
				if (result == null) result = caseCapraExpression(restriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RENAMING: {
				Renaming renaming = (Renaming)theEObject;
				T result = caseRenaming(renaming);
				if (result == null) result = caseOperator(renaming);
				if (result == null) result = caseCapraExpression(renaming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SILENT_IDENTIFIER: {
				SilentIdentifier silentIdentifier = (SilentIdentifier)theEObject;
				T result = caseSilentIdentifier(silentIdentifier);
				if (result == null) result = caseDemandIdentifier(silentIdentifier);
				if (result == null) result = caseCommunicationIdentifier(silentIdentifier);
				if (result == null) result = caseIdentifier(silentIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROCESS_VARIABLE: {
				ProcessVariable processVariable = (ProcessVariable)theEObject;
				T result = caseProcessVariable(processVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROCESS_VARIABLE_USAGE: {
				ProcessVariableUsage processVariableUsage = (ProcessVariableUsage)theEObject;
				T result = caseProcessVariableUsage(processVariableUsage);
				if (result == null) result = caseCapraExpression(processVariableUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Capra Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Capra Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapraExpression(CapraExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminal(Terminal object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperator(Operator object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventAction(EventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Communication Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Communication Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationIdentifier(CommunicationIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Demand Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Demand Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDemandAction(DemandAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Demand Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Demand Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDemandIdentifier(DemandIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceUsage(ResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Successful Termination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Successful Termination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuccessfulTermination(SuccessfulTermination object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probabilistic Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probabilistic Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbabilisticPrefix(ProbabilisticPrefix object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Internal Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Internal Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalSelector(InternalSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>External Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>External Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalSelector(ExternalSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Input Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Input Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputEventAction(InputEventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Output Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Output Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputEventAction(OutputEventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Communication Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Communication Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationEventAction(CommunicationEventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bounded Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bounded Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundedLoop(BoundedLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parallel Composition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parallel Composition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelComposition(ParallelComposition object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestriction(Restriction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Renaming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Renaming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenaming(Renaming object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Silent Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Silent Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSilentIdentifier(SilentIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Process Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Process Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessVariable(ProcessVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Process Variable Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Process Variable Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessVariableUsage(ProcessVariableUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch
