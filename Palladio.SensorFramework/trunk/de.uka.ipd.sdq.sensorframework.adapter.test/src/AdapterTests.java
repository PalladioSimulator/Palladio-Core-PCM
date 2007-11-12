import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.adapter.internal.OutlierRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.adapter.internal.WarmupRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import junit.framework.Assert;
import junit.framework.TestCase;


public class AdapterTests extends TestCase {

	public void testInternalAdapter(){
		SensorAndMeasurements sam = initialiseSAM(new double[]{1,2,3,4,5,6,7,8,9,1000});
		SensorAndMeasurements outlierSAM = (SensorAndMeasurements) new OutlierRemovingAdapterTimeSpanSensor(sam).getAdaptedObject();
		Assert.assertEquals(9,outlierSAM.getMeasurements().size());
		for (double value : new double[]{1,2,3,4,5,6,7,8,9}) {
			boolean found = false;
			for(Iterator<Measurement> it = outlierSAM.getMeasurements().iterator(); it.hasNext(); ) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) it.next();
				if (tsm.getTimeSpan() == value)
					found  = true;
			}
			Assert.assertTrue(found);
		}
	}

	public void testWarmupAdapter() {
		SensorAndMeasurements sam = initialiseSAM(new double[]{1,2,3,4,5,6,7,8,9,1000});
		WarmupRemovingAdapterTimeSpanSensor adapter = new WarmupRemovingAdapterTimeSpanSensor(sam);
		adapter.getProperties().put(WarmupRemovingAdapterTimeSpanSensor.WARMUP_SIZE, 2L);
		SensorAndMeasurements outlierSAM = (SensorAndMeasurements) adapter.getAdaptedObject();
		Assert.assertEquals(8,outlierSAM.getMeasurements().size());
		for (double value : new double[]{3,4,5,6,7,8,9,1000}) {
			boolean found = false;
			for(Iterator<Measurement> it = outlierSAM.getMeasurements().iterator(); it.hasNext(); ) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) it.next();
				if (tsm.getTimeSpan() == value)
					found  = true;
			}
			Assert.assertTrue(found);
		}
	}

	private SensorAndMeasurements initialiseSAM(double[] values) {
		IDAOFactory daoFactory = new MemoryDAOFactory(1);
		Experiment exp = daoFactory.createExperimentDAO().addExperiment("Server");
		ExperimentRun expRun = daoFactory.createExperimentRunDAO().addExperimentRun(new Date().toString());
		exp.addExperimentRun(expRun);
		TimeSpanSensor tss = exp.addTimeSpanSensor("Overall RT");
		for (double value : values)
			expRun.addTimeSpanMeasurement(tss, 0, value);
		return expRun.getMeasurementsOfSensor(tss);
	}
}
