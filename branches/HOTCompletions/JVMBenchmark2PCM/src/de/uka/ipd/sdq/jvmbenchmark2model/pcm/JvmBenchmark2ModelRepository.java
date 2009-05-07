package de.uka.ipd.sdq.jvmbenchmark2model.pcm;

import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.pcm.repository.AbstractInterface;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;


public class JvmBenchmark2ModelRepository {
	
	private Repository repository;
	private RepositoryFactory repositoryFactory;
	private ResourcetypeFactory resourcetypeFactory;
	
	//private static final String MIDDLEWAREINTERFACEREPOSITORY_FILE = "de.uka.ipd.sdq.pcm.resources/MiddlewareInterfaces.repository";
	private static final String MIDDLEWAREINTERFACEREPOSITORY_FILE = "MiddlewareInterfaces.repository";
	//private static final String RESOURCEINTERFACES_FILE = "de.uka.ipd.sdq.pcm.resources/ResourceInterfaces.repository";
	private static final String RESOURCEINTERFACES_FILE = "ResourceInterfaces.repository";
	private static final String CPU_RESOURCEINTERFACE_NAME = "ICpu";
	private static final String JVM_RESOURCEINTERFACE_NAME = "IJvm";
	private Repository resourceInterfaceRepository;
	private Repository middlewareInterfaceRepository;
	
	public static ResourceInterface CPU_RESOURCEINTERFACE;
	public static ResourceInterface JVM_RESOURCEINTERFACE;
	
	private static Logger logger = Logger.getLogger(JvmBenchmark2ModelRepository.class);

	public JvmBenchmark2ModelRepository() {
		
		this.repositoryFactory = RepositoryFactory.eINSTANCE;
		this.resourcetypeFactory = ResourcetypeFactory.eINSTANCE;
		this.repository = this.repositoryFactory.createRepository();
		
		createInitialResources();
		
	}
	
	/**
	 * Save the repository, and thus the created {@link ResourceDemandingSEFF}s,
	 * to an XML file using Eclipse's EMF framework.
	 * 
	 * @param repositoryURI
	 *            the URI of the file to be saved to
	 * @param repositoryName
	 *            the name of the repository
	 */
	public void save(URI fileURI, String repositoryName) throws IOException {
		logger.info("Saving repositories to " + fileURI.toFileString());

		ResourceSet resourceSet = getResourceSetForURI();

		this.repository.setEntityName(repositoryName);
		URI repositoryURI = fileURI;
		repositoryURI = repositoryURI.appendFileExtension("repository");
		// Create a resource for this file.
		Resource resource = resourceSet.createResource(repositoryURI);
		// Add object to the contents.
		resource.getContents().add(this.repository);
		resource.save(Collections.EMPTY_MAP);
	}

	private ResourceSet getResourceSetForURI() {
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		return resourceSet;
	}
	
	/**
     * Load an XMI file, such as a resourcetype repository.
     * 
     * @param fileName the path to the file, relative inside Eclipse
     * @return the corresponding {@link EObject}
     */
    private EObject loadFromXMIFile(String fileName, ResourceSet resourceSet) {
		// Probably this works only when run as a plugin
		//URI fileURI = URI.createPlatformPluginURI(fileName, true);
		URI fileURI = URI.createFileURI("C:/pcm_dev_workspace/de.uka.ipd.sdq.pcm.resources/defaultModels/" + fileName);

		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	/**
	 * Create the resources to be associated later to internal actions.
	 * <p>
	 * So far, the resources created are:
	 * <ul>
	 * <li>CPU, written to {@link #CPU_RESOURCETYPE}</li>
	 * <li>Hard disk, written to {@link #IO_RESOURCETYPE}</li>
	 * <li>Console (for System.out output), written to
	 * {@link #OUTPUT_RESOURCETYPE}</li>
	 * </ul>
	 * </p>
	 */
	private void createInitialResources() {
		ResourceSet resourceSet = createResourceSet();
		
		this.resourceInterfaceRepository = (Repository) 
				loadFromXMIFile(RESOURCEINTERFACES_FILE, resourceSet);
		if (this.resourceInterfaceRepository == null) {
			logger.error("Failed to load resource interface repository!");
			return;
		}
		for (AbstractInterface abstractInterface : this.resourceInterfaceRepository.getInterfaces__Repository()) {
			if (abstractInterface.getClass().equals(ResourceInterfaceImpl.class)) {
				String name = abstractInterface.getEntityName();
				if (name.equals(CPU_RESOURCEINTERFACE_NAME)) {
					CPU_RESOURCEINTERFACE = (ResourceInterface)abstractInterface; 
				}
			}
		}
		
		resourceSet = createResourceSet();
		this.middlewareInterfaceRepository = (Repository) 
				loadFromXMIFile(MIDDLEWAREINTERFACEREPOSITORY_FILE, resourceSet);
		for (AbstractInterface abstractInterface : this.middlewareInterfaceRepository.getInterfaces__Repository()) {
			if (abstractInterface.getClass().equals(ResourceInterfaceImpl.class)) {
				String name = abstractInterface.getEntityName();
				if (name.equals(JVM_RESOURCEINTERFACE_NAME)) {
					JVM_RESOURCEINTERFACE = (ResourceInterface)abstractInterface; 
				}
			}
		}
	}
	
	private ResourceSet createResourceSet() {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI,
				RepositoryPackage.eINSTANCE);
		return resourceSet;
	}
	
	/**
	 * Create a new {@link BasicComponent}. An interface with the same name is
	 * looked up and, if present, provided by the new component.
	 * 
	 * @param name
	 *            the name of the component
	 */
	public BasicComponent createJvmComponent(String name) {
		logger.info("New component: " + name);		
		
		BasicComponent comp = repositoryFactory.createBasicComponent();
		comp.setEntityName(name);
		
		ResourceRequiredRole resourceRequiredRole = resourcetypeFactory.createResourceRequiredRole();
		resourceRequiredRole.setEntityName(CPU_RESOURCEINTERFACE.getEntityName());
		resourceRequiredRole.setRequiredResourceInterface_ResourceRequiredRole(CPU_RESOURCEINTERFACE);		
		resourceRequiredRole.setResourceRequiringEntity_ResourceRequiredRole(comp);
		
		ProvidedRole pr = repositoryFactory.createProvidedRole();
		pr.setEntityName(JVM_RESOURCEINTERFACE.getEntityName());
		pr.setProvidedInterface__ProvidedRole(JVM_RESOURCEINTERFACE);
		pr.setProvidingEntity_ProvidedRole(comp);
		
		comp.setRepository_RepositoryComponent(repository);
		return comp;
	}
}
