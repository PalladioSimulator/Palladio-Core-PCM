package de.uka.ipd.sdq.sensorframework.storage.tests;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

import junit.framework.Assert;

import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.lists.DoubleSerialiser;


public class DoubleListTest {

	private static final int LARGE_LIST_TEST_COUNT = 1000000;

	@Test
	public void listTest() {
		BackgroundMemoryList<Double> list;
		try {
			new File("C:/temp/testlist2.lst").delete();
			list = new BackgroundMemoryList<Double>("C:/temp/testlist2.lst",
					new DoubleSerialiser());
			list.add(1.0);
			list.close();
			Assert.assertEquals(8, new File("C:/temp/testlist2.lst").length());
			
			list = new BackgroundMemoryList<Double>("C:/temp/testlist2.lst",
					new DoubleSerialiser());
			Assert.assertEquals(1,list.size());
			Assert.assertEquals(1.0, list.get(0));
			list.add(2.0);
			Assert.assertEquals(2,list.size());
			Assert.assertEquals(2.0, list.get(1));
			list.close();
			Assert.assertEquals(16, new File("C:/temp/testlist2.lst").length());
			
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void listTest2() {
		BackgroundMemoryList<Double> list;
		try {
			new File("C:/temp/testlist.lst").delete();
			list = new BackgroundMemoryList<Double>("C:/temp/testlist.lst",
					new DoubleSerialiser());
			for (double i = 0; i < LARGE_LIST_TEST_COUNT; i += 1)
				list.add(i);
			list.close();
			Assert.assertEquals(LARGE_LIST_TEST_COUNT * 8, new File("C:/temp/testlist.lst").length());
			
			list = new BackgroundMemoryList<Double>("C:/temp/testlist.lst",
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
