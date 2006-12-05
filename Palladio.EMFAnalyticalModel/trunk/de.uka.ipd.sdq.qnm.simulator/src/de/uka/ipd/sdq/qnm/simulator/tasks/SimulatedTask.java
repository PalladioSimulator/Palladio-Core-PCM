package de.uka.ipd.sdq.qnm.simulator.tasks;

import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.simulator.QNModelInstance;
import de.uka.ipd.sdq.qnm.simulator.SimuQNModel;
import de.uka.ipd.sdq.qnm.visitors.ResourceModelVisitor;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedTask extends SimProcess {

	private AbstractResourceUsage completeResourceUsage;

	private Double currentDemand;

	private String histogramId;
	
	public SimulatedTask(Model owner, String name, boolean showInTrace,
			AbstractResourceUsage aru) {
		super(owner, name, showInTrace);
		completeResourceUsage = aru;

		histogramId = "Response Times per Task";
		
		SimuQNModel model = (SimuQNModel)owner;
//		QNModel qnModel = model.getEmfModel().getQnModel();
//		histogramId += "Tasks: "
//				+ ((Task) qnModel.getTasks().get(0)).getNumReplicas() + " | ";
//		histogramId += "Threads: "
//				+ ((PassiveResource) qnModel.getResources().get(3))
//						.getNumReplicas();
		
		if (!model.getSensorFactory().hasHistogram(histogramId))
			model.getSensorFactory().createHistogramSensor(histogramId);
		
	}

	@Override
	public void lifeCycle() {
		SimuQNModel model = (SimuQNModel) getModel();

		while (true) {
			SimTime startTime = currentTime();

			ResourceModelVisitor visitor = new ResourceModelVisitor(this);
			visitor.doSwitch(completeResourceUsage);

			SimTime stopTime = currentTime();
			model.getSensorFactory().getValueSupplierForSensor(histogramId)
				.newResponseTimeMeasurement(
						SimTime.diff(stopTime, startTime).getTimeValue());
		}
	}

	public Double getCurrentDemand() {
		return currentDemand;
	}

	public void setCurrentDemand(Double currentDemand) {
		this.currentDemand = currentDemand;
	}
}
