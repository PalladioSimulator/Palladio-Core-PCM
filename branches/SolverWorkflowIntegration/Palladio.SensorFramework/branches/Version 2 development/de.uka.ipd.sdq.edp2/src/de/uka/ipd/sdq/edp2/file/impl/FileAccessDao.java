/**
 * 
 */
package de.uka.ipd.sdq.edp2.file.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.Dao;

/**Provides the basic functionality and protocol checking for DAOs with file access.
 * @author groenda
 */
public abstract class FileAccessDao implements Dao {
	/** Error logger for this class. */
	protected static final Logger logger = Logger.getLogger(FileAccessDao.class.getCanonicalName());
	
	/** Denotes read-only file access. */
	private static final String FILE_ACCESS_READ_ONLY = "r";
	/** Denotes read and write file access. */
	private static final String FILE_ACCESS_READ_WRITE = "rw";

	/** Pointer to the file containing the resource. */
	protected File resourceFile = null;
	/** Status flag. Determine if the data behind the dao is open or not. */
	protected boolean open = false;
	/** Status flag. Determine if the data has been deleted. */
	protected boolean deleted = false;
	
	/**Sets the resource file from which the ExperimentGroup data is loaded.
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
	public synchronized void open() throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new DataNotAccessibleException("Data has already been deleted.", null);
		}
	}	

	@Override
	public synchronized void close() throws DataNotAccessibleException {
		if (!isOpen()) {
			throw new IllegalStateException("State must be open to be changed by close().");
		}
	}
	
	@Override
	public synchronized void delete() throws DataNotAccessibleException {
		if (isOpen()) {
			throw new DataNotAccessibleException("Data cannot be deleted if the status is open.", null);
		}
		if (isDeleted()) {
			String msg = "Data can only be deleted once.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		if (!resourceFile.exists() || resourceFile.delete()) {
			deleted = true;
		} else {
			String msg = "Could not delete file.";
			logger.log(Level.WARNING, msg);
			throw new DataNotAccessibleException(msg, null);
		}
	}
	
	@Override
	public synchronized boolean isDeleted() {
		return deleted;
	}

	@Override
	public synchronized boolean isOpen() {
		return open;
	}

	@Override
	public synchronized void deserialize(ExtendedDataInputStream input) throws DataNotAccessibleException {
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
