/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

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

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderTabGroup;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;

/**
 * The class defines a tab, which is responsible for the SimuCom configuration.
 * 
 * @author Roman Andrej
 */
public class SimuComConfigurationTab extends AbstractLaunchConfigurationTab {

	private Text nameField;
	private Text timeField;
	private Text maxMeasurementsField;
	private Text dataField;
	private Button checkLoggingButton;
	private Button useConfidenceCheckBox;
	private Label levelLabel;
	private Text levelField;
	private Label halfWidthLabel;
	private Text halfWidthField;
	private Label selectModelElementLabel;
	private Text selectModelElementField;
	private Button selectModelElementButton;
	private Combo persistenceCombo;
	private ArrayList<String> modelFiles = new ArrayList<String>();
	private String selectedModelElementName;
	private URI selectedModelElementURI;
	
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
		
		/** Create SimuCom section */
		final Group simucomGroup = new Group(container, SWT.NONE);
		simucomGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		simucomGroup.setLayout(gridLayout_1);
		simucomGroup.setText("SimuCom");

		final Label timeLabel = new Label(simucomGroup, SWT.NONE);
		timeLabel.setText("Maximum simulation time:");

		timeField = new Text(simucomGroup, SWT.BORDER);
		timeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		timeField.addModifyListener(modifyListener);

		final Label secLabel = new Label(simucomGroup, SWT.NONE);
		secLabel.setText("Simulated Time Units");

		final Label maxLabel = new Label(simucomGroup, SWT.NONE);
		maxLabel.setText("Maximum measurements count:");

		maxMeasurementsField = new Text(simucomGroup, SWT.BORDER);
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
		persistenceGroup.setText("Persistence");

		final Label persistenceLabel = new Label(persistenceGroup, SWT.NONE);
		persistenceLabel.setText("Persistence Framework:");

		String[] recorderNames = null;
		try {
			recorderNames = RecorderExtensionHelper.getRecorderNames();
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		persistenceCombo = new Combo(persistenceGroup, SWT.READ_ONLY);
		persistenceCombo.setItems(recorderNames);
		persistenceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		persistenceCombo.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
				System.out.println("Default");
			}
			
		});
		
		recorderTabGroup = new RecorderTabGroup();
		CTabFolder tabFolder = TabHelper.createTabFolder(recorderTabGroup,
				getLaunchConfigurationDialog(),
				getLaunchConfigurationDialog().getMode(),
				persistenceGroup, SWT.BORDER | SWT.FLAT);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		
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
		return "SimuCom";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		recorderTabGroup.initializeFrom(configuration);
		try {
			nameField.setText(configuration.getAttribute(
					SimuComConfig.EXPERIMENT_RUN, ""));
		} catch (CoreException e) {
			nameField.setText("MyRun");
		}

		try {
			timeField.setText(configuration.getAttribute(
					SimuComConfig.SIMULATION_TIME, ""));
		} catch (CoreException e) {
			timeField.setText("150000");
		}

		try {
			maxMeasurementsField.setText(configuration.getAttribute(
					SimuComConfig.MAXIMUM_MEASUREMENT_COUNT, ""));
		} catch (CoreException e) {
			maxMeasurementsField.setText("10000");
		}
		
		try {
			String persistenceFrameworkName = configuration.getAttribute(
					SimuComConfig.PERSISTENCE_RECORDER_NAME, "");
			String[] items = persistenceCombo.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(persistenceFrameworkName)){
					persistenceCombo.select(i);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		try {
			checkLoggingButton.setSelection(configuration.getAttribute(
					SimuComConfig.VERBOSE_LOGGING, false));
		} catch (CoreException e) {
			checkLoggingButton.setSelection(false);
		}
		
		try {
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
		} catch (CoreException e) {
			useConfidenceCheckBox.setSelection(false);
			levelLabel.setEnabled(false);
			levelField.setEnabled(false);
			halfWidthLabel.setEnabled(false);
			halfWidthField.setEnabled(false);
			selectModelElementLabel.setEnabled(false);
			selectModelElementField.setEnabled(false);
			selectModelElementButton.setEnabled(false);
	}

		try {
			levelField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_LEVEL, "95"));
		} catch (CoreException e) {
			levelField.setText("95");
		}
		
		try {
			halfWidthField.setText(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_HALFWIDTH, "10"));
		} catch (CoreException e) {
			halfWidthField.setText("10");
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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Comment
		recorderTabGroup.performApply(configuration);
		
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				nameField.getText());
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
				timeField.getText());		
		configuration.setAttribute(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT,
						maxMeasurementsField.getText());
		configuration.setAttribute(SimuComConfig.PERSISTENCE_RECORDER_NAME,
				persistenceCombo.getText());
		configuration.setAttribute(SimuComConfig.VERBOSE_LOGGING,
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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Comment
		if (recorderTabGroup != null) {
			recorderTabGroup.setDefaults(configuration);
		}
		
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				"MyRun");
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
		"150000");
		configuration.setAttribute(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT,
		"10000");
		configuration.setAttribute(SimuComConfig.PERSISTENCE_RECORDER_NAME, "");
		configuration.setAttribute(SimuComConfig.USE_CONFIDENCE, false);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_LEVEL, 95);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_HALFWIDTH, 10);
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, "");
		configuration.setAttribute(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, "");
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
