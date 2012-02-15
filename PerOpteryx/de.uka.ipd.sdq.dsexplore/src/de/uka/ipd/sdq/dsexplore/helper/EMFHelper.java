package de.uka.ipd.sdq.dsexplore.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * Also see {@link EcoreUtil} for more helper functions 
 * like {@link EcoreUtil#equals(EObject, EObject)} to 
 * test for equality. 
 * @author martens
 *
 */
public class EMFHelper {
	
	/**
	 * Checks for two PCM model elements whether they are the same, i.e. whether
	 * they have the same ID. The model elements have to be derived from
	 * Identifier. Note that two systems might use the same assembly contexts
	 * and components, but still are two different systems. If one of the 
	 * Identifiers in null, false is returned. 
	 * 
	 * @param i1
	 *            One Identifier
	 * @param i2
	 *            Another Identifier
	 * @return true if i1.getId().equals(i2.getId()), false otherwise
	 */
	public static boolean checkIdentity(EObject i1, EObject i2) {
		if (i1 == null || i2 == null)
			return false;
		if (i1 instanceof Identifier && i2 instanceof Identifier){
			if (((Identifier) i1).getId().equals(((Identifier) i2).getId())) {
				// logger.debug("Two model elements match with Id: "+i1.getId());
				return true;
			} else {
				return false;
			}} else {
				return EcoreUtil.equals(i1, i2);
			}
	}
	
	/**
	 * Implements an identifier-based contains. Calls {@link #checkIdentity(Identifier, Identifier)}
	 * to compare the {@link Identifier} i with the contents of the collection. 
	 * 
	 * @param coll
	 * @param i
	 * @return true if there is an {@link Identifier} in coll with an id equal to i.getID().
	 */
	public static boolean contains(Collection<? extends EObject> coll, EObject i){
		for (EObject identifier : coll) {
			if (checkIdentity(identifier, i)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean retainAll(Collection<? extends Identifier> collection, Collection<? extends EObject> itemsToRetain){
		boolean removedAny = false;
		for (Iterator<? extends Identifier> iterator = collection.iterator(); iterator.hasNext();) {
			Identifier identifier = iterator.next();
			boolean identifierContainedInItemsToRetain = false;
			for (EObject identifierToRetain : itemsToRetain) {
				if (checkIdentity(identifier, identifierToRetain)){
					identifierContainedInItemsToRetain = true;
				}
			}
			if (!identifierContainedInItemsToRetain){
				iterator.remove();
				removedAny = true;
			}
		}
		return removedAny;
	}
	
	/**
	 * Save the given EObject to the file given by filename.
	 * 
	 * @param modelToSave
	 *            The EObject to save
	 * @param fileName
	 *            The filename where to save.
	 */
	public static void saveToXMIFile(final EObject modelToSave, final String fileName) {
		
		Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");
		
		logger.debug("Saving " + modelToSave.toString() + " to " + fileName);

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
		} catch (FileNotFoundException e){
			if (fileName.length() > 250){
				//try again with a shorter filename
				saveToXMIFile(modelToSave, fileName.substring(0, fileName.indexOf("-"))+"-shortened-"+fileName.hashCode());
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		// logger.debug("Saved " + fileURI);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param fileName
	 *            the filename specifying the file to load from
	 * @return The EObject loaded from the file
	 */
	public static EObject loadFromXMIFile(final String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		registerPackages(resourceSet);
		
		return loadFromXMIFile(fileName, resourceSet);
	}

	public static EObject loadFromXMIFile(final String fileName, ResourceSet resourceSet){
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
			Logger.getLogger("de.uka.ipd.sdq.dsexplore").error(e.getMessage());
			return null;
		}

		// logger.debug("Loaded " + uri);

		// if (!fileName.endsWith(".assembly") &&
		// !fileName.endsWith("repository")) {
		// // Validate the contents of the loaded resource.
		// for (Iterator j = resource.getContents().iterator(); j.hasNext();) {
		// EObject eObject = (EObject) j.next();
		// Diagnostic diagnostic = Diagnostician.INSTANCE
		// .validate(eObject);
		// if (diagnostic.getSeverity() != Diagnostic.OK) {
		// System.out.println();
		// System.out.println(diagnostic.getMessage());
		// // printDiagnostic(diagnostic, "");
		//					
		// }
		// }
		// }
		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param resourceSet
	 *            The resource set to register all contained model packages
	 *            with.
	 */
	private static void registerPackages(final ResourceSet resourceSet) {

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
	
	public static Entity retrieveEntityByID(List<? extends EObject> entities, EObject object){
		if (object instanceof Entity){
			List<Entity> castedEntities = new ArrayList<Entity>();
			for (EObject eObject : entities) {
				if (eObject instanceof Entity){
					castedEntities.add((Entity) eObject);
				}
			}
			return retrieveEntityByID(castedEntities, ((Entity)object).getId());
		}
		return null;
	}
	
	public static Entity retrieveEntityByID(List<? extends Entity> entities, String id) {
		for (Entity entity : entities) {
			
			if (entity.getId().equals(id)){
				return entity;
			}
		}
		return null;
	}
	
	public static int indexOfByID(List<? extends Entity> entities, String id) {
		Entity entity = retrieveEntityByID(entities, id);
		return entities.indexOf(entity);
	}

	public static Candidates createEMFCandidates(Collection<DSEIndividual> individuals) {
		Candidates candidates = designdecisionFactory.eINSTANCE.createCandidates();
		candidates.setProblem(Opt4JStarter.getProblem().getEMFProblem());
		
		for (DSEIndividual dseIndividual : individuals) {
			candidates.getCandidate().add(dseIndividual.getGenotype().getEMFCandidate());
		}
		return candidates;
	}
	
	public static List<PassiveResource> getPassiveResources(List<Repository> repositoryList){


		List<PassiveResource> passiveResourceList = new ArrayList<PassiveResource>(repositoryList.size());

		for (Repository repository : repositoryList) {
			List<RepositoryComponent> repoComponents = repository
					.getComponents__Repository();
			for (RepositoryComponent repositoryComponent : repoComponents) {
				if (repositoryComponent instanceof BasicComponent) {
					BasicComponent basicComponent = (BasicComponent) repositoryComponent;
					List<PassiveResource> passiveResourceOfComponentList = basicComponent
							.getPassiveResource_BasicComponent();
					for (PassiveResource passiveResource : passiveResourceOfComponentList) {

						passiveResourceList.add(passiveResource);
					}
					
				}
			}
		}
		return passiveResourceList;
	}
	
	/** Recursively get all contained AssemblyContexts in one flat list. 
	 * */
	public static List<AssemblyContext> getAllUsedAssemblyContexts(ComposedProvidingRequiringEntity composite){
		List<AssemblyContext> resultList = new LinkedList<AssemblyContext>();
		
		List<AssemblyContext> currentAssemblyContexts = composite.getAssemblyContexts__ComposedStructure();
		resultList.addAll(currentAssemblyContexts);
		
		for (AssemblyContext assemblyContext : currentAssemblyContexts) {
			RepositoryComponent innerComponent = assemblyContext.getEncapsulatedComponent__AssemblyContext();
			if (innerComponent instanceof ComposedProvidingRequiringEntity){
				resultList.addAll(getAllUsedAssemblyContexts((ComposedProvidingRequiringEntity) innerComponent));
			}
		}
		return resultList;
		
	}

	public static List<AllocationContext> getAllUsedAllocationContexts(
			Allocation allocation) {
		return allocation.getAllocationContexts_Allocation();
	}
	
}
