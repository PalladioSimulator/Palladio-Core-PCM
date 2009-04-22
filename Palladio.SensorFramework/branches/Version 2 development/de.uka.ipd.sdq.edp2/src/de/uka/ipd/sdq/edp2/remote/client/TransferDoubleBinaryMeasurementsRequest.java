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

/**Handler for outgoing Edp2TransferProtocol requests of type DoubleBinaryMeasurements at the protocol client.
 * @author groenda
 */
public class TransferDoubleBinaryMeasurementsRequest extends
		GenericTransferRequest {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferDoubleBinaryMeasurementsRequest.class
					.getCanonicalName());
	
	public TransferDoubleBinaryMeasurementsRequest(IChannel channel, String uuid, DaoFactory factory) {
		super (channel, uuid, factory);
	}

	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_DOUBLE_BINARY_MEASUREMENTS_SIGNAL;
	}

	@Override
	protected Dao createDao(String uuid) {
		return factory.createDoubleMeasurementsDao(uuid);
	}

	@Override
	protected String getHandledDaoName() {
		return "DoubleBinaryMeasurementsDao";
	}

	@Override
	protected boolean isDaoInstanceOfValid(Dao dao) {
		return (dao instanceof BinaryMeasurementsDao);
	}

}
