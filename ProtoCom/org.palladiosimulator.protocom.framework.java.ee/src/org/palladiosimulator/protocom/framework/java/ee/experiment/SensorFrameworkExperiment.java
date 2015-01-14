package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.api.sockets.ResultsSocket;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.storage.IStorage;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 *
 * @author Christian Klaussner
 */
@Singleton
public final class SensorFrameworkExperiment implements IExperiment {
	private static final double ONE_SECOND_IN_NANO_SECONDS = Math.pow(10, 9);

	private static final String[] stateFiles = new String[] {
		"experiment.ser",
		"exprun.ser",
		"id_generator.ser",
		"sensor.ser"
	};

	@Inject
	private IStorage storage;

	private IDAOFactory dataSource;
	private de.uka.ipd.sdq.sensorframework.entities.Experiment experiment;
	private String experimentId;
	private String experimentName;
	private String tempFolder;

	private ExperimentRun run;

	private HashMap<String, TimeSpanSensor> sensors;

	public SensorFrameworkExperiment() {
		sensors = new HashMap<String, TimeSpanSensor>();
	}

	/**
	 *
	 * @param experimentName
	 */
	public void init(String experimentName) {
		this.experimentId = getExperimentId(experimentName);
		this.experimentName = experimentName;

		reset();
	}

	/**
	 *
	 */
	public void reset() {

		// Remove previous sensors and the data source.
		sensors.clear();

		if (dataSource != null) {
			try {
				dataSource.finalizeAndClose();
			} catch (Exception e) {
				// Ignore Sensor Framework exceptions.
			}
		}

		// Create a new temporary folder and data source.
		tempFolder = getTempFolder();
		fetchExperiment(experimentId, tempFolder);

		this.dataSource = new FileDAOFactory(tempFolder);
		experiment = dataSource.createExperimentDAO().addExperiment(experimentName);
	}

	public String getId() {
		return experimentId;
	}

	/**
	 *
	 */
	public void startRun() {
		run = experiment.addExperimentRun(new Date().toString());
	}

	/**
	 * Stops the current experiment run and stores the results.
	 */
	public void stopRun() {

		// Store and copy experiment files.

		String folder = "results/" + experimentId;

		try {
			storage.createFolder("results");
			storage.createFolder(folder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dataSource.store();
		storeExperiment(experimentId, tempFolder);

		// Store experiment metadata.
		ExperimentData data = new ExperimentData();

		data.setId(experimentId);
		data.setName(experimentName);
		data.setDate(new Date());

		try {
			storage.writeFile(folder + "/experiment.json", JsonHelper.toJson(data));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ResultsSocket.update(data);
	}

	/**
	 *
	 * @param name
	 * @param startTime
	 * @param endTime
	 */
	public void takeMeasurement(String name, long startTime, long endTime) {
		TimeSpanSensor sensor = sensors.get(name);

		if (sensor == null) {
			sensor = experiment.addTimeSpanSensor(name);
			sensors.put(name, sensor);
		}

		double start = startTime / ONE_SECOND_IN_NANO_SECONDS;
		double timeSpan = (endTime - startTime) / ONE_SECOND_IN_NANO_SECONDS;

		run.addTimeSpanMeasurement(sensor, start, timeSpan);
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	private String getExperimentId(String name) {
		String id = "default";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(name.getBytes("UTF-8"));

			id = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return id;
	}

	// The following methods are used for copying experiment data back and forth between
	// storage and file system. May be replaced by a custom DAO factory.

	/**
	 *
	 * @param id
	 * @return
	 */
	private String fetchExperiment(String id, String destination) {
		File folder = new File(destination);
		folder.mkdirs();

		String source = "results/" + id + "/";

		if (storage.fileExists(source)) {
			try {
				for (String stateFile : stateFiles) {
					copyToFs(source, stateFile, destination);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return folder.getAbsolutePath();
	}

	/**
	 *
	 * @param id
	 * @param source
	 */
	private void storeExperiment(String id, String source) {
		String destination = "results/" + id + "/";

		try {
			// Copy state files.

			for (String stateFile : stateFiles) {
				copyFromFs(source, stateFile, destination);
			}

			// Copy the remaining files that don't exist in the storage.
			for (String file : new File(source).list()) {
				if (storage.fileExists(destination + file)) {
					continue;
				}

				copyFromFs(source, file, destination);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the path of a temporary folder for storing experiment data.
	 * @return the path of a temporary folder
	 */
	private String getTempFolder() {
		StringBuilder sb = new StringBuilder();

		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("/ProtoCom/");
		sb.append(UUID.randomUUID());
		sb.append('/');

		return sb.toString();
	}

	/**
	 *
	 * @param path
	 * @param file
	 * @param destination
	 * @throws IOException
	 */
	private void copyToFs(String path, String file, String destination)
		throws IOException {

		try {
			byte[] data = storage.readFile(path + file);
			FileOutputStream out = new FileOutputStream(destination + file);

			out.write(data);
			out.close();
		} catch (FileNotFoundException e) {
			// Ignore missing files.
		}
	}

	/**
	 *
	 * @param path
	 * @param file
	 * @param destination
	 */
	private void copyFromFs(String path, String file, String destination)
		throws IOException {

		try {
			FileInputStream in = new FileInputStream(path + file);

			ByteArrayOutputStream data = new ByteArrayOutputStream();
			IOUtils.copy(in, data);

			storage.writeFile(destination + file, data.toByteArray());

			in.close();
		} catch (FileNotFoundException e) {
			// Ignore missing files.
		}
	}
}
