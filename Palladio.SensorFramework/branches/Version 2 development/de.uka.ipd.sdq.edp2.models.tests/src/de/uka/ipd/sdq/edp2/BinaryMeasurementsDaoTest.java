/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import javax.measure.Measure;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDaoImpl;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**
 * @author groenda
 *
 */
public abstract class BinaryMeasurementsDaoTest extends MeasurementsDaoTest {
	
	/** Binary measurement DAO to test. */
	@SuppressWarnings("unchecked")
	protected BinaryMeasurementsDaoImpl<Measure> bmDao = (BinaryMeasurementsDaoImpl<Measure>) dao;
	@SuppressWarnings("unchecked")
	protected Unit unit = SI.SECOND;

	@Test (expected = IllegalStateException.class)
	public void testGetBinaryMeasurmentsOnlyIfOpen() {
		bmDao.getBinaryMeasurements();
	}
	
	@Test (expected = IllegalStateException.class)
	public void testOpenOnlyIfUnitSet() throws DataNotAccessibleException {
		bmDao.open();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void testLifeCycleOpen(Edp2Dao dao)
			throws DataNotAccessibleException {
		if (bmDao.getUnit()==null) {
			bmDao.setUnit(unit);
		}
		super.testLifeCycleOpen(dao);
	}
}
