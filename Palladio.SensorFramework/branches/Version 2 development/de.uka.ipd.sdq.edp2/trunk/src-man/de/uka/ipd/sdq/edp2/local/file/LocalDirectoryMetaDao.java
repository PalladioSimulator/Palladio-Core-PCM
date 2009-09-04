/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp.internal.SerializationUtil;
import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MetaDaoImpl;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.EmfmodelSwitch;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**DAO to access the meta data stored in a local directory.
 * Warning: It is not allowed to reassign a managed repository to another instance of Repositories.
 * @author groenda
 *
 */
public class LocalDirectoryMetaDao extends MetaDaoImpl {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(LocalDirectoryMetaDao.class.getCanonicalName());

	/** The measurement DAO factory connected to this meta data DAO.*/
	MeasurementsDaoFactory mmtDaoFactory = null;
	
	/** Repository in which the managed data is stored. */
	private LocalDirectoryRepository managedRepo;
	
	public LocalDirectoryMetaDao(final LocalDirectoryRepository repo) {
		this.managedRepo = repo;
		// observe changes on the assignment of the repository
		Adapter reposAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature().equals(RepositoryPackage.Literals.REPOSITORY__REPOSITORIES)) {
					if (msg.getEventType() == Notification.SET) {
						if (msg.getOldValue() != null) {
							if (isOpen()) {
								String errMsg = "Repository was reassigned to another instance "
									+ "of Repositories while it was still open. Data might be corrupted!";
								logger.log(Level.SEVERE, errMsg);
								throw new IllegalStateException(errMsg);
							}
						}
					}
				}
			}
		};
		managedRepo.eAdapters().add(reposAdapter);
		// observe changes on the ExperimentGroup list
		Adapter descAdapter = new LocalDirectoryMetaResourceAdapter(repo,
				RepositoryPackage.Literals.REPOSITORY__DESCRIPTIONS,
				EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION);
		managedRepo.eAdapters().add(descAdapter);
		// observe changes on the Descriptions list
		Adapter expGroupAdapter = new LocalDirectoryMetaResourceAdapter(repo,
				RepositoryPackage.Literals.REPOSITORY__EXPERIMENT_GROUPS,
				EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION);
		managedRepo.eAdapters().add(expGroupAdapter);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMetaDao#getMeasurementsDaoFactory()
	 */
	@Override
	public MeasurementsDaoFactory getMeasurementsDaoFactory() {
		return mmtDaoFactory;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IEdp2Dao#canOpen()
	 */
	@Override
	public boolean canOpen() {
		if (!super.canOpen()) {
			return false;
		}
		try {
			if (managedRepo.getRepositories() == null) {
				return false;
			}
			URI uri = URI.createURI(managedRepo.getUri());
			File directory = new File(uri.toFileString());
			if (!directory.isDirectory()) {
				//URI does not point to a directory.
				return false;
			}
			if (!checkFilesContainEmfModel(directory, EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION, Description.class)) {
				// At least one of the description files is not valid
				return false;
			}
			if (!checkFilesContainEmfModel(directory, EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION, ExperimentGroup.class)) {				
				// At least one of the experiment group files is not valid
				return false;
			}
		} catch (IllegalArgumentException e) {
			// URI is not valid
			return false;
		}
		return true;
	}

	/**Checks if all files with the given extension contain a EMF model with the given expected root.
	 * @param directory Directory to check.
	 * @param fileExtension Extension of files to check.
	 * @param expectedRoot Expected EMF root element of each file.
	 * @return <code>true</code> if the condition holds for all files, <code>false</code> otherwise.
	 */
	@SuppressWarnings("unchecked")
	private boolean checkFilesContainEmfModel(File directory,
			String fileExtension, Class expectedRoot) {
		assert (directory.isDirectory());
		
		ResourceSet resourceSet = SerializationUtil.createResourceSet();
		Resource resource;
		File[] files = directory.listFiles(new FilenameExtensionFiler(fileExtension));
		for (File file : files) {
			if (!file.isFile()) {
				// File is not a simple file
				return false;
			}
			resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
			if (resource == null) {
				// Error accessing the resource
				return false;
			}
			try {
				resource.load(null);
				if (resource.getWarnings().size() != 0 || resource.getErrors().size() != 0) {
					// There were warnings or errors while loading the file
					return false;
				}
				if (resource.getContents().size() != 1 || !expectedRoot.isInstance(resource.getContents().get(0))) {
					// There is more than one root or the root is not of the expected type 
					return false;
				}
			} catch (IOException e) {
				resourceSet = null;
				return false;
			}
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IEdp2Dao#close()
	 */
	@Override
	public void close() throws DataNotAccessibleException {
		super.close();
		// close directory
		URI uri;
		try {
			uri = URI.createURI(managedRepo.getUri());
			File directory = new File(uri.toFileString());
			if (!directory.isDirectory()) {
				String msg = "URI does not point to a directory.";
				logger.log(Level.WARNING, msg);
				throw new DataNotAccessibleException(msg, null);
			}
			// load descriptions
			saveDescriptions(directory);
			// load experiment groups
			saveExperimentGroups(directory);
			mmtDaoFactory.setActive(false);
			// Warning: Cannot clear lists as this would affect data on background storage
			managedRepo.resetDescriptions();
			managedRepo.resetExperimentGroups();
			setClosed();
		} catch (IllegalArgumentException e) {
			String msg = "URI is not valid.";
			logger.log(Level.WARNING, msg);
			throw new DataNotAccessibleException(msg, e);
		}
		assert (isOpen());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IEdp2Dao#delete()
	 */
	@Override
	public void delete() throws DataNotAccessibleException {
		super.delete();
		if (true) throw new UnsupportedOperationException("Not implemented yet");
		assert (isOpen());
		if (!isDeleted()) {
			// open directory
			URI uri;
			try {
				uri = URI.createURI(managedRepo.getUri());
				File directory = new File(uri.toFileString());
				if (!directory.isDirectory()) {
					String msg = "URI does not point to a directory.";
					logger.log(Level.WARNING, msg);
					throw new DataNotAccessibleException(msg, null);
				}
				// load experiment groups
				loadExperimentGroups(directory);
				/* Find all cross references.
				 * Delete all cross references which are in the directory of the MetaDao.
				 */
				Map<EObject, Collection<Setting>> references = EcoreUtil.CrossReferencer.find(managedRepo.getExperimentGroups());
				
//				DataSeries[] referencedDataSeries = null;
//				// TODO Auto-generated method stub
//				// Remove all DataSeries files
//				for (DataSeries dataSeries : referencedDataSeries) {
//					String dsFileLocation = directory.getAbsoluteFile()
//							+ File.separator
//							+ dataSeries.getValuesUuid()
//							+ EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION;
//					File dsFile = new File (dsFileLocation);
//					boolean success = dsFile.delete();
//					if (!success) {
//						logger.log(Level.WARNING, "Failed to delete DataSeries file. Filename: " + dsFileLocation);
//					}
//				}
				// Remove all ExperimentGroup files
				deleteExperimentGroups(directory);
				if (!directory.delete()) {
					logger.log(Level.WARNING, "Failed to delete EDP2 directory. Might be not empty. Directory: " + directory.getAbsolutePath());
				}
				mmtDaoFactory = null;
				setDeleted(true);
			} catch (IllegalArgumentException e) {
				String msg = "URI is not valid.";
				logger.log(Level.WARNING, msg);
				throw new DataNotAccessibleException(msg, e);
			}
		}
		assert (isDeleted());
}

	/**Deletes all ExperimentGroup files in a directory.
	 * @param directory The EDP2 data directory.
	 */
	private void deleteExperimentGroups(File directory) {
		// ExperimentGroup files
		File[] expGroupFiles = directory
				.listFiles(new FilenameExtensionFiler(
						EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION));
		for (File expGroupFile : expGroupFiles) {
			boolean success = expGroupFile.delete();
			if (!success) {
				logger.log(Level.WARNING,
						"Failed to delete ExperimentGroup file. Filename: "
								+ expGroupFile.getAbsolutePath());
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IEdp2Dao#open()
	 */
	@Override
	public void open() throws DataNotAccessibleException {
		super.open();
		// open directory
		URI uri;
		try {
			uri = URI.createURI(managedRepo.getUri());
			File directory = new File(uri.toFileString());
			if (!directory.isDirectory()) {
				String msg = "URI does not point to a directory.";
				logger.log(Level.WARNING, msg);
				throw new DataNotAccessibleException(msg, null);
			}
			if (managedRepo.getRepositories() == null) {
				String msg = "Every repository must be attached to an instance of Repositories in order to be opened.";
				logger.log(Level.SEVERE, msg);
				throw new DataNotAccessibleException(msg, null);
			}
			// load descriptions
			loadDescriptions(directory);
			// load experiment groups
			loadExperimentGroups(directory);
			mmtDaoFactory = LocalDirectoryMeasurementsDaoFactory.getRegisteredFactory(directory);
			if (mmtDaoFactory == null) { // DaoFactory not previously initialized
				mmtDaoFactory = new LocalDirectoryMeasurementsDaoFactory(directory);
			}
			setOpen();
		} catch (IllegalArgumentException e) {
			String msg = "URI is not valid.";
			logger.log(Level.WARNING, msg);
			throw new DataNotAccessibleException(msg, e);
		}
		assert (isOpen());
	}

	/**Loads all descriptions from the description files within the specified directory.
	 * @param directory The EDP2 data directory
	 */
	private void loadDescriptions(File directory) {
		File[] descriptionFiles = directory.listFiles(new FilenameExtensionFiler(EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION));
		for (File descriptionFile : descriptionFiles) {
			if (!descriptionFile.isFile()) {
				String msg = "Could not load the description file " + descriptionFile.getName();
				logger.log(Level.WARNING, msg);
			}
			loadDescription(descriptionFile);
		}
	}
	
	/**Saves all descriptions to description files within the specified directory.
	 * @param directory The EDP2 data directory.
	 */
	private void saveDescriptions(File directory) {
		for (Description desc : managedRepo.getDescriptions()) {
			saveDescription(directory, desc);
		}
	}

	/**Saves a description in the provided directory.
	 * @param directory The EDP2 data directory.
	 * @param desc The description to save.
	 */
	private void saveDescription(File directory, Description desc) {
		String descFileLocation = directory.getAbsoluteFile() + File.separator
				+ desc.getUuid() + "."
				+ EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION;
		Resource resource = managedRepo.getRepositories()
				.getCommonResourceSet().createResource(URI.createFileURI(descFileLocation));
		if (resource == null) {
			String msg = "Could not create resource to save the description file " + descFileLocation;
			logger.log(Level.WARNING, msg);
		} else {
			resource.getContents().add(desc);
			try {
				resource.save(null);
			} catch (IOException e) {
				String msg = "Could not save the description file " + descFileLocation;
				logger.log(Level.WARNING, msg, e);
			}
		}
	}

	/**Saves all experiment groups to files within the specified directory.
	 * @param directory The EDP2 data directory.
	 */
	private void saveExperimentGroups(File directory) {
		for (ExperimentGroup eg : managedRepo.getExperimentGroups()) {
			saveExperimentGroup(directory, eg);
		}
	}

	/**Saves an experiment group in the provided directory.
	 * @param directory The EDP2 data directory.
	 * @param expGroup The experiment group to save.
	 */
	private void saveExperimentGroup(File directory, ExperimentGroup expGroup) {
		String egFileLocation = directory.getAbsoluteFile() + File.separator
				+ expGroup.getUuid() + "."
				+ EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION;
		Resource resource = managedRepo.getRepositories()
				.getCommonResourceSet().createResource(URI.createFileURI(egFileLocation));
		if (resource == null) {
			String msg = "Could not create resource to save the experiment group file " + egFileLocation;
			logger.log(Level.WARNING, msg);
		} else {
			resource.getContents().add(expGroup);
			try {
				resource.save(null);
			} catch (IOException e) {
				String msg = "Could not save the experiment group file " + egFileLocation;
				logger.log(Level.WARNING, msg, e);
			}
		}
	}
	
	/**Loads the description stored in a description file.
	 * @param descriptionFile The description file containing the EMF model of the description.
	 */
	private void loadDescription(File descriptionFile) {
		assert (managedRepo.getRepositories() != null);
		Resource resource = managedRepo.getRepositories()
				.getCommonResourceSet().createResource(
						URI.createFileURI(descriptionFile.getAbsolutePath()));
		String errorMessage = null;
		try {
			resource.load(null);
			if (resource != null) {
				if (resource.getContents().size() == 1
						&& resource.getWarnings().size() == 0
						&& resource.getErrors().size() == 0) {
					if (new EmfmodelSwitch<Boolean>() {
									@Override
									public Boolean caseDescription(Description object) {
										return true;
									}
									@Override
									public Boolean defaultCase(EObject object) {
										return false;
									}
								}.doSwitch(resource.getContents().get(0)) == true) {
						managedRepo.getDescriptions().add((Description) resource.getContents().get(0));
					} else {
						errorMessage = "Root model element was not of type Description.";
					}
				} else {
					errorMessage = "There was more or less than one root element or there were errors parsing the file.";
				}
			}
		} catch (IOException e) {
			errorMessage = "Could not load EMF model. Reason: " + e.getMessage();
		}
		if (errorMessage != null) {
			logger.log(Level.WARNING, errorMessage + " Filename: " + descriptionFile.getAbsolutePath() + ".");
		}
	}

	/**Loads all experiment groups from the description files within the specified directory.
	 * @param directory The EDP2 data directory
	 */
	private void loadExperimentGroups(File directory) {
		File[] expGroupFiles = directory.listFiles(new FilenameExtensionFiler(EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION));
		for (File expGroupFile : expGroupFiles) {
			if (!expGroupFile.isFile()) {
				String msg = "Could not load the experiment group file " + expGroupFile.getName();
				logger.log(Level.WARNING, msg);
			}
			loadExperimentGroup(expGroupFile);
		}
	}

	/**Loads the experiment group stored in a description file.
	 * @param expGroupFile The experiment group file containing the EMF model of the description.
	 */
	private void loadExperimentGroup(File expGroupFile) {
		Resource resource = managedRepo.getRepositories()
				.getCommonResourceSet().createResource(
						URI.createFileURI(expGroupFile.getAbsolutePath()));
		String errorMessage = null;
		try {
			resource.load(null);
			if (resource != null) {
				if (resource.getContents().size() == 1
						&& resource.getWarnings().size() == 0
						&& resource.getErrors().size() == 0) {
					if (new EmfmodelSwitch<Boolean>() {
								@Override
								public Boolean caseExperimentGroup(ExperimentGroup object) {
									return true;
								}
								@Override
								public Boolean defaultCase(EObject object) {
									return false;
								}
							}.doSwitch(resource.getContents().get(0)) == true) {
						managedRepo.getExperimentGroups().add((ExperimentGroup) resource.getContents().get(0));
					} else {
						errorMessage = "Root model element was not of type ExperimentGroup.";
					}
				} else {
					errorMessage = "There was more or less than one root element or there were errors parsing the file.";
				}
			}
		} catch (IOException e) {
			errorMessage = "Could not load EMF model.";
		}
		if (errorMessage != null) {
			logger.log(Level.WARNING, errorMessage + " Filename: " + expGroupFile.getAbsolutePath() + ".");
		}
	}
	
	/**EMF Adapter class to generate file-based resources within a local directory for
	 * a given structural feature containing a list of Identifiable elements. 
	 * @author groenda
	 *
	 */
	private final class LocalDirectoryMetaResourceAdapter extends AdapterImpl {
		/** Local directory repository which contains the feature. */
		private final LocalDirectoryRepository repo;
		/** Structural feature which is observed. */
		private EStructuralFeature feature;
		/** File extension to use for generating the resources. */
		private String fileExtension;

		private LocalDirectoryMetaResourceAdapter(
				LocalDirectoryRepository repo, EStructuralFeature feature,
				String fileExtension) {
			this.repo = repo;
			this.feature = feature;
			this.fileExtension = fileExtension;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature().equals(feature)) {
				if (msg.getEventType() == Notification.ADD) {
					Identifiable id = (Identifiable) msg.getNewValue();
					assignResource(id);
				}
				if (msg.getEventType() == Notification.ADD_MANY) {
					for (Identifiable id : (Collection<Identifiable>) msg
							.getNewValue()) {
						assignResource(id);
					}
				}
				if (msg.getEventType() == Notification.REMOVE) {
					Identifiable id = (Identifiable) msg.getOldValue();
					removeResource(id);
				}
				if (msg.getEventType() == Notification.REMOVE_MANY) {
					for (Identifiable id : (Collection<Identifiable>) msg
							.getOldValue()) {
						removeResource(id);
					}
				}
			}
		}

		/**Assigns a resource to the identifiable (if is does not have a resource yet).
		 * @param id Identifiable.
		 */
		private void assignResource(Identifiable id) {
			if (id.eResource() == null) {
				URI uri = URI
						.createURI(repo.getUri())
						.appendSegment(id.getUuid())
						.appendFileExtension(fileExtension);
				Resource resource = repo.getRepositories()
						.getCommonResourceSet().createResource(uri);
				resource.getContents().add(id);
				Assert.isNotNull(id.eResource());
			}
		}
		
		/**Removes a resource from an identifiable (if it has a resource).
		 * @param id Identifiable.
		 */
		private void removeResource(Identifiable id) {
			if (id.eResource() != null) {
				try {
					id.eResource().delete(null);
				} catch (IOException e) {
					logger.log(Level.WARNING, "Could not delete file for a removed element. " + e.getMessage());
				}
			}
		}
	}

	/**Filename filter which accepts all files with a given extension.
	 * @author groenda
	 */
	class FilenameExtensionFiler implements FilenameFilter {
		/** Valid extension of the files. */
		private String extension;
		
		/**Initializes the filter and sets the accepted extension.
		 * @param extension Accepted extension.
		 */
		public FilenameExtensionFiler(String extension) {
			this.extension = extension;
		}

		@Override
		public boolean accept(File arg0, String arg1) {
			return arg1.endsWith(extension);
		}
	}
}
