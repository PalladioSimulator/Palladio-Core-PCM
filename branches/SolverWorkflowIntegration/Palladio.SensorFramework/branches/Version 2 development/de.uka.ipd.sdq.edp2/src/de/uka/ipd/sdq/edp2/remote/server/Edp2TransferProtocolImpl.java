/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;

import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Implementation of the Edp2TransferProtocol on the server side.
 * @author groenda
 */
public class Edp2TransferProtocolImpl extends SignalProtocol implements
		Edp2TransferProtocol {
	/** Logger for this class. */
	private static final Logger logger = Logger
			.getLogger(Edp2TransferProtocolImpl.class.getCanonicalName());
	
	/** DAO registry. */
	private DaoRegistry daoRegistry;
	
	public Edp2TransferProtocolImpl(DaoRegistry daoRegistry) {
		this.daoRegistry = daoRegistry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.net4j.signal.SignalProtocol#createSignalReactor(short)
	 */
	@Override
	protected SignalReactor createSignalReactor(short signalID) {
		switch (signalID) {
		case Edp2TransferProtocol.LIST_EXPERIMENT_GROUPS_SIGNAL: 
			return new ListExperimentGroupIndication(daoRegistry);
		case Edp2TransferProtocol.TRANSFER_DOUBLE_BINARY_MEASUREMENTS_SIGNAL:
			return new TransferDoubleBinaryMeasurementsIndication(daoRegistry);
		case Edp2TransferProtocol.TRANSFER_EXPERIMENT_GROUP_SIGNAL: 
			return new TransferExperimentGroupsIndication(daoRegistry);
		case Edp2TransferProtocol.TRANSFER_LONG_BINARY_MEASUREMENTS_SIGNAL: 
			return new TransferLongBinaryMeasurementsIndication(daoRegistry);
		case Edp2TransferProtocol.TRANSFER_NOMINAL_MEASUREMENTS_SIGNAL: 
			return new TransferNominalMeasurmentsIndication(daoRegistry);
		case Edp2TransferProtocol.TRANSFER_DESCRIPTIONS_SIGNAL:
			return new TransferDescriptionsIndication(daoRegistry);
		default:
			String msg = "Edp2Transfer Protocol was violated. signal = " + signalID;
			logger.log(Level.SEVERE, msg);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.net4j.protocol.IProtocol#getType()
	 */
	@Override
	public String getType() {
		return PROTOCOL_NAME;
	}
}
