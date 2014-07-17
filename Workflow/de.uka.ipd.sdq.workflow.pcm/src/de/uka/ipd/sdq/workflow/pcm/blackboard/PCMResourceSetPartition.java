package de.uka.ipd.sdq.workflow.pcm.blackboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import de.uka.ipd.sdq.workflow.blackboard.Blackboard;
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
        final List<Repository> allRepositories = getElement(RepositoryPackage.eINSTANCE.getRepository());
        final Iterator<Repository> iterator = allRepositories.iterator();
        final List<Repository> resultList = new ArrayList<Repository>();
        while(iterator.hasNext()) {
            resultList.add(iterator.next());
        }
        return resultList;
    }

    /**
     * @return Returns a PCM Repository which contains components of Steffen's and Jens' middleware completions
     */
    public Repository getMiddlewareRepository() {
        return (Repository) getElement(RepositoryPackage.eINSTANCE.getRepository()).get(0);
    }

    /**
     * @return Returns the feature configuration which annotates connectors with their technical realisation
     */
    public Configuration getFeatureConfig() {
        return (Configuration) getElement(featureconfigPackage.eINSTANCE.getConfiguration()).get(0);
    }

    /**
     * @return Returns the PCM system instance of the stored PCM model
     */
    public System getSystem() {
        return (System) getElement(SystemPackage.eINSTANCE.getSystem()).get(0);
    }

    /**
     * @return Returns the PCM system's allocation model
     */
    public Allocation getAllocation() {
        return (Allocation) getElement(AllocationPackage.eINSTANCE.getAllocation()).get(0);
    }

    /**
     * @return Returns the PCM usage model of the PCM model in this blackboard partition
     */
    public UsageModel getUsageModel() {
        return (UsageModel) getElement(UsagemodelPackage.eINSTANCE.getUsageModel()).get(0);
    }

    /**
     * @return Returns the PCM Resource Type Repository used by the stored PCM model instance
     */
    public ResourceRepository getResourceTypeRepository() {
        return (ResourceRepository) getElement(ResourcetypePackage.eINSTANCE.getResourceRepository()).get(0);
    }

    /**
     * @return Returns the PCM Resource Environment used by the stored PCM model instance
     */
    public ResourceEnvironment getResourceEnvironment() {
        return (ResourceEnvironment) getElement(ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment()).get(0);
    }

    /**
     * Helper to find root objects of a specified class.
     *
     * @param clazz The class to get elements for.
     * @return The list of found root elements. Empty list if none have been found.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends EObject> List<T> getElement(final EClass targetType) {
        final ArrayList<T> result = new ArrayList<T>();
        for (final Resource r : rs.getResources()) {
            if (r != null && r.getContents().size() > 0 && r.getContents().get(0).eClass() == targetType ) {
                result.add((T) r.getContents().get(0));
            }
        }
        if (result.size() == 0) {
            throw new RuntimeException("Failed to retrieve PCM model element "+targetType.getName());
        } else {
            return result;
        }
    }

}
