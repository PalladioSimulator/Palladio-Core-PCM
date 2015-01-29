package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.util.HashMap;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

/**
 * The StrategiesRegistry class is used to store initialized strategies for lookup during the prototype's execution.
 * @author Christian Klaussner
 */
public final class StrategiesRegistry {
	private static final StrategiesRegistry INSTANCE = new StrategiesRegistry();
    private final HashMap<ResourceTypeEnum, IDemandStrategy> strategies = new HashMap<ResourceTypeEnum, IDemandStrategy>();

    /**
     * Private singleton constructor.
     */
    private StrategiesRegistry() {
    }

    /**
     * Gets the instance of the strategies registry.
     * @return the instance of the strategies registry
     */
    public static StrategiesRegistry getInstance() {
        return INSTANCE;
    }

    /**
     * Registers a strategy.
     * @param resourceType the type of the strategy
     * @param strategy the strategy to register
     */
    public void registerStrategy(ResourceTypeEnum resourceType, IDemandStrategy strategy) {
        strategies.put(resourceType, strategy);
    }

    /**
     * Gets a registered strategy of the specified type.
     * @param resourceType the type of strategy to retrieve
     * @return a registered strategy of the specified type
     */
    public IDemandStrategy getStrategy(ResourceTypeEnum resourceType) {
        if (!strategies.containsKey(resourceType)) {
            throw new RuntimeException("No strategy registered for " + resourceType);
        }

        return strategies.get(resourceType);
    }
}
