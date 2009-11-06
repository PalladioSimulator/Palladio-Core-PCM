/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;

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
 *   <li>{@link measurements.MeasurementScript#getTaskSets <em>Task Sets</em>}</li>
 *   <li>{@link measurements.MeasurementScript#getMachineDescriptions <em>Machine Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.MeasurementsPackage#getMeasurementScript()
 * @model
 * @generated
 */
public interface MeasurementScript extends EObject {
	/**
	 * Returns the value of the '<em><b>Task Sets</b></em>' reference list.
	 * The list contents are of type {@link measurements.TaskSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Sets</em>' reference list.
	 * @see measurements.MeasurementsPackage#getMeasurementScript_TaskSets()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TaskSet> getTaskSets();

	/**
	 * Returns the value of the '<em><b>Machine Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link measurements.MachineDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Descriptions</em>' containment reference list.
	 * @see measurements.MeasurementsPackage#getMeasurementScript_MachineDescriptions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MachineDescription> getMachineDescriptions();

} // MeasurementScript
