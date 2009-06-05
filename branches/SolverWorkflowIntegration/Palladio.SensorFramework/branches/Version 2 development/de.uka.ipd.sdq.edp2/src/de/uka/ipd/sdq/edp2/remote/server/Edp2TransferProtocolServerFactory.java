/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import org.eclipse.net4j.protocol.ServerProtocolFactory;
import org.eclipse.net4j.util.factory.ProductCreationException;

import de.uka.ipd.sdq.edp2.DaoRegistry;

/**Factory for the server side of the Edp2TransferProtocol.
 * @author groenda
 */
public class Edp2TransferProtocolServerFactory extends ServerProtocolFactory {
	/** Registry of DAOs which can be accessed by this server. */
	private DaoRegistry daoRegistry;
	
	/**Registers server for Edp2TransferProtocol in Net4J. 
	 */
	public Edp2TransferProtocolServerFactory(DaoRegistry daoRegistry) {
		super(Edp2TransferProtocolImpl.PROTOCOL_NAME);
		this.daoRegistry = daoRegistry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.net4j.util.factory.IFactory#create(java.lang.String)
	 */
	@Override
	public Object create(String description) throws ProductCreationException {
		return new Edp2TransferProtocolImpl(daoRegistry);
	}

}
