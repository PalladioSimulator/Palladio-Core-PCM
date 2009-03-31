/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;

/**
 * @author groenda
 *
 */
public class FileDaoFactoryTest extends DaoFactoryTest {

	/**
	 * @throws IOException Error if file could not be accessed.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			daoFactory = Edp2Factory.createFileDaoFactory(tempFile.getAbsoluteFile());
			assertNotNull("DaoFactory must not be null.", daoFactory);
		}
	}
	

}
