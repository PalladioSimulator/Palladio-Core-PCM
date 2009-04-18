package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.codegen.runconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.MDSDBlackboard;

public abstract class AbstractMDSDLaunchConfigurationDelegate<T extends AbstractCodeGenerationWorkflowRunConfiguration>
extends
	AbstractWorkflowBasedLaunchConfigurationDelegate<T, MDSDBlackboard> {

	public AbstractMDSDLaunchConfigurationDelegate() {
		super();
	}

	@Override
	protected MDSDBlackboard createBlackboard() {
		return new MDSDBlackboard();
	}

}