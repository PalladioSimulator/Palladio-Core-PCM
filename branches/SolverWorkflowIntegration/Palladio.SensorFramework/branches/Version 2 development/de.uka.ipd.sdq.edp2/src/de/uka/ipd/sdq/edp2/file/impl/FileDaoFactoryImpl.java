/**
 * 
 */
package de.uka.ipd.sdq.edp2.file.impl;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.DescriptionsDao;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.JScienceXmlMeasurementsDao;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.file.impl.BackgroundMemoryListImpl.BinaryRepresentation;

/**This {@link DaoFactory} implementation stores data in file on background storage.
 * 
 * @author groenda
 */
public class FileDaoFactoryImpl implements DaoFactory {
	/** Logger for this class. */
	private static final Logger logger = Logger
			.getLogger(FileDaoFactoryImpl.class.getCanonicalName());
	
	/** File suffix for uuid-referenced data files. */
	private static final String FILE_SUFFIX = "edp2bin";
	
	/**
	 * Resource set for all handled EMF models. Must be the same to allow
	 * correct linking.
	 */
	private static final ResourceSet emfResourceSet = new ResourceSetImpl();
	/** Determines where newly created DAOs are registered. */
	private DaoRegistry daoRegistry;

	/** Map containing the existing FileDaoFactories. */
	public static ConcurrentMap<String, DaoFactory> existingFileDaoFactories = new ConcurrentHashMap<String, DaoFactory>();

	/** Directory which is handled by this instance of the file dao factory. */
	private File storageDirectory = null;

	/**
	 * Creates a new instance of a DaoFactory for files.
	 * 
	 * @param storageDirectory
	 *            The directory for which this instance is responsible.
	 */
	public FileDaoFactoryImpl(File storageDirectory, DaoRegistry daoRegistry) {
		if (existingFileDaoFactories
				.containsKey(fileToMapKey(storageDirectory))) {
			logger.log(Level.SEVERE,
					"There is already an existing FileDaoFactory instance for "
							+ fileToMapKey(storageDirectory) + ".");
			throw new IllegalArgumentException();
		} else {
			existingFileDaoFactories.put(fileToMapKey(storageDirectory), this);
		}
		this.storageDirectory = storageDirectory;
		this.daoRegistry = daoRegistry;
	}

	/**
	 * Converts a file/directory name to a valid key of the
	 * existingFileDaoFactories map.
	 * 
	 * @param directory
	 *            The file to convert.
	 * @return The key for the map.
	 */
	public String fileToMapKey(File directory) {
		String result = null;
		try {
			result = directory.getCanonicalPath();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Could not resolve file name to String.",
					e);
		}
		return result;
	}

	/**
	 * returns the absolute path to a uuid-referenced data file.
	 * 
	 * @param uuid
	 *            Identifier of the data (file).
	 * @return aboslute path to the file.
	 */
	private String getAbsolutePathToUuidFile(String uuid, String suffix) {
		return new File(storageDirectory.getAbsolutePath() + File.separator
				+ uuid).getAbsolutePath()
				+ "." + suffix;
	}

	@Override
	public ExperimentGroupDao createExperimentGroupDao(String uuid) {
		FileExperimentGroupDaoImpl expGroupDao = new FileExperimentGroupDaoImpl();
		/*
		 * File extension used to store file. Not correct wrt to EDP2
		 * definitions but works for testing.
		 */
		expGroupDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION)));
		expGroupDao.setResourceSet(emfResourceSet);
		daoRegistry.register(expGroupDao, uuid);
		return expGroupDao;
	}

	@Override
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(
			String uuid) {
		// TODO Implement JScienceXmlMeasurements
		logger.log(Level.SEVERE,
				"Unsupported Operation: JScience Measurements.");
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BinaryMeasurementsDao<Measure> createDoubleMeasurementsDao(String uuid) {
		FileBinaryMeasurementsDaoImpl<Measure> fbmDao = new FileBinaryMeasurementsDaoImpl<Measure>();
		fbmDao.setBinaryRepresentation(BinaryRepresentation.DOUBLE);
		fbmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				FILE_SUFFIX)));
		fbmDao.setSerializer(new DoubleSerializer());
		daoRegistry.register(fbmDao, uuid);
		return fbmDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BinaryMeasurementsDao<Measure> createLongMeasurementsDao(String uuid) {
		FileBinaryMeasurementsDaoImpl<Measure> fbmDao = new FileBinaryMeasurementsDaoImpl<Measure>();
		fbmDao.setBinaryRepresentation(BinaryRepresentation.LONG);
		fbmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				FILE_SUFFIX)));
		fbmDao.setSerializer(new LongSerializer());
		daoRegistry.register(fbmDao, uuid);
		return fbmDao;
	}

	@Override
	public NominalMeasurementsDao createNominalMeasurementsDao(String uuid) {
		FileNominalMeasurementsDaoImpl fnmDao = new FileNominalMeasurementsDaoImpl();
		fnmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION)));
		fnmDao.setResourceSet(emfResourceSet);
		daoRegistry.register(fnmDao, uuid);
		return fnmDao;
	}

	@Override
	public DaoRegistry getDaoRegistry() {
		return daoRegistry;
	}

	@Override
	public DescriptionsDao createDescriptionsDao(String uuid) {
		FileDescriptionsDaoImpl descDao = new FileDescriptionsDaoImpl();
		descDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION)));
		descDao.setResourceSet(emfResourceSet);
		daoRegistry.register(descDao, uuid);
		return descDao;
	}
}
