/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.file.BackgroundMemoryList;
import de.uka.ipd.sdq.edp2.file.Serializer;
import de.uka.ipd.sdq.edp2.file.impl.BackgroundMemoryListImpl;
import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

/**DAO for measurement data stored in binary files.
 * @author groenda
 */
public class FileBinaryMeasurementsDaoImpl<T> extends FileAccessDao implements BinaryMeasurementsDao<T> {
	/** Error logger for this class. */
	protected static final Logger logger = Logger.getLogger(FileBinaryMeasurementsDaoImpl.class.getCanonicalName());

	/** Suffix for files in which the binary measurements are stored. */
	public final static String FILE_SUFFIX = ".bin";
	
	/** Serializer to use for the background list. */
	private Serializer<T> serializer = null;
	/** Background memory list used to actually handle the list. */
	private BackgroundMemoryList<T> backgroundMemoryList;
	
	public void open() throws DataNotAccessibleException {
		super.open();
		if (serializer == null) {
			String msg = "Initialization must have failed. Serializer is null.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg, null);
		}
		try {
			this.backgroundMemoryList = new BackgroundMemoryListImpl<T>(
					resourceFile.getAbsolutePath(),	serializer);
			open = true;
		} catch (IOException ioe) {
			String msg = "Error accessing file on background storage.";
			logger.log(Level.SEVERE, msg, ioe);
			throw new DataNotAccessibleException(msg, ioe);
		}
	}
	
	public void close() throws DataNotAccessibleException {
		super.close();
		try {
			backgroundMemoryList.close();
			open = false;
		} catch (IOException ioe) {
			String msg = "Error accessing file on background storage.";
			logger.log(Level.SEVERE, msg, ioe);
			throw new DataNotAccessibleException(msg, ioe);
		}
	}
	
	public Serializer<T> getSerializer() {
		return serializer;
	}

	public void setSerializer(Serializer<T> serializer) {
		this.serializer = serializer;
	}

	@Override
	public BinaryMeasurements<T> getBinaryMeasurements() {
		if (!isOpen()) {
			String msg = "Binary measurements can only be requested if state is open.";
			logger.log(Level.WARNING, msg);
			throw new IllegalStateException(msg);
		}
		return backgroundMemoryList;
	}
}
