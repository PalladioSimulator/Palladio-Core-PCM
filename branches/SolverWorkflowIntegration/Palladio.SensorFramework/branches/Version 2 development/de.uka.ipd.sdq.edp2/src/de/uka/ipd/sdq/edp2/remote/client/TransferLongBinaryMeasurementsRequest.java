/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import java.util.logging.Logger;

import org.eclipse.net4j.channel.IChannel;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for outgoing Edp2TransferProtocol requests of type LongBinaryMeasurements at the protocol client.
 * @author groenda
 */
public class TransferLongBinaryMeasurementsRequest extends
		GenericTransferRequest {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferLongBinaryMeasurementsRequest.class
					.getCanonicalName());

	public TransferLongBinaryMeasurementsRequest(IChannel channel, String uuid, DaoFactory factory) {
		super (channel, uuid, factory);
	}

	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_LONG_BINARY_MEASUREMENTS_SIGNAL;
	}

	@Override
	protected Dao createDao(String uuid) {
		return factory.createLongMeasurementsDao(uuid);
	}

	@Override
	protected String getHandledDaoName() {
		return "LongBinaryMeasurementsDao";
	}

	@Override
	protected boolean isDaoInstanceOfValid(Dao dao) {
		return (dao instanceof BinaryMeasurementsDao);
	}

}
