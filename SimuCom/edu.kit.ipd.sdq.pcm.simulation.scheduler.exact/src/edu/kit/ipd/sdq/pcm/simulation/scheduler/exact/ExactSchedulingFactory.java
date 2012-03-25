package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact;

import java.util.Hashtable;
import java.util.Map;

import scheduler.SchedulerLibrary;
import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.DynamicPriorityBoostConfiguratioin;
import scheduler.configuration.LoadBalancing;
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
import scheduler.configuration.QuantumTimeSliceConfiguration;
import scheduler.configuration.QueueingConfiguration;
import scheduler.configuration.SchedulerConfiguration;
import scheduler.configuration.TimeSliceConfiguration;
import scheduler.configuration.util.ConfigurationSwitch;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.factory.QueueingConfigurationSwitch;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IInstanceSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.ILoadBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers.OneToIdleBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers.ToThresholdBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.instance.IdleSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.instance.RoundRobinSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.process.NextRunnableProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.process.PreferIdealAndLastProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.impl.PriorityManagerImpl;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update.SleepAverageDependentUpdate;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.PreemptiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IProcessQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.basicqueues.PriorityArray;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.basicqueues.ProcessQueueImpl;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.runqueues.ActiveExpiredRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.runqueues.SingleRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.active.SimResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.IScheduler;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.impl.PreemptiveScheduler;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.ITimeSlice;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.impl.PriorityDependentTimeSlice;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.impl.QuantumTimeSlice;

public class ExactSchedulingFactory {
	

	private static final String PATHMAP_TO_SCHEDULER_LIBRARY = "pathmap://PCM_EXACT_SCHEDULER_MODELS/Library.scheduler";
	
	private SchedulerModel model;
	
	public ExactSchedulingFactory(SchedulerModel model) {
	    this.model = model;
	}
	
	
	private Map<String, IResourceInstance> resource_instance_map = new Hashtable<String, IResourceInstance>();
	private Map<String, ActiveProcess> process_map = new Hashtable<String, ActiveProcess>();
	private Map<String, PriorityManagerImpl> manager_map = new Hashtable<String, PriorityManagerImpl>();
	
	/* Loads scheduler configuration */
	public IActiveResource getResource(SchedulerModel model,
			String schedulerName, int numReplicas, String sensorDescription) {

		SchedulerLibrary lib = (SchedulerLibrary) SchedulerTools
				.loadFromXMI(PATHMAP_TO_SCHEDULER_LIBRARY);
		SchedulerConfiguration selectedConf = null;
		for (SchedulerConfiguration conf : lib.getSchedulerConfiguration()) {
			if (conf.getName().equals(schedulerName)) {
				selectedConf = conf;
				break;
			}
		}
		if (selectedConf != null) {
			ActiveResourceConfiguration resourceConf = null;
			resourceConf = ConfigurationFactory.eINSTANCE
					.createActiveResourceConfiguration();
			resourceConf.setName(schedulerName);
			resourceConf.setReplicas(numReplicas);
			resourceConf.setSchedulerConfiguration(selectedConf);
			SimActiveResource resource = new SimActiveResource(this, model, resourceConf);
				IScheduler scheduler = createScheduler(model, resourceConf.getSchedulerConfiguration(), resource);
				resource.setScheduler(scheduler);
			return resource;
		}
		return null;
	}
	
	private IScheduler createScheduler(SchedulerModel model, SchedulerConfiguration configuration, IActiveResource scheduled_resource) {
		return createPreemptiveScheduler(model, configuration, scheduled_resource);
	}

    private IScheduler createPreemptiveScheduler(SchedulerModel model, SchedulerConfiguration configuration,
            IActiveResource scheduled_resource) {
		IProcessQueue process_queue_prototype = createProcessQueue(model, configuration
				.getPriorityConfiguration());
        IQueueingStrategy queueing_strategy = createQueueingStrategy(model, configuration.getQueueingConfiguration(),
                process_queue_prototype, (SimActiveResource) scheduled_resource);
		boolean in_front_after_waiting = configuration.isInFrontAfterWaiting();
		double scheduling_interval = configuration.getInterval();
		return new PreemptiveScheduler(model, (SimActiveResource) scheduled_resource,
				queueing_strategy, in_front_after_waiting, scheduling_interval, configuration.getStarvationBoost());
	}
    
    private IProcessQueue createProcessQueue(SchedulerModel model, PriorityConfiguration configuration) {
		if (configuration == null) {
			return new ProcessQueueImpl(model);
		}
		PriorityManagerImpl manager = createPriorityManager(configuration
				.getRange());
		return new PriorityArray(model, manager);
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
    
    private IQueueingStrategy createQueueingStrategy(SchedulerModel model, QueueingConfiguration configuration,
            IProcessQueue process_queue_prototype, SimActiveResource resource) {
		IRunQueue runqueue_prototype = createRunQueue(model, configuration
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

	private IRunQueue createRunQueue(SchedulerModel model, scheduler.configuration.RunQueueType type,
			IProcessQueue process_queue_prototype) {
		IRunQueue runqueue = null;
		switch (type) {
		case SINGLE:
			runqueue = new SingleRunQueue(process_queue_prototype);
			break;
		case ACTIVE_AND_EXPIRED:
			runqueue = new ActiveExpiredRunQueue(model, process_queue_prototype);
			break;
		default:
			assert false : "Unknown RunqueueType";
			break;
		}
		return runqueue;
	}

	
	public IResourceInstance createResourceInstance(int index,
			IActiveResource containing_resource) {

		String id = containing_resource.getId() + index;

		IResourceInstance instance = resource_instance_map.get(id);
		if (instance == null) {
			instance = new SimResourceInstance(model, index, containing_resource);
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
            ProcessConfiguration configuration, ActiveResourceConfiguration resourceConfiguration) {
		String id = process.getId() + resourceConfiguration.getId();

		ActiveProcess active_process = process_map.get(id);

		if (active_process == null) {
			if (resourceConfiguration.getReplicas() > 0) {

				if (resourceConfiguration.getSchedulerConfiguration()
						.getPriorityConfiguration() != null) {
					IPriority prio = getPriority(configuration.getPriority(),
							resourceConfiguration.getSchedulerConfiguration()
									.getPriorityConfiguration().getRange());
					active_process = new ProcessWithPriority(model, process, prio);
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
						active_process = new PreemptiveProcess(model, process);
					ITimeSlice timeslice = createTimeSlice(
							resourceConfiguration.getSchedulerConfiguration()
									.getPreemptionConfiguration(),
							active_process);
					timeslice.fullReset();
					((PreemptiveProcess) active_process)
							.setTimeSlice(timeslice);
				} else {
					active_process = new ActiveProcess(model, process);
				}
				process_map.put(id, active_process);
			}
		}

		return active_process;
	}
    
    private IPriorityUpdateStrategy createPriorityUpdadateStrategy(
            PriorityBoostConfiguration boostConfiguration, IActiveProcess process) {
		if (boostConfiguration instanceof DynamicPriorityBoostConfiguratioin) {
			DynamicPriorityBoostConfiguratioin dynamic = (DynamicPriorityBoostConfiguratioin) boostConfiguration;
			return new SleepAverageDependentUpdate(model, process, dynamic
					.getMaxSleepAverage(), dynamic.getMaxBonus());
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
			public ITimeSlice caseQuantumTimeSliceConfiguration(
					QuantumTimeSliceConfiguration configuration) {
				double timeslice = configuration.getTimeslice();
				int quanta = configuration.getQuanta();
				int min_quanta = configuration.getMinQuanta();
				return new QuantumTimeSlice(timeslice,quanta,min_quanta);
			}
			
			@Override
			public ITimeSlice casePriorityDependentTimeSliceConfiguration(
					PriorityDependentTimeSliceConfiguration configuration) {
				double timeslice = configuration.getTimeslice();
				double min_timeslice = configuration.getMinTimeslice();
				double min_time_to_be_scheduled = configuration.getMinTimeToBeScheduled();
				return new PriorityDependentTimeSlice(
						(ProcessWithPriority) process, timeslice,
						min_timeslice, min_time_to_be_scheduled);
			}
		};

		if (preemptionConfiguration != null) {
			TimeSliceConfiguration timesliceConf = preemptionConfiguration
					.getTimesliceConfiguration();
			return timesliceSwitch.doSwitch(timesliceConf);
		}
		return null;
	}
    
    public ILoadBalancer createLoadBalancer(LoadBalancing load_balancing) {
		double balance_interval = load_balancing.getBalancingInterval();
		double threshold = load_balancing.getThreshold();
		boolean prio_increasing = load_balancing.getPreferredPriority() == PreferredPriority.HIGHER;
		boolean queue_ascending = load_balancing.getPreferredWaitingTime() == PreferredWaitingTime.SHORT;

		switch (load_balancing.getBalancingType()) {
		case ANY_TO_THRESHOLD:
			return new ToThresholdBalancer(model, balance_interval, 
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



}
