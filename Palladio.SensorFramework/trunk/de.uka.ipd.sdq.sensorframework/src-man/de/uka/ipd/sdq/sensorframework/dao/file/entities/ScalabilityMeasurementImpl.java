/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;

/**
 * @author ihssane
 * 
 * TODO Kommentare TODO Warum wird hier nicht TimeSpanSensorAndMeasurement
 * referenziert??
 * 
 */
public class ScalabilityMeasurementImpl 
extends MeasurementImpl 
implements ScalabilityMeasurement {

	private Double[] params;

	public ScalabilityMeasurementImpl(long id, double eventTime, Double[] params) {
		super(id, eventTime);
		this.params = params;
	}

	public Double[] getParameters() {
		return params;
	}

	public void setParameters(Double[] value) {
		this.params = value;
	}

	public ScalabilitySensor getSensor() {
		throw new UnsupportedOperationException();
	}

	public void setSensor(ScalabilitySensor value) {
		throw new UnsupportedOperationException();
	}

}
