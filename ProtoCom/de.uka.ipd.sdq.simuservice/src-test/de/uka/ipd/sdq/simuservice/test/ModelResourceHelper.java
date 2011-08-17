package de.uka.ipd.sdq.simuservice.test;

import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

public class ModelResourceHelper {

	public StringWriter writeToString() throws Exception {
		File[] modelFiles = SampleModelLoaderHelper.getSampleModelFiles();
		StringWriter writer = new StringWriter();
		for (File f : modelFiles) {
			FileReader reader = new FileReader(f);
			char[] chars = new char[1024];
			int i = reader.read(chars);
			while (i > -1) {
				writer.write(chars);
				i = reader.read(chars);
			}
		}
		return writer;
	}

	public StringWriter writeToString(String path) throws Exception {
		StringWriter writer = new StringWriter();
		FileReader reader = new FileReader(new File(path));
		char[] chars = new char[1024];
		int i = reader.read(chars);
		while (i > -1) {
			writer.write(chars);
			i = reader.read(chars);
		}
		return writer;
	}
}
