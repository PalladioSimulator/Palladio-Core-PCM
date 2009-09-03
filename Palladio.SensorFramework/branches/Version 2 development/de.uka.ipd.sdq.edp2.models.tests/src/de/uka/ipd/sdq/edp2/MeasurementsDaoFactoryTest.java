/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertNotNull;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.JScienceXmlMeasurementsDao;

/**Unit test for the DaoFactory interface.
 * Reuse this class to test implementations of the DaoInterface.
 * @author groenda
 */
public abstract class MeasurementsDaoFactoryTest {
	/** The DAO factory used for testing. Must be initialized in subclasses. */
	protected static MeasurementsDaoFactory daoFactory;
	
	/** UUID used for the individual DAO.*/
	protected String uuid;

	@Before
	public void setUpUuid() {
		uuid = EcoreUtil.generateUUID();
	}
	
	@Test
	public void testInitialState() {
		Assert.assertEquals("Initial state must be active.", true, daoFactory.isActive());
		Assert.assertNotNull("DAO factory must not be null.", daoFactory.getDaoRegistry());
	}

	@Test(expected=IllegalStateException.class)
	public void testSetActiveIfIsActive() {
		Assert.assertEquals("Initial state must be active.", true, daoFactory.isActive());
		daoFactory.setActive(true);
	}
	
	@Test
	public void testSetActiveFalse() throws DataNotAccessibleException {
		// create DAOs of all types to check if they are closed on setActive(false)
		MeasurementsDao[] daos = new MeasurementsDao[8]; 
		daos[0] = daoFactory.createDoubleMeasurementsDao(EcoreUtil.generateUUID());
		daos[1] = daoFactory.createDoubleMeasurementsDao(EcoreUtil.generateUUID());
		daos[1].open();
		daos[2] = daoFactory.createJScienceXmlMeasurementsDao(EcoreUtil.generateUUID());
		daos[3] = daoFactory.createJScienceXmlMeasurementsDao(EcoreUtil.generateUUID());
		daos[3].open();
		daos[4] = daoFactory.createLongMeasurementsDao(EcoreUtil.generateUUID());
		daos[5] = daoFactory.createLongMeasurementsDao(EcoreUtil.generateUUID());
		daos[5].open();
		daos[6] = daoFactory.createNominalMeasurementsDao(EcoreUtil.generateUUID());
		daos[7] = daoFactory.createNominalMeasurementsDao(EcoreUtil.generateUUID());
		daos[7].open();
		Assert.assertEquals("Initial state must be active.", true, daoFactory.isActive());
		daoFactory.setActive(false);
		Assert.assertEquals("Initial state must be active.", false, daoFactory.isActive());
		for (MeasurementsDao dao : daos) {
			Assert
					.assertEquals(
							"Generated DAOs must be closed after state has been changed to inactive.",
							false, dao.isOpen());
		}
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCreateDoubleMeasurementsDaoAfterSetActiveFalse() {
		daoFactory.setActive(false);
		daoFactory.createDoubleMeasurementsDao(uuid);
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMeasurementsDaoFactory#createDoubleMeasurementsDao(java.lang.String)}.
	 * @throws DataNotAccessibleException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateDoubleMeasurementsDao() throws DataNotAccessibleException {
		BinaryMeasurementsDao<javax.measure.Measure> bmd = daoFactory.createDoubleMeasurementsDao(uuid);
		assertNotNull("CreateDoubleMeasurementsDao returned null object.", bmd);
	}

	@Test(expected=IllegalStateException.class)
	public void testCreateJScienceXmlMeasurementsDaoAfterSetActiveFalse() {
		daoFactory.setActive(false);
		daoFactory.createJScienceXmlMeasurementsDao(uuid);
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMeasurementsDaoFactory#createJScienceXmlMeasurementsDao(java.lang.String)}.
	 * @throws DataNotAccessibleException 
	 */
	@Test
	public void testCreateJScienceXmlMeasurementsDao() throws DataNotAccessibleException {
		JScienceXmlMeasurementsDao jsxmd = daoFactory.createJScienceXmlMeasurementsDao(uuid);
		assertNotNull("CreateJScienceXmlMeasurementsDao returned null object.", jsxmd);
	}

	@Test(expected=IllegalStateException.class)
	public void testCreateLongMeasurementsDaoAfterSetActiveFalse() {
		daoFactory.setActive(false);
		daoFactory.createLongMeasurementsDao(uuid);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMeasurementsDaoFactory#createLongMeasurementsDao(java.lang.String)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateLongMeasurementsDao() {
		BinaryMeasurementsDao<javax.measure.Measure> bmd = daoFactory.createLongMeasurementsDao(uuid);
		assertNotNull("CreateLongMeasurementsDao returned null object.", bmd);
	}

	@Test(expected=IllegalStateException.class)
	public void testCreateNominalMeasurementsDaoAfterSetActiveFalse() {
		daoFactory.setActive(false);
		daoFactory.createNominalMeasurementsDao(uuid);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMeasurementsDaoFactory#createNominalMeasurementsDao(java.lang.String)}.
	 */
	@Test
	public void testCreateNominalMeasurementsDao() {
		NominalMeasurementsDao nmd = daoFactory.createNominalMeasurementsDao(uuid);
		assertNotNull("CreateNominalMeasurementsDao returned null object.", nmd);
	}

}
