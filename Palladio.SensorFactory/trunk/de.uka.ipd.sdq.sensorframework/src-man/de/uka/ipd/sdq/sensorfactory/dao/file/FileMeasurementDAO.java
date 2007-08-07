/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorfactory.dao.file.entities.TimeSpanMeasurementImpl;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IMeasurementDAO;

/**
 * @author ihssane
 * 
 */
public class FileMeasurementDAO implements IMeasurementDAO {

	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileMeasurementDAO(FileDAOFactory factory, IDGenerator idGen) {
		this.factory = (FileDAOFactory) factory;
		this.idGen = idGen;
	}

	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		TimeSpanMeasurement tsm = new TimeSpanMeasurementImpl(idGen
				.getNextMeasurementID(), p_eventtime, p_timespan);
		tsm.setSensor(p_sensor);
		return tsm;
	}

	public Measurement get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Measurement> getMeasurements() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeMeasurement(Measurement measurement, boolean doCascade) {
		// TODO Auto-generated method stub

	}

}
