/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.usagemodel.*;

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
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage
 * @generated
 */
public class UsagemodelSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UsagemodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsagemodelSwitch() {
		if (modelPackage == null) {
			modelPackage = UsagemodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UsagemodelPackage.WORKLOAD: {
				Workload workload = (Workload)theEObject;
				Object result = caseWorkload(workload);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.USAGE_SCENARIO: {
				UsageScenario usageScenario = (UsageScenario)theEObject;
				Object result = caseUsageScenario(usageScenario);
				if (result == null) result = caseEntity(usageScenario);
				if (result == null) result = caseIdentifier(usageScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.SCENARIO_BEHAVIOUR: {
				ScenarioBehaviour scenarioBehaviour = (ScenarioBehaviour)theEObject;
				Object result = caseScenarioBehaviour(scenarioBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.ABSTRACT_USER_ACTION: {
				AbstractUserAction abstractUserAction = (AbstractUserAction)theEObject;
				Object result = caseAbstractUserAction(abstractUserAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.USAGE_MODEL: {
				UsageModel usageModel = (UsageModel)theEObject;
				Object result = caseUsageModel(usageModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.STOP: {
				Stop stop = (Stop)theEObject;
				Object result = caseStop(stop);
				if (result == null) result = caseAbstractUserAction(stop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.START: {
				Start start = (Start)theEObject;
				Object result = caseStart(start);
				if (result == null) result = caseAbstractUserAction(start);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.OPEN_WORKLOAD: {
				OpenWorkload openWorkload = (OpenWorkload)theEObject;
				Object result = caseOpenWorkload(openWorkload);
				if (result == null) result = caseWorkload(openWorkload);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				Object result = caseLoop(loop);
				if (result == null) result = caseAbstractUserAction(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL: {
				EntryLevelSystemCall entryLevelSystemCall = (EntryLevelSystemCall)theEObject;
				Object result = caseEntryLevelSystemCall(entryLevelSystemCall);
				if (result == null) result = caseAbstractUserAction(entryLevelSystemCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.CLOSED_WORKLOAD: {
				ClosedWorkload closedWorkload = (ClosedWorkload)theEObject;
				Object result = caseClosedWorkload(closedWorkload);
				if (result == null) result = caseWorkload(closedWorkload);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UsagemodelPackage.BRANCH: {
				Branch branch = (Branch)theEObject;
				Object result = caseBranch(branch);
				if (result == null) result = caseAbstractUserAction(branch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkload(Workload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Usage Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Usage Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUsageScenario(UsageScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Scenario Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Scenario Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract User Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract User Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractUserAction(AbstractUserAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Usage Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Usage Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUsageModel(UsageModel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Stop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Stop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStop(Stop object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStart(Start object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Open Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Open Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOpenWorkload(OpenWorkload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Entry Level System Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Closed Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Closed Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClosedWorkload(ClosedWorkload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBranch(Branch object) {
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
	public Object caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEntity(Entity object) {
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
	public Object defaultCase(EObject object) {
		return null;
	}

} //UsagemodelSwitch
