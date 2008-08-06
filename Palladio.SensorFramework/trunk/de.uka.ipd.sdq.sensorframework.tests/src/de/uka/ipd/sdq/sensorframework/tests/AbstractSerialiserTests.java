package de.uka.ipd.sdq.sensorframework.tests;

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

public abstract class AbstractSerialiserTests extends TestCase {

	private static final int CREATE_COUNT = 10;

	public void testExperimentStore() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		for (int i=0; i < CREATE_COUNT; i++) {
			@SuppressWarnings("unused")
			Experiment e = experimentDAO.addExperiment("Test"+i);
		}
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		int count = 0;
		for (Experiment e : experimentDAO.getExperiments()) {
			count++;
			Assert.assertEquals(0,e.getSensors().size());
			Assert.assertEquals(0,e.getExperimentRuns().size());
		}
		Assert.assertEquals(10, experimentDAO.getExperiments().size());
		Assert.assertEquals(10, count);
		factory.finalizeAndClose();
	}

	public void testExperimentStoreAfterReload() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		factory.finalizeAndClose();

		for (int i=0; i < CREATE_COUNT; i++) {
			factory = createDAOFactory();
			IExperimentDAO experimentDAO = factory.createExperimentDAO();
			@SuppressWarnings("unused")
			Experiment e = experimentDAO.addExperiment("Test"+i);
			factory.finalizeAndClose();
		}
		
		// load it again
		factory = createDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		int count = 0;
		for (Experiment e : experimentDAO.getExperiments()) {
			count++;
			Assert.assertEquals(0,e.getSensors().size());
			Assert.assertEquals(0,e.getExperimentRuns().size());
		}
		factory.finalizeAndClose();
		Assert.assertEquals(CREATE_COUNT, count);
	}

	public void testSensorStore() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test");
		addTimeSpanSensors(factory, e);
		addStateSensors(factory, e);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		for (Experiment ex : experimentDAO.getExperiments()) {
			int count = 0; int tssCount = 0; int stateCount = 0;
			for (Sensor s : ex.getSensors()) {
				count++;
				if (s instanceof TimeSpanSensor) {
					tssCount++; 
				} else { 
					stateCount++;
					Assert.assertEquals(1,((StateSensor)s).getSensorStates().size()); 
				}
				Assert.assertTrue(s instanceof TimeSpanSensor ? s.getSensorName().startsWith("TSS") : s.getSensorName().startsWith("StateSensor"));
			}
			Assert.assertEquals(2*CREATE_COUNT, count);
			Assert.assertEquals(CREATE_COUNT, tssCount);
			Assert.assertEquals(CREATE_COUNT, stateCount);
		}
		factory.finalizeAndClose();
	}

	public void testSensorStore2() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test");
		addStateSensors(factory, e);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		int statesCount = factory.createStateDAO().getStates().size();
		factory.finalizeAndClose();
		Assert.assertEquals(1, statesCount);
	}

	public void testExperimentRunStore() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test");
		addTimeSpanSensors(factory, e);
		addStateSensors(factory, e);
		addExperimentRuns(factory, e);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		for (Experiment ex : experimentDAO.getExperiments()) {
			int count = 0;
			for (ExperimentRun er : ex.getExperimentRuns()) {
				count++;
				Assert.assertTrue(er.getExperimentDateTime().startsWith("Date"));
			}
			Assert.assertEquals(CREATE_COUNT, count);
		}
		factory.finalizeAndClose();
	}
	
	public void testExperimentRunStore2() throws IOException {
		// store some data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test");
		addExperimentRuns(factory, e);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		int count = factory.createExperimentRunDAO().getExperimentRuns().size();
		Assert.assertEquals(CREATE_COUNT, count);
		factory.finalizeAndClose();
	}
	
	public void testExperimentRunStoreAfterReload() throws IOException {
		testExperimentRunStore();
		
		// store some additional data
		IDAOFactory factory = createDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test2");
		addTimeSpanSensors(factory, e);
		addStateSensors(factory, e);
		addExperimentRuns(factory, e);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		int count = 0;
		for (@SuppressWarnings("unused")
		Experiment ex : experimentDAO.getExperiments()) {
			count++;
		}
		Assert.assertEquals(2, count);
		factory.finalizeAndClose();
	}

	public void testTimeSpanMeasurements() throws IOException {
		testTimeSpanMeasurementsInternal(CREATE_COUNT);
	}

	public void testTimeSpanMeasurementsLarge() throws IOException {
		testTimeSpanMeasurementsInternal(CREATE_COUNT*12345 + 123);
	}
	
	
	private void testTimeSpanMeasurementsInternal(final int createCount) throws IOException {
		// store some additional data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test2");
		addTimeSpanSensors(factory, e);
		addExperimentRuns(factory, e);
		addTimeSpanMeasurements(factory,e,createCount);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		e = experimentDAO.getExperiments().iterator().next();
		TimeSpanSensor tss = (TimeSpanSensor) e.getSensors().iterator().next();
		ExperimentRun er = e.getExperimentRuns().iterator().next();
		SensorAndMeasurements sam = er.getMeasurementsOfSensor(tss);
		Assert.assertEquals(tss, sam.getSensor());
		int count = 0;
		for (Measurement m : sam.getMeasurements()) {
			Assert.assertTrue(m instanceof TimeSpanMeasurement);
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
			Assert.assertTrue(tsm.getTimeSpan() > 0);
			Assert.assertTrue(tsm.getEventTime() > 0);
			count++;
		}
		Assert.assertEquals(createCount, count);
		Assert.assertEquals(createCount, sam.getMeasurements().size());
		factory.finalizeAndClose();
	}
	
	public void testStateMeasurements() throws IOException {
		testStateMeasurementsInternal(CREATE_COUNT);
	}

	public void testStateMeasurementsLarge() throws IOException {
		testStateMeasurementsInternal(CREATE_COUNT*12345 + 123);
	}
	
	private void testStateMeasurementsInternal(int createCount) throws IOException {
		// store some additional data
		IDAOFactory factory = createCleanDAOFactory();
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		Experiment e = experimentDAO.addExperiment("Test2");
		addStateSensors(factory, e);
		addExperimentRuns(factory, e);
		addStateMeasurements(factory,e,createCount);
		factory.finalizeAndClose();
		
		// load it again
		factory = createDAOFactory();
		experimentDAO = factory.createExperimentDAO();
		e = experimentDAO.getExperiments().iterator().next();
		StateSensor ssensor = (StateSensor) e.getSensors().iterator().next();
		ExperimentRun er = e.getExperimentRuns().iterator().next();
		SensorAndMeasurements sam = er.getMeasurementsOfSensor(ssensor);
		Assert.assertEquals(ssensor, sam.getSensor());
		int count = 0;
		for (Measurement m : sam.getMeasurements()) {
			Assert.assertTrue(m instanceof StateMeasurement);
			StateMeasurement sm = (StateMeasurement) m;
			Assert.assertNotNull(sm.getSensorState());
			Assert.assertEquals(sm.getSensorState(), ssensor.getInitialState());
			Assert.assertTrue(sm.getEventTime() > 0);
			count++;
		}
		Assert.assertEquals(createCount, count);
		Assert.assertEquals(createCount, sam.getMeasurements().size());
		factory.finalizeAndClose();
	}
	
	
	private void addTimeSpanMeasurements(IDAOFactory factory, Experiment e, int create_count) {
		TimeSpanSensor tss = (TimeSpanSensor) e.getSensors().iterator().next();
		ExperimentRun er = e.getExperimentRuns().iterator().next();
		for (int i = 0; i < create_count; i++) {
			er.addTimeSpanMeasurement(tss, i + 1, i + 1);
		}
	}

	private void addStateMeasurements(IDAOFactory factory, Experiment e, int createCount) {
		StateSensor ssensor = (StateSensor) e.getSensors().iterator().next();
		ExperimentRun er = e.getExperimentRuns().iterator().next();
		for (int i = 0; i < createCount; i++) {
			er.addStateMeasurement(ssensor, ssensor.getInitialState(), i + 1);
		}
	}

	private void addExperimentRuns(IDAOFactory factory, Experiment e) {
		for (int i=0; i < CREATE_COUNT; i++) {
			ExperimentRun run = factory.createExperimentRunDAO().addExperimentRun("Date"+i);
			e.addExperimentRun(run);
		}	
	}

	private void addTimeSpanSensors(IDAOFactory factory, Experiment e) {
		for (int i=0; i < CREATE_COUNT; i++) {
			Sensor s = factory.createSensorDAO().addTimeSpanSensor("TSS"+i);
			e.addSensor(s);
		}
	}
	
	private void addStateSensors(IDAOFactory factory, Experiment e) {
		State state = factory.createStateDAO().addState("AState");
		for (int i=0; i < CREATE_COUNT; i++) {
			StateSensor s = factory.createSensorDAO().addStateSensor(state, "StateSensor"+i);
			s.addSensorState(state);
			e.addSensor(s);
		}
	}
	
	protected abstract IDAOFactory createDAOFactory();
	protected abstract IDAOFactory createCleanDAOFactory() throws IOException;
}
