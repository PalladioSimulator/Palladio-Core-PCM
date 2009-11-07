/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.MeasurementScript#getTaskSets <em>Task Sets</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.MeasurementScript#getMachineDescriptions <em>Machine Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMeasurementScript()
 * @model
 * @generated
 */
public interface MeasurementScript extends EObject {
	/**
	 * Returns the value of the '<em><b>Task Sets</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.measurements.TaskSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Sets</em>' reference list.
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMeasurementScript_TaskSets()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TaskSet> getTaskSets();

	/**
	 * Returns the value of the '<em><b>Machine Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.measurements.MachineDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Descriptions</em>' containment reference list.
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMeasurementScript_MachineDescriptions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MachineDescription> getMachineDescriptions();

} // MeasurementScript
