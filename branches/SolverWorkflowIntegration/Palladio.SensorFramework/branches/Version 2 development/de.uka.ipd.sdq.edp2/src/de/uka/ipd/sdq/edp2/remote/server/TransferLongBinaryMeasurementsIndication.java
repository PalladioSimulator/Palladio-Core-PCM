/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for incoming Edp2TransferProtocol requests of type LongBinaryMeasurements at the protocol server.
 * @author groenda
 */
public class TransferLongBinaryMeasurementsIndication extends GenericTransferIndication {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferLongBinaryMeasurementsIndication.class
					.getCanonicalName());
	
	/** Initialization.
	 */
	public TransferLongBinaryMeasurementsIndication(DaoRegistry daoRegistry) {
		super(daoRegistry);
	}
	
	@Override
	protected short getSignalID() {
		return (short) Edp2TransferProtocol.TRANSFER_LONG_BINARY_MEASUREMENTS_SIGNAL;
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
