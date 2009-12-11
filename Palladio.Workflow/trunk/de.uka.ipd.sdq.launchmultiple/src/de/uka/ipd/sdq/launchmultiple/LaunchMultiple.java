package de.uka.ipd.sdq.launchmultiple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
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
	
	/** Logger for log4j. */
	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.launchmultiple");


	/**
	 * FIXME: Use workflow concept
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		//FIXME: Add a better way to access this
		LaunchMultipleTab tab = LaunchMultipleTab.getAnyInstance();
		
		List<ILaunchConfiguration> configs = tab.getLaunchConfigs();
		
		List<ILaunchConfiguration> configsToBeLaunched = new ArrayList<ILaunchConfiguration>();
		
		for (ILaunchConfiguration launchConfiguration : configs) {
			boolean toBeLaunched = configuration.getAttribute(launchConfiguration.getName(), false);
			if (toBeLaunched){
				configsToBeLaunched.add(launchConfiguration);
			}
		}
		
		for (ILaunchConfiguration launchConfiguration : configsToBeLaunched) {
			
			try {
			
			//retrieve SimuCom Launch Delegate
			Set<String> modes = new HashSet<String>();
			modes.add(mode);
			ILaunchConfigurationDelegate delegate = launchConfiguration.getType().getDelegates(modes)[0].getDelegate();
			delegate.launch(launchConfiguration, mode, launch, monitor);
			
			} catch (Exception e){
				//Run all launches, whatever happens. Thus catch all exceptions, print something, then continue.
				logger.error("Running "+launchConfiguration.getName()+" failed. I will start the next one. Cause: "+e.getMessage());
				e.printStackTrace();
			}
			
		}
		
	}

}
