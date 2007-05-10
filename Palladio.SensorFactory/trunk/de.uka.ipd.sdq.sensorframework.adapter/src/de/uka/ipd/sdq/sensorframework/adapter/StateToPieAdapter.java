package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import sun.nio.cs.HistoricallyNamedCharset;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.sensorfactory.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;

public class StateToPieAdapter implements IAdapter {

	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public StateToPieAdapter(SensorAndMeasurements sensorAndMeasurements) {
		this.myValues = sensorAndMeasurements;
	}

	public Object getAdaptedObject() {
		Pie p = new Pie();
		HashMap<String, Double> newPie = new HashMap<String, Double>(); 
		for(State state : ((StateSensor)myValues.getSensor()).getSensorStates())
			newPie.put(state.getStateLiteral(), 0.0);
		double lastChangeTime = 0.0;
		for(Measurement m : myValues.getMeasurements()){
			StateMeasurement sm = (StateMeasurement) m;
			Double oldValue = newPie.get(sm.getSensorState().getStateLiteral());
			double newValue = oldValue + (sm.getEventTime() - lastChangeTime);
			lastChangeTime = sm.getEventTime();
			newPie.put(sm.getSensorState().getStateLiteral(), newValue);
		}
		for(Entry<String,Double>e:newPie.entrySet()){
			p.addEntity(new PieEntity(e.getValue(),e.getKey()));
		}
		return p;
	}

	public Properties getProperties() {
		return myProperties;
	}

	public void setProperties(Properties newProperties) {
		this.myProperties = newProperties;
	}

}
