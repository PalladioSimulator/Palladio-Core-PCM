package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedActiveResource extends AbstractScheduledResource {

	private String processingRate = "0";
	private String units = null;

	public SimulatedActiveResource(SimuComModel myModel, String typeID,
			String description, String processingRate, Double mttf,
			Double mttr, String units, SchedulingStrategy strategy) {
		super(myModel, typeID, description, strategy);
		this.processingRate = processingRate;
		this.units = units;
		this.mttf = mttf;
		this.mttr = mttr;
		this.canFail = ((this.mttf > 0.0) && (this.mttr > 0.0));

		// used to let resource fail and be repaired again:
		if (this.canFail) {
			this.failedEvent = new ResourceFailedEvent(myModel,
					"ResourceFailed");
			this.repairedEvent = new ResourceRepairedEvent(myModel,
					"ResourceRepaired");
			this.failedEvent.setResource(this);
			this.failedEvent.setRepairedEvent(repairedEvent);
			this.repairedEvent.setResource(this);
			this.repairedEvent.setFailedEvent(failedEvent);
		}
	}

	@Override
	protected double calculateDemand(double demand) {
		return demand
				/ (Double) Context.evaluateStatic(processingRate, Double.class);
	}
}
