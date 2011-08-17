/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration <em>Priority Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration <em>Preemption Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration <em>Queueing Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting <em>In Front After Waiting</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#isWindows <em>Windows</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getInterval <em>Interval</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getStarvationBoost <em>Starvation Boost</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration()
 * @model
 * @generated
 */
public interface SchedulerConfiguration extends Identifier {
	/**
	 * Returns the value of the '<em><b>Priority Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Configuration</em>' containment reference.
	 * @see #setPriorityConfiguration(PriorityConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_PriorityConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PriorityConfiguration getPriorityConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration <em>Priority Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Configuration</em>' containment reference.
	 * @see #getPriorityConfiguration()
	 * @generated
	 */
	void setPriorityConfiguration(PriorityConfiguration value);

	/**
	 * Returns the value of the '<em><b>Preemption Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preemption Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preemption Configuration</em>' containment reference.
	 * @see #setPreemptionConfiguration(PreemptionConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_PreemptionConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PreemptionConfiguration getPreemptionConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration <em>Preemption Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preemption Configuration</em>' containment reference.
	 * @see #getPreemptionConfiguration()
	 * @generated
	 */
	void setPreemptionConfiguration(PreemptionConfiguration value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Queueing Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queueing Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queueing Configuration</em>' containment reference.
	 * @see #setQueueingConfiguration(QueueingConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_QueueingConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	QueueingConfiguration getQueueingConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration <em>Queueing Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queueing Configuration</em>' containment reference.
	 * @see #getQueueingConfiguration()
	 * @generated
	 */
	void setQueueingConfiguration(QueueingConfiguration value);

	/**
	 * Returns the value of the '<em><b>In Front After Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Front After Waiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Front After Waiting</em>' attribute.
	 * @see #setInFrontAfterWaiting(boolean)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_InFrontAfterWaiting()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isInFrontAfterWaiting();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting <em>In Front After Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Front After Waiting</em>' attribute.
	 * @see #isInFrontAfterWaiting()
	 * @generated
	 */
	void setInFrontAfterWaiting(boolean value);

	/**
	 * Returns the value of the '<em><b>Windows</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Windows</em>' attribute.
	 * @see #setWindows(boolean)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_Windows()
	 * @model default="true" unique="false" required="true"
	 * @generated
	 */
	boolean isWindows();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#isWindows <em>Windows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Windows</em>' attribute.
	 * @see #isWindows()
	 * @generated
	 */
	void setWindows(boolean value);

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #setInterval(double)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_Interval()
	 * @model
	 * @generated
	 */
	double getInterval();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(double value);

	/**
	 * Returns the value of the '<em><b>Starvation Boost</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starvation Boost</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starvation Boost</em>' containment reference.
	 * @see #setStarvationBoost(StarvationBoost)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_StarvationBoost()
	 * @model containment="true"
	 * @generated
	 */
	StarvationBoost getStarvationBoost();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getStarvationBoost <em>Starvation Boost</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starvation Boost</em>' containment reference.
	 * @see #getStarvationBoost()
	 * @generated
	 */
	void setStarvationBoost(StarvationBoost value);

} // SchedulerConfiguration
