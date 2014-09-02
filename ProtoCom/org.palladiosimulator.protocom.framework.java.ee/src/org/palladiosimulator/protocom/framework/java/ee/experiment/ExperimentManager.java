package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.storage.Storage;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 *
 * @author Christian Klaussner
 */
public final class ExperimentManager {
	private static ExperimentManager instance;

	private ExperimentManager() {
		sensors = new HashMap<String, TimeSpanSensor>();
	}

	public static ExperimentManager getInstance() {
		if (instance == null) {
			instance = new ExperimentManager();
		}

		return instance;
	}

	//

	private static final double ONE_SECOND_IN_NANO_SECONDS = Math.pow(10, 9);

	private IDAOFactory dataSource;
	private File directory;
	private Experiment experiment;
	private String experimentName;

	private ExperimentRun run;

	private HashMap<String, TimeSpanSensor> sensors;

	/**
	 *
	 * @param experimentName
	 */
	public void init(String experimentName) {
		this.experimentName = experimentName;

		String temp = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator");

		directory = new File(temp + UUID.randomUUID());
		directory.mkdirs();

		this.dataSource = new FileDAOFactory(directory.getAbsolutePath());

		experiment = dataSource.createExperimentDAO().addExperiment(experimentName);
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
		dataSource.store();

		Storage storage = new Storage();

		// Calculate the identifier for the given experiment name.

		String experimentId = "default";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(experimentName.getBytes("UTF-8"));

			experimentId = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// Copy results from temporary folder to destination.

		String folder = "experiments/" + experimentId;

		try {
			storage.createFolder("experiments");
			storage.createFolder(folder);

			for (String filename : directory.list()) {
				// TODO: Not platform independent!
				// Path path = Paths.get(directory.getAbsolutePath(), filename);
				String path = directory.getAbsolutePath() + "/" + filename;

				File file = new File(path.toString());
				byte[] data = IOUtils.toByteArray(new FileInputStream(file));

				storage.writeFile(folder + "/" + filename, data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Store experiment meta data.

		ExperimentInfo info = new ExperimentInfo();
		info.setName(experimentName);

		try {
			storage.writeFile(folder + "/experiment.json", JsonHelper.toJson(info));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}
