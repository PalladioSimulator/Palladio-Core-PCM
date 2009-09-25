package de.uka.ipd.sdq.workflow.launchconfig.tabs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.navigator.ResourcePatternFilter;

import de.uka.ipd.sdq.featureinstance.FeatureConfigWidget;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;

/**
 * The class defines a tab, where the specific characteristics for the
 * simulation can be set.
 * 
 * @author Roman Andrej
 */
public class FeatureOptionsTab extends AbstractLaunchConfigurationTab {

	private static final String DEFAULT_CONNECTOR_FEATURE_CONFIG = "pathmap://PCM_MODELS/ConnectorConfig.featureconfig";
	private Button simulateLinkingResourcesButton;
	private Button simulateFailuresButton;
	private Text textFeatureConfig;
	private Text textTargetConfig;
	private FeatureConfigWidget editorWidget;
	private String sourceFile;
	private String targetFile;
	private Composite container;
	private Button modelSaveButton;
	private boolean editorValid = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (e.getSource().equals(textFeatureConfig)) {
					if (sourceFile == null || !sourceFile.equals(textFeatureConfig.getText())) {
						sourceFile = textFeatureConfig.getText();

						if (sourceFile != null && targetFile != null) {
							editorWidget.setSourceInput(sourceFile);
							editorWidget.setTargetInput(targetFile);
							editorValid = editorWidget.createPages();
						}
					}
				} else if (e.getSource().equals(textTargetConfig)) {
					if (targetFile == null || !targetFile.equals(textTargetConfig.getText())) {
						targetFile = textTargetConfig.getText();

						if (sourceFile != null && targetFile != null) {
							editorWidget.setSourceInput(sourceFile);
							editorWidget.setTargetInput(targetFile);
							editorValid = editorWidget.createPages();
						}
					}
				}
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		final ICheckStateListener checkListener = new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (modelSaveButton != null) {
					modelSaveButton.setEnabled(true);
				}
			}
		};

		// Create the top-level container:
		container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		// Create networking section:
		final Group networkingGroup = new Group(container, SWT.NONE);
		networkingGroup.setText("Networking");
		final GridData gd_networkingGroup = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		networkingGroup.setLayoutData(gd_networkingGroup);
		networkingGroup.setLayout(new GridLayout());
		simulateLinkingResourcesButton = new Button(networkingGroup, SWT.CHECK);
		final GridData gd_simulateLinkingResourcesButton = new GridData(
				SWT.FILL, SWT.CENTER, true, false);
		simulateLinkingResourcesButton
				.setLayoutData(gd_simulateLinkingResourcesButton);
		simulateLinkingResourcesButton.setText("Simulate linking resources");
		simulateLinkingResourcesButton.addSelectionListener(selectionListener);

		// Create reliability section:
		final Group reliabilityGroup = new Group(container, SWT.NONE);
		reliabilityGroup.setText("Reliability");
		final GridData gd_reliabilityGroup = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		reliabilityGroup.setLayoutData(gd_reliabilityGroup);
		reliabilityGroup.setLayout(new GridLayout());
		simulateFailuresButton = new Button(reliabilityGroup, SWT.CHECK);
		final GridData gd_simulateFailuresButton = new GridData(
				SWT.FILL, SWT.CENTER, true, false);
		simulateFailuresButton
				.setLayoutData(gd_simulateFailuresButton);
		simulateFailuresButton.setText("Simulate failures");
		simulateFailuresButton.addSelectionListener(selectionListener);

		// Create PCM2EJB feature configuration section:
		final Group featureConfigGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryTypeGroup = new GridLayout();
		glReposetoryTypeGroup.numColumns = 3;
		featureConfigGroup.setLayout(glReposetoryTypeGroup);
		featureConfigGroup.setText("PCM2EJB Feature Configuration File");
		featureConfigGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		textFeatureConfig = new Text(featureConfigGroup, SWT.SINGLE
				| SWT.BORDER);
		final GridData gd_textResourceTypeRepository = new GridData(SWT.FILL,
				SWT.CENTER, true, false);
		gd_textResourceTypeRepository.widthHint = 200;
		textFeatureConfig.setLayoutData(gd_textResourceTypeRepository);
		textFeatureConfig.addModifyListener(modifyListener);
		final Button workspaceButton = new Button(featureConfigGroup, SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton.addSelectionListener(new WorkspaceButtonSelectionListener(
						textFeatureConfig,
						ConstantsContainer.FEATURECONFIG_EXTENSION));
		final Button buttonResourceTypeRepository = new Button(
				featureConfigGroup, SWT.NONE);
		buttonResourceTypeRepository.setLayoutData(new GridData());
		buttonResourceTypeRepository.setText("File System...");
		buttonResourceTypeRepository
				.addSelectionListener(new SelectionAdapter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.swt.events.SelectionAdapter#widgetSelected
					 * (org.eclipse.swt.events.SelectionEvent)
					 */
					public void widgetSelected(SelectionEvent e) {
						textFeatureConfig
								.setText(openFileDialog(ConstantsContainer.FEATURECONFIG_EXTENSION));
					}
				});
		
		// Create target feature configuration section:
		final Group targetConfigGroup = new Group(container, SWT.NONE);
		final GridLayout glRepositoryTypeGroup = new GridLayout();
		glRepositoryTypeGroup.numColumns = 3;
		targetConfigGroup.setLayout(glRepositoryTypeGroup);
		targetConfigGroup.setText("Target featureconfig file");
		targetConfigGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		textTargetConfig = new Text(targetConfigGroup, SWT.SINGLE
				| SWT.BORDER);
		final GridData gd_textTResourceTypeRepository = new GridData(SWT.FILL,
				SWT.CENTER, true, false);
		gd_textTResourceTypeRepository.widthHint = 200;
		textTargetConfig.setLayoutData(gd_textTResourceTypeRepository);
		textTargetConfig.addModifyListener(modifyListener);
		final Button targetButton = new Button(targetConfigGroup, SWT.NONE);
		targetButton.setText("Workspace...");
		targetButton
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textTargetConfig,
						ConstantsContainer.FEATURECONFIG_EXTENSION));
		final Button buttonTResourceTypeRepository = new Button(
				targetConfigGroup, SWT.NONE);
		buttonTResourceTypeRepository.setLayoutData(new GridData());
		buttonTResourceTypeRepository.setText("File System...");
		buttonTResourceTypeRepository
		.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				textTargetConfig
						.setText(openFileDialog(ConstantsContainer.FEATURECONFIG_EXTENSION));
			}
		});
		
		// Create Editor widget
		final Group editorGroup = new Group(container, SWT.NONE);
		editorGroup.setText("FeatureConfig Editor:");
		editorGroup.setLayout(new RowLayout(SWT.VERTICAL));
		editorWidget = new FeatureConfigWidget(editorGroup);
		editorWidget.addCheckStateListener(checkListener);
		modelSaveButton = new Button(editorGroup, SWT.NONE);
		modelSaveButton.setText("Save featureconfig");
		modelSaveButton.setEnabled(false);
		modelSaveButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				editorWidget.doSave(new NullProgressMonitor());
				modelSaveButton.setEnabled(false);
			}
		});
		Button validateButton = new Button(editorGroup, SWT.NONE);
		validateButton.setText("Validate");
		validateButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (editorWidget != null) {
					editorWidget.validate();
				}
			}
		});
	}
	
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		
		if (!validateFilePath(textFeatureConfig.getText(),
				ConstantsContainer.FEATURECONFIG_EXTENSION)) {
			setErrorMessage("Source model file is missing!");
			return false;
		}
		if (!validateFilePath(textTargetConfig.getText(),
				ConstantsContainer.FEATURECONFIG_EXTENSION)) {
			setErrorMessage("Target model file is missing!");
			return false;
		}
		if (editorWidget != null) {
			if (!editorValid) {
				setErrorMessage(editorWidget.getErrorMessage());
			}
			return false;
		}
		
		return true;
	}
	
	private boolean validateFilePath(String filePath, String[] extensions){
		if (filePath.equals(""))
			return false;
		String extension = getExtensionFromArray(extensions).replace("*", ""); 
		if (filePath.contains(extension))
			return true;
		return false;
	}
	
	private String getExtensionFromArray(String[] array){
		return array[0];
	}

	/**
	 * The function calls the FileDialog and gives back absolute path on the
	 * file as String
	 * 
	 * @param extensions
	 *            which the dialog will use to filter the files it shows to the
	 *            argument
	 * @return absolute path to a file
	 */
	private String openFileDialog(String[] extensions) {
		String filename = "";

		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		dialog.setFilterExtensions(extensions);
		dialog.setText("Select model file");

		if (dialog.open() != null) {
			String root = dialog.getFilterPath() + File.separatorChar;
			filename = root + dialog.getFileName();
		}
		return filename;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Feature Settings";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return RunConfigImages.getFeaturTabImage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			simulateLinkingResourcesButton
					.setSelection(configuration
							.getAttribute(
									ConstantsContainer.SIMULATE_LINKING_RESOURCES,
									true));
		} catch (CoreException e) {
			simulateLinkingResourcesButton.setSelection(true);
		}
		try {
			simulateFailuresButton
					.setSelection(configuration
							.getAttribute(
									ConstantsContainer.SIMULATE_FAILURES,
									true));
		} catch (CoreException e) {
			simulateFailuresButton.setSelection(false);
		}
		try {
			textFeatureConfig.setText(configuration.getAttribute(
					ConstantsContainer.FEATURE_CONFIG, ""));
		} catch (CoreException e) {
			simulateLinkingResourcesButton.setSelection(true);
		}
		try {
			textTargetConfig.setText(configuration.getAttribute(
					ConstantsContainer.FEATURE_CONFIG_TARGET, ""));
		} catch (CoreException e) {
			simulateLinkingResourcesButton.setSelection(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ConstantsContainer.SIMULATE_LINKING_RESOURCES,
				this.simulateLinkingResourcesButton.getSelection());
		configuration.setAttribute(
				ConstantsContainer.SIMULATE_FAILURES,
				this.simulateFailuresButton.getSelection());
		configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG,
				textFeatureConfig.getText());
		configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG_TARGET,
				textTargetConfig.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ConstantsContainer.SIMULATE_LINKING_RESOURCES, true);
		configuration.setAttribute(
				ConstantsContainer.SIMULATE_FAILURES, false);
		configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG,
				DEFAULT_CONNECTOR_FEATURE_CONFIG);
	}

	/** Button SelectionListener - call a WorkspaceResourceDialog */
	class WorkspaceButtonSelectionListener extends SelectionAdapter {

		private Text field;
		private String extension;

		public WorkspaceButtonSelectionListener(Text field, String[] extensions) {
			this.field = field;
			this.extension = getExtensionFromArray(extensions);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			field.setText(openResourceDialog(extension, true));
		}

		private String getExtensionFromArray(String[] array) {
			return array[0];
		}
	}

	/**
	 * The function calls the ContainerSelectionDialog and gives back relative
	 * to the workspace
	 * 
	 * @return relative path to file in workspace
	 */
	private String openResourceDialog(String extension, boolean relativePath) {

		/** Filter from the redundant files. */
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ResourcePatternFilter filter = new ResourcePatternFilter();
		filter
				.setPatterns(new String[] { "*diagram", "*.settings",
						"*.project" });
		filters.add(filter);

		/** create the dialog message */
		String msg = "Select a file (" + extension + ").";

		IFile file = null;

		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(),
				null, msg, false, null, filters);

		if (files.length != 0)
			file = files[0];
		if (file != null) {
			if (relativePath) {
				return file.getFullPath().toOSString().substring(1);
			} else {
				return file.getLocation().toOSString();
			}
		}

		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab";
	}

}
