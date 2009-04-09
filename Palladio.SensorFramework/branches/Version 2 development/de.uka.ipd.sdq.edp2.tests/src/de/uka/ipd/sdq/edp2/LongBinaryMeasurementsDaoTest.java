/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

/**JUnit test for classes with LongBinaryMeasurementsDao interface.
 * Subclass and test for all different types of LongBinaryMeasurementsDao.
 * @author groenda
 */
@SuppressWarnings("unchecked")
public abstract class LongBinaryMeasurementsDaoTest extends Edp2DaoTest {
	/** Binary measurement DAO to test. */
	protected BinaryMeasurementsDao<Long> bmDao = (BinaryMeasurementsDao<Long>) dao;

	@Test (expected = IllegalStateException.class)
	public void testGetBinaryMeasurmentsOnlyIfOpen() {
		bmDao.getBinaryMeasurements();
	}
	
	@Test
	public void testGetBinaryMeasurements() throws DataNotAccessibleException {
		assertFalse("BinaryMeasurementsDao must have initial state of not-open.", bmDao.isOpen());
		assertFalse("BinaryMeasurementsDao must have initial state of not-deleted.", bmDao.isDeleted());
		
		bmDao.open();
		assertTrue("BinaryMeasurementsDao must be open after open().", bmDao.isOpen());
		assertFalse("BinaryMeasurementsDao.open() must not effect status of deletion.", bmDao.isDeleted());
		assertNotNull("BinaryMeasurementsDao must be not null if open.", bmDao.getBinaryMeasurements());
		
		bmDao.close();
		assertFalse("BinaryMeasurementsDao must be closed after close().", bmDao.isOpen());
		assertFalse("BinaryMeasurementsDao.open() must not effect status of deletion.", bmDao.isDeleted());
		
		bmDao.delete();
		assertFalse("BinaryMeasurementsDao.delete() must have no effect on status of open/closed.", bmDao.isOpen());
		assertTrue("BinaryMeasurementsDao must be deleted adter delete().", bmDao.isDeleted());
	}
	
	@Test
	public void testDataRetainedIfReopened() throws DataNotAccessibleException {
		bmDao.open();
		BinaryMeasurements<Long> bmd = bmDao.getBinaryMeasurements();
		long testValue = Long.MAX_VALUE;
		bmd.add(testValue);
		bmd = null;
		bmDao.close();
		bmDao.open();
		bmd = bmDao.getBinaryMeasurements();
	}
}
