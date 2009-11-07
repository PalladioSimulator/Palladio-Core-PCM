/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler;

import de.uka.ipd.sdq.measurements.MachineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Strategy Measurement Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDemand <em>Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask()
 * @model
 * @generated
 */
public interface ResourceStrategyMeasurementTask extends MachineTask {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(int)
	 * @see de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask_Duration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getDuration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(int value);

	/**
	 * Returns the value of the '<em><b>Demand</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' attribute.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand
	 * @see #setDemand(ResourceStrategyDemand)
	 * @see de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask_Demand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceStrategyDemand getDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDemand <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' attribute.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(ResourceStrategyDemand value);

} // ResourceStrategyMeasurementTask
