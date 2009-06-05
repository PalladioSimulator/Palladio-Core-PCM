/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Generic handler for incoming Edp2TransferProtocol requests at the protocol server.
 * @author groenda
 */
public abstract class GenericTransferIndication extends IndicationWithResponse
		implements Edp2TransferProtocol {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(GenericTransferIndication.class
					.getCanonicalName());
	
	/**UUID of the requested DoubleBinaryMeasurements. */
	protected String requestedUuid;
	/** The central DAO registry. */
	protected DaoRegistry daoRegistry;

	/** Initialization.
	 */
	public GenericTransferIndication(DaoRegistry daoRegistry) {
		requestedUuid = null;
		this.daoRegistry = daoRegistry;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.IndicationWithResponse#indicating(org.eclipse.net4j.util.io.ExtendedDataInputStream)
	 */
	@Override
	protected void indicating(ExtendedDataInputStream in) throws IOException {
		requestedUuid = in.readString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.IndicationWithResponse#responding(org.eclipse.net4j.util.io.ExtendedDataOutputStream)
	 */
	@Override
	protected void responding(ExtendedDataOutputStream out) throws IOException {
		boolean success = false;
		if (daoRegistry.isRegistered(requestedUuid)) {
			success = true;
			// load/open dao and serialize data
			Dao dao = daoRegistry.getEdp2Dao(requestedUuid);
			if (!isDaoInstanceOfValid(dao)) {
				logger.log(Level.SEVERE, "Requested DAO for UUID is not an " + getHandledDaoName() + ".");
				success = false;
			}
			if (!dao.isOpen()) {
				try {
					dao.open();
				} catch (DataNotAccessibleException e) {
					logger.log(Level.WARNING, "Could not access DAO for UUID "
							+ requestedUuid + ".", e);
					success = false;
				}
			}
			out.writeBoolean(success);
			if (success) {
				// TODO Check what happens if byte-array overflow occurs (>=2^32 bytes overall)
				try {
					dao.serialize(out);
				} catch (DataNotAccessibleException e) {
					String msg ="Could not serialize data to transfer stream. Data corrupted.";
					logger.log(Level.SEVERE, msg, e);
					// Send empty array to allow error detection on client side
					ExtendedIOUtil.writeByteArray(out, new byte[0]);
					throw new IOException(msg);
				}
			}
		} else {
			out.writeBoolean(success);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.Signal#getSignalID()
	 */
	@Override
	protected abstract short getSignalID();

	/**Checks if a DAO is a valid transfer instance for this class.
	 * @param dao The DAO to check.
	 * @return <code>true</code> if the instance is valid.
	 */
	protected abstract boolean isDaoInstanceOfValid(Dao dao);
	
	/**Returns the name of the DAOs handled by the transfer class.
	 * @return Name of the DAO.
	 */
	protected abstract String getHandledDaoName();
}
