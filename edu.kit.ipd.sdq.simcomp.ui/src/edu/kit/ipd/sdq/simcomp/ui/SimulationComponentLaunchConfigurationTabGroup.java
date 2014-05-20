package edu.kit.ipd.sdq.simcomp.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.FeatureOptionsTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuConfigurationTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

public class SimulationComponentLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

		List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();

		tabs.add(new FileNamesInputTab());
		tabs.add(new SimuComConfigurationTab());
		tabs.add(new SimulationComponentConfigTab());
		tabs.add(new SimuConfigurationTab());
		tabs.add(new FeatureOptionsTab());

		setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
	}

}
