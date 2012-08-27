/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.AbstractMeasurementsDaoImpl;

/**
 * Provides the basic functionality and protocol checking for DAOs where the persisted data is managed in
 * files on a local drive
 * 
 * @author groenda
 */
abstract class FileAccessDao extends AbstractMeasurementsDaoImpl {
    
	/** Error logger for this class. */
	protected static final Logger logger = Logger.getLogger(FileAccessDao.class.getCanonicalName());
	
	/** Denotes read-only file access. */
	private static final String FILE_ACCESS_READ_ONLY = "r";
	
	/** Denotes read and write file access. */
	private static final String FILE_ACCESS_READ_WRITE = "rw";

	/** Pointer to the file containing the resource. */
	protected File resourceFile = null;
	
	/**
	 * Sets the resource file from which the ExperimentGroup data is loaded.
	 * Can only be set once.
	 * @param resourceFile File in which the ExperimentGroup is stored.
	 */
	public synchronized void setResourceFile(File resourceFile) {
		if (this.resourceFile == null) {
			this.resourceFile = resourceFile;
		} else {
			logger.log(Level.SEVERE, "Setting the file resource is only allowed if there is no resource loaded.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public synchronized void delete() throws DataNotAccessibleException {
		super.delete();
		if (!resourceFile.exists() || resourceFile.delete()) {
			setDeleted(true);
		} else {
			String msg = "Could not delete file.";
			logger.log(Level.WARNING, msg);
			throw new DataNotAccessibleException(msg, null);
		}
	}
	
	@Override
	public synchronized void deserialize(ExtendedDataInputStream input) throws DataNotAccessibleException {
		super.deserialize(input);
		boolean oldOpenState = isOpen();
		if (oldOpenState) {
			close();
		}
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(resourceFile, FILE_ACCESS_READ_WRITE);
		} catch (FileNotFoundException e) {
			String msg = "Serialization error: File "
					+ resourceFile.getAbsolutePath()
					+ " on background storage could not be accessed.";
			logger.log(Level.SEVERE, msg, e);
			throw new DataNotAccessibleException(msg, e);
		}
		try {
			raf.seek(0);
			byte[] b = ExtendedIOUtil.readByteArray(input);
			raf.write(b);
			raf.setLength(b.length);
		} catch (IOException ioe) {
			String msg = "Serialization error: Could not read from file "
					+ resourceFile.getAbsolutePath()
					+ " on background storage and store results in serialized stream.";
			logger.log(Level.SEVERE, msg, ioe);
			throw new DataNotAccessibleException(msg, ioe);
		}
		if (oldOpenState) {
			open();
		}
	}

	@Override
	public synchronized void serialize(ExtendedDataOutputStream output) throws DataNotAccessibleException {
		super.serialize(output);
		boolean oldOpenState = isOpen();
		if (oldOpenState) {
			close();
		}
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(resourceFile, FILE_ACCESS_READ_ONLY);
		} catch (FileNotFoundException e) {
			String msg = "Serialization error: File "
					+ resourceFile.getAbsolutePath()
					+ " on background storage could not be accessed.";
			logger.log(Level.SEVERE, msg, e);
			throw new DataNotAccessibleException(msg, e);
		}
		//TODO State that only files of size Integer.MAX_INT are supported (also by Serializer).
		byte[] b = new byte[(int) resourceFile.length()];
		try {
			raf.seek(0);
			raf.read(b);
			ExtendedIOUtil.writeByteArray(output, b);
		} catch (IOException ioe) {
			String msg = "Serialization error: Could not read from file "
					+ resourceFile.getAbsolutePath()
					+ " on background storage and store results in serialized stream.";
			logger.log(Level.SEVERE, msg, ioe);
			throw new DataNotAccessibleException(msg, ioe);
		}
		if (oldOpenState) {
			open();
		}
	}
}
