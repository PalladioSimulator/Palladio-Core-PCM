package de.uka.ipd.sdq.cip;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;


/**
 * Encapsulated an PCM instance.
 * @author Lucka
 *
 */
public class PCMInstance {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger(PCMInstance.class.getName());

	
    private Repository repository;
    private System system;
    private Allocation allocation;
    private ResourceEnvironment resourceenvironment;
    
    private ResourceType resourcetype;
    private Repository mwRepository;
	private String storagePath;
	private ResourceRepository resourceRepository;
	private UsageModel usageModel;

	private String allocationFileName;

	private String repositoryFileName;

	private String resourceRepositoryFileName;

	private String usageModelFileName;

	private String systemFileName;
    
    public PCMInstance(){
    	super();
    }
    
    /**
     * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
     * @param configuration Config given by Eclipse
     */
    public PCMInstance(final ILaunchConfiguration configuration) {
		//this.usage = ComputedUsageFactory.eINSTANCE.createComputedUsage();
		//this.actualAllocation = ComputedAllocationFactory.eINSTANCE.createComputedAllocation();
		try {
			this.storagePath = configuration.getAttribute("outputPath", ".");
			
			String filename = configuration.getAttribute(ConstantsContainer.ALLOCATION_FILE, "");
			this.allocation = ((Allocation) loadFromXMIFile(filename));
			this.allocationFileName = filename;
			
			filename = configuration.getAttribute(ConstantsContainer.REPOSITORY_FILE, "");
			this.repository = ((Repository) loadFromXMIFile(filename));
			this.repositoryFileName = filename;
			this.resourceenvironment = this.allocation.getTargetResourceEnvironment_Allocation();
			
			filename = configuration.getAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, "");
			this.resourceRepository = ((ResourceRepository) loadFromXMIFile(filename));
			this.resourceRepositoryFileName = filename;
			
			filename = configuration.getAttribute(ConstantsContainer.USAGE_FILE, "");
			this.usageModel = ((UsageModel) loadFromXMIFile(filename));
			this.usageModelFileName = filename;
			
			this.system = this.allocation.getSystem_Allocation();
			this.systemFileName = configuration.getAttribute(ConstantsContainer.SYSTEM_FILE, "");
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

    /**
     * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
     * @param fileName the filename specifying the file to load from 
     * @return The EObject loaded from the file
     */
	private EObject loadFromXMIFile(final String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		registerPackages(resourceSet);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		Resource resource = null;
		// Demand load resource for this file.
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

		//logger.debug("Loaded " + uri);

//		if (!fileName.endsWith(".assembly") &&
//		    !fileName.endsWith("repository")) {
//			// Validate the contents of the loaded resource.
//			for (Iterator j = resource.getContents().iterator(); j.hasNext();) {
//				EObject eObject = (EObject) j.next();
//				Diagnostic diagnostic = Diagnostician.INSTANCE
//						.validate(eObject);
//				if (diagnostic.getSeverity() != Diagnostic.OK) {
//					System.out.println();
//					System.out.println(diagnostic.getMessage());
//					// printDiagnostic(diagnostic, "");
//					
//				}
//			}
//		}
		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * @param resourceSet The resource set to register all contained model packages with. 
	 */
	private void registerPackages(final ResourceSet resourceSet) {

		resourceSet.getPackageRegistry().put(AllocationPackage.eNS_URI,
				AllocationPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ParameterPackage.eNS_URI,
				ParameterPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				ResourceenvironmentPackage.eNS_URI,
				ResourceenvironmentPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ResourcetypePackage.eNS_URI,
				ResourcetypePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI,
				RepositoryPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SeffPackage.eNS_URI,
				SeffPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SystemPackage.eNS_URI,
				SystemPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(UsagemodelPackage.eNS_URI,
				UsagemodelPackage.eINSTANCE);

	}

	/**
	 * Save the contained models back to xmi Files. 
	 */
	public void saveToFiles() {
		//fileNamePrefix = storagePath + "\\" + fileNamePrefix;
		//java.lang.System.out.println(storagePath);
		saveToXMIFile(allocation, allocationFileName); //fileNamePrefix+".allocation");
		saveToXMIFile(repository, repositoryFileName); //fileNamePrefix+".repository");
		//saveToXMIFile(resourceenvironment, fileNamePrefix+".resourceenvironment");
		//saveToXMIFile(resourceRepository, resourceRepositoryFileName); //fileNamePrefix+".resourcetype");
		saveToXMIFile(system, systemFileName); //fileNamePrefix+".system");
		saveToXMIFile(usageModel, usageModelFileName); //fileNamePrefix+".usagemodel");
		
		//saveToXMIFile(usage, fileNamePrefix+".usage");
		//saveToXMIFile(actualAllocation, fileNamePrefix+".actualallocation");
		
	}
	
	/**
	 * Save the given EObject to the file given by filename. 
	 * @param modelToSave The EObject to save
	 * @param fileName The filename where to save. 
	 */
	private void saveToXMIFile(final EObject modelToSave, final String fileName) {
		java.lang.System.out.println("Saving " + modelToSave.toString() + " to " + fileName);
		
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(modelToSave);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
	//		logger.error(e.getMessage());
		}
		//logger.debug("Saved " + fileURI);
	}
    
	/**
	 * Initialise this PCM instance with the given models. 
	 * @param repository 
	 * @param system
	 * @param allocation
	 * @param resourceenvironment
	 * @param resourcetype
	 * @param mwRepository
	 */
	public PCMInstance(Repository repository, System system,
			Allocation allocation, ResourceEnvironment resourceenvironment,
			ResourceType resourcetype, Repository mwRepository) {
		super();
		this.repository = repository;
		this.system = system;
		this.allocation = allocation;
		this.resourceenvironment = resourceenvironment;
		this.resourcetype = resourcetype;
		this.mwRepository = mwRepository;
	}
    
	
	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	public ResourceEnvironment getResourceenvironment() {
		return resourceenvironment;
	}

	public void setResourceenvironment(ResourceEnvironment resourceenvironment) {
		this.resourceenvironment = resourceenvironment;
	}

	public ResourceType getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(ResourceType resourcetype) {
		this.resourcetype = resourcetype;
	}

	public Repository getMwRepository() {
		return mwRepository;
	}

	public void setMwRepository(Repository mwRepository) {
		this.mwRepository = mwRepository;
	}


    
    
    
	
	
}
