package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.HashMap;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;

public class DemandConsumerStrategiesRegistry {

	private HashMap<ResourceTypeEnum,IDemandStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IDemandStrategy>();
	private static DemandConsumerStrategiesRegistry singletonInstance = new DemandConsumerStrategiesRegistry();
	
	private DemandConsumerStrategiesRegistry() {
	}

	public static DemandConsumerStrategiesRegistry singleton() {
		return singletonInstance;
	}
	
	public void registerStrategyFor(ResourceTypeEnum resourceType, IDemandStrategy strategy){
		strategiesHash.put(resourceType, strategy);
	}
	
	public IDemandStrategy getStrategyFor(ResourceTypeEnum resource) {
		if(!strategiesHash.containsKey(resource)) {
			// TODO: This is a temporary J2EE hack
			IDemandStrategy strategy = new FibonacciDemand();
			strategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM,1000);
			strategiesHash.put(resource,strategy);
			return strategy;
			// throw new RuntimeException("Requested Resourcestrategy >"+resource+"< is not registered!");
		}
		
		return strategiesHash.get(resource);
	}
}
