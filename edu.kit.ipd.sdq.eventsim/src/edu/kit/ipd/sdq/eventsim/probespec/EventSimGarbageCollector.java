package edu.kit.ipd.sdq.eventsim.probespec;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.RegionBasedGarbageCollector;
import edu.kit.ipd.sdq.eventsim.entities.User;

/**
 * A {@link RegionBasedGarbageCollector}, specialised to be used within EventSim. It enables a
 * {@link RequestContext} to be used as region identifier. More precisely, the specified
 * {@link RequestContext} gets translated to the appropriate region identifier.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimGarbageCollector extends RegionBasedGarbageCollector<RequestContext> {

    private ISampleBlackboard blackboard;

    /**
     * Constructs a garbage collector for the measurements on the specified blackboard.
     * 
     * @param blackboard
     *            the blackboard whose measurements are to be collected
     */
    public EventSimGarbageCollector(ISampleBlackboard blackboard) {
        this.blackboard = blackboard;
    }

    public void collectSamplesOfUser(User user) {
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void collectRegionSamples(RequestContext regionId) {
        blackboard.deleteSamplesInRequestContext(regionId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RequestContext obtainRegionId(ProbeSetAndRequestContext sampleId) {
        return sampleId.getCtxID().rootContext();
    }

}
