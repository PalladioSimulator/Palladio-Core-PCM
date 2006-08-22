package de.uka.ipd.sdq.simucom.sensors;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.simucom.ResponseTimeValueSupplier;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.statistic.Histogram;

public class SensorFactory  {
	
	private HashMap<String,Histogram> histogramSensors = new HashMap<String,Histogram>();
	private HashMap<String,ResponseTimeValueSupplier> histogramValueSupplier = new HashMap<String,ResponseTimeValueSupplier>();
	private ArrayList<ISensorObserver> sensorObservers = new ArrayList<ISensorObserver>();
	private SimuComModel model;
	
	/** Make this class static-only
	 * (Singleton-Pattern)
	 */
	public SensorFactory(SimuComModel model)
	{
		this.model = model;
	}
	
	public void createHistogramSensor(String id, ResponseTimeValueSupplier supplier) {
		Histogram h = new Histogram(model, id, supplier, 0, 1500, 1500, true, false);
		h.reset();
		histogramSensors.put(id, h);
		histogramValueSupplier.put(id, supplier);
		fireSensorAddedEvent(new SensorAddedEvent(id,supplier));
	}
	
	public void createHistogramSensor(String id)
	{
		ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier(id);
		this.createHistogramSensor(id, supplier);
	}

	public Histogram getHistogram(String id)
	{
		return histogramSensors.get(id);
	}

	public ResponseTimeValueSupplier getValueSupplierForSensor(String id)
	{
		return this.histogramValueSupplier.get(id);
	}
	
	
	public boolean hasHistogram(String id)
	{
		return histogramSensors.containsKey(id);
	}
	
	public void addSensorObserver(ISensorObserver observer)
	{
		sensorObservers.add(observer);
	}
	
	public void removeSensorObserver(ISensorObserver observer)
	{
		sensorObservers.remove(observer);
	}
	
	private void fireSensorAddedEvent(SensorAddedEvent e)
	{
		for (ISensorObserver o : sensorObservers)
			o.sensorAddedEvent(e);
	}
}
