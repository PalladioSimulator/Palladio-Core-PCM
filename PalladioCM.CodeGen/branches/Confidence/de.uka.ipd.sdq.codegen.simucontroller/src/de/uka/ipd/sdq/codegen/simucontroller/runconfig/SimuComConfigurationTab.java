/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.ConfigureDatasourceDialog;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.DatasourceListLabelProvider;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

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
	
	private ArrayList<String> modelFiles = new ArrayList<String>();
	private String selectedModelElementName;
	private URI selectedModelElementURI;
	protected int selectedDataSourceID;

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
		
		Composite container = new Composite(parent, SWT.NONE);
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
		secLabel.setText("Simulated Seconds");

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

		/**DataSet group */
		final Group dataSetGroup = new Group(container, SWT.NONE);
		dataSetGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 3;
		dataSetGroup.setLayout(gridLayout_2);
		dataSetGroup.setText("Data Set");

		final Label dataSourceLabel = new Label(dataSetGroup, SWT.NONE);
		dataSourceLabel.setText("Data source:");

		dataField = new Text(dataSetGroup, SWT.BORDER | SWT.READ_ONLY);
		dataField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dataField.addModifyListener(modifyListener);

		final Button browseButton = new Button(dataSetGroup, SWT.NONE);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigureDatasourceDialog dialog = new ConfigureDatasourceDialog(e.display
						.getActiveShell(),"Select Datasource...", true);
				if (dialog.open() == Dialog.OK) {
					IDAOFactory dataSet = (IDAOFactory) dialog.getResult();
					selectedDataSourceID = (int) dataSet.getID();
					dataField.setText(dataSet.getName() + " [" + dataSet.getID() + " ]");
				}
			}
		});
		
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
		ResourceSet rs = loadResourceSetForModelFiles();
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
	
	private ResourceSet loadResourceSetForModelFiles() {
		ResourceSet rs = new ResourceSetImpl();
		for (String file : modelFiles) {
			try {
				rs.getResource(URI.createURI(file), true);
			} catch (Exception ex) {
				rs.getResource(URI.createFileURI(file), true);
			}
		}
		EcoreUtil.resolveAll(rs);
		return rs;
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
			selectedDataSourceID = 
				configuration.getAttribute(
						SimuComConfig.DATASOURCE_ID, -1);
			if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null)
				dataField.setText("");
			else {
				IDAOFactory factory = SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID);
				dataField.setText(DatasourceListLabelProvider.dataSetRepresentation(factory));
			}
		} catch (CoreException e) {
			selectedDataSourceID = -1;
			dataField.setText("");
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
			modelFiles.clear();
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ""));
		} catch (CoreException e) {
			selectModelElementField.setText("");
		}
		
		try {
			selectedModelElementURI = URI.createURI(configuration.getAttribute(
					SimuComConfig.CONFIDENCE_MODELELEMENT_URI, ""));
			ResourceSet rs = loadResourceSetForModelFiles();
			EObject selectedModelElement = rs.getEObject(selectedModelElementURI, false);		
			if (selectedModelElement != null && selectedModelElement instanceof UsageScenario) {
				UsageScenario usageScenario = (UsageScenario)selectedModelElement;
				selectedModelElementName = usageScenario.getEntityName();
				updateModelElementField(usageScenario);
			} else {	// selectedModelElement is null or of wrong type
				selectedModelElementURI = null;
				selectedModelElementName = "";
				selectModelElementField.setText("");
			}
		} catch (CoreException e) {
			selectedModelElementURI = null;
			selectedModelElementName = "";
			selectModelElementField.setText("");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				nameField.getText());
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
				timeField.getText());		
		configuration.setAttribute(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT,
						maxMeasurementsField.getText());
		configuration.setAttribute(SimuComConfig.DATASOURCE_ID,
				selectedDataSourceID);
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
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				"MyRun");
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
		"150000");
		configuration.setAttribute(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT,
		"10000");
		configuration.setAttribute(SimuComConfig.DATASOURCE_ID,
				-1);
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
		if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null){
			setErrorMessage("Data source is missing!");
			return false;
		}
		// check confidence level
		if (useConfidenceCheckBox.getSelection() && levelField.getText().equals("")) {
			setErrorMessage("Confidence level is missing!");
			return false;
		} else if (useConfidenceCheckBox.getSelection() && levelField.getText().length() > 0) {
			try {
				int level = Integer.parseInt(levelField.getText());
				if (level < 0 || level > 100) {
					setErrorMessage("Confidence level has to be a percentage!");
					return false;
				}
			} catch (NumberFormatException ex) {
				setErrorMessage("Confidence level has to be an integer!");
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
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}
	
}
