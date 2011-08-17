package de.uka.ipd.sdq.simuservice.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

public class SampleModelLoaderHelper {

	public static final String REPOSITORYEXTENSION = "repository";
	public static final String SYSTEMEXTENSION = "system";
	public static final String RESOURCEENVIRONMENTEXTENSION = "resourceenvironment";
	public static final String ALLOCATIONEXTENSION = "allocation";
	public static final String USAGEEXTENSION = "usagemodel";

	/**
	 * Get the model files from the resources/models/ sub directory of the plug-in.
	 * @return Array of file objects that represent the models.
	 */
	public static File[] getSampleModelFiles()  {
		File model = new File("resources/models/");	
		File[] modelFiles = model.listFiles(new ModelMatcher());
		return modelFiles;
	}
	
	public static String getSampleModelXMI(final String extension) throws CoreException, FileNotFoundException, IOException {
		File file = null;
		for (File f : getSampleModelFiles()) {
			if (f.getName().endsWith(extension))
				file = f;
		}
		assertTrue("No sample model file exists with extension \"" + extension + "\"!", !(file == null));
		String s = readFileToString(file);
		assertTrue("Sample model file " + file.getAbsolutePath() + " is empty!", !s.equals(""));
		return s;
	}
	
	public static String getSampleModelFileName(final String extension) throws CoreException{
		File file = null;
		for (File f : getSampleModelFiles()) {
			if (f.getName().endsWith(extension))
				file = f;
		}		
		assertTrue("No sample model file exists with extension \"" + extension + "\"!", !(file == null));
		return file.getName();
	}
	
	private static class ModelMatcher implements FilenameFilter {
		public boolean accept(File arg0, String arg1) {
			if (arg1.endsWith("allocation") 
					|| arg1.endsWith("usagemodel") 
					|| arg1.endsWith("system")
					|| arg1.endsWith("repository")
					|| arg1.endsWith("resourceenvironment"))					
				return true; 
			else 
				return false;
		}
	}

	private static String readFileToString(File file) throws java.io.IOException{
	    byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
	    stream.read(buffer);
	    return new String(buffer);
	}
}
