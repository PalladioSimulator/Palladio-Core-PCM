/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.tests;

import java.io.File;
import java.io.IOException;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.tests.util.TempDir;

/**
 * @author Steffen Becker
 *
 */
public class FileSerialiserTests extends AbstractSerialiserTests {

	private File lastTempDir;

	/**
	 * 
	 */
	public FileSerialiserTests() {
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.tests.AbstractSerialiserTests#createCleanDAOFactory()
	 */
	@Override
	protected IDAOFactory createCleanDAOFactory() throws IOException {
		this.lastTempDir = TempDir.createGeneratedName("TempDB");
		return new FileDAOFactory(lastTempDir.getAbsolutePath());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.tests.AbstractSerialiserTests#createDAOFactory()
	 */
	@Override
	protected IDAOFactory createDAOFactory() {
		return new FileDAOFactory(lastTempDir.getAbsolutePath());
	}
}
