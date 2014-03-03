package de.uka.ipd.sdq.edp2;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * The EDP2 plugin. The plugin persists created Repositories in its meta data location
 * and allows to access these.
 *       
 * @author Sebastian Lehrig
 */
public class EDP2Plugin extends Plugin {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(EDP2Plugin.class.getCanonicalName());
	
	/** Setting: Should there be an initial population or mock-up data of repositories? */
	private static String SETTING_INITIALLY_POPULATE_REPOSITORY = "populate_repository";
	
	/** The plug-in ID. */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.edp2";
    
    /** Instance of this plugin. */
	public static EDP2Plugin INSTANCE;
	
	/** Metadata location for persistent repositories storage. */
	private static final String METADATA_LOCATION_REPOSITORIES = "platform:/meta/"+PLUGIN_ID+"/repositories.edp2";
	
	/** Resource set used to persist repositories. */
    ResourceSet rs = new ResourceSetImpl();
    
    /** Resource used to persist repositories. */
    Resource resource = null;
    
	/**
	 * Constructor.
	 */
	public EDP2Plugin() {
		// initialize	    
		IScopeContext context = new ConfigurationScope();
		IEclipsePreferences node = context.getNode(PLUGIN_ID);
		Boolean populate = false;
		if (node != null) {
			populate = node.getBoolean(SETTING_INITIALLY_POPULATE_REPOSITORY, false);
			node.putBoolean(SETTING_INITIALLY_POPULATE_REPOSITORY, populate);
			try {
				node.flush();
			} catch (BackingStoreException e) {
				logger.log(Level.SEVERE, "Could not load/store preferences. ", e);
			}
		}
		if (populate) {
			populateRepository();
		}
		
		INSTANCE = this;		
	}

	/* (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);      
        
        // initialize persistent repositories storage
        initializeResource();
        initializeRepositories();
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        saveRepositories();
        super.stop(context);
    }
    
	/**
	 * Initializes available repositories based on this plugin's data file for
	 * persistent storage.
	 * 
	 * @param context This plugin's bundle context
	 */
	private void initializeRepositories() {	    
	    try {	        
	        Repositories repositories = (Repositories) resource.getContents().get(0);
	        	        
	        getRepositories().getAvailableRepositories().addAll(repositories.getAvailableRepositories());
	        for (Repository repo : getRepositories().getAvailableRepositories()) {
                if (repo.canOpen()) {
                    try {
                        repo.open();
                    } catch (DataNotAccessibleException e) {
                        logger.log(Level.WARNING, "Could not open repository after reloading. Repository is " + repo);
                    }
                }
            }
        } catch (Exception e) {
            logger.warning("No preexisting EDP2 dataset configuration file. Resetting configuration...");
            if (getRepositories().getAvailableRepositories().size() == 0) {
                // TODO add EDP2 main memory repository once available
            }
        }
    }

	/**
	 * Stores available repositories into this plugin's data file for
     * persistent storage.
     * 
	 * @param context This plugin's bundle context
	 */
	private void saveRepositories() {
	    resource.getContents().clear();
	    resource.getContents().add(getRepositories());
	    try {
	        resource.save(Collections.EMPTY_MAP);
	    } catch (IOException e) {
	        logger.warning("Saving dataset configuration failed.");
	    }
    }
	
	/**
	 * Initializes the resource for persistent repositories storage. Creates
	 * The resource if it did not exist.
	 */
	private void initializeResource() {
	    // register repositories package for persistent storage        
        rs.getPackageRegistry().put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
        
        //File file = context.getDataFile(PLUGIN_ID);
        URI uri = URI.createURI(METADATA_LOCATION_REPOSITORIES, true);
        
        try {
            resource = rs.getResource(uri, true);
        }
        catch (Exception e) {
            resource = rs.createResource(uri);
        }
	}
	
    /**
	 * Populates the repositories instance with mock-up data.
	 * Only used and important for testing. Creation is controlled via a properties file.
	 */
	private void populateRepository() {
		RepositoryFactory repoFactory = RepositoryFactory.eINSTANCE;
		Repositories repos = getRepositories();
		
		LocalDirectoryRepository ldRepo = repoFactory.createLocalDirectoryRepository();
		ldRepo.setUri(URI.createPlatformPluginURI("/de.uka.ipd.sdq.edp2.examples/LocalRepository", true).toString());
		RepositoryManager.addRepository(repos, ldRepo);
		
		RemoteCdoRepository rcRepo = repoFactory.createRemoteCdoRepository();
		rcRepo.setUrl("tcp://localhost:2036");
		RepositoryManager.addRepository(repos, rcRepo);
		
		LocalMemoryRepository lmRepo = repoFactory.createLocalMemoryRepository();
		lmRepo.setDomain("Domain 1");
		RepositoryManager.addRepository(repos, lmRepo);
		
		LocalSensorFrameworkRepository lsfRepo = repoFactory.createLocalSensorFrameworkRepository();
		RepositoryManager.addRepository(repos, lsfRepo);
	}

	/**
	 * Central method for receiving repositories.
	 * 
	 * @return The Repositories instance containing all available repositories.
	 */
	public Repositories getRepositories() {
		return RepositoryManager.getCentralRepository();
	}

}
