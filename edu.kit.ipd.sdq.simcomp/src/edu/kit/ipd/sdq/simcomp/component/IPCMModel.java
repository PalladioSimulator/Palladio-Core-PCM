package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

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
