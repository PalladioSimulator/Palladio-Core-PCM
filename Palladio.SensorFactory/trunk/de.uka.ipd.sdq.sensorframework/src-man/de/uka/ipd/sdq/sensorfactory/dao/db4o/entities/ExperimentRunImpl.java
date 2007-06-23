package de.uka.ipd.sdq.sensorfactory.dao.db4o.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.db4o.ObjectContainer;
import com.db4o.config.QueryEvaluationMode;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;
import com.db4o.types.Db4oList;
import com.db4o.types.Db4oMap;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.PersistedLinkedList;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.PersistedLinkedListAdapter;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.base.AbstractExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentImpl;
import de.uka.ipd.sdq.sensorfactory.entities.impl.StateMeasurementImpl;
import de.uka.ipd.sdq.sensorfactory.entities.impl.TimeSpanMeasurementImpl;

public class ExperimentRunImpl extends AbstractExperimentRun {

	private transient ObjectContainer db;
	private transient Map<Long, PersistedLinkedListAdapter> index;
	private Map<Long, PersistedLinkedList> backgroundIndex;

	@SuppressWarnings("unchecked")
	public ExperimentRunImpl(IDAOFactory myFactory, ObjectContainer db) {
		super(myFactory);
		this.db = db;
		index = new HashMap<Long,PersistedLinkedListAdapter>();
		backgroundIndex = new HashMap<Long,PersistedLinkedList>();
	}

	@Override
	public void addMeasurement(Measurement value) {
		//TODO GetSensor to update index
	}

	@Override
	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement result = myDAOFactory
				.createMeasurementDAO().addStateMeasurement(p_sensor,
						p_sensorstate, p_eventtime);

		addMeasurementToIndex(p_sensor,result);
		((ExtObjectContainer)db).purge(result);
		return result;
	}

	private void addMeasurementToIndex(Sensor p_sensor,
			Measurement result) {
		List<Measurement> list = index.get(p_sensor.getSensorID());
		if (list == null) {
			backgroundIndex.put(p_sensor.getSensorID(), 
					new PersistedLinkedList(myDAOFactory,db));
					//db.ext().collections().newLinkedList());
			index.put(p_sensor.getSensorID(), 
					new PersistedLinkedListAdapter(backgroundIndex.get(p_sensor.getSensorID())));
					//db.ext().collections().newLinkedList());
			list = index.get(p_sensor.getSensorID());
		}
		list.add(result);
	}

	@Override
	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement result = myDAOFactory
				.createMeasurementDAO().addTimeSpanMeasurement(p_sensor,
						p_eventtime, p_timespan);

		addMeasurementToIndex(p_sensor,result);
		((ExtObjectContainer)db).purge(result);
		return result;
	}

	@Override
	public Collection<Measurement> getMeasurements() {
		List<Measurement> measurements = new LinkedList<Measurement>();
		for(PersistedLinkedListAdapter adapter:index.values()) {
			measurements.addAll(adapter);
		}
		return measurements;		
	}

	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.db = arg0;
		this.myDAOFactory = DB4ODAOFactory.factoryRegistry.get(arg0);
		db.activate(backgroundIndex, 2);
		index = new HashMap<Long,PersistedLinkedListAdapter>();
		for (Long id : backgroundIndex.keySet()) {
			index.put(id, new PersistedLinkedListAdapter(backgroundIndex.get(id)));
			backgroundIndex.get(id).setDAOFactory(myDAOFactory);
		}
	}

	@Override
	public SensorAndMeasurements getMeasurementsOfSensor(final Sensor sensor) {
		Collection<Measurement> measurementsResult = index.get(sensor.getSensorID());
		if (measurementsResult == null) measurementsResult = Collections.EMPTY_LIST;
		return new SensorAndMeasurements(sensor, measurementsResult);
	}

	public void flushBuffers() {
		for(PersistedLinkedList l : backgroundIndex.values()){
			l.flushList();
		}
	}
}
