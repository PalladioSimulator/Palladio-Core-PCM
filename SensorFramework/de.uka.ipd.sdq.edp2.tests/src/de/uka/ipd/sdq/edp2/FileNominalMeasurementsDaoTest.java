/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**JUnit test for file-backed NominalMeasurementsDao.
 * @author groenda
 */
public class FileNominalMeasurementsDaoTest extends NominalMeasurementsDaoTest {

	@Before
	public void setUpBefore() throws Exception {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		String uuid = EcoreUtil.generateUUID();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			df = factory.createFileDaoFactory(tempFile.getAbsoluteFile());
			assertNotNull("DaoFactory must not be null.", df);
			dao = onmDao = df.createNominalMeasurementsDao(uuid);
			assertNotNull("NominalMeasurementsDaoTest must not be null.", onmDao);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.NominalMeasurementsDaoTest#testNominalMeasurementsDataRetainedIfReopened()
	 */
	@Override
	public void testNominalMeasurementsDataRetainedIfReopened()
			throws DataNotAccessibleException, IOException {
		// EMF initialization
		ResourceSet resourceSet = onmDao.getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION,
						new EmfModelXMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION,
						new EmfModelXMIResourceFactoryImpl());
		File tempFileEg = File.createTempFile(NominalMeasurementsDaoTest.class
				.getName(), EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION);
		tempFileEg.deleteOnExit();
		// Build model
		EmfmodelFactory ef = EmfmodelFactoryImpl.eINSTANCE;
		String egUuid = EcoreUtil.generateUUID();
		ExperimentGroupDao egDao = df.createExperimentGroupDao(egUuid);
		egDao.open();
		ExperimentGroup eg = egDao.getExperimentGroup();
		NominalMeasure nm = ef.createNominalMeasure();
		CategoryIdentifier ci = ef.createCategoryIdentifier();
		ci.setStateLiteral("First Category");
		nm.getDefinedCategoryIdentifiers().add(ci);
		eg.getMeasure().add(nm);
		egDao.close();

		ObservedIdentifierBasedMeasurements onm;
		onmDao.open();
		onm = onmDao.getObservedIdentifierBasedMeasurements();
		ObservedCategory oc = ef.createObservedCategory();
		oc.setCategoryIdentifier(ci);
		onm.getObservedCategories().add(oc);
		onm = null;
		onmDao.close();
		onmDao.open();
		onm = onmDao.getNominalMeasurements();
		assertEquals("Size of ObservedNominalMeasurements must be 1.", 1, onm
				.getObservedCategories().size());
		assertEquals(
				"ObservedNominalMeasurements must point to the same CategoryIdentifier after saving.",
				ci.getUuid(), onm.getObservedCategories().get(0).getCategoryIdentifier().getUuid(),0.1);
		onmDao.close();
	}
}
