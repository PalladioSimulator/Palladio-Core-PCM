/**
 *
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.palladiosimulator.recorderframework.launch.RecorderExtensionHelper;
import org.palladiosimulator.recorderframework.launch.RecorderTabGroup;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, which is responsible for the SimuCom configuration.
 *
 * @author Roman Andrej
 */
public class SimuComConfigurationTab extends AbstractLaunchConfigurationTab {

	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(SimuComConfigurationTab.class);

	private Text nameField;
	private Text timeField;
	private Text maxMeasurementsField;
	private Button checkLoggingButton;
	
	/** Confidence settings */
	private Button useConfidenceCheckBox;
	private Label levelLabel;
	private Text levelField;
	private Label halfWidthLabel;
	private Text halfWidthField;
	private Label selectModelElementLabel;
	private Text selectModelElementField;
	private Button selectModelElementButton;
	private String selectedModelElementName;
	private URI selectedModelElementURI;
	/** Batch means settings */
	private Button useAutomatedBatchMeansCheckBox;
	private Label batchSizeLabel;
	private Text batchSizeField;
	private Label minNumberOfBatchesLabel;
	private Text minNumberOfBatchesField;
	
	private Combo persistenceCombo;
	private Combo simulatorCombo;
	private ArrayList<String> modelFiles = new ArrayList<String>();

	private RecorderTabGroup recorderTabGroup;
	protected Composite container;



	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				SimuComConfigurationTab.this.setDirty(true);
				SimuComConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};

		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		setControl(container);

		/** Create Simulator section */
		final Group simulatorGroup = new Group(container, SWT.NONE);
        simulatorGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        final GridLayout simulatorLayout = new GridLayout();
        simulatorLayout.numColumns = 3;
        simulatorGroup.setLayout(simulatorLayout);
        simulatorGroup.setText("Simulator");
		
        final Label simulatorLabel = new Label(simulatorGroup, SWT.NONE);
        simulatorLabel.setText("Simulator implementation:");
        
        String[] simulatorNames = null;
        try {
            simulatorNames = SimulatorExtensionHelper.getSimulatorNames();
        } catch (CoreException e1) {
        	if(logger.isEnabledFor(Level.WARN)) 
        		logger.warn("Could not retrieve names of simulator extensions.", e1);
        }
        simulatorCombo = new Combo(simulatorGroup, SWT.READ_ONLY);
        simulatorCombo.setItems(simulatorNames);
        simulatorCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        simulatorCombo.addSelectionListener (new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updateLaunchConfigurationDialog();
            }
        });
        
        /** Create Experiment Run section */
		final Group experimentrunGroup = new Group(container, SWT.NONE);
		experimentrunGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		experimentrunGroup.setLayout(gridLayout);
		experimentrunGroup.setText("Experiment Run");

		Label nameLabel = new Label(experimentrunGroup, SWT.NONE);
		nameLabel.setText("Experiment Name:");

		nameField = new Text(experimentrunGroup, SWT.BORDER);
		final GridData gd_nameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_nameField.widthHint = 70;
		nameField.setLayoutData(gd_nameField);
		nameField.addModifyListener(modifyListener);

		/** DataSet group */
		final Group persistenceGroup = new Group(container, SWT.NONE);
		persistenceGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		persistenceGroup.setLayout(new GridLayout(2, false));
		persistenceGroup.setText("Simulation Results");

		final Label persistenceLabel = new Label(persistenceGroup, SWT.NONE);
		persistenceLabel.setText("Persistence Framework:");

		String[] recorderNames = null;
		try {
			recorderNames = RecorderExtensionHelper.getRecorderNames();
		} catch (CoreException e1) {
			if(logger.isEnabledFor(Level.WARN)) 
				logger.warn("Could not access RecorderNames.", e1);
		}
		persistenceCombo = new Combo(persistenceGroup, SWT.READ_ONLY);
		persistenceCombo.setItems(recorderNames);
		persistenceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		persistenceCombo.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		recorderTabGroup = new RecorderTabGroup();
		CTabFolder tabFolder = TabHelper.createTabFolder(recorderTabGroup,
				getLaunchConfigurationDialog(),
				getLaunchConfigurationDialog().getMode(),
				persistenceGroup, SWT.BORDER | SWT.FLAT);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
        
		/** Create Stop Conditions section */
		final Group stopConditionsGroup = new Group(container, SWT.NONE);
		stopConditionsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		stopConditionsGroup.setLayout(gridLayout_1);
		stopConditionsGroup.setText("Stop Conditions");

		final Label timeLabel = new Label(stopConditionsGroup, SWT.NONE);
		timeLabel.setText("Maximum simulation time:");

		timeField = new Text(stopConditionsGroup, SWT.BORDER);
		timeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		timeField.addModifyListener(modifyListener);

		final Label secLabel = new Label(stopConditionsGroup, SWT.NONE);
		secLabel.setText("Simulated Time Units");

		final Label maxLabel = new Label(stopConditionsGroup, SWT.NONE);
		maxLabel.setText("Maximum measurements count:");

		maxMeasurementsField = new Text(stopConditionsGroup, SWT.BORDER);
		maxMeasurementsField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		maxMeasurementsField.addModifyListener(modifyListener);

		/** Create Confidence Stop Condition section */
		final Group confidenceGroup = new Group(container, SWT.NONE);
		confidenceGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout confidenceLayout = new GridLayout();
		confidenceLayout.numColumns = 3;
		confidenceGroup.setLayout(confidenceLayout);
		confidenceGroup.setText("Confidence Stop Condition");

		useConfidenceCheckBox = new Button(confidenceGroup, SWT.CHECK);
		useConfidenceCheckBox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		useConfidenceCheckBox.setText("Stop when reaching confidence");
		useConfidenceCheckBox.setSelection(false);
		useConfidenceCheckBox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// enable level and half-with fields if and only if check box is checked
				boolean selected = useConfidenceCheckBox.getSelection();
				levelLabel.setEnabled(selected);
				levelField.setEnabled(selected);
				halfWidthLabel.setEnabled(selected);
				halfWidthField.setEnabled(selected);
				selectModelElementLabel.setEnabled(selected);
				selectModelElementField.setEnabled(selected);
				selectModelElementButton.setEnabled(selected);
				enableBatchMeansSettings(selected);

				SimuComConfigurationTab.this.updateLaunchConfigurationDialog();
			}

		});

		levelLabel = new Label(confidenceGroup, SWT.NONE);
		levelLabel.setText("Confidence level (%):");
		levelLabel.setEnabled(false);

		levelField = new Text(confidenceGroup, SWT.BORDER);
		levelField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		levelField.addModifyListener(modifyListener);
		levelField.setEnabled(false);

		halfWidthLabel = new Label(confidenceGroup, SWT.NONE);
		halfWidthLabel.setText("Confidence interval half-width (%):");
		halfWidthLabel.setEnabled(false);

		halfWidthField = new Text(confidenceGroup, SWT.BORDER);
		halfWidthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		halfWidthField.addModifyListener(modifyListener);
		halfWidthField.setEnabled(false);

		selectModelElementLabel = new Label(confidenceGroup, SWT.NONE);
		selectModelElementLabel.setText("Monitor Response Time of:");
		selectModelElementLabel.setEnabled(false);

		selectModelElementField = new Text(confidenceGroup, SWT.BORDER);
		selectModelElementField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		selectModelElementField.addModifyListener(modifyListener);
		selectModelElementField.setEditable(false);
		selectModelElementField.setEnabled(false);

		selectModelElementButton = new Button(confidenceGroup, SWT.NONE);
		selectModelElementButton.setText("Select Model Element...");
		selectModelElementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				showSelectModelElementDialog();
			}
		});
		
		/** Batch means configuration */
		useAutomatedBatchMeansCheckBox = new Button(confidenceGroup, SWT.CHECK);
		useAutomatedBatchMeansCheckBox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		useAutomatedBatchMeansCheckBox.setText("Automatically determine batch size (Beware: Manual batch size can lead to invalid results, only use it care).");
		useAutomatedBatchMeansCheckBox.setSelection(false);
		useAutomatedBatchMeansCheckBox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// enable level and half-with fields if and only if check box is checked
				boolean selected = useAutomatedBatchMeansCheckBox.getSelection();
				batchSizeLabel.setEnabled(!selected);
				batchSizeField.setEnabled(!selected);
				minNumberOfBatchesLabel.setEnabled(!selected);
				minNumberOfBatchesField.setEnabled(!selected);

				SimuComConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});
		
		batchSizeLabel = new Label(confidenceGroup, SWT.NONE);
		batchSizeLabel.setText("Batch size:");
		batchSizeLabel.setEnabled(false);

		batchSizeField = new Text(confidenceGroup, SWT.BORDER);
		batchSizeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		batchSizeField.addModifyListener(modifyListener);
		batchSizeField.setEnabled(false);
		
		minNumberOfBatchesLabel = new Label(confidenceGroup, SWT.NONE);
		minNumberOfBatchesLabel.setText("Minimum number of batches:");
		minNumberOfBatchesLabel.setEnabled(false);

		minNumberOfBatchesField = new Text(confidenceGroup, SWT.BORDER);
		minNumberOfBatchesField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		minNumberOfBatchesField.addModifyListener(modifyListener);
		minNumberOfBatchesField.setEnabled(false);		

		/** Logging group*/
		final Group loggingGroup = new Group(container, SWT.NONE);
		loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		loggingGroup.setText("Logging");
		loggingGroup.setLayout(new GridLayout());
		checkLoggingButton = new Button(loggingGroup, SWT.CHECK);
		checkLoggingButton.setText("Enable verbose logging");
		checkLoggingButton.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				SimuComConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});
		checkLoggingButton.setSelection(false);
	}

	/**
	 * needs the value of useAutomatedBatchMeansCheckBox to be initialised. 
	 * @param parentSelected
	 */
	private void enableBatchMeansSettings(boolean parentSelected) {
		useAutomatedBatchMeansCheckBox.setEnabled(parentSelected);
		
		// depend on useAutomatedBatchMeans, too
		batchSizeLabel.setEnabled(parentSelected && !useAutomatedBatchMeansCheckBox.getSelection());
		batchSizeField.setEnabled(parentSelected && !useAutomatedBatchMeansCheckBox.getSelection());
		minNumberOfBatchesLabel.setEnabled(parentSelected && !useAutomatedBatchMeansCheckBox.getSelection());
		minNumberOfBatchesField.setEnabled(parentSelected && !useAutomatedBatchMeansCheckBox.getSelection());
	}
	
	private void showSelectModelElementDialog() {
		ResourceSet rs = loadModelFiles();
		ArrayList<Object> filter = new ArrayList<Object>();
		filter.add(UsageModel.class);
		filter.add(UsageScenario.class);
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog
			(this.getShell(), filter, rs);
		if (dialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {
			EObject modelElement = dialog.getResult();
			if (modelElement instanceof UsageScenario) {
				UsageScenario usageScenario = (UsageScenario)modelElement;
				selectedModelElementURI = EcoreUtil.getURI(modelElement);
				selectedModelElementName = usageScenario.getEntityName();
				updateModelElementField(usageScenario);
			} else {
				MessageBox warningBox = new MessageBox(selectModelElementField
						.getShell(), SWT.ICON_WARNING | SWT.OK);
				warningBox.setText("Warning");
				warningBox.setMessage("No response times will be available for " +
						"the selected model element. Please select a suitable " +
						"model element.");
				warningBox.open();
			}
		}
	}

	private void updateModelElementField(UsageScenario modelElement) {
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new PalladioItemProviderAdapterFactory(
						new UsagemodelItemProviderAdapterFactory()));
		selectModelElementField.setText(labelProvider.getText(modelElement));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Simulation";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		recorderTabGroup.initializeFrom(configuration);
		
        try {
            String simulatorId = configuration.getAttribute(AbstractSimulationConfig.SIMULATOR_ID,
                    AbstractSimulationConfig.DEFAULT_SIMULATOR_ID);
            String simulatorName = SimulatorExtensionHelper.getSimulatorNameForId(simulatorId);
            String[] items = simulatorCombo.getItems();
            for (int i = 0; i < items.length; i++) {
                String currentItemName = items[i];
                if (currentItemName.equals(simulatorName)) {
                    simulatorCombo.select(i);
                }
            }
        } catch (CoreException e) {
        	if(logger.isEnabledFor(Level.WARN)) 
        		logger.warn("Could not initialise simulator selection.", e);
        }
		
		try {
			nameField.setText(configuration.getAttribute(
					AbstractSimulationConfig.EXPERIMENT_RUN, ""));
		} catch (CoreException e) {
			nameField.setText("MyRun");
		}

		try {
			timeField.setText(configuration.getAttribute(
					AbstractSimulationConfig.SIMULATION_TIME, ""));
		} catch (CoreException e) {
			timeField.setText("150000");
		}

		try {
			maxMeasurementsField.setText(configuration.getAttribute(
					AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT, ""));
		} catch (CoreException e) {
			maxMeasurementsField.setText("10000");
		}

		try {
			String persistenceFrameworkName = configuration.getAttribute(
					AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, "");
			String[] items = persistenceCombo.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(persistenceFrameworkName)){
					persistenceCombo.select(i);
				}
			}
		} catch (CoreException e) {
			if(logger.isEnabledFor(Level.WARN)) 
				logger.warn("Could not access persistency recorder name.", e);
		}

		try {
			checkLoggingButton.setSelection(configuration.getAttribute(
					AbstractSimulationConfig.VERBOSE_LOGGING, false));
		} catch (CoreException e) {
			checkLoggingButton.setSelection(false);
		}

		try {
			levelField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_LEVEL, "95"));
		} catch (CoreException e) {
			levelField.setText(""+SimuComConfig.DEFAULT_CONFIDENCE_LEVEL);
		}

		try {
			halfWidthField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_HALFWIDTH, "10"));
		} catch (CoreException e) {
			halfWidthField.setText(""+SimuComConfig.DEFAULT_CONFIDENCE_HALFWIDTH);
		}
		

		String defaultBatchSize = ""+SimuComConfig.DEFAULT_CONFIDENCE_BATCH_SIZE;
		try {
			batchSizeField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_BATCH_SIZE, defaultBatchSize));
		} catch (CoreException e) {
			batchSizeField.setText(defaultBatchSize);
		}
		
		String defaultMinNumberOfBatches = ""+SimuComConfig.DEFAULT_CONFIDENCE_MIN_NUMBER_OF_BATCHES;
		try {
			minNumberOfBatchesField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_MIN_NUMBER_OF_BATCHES, defaultMinNumberOfBatches));
		} catch (CoreException e) {
			minNumberOfBatchesField.setText(defaultMinNumberOfBatches);
		}

		try {
			String usageFile = configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, "");
			modelFiles.clear();
			if (!usageFile.isEmpty()) {
				modelFiles.add(usageFile);
	}
		} catch (CoreException e) {
		}

		try {
			selectedModelElementURI = URI.createURI(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_MODELELEMENT_URI, ""));
			UsageScenario usageScenario = getUsageScenarioFromURI(selectedModelElementURI);
			selectedModelElementName = usageScenario.getEntityName();
			updateModelElementField(usageScenario);
		} catch (Exception e) {
			selectedModelElementURI = null;
			selectedModelElementName = "";
			selectModelElementField.setText("");
		}
		
	
		// decide how to enable / disable them after initialising the values. 
		try {
			boolean isAutomaticBatches = configuration.getAttribute(
					SimuComConfig.CONFIDENCE_USE_AUTOMATIC_BATCHES, false);
			useAutomatedBatchMeansCheckBox.setSelection(isAutomaticBatches);
			
			boolean select = configuration.getAttribute(
					SimuComConfig.USE_CONFIDENCE, false);
			useConfidenceCheckBox.setSelection(select);
			
			levelLabel.setEnabled(select);
			levelField.setEnabled(select);
			halfWidthLabel.setEnabled(select);
			halfWidthField.setEnabled(select);
			selectModelElementLabel.setEnabled(select);
			selectModelElementField.setEnabled(select);
			selectModelElementButton.setEnabled(select);
			
			// needs the value of useAutomatedBatchMeansCheckBox to be initialised.  
			enableBatchMeansSettings(select);
			
		} catch (CoreException e) {
			useConfidenceCheckBox.setSelection(false);
			levelLabel.setEnabled(false);
			levelField.setEnabled(false);
			halfWidthLabel.setEnabled(false);
			halfWidthField.setEnabled(false);
			selectModelElementLabel.setEnabled(false);
			selectModelElementField.setEnabled(false);
			selectModelElementButton.setEnabled(false);
			enableBatchMeansSettings(false);
			
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        // delegate this method call to recorder tab group
        recorderTabGroup.performApply(configuration);

        // apply simulator selection
        try {
            // find simulator id for the given simulator name
            String simulatorId = SimulatorExtensionHelper.getSimulatorIdForName(simulatorCombo.getText());
            configuration.setAttribute(AbstractSimulationConfig.SIMULATOR_ID, simulatorId);
        } catch (CoreException e) {
        	if(logger.isEnabledFor(Level.ERROR)) 
        		logger.error("Failed to retrieve the id for simulator \"" + simulatorCombo.getText() + "\"");
        }
        
		configuration.setAttribute(AbstractSimulationConfig.EXPERIMENT_RUN,
				nameField.getText());
		configuration.setAttribute(AbstractSimulationConfig.SIMULATION_TIME,
				timeField.getText());
		configuration.setAttribute(AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT,
						maxMeasurementsField.getText());
		configuration.setAttribute(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME,
				persistenceCombo.getText());
		configuration.setAttribute(AbstractSimulationConfig.VERBOSE_LOGGING,
				checkLoggingButton.getSelection());
		configuration.setAttribute(SimuComConfig.USE_CONFIDENCE,
				useConfidenceCheckBox.getSelection());
		configuration.setAttribute(SimuComConfig.CONFIDENCE_LEVEL,
				levelField.getText());
		configuration.setAttribute(SimuComConfig.CONFIDENCE_HALFWIDTH,
				halfWidthField.getText());
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME,
				selectedModelElementName);

		if (selectedModelElementURI != null) {
			configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_URI,
					selectedModelElementURI.toString());
		} else {
			configuration.setAttribute(
					SimuComConfig.CONFIDENCE_MODELELEMENT_URI, "");
		}
		configuration.setAttribute(SimuComConfig.CONFIDENCE_USE_AUTOMATIC_BATCHES,
				useAutomatedBatchMeansCheckBox.getSelection());
		configuration.setAttribute(SimuComConfig.CONFIDENCE_BATCH_SIZE,
				batchSizeField.getText());
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MIN_NUMBER_OF_BATCHES,
				minNumberOfBatchesField.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// delegate this method call to recorder tab group
		if (recorderTabGroup != null) {
			recorderTabGroup.setDefaults(configuration);
		}

		configuration.setAttribute(AbstractSimulationConfig.SIMULATOR_ID, AbstractSimulationConfig.DEFAULT_SIMULATOR_ID);
        configuration.setAttribute(AbstractSimulationConfig.EXPERIMENT_RUN, AbstractSimulationConfig.DEFAULT_EXPERIMENT_RUN);
        configuration.setAttribute(AbstractSimulationConfig.SIMULATION_TIME, AbstractSimulationConfig.DEFAULT_SIMULATION_TIME);
        configuration.setAttribute(AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT, AbstractSimulationConfig.DEFAULT_MAXIMUM_MEASUREMENT_COUNT);
        configuration.setAttribute(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, AbstractSimulationConfig.DEFAULT_PERSISTENCE_RECORDER_NAME);
		configuration.setAttribute(SimuComConfig.USE_CONFIDENCE, SimuComConfig.DEFAULT_USE_CONFIDENCE);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_LEVEL, SimuComConfig.DEFAULT_CONFIDENCE_LEVEL);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_HALFWIDTH, SimuComConfig.DEFAULT_CONFIDENCE_HALFWIDTH);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, SimuComConfig.DEFAULT_CONFIDENCE_MODELELEMENT_NAME);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, SimuComConfig.DEFAULT_CONFIDENCE_MODELELEMENT_URI);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_USE_AUTOMATIC_BATCHES, SimuComConfig.DEFAULT_CONFIDENCE_USE_AUTOMATIC_BATCHES);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_BATCH_SIZE, SimuComConfig.DEFAULT_CONFIDENCE_BATCH_SIZE);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MIN_NUMBER_OF_BATCHES, SimuComConfig.DEFAULT_CONFIDENCE_MIN_NUMBER_OF_BATCHES);

		// set default value for persistence framework
		try {
			String[] recorderNames = RecorderExtensionHelper.getRecorderNames();
			if (recorderNames.length > 0){
				configuration.setAttribute(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, recorderNames[0]);
			}
		} catch (CoreException e1) {
			if(logger.isEnabledFor(Level.ERROR)) 
				logger.error("Could not set default value for persistence framework.", e1);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return SimuControllerImages.imageRegistry
				.get(SimuControllerImages.SIMUCOM_CONF);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		String simulatorName = simulatorCombo.getText();
        if (simulatorName == null || simulatorName.isEmpty()) {
            setErrorMessage("Simulator implementation is missing!");
            return false;
        }
		if (nameField.getText().equals("")){
			setErrorMessage("ExperimentRun name is missing!");
			return false;
		}
		if (timeField.getText().equals("")){
			setErrorMessage("Simulation time is missing!");
			return false;
		}
		if (maxMeasurementsField.getText().equals("")){
			setErrorMessage("Maximum Measurement counter is missing!");
			return false;
		}
		String persistenceFrameworkName = persistenceCombo.getText();
		if (persistenceFrameworkName == null || persistenceFrameworkName.isEmpty()) {
			setErrorMessage("Persistence Framework is missing!");
			return false;
		}
		// delegate validation to persistence framework tabs
		ILaunchConfigurationTab[] recorderTabs = recorderTabGroup.getTabs();
		for (ILaunchConfigurationTab tab : recorderTabs) {
			if (tab.getName().equals(persistenceFrameworkName) && !tab.isValid(launchConfig)) {
				setErrorMessage(persistenceFrameworkName + ": " + tab.getErrorMessage());
				return false;
			}
		}
		// check confidence level
		if (useConfidenceCheckBox.getSelection() && "".equals(levelField.getText())) {
			setErrorMessage("Confidence level is missing!");
			return false;
		} else if (useConfidenceCheckBox.getSelection() && "".equals(halfWidthField.getText())) {
			setErrorMessage("Confidence interval half-width is missing!");
			return false;
		} else if (useConfidenceCheckBox.getSelection() && "".equals(selectModelElementField.getText())) {
			setErrorMessage("Specify the usage scenario for which the confidence interval should be determined.");
			return false;
		} else if (useConfidenceCheckBox.getSelection() && !"".equals(levelField.getText())) {
			try {
				double level = Double.parseDouble(levelField.getText());
				if (level < 0 || level > 100) {
					setErrorMessage("Confidence level has to be a percentage!");
					return false;
				}
			} catch (NumberFormatException ex) {
				setErrorMessage("Confidence level has to be an number!");
				return false;
			}
		}
		// check confidence interval half-width
		if (useConfidenceCheckBox.getSelection() && halfWidthField.getText().equals("")) {
			setErrorMessage("Confidence interval half-width is missing!");
			return false;
		} else if (useConfidenceCheckBox.getSelection() && halfWidthField.getText().length() > 0) {
			try {
				int halfWidth = Integer.parseInt(halfWidthField.getText());
				if (halfWidth < 0 || halfWidth > 100) {
					setErrorMessage("Half-width has to be a percentage!");
					return false;
				}
			} catch (NumberFormatException ex) {
				setErrorMessage("Half-width has to be an integer!");
				return false;
			}
		}
		// check, whether a model element is selected
		if (useConfidenceCheckBox.getSelection()
				&& selectedModelElementURI == null) {
			setErrorMessage("Select a model element whose response times are " +
					"to be monitored!");
		}
		
		// check validity of batch size and number settings
		if (useConfidenceCheckBox.getSelection() 
				&& !useAutomatedBatchMeansCheckBox.getSelection()){
			if ("".equals(batchSizeField.getText())){
				setErrorMessage("Batch size has to be specified if not determined automatically.");
				return false;
			} else if ("".equals(minNumberOfBatchesField.getText())){
				setErrorMessage("Minimum number of batches have to be specified if not determined automatically.");
				return false;
			}
			
			try {
				Integer.parseInt(batchSizeField.getText());
			} catch (NumberFormatException ex) {
				setErrorMessage("Batch size has to be an integer!");
				return false;
			}
			
			try {
				Integer.parseInt(minNumberOfBatchesField.getText());
			} catch (NumberFormatException ex) {
				setErrorMessage("Minimum number of batches has to be an integer!");
				return false;
			}
			
		}
		
		return true;
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy configuration) {
		try {
			String usageFile = configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, "");

			if (!usageFile.isEmpty()) {
				// Prevent reloading the model elements when usage file has not
				// changed
				if (!modelFiles.contains(usageFile)) {
					modelFiles.clear();
					modelFiles.add(usageFile);

					selectedModelElementURI = URI.createURI(configuration.getAttribute(
							SimuComConfig.CONFIDENCE_MODELELEMENT_URI, ""));
					UsageScenario usageScenario = getUsageScenarioFromURI(selectedModelElementURI);
					selectedModelElementName = usageScenario.getEntityName();
					updateModelElementField(usageScenario);
}
			}
		} catch (Exception e) {
			selectedModelElementURI = null;
			selectedModelElementName = "";
			selectModelElementField.setText("");
		}

	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

	private ResourceSet loadModelFiles() {
		ResourceSet rs = new ResourceSetImpl();
		for (String file : modelFiles) {
			try {
				rs.getResource(URI.createURI(file), true);
			} catch (Exception ex) {
				try {
					rs.getResource(URI.createFileURI(file), true);
				} catch (Exception exInner) {
				}
			}
		}
		EcoreUtil.resolveAll(rs);
		return rs;
	}

	private UsageScenario getUsageScenarioFromURI(URI selectedModelElementURI)
			throws Exception {
		ResourceSet rs = loadModelFiles();
		EObject selectedModelElement = rs.getEObject(selectedModelElementURI,
				false);

		if (selectedModelElement != null
				&& selectedModelElement instanceof UsageScenario) {
			return (UsageScenario) selectedModelElement;
		} else {
			throw new RuntimeException("selectedModelElement " +
					"is null or of wrong type");
		}
	}

}
