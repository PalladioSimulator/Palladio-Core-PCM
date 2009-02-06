package de.uka.ipd.sdq.sensorframework.storage.tests;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

import junit.framework.Assert;
import de.uka.ipd.sdq.sensorframework.file.impl.DoubleSerialiser;

/**Test the behavior of the DoubleSerialiser.
 * @author Steffen Becker
 */
public class DoubleSerialiserTest {
	
	/**Tests the serialization by saving, reloading and comparing elements.
	 * @throws IOException
	 */
	@Test
	public void testDoubleSerialiser() throws IOException {
		File tempFile = File.createTempFile("TestDB", "lst");
		RandomAccessFile raf = new RandomAccessFile(tempFile.getAbsolutePath(),"rw");
		int count = 1000000;
		double[] d = new double[count];
		for (int i = 0; i < count; i++)
			d[i] = Math.random()*1000.0-500.0;
		DoubleSerialiser ds = new DoubleSerialiser();
		byte[] bytes = ds.serialise(toDoubleArray(d),d.length);
		raf.write(bytes);
		raf.seek(0);
		raf.read(bytes);
		raf.close();
		Assert.assertTrue(bytes.length == ds.getElementLength() * count);
		Double[] doubles = (Double[]) ds.deserialise(bytes);
		for (int i=0; i < count; i++)
			Assert.assertEquals(d[i],doubles[i]);
	}
	
	private Double[] toDoubleArray(double[] d){
		Double[] result = new Double[d.length];
		for (int i = 0; i < d.length; i++){
			result[i] = d[i];
		}
		return result;
	}
	
}
