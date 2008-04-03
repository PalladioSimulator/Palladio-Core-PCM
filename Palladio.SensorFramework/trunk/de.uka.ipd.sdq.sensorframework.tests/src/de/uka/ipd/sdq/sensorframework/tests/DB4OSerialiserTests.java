/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.tests;

import java.io.File;
import java.io.IOException;

import de.uka.ipd.sdq.sensorframework.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.tests.util.TempDir;

/**
 * @author Snowball
 *
 */
public class DB4OSerialiserTests // extends AbstractSerialiserTests 
{

	private File lastTempDir;

	/**
	 * 
	 */
	public DB4OSerialiserTests() {
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.tests.AbstractSerialiserTests#createCleanDAOFactory()
	 */
	// @Override
	protected IDAOFactory createCleanDAOFactory() throws IOException {
		this.lastTempDir = File.createTempFile("db4o", "db");
		return new DB4ODAOFactory(this.lastTempDir.getAbsolutePath());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.tests.AbstractSerialiserTests#createDAOFactory()
	 */
	// @Override
	protected IDAOFactory createDAOFactory() {
		return new DB4ODAOFactory(lastTempDir.getAbsolutePath());
	}
}
