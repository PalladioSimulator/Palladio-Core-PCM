package de.uka.ipd.sdq.measurements.driver.os;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChildProcessFileLog implements Runnable {

	InputStream stream;
	FileOutputStream outputStream;
	boolean writeToFile = false;
	public ChildProcessFileLog(InputStream stream, String filename) {
		this.stream = stream;
		if (filename != null) {
			writeToFile = true;
			File file = new File(filename);
			try {
				file.createNewFile();
				outputStream = new FileOutputStream(filename);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void run() {
		int c = 0;
		if (writeToFile) {
			while (c!= -1) {
				try {
					
					c = stream.read();
					if (c!=-1) {
						outputStream.write(c);
						outputStream.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			while (c!= -1) {
				try {
					c = stream.read();					
				} catch (IOException e) {

				}
			}	
		}
	}

}