/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.impl;

import java.io.File;
import java.io.IOException;

import de.uka.ipd.sdq.sensorframework.DataNotAccessibleException;
import de.uka.ipd.sdq.sensorframework.BinaryMeasurementsDao;
import de.uka.ipd.sdq.sensorframework.file.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.file.Serializer;
import de.uka.ipd.sdq.sensorframework.file.impl.BackgroundMemoryListImpl;
import de.uka.ipd.sdq.sensorframework.models.binary.BinaryMeasurements;

/**DAO for measurement data stored in binary files.
 * @author groenda
 */
public class FileMeasurementDataDao<T> implements BinaryMeasurementsDao<T> {
	/** Suffix for files in which the measurements are stored. */
	public final static String FILE_SUFFIX = ".bin";
	
	/** Directory in which all files are stored. */
	private File storageDirectory = null;
	/** Unique identifier for the measurements. Must be a valid file name. */
	private String uuid = null;
	/** Serializer to use for the background list. */
	private Serializer<T> serializer = null;
	/** Background memory list used to actually handle the list. */
	private BackgroundMemoryList<T> backgroundMemoryList;
	/** Status if the background storage is currently accessible. */
	private boolean accessible = false;
	
	/**Calculates the absolute path for the file in which the measurements are stored.
	 * @return Absolute path to the file.
	 */
	private String getAbsolutePath() {
		return storageDirectory.getAbsolutePath() + File.separator + uuid + FILE_SUFFIX;
	}
	
	public void openStorage() throws DataNotAccessibleException {
		if (storageDirectory==null || uuid == null || serializer == null || accessible == true) {
			throw new IllegalStateException("Protocol violation. It is mandataory to provide " +
					"information about the file location first. Files are not allowed to be opened " +
					"twice.", null);
		}
		try {
			this.backgroundMemoryList = new BackgroundMemoryListImpl<T>(getAbsolutePath(), serializer);
			accessible = true;
		} catch (IOException ioe) {
			throw new DataNotAccessibleException("Error accessing file on background storage.", ioe);
		}
	}
	
	public void closeStorage() throws DataNotAccessibleException {
		if (accessible) {
			try {
				backgroundMemoryList.close();
			} catch (IOException ioe) {
				throw new DataNotAccessibleException("Error accessing file on background storage.", ioe);
			}
		} else {
			throw new IllegalStateException("Protocol violation. The background story was not opened before it was closed.");
		}
	}
	
	public boolean isStorageClosed() {
		return false;
	}

	public File getStorageDirectory() {
		return storageDirectory;
	}

	public void setStorageDirectory(File storageDirectory) {
		this.storageDirectory = storageDirectory;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Serializer<T> getSerializer() {
		return serializer;
	}

	public void setSerializer(Serializer<T> serializer) {
		this.serializer = serializer;
	}

	@Override
	public BinaryMeasurements<T> getBinaryMeasurements() {
		return backgroundMemoryList;
	}
}
