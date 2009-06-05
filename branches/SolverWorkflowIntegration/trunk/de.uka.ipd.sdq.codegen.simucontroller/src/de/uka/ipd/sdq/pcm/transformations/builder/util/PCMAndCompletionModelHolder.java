package de.uka.ipd.sdq.pcm.transformations.builder.util;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

public class PCMAndCompletionModelHolder extends PCMModelHolder {

	private Repository completionRepository;
	private Repository middlewareRepository;
	
	public PCMAndCompletionModelHolder(ResourceRepository resourceRepository, 
			Repository repository, System system,
			Allocation allocation, UsageModel usageModel,
			Repository completionRepository,
			Repository middlewareRepository) {
		super(resourceRepository, repository, system, allocation, usageModel);
		this.completionRepository = completionRepository;
		this.middlewareRepository = middlewareRepository;
	}

	public Repository getCompletionRepository() {
		return completionRepository;
	}

	public Repository getMiddlewareRepository() {
		return middlewareRepository;
	}

	
}
