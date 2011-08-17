package de.uka.ipd.sdq.dsexplore.analysis.lqn.launch;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

import de.uka.ipd.sdq.pcmsolver.runconfig.MainConfigTab;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;

/**
 * Provides a configuration tab group for the LQN Solver analysis method.
 * 
 * @author pmerkle
 *
 */
public class LQNAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
			new MainConfigTabExt(),
			new ConfigurationTab()
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
			
			// set LQN Solver as default, if not done yet
			if (!comboSolver.getText().equals(MessageStrings.LQNS_SOLVER)) {
				String[] solverItems = comboSolver.getItems();
				for (int i = 0; i < solverItems.length; i++) {
					String str = solverItems[i];
					if (str.equals(MessageStrings.LQNS_SOLVER)) {
						comboSolver.select(i);
						comboSolver.notifyListeners(SWT.Selection, new Event());
					}
				}
			}
			
			// set XML Output as default, if not done yet
			if (!comboLqnsOutput.getText().equals(MessageStrings.LQN_OUTPUT_XML)) {
				String[] outputItems = comboLqnsOutput.getItems();
				for (int i = 0; i < outputItems.length; i++) {
					String str = outputItems[i];
					if (str.equals(MessageStrings.LQN_OUTPUT_XML)) {
						comboLqnsOutput.select(i);
					}
				}
			}
			
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
			super.setDefaults(configuration);

			configuration.setAttribute(MessageStrings.SOLVER,
					MessageStrings.LQNS_SOLVER);
			configuration.setAttribute(MessageStrings.LQNS_OUTPUT,
					MessageStrings.LQN_OUTPUT_XML);
		}
		
	}

}
