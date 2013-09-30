package de.uka.ipd.sdq.pcm.transformations.builder.util;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

public class PCMModelHolder {
	private Repository repository;
	private System system;
	private Allocation allocation;
	private ResourceEnvironment resourceEnvironment;
	private UsageModel usageModel;
	private ResourceRepository resourceRepository;
	
	public Repository getRepository() {
		return repository;
	}
	public System getSystem() {
		return system;
	}
	public Allocation getAllocation() {
		return allocation;
	}
	public ResourceEnvironment getResourceEnvironment() {
		return resourceEnvironment;
	}
	public UsageModel getUsageModel() {
		return usageModel;
	}
	public PCMModelHolder(ResourceRepository resourceRepository, Repository repository, System system,
			Allocation allocation,
			UsageModel usageModel) {
		super();
		this.resourceRepository = resourceRepository;
		this.repository = repository;
		this.system = system;
		this.allocation = allocation;
		this.resourceEnvironment = allocation.getTargetResourceEnvironment_Allocation();
		this.usageModel = usageModel;
	}
	public ResourceRepository getResourceRepository() {
		return resourceRepository;
	}
}
