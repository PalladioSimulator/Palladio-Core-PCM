package de.uka.ipd.sdq.dsexplore.launch;

import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

public class StartingPopulationHeuristicTab extends FileNamesInputTab {
	final static String TAB_NAME = "Starting Population Heuristic";
	private static final int DEFAULT_MARGIN = 15;
	private static final int DEFAULT_HORIZONTAL_SPACING = 30;
	private ModifyListener modifyListener;
	
	/*
	 * Reallocation Settings
	 */
	
	final static String STARTING_POPULATION_GROUP_NAME = "Starting Population Heuristic";
	final static String USE_STARTING_POPULATION_HEURISTIC = "Use starting population heuristic";
	final static String MAX_NUMBER_RESOURCE_CONTAINERS = "Maximum number of resource containers";
	final static String MIN_NUMBER_RESOURCE_CONTAINERS = "Minimum number of resource containers";
	final static String NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL = "Number of candidates per allocation level";

	private Button useStartingPopulationHeuristicButton;
	private Text minNumberOfResourceContainers;
	private Text maxNumberOfResourceContainers;
	private Text numberOfCandidatesPerAllocationLevel;

	private Label minNumberOfResourceContainersLabel;
	private Label maxNumberOfResourceContainersLabel;
	private Label numberOfCandidatesPerAllocationLevelLabel;
	
	final static boolean USE_STARTING_POPULATION_HEURISTIC_DEFAULT =  false;
	final static int MIN_NUMBER_OF_RESOURCE_CONTAINERS_DEFAULT = 2;
	final static int MAX_NUMBER_OF_RESOURCE_CONTAINERS_DEFAULT = 9;
	final static int NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL_DEFAULT = 10;

	@Override
	public void createControl(Composite parent) {
		modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				StartingPopulationHeuristicTab.this.setDirty(true);
				StartingPopulationHeuristicTab.this.updateLaunchConfigurationDialog();
			}
		};

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				StartingPopulationHeuristicTab.this.setDirty(true);
				StartingPopulationHeuristicTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				StartingPopulationHeuristicTab.this.setDirty(true);
				StartingPopulationHeuristicTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/*
		 * Reallocation
		 */
		{
			final Group startingPopulationGroup = new Group(container, SWT.NONE);
			final GridLayout startingPopulationGroupLayout = new GridLayout();
			startingPopulationGroupLayout.numColumns = 4;
			startingPopulationGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			startingPopulationGroupLayout.marginHeight = DEFAULT_MARGIN;
			startingPopulationGroupLayout.marginWidth = DEFAULT_MARGIN;
			startingPopulationGroup.setLayout(startingPopulationGroupLayout);
			startingPopulationGroup.setText(STARTING_POPULATION_GROUP_NAME);
			startingPopulationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false));

			useStartingPopulationHeuristicButton = new Button(startingPopulationGroup, SWT.CHECK);
			useStartingPopulationHeuristicButton.setEnabled(true);
			useStartingPopulationHeuristicButton.setSelection(true);
			useStartingPopulationHeuristicButton.setText(USE_STARTING_POPULATION_HEURISTIC);
			useStartingPopulationHeuristicButton.addSelectionListener(selectionListener);
			useStartingPopulationHeuristicButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// enable level and half-with fields if and only if check
					// box is checked
					updateStartingPopulationSelection();
				}

			});

			// spacer
			new Label(startingPopulationGroup, SWT.NONE);
			new Label(startingPopulationGroup, SWT.NONE);
			new Label(startingPopulationGroup, SWT.NONE);

			maxNumberOfResourceContainersLabel = new Label(
					startingPopulationGroup, SWT.NONE);
			maxNumberOfResourceContainersLabel
					.setText(MAX_NUMBER_RESOURCE_CONTAINERS);
			maxNumberOfResourceContainers = new Text(startingPopulationGroup,
					SWT.SINGLE | SWT.BORDER);
			maxNumberOfResourceContainers.setEnabled(true);
			maxNumberOfResourceContainers
					.addModifyListener(modifyListener);

			minNumberOfResourceContainersLabel = new Label(
					startingPopulationGroup, SWT.NONE);
			minNumberOfResourceContainersLabel
					.setText(MIN_NUMBER_RESOURCE_CONTAINERS);
			minNumberOfResourceContainers = new Text(startingPopulationGroup,
					SWT.SINGLE | SWT.BORDER);
			minNumberOfResourceContainers.setEnabled(true);
			minNumberOfResourceContainers
					.addModifyListener(modifyListener);

			numberOfCandidatesPerAllocationLevelLabel = new Label(
					startingPopulationGroup, SWT.NONE);
			numberOfCandidatesPerAllocationLevelLabel
					.setText(NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL);
			numberOfCandidatesPerAllocationLevel = new Text(startingPopulationGroup,
					SWT.SINGLE | SWT.BORDER);
			numberOfCandidatesPerAllocationLevel.setEnabled(true);
			numberOfCandidatesPerAllocationLevel
					.addModifyListener(modifyListener);
		}
	}

	@Override
	public String getName() {
		return TAB_NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			useStartingPopulationHeuristicButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_STARTING_POPULATION_HEURISTIC, USE_STARTING_POPULATION_HEURISTIC_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_STARTING_POPULATION_HEURISTIC , e.getMessage());
		}
		
		try {
			maxNumberOfResourceContainers.setText(configuration.getAttribute(DSEConstantsContainer.MAX_NUMBER_RESOURCE_CONTAINERS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), MAX_NUMBER_RESOURCE_CONTAINERS , e.getMessage());
		}
		
		try {
			minNumberOfResourceContainers.setText(configuration.getAttribute(DSEConstantsContainer.MIN_NUMBER_RESOURCE_CONTAINERS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), MIN_NUMBER_RESOURCE_CONTAINERS , e.getMessage());
		}
		
		try {
			numberOfCandidatesPerAllocationLevel.setText(configuration.getAttribute(DSEConstantsContainer.NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL , e.getMessage());
		}
		updateSelections();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSEConstantsContainer.USE_STARTING_POPULATION_HEURISTIC, useStartingPopulationHeuristicButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.MAX_NUMBER_RESOURCE_CONTAINERS, maxNumberOfResourceContainers.getText());
		configuration.setAttribute(DSEConstantsContainer.MIN_NUMBER_RESOURCE_CONTAINERS, minNumberOfResourceContainers.getText());
		configuration.setAttribute(DSEConstantsContainer.NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL, numberOfCandidatesPerAllocationLevel.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSEConstantsContainer.USE_STARTING_POPULATION_HEURISTIC, USE_STARTING_POPULATION_HEURISTIC_DEFAULT);
		configuration.setAttribute(DSEConstantsContainer.MIN_NUMBER_RESOURCE_CONTAINERS, Integer.toString(MIN_NUMBER_OF_RESOURCE_CONTAINERS_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.MAX_NUMBER_RESOURCE_CONTAINERS, Integer.toString(MAX_NUMBER_OF_RESOURCE_CONTAINERS_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL, Integer.toString(NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL_DEFAULT));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		if (!useStartingPopulationHeuristicButton.getSelection()) {
			return true;
		}
		
		// starting population cannot be used together with a predefined start population
		String startingPopulationFileName;
		try {
			startingPopulationFileName = launchConfig.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "");
			if (startingPopulationFileName != null && ! "".equals(startingPopulationFileName)){
				setErrorMessage("Starting population heuristics cannot be enabled if a starting population has been predefined in the DSE Options Tab");
				return false;
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		} 
		
		
		/*
		 * Check: is int and > 0 ?
		 */
		Hashtable<Text, String> valuesToCheck = new Hashtable<Text, String>();
		valuesToCheck.put(minNumberOfResourceContainers, "Minimum number of resouce containers");
		valuesToCheck.put(maxNumberOfResourceContainers, "Maximum number of resource containers");
		valuesToCheck.put(numberOfCandidatesPerAllocationLevel, "Number of candidates per processing rate level");
		for (Text text : valuesToCheck.keySet()) {
			try {
				int i = Integer.parseInt(text.getText());
				if (i <= 0) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				setErrorMessage(valuesToCheck.get(text) + " (" + text.getText()
						+ ") must be an integer value >0 or empty.");
				return false;
			}
		}

		/*
		 * Check minNumberOfResourceContainers <= maxNumberOfResourceContainers
		 */
		try {
			int min = Integer.parseInt(minNumberOfResourceContainers.getText());
			int max = Integer.parseInt(maxNumberOfResourceContainers.getText());
			if (min > max) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			setErrorMessage("Minimum number of resource containers must not be larger than maxmimum number of resource containers.");
			return false;
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
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
	}
	
	private void updateSelections() {
		updateStartingPopulationSelection();
	}


	/**
	 * 
	 */
	private void updateStartingPopulationSelection() {
		boolean selected = useStartingPopulationHeuristicButton.getSelection();
		maxNumberOfResourceContainersLabel
				.setEnabled(selected);
		maxNumberOfResourceContainers.setEnabled(selected);
		minNumberOfResourceContainersLabel
				.setEnabled(selected);
		minNumberOfResourceContainers.setEnabled(selected);
		numberOfCandidatesPerAllocationLevelLabel
				.setEnabled(selected);
		numberOfCandidatesPerAllocationLevel.setEnabled(selected);
		StartingPopulationHeuristicTab.this.updateLaunchConfigurationDialog();
	}
	

}
