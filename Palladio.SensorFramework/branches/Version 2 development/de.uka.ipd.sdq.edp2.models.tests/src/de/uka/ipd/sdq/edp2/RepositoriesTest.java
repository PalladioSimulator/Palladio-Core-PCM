/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import junit.framework.Assert;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryFactory;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**Test {@link Repositories} elements.
 * @author groenda
 *
 */
public class RepositoriesTest {
	/** Repositories under test. */
	protected Repositories repos;

	@Before
	public void createRepositories() {
		repos = RepositoryFactory.eINSTANCE.createRepositories();
	}
	
	@Test
	public void testGetAvailableRepositories() {
		Assert.assertEquals("Initial available repositories size mismatch.", 0, repos.getAvailableRepositories().size());
	}
	
	@Test
	public void testGetCommonResourceSet() {
		ResourceSet rs = repos.getCommonResourceSet();
		Assert.assertNotNull("Common resource set must be initialized.", rs);
		Assert.assertTrue("Common resource set must contain a factory for the experiment group extension.", rs.getResourceFactoryRegistry().getExtensionToFactoryMap().containsKey(EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION));
		Assert.assertTrue("Common resource set must contain a factory for the description extension.", rs.getResourceFactoryRegistry().getExtensionToFactoryMap().containsKey(EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION));
		Assert.assertTrue("Common resource set must contain a factory for the nominal measurements extension.", rs.getResourceFactoryRegistry().getExtensionToFactoryMap().containsKey(EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION));
	}
	
	@Test
	public void testSetCommonResourceSet() {
		ResourceSet newResourceSet = new ResourceSetImpl();
		repos.setCommonResourceSet(newResourceSet);
		Assert.assertEquals("Setting the common resource set did not work.", newResourceSet, repos.getCommonResourceSet());
	}

}
