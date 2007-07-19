package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.HashMap;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public class StrategiesRegistry {

	private HashMap<ResourceTypeEnum,IConsumerStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IConsumerStrategy>();
	private static StrategiesRegistry singletonInstance = new StrategiesRegistry();
	
	private StrategiesRegistry() {
		IConsumerStrategy stratCPU = new FibonacciCPUStrategy();
		//TODO: inject the real processing rate
		stratCPU.initialiseStrategy(1000);
		registerStrategyFor(ResourceTypeEnum.CPU, stratCPU);
		
		IConsumerStrategy stratHDD = new ReadLargeChunksHDDStrategy();
		registerStrategyFor(ResourceTypeEnum.HDD, stratHDD);

		
	}

	public static StrategiesRegistry singleton() {
		return singletonInstance;
	}
	
	public void registerStrategyFor(ResourceTypeEnum resourceType, IConsumerStrategy strategy){
		strategiesHash.put(resourceType, strategy);
	}
	
	public IConsumerStrategy getStrategyFor(ResourceTypeEnum resource) {
		assert strategiesHash.containsKey(resource);
		
		return strategiesHash.get(resource);
	}
}
