package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;

public abstract class SimuComConfigurationBuilder {

	public abstract SimuComWorkflowConfiguration getConfiguration() throws CoreException;
}
