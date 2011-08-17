package de.uka.ipd.sdq.probespec.framework;

/**
 * This blackboard discards any measurement that is published at the blackboard. Thus, the
 * {@link #getSample(ProbeSetAndRequestContext)} method returns always null.
 * <p>
 * Use this blackboard, when no measurements are supposed to be stored.
 * 
 * @author Philipp Merkle
 * 
 */
public class NullSampleBlackboard implements ISampleBlackboard {

    @Override
    public void addBlackboardListener(IBlackboardListener l, Integer... topics) {
        // nothing to do
    }

    @Override
    public void addSample(ProbeSetSample pss) {
        // nothing to do
    }

    @Override
    public void deleteSample(ProbeSetAndRequestContext pss) {
        // nothing to do
    }

    @Override
    public void deleteSamplesInRequestContext(RequestContext requestContext) {
        // nothing to do
    }

    @Override
    public ProbeSetSample getSample(ProbeSetAndRequestContext probeSetSampleID) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
