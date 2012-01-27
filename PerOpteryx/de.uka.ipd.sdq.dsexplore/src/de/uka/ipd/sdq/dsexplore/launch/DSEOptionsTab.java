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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

public class DSEOptionsTab extends FileNamesInputTab {
	
	private Text maximumIterations; 

	private Text numberOfIndividualsPerGeneration;
	
	private Image icon;

	//private Text meanResponseTimeRequirement;

	private Combo useHeuristics;
	
	private Text crossoverRate;

	//private Text maxCost;

	private Text textGivenInstances;

	private Button designDecisionsOnly;

	private Button optimisationOnly;

	private Text textDesignDecisionFile;

	//private Text textQMLDefinitionFile;
	
	private Text textCacheInstances;
	private Text textAllInstances;
	private Text textArchiveInstances;

	private Button stopOnInitialFailure;

	private Button outputAsEMF;
	
	/**
	 * Option to start a number of DSE runs on the same settings, to get several samples for the 
	 * runs and be able to draw statistically valid conclusions.   
	 */
	private Text numberOfDSERuns; 
		
	
	//private QMLManager qmlManager;
	//private QMLDefinitionsLoadListener qmlDefinitionsLoadListener;
	
//	public DSEOptionsTab(FileNamesInputTab modelsTab, QMLManager qmlManager){
//		this.modelsTab = modelsTab;
//		this.qmlManager = qmlManager;
//	}
	
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
		
		this.container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		
//		/**
//		 * Add QML input section
//		 */
//		this.textQMLDefinitionFile = new Text(container, SWT.SINGLE | SWT.BORDER);
//		String[] qmlExtension = new String[1];
//		qmlExtension[0] = DSEConstantsContainer.QML_DEFINITION_EXTENSION;
//		this.createFileInputSection(container, modifyListener, "QML Criteria Definitions", qmlExtension, textQMLDefinitionFile);
//		final Button buttonQML = new Button(container, SWT.NONE);
//		buttonQML.setText("Load QML...");
//		qmlDefinitionsLoadListener = new QMLDefinitionsLoadListener(textQMLDefinitionFile, modelsTab.getUsageModelFile(), qmlManager, modifyListener);
//		buttonQML.addSelectionListener(qmlDefinitionsLoadListener);
		
		final Group maximumIterationsGroup = new Group(container, SWT.NONE);
		final GridLayout glmaximumIterationsGroup = new GridLayout();
		glmaximumIterationsGroup.numColumns = 2;
		maximumIterationsGroup.setLayout(glmaximumIterationsGroup);
		maximumIterationsGroup.setText("Evolutionary algorithm parameters");
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
		
		final Label crossoverRateLabel = new Label(maximumIterationsGroup, SWT.NONE);
		crossoverRateLabel.setText("Crossover rate:");
		
		crossoverRate = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		crossoverRate.setEnabled(true);
		crossoverRate.addModifyListener(modifyListener);
		
//		final Label meanRespTimeLabel = new Label(maximumIterationsGroup, SWT.NONE);
//		meanRespTimeLabel.setText("Maximal response time:");

/*		meanResponseTimeRequirement = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		meanResponseTimeRequirement.setEnabled(true);
		meanResponseTimeRequirement.addModifyListener(modifyListener);
*/		
//		final Label maxCostLabel = new Label(maximumIterationsGroup, SWT.NONE);
//		maxCostLabel.setText("Maximal cost:");

//		maxCost = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
//		maxCost.setEnabled(true);
//		maxCost.addModifyListener(modifyListener);
		

		useHeuristics = new Combo(container, SWT.READ_ONLY);
		useHeuristics.setEnabled(true);
		useHeuristics.setItems (new String [] {
				DSEConstantsContainer.SEARCH_EVOLUTIONARY,
				DSEConstantsContainer.SEARCH_RANDOM,
				DSEConstantsContainer.SEARCH_RULE,
				DSEConstantsContainer.SEARCH_RULE_OPT,
				});
		useHeuristics.setSize (400, 200);
		useHeuristics.addModifyListener(modifyListener);
		useHeuristics.addSelectionListener(selectionListener);
		
		/**
		 * Add given instances input section
		 */
		this.textGivenInstances = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Start population or predefined candidates (optional), either .csv or .designdecision containing Candidates", DSEConstantsContainer.CANDIDATE_EXTENSION, textGivenInstances, getShell(), DSEConstantsContainer.DEFAULT_GIVEN_CANDIDATES_FILE);
		
		this.textCacheInstances = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Candidates for evaluation cache (optional, .csv)", DSEConstantsContainer.CSV_EXTENSION, textCacheInstances, getShell(), DSEConstantsContainer.DEFAULT_CACHED_CANDIDATES_FILE);

		this.textAllInstances = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "All previous candidates (optional, .csv), will be included in allcandidates*.csv, and cache (optional). Not considered by the evolutionary algorithm.", DSEConstantsContainer.CSV_EXTENSION, textAllInstances, getShell(), DSEConstantsContainer.DEFAULT_ALL_CANDIDATES_FILE);

		this.textArchiveInstances = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Archive candidates (optional, .csv), will be included in the internal archive and archiveIndividuals.csv and cache (optional, .csv). Must be specified if an evolutionary search should be properly continued.", DSEConstantsContainer.CSV_EXTENSION, textArchiveInstances, getShell(), DSEConstantsContainer.DEFAULT_ARCHIVE_INSTANCES_FILE);
		
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
		
		/**
		 * Add optional design decision input section
		 */
		this.textDesignDecisionFile = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Design Decision File", DSEConstantsContainer.DESIGNDECISION_EXTENSION, textDesignDecisionFile, getShell(), DSEConstantsContainer.DEFAULT_DESIGN_DECISION_FILE);
		
		//this.createHelpSection();
		final Group failureOptions = new Group(container, SWT.NONE);
		final GridLayout glfailureOptions = new GridLayout();
		glfailureOptions.numColumns = 2;
		failureOptions.setLayout(glfailureOptions);
		failureOptions.setText("Failure handling options");
		failureOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		
		stopOnInitialFailure = new Button(failureOptions,  SWT.CHECK);
		stopOnInitialFailure.setEnabled(true);
		stopOnInitialFailure.setSelection(true);
		stopOnInitialFailure.setText("Stop on initial failure");
		stopOnInitialFailure.addSelectionListener(selectionListener);
		
		final Group outputOptions = new Group(container, SWT.NONE);
		final GridLayout gloutputOptions = new GridLayout();
		gloutputOptions.numColumns = 2;
		outputOptions.setLayout(gloutputOptions);
		outputOptions.setText("Output options");
		outputOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		
		outputAsEMF = new Button(outputOptions,  SWT.CHECK);
		outputAsEMF.setEnabled(true);
		outputAsEMF.setSelection(false);
		outputAsEMF.setText("Output as EMF models");
		outputAsEMF.addSelectionListener(selectionListener);
		
		final Group dseIterationsGroups = new Group(container, SWT.NONE);
		final GridLayout dseIterationsGroup = new GridLayout();
		dseIterationsGroup.numColumns = 2;
		dseIterationsGroups.setLayout(dseIterationsGroup);
		dseIterationsGroups.setText("Evolutionary algorithm parameters");
		dseIterationsGroups.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label dseIterationsLabel = new Label(dseIterationsGroups, SWT.NONE);
		dseIterationsLabel.setText("Number of DSE runs (optional, default is 1):");
		
		numberOfDSERuns = new Text(dseIterationsGroups, SWT.SINGLE	| SWT.BORDER);
		numberOfDSERuns.setEnabled(true);
		numberOfDSERuns.addModifyListener(modifyListener);

	}

//	protected void loadQML() {
//		qmlManager.processQMLFile(textQMLDefinitionFile.getText(), modelsTab.getUsageModelFile().getText());
//	}
	
	//klappt nicht so
	/*private void createHelpSection() {
		final Group helpGroup = new Group(container, SWT.NONE);
		final GridLayout glHelpLayout = new GridLayout();
		glHelpLayout.numColumns = 2;
		helpGroup.setLayout(glHelpLayout);
		helpGroup.setText("Design decision options");
		helpGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		this.helpButton = new Button(helpGroup, SWT.NONE);
		this.helpButton.setText("Help");
		this.helpButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().getHelpSystem().displayHelp("de.uka.ipd.sdq.dsexplore.launchDSE");
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().getHelpSystem().displayHelp("de.uka.ipd.sdq.dsexplore.launchDSE");
				
			}
		});
		PlatformUI.getWorkbench().getHelpSystem().setHelp(helpButton, "de.uka.ipd.sdq.dsexplore.launchDSE");
	}

	@Override
	public String getName() {
		return "DSE Options";
	}*/
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		if (icon == null){
			icon = DSEPluginActivator.getImageDescriptor("icons/dse_launch.gif").createImage(); 
		}
		return icon;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		
//		try {
//			this.textQMLDefinitionFile.setText(configuration.getAttribute(
//					DSEConstantsContainer.QML_DEFINITION_FILE, ""));
//		} catch (CoreException e) {
//			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.QML_DEFINITION_FILE, e.getMessage());
//		}
		
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
			crossoverRate.setText(configuration.getAttribute(
					DSEConstantsContainer.CROSSOVER_RATE, "0.5"));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"numberOfIndividualsPerGeneration", e.getMessage());
		}
		
		try{
			String solverStr = configuration.getAttribute(DSEConstantsContainer.SEARCH_METHOD, 
					DSEConstantsContainer.SEARCH_EVOLUTIONARY);
			String[] items = useHeuristics.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(solverStr)){
					useHeuristics.select(i);
				}
			}
		} catch(CoreException e){
			useHeuristics.select(0);
		}
		
		try {
			this.textGivenInstances.setText(configuration.getAttribute(
					DSEConstantsContainer.PREDEFINED_INSTANCES, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.PREDEFINED_INSTANCES, e.getMessage());
		}
		
		try {
			this.textCacheInstances.setText(configuration.getAttribute(
					DSEConstantsContainer.CACHE_INSTANCES, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.CACHE_INSTANCES, e.getMessage());
		}
		
		try {
			this.textAllInstances.setText(configuration.getAttribute(
					DSEConstantsContainer.ALL_CANDIDATES, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.ALL_CANDIDATES, e.getMessage());
		}
		
		try {
			this.textArchiveInstances.setText(configuration.getAttribute(
					DSEConstantsContainer.ARCHIVE_CANDIDATES, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.ARCHIVE_CANDIDATES, e.getMessage());
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
		try {
			this.textDesignDecisionFile.setText(configuration.getAttribute(
					DSEConstantsContainer.DESIGN_DECISION_FILE, ""));
			if ("".equals(this.textDesignDecisionFile.getText())){
				String fullName = getFullDefaultDesignDecisionName(configuration);
				this.textDesignDecisionFile.setText(fullName);
			}
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.DESIGN_DECISION_FILE, e.getMessage());
		}
		try {
			this.stopOnInitialFailure.setSelection(configuration.getAttribute(
					DSEConstantsContainer.STOP_ON_INITIAL_FAILURE, false));
		} catch (CoreException e) {
			this.stopOnInitialFailure.setSelection(true);
		}
		try {
			this.outputAsEMF.setSelection(configuration.getAttribute(
					DSEConstantsContainer.STORE_RESULTS_AS_EMF, false));
		} catch (CoreException e) {
			this.outputAsEMF.setSelection(false);
		}
		try {
			numberOfDSERuns.setText(configuration.getAttribute(
					DSEConstantsContainer.DSE_ITERATIONS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"number of DSE iterations", e.getMessage());
		}
		//loadQML();
	}



	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		//loadQML();
		
		configuration.setAttribute(
				DSEConstantsContainer.MAX_ITERATIONS,
				this.maximumIterations.getText());
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				this.numberOfIndividualsPerGeneration.getText());
		configuration.setAttribute(
				DSEConstantsContainer.CROSSOVER_RATE,
				this.crossoverRate.getText());
//		configuration.setAttribute(
//				DSEConstantsContainer.MRT_REQUIREMENTS, 
//				this.meanResponseTimeRequirement.getText());
//		configuration.setAttribute(
//				DSEConstantsContainer.MAX_COST, 
//				this.maxCost.getText());
		configuration.setAttribute(
				DSEConstantsContainer.SEARCH_METHOD, 
				this.useHeuristics.getText());
		configuration.setAttribute(
				DSEConstantsContainer.PREDEFINED_INSTANCES, 
				this.textGivenInstances.getText());
		configuration.setAttribute(
				DSEConstantsContainer.CACHE_INSTANCES, 
				this.textCacheInstances.getText());
		configuration.setAttribute(
				DSEConstantsContainer.ALL_CANDIDATES, 
				this.textAllInstances.getText());
		configuration.setAttribute(
				DSEConstantsContainer.ARCHIVE_CANDIDATES, 
				this.textArchiveInstances.getText());
		configuration.setAttribute(
				DSEConstantsContainer.DESIGN_DECISIONS_ONLY, 
				this.designDecisionsOnly.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.OPTIMISATION_ONLY,
				this.optimisationOnly.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.DESIGN_DECISION_FILE, 
				this.textDesignDecisionFile.getText());
//		configuration.setAttribute(
//				DSEConstantsContainer.QML_DEFINITION_FILE, 
//				this.textQMLDefinitionFile.getText());
		configuration.setAttribute(
				DSEConstantsContainer.STOP_ON_INITIAL_FAILURE,
				this.stopOnInitialFailure.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.STORE_RESULTS_AS_EMF,
				this.outputAsEMF.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.DSE_ITERATIONS,
				this.numberOfDSERuns.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				"3");
		configuration.setAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false);
		configuration.setAttribute(DSEConstantsContainer.OPTIMISATION_ONLY, false);
		configuration.setAttribute(DSEConstantsContainer.SEARCH_METHOD, DSEConstantsContainer.SEARCH_EVOLUTIONARY);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

//		if(!qmlManager.isQMLLoaded()){
//			String errorMessage = "Select Usage Model and load QML Definition!";
//			if(qmlManager.getDiagnosis() != null) {
//				errorMessage += " "+qmlManager.getDiagnosis();
//			}
//			setErrorMessage(errorMessage);
//			return false;
//		} else if(qmlManager.getActivatedCriteria().size() < 1) {
//			setErrorMessage("QML definition contains no objectives. Nothing to optimize!");
//			return false;
//		}
		
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
		
		try {
			Double.parseDouble(this.crossoverRate.getText());
		} catch (NumberFormatException e) {
			setErrorMessage("Crossover rate must be a number.");
			return false;
		}
		
		
//		if (this.meanResponseTimeRequirement.getText().length() != 0) {
//			try {
//				Double.parseDouble(this.meanResponseTimeRequirement.getText());
//			} catch (NumberFormatException e) {
//				setErrorMessage("Mean response time requirement must be a double value or empty.");
//				return false;
//			}
//		}
//		
//		if (this.maxCost.getText().length() != 0) {
//			try {
//				Double.parseDouble(this.maxCost.getText());
//			} catch (NumberFormatException e) {
//				setErrorMessage("Maximal cost must be a double value or empty.");
//				return false;
//			}
//		}
		
		if (this.designDecisionsOnly.getSelection() && this.optimisationOnly.getSelection()){
			setErrorMessage("You cannot choose both \"design decisions only\" and \"optimisation only\", as nothing remains to be done.");
			return false;
		}
		
		if ( this.textDesignDecisionFile.getText().length() > 0){
			//If something is written in the textDesignDecisionFile text, it must be a valid path.
			if (!TabHelper.validateFilenameExtension(textDesignDecisionFile.getText(), 
					DSEConstantsContainer.DESIGNDECISION_EXTENSION)) {
					setErrorMessage("Design decision file path is invalid: The file must have the correct extension.");
					return false;
			}
			//Additionally, if the optimisation only button is not set, we inform the user that the
			//specified file will be overwritten.
			if (!this.optimisationOnly.getSelection()){
				setMessage("Note that your defined design decision file will be overwritten or created if it does not exist yet.");
			} 
		} else if(this.optimisationOnly.getSelection()){
			//We need a design decision file if optimisation only is selected
			setErrorMessage("You need to provide a design decision file to read the problem from.");
			return false;
		} else {
			//Notify user about the default design decision file name. 
			setMessage("If you do not specify a design decision file, the default name will be <name of this launch configuration>.designdecision.");
		}
		
		if (this.numberOfDSERuns.getText().length() != 0) {
			try {
				Integer.parseInt(this.numberOfDSERuns.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Number of DSE iterations must be an integer value or empty.");
				return false;
			}
		}
		
		//If rule-based search is selected, one should choose one of the tactics
		if (this.useHeuristics.getText().equals(DSEConstantsContainer.SEARCH_RULE) 
				|| this.useHeuristics.getText().equals(DSEConstantsContainer.SEARCH_RULE_OPT)){
			boolean noTacticsSelected = true;
			try {
				noTacticsSelected = 
					!launchConfig.getAttribute(DSEConstantsContainer.USE_PROCESSING_RATE, false)
					&& !launchConfig.getAttribute(DSEConstantsContainer.USE_REALLOCATION, false)
					&& !launchConfig.getAttribute(DSEConstantsContainer.USE_SERVER_CONSOLIDATION, false)
					&& !launchConfig.getAttribute(DSEConstantsContainer.USE_SERVER_EXPANSION, false)
					&& !launchConfig.getAttribute(DSEConstantsContainer.USE_ANTIPATTERNS, false);
			} catch (CoreException e) {
				//noTactics will stay true and the message will be written.
			}
			if (noTacticsSelected){
				setMessage("Make sure to select some tactics when choosing the rule-based search, otherwise nothing will happen.");
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
	@Override
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

	/**returns the path including the last /*/
	private String getPathTo(String fileURL){
		int index = fileURL.lastIndexOf("\\");
		String folderPath = fileURL.substring(0, index+1); 
		return folderPath;
	}
	
	private String getDefaultDesignDecisionFileName(ILaunchConfiguration configuration) throws CoreException {
		String problemName = configuration.getName();
		return problemName+".designdecision";
	}

	private String getFullDefaultDesignDecisionName(
			ILaunchConfiguration configuration) throws CoreException {
		String allocFile = configuration.getAttribute(ConstantsContainer.ALLOCATION_FILE,"");
		String path = getPathTo(allocFile);
		String name = getDefaultDesignDecisionFileName(configuration);
		String fullName = path+name;
		return fullName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "DSE Options";
	}
	
}
