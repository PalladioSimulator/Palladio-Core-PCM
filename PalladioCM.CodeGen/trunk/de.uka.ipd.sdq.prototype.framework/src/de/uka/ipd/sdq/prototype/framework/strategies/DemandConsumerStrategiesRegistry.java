package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.HashMap;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public class DemandConsumerStrategiesRegistry {

	private HashMap<ResourceTypeEnum,IDemandConsumerStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IDemandConsumerStrategy>();
	private static DemandConsumerStrategiesRegistry singletonInstance = new DemandConsumerStrategiesRegistry();
	
	private DemandConsumerStrategiesRegistry() {
	}

	public static DemandConsumerStrategiesRegistry singleton() {
		return singletonInstance;
	}
	
	public void registerStrategyFor(ResourceTypeEnum resourceType, IDemandConsumerStrategy strategy){
		strategiesHash.put(resourceType, strategy);
	}
	
	public IDemandConsumerStrategy getStrategyFor(ResourceTypeEnum resource) {
		assert strategiesHash.containsKey(resource);
		
		return strategiesHash.get(resource);
	}
}
