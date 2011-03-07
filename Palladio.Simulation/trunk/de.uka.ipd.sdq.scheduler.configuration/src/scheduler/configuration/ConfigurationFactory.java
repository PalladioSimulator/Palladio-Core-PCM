/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scheduler.configuration.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationFactory eINSTANCE = scheduler.configuration.impl.ConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dynamic Priority Boost Configuratioin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Priority Boost Configuratioin</em>'.
	 * @generated
	 */
	DynamicPriorityBoostConfiguratioin createDynamicPriorityBoostConfiguratioin();

	/**
	 * Returns a new object of class '<em>Load Balancing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Balancing</em>'.
	 * @generated
	 */
	LoadBalancing createLoadBalancing();

	/**
	 * Returns a new object of class '<em>Multiple Queue Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiple Queue Configuration</em>'.
	 * @generated
	 */
	MultipleQueueConfiguration createMultipleQueueConfiguration();

	/**
	 * Returns a new object of class '<em>Quantum Time Slice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quantum Time Slice Configuration</em>'.
	 * @generated
	 */
	QuantumTimeSliceConfiguration createQuantumTimeSliceConfiguration();

	/**
	 * Returns a new object of class '<em>Preemption Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preemption Configuration</em>'.
	 * @generated
	 */
	PreemptionConfiguration createPreemptionConfiguration();

	/**
	 * Returns a new object of class '<em>Priority Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority Configuration</em>'.
	 * @generated
	 */
	PriorityConfiguration createPriorityConfiguration();

	/**
	 * Returns a new object of class '<em>Priority Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority Range</em>'.
	 * @generated
	 */
	PriorityRange createPriorityRange();

	/**
	 * Returns a new object of class '<em>Priority Dependent Time Slice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority Dependent Time Slice Configuration</em>'.
	 * @generated
	 */
	PriorityDependentTimeSliceConfiguration createPriorityDependentTimeSliceConfiguration();

	/**
	 * Returns a new object of class '<em>Active Resource Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Resource Configuration</em>'.
	 * @generated
	 */
	ActiveResourceConfiguration createActiveResourceConfiguration();

	/**
	 * Returns a new object of class '<em>Passive Resource Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource Configuration</em>'.
	 * @generated
	 */
	PassiveResourceConfiguration createPassiveResourceConfiguration();

	/**
	 * Returns a new object of class '<em>Static Priority Boost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Priority Boost</em>'.
	 * @generated
	 */
	StaticPriorityBoost createStaticPriorityBoost();

	/**
	 * Returns a new object of class '<em>Process Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Configuration</em>'.
	 * @generated
	 */
	ProcessConfiguration createProcessConfiguration();

	/**
	 * Returns a new object of class '<em>Single Queue Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Queue Configuration</em>'.
	 * @generated
	 */
	SingleQueueConfiguration createSingleQueueConfiguration();

	/**
	 * Returns a new object of class '<em>Static Priority Boost Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Priority Boost Configuration</em>'.
	 * @generated
	 */
	StaticPriorityBoostConfiguration createStaticPriorityBoostConfiguration();

	/**
	 * Returns a new object of class '<em>Scheduler Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler Configuration</em>'.
	 * @generated
	 */
	SchedulerConfiguration createSchedulerConfiguration();

	/**
	 * Returns a new object of class '<em>Starvation Boost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Starvation Boost</em>'.
	 * @generated
	 */
	StarvationBoost createStarvationBoost();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigurationPackage getConfigurationPackage();

} //ConfigurationFactory
