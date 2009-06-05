package de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class PCMResourceSetPartition extends ResourceSetPartition {
	
	public Repository getRepository() {
		return (Repository) getElement(RepositoryPackage.eINSTANCE.getRepository());
	}

	public Repository getMiddlewareRepository() {
		return (Repository) getElement(RepositoryPackage.eINSTANCE.getRepository());
	}

	public Configuration getFeatureConfig() {
		return (Configuration) getElement(featureconfigPackage.eINSTANCE.getConfiguration());
	}

	public System getSystem() {
		return (System) getElement(SystemPackage.eINSTANCE.getSystem());
	}

	public Allocation getAllocation() {
		return (Allocation) getElement(AllocationPackage.eINSTANCE.getAllocation());
	}

	public UsageModel getUsageModel() {
		return (UsageModel) getElement(UsagemodelPackage.eINSTANCE.getUsageModel());
	}

	public ResourceRepository getResourceTypeRepository() {
		return (ResourceRepository) getElement(ResourcetypePackage.eINSTANCE.getResourceRepository());
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
