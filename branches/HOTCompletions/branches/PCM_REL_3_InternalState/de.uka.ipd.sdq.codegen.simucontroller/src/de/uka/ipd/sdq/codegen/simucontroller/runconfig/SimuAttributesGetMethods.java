package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * The class defines the methods, the are SimuCom special variable from the
 * LaunchConfiguration-Object back supplies.
 * 
 * @author Roman Andrej
 */
public class SimuAttributesGetMethods extends AttributesGetMethods {

	public SimuAttributesGetMethods(ILaunchConfiguration configuration) {
		super(configuration);
	}
	
	/**
	 * The method return a HashMap with SimuCom special properties.
	 * 
	 * @throws JobFailedException
	 */
	public Map<String, Object> getSimuComProperties() throws JobFailedException {
		Map<String, Object> properties = new HashMap<String, Object>();
		
		try {
			properties = configuration.getAttributes();
		} catch (CoreException e) {
			throw new JobFailedException("Getting properties failed", e);
		}

		return properties;
	}
	
	/**
	 * The method return the value of SHOULD_THROW_EXCEPTION attribute in the
	 * ILaunchConfiguration-Object
	 */
	public boolean isShouldThrowException() {
		boolean shouldThrowException;

		try {
			shouldThrowException = configuration.getAttribute(
					SimuComConfig.SHOULD_THROW_EXCEPTION, false);
		} catch (CoreException e) {
			shouldThrowException = false;
		}

		return shouldThrowException;
	}

	/**
	 * The method return the value of DELETE_PLUGIN attribute in the
	 * ILaunchConfiguration-Object
	 */
	public boolean isDeleteProject() {
		boolean deleteProject;

		try {
			deleteProject = configuration.getAttribute(
					ConstantsContainer.DELETE_PLUGIN, true);
		} catch (CoreException e) {
			deleteProject = true;
		}

		return deleteProject;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods#isShouldThrowException(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected boolean isShouldThrowException(ILaunchConfiguration configuration)
			throws CoreException {
		return configuration.getAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION,
				false);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods#defineTemplateMethod()
	 */
	@Override
	protected String defineTemplateMethod() {
		return "simulation_template_methods";
	}
}
