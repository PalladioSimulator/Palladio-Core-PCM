package de.uka.ipd.sdq.ByCounter.test;

import java.io.FileOutputStream;

/**
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class FileOutputStreamTester {
	public int doKenntErAlsKeyword(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./test.txt");
			fos.write(1);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return 1;
	}
}
