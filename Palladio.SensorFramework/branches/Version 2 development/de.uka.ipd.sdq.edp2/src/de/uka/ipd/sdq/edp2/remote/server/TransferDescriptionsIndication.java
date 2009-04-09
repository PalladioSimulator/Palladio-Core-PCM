/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.DescriptionsDao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for incoming Edp2TransferProtocol requests of type Descriptions at the protocol server.
 * @author groenda
 */
public class TransferDescriptionsIndication extends
		GenericTransferIndication {

	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferDescriptionsIndication.class.getCanonicalName());

	public TransferDescriptionsIndication(DaoRegistry daoRegistry) {
		super (daoRegistry);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.Signal#getSignalID()
	 */
	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_DESCRIPTIONS_SIGNAL;
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
