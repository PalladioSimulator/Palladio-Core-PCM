package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.util.HashMap;

import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ResourceTypeEnum;

/**
 * 
 * @author Christian Klaussner
 */
public final class StrategiesRegistry {
	private static StrategiesRegistry instance = new StrategiesRegistry();
    private final HashMap<ResourceTypeEnum, IDemandStrategy> strategies = new HashMap<ResourceTypeEnum, IDemandStrategy>();

    /**
     * Private singleton constructor.
     */
    private StrategiesRegistry() {
    }

    public static StrategiesRegistry getInstance() {
        return instance;
    }

    public void registerStrategy(ResourceTypeEnum resourceType, IDemandStrategy strategy) {
        strategies.put(resourceType, strategy);
    }

    public IDemandStrategy getStrategy(ResourceTypeEnum resourceType) {
        if (!strategies.containsKey(resourceType)) {
            throw new RuntimeException("No strategy registered for " + resourceType);
        }

        return strategies.get(resourceType);
    }
}
