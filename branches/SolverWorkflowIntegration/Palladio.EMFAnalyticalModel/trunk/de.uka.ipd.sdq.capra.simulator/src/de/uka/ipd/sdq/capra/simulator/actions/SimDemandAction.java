package de.uka.ipd.sdq.capra.simulator.actions;

import umontreal.iro.lecuyer.probdist.Distribution;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.tools.RandomStreamProvider;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

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
		if (resource instanceof SimActiveResource){
			process.setMainResource((SimActiveResource)resource);
		}
		resource.process(process, getNextSample());
	}
	
	private double getNextSample() {
		return Math.abs( generator.nextDouble() + (flatStream.nextDouble() - 0.5) * samplingWidth);
	}

	@Override
	public SimDemandAction clone(){
		SimDemandAction action = new SimDemandAction(name,resource,distribution,samplingWidth);
		return action;
	}

	@Override
	public void reset() {
	}

	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void addFinishingListener(IFinishingListener listener) {
		
	}
	
}
