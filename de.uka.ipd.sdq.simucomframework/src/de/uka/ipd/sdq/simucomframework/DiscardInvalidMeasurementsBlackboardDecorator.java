package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.probespec.framework.IBlackboardListener;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Decorates an {@link ISampleBlackboard} in order to discard measurements that
 * arrives after the simulation has been stopped already.
 * 
 * @author pmerkle
 * 
 */
public class DiscardInvalidMeasurementsBlackboardDecorator implements
		ISampleBlackboard {

	private final ISampleBlackboard decorated;
	private final ISimulationControl simControl;

	public DiscardInvalidMeasurementsBlackboardDecorator(
			ISampleBlackboard decorated, ISimulationControl simControl) {
		super();
		
	    this.decorated = decorated;
		this.simControl = simControl;
	}

	public void addBlackboardListener(IBlackboardListener l, Integer... topics) {
		decorated.addBlackboardListener(l, topics);
	}

	public void addSample(ProbeSetSample pss) {
		if (simControl.isRunning()) {
			decorated.addSample(pss);
		}
	}
	
	public void addSampleAfterSimulationEnd(ProbeSetSample pss) {
		decorated.addSample(pss);
	}

	public void deleteSample(ProbeSetAndRequestContext pss) {
		decorated.deleteSample(pss);
	}

	public void deleteSamplesInRequestContext(RequestContext requestContext) {
		decorated.deleteSamplesInRequestContext(requestContext);
	}

	public ProbeSetSample getSample(ProbeSetAndRequestContext probeSetSampleID) {
		return decorated.getSample(probeSetSampleID);
	}

	public int size() {
		return decorated.size();
	}

}
