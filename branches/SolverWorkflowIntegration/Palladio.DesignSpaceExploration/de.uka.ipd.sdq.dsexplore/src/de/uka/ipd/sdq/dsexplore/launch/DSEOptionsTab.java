package de.uka.ipd.sdq.dsexplore.launch;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;

public class DSEOptionsTab extends FileNamesInputTab {
	
	private Text maximumIterations; 

	private Text numberOfIndividualsPerGeneration;
	
	private Image icon;

	private Text meanResponseTimeRequirement;

	private Text threshold;

	private Text increaseFactor;

	private Text textCostModel;

	private Text maxCost;

	private Text textGivenInstances;

	private Button designDecisionsOnly;

	private Button optimisationOnly;


	@Override
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				DSEOptionsTab.this.setDirty(true);
				DSEOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				DSEOptionsTab.this.setDirty(true);
				DSEOptionsTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				DSEOptionsTab.this.setDirty(true);
				DSEOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		final Group maximumIterationsGroup = new Group(container, SWT.NONE);
		final GridLayout glmaximumIterationsGroup = new GridLayout();
		glmaximumIterationsGroup.numColumns = 2;
		maximumIterationsGroup.setLayout(glmaximumIterationsGroup);
		maximumIterationsGroup.setText("Stop criteria");
		maximumIterationsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label maxIterationLabel = new Label(maximumIterationsGroup, SWT.NONE);
		maxIterationLabel.setText("Maximum number of iterations:");
		
		maximumIterations = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		maximumIterations.setEnabled(true);
		maximumIterations.addModifyListener(modifyListener);
		
		final Label numberOfIndividualsPerGenerationLabel = new Label(maximumIterationsGroup, SWT.NONE);
		numberOfIndividualsPerGenerationLabel.setText("Number of individuals per generation:");
		
		numberOfIndividualsPerGeneration = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		numberOfIndividualsPerGeneration.setEnabled(true);
		numberOfIndividualsPerGeneration.addModifyListener(modifyListener);
		
		final Label meanRespTimeLabel = new Label(maximumIterationsGroup, SWT.NONE);
		meanRespTimeLabel.setText("Maximal response time:");

		meanResponseTimeRequirement = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		meanResponseTimeRequirement.setEnabled(true);
		meanResponseTimeRequirement.addModifyListener(modifyListener);
		
		final Label maxCostLabel = new Label(maximumIterationsGroup, SWT.NONE);
		maxCostLabel.setText("Maximal cost:");

		maxCost = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		maxCost.setEnabled(true);
		maxCost.addModifyListener(modifyListener);
		
		final Label thresholdLabel = new Label(maximumIterationsGroup, SWT.NONE);
		thresholdLabel.setText("Threshold for strengthen resource:");

		threshold = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		threshold.setEnabled(true);
		threshold.addModifyListener(modifyListener);
		
		final Label increaseFactorLabel = new Label(maximumIterationsGroup, SWT.NONE);
		increaseFactorLabel.setText("Increase factor for strengthen resource:");

		increaseFactor = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		increaseFactor.setEnabled(true);
		increaseFactor.addModifyListener(modifyListener);
		
		/**
		 * Add cost model input section
		 */
		this.textCostModel = new Text(container, SWT.SINGLE | SWT.BORDER);
		this.createFileInputSection(container, modifyListener, "Cost Model File", DSEConstantsContainer.COST_MODEL_EXTENSION, textCostModel);
		
		/**
		 * Add given instances input section
		 */
		this.textGivenInstances = new Text(container, SWT.SINGLE | SWT.BORDER);
		this.createFileInputSection(container, modifyListener, "Predefined instances", DSEConstantsContainer.CSV_EXTENSION, textGivenInstances);
		
		final Group designDecisionOptions = new Group(container, SWT.NONE);
		final GridLayout gldesignDecisionOptions = new GridLayout();
		gldesignDecisionOptions.numColumns = 2;
		designDecisionOptions.setLayout(gldesignDecisionOptions);
		designDecisionOptions.setText("Design decision options");
		designDecisionOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		

//		simulateFailuresButton = new Button(reliabilityGroup, SWT.CHECK);
//		final GridData gd_simulateFailuresButton = new GridData(SWT.FILL, SWT.CENTER, true, false);
//		simulateFailuresButton.setLayoutData(gd_simulateFailuresButton);
//		simulateFailuresButton.setText("Simulate failures");
//		simulateFailuresButton.addSelectionListener(selectionListener);
		
		designDecisionsOnly = new Button(designDecisionOptions,  SWT.CHECK);
		designDecisionsOnly.setEnabled(true);
		designDecisionsOnly.setText("Only determine design decisions, do not optimise");
		designDecisionsOnly.addSelectionListener(selectionListener);

		optimisationOnly = new Button(designDecisionOptions, SWT.CHECK);
		optimisationOnly.setEnabled(true);
		optimisationOnly.setText("Only optimise, using pre-existing design decisions");
		optimisationOnly.addSelectionListener(selectionListener);

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
		try {
			numberOfIndividualsPerGeneration.setText(configuration.getAttribute(
					DSEConstantsContainer.INDIVIDUALS_PER_GENERATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"numberOfIndividualsPerGeneration", e.getMessage());
		}
		try {
			meanResponseTimeRequirement.setText(configuration.getAttribute(
					DSEConstantsContainer.MRT_REQUIREMENTS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"mean response time", e.getMessage());
		} 
		try {
			maxCost.setText(configuration.getAttribute(
					DSEConstantsContainer.MAX_COST, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"max cost", e.getMessage());
		}
		try {
			this.threshold.setText(configuration.getAttribute(
					DSEConstantsContainer.THRESHOLD, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.THRESHOLD, e.getMessage());
		}
		try {
			this.increaseFactor.setText(configuration.getAttribute(
					DSEConstantsContainer.INCR_FACTOR, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.INCR_FACTOR, e.getMessage());
		}
		try {
			this.textCostModel.setText(configuration.getAttribute(
					DSEConstantsContainer.COST_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.COST_FILE, e.getMessage());
		}
		try {
			this.textGivenInstances.setText(configuration.getAttribute(
					DSEConstantsContainer.PREDEFINED_INSTANCES, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.PREDEFINED_INSTANCES, e.getMessage());
		}
		
		try {
			this.designDecisionsOnly.setSelection(configuration.getAttribute(
					DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false));
		} catch (CoreException e) {
			this.designDecisionsOnly.setSelection(false);
		}
		try {
			this.optimisationOnly.setSelection(configuration.getAttribute(
					DSEConstantsContainer.OPTIMISATION_ONLY, false));
		} catch (CoreException e) {
			this.optimisationOnly.setSelection(false);
		}
		

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.MAX_ITERATIONS,
				this.maximumIterations.getText());
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				this.numberOfIndividualsPerGeneration.getText());
		configuration.setAttribute(
				DSEConstantsContainer.MRT_REQUIREMENTS, 
				this.meanResponseTimeRequirement.getText());
		configuration.setAttribute(
				DSEConstantsContainer.MAX_COST, 
				this.maxCost.getText());
		configuration.setAttribute(
				DSEConstantsContainer.THRESHOLD,
				this.threshold.getText());
		configuration.setAttribute(
				DSEConstantsContainer.INCR_FACTOR, 
				this.increaseFactor.getText());
		configuration.setAttribute(
				DSEConstantsContainer.COST_FILE, 
				this.textCostModel.getText());
		configuration.setAttribute(
				DSEConstantsContainer.PREDEFINED_INSTANCES, 
				this.textGivenInstances.getText());
		configuration.setAttribute(
				DSEConstantsContainer.DESIGN_DECISIONS_ONLY, 
				this.designDecisionsOnly.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.OPTIMISATION_ONLY,
				this.optimisationOnly.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.THRESHOLD,
				"0.7");
		configuration.setAttribute(
				DSEConstantsContainer.INCR_FACTOR, 
				"1.1");
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				"3");
		configuration.setAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false);
		configuration.setAttribute(DSEConstantsContainer.OPTIMISATION_ONLY, false);
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
		
		// check this.numberOfIndividualsPerGeneration
		if (this.numberOfIndividualsPerGeneration.getText().length() != 0) {
			try {
				Integer.parseInt(this.numberOfIndividualsPerGeneration.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Number of individuals per generation must be an integer value or empty.");
				return false;
			}
		}
		
		if (this.meanResponseTimeRequirement.getText().length() != 0) {
			try {
				Double.parseDouble(this.meanResponseTimeRequirement.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Mean response time requirement must be a double value or empty.");
				return false;
			}
		}
		
		if (this.maxCost.getText().length() != 0) {
			try {
				Double.parseDouble(this.maxCost.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Maximal cost must be a double value or empty.");
				return false;
			}
		}
		
		try {
			Double.parseDouble(this.threshold.getText());
		} catch (NumberFormatException e) {
			setErrorMessage("Threshold must be a double value.");
			return false;
		}
	
		try {
			Double.parseDouble(this.increaseFactor.getText());
		} catch (NumberFormatException e) {
			setErrorMessage("InreaseFactor must be a double value.");
			return false;
		}
		
		String extension = DSEConstantsContainer.COST_MODEL_EXTENSION[0].replace("*", "");
		if (this.textCostModel.getText().equals("") || !this.textCostModel.getText().contains(extension)){
			setErrorMessage("Cost model is missing!");
			return false;
		}
		
		if (this.designDecisionsOnly.getSelection() && this.optimisationOnly.getSelection()){
			setErrorMessage("You cannot choose both \"design decisions only\" and \"optimisation only\", as nothing remains to be done.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Disposes the image for the DSE options tab.
	 * 
	 * @see ILaunchConfigurationTab#dispose()
	 */
	public void dispose() {
		if (icon != null){
			icon.dispose();
		}
	}
	
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

}
