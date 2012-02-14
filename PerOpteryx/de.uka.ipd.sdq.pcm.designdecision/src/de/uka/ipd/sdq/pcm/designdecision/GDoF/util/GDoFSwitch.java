/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF.util;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage
 * @generated
 */
public class GDoFSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GDoFPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GDoFSwitch() {
		if (modelPackage == null) {
			modelPackage = GDoFPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GDoFPackage.CHANGEABLE_ELEMENT_DESCRIPTION: {
				ChangeableElementDescription changeableElementDescription = (ChangeableElementDescription)theEObject;
				T result = caseChangeableElementDescription(changeableElementDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.VALUE_RULE: {
				ValueRule valueRule = (ValueRule)theEObject;
				T result = caseValueRule(valueRule);
				if (result == null) result = caseOCLRule(valueRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.OCL_RULE: {
				OCLRule oclRule = (OCLRule)theEObject;
				T result = caseOCLRule(oclRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.HELPER_OCL_DEFINITION: {
				HelperOCLDefinition helperOCLDefinition = (HelperOCLDefinition)theEObject;
				T result = caseHelperOCLDefinition(helperOCLDefinition);
				if (result == null) result = caseOCLRule(helperOCLDefinition);
				if (result == null) result = caseStaticContextRule(helperOCLDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.STATIC_CONTEXT_RULE: {
				StaticContextRule staticContextRule = (StaticContextRule)theEObject;
				T result = caseStaticContextRule(staticContextRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.SELECTION_RULE: {
				SelectionRule selectionRule = (SelectionRule)theEObject;
				T result = caseSelectionRule(selectionRule);
				if (result == null) result = caseOCLRule(selectionRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.DO_FREPOSITORY: {
				DoFRepository doFRepository = (DoFRepository)theEObject;
				T result = caseDoFRepository(doFRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.INSTANCE_SELECTION_RULE: {
				InstanceSelectionRule instanceSelectionRule = (InstanceSelectionRule)theEObject;
				T result = caseInstanceSelectionRule(instanceSelectionRule);
				if (result == null) result = caseSelectionRule(instanceSelectionRule);
				if (result == null) result = caseOCLRule(instanceSelectionRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.STATIC_SELECTION_RULE: {
				StaticSelectionRule staticSelectionRule = (StaticSelectionRule)theEObject;
				T result = caseStaticSelectionRule(staticSelectionRule);
				if (result == null) result = caseSelectionRule(staticSelectionRule);
				if (result == null) result = caseStaticContextRule(staticSelectionRule);
				if (result == null) result = caseOCLRule(staticSelectionRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GDoFPackage.DEGREE_OF_FREEDOM: {
				DegreeOfFreedom degreeOfFreedom = (DegreeOfFreedom)theEObject;
				T result = caseDegreeOfFreedom(degreeOfFreedom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Changeable Element Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Changeable Element Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeableElementDescription(ChangeableElementDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueRule(ValueRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLRule(OCLRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Helper OCL Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Helper OCL Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHelperOCLDefinition(HelperOCLDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Context Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Context Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticContextRule(StaticContextRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionRule(SelectionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do FRepository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do FRepository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoFRepository(DoFRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selection Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selection Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSelectionRule(InstanceSelectionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Selection Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Selection Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticSelectionRule(StaticSelectionRule object) {
		return null;
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GDoFSwitch
