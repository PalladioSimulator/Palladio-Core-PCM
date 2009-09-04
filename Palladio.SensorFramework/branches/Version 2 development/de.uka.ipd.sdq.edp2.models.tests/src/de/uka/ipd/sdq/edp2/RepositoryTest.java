/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;

/**Test instances of {@link Repository} classes/elements.
 * @author groenda
 *
 */
public abstract class RepositoryTest extends MetaDaoTest {
	/** Repository under test. */
	protected Repository repo;
	/** Common Repository instance*/
	protected Repositories repos = RepositoryFactory.eINSTANCE.createRepositories();
	
	@Before
	public void addRepository() throws Exception {
		dao = metaDao = repo = initializeRepository();
		repos.getAvailableRepositories().add(repo);
	}
	
	public abstract Repository initializeRepository() throws Exception;

	@Test
	public void testGetDescription() {
		Assert.assertEquals("Initial size of descriptions wrong.", 0, repo.getDescriptions().size());
		// add a description
		Description desc = EmfmodelFactory.eINSTANCE.createBaseMetricDescription();
		repo.getDescriptions().add(desc);
		Assert.assertNotNull("Description must be added to a resource upon insertion into the list of descriptions (single value case).", desc.eResource());
		Assert.assertEquals("Size after adding one element is wrong.", 1, repo.getDescriptions().size());
		
		// remove a description
		repo.getDescriptions().remove(desc);
		Assert.assertNull("Resource of description must be null after deletion.", desc.eResource());
		Assert.assertEquals("Size after removing the only element is wrong.", 0, repo.getDescriptions().size());
		
		// add a collection
		Collection<Description> c = new LinkedList<Description>();
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		repo.getDescriptions().addAll(c);
		for (Description desc2 : repo.getDescriptions()) {
			Assert.assertNotNull("Description must be added to a resource upon insertion into the list of descriptions (multi value case).", desc2.eResource());
		}
		Assert.assertEquals("Size after adding elements is wrong.", 3, repo.getDescriptions().size());
		
		// remove a collection
		repo.getDescriptions().clear();
		Assert.assertEquals("Size after removing all elements is wrong.", 0, repo.getDescriptions().size());
	}
	
	@Test
	public void testGetExperimentGroup() {
		Assert.assertEquals("Initial size of experiment groups wrong.", 0, repo.getExperimentGroups().size());
		// Add an experiment group
		ExperimentGroup eg = EmfmodelFactory.eINSTANCE.createExperimentGroup();
		repo.getExperimentGroups().add(eg);
		Assert.assertNotNull("Element must be assigned a resource upon insertion into the list of experiment groups (single value case).", eg.eResource());
		Assert.assertEquals("Size after adding one element is wrong.", 1, repo.getExperimentGroups().size());

		// Remove an experiment group
		repo.getExperimentGroups().remove(eg);
		Assert.assertNull("Resource of experiment group must be null after deletion.", eg.eResource());
		Assert.assertEquals("Size after removing the only element is wrong.", 0, repo.getExperimentGroups().size());

		// Add a collection
		Collection<ExperimentGroup> c = new LinkedList<ExperimentGroup>();
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		repo.getExperimentGroups().addAll(c);
		for (ExperimentGroup eg2 : repo.getExperimentGroups()) {
			Assert.assertNotNull("Element must be assigned a resource upon insertion into the list of experiment groups (single value case).", eg2.eResource());
		}
		Assert.assertEquals("Size after adding elements is wrong.", 3, repo.getExperimentGroups().size());

		// Remove a collection
		repo.getExperimentGroups().clear();
		Assert.assertEquals("Size after removing all elements is wrong.", 0, repo.getExperimentGroups().size());
	}

	@Test
	public void testReadOnly() throws DataNotAccessibleException {
		Assert.assertFalse("Repository should not be read only after initialization.", repo.isReadOnly());
		
		repo.setReadOnly(false);
		Assert.assertFalse("Repository must be read-only after setting it.", repo.isReadOnly());
	}

	@Test (expected=DataNotAccessibleException.class)
	public void unassignedRepository() throws Exception {
		repo = initializeRepository();
		Assert.assertFalse("A repository must be assigned to a Repositories " +
				"instance in order to be opened.", repo.canOpen());
		repo.open();
	}

	@Test (expected = IllegalStateException.class)
	public void reassigningRepositoryWithoutClosing() throws IOException, DataNotAccessibleException {
		// assign & open Repository
		RepositoryManager.addRepository(repos, repo);
		// create dummy test instance
		repo.getExperimentGroups().add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		// reassign
		Repositories repos2 = RepositoryFactory.eINSTANCE.createRepositories();
		RepositoryManager.addRepository(repos2, repo);
		Assert.assertEquals("ResourceSet assigned to a repository must match the resource set of the parent Repositories instance.",
				repos2.getCommonResourceSet(), repo
				.getExperimentGroups().get(0).eResource().getResourceSet());
	}

	@Test
	public void reassigningRepositoryWithClosing() throws IOException, DataNotAccessibleException {
		// assign & open Repository
		RepositoryManager.addRepository(repos, repo);
		// create dummy test instance
		repo.getExperimentGroups().add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		repo.close();
		// reassign
		Repositories repos2 = RepositoryFactory.eINSTANCE.createRepositories();
		RepositoryManager.addRepository(repos2, repo);
		Assert.assertTrue("ResourceSet assigned to a repository must match the resource set of the parent Repositories instance.",
				repos2.getCommonResourceSet().equals(repo
				.getExperimentGroups().get(0).eResource().getResourceSet()));
	}
	
}
