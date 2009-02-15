package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedActiveResource extends AbstractScheduledResource {
	
	private String processingRate = "0";
	private String units = null;
	
	public SimulatedActiveResource(SimuComModel myModel, String typeID, String description, String processingRate, String units, SchedulingStrategy strategy)
	{
		super (myModel, typeID, description, strategy);
		this.processingRate = processingRate;
		this.units = units;
	}

	@Override
	protected double calculateDemand(double demand) {
		return demand/(Double)Context.evaluateStatic(
				this.getModel().getStoExCache(),
				processingRate,Double.class);
	}

}
