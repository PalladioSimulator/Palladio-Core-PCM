package de.uka.ipd.sdq.simulation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

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

public class PCMModel {

    private Allocation allocationModel;
    private Repository repositoryModel;
    private ResourceEnvironment resourceModel;
    private System systemModel;
    private UsageModel usageModel;

    private ResourceRepository resourceRepository;

    public static enum PCMPartialModel {
        USAGE(UsagemodelPackage.eINSTANCE.getUsageModel()), ALLOCATION(AllocationPackage.eINSTANCE.getAllocation()), SYSTEM(
                SystemPackage.eINSTANCE.getSystem()), RESOURCEENVIRONMENT(ResourceenvironmentPackage.eINSTANCE
                .getResourceEnvironment()), REPOSITORY(RepositoryPackage.eINSTANCE.getRepository()), RESOURCEREPOSITORY(
                ResourcetypePackage.eINSTANCE.getResourceRepository());

        private final EClass eClass;

        PCMPartialModel(EClass eClass) {
            this.eClass = eClass;
        }

        EClass getEClass() {
            return eClass;
        }
    }

    private PCMModel(Allocation allocationModel, Repository repositoryModel, ResourceEnvironment resourceModel,
            System systemModel, UsageModel usageModel, ResourceRepository resourceRepository) {
        this.allocationModel = allocationModel;
        this.repositoryModel = repositoryModel;
        this.resourceModel = resourceModel;
        this.systemModel = systemModel;
        this.usageModel = usageModel;
        this.resourceRepository = resourceRepository;
    }

    public UsageModel getUsageModel() {
        return usageModel;
    }

    public Allocation getAllocationModel() {
        return allocationModel;
    }

    public System getSystemModel() {
        return systemModel;
    }

    public ResourceEnvironment getResourceModel() {
        return resourceModel;
    }

    public Repository getRepositoryModel() {
        return repositoryModel;
    }

    public ResourceRepository getResourceRepository() {
        return resourceRepository;
    }

    public static PCMModel loadFromBundle(Bundle bundle, Map<PCMPartialModel, IPath> modelLocations) {
        URI usageUri = absolutePathToBundleURI(bundle, modelLocations.get(PCMPartialModel.USAGE));
        URI allocationUri = absolutePathToBundleURI(bundle, modelLocations.get(PCMPartialModel.ALLOCATION));

        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(usageUri, true);
        resourceSet.getResource(allocationUri, true);
        resolveAllProxies(resourceSet);

        UsageModel usageModel = null;
        Allocation allocationModel = null;
        Repository repositoryModel = null;
        System systemModel = null;
        ResourceEnvironment resourceModel = null;
        ResourceRepository resourceRepository = null;
        for (Resource r : resourceSet.getResources()) {
            EObject o = r.getContents().get(0);
            if (PCMPartialModel.USAGE.getEClass().isInstance(o)) {
                usageModel = (UsageModel) o;
            } else if (PCMPartialModel.ALLOCATION.getEClass().isInstance(o)) {
                allocationModel = (Allocation) o;
            } else if (PCMPartialModel.REPOSITORY.getEClass().isInstance(o)) {
                repositoryModel = (Repository) o;
            } else if (PCMPartialModel.SYSTEM.getEClass().isInstance(o)) {
                systemModel = (System) o;
            } else if (PCMPartialModel.RESOURCEENVIRONMENT.getEClass().isInstance(o)) {
                resourceModel = (ResourceEnvironment) o;
            } else if (PCMPartialModel.RESOURCEREPOSITORY.getEClass().isInstance(o)) {
                resourceRepository = (ResourceRepository) o;
            }
        }

        return new PCMModel(allocationModel, repositoryModel, resourceModel, systemModel, usageModel,
                resourceRepository);
    }

    /**
     * This method is a copy of ResourceSetPartition.resolveAllProxies().
     */
    private static void resolveAllProxies(ResourceSet resourceSet) {
        ArrayList<Resource> currentResources = null;
        // The resolveAll() call is not recursive; thus we have to repeat
        // the thing until the resource set does not grow any more:
        do {
            // Copy list to avoid concurrent modification exceptions:
            currentResources = new ArrayList<Resource>(resourceSet.getResources());
            // TODO: check if this loop can be replaced through a single call
            // to EcoreUtil.resolveAll(resourceSet). Maybe this is even already recursive,
            // i.e. we can eliminate the outer do..while loop?
            for (Resource r : currentResources) {
                EcoreUtil.resolveAll(r);
            }
        } while (currentResources.size() != resourceSet.getResources().size());
    }

    private static URI absolutePathToBundleURI(Bundle bundle, IPath modelLocation) {
        // create URI pointing to the model file contained in the bundle
        URL bundleUrl = FileLocator.find(bundle, modelLocation, null);
        URI bundleUri = URI.createURI(bundleUrl.toExternalForm());
        return bundleUri;
    }

}
