package org.palladiosimulator.protocom.framework.strategies;

import java.util.HashMap;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.FibonacciDemand;

public class StrategiesRegistry {

	private HashMap<ResourceTypeEnum,IDemandStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IDemandStrategy>();
	private static StrategiesRegistry singletonInstance = new StrategiesRegistry();
	
	private StrategiesRegistry() {
		IDemandStrategy strat = new FibonacciDemand();
		//TODO: inject the real processing rate
		strat.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM,1);
		registerStrategyFor(ResourceTypeEnum.CPU, strat);
		
	}

	public static StrategiesRegistry singleton() {
		return singletonInstance;
	}
	
	public void registerStrategyFor(ResourceTypeEnum resourceType, IDemandStrategy strategy){
		strategiesHash.put(resourceType, strategy);
	}
	
	public IDemandStrategy getStrategyFor(ResourceTypeEnum resource) {
		assert strategiesHash.containsKey(resource);
		
		return strategiesHash.get(resource);
	}
}
