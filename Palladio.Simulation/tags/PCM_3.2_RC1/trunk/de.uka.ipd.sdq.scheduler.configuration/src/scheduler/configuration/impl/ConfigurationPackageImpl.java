/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scheduler.SchedulerPackage;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.DynamicPriorityBoostConfiguratioin;
import scheduler.configuration.InstanceToBalance;
import scheduler.configuration.LoadBalancing;
import scheduler.configuration.LoadBalancingType;
import scheduler.configuration.MultipleQueueConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.PassiveResourceType;
import scheduler.configuration.PreemptionConfiguration;
import scheduler.configuration.PreferredPriority;
import scheduler.configuration.PreferredWaitingTime;
import scheduler.configuration.PriorityBoostConfiguration;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.PriorityConfiguration;
import scheduler.configuration.PriorityDegradation;
import scheduler.configuration.PriorityDependentTimeSliceConfiguration;
import scheduler.configuration.PriorityRange;
import scheduler.configuration.ProcessConfiguration;
import scheduler.configuration.ProcessSelection;
import scheduler.configuration.QuantumTimeSliceConfiguration;
import scheduler.configuration.QueueingConfiguration;
import scheduler.configuration.ResourceInstanceSelection;
import scheduler.configuration.RunQueueType;
import scheduler.configuration.SchedulerConfiguration;
import scheduler.configuration.SingleQueueConfiguration;
import scheduler.configuration.StarvationBoost;
import scheduler.configuration.StaticPriorityBoost;
import scheduler.configuration.StaticPriorityBoostConfiguration;
import scheduler.configuration.TimeSliceConfiguration;

import scheduler.impl.SchedulerPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationPackageImpl extends EPackageImpl implements ConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicPriorityBoostConfiguratioinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityBoostConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBalancingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleQueueConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queueingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantumTimeSliceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeSliceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preemptionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityDependentTimeSliceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeResourceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passiveResourceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticPriorityBoostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleQueueConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticPriorityBoostConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass starvationBoostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum instanceToBalanceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loadBalancingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum preferredWaitingTimeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum preferredPriorityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceInstanceSelectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum runQueueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityClassEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityDegradationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processSelectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum passiveResourceTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see scheduler.configuration.ConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfigurationPackageImpl() {
		super(eNS_URI, ConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConfigurationPackage init() {
		if (isInited) return (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) : SchedulerPackage.eINSTANCE);

		// Create package meta-data objects
		theConfigurationPackage.createPackageContents();
		theSchedulerPackage.createPackageContents();

		// Initialize created meta-data
		theConfigurationPackage.initializePackageContents();
		theSchedulerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConfigurationPackage.eNS_URI, theConfigurationPackage);
		return theConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicPriorityBoostConfiguratioin() {
		return dynamicPriorityBoostConfiguratioinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPriorityBoostConfiguratioin_MaxBonus() {
		return (EAttribute)dynamicPriorityBoostConfiguratioinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPriorityBoostConfiguratioin_Threshold() {
		return (EAttribute)dynamicPriorityBoostConfiguratioinEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPriorityBoostConfiguratioin_MaxSleepAverage() {
		return (EAttribute)dynamicPriorityBoostConfiguratioinEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriorityBoostConfiguration() {
		return priorityBoostConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBalancing() {
		return loadBalancingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_BalancingType() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_PreferredWaitingTime() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_PreferredPriority() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_Instances() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_Threshold() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_MaxIterations() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalancing_BalancingInterval() {
		return (EAttribute)loadBalancingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleQueueConfiguration() {
		return multipleQueueConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleQueueConfiguration_LoadBalancing() {
		return (EReference)multipleQueueConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultipleQueueConfiguration_InFrontWhenBalancing() {
		return (EAttribute)multipleQueueConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueueingConfiguration() {
		return queueingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueueingConfiguration_InitialInstanceSelection() {
		return (EAttribute)queueingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueueingConfiguration_RunqueueType() {
		return (EAttribute)queueingConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuantumTimeSliceConfiguration() {
		return quantumTimeSliceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantumTimeSliceConfiguration_Quanta() {
		return (EAttribute)quantumTimeSliceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantumTimeSliceConfiguration_MinQuanta() {
		return (EAttribute)quantumTimeSliceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeSliceConfiguration() {
		return timeSliceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeSliceConfiguration_Timeslice() {
		return (EAttribute)timeSliceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreemptionConfiguration() {
		return preemptionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreemptionConfiguration_TimesliceConfiguration() {
		return (EReference)preemptionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriorityConfiguration() {
		return priorityConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPriorityConfiguration_Range() {
		return (EReference)priorityConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPriorityConfiguration_BoostConfiguration() {
		return (EReference)priorityConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriorityRange() {
		return priorityRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_Highest() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_High() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_Average() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_Low() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_Lowest() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityRange_Default() {
		return (EAttribute)priorityRangeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriorityDependentTimeSliceConfiguration() {
		return priorityDependentTimeSliceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityDependentTimeSliceConfiguration_MinTimeslice() {
		return (EAttribute)priorityDependentTimeSliceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriorityDependentTimeSliceConfiguration_MinTimeToBeScheduled() {
		return (EAttribute)priorityDependentTimeSliceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveResourceConfiguration() {
		return activeResourceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveResourceConfiguration_SchedulerConfiguration() {
		return (EReference)activeResourceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveResourceConfiguration_Replicas() {
		return (EAttribute)activeResourceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveResourceConfiguration_Name() {
		return (EAttribute)activeResourceConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassiveResourceConfiguration() {
		return passiveResourceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPassiveResourceConfiguration_StaticPriorityBoostConfiguration() {
		return (EReference)passiveResourceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPassiveResourceConfiguration_Capacity() {
		return (EAttribute)passiveResourceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPassiveResourceConfiguration_Type() {
		return (EAttribute)passiveResourceConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPassiveResourceConfiguration_Name() {
		return (EAttribute)passiveResourceConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPassiveResourceConfiguration_ManagingResource() {
		return (EReference)passiveResourceConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPassiveResourceConfiguration_AcquisitionDemand() {
		return (EAttribute)passiveResourceConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticPriorityBoost() {
		return staticPriorityBoostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticPriorityBoost_ResetTimeslice() {
		return (EAttribute)staticPriorityBoostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticPriorityBoost_Bonus() {
		return (EAttribute)staticPriorityBoostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticPriorityBoost_Degradation() {
		return (EAttribute)staticPriorityBoostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticPriorityBoost_TimePenalty() {
		return (EAttribute)staticPriorityBoostEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessConfiguration() {
		return processConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessConfiguration_Priority() {
		return (EAttribute)processConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessConfiguration_Replicas() {
		return (EAttribute)processConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessConfiguration_Name() {
		return (EAttribute)processConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessConfiguration_AffinityList() {
		return (EAttribute)processConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleQueueConfiguration() {
		return singleQueueConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleQueueConfiguration_ProcessSelection() {
		return (EAttribute)singleQueueConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticPriorityBoostConfiguration() {
		return staticPriorityBoostConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStaticPriorityBoostConfiguration_StarvationBoost() {
		return (EReference)staticPriorityBoostConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulerConfiguration() {
		return schedulerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerConfiguration_PriorityConfiguration() {
		return (EReference)schedulerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerConfiguration_PreemptionConfiguration() {
		return (EReference)schedulerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerConfiguration_Name() {
		return (EAttribute)schedulerConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerConfiguration_QueueingConfiguration() {
		return (EReference)schedulerConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerConfiguration_InFrontAfterWaiting() {
		return (EAttribute)schedulerConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerConfiguration_Windows() {
		return (EAttribute)schedulerConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerConfiguration_Interval() {
		return (EAttribute)schedulerConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerConfiguration_StarvationBoost() {
		return (EReference)schedulerConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStarvationBoost() {
		return starvationBoostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStarvationBoost_StarvationLimit() {
		return (EAttribute)starvationBoostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStarvationBoost_Boost() {
		return (EAttribute)starvationBoostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStarvationBoost_DurationInTimeslices() {
		return (EAttribute)starvationBoostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInstanceToBalance() {
		return instanceToBalanceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoadBalancingType() {
		return loadBalancingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPreferredWaitingTime() {
		return preferredWaitingTimeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPreferredPriority() {
		return preferredPriorityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceInstanceSelection() {
		return resourceInstanceSelectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRunQueueType() {
		return runQueueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriorityClass() {
		return priorityClassEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriorityDegradation() {
		return priorityDegradationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessSelection() {
		return processSelectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPassiveResourceType() {
		return passiveResourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFactory getConfigurationFactory() {
		return (ConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dynamicPriorityBoostConfiguratioinEClass = createEClass(DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN);
		createEAttribute(dynamicPriorityBoostConfiguratioinEClass, DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS);
		createEAttribute(dynamicPriorityBoostConfiguratioinEClass, DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD);
		createEAttribute(dynamicPriorityBoostConfiguratioinEClass, DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE);

		priorityBoostConfigurationEClass = createEClass(PRIORITY_BOOST_CONFIGURATION);

		loadBalancingEClass = createEClass(LOAD_BALANCING);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__BALANCING_TYPE);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__PREFERRED_WAITING_TIME);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__PREFERRED_PRIORITY);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__INSTANCES);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__THRESHOLD);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__MAX_ITERATIONS);
		createEAttribute(loadBalancingEClass, LOAD_BALANCING__BALANCING_INTERVAL);

		multipleQueueConfigurationEClass = createEClass(MULTIPLE_QUEUE_CONFIGURATION);
		createEReference(multipleQueueConfigurationEClass, MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING);
		createEAttribute(multipleQueueConfigurationEClass, MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING);

		queueingConfigurationEClass = createEClass(QUEUEING_CONFIGURATION);
		createEAttribute(queueingConfigurationEClass, QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION);
		createEAttribute(queueingConfigurationEClass, QUEUEING_CONFIGURATION__RUNQUEUE_TYPE);

		quantumTimeSliceConfigurationEClass = createEClass(QUANTUM_TIME_SLICE_CONFIGURATION);
		createEAttribute(quantumTimeSliceConfigurationEClass, QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA);
		createEAttribute(quantumTimeSliceConfigurationEClass, QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA);

		timeSliceConfigurationEClass = createEClass(TIME_SLICE_CONFIGURATION);
		createEAttribute(timeSliceConfigurationEClass, TIME_SLICE_CONFIGURATION__TIMESLICE);

		preemptionConfigurationEClass = createEClass(PREEMPTION_CONFIGURATION);
		createEReference(preemptionConfigurationEClass, PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION);

		priorityConfigurationEClass = createEClass(PRIORITY_CONFIGURATION);
		createEReference(priorityConfigurationEClass, PRIORITY_CONFIGURATION__RANGE);
		createEReference(priorityConfigurationEClass, PRIORITY_CONFIGURATION__BOOST_CONFIGURATION);

		priorityRangeEClass = createEClass(PRIORITY_RANGE);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__HIGHEST);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__HIGH);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__AVERAGE);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__LOW);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__LOWEST);
		createEAttribute(priorityRangeEClass, PRIORITY_RANGE__DEFAULT);

		priorityDependentTimeSliceConfigurationEClass = createEClass(PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION);
		createEAttribute(priorityDependentTimeSliceConfigurationEClass, PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE);
		createEAttribute(priorityDependentTimeSliceConfigurationEClass, PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED);

		activeResourceConfigurationEClass = createEClass(ACTIVE_RESOURCE_CONFIGURATION);
		createEReference(activeResourceConfigurationEClass, ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION);
		createEAttribute(activeResourceConfigurationEClass, ACTIVE_RESOURCE_CONFIGURATION__REPLICAS);
		createEAttribute(activeResourceConfigurationEClass, ACTIVE_RESOURCE_CONFIGURATION__NAME);

		passiveResourceConfigurationEClass = createEClass(PASSIVE_RESOURCE_CONFIGURATION);
		createEReference(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION);
		createEAttribute(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__CAPACITY);
		createEAttribute(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__TYPE);
		createEAttribute(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__NAME);
		createEReference(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE);
		createEAttribute(passiveResourceConfigurationEClass, PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND);

		staticPriorityBoostEClass = createEClass(STATIC_PRIORITY_BOOST);
		createEAttribute(staticPriorityBoostEClass, STATIC_PRIORITY_BOOST__RESET_TIMESLICE);
		createEAttribute(staticPriorityBoostEClass, STATIC_PRIORITY_BOOST__BONUS);
		createEAttribute(staticPriorityBoostEClass, STATIC_PRIORITY_BOOST__DEGRADATION);
		createEAttribute(staticPriorityBoostEClass, STATIC_PRIORITY_BOOST__TIME_PENALTY);

		processConfigurationEClass = createEClass(PROCESS_CONFIGURATION);
		createEAttribute(processConfigurationEClass, PROCESS_CONFIGURATION__PRIORITY);
		createEAttribute(processConfigurationEClass, PROCESS_CONFIGURATION__REPLICAS);
		createEAttribute(processConfigurationEClass, PROCESS_CONFIGURATION__NAME);
		createEAttribute(processConfigurationEClass, PROCESS_CONFIGURATION__AFFINITY_LIST);

		singleQueueConfigurationEClass = createEClass(SINGLE_QUEUE_CONFIGURATION);
		createEAttribute(singleQueueConfigurationEClass, SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION);

		staticPriorityBoostConfigurationEClass = createEClass(STATIC_PRIORITY_BOOST_CONFIGURATION);
		createEReference(staticPriorityBoostConfigurationEClass, STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST);

		schedulerConfigurationEClass = createEClass(SCHEDULER_CONFIGURATION);
		createEReference(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION);
		createEReference(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION);
		createEAttribute(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__NAME);
		createEReference(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION);
		createEAttribute(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING);
		createEAttribute(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__WINDOWS);
		createEAttribute(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__INTERVAL);
		createEReference(schedulerConfigurationEClass, SCHEDULER_CONFIGURATION__STARVATION_BOOST);

		starvationBoostEClass = createEClass(STARVATION_BOOST);
		createEAttribute(starvationBoostEClass, STARVATION_BOOST__STARVATION_LIMIT);
		createEAttribute(starvationBoostEClass, STARVATION_BOOST__BOOST);
		createEAttribute(starvationBoostEClass, STARVATION_BOOST__DURATION_IN_TIMESLICES);

		// Create enums
		instanceToBalanceEEnum = createEEnum(INSTANCE_TO_BALANCE);
		loadBalancingTypeEEnum = createEEnum(LOAD_BALANCING_TYPE);
		preferredWaitingTimeEEnum = createEEnum(PREFERRED_WAITING_TIME);
		preferredPriorityEEnum = createEEnum(PREFERRED_PRIORITY);
		resourceInstanceSelectionEEnum = createEEnum(RESOURCE_INSTANCE_SELECTION);
		runQueueTypeEEnum = createEEnum(RUN_QUEUE_TYPE);
		priorityClassEEnum = createEEnum(PRIORITY_CLASS);
		priorityDegradationEEnum = createEEnum(PRIORITY_DEGRADATION);
		processSelectionEEnum = createEEnum(PROCESS_SELECTION);
		passiveResourceTypeEEnum = createEEnum(PASSIVE_RESOURCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dynamicPriorityBoostConfiguratioinEClass.getESuperTypes().add(this.getPriorityBoostConfiguration());
		multipleQueueConfigurationEClass.getESuperTypes().add(this.getQueueingConfiguration());
		quantumTimeSliceConfigurationEClass.getESuperTypes().add(this.getTimeSliceConfiguration());
		priorityDependentTimeSliceConfigurationEClass.getESuperTypes().add(this.getTimeSliceConfiguration());
		activeResourceConfigurationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		passiveResourceConfigurationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		processConfigurationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		singleQueueConfigurationEClass.getESuperTypes().add(this.getQueueingConfiguration());
		staticPriorityBoostConfigurationEClass.getESuperTypes().add(this.getPriorityBoostConfiguration());
		schedulerConfigurationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(dynamicPriorityBoostConfiguratioinEClass, DynamicPriorityBoostConfiguratioin.class, "DynamicPriorityBoostConfiguratioin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicPriorityBoostConfiguratioin_MaxBonus(), ecorePackage.getEInt(), "maxBonus", null, 1, 1, DynamicPriorityBoostConfiguratioin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDynamicPriorityBoostConfiguratioin_Threshold(), ecorePackage.getEInt(), "threshold", null, 1, 1, DynamicPriorityBoostConfiguratioin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDynamicPriorityBoostConfiguratioin_MaxSleepAverage(), ecorePackage.getEDouble(), "maxSleepAverage", null, 0, 1, DynamicPriorityBoostConfiguratioin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(priorityBoostConfigurationEClass, PriorityBoostConfiguration.class, "PriorityBoostConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadBalancingEClass, LoadBalancing.class, "LoadBalancing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadBalancing_BalancingType(), this.getLoadBalancingType(), "balancingType", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_PreferredWaitingTime(), this.getPreferredWaitingTime(), "preferredWaitingTime", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_PreferredPriority(), this.getPreferredPriority(), "preferredPriority", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_Instances(), this.getInstanceToBalance(), "instances", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_Threshold(), ecorePackage.getEDouble(), "threshold", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_MaxIterations(), ecorePackage.getEInt(), "maxIterations", null, 1, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoadBalancing_BalancingInterval(), ecorePackage.getEDouble(), "balancingInterval", null, 0, 1, LoadBalancing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleQueueConfigurationEClass, MultipleQueueConfiguration.class, "MultipleQueueConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultipleQueueConfiguration_LoadBalancing(), this.getLoadBalancing(), null, "loadBalancing", null, 1, 1, MultipleQueueConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultipleQueueConfiguration_InFrontWhenBalancing(), ecorePackage.getEBoolean(), "InFrontWhenBalancing", "true", 1, 1, MultipleQueueConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queueingConfigurationEClass, QueueingConfiguration.class, "QueueingConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQueueingConfiguration_InitialInstanceSelection(), this.getResourceInstanceSelection(), "initialInstanceSelection", null, 1, 1, QueueingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQueueingConfiguration_RunqueueType(), this.getRunQueueType(), "runqueueType", null, 1, 1, QueueingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quantumTimeSliceConfigurationEClass, QuantumTimeSliceConfiguration.class, "QuantumTimeSliceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuantumTimeSliceConfiguration_Quanta(), ecorePackage.getEInt(), "quanta", null, 0, 1, QuantumTimeSliceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuantumTimeSliceConfiguration_MinQuanta(), ecorePackage.getEInt(), "minQuanta", null, 0, 1, QuantumTimeSliceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeSliceConfigurationEClass, TimeSliceConfiguration.class, "TimeSliceConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeSliceConfiguration_Timeslice(), ecorePackage.getEDouble(), "timeslice", null, 0, 1, TimeSliceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preemptionConfigurationEClass, PreemptionConfiguration.class, "PreemptionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreemptionConfiguration_TimesliceConfiguration(), this.getTimeSliceConfiguration(), null, "timesliceConfiguration", null, 1, 1, PreemptionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(priorityConfigurationEClass, PriorityConfiguration.class, "PriorityConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPriorityConfiguration_Range(), this.getPriorityRange(), null, "range", null, 1, 1, PriorityConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPriorityConfiguration_BoostConfiguration(), this.getPriorityBoostConfiguration(), null, "boostConfiguration", null, 1, 1, PriorityConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(priorityRangeEClass, PriorityRange.class, "PriorityRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriorityRange_Highest(), ecorePackage.getEInt(), "highest", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriorityRange_High(), ecorePackage.getEInt(), "high", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriorityRange_Average(), ecorePackage.getEInt(), "average", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriorityRange_Low(), ecorePackage.getEInt(), "low", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriorityRange_Lowest(), ecorePackage.getEInt(), "lowest", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriorityRange_Default(), ecorePackage.getEInt(), "default", null, 1, 1, PriorityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(priorityDependentTimeSliceConfigurationEClass, PriorityDependentTimeSliceConfiguration.class, "PriorityDependentTimeSliceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriorityDependentTimeSliceConfiguration_MinTimeslice(), ecorePackage.getEDouble(), "minTimeslice", null, 0, 1, PriorityDependentTimeSliceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPriorityDependentTimeSliceConfiguration_MinTimeToBeScheduled(), ecorePackage.getEDouble(), "minTimeToBeScheduled", null, 0, 1, PriorityDependentTimeSliceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activeResourceConfigurationEClass, ActiveResourceConfiguration.class, "ActiveResourceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActiveResourceConfiguration_SchedulerConfiguration(), this.getSchedulerConfiguration(), null, "schedulerConfiguration", null, 1, 1, ActiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActiveResourceConfiguration_Replicas(), ecorePackage.getEInt(), "replicas", "1", 1, 1, ActiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActiveResourceConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, ActiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(passiveResourceConfigurationEClass, PassiveResourceConfiguration.class, "PassiveResourceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPassiveResourceConfiguration_StaticPriorityBoostConfiguration(), this.getStaticPriorityBoost(), null, "staticPriorityBoostConfiguration", null, 0, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPassiveResourceConfiguration_Capacity(), ecorePackage.getEInt(), "capacity", "1", 1, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPassiveResourceConfiguration_Type(), this.getPassiveResourceType(), "type", null, 1, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPassiveResourceConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPassiveResourceConfiguration_ManagingResource(), this.getActiveResourceConfiguration(), null, "managingResource", null, 0, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPassiveResourceConfiguration_AcquisitionDemand(), ecorePackage.getEDouble(), "acquisitionDemand", null, 0, 1, PassiveResourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticPriorityBoostEClass, StaticPriorityBoost.class, "StaticPriorityBoost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticPriorityBoost_ResetTimeslice(), ecorePackage.getEBoolean(), "resetTimeslice", null, 1, 1, StaticPriorityBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticPriorityBoost_Bonus(), ecorePackage.getEInt(), "bonus", null, 1, 1, StaticPriorityBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticPriorityBoost_Degradation(), this.getPriorityDegradation(), "degradation", null, 1, 1, StaticPriorityBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticPriorityBoost_TimePenalty(), ecorePackage.getEDouble(), "timePenalty", null, 0, 1, StaticPriorityBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processConfigurationEClass, ProcessConfiguration.class, "ProcessConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessConfiguration_Priority(), this.getPriorityClass(), "priority", null, 1, 1, ProcessConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcessConfiguration_Replicas(), ecorePackage.getEInt(), "replicas", "1", 1, 1, ProcessConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcessConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, ProcessConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcessConfiguration_AffinityList(), ecorePackage.getEInt(), "affinityList", null, 0, -1, ProcessConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(singleQueueConfigurationEClass, SingleQueueConfiguration.class, "SingleQueueConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleQueueConfiguration_ProcessSelection(), this.getProcessSelection(), "processSelection", null, 1, 1, SingleQueueConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticPriorityBoostConfigurationEClass, StaticPriorityBoostConfiguration.class, "StaticPriorityBoostConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStaticPriorityBoostConfiguration_StarvationBoost(), this.getStaticPriorityBoost(), null, "starvationBoost", null, 0, 1, StaticPriorityBoostConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(schedulerConfigurationEClass, SchedulerConfiguration.class, "SchedulerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulerConfiguration_PriorityConfiguration(), this.getPriorityConfiguration(), null, "priorityConfiguration", null, 0, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSchedulerConfiguration_PreemptionConfiguration(), this.getPreemptionConfiguration(), null, "preemptionConfiguration", null, 0, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSchedulerConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSchedulerConfiguration_QueueingConfiguration(), this.getQueueingConfiguration(), null, "queueingConfiguration", null, 0, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSchedulerConfiguration_InFrontAfterWaiting(), ecorePackage.getEBoolean(), "inFrontAfterWaiting", null, 1, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSchedulerConfiguration_Windows(), ecorePackage.getEBoolean(), "Windows", "true", 1, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulerConfiguration_Interval(), ecorePackage.getEDouble(), "interval", null, 0, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerConfiguration_StarvationBoost(), this.getStarvationBoost(), null, "starvationBoost", null, 0, 1, SchedulerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(starvationBoostEClass, StarvationBoost.class, "StarvationBoost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStarvationBoost_StarvationLimit(), ecorePackage.getEDouble(), "starvationLimit", null, 0, 1, StarvationBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStarvationBoost_Boost(), ecorePackage.getEInt(), "boost", null, 0, 1, StarvationBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStarvationBoost_DurationInTimeslices(), ecorePackage.getEInt(), "durationInTimeslices", null, 0, 1, StarvationBoost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(instanceToBalanceEEnum, InstanceToBalance.class, "InstanceToBalance");
		addEEnumLiteral(instanceToBalanceEEnum, InstanceToBalance.CURRENT);
		addEEnumLiteral(instanceToBalanceEEnum, InstanceToBalance.ALL);

		initEEnum(loadBalancingTypeEEnum, LoadBalancingType.class, "LoadBalancingType");
		addEEnumLiteral(loadBalancingTypeEEnum, LoadBalancingType.IDLE_TO_ONE);
		addEEnumLiteral(loadBalancingTypeEEnum, LoadBalancingType.IDLE_TO_THRESHOLD);
		addEEnumLiteral(loadBalancingTypeEEnum, LoadBalancingType.ANY_TO_THRESHOLD);

		initEEnum(preferredWaitingTimeEEnum, PreferredWaitingTime.class, "PreferredWaitingTime");
		addEEnumLiteral(preferredWaitingTimeEEnum, PreferredWaitingTime.LONG);
		addEEnumLiteral(preferredWaitingTimeEEnum, PreferredWaitingTime.SHORT);

		initEEnum(preferredPriorityEEnum, PreferredPriority.class, "PreferredPriority");
		addEEnumLiteral(preferredPriorityEEnum, PreferredPriority.HIGHER);
		addEEnumLiteral(preferredPriorityEEnum, PreferredPriority.LOWER);

		initEEnum(resourceInstanceSelectionEEnum, ResourceInstanceSelection.class, "ResourceInstanceSelection");
		addEEnumLiteral(resourceInstanceSelectionEEnum, ResourceInstanceSelection.ROUND_ROBIN);
		addEEnumLiteral(resourceInstanceSelectionEEnum, ResourceInstanceSelection.PREFER_IDLE);

		initEEnum(runQueueTypeEEnum, RunQueueType.class, "RunQueueType");
		addEEnumLiteral(runQueueTypeEEnum, RunQueueType.ACTIVE_AND_EXPIRED);
		addEEnumLiteral(runQueueTypeEEnum, RunQueueType.SINGLE);

		initEEnum(priorityClassEEnum, PriorityClass.class, "PriorityClass");
		addEEnumLiteral(priorityClassEEnum, PriorityClass.LOWEST);
		addEEnumLiteral(priorityClassEEnum, PriorityClass.LOW);
		addEEnumLiteral(priorityClassEEnum, PriorityClass.AVERAGE);
		addEEnumLiteral(priorityClassEEnum, PriorityClass.HIGH);
		addEEnumLiteral(priorityClassEEnum, PriorityClass.HIGHEST);
		addEEnumLiteral(priorityClassEEnum, PriorityClass.DEFAULT);

		initEEnum(priorityDegradationEEnum, PriorityDegradation.class, "PriorityDegradation");
		addEEnumLiteral(priorityDegradationEEnum, PriorityDegradation.RESET);
		addEEnumLiteral(priorityDegradationEEnum, PriorityDegradation.SLOW_DECAY);

		initEEnum(processSelectionEEnum, ProcessSelection.class, "ProcessSelection");
		addEEnumLiteral(processSelectionEEnum, ProcessSelection.PREFER_IDEAL_AND_LAST);
		addEEnumLiteral(processSelectionEEnum, ProcessSelection.NEXT_RUNNABLE);

		initEEnum(passiveResourceTypeEEnum, PassiveResourceType.class, "PassiveResourceType");
		addEEnumLiteral(passiveResourceTypeEEnum, PassiveResourceType.FAIR);
		addEEnumLiteral(passiveResourceTypeEEnum, PassiveResourceType.UNFAIR);
	}

} //ConfigurationPackageImpl
