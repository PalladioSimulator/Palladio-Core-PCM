/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.util;

import de.uka.ipd.sdq.qnm.*;

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
			case QnmPackage.CUSTOMER: {
				Customer customer = (Customer)theEObject;
				Object result = caseCustomer(customer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.DEMAND: {
				Demand demand = (Demand)theEObject;
				Object result = caseDemand(demand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.SERVER: {
				Server server = (Server)theEObject;
				Object result = caseServer(server);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.DEVICE_SERVER: {
				DeviceServer deviceServer = (DeviceServer)theEObject;
				Object result = caseDeviceServer(deviceServer);
				if (result == null) result = caseServer(deviceServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.LOGICAL_SERVER: {
				LogicalServer logicalServer = (LogicalServer)theEObject;
				Object result = caseLogicalServer(logicalServer);
				if (result == null) result = caseServer(logicalServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.LOGICAL_DEMAND: {
				LogicalDemand logicalDemand = (LogicalDemand)theEObject;
				Object result = caseLogicalDemand(logicalDemand);
				if (result == null) result = caseDemand(logicalDemand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.DEVICE_DEMAND: {
				DeviceDemand deviceDemand = (DeviceDemand)theEObject;
				Object result = caseDeviceDemand(deviceDemand);
				if (result == null) result = caseDemand(deviceDemand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.SEQUENTIAL_DEMAND: {
				SequentialDemand sequentialDemand = (SequentialDemand)theEObject;
				Object result = caseSequentialDemand(sequentialDemand);
				if (result == null) result = caseLogicalDemand(sequentialDemand);
				if (result == null) result = caseDemand(sequentialDemand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.ALTERNATIVE_DEMAND: {
				AlternativeDemand alternativeDemand = (AlternativeDemand)theEObject;
				Object result = caseAlternativeDemand(alternativeDemand);
				if (result == null) result = caseLogicalDemand(alternativeDemand);
				if (result == null) result = caseDemand(alternativeDemand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.ITERATIVE_DEMAND: {
				IterativeDemand iterativeDemand = (IterativeDemand)theEObject;
				Object result = caseIterativeDemand(iterativeDemand);
				if (result == null) result = caseLogicalDemand(iterativeDemand);
				if (result == null) result = caseDemand(iterativeDemand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QnmPackage.PARALLEL_DEMAND: {
				ParallelDemand parallelDemand = (ParallelDemand)theEObject;
				Object result = caseParallelDemand(parallelDemand);
				if (result == null) result = caseLogicalDemand(parallelDemand);
				if (result == null) result = caseDemand(parallelDemand);
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
	 * Returns the result of interpretting the object as an instance of '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Customer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCustomer(Customer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDemand(Demand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseServer(Server object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Device Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Device Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeviceServer(DeviceServer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Logical Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Logical Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLogicalServer(LogicalServer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Logical Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Logical Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLogicalDemand(LogicalDemand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Device Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Device Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeviceDemand(DeviceDemand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sequential Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sequential Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequentialDemand(SequentialDemand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Alternative Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Alternative Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAlternativeDemand(AlternativeDemand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterative Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterative Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterativeDemand(IterativeDemand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parallel Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parallel Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParallelDemand(ParallelDemand object) {
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
