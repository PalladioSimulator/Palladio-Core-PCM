package de.uka.ipd.sdq.measurements.driver.os;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import de.uka.ipd.sdq.measurements.driver.common.Calibrator;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;

public class MidisHostHelper {

	public static long calibrate(final RmiDemand demand, int degreeOfAccuracy, boolean signalOnFinish,
			String masterURL, int masterPort) {
		long calibrationId = System.currentTimeMillis();
		Properties properties = null;
		String calibrationFilePath = PropertyManager.getInstance().getCalibrationFilePath();
		if ((calibrationFilePath != null) && (!calibrationFilePath.equals(""))) {
			properties = new Properties();
			properties.setProperty("CalibrationPath", calibrationFilePath);
		}
		new Thread(new Calibrator(calibrationId, demand, degreeOfAccuracy, properties, signalOnFinish, masterURL, masterPort)).start();
		return calibrationId;
	}

	public static boolean updateJarFile(byte[] buffer) {
		OSDriver.log("Receiving updated jar file...");
		String fileName = "midishost_new";
		String fileNameWithNumber = "midishost_new.jar";
		int fileNumber = 0;
		try {
			File file = new File(fileNameWithNumber);
			while (file.exists()) {
				fileNumber++;
				fileNameWithNumber = fileName + "_" + fileNumber + ".jar";
				file = new File(fileNameWithNumber);
			}
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileNameWithNumber));
			output.write(buffer, 0, buffer.length);
			output.flush();
			output.close();

		} catch (Exception e) {
			OSDriver.logError("File update failed!");
			return false;
		}
		OSDriver.log("File updated successfully.");
		return true;
	}

	
}
