/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.net4j.channel.IChannel;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**
 * Generic handler for outgoing Edp2TransferProtocol requests at the protocol
 * client.
 * 
 * @author groenda
 */
public abstract class GenericTransferRequest extends
		RequestWithConfirmation<Boolean> implements Edp2TransferProtocol {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(GenericTransferRequest.class.getCanonicalName());

	/** UUID of the requested instance. */
	protected String uuid;
	/** Factory used to create new DAOs after successful transfer. */
	protected DaoFactory factory;

	public GenericTransferRequest(IChannel channel, String uuid,
			DaoFactory factory) {
		super(channel);
		this.uuid = uuid;
		this.factory = factory;
	}

	@Override
	protected Boolean confirming(ExtendedDataInputStream in) throws IOException {
		boolean success = in.readBoolean();
		if (success) {
			Dao dao;
			if (factory.getDaoRegistry().isRegistered(uuid)) {
				dao = factory.getDaoRegistry().getEdp2Dao(uuid);
				if (!isDaoInstanceOfValid(dao)) {
					logger.log(Level.SEVERE,
							"Requested DAO for UUID is not an "
									+ getHandledDaoName() + ".");
					success = false;
					return success;
				}
			} else {
				dao = createDao(uuid);
			}
			try {
				dao.deserialize(in);
			} catch (DataNotAccessibleException e) {
				success = false;
				String msg = "(Local) DAO could not be accessed corectly. UUID = "
						+ uuid;
				logger.log(Level.SEVERE, msg, e);
				throw new IOException(msg);
			}
		} else {
			logger.log(Level.WARNING, "Transfer of " + getHandledDaoName()
					+ " to client not successful. UUID = " + uuid);
		}
		return success;
	}

	/**
	 * Creates DAO of the requested type.
	 * 
	 * @param uuid
	 *            UUID for which the DAO is responsible.
	 * @return Edp2Dao instance.
	 */
	protected abstract Dao createDao(String uuid);

	@Override
	protected void requesting(ExtendedDataOutputStream out) throws IOException {
		out.writeString(uuid);
	}

	@Override
	protected abstract short getSignalID();

	/**
	 * Checks if a DAO is a valid transfer instance for this class.
	 * 
	 * @param dao
	 *            The dao to check.
	 * @return <code>true</code> if the instance is valid.
	 */
	protected abstract boolean isDaoInstanceOfValid(Dao dao);

	/**
	 * Returns the name of the DAOs handled by the transfer class.
	 * 
	 * @return Name of the DAO.
	 */
	protected abstract String getHandledDaoName();
}
