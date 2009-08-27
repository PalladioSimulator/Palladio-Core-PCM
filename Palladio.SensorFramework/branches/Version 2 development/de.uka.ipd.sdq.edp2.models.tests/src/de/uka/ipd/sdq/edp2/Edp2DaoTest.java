/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**JUnit test for classes with Edp2Dao interface. 
 * Subclass and test for all different types of Edp2Dao.
 * @author groenda
 */
public abstract class Edp2DaoTest {
	
	/** DAO under test. */
	protected Edp2Dao dao = null;

	@Test
	public void testInitialStatus() {
		Assert.assertEquals("Initialized DAO should be in state closed.", false, dao.isOpen());
		Assert.assertEquals("Initialized DAO should not be in state deleted.", false, dao.isDeleted());
		Assert.assertEquals("Initialized DAO should not be allowed to be closed.", false, dao.canClose());
		Assert.assertEquals("Initialized DAO should be allowed to be deleted.", true, dao.canDelete());
		Assert.assertEquals("Initialized DAO should be allowed to be opened.", true, dao.canOpen());
	}
	
	@Test
	public void testDelete() throws DataNotAccessibleException {
		testLifeCycleDelete(dao);
	}
	
	@Test
	public void testDeleteAfterClose() throws DataNotAccessibleException {
		testLifeCycleOpen(dao);
		testLifeCycleClose(dao);
		testLifeCycleDelete(dao);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testDeleteAfterDelete() throws DataNotAccessibleException {
		testLifeCycleDelete(dao);
		testLifeCycleDelete(dao);
	}

	@Test(expected = IllegalStateException.class)
	public void testDeleteNotIfOpen() throws DataNotAccessibleException {
		dao.open();
		dao.delete();
	}
	
	@Test
	public void testOpen() throws DataNotAccessibleException {
		testLifeCycleOpen(dao);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testOpenAfterDelete() throws DataNotAccessibleException {
		testLifeCycleDelete(dao);
		testLifeCycleOpen(dao);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseAfterDelete() throws DataNotAccessibleException {
		testLifeCycleDelete(dao);
		testLifeCycleClose(dao);
	}
	
	@Test
	public void testClosed() throws DataNotAccessibleException {
		testLifeCycleOpen(dao);
		testLifeCycleClose(dao);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseAfterClose() throws DataNotAccessibleException {
		testLifeCycleClose(dao);
		testLifeCycleClose(dao);
	}

	@Test(expected = IllegalStateException.class)
	public void testOpenAfterOpen() throws DataNotAccessibleException {
		testLifeCycleOpen(dao);
		testLifeCycleOpen(dao);
	}

	public void testLifeCycleOpen(Edp2Dao dao) throws DataNotAccessibleException {
		dao.open();
		Assert.assertEquals("Open DAO should be in state open.", true, dao.isOpen());
		Assert.assertEquals("Open DAO should be in state open.", false, dao.isDeleted());
		Assert.assertEquals("Open DAO should be allowed to be opened.", false, dao.canOpen());
		Assert.assertEquals("Open DAO should not be allowed to be deleted.", false, dao.canDelete());
	}
	
	public void testLifeCycleClose(Edp2Dao dao) throws DataNotAccessibleException {
		dao.close();
		Assert.assertEquals("Closed DAO should be in state closed.", false, dao.isOpen());
		Assert.assertEquals("Closed DAO should be in state closed.", false, dao.isDeleted());
		Assert.assertEquals("Closed DAO should be allowed to be closed.", false, dao.canClose());
		Assert.assertEquals("Closed DAO should be allowed to be deleted.", true, dao.canDelete());
	}
	
	public void testLifeCycleDelete(Edp2Dao dao) throws DataNotAccessibleException {
		dao.delete();
		Assert.assertEquals("Deleted DAO should not be allowed to be deleted again.", false, dao.canDelete());
		Assert.assertEquals("Deleted DAO should not be allowed to be (re-)opened.", false, dao.canOpen());
		Assert.assertEquals("Deleted DAO should not be allowed to be closed.", false, dao.canClose());
		Assert.assertEquals("Deleted DAO should not be in state open.", false, dao.isOpen());
		Assert.assertEquals("Deleted DAO should be in state deleted.", true, dao.isDeleted());
	}
}
