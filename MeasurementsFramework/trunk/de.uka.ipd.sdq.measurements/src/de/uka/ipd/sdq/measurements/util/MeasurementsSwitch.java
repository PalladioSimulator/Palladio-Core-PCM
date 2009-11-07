/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.MachineMapping;
import de.uka.ipd.sdq.measurements.MachineReference;
import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.PlainMachineReference;
import de.uka.ipd.sdq.measurements.VirtualMachineReference;

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
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage
 * @generated
 */
public class MeasurementsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MeasurementsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementsSwitch() {
		if (modelPackage == null) {
			modelPackage = MeasurementsPackage.eINSTANCE;
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
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE: {
				VirtualMachineReference virtualMachineReference = (VirtualMachineReference)theEObject;
				T result = caseVirtualMachineReference(virtualMachineReference);
				if (result == null) result = caseMachineReference(virtualMachineReference);
				if (result == null) result = caseIdentifier(virtualMachineReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementsPackage.MACHINE_REFERENCE: {
				MachineReference machineReference = (MachineReference)theEObject;
				T result = caseMachineReference(machineReference);
				if (result == null) result = caseIdentifier(machineReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementsPackage.PLAIN_MACHINE_REFERENCE: {
				PlainMachineReference plainMachineReference = (PlainMachineReference)theEObject;
				T result = casePlainMachineReference(plainMachineReference);
				if (result == null) result = caseMachineReference(plainMachineReference);
				if (result == null) result = caseIdentifier(plainMachineReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementsPackage.MEASUREMENT_SCRIPT: {
				MeasurementScript measurementScript = (MeasurementScript)theEObject;
				T result = caseMeasurementScript(measurementScript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementsPackage.MACHINE_DESCRIPTION: {
				MachineDescription machineDescription = (MachineDescription)theEObject;
				T result = caseMachineDescription(machineDescription);
				if (result == null) result = caseIdentifier(machineDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementsPackage.MACHINE_MAPPING: {
				MachineMapping machineMapping = (MachineMapping)theEObject;
				T result = caseMachineMapping(machineMapping);
				if (result == null) result = caseIdentifier(machineMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Machine Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Machine Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualMachineReference(VirtualMachineReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineReference(MachineReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plain Machine Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plain Machine Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlainMachineReference(PlainMachineReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Script</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementScript(MeasurementScript object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineDescription(MachineDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineMapping(MachineMapping object) {
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

} //MeasurementsSwitch
