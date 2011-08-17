package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.cip.runtime.runconfig.tabs.CipCompletionTab;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableTabGroup;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

/**
 * The class defines tabs for the SimuBench Launch configuration menu.
 * 
 * @author Roman Andrej
 */
public class SimuTabGroup extends ExtendableTabGroup {

	public List<ILaunchConfigurationTab> getTabs(String mode) { 
		List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
		tabs.add(new FileNamesInputTab());// Default tab
		tabs.add(new SimuComConfigurationTab());
		tabs.add(new SimuConfigurationTab());
		tabs.add(new FeatureOptionsTab());
		tabs.add(new CipCompletionTab());
		return tabs;
	}
	
	protected String getWorkflowId() {
		return "workflow.extension.simucom";
	}
}
