/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sim Time Stop Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition#getSimulationTime <em>Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage#getSimTimeStopCondition()
 * @model
 * @generated
 */
public interface SimTimeStopCondition extends StopCondition {
	/**
	 * Returns the value of the '<em><b>Simulation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Time</em>' attribute.
	 * @see #setSimulationTime(int)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage#getSimTimeStopCondition_SimulationTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getSimulationTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition#getSimulationTime <em>Simulation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Time</em>' attribute.
	 * @see #getSimulationTime()
	 * @generated
	 */
	void setSimulationTime(int value);

} // SimTimeStopCondition
