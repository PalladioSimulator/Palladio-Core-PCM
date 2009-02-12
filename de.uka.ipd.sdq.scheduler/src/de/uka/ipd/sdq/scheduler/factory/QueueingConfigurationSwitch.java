package de.uka.ipd.sdq.scheduler.factory;

import scheduler.configuration.MultipleQueueConfiguration;
import scheduler.configuration.SingleQueueConfiguration;
import scheduler.configuration.util.ConfigurationSwitch;
import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.balancers.AbstractLoadBalancer;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.queueing.strategies.SingleQueueStrategy;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class QueueingConfigurationSwitch extends ConfigurationSwitch<IQueueingStrategy> {
	
	
	private IInstanceSelector instance_selector;
	private IRunQueue runqueue_prototype;
	private SimActiveResource resource;
	private SchedulingFactory factory;

	public QueueingConfigurationSwitch(IRunQueue runqueue_prototype, IInstanceSelector instance_selector, SchedulingFactory factory, SimActiveResource resource){
		this.instance_selector = instance_selector;
		this.runqueue_prototype = runqueue_prototype;
		this.factory = factory;
		this.resource = resource;
	}
	
	@Override
	public IQueueingStrategy caseMultipleQueueConfiguration(
			MultipleQueueConfiguration configuration) {
		AbstractLoadBalancer load_balancer = (AbstractLoadBalancer)factory.createLoadBalancer(configuration.getLoadBalancing());
		MultipleQueuesStrategy strategy = new MultipleQueuesStrategy(resource.getInstanceList(), runqueue_prototype, instance_selector, load_balancer);
		load_balancer.setQueueHolder(strategy);
		return strategy;
	}
	
	@Override
	public IQueueingStrategy caseSingleQueueConfiguration(SingleQueueConfiguration configuration) {
		IProcessSelector processSelector = factory.createProcessSelector(configuration.getProcessSelection());
		return new SingleQueueStrategy(runqueue_prototype, processSelector, instance_selector);
	}
}
