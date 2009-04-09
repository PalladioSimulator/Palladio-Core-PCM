/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;


/**JUnit test for file-backed ExperimentGroupDao.
 * @author groenda
 */
public class FileExperimentGroupDaoTest extends ExperimentGroupDaoTest {
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBefore() throws Exception {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		String uuid = EcoreUtil.generateUUID();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			df = factory.createFileDaoFactory(tempFile.getAbsoluteFile());
			assertNotNull("DaoFactory must not be null.", df);
			dao = egd = df.createExperimentGroupDao(uuid);
			assertNotNull("ExperimentGroupDao must not be null.", egd);
		}
	}
}
