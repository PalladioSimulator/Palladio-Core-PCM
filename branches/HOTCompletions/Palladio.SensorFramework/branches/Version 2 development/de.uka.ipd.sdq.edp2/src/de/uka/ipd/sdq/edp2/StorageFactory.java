package de.uka.ipd.sdq.edp2;

import java.io.File;
import java.io.IOException;

import de.uka.ipd.sdq.edp2.file.impl.FileDaoFactoryImpl;
import de.uka.ipd.sdq.edp2.impl.Edp2DaoRegistryImpl;

/**Factory to create the different existing DaoFactories.
 * Returns existing factories if the same domains are requested more than once.
 * @author groenda
 */
public class StorageFactory {
	/** Singleton to provide one central factory. */
	public static final StorageFactory INSTANCE = new StorageFactory();
	
	/** Registry for all DAOs created by factories which this factory created. */
	private DaoRegistry daoRegistry;

	/**Initialized a new EDP2 factory.
	 * Creates an empty DAO registry.
	 */
	public StorageFactory() {
		daoRegistry = new Edp2DaoRegistryImpl();
	}
	
	/**Creates a MemoryDaoFactory instance for the specified directory.
	 * Returns an existing factory if there already is one.
	 * @param domain Domain for which the MemoryDaoFactory is responsible.
	 * @return The created or requested DaoFactory.
	 * @throws IOException If there are errors handling the directory.
	 */
	public DaoFactory createMemoryDaoFactory(String domain) {
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
	public DaoFactory createFileDaoFactory(File directory) throws IOException {
		DaoFactory daoFactory;
		String key = directory.getCanonicalPath();
		if (FileDaoFactoryImpl.existingFileDaoFactories.containsKey(key)) {
			daoFactory = FileDaoFactoryImpl.existingFileDaoFactories.get(key);
		} else {
			daoFactory = new FileDaoFactoryImpl(directory, daoRegistry);
			FileDaoFactoryImpl.existingFileDaoFactories.put(key, daoFactory);
		}
		return daoFactory;
	}

	/**Returns a registry which contains all DAOs which were created by factories created by this class.
	 * @return the daoRegistry
	 */
	public DaoRegistry getDaoRegistry() {
		return daoRegistry;
	}

	/**Sets the registry which contains all DAOs which are accessible.
	 * @param daoRegistry the daoRegistry to set
	 */
	public void setDaoRegistry(DaoRegistry daoRegistry) {
		this.daoRegistry = daoRegistry;
	}
}
