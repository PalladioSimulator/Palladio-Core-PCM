package de.uka.ipd.sdq.sensorframework.storage.tests;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.lists.DoubleSerialiser;


public class DoubleListTest extends TestCase {

	private static final int LARGE_LIST_TEST_COUNT = 1000000;

	public void testList() {
		BackgroundMemoryList<Double> list;
		try {
			File tempFile = File.createTempFile("TempDB", "lst");
			list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
					new DoubleSerialiser());
			list.add(1.0);
			list.close();
			Assert.assertEquals(8, tempFile.length());
			
			list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
					new DoubleSerialiser());
			Assert.assertEquals(1,list.size());
			Assert.assertEquals(1.0, list.get(0));
			list.add(2.0);
			Assert.assertEquals(2,list.size());
			Assert.assertEquals(2.0, list.get(1));
			list.close();
			Assert.assertEquals(16, tempFile.length());
			
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	public void testList2() {
		BackgroundMemoryList<Double> list;
		try {
			File tempFile = File.createTempFile("TempDB", "lst");
			list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
					new DoubleSerialiser());
			for (double i = 0; i < LARGE_LIST_TEST_COUNT; i += 1)
				list.add(i);
			list.close();
			Assert.assertEquals(LARGE_LIST_TEST_COUNT * 8, tempFile.length());
			
			list = new BackgroundMemoryList<Double>(tempFile.getAbsolutePath(),
					new DoubleSerialiser());
			for (double i = 0; i < LARGE_LIST_TEST_COUNT; i += 1)
				Assert.assertEquals(i,list.get((int)i));
			list.close();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
}
