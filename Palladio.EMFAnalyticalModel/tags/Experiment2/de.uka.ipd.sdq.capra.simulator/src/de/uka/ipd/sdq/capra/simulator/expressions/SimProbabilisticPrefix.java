package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Hashtable;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;

public class SimProbabilisticPrefix implements SimCapraExpression {

	private SimAction action;
	private SimInternalSelector[] targetOptions;
	private RandomStream stream;
	
	private SimCapraExpression selectedExpression = null;
	
	private int next = 0;
	
	
	public SimProbabilisticPrefix(SimAction action,
			SimInternalSelector[] targetOptions, RandomStream stream) {
		super();
		this.action = action;
		this.targetOptions = targetOptions;
		this.stream = stream;
	}

	public SimProbabilisticPrefix(SimAction action,
			SimInternalSelector[] targetOptions) {
		this(action, targetOptions, new MRG32k3a());
	}


	public SimProbabilisticPrefix clone(){
		SimInternalSelector[] newTargetOptions = new SimInternalSelector[targetOptions.length];
		for (int i=0; i<targetOptions.length; i++) {
			newTargetOptions[i] = targetOptions[i].clone();
		}
		return new SimProbabilisticPrefix(action.clone(), newTargetOptions);
	}

	@Override
	public void useSensorInstances(Hashtable<String,SimSensorInstance> sensorInstanceTable) {
		action.useSensorInstances(sensorInstanceTable);
		for (SimInternalSelector selector : targetOptions) {
			selector.getCapraExpression().useSensorInstances(sensorInstanceTable);
		}
	}

	@Override
	public void reset() {
		double choice = stream.nextDouble();
		double current = 0;
		for (SimInternalSelector selector : targetOptions) {
			current += selector.getProbability();
			if (choice <= current){
				selectedExpression = selector.getCapraExpression();
				break;
			}
		}
		next = 1;
	}

	@Override
	public SimCapraExpression getNext() {
		SimCapraExpression result = null;
		switch (next) {
		case 1:
			result = action;
			next++;
			break;
		case 2:
			result = selectedExpression;
			next++;
			break;
		}
		return result;
	}

	@Override
	public boolean isAction() {
		return false;
	}

}
