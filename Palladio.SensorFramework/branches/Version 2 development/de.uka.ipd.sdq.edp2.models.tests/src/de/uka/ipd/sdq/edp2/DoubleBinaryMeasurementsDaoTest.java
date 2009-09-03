/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.List;

import javax.measure.Measure;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**JUnit test for classes with DoubleBinaryMeasurementsDao interface.
 * Subclass and test for all different types of DoubleBinaryMeasurementsDao.
 * @author groenda
 */
@SuppressWarnings("unchecked")
public abstract class DoubleBinaryMeasurementsDaoTest extends BinaryMeasurementsDaoTest {

	@Test
	public void testDataRetainedIfReopened() throws DataNotAccessibleException {
		bmDao.setUnit(unit);
		bmDao.open();
		List<Measure> bmd = bmDao.getMeasurements();
		double testValue = 5.0132;
		bmd.add(Measure.valueOf(testValue, unit));
		bmd = null;
		bmDao.close();
		bmDao.open();
		Assert.assertEquals("Unit must be retained if DAO is reopened.", unit, bmDao.getUnit());
		bmd = bmDao.getMeasurements();
		Assert.assertEquals("Test data must be retained if DAO is reopened.", testValue, bmd.get(0).doubleValue(unit));
	}
}
