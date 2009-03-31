/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;

import de.uka.ipd.sdq.edp2.file.impl.EmfModelXMIResourceFactoryImpl;
import de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelFactoryImpl;

/**
 * @author groenda
 *
 */
public class FileNominalMeasurementsDaoTest extends NominalMeasurementsDaoTest {

	@Before
	public void setUpBefore() throws Exception {
		File tempFile = File.createTempFile("delete", "me");
		tempFile.delete();
		String uuid = EcoreUtil.generateUUID();
		if (tempFile.mkdir() == true) {
			tempFile.deleteOnExit();
			df = Edp2Factory.createFileDaoFactory(tempFile.getAbsoluteFile());
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
		File tempFile = null;
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK,
						new EmfModelXMIResourceFactoryImpl());
		tempFile = File.createTempFile(NominalMeasurementsDaoTest.class
				.getName()
				+ "_", "."
				+ EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK);
		tempFile.deleteOnExit();
		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());
		// Build model
		EmfmodelFactory ef = EmfmodelFactoryImpl.eINSTANCE;
		CategoryIdentifier ci = ef.createCategoryIdentifier();
		ci.setStateLiteral("First Category");
		// Serialize
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(ci);
		resource.save(Collections.EMPTY_MAP);

		ObservedNominalMeasurements onm;
		onmDao.open();
		onm = onmDao.getNominalMeasurements();
		onm.getObservedCategories().add(ci);
		onm = null;
		onmDao.close();
		onmDao.open();
		onm = onmDao.getNominalMeasurements();
		assertEquals("Size of ObservedNominalMeasurements must be 1.", 1, onm
				.getObservedCategories().size());
		assertEquals(
				"ObservedNominalMeasurements must point to the same CategoryIdentifier after saving.",
				ci, onm.getObservedCategories().get(0));
		onmDao.close();
	}
}
