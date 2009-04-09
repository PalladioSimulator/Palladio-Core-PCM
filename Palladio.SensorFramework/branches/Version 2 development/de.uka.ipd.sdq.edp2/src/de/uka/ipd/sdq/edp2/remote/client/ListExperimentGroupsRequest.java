/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote.client;

import java.io.IOException;
import java.util.Set;

import org.eclipse.net4j.channel.IChannel;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.util.collection.HashBag;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOUtil;

import de.uka.ipd.sdq.edp2.remote.Edp2TransferProtocol;

/**
 * @author groenda
 */
public class ListExperimentGroupsRequest extends
		RequestWithConfirmation<Set<String>> implements Edp2TransferProtocol {

	public ListExperimentGroupsRequest(IChannel channel) {
		super(channel);
	}

	@Override
	protected Set<String> confirming(ExtendedDataInputStream in) throws IOException {
		Set<String> returnSet = new HashBag<String>();
		int numberOfUuids = in.readInt();
		for (int i = 0; i < numberOfUuids; i++) {
			returnSet.add(ExtendedIOUtil.readString(in));
		}
		return returnSet;
	}

	@Override
	protected void requesting(ExtendedDataOutputStream out) throws IOException {
		// Do nothing
		out.writeBoolean(false);
	}

	@Override
	protected short getSignalID() {
		return Edp2TransferProtocol.LIST_EXPERIMENT_GROUPS_SIGNAL;
	}

}
