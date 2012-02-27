package de.uka.ipd.sdq.dsexplore.analysis.cost;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;

public class CostAnalysisTab extends de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab implements
		ILaunchConfigurationTab {

	private Text textCostModel;
	
//	private Button combineCostTypesInObjective;
//	private Button considerInitialCost;
//	private Button considerOperatingCost;

	@Override
	public void createControl(Composite parent) {
		
		// Create a listener for GUI modification events:
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				CostAnalysisTab.this.setDirty(true);
				CostAnalysisTab.this.updateLaunchConfigurationDialog();
			}
		};
		
//		final SelectionListener selectionListener = new SelectionListener() {
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//				CostAnalysisTab.this.setDirty(true);
//				CostAnalysisTab.this.updateLaunchConfigurationDialog();
//			}
//
//			public void widgetSelected(SelectionEvent e) {
//				CostAnalysisTab.this.setDirty(true);
//				CostAnalysisTab.this.updateLaunchConfigurationDialog();
//			}
//		};
		
		// Create a new Composite to hold the page's controls:
		final Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/**
		 * Add cost model input section
		 */
		this.textCostModel = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Cost Model File", DSEConstantsContainer.COST_MODEL_EXTENSION, textCostModel, getShell(), DSEConstantsContainer.DEFAULT_COST_MODEL_FILE);
		
//		this.combineCostTypesInObjective = new Button(container,  SWT.CHECK);
//		this.combineCostTypesInObjective.setEnabled(true);
//		this.combineCostTypesInObjective.setText("Combine all cost types in one objective");
//		this.combineCostTypesInObjective.addSelectionListener(selectionListener);
//		this.combineCostTypesInObjective.setSelection(true);
//		
//		this.considerInitialCost = new Button(container,  SWT.CHECK);
//		this.considerInitialCost.setEnabled(true);
//		this.considerInitialCost.setText("Consider inital costs annotations");
//		this.considerInitialCost.addSelectionListener(selectionListener);
//		this.considerInitialCost.setSelection(true);
//		
//		this.considerOperatingCost = new Button(container,  SWT.CHECK);
//		this.considerOperatingCost.setEnabled(true);
//		this.considerOperatingCost.setText("Consider operating costs annotations");
//		this.considerOperatingCost.addSelectionListener(selectionListener);
//		this.considerOperatingCost.setSelection(true);
				
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
		
//		try {
//			this.combineCostTypesInObjective.setSelection(configuration.getAttribute(
//					DSEConstantsContainer.COST_COMBINE_COST_TYPES, true));
//		} catch (CoreException e) {
//			this.combineCostTypesInObjective.setSelection(true);
//		}
//		
//		try {
//			this.considerInitialCost.setSelection(configuration.getAttribute(
//					DSEConstantsContainer.COST_CONSIDER_INITIAL, true));
//		} catch (CoreException e) {
//			this.considerInitialCost.setSelection(true);
//		}
//		
//		try {
//			this.considerOperatingCost.setSelection(configuration.getAttribute(
//					DSEConstantsContainer.COST_CONSIDER_OPERATING, true));
//		} catch (CoreException e) {
//			this.considerOperatingCost.setSelection(true);
//		}
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.COST_FILE, 
				this.textCostModel.getText());
		
//		configuration.setAttribute(
//				DSEConstantsContainer.COST_COMBINE_COST_TYPES, 
//				this.combineCostTypesInObjective.getSelection());
//		
//		configuration.setAttribute(
//				DSEConstantsContainer.COST_CONSIDER_INITIAL, 
//				this.considerInitialCost.getSelection());
//		
//		configuration.setAttribute(
//				DSEConstantsContainer.COST_CONSIDER_OPERATING, 
//				this.considerOperatingCost.getSelection());

		
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
