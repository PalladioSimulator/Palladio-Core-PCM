/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**Test for classes implementing {@link MetaDao}
 * @author groenda
 *
 */
public abstract class MetaDaoTest extends Edp2DaoTest {
	/** DAO under test. */
	protected MetaDao metaDao; 

	@Test
	public void getMeasurementsDaoFactoryTest() throws DataNotAccessibleException {
		Assert.assertNull("Measurement factory must be null after initialization.", metaDao.getMeasurementsDaoFactory());
		metaDao.open();
		Assert.assertNotNull("Measurement factory must not be null after open.", metaDao.getMeasurementsDaoFactory());
		Assert.assertTrue("Measurement factory must active after open.", metaDao.getMeasurementsDaoFactory().isActive());
		metaDao.close();
		Assert.assertFalse("Measurement factory must be inactive after close.", metaDao.getMeasurementsDaoFactory().isActive());
	}
	
	@Test (expected = IllegalStateException.class)
	public void getMeasurementsDaoFactoryDisabledAfterCloseTest() throws DataNotAccessibleException {
		metaDao.open();
		MeasurementsDaoFactory factory = metaDao.getMeasurementsDaoFactory();
		metaDao.close();
		factory.createDoubleMeasurementsDao(EcoreUtil.generateUUID());
	}
}
