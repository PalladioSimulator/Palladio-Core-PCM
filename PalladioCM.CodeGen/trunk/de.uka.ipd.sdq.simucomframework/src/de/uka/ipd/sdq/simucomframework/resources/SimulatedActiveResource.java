package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedActiveResource extends AbstractScheduledResource {
	
	private double processingRate = 0;
	private String units = null;
	
	public SimulatedActiveResource(SimuComModel myModel, String typeID, double d, String units, SchedulingStrategy strategy)
	{
		super (myModel, typeID, strategy);
		this.processingRate = d;
		this.units = units;
	}

	@Override
	protected double calculateDemand(double demand) {
		return demand/processingRate;
	}

}
