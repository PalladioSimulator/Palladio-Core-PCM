import java.util.Date;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class TestHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IDAOFactory f = SensorFrameworkDataset.singleton().getMemoryDataset();
		Experiment e = f.createExperimentDAO().addExperiment("Test");
		ExperimentRun er =e.addExperimentRun("TestRun "+new Date().toString());
		TimeSpanSensor s = e.addTimeSpanSensor("ATimeSpanSensor");
		State busyState = f.createStateDAO().addState("Busy");
		State idleState = f.createStateDAO().addState("Idle");
		StateSensor stateSen = e.addStateSensor(idleState,"AStateSensor");
		boolean flag = false; double valueSum = 0;
		for (int i=0; i<100000; i++) {
			double value = Math.random() * 5000;
			er.addTimeSpanMeasurement(s, value, value);
			er.addStateMeasurement(stateSen, flag ? busyState : idleState, valueSum);
			flag = !flag;
			valueSum += value;
		}
		long start = System.nanoTime();
		// TODO: SensorFrameworkDataset.singleton().getDataset(1).storeExperiment(e);
		System.out.println((System.nanoTime()-start)/Math.pow(10, 9));
		SensorAndMeasurements r = er.getMeasurementsOfSensor(s);
	}

}
