/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import de.uka.ipd.sdq.sensorframework.DaoFactory;
import de.uka.ipd.sdq.sensorframework.DataNotAccessibleException;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.ExperimentGroupDao;
import de.uka.ipd.sdq.sensorframework.BinaryMeasurementsDao;
import de.uka.ipd.sdq.sensorframework.file.impl.DoubleSerialiser;

/**Responsible for creating DAOs accessing files on background storage.
 * @author groenda
 */
public class FileDaoFactory implements DaoFactory {
	private File storageDirectory = null;
	private boolean accessible = false;
	private List<String> storedExperimentGroupUuids = null;
	private static ConcurrentMap<String, FileMeasurementDataDao<Double>> registeredDoubleMmts = null; 
	private static ConcurrentMap<String, ExperimentGroup> registeredExperimentGroups = null; 

	@Override
	public BinaryMeasurementsDao<Double> createDoubleMeasurementDataDao(String uuid) {
		FileMeasurementDataDao<Double> fmd;
		if (registeredDoubleMmts.containsKey(uuid)) {
			fmd = registeredDoubleMmts.get(uuid);
		} else {
			ensureUuidNotExists(uuid);
			fmd = new FileMeasurementDataDao<Double>();
			fmd.setSerializer(new DoubleSerialiser());
			fmd.setStorageDirectory(storageDirectory);
			fmd.setUuid(uuid);
			registeredDoubleMmts.put(uuid, fmd);
		}
		return fmd;
	}

	/**Checks if the UUID is not already known to this factory.
	 * @param uuid Identifier to check.
	 */
	private void ensureUuidNotExists(String uuid) {
		if (registeredDoubleMmts.containsKey(uuid) || registeredExperimentGroups.containsKey(uuid)) {
			throw new IllegalArgumentException("The provided uuid '" + uuid + "' was already in use.");
		}
	}

	@Override
	public void closeStorage() throws DataNotAccessibleException {
		// TODO Auto-generated method stub
		accessible = false; 
		registeredDoubleMmts = null;
		registeredExperimentGroups = null;
		storedExperimentGroupUuids = null;
		// storageDirectory is remembered to allow reopening
	}

	@Override
	public boolean isStorageClosed() {
		return !accessible;
	}

	@Override
	public void openStorage() throws DataNotAccessibleException {
		registeredExperimentGroups = new ConcurrentHashMap<String, ExperimentGroup>();
		registeredDoubleMmts = new ConcurrentHashMap<String, FileMeasurementDataDao<Double>>();
		validateDirectory(storageDirectory);
		lookupExperimentGroups();
		accessible = true;
	}

	/**Looks up all files which should contain valid ExperimentGroup instances.
	 */
	private void lookupExperimentGroups() {
		File[] sfEmfFiles = storageDirectory.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(FileMeasurementDataDao.FILE_SUFFIX)
						&& dir.isFile();
				}
			});
		// assume all files with correct suffix contain valid experiment group instances.
		storedExperimentGroupUuids = new ArrayList<String>();
		for (int index=0; index < sfEmfFiles.length; index++) {
			String uuid = sfEmfFiles[index].getName().substring(0, 
					sfEmfFiles[index].getName().lastIndexOf(FileMeasurementDataDao.FILE_SUFFIX));
			storedExperimentGroupUuids.add(uuid);
		}
	}

	/**Validates that the provided file is a directory.
	 * @param storageDirectory2 The directory.
	 */
	private void validateDirectory(File storageDirectory2) {
		if (!storageDirectory2.isDirectory()) {
			throw new IllegalArgumentException("The provided file '" 
					+ storageDirectory2.getAbsolutePath() + "' is not a valid directory.");
		}
	}

	@Override
	public ExperimentGroupDao createExperimentGroupDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStoredExperimentGroupUuids() {
		return storedExperimentGroupUuids;
	}

	public File getStorageDirectory() {
		return storageDirectory;
	}

	public void setStorageDirectory(File storageDirectory) {
		if (accessible) {
			throw new IllegalStateException("The storage directory can only be changed " +
					"if it is not in accessible state/open.");
		}
		this.storageDirectory = storageDirectory;
	}

}
