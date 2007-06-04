package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class ExperimentRunImpl extends de.uka.ipd.sdq.sensorfactory.entities.base.AbstractExperimentRun {

	public ExperimentRunImpl(IDAOFactory myFactory) {
		super(myFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		// TODO: Fix this conceptually!!!
//		EntityManager em = ExperimentDAO.singleton().getEntityManagerFactory().createEntityManager();
//		Query q = em.createQuery("SELECT m FROM Measurement m WHERE FK_SENSOR = "+sensor.getSensorID());
//		Collection <Measurement> result = q.getResultList();
//		em.close();
		ArrayList<Measurement> result = new ArrayList<Measurement>();
		for (Measurement m: this.getMeasurements()) {
			if (m instanceof TimeSpanMeasurement) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
				if (tsm.getSensor() == sensor)
					result.add(m);
			}
			if (m instanceof StateMeasurement) {
				StateMeasurement tsm = (StateMeasurement) m;
				if (tsm.getSensor() == sensor)
					result.add(m);
			}
		}
		return new SensorAndMeasurements(sensor,result);
	}
}
