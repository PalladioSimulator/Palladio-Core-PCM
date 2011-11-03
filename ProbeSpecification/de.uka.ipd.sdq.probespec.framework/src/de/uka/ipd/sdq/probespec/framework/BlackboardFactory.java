package de.uka.ipd.sdq.probespec.framework;

import de.uka.ipd.sdq.probespec.framework.concurrency.ConcurrentSampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.concurrency.ThreadManager;

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
     * is to be created, a <code>threadManager</code> is expected; otherwise, this parameter may
     * be <code>null</code>.
     * 
     * @param type
     *            the type of the blackboard to create
     * @param threadManager
     *            the {@link ThreadManager}, if creating a {@link BlackboardType#CONCURRENT}
     *            blackboard; <code>null</code> else
     * @return the created blackboard
     */
    public static ISampleBlackboard createBlackboard(BlackboardType type, ThreadManager threadManager) {
        switch (type) {
        case SIMPLE:
            return new SampleBlackboard();
        case CONCURRENT:
            return new ConcurrentSampleBlackboard(threadManager);
        case NONE:
            return new NullSampleBlackboard();
        }

        throw new RuntimeException("Could not create a blackboard of type " + type.toString()
                + ", as it is unknown how to handle this type.");
    }

}
