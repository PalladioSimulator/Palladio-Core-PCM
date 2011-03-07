/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.pcm.qosannotations.*;

import de.uka.ipd.sdq.stoex.RandomVariable;

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
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage
 * @generated
 */
public class QosannotationsSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QosannotationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QosannotationsSwitch() {
		if (modelPackage == null) {
			modelPackage = QosannotationsPackage.eINSTANCE;
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
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME: {
				SpecifiedExecutionTime specifiedExecutionTime = (SpecifiedExecutionTime)theEObject;
				Object result = caseSpecifiedExecutionTime(specifiedExecutionTime);
				if (result == null) result = caseRandomVariable(specifiedExecutionTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QosannotationsPackage.SPECIFIED_FAILURE_PROBABILITY: {
				SpecifiedFailureProbability specifiedFailureProbability = (SpecifiedFailureProbability)theEObject;
				Object result = caseSpecifiedFailureProbability(specifiedFailureProbability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QosannotationsPackage.SYSTEM_SPECIFIED_EXECUTION_TIME: {
				SystemSpecifiedExecutionTime systemSpecifiedExecutionTime = (SystemSpecifiedExecutionTime)theEObject;
				Object result = caseSystemSpecifiedExecutionTime(systemSpecifiedExecutionTime);
				if (result == null) result = caseSpecifiedExecutionTime(systemSpecifiedExecutionTime);
				if (result == null) result = caseRandomVariable(systemSpecifiedExecutionTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QosannotationsPackage.COMPONENT_SPECIFIED_EXECUTION_TIME: {
				ComponentSpecifiedExecutionTime componentSpecifiedExecutionTime = (ComponentSpecifiedExecutionTime)theEObject;
				Object result = caseComponentSpecifiedExecutionTime(componentSpecifiedExecutionTime);
				if (result == null) result = caseSpecifiedExecutionTime(componentSpecifiedExecutionTime);
				if (result == null) result = caseRandomVariable(componentSpecifiedExecutionTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QosannotationsPackage.QO_SANNOTATIONS: {
				QoSAnnotations qoSAnnotations = (QoSAnnotations)theEObject;
				Object result = caseQoSAnnotations(qoSAnnotations);
				if (result == null) result = caseEntity(qoSAnnotations);
				if (result == null) result = caseIdentifier(qoSAnnotations);
				if (result == null) result = caseNamedElement(qoSAnnotations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Specified Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Specified Execution Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSpecifiedExecutionTime(SpecifiedExecutionTime object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Specified Failure Probability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Specified Failure Probability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSpecifiedFailureProbability(SpecifiedFailureProbability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>System Specified Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>System Specified Execution Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSystemSpecifiedExecutionTime(SystemSpecifiedExecutionTime object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Component Specified Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Component Specified Execution Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentSpecifiedExecutionTime(ComponentSpecifiedExecutionTime object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Qo SAnnotations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Qo SAnnotations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseQoSAnnotations(QoSAnnotations object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRandomVariable(RandomVariable object) {
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
	 * Returns the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElement(NamedElement object) {
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

} //QosannotationsSwitch
