/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import org.eclipse.net4j.protocol.ClientProtocolFactory;
import org.eclipse.net4j.util.factory.ProductCreationException;

import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**Factory for the client side of the Edp2TransferProtocol.
 * @author groenda
 */
public class Edp2TransferProtocolClientFactory extends ClientProtocolFactory {

	public Edp2TransferProtocolClientFactory() {
		super(Edp2TransferProtocol.PROTOCOL_NAME);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.net4j.util.factory.IFactory#create(java.lang.String)
	 */
	@Override
	public Object create(String description) throws ProductCreationException {
		return new Edp2TransferProtocolImpl();
	}

}
