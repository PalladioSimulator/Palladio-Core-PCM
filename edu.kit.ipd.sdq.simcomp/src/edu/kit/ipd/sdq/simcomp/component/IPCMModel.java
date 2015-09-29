package edu.kit.ipd.sdq.simcomp.component;

import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

/**
 * Represents the PCM model of a component-based system to simulate.
 * 
 * @author Christoph Föhrdes
 */
public interface IPCMModel {

	public UsageModel getUsageModel();

	public Allocation getAllocationModel();

	public System getSystemModel();

	public ResourceEnvironment getResourceEnvironmentModel();

	public Repository getRepositoryModel();

	public ResourceRepository getResourceRepository();
}
