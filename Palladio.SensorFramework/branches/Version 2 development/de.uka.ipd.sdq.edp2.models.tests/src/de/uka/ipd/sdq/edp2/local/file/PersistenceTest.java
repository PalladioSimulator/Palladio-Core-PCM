package de.uka.ipd.sdq.edp2.local.file;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.BeforeClass;

import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**Abstract class which provides helper methods to classes testing persistence.
 * @author groenda
 */
public abstract class PersistenceTest {
	protected final static EmfmodelFactory EmfModelFactory = EmfmodelFactory.eINSTANCE;
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	protected static File tempFile = null;
	/** File extension used to store file. Not correct wrt to EDP2 definitions but works for testing.*/
	protected static String testedExtensionType = EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION;

	@BeforeClass
	public static void prepareEmf() {
		// Register the default resource factory -- only needed for stand-alone!
		// With SetUUID==true; uuid is identifiable element id (if applicable)
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(testedExtensionType,
						new EmfModelXMIResourceFactoryImpl());
//		// With SetUUID==false
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
//		.put(SensorFrameworkXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK,
//				new XMIResourceFactoryImpl());

		// Register the package -- only needed for stand-alone!
		@SuppressWarnings("unused")
		EmfmodelPackage sp = EmfmodelPackage.eINSTANCE;
	}

	@Before
	public void initializeEnvironment() throws IOException {
		tempFile = File.createTempFile(PersistenceTest.class.getName() 
				+ "_", "." + testedExtensionType);
		tempFile.deleteOnExit();
	}
	
	protected void serialize(ExperimentGroup eg) throws IOException {
		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		// Add the book and writer objects to the contents.
		resource.getContents().add(eg);

		// Save the contents of the resource to the file system.
		resource.save(Collections.EMPTY_MAP);
	}

	protected ExperimentGroup deserialize() {
		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());

		// Demand load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);

		ExperimentGroup eg = (ExperimentGroup) resource.getContents().get(0);
		return eg;
	}
}
