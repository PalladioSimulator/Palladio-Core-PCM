/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MeasurementsDaoRegistry;
import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDaoImpl;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.JScienceXmlMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsDaoRegistryImpl;
import de.uka.ipd.sdq.edp2.impl.NominalMeasurementsDaoImpl;
import de.uka.ipd.sdq.edp2.local.file.BackgroundMemoryListImpl.BinaryRepresentation;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**This {@link MeasurementsDaoFactory} implementation stores data in file on background storage.
 * 
 * @author groenda
 */
public class LocalDirectoryMeasurementsDaoFactory extends de.uka.ipd.sdq.edp2.impl.MeasurementsDaoFactory {
	/** Logger for this class. */
	private static final Logger logger = Logger
			.getLogger(LocalDirectoryMeasurementsDaoFactory.class.getCanonicalName());
	
	/** File suffix for uuid-referenced data files. */
	private static final String FILE_SUFFIX = "edp2bin";
	
	/**
	 * Resource set for all handled EMF models. Must be the same to allow
	 * correct linking.
	 */
	private static final ResourceSet emfResourceSet = new ResourceSetImpl();
	/** Determines where newly created DAOs are registered. */
	private MeasurementsDaoRegistry daoRegistry;

	/** Map containing the existing FileDaoFactories. */
	public static ConcurrentMap<String, MeasurementsDaoFactory> existingFileDaoFactories = new ConcurrentHashMap<String, MeasurementsDaoFactory>();

	/** Directory which is handled by this instance of the file dao factory. */
	private File storageDirectory = null;

	/**
	 * Creates a new instance of a DaoFactory for files.
	 * 
	 * @param storageDirectory
	 *            The directory for which this instance is responsible.
	 */
	public LocalDirectoryMeasurementsDaoFactory(File storageDirectory) {
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
		this.daoRegistry = new MeasurementsDaoRegistryImpl();
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

//	@Override
//	public ExperimentGroupDao createExperimentGroupDao(String uuid) {
//		FileExperimentGroupDaoImpl expGroupDao = new FileExperimentGroupDaoImpl();
//		/*
//		 * File extension used to store file. Not correct wrt to EDP2
//		 * definitions but works for testing.
//		 */
//		expGroupDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
//				EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION)));
//		expGroupDao.setResourceSet(emfResourceSet);
//		daoRegistry.register(expGroupDao, uuid);
//		return expGroupDao;
//	}

	@Override
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(
			String uuid) {
		super.createJScienceXmlMeasurementsDao(uuid);
		// TODO Implement JScienceXmlMeasurements
		logger.log(Level.SEVERE,
				"Unsupported Operation: JScience Measurements.");
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BinaryMeasurementsDaoImpl<Measure> createDoubleMeasurementsDao(String uuid) {
		super.createDoubleMeasurementsDao(uuid);
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
	public BinaryMeasurementsDaoImpl<Measure> createLongMeasurementsDao(String uuid) {
		super.createLongMeasurementsDao(uuid);
		FileBinaryMeasurementsDaoImpl<Measure> fbmDao = new FileBinaryMeasurementsDaoImpl<Measure>();
		fbmDao.setBinaryRepresentation(BinaryRepresentation.LONG);
		fbmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				FILE_SUFFIX)));
		fbmDao.setSerializer(new LongSerializer());
		daoRegistry.register(fbmDao, uuid);
		return fbmDao;
	}

	@Override
	public NominalMeasurementsDaoImpl createNominalMeasurementsDao(String uuid) {
		super.createNominalMeasurementsDao(uuid);
		FileNominalMeasurementsDaoImpl fnmDao = new FileNominalMeasurementsDaoImpl();
		fnmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
				EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION)));
		fnmDao.setResourceSet(emfResourceSet);
		daoRegistry.register(fnmDao, uuid);
		return fnmDao;
	}

	@Override
	public MeasurementsDaoRegistry getDaoRegistry() {
		return daoRegistry;
	}

	@Override
	public void setActive(boolean newValue) {
		super.setActive(newValue);
		Set<String> registeredUuids = daoRegistry.getRegisteredUuids();
		for (String uuid : registeredUuids) {
			try {
				if (!isActive()) {
					if (!daoRegistry.getMeasurementsDao(uuid).isDeleted()) {
						daoRegistry.getMeasurementsDao(uuid).close();
					}
					daoRegistry.deregister(uuid);
				} else {
					daoRegistry.getMeasurementsDao(uuid).open();
				}
			} catch (DataNotAccessibleException e) {
				logger.log(Level.SEVERE, "Could not close DAO.", e);
			}
		}
	}

//	@Override
//	public DescriptionsDao createDescriptionsDao(String uuid) {
//		FileDescriptionsDaoImpl descDao = new FileDescriptionsDaoImpl();
//		descDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,
//				EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION)));
//		descDao.setResourceSet(emfResourceSet);
//		daoRegistry.register(descDao, uuid);
//		return descDao;
//	}
}
