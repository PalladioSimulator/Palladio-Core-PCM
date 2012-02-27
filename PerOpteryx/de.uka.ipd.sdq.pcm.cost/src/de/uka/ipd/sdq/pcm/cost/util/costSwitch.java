/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.util;

import de.uka.ipd.sdq.pcm.cost.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * @see de.uka.ipd.sdq.pcm.cost.costPackage
 * @generated
 */
public class costSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static costPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public costSwitch() {
		if (modelPackage == null) {
			modelPackage = costPackage.eINSTANCE;
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
			case costPackage.COMPONENT_COST: {
				ComponentCost componentCost = (ComponentCost)theEObject;
				T result = caseComponentCost(componentCost);
				if (result == null) result = caseCost(componentCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.COST: {
				Cost cost = (Cost)theEObject;
				T result = caseCost(cost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.FIXED_LINKING_RESOURCE_COST: {
				FixedLinkingResourceCost fixedLinkingResourceCost = (FixedLinkingResourceCost)theEObject;
				T result = caseFixedLinkingResourceCost(fixedLinkingResourceCost);
				if (result == null) result = caseLinkingResourceCost(fixedLinkingResourceCost);
				if (result == null) result = caseCost(fixedLinkingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.LINKING_RESOURCE_COST: {
				LinkingResourceCost linkingResourceCost = (LinkingResourceCost)theEObject;
				T result = caseLinkingResourceCost(linkingResourceCost);
				if (result == null) result = caseCost(linkingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.FIXED_PROCESSING_RESOURCE_COST: {
				FixedProcessingResourceCost fixedProcessingResourceCost = (FixedProcessingResourceCost)theEObject;
				T result = caseFixedProcessingResourceCost(fixedProcessingResourceCost);
				if (result == null) result = caseProcessingResourceCost(fixedProcessingResourceCost);
				if (result == null) result = caseCost(fixedProcessingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.PROCESSING_RESOURCE_COST: {
				ProcessingResourceCost processingResourceCost = (ProcessingResourceCost)theEObject;
				T result = caseProcessingResourceCost(processingResourceCost);
				if (result == null) result = caseCost(processingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.VARIABLE_COST: {
				VariableCost variableCost = (VariableCost)theEObject;
				T result = caseVariableCost(variableCost);
				if (result == null) result = caseCost(variableCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.VARIABLE_LINKING_RESOURCE_COST: {
				VariableLinkingResourceCost variableLinkingResourceCost = (VariableLinkingResourceCost)theEObject;
				T result = caseVariableLinkingResourceCost(variableLinkingResourceCost);
				if (result == null) result = caseVariableCost(variableLinkingResourceCost);
				if (result == null) result = caseLinkingResourceCost(variableLinkingResourceCost);
				if (result == null) result = caseCost(variableLinkingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST: {
				VariableProcessingResourceCost variableProcessingResourceCost = (VariableProcessingResourceCost)theEObject;
				T result = caseVariableProcessingResourceCost(variableProcessingResourceCost);
				if (result == null) result = caseVariableCost(variableProcessingResourceCost);
				if (result == null) result = caseProcessingResourceCost(variableProcessingResourceCost);
				if (result == null) result = caseCost(variableProcessingResourceCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.SCALAR_FUNCTION: {
				ScalarFunction scalarFunction = (ScalarFunction)theEObject;
				T result = caseScalarFunction(scalarFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.COST_REPOSITORY: {
				CostRepository costRepository = (CostRepository)theEObject;
				T result = caseCostRepository(costRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case costPackage.COMPONENT_COST_PER_INSTANCE: {
				ComponentCostPerInstance componentCostPerInstance = (ComponentCostPerInstance)theEObject;
				T result = caseComponentCostPerInstance(componentCostPerInstance);
				if (result == null) result = caseComponentCost(componentCostPerInstance);
				if (result == null) result = caseCost(componentCostPerInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentCost(ComponentCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCost(Cost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Linking Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Linking Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedLinkingResourceCost(FixedLinkingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linking Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linking Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkingResourceCost(LinkingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Processing Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Processing Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedProcessingResourceCost(FixedProcessingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingResourceCost(ProcessingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableCost(VariableCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Linking Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Linking Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableLinkingResourceCost(VariableLinkingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Processing Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Processing Resource Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableProcessingResourceCost(VariableProcessingResourceCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarFunction(ScalarFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cost Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cost Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCostRepository(CostRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Cost Per Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Cost Per Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentCostPerInstance(ComponentCostPerInstance object) {
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

} //costSwitch
