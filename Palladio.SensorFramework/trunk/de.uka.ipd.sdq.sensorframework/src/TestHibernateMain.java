import java.util.Date;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * TODO It is not clear what is being tested, and what the expected results ought to be.
 * TODO Not part of a JUnit test suite. 
 * @author Steffen Becker
 */
public class TestHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IDAOFactory f = SensorFrameworkDataset.singleton().getDataSourceByID(1);
		Experiment e = f.createExperimentDAO().addExperiment("Test");
		ExperimentRun er =e.addExperimentRun("TestRun "+new Date().toString());
		TimeSpanSensor s = e.addTimeSpanSensor("ATimeSpanSensor");
		State busyState = f.createStateDAO().addState("Busy");
		State idleState = f.createStateDAO().addState("Idle");
		StateSensor stateSen = e.addStateSensor(idleState,"AStateSensor");
		stateSen.addSensorState(busyState);
		stateSen.addSensorState(idleState);
		boolean flag = false; 
		double valueSum = 0;
		long start = System.nanoTime();
		for (int i=0; i<200000; i++) {
			if (i % 1000 == 0) System.out.print(".");
			if (i % 100000 == 0) System.out.print("\n");
			double value = Math.random() * 5000;
			er.addTimeSpanMeasurement(s, value, value);
			er.addStateMeasurement(stateSen, flag ? busyState : idleState, valueSum);
			flag = !flag;
			valueSum += value;
		}
		System.out.println("\nDone creating measurements: "+(System.nanoTime()-start)/Math.pow(10, 9));
		f.finalizeAndClose();
		System.out.println("Done storing: "+(System.nanoTime()-start)/Math.pow(10, 9));
		System.out.println(er.getMeasurementsOfSensor(s).getMeasurements().size());
		System.out.println("Done "+(System.nanoTime()-start)/Math.pow(10, 9));
	}

}
