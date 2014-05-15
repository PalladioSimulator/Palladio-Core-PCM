package edu.kit.ipd.sdq.simcomp.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class SimulationComponentLaunchConfigurationTabs extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
	
        List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();

        tabs.add(new SimulationComponentConfigTab());
		
        setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
	}

}
