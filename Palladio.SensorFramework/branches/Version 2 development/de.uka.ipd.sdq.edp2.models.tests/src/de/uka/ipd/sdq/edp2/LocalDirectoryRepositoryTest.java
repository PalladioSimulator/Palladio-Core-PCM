/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories;
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
