package de.uka.ipd.sdq.simucomframework.sensors;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.statistic.Histogram;

public class SensorFactory {

	private static SensorFactory sensorFactory;

	private HashMap<String, Histogram> histogramSensors = new HashMap<String, Histogram>();

	private HashMap<String, ResponseTimeValueSupplier> histogramValueSupplier = new HashMap<String, ResponseTimeValueSupplier>();

	private ArrayList<ISensorObserver> sensorObservers = new ArrayList<ISensorObserver>();

	private SimuComModel model;

	static {
		sensorFactory = new SensorFactory();
	}

	/**
	 * Make this class static-only (Singleton-Pattern)
	 */
	private SensorFactory() {
	}

	public void setModel(SimuComModel model) {
		this.model = model;
	}

	public void createHistogramSensor(String id,
			ResponseTimeValueSupplier supplier) {
		Histogram h = new Histogram(model, id, supplier, 0, 1500, 1500, true,
				false);
		h.reset();
		histogramSensors.put(id, h);
		histogramValueSupplier.put(id, supplier);
		fireSensorAddedEvent(new SensorAddedEvent(id, supplier));
	}

	public void createHistogramSensor(String id) {
		ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier(id);
		this.createHistogramSensor(id, supplier);
	}

	public Histogram getHistogram(String id) {
		return histogramSensors.get(id);
	}

	public Histogram safeGetHistogram(String id) {
		if (!histogramSensors.containsKey(id))
			this.createHistogramSensor(id);
		return histogramSensors.get(id);
	}

	public ResponseTimeValueSupplier getValueSupplierForSensor(String id) {
		return this.histogramValueSupplier.get(id);
	}

	public ResponseTimeValueSupplier safeGetValueSupplierForSensor(String id) {
		safeGetHistogram(id);
		return this.histogramValueSupplier.get(id);
	}

	public boolean hasHistogram(String id) {
		return histogramSensors.containsKey(id);
	}

	public void addSensorObserver(ISensorObserver observer) {
		sensorObservers.add(observer);
	}

	public void removeSensorObserver(ISensorObserver observer) {
		sensorObservers.remove(observer);
	}

	private void fireSensorAddedEvent(SensorAddedEvent e) {
		for (ISensorObserver o : sensorObservers)
			o.sensorAddedEvent(e);
	}

	public static SensorFactory singleton() {
		return sensorFactory;
	}

	public void addMeasurement(String id, double d) {
        this.safeGetValueSupplierForSensor(id)
        .newMeasurement(d);	
    }
}
