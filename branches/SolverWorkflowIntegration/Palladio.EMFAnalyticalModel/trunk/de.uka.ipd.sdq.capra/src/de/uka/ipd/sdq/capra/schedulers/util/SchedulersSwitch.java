/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.util;

import de.uka.ipd.sdq.capra.schedulers.*;

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
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage
 * @generated
 */
public class SchedulersSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulersSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulersPackage.eINSTANCE;
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
			case SchedulersPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.SELECTION_POLICY: {
				SelectionPolicy selectionPolicy = (SelectionPolicy)theEObject;
				T result = caseSelectionPolicy(selectionPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.TIME_CONSUMPTION: {
				TimeConsumption timeConsumption = (TimeConsumption)theEObject;
				T result = caseTimeConsumption(timeConsumption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.NON_PREEMPTIVE: {
				NonPreemptive nonPreemptive = (NonPreemptive)theEObject;
				T result = caseNonPreemptive(nonPreemptive);
				if (result == null) result = caseAssignment(nonPreemptive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.PREEMPTIVE: {
				Preemptive preemptive = (Preemptive)theEObject;
				T result = casePreemptive(preemptive);
				if (result == null) result = caseAssignment(preemptive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.QUANTUM: {
				Quantum quantum = (Quantum)theEObject;
				T result = caseQuantum(quantum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.WAITING_TIME: {
				WaitingTime waitingTime = (WaitingTime)theEObject;
				T result = caseWaitingTime(waitingTime);
				if (result == null) result = caseSelectionPolicy(waitingTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.PRIORITY: {
				Priority priority = (Priority)theEObject;
				T result = casePriority(priority);
				if (result == null) result = caseSelectionPolicy(priority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.PRIORTY_QUANTUMS: {
				PriortyQuantums priortyQuantums = (PriortyQuantums)theEObject;
				T result = casePriortyQuantums(priortyQuantums);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulersPackage.SCHEDULER: {
				Scheduler scheduler = (Scheduler)theEObject;
				T result = caseScheduler(scheduler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionPolicy(SelectionPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Consumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConsumption(TimeConsumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Preemptive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Preemptive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonPreemptive(NonPreemptive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preemptive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preemptive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreemptive(Preemptive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quantum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quantum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuantum(Quantum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Waiting Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Waiting Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitingTime(WaitingTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriority(Priority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priorty Quantums</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priorty Quantums</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriortyQuantums(PriortyQuantums object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduler(Scheduler object) {
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

} //SchedulersSwitch
