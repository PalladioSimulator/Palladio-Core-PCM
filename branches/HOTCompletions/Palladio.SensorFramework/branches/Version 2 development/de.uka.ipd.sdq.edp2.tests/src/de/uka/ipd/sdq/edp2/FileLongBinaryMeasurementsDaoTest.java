/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;

/**JUnit test for file-backed LongBinaryMeasurementsDao.
 * @author groenda
 */
public class FileLongBinaryMeasurementsDaoTest extends
		LongBinaryMeasurementsDaoTest {
	@SuppressWarnings("unchecked")
	@Before
	public void setUpBefore() throws Exception {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		String uuid = EcoreUtil.generateUUID();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			df = factory.createFileDaoFactory(tempFile.getAbsoluteFile());
			assertNotNull("DaoFactory must not be null.", df);
			dao = bmDao = df.createLongMeasurementsDao(uuid);
			bmDao.setUnit(unit);
			assertNotNull("LongBinaryMeasurementsDao must not be null.", bmDao);
		}
	}
}
