package de.uka.ipd.sdq.simucomframework;

import java.util.Observable;
import java.util.Observer;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;

public class MaxMeasurementsStopCondition extends Condition implements Observer{

	private int measurementCounter = 0;
	private static final int MAX_MEASUREMENTS = 10; 
	
	public MaxMeasurementsStopCondition(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);

		((SimuComModel)owner).getSensorFactory().addSensorObserver(new ISensorObserver(){
			public void sensorAddedEvent(SensorAddedEvent e)
			{
				if (e.getId().contains("Response Time of") && !e.getId().contains("Call")){
					e.getSupplier().addObserver(MaxMeasurementsStopCondition.this);
				}
			}
		});
	}

	public boolean check() {
		return (measurementCounter<MAX_MEASUREMENTS);
	}
	
	public void update(Observable o, Object arg) {
		measurementCounter++;
	}

	@Override
	public boolean check(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
