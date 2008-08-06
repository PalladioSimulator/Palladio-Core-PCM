package de.uka.ipd.sdq.sensorframework.storage.lists;

/**
 * @author Steffen Becker
 *
 */
public interface ISerialiser {

	long getElementLength();
	byte[] serialise(Object[] objects,int count);
	Object[] deserialise(byte[] bytes);	

}
