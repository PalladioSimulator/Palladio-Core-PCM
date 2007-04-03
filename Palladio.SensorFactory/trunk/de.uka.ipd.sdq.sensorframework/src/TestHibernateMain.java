import java.util.Collection;
import java.util.Date;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.impl.SensorAndMeasurements;

public class TestHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Experiment e = ExperimentDAO.singleton().createExperiment("Test");
		ExperimentRun er =e.addExperimentRun("TestRun "+new Date().toString());
		TimeSpanSensor s = e.addTimeSpanSensor("ATimeSpanSensor");
		for (int i=0; i<1000; i++) {
			double value = Math.random() * 5000;
			er.addTimeSpanMeasurement(s, value, value);
		}
		ExperimentDAO.singleton().storeExperiment(e);
		SensorAndMeasurements r = er.getMeasurementsOfSensor(s);
	}

}
