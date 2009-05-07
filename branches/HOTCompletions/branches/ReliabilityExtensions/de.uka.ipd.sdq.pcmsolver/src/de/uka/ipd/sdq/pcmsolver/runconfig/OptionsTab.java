package de.uka.ipd.sdq.pcmsolver.runconfig;

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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.seff.InternalAction;

/**
 * This tab page shows additional options for the PCM Solver Reliability launch.
 * 
 * @author brosch
 * 
 */
public class OptionsTab extends AbstractLaunchConfigurationTab {

	/**
	 * Checks for verbose logging.
	 */
	private Button checkVerboseLogging = null;

	/**
	 * Checks for Markov statistics.
	 */
	private Button checkMarkovStatistics = null;

	/**
	 * Checks for single result prints.
	 */
	private Button checkSingleResults = null;

	/**
	 * Opens the variable selection dialog.
	 */
	private Button buttonSelectVariable = null;

	/**
	 * Sensitivity analysis variable text field.
	 */
	private Text textVariable = null;

	/**
	 * Sensitivity analysis minimum value field.
	 */
	private Text textMinimum = null;

	/**
	 * Sensitivity analysis maximum value field.
	 */
	private Text textMaximum = null;

	/**
	 * Sensitivity analysis step field.
	 */
	private Text textStep = null;

	/**
	 * Temporary models path.
	 */
	private Text textPath = null;

	/**
	 * Default setting for verbose logging.
	 */
	private static final boolean VERBOSEDEFAULT = false;

	/**
	 * Default setting for Markov statistics.
	 */
	private static final boolean STATISTICSDEFAULT = false;

	/**
	 * Default setting for single result printing.
	 */
	private static final boolean SINGLERESULTSDEFAULT = false;

	/**
	 * Default string for sensitivity analysis element field.
	 */
	private static final String NOELEMENTSELECTED = "NO ELEMENT SELECTED";

	/**
	 * Default string for invalid sensitivity analysis selection.
	 */
	private static final String INVALIDSELECTION = "NOT VALID (select InternalAction!)";

	/**
	 * Indicates if sensitivity analysis is active.
	 */
	private boolean sensitiviyActive = false;

	/**
	 * Names of model files.
	 */
	private ArrayList<String> modelFiles = new ArrayList<String>();

	/**
	 * The central routine to create the layout of the tag page.
	 * 
	 * @param parent
	 *            the parent control
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(final Composite parent) {

		// Create a listener for GUI events:
		final Listener listener = new Listener() {
			public void handleEvent(final Event event) {
				updateLaunchConfigurationDialog();
			}
		};

		// Create a listener for GUI modification events:
		final ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};

		// Create a new Composite to hold the page's controls:
		final Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		// Create a new GridLayout for the logging Group:
		final GridLayout loggingLayout = new GridLayout();
		loggingLayout.numColumns = 1;

		// Create the logging Group with the verbose logging check box:
		final Group loggingGroup = new Group(container, SWT.NONE);
		loggingGroup.setLayout(loggingLayout);
		loggingGroup.setText("Logging");
		loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		// Create the verbose logging check box:
		checkVerboseLogging = new Button(loggingGroup, SWT.CHECK);
		checkVerboseLogging.setText("Enable verbose logging");
		checkVerboseLogging.setSelection(VERBOSEDEFAULT);
		checkVerboseLogging.addListener(SWT.Selection, listener);

		// Create the Markov statistics check box:
		checkMarkovStatistics = new Button(loggingGroup, SWT.CHECK);
		checkMarkovStatistics.setText("Print Markov statistics");
		checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
		checkMarkovStatistics.addListener(SWT.Selection, listener);

		// Create the Markov statistics check box:
		checkSingleResults = new Button(loggingGroup, SWT.CHECK);
		checkSingleResults
				.setText("Print results of all Markov transformation runs");
		checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
		checkSingleResults.addListener(SWT.Selection, listener);

		// Create a grid layout for the sensitivity group:
		final GridLayout sensitivityLayout = new GridLayout();
		sensitivityLayout.numColumns = 6;

		// Create the sensitivity analysis Group:
		final Group sensitivityGroup = new Group(container, SWT.NONE);
		sensitivityGroup.setText("Sensitivity Analysis");
		sensitivityGroup.setLayout(sensitivityLayout);
		sensitivityGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		// Create the variable label:
		final Label labelVariable = new Label(sensitivityGroup, SWT.NONE);
		labelVariable.setText("Element:");

		// Create the variable text field:
		textVariable = new Text(sensitivityGroup, SWT.BORDER);
		textVariable.setEditable(false);
		textVariable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 4, 1));
		textVariable.addModifyListener(modifyListener);

		// Create the select variable button:
		buttonSelectVariable = new Button(sensitivityGroup, SWT.NONE);
		buttonSelectVariable.setText("Select Model Element...");
		buttonSelectVariable.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				selectVariable();
			}
		});

		// Create the minimum label:
		final Label labelMinimum = new Label(sensitivityGroup, SWT.NONE);
		labelMinimum.setText("Minimum:");

		// Create the minimum text field:
		textMinimum = new Text(sensitivityGroup, SWT.BORDER);
		textMinimum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		textMinimum.addModifyListener(modifyListener);

		// Create the maximum label:
		final Label labelMaximum = new Label(sensitivityGroup, SWT.NONE);
		labelMaximum.setText("Maximum:");

		// Create the maximum text field:
		textMaximum = new Text(sensitivityGroup, SWT.BORDER);
		textMaximum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		textMaximum.addModifyListener(modifyListener);

		// Create the step label:
		final Label labelStep = new Label(sensitivityGroup, SWT.NONE);
		labelStep.setText("Step Width:");

		// Create the step text field:
		textStep = new Text(sensitivityGroup, SWT.BORDER);
		textStep.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textStep.addModifyListener(modifyListener);

		// Create the path label:
		final Label labelPath = new Label(sensitivityGroup, SWT.NONE);
		labelPath.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false,
				2, 1));
		labelPath.setText("Path for temporary models:");

		// Create the path text field:
		textPath = new Text(sensitivityGroup, SWT.BORDER);
		textPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				4, 1));
		textPath.addModifyListener(modifyListener);
	}

	/**
	 * The name of the tap page as displayed to the user.
	 * 
	 * @return the name of the tap page
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Options";
	}

	/**
	 * Opens a dialog to select a PCM Random Variable from any of the model's
	 * files.
	 */
	private void selectVariable() {

		// Create an EMF resource set to hold all model files:
		ResourceSet rs = new ResourceSetImpl();

		// Get all model file resources:
		for (String file : modelFiles) {
			try {
				rs.getResource(URI.createURI(file), true);
			} catch (Exception ex) {
				rs.getResource(URI.createFileURI(file), true);
			}
		}
		EcoreUtil.resolveAll(rs);

		// Prepare a filter for the type of elements to be displayed:
		ArrayList filter = new ArrayList();
		filter.add(EObject.class);

		// Show the dialog:
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				getShell(), filter, rs);
		if (dialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {

			// Write the EMF element URI into the variable text field:
			if (activateSensitivity(dialog.getResult())) {
				textVariable.setText(((InternalAction) dialog.getResult())
						.getId());
			}
		}
	}

	/**
	 * Activates sensitivity analysis for the given EMF element.
	 * 
	 * @param element
	 *            the element
	 * @return TRUE if sensitivity has been activated
	 */
	private boolean activateSensitivity(EObject element) {

		// Determine target activation status:
		boolean activate = true;

		// Check the argument:
		if ((element == null) || !(element instanceof InternalAction)) {

			// Wrong argument. Deactivate sensitivity:
			textVariable.setText(INVALIDSELECTION);
			activate = false;
		}

		// Set sensitivity:
		setSensitivity(activate);
		return activate;
	}

	/**
	 * Activates or deactivates sensitivity analysis.
	 * 
	 * @param activate
	 *            determines the required target state
	 */
	private void setSensitivity(boolean activate) {
		textMinimum.setEnabled(activate);
		textMaximum.setEnabled(activate);
		textStep.setEnabled(activate);
		sensitiviyActive = activate;
	}

	/**
	 * Initialization of the tab page in the case that a configuration already
	 * exists.
	 * 
	 * @param configuration
	 *            configuration details of the launch
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(final ILaunchConfiguration configuration) {

		// Try to retrieve the settings from the given configuration:
		try {
			checkVerboseLogging.setSelection(configuration.getAttribute(
					MessageStrings.VERBOSE_LOGGING, VERBOSEDEFAULT));
			checkMarkovStatistics.setSelection(configuration.getAttribute(
					MessageStrings.MARKOV_STATISTICS, STATISTICSDEFAULT));
			checkSingleResults.setSelection(configuration.getAttribute(
					MessageStrings.SINGLE_RESULTS, SINGLERESULTSDEFAULT));
			setSensitivity(configuration.getAttribute(
					ConstantsContainer.SENSITIVITY_ACTIVE, false));
			textVariable.setText(configuration.getAttribute(
					ConstantsContainer.VARIABLE_TEXT, NOELEMENTSELECTED));
			textMinimum.setText(configuration.getAttribute(
					ConstantsContainer.MINIMUM_TEXT, ""));
			textMaximum.setText(configuration.getAttribute(
					ConstantsContainer.MAXIMUM_TEXT, ""));
			textStep.setText(configuration.getAttribute(
					ConstantsContainer.STEP_WIDTH_TEXT, ""));
			textPath.setText(configuration.getAttribute(
					ConstantsContainer.TEMPORARY_MODELS_PATH, ""));
		} catch (CoreException e) {

			// Defaults apply:
			checkVerboseLogging.setSelection(VERBOSEDEFAULT);
			checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
			checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
			setSensitivity(false);
			textVariable.setText(NOELEMENTSELECTED);
			textMinimum.setText("");
			textMaximum.setText("");
			textStep.setText("");
			textPath.setText("");
		}

		// Try to retrieve model files from the files tab:
		try {
			modelFiles.clear();
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.REPOSITORY_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.SYSTEM_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.ALLOCATION_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ""));
		} catch (CoreException e) {

			// If the model files cannot be retrieved, no sensitivity analysis
			// can be performed:
			setSensitivity(false);
			textVariable.setText(NOELEMENTSELECTED);
		}

		// Update Buttons and Message:
		updateLaunchConfigurationDialog();
	}

	/**
	 * Checks if the tab is in a valid state.
	 * 
	 * @param configuration
	 *            configuration details of the launch
	 * @return TRUE if the tab page's state is valid
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public boolean isValid(final ILaunchConfiguration configuration) {

		// There is no invalid state:
		return true;
	}

	/**
	 * Applies the values entered to the tab page to the launch configuration.
	 * 
	 * @param configuration
	 *            configuration details of the launch as a working copy
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {

		// Store the settings into the configuration:
		configuration.setAttribute(MessageStrings.VERBOSE_LOGGING,
				checkVerboseLogging.getSelection());
		configuration.setAttribute(MessageStrings.MARKOV_STATISTICS,
				checkMarkovStatistics.getSelection());
		configuration.setAttribute(MessageStrings.SINGLE_RESULTS,
				checkSingleResults.getSelection());
		configuration.setAttribute(ConstantsContainer.SENSITIVITY_ACTIVE,
				sensitiviyActive);
		configuration.setAttribute(ConstantsContainer.VARIABLE_TEXT,
				textVariable.getText());
		configuration.setAttribute(ConstantsContainer.MINIMUM_TEXT, textMinimum
				.getText());
		configuration.setAttribute(ConstantsContainer.MAXIMUM_TEXT, textMaximum
				.getText());
		configuration.setAttribute(ConstantsContainer.STEP_WIDTH_TEXT, textStep
				.getText());
		configuration.setAttribute(ConstantsContainer.TEMPORARY_MODELS_PATH,
				textPath.getText());
	}

	/**
	 * Loads default settings into the configuration.
	 * 
	 * @param configuration
	 *            configuration details of the launch as a working copy
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {

		// Load default settings into the configuration:
		configuration.setAttribute(MessageStrings.VERBOSE_LOGGING,
				VERBOSEDEFAULT);
		configuration.setAttribute(MessageStrings.MARKOV_STATISTICS,
				STATISTICSDEFAULT);
		configuration.setAttribute(MessageStrings.SINGLE_RESULTS,
				SINGLERESULTSDEFAULT);
		configuration
				.setAttribute(ConstantsContainer.SENSITIVITY_ACTIVE, false);
		configuration.setAttribute(ConstantsContainer.VARIABLE_TEXT,
				NOELEMENTSELECTED);
		configuration.setAttribute(ConstantsContainer.MINIMUM_TEXT, "");
		configuration.setAttribute(ConstantsContainer.MAXIMUM_TEXT, "");
		configuration.setAttribute(ConstantsContainer.STEP_WIDTH_TEXT, "");
		configuration
				.setAttribute(ConstantsContainer.TEMPORARY_MODELS_PATH, "");
	}

}
