package org.palladiosimulator.protocom.framework.java.se.strategies;

import java.util.HashMap;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.FibonacciDemand;

public class StrategiesRegistry {

    private final HashMap<ResourceTypeEnum, IDemandStrategy> strategiesHash = new HashMap<ResourceTypeEnum, IDemandStrategy>();
    private static StrategiesRegistry singletonInstance = new StrategiesRegistry();

    private StrategiesRegistry() {
        final IDemandStrategy strat = new FibonacciDemand();
        // TODO: inject the real processing rate
        strat.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, 1);
        strat.ensureCalibrationExists();
        registerStrategyFor(ResourceTypeEnum.CPU, strat);

    }

    public static StrategiesRegistry singleton() {
        return singletonInstance;
    }

    public void registerStrategyFor(final ResourceTypeEnum resourceType, final IDemandStrategy strategy) {
        this.strategiesHash.put(resourceType, strategy);
    }

    public IDemandStrategy getStrategyFor(final ResourceTypeEnum resource) {
        assert this.strategiesHash.containsKey(resource);

        return this.strategiesHash.get(resource);
    }
}
