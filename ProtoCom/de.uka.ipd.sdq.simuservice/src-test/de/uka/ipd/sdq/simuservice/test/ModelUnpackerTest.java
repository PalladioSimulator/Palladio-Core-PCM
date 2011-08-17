/**
 * 
 */
package de.uka.ipd.sdq.simuservice.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author kuester
 *
 */
public class ModelUnpackerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testUnpacker() throws Exception {
		ModelResourceHelper helper = new ModelResourceHelper();
		
		StringWriter writer = helper.writeToString();
		storeTo(writer.getBuffer().toString());
		System.out.print(writer.getBuffer().toString());
	}
	
	public void storeTo(String contents) throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("TestModelProject");
		IFolder modelsFolder = project.getFolder("models");
		if (!modelsFolder.exists()) modelsFolder.create(true, true, null);
		
		writeToFile(modelsFolder.getRawLocation().toFile().toString(), contents);
	}
	
	public File writeToFile(String path, String contents) throws Exception {
		File f = new File(path + System.getProperty("file.separator") + "modell.xmi");
		assert (!f.exists());
		FileOutputStream writer = new FileOutputStream(f);
		writer.write(contents.getBytes());
		writer.close();
		return f;
	}
	
}
