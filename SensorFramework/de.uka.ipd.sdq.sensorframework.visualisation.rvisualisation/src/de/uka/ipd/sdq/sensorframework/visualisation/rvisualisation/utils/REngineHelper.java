package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport.TimeseriesData;

/**
 * Provides helper method for working with the R engine and the SensorFramework.
 * The class offers methods for feeding sensor data into R and may later also
 * provide methods for more complex commands and calculation.
 * 
 * @author Anne
 * 
 */
public class REngineHelper {
	
	/**Transfer data to R by the specified type.
	 * @author groenda
	 */
	public enum TransferType {
		/** Transfer by temporary files. */
		FILE,
		/** Transfer by memory. */
		MEMORY
	}
	
	/** The default setting for data transfer to R. */
	public static final TransferType TRANSFER_TYPE = TransferType.FILE;
	
	/**
	 * Convenience method, calls
	 * {@link #storeMeasurementsInRVector(SensorAndMeasurements, int, TimeseriesData, TransferType, RConnection)}
	 * with the standard {@link TransferType} which is
	 * <code>TransferType.MEMORY</code>.
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param sensorNumber number of the sensor vector in R.
	 * @param dataSelection the data element to save.
	 * @param rConnection Connection to the R engine.
	 * @return R variable name which contains the data.
	 */
	public static String storeMeasurementsInRVector(
			final SensorAndMeasurements measurements, final int sensorNumber,
			final TimeseriesData dataSelection, 
			final RConnection rConnection) {
		return storeMeasurementsInRVector(measurements, sensorNumber, dataSelection, TRANSFER_TYPE, rConnection);
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
	public static String storeMeasurementsInRVector(
			final SensorAndMeasurements measurements, final int sensorNumber,
			final TimeseriesData dataSelection, final TransferType transferType, 
			final RConnection rConnection) {
		String sensorName = null;

		if (dataSelection == TimeseriesData.TIMESPAN) {
			sensorName = "sensor" + sensorNumber; 
		} else 
			if (dataSelection == TimeseriesData.EVENTTIME) {
			sensorName = "sensor" + sensorNumber + "_ET";
		} else {
			throw new RuntimeException("Unknown data element of time series.");
		}

		if (transferType == TransferType.MEMORY) {
			// Activate to transfer data via memory
			double[] measurementsArray = 
				prepareExportToRByMemory(measurements, dataSelection);
			rConnection.assign(sensorName, measurementsArray);
		}
		if (transferType == TransferType.FILE) {
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

		}
		return sensorName;
	}
	
	/**Prepares the export the measurements of a sensor to R. Therefore an 
	 * array is filled with the measurements. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param dataSelection the data element to save.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
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

	/**Prepares to export the measurements of a time series sensor to R. 
	 * Therefore a temporary file is created and the R command line to 
	 * import this data is returned. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param dataSelection the data element to save.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 */
	private static String prepareExportToRByFile(
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
				+ temporaryFile.getAbsolutePath().replace("\\", 
						"\\\\")
				+ "\")";
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
				"Error accessing temporary file to transfer sensordata "
				+ "to R. \n\n Details: "	+ e.getMessage());
		}
		return "";
	}

}
