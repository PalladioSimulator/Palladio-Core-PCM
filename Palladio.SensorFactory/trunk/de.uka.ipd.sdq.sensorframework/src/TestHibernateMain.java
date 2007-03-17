import java.util.Collection;
import java.util.Date;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

public class TestHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Experiment e = ExperimentDAO.singleton().createExperiment("SimuConf 03");
		ExperimentRun er =e.addExperimentRun(new Date().toString());
		TimeSpanSensor s = e.addTimeSpanSensor("Sensor 08");
		s = e.addTimeSpanSensor("Sensor01");
		s = e.addTimeSpanSensor("Sensor02");
		for (int i=0; i<1000; i++) {
			double value = Math.random() * 5000;
			er.addTimeSpanMeasurement(s, value, value);
		}
		ExperimentDAO.singleton().storeExperiment(e);
		Collection<Measurement> r = er.getMeasurementsOfSensor(s);
	}

}
