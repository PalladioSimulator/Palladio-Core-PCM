/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactoryTest;
import de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMeasurementsDaoFactory;

/**Tests the {@link LocalDirectoryMeasurementsDaoFactory}.
 * @author groenda
 */
public class LocalDirectoryMeasurementsDaoFactoryTest extends MeasurementsDaoFactoryTest {

	/**
	 * @throws IOException Error if file could not be accessed.
	 */
	@Before
	public void setUpDaoFactory() throws IOException {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			daoFactory = new LocalDirectoryMeasurementsDaoFactory(tempFile.getAbsoluteFile()); 
			assertNotNull("DaoFactory must not be null.", daoFactory);
		}
	}
	

}
