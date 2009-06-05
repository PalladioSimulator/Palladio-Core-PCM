/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;

/**Unit test for the DaoFactory interface.
 * Reuse this class to test implementations of the DaoInterface.
 * @author groenda
 */
public abstract class DaoFactoryTest {
	/** the dao factory. Must be initialized in subclasses. */
	protected static DaoFactory daoFactory;
	/** uuid used for the individual dao.*/
	protected String uuid;

	@Before
	public void setUpBefore() {
		uuid = EcoreUtil.generateUUID();
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl#createDoubleMeasurementsDao(java.lang.String)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateDoubleMeasurementsDao() {
		BinaryMeasurementsDao<javax.measure.Measure> bmd = daoFactory.createDoubleMeasurementsDao(uuid);
		assertNotNull("CreateDoubleMeasurementsDao returned null object.", bmd);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl#createExperimentGroupDao(java.lang.String)}.
	 */
	@Test
	public void testCreateExperimentGroupDao() {
		ExperimentGroupDao egd = daoFactory.createExperimentGroupDao(uuid);
		assertNotNull("CreateExperimentGroupDao returned null object.", egd);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl#createJScienceXmlMeasurementsDao(java.lang.String)}.
	 */
	@Test
	public void testCreateJScienceXmlMeasurementsDao() {
		JScienceXmlMeasurementsDao jsxmd = daoFactory.createJScienceXmlMeasurementsDao(uuid);
		assertNotNull("CreateJScienceXmlMeasurementsDao returned null object.", jsxmd);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl#createLongMeasurementsDao(java.lang.String)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateLongMeasurementsDao() {
		BinaryMeasurementsDao<javax.measure.Measure> bmd = daoFactory.createLongMeasurementsDao(uuid);
		assertNotNull("CreateLongMeasurementsDao returned null object.", bmd);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl#createNominalMeasurementsDao(java.lang.String)}.
	 */
	@Test
	public void testCreateNominalMeasurementsDao() {
		NominalMeasurementsDao nmd = daoFactory.createNominalMeasurementsDao(uuid);
		assertNotNull("CreateNominalMeasurementsDao returned null object.", nmd);
	}

}
