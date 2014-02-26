/**
 * 
 */
package de.uka.ipd.sdq.edp2.storage.tests;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.local.file.LongSerializer;

/**Test the behavior of the LongSerializer.
 * @author groenda
 */
public class LongSerializerTest extends LongSerializer {
	/**Tests the serialization by saving, reloading and comparing elements.
	 * @throws IOException
	 */
	
	@Test
	public void testLongSerializer() throws IOException {
		File tempFile = File.createTempFile("TestDB", "lst");
		RandomAccessFile raf = new RandomAccessFile(tempFile.getAbsolutePath(),"rw");
		int count = 1000000;
		long[] d = new long[count];
		d[0] = Long.MIN_VALUE;
		d[1] = Long.MAX_VALUE;
		for (int i = 2; i < count; i++)
			d[i] =  (long) (Math.random()*100000.0);
		LongSerializer ds = new LongSerializer();
		byte[] bytes = ds.serialise(toLongArray(d),d.length);
		raf.write(bytes);
		raf.seek(0);
		raf.read(bytes);
		raf.close();
		Assert.assertTrue(bytes.length == ds.getElementLength() * count);
		Long[] longs = (Long[]) ds.deserialise(bytes);
		for (int i=0; i < count; i++)
			Assert.assertEquals(d[i], (long) longs[i]);
	}
	
	private Long[] toLongArray(long[] d){
		Long[] result = new Long[d.length];
		for (int i = 0; i < d.length; i++){
			result[i] = d[i];
		}
		return result;
	}
}
