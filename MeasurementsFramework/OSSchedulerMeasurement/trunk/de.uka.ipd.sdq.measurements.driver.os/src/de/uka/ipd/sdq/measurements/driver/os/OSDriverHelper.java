package de.uka.ipd.sdq.measurements.driver.os;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;

public class OSDriverHelper {

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
		DriverLogger.log("Receiving updated jar file...");
		String fileName = "osdriver_new";
		String fileNameWithNumber = "osdriver_new.jar";
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

		} catch (IOException e) {
			DriverLogger.logError("File update failed!");
			return false;
		}
		DriverLogger.log("File updated successfully.");
		return true;
	}

	
}
