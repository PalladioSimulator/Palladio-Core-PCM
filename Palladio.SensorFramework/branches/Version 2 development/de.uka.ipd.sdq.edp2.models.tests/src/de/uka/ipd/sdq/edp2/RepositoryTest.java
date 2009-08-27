/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.Collection;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.emfmodel.Description;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryFactory;

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
		initializeRepository();
		repos.getAvailableRepositories().add(repo);
		dao = metaDao = repo;
	}
	
	public abstract void initializeRepository() throws Exception;

	@Test
	public void testGetDescription() {
		Assert.assertEquals("Initial size of descriptions wrong.", 0, repo.getDescription().size());
		// add a description
		Description desc = EmfmodelFactory.eINSTANCE.createBaseMetricDescription();
		repo.getDescription().add(desc);
		Assert.assertNotNull("Description must be added to a resource upon insertion into the list of descriptions (single value case).", desc.eResource());
		Assert.assertEquals("Size after adding one element is wrong.", 1, repo.getDescription().size());
		
		// remove a description
		repo.getDescription().remove(desc);
		Assert.assertNull("Resource of description must be null after deletion.", desc.eResource());
		Assert.assertEquals("Size after removing the only element is wrong.", 0, repo.getDescription().size());
		
		// add a collection
		Collection<Description> c = new LinkedList<Description>();
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		c.add(EmfmodelFactory.eINSTANCE.createBaseMetricDescription());
		repo.getDescription().addAll(c);
		for (Description desc2 : repo.getDescription()) {
			Assert.assertNotNull("Description must be added to a resource upon insertion into the list of descriptions (multi value case).", desc2.eResource());
		}
		Assert.assertEquals("Size after adding elements is wrong.", 3, repo.getDescription().size());
		
		// remove a collection
		repo.getDescription().clear();
		Assert.assertEquals("Size after removing all elements is wrong.", 0, repo.getDescription().size());
	}
	
	@Test
	public void testGetExperimentGroup() {
		Assert.assertEquals("Initial size of experiment groups wrong.", 0, repo.getExperimentGroup().size());
		// Add an experiment group
		ExperimentGroup eg = EmfmodelFactory.eINSTANCE.createExperimentGroup();
		repo.getExperimentGroup().add(eg);
		Assert.assertNotNull("Element must be assigned a resource upon insertion into the list of experiment groups (single value case).", eg.eResource());
		Assert.assertEquals("Size after adding one element is wrong.", 1, repo.getExperimentGroup().size());

		// Remove an experiment group
		repo.getExperimentGroup().remove(eg);
		Assert.assertNull("Resource of experiment group must be null after deletion.", eg.eResource());
		Assert.assertEquals("Size after removing the only element is wrong.", 0, repo.getExperimentGroup().size());

		// Add a collection
		Collection<ExperimentGroup> c = new LinkedList<ExperimentGroup>();
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		c.add(EmfmodelFactory.eINSTANCE.createExperimentGroup());
		repo.getExperimentGroup().addAll(c);
		for (ExperimentGroup eg2 : repo.getExperimentGroup()) {
			Assert.assertNotNull("Element must be assigned a resource upon insertion into the list of experiment groups (single value case).", eg2.eResource());
		}
		Assert.assertEquals("Size after adding elements is wrong.", 3, repo.getExperimentGroup().size());

		// Remove a collection
		repo.getExperimentGroup().clear();
		Assert.assertEquals("Size after removing all elements is wrong.", 0, repo.getExperimentGroup().size());
	}

	@Test
	public void testReadOnly() throws DataNotAccessibleException {
		Assert.assertFalse("Repository should not be read only after initialization.", repo.isReadOnly());
		
		repo.setReadOnly(false);
		Assert.assertFalse("Repository must be read-only after setting it.", repo.isReadOnly());
	}
}
