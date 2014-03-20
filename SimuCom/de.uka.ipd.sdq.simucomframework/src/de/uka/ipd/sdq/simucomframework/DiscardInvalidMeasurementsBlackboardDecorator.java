//package de.uka.ipd.sdq.simucomframework;
//
//import de.uka.ipd.sdq.probespec.framework.IBlackboardListener;
//import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
//import de.uka.ipd.sdq.probespec.framework.measurements.MeasurementSet;
//import de.uka.ipd.sdq.probespec.framework.requestcontext.ProbeAndRequestContext;
//import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
//import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
//
///**
// * Decorates an {@link ISampleBlackboard} in order to discard measurements that
// * arrives after the simulation has been stopped already.
// *
// * @author pmerkle
// *
// */
//public class DiscardInvalidMeasurementsBlackboardDecorator implements
//		ISampleBlackboard {
//
//	private final ISampleBlackboard decorated;
//	private final ISimulationControl simControl;
//
//	public DiscardInvalidMeasurementsBlackboardDecorator(
//			ISampleBlackboard decorated, ISimulationControl simControl) {
//		super();
//
//	    this.decorated = decorated;
//		this.simControl = simControl;
//	}
//
//	public void addBlackboardListener(IBlackboardListener l, Integer... topics) {
//		decorated.addBlackboardListener(l, topics);
//	}
//
//	public void addSample(MeasurementSet pss) {
//		if (simControl.isRunning()) {
//			decorated.addSample(pss);
//		}
//	}
//
//	public void addSampleAfterSimulationEnd(MeasurementSet pss) {
//		decorated.addSample(pss);
//	}
//
//	public void deleteSample(ProbeAndRequestContext pss) {
//		decorated.deleteSample(pss);
//	}
//
//	public void deleteSamplesInRequestContext(RequestContext requestContext) {
//		decorated.deleteSamplesInRequestContext(requestContext);
//	}
//
//	public MeasurementSet getSample(ProbeAndRequestContext probeSetSampleID) {
//		return decorated.getSample(probeSetSampleID);
//	}
//
//	public int size() {
//		return decorated.size();
//	}
//
//}
