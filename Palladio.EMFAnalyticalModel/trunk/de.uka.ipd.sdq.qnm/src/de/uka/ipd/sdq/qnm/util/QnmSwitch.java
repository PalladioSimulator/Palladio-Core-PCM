/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.util;

import de.uka.ipd.sdq.qnm.*;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

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
 * @see de.uka.ipd.sdq.qnm.QnmPackage
 * @generated
 */
public class QnmSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QnmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QnmSwitch() {
		if (modelPackage == null) {
			modelPackage = QnmPackage.eINSTANCE;
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
			case QnmPackage.QN_MODEL: {
				QNModel qnModel = (QNModel)theEObject;
				Object result = caseQNModel(qnModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.TASK: {
				Task task = (Task)theEObject;
				Object result = caseTask(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.COMPOSITE_RESOURCE_USAGE: {
				CompositeResourceUsage compositeResourceUsage = (CompositeResourceUsage)theEObject;
				Object result = caseCompositeResourceUsage(compositeResourceUsage);
				if (result == null) result = caseAbstractResourceUsage(compositeResourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.SEQUENTIAL_RESOURCE_USAGE: {
				SequentialResourceUsage sequentialResourceUsage = (SequentialResourceUsage)theEObject;
				Object result = caseSequentialResourceUsage(sequentialResourceUsage);
				if (result == null) result = caseCompositeResourceUsage(sequentialResourceUsage);
				if (result == null) result = caseAbstractResourceUsage(sequentialResourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.ALTERNATIVE_RESOURCE_USAGE: {
				AlternativeResourceUsage alternativeResourceUsage = (AlternativeResourceUsage)theEObject;
				Object result = caseAlternativeResourceUsage(alternativeResourceUsage);
				if (result == null) result = caseCompositeResourceUsage(alternativeResourceUsage);
				if (result == null) result = caseAbstractResourceUsage(alternativeResourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.ITERATIVE_RESOURCE_USAGE: {
				IterativeResourceUsage iterativeResourceUsage = (IterativeResourceUsage)theEObject;
				Object result = caseIterativeResourceUsage(iterativeResourceUsage);
				if (result == null) result = caseCompositeResourceUsage(iterativeResourceUsage);
				if (result == null) result = caseAbstractResourceUsage(iterativeResourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.PARALLEL_RESOURCE_USAGE: {
				ParallelResourceUsage parallelResourceUsage = (ParallelResourceUsage)theEObject;
				Object result = caseParallelResourceUsage(parallelResourceUsage);
				if (result == null) result = caseCompositeResourceUsage(parallelResourceUsage);
				if (result == null) result = caseAbstractResourceUsage(parallelResourceUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>QN Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>QN Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseQNModel(QNModel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Composite Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composite Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeResourceUsage(CompositeResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sequential Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sequential Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequentialResourceUsage(SequentialResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Alternative Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Alternative Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAlternativeResourceUsage(AlternativeResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterative Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterative Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterativeResourceUsage(IterativeResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parallel Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parallel Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParallelResourceUsage(ParallelResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractResourceUsage(AbstractResourceUsage object) {
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

} //QnmSwitch
