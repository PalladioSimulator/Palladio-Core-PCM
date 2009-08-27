/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryFactory;

/**Test {@link LocalDirectoryRepository} classes/elements.
 * @author groenda
 *
 */
public class LocalDirectoryRepositoryTest extends RepositoryTest {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.RepositoryTest#initializeRepository()
	 */
	@Override
	public void initializeRepository() throws IOException {
		LocalDirectoryRepository ldRepo = RepositoryFactory.eINSTANCE.createLocalDirectoryRepository();
		File tempDir = File.createTempFile("LocalDirectoryRepositoryTest_", null);
		tempDir.delete();
		tempDir.mkdir();
		tempDir.deleteOnExit();
		ldRepo.setUri(URI.createFileURI(tempDir.getAbsolutePath()).toString());
		repo = ldRepo;
	}

}
