package de.uka.ipd.sdq.scheduler.factory;

import java.util.Hashtable;
import java.util.Map;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.DynamicPriorityBoostConfiguratioin;
import scheduler.configuration.LoadBalancing;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.PredefinedTimeSliceConfiguration;
import scheduler.configuration.PreemptionConfiguration;
import scheduler.configuration.PreferredPriority;
import scheduler.configuration.PreferredWaitingTime;
import scheduler.configuration.PriorityBoostConfiguration;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.PriorityConfiguration;
import scheduler.configuration.PriorityDependentTimeSliceConfiguration;
import scheduler.configuration.PriorityRange;
import scheduler.configuration.ProcessConfiguration;
import scheduler.configuration.ProcessSelection;
import scheduler.configuration.QueueingConfiguration;
import scheduler.configuration.SchedulerConfiguration;
import scheduler.configuration.TimeSliceConfiguration;
import scheduler.configuration.util.ConfigurationSwitch;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.balancers.OneToIdleBalancer;
import de.uka.ipd.sdq.scheduler.loaddistribution.balancers.ToThresholdBalancer;
import de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance.IdleSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance.RoundRobinSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.selectors.process.NextRunnableProcessSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.selectors.process.PreferIdealAndLastProcessSelector;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.priority.impl.PriorityManagerImpl;
import de.uka.ipd.sdq.scheduler.priority.update.DecayToBaseUpdate;
import de.uka.ipd.sdq.scheduler.priority.update.SetToBaseUpdate;
import de.uka.ipd.sdq.scheduler.priority.update.SleepAverageDependentUpdate;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.PreemptiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.basicqueues.PriorityArray;
import de.uka.ipd.sdq.scheduler.queueing.basicqueues.ProcessQueueImpl;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ActiveExpiredRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.SingleRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimFCFSResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimProcessorSharingResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.passive.SimFairPassiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimUnfairPassiveResource;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;
import de.uka.ipd.sdq.scheduler.strategy.impl.PreemptiveScheduler;
import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;
import de.uka.ipd.sdq.scheduler.timeslice.impl.PriorityDependentTimeSlice;
import de.uka.ipd.sdq.scheduler.timeslice.impl.QuantumTimeSlice;

/**
 * Creates instances of active and passive resources with different scheduling
 * strategies.
 * 
 * @author jens
 * 
 */
public class SchedulingFactory implements ISchedulingFactory {

	private static Simulator usedSimulator = Simulator.defaultSimulator;

	private Map<String, IActiveResource> active_resource_map = new Hashtable<String, IActiveResource>();
	private Map<String, IPassiveResource> passive_resource_map = new Hashtable<String, IPassiveResource>();
	private Map<String, IResourceInstance> resource_instance_map = new Hashtable<String, IResourceInstance>();
	private Map<String, IScheduler> scheduler_map = new Hashtable<String, IScheduler>();
	private Map<String, ActiveProcess> process_map = new Hashtable<String, ActiveProcess>();
	private Map<String, PriorityManagerImpl> manager_map = new Hashtable<String, PriorityManagerImpl>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.scheduler.builder.ISchedulingFactory#createActiveResource(scheduler.configuration.ActiveResourceConfiguration)
	 */
	public IActiveResource createActiveResource(
			ActiveResourceConfiguration configuration) {
		SimActiveResource resource = (SimActiveResource) active_resource_map.get(configuration.getId());
		if (resource == null) {
				resource = new SimActiveResource(configuration.getReplicas(),configuration.getName(), configuration.getId());
				IScheduler scheduler = createScheduler(configuration.getSchedulerConfiguration(), resource);
				resource.setScheduler(scheduler);
			active_resource_map.put(configuration.getId(), resource);
		}
		return resource;
	}
	
	
	public IActiveResource createSimFCFSResource(String resourceName, String resourceId)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimFCFSResource(resourceName, resourceId, 1);
		active_resource_map.put(resourceId, resource);
		return resource;
	}
	
	public IActiveResource createSimDelayResource(String resourceName, String resourceId)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimDelayResource(resourceName, resourceId);
		active_resource_map.put(resourceId, resource);
		return resource;
	}

	
	public IActiveResource createSimProcessorSharingResource(String resourceName, String resourceId)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimProcessorSharingResource(resourceName, resourceId, 1);
		active_resource_map.put(resourceId, resource);
		return resource;
	}

	public IPassiveResource createPassiveResource(
			PassiveResourceConfiguration configuration) {
		IPassiveResource resource = passive_resource_map.get(configuration
				.getId());
		if (resource == null) {
			IPriorityBoost priority_boost = createStaticPriorityBoost(configuration
					.getStaticPriorityBoostConfiguration());
			SimActiveResource managing_resource = (SimActiveResource) createActiveResource(configuration
					.getManagingResource());

			switch (configuration.getType()) {
			case FAIR:
				resource = new SimFairPassiveResource(configuration
						.getCapacity(), configuration.getName(), configuration
						.getId(), priority_boost, managing_resource);
				break;

			case UNFAIR:
				resource = new SimUnfairPassiveResource(configuration
						.getCapacity(), configuration.getName(), configuration
						.getId(), priority_boost, managing_resource,
						configuration.getAcquisitionDemand().getValue(),true);
				break;

			default:
				break;
			}

			passive_resource_map.put(configuration.getId(), resource);
		}
		return resource;
	}

	public IResourceInstance createResourceInstance(int index,
			IActiveResource containing_resource) {

		String id = containing_resource.getId() + index;

		IResourceInstance instance = resource_instance_map.get(id);
		if (instance == null) {
			instance = new SimResourceInstance(index, containing_resource);
			resource_instance_map.put(id, instance);
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.scheduler.builder.ISchedulingFactory#createRunningProcess(de.uka.ipd.sdq.scheduler.ISchedulableProcess,
	 *      scheduler.configuration.ProcessConfiguration,
	 *      scheduler.configuration.ActiveResourceConfiguration)
	 */
	public IRunningProcess createRunningProcess(ISchedulableProcess process,
			ProcessConfiguration configuration,
			ActiveResourceConfiguration resourceConfiguration) {
		String id = process.getId() + resourceConfiguration.getId();

		ActiveProcess active_process = process_map.get(id);

		if (active_process == null) {
			if (resourceConfiguration.getReplicas() > 0) {

				if (resourceConfiguration.getSchedulerConfiguration()
						.getPriorityConfiguration() != null) {
					IPriority prio = getPriority(configuration.getPriority(),
							resourceConfiguration.getSchedulerConfiguration()
									.getPriorityConfiguration().getRange());
					active_process = new ProcessWithPriority(process, prio);
					IPriorityUpdateStrategy updateStrategy = createPriorityUpdadateStrategy(
							resourceConfiguration.getSchedulerConfiguration()
									.getPriorityConfiguration()
									.getBoostConfiguration(), active_process);
					((ProcessWithPriority) active_process)
							.setPriorityUpdateStrategy(updateStrategy);
				}
				if (resourceConfiguration.getSchedulerConfiguration()
						.getPreemptionConfiguration() != null) {
					if (active_process == null)
						active_process = new PreemptiveProcess(process);
					ITimeSlice timeslice = createTimeSlice(
							resourceConfiguration.getSchedulerConfiguration()
									.getPreemptionConfiguration(),
							active_process);
					timeslice.fullReset();
					((PreemptiveProcess) active_process)
							.setTimeSlice(timeslice);
				} else {
					active_process = new ActiveProcess(process);
				}
				process_map.put(id, active_process);
			}
		}

		return active_process;
	}

	private IPriorityUpdateStrategy createPriorityUpdadateStrategy(
			PriorityBoostConfiguration boostConfiguration,
			IActiveProcess process) {
		if (boostConfiguration instanceof DynamicPriorityBoostConfiguratioin) {
			DynamicPriorityBoostConfiguratioin dynamic = (DynamicPriorityBoostConfiguratioin) boostConfiguration;
			return new SleepAverageDependentUpdate(process, dynamic
					.getMaxSleepAverage().getValue(), dynamic.getMaxBonus());
		}
		return null;
	}

	private IPriority getPriority(PriorityClass priority, PriorityRange range) {
		PriorityManagerImpl manager = createPriorityManager(range);
		IPriority prio = manager.getDefaultPriority();
		switch (priority) {
		case LOWEST:
			prio = manager.getLowestPriority();
			break;
		case LOW:
			prio = manager.getLowPriority();
			break;
		case AVERAGE:
			prio = manager.getAveragePriority();
			break;
		case HIGH:
			prio = manager.getHighPriority();
			break;
		case HIGHEST:
			prio = manager.getHighestPriority();
			break;
		default:
			prio = manager.getDefaultPriority();
			break;
		}
		return prio;
	}

	private ITimeSlice createTimeSlice(
			PreemptionConfiguration preemptionConfiguration,
			final ActiveProcess process) {

		ConfigurationSwitch<ITimeSlice> timesliceSwitch = new ConfigurationSwitch<ITimeSlice>() {
			@Override
			public ITimeSlice casePredefinedTimeSliceConfiguration(
					PredefinedTimeSliceConfiguration configuration) {
				double timeslice = configuration.getTimeslice().getValue();
				int granularity = configuration.getGranularity();
				// TODO tatsächliche Konfiguration auslesen.
				// return new DiscreteTimeSlice();
				// return new ContinuousTimeSlice(timeslice, granularity);
				return new QuantumTimeSlice(timeslice, granularity);
			}

			@Override
			public ITimeSlice casePriorityDependentTimeSliceConfiguration(
					PriorityDependentTimeSliceConfiguration configuration) {
				double timeslice = configuration.getTimeslice().getValue();
				double min_timeslice = configuration.getMinTimeslice()
						.getValue();
				int granularity = configuration.getGranularity();
				return new PriorityDependentTimeSlice(
						(ProcessWithPriority) process, timeslice,
						min_timeslice, granularity);
			}
		};

		if (preemptionConfiguration != null) {
			TimeSliceConfiguration timesliceConf = preemptionConfiguration
					.getTimesliceConfiguration();
			return timesliceSwitch.doSwitch(timesliceConf);
		}
		return null;
	}

	private IScheduler createScheduler(SchedulerConfiguration configuration,
			IActiveResource scheduled_resource) {
		return createPreemptiveScheduler(configuration,scheduled_resource);
	}

	private IScheduler createPreemptiveScheduler(
			SchedulerConfiguration configuration,
			IActiveResource scheduled_resource) {
		IProcessQueue process_queue_prototype = createProcessQueue(configuration
				.getPriorityConfiguration());
		IQueueingStrategy queueing_strategy = createQueueingStrategy(
				configuration.getQueueingConfiguration(),
				process_queue_prototype, (SimActiveResource) scheduled_resource);
		boolean in_front_after_waiting = configuration.isInFrontAfterWaiting();
		double scheduling_interval = configuration.getInterval().getValue();
		return new PreemptiveScheduler((SimActiveResource) scheduled_resource,
				queueing_strategy, in_front_after_waiting, scheduling_interval, configuration.isWindows());
	}

	private IProcessQueue createProcessQueue(PriorityConfiguration configuration) {
		if (configuration == null) {
			return new ProcessQueueImpl();
		}
		PriorityManagerImpl manager = createPriorityManager(configuration
				.getRange());
		return new PriorityArray(manager);
	}

	private PriorityManagerImpl createPriorityManager(PriorityRange range) {
		String id = getManagerId(range);
		PriorityManagerImpl manager = manager_map.get(id);
		if (manager == null) {
			manager = new PriorityManagerImpl(range.getHighest(), range
					.getHigh(), range.getAverage(), range.getLow(), range
					.getLowest(), range.getDefault());
			manager_map.put(id, manager);
		}
		return manager;
	}

	private String getManagerId(PriorityRange range) {
		return range.getHighest() + "_" + range.getHigh() + "_"
				+ range.getAverage() + "_" + range.getLow() + "_"
				+ range.getLowest() + "_" + range.getDefault();
	}

	private IQueueingStrategy createQueueingStrategy(
			QueueingConfiguration configuration,
			IProcessQueue process_queue_prototype, SimActiveResource resource) {
		IRunQueue runqueue_prototype = createRunQueue(configuration
				.getRunqueueType(), process_queue_prototype);
		IInstanceSelector instance_selector = createInstanceSelector(
				configuration.getInitialInstanceSelection(), resource);

		QueueingConfigurationSwitch qSwitch = new QueueingConfigurationSwitch(
				runqueue_prototype, instance_selector, this, resource);
		return qSwitch.doSwitch(configuration);
	}

	private IInstanceSelector createInstanceSelector(
			scheduler.configuration.ResourceInstanceSelection initialInstanceSelection,
			SimActiveResource resource) {
		switch (initialInstanceSelection) {
		case PREFER_IDLE:
			return new IdleSelector(resource);
		case ROUND_ROBIN:
			return new RoundRobinSelector(resource);
		default:
			assert false : "Unknown InstanceSelector!";
			break;
		}
		return null;
	}

	private IRunQueue createRunQueue(scheduler.configuration.RunQueueType type,
			IProcessQueue process_queue_prototype) {
		IRunQueue runqueue = null;
		switch (type) {
		case SINGLE:
			runqueue = new SingleRunQueue(process_queue_prototype);
			break;
		case ACTIVE_AND_EXPIRED:
			runqueue = new ActiveExpiredRunQueue(process_queue_prototype);
			break;
		default:
			assert false : "Unknown RunqueueType";
			break;
		}
		return runqueue;
	}

	private IPriorityBoost createStaticPriorityBoost(
			scheduler.configuration.StaticPriorityBoost configuration) {
		IPriorityBoost boost = null;
		if (configuration != null) {
			IPriorityUpdateStrategy update_strategy = null;
			switch (configuration.getDegradation()) {
			case RESET:
				update_strategy = new SetToBaseUpdate(1);
				break;
			case SLOW_DECAY:
				update_strategy = new DecayToBaseUpdate();
				break;
			default:
				assert false : "Undefinded Priority Update Configuration.";
				break;
			}
			boost = new de.uka.ipd.sdq.scheduler.priority.boost.StaticPriorityBoost(
					update_strategy, configuration.getBonus(),
					(int) configuration.getTimePenalty().getValue(),
					configuration.isResetTimeslice());
		}
		return boost;
	}

	public IProcessSelector createProcessSelector(
			ProcessSelection processSelection) {
		switch (processSelection) {
		case NEXT_RUNNABLE:
			return new NextRunnableProcessSelector();
		case PREFER_IDEAL_AND_LAST:
			return new PreferIdealAndLastProcessSelector();
		default:
			assert false : "Unknown ProcessSelection";
			break;
		}
		return null;
	}

	public ILoadBalancer createLoadBalancer(LoadBalancing load_balancing) {
		double balance_interval = load_balancing.getBalancingInterval()
				.getValue();
		double threshold = load_balancing.getThreshold();
		boolean prio_increasing = load_balancing.getPreferredPriority() == PreferredPriority.HIGHER;
		boolean queue_ascending = load_balancing.getPreferredWaitingTime() == PreferredWaitingTime.SHORT;

		switch (load_balancing.getBalancingType()) {
		case ANY_TO_THRESHOLD:
			return new ToThresholdBalancer(balance_interval, 
					prio_increasing, queue_ascending, (int)threshold);
		case IDLE_TO_THRESHOLD:
//			return new IdleToThresholdBalancer(balance_interval,
//					global_balance, prio_increasing, queue_ascending,
//					max_iterations, threshold);
		case IDLE_TO_ONE:
			return new OneToIdleBalancer(balance_interval, 
					prio_increasing, queue_ascending);
		default:
			assert false : "Unknown LoadBalancing Type.";
			break;
		}
		return null;
	}

	public static void setUsedSimulator(Simulator simulator) {
		usedSimulator = simulator;
	}

	public static Simulator getUsedSimulator() {
		return usedSimulator;
	}

	public void resetFactory() {
		this.active_resource_map.clear();
		this.manager_map.clear();
		this.passive_resource_map.clear();
		this.process_map.clear();
		this.resource_instance_map.clear();
		this.scheduler_map.clear();
	}
}
