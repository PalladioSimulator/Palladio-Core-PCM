package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.factory;

import scheduler.configuration.MultipleQueueConfiguration;
import scheduler.configuration.SingleQueueConfiguration;
import scheduler.configuration.util.ConfigurationSwitch;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.ExactSchedulingFactory;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IInstanceSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers.AbstractLoadBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.strategies.MultipleQueuesStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.strategies.SingleQueueStrategy;

public class QueueingConfigurationSwitch extends ConfigurationSwitch<IQueueingStrategy> {
	
	
	private IInstanceSelector instance_selector;
	private IRunQueue runqueue_prototype;
	private SimActiveResource resource;
	private ExactSchedulingFactory factory;

	public QueueingConfigurationSwitch(IRunQueue runqueue_prototype, IInstanceSelector instance_selector, ExactSchedulingFactory factory, SimActiveResource resource){
		this.instance_selector = instance_selector;
		this.runqueue_prototype = runqueue_prototype;
		this.factory = factory;
		this.resource = resource;
	}
	
	@Override
	public IQueueingStrategy caseMultipleQueueConfiguration(
			MultipleQueueConfiguration configuration) {
		AbstractLoadBalancer load_balancer = (AbstractLoadBalancer)factory.createLoadBalancer(configuration.getLoadBalancing());
		MultipleQueuesStrategy strategy = new MultipleQueuesStrategy(resource.getInstanceList(), runqueue_prototype, instance_selector, load_balancer, configuration.isInFrontWhenBalancing());
		load_balancer.setQueueHolder(strategy);
		return strategy;
	}
	
	@Override
	public IQueueingStrategy caseSingleQueueConfiguration(SingleQueueConfiguration configuration) {
		IProcessSelector processSelector = factory.createProcessSelector(configuration.getProcessSelection());
		return new SingleQueueStrategy(runqueue_prototype, processSelector, instance_selector);
	}
}
