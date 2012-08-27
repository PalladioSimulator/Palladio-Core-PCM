/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.local.file.BackgroundMemoryListImpl.BinaryRepresentation;

/**File-backed implementation of {@link BinaryMeasurementsDao}.
 * @author groenda
 * @author S. Becker
 */
public class FileBinaryMeasurementsDaoImpl<V,Q extends Quantity> extends FileAccessDao implements BinaryMeasurementsDao<V,Q> {
	/** Error logger for this class. */
	protected static final Logger logger = Logger.getLogger(FileBinaryMeasurementsDaoImpl.class.getCanonicalName());

	/** Serializer to use for the background list. */
	private Serializer<V> serializer = null;
	/** Background memory list used to actually handle the list. */
	private BackgroundMemoryList<V,Q> backgroundMemoryList;
	/** Binary format of stored Measures. */
	private BinaryRepresentation binaryRepresentation = null;
	/** Unit in which all measurements are stored. */
	private Unit<Q> unit;
	
	public void open() throws DataNotAccessibleException {
		super.open();
		if (unit == null) {
			String msg = "A unit must be set before a call to open() is made.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg, null);
		}
		if (binaryRepresentation == null) {
			String msg = "A binary representation must be set before a call to open() is made.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg, null);
		}
		if (serializer == null) {
			String msg = "Initialization must have failed. Serializer is null.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg, null);
		}
		try {
			this.backgroundMemoryList = new BackgroundMemoryListImpl<V,Q>(
					resourceFile.getAbsolutePath(),	serializer, binaryRepresentation, unit);
			setOpen();
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
			setClosed();
		} catch (IOException ioe) {
			String msg = "Error accessing file on background storage.";
			logger.log(Level.SEVERE, msg, ioe);
			throw new DataNotAccessibleException(msg, ioe);
		}
	}
	
	public Serializer<V> getSerializer() {
		return serializer;
	}

	public void setSerializer(Serializer<V> serializer) {
		this.serializer = serializer;
	}

	@Override
	public List<Measure<V,Q>> getMeasurements() {
		if (!isOpen()) {
			String msg = "Binary measurements can only be requested if state is open.";
			logger.log(Level.WARNING, msg);
			throw new IllegalStateException(msg);
		}
		return backgroundMemoryList;
	}

	/**
	 * @return the binaryRepresentation
	 */
	public BinaryRepresentation getBinaryRepresentation() {
		return binaryRepresentation;
	}

	/**
	 * @param binaryRepresentation the binaryRepresentation to set
	 */
	public void setBinaryRepresentation(BinaryRepresentation binaryRepresentation) {
		if (this.binaryRepresentation != null) {
			String msg = "It is not allowed to set the binary representation more than once.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		this.binaryRepresentation = binaryRepresentation;
	}

	/**
	 * @return the unit
	 */
    public Unit<Q> getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
    public void setUnit(Unit<Q> unit) {
		if (this.unit != null) {
			String msg = "It is not allowed to set the unit more than once.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		this.unit = unit;
	}
	
	@Override
	public synchronized void serialize(ExtendedDataOutputStream output)
			throws DataNotAccessibleException {
		try {
			super.serialize(output);
			ExtendedIOUtil.writeString(output, getUnit().toString());
		} catch (IOException e) {
			String msg = "Could not put unit name on stream.";
			logger.log(Level.SEVERE, msg, e);
			throw new DataNotAccessibleException(msg, e);
		}
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public synchronized void deserialize(ExtendedDataInputStream input)
			throws DataNotAccessibleException {
		try {
			super.deserialize(input);
			unit = (Unit<Q>) Unit.valueOf(ExtendedIOUtil.readString(input));
		} catch (IOException e) {
			String msg = "Could not put unit name on stream.";
			logger.log(Level.SEVERE, msg, e);
			throw new DataNotAccessibleException(msg, e);
		}
	}
}
