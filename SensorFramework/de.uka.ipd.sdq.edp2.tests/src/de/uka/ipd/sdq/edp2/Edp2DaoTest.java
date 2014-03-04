/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**JUnit test for classes with Edp2Dao interface. 
 * Subclass and test for all different types of Edp2Dao.
 * @author groenda
 */
public abstract class Edp2DaoTest {
	
	/** The factory used to create the DAO factories. */
	//protected StorageFactory factory = new StorageFactory();
	
	/** The used DAO factory. */
	protected MeasurementsDaoFactory df = null;
	
	/** DAO under test. */
	protected Edp2Dao dao = null;

	@Test(expected = IllegalStateException.class)
	public void testDelete() throws DataNotAccessibleException {
		assertFalse("DAO must have initial state of not-deletd.", dao.isDeleted());
		dao.open();
		dao.close();
		dao.delete();
		assertTrue("DAO must be deleted after delet().", dao.isDeleted());
		dao.open();
	}

	@Test(expected = IllegalStateException.class)
	public void testDeleteNotIfOpen() throws DataNotAccessibleException {
		dao.open();
		dao.delete();
	}
	
	@Test
	public void testOpen() throws DataNotAccessibleException {
		assertFalse("DAO must have initial state of not-open.", dao.isOpen());
		dao.open();
		assertTrue("DAO must be open after open().", dao.isOpen());
	}
	
	@Test
	public void testClosed() throws DataNotAccessibleException {
		assertFalse("DAO must have initial state of not-open.", dao.isOpen());
		dao.open();
		assertTrue("DAO must be open after open().", dao.isOpen());
		dao.close();
		assertFalse("DAO must be closed after close().", dao.isOpen());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testClosedOnClosedDataset() throws DataNotAccessibleException {
		dao.close();
	}
}
