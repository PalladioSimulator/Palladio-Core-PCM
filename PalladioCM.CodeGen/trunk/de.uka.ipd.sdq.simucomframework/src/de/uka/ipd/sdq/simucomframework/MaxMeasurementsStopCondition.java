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
	private long max_measurements = 1000; 
	
	public MaxMeasurementsStopCondition(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);

		max_measurements = ((SimuComModel)owner).getConfig().getMaxMeasurementsCount();
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
		return (max_measurements > 0) && (measurementCounter>=max_measurements);
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
