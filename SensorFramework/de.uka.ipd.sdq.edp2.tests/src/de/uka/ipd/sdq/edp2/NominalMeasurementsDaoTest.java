/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**JUnit test for classes with NominalMeasurementsDao interface.
 * Subclass and test for all different types of NominalMeasurementsDaos.
 * @author groenda
 */
public abstract class NominalMeasurementsDaoTest extends Edp2DaoTest {
	/** The ExperimentGroupDao under test. */
	protected NominalMeasurementsDao onmDao = (NominalMeasurementsDao) dao;

	@Test (expected = IllegalStateException.class)
	public void testGetNominalMeasurementsOnlyIfOpen() {
		onmDao.getObservedIdentifierBasedMeasurements();
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileExperimentGroupDaoImpl#getExperimentGroup()}.
	 * @throws DataNotAccessibleException Error while accessing the file.
	 */
	@Test
	public void testGetNominalMeasurements() throws DataNotAccessibleException {
		assertFalse("NominalMeasurementsDao must have initial state of not-open.", onmDao.isOpen());
		assertFalse("NominalMeasurementsDao must have initial state of not-deleted.", onmDao.isDeleted());
		
		onmDao.open();
		assertTrue("NominalMeasurementsDao must be open after open().", onmDao.isOpen());
		assertFalse("NominalMeasurementsDao.open() must not effect status of deletion.", onmDao.isDeleted());
		assertNotNull("NominalMeasurementsDao must be not null if open.", onmDao.getObservedIdentifierBasedMeasurements());
		
		onmDao.close();
		assertFalse("NominalMeasurementsDao must be closed after close().", onmDao.isOpen());
		assertFalse("NominalMeasurementsDao.open() must not effect status of deletion.", onmDao.isDeleted());
		
		onmDao.delete();
		assertFalse("NominalMeasurementsDao.delete() must have no effect on status of open/closed.", onmDao.isOpen());
		assertTrue("NominalMeasurementsDao must be deleted adter delete().", onmDao.isDeleted());
	}
		
	/**Abstract due to the fact that other EMF models are referenced and the test should be kept simple.
	 * @throws DataNotAccessibleException
	 * @throws IOException
	 */
	@Test
	public abstract void testNominalMeasurementsDataRetainedIfReopened() throws DataNotAccessibleException, IOException; 
	
	/**Test the storing of EMF resource set.
	 */
	@Test
	public void testResourceSet() {
		assertNotNull("Resource set must not be null if initalized.", onmDao.getResourceSet());
	}
}
