/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;

import de.uka.ipd.sdq.edp2.DoubleBinaryMeasurementsDaoTest;

/**JUnit test for file-backed DoubleBinaryMeasurementsDao.
 * @author groenda
 */
public class FileDoubleBinaryMeasurementsDaoTest extends
		DoubleBinaryMeasurementsDaoTest {
	
	@Before
	public void setUpBefore() throws Exception {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		String uuid = EcoreUtil.generateUUID();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			df = new LocalDirectoryMeasurementsDaoFactory(tempFile.getAbsoluteFile()); 
			assertNotNull("DaoFactory must not be null.", df);
			dao = bmDao = df.createDoubleMeasurementsDao(uuid);
			assertNotNull("DoubleBinaryMeasurementsDao must not be null.", bmDao);
		}
	}

}
