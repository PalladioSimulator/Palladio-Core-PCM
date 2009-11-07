/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements.scheduler;

import measurements.MachineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Strategy Measurement Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link measurements.scheduler.ResourceStrategyMeasurementTask#getDuration <em>Duration</em>}</li>
 *   <li>{@link measurements.scheduler.ResourceStrategyMeasurementTask#getDemand <em>Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask()
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
	 * @see measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask_Duration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getDuration();

	/**
	 * Sets the value of the '{@link measurements.scheduler.ResourceStrategyMeasurementTask#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(int value);

	/**
	 * Returns the value of the '<em><b>Demand</b></em>' attribute.
	 * The literals are from the enumeration {@link measurements.scheduler.ResourceStrategyDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' attribute.
	 * @see measurements.scheduler.ResourceStrategyDemand
	 * @see #setDemand(ResourceStrategyDemand)
	 * @see measurements.scheduler.SchedulerPackage#getResourceStrategyMeasurementTask_Demand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceStrategyDemand getDemand();

	/**
	 * Sets the value of the '{@link measurements.scheduler.ResourceStrategyMeasurementTask#getDemand <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' attribute.
	 * @see measurements.scheduler.ResourceStrategyDemand
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(ResourceStrategyDemand value);

} // ResourceStrategyMeasurementTask
