package de.uka.ipd.sdq.measurements.osscheduler.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.measurements.osscheduler.ui.tabs.OSSchedulerMeasurementsConfigurationTab;

public class OSSchedulerMeasurementsTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[]{new OSSchedulerMeasurementsConfigurationTab()});
		
	}

}
