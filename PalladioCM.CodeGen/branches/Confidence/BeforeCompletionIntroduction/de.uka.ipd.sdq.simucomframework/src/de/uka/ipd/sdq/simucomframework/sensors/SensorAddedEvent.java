package de.uka.ipd.sdq.simucomframework.sensors;

import desmoj.core.statistic.ValueSupplier;

public class SensorAddedEvent {

	private String id = null;
	private ValueSupplier supplier = null;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public SensorAddedEvent(String id, ValueSupplier supplier) {
		this.id = id;
		this.supplier = supplier;
	}

	/**
	 * @return the supplier
	 */
	public ValueSupplier getSupplier() {
		return supplier;
	}

}
