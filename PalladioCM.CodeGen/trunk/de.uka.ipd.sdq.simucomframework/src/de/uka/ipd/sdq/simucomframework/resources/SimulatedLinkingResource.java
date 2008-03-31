package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.exceptions.ThroughputZeroOrNegativeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class SimulatedLinkingResource extends AbstractScheduledResource {
	
	private String throughput;
	private String latencySpec;
	
	public SimulatedLinkingResource(SimuComModel myModel, String typeID, String description, String d, String latencySpec)
	{
		super (myModel, typeID, description, SchedulingStrategy.FCFS);
		this.latencySpec = latencySpec;
		this.throughput = d;
	}

	@Override
	protected double calculateDemand(double demand) {
		double calculatedThroughput = NumberConverter.toDouble(StackContext.evaluateStatic(throughput));
		if (calculatedThroughput <= 0) {
			throw new ThroughputZeroOrNegativeException("Throughput at resource "+getName()+" was less or equal zero");
		}
		return NumberConverter.toDouble(StackContext.evaluateStatic(latencySpec)) + 
				demand/calculatedThroughput;
	}

}
