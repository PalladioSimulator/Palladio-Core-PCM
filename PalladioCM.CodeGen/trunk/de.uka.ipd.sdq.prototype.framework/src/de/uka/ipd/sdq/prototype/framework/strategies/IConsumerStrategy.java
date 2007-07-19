package de.uka.ipd.sdq.prototype.framework.strategies;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public interface IConsumerStrategy {
	
	/**
	 * Initialise the strategy to the passed processing rate in units/sec
	 * @param processingRate The rate to initialise to
	 */
	void initialiseStrategy(double processingRate);
	
	/**
	 * Consume a resource according to its demand
	 * @param demand The demand to consume
	 */
	void consume (double demand);
	
	/**
	 * Get the resource this strategy is able to simulate
	 * @return The resource type we can simulate
	 */
	ResourceTypeEnum getStrategysResource();
}
