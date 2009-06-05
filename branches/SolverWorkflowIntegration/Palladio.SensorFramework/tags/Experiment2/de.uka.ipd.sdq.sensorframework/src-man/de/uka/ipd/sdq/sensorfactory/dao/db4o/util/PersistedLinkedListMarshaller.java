package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import com.db4o.config.ObjectMarshaller;
import com.db4o.foundation.PrimitiveCodec;

public class PersistedLinkedListMarshaller implements ObjectMarshaller {

	public int marshalledFieldLength() {
		return PrimitiveCodec.LONG_LENGTH*2;
	}

	public void readFields(Object obj, byte[] slot, int offset) {
		MyList list = (MyList) obj;
		list.setHeadID(PrimitiveCodec.readLong(slot, offset));
		offset+= PrimitiveCodec.LONG_LENGTH;		
		list.setLast(PrimitiveCodec.readLong(slot, offset));
		offset+= PrimitiveCodec.LONG_LENGTH;		
	}

	public void writeFields(Object obj, byte[] slot, int offset) {
		MyList list = (MyList) obj;
		list.flushList();
		PrimitiveCodec.writeLong(slot, offset, list.getHeadID());
		offset+= PrimitiveCodec.LONG_LENGTH;		
		PrimitiveCodec.writeLong(slot, offset, list.getLastID());
		offset+= PrimitiveCodec.LONG_LENGTH;		
	}

}
