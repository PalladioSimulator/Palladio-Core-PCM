package de.uka.ipd.sdq.workflow.pcm.blackboard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * This class is a specialised MDSDBlackboard partition which is specialised to load and hold PCM model 
 * instances. Currently, the PCM instance is loaded as a list of files, each file containing a part of the PCM
 * model. In future versions of this class it should be sufficient to specify a PCM System and a PCM UsageModel. All
 * other model parts can then be derived automatically.
 * 
 * @author Steffen Becker
 *
 */
public class PCMResourceSetPartition extends ResourceSetPartition {
	
	/**
	 * @return Returns the PCM repository instance of the PCM model
	 */
	public Repository getRepository() {
		// TODO: Allow using multiple Repositories, derive the list of repositories automatically
		return (Repository) getElement(RepositoryPackage.eINSTANCE.getRepository());
	}

	/**
	 * @return Returns a PCM Repository which contains components of Steffen's and Jens' middleware completions
	 */
	public Repository getMiddlewareRepository() {
		return (Repository) getElement(RepositoryPackage.eINSTANCE.getRepository());
	}

	/**
	 * @return Returns the feature configuration which annotates connectors with their technical realisation
	 */
	public Configuration getFeatureConfig() {
		return (Configuration) getElement(featureconfigPackage.eINSTANCE.getConfiguration());
	}

	/**
	 * @return Returns the PCM system instance of the stored PCM model
	 */
	public System getSystem() {
		return (System) getElement(SystemPackage.eINSTANCE.getSystem());
	}

	/**
	 * @return Returns the PCM system's allocation model
	 */
	public Allocation getAllocation() {
		return (Allocation) getElement(AllocationPackage.eINSTANCE.getAllocation());
	}

	/**
	 * @return Returns the PCM usage model of the PCM model in this blackboard partition
	 */
	public UsageModel getUsageModel() {
		return (UsageModel) getElement(UsagemodelPackage.eINSTANCE.getUsageModel());
	}

	/**
	 * @return Returns the PCM Resource Type Repository used by the stored PCM model instance
	 */
	public ResourceRepository getResourceTypeRepository() {
		return (ResourceRepository) getElement(ResourcetypePackage.eINSTANCE.getResourceRepository());
	}
	
	/**
	 * @return Returns the PCM Resource Environment used by the stored PCM model instance
	 */
	public ResourceEnvironment getResourceEnvironment() {
		return (ResourceEnvironment) getElement(ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment());
	}
	
	
	/**
	 * Helper to find root object of specified class
	 * @param clazz 
	 */
	private EObject getElement(EClass clazz) {
		for (Resource r : this.rs.getResources()) {
			if (r.getContents().get(0).eClass() == clazz ) {
				return r.getContents().get(0);
			}
		}
		throw new RuntimeException("Failed to retrieve PCM model element");
	}

}
