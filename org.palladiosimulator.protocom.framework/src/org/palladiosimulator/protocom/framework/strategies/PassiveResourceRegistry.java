package org.palladiosimulator.protocom.framework.strategies;

import java.util.HashMap;

/**
 * Registry for passive resource types.
 * 
 * @author zolynski
 */
public class PassiveResourceRegistry {

    private HashMap<String, PassiveResource> passiveResourceHash = new HashMap<String, PassiveResource>();
    private static PassiveResourceRegistry singletonInstance = new PassiveResourceRegistry();

    private PassiveResourceRegistry() {
    }

    public static PassiveResourceRegistry singleton() {
        return singletonInstance;
    }

    public void addPassiveResource(PassiveResource p) {
        passiveResourceHash.put(p.getType(), p);
    }

    public PassiveResource getResource(String type) {
        return this.passiveResourceHash.get(type);
    }

}
