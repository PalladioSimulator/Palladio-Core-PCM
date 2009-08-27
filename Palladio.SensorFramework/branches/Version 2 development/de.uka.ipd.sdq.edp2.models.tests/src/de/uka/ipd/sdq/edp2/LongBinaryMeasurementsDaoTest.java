/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertEquals;

import javax.measure.Measure;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

/**JUnit test for classes with LongBinaryMeasurementsDao interface.
 * Subclass and test for all different types of LongBinaryMeasurementsDao.
 * @author groenda
 */
@SuppressWarnings("unchecked")
public abstract class LongBinaryMeasurementsDaoTest extends BinaryMeasurementsDaoTest {

	@Test
	public void testDataRetainedIfReopened() throws DataNotAccessibleException {
		bmDao.setUnit(unit);
		bmDao.open();
		BinaryMeasurements<Measure> bmd = bmDao.getBinaryMeasurements();
		long testValue = Long.MAX_VALUE;
		bmd.add(Measure.valueOf(testValue, unit));
		bmd = null;
		bmDao.close();
		bmDao.open();
		bmd = bmDao.getBinaryMeasurements();
		assertEquals("Test data must be retained if DAO is reopened.", testValue, bmd.get(0).longValue(unit));
	}
}
