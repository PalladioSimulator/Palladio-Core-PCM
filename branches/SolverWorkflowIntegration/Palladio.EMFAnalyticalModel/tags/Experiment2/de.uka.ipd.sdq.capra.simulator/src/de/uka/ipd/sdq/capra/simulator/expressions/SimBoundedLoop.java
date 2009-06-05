package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Hashtable;

import umontreal.iro.lecuyer.probdist.DiscreteDistribution;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import umontreal.iro.lecuyer.randvar.RandomVariateGenInt;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.tools.RandomStreamProvider;

public class SimBoundedLoop implements SimCapraExpression {

	private RandomVariateGen numIterationsGen;
	private SimCapraExpression targetProcess;
	private SimCapraExpression repeatedProcess;
	private int numIterations = -1;

	public SimBoundedLoop(DiscreteDistribution numIterationsDistribution,
			SimCapraExpression repeatedProcess, SimCapraExpression targetProcess) {
		this.repeatedProcess = repeatedProcess;
		this.targetProcess = targetProcess;
		this.numIterationsGen = new RandomVariateGen(RandomStreamProvider.getSelectionStream(),numIterationsDistribution);
	}
	
	private SimBoundedLoop(){
		this.numIterations = -1;
	}

	@Override
	public SimCapraExpression getNext() {
		SimCapraExpression result = null;
		if (numIterations == 0){
			result = targetProcess;
		} else if (numIterations > 0){
			result = repeatedProcess;
		}
		numIterations--;
		return result;
	}

	@Override
	public boolean isAction() {
		return false;
	}

	@Override
	public void reset() {
		numIterations = (int)numIterationsGen.nextDouble();		
	}

	@Override
	public void useSensorInstances(
			Hashtable<String, SimSensorInstance> sensorInstanceTable) {
		repeatedProcess.useSensorInstances(sensorInstanceTable);
		targetProcess.useSensorInstances(sensorInstanceTable);
	}
	
	public SimBoundedLoop clone(){
		SimBoundedLoop loop = new SimBoundedLoop();
		loop.targetProcess = this.targetProcess.clone();
		loop.repeatedProcess = this.repeatedProcess.clone();
		loop.numIterationsGen = this.numIterationsGen;
		return loop;
	}
}
