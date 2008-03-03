package de.uka.ipd.sdq.sensorframework.storage.lists;

public interface ISerialiser {

	long getElementLenght();
	byte[] serialise(Object[] objects,int count);
	Object[] deserialise(byte[] bytes);	

}
