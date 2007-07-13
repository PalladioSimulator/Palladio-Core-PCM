package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.HashMap;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public class StrategiesRegistry {

	private HashMap<ResourceTypeEnum,IConsumerStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IConsumerStrategy>();
	private static StrategiesRegistry singletonInstance = new StrategiesRegistry();
	
	private StrategiesRegistry() {
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
