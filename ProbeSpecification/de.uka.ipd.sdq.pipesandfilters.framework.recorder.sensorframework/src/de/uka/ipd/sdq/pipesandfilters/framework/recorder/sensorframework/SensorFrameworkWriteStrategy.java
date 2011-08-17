package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IRawWriteStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.DemandedTimeWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.ExecutionResultWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.IWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.OverallUtilisationWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.ResponseTimeWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.UtilisationWriteDataStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies.WaitingTimeWriteDataStrategy;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * Write Strategy for the SensorFramework.
 *
 * @author pmerkle
 *
 */
public class SensorFrameworkWriteStrategy implements IRawWriteStrategy {

    private static Logger logger = Logger.getLogger(SensorFrameworkWriteStrategy.class.getName());

	private SensorFrameworkMetaDataInit metaData;

	private SensorFrameworkConfig sensorFrameworkConfig;

	private IDAOFactory daoFactory;

	/**
	 * All instances of this class uses the same IDAOFactory. Hence it is
	 * sufficient when a single writer flushes the data. Several subsequent
	 * flushes would be redundant. This variable is used to coordinate the flush
	 * between several instances of this writer. It is false when one instance
	 * has written data that has not yet been flushed; true else.
	 */
	private static boolean flushed;

	private Experiment experiment;

	private ExperimentRun run;

	private IWriteDataStrategy writeDataStrategy;

	@Override
	public void initialize(MetaDataInit metaData) {
		if (metaData instanceof SensorFrameworkMetaDataInit) {
			this.metaData = (SensorFrameworkMetaDataInit) metaData;
		} else {
			throw new IllegalArgumentException("Expected meta data of type "
					+ SensorFrameworkMetaDataInit.class.getSimpleName()
					+ " but was " + metaData.getClass().getSimpleName());
		}

		if (this.metaData.getRecorderConfiguration() instanceof SensorFrameworkConfig) {
			sensorFrameworkConfig = (SensorFrameworkConfig) this.metaData
					.getRecorderConfiguration();
		} else {
			throw new IllegalArgumentException("Expected meta data containing "
					+ SensorFrameworkConfig.class.getSimpleName()
					+ " but was "
					+ this.metaData.getRecorderConfiguration().getClass()
							.getSimpleName() + ".");
		}

		if (!this.metaData.isRemoteRun()) {
			initialiseNewSensorframework();
		} else {
			initialiseTempSensorframework();
		}

		// Create sensor
		// TODO Remove hard coded metric names "Response Time", ... Use Enum
		// instead!?
		if (metaData.getMetricName().equals("Response Time")) {
			writeDataStrategy = new ResponseTimeWriteDataStrategy(daoFactory,
					experiment, run);
		} else if (metaData.getMetricName().equals("Waiting Time")) {
			writeDataStrategy = new WaitingTimeWriteDataStrategy(daoFactory,
					experiment, run);
		} else if (metaData.getMetricName().equals("Hold Time")) {
			writeDataStrategy = new WaitingTimeWriteDataStrategy(daoFactory,
					experiment, run);
		} else if (metaData.getMetricName().equals("Demanded Time")) {
			writeDataStrategy = new DemandedTimeWriteDataStrategy(daoFactory,
					experiment, run);
		} else if (metaData.getMetricName().equals("Utilisation")) {
			writeDataStrategy = new UtilisationWriteDataStrategy(daoFactory,
					experiment, run);
		} else if (metaData.getMetricName().equals("Overall Utilisation")) {
			writeDataStrategy = new OverallUtilisationWriteDataStrategy(
					daoFactory, experiment, run);
		} else if (metaData.getMetricName().equals("Execution Time")) {
			writeDataStrategy = new ExecutionResultWriteDataStrategy(
					daoFactory, experiment, run);
		}
		writeDataStrategy.initialise(metaData);

		flushed = false;
	}

	@Override
	public void writeData(PipeData data) {
		if (!flushed) {
			writeDataStrategy.writeData(data);
        } else {
            logger.warn("Tried to write data, but the pipe has been flushed already");
        }
	}

	@Override
    public synchronized void flush() {
		if (!flushed) {
			flushed = true;
			logger.debug("Flushing SensorFramework data store");
			daoFactory.store();
			//do not execute daoFactory.finalizeAndClose() ! This will flush all lists for file-based lists, e.g. experiments, from memory. This should not be done on any DAO requested via the singleton as the lists are not reloaded on next access.
		}
		run = null;
		experiment = null;
	}

	private void initialiseNewSensorframework() {
		// Obtain DAOFactory
		daoFactory = SensorFrameworkDataset.singleton().getDataSourceByID(
				sensorFrameworkConfig.getDatasourceID());
		if (daoFactory == null)
			throw new DatasourceConfigurationInvalidException();

		// Find an existing or create a new Experiment
		if (daoFactory.createExperimentDAO().findByExperimentName(
				metaData.getExperimentName()).size() == 1) {
			experiment = daoFactory.createExperimentDAO().findByExperimentName(
					metaData.getExperimentName()).iterator().next();
		} else {
			experiment = daoFactory.createExperimentDAO().addExperiment(
					metaData.getExperimentName());
		}

		// Find an existing or create a new ExperimentRun
		for (ExperimentRun r : experiment.getExperimentRuns()) {
			if (r.getExperimentDateTime().equals(
					metaData.getExperimentRunName())) {
				run = r;
			}
		}
		if (run == null)
			run = experiment.addExperimentRun(metaData.getExperimentRunName());

		// run = new SimuComExperimentRunDecorator(this, experiment
		// .addExperimentRun("Run " + new Date()));
	}

	// TODO Initialization for R-OSGI
	private void initialiseTempSensorframework() {
		// // TODO!!!!
		// this.daoFactory = new FileDAOFactory("C:/temp/test");
		// experiment = daoFactory.createExperimentDAO().addExperiment(
		// this.getConfig().getNameExperimentRun());
		// run = new SimuComExperimentRunDecorator(this, experiment
		// .addExperimentRun("Run " + new Date()));
	}

}
