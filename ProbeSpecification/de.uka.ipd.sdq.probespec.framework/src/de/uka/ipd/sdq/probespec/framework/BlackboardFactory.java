package de.uka.ipd.sdq.probespec.framework;

import de.uka.ipd.sdq.probespec.framework.concurrency.ConcurrentSampleBlackboard;

/**
 * This factory creates instances of {@link ISampleBlackboard} for the various
 * {@link BlackboardType}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class BlackboardFactory {

    /**
     * Creates a blackboard of the specified type. If a {@link BlackboardType#CONCURRENT} blackboard
     * is to be created, a <code>probeSpecContext</code> is expected; otherwise, this parameter may
     * be <code>null</code>.
     * 
     * @param type
     *            the type of the blackboard to create
     * @param probeSpecContext
     *            the {@link ProbeSpecContext}, if creating a {@link BlackboardType#CONCURRENT}
     *            blackboard; <code>null</code> else
     * @return the created blackboard
     */
    public static ISampleBlackboard createBlackboard(BlackboardType type, ProbeSpecContext probeSpecContext) {
        switch (type) {
        case SIMPLE:
            return new SampleBlackboard();
        case CONCURRENT:
            return new ConcurrentSampleBlackboard(probeSpecContext);
        case NONE:
            return new NullSampleBlackboard();
        }

        throw new RuntimeException("Could not create a blackboard of type " + type.toString()
                + ", as it is unknown how to handle this type.");
    }

}
