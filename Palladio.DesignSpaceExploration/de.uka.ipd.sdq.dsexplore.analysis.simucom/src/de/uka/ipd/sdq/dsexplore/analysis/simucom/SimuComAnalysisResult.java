package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.sensorframework.adapter.StateSensorToPieAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport.TimeseriesData;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;


public class SimuComAnalysisResult implements IAnalysisResult {

	private ExperimentRun run;
	
	private double meanValueCache;

	private Experiment experiment;

	private PCMInstance pcm; 
	
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public SimuComAnalysisResult(ExperimentRun run, Experiment experiment, PCMInstance pcm) {
		this.run = run;
		this.experiment = experiment;
		this.pcm = pcm;
	}

	@Override
	public double getMeanValue() throws AnalysisFailedException {
		if (meanValueCache == 0){
			//Get usage scenario sensor. 
			UsageScenario us = pcm.getUsageModel().getUsageScenario_UsageModel().get(0);
			Sensor respTimeSensor = getSensorForUsageScenario(experiment, us);
			if (respTimeSensor != null){
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(respTimeSensor);
				meanValueCache = calculateMeanValue(sam);
			} else 
				throw new AnalysisFailedException("Could not find sensor for usage scenario "+us.getEntityName());
		}
		return meanValueCache;
	}

	private double calculateMeanValue(SensorAndMeasurements sam) throws AnalysisFailedException {
		AnalysisFailedException error = null;
		try {
		if (RConnection.isEngineAvailable()){

			RConnection rConnection = RConnection.getRConnection();
			String sensorName = storeMeasurementsInRVector(sam, sam.getSensor().getSensorID(), TimeseriesData.TIMESPAN, rConnection);
			Vector<REXP> rResult = rConnection.execute("mean(" + sensorName + ")\n");
			if (rResult.size() > 0) {
				if (rResult.get(0).rtype == REXP.REALSXP){
					return rResult.get(0).asDouble();
				} else {
					error = new AnalysisFailedException("R engine returned a non-double when trying to calculate the mean value: "+rResult.get(0).asString());
					logger.error(error.getMessage());
				}
			} else {
				error = new AnalysisFailedException("Querying R engine returned an empty result."); 
				logger.error(error.getMessage());
			}
		} else {
			error = new AnalysisFailedException("Could not connect to R engine! Check your R configuration.");
			logger.error(error.getMessage());
		}
		} catch (ExceptionInInitializerError e) {
			error = new AnalysisFailedException("Could not connect to R engine!  Check your R configuration.", e);
			logger.error(error.getMessage());
			logger.error(e.getMessage());
		}
		throw error;
	}

	private static Sensor getSensorForUsageScenario(Experiment exp, UsageScenario us) {
		Collection<Sensor> sensors = exp.getSensors();
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();) {
			Sensor sensor = iterator.next();
			//logger.debug("Experiment has a sensor with ID "+sensor.getSensorID()+" and name "+sensor.getSensorName()+".");
			if (sensor.getSensorName().contains(us.getEntityName())){
				logger.debug("Found sensor for usage scenario "+us.getEntityName());
				return sensor;
			}
		}
		logger.error("No sensor found for usage scenario "+us.getEntityName());
		return null;
	}
	
	private static Sensor getSensorForResource(Experiment exp, ResourceContainer rc, ProcessingResourceSpecification res) {
		Collection<Sensor> sensors = exp.getSensors();
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();) {
			Sensor sensor = iterator.next();
			//logger.debug("Experiment has a sensor with ID "+sensor.getSensorID()+" and name "+sensor.getSensorName()+".");
			if (sensor.getSensorName().contains(res.getActiveResourceType_ActiveResourceSpecification().getEntityName())
					&& sensor.getSensorName().contains("Utilisation")
					&& sensor.getSensorName().contains(rc.getEntityName())){
				logger.debug("Found sensor for the resource "+rc.getEntityName()+": "+res.getActiveResourceType_ActiveResourceSpecification().getEntityName());
				return sensor;
			}
		}
		logger.error("No sensor found for resource "+rc.getEntityName()+": "+res.getActiveResourceType_ActiveResourceSpecification().getEntityName());
		return null;
	}

	/**Export the measurements of a sensor to R. 
	 * There are two alternatives. The measurements can be transferred 
	 * via an array, which implies certain size restrictions. An alternative is
	 * to use a temporary file. The behavior can only be switched in source 
	 * code by the constant <code>TRANSFER_TYPE</code>.
	 * Variable names in R are as follows:<br /> 
	 *   For timespan data: "sensor" + #<br />
	 *   For eventtime data: "sensor" + # + "_ET")<br />
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param sensorNumber number of the sensor vector in R.
	 * @param dataSelection the data element to save.
	 * @param rConnection Connection to the R engine.
	 * @return R variable name which contains the data.
	 */
	protected static String storeMeasurementsInRVector(
			final SensorAndMeasurements measurements, final long sensorNumber,
			final TimeseriesData dataSelection, final RConnection rConnection) {
		String sensorName = null;

		if (dataSelection == TimeseriesData.TIMESPAN) {
			sensorName = "sensor" + sensorNumber; 
		} else 
			if (dataSelection == TimeseriesData.EVENTTIME) {
			sensorName = "sensor" + sensorNumber + "_ET";
		} else {
			throw new RuntimeException("Unknown data element of time series.");
		}

		//if (TRANSFER_TYPE == TransferType.MEMORY) {
			// Activate to transfer data via memory
			double[] measurementsArray = 
				prepareExportToRByMemory(measurements, dataSelection);
			rConnection.assign(sensorName, measurementsArray);
		//}
/*		if (TRANSFER_TYPE == TransferType.FILE) {
			// Activate to transfer data via temporary file
			String rCommand = sensorName + " <- "
				+ prepareExportToRByFile(measurements, dataSelection);
			Vector<REXP> result = rConnection.execute(rCommand);
			// Error handling
			if (!rConnection.getLastConsoleMessage().equalsIgnoreCase("Read " 
					+ measurements.getMeasurements().size() + " items\n")) {
				String rResults = "Executing command: '" + rCommand + "' with ";
				for (REXP currentResult : result) {
					rResults += "String: " + currentResult.asString() 
						+ ", SymbolName: " + currentResult.asSymbolName() 
						+ ", Type: " + currentResult.getType() + "\n";
				}
				RVisualisationPlugin.log(IStatus.INFO,
					"Storing Measurements in R via file is most likely wrong. Last message "
					+ "on the console was: " + rConnection.getLastConsoleMessage()
					+ "R returned:\n" + rResults);
			}

		}*/
		return sensorName;
	}
	
	/**Prepares the export the measurements of a sensor to R. Therefore an 
	 * array is filled with the measurements. 
	 * 
	 * Copied from 
	 * de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport. 
	 * TODO: Possibly make this public in RReport and use it properly or refactor it 
	 * to a helper class.
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param dataSelection the data element to save.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 * @author Henning
	 */
	private static double[] prepareExportToRByMemory(
			final SensorAndMeasurements measurements,
			final TimeseriesData dataSelection) {
		double[] measurementsArray = 
			new double[measurements.getMeasurements().size()];
		if (measurements.getMeasurements().size() == Integer.MAX_VALUE) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Too many measurements. Results might be inaccurate.");
		}
		int position = 0;
		for (Measurement time : measurements.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
			measurementsArray[position++] = 
				(dataSelection == TimeseriesData.EVENTTIME) 
					? tsm.getEventTime() 
					: tsm.getTimeSpan(); 
		}
		return measurementsArray;
	}

	@Override
	public PCMInstance getPCMInstance() {
		return pcm;
	}

	@Override
	public int compareTo(IAnalysisResult other) {
		double difference;
		try {
			difference = (this.getMeanValue()-other.getMeanValue());
		if (difference < 0 && difference > -1)
			return -1;
		if (difference > 0 && difference < 1)
			return 1;
		return (int)Math.round(difference);
		
		} catch (AnalysisFailedException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * {@inheritDoc}
	 * @throws AnalysisFailedException 
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult#getUtilisationOfResource(de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification)
	 */
	@Override
	public double getUtilisationOfResource(ResourceContainer container, ProcessingResourceSpecification resource) throws AnalysisFailedException {
		Sensor sensor = getSensorForResource(this.experiment, container, resource);
		
		if (sensor != null){
			SensorAndMeasurements sam = run.getMeasurementsOfSensor(sensor);
			StateSensorToPieAdapter dataAdapter = new StateSensorToPieAdapter(sam);
			Pie pie = (Pie)dataAdapter.getAdaptedObject();
			Collection<PieEntity> pieParts = pie.getEntities(Integer.MAX_VALUE);
			double totalIdleTime = 0;
			//I need to sum up all pie parts to get the 100% comparison
			double totalTime = 0;
			for (Iterator<PieEntity> iterator = pieParts.iterator(); iterator
					.hasNext();) {
				PieEntity pieEntity = iterator.next();
				totalTime += pieEntity.getValue();
				if (pieEntity.getLabel().contains("Idle")){
					//this returns a large number > 399
					totalIdleTime = pieEntity.getValue();
				}
				
			}
			double busyFraction = (1 - (totalIdleTime/totalTime));
			return busyFraction;
		} else 
			throw new AnalysisFailedException("Could not find sensor for resource "+container.getEntityName()+": "+resource.getActiveResourceType_ActiveResourceSpecification().getEntityName());

	}
	
	/**Prepares to export the measurements of a time series sensor to R. 
	 * Therefore a temporary file is created and the R command line to 
	 * import this data is returned. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param dataSelection the data element to save.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 */
/*	private String prepareExportToRByFile(
			final SensorAndMeasurements measurements,
			final TimeseriesData dataSelection) {
		File temporaryFile;
		try {
			temporaryFile = File.createTempFile("data", 
					(dataSelection == TimeseriesData.EVENTTIME) 
						? "_et.txt" 
						: "_ts.txt"
					);
			temporaryFile.deleteOnExit();
			FileWriter temporaryFileWriter = new FileWriter(temporaryFile);
			StringBuffer result = new StringBuffer();
			for (Measurement time : measurements.getMeasurements()) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(
					(dataSelection == TimeseriesData.EVENTTIME) 
						? tsm.getEventTime() 
						: tsm.getTimeSpan() 
					);
				result.append(" ");
			}
			temporaryFileWriter.write(result.toString());
			temporaryFileWriter.close();
			return "scan(file=\"" 
				+ temporaryFile.getAbsolutePath().replace(File.separator, 
						"\\\\")
				+ "\")";
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
				"Error accessing temporary file to transfer sensordata "
				+ "to R. \n\n Details: "	+ e.getMessage());
		}
		return "";
	}*/

}
