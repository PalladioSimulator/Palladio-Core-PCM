package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.List;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.IBlackboardListener;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
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

	private ISampleBlackboard decorated;
	private ISimulationControl simControl;

	public DiscardInvalidMeasurementsBlackboardDecorator(
			ISampleBlackboard decorated, ISimulationControl simControl) {
		this.decorated = decorated;
		this.simControl = simControl;
	}

	public void addBlackboardListener(IBlackboardListener l, Integer... topics) {
		decorated.addBlackboardListener(l, topics);
	}

	public void addSample(ProbeSample<?, ? extends Quantity> sample,
			RequestContext requestContextID, Integer probeSetId) {
		if (simControl.isRunning()) {
			List<ProbeSample<?, ? extends Quantity>> samples = new ArrayList<ProbeSample<?,? extends Quantity>>();
			samples.add(sample);
			decorated.addSample(samples, requestContextID, probeSetId);
		}
	}
	
	public void addSample(List<ProbeSample<?, ? extends Quantity>> samples,
			RequestContext requestContextID, Integer probeSetId) {
		if (simControl.isRunning()) {
			decorated.addSample(samples, requestContextID, probeSetId);
		}
	}
	
	public void addSampleAfterSimulationEnd(ProbeSample<?, ? extends Quantity> sample,
			RequestContext requestContextID, Integer probeSetId) {
		List<ProbeSample<?, ? extends Quantity>> samples = new ArrayList<ProbeSample<?,? extends Quantity>>();
		samples.add(sample);
		decorated.addSample(samples, requestContextID, probeSetId);
	}
	
	public void addSampleAfterSimulationEnd(List<ProbeSample<?, ? extends Quantity>> samples,
			RequestContext requestContextID, Integer probeSetId) {
		decorated.addSample(samples, requestContextID, probeSetId);
	}

	@Override
	public void deleteSampleSet(RequestContext requestContext, Integer probeSetID) {
		decorated.deleteSampleSet(requestContext, probeSetID);
	}

	public void deleteSamplesInRequestContext(RequestContext requestContext) {
		decorated.deleteSamplesInRequestContext(requestContext);
	}

	@Override
	public ProbeSetSample getSample(RequestContext requestContext, Integer probeSetID) {
		return decorated.getSample(requestContext, probeSetID);
	}

	public int size() {
		return decorated.size();
	}

}
