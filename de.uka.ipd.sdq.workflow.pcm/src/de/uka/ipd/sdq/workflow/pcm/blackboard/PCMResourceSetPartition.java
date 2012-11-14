package de.uka.ipd.sdq.workflow.pcm.blackboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.featureconfigFactory;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemFactory;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;
import de.uka.ipd.sdq.workflow.Blackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * This class is a specialised MDSDBlackboard partition which is specialised to load and hold PCM model
 * instances. Currently, the PCM instance is loaded as a list of files, each file containing a part of the PCM
 * model. It is sufficient to specify a PCM Allocation and a PCM UsageModel. All
 * other model parts can then be derived automatically.
 *
 * Note that there is no specialised {@link Blackboard} for PCMResourceSetPartitions, because
 * usually, the Blackboard containing the PCM might contain other models, for example SAAM models
 * when transforming one into the other.
 *
 *
 * @author Steffen Becker
 *
 */
public class PCMResourceSetPartition extends ResourceSetPartition {

	/**
	 * @return Returns the PCM repository instance of the PCM model
	 */
	public List<Repository> getRepositories() {
		// TODO: Allow using multiple Repositories, derive the list of repositories automatically
		List<Repository> allRepositories = getElement(RepositoryFactory.eINSTANCE.createRepository());
		Iterator<Repository> iterator = allRepositories.iterator();
		List<Repository> resultList = new ArrayList<Repository>();
		while(iterator.hasNext()) {
			resultList.add((Repository)iterator.next());
		}
		return resultList;
	}

	/**
	 * @return Returns a PCM Repository which contains components of Steffen's and Jens' middleware completions
	 */
	public Repository getMiddlewareRepository() {
		return (Repository) getElement(RepositoryFactory.eINSTANCE.createRepository()).get(0);
	}

	/**
	 * @return Returns the feature configuration which annotates connectors with their technical realisation
	 */
	public Configuration getFeatureConfig() {
		return (Configuration) getElement(featureconfigFactory.eINSTANCE.createConfiguration()).get(0);
	}

	/**
	 * @return Returns the PCM system instance of the stored PCM model
	 */
	public System getSystem() {
		return (System) getElement(SystemFactory.eINSTANCE.createSystem()).get(0);
	}

	/**
	 * @return Returns the PCM system's allocation model
	 */
	public Allocation getAllocation() {
		return (Allocation) getElement(AllocationFactory.eINSTANCE.createAllocation()).get(0);
	}

	/**
	 * @return Returns the PCM usage model of the PCM model in this blackboard partition
	 */
	public UsageModel getUsageModel() {
		return (UsageModel) getElement(UsagemodelFactory.eINSTANCE.createUsageModel()).get(0);
	}

	/**
	 * @return Returns the PCM Resource Type Repository used by the stored PCM model instance
	 */
	public ResourceRepository getResourceTypeRepository() {
		return (ResourceRepository) getElement(ResourcetypeFactory.eINSTANCE.createResourceRepository()).get(0);
	}

	/**
	 * @return Returns the PCM Resource Environment used by the stored PCM model instance
	 */
	public ResourceEnvironment getResourceEnvironment() {
		return (ResourceEnvironment) getElement(ResourceenvironmentFactory.eINSTANCE.createResourceEnvironment()).get(0);
	}

	/**
	 * Helper to find root objects of a specified class.
	 *
	 * @param clazz The class to get elements for.
	 * @return The list of found root elements. Empty list if none have been found.
	 */
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getElement(final T targetType) {
		ArrayList<T> result = new ArrayList<T>();
		for (Resource r : rs.getResources()) {
			if (r != null && r.getContents().size() > 0 && r.getContents().get(0).eClass() == targetType.eClass() ) {
				result.add((T) r.getContents().get(0));
			}
		}
		if (result.size() == 0)
			throw new RuntimeException("Failed to retrieve PCM model element "+targetType.eClass().getName());
		else
			return result;
	}

}
