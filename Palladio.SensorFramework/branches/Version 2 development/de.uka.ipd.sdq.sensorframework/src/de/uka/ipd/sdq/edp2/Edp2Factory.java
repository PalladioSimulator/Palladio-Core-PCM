package de.uka.ipd.sdq.edp2;

import java.io.File;
import java.io.IOException;

import de.uka.ipd.sdq.edp2.impl.FileDaoFactoryImpl;

/**Factory to create the different existing DaoFactories.
 * Returns existing factories if the same domains are requested more than once.
 * @author groenda
 */
public class Edp2Factory {

	/**Creates a MemoryDaoFactory instance for the specified directory.
	 * Returns an existing factory if there already is one.
	 * @param domain Domain for which the MemoryDaoFactory is responsible.
	 * @return The created or requested DaoFactory.
	 * @throws IOException If there are errors handling the directory.
	 */
	public static DaoFactory createMemoryDaoFactory(String domain) {
		DaoFactory daoFactory;
		if (MemoryDaoFactory.existingMemoryDaoFactories.containsKey(domain)) {
			daoFactory = MemoryDaoFactory.existingMemoryDaoFactories.get(domain);
		} else {
			daoFactory = new MemoryDaoFactory(domain);
			MemoryDaoFactory.existingMemoryDaoFactories.put(domain, daoFactory);
		}
		return daoFactory;
	}
	
	/**Creates a FileDaoFactory instance for the specified directory.
	 * Returns an existing factory if there already is one.
	 * @param directory Directory for which the FileDaoFactory is responsible.
	 * @return The created or requested DaoFactory.
	 * @throws IOException If there are errors handling the directory.
	 */
	public static DaoFactory createFileDaoFactory(File directory) throws IOException {
		DaoFactory daoFactory;
		String key = directory.getCanonicalPath();
		if (FileDaoFactoryImpl.existingFileDaoFactories.containsKey(key)) {
			daoFactory = FileDaoFactoryImpl.existingFileDaoFactories.get(key);
		} else {
			daoFactory = new FileDaoFactoryImpl(directory);
			FileDaoFactoryImpl.existingFileDaoFactories.put(key, daoFactory);
		}
		return daoFactory;
	}
}
