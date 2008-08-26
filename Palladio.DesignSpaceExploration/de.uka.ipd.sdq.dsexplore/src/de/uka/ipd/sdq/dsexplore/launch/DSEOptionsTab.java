package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.codegen.runconfig.RunConfigPlugin;
import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;

public class DSEOptionsTab extends AbstractLaunchConfigurationTab {
	
	private Text maximumIterations; 
	
	private Image icon;

	@Override
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				DSEOptionsTab.this.setDirty(true);
				DSEOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		final Group maximumIterationsGroup = new Group(container, SWT.NONE);
		final GridLayout glmaximumIterationsGroup = new GridLayout();
		glmaximumIterationsGroup.numColumns = 3;
		maximumIterationsGroup.setLayout(glmaximumIterationsGroup);
		maximumIterationsGroup.setText("Maximum iterations: ");
		maximumIterationsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		
		maximumIterations = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		maximumIterations.setEnabled(true);
		maximumIterations.addModifyListener(modifyListener);

	}

	@Override
	public String getName() {
		return "DSE Options";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		if (icon == null){
			icon = DSEPluginActivator.getImageDescriptor("icons/dse_launch.gif").createImage(); 
		}
		return icon;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			maximumIterations.setText(configuration.getAttribute(
					DSEConstantsContainer.MAX_ITERATIONS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"maximum iterations", e.getMessage());
		}

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.MAX_ITERATIONS,
				maximumIterations.getText());

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		// check this.maxIterations
		if (this.maximumIterations.getText().length() != 0) {
			try {
				Integer.parseInt(this.maximumIterations.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Maximum iterations must be an integer value or empty.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Disposes the image for the DSE options tab.
	 * 
	 * @see ILaunchConfigurationTab#dispose()
	 */
	public void dispose() {
		icon.dispose();
	}

}
