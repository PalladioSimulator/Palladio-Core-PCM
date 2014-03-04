package de.uka.ipd.sdq.edp2.storage.tests;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

import static org.junit.Assert.*;

import de.uka.ipd.sdq.edp2.local.file.DoubleSerializer;

/**Test the behavior of the DoubleSerializer.
 * @author Steffen Becker
 */
public class DoubleSerializerTest {
	
	/**Tests the serialization by saving, reloading and comparing elements.
	 * @throws IOException
	 */
	@Test
	public void testDoubleSerializer() throws IOException {
		File tempFile = File.createTempFile("TestDB", "lst");
		RandomAccessFile raf = new RandomAccessFile(tempFile.getAbsolutePath(),"rw");
		int count = 1000000;
		double[] d = new double[count];
		d[0] = Double.MAX_VALUE;
		d[1] = Double.MIN_VALUE;
		for (int i = 2; i < count; i++)
			d[i] = Math.random()*1000.0-500.0;
		DoubleSerializer ds = new DoubleSerializer();
		byte[] bytes = ds.serialise(toDoubleArray(d),d.length);
		raf.write(bytes);
		raf.seek(0);
		raf.read(bytes);
		raf.close();
		assertTrue(bytes.length == ds.getElementLength() * count);
		Double[] doubles = (Double[]) ds.deserialise(bytes);
		for (int i=0; i < count; i++)
			assertTrue(d[i] == doubles[i]);
	}
	
	private Double[] toDoubleArray(double[] d){
		Double[] result = new Double[d.length];
		for (int i = 0; i < d.length; i++){
			result[i] = d[i];
		}
		return result;
	}
	
}
