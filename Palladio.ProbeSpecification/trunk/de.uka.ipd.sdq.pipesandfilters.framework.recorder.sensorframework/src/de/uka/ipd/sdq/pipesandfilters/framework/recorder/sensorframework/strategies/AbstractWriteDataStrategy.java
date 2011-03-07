package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.SensorHelper;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public abstract class AbstractWriteDataStrategy implements IWriteDataStrategy {

	protected IDAOFactory daoFactory;

	protected Experiment experiment;

	protected ExperimentRun run;

	protected Sensor sensor;

	public AbstractWriteDataStrategy(IDAOFactory daoFactory,
			Experiment experiment, ExperimentRun run) {
		this.daoFactory = daoFactory;
		this.experiment = experiment;
		this.run = run;
	}

	@Override
	public void initialise(MetaDataInit metaData) {
		String sensorId = metaData.getMeasurementName();
		sensor = SensorHelper.createOrReuseTimeSensor(daoFactory, experiment,
				sensorId);
	}

}
