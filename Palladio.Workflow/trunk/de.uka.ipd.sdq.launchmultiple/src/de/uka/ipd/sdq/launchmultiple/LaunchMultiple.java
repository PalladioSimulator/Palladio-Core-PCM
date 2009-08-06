package de.uka.ipd.sdq.launchmultiple;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

/**
 * 
 * @author Anne
 *
 */
public class LaunchMultiple implements ILaunchConfigurationDelegate {

	/**
	 * FIXME: Use workflow concept
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		//FIXME: Add a better way to access this
		LaunchMultipleTab tab = LaunchMultipleTab.getAnyInstance();
		
		ILaunchConfiguration[] configs = tab.getLaunchConfigs();
		
		List<ILaunchConfiguration> configsToBeLaunched = new ArrayList<ILaunchConfiguration>();
		
		for (ILaunchConfiguration launchConfiguration : configs) {
			boolean toBeLaunched = configuration.getAttribute(launchConfiguration.getName(), false);
			if (toBeLaunched){
				configsToBeLaunched.add(launchConfiguration);
			}
		}
		
		for (ILaunchConfiguration launchConfiguration : configsToBeLaunched) {
			//retrieve SimuCom Launch Delegate
			ILaunchConfigurationDelegate delegate = tab.getDelegate(mode);
			delegate.launch(launchConfiguration, mode, launch, monitor);
			
		}
		
	}

}
