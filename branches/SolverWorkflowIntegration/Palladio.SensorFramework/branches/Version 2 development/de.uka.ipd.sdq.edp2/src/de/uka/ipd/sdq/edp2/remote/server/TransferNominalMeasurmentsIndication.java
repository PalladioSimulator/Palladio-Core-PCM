/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.Dao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Handler for incoming Edp2TransferProtocol requests of type NominalMeasurements at the protocol server.
 * @author groenda
 */
public class TransferNominalMeasurmentsIndication extends
		GenericTransferIndication {

	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(TransferNominalMeasurmentsIndication.class.getCanonicalName());

	public TransferNominalMeasurmentsIndication(DaoRegistry daoRegistry) {
		super (daoRegistry);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.Signal#getSignalID()
	 */
	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.TRANSFER_NOMINAL_MEASUREMENTS_SIGNAL;
	}

	@Override
	protected String getHandledDaoName() {
		return "NominalMeasurementsDao";
	}

	@Override
	protected boolean isDaoInstanceOfValid(Dao dao) {
		return (dao instanceof NominalMeasurementsDao);
	}

}
