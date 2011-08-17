package de.uka.ipd.sdq.dsexplore.analysis.cost;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

public class CostAnalysisTab extends de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab implements
		ILaunchConfigurationTab {

	private Text textCostModel;

	@Override
	public void createControl(Composite parent) {
		
		// Create a listener for GUI modification events:
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				CostAnalysisTab.this.setDirty(true);
				CostAnalysisTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		// Create a new Composite to hold the page's controls:
		final Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/**
		 * Add cost model input section
		 */
		this.textCostModel = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Cost Model File", DSEConstantsContainer.COST_MODEL_EXTENSION, textCostModel, getShell(), DSEConstantsContainer.DEFAULT_COST_MODEL_FILE);
	}

	@Override
	public String getName() {
		return "Cost Analysis";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			this.textCostModel.setText(configuration.getAttribute(
					DSEConstantsContainer.COST_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.COST_FILE, e.getMessage());
		}
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.COST_FILE, 
				this.textCostModel.getText());
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
				
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
		
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
				
	}

	@Override
	public void dispose() {
		super.dispose();		
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		String extension = DSEConstantsContainer.COST_MODEL_EXTENSION[0].replace("*", "");
		if (this.textCostModel.getText().equals("") || !this.textCostModel.getText().contains(extension)){
			setErrorMessage("Cost model is missing!");
			return false;
		}
		return true;
	}



}
