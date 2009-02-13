package de.uka.ipd.sdq.dsexplore.analysis.lqnsolver.launch;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.pcmsolver.runconfig.CommonTab;
import de.uka.ipd.sdq.pcmsolver.runconfig.MainConfigTab;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

/**
 * Provides a configuration tab group for the LQN Solver analysis method.
 * 
 * @author pmerkle
 *
 */
public class LQNAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
			new MainConfigTabExt(),
			new CommonTab()
		};
		setTabs(tabs);
		
	}
	
	/**
	 * This class extends the {@link MainConfigTab} in order to support
	 * disabling of the solver selection combo. 
	 * 
	 * @author pmerkle
	 * 
	 */
	private class MainConfigTabExt extends MainConfigTab {

		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			
			comboSolver.setEnabled(false);
			comboLqnsOutput.setEnabled(false);
		}

		@Override
		public void initializeFrom(ILaunchConfiguration configuration) {
			super.initializeFrom(configuration);
			
			// set LQN Solver as default
			String[] solverItems = comboSolver.getItems();
			for (int i=0; i<solverItems.length; i++){
				String str = solverItems[i];
				if (str.equals(MessageStrings.LQNS_SOLVER)){
					comboSolver.select(i);
				}
			}
			
			// set XML Output as default
			String[] outputItems = comboLqnsOutput.getItems();
			for (int i=0; i<outputItems.length; i++){
				String str = outputItems[i];
				if (str.equals(MessageStrings.LQNS_OUTPUT_XML)){
					comboSolver.select(i);
				}
			}
		}		
		
	}

}
