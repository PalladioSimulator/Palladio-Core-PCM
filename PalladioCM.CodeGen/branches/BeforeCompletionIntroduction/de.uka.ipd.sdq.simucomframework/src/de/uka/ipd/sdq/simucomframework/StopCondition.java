package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//import umontreal.iro.lecuyer.probdist.EmpiricalDist;
//import umontreal.iro.lecuyer.probdist.StudentDist;

import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;

public class StopCondition extends Condition implements Observer
{
	private ArrayList values = new ArrayList();
	
	public StopCondition(Model owner, String name, final String myId, boolean showInTrace) {
		super(owner, name, showInTrace);
		SensorFactory.singleton().addSensorObserver(new ISensorObserver(){
			public void sensorAddedEvent(SensorAddedEvent e)
			{
				if (e.getId().equals(myId)){
					e.getSupplier().addObserver(StopCondition.this);
				}
			}
		});
	}

	public boolean check() {
		double[] vals = new double[values.size()];
		for (int i=0; i<values.size();i++)
			vals[i] = (Double)values.get(i);
		if (vals.length < 2) 
			return false;
		//EmpiricalDist d = new EmpiricalDist(vals);
		//StudentDist sd = new StudentDist(values.size()-1);
		//double size = sd.inverseF(0.95) * d.getSampleStandardDeviation() / Math.sqrt(values.size()) * 2;
		//System.out.println("IntSize: "+size+" Mean: "+d.getMean() + " S: "+d.getSampleStandardDeviation() +" N: "+d.getN());
		return false; //size < Math.pow(10, -3);
	}

	public boolean check(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Observable o, Object arg) {
		values.add(arg);
	}

}
