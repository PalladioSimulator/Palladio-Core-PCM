/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks;

import de.uka.ipd.sdq.measurements.MachineReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.tasks.MachineTask#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage#getMachineTask()
 * @model abstract="true"
 * @generated
 */
public interface MachineTask extends AbstractTask {
	/**
	 * Returns the value of the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' reference.
	 * @see #setMachine(MachineReference)
	 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage#getMachineTask_Machine()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MachineReference getMachine();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.tasks.MachineTask#getMachine <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(MachineReference value);

} // MachineTask
