/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scheduler.configuration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigurationFactory init() {
		try {
			ConfigurationFactory theConfigurationFactory = (ConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/scheduler/configuration/1.0"); 
			if (theConfigurationFactory != null) {
				return theConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN: return createDynamicPriorityBoostConfiguratioin();
			case ConfigurationPackage.LOAD_BALANCING: return createLoadBalancing();
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION: return createMultipleQueueConfiguration();
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION: return createQuantumTimeSliceConfiguration();
			case ConfigurationPackage.PREEMPTION_CONFIGURATION: return createPreemptionConfiguration();
			case ConfigurationPackage.PRIORITY_CONFIGURATION: return createPriorityConfiguration();
			case ConfigurationPackage.PRIORITY_RANGE: return createPriorityRange();
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION: return createPriorityDependentTimeSliceConfiguration();
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION: return createActiveResourceConfiguration();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION: return createPassiveResourceConfiguration();
			case ConfigurationPackage.STATIC_PRIORITY_BOOST: return createStaticPriorityBoost();
			case ConfigurationPackage.PROCESS_CONFIGURATION: return createProcessConfiguration();
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION: return createSingleQueueConfiguration();
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION: return createStaticPriorityBoostConfiguration();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION: return createSchedulerConfiguration();
			case ConfigurationPackage.STARVATION_BOOST: return createStarvationBoost();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConfigurationPackage.INSTANCE_TO_BALANCE:
				return createInstanceToBalanceFromString(eDataType, initialValue);
			case ConfigurationPackage.LOAD_BALANCING_TYPE:
				return createLoadBalancingTypeFromString(eDataType, initialValue);
			case ConfigurationPackage.PREFERRED_WAITING_TIME:
				return createPreferredWaitingTimeFromString(eDataType, initialValue);
			case ConfigurationPackage.PREFERRED_PRIORITY:
				return createPreferredPriorityFromString(eDataType, initialValue);
			case ConfigurationPackage.RESOURCE_INSTANCE_SELECTION:
				return createResourceInstanceSelectionFromString(eDataType, initialValue);
			case ConfigurationPackage.RUN_QUEUE_TYPE:
				return createRunQueueTypeFromString(eDataType, initialValue);
			case ConfigurationPackage.PRIORITY_CLASS:
				return createPriorityClassFromString(eDataType, initialValue);
			case ConfigurationPackage.PRIORITY_DEGRADATION:
				return createPriorityDegradationFromString(eDataType, initialValue);
			case ConfigurationPackage.PROCESS_SELECTION:
				return createProcessSelectionFromString(eDataType, initialValue);
			case ConfigurationPackage.PASSIVE_RESOURCE_TYPE:
				return createPassiveResourceTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ConfigurationPackage.INSTANCE_TO_BALANCE:
				return convertInstanceToBalanceToString(eDataType, instanceValue);
			case ConfigurationPackage.LOAD_BALANCING_TYPE:
				return convertLoadBalancingTypeToString(eDataType, instanceValue);
			case ConfigurationPackage.PREFERRED_WAITING_TIME:
				return convertPreferredWaitingTimeToString(eDataType, instanceValue);
			case ConfigurationPackage.PREFERRED_PRIORITY:
				return convertPreferredPriorityToString(eDataType, instanceValue);
			case ConfigurationPackage.RESOURCE_INSTANCE_SELECTION:
				return convertResourceInstanceSelectionToString(eDataType, instanceValue);
			case ConfigurationPackage.RUN_QUEUE_TYPE:
				return convertRunQueueTypeToString(eDataType, instanceValue);
			case ConfigurationPackage.PRIORITY_CLASS:
				return convertPriorityClassToString(eDataType, instanceValue);
			case ConfigurationPackage.PRIORITY_DEGRADATION:
				return convertPriorityDegradationToString(eDataType, instanceValue);
			case ConfigurationPackage.PROCESS_SELECTION:
				return convertProcessSelectionToString(eDataType, instanceValue);
			case ConfigurationPackage.PASSIVE_RESOURCE_TYPE:
				return convertPassiveResourceTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicPriorityBoostConfiguratioin createDynamicPriorityBoostConfiguratioin() {
		DynamicPriorityBoostConfiguratioinImpl dynamicPriorityBoostConfiguratioin = new DynamicPriorityBoostConfiguratioinImpl();
		return dynamicPriorityBoostConfiguratioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancing createLoadBalancing() {
		LoadBalancingImpl loadBalancing = new LoadBalancingImpl();
		return loadBalancing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleQueueConfiguration createMultipleQueueConfiguration() {
		MultipleQueueConfigurationImpl multipleQueueConfiguration = new MultipleQueueConfigurationImpl();
		return multipleQueueConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantumTimeSliceConfiguration createQuantumTimeSliceConfiguration() {
		QuantumTimeSliceConfigurationImpl quantumTimeSliceConfiguration = new QuantumTimeSliceConfigurationImpl();
		return quantumTimeSliceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreemptionConfiguration createPreemptionConfiguration() {
		PreemptionConfigurationImpl preemptionConfiguration = new PreemptionConfigurationImpl();
		return preemptionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityConfiguration createPriorityConfiguration() {
		PriorityConfigurationImpl priorityConfiguration = new PriorityConfigurationImpl();
		return priorityConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRange createPriorityRange() {
		PriorityRangeImpl priorityRange = new PriorityRangeImpl();
		return priorityRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDependentTimeSliceConfiguration createPriorityDependentTimeSliceConfiguration() {
		PriorityDependentTimeSliceConfigurationImpl priorityDependentTimeSliceConfiguration = new PriorityDependentTimeSliceConfigurationImpl();
		return priorityDependentTimeSliceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResourceConfiguration createActiveResourceConfiguration() {
		ActiveResourceConfigurationImpl activeResourceConfiguration = new ActiveResourceConfigurationImpl();
		return activeResourceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceConfiguration createPassiveResourceConfiguration() {
		PassiveResourceConfigurationImpl passiveResourceConfiguration = new PassiveResourceConfigurationImpl();
		return passiveResourceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticPriorityBoost createStaticPriorityBoost() {
		StaticPriorityBoostImpl staticPriorityBoost = new StaticPriorityBoostImpl();
		return staticPriorityBoost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessConfiguration createProcessConfiguration() {
		ProcessConfigurationImpl processConfiguration = new ProcessConfigurationImpl();
		return processConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleQueueConfiguration createSingleQueueConfiguration() {
		SingleQueueConfigurationImpl singleQueueConfiguration = new SingleQueueConfigurationImpl();
		return singleQueueConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticPriorityBoostConfiguration createStaticPriorityBoostConfiguration() {
		StaticPriorityBoostConfigurationImpl staticPriorityBoostConfiguration = new StaticPriorityBoostConfigurationImpl();
		return staticPriorityBoostConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerConfiguration createSchedulerConfiguration() {
		SchedulerConfigurationImpl schedulerConfiguration = new SchedulerConfigurationImpl();
		return schedulerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StarvationBoost createStarvationBoost() {
		StarvationBoostImpl starvationBoost = new StarvationBoostImpl();
		return starvationBoost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceToBalance createInstanceToBalanceFromString(EDataType eDataType, String initialValue) {
		InstanceToBalance result = InstanceToBalance.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstanceToBalanceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancingType createLoadBalancingTypeFromString(EDataType eDataType, String initialValue) {
		LoadBalancingType result = LoadBalancingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadBalancingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferredWaitingTime createPreferredWaitingTimeFromString(EDataType eDataType, String initialValue) {
		PreferredWaitingTime result = PreferredWaitingTime.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreferredWaitingTimeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferredPriority createPreferredPriorityFromString(EDataType eDataType, String initialValue) {
		PreferredPriority result = PreferredPriority.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreferredPriorityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInstanceSelection createResourceInstanceSelectionFromString(EDataType eDataType, String initialValue) {
		ResourceInstanceSelection result = ResourceInstanceSelection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceInstanceSelectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunQueueType createRunQueueTypeFromString(EDataType eDataType, String initialValue) {
		RunQueueType result = RunQueueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRunQueueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityClass createPriorityClassFromString(EDataType eDataType, String initialValue) {
		PriorityClass result = PriorityClass.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityClassToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDegradation createPriorityDegradationFromString(EDataType eDataType, String initialValue) {
		PriorityDegradation result = PriorityDegradation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityDegradationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSelection createProcessSelectionFromString(EDataType eDataType, String initialValue) {
		ProcessSelection result = ProcessSelection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessSelectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType createPassiveResourceTypeFromString(EDataType eDataType, String initialValue) {
		PassiveResourceType result = PassiveResourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPassiveResourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPackage getConfigurationPackage() {
		return (ConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigurationPackage getPackage() {
		return ConfigurationPackage.eINSTANCE;
	}

} //ConfigurationFactoryImpl
