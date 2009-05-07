package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.ReplicatedProcess;
import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.resources.Resource;
import de.uka.ipd.sdq.capra.simulator.SimulationModel;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;

public class SimulationModelCreator {
	
	public static SimulationModel createFrom(CapraModel capraModel){
		SimulationModel model = new SimulationModel();

		transformResoruces(capraModel, model);
		transformSensors(capraModel, model);
		transformProcesses(capraModel, model);
		
		return model;
	}

	private static void transformProcesses(CapraModel capraModel,
			SimulationModel model) {
		CapraExpressionFactory expressionFactory = new CapraExpressionFactory();
		CapraExpressionTransformer expressionTransformer = new CapraExpressionTransformer(model.getResources(), expressionFactory, model.getSensors());
		CapraProcessManager processes = model.getProcesses();
		for(ReplicatedProcess p: capraModel.getProcesses()){
			SimCapraExpression expression = expressionTransformer.transformCapraExpression(p.getProcessvariable().getProcess());
			String name = p.getProcessvariable().getName();
			int numReplicas = p.getNumReplicas();
			processes.addNewProcess(expression, name, numReplicas);
		}
	}

	private static void transformSensors(CapraModel capraModel,
			SimulationModel model) {
		SensorFactory sensorFactory = new SensorFactory();
		SensorTransformer sensorTransformer = new SensorTransformer(sensorFactory);
		SensorManager sensors = model.getSensors();
		for (Sensor s : capraModel.getSensors()) {
			SimSensor simSensor = sensorTransformer.transformSensor(s);
			sensors.addSensor(simSensor);
		}
	}

	private static void transformResoruces(CapraModel capraModel,
			SimulationModel model) {
		ResourceTransformer resourceTransformer = new ResourceTransformer(model.getResources());
		for(Resource r : capraModel.getResources()){
			resourceTransformer.transformResource(r);
		}
	}
}
