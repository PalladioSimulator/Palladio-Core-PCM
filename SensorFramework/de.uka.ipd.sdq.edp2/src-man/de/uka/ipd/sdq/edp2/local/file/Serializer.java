package de.uka.ipd.sdq.edp2.local.file;

/**
 * Interface used by the BackgroundMemoryList to serialise the elements of the list into bytestreams 
 * and vice versa. The elements serialised form has to have a constant memory footprint. Otherwise using the 
 * BackgroundMemoryList will not work as it relies on the constant sizes to seek in the background storage and
 * calculate the number of elements. 
 * @author Steffen Becker
 */
public interface Serializer<T> {

	/** 
	 * @return The size of each element in serialised form, e.g., for doubles it could be 8 bytes (IEEE format). 
	 * The result is not allowed to change at runtime
	 */
	long getElementLength();
	
	/** Convert the given array of elements into their serialised form. Attention:
	 * Due to a flaw in Java Generics, this signature cannot be serialise(T[] objects, int count) as
	 * this leads to a class cast exception despite the fact that you pass the right array. We kept the
	 * Type parameter to get at least a type save deserialise.
	 * @param objects The array of elements to serialise
	 * @param count The number of elements to serialise
	 * @return The elements in their serialised form
	 */
	byte[] serialise(Object[] objects, int count);
	
	
	/** Convert a serialised form into an array of elements of the serialiser's type
	 * @param bytes The byte array to deserialise
	 * @return An array of elements deserialised from the given byte array
	 */
	T[] deserialise(byte[] bytes);	

}
