package de.uka.ipd.sdq.sensorframework.storage.tests;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.lists.DoubleSerialiser;


/**Tests the behavior of the BackgroundMemoryList and DoubleSerialiser.
 * @author Henning Groenda
 */
public class DoubleBackgroundMemoryListTest {

	private static final int LARGE_NUMBER_OF_ELEMENTS = 1000000;
	
	/** Temporary file used to serialize data. */
	private static File tempFile = null;
	/** The used serializer. */
	private static DoubleSerialiser doubleSerializer = new DoubleSerialiser();
	/** The used background list. */
	private static BackgroundMemoryList<Double> list;

	@Before
	public void initializeEnvironment() throws IOException {
		tempFile = File.createTempFile(DoubleBackgroundMemoryListTest.class.getName() + "_", ".tst");
		tempFile.deleteOnExit();
	}
	
	/**Checks if a single value can be serialized and deserialized successfully.
	 * @throws IOException
	 */
	@Test
	public void basicDeserialization() throws IOException {
		// Check list instance serialization size
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				doubleSerializer);
		Assert.assertEquals("File length of empty lists should be 0.", 0, tempFile.length());
		Assert.assertEquals("Size of empty array should be 0.", 0, list.size());
		list.add(1.0);
		Assert.assertEquals("Size of single element array should be 1.", 1, list.size());
		list.close();
		Assert.assertEquals("File length after storing and closing is the expected " +
				"product of object serialization size and number of data elements.", 
				doubleSerializer.getElementLength(), tempFile.length());
		
		// check if deserialization works with another instance
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		Assert.assertEquals("Deserilized test list must contain one element.", 1, list.size());
		Assert.assertEquals("Value before and after serialization must be the same.", 1.0, list.get(0));
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSizeMinusOne() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				doubleSerializer);
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE - 1, 0);
		list.close();
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSize() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				doubleSerializer);
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE, 0);
		list.close();
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSizePlusOne() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				doubleSerializer);
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE + 1, 0);
		list.close();
	}
	
	/**Creates the specified number of elements in the list, closes it, and checks if values are the same.
	 * Asserts correct file size.
	 * @param numberElements Number of data elements to create.
	 * @param valueOffset Offset to add on the values stored.
	 * @throws IOException
	 */
	public void basicDeserializationChunkSize(long numberElements, int valueOffset) throws IOException {
		long oldListSize = list.size();
		
		// create and serialize elements
		for (double i = 0; i < numberElements; i++) {
			list.add(i + 1 + valueOffset);
		}
		list.close();
		Assert.assertEquals("File length after storing and closing is expected to be the " +
				"product of object serialization size and number of data elements.", 
				doubleSerializer.getElementLength() * (numberElements + oldListSize), tempFile.length());

		// check if deserialization works with another instance
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		Assert.assertEquals("Deserialized test list must contain " + (numberElements + oldListSize) + " element(s).", 
				numberElements + oldListSize, list.size());
		for (double i = 0; i < numberElements; i++) {
			Assert.assertEquals("Value(s) before and after serialization must be the same.", 
					i + 1 + valueOffset, list.get((int) (oldListSize + i)));
		}
	}
	
	/**Checks the behavior for large number of elements.
	 * @throws IOException
	 */
	@Test
	public void largeNumberOfElements() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				doubleSerializer);
		basicDeserializationChunkSize(LARGE_NUMBER_OF_ELEMENTS, 0);
		list.close();
	}

	/**Checks if repetitive writing is possible. Also checks if there are errors when
	 * writing if all chunks are full.
	 * @throws IOException
	 */
	@Test
	public void repetitiveWriting() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE, 0);
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE - 1, 
				2 * BackgroundMemoryList.DEFAULT_CHUNK_SIZE);
		basicDeserializationChunkSize(BackgroundMemoryList.DEFAULT_CHUNK_SIZE + 2,
				4 * BackgroundMemoryList.DEFAULT_CHUNK_SIZE);
		list.close();
	}
	
	/**Checks if an exception is throw if null Objects are added to the list.
	 * @throws IOException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void nullElementException() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.add(null);
		list.close();
	}
	
	/**Checks if empty lists are serialized and deserialized correctly.
	 * @throws IOException
	 */
	@Test
	public void noElementsInList() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		Assert.assertEquals("Size of empty list is not 0.", list.size(), 0);
		list.close();
		Assert.assertEquals("File size of empty list is not 0.", tempFile.length(), 0);
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		Assert.assertEquals("Size of empty list after deserialization is not 0.", list.size(), 0);
		list.close();
	}
	
	@Test(expected=IllegalStateException.class)
	public void noAddAfterClose() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.close();
		list.add(1.0);
	}

	@Test(expected=IllegalStateException.class)
	public void noGetAfterClose() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.close();
		list.get(1);
	}
	
	@Test(expected=IllegalStateException.class)
	public void noCloseAfterClose() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.close();
		list.close();
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void onlyPositiveIndices() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.get(-1);
		list.close();
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void keepIndicesWithinExistingElements() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		list.add(1.1);
		list.get(1);
		list.get(2);
		list.close();
	}
	
	/**Checks if the same file can be read correctly using different chunk sizes.
	 * @throws IOException
	 */
	@Test
	public void differentChunkSizes() throws IOException {
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser());
		long numberElements = BackgroundMemoryList.DEFAULT_CHUNK_SIZE + 2;
		// create and serialize elements
		for (double i = 0; i < numberElements; i++) {
			list.add(i + 1);
		}
		list.close();
		list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
				new DoubleSerialiser(), BackgroundMemoryList.DEFAULT_CHUNK_SIZE / 4);
		Assert.assertEquals("Deserialized test list must contain " + numberElements + " element(s).", 
				numberElements, list.size());
		for (double i = 0; i < numberElements; i++) {
			Assert.assertEquals("Value(s) before and after serialization must be the same.", 
					i + 1, list.get((int) i));
		}
		list.close();
	}
}
