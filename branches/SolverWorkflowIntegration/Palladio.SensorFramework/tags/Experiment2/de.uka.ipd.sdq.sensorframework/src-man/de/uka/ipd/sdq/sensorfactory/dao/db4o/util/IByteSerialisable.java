package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface IByteSerialisable {
	void toBytes(DataOutputStream stream) throws IOException;
	void fromBytes(DataInputStream stream) throws IOException;
}
