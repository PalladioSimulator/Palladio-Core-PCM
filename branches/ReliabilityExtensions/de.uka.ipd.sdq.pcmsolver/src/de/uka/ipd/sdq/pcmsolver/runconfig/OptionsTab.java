package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

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
	 * Width of verbose logging Group.
	 */
	private static final int LOGGINGWIDTH = 500;

	/**
	 * The central routine to create the layout of the tag page.
	 * 
	 * @param parent
	 *            the parent control
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(final Composite parent) {

		// Create a new Composite to hold the page's controls:
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		// Create a new GridLayout for the logging Group:
		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 1;

		// Create the logging Group with the verbose logging check box:
		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Logging");
		group.setLayoutData(new GridData(LOGGINGWIDTH, SWT.DEFAULT));

		// Create the verbose logging check box:
		checkVerboseLogging = new Button(group, SWT.CHECK);
		checkVerboseLogging.setText("Enable verbose logging");
		checkVerboseLogging.setSelection(VERBOSEDEFAULT);
		checkVerboseLogging.addListener(SWT.Selection, new Listener() {
			public void handleEvent(final Event event) {
				updateLaunchConfigurationDialog();
			}
		});

		// Create the Markov statistics check box:
		checkMarkovStatistics = new Button(group, SWT.CHECK);
		checkMarkovStatistics.setText("Print Markov statistics");
		checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
		checkMarkovStatistics.addListener(SWT.Selection, new Listener() {
			public void handleEvent(final Event event) {
				updateLaunchConfigurationDialog();
			}
		});

		// Create the Markov statistics check box:
		checkSingleResults = new Button(group, SWT.CHECK);
		checkSingleResults.setText("Print results of all Markov transformation runs");
		checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
		checkSingleResults.addListener(SWT.Selection, new Listener() {
			public void handleEvent(final Event event) {
				updateLaunchConfigurationDialog();
			}
		});
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
		} catch (CoreException e) {

			// Defaults apply:
			checkVerboseLogging.setSelection(VERBOSEDEFAULT);
			checkMarkovStatistics.setSelection(STATISTICSDEFAULT);
			checkSingleResults.setSelection(SINGLERESULTSDEFAULT);
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
	}

}
