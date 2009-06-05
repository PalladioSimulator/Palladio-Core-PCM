/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import org.eclipse.net4j.channel.IChannel;

import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for outgoing Edp2TransferProtocol requests of type ExperimentGroup at the protocol client.
 * @author groenda
 */
public class TransferExperimentGroupRequest extends GenericTransferRequest {
	
	public TransferExperimentGroupRequest(IChannel channel, String uuid, DaoFactory factory) {
		super (channel, uuid, factory);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.remote.client.GenericTransferRequest#createDao(java.lang.String)
	 */
	@Override
	protected Dao createDao(String uuid) {
		return factory.createExperimentGroupDao(uuid);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.remote.client.GenericTransferRequest#getHandledDaoName()
	 */
	@Override
	protected String getHandledDaoName() {
		return "ExperimentGroupDao";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.remote.client.GenericTransferRequest#getSignalID()
	 */
	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_EXPERIMENT_GROUP_SIGNAL;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.remote.client.GenericTransferRequest#isDaoInstanceOfValid(de.uka.ipd.sdq.edp2.Edp2Dao)
	 */
	@Override
	protected boolean isDaoInstanceOfValid(Dao dao) {
		return dao instanceof ExperimentGroupDao;
	}

}
