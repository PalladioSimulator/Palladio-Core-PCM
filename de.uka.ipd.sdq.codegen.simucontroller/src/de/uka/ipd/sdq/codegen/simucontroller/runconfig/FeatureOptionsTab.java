package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
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

import de.uka.ipd.sdq.featureinstance.FeatureConfigWidget;
import de.uka.ipd.sdq.workflow.launchconfig.ImageRegistryHelper;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, where the specific characteristics for the simulation can be set.
 *
 * @author Roman Andrej
 * @author groenda
 */
public class FeatureOptionsTab extends AbstractLaunchConfigurationTab {

    /** The id of this plug-in. */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.codegen.simucontroller";
    /** The path to the image file for the tab icon. */
    private static final String FEATURE_OPTIONS_TAB_IMAGE_PATH = "icons/feature_tab.gif";

    private static final String TITLE_FEATURE_CONFIG_SECTION = "PCM2EJB Feature Configuration File";
    private static final String LABEL_SIMULATE_NETWORK = "Simulate throughput of linking resources and middleware marshalling / demarshalling of remote calls.";
    private static final String SIMULATE_NETWORK_EXPLANATION = "Latency is always simulated if linking resources connect containers. The linking resource is treated as a FCFS resource.";

    // Default values
    private static final Boolean DEFAULT_SIMULATE_FAILURES = false;
    private static final Boolean DEFAULT_SIMULATE_LINKING_RESOURCES = false;
    private static final String DEFAULT_FEATURE_CONFIGURATION_FILE_LABEL = "Feature Configuration File";
    // UI elements
    private Button simulateLinkingResourcesButton;
    private Button simulateFailuresButton;
    private Text textFeatureConfig;
    private Text textTargetConfig;
    private FeatureConfigWidget editorWidget;
    private String sourceFile;
    private String targetFile;
    private Button modelSaveButton;

    private boolean editorValid = true;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
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
        Composite container = new Composite(parent, SWT.NONE);

        setControl(container);
        container.setLayout(new GridLayout());

        // Create networking section:
        final Group networkingGroup = new Group(container, SWT.NONE);
        networkingGroup.setText("Networking");
        final GridData gd_networkingGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
        networkingGroup.setLayoutData(gd_networkingGroup);
        networkingGroup.setLayout(new GridLayout());
        simulateLinkingResourcesButton = new Button(networkingGroup, SWT.CHECK);
        final GridData gd_simulateLinkingResourcesButton = new GridData(SWT.FILL, SWT.CENTER, true, false);
        simulateLinkingResourcesButton.setLayoutData(gd_simulateLinkingResourcesButton);
        simulateLinkingResourcesButton.setText(FeatureOptionsTab.LABEL_SIMULATE_NETWORK);
        simulateLinkingResourcesButton.addSelectionListener(selectionListener);

        Label simulateLinkingResourceLabel = new Label(networkingGroup, SWT.NONE);
        simulateLinkingResourceLabel.setText(SIMULATE_NETWORK_EXPLANATION);
        simulateLinkingResourceLabel.setEnabled(true);

        // Create reliability section:
        final Group reliabilityGroup = new Group(container, SWT.NONE);
        reliabilityGroup.setText("Reliability");
        final GridData gd_reliabilityGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
        reliabilityGroup.setLayoutData(gd_reliabilityGroup);
        reliabilityGroup.setLayout(new GridLayout());
        simulateFailuresButton = new Button(reliabilityGroup, SWT.CHECK);
        final GridData gd_simulateFailuresButton = new GridData(SWT.FILL, SWT.CENTER, true, false);
        simulateFailuresButton.setLayoutData(gd_simulateFailuresButton);
        simulateFailuresButton.setText("Simulate failures");
        simulateFailuresButton.addSelectionListener(selectionListener);

        // Create PCM2EJB feature configuration section:
        final Group featureConfigGroup = new Group(container, SWT.NONE);
        final GridLayout glReposetoryTypeGroup = new GridLayout();
        glReposetoryTypeGroup.numColumns = 3;
        featureConfigGroup.setLayout(glReposetoryTypeGroup);
        featureConfigGroup.setText(FeatureOptionsTab.TITLE_FEATURE_CONFIG_SECTION);
        featureConfigGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        textFeatureConfig = new Text(featureConfigGroup, SWT.SINGLE | SWT.BORDER);
        final GridData gd_textResourceTypeRepository = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd_textResourceTypeRepository.widthHint = 200;
        textFeatureConfig.setLayoutData(gd_textResourceTypeRepository);
        textFeatureConfig.addModifyListener(modifyListener);
        TabHelper.createFileInputSection(featureConfigGroup, modifyListener, DEFAULT_FEATURE_CONFIGURATION_FILE_LABEL,
                ConstantsContainer.FEATURECONFIG_EXTENSION, textFeatureConfig, getShell(),
                ConstantsContainer.DEFAULT_FEATURE_CONFIGURATION_FILE);

        // FIXME: re-enable
        // // Create target feature configuration section:
        // final Group targetConfigGroup = new Group(container, SWT.NONE);
        // final GridLayout glRepositoryTypeGroup = new GridLayout();
        // glRepositoryTypeGroup.numColumns = 3;
        // targetConfigGroup.setLayout(glRepositoryTypeGroup);
        // targetConfigGroup.setText("Target featureconfig file");
        // targetConfigGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
        // true, false));
        // textTargetConfig = new Text(targetConfigGroup, SWT.SINGLE
        // | SWT.BORDER);
        // final GridData gd_textTResourceTypeRepository = new GridData(SWT.FILL,
        // SWT.CENTER, true, false);
        // gd_textTResourceTypeRepository.widthHint = 200;
        // textTargetConfig.setLayoutData(gd_textTResourceTypeRepository);
        // textTargetConfig.addModifyListener(modifyListener);
        // final Button targetButton = new Button(targetConfigGroup, SWT.NONE);
        // targetButton.setText("Workspace...");
        // targetButton
        // .addSelectionListener(new WorkspaceButtonSelectionListener(
        // textTargetConfig,
        // ConstantsContainer.FEATURECONFIG_EXTENSION));
        // final Button buttonTResourceTypeRepository = new Button(
        // targetConfigGroup, SWT.NONE);
        // buttonTResourceTypeRepository.setLayoutData(new GridData());
        // buttonTResourceTypeRepository.setText("File System...");
        // buttonTResourceTypeRepository
        // .addSelectionListener(new SelectionAdapter() {
        //
        // public void widgetSelected(SelectionEvent e) {
        // textTargetConfig
        // .setText(openFileDialog(ConstantsContainer.FEATURECONFIG_EXTENSION));
        // }
        // });
        //
        // // Create Editor widget
        // final Group editorGroup = new Group(container, SWT.NONE);
        // editorGroup.setText("FeatureConfig Editor:");
        // editorGroup.setLayout(new RowLayout(SWT.VERTICAL));
        // editorWidget = new FeatureConfigWidget(editorGroup);
        // editorWidget.addCheckStateListener(checkListener);
        // modelSaveButton = new Button(editorGroup, SWT.NONE);
        // modelSaveButton.setText("Save featureconfig");
        // modelSaveButton.setEnabled(false);
        // modelSaveButton.addSelectionListener(new SelectionAdapter() {
        // public void widgetSelected(SelectionEvent e) {
        // editorWidget.doSave(new NullProgressMonitor());
        // modelSaveButton.setEnabled(false);
        // }
        // });
        // Button validateButton = new Button(editorGroup, SWT.NONE);
        // validateButton.setText("Validate");
        // validateButton.addSelectionListener(new SelectionAdapter() {
        // public void widgetSelected(SelectionEvent e) {
        // if (editorWidget != null) {
        // editorWidget.validate();
        // }
        // }
        // });
    }

    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
        setErrorMessage(null);

        if (!TabHelper.validateFilenameExtension(textFeatureConfig.getText(),
                ConstantsContainer.FEATURECONFIG_EXTENSION)) {
            setErrorMessage("Source model file is missing!");
            return false;
        }

        // FIXME: re-enable
        // if (!validateFilePath(textTargetConfig.getText(),
        // ConstantsContainer.FEATURECONFIG_EXTENSION)) {
        // setErrorMessage("Target model file is missing!");
        // return false;
        // }
        // if (editorWidget != null) {
        // if (!editorValid) {
        // setErrorMessage(editorWidget.getErrorMessage());
        // }
        // return false;
        // }

        return true;
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
        return ImageRegistryHelper.getTabImage(PLUGIN_ID, FEATURE_OPTIONS_TAB_IMAGE_PATH);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
     * .debug.core.ILaunchConfiguration)
     */
    public void initializeFrom(ILaunchConfiguration configuration) {
        try {
            simulateLinkingResourcesButton.setSelection(configuration.getAttribute(
                    ConstantsContainer.SIMULATE_LINKING_RESOURCES, true));
        } catch (CoreException e) {
            simulateLinkingResourcesButton.setSelection(true);
        }
        try {
            simulateFailuresButton.setSelection(configuration.getAttribute(ConstantsContainer.SIMULATE_FAILURES, true));
        } catch (CoreException e) {
            simulateFailuresButton.setSelection(false);
        }
        try {
            textFeatureConfig.setText(configuration.getAttribute(ConstantsContainer.FEATURE_CONFIG,
                    ConstantsContainer.DEFAULT_FEATURE_CONFIGURATION_FILE));
        } catch (CoreException e) {
            textFeatureConfig.setText(ConstantsContainer.DEFAULT_FEATURE_CONFIGURATION_FILE);
        }
        // FIXME: re-enable
        // try {
        // textTargetConfig.setText(configuration.getAttribute(
        // ConstantsContainer.FEATURE_CONFIG_TARGET, ""));
        // } catch (CoreException e) {
        // simulateLinkingResourcesButton.setSelection(true);
        // }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
     * .debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES,
                this.simulateLinkingResourcesButton.getSelection());
        configuration.setAttribute(ConstantsContainer.SIMULATE_FAILURES, this.simulateFailuresButton.getSelection());
        configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG, textFeatureConfig.getText());
        // FIXME: re-enable
        // configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG_TARGET,
        // textTargetConfig.getText());
    }

    /*
     * TODO: Maybe this can be used to check whether models are needed
     * 
     * @Override public boolean isValid(ILaunchConfiguration launchConfig) {
     * 
     * setErrorMessage(null);
     * 
     * //if linking resources shall be simulated, the connector config must be specified if
     * (simulateLinkingResourcesButton.getSelection() && (this.textFeatureConfig.getText() == null
     * || this.textFeatureConfig.getText().equals(""))){
     * setErrorMessage("If \""+FeatureOptionsTab.LABEL_SIMULATE_NETWORK
     * +"\" is checked, a connector config has to be chosen for "
     * +FeatureOptionsTab.TITLE_FEATURE_CONFIG_SECTION); return false; }
     * 
     * return super.isValid(launchConfig); }
     */

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
     * debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES, DEFAULT_SIMULATE_LINKING_RESOURCES);
        configuration.setAttribute(ConstantsContainer.SIMULATE_FAILURES, DEFAULT_SIMULATE_FAILURES);
        ;
        configuration.setAttribute(ConstantsContainer.FEATURE_CONFIG,
                ConstantsContainer.DEFAULT_FEATURE_CONFIGURATION_FILE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#activated(org.eclipse.debug.core.
     * ILaunchConfigurationWorkingCopy)
     */
    @Override
    public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
        // Leave this method empty to prevent unnecessary invocation of
        // initializeFrom() and multiple resulting invocations of
        // performApply().
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#deactivated(org.eclipse.debug.core.
     * ILaunchConfigurationWorkingCopy)
     */
    @Override
    public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
        // Intentionally left empty.
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
