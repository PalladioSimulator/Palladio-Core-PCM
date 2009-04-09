/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for incoming Edp2TransferProtocol requests of type DoubleBinaryMeasurements at the protocol server.
 * @author groenda
 */
public class TransferDoubleBinaryMeasurementsIndication extends GenericTransferIndication {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferDoubleBinaryMeasurementsIndication.class
					.getCanonicalName());
	
	/** Initialization.
	 */
	public TransferDoubleBinaryMeasurementsIndication(DaoRegistry daoRegistry) {
		super(daoRegistry);
	}
	
	@Override
	protected short getSignalID() {
		return (short) Edp2TransferProtocol.TRANSFER_DOUBLE_BINARY_MEASUREMENTS_SIGNAL;
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
