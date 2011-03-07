package de.uka.ipd.sdq.launchmultiple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;



/**
 * 
 * @author Anne
 *
 */
public class LaunchMultipleTab extends AbstractLaunchConfigurationTab {
	
	private List<Button> buttons = new ArrayList<Button>();
	
	//The id attribute in the org.eclipse.debug.core.launchConfigurationTypes extension point.
	private String[] launchTypes = { 
			"de.uka.ipd.sdq.simucontroller.SimuLaunching",
			"de.uka.ipd.sdq.dsolver_plugin.PCMSolverLaunchConfigurationType",
			"de.uka.ipd.sdq.dsolver_plugin.PCMSolverLaunchConfigurationType.Reliability",
			"de.uka.ipd.sdq.dsexplore.launchDSE"
			};
	
	//FIXME: retrieve instance of this using the extension point
	private static LaunchMultipleTab instance;
	
	/** Logger for log4j. */
	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.launchmultiple");

	
	public void createControl(Composite parent) {
		
		//FIXME: See above
		instance = this;
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layoutOuter = new GridLayout();
		layoutOuter.numColumns = 3;
		container.setLayout(layoutOuter);
		setControl(container);
		
		
		
		buttons = new ArrayList<Button>();
		
		/** Logging group*/
		final Group loggingGroup = new Group(container, SWT.NONE);
		loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		loggingGroup.setText("Choose Launch Configs to run.");
		GridLayout layoutInner = new GridLayout();
		layoutInner.numColumns = 3;
		loggingGroup.setLayout(layoutInner);
		
		List<ILaunchConfiguration> configs = getLaunchConfigs();

		
		for (ILaunchConfiguration launchConfiguration : configs) {
			buttons.add(createCheckBox(launchConfiguration, loggingGroup));
		}

	}

	public List<ILaunchConfiguration> getLaunchConfigs() {
		ILaunchManager manager = this.getLaunchManager();
		
		List<ILaunchConfiguration> allTypes = new LinkedList<ILaunchConfiguration>();
		for (String launchTypeID : this.launchTypes) {
			
			try {
				ILaunchConfigurationType launchType = manager.getLaunchConfigurationType(launchTypeID);
				ILaunchConfiguration[] configs = null;
				configs = manager.getLaunchConfigurations(launchType);
				
				for (ILaunchConfiguration iLaunchConfiguration : configs) {
					allTypes.add(iLaunchConfiguration);
				}
				
			} catch (CoreException e) {
				logger.error("Could not find a configuration type for id "+launchTypeID+", skipping it.");
				e.printStackTrace();
			}

			
		}
		return allTypes;
	}
	
	private Button createCheckBox(ILaunchConfiguration launchConfiguration, Group launchConfigGroup) {
		
		Button launchConfigButton = new Button(launchConfigGroup, SWT.CHECK);
		launchConfigButton.setText(launchConfiguration.getName());
		launchConfigButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				LaunchMultipleTab.this.updateLaunchConfigurationDialog();
			}
		});
		launchConfigButton.setSelection(false);
		
		return launchConfigButton;
		
	}

	public String getName() {
		return "Launch Multiple Runs Tab";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		
		List<ILaunchConfiguration> configs = getLaunchConfigs();
		
	
		for (ILaunchConfiguration launchConfiguration : configs) {
			boolean selected = false;
			try {
				selected = configuration.getAttribute(launchConfiguration.getName(), false);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			Button button = getButtonFor(launchConfiguration.getName());
			
			if (button != null){
				button.setSelection(selected);
			}
			
		}

	}

	/**
	 * Can be null
	 * @param name
	 * @return Button with that name or null
	 */
	private Button getButtonFor(String name) {
		for (Button button : this.buttons) {
			if (button.getText().equals(name)){
				return button;
			}
		} 
		return null;
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		for (Button button : this.buttons) {
			config.setAttribute(button.getText(), button.getSelection());
		}

	}

	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		for (Button button : this.buttons) {
			config.setAttribute(button.getText(), true);
		}

	}
	
	/** 
	 * FIXME Do this better, e.g. by extension point
	 * No guarantee which instance is returned!
	 * @return
	 */
	public static LaunchMultipleTab getAnyInstance(){
		return instance;
	}

}
