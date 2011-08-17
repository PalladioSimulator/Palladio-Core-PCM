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

public class TacticsTab extends FileNamesInputTab {
	final static String TAB_NAME = "Tactics";
	private static final int DEFAULT_MARGIN = 15;
	private static final int DEFAULT_HORIZONTAL_SPACING = 30;
	private ModifyListener modifyListener;
	
	/*
	 * General Settings
	 */
	final static String GENERAL_SETTINGS_GROUP_NAME = "General Settings";
	final static String CONSIDER_QML_BOUNDS = "Consider QML bounds (Makes tactic application dependent of bound violations.)";
	final static String TACTICS_PROBABILITY = "Probability to try applying tactics when mating.";
	
	private Button considerQMLBoundsButton;
	private Text tacticsProbabilityText;
	
	/*
	 * Reallocation Settings
	 */
	
	final static String REALLOCATION_GROUP_NAME = "Reallocation Tactic";
	final static String USE_REALLOCATION = "Use reallocation tactic";
	final static String REALLOCATION_UTILISATION_DIFFERENCE = "Threshold for utilisation difference";
	final static String REALLOCATION_WEIGHT = "Weight of reallocation tactic";

	private Button useReallocationButton;
	private Text reallocationThresholdUtilisationDifference;
	private Text reallocationWeight;

	private Label reallocationThresholdUtilisationDifferenceLabel;
	private Label reallocationWeightLabel;
	
	final static boolean USE_REALLOCATION_DEFAULT =  false;
	final static double REALLOCATION_UTILISATION_DIFFERENCE_DEFAULT = 0.5;
	final static double REALLOCATION_WEIGHT_DEFAULT = 1.0;
	
	/*
	 * Processing rate setting
	 */

	final static String PROCESSING_RATE_GROUP_NAME = "Processing Rate Heuristic";
	final static String USE_PROCESSING_RATE = "Use processing rate tactic";
	final static String PROCESSING_RATE_THRESHOLD_LOW_UTILISATION = "Threshold for low utilisation";
	final static String PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION = "Threshold for high utilisation";
	final static String PROCESSING_RATE_INCREASE_FACTOR = "Increase processing rate factor";
	final static String PROCESSING_RATE_DECREASE_FACTOR = "Decrease processing rate factor";
	final static String PROCESSING_RATE_WEIGHT = "Weight of processing rate tactic";

	private Button useProcessingRateButton;
	private Text processingRateThresholdLowUtilisation;
	private Text processingRateThresholdHighUtilisation;
	private Text processingRateDecreaseFactor;
	private Text processingRateIncreaseFactor;
	private Text processingRateWeight;

	private Label processingRateThresholdLowUtilisationLabel;
	private Label processingRateThresholdHighUtilisationLabel;
	private Label processingRateDecreaseFactorLabel;
	private Label processingRateIncreaseFactorLabel;
	private Label processingRateWeightLabel;
	
	final static boolean USE_PROCESSING_RATE_DEFAULT = false;
	final static double PROCESSING_RATE_THRESHOLD_LOW_UTILISATION_DEFAULT = 0.2;
	final static double PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION_DEFAULT = 0.8;
	final static double PROCESSING_RATE_INCREASE_FACTOR_DEFAULT = 0.25;
	final static double PROCESSING_RATE_DECREASE_FACTOR_DEFAULT = 0.25;
	final static double PROCESSING_RATE_WEIGHT_DEFAULT = 0.1;
	
	/*
	 * Server consolidation settings
	 */

	final static String SERVER_CONSOLIDATION_GROUP_NAME = "Server Consolidation";
	final static String USE_SERVER_CONSOLIDATION = "Use server consolidation tactic";
	final static String SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION = "Threshold for low utilisation";
	final static String SERVER_CONSOLIDATION_WEIGHT = "Weight of server consolidation tactic";

	private Button useServerConsolidationButton;
	private Text serverConsolidationThresholdLowUtilisation;
	private Text serverConsolidationWeight;

	private Label serverConsolidationThresholdLowUtilisationLabel;
	private Label serverConsolidationWeightLabel;
	
	final static boolean USE_SERVER_CONSOLIDATION_DEFAULT = false;
	final static double SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION_DEFAULT = 0.3;
	final static double SERVER_CONSOLIDATION_WEIGHT_DEFAULT = 0.5;
	
	/*
	 * Server expansion settings
	 */

	final static String SERVER_EXPANSION_GROUP_NAME = "Server expansion";
	final static String USE_SERVER_EXPANSION = "Use server expansion tactic";
	final static String SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION = "Threshold for high utilisation";
	final static String SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS = "Maximum number of reallocations";
	final static String SERVER_EXPANSION_WEIGHT = "Weight of server expansion tactic";
	
	private Button useServerExpansionButton;
	private Text serverExpansionThresholdHighUtilisation;
	private Text serverExpansionMaxNumberOfReplacements;
	private Text serverExpansionWeight;

	private Label serverExpansionThresholdHighUtilisationLabel;
	private Label serverExpansionMaxNumberOfReplacementsLabel;
	private Label serverExpansionWeightLabel;
	
	/* Linking resource reallocation tactic*/
	private Button useLinkReallocationButton;
	final static String REALLOCATION_FOR_LINK_USAGE_GROUP_NAME = "Reallocation for link usage tactic";
	final static String REALLOCATION_FOR_LINK_USAGE = "Use link reallocation tactic";
	
	/* Antipattern settings */
	private Button useAntipatternsButton;
	private static final String USE_ANTIPATTERNS = "Use antipattern knowledge";
    private static final String ANTIPATTERNS_GROUP_NAME = "Antipattern Detection and Solution";
	
    /* defaults */
    final static boolean CONSIDER_QML_BOUNDS_DEFAULT = false;
	final static boolean USE_SERVER_EXPANSION_DEFAULT = false;
	final static double SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION_DEFAULT = 0.7;
	final static int SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS_DEFAULT = 1;
	final static double SERVER_EXPANSION_WEIGHT_DEFAULT = 0.5;
	
	final static boolean  USE_ANTIPATTERNS_DEFAULT = false;
	final static boolean USE_LINK_REALLOCATION_DEFAULT = false;
	
	

	@Override
	public void createControl(Composite parent) {
		modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				TacticsTab.this.setDirty(true);
				TacticsTab.this.updateLaunchConfigurationDialog();
			}
		};

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				TacticsTab.this.setDirty(true);
				TacticsTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				TacticsTab.this.setDirty(true);
				TacticsTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		/*
		 * Consider QML bounds
		 */
		{
			final Group generalSettingsGroup = new Group(container, SWT.NONE);
			final GridLayout qmlGroupLayout = new GridLayout();
			qmlGroupLayout.numColumns = 4;
			qmlGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			qmlGroupLayout.marginHeight = DEFAULT_MARGIN;
			qmlGroupLayout.marginWidth = DEFAULT_MARGIN;
			generalSettingsGroup.setLayout(qmlGroupLayout);
			generalSettingsGroup.setText(GENERAL_SETTINGS_GROUP_NAME);
			generalSettingsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false));

			considerQMLBoundsButton = new Button(generalSettingsGroup, SWT.CHECK);
			considerQMLBoundsButton.setEnabled(true);
			considerQMLBoundsButton.setSelection(true);
			considerQMLBoundsButton.setText(CONSIDER_QML_BOUNDS);
			considerQMLBoundsButton.addSelectionListener(selectionListener);

			Label tacticsProbabilityLabel = new Label(generalSettingsGroup, SWT.NONE);
			tacticsProbabilityLabel.setText(TACTICS_PROBABILITY);
			
			tacticsProbabilityText = new Text(generalSettingsGroup, SWT.SINGLE | SWT.BORDER);
			tacticsProbabilityText.setText(""+DSEConstantsContainer.TACTICS_PROBABILITY_DEFAULT);
			tacticsProbabilityText.addModifyListener(modifyListener);
		}
		
		/*
		 * Reallocation
		 */
		{
			final Group reallocationGroup = new Group(container, SWT.NONE);
			final GridLayout reallocationGroupLayout = new GridLayout();
			reallocationGroupLayout.numColumns = 4;
			reallocationGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			reallocationGroupLayout.marginHeight = DEFAULT_MARGIN;
			reallocationGroupLayout.marginWidth = DEFAULT_MARGIN;
			reallocationGroup.setLayout(reallocationGroupLayout);
			reallocationGroup.setText(REALLOCATION_GROUP_NAME);
			reallocationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false));

			useReallocationButton = new Button(reallocationGroup, SWT.CHECK);
			useReallocationButton.setEnabled(true);
			useReallocationButton.setSelection(true);
			useReallocationButton.setText(USE_REALLOCATION);
			useReallocationButton.addSelectionListener(selectionListener);
			useReallocationButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// enable level and half-with fields if and only if check
					// box is checked
					updateReallocationSelection();
				}

			});

			// spacer
			new Label(reallocationGroup, SWT.NONE);
			new Label(reallocationGroup, SWT.NONE);
			new Label(reallocationGroup, SWT.NONE);

			reallocationThresholdUtilisationDifferenceLabel = new Label(
					reallocationGroup, SWT.NONE);
			reallocationThresholdUtilisationDifferenceLabel
					.setText(REALLOCATION_UTILISATION_DIFFERENCE);
			reallocationThresholdUtilisationDifference = new Text(reallocationGroup,
					SWT.SINGLE | SWT.BORDER);
			reallocationThresholdUtilisationDifference.setEnabled(true);
			reallocationThresholdUtilisationDifference
					.addModifyListener(modifyListener);

			reallocationWeightLabel = new Label(reallocationGroup, SWT.NONE);
			reallocationWeightLabel.setText(REALLOCATION_WEIGHT);
			reallocationWeight = new Text(reallocationGroup, SWT.SINGLE
					| SWT.BORDER);
			reallocationWeight.setEnabled(true);
			reallocationWeight.addModifyListener(modifyListener);
		}

		/*
		 * Processing Rate
		 */
		{
			final Group processingRateGroup = new Group(container, SWT.NONE);
			final GridLayout processingRateGroupLayout = new GridLayout();
			processingRateGroupLayout.numColumns = 4;
			processingRateGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			processingRateGroupLayout.marginHeight = DEFAULT_MARGIN;
			processingRateGroupLayout.marginWidth = DEFAULT_MARGIN;
			processingRateGroup.setLayout(processingRateGroupLayout);
			processingRateGroup.setText(PROCESSING_RATE_GROUP_NAME);
			processingRateGroup.setLayoutData(new GridData(SWT.FILL,
					SWT.CENTER, true, false));

			useProcessingRateButton = new Button(processingRateGroup, SWT.CHECK);
			useProcessingRateButton.setEnabled(true);
			useProcessingRateButton.setSelection(true);
			useProcessingRateButton.setText(USE_PROCESSING_RATE);
			useProcessingRateButton.addSelectionListener(selectionListener);
			useProcessingRateButton
					.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							// enable level and half-with fields if and only if
							// check box is checked
							updateProcessingRateSelection();
						}

					});

			// spacer
			new Label(processingRateGroup, SWT.NONE);
			new Label(processingRateGroup, SWT.NONE);
			new Label(processingRateGroup, SWT.NONE);

			processingRateThresholdHighUtilisationLabel = new Label(
					processingRateGroup, SWT.NONE);
			processingRateThresholdHighUtilisationLabel
					.setText(PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION);
			processingRateThresholdHighUtilisation = new Text(
					processingRateGroup, SWT.SINGLE | SWT.BORDER);
			processingRateThresholdHighUtilisation.setEnabled(true);
			processingRateThresholdHighUtilisation
					.addModifyListener(modifyListener);

			processingRateThresholdLowUtilisationLabel = new Label(
					processingRateGroup, SWT.NONE);
			processingRateThresholdLowUtilisationLabel
					.setText(PROCESSING_RATE_THRESHOLD_LOW_UTILISATION);
			processingRateThresholdLowUtilisation = new Text(
					processingRateGroup, SWT.SINGLE | SWT.BORDER);
			processingRateThresholdLowUtilisation.setEnabled(true);
			processingRateThresholdLowUtilisation
					.addModifyListener(modifyListener);

			processingRateDecreaseFactorLabel = new Label(processingRateGroup,
					SWT.NONE);
			processingRateDecreaseFactorLabel
					.setText(PROCESSING_RATE_DECREASE_FACTOR);
			processingRateDecreaseFactor = new Text(processingRateGroup,
					SWT.SINGLE | SWT.BORDER);
			processingRateDecreaseFactor.setEnabled(true);
			processingRateDecreaseFactor.addModifyListener(modifyListener);

			processingRateIncreaseFactorLabel = new Label(processingRateGroup,
					SWT.NONE);
			processingRateIncreaseFactorLabel
					.setText(PROCESSING_RATE_INCREASE_FACTOR);
			processingRateIncreaseFactor = new Text(processingRateGroup,
					SWT.SINGLE | SWT.BORDER);
			processingRateIncreaseFactor.setEnabled(true);
			processingRateIncreaseFactor.addModifyListener(modifyListener);

			processingRateWeightLabel = new Label(processingRateGroup, SWT.NONE);
			processingRateWeightLabel.setText(PROCESSING_RATE_WEIGHT);
			processingRateWeight = new Text(processingRateGroup, SWT.SINGLE
					| SWT.BORDER);
			processingRateWeight.setEnabled(true);
			processingRateWeight.addModifyListener(modifyListener);
		}

		/*
		 * Server Consolidation
		 */
		{
			final Group serverConsolidationGroup = new Group(container,
					SWT.NONE);
			final GridLayout serverConsolidationGroupLayout = new GridLayout();
			serverConsolidationGroupLayout.marginHeight = DEFAULT_MARGIN;
			serverConsolidationGroupLayout.marginWidth = DEFAULT_MARGIN;
			serverConsolidationGroupLayout.numColumns = 4;
			serverConsolidationGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			serverConsolidationGroup.setLayout(serverConsolidationGroupLayout);
			serverConsolidationGroup.setText(SERVER_CONSOLIDATION_GROUP_NAME);
			serverConsolidationGroup.setLayoutData(new GridData(SWT.FILL,
					SWT.CENTER, true, false));

			useServerConsolidationButton = new Button(serverConsolidationGroup,
					SWT.CHECK);
			useServerConsolidationButton.setEnabled(true);
			useServerConsolidationButton.setSelection(true);
			useServerConsolidationButton.setText(USE_SERVER_CONSOLIDATION);
			useServerConsolidationButton.addSelectionListener(selectionListener);
			useServerConsolidationButton
					.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							// enable level and half-with fields if and only if
							// check box is checked
							updateServerConsolidationSelection();
						}
					});

			// spacer
			new Label(serverConsolidationGroup, SWT.NONE);
			new Label(serverConsolidationGroup, SWT.NONE);
			new Label(serverConsolidationGroup, SWT.NONE);

			serverConsolidationThresholdLowUtilisationLabel = new Label(
					serverConsolidationGroup, SWT.NONE);
			serverConsolidationThresholdLowUtilisationLabel
					.setText(SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION);
			serverConsolidationThresholdLowUtilisation = new Text(
					serverConsolidationGroup, SWT.SINGLE | SWT.BORDER);
			serverConsolidationThresholdLowUtilisation.setEnabled(true);
			serverConsolidationThresholdLowUtilisation
					.addModifyListener(modifyListener);

			serverConsolidationWeightLabel = new Label(
					serverConsolidationGroup, SWT.NONE);
			serverConsolidationWeightLabel.setText(SERVER_CONSOLIDATION_WEIGHT);
			serverConsolidationWeight = new Text(serverConsolidationGroup,
					SWT.SINGLE | SWT.BORDER);
			serverConsolidationWeight.setEnabled(true);
			serverConsolidationWeight.addModifyListener(modifyListener);
		}

		/*
		 * Server Expansion
		 */
		{
			final Group serverExpansionGroup = new Group(container, SWT.NONE);
			final GridLayout serverExpansionGroupLayout = new GridLayout();
			serverExpansionGroupLayout.marginHeight = DEFAULT_MARGIN;
			serverExpansionGroupLayout.marginWidth = DEFAULT_MARGIN;
			serverExpansionGroupLayout.numColumns = 4;
			serverExpansionGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			serverExpansionGroup.setLayout(serverExpansionGroupLayout);
			serverExpansionGroup.setText(SERVER_EXPANSION_GROUP_NAME);
			serverExpansionGroup.setLayoutData(new GridData(SWT.FILL,
					SWT.CENTER, true, false));

			useServerExpansionButton = new Button(serverExpansionGroup,
					SWT.CHECK);
			useServerExpansionButton.setEnabled(true);
			useServerExpansionButton.setSelection(true);
			useServerExpansionButton.setText(USE_SERVER_EXPANSION);
			useServerExpansionButton.addSelectionListener(selectionListener);
			useServerExpansionButton
					.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							// enable level and half-with fields if and only if
							// check box is
							// checked
							updateServerExpansionSelection();
						}
					});

			// spacer
			new Label(serverExpansionGroup, SWT.NONE);
			new Label(serverExpansionGroup, SWT.NONE);
			new Label(serverExpansionGroup, SWT.NONE);

			serverExpansionThresholdHighUtilisationLabel = new Label(
					serverExpansionGroup, SWT.NONE);
			serverExpansionThresholdHighUtilisationLabel
					.setText(SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION);
			serverExpansionThresholdHighUtilisation = new Text(
					serverExpansionGroup, SWT.SINGLE | SWT.BORDER);
			serverExpansionThresholdHighUtilisation.setEnabled(true);
			serverExpansionThresholdHighUtilisation
					.addModifyListener(modifyListener);

			serverExpansionMaxNumberOfReplacementsLabel = new Label(
					serverExpansionGroup, SWT.NONE);
			serverExpansionMaxNumberOfReplacementsLabel
					.setText(SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS);
			serverExpansionMaxNumberOfReplacements = new Text(
					serverExpansionGroup, SWT.SINGLE | SWT.BORDER);
			serverExpansionMaxNumberOfReplacements.setEnabled(true);
			serverExpansionMaxNumberOfReplacements
					.addModifyListener(modifyListener);

			serverExpansionWeightLabel = new Label(serverExpansionGroup,
					SWT.NONE);
			serverExpansionWeightLabel.setText(SERVER_EXPANSION_WEIGHT);
			serverExpansionWeight = new Text(serverExpansionGroup, SWT.SINGLE
					| SWT.BORDER);
			serverExpansionWeight.setEnabled(true);
			serverExpansionWeight.addModifyListener(modifyListener);
		}
		
		{
			// Link reallocation
			final Group linkReallocGroup = new Group(container, SWT.NONE);
			final GridLayout linkReallocGroupLayout = new GridLayout();
			linkReallocGroupLayout.marginHeight = DEFAULT_MARGIN;
			linkReallocGroupLayout.marginWidth = DEFAULT_MARGIN;
			linkReallocGroupLayout.numColumns = 4;
			linkReallocGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			linkReallocGroup.setLayout(linkReallocGroupLayout);
			linkReallocGroup.setText(REALLOCATION_FOR_LINK_USAGE_GROUP_NAME);
			linkReallocGroup.setLayoutData(new GridData(SWT.FILL,
					SWT.CENTER, true, false));

			useLinkReallocationButton = new Button(linkReallocGroup,
					SWT.CHECK);
			useLinkReallocationButton.setEnabled(true);
			useLinkReallocationButton.setSelection(true);
			useLinkReallocationButton.setText(REALLOCATION_FOR_LINK_USAGE);
			useLinkReallocationButton.addSelectionListener(selectionListener);
		}
		
		
		{
			/*
			 * Antipatterns
			 */
			final Group antipatternsGroup = new Group(container, SWT.NONE);
			final GridLayout antipatternsGroupLayout = new GridLayout();
			antipatternsGroupLayout.marginHeight = DEFAULT_MARGIN;
			antipatternsGroupLayout.marginWidth = DEFAULT_MARGIN;
			antipatternsGroupLayout.numColumns = 4;
			antipatternsGroupLayout.horizontalSpacing = DEFAULT_HORIZONTAL_SPACING;
			antipatternsGroup.setLayout(antipatternsGroupLayout);
			antipatternsGroup.setText(ANTIPATTERNS_GROUP_NAME);
			antipatternsGroup.setLayoutData(new GridData(SWT.FILL,
					SWT.CENTER, true, false));

			useAntipatternsButton = new Button(antipatternsGroup,
					SWT.CHECK);
			useAntipatternsButton.setEnabled(true);
			useAntipatternsButton.setSelection(true);
			useAntipatternsButton.setText(USE_ANTIPATTERNS);
			useAntipatternsButton.addSelectionListener(selectionListener);
		}

	}

	@Override
	public String getName() {
		return TAB_NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			considerQMLBoundsButton.setSelection(configuration.getAttribute(DSEConstantsContainer.CONSIDER_QML_BOUNDS, CONSIDER_QML_BOUNDS_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), CONSIDER_QML_BOUNDS , e.getMessage());
		}
		
		try {
			tacticsProbabilityText.setText(configuration.getAttribute(DSEConstantsContainer.TACTICS_PROBABILITY, ""+DSEConstantsContainer.TACTICS_PROBABILITY_DEFAULT ));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), TACTICS_PROBABILITY , e.getMessage());
		}
		
		try {
			useReallocationButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_REALLOCATION, USE_REALLOCATION_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_REALLOCATION , e.getMessage());
		}
		
		try {
			reallocationThresholdUtilisationDifference.setText(configuration.getAttribute(DSEConstantsContainer.REALLOCATION_UTILISATION_DIFFERENCE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), REALLOCATION_UTILISATION_DIFFERENCE , e.getMessage());
		}
		
		try {
			reallocationWeight.setText(configuration.getAttribute(DSEConstantsContainer.REALLOCATION_WEIGHT, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), REALLOCATION_WEIGHT , e.getMessage());
		}
		
		try {
			useProcessingRateButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_PROCESSING_RATE, USE_PROCESSING_RATE_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_PROCESSING_RATE , e.getMessage());
		}
		
		try {
			useLinkReallocationButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_LINK_REALLOCATION, USE_LINK_REALLOCATION_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), REALLOCATION_FOR_LINK_USAGE , e.getMessage());
		}
		
		try {
			useAntipatternsButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_ANTIPATTERNS, USE_ANTIPATTERNS_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_ANTIPATTERNS , e.getMessage());
		}
		
		try {
			processingRateDecreaseFactor.setText(configuration.getAttribute(DSEConstantsContainer.PROCESSING_RATE_DECREASE_FACTOR, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), PROCESSING_RATE_DECREASE_FACTOR , e.getMessage());
		}
		
		try {
			processingRateIncreaseFactor.setText(configuration.getAttribute(DSEConstantsContainer.PROCESSING_RATE_INCREASE_FACTOR, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), PROCESSING_RATE_INCREASE_FACTOR , e.getMessage());
		}
		
		try {
			processingRateThresholdHighUtilisation.setText(configuration.getAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION , e.getMessage());
		}
		
		try {
			processingRateThresholdLowUtilisation.setText(configuration.getAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_LOW_UTILISATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), PROCESSING_RATE_THRESHOLD_LOW_UTILISATION , e.getMessage());
		}
		
		try {
			processingRateWeight.setText(configuration.getAttribute(DSEConstantsContainer.PROCESSING_RATE_WEIGHT, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), PROCESSING_RATE_WEIGHT , e.getMessage());
		}
		
		try {
			useServerConsolidationButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_SERVER_CONSOLIDATION, USE_SERVER_CONSOLIDATION_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_SERVER_CONSOLIDATION , e.getMessage());
		}
		
		try {
			serverConsolidationThresholdLowUtilisation.setText(configuration.getAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION , e.getMessage());
		}
		
		try {
			serverConsolidationWeight.setText(configuration.getAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_WEIGHT, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), SERVER_CONSOLIDATION_WEIGHT , e.getMessage());
		}
		
		try {
			useServerExpansionButton.setSelection(configuration.getAttribute(DSEConstantsContainer.USE_SERVER_EXPANSION, USE_SERVER_EXPANSION_DEFAULT));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), USE_SERVER_EXPANSION , e.getMessage());
		}
		
		try {
			serverExpansionMaxNumberOfReplacements.setText(configuration.getAttribute(DSEConstantsContainer.SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS , e.getMessage());
		}
		
		try {
			serverExpansionThresholdHighUtilisation.setText(configuration.getAttribute(DSEConstantsContainer.SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION , e.getMessage());
		}
		
		try {
			serverExpansionWeight.setText(configuration.getAttribute(DSEConstantsContainer.SERVER_EXPANSION_WEIGHT, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), SERVER_EXPANSION_WEIGHT , e.getMessage());
		}
		
		updateSelections();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSEConstantsContainer.CONSIDER_QML_BOUNDS, considerQMLBoundsButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.TACTICS_PROBABILITY, tacticsProbabilityText.getText());
		
		configuration.setAttribute(DSEConstantsContainer.USE_REALLOCATION, useReallocationButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.REALLOCATION_UTILISATION_DIFFERENCE, reallocationThresholdUtilisationDifference.getText());
		configuration.setAttribute(DSEConstantsContainer.REALLOCATION_WEIGHT, reallocationWeight.getText());
		
		configuration.setAttribute(DSEConstantsContainer.USE_PROCESSING_RATE, useProcessingRateButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_DECREASE_FACTOR, processingRateDecreaseFactor.getText());
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_INCREASE_FACTOR, processingRateIncreaseFactor.getText());
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION, processingRateThresholdHighUtilisation.getText());
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_LOW_UTILISATION, processingRateThresholdLowUtilisation.getText());
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_WEIGHT, processingRateWeight.getText());
		
		configuration.setAttribute(DSEConstantsContainer.USE_SERVER_CONSOLIDATION, useServerConsolidationButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION, serverConsolidationThresholdLowUtilisation.getText());
		configuration.setAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_WEIGHT, serverConsolidationWeight.getText());
		
		configuration.setAttribute(DSEConstantsContainer.USE_SERVER_EXPANSION, useServerExpansionButton.getSelection());
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS, serverExpansionMaxNumberOfReplacements.getText());
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION, serverExpansionThresholdHighUtilisation.getText());
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_WEIGHT, serverExpansionWeight.getText());
		
		configuration.setAttribute(DSEConstantsContainer.USE_LINK_REALLOCATION, useLinkReallocationButton.getSelection());
		
		configuration.setAttribute(DSEConstantsContainer.USE_ANTIPATTERNS, useAntipatternsButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		configuration.setAttribute(DSEConstantsContainer.THRESHOLD, "0.7");
//		configuration.setAttribute(DSEConstantsContainer.INCR_FACTOR, "1.1");
//		configuration.setAttribute(
//				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION, "3");
//		configuration.setAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY,
//				false);
//		configuration.setAttribute(DSEConstantsContainer.OPTIMISATION_ONLY,
//				false);
		
		configuration.setAttribute(DSEConstantsContainer.USE_REALLOCATION, USE_REALLOCATION_DEFAULT);
		configuration.setAttribute(DSEConstantsContainer.REALLOCATION_UTILISATION_DIFFERENCE, Double.toString(REALLOCATION_UTILISATION_DIFFERENCE_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.REALLOCATION_WEIGHT, Double.toString(REALLOCATION_WEIGHT_DEFAULT));
		
		configuration.setAttribute(DSEConstantsContainer.USE_PROCESSING_RATE, USE_PROCESSING_RATE_DEFAULT);
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_DECREASE_FACTOR, Double.toString(PROCESSING_RATE_DECREASE_FACTOR_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_INCREASE_FACTOR, Double.toString(PROCESSING_RATE_INCREASE_FACTOR_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION, Double.toString(PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_LOW_UTILISATION, Double.toString(PROCESSING_RATE_THRESHOLD_LOW_UTILISATION_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.PROCESSING_RATE_WEIGHT, Double.toString(PROCESSING_RATE_WEIGHT_DEFAULT));
		
		configuration.setAttribute(DSEConstantsContainer.USE_SERVER_CONSOLIDATION, USE_SERVER_CONSOLIDATION_DEFAULT);
		configuration.setAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION, Double.toString(SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_WEIGHT, Double.toString(SERVER_CONSOLIDATION_WEIGHT_DEFAULT));
		
		configuration.setAttribute(DSEConstantsContainer.USE_SERVER_EXPANSION, USE_SERVER_EXPANSION_DEFAULT);
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS, Integer.toString(SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION, Double.toString(SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION_DEFAULT));
		configuration.setAttribute(DSEConstantsContainer.SERVER_EXPANSION_WEIGHT, Double.toString(SERVER_EXPANSION_WEIGHT_DEFAULT));
		
		configuration.setAttribute(DSEConstantsContainer.USE_ANTIPATTERNS, USE_ANTIPATTERNS_DEFAULT);
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
		
		/*
		 * Check: is double?
		 */
		Hashtable<Text, String> valuesToCheck = new Hashtable<Text, String>();
		if (useProcessingRateButton.getSelection()) {
			valuesToCheck.put(processingRateDecreaseFactor, "Processing rate: Decrease factor");
			valuesToCheck.put(processingRateIncreaseFactor, "Processing rate: Increase factor");
		}
		for (Text text : valuesToCheck.keySet()) {
				try {
					Double.parseDouble(text.getText());
				} catch (NumberFormatException e) {
					setErrorMessage(valuesToCheck.get(text)  + " (" +  text.getText() + ") must be a double value or empty.");
					return false;
				}
		}
		
		/*
		 * Check: is int?
		 */
		valuesToCheck = new Hashtable<Text, String>();
		if (useServerExpansionButton.getSelection()) {
			valuesToCheck.put(serverExpansionMaxNumberOfReplacements, "Server expansion: Maximum number of reallocations");
		}
		for (Text text : valuesToCheck.keySet()) {
				try {
					Integer.parseInt(text.getText());
				} catch (NumberFormatException e) {
					setErrorMessage(valuesToCheck.get(text) + " (" +  text.getText() + ") must be an integer value or empty.");
					return false;
				}
		}

		/*
		 * Check: is double in [0,1]?
		 */
		valuesToCheck = new Hashtable<Text, String>();
		valuesToCheck.put(tacticsProbabilityText, TACTICS_PROBABILITY);
		
		if (useProcessingRateButton.getSelection()) {
			valuesToCheck.put(processingRateWeight, "Processing rate: Weight");
			valuesToCheck.put(processingRateThresholdLowUtilisation, "Processing rate: "+PROCESSING_RATE_THRESHOLD_LOW_UTILISATION);
			valuesToCheck
					.put(processingRateThresholdHighUtilisation, "Processing rate: "+PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION);
		}
		if (useReallocationButton.getSelection()) {
			valuesToCheck.put(reallocationWeight, "Reallocation: Weight");
			valuesToCheck.put(reallocationThresholdUtilisationDifference, "Reallocation: "+REALLOCATION_UTILISATION_DIFFERENCE);
		}
		if (useServerConsolidationButton.getSelection()) {
			valuesToCheck.put(serverConsolidationWeight, SERVER_CONSOLIDATION_WEIGHT);
			valuesToCheck.put(serverConsolidationThresholdLowUtilisation,
					"Server consolidation: "+SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION);
		}
		if (useServerExpansionButton.getSelection()) {
			valuesToCheck.put(serverExpansionWeight, "Server expansion: Weight");
			valuesToCheck.put(serverExpansionThresholdHighUtilisation,
					"Server expansion: "+SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION);
		}

		for (Text text : valuesToCheck.keySet()) {
				try {
					if (Double.parseDouble(text.getText()) < 0 || Double.parseDouble(text.getText()) > 1.0) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException e) {
					setErrorMessage(valuesToCheck.get(text) + " (" +  text.getText() + ") must be a double value between 0.0 and 1.0 or empty.");
					return false;
				}
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
		updateProcessingRateSelection();
		updateReallocationSelection();
		updateServerConsolidationSelection();
		updateServerExpansionSelection();
	}
	
	private void updateServerConsolidationSelection() {
		boolean selected = useServerConsolidationButton
				.getSelection();
		serverConsolidationThresholdLowUtilisationLabel
				.setEnabled(selected);
		serverConsolidationThresholdLowUtilisation
				.setEnabled(selected);
		serverConsolidationWeightLabel.setEnabled(selected);
		serverConsolidationWeight.setEnabled(selected);
		TacticsTab.this
				.updateLaunchConfigurationDialog();
	}
	
	/**
	 * 
	 */
	private void updateServerExpansionSelection() {
		boolean selected = useServerExpansionButton
				.getSelection();
		serverExpansionThresholdHighUtilisationLabel
				.setEnabled(selected);
		serverExpansionThresholdHighUtilisation
				.setEnabled(selected);
		serverExpansionMaxNumberOfReplacementsLabel
				.setEnabled(selected);
		serverExpansionMaxNumberOfReplacements
				.setEnabled(selected);
		serverExpansionWeightLabel.setEnabled(selected);
		serverExpansionWeight.setEnabled(selected);
		TacticsTab.this
				.updateLaunchConfigurationDialog();
	}
	

	/**
	 * 
	 */
	private void updateReallocationSelection() {
		boolean selected = useReallocationButton.getSelection();
		reallocationThresholdUtilisationDifferenceLabel
				.setEnabled(selected);
		reallocationThresholdUtilisationDifference.setEnabled(selected);
		reallocationWeightLabel.setEnabled(selected);
		reallocationWeight.setEnabled(selected);
		TacticsTab.this.updateLaunchConfigurationDialog();
	}
	

	/**
	 * 
	 */
	private void updateProcessingRateSelection() {
		boolean selected = useProcessingRateButton
				.getSelection();
		processingRateThresholdHighUtilisationLabel
				.setEnabled(selected);
		processingRateThresholdHighUtilisation
				.setEnabled(selected);
		processingRateThresholdLowUtilisationLabel
				.setEnabled(selected);
		processingRateThresholdLowUtilisation
				.setEnabled(selected);
		processingRateDecreaseFactorLabel
				.setEnabled(selected);
		processingRateDecreaseFactor.setEnabled(selected);
		processingRateIncreaseFactorLabel
				.setEnabled(selected);
		processingRateIncreaseFactor.setEnabled(selected);
		processingRateWeightLabel.setEnabled(selected);
		processingRateWeight.setEnabled(selected);
		TacticsTab.this
				.updateLaunchConfigurationDialog();
	}
}
