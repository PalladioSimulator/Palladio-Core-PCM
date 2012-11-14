package de.uka.ipd.sdq.reliability.solver.runconfig;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;

/**
 * This tab page shows additional options for the PCM Solver Reliability launch.
 * 
 * @author brosch
 * 
 */
public class OptionsTab extends AbstractLaunchConfigurationTab {

    /**
     * The path to the image file for the tab icon.
     */
    private static final String FILENAME_TAB_IMAGE_PATH = "icons/options_tab.gif";

    /**
     * Default setting for physical states iteration.
     */
    private static final boolean ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED = true;

    /**
     * Default setting for logging.
     */
    private static final String LOGFILEDEFAULT = "";

    /**
     * Default setting for type of evaluation mode.
     */
    private static final MarkovEvaluationType MARKOV_EVALUATION_MODE = MarkovEvaluationType.POINTSOFFAILURE;

    /**
     * Default setting for applying Markov model reduction ("optimize" option).
     */
    private static final boolean MARKOV_MODEL_REDUCTION_ENABLED = true;

    /**
     * Default setting for storing the Markov model.
     */
    private static final boolean MARKOV_MODEL_STORAGE_ENABLED = false;

    /**
     * Default setting for addition of Markov model traces.
     */
    private static final boolean MARKOV_MODEL_TRACES_ENABLED = false;

    /**
     * Default name for the Markov model file.
     */
    private static final String MARKOVMODELFILEDEFAULT = "";

    /**
     * Default setting for number of evaluated system states.
     */
    private static final int NUMBER_OF_EVALUATED_SYSTEM_STATES = 1;

    /**
     * Default setting for number of evaluated system states.
     */
    private static final boolean NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED = false;

    /**
     * Default setting for number of decimal places.
     */
    private static final int NUMBER_OF_EXACT_DECIMAL_PLACES = 1;

    /**
     * Default setting for exact decimal places shown of result.
     */
    private static final boolean NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED = false;

    /**
     * The id of this plug-in.
     */
    private static final String PLUGIN_ID = "de.uka.ipd.sdq.reliability.solver";

    /**
     * Default setting for saving results file.
     */
    private static final String SAVE_FILE_DEFAULT = "";

    /**
     * Default setting for saving results.
     */
    private static final boolean SAVE_RESULTS_TO_FILE_ENABLED = false;

    /**
     * Default setting for single result printing.
     */
    private static final boolean SINGLERESULTSDEFAULT = false;

    /**
     * Default setting for solving time limit.
     */
    private static final int SOLVING_TIME_LIMIT = 1;

    /**
     * Default setting for solving time limit.
     */
    private static final boolean SOLVING_TIME_LIMIT_ENABLED = false;

    /**
     * Default setting for Markov statistics.
     */
    private static final boolean STATISTICSDEFAULT = false;

    /**
     * Button to a file dialog, starting in the user's file system.
     */
    private Button buttonFileSystemFileDialogLogFile = null;

    /**
     * Button to a file dialog, starting in the user's file system.
     */
    private Button buttonFileSystemFileDialogModelFile = null;

    /**
     * Button to a file dialog, starting in the user's file system.
     */
    private Button buttonFileSystemFileDialogSaveToFile = null;

    /**
     * Button to a file dialog, starting in the user's workspace.
     */
    private Button buttonWorkspaceFileDialogLogFile = null;

    /**
     * Button to a file dialog, starting in the user's workspace.
     */
    private Button buttonWorkspaceFileDialogModelFile = null;

    /**
     * Button to a file dialog, starting in the user's workspace.
     */
    private Button buttonWorkspaceFileDialogSaveToFile = null;

    /**
     * Checks for iteration over physical system states.
     */
    private Button checkIterateOverPhysicalSystemStates;

    /**
     * Checks for Markov model traces enablement.
     */
    private Button checkMarkovModelTraces = null;

    /**
     * Checks for Markov statistics.
     */
    private Button checkMarkovStatistics = null;

    /**
     * Checks for number of evaluated system states.
     */
    private Button checkNumberOfEvaluatedSystemStates = null;

    /**
     * Checks for number of exact decimal places.
     */
    private Button checkNumberOfExactDecimalPlaces = null;

    /**
     * Checks for optimize option.
     */
    private Button checkOptimize = null;

    /**
     * Checks whether results should be saved to a file.
     */
    private Button checkSaveResultsToFile = null;

    /**
     * Checks for single result prints.
     */
    private Button checkSingleResults = null;

    /**
     * Checks for solving time limits.
     */
    private Button checkSolvingTimeLimit = null;

    /**
     * Checks for Markov model storage.
     */
    private Button checkStoreMarkovModel = null;

    /**
     * Radio button for failure categories (simplified evaluation without failure recovery).
     */
    private Button radioFailureCategories = null;

    /**
     * Radio button for failure types.
     */
    private Button radioFailureTypes = null;

    /**
     * Radio button for points of failure.
     */
    private Button radioPointsOfFailure = null;

    /**
     * Radio button for single failure mode (simplified evaluation without failure recovery).
     */
    private Button radioSingleFailureMode = null;

    /**
     * Spinner for number of evaluated system states.
     */
    private Spinner spinnerNumberOfEvaluatedSystemStates = null;

    /**
     * Spinner for number of exact decimal places.
     */
    private Spinner spinnerNumberOfExactDecimalPlaces = null;

    /**
     * Spinner for solving time limits.
     */
    private Spinner spinnerSolvingTimeLimit = null;

    /**
     * Text box to specify the logging file.
     */
    private Text textLogFile = null;

    /**
     * Text box to specify the model file.
     */
    private Text textMarkovModelFile = null;

    /**
     * Text box to specify the results file.
     */
    private Text textSaveResultsToFile = null;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#activated(org.eclipse
     * .debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void activated(final ILaunchConfigurationWorkingCopy workingCopy) {
        // Leave this method empty to prevent unnecessary invocation of
        // initializeFrom() and multiple resulting invocations of
        // performApply().
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
     * .swt.widgets.Composite)
     */
    public void createControl(final Composite parent) {

        // Create a listener for GUI events:
        final Listener listener = new Listener() {
            public void handleEvent(final Event event) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                updateFieldsEnablement();
            }
        };

        // Create a listener for GUI modification events:
        final ModifyListener modifyListener = new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                updateFieldsEnablement();
            }
        };

        // Create a new Composite to hold the page's controls.
        // The composite will show scroll bars if the size of
        // the dialog decreases below the minimum size of the
        // contained controls:
        ScrolledComposite container = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        container.setExpandHorizontal(true);
        container.setExpandVertical(true);
        Composite contentContainer = new Composite(container, SWT.NONE);
        container.setContent(contentContainer);
        GridLayout layout = new GridLayout();
        contentContainer.setLayout(layout);

        // Sets the scrolled composite to be the displayed
        // top-level control in this tab:
        setControl(container);

        // Create a new GridLayout for the stop conditions Group:
        final GridLayout stopConditionsLayout = new GridLayout();
        stopConditionsLayout.numColumns = 2;

        // Create the logging Group with the verbose logging check box:
        final Group stopConditionsGroup = new Group(contentContainer, SWT.NONE);
        stopConditionsGroup.setLayout(stopConditionsLayout);
        stopConditionsGroup.setText("Stop Conditions");
        stopConditionsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        // Create the check box and spinner for specifying the number of
        // evaluated system states
        checkNumberOfEvaluatedSystemStates = new Button(stopConditionsGroup, SWT.CHECK);
        checkNumberOfEvaluatedSystemStates.setText("Number of evaluated system states:");
        checkNumberOfEvaluatedSystemStates.setSelection(NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED);
        checkNumberOfEvaluatedSystemStates.addListener(SWT.Selection, listener);
        checkNumberOfEvaluatedSystemStates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        spinnerNumberOfEvaluatedSystemStates = new Spinner(stopConditionsGroup, SWT.NORMAL);
        spinnerNumberOfEvaluatedSystemStates.setIncrement(1);
        spinnerNumberOfEvaluatedSystemStates.setMinimum(1);
        spinnerNumberOfEvaluatedSystemStates.setMaximum(1000000);
        spinnerNumberOfEvaluatedSystemStates.setSelection(NUMBER_OF_EVALUATED_SYSTEM_STATES);
        spinnerNumberOfEvaluatedSystemStates.setEnabled(NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED);
        spinnerNumberOfEvaluatedSystemStates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        spinnerNumberOfEvaluatedSystemStates.addListener(SWT.Selection, listener);
        spinnerNumberOfEvaluatedSystemStates.addModifyListener(modifyListener);

        // Create the check box and spinner for showing the number of exact
        // decimal places
        checkNumberOfExactDecimalPlaces = new Button(stopConditionsGroup, SWT.CHECK);
        checkNumberOfExactDecimalPlaces.setText("Number of exact decimal places:");
        checkNumberOfExactDecimalPlaces.setSelection(NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED);
        checkNumberOfExactDecimalPlaces.addListener(SWT.Selection, listener);
        checkNumberOfExactDecimalPlaces.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        spinnerNumberOfExactDecimalPlaces = new Spinner(stopConditionsGroup, SWT.NORMAL);
        spinnerNumberOfExactDecimalPlaces.setIncrement(1);
        spinnerNumberOfExactDecimalPlaces.setMinimum(1);
        spinnerNumberOfExactDecimalPlaces.setMaximum(10);
        spinnerNumberOfExactDecimalPlaces.setSelection(NUMBER_OF_EXACT_DECIMAL_PLACES);
        spinnerNumberOfExactDecimalPlaces.setEnabled(NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED);
        spinnerNumberOfExactDecimalPlaces.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        spinnerNumberOfExactDecimalPlaces.addListener(SWT.Selection, listener);
        spinnerNumberOfExactDecimalPlaces.addModifyListener(modifyListener);

        // Create the check box and spinner for limiting solving time
        checkSolvingTimeLimit = new Button(stopConditionsGroup, SWT.CHECK);
        checkSolvingTimeLimit.setText("Solving time (in seconds):");
        checkSolvingTimeLimit.setSelection(SOLVING_TIME_LIMIT_ENABLED);
        checkSolvingTimeLimit.addListener(SWT.Selection, listener);
        checkSolvingTimeLimit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        spinnerSolvingTimeLimit = new Spinner(stopConditionsGroup, SWT.NORMAL);
        spinnerSolvingTimeLimit.setIncrement(1);
        spinnerSolvingTimeLimit.setMinimum(1);
        spinnerSolvingTimeLimit.setMaximum(86400); // 24h
        spinnerSolvingTimeLimit.setSelection(SOLVING_TIME_LIMIT);
        spinnerSolvingTimeLimit.setEnabled(SOLVING_TIME_LIMIT_ENABLED);
        spinnerSolvingTimeLimit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        spinnerSolvingTimeLimit.addListener(SWT.Selection, listener);
        spinnerSolvingTimeLimit.addModifyListener(modifyListener);

        // Create a new GridLayout for the Markov transformation Group:
        final GridLayout markovTransformationLayout = new GridLayout();
        markovTransformationLayout.numColumns = 4;

        // Create the Markov transformation Group
        Group markovTransformationGroup = new Group(contentContainer, SWT.NONE);
        markovTransformationGroup.setLayout(markovTransformationLayout);
        markovTransformationGroup.setText("Markov Transformation");
        markovTransformationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        // Add an optimize option as check box
        checkOptimize = new Button(markovTransformationGroup, SWT.CHECK);
        checkOptimize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                markovTransformationLayout.numColumns, 1));
        checkOptimize.setText("Apply Markov model reduction");
        checkOptimize.setSelection(MARKOV_MODEL_REDUCTION_ENABLED);
        checkOptimize.addListener(SWT.Selection, listener);

        // Add an option for Markov model traces as check box
        checkMarkovModelTraces = new Button(markovTransformationGroup, SWT.CHECK);
        checkMarkovModelTraces.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                markovTransformationLayout.numColumns, 1));
        checkMarkovModelTraces.setText("Add Markov traces");
        checkMarkovModelTraces.setSelection(MARKOV_MODEL_TRACES_ENABLED);
        checkMarkovModelTraces.addListener(SWT.Selection, listener);

        // Add an option to iterate over physical system states as check box
        checkIterateOverPhysicalSystemStates = new Button(markovTransformationGroup, SWT.CHECK);
        checkIterateOverPhysicalSystemStates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                markovTransformationLayout.numColumns, 1));
        checkIterateOverPhysicalSystemStates.setText("Iterate over physical system states");
        checkIterateOverPhysicalSystemStates.setSelection(ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED);
        checkIterateOverPhysicalSystemStates.addListener(SWT.Selection, listener);

        // Add a store markov model option as check box
        checkStoreMarkovModel = new Button(markovTransformationGroup, SWT.CHECK);
        checkStoreMarkovModel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                markovTransformationLayout.numColumns, 1));
        checkStoreMarkovModel.setText("Store Markov model");
        checkStoreMarkovModel.setSelection(MARKOV_MODEL_STORAGE_ENABLED);
        checkStoreMarkovModel.addListener(SWT.Selection, listener);

        // Add a label showing where to specify the model file
        Label labelModelFile = new Label(markovTransformationGroup, SWT.NONE);
        labelModelFile.setText("Model file:");

        // Create the model file text box
        textMarkovModelFile = new Text(markovTransformationGroup, SWT.BORDER);
        textMarkovModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        textMarkovModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
        textMarkovModelFile.setText(MARKOVMODELFILEDEFAULT);
        textMarkovModelFile.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(final KeyEvent e) {
                // nothing happens here
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                updateFieldsEnablement();
            }

        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's workspace
        buttonWorkspaceFileDialogModelFile = new Button(markovTransformationGroup, SWT.NONE);
        buttonWorkspaceFileDialogModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonWorkspaceFileDialogModelFile.setText("Workspace...");
        buttonWorkspaceFileDialogModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
        buttonWorkspaceFileDialogModelFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                IFile file = WorkspaceResourceDialog.openNewFile(getShell(), "Save As", "Select the parent folder:",
                        getRelativeFilePath(textMarkovModelFile.getText().trim()), null);
                if (file != null) {
                    String newModelFile = file.getLocation().toOSString();
                    if (newModelFile != null) {
                        String portableString = file.getFullPath().toPortableString();
                        newModelFile = "platform:/resource" + portableString;
                        // did the user select "*.markov" as extension
                        // and
                        // not add ".markov" to the file they specified?
                        if (!newModelFile.endsWith(".markov")) {
                            newModelFile += ".markov"; // append ".txt"
                            // extension
                        }
                        textMarkovModelFile.setText(newModelFile);
                        updateLaunchConfigurationDialog();
                        updateFieldsEnablement();
                    }
                }
            }
        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's file system
        buttonFileSystemFileDialogModelFile = new Button(markovTransformationGroup, SWT.NONE);
        buttonFileSystemFileDialogModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonFileSystemFileDialogModelFile.setText("File System...");
        buttonFileSystemFileDialogModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
        buttonFileSystemFileDialogModelFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                FileDialog fileDiag = new FileDialog(new Shell(), SWT.SAVE);
                fileDiag.setFilterPath(getDirectoryName(textMarkovModelFile.getText().trim()));
                fileDiag.setFilterExtensions(new String[] { "*.markov", "*.*" });
                fileDiag.setFileName(getFileName(textMarkovModelFile.getText().trim()));
                fileDiag.setOverwrite(true);
                String modelFile = fileDiag.open();
                if (modelFile != null) {
                    // did the user select "*.markov" as extension and
                    // not add ".markov" to the file they specified?
                    if (fileDiag.getFilterIndex() == 0 && !modelFile.endsWith(".markov")) {
                        modelFile += ".markov"; // append ".txt"
                        // extension
                    }
                    textMarkovModelFile.setText(modelFile);
                    updateLaunchConfigurationDialog();
                    updateFieldsEnablement();
                }
            }
        });

        // Create evaluation mode Group
        final GridLayout evaluationModeLayout = new GridLayout();
        final Group evaluationModeGroup = new Group(contentContainer, SWT.NONE);
        evaluationModeGroup.setLayout(evaluationModeLayout);
        evaluationModeGroup.setText("Evaluation Mode");
        evaluationModeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        // Of the following four radio buttons, only one must be enabled
        // (checked). Make sure
        // the boolean default values used are set accordingly (only one true).
        radioSingleFailureMode = new Button(evaluationModeGroup, SWT.RADIO);
        radioSingleFailureMode.setText("Single failure mode (simplified evaluation without failure recovery)");
        radioSingleFailureMode.setSelection(MarkovEvaluationType.SINGLE == MARKOV_EVALUATION_MODE);
        radioSingleFailureMode.addListener(SWT.Selection, listener);
        radioSingleFailureMode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        radioFailureCategories = new Button(evaluationModeGroup, SWT.RADIO);
        radioFailureCategories.setText("Failure categories (simplified evaluation without failure recovery)");
        radioFailureCategories.setSelection(MarkovEvaluationType.CLASSES == MARKOV_EVALUATION_MODE);
        radioFailureCategories.addListener(SWT.Selection, listener);
        radioFailureCategories.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        radioFailureTypes = new Button(evaluationModeGroup, SWT.RADIO);
        radioFailureTypes.setText("Failure types");
        radioFailureTypes.setSelection(MarkovEvaluationType.TYPES == MARKOV_EVALUATION_MODE);
        radioFailureTypes.addListener(SWT.Selection, listener);
        radioFailureTypes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        radioPointsOfFailure = new Button(evaluationModeGroup, SWT.RADIO);
        radioPointsOfFailure.setText("Points of failure (includes detailed reliability report)");
        radioPointsOfFailure.setSelection(MarkovEvaluationType.POINTSOFFAILURE == MARKOV_EVALUATION_MODE);
        radioPointsOfFailure.addListener(SWT.Selection, listener);
        radioPointsOfFailure.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        // Create a new GridLayout for the logging Group:
        final GridLayout loggingLayout = new GridLayout();
        loggingLayout.numColumns = 4;

        // Create the logging Group with the verbose logging check box:
        final Group loggingGroup = new Group(contentContainer, SWT.NONE);
        loggingGroup.setLayout(loggingLayout);
        loggingGroup.setText("Logging");
        loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        // Create the Markov statistics check box:
        checkMarkovStatistics = new Button(loggingGroup, SWT.CHECK);
        checkMarkovStatistics.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, loggingLayout.numColumns,
                1));
        checkMarkovStatistics.setText("Print Markov statistics on console");
        checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
        checkMarkovStatistics.addListener(SWT.Selection, listener);

        // Create the Markov statistics check box:
        checkSingleResults = new Button(loggingGroup, SWT.CHECK);
        checkSingleResults.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, loggingLayout.numColumns, 1));
        checkSingleResults.setText("Log results of individual Markov transformation runs");
        checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
        checkSingleResults.addListener(SWT.Selection, listener);

        // Add a label showing where to specify the log file
        Label labelLogFile = new Label(loggingGroup, SWT.NONE);
        labelLogFile.setText("Log file:");

        // Create the logging file text box
        textLogFile = new Text(loggingGroup, SWT.BORDER);
        textLogFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        textLogFile.setText(LOGFILEDEFAULT);
        textLogFile.setEnabled(SINGLERESULTSDEFAULT);
        textLogFile.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(final KeyEvent e) {
                // nothing happens here
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                updateFieldsEnablement();
            }

        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's workspace
        buttonWorkspaceFileDialogLogFile = new Button(loggingGroup, SWT.NONE);
        buttonWorkspaceFileDialogLogFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonWorkspaceFileDialogLogFile.setText("Workspace...");
        buttonWorkspaceFileDialogLogFile.setEnabled(SINGLERESULTSDEFAULT);
        buttonWorkspaceFileDialogLogFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                IFile file = WorkspaceResourceDialog.openNewFile(getShell(), "Save As", "Select the parent folder:",
                        getRelativeFilePath(textLogFile.getText().trim()), null);
                if (file != null) {
                    String newLogFile = file.getLocation().toOSString();
                    if (newLogFile != null) {
                        String portableString = file.getFullPath().toPortableString();
                        newLogFile = "platform:/resource" + portableString;
                        // did the user select "*.txt" as extension and
                        // not add ".txt" to the file they specified?
                        if (!newLogFile.endsWith(".txt")) {
                            newLogFile += ".txt"; // append ".txt"
                            // extension
                        }
                        textLogFile.setText(newLogFile);
                        updateLaunchConfigurationDialog();
                        updateFieldsEnablement();
                    }
                }
            }
        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's file system
        buttonFileSystemFileDialogLogFile = new Button(loggingGroup, SWT.NONE);
        buttonFileSystemFileDialogLogFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonFileSystemFileDialogLogFile.setText("File System...");
        buttonFileSystemFileDialogLogFile.setEnabled(SINGLERESULTSDEFAULT);
        buttonFileSystemFileDialogLogFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                FileDialog fileDiag = new FileDialog(new Shell(), SWT.SAVE);
                fileDiag.setFilterPath(getDirectoryName(textLogFile.getText().trim()));
                fileDiag.setFilterExtensions(new String[] { "*.txt", "*.*" });
                fileDiag.setFileName(getFileName(textLogFile.getText().trim()));
                fileDiag.setOverwrite(true);
                String logFile = fileDiag.open();
                if (logFile != null) {
                    // did the user select "*.txt" as extension and
                    // not add ".txt" to the file they specified?
                    if (fileDiag.getFilterIndex() == 0 && !logFile.endsWith(".txt")) {
                        logFile += ".txt"; // append ".txt" extension
                    }
                    textLogFile.setText(logFile);
                    updateLaunchConfigurationDialog();
                    updateFieldsEnablement();
                }
            }

        });

        // Create a new GridLayout for the Markov analysis Group:
        final GridLayout markovAnalysisResultsLayout = new GridLayout();
        markovAnalysisResultsLayout.numColumns = 4;

        // Create the Markov analysis Group
        final Group markovAnalysisResultsGroup = new Group(contentContainer, SWT.NONE);
        markovAnalysisResultsGroup.setLayout(markovAnalysisResultsLayout);
        markovAnalysisResultsGroup.setText("Markov Analysis Results");
        markovAnalysisResultsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        // Create the Markov statistics check box:
        checkSaveResultsToFile = new Button(markovAnalysisResultsGroup, SWT.CHECK);
        checkSaveResultsToFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                markovAnalysisResultsLayout.numColumns, 1));
        checkSaveResultsToFile.setText("Save results to file");
        checkSaveResultsToFile.setSelection(SAVE_RESULTS_TO_FILE_ENABLED);
        checkSaveResultsToFile.addListener(SWT.Selection, listener);

        // Add a label showing where to specify the results file
        Label labelSaveResultsToFile = new Label(markovAnalysisResultsGroup, SWT.NONE);
        labelSaveResultsToFile.setText("File:");

        // Create the textbox to specify a file for saving the Markov analysis
        // results
        textSaveResultsToFile = new Text(markovAnalysisResultsGroup, SWT.BORDER);
        textSaveResultsToFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        textSaveResultsToFile.setText(SAVE_FILE_DEFAULT);
        textSaveResultsToFile.setEnabled(SAVE_RESULTS_TO_FILE_ENABLED);
        textSaveResultsToFile.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(final KeyEvent e) {
                // nothing happens here
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                updateFieldsEnablement();
            }

        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's workspace
        buttonWorkspaceFileDialogSaveToFile = new Button(markovAnalysisResultsGroup, SWT.NONE);
        buttonWorkspaceFileDialogSaveToFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonWorkspaceFileDialogSaveToFile.setText("Workspace...");
        buttonWorkspaceFileDialogSaveToFile.setEnabled(SAVE_RESULTS_TO_FILE_ENABLED);
        buttonWorkspaceFileDialogSaveToFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                IFile file = WorkspaceResourceDialog.openNewFile(getShell(), "Save As", "Select the parent folder:",
                        getRelativeFilePath(textSaveResultsToFile.getText().trim()), null);
                if (file != null) {
                    String newSaveToFile = file.getLocation().toOSString();
                    if (newSaveToFile != null) {
                        String portableString = file.getFullPath().toPortableString();
                        newSaveToFile = "platform:/resource" + portableString;
                        // did the user select "*.markovresult" as
                        // extension and
                        // not add ".markovresult" to the file they
                        // specified?
                        if (!newSaveToFile.endsWith(".markovresult")) {
                            newSaveToFile += ".markovresult"; // append
                                                              // ".markovresult"
                            // extension
                        }
                        textSaveResultsToFile.setText(newSaveToFile);
                        updateLaunchConfigurationDialog();
                        updateFieldsEnablement();
                    }
                }
            }
        });

        // Create the button responsible for triggering a file dialog,
        // starting in the user's file system
        buttonFileSystemFileDialogSaveToFile = new Button(markovAnalysisResultsGroup, SWT.NONE);
        buttonFileSystemFileDialogSaveToFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        buttonFileSystemFileDialogSaveToFile.setText("File System...");
        buttonFileSystemFileDialogSaveToFile.setEnabled(SINGLERESULTSDEFAULT);
        buttonFileSystemFileDialogSaveToFile.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
                // nothing happens here
            }

            @Override
            public void widgetSelected(final SelectionEvent e) {
                FileDialog fileDiag = new FileDialog(new Shell(), SWT.SAVE);
                fileDiag.setFilterPath(getDirectoryName(textSaveResultsToFile.getText().trim()));
                fileDiag.setFilterExtensions(new String[] { "*.markovresult", "*.*" });
                fileDiag.setFileName(getFileName(textSaveResultsToFile.getText().trim()));
                fileDiag.setOverwrite(true);
                String saveToFile = fileDiag.open();
                if (saveToFile != null) {
                    // did the user select "*.markovresult" as extension
                    // and
                    // not add ".markovresult" to the file they
                    // specified?
                    if (fileDiag.getFilterIndex() == 0 && !saveToFile.endsWith(".markovresult")) {
                        saveToFile += ".markovresult"; // append
                                                       // ".markovresult"
                                                       // extension
                    }
                    textSaveResultsToFile.setText(saveToFile);
                    updateLaunchConfigurationDialog();
                    updateFieldsEnablement();
                }
            }

        });

        // After all internal controls have been created,
        // calculate the minimal size of the contentContainer.
        // Scrollbars will be shown if the dialog size decreases
        // below the calculated min size:
        container.setMinSize(contentContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#deactivated(org.eclipse
     * .debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void deactivated(final ILaunchConfigurationWorkingCopy workingCopy) {
    }

    /**
     * Returns the currently selected file path.
     * 
     * Only valid and absolute paths are accepted.
     * 
     * @return the currently selected file path
     */
    private Path getCurrentFilePath(final String path) {
        if (Path.ROOT.isValidPath(path)) {
            Path resultPath = new Path(path);
            if (resultPath.isAbsolute()) {
                return resultPath;
            }
        }
        return null;
    }

    /**
     * Returns the current file directory as a String.
     * 
     * @return the current file directory
     */
    private String getDirectoryName(final String path) {
        Path filePath = getCurrentFilePath(path);
        if (filePath == null) {
            return null;
        }
        if (filePath.toFile().isDirectory()) {
            return filePath.toOSString();
        }
        return new Path(filePath.toFile().getParent()).toOSString();
    }

    /**
     * Returns the current file name as a String.
     * 
     * @return the current file name
     */
    private String getFileName(String path) {
        Path filePath = getCurrentFilePath(path);
        if ((filePath == null) || (filePath.toFile().isDirectory())) {
            return null;
        }
        return filePath.toFile().getName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
     */
    public Image getImage() {
        return RunConfigImages.getTabImage(PLUGIN_ID, FILENAME_TAB_IMAGE_PATH);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
     */
    public String getName() {
        return "Analysis Options";
    }

    /**
     * Returns the currently selected file path, relative to the workspace.
     * 
     * Returns an empty path if the current file path is not valid or not within the workspace.
     * 
     * @return the currently selected file path
     */
    private Path getRelativeFilePath(final String path) {
        Path logFilePath = getCurrentFilePath(path);
        Path workspacePath = (Path) ResourcesPlugin.getWorkspace().getRoot().getLocation();
        Path resultPath = new Path("");
        if ((logFilePath != null) && (workspacePath.isPrefixOf(logFilePath))) {
            resultPath = (Path) logFilePath.makeRelativeTo(workspacePath);
        }
        return resultPath;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
     * .debug.core.ILaunchConfiguration)
     */
    public void initializeFrom(final ILaunchConfiguration configuration) {
        // Try to retrieve the settings from the given configuration:
        try {
            checkMarkovStatistics.setSelection(configuration.getAttribute(MessageStrings.MARKOV_STATISTICS,
                    STATISTICSDEFAULT));
            checkSingleResults.setSelection(configuration.getAttribute(MessageStrings.SINGLE_RESULTS,
                    SINGLERESULTSDEFAULT));
            checkNumberOfEvaluatedSystemStates.setSelection(configuration.getAttribute(
                    MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED, false));
            checkNumberOfExactDecimalPlaces.setSelection(configuration.getAttribute(
                    MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED, false));
            checkSolvingTimeLimit.setSelection(configuration.getAttribute(MessageStrings.SOLVING_TIME_LIMIT_ENABLED,
                    false));
            spinnerNumberOfEvaluatedSystemStates.setSelection(configuration.getAttribute(
                    MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES, NUMBER_OF_EVALUATED_SYSTEM_STATES));
            spinnerNumberOfExactDecimalPlaces.setSelection(configuration.getAttribute(
                    MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES, NUMBER_OF_EXACT_DECIMAL_PLACES));
            spinnerSolvingTimeLimit.setSelection(configuration.getAttribute(MessageStrings.SOLVING_TIME_LIMIT,
                    SOLVING_TIME_LIMIT));
            textLogFile.setEnabled(configuration.getAttribute(MessageStrings.SINGLE_RESULTS, SINGLERESULTSDEFAULT));
            textLogFile.setText(configuration.getAttribute(MessageStrings.LOG_FILE, LOGFILEDEFAULT));
            buttonWorkspaceFileDialogLogFile.setEnabled(configuration.getAttribute(MessageStrings.SINGLE_RESULTS,
                    SINGLERESULTSDEFAULT));
            buttonFileSystemFileDialogLogFile.setEnabled(configuration.getAttribute(MessageStrings.SINGLE_RESULTS,
                    SINGLERESULTSDEFAULT));
            checkOptimize.setSelection(configuration.getAttribute(MessageStrings.MARKOV_MODEL_REDUCTION_ENABLED,
                    MARKOV_MODEL_REDUCTION_ENABLED));
            checkMarkovModelTraces.setSelection(configuration.getAttribute(MessageStrings.MARKOV_MODEL_TRACES_ENABLED,
                    MARKOV_MODEL_TRACES_ENABLED));
            checkIterateOverPhysicalSystemStates.setSelection(configuration.getAttribute(
                    MessageStrings.ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED,
                    ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED));
            checkStoreMarkovModel.setSelection(configuration.getAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED,
                    MARKOV_MODEL_STORAGE_ENABLED));
            textMarkovModelFile.setEnabled(configuration.getAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED,
                    MARKOV_MODEL_STORAGE_ENABLED));
            textMarkovModelFile.setText(configuration.getAttribute(MessageStrings.MARKOV_MODEL_FILE,
                    MARKOVMODELFILEDEFAULT));
            buttonWorkspaceFileDialogModelFile.setEnabled(configuration.getAttribute(
                    MessageStrings.MARKOV_MODEL_STORAGE_ENABLED, MARKOV_MODEL_STORAGE_ENABLED));
            buttonFileSystemFileDialogModelFile.setEnabled(configuration.getAttribute(
                    MessageStrings.MARKOV_MODEL_STORAGE_ENABLED, MARKOV_MODEL_STORAGE_ENABLED));

            checkSaveResultsToFile.setSelection(configuration.getAttribute(MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED,
                    SAVE_RESULTS_TO_FILE_ENABLED));
            textSaveResultsToFile.setEnabled(configuration.getAttribute(MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED,
                    SAVE_RESULTS_TO_FILE_ENABLED));
            textSaveResultsToFile.setText(configuration.getAttribute(MessageStrings.SAVE_FILE_DEFAULT,
                    SAVE_FILE_DEFAULT));
            buttonWorkspaceFileDialogSaveToFile.setEnabled(configuration.getAttribute(
                    MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED, SAVE_RESULTS_TO_FILE_ENABLED));
            buttonFileSystemFileDialogSaveToFile.setEnabled(configuration.getAttribute(
                    MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED, SAVE_RESULTS_TO_FILE_ENABLED));

            MarkovEvaluationType evalType;
            try {
                evalType = MarkovEvaluationType.valueOf(configuration.getAttribute(
                        MessageStrings.MARKOV_EVALUATION_MODE, MARKOV_EVALUATION_MODE.toString()));
            } catch (IllegalArgumentException e) {
                evalType = MARKOV_EVALUATION_MODE;
            }
            radioFailureCategories.setSelection(MarkovEvaluationType.CLASSES == evalType);
            radioPointsOfFailure.setSelection(MarkovEvaluationType.POINTSOFFAILURE == evalType);
            radioSingleFailureMode.setSelection(MarkovEvaluationType.SINGLE == evalType);
            radioFailureTypes.setSelection(MarkovEvaluationType.TYPES == evalType);
        } catch (CoreException e) {
            // Defaults apply:
            checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
            checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
            checkNumberOfEvaluatedSystemStates.setSelection(NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED);
            spinnerNumberOfEvaluatedSystemStates.setSelection(NUMBER_OF_EVALUATED_SYSTEM_STATES);
            checkNumberOfExactDecimalPlaces.setSelection(NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED);
            spinnerNumberOfExactDecimalPlaces.setSelection(NUMBER_OF_EXACT_DECIMAL_PLACES);
            checkSolvingTimeLimit.setSelection(SOLVING_TIME_LIMIT_ENABLED);
            spinnerSolvingTimeLimit.setSelection(SOLVING_TIME_LIMIT);
            textLogFile.setEnabled(SINGLERESULTSDEFAULT);
            textLogFile.setText(LOGFILEDEFAULT);
            buttonWorkspaceFileDialogLogFile.setEnabled(SINGLERESULTSDEFAULT);
            buttonFileSystemFileDialogLogFile.setEnabled(SINGLERESULTSDEFAULT);
            checkOptimize.setSelection(MARKOV_MODEL_REDUCTION_ENABLED);
            checkMarkovModelTraces.setSelection(MARKOV_MODEL_TRACES_ENABLED);
            checkIterateOverPhysicalSystemStates.setSelection(ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED);
            checkStoreMarkovModel.setSelection(MARKOV_MODEL_STORAGE_ENABLED);
            textMarkovModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
            textMarkovModelFile.setText(MARKOVMODELFILEDEFAULT);
            buttonWorkspaceFileDialogModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
            buttonFileSystemFileDialogModelFile.setEnabled(MARKOV_MODEL_STORAGE_ENABLED);
            radioSingleFailureMode.setSelection(MarkovEvaluationType.SINGLE == MARKOV_EVALUATION_MODE);
            radioFailureCategories.setSelection(MarkovEvaluationType.CLASSES == MARKOV_EVALUATION_MODE);
            radioFailureTypes.setSelection(MarkovEvaluationType.TYPES == MARKOV_EVALUATION_MODE);
            radioPointsOfFailure.setSelection(MarkovEvaluationType.POINTSOFFAILURE == MARKOV_EVALUATION_MODE);

            checkSaveResultsToFile.setSelection(SAVE_RESULTS_TO_FILE_ENABLED);
            textSaveResultsToFile.setEnabled(SAVE_RESULTS_TO_FILE_ENABLED);
            textSaveResultsToFile.setText(SAVE_FILE_DEFAULT);
            buttonWorkspaceFileDialogSaveToFile.setEnabled(SAVE_RESULTS_TO_FILE_ENABLED);
            buttonFileSystemFileDialogSaveToFile.setEnabled(SAVE_RESULTS_TO_FILE_ENABLED);
        }

        // Update the state of the dialog:
        updateLaunchConfigurationDialog();
        updateFieldsEnablement();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
     * .debug.core.ILaunchConfiguration)
     */
    public boolean isValid(final ILaunchConfiguration configuration) {
        // single result logging enabled?
        if (checkSingleResults.getSelection()) {
            if (getCurrentFilePath(resolvePath(textLogFile.getText().trim())) == null) {
                setErrorMessage("Invalid log file!");
                return false;
            } else if (getCurrentFilePath(resolveFile(textLogFile.getText().trim())).toFile().isDirectory()) {
                setErrorMessage("Log file is a directory!");
                return false;
            } else if (!getCurrentFilePath(resolvePath(textLogFile.getText().trim())).toFile().getParentFile().exists()) {
                setErrorMessage("Log file directory does not exist!");
                return false;
            }
        }
        if (checkStoreMarkovModel.getSelection()) {
            if (getCurrentFilePath(resolvePath(textMarkovModelFile.getText().trim())) == null) {
                setErrorMessage("Invalid Markov model file!");
                return false;
            } else if (getCurrentFilePath(resolveFile(textMarkovModelFile.getText().trim())).toFile().isDirectory()) {
                setErrorMessage("Markov model file is a directory!");
                return false;
            } else if (!getCurrentFilePath(resolvePath(textMarkovModelFile.getText().trim())).toFile().getParentFile()
                    .exists()) {
                setErrorMessage("Markov model file directory does not exist!");
                return false;
            }
        }
        if (checkSaveResultsToFile.getSelection()) {
            if (getCurrentFilePath(resolvePath(textSaveResultsToFile.getText().trim())) == null) {
                setErrorMessage("Invalid results file!");
                return false;
            } else if (getCurrentFilePath(resolveFile(textSaveResultsToFile.getText().trim())).toFile().isDirectory()) {
                setErrorMessage("Results file is a directory!");
                return false;
            } else if (!getCurrentFilePath(resolvePath(textSaveResultsToFile.getText().trim())).toFile()
                    .getParentFile().exists()) {
                setErrorMessage("Results file directory does not exist!");
                return false;
            }
        }

        setErrorMessage(null); // will clear any error messages shown
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
     * .debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
        // Store the settings into the configuration:
        configuration.setAttribute(MessageStrings.MARKOV_STATISTICS, checkMarkovStatistics.getSelection());
        configuration.setAttribute(MessageStrings.SINGLE_RESULTS, checkSingleResults.getSelection());

        configuration.setAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED,
                checkNumberOfEvaluatedSystemStates.getSelection());
        configuration.setAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES,
                Integer.parseInt(spinnerNumberOfEvaluatedSystemStates.getText()));

        configuration.setAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED,
                checkNumberOfExactDecimalPlaces.getSelection());
        configuration.setAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES,
                Integer.parseInt(spinnerNumberOfExactDecimalPlaces.getText()));

        configuration.setAttribute(MessageStrings.SOLVING_TIME_LIMIT_ENABLED, checkSolvingTimeLimit.getSelection());
        configuration.setAttribute(MessageStrings.SOLVING_TIME_LIMIT,
                Integer.parseInt(spinnerSolvingTimeLimit.getText()));

        configuration.setAttribute(MessageStrings.LOG_FILE, textLogFile.getText().trim());

        configuration.setAttribute(MessageStrings.MARKOV_MODEL_REDUCTION_ENABLED, checkOptimize.getSelection());

        configuration.setAttribute(MessageStrings.MARKOV_MODEL_TRACES_ENABLED, checkMarkovModelTraces.getSelection());

        configuration.setAttribute(MessageStrings.ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED,
                checkIterateOverPhysicalSystemStates.getSelection());

        configuration.setAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED, checkStoreMarkovModel.getSelection());
        configuration.setAttribute(MessageStrings.MARKOV_MODEL_FILE, textMarkovModelFile.getText().trim());

        if (radioSingleFailureMode.getSelection()) {
            configuration.setAttribute(MessageStrings.MARKOV_EVALUATION_MODE, MarkovEvaluationType.SINGLE.toString());
        } else if (radioFailureCategories.getSelection()) {
            configuration.setAttribute(MessageStrings.MARKOV_EVALUATION_MODE, MarkovEvaluationType.CLASSES.toString());
        } else if (radioFailureTypes.getSelection()) {
            configuration.setAttribute(MessageStrings.MARKOV_EVALUATION_MODE, MarkovEvaluationType.TYPES.toString());
        } else if (radioPointsOfFailure.getSelection()) {
            configuration.setAttribute(MessageStrings.MARKOV_EVALUATION_MODE,
                    MarkovEvaluationType.POINTSOFFAILURE.toString());
        }

        configuration.setAttribute(MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED, checkSaveResultsToFile.getSelection());
        configuration.setAttribute(MessageStrings.SAVE_FILE_DEFAULT, textSaveResultsToFile.getText().trim());
    }

    /**
     * Resolves a file's path in case it starts with "platform:/" and returns the entire absolute
     * path to the file, including the file's name.
     * 
     * @param fileURL
     *            the path to a file, including the file's name (and its extension)
     * @return the absolute path to the file, including the file's name
     */
    private String resolveFile(String fileURL) {
        // if this is a platform URL, first resolve it to an absolute path
        if (fileURL.startsWith("platform:")) {
            try {
                URL solvedURL = FileLocator.resolve(new URL(fileURL));
                fileURL = solvedURL.getPath();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return fileURL;
    }

    /** returns the path including the last slash */
    private String resolvePath(String fileURL) {
        // if this is a platform URL, first resolve it to an absolute path
        if (fileURL.startsWith("platform:")) {
            try {
                URL solvedURL = FileLocator.resolve(new URL(fileURL));
                fileURL = solvedURL.getPath();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        // now this should be an absolute path, but it can have either slashes
        // or backslashes
        int indexBackslash = fileURL.lastIndexOf("\\");
        int indexSlash = fileURL.lastIndexOf("/");
        // the right directory separator is the one where the above results in
        // the higher index (assuming that linux file systems do not allow
        // backslashes in file names...)
        int index = indexBackslash > indexSlash ? indexBackslash : indexSlash;
        String folderPath = fileURL.substring(0, index + 1);
        return folderPath;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
     * debug.core.ILaunchConfigurationWorkingCopy)
     */
    public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
        // Load default settings into the configuration:
        configuration.setAttribute(MessageStrings.MARKOV_STATISTICS, STATISTICSDEFAULT);
        configuration.setAttribute(MessageStrings.SINGLE_RESULTS, SINGLERESULTSDEFAULT);
        configuration.setAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED,
                NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED);
        configuration.setAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES, NUMBER_OF_EVALUATED_SYSTEM_STATES);
        configuration.setAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED,
                NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED);
        configuration.setAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES, NUMBER_OF_EXACT_DECIMAL_PLACES);
        configuration.setAttribute(MessageStrings.SOLVING_TIME_LIMIT_ENABLED, SOLVING_TIME_LIMIT_ENABLED);
        configuration.setAttribute(MessageStrings.SOLVING_TIME_LIMIT, SOLVING_TIME_LIMIT);
        configuration.setAttribute(MessageStrings.LOG_FILE, LOGFILEDEFAULT);
        configuration.setAttribute(MessageStrings.MARKOV_MODEL_REDUCTION_ENABLED, MARKOV_MODEL_REDUCTION_ENABLED);
        configuration.setAttribute(MessageStrings.MARKOV_MODEL_TRACES_ENABLED, MARKOV_MODEL_TRACES_ENABLED);
        configuration.setAttribute(MessageStrings.ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED,
                ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED);
        configuration.setAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED, MARKOV_MODEL_STORAGE_ENABLED);
        configuration.setAttribute(MessageStrings.MARKOV_MODEL_FILE, MARKOVMODELFILEDEFAULT);
        configuration.setAttribute(MessageStrings.MARKOV_EVALUATION_MODE, MARKOV_EVALUATION_MODE.toString());
    }

    /**
     * Updates the status of the spinner fields.
     */
    private void updateFieldsEnablement() {
        spinnerNumberOfEvaluatedSystemStates.setEnabled(checkNumberOfEvaluatedSystemStates.getSelection());
        spinnerNumberOfExactDecimalPlaces.setEnabled(checkNumberOfExactDecimalPlaces.getSelection());
        spinnerSolvingTimeLimit.setEnabled(checkSolvingTimeLimit.getSelection());
        textLogFile.setEnabled(checkSingleResults.getSelection());
        buttonWorkspaceFileDialogLogFile.setEnabled(checkSingleResults.getSelection());
        buttonFileSystemFileDialogLogFile.setEnabled(checkSingleResults.getSelection());
        textMarkovModelFile.setEnabled(checkStoreMarkovModel.getSelection());
        buttonWorkspaceFileDialogModelFile.setEnabled(checkStoreMarkovModel.getSelection());
        buttonFileSystemFileDialogModelFile.setEnabled(checkStoreMarkovModel.getSelection());
        textSaveResultsToFile.setEnabled(checkSaveResultsToFile.getSelection());
        buttonWorkspaceFileDialogSaveToFile.setEnabled(checkSaveResultsToFile.getSelection());
        buttonFileSystemFileDialogSaveToFile.setEnabled(checkSaveResultsToFile.getSelection());
    }
}
