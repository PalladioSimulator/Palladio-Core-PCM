/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;

import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Edp2TransferProtocol implementation on the client side.
 * @author groenda
 */
public class Edp2TransferProtocolImpl extends SignalProtocol implements
		Edp2TransferProtocol {
	
	/* (non-Javadoc)
	 * @see org.eclipse.net4j.signal.SignalProtocol#createSignalReactor(short)
	 */
	@Override
	protected SignalReactor createSignalReactor(short signalID) {
	    // Only needed for server initiated requests
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.net4j.protocol.IProtocol#getType()
	 */
	@Override
	public String getType() {
		return Edp2TransferProtocol.PROTOCOL_NAME;
	}
	
}
