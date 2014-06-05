package edu.kit.ipd.sdq.eventsim.resources;

import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;

public enum SchedulingPolicy {

    FCFS("FCFS"), PROCESSOR_SHARING("ProcessorSharing"), DELAY("Delay");

    private String id;

    SchedulingPolicy(String id) {
        this.id = id;
    }

    public static SchedulingPolicy getPolicyForId(String id) {
        for (SchedulingPolicy p : SchedulingPolicy.values()) {
            if (p.id.equalsIgnoreCase(id)) {
                return p;
            }
        }
        throw new EventSimException("Could not find SchedulingPolicy for id " + id);
    }

}
