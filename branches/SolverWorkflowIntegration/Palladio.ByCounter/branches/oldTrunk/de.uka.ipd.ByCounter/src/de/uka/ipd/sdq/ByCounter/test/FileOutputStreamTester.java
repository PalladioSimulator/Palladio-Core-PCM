package de.uka.ipd.sdq.ByCounter.test;

import java.io.FileOutputStream;

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
