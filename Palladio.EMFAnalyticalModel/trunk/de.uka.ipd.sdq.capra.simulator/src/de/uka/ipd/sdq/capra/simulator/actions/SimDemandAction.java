package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.Hashtable;

import umontreal.iro.lecuyer.probdist.Distribution;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.tools.RandomStreamProvider;
import de.uka.ipd.sdq.scheduler.IActiveResource;

/**
 * @author     jens.happe
 */
public class SimDemandAction implements SimAction {

	private IActiveResource resource;
	private Distribution distribution;
	private RandomVariateGen generator;
	private String name;
	private double samplingWidth;
	private RandomStream flatStream;
	
	
	public SimDemandAction(String name, IActiveResource resource, Distribution distribution, double samplingWidth) {
		super();
		this.resource = resource;
		this.distribution = distribution;
		this.generator = new RandomVariateGen(RandomStreamProvider.getTimeStream(), distribution);
		this.flatStream = RandomStreamProvider.getTimeStream();
		this.name = name;
		this.samplingWidth = samplingWidth;
	}
	
	@Override
	public void execute(SimCapraProcess process) {
		resource.process(process, getNextSample());
	}
	
	private double getNextSample() {
		return Math.abs( generator.nextDouble() + (flatStream.nextDouble() - 0.5) * samplingWidth);
	}

	public SimDemandAction clone(){
		SimDemandAction action = new SimDemandAction(name,resource,distribution,samplingWidth);
		return action;
	}

	@Override
	public void useSensorInstances(Hashtable<String,SimSensorInstance> sensorInstanceTable) {
		// nothing to do.
	}

	@Override
	public void reset() {
	}

	@Override
	public SimCapraExpression getNext() {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}
}
