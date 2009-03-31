/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.JScienceXmlMeasurementsDao;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.file.impl.DoubleSerializer;
import de.uka.ipd.sdq.edp2.file.impl.EmfModelXMIResourceFactoryImpl;
import de.uka.ipd.sdq.edp2.file.impl.LongSerializer;

/**Responsible for creating DAOs accessing files on background storage.
 * @author groenda
 */
public class FileDaoFactoryImpl implements DaoFactory {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(FileDaoFactoryImpl.class.getCanonicalName());
	/** File suffix for uuid-referenced data files. */
	private static final String FILE_SUFFIX = ".bin";
	/** Resource set for all handled EMF models. Must be the same to allow correct linking. */
	private static final ResourceSet emfResourceSet = new ResourceSetImpl(); 
	
	/** Map containing the existing FileDaoFactories. */
	public static ConcurrentMap<String, DaoFactory> existingFileDaoFactories = 
		new ConcurrentHashMap<String, DaoFactory>(); 
	
	/** Directory which is handled by this instance of the file dao factory. */
	private File storageDirectory = null;
	
	/**Creates a new instance of a DaoFactory for files.
	 * @param storageDirectory The directory for which this instance is responsible.
	 */
	public FileDaoFactoryImpl(File storageDirectory) {
		if (existingFileDaoFactories.containsKey(fileToMapKey(storageDirectory))) {
			logger.log(Level.SEVERE, "There is already an existing FileDaoFactory instance for " 
					+ fileToMapKey(storageDirectory)+ ".");
			throw new IllegalArgumentException();
		} else {
			existingFileDaoFactories.put(fileToMapKey(storageDirectory), this);
		}
		this.storageDirectory = storageDirectory;
	}
	
	/**Converts a file/directory name to a valid key of the existingFileDaoFactories map.
	 * @param directory The file to convert.
	 * @return The key for the map.
	 */
	public String fileToMapKey(File directory) {
		String result = null;
		try {
			result = directory.getCanonicalPath();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Could not resolve file name to String.", e);
		}
		return result;
	}
	
	/**returns the absolute path to a uuid-referenced data file.
	 * @param uuid Identifier of the data (file).
	 * @return aboslute path to the file.
	 */
	private String getAbsolutePathToUuidFile(String uuid, String suffix) {
		return new File(storageDirectory.getAbsolutePath() 
				+ File.separator + uuid).getAbsolutePath() + "." + suffix;
	}

	@Override
	public ExperimentGroupDao createExperimentGroupDao(String uuid) {
		FileExperimentGroupDaoImpl expGroupDao = new FileExperimentGroupDaoImpl();
		expGroupDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid,EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK)));
		expGroupDao.setResourceSet(emfResourceSet);
		return expGroupDao;
	}

	@Override
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(
			String uuid) {
		// TODO Auto-generated method stub
		logger.log(Level.SEVERE, "Unsupported Operation: JScience Measurements.");
		throw new UnsupportedOperationException();
	}

	@Override
	public BinaryMeasurementsDao<Double> createDoubleMeasurementsDao(String uuid) {
		FileBinaryMeasurementsDaoImpl<Double> fbmDao = new FileBinaryMeasurementsDaoImpl<Double>();
		fbmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid, FILE_SUFFIX)));
		fbmDao.setSerializer(new DoubleSerializer());
		return fbmDao;
	}

	@Override
	public BinaryMeasurementsDao<Long> createLongMeasurementsDao(String uuid) {
		FileBinaryMeasurementsDaoImpl<Long> fbmDao = new FileBinaryMeasurementsDaoImpl<Long>();
		fbmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid, FILE_SUFFIX)));
		fbmDao.setSerializer(new LongSerializer());
		return fbmDao;
	}

	@Override
	public NominalMeasurementsDao createNominalMeasurementsDao(String uuid) {
		FileNominalMeasurementsDaoImpl fnmDao = new FileNominalMeasurementsDaoImpl();
		fnmDao.setResourceFile(new File(getAbsolutePathToUuidFile(uuid, EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK)));
		fnmDao.setResourceSet(emfResourceSet);
		return fnmDao;
	}
	
}
