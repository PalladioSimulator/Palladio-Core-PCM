/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import java.util.logging.Logger;

import org.eclipse.net4j.channel.IChannel;

import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DescriptionsDao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**
 * Handler for outgoing Edp2TransferProtocol requests of type
 * Descriptions at the protocol client.
 * 
 * @author groenda
 */
public class TransferDescriptionsRequest extends GenericTransferRequest {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferDescriptionsRequest.class
					.getCanonicalName());

	public TransferDescriptionsRequest(IChannel channel, String uuid,
			DaoFactory factory) {
		super(channel, uuid, factory);
	}

	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_DESCRIPTIONS_SIGNAL;
	}

	@Override
	protected Dao createDao(String uuid) {
		return factory.createDescriptionsDao(uuid);
	}

	@Override
	protected String getHandledDaoName() {
		return "DescriptionsDao";
	}

	@Override
	protected boolean isDaoInstanceOfValid(Dao dao) {
		return (dao instanceof DescriptionsDao);
	}

}
