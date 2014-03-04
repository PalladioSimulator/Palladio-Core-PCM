/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**JUnit test for classes with ExperimentGroupDao interface.
 * Subclass and test for all different types of ExperimentGroupDaos.
 * @author groenda
 */
public abstract class ExperimentGroupDaoTest extends Edp2DaoTest {
	/** The ExperimentGroupDao under test. */
	protected EmfFileAccessDao egd = dao;
	
	@Test (expected = IllegalStateException.class)
	public void testGetExperimentGroupOnlyIfOpen() {
		egd.getExperimentGroup();
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.edp2.file.impl.FileExperimentGroupDaoImpl#getExperimentGroup()}.
	 * @throws DataNotAccessibleException Error while accessing the file.
	 */
	@Test
	public void testGetExperimentGroup() throws DataNotAccessibleException {
		assertFalse("ExperimentGroup must have initial state of not-open.", egd.isOpen());
		assertFalse("ExperimentGroup must have initial state of not-deleted.", egd.isDeleted());
		
		egd.open();
		assertTrue("ExperimentGroup must be open after open().", egd.isOpen());
		assertFalse("ExperimentGroup.open() must not effect status of deletion.", egd.isDeleted());
		assertNotNull("ExperimentGroup must be not null if open.", egd.getExperimentGroup());
		
		egd.close();
		assertFalse("ExperimentGroup must be closed after close().", egd.isOpen());
		assertFalse("ExperimentGroup.open() must not effect status of deletion.", egd.isDeleted());
		
		egd.delete();
		assertFalse("ExperimentGroup.delete() must have no effect on status of open/closed.", egd.isOpen());
		assertTrue("ExperimentGroup must be deleted adter delete().", egd.isDeleted());
	}
		
	@Test
	public void testExperimentGroupDataRetainedIfReopened() throws DataNotAccessibleException {
		egd.open();
		ExperimentGroup eg = egd.getExperimentGroup();
		String testString = "ExperimentGroupOne";
		eg.setUuid(testString);
		egd.close();
		egd.open();
		eg = egd.getExperimentGroup();
		assertEquals("Id of ExperimentGroup must be retained if reopened.", 
				testString, eg.getUuid());
		egd.close();
	}

	/**Test the storing of EMF resource set.
	 */
	@Test
	public void testResourceSet() {
		assertNotNull("Resource set must not be null if initalized.", egd.getResourceSet());
	}
}
