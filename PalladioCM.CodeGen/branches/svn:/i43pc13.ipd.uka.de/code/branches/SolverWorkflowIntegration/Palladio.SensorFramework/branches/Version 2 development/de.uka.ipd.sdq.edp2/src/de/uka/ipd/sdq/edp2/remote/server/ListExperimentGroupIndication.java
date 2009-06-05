/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**
 * @author groenda
 * 
 */
public class ListExperimentGroupIndication extends IndicationWithResponse implements
		Edp2TransferProtocol {
	/** Logger for this class. */
	protected static final Logger logger = Logger
			.getLogger(ListExperimentGroupIndication.class.getCanonicalName());

	/** The central DAO registry. */
	protected DaoRegistry daoRegistry;

	/** Initialization.
	 */
	public ListExperimentGroupIndication(DaoRegistry daoRegistry) {
		this.daoRegistry = daoRegistry;
	}

	@Override
	protected void indicating(ExtendedDataInputStream in) throws IOException {
		// Do nothing; Senseless transfer required for Net4J to work
		in.readBoolean();
	}

	@Override
	protected void responding(ExtendedDataOutputStream out) throws IOException {
		Set<String> list = daoRegistry.getRegisteredUuids();
		out.writeInt(list.size());
		Iterator<String> listIterator = list.iterator();
		while (listIterator.hasNext()) {
			ExtendedIOUtil.writeString(out, listIterator.next());
		}
	}

	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.LIST_EXPERIMENT_GROUPS_SIGNAL;
	}
	
	
}
