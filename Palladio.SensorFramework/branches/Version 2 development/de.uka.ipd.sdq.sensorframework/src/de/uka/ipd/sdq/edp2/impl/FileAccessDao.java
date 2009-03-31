/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.Edp2Dao;

/**Provides the basic functionality and protocol checking for ExpermentGroupDaos with file access.
 * @author groenda
 */
public abstract class FileAccessDao implements Edp2Dao {
	/** Error logger for this class. */
	protected static final Logger logger = Logger.getLogger(FileAccessDao.class.getCanonicalName());

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
	public void setResourceFile(File resourceFile) {
		if (this.resourceFile == null) {
			this.resourceFile = resourceFile;
		} else {
			logger.log(Level.SEVERE, "Setting the file resource is only allowed if there is no resource loaded.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void open() throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new DataNotAccessibleException("Data has already been deleted.", null);
		}
	}	

	@Override
	public void close() throws DataNotAccessibleException {
		if (!isOpen()) {
			throw new IllegalStateException("State must be open to be changed by close().");
		}
	}
	
	@Override
	public void delete() throws DataNotAccessibleException {
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
	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public boolean isOpen() {
		return open;
	}

}
