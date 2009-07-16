package de.uka.ipd.sdq.launchmultiple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
	
	//FIXME: retrieve instance of this using the extension point
	private static LaunchMultipleTab instance;
	
	private ILaunchConfigurationType launchType = null;

	@Override
	public void createControl(Composite parent) {
		
		//FIXME: See above
		instance = this;
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		setControl(container);
		
		buttons = new ArrayList<Button>();
		
		/** Logging group*/
		final Group loggingGroup = new Group(container, SWT.NONE);
		loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		loggingGroup.setText("Choose Launch Configs to Run");
		loggingGroup.setLayout(new GridLayout());
		
		ILaunchConfiguration[] configs = getLaunchConfigs();
		
		for (ILaunchConfiguration launchConfiguration : configs) {
			buttons.add(createCheckBox(launchConfiguration, loggingGroup));
		}

	}

	public ILaunchConfiguration[] getLaunchConfigs() {
		ILaunchManager manager = this.getLaunchManager();
		
		this.launchType = manager.getLaunchConfigurationType("de.uka.ipd.sdq.simucontroller.SimuLaunching");
		
		ILaunchConfiguration[] configs = null;
		
		try {
			configs = manager.getLaunchConfigurations(this.launchType);
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return configs;
	}
	
	public ILaunchConfigurationDelegate getDelegate(String mode) throws CoreException{
		Set<String> modes = new HashSet<String>();
		modes.add(mode);
		return this.launchType.getDelegates(modes)[0].getDelegate();
	}

	private Button createCheckBox(ILaunchConfiguration launchConfiguration, Group launchConfigGroup) {
		
		Button launchConfigButton = new Button(launchConfigGroup, SWT.CHECK);
		launchConfigButton.setText(launchConfiguration.getName());
		launchConfigButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				LaunchMultipleTab.this.updateLaunchConfigurationDialog();
			}
		});
		launchConfigButton.setSelection(false);
		
		return launchConfigButton;
		
	}

	@Override
	public String getName() {
		return "Launch Multiple Runs Tab";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		
		ILaunchConfiguration[] configs = getLaunchConfigs();
		
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

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy config) {
		for (Button button : this.buttons) {
			config.setAttribute(button.getText(), button.getSelection());
		}

	}

	@Override
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
