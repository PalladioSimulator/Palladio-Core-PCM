import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

public class TestHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Experiment e = ExperimentDAO.singleton().createExperiment("New Experiment");
		TimeSpanSensor s = e.addTimeSpanSensor("Sensor");
		for (int i=0; i<1000; i++) {
			double value = Math.random() * 5000;
			s.addTimeSpan(value, value);
		}
		ExperimentDAO.singleton().storeExperiment(e);
	}

}
