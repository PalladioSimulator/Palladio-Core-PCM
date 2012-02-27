/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.launch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.tcfmoop.config.TerminationCriteriaNames;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;

/**
 * @author Atanas Dimitrov
 * 
 */
public class TerminationCriteriaTab extends AbstractLaunchConfigurationTab {

	private final static String TAB_NAME = "Termination Criteria";
	private final static String MENU_COMMON_SETTING = "Termination Criteria Manager";
	private final static String MENU_MAX_GEN_NUM = "Maximum Number Of Generations";
	private final static String MENU_ELAPSED_TIME = "Elapsed Time";
	private final static String MENU_NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND = "No New Pareto Optimal Candidates Found";
	private final static String MENU_PARETO_OPTIMAL_SET_STABILITY = "Pareto Optimal Set Stability";
	private final static String MENU_MINIMAL_QUALITY_CRITERIA_VALUE = "Minimal Quality Criteria Value";
	private final static String MENU_A_GIVEN_PARETO_FRONT_IS_REACHED = "A Given Pareto Front Is Reached";
	private final static String MENU_INSIGNIFICANT_SET_QUALITY_IMPROVEMENT = "Insignificant Set Quality Improvement";
	private final static String MENU_INSIGNIFICANT_PARETO_FRONT_CHANGE = "Insignificant Pareto Front Change";

	private Image icon;

	private StackLayout stackLayout = new StackLayout();
	private GridLayout oneBlocksGrid = new GridLayout();
	private GridLayout twoBlocksGrid = new GridLayout();
	private GridLayout threeBlocksGrid = new GridLayout();
	private GridLayout fiveBlocksGrid = new GridLayout();

	private Map<String, Composite> contentMap = new HashMap<String, Composite>();

	private Composite container;
	private Composite headerContainer;
	private Composite bodyContainer;

	private Composite commonComposite;
	private Composite maxGenNumComposite;
	private Composite elapsedTimeComposite;
	private Composite noNewParetoOptimalCandidatesFoundComposite;
	private Composite paretoOptimalSetStabilityComposite;
	private Composite minimalQualityCriteriaValueComposite;
	private Composite aGivenParetoFrontIsReachedComposite;
	private Composite insignificantSetQualityImprovementComposite;
	private Composite insignificantParetoFrontChangeComposite;

	private Combo itemsToConfig;

	// Common Begin
	private Button useTerminationCriteria;
	private Button runInComparisionMode;
	// Common End

	// ComposedMode Begin
	private Button activateComposedCriteria;
	private Button expAnd;
	private Button expOr;
	private Button expNot;
	private Button expBrackets;
	private Button expCrit;
	private Button expValidate;
	private Text composedExpression;
	private Label expressionIsValid;
	// ComposedMode End

	// Maximum Generation Number Begin
	private Button maxGenNumActivate;
	private Label maxGenNumLabel;
	private Spinner maxGenNumSpinner;
	// Maximum Generation Number End

	// Maximum Generation Number Begin
	private Button elapsedTimeActivate;
	private Label elapsedTimeLabel;
	private Label elapsedTimeLabel2;
	private Spinner elapsedTimeSpinner;
	private Combo elapsedTimeCombo;
	// Maximum Generation Number End

	// No New Pareto Optimal Candidates Found Begin
	private Button noNewParetoOptimalCandidatesFoundActivate;
	private Label noNewParetoOptimalCandidatesFoundLabel;
	private Spinner noNewParetoOptimalCandidatesFoundSpinner;
	// No New Pareto Optimal Candidates Found End

	// Pareto Optimal Set Stability Begin
	private Button paretoOptimalSetStabilityActivate;
	private Label paretoOptimalSetStabilityLabel;
	private Combo paretoOptimalSetStabilityCombo;
	private Label paretoOptimalSetStabilityLabel1;
	private Spinner paretoOptimalSetStabilitySpinner;
	private Label paretoOptimalSetStabilityLabel2;
	private Spinner paretoOptimalSetStabilitySpinner1;
	private Label paretoOptimalSetStabilityLabel3;
	private Spinner paretoOptimalSetStabilitySpinner2;
	// Pareto Optimal Set Stability End

	// A Given Pareto Front Is Reached Begin
	private Button aGivenParetoFrontIsReachedActivate;
	private Label aGivenParetoFrontIsReachedLabel;
	private Spinner aGivenParetoFrontIsReachedSpinner;
	private Label aGivenParetoFrontIsReachedLabel1;
	private Text aGivenParetoFrontIsReachedText;
	private Button aGivenParetoFrontIsReachedBrowse;
	private FileDialog aGivenParetoFrontIsReachedFileDialog;
	// A Given Pareto Front Is Reached End

	// Insignificant Pareto Front Change Begin
	private Button insignificantParetoFrontChangeActivate;
	private Label insignificantParetoFrontChangeLabel;
	private Spinner insignificantParetoFrontChangeSpinner;
	private Label insignificantParetoFrontChangeLabel1;
	private Label insignificantParetoFrontChangeLabel2;
	private Spinner insignificantParetoFrontChangeSpinner1;
	// Insignificant Pareto Front Change End

	// Minimal Quality Criteria Value Begin
	private Button minimalQualityCriteriaValueActivate;
	private Label minimalQualityCriteriaValueLabel;
	private Spinner minimalQualityCriteriaValueSpinner;
	private Label minimalQualityCriteriaValueLabel1;
	private Table minimalQualityCriteriaValueTable;
	private Button minimalQualityCriteriaValueButton;
	private Button minimalQualityCriteriaValueButton1;
	private Button minimalQualityCriteriaValueButton2;
	// Minimal Quality Criteria Value End

	// Insignificant Set Quality Improvement Begin
	private Button insignificantSetQualityImprovementActivate;
	private Label insignificantSetQualityImprovementLabel;
	private Spinner insignificantSetQualityImprovementSpinner;
	private Label insignificantSetQualityImprovementLabel1;
	private Label insignificantSetQualityImprovementLabel2;
	private Table insignificantSetQualityImprovementTable;
	private Button insignificantSetQualityImprovementButton;
	private Button insignificantSetQualityImprovementButton1;
	private Button insignificantSetQualityImprovementButton2;
	// Insignificant Set Quality Improvement End

	private QMLManager qmlManager;

	public TerminationCriteriaTab(QMLManager qmlManager) {
		this.qmlManager = qmlManager;
	}

	@Override
	public Image getImage() {
		if (icon == null) {
			icon = DSEPluginActivator.getImageDescriptor("icons/tcmanager.gif")
					.createImage();
		}
		return icon;
	}

	final ModifyListener modifyListener = new ModifyListener() {

		public void modifyText(ModifyEvent e) {
			TerminationCriteriaTab.this.setDirty(true);
			TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
		}
	};

	final SelectionListener selectionListener = new SelectionListener() {

		public void widgetDefaultSelected(SelectionEvent e) {
			TerminationCriteriaTab.this.setDirty(true);
			TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
		}

		public void widgetSelected(SelectionEvent e) {
			TerminationCriteriaTab.this.setDirty(true);
			TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
		}
	};

	@Override
	public void createControl(Composite parent) {
		this.oneBlocksGrid.numColumns = 1;
		this.twoBlocksGrid.numColumns = 2;
		this.threeBlocksGrid.numColumns = 3;
		this.fiveBlocksGrid.numColumns = 5;

		container = new Composite(parent, SWT.NONE);
		this.setControl(container);
		container.setLayout(oneBlocksGrid);
		container.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		this.headerContainer = new Composite(container, SWT.NONE);
		this.headerContainer.setLayout(oneBlocksGrid);
		this.headerContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false));

		this.bodyContainer = new Composite(container, SWT.NONE);
		this.bodyContainer.setLayout(this.stackLayout);
		this.bodyContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				true));

		this.initAndAddCommonCompositeContent();
		this.initAndAddMaxGenNumCompositeContent();
		this.initAndAddElapsedTimeComposedContent();
		this.initAndAddNoNewParetoOptimalCandidatesFoundComposedContent();
		this.initAndAddParetoOptimalSetStabilityComposedContent();
		this.initAndAddAGivenParetoFrontIsReachedComposedContent();
		this.initAndAddInsignificantParetoFrontChangeContent();
		this.initAndAddMinimalQualityCriteriaValueContent();
		this.initAndAddInsignificantSetQualityImprovementContent();

		this.menuSelector();

		this.stackLayout.topControl = this.commonComposite;
	}

	private void menuSelector() {
		itemsToConfig = new Combo(this.headerContainer, SWT.READ_ONLY);
		itemsToConfig.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		itemsToConfig.setEnabled(true);

		String[] items = this.contentMap.keySet().toArray(new String[1]);

		itemsToConfig.setItems(items);
		itemsToConfig.addModifyListener(modifyListener);
		itemsToConfig.addSelectionListener(selectionListener);

		itemsToConfig.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// enable level and half-with fields if and only if check
				// box is checked
				stackLayout.topControl = contentMap.get(itemsToConfig
						.getItem(itemsToConfig.getSelectionIndex()));
				TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
			}
		});

		itemsToConfig.select(0);
	}

	private void initAndAddCommonCompositeContent() {
		commonComposite = new Composite(bodyContainer, SWT.NONE);
		commonComposite.setLayout(new GridLayout());

		Group commonSettingsGroup = new Group(commonComposite, SWT.NONE);
		commonSettingsGroup.setLayout(twoBlocksGrid);
		commonSettingsGroup.setText("Common Settings");
		commonSettingsGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false));

		useTerminationCriteria = createButton(commonSettingsGroup,
				"Use termination Criteria", true, SWT.CHECK, null, null);

		runInComparisionMode = createButton(commonSettingsGroup,
				"Run in Comparision Mode", true, SWT.CHECK, null, null);

		Group composedCriteriaGroup = new Group(commonComposite, SWT.NONE);
		composedCriteriaGroup.setLayout(twoBlocksGrid);
		composedCriteriaGroup.setText("Composed Termination Criterion");
		composedCriteriaGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false));

		Group composedExpressionGroup = new Group(commonComposite, SWT.NONE);

		activateComposedCriteria = createButton(composedCriteriaGroup,
				"Activate Composed Termination Criterion", true, SWT.CHECK,
				null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = activateComposedCriteria
								.getSelection();
						expAnd.setEnabled(selected);
						expOr.setEnabled(selected);
						expNot.setEnabled(selected);
						expBrackets.setEnabled(selected);
						expCrit.setEnabled(selected);
						composedExpression.setEnabled(selected);
						expValidate.setEnabled(selected);
						expressionIsValid.setEnabled(selected);
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		composedExpressionGroup.setLayout(this.oneBlocksGrid);
		composedExpressionGroup
				.setText("Composed Termination Criterion Expression");
		composedExpressionGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false));
		composedExpressionGroup.setEnabled(true);

		Group composedExpressionGroupInternal1 = new Group(
				composedExpressionGroup, SWT.None | SWT.SHADOW_NONE);
		composedExpressionGroupInternal1.setLayout(this.fiveBlocksGrid);
		composedExpressionGroupInternal1.setLayoutData(new GridData(SWT.FILL,
				SWT.TOP, true, false));
		composedExpressionGroupInternal1.setEnabled(true);

		expAnd = this.createButton(composedExpressionGroupInternal1, " && ",
				composedExpressionGroupInternal1.isEnabled(), SWT.PUSH, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						StringBuilder currentExpression = new StringBuilder(
								composedExpression.getText());
						currentExpression.insert(composedExpression
								.getCaretPosition(), " && ");
						composedExpression
								.setText(currentExpression.toString());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		expOr = this.createButton(composedExpressionGroupInternal1, " || ",
				composedExpressionGroupInternal1.isEnabled(), SWT.PUSH, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						StringBuilder currentExpression = new StringBuilder(
								composedExpression.getText());
						currentExpression.insert(composedExpression
								.getCaretPosition(), " || ");
						composedExpression
								.setText(currentExpression.toString());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		expNot = this.createButton(composedExpressionGroupInternal1, " ! ",
				composedExpressionGroupInternal1.isEnabled(), SWT.PUSH, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						StringBuilder currentExpression = new StringBuilder(
								composedExpression.getText());
						currentExpression.insert(composedExpression
								.getCaretPosition(), " !");
						composedExpression
								.setText(currentExpression.toString());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		expBrackets = this.createButton(composedExpressionGroupInternal1,
				" ( .. ) ", composedExpressionGroupInternal1.isEnabled(),
				SWT.PUSH, null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						StringBuilder currentExpression = new StringBuilder(
								composedExpression.getText());
						currentExpression.insert(composedExpression
								.getSelection().y, " ) ");
						currentExpression.insert(composedExpression
								.getSelection().x, " ( ");

						composedExpression
								.setText(currentExpression.toString());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		expCrit = this.createButton(composedExpressionGroupInternal1,
				" Criterion ", composedExpressionGroupInternal1.isEnabled(),
				SWT.PUSH, null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final Shell dialog = new Shell(
								minimalQualityCriteriaValueButton.getShell(),
								SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
						dialog.setText("Select a configured Criterion:");
						FormLayout formLayout = new FormLayout();
						formLayout.marginWidth = 10;
						formLayout.marginHeight = 10;
						formLayout.spacing = 10;
						dialog.setLayout(formLayout);

						FormData data = new FormData();
						Label label = createLabel(dialog,
								"Select Termination Criterion: ", true,
								SWT.NONE, data);

						final Combo configuredCriteriaCombo = new Combo(dialog,
								SWT.READ_ONLY);
						configuredCriteriaCombo.setEnabled(true);
						List<String> items = new LinkedList<String>();

						if (maxGenNumActivate.getSelection()) {
							items
									.add(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS
											.name());
						}

						if (elapsedTimeActivate.getSelection()) {
							items.add(TerminationCriteriaNames.ELAPSED_TIME
									.name());
						}

						if (noNewParetoOptimalCandidatesFoundActivate
								.getSelection()) {
							items
									.add(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND
											.name());
						}

						if (paretoOptimalSetStabilityActivate.getSelection()) {
							items
									.add(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY
											.name());
						}

						if (aGivenParetoFrontIsReachedActivate.getSelection()) {
							items
									.add(TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED
											.name());
						}

						if (insignificantParetoFrontChangeActivate
								.getSelection()) {
							items
									.add(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE
											.name());
						}

						if (minimalQualityCriteriaValueActivate.getSelection()) {
							items
									.add(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE
											.name());
						}

						if (insignificantSetQualityImprovementActivate
								.getSelection()) {
							items
									.add(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT
											.name());
						}

						configuredCriteriaCombo.setItems(items
								.toArray(new String[0]));
						configuredCriteriaCombo.select(0);
						data = new FormData();
						data.top = new FormAttachment(label, 0, SWT.DEFAULT);
						configuredCriteriaCombo.setLayoutData(data);

						data = new FormData();
						data.width = 60;
						data.left = new FormAttachment(configuredCriteriaCombo,
								0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);
						Button ok = createButton(dialog, "OK", true, SWT.PUSH,
								data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										StringBuilder currentExpression = new StringBuilder(
												composedExpression.getText());
										currentExpression
												.insert(
														composedExpression
																.getCaretPosition(),
														" "
																+ configuredCriteriaCombo
																		.getItem(configuredCriteriaCombo
																				.getSelectionIndex())
																+ " ");
										composedExpression
												.setText(currentExpression
														.toString());
										TerminationCriteriaTab.this
												.updateLaunchConfigurationDialog();
										dialog.close();
									}
								});

						data = new FormData();
						data.width = 60;
						data.left = new FormAttachment(ok, 0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);
						createButton(dialog, "Cancel", true, SWT.PUSH, data,
								new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										dialog.close();
									}
								});

						dialog.setDefaultButton(ok);
						dialog.pack();
						dialog.open();
					}
				});

		Group composedExpressionGroupInternal2 = new Group(
				composedExpressionGroup, SWT.None | SWT.SHADOW_NONE);
		composedExpressionGroupInternal2.setLayout(this.twoBlocksGrid);
		composedExpressionGroupInternal2.setLayoutData(new GridData(SWT.FILL,
				SWT.TOP, true, false));
		composedExpressionGroupInternal2.setEnabled(true);

		composedExpression = new Text(composedExpressionGroupInternal2,
				SWT.SINGLE | SWT.WRAP | SWT.BORDER);
		composedExpression
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composedExpression.setEnabled(composedExpression.getParent()
				.isEnabled());
		composedExpression.addModifyListener(modifyListener);

		expValidate = this.createButton(composedExpressionGroupInternal2,
				" Normalize And Validate ", composedExpressionGroupInternal2
						.isEnabled(), SWT.PUSH, null, new SelectionAdapter() {
					@Override
					/**
					 * Performs several tests to check the consistency of the boolean expression.
					 * Tests include: Correct usage of &&, || and correct number of brackets.
					 * Check whether all used termination criteria can be located and are active.
					 */
					public void widgetSelected(SelectionEvent e) {

						int expressionSize = composedExpression.getText()
								.length();

						String currentExp = composedExpression.getText()
								.replaceAll("\\s\\s", " ");

						while (currentExp.contains("  ")) {
							currentExp = currentExp.replaceAll("\\s\\s", " ");
						}

						composedExpression.setText(currentExp);

						currentExp = currentExp.replaceAll("&&", "");
						if (currentExp.contains("&")) {
							expressionIsValid
									.setText("Expression is not valid. The ''&&'' is misused. Click Normalize and Validate to refresh.");
							TerminationCriteriaTab.this
									.updateLaunchConfigurationDialog();
							return;
						}

						currentExp = currentExp.replaceAll("\\|\\|", "");
						if (currentExp.contains("|")) {
							expressionIsValid
									.setText("Expression is not valid. The ''||'' is misused. Click Normalize and Validate to refresh.");
							TerminationCriteriaTab.this
									.updateLaunchConfigurationDialog();
							return;
						}

						if ((currentExp.length() - currentExp.replaceAll("\\(",
								"").length()) != (currentExp.length() - currentExp
								.replaceAll("\\)", "").length())) {
							expressionIsValid
									.setText("Expression is not valid. The number of opening and closing brackets do not match. Click Normalize and Validate to refresh.");
							TerminationCriteriaTab.this
									.updateLaunchConfigurationDialog();
							return;
						} else {
							currentExp = currentExp.replaceAll("\\(", "");
							currentExp = currentExp.replaceAll("\\)", "");
						}

						currentExp = currentExp.replaceAll("\\s\\s", " ");

						String[] usedTCUnTrimmed = currentExp.split(" ");

						List<String> usedTCList = new LinkedList<String>();

						for (int i = 0; i < usedTCUnTrimmed.length; i++) {
							String entry = usedTCUnTrimmed[i].trim();

							if (!entry.isEmpty()) {
								usedTCList.add(entry);
							}
						}

						String[] usedTC = usedTCList.toArray(new String[0]);

						if (expressionSize != 0 && usedTC.length == 0) {
							expressionIsValid
									.setText("Expression is not valid. At least one termination criterion must be selected. Click Normalize and Validate to refresh.");
							TerminationCriteriaTab.this
									.updateLaunchConfigurationDialog();
							return;
						}

						for (String crit : usedTC) {

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS
											.name())) {
								if (!maxGenNumActivate.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. MAXIMUM_NUMBER_OF_GENERATIONS is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.ELAPSED_TIME
											.name())) {
								if (!elapsedTimeActivate.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. ELAPSED_TIME is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND
											.name())) {
								if (!noNewParetoOptimalCandidatesFoundActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY
											.name())) {
								if (!paretoOptimalSetStabilityActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. PARETO_OPTIMAL_SET_STABILITY is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED
											.name())) {
								if (!aGivenParetoFrontIsReachedActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. GIVEN_PARETO_FRONT_IS_REACHED is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE
											.name())) {
								if (!insignificantParetoFrontChangeActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. INSIGNIFICANT_PARETO_FRONT_CHANGE is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE
											.name())) {
								if (!minimalQualityCriteriaValueActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. MINIMAL_QUALITY_CIRTERIA_VALUE is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							if (crit
									.equalsIgnoreCase(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT
											.name())) {
								if (!insignificantSetQualityImprovementActivate
										.getSelection()) {
									expressionIsValid
											.setText("Expression is not valid. INSIGNIFICANT_SET_QUALITY_IMPROVEMENT is not activated. Click Normalize and Validate to refresh.");
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
									return;
								}
								continue;
							}

							expressionIsValid
									.setText("Expression is not valid. "
											+ crit
											+ " cannot be recognised as a Termination Criterion.  Click Normalize and Validate to refresh.");
							TerminationCriteriaTab.this
									.updateLaunchConfigurationDialog();
							return;

						}

						expressionIsValid
								.setText("Expression seems to be valid. Note that this check does not guarantee the correctnes of the expression. Click Normalize and Validate to refresh.");
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		this.expressionIsValid = this
				.createLabel(
						composedExpressionGroup,
						"Expression seems to be valid. Click Normalize and Validate to refresh.",
						composedExpressionGroup.isEnabled(), SWT.HORIZONTAL
								| SWT.LEFT, null);

		this.contentMap.put(MENU_COMMON_SETTING, commonComposite);
	}

	/**
	 * Creates a Button
	 * 
	 * @param parent
	 * @param text
	 * @param isEnabled
	 * @param type
	 * @param data
	 *            will not be used if null
	 * @param selectionAdapter
	 *            will not be used if null
	 * @return a new Button
	 */
	private Button createButton(Composite parent, String text,
			boolean isEnabled, int type, FormData data,
			SelectionAdapter selectionAdapter) {
		Button button = new Button(parent, type);
		button.setEnabled(isEnabled);
		button.setText(text);
		if (data != null) {
			button.setLayoutData(data);
		}
		button.addSelectionListener(selectionListener);
		if (selectionAdapter != null) {
			button.addSelectionListener(selectionAdapter);
		}
		return button;
	}

	/**
	 * Creates a Label
	 * 
	 * @param parent
	 * @param text
	 * @param isEnabled
	 * @param style
	 * @param data
	 *            will not be used if null
	 * @return
	 */
	private Label createLabel(Composite parent, String text, boolean isEnabled,
			int style, FormData data) {
		Label label = new Label(parent, style);
		label.setText(text);
		if (data != null) {
			label.setLayoutData(data);
		}
		label.setEnabled(isEnabled);
		return label;
	}

	private void initAndAddMaxGenNumCompositeContent() {
		maxGenNumComposite = new Composite(this.bodyContainer, SWT.TOP);
		maxGenNumComposite.setLayout(new GridLayout());

		this.maxGenNumActivate = this.createButton(this.maxGenNumComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = maxGenNumActivate.getSelection();
						maxGenNumLabel.setEnabled(selected);
						maxGenNumSpinner.setEnabled(selected);
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group maxGenNumSettings = new Group(this.maxGenNumComposite, SWT.NONE);
		maxGenNumSettings.setLayout(this.twoBlocksGrid);
		maxGenNumSettings.setText("Configuration");
		maxGenNumSettings.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false));
		maxGenNumSettings.setEnabled(true);

		this.maxGenNumLabel = this.createLabel(maxGenNumSettings,
				"Maximum number of Generations: ", false, SWT.HORIZONTAL
						| SWT.LEFT, null);

		this.maxGenNumSpinner = new Spinner(maxGenNumSettings, SWT.NONE);
		this.maxGenNumSpinner.setValues(1, 1, Integer.MAX_VALUE, 0, 1, 1);
		this.maxGenNumSpinner.setEnabled(false);

		this.contentMap.put(MENU_MAX_GEN_NUM, maxGenNumComposite);

	}

	private void initAndAddElapsedTimeComposedContent() {
		elapsedTimeComposite = new Composite(this.bodyContainer, SWT.TOP);
		elapsedTimeComposite.setLayout(new GridLayout());

		this.elapsedTimeActivate = this.createButton(this.elapsedTimeComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = elapsedTimeActivate.getSelection();
						elapsedTimeLabel.setEnabled(selected);
						elapsedTimeLabel2.setEnabled(selected);
						elapsedTimeSpinner.setEnabled(selected);
						elapsedTimeCombo.setEnabled(selected);
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group elapsedTimeSettings = new Group(this.elapsedTimeComposite,
				SWT.NONE);
		elapsedTimeSettings.setLayout(this.twoBlocksGrid);
		elapsedTimeSettings.setText("Configuration");
		elapsedTimeSettings.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false));
		elapsedTimeSettings.setEnabled(true);

		this.elapsedTimeLabel = this.createLabel(elapsedTimeSettings,
				"Type of the measured time: ", false,
				SWT.HORIZONTAL | SWT.LEFT, null);

		this.elapsedTimeCombo = new Combo(elapsedTimeSettings, SWT.READ_ONLY);
		this.elapsedTimeCombo.setEnabled(false);
		String[] items = { "USER_TIME", "CPU_TIME" };
		this.elapsedTimeCombo.setItems(items);
		this.elapsedTimeCombo.select(0);

		this.elapsedTimeLabel2 = this.createLabel(elapsedTimeSettings,
				"Time in minutes: ", false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.elapsedTimeSpinner = new Spinner(elapsedTimeSettings, SWT.NONE);
		this.elapsedTimeSpinner.setValues(1, 1, Integer.MAX_VALUE, 0, 1, 1);
		this.elapsedTimeSpinner.setEnabled(false);

		this.contentMap.put(MENU_ELAPSED_TIME, elapsedTimeComposite);

	}

	private void initAndAddNoNewParetoOptimalCandidatesFoundComposedContent() {

		this.noNewParetoOptimalCandidatesFoundComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.noNewParetoOptimalCandidatesFoundComposite
				.setLayout(new GridLayout());

		this.noNewParetoOptimalCandidatesFoundActivate = this.createButton(
				this.noNewParetoOptimalCandidatesFoundComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = noNewParetoOptimalCandidatesFoundActivate
								.getSelection();
						noNewParetoOptimalCandidatesFoundLabel
								.setEnabled(selected);
						noNewParetoOptimalCandidatesFoundSpinner
								.setEnabled(selected);
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group noNewParetoOptimalCandidatesFoundSettings = new Group(
				this.noNewParetoOptimalCandidatesFoundComposite, SWT.NONE);
		noNewParetoOptimalCandidatesFoundSettings.setLayout(this.twoBlocksGrid);
		noNewParetoOptimalCandidatesFoundSettings.setText("Configuration");
		noNewParetoOptimalCandidatesFoundSettings.setLayoutData(new GridData(
				SWT.FILL, SWT.TOP, true, false));
		noNewParetoOptimalCandidatesFoundSettings.setEnabled(true);

		this.noNewParetoOptimalCandidatesFoundLabel = this
				.createLabel(
						noNewParetoOptimalCandidatesFoundSettings,
						"Number of iterations without a new Pareto Optimal candidate: ",
						false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.noNewParetoOptimalCandidatesFoundSpinner = new Spinner(
				noNewParetoOptimalCandidatesFoundSettings, SWT.NONE);
		this.noNewParetoOptimalCandidatesFoundSpinner.setValues(1, 1,
				Integer.MAX_VALUE, 0, 1, 1);
		this.noNewParetoOptimalCandidatesFoundSpinner.setEnabled(false);

		this.contentMap.put(MENU_NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND,
				noNewParetoOptimalCandidatesFoundComposite);

	}

	private void initAndAddParetoOptimalSetStabilityComposedContent() {

		this.paretoOptimalSetStabilityComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.paretoOptimalSetStabilityComposite.setLayout(new GridLayout());

		this.paretoOptimalSetStabilityActivate = this.createButton(
				this.paretoOptimalSetStabilityComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = paretoOptimalSetStabilityActivate
								.getSelection();
						paretoOptimalSetStabilityLabel.setEnabled(selected);
						paretoOptimalSetStabilityCombo.setEnabled(selected);
						paretoOptimalSetStabilityLabel1.setEnabled(selected);
						paretoOptimalSetStabilitySpinner.setEnabled(selected);
						paretoOptimalSetStabilityLabel2.setEnabled(selected);
						paretoOptimalSetStabilitySpinner1.setEnabled(selected);
						paretoOptimalSetStabilityLabel3.setEnabled(selected);
						paretoOptimalSetStabilitySpinner2.setEnabled(selected);

						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group paretoOptimalSetStabilitySettings = new Group(
				this.paretoOptimalSetStabilityComposite, SWT.NONE);
		paretoOptimalSetStabilitySettings.setLayout(this.twoBlocksGrid);
		paretoOptimalSetStabilitySettings.setText("Configuration");
		paretoOptimalSetStabilitySettings.setLayoutData(new GridData(SWT.FILL,
				SWT.TOP, true, false));
		paretoOptimalSetStabilitySettings.setEnabled(true);

		this.paretoOptimalSetStabilityLabel = this.createLabel(
				paretoOptimalSetStabilitySettings, "Evaluation Mode: ", false,
				SWT.HORIZONTAL | SWT.LEFT, null);

		this.paretoOptimalSetStabilityCombo = new Combo(
				paretoOptimalSetStabilitySettings, SWT.READ_ONLY);
		this.paretoOptimalSetStabilityCombo.setEnabled(false);
		String[] items = { "EXACT_NUMBER", "PERCENTAGE" };
		this.paretoOptimalSetStabilityCombo.setItems(items);
		this.paretoOptimalSetStabilityCombo.select(0);

		this.paretoOptimalSetStabilityLabel1 = this.createLabel(
				paretoOptimalSetStabilitySettings,
				"Minimum Iterations to survive: ", false, SWT.HORIZONTAL
						| SWT.LEFT, null);

		this.paretoOptimalSetStabilitySpinner = new Spinner(
				paretoOptimalSetStabilitySettings, SWT.NONE);
		this.paretoOptimalSetStabilitySpinner.setValues(2, 2,
				Integer.MAX_VALUE, 0, 1, 1);
		this.paretoOptimalSetStabilitySpinner.setEnabled(false);

		this.paretoOptimalSetStabilityLabel2 = this.createLabel(
				paretoOptimalSetStabilitySettings,
				"Exact number of survivers: ", false,
				SWT.HORIZONTAL | SWT.LEFT, null);

		this.paretoOptimalSetStabilitySpinner1 = new Spinner(
				paretoOptimalSetStabilitySettings, SWT.NONE);
		this.paretoOptimalSetStabilitySpinner1.setValues(1, 1,
				Integer.MAX_VALUE, 0, 1, 1);
		this.paretoOptimalSetStabilitySpinner1.setEnabled(false);

		this.paretoOptimalSetStabilityLabel3 = this.createLabel(
				paretoOptimalSetStabilitySettings,
				"Number of survives in percentage: ", false, SWT.HORIZONTAL
						| SWT.LEFT, null);

		this.paretoOptimalSetStabilitySpinner2 = new Spinner(
				paretoOptimalSetStabilitySettings, SWT.NONE);
		this.paretoOptimalSetStabilitySpinner2.setValues(0, 0, 100, 0, 1, 1);
		this.paretoOptimalSetStabilitySpinner2.setEnabled(false);

		this.contentMap.put(MENU_PARETO_OPTIMAL_SET_STABILITY,
				paretoOptimalSetStabilityComposite);

	}

	private void initAndAddAGivenParetoFrontIsReachedComposedContent() {

		this.aGivenParetoFrontIsReachedComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.aGivenParetoFrontIsReachedComposite.setLayout(new GridLayout());

		this.aGivenParetoFrontIsReachedActivate = this.createButton(
				this.aGivenParetoFrontIsReachedComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = aGivenParetoFrontIsReachedActivate
								.getSelection();
						aGivenParetoFrontIsReachedLabel.setEnabled(selected);
						aGivenParetoFrontIsReachedSpinner.setEnabled(selected);
						aGivenParetoFrontIsReachedLabel1.setEnabled(selected);
						aGivenParetoFrontIsReachedText.setEnabled(selected);
						aGivenParetoFrontIsReachedBrowse.setEnabled(selected);

						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group aGivenParetoFrontIsReachedSettings = new Group(
				this.aGivenParetoFrontIsReachedComposite, SWT.NONE);
		aGivenParetoFrontIsReachedSettings.setLayout(this.threeBlocksGrid);
		aGivenParetoFrontIsReachedSettings.setText("Configuration");
		aGivenParetoFrontIsReachedSettings.setLayoutData(new GridData(SWT.FILL,
				SWT.TOP, true, false));
		aGivenParetoFrontIsReachedSettings.setEnabled(true);

		this.aGivenParetoFrontIsReachedLabel = this.createLabel(
				aGivenParetoFrontIsReachedSettings, "Percentages to cover: ",
				false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.aGivenParetoFrontIsReachedSpinner = new Spinner(
				aGivenParetoFrontIsReachedSettings, SWT.NONE);
		this.aGivenParetoFrontIsReachedSpinner.setValues(1, 1, 100, 0, 1, 1);
		this.aGivenParetoFrontIsReachedSpinner.setEnabled(false);

		(this.createLabel(aGivenParetoFrontIsReachedSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.aGivenParetoFrontIsReachedLabel1 = this.createLabel(
				aGivenParetoFrontIsReachedSettings, "Targeted Pareto Front: ",
				false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.aGivenParetoFrontIsReachedText = new Text(
				aGivenParetoFrontIsReachedSettings, SWT.SINGLE | SWT.BORDER);
		this.aGivenParetoFrontIsReachedText.setEnabled(false);
		this.aGivenParetoFrontIsReachedText.addModifyListener(modifyListener);

		this.aGivenParetoFrontIsReachedBrowse = this.createButton(
				aGivenParetoFrontIsReachedSettings, "Browse", false, SWT.PUSH,
				null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						aGivenParetoFrontIsReachedFileDialog = new FileDialog(
								aGivenParetoFrontIsReachedBrowse.getShell());
						aGivenParetoFrontIsReachedText
								.setText(aGivenParetoFrontIsReachedFileDialog
										.open());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		this.contentMap.put(MENU_A_GIVEN_PARETO_FRONT_IS_REACHED,
				aGivenParetoFrontIsReachedComposite);

	}

	private void initAndAddInsignificantParetoFrontChangeContent() {

		this.insignificantParetoFrontChangeComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.insignificantParetoFrontChangeComposite
				.setLayout(new GridLayout());

		this.insignificantParetoFrontChangeActivate = this.createButton(
				this.insignificantParetoFrontChangeComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = insignificantParetoFrontChangeActivate
								.getSelection();
						insignificantParetoFrontChangeLabel
								.setEnabled(selected);
						insignificantParetoFrontChangeSpinner
								.setEnabled(selected);
						insignificantParetoFrontChangeLabel1
								.setEnabled(selected);
						insignificantParetoFrontChangeLabel2
								.setEnabled(selected);
						insignificantParetoFrontChangeSpinner1
								.setEnabled(selected);

						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group insignificantParetoFrontChangeSettings = new Group(
				this.insignificantParetoFrontChangeComposite, SWT.NONE);
		insignificantParetoFrontChangeSettings.setLayout(this.threeBlocksGrid);
		insignificantParetoFrontChangeSettings.setText("Configuration");
		insignificantParetoFrontChangeSettings.setLayoutData(new GridData(
				SWT.FILL, SWT.TOP, true, false));
		insignificantParetoFrontChangeSettings.setEnabled(true);

		this.insignificantParetoFrontChangeLabel = this.createLabel(
				insignificantParetoFrontChangeSettings, "Number of the n -  ",
				false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.insignificantParetoFrontChangeSpinner = new Spinner(
				insignificantParetoFrontChangeSettings, SWT.NONE);
		this.insignificantParetoFrontChangeSpinner
				.setValues(1, 1, 100, 0, 1, 1);
		this.insignificantParetoFrontChangeSpinner.setEnabled(false);

		this.insignificantParetoFrontChangeLabel1 = this.createLabel(
				insignificantParetoFrontChangeSettings, " generation.", false,
				SWT.HORIZONTAL | SWT.LEFT, null);

		this.insignificantParetoFrontChangeLabel2 = this.createLabel(
				insignificantParetoFrontChangeSettings,
				"Minimum improvement (Persentage value);", false,
				SWT.HORIZONTAL | SWT.LEFT, null);

		this.insignificantParetoFrontChangeSpinner1 = new Spinner(
				insignificantParetoFrontChangeSettings, SWT.NONE);
		this.insignificantParetoFrontChangeSpinner1.setValues(1, 1, 100, 0, 1,
				1);
		this.insignificantParetoFrontChangeSpinner1.setEnabled(false);

		this.contentMap.put(MENU_INSIGNIFICANT_PARETO_FRONT_CHANGE,
				insignificantParetoFrontChangeComposite);

	}

	private void initAndAddMinimalQualityCriteriaValueContent() {

		this.minimalQualityCriteriaValueComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.minimalQualityCriteriaValueComposite.setLayout(new GridLayout());

		this.minimalQualityCriteriaValueActivate = this.createButton(
				this.minimalQualityCriteriaValueComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = minimalQualityCriteriaValueActivate
								.getSelection();
						minimalQualityCriteriaValueLabel.setEnabled(selected);
						minimalQualityCriteriaValueSpinner.setEnabled(selected);
						minimalQualityCriteriaValueLabel1.setEnabled(selected);
						minimalQualityCriteriaValueTable.setEnabled(selected);
						minimalQualityCriteriaValueButton.setEnabled(selected);
						minimalQualityCriteriaValueButton1.setEnabled(selected);
						minimalQualityCriteriaValueButton2.setEnabled(selected);

						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group minimalQualityCriteriaValueSettings = new Group(
				this.minimalQualityCriteriaValueComposite, SWT.NONE);
		minimalQualityCriteriaValueSettings.setLayout(this.threeBlocksGrid);
		minimalQualityCriteriaValueSettings.setText("Configuration");
		minimalQualityCriteriaValueSettings.setLayoutData(new GridData(
				SWT.FILL, SWT.TOP, true, false));
		minimalQualityCriteriaValueSettings.setEnabled(true);

		this.minimalQualityCriteriaValueLabel = this.createLabel(
				minimalQualityCriteriaValueSettings,
				"Number of candidates to conform: ", false, SWT.HORIZONTAL
						| SWT.LEFT, null);

		this.minimalQualityCriteriaValueSpinner = new Spinner(
				minimalQualityCriteriaValueSettings, SWT.NONE);
		this.minimalQualityCriteriaValueSpinner.setValues(1, 1,
				Integer.MAX_VALUE, 0, 1, 1);
		this.minimalQualityCriteriaValueSpinner.setEnabled(false);

		(this.createLabel(minimalQualityCriteriaValueSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.minimalQualityCriteriaValueLabel1 = this.createLabel(
				minimalQualityCriteriaValueSettings, "Configured Objectives.",
				false, SWT.HORIZONTAL | SWT.LEFT, null);

		(this.createLabel(minimalQualityCriteriaValueSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);
		(this.createLabel(minimalQualityCriteriaValueSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.minimalQualityCriteriaValueTable = new Table(
				minimalQualityCriteriaValueSettings, SWT.BORDER | SWT.V_SCROLL
						| SWT.H_SCROLL);

		TableColumn tc1 = new TableColumn(
				this.minimalQualityCriteriaValueTable, SWT.CENTER);
		TableColumn tc2 = new TableColumn(
				this.minimalQualityCriteriaValueTable, SWT.CENTER);
		tc1.setText("Objective");
		tc2.setText("Min Value");
		tc1.setWidth(150);
		tc2.setWidth(150);
		this.minimalQualityCriteriaValueTable.setHeaderVisible(true);
		this.minimalQualityCriteriaValueTable.setEnabled(false);

		Group minimalQualityCriteriaValueSettingsButtons = new Group(
				minimalQualityCriteriaValueSettings, SWT.NONE);
		minimalQualityCriteriaValueSettingsButtons
				.setLayout(this.oneBlocksGrid);
		minimalQualityCriteriaValueSettingsButtons.setLayoutData(new GridData(
				SWT.FILL, SWT.TOP, false, false));
		minimalQualityCriteriaValueSettingsButtons.setEnabled(true);

		(this.createLabel(minimalQualityCriteriaValueSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.minimalQualityCriteriaValueButton = this.createButton(
				minimalQualityCriteriaValueSettingsButtons, "Add Objective",
				false, SWT.PUSH, null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final Shell dialog = new Shell(
								minimalQualityCriteriaValueButton.getShell(),
								SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
						dialog.setText("Configure an objective");
						FormLayout formLayout = new FormLayout();
						formLayout.marginWidth = 10;
						formLayout.marginHeight = 10;
						formLayout.spacing = 10;
						dialog.setLayout(formLayout);

						FormData data = new FormData();

						Label label = createLabel(dialog, "Select Objective: ",
								true, SWT.NONE, data);

						final Combo objectivesCombo = new Combo(dialog,
								SWT.READ_ONLY);
						objectivesCombo.setEnabled(true);

						List<EvaluationAspectWithContext> objectivesList = qmlManager.getActivatedObjectives();

						String[] items = new String[objectivesList.size()];
						for (int index = 0; index < objectivesList.size(); index++) {
							items[index] = objectivesList.get(index).getCriterion().getDimension().getEntityName() + "-" + objectivesList.get(index).getCriterion().getId();
						}
						objectivesCombo.setItems(items);
						objectivesCombo.select(0);
						data = new FormData();
						data.top = new FormAttachment(label, 0, SWT.DEFAULT);
						objectivesCombo.setLayoutData(data);

						data = new FormData();
						data.left = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label1 = createLabel(dialog, "Minimal Value:",
								true, SWT.NONE, data);

						final Spinner minimalSpinner = new Spinner(dialog,
								SWT.NONE);
						minimalSpinner.setValues(0, 0, Integer.MAX_VALUE, 0, 1,
								1);
						minimalSpinner.setEnabled(true);
						data = new FormData();
						data.top = new FormAttachment(label1, 0, SWT.DEFAULT);
						data.left = new FormAttachment(objectivesCombo, 0,
								SWT.DEFAULT);
						minimalSpinner.setLayoutData(data);

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(100, 0);
						data.bottom = new FormAttachment(100, 0);
						data.top = new FormAttachment(minimalSpinner, 0,
								SWT.DEFAULT);
						Button cancel = createButton(dialog, "Cancel", true,
								SWT.PUSH, data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										dialog.close();
									}
								});

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(cancel, 0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);
						Button ok = createButton(dialog, "OK", true, SWT.PUSH,data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										new TableItem(TerminationCriteriaTab.this.minimalQualityCriteriaValueTable,SWT.NONE).setText(new String[] {objectivesCombo.getItem(objectivesCombo.getSelectionIndex()),Integer.toString(minimalSpinner.getSelection()) });
										dialog.close();
										TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
									}
								});

						dialog.setDefaultButton(ok);
						dialog.pack();
						dialog.open();
					}
				});

		this.minimalQualityCriteriaValueButton1 = this.createButton(
				minimalQualityCriteriaValueSettingsButtons, "Edit Objective",
				false, SWT.PUSH, null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final Shell dialog = new Shell(minimalQualityCriteriaValueButton1.getShell(),SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
						int itemIndex = TerminationCriteriaTab.this.minimalQualityCriteriaValueTable.getSelectionIndex();

						if (itemIndex < 0) {
							dialog.dispose();
							return;
						}

						final TableItem item = TerminationCriteriaTab.this.minimalQualityCriteriaValueTable
								.getItem(itemIndex);

						dialog.setText("Edit an objective");
						FormLayout formLayout = new FormLayout();
						formLayout.marginWidth = 10;
						formLayout.marginHeight = 10;
						formLayout.spacing = 10;
						dialog.setLayout(formLayout);

						FormData data = new FormData();
						Label label = createLabel(dialog, "Select Objective: ",true, SWT.NONE, data);

						data = new FormData();
						data.top = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label3 = createLabel(dialog, item.getText(0),true, SWT.NONE, data);

						data = new FormData();
						data.left = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label1 = createLabel(dialog, "Minimal Value:",true, SWT.NONE, data);

						final Spinner minimalSpinner = new Spinner(dialog, SWT.NONE);
						minimalSpinner.setValues(0, 0, Integer.MAX_VALUE, 0, 1, 1);
						minimalSpinner.setEnabled(true);
						minimalSpinner.setSelection(Integer.parseInt(item.getText(1)));
						data = new FormData();
						data.top = new FormAttachment(label1, 0, SWT.DEFAULT);
						data.left = new FormAttachment(label3, 0, SWT.DEFAULT);
						minimalSpinner.setLayoutData(data);

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(100, 0);
						data.bottom = new FormAttachment(100, 0);
						data.top = new FormAttachment(minimalSpinner, 0, SWT.DEFAULT);
						Button cancel = createButton(dialog, "Cancel", true,SWT.PUSH, data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										dialog.close();
									}
								});

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(cancel, 0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);

						Button ok = createButton(dialog, "OK", true, SWT.PUSH, data, new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									item.setText(1, Integer
											.toString(minimalSpinner
													.getSelection()));
									dialog.close();
									TerminationCriteriaTab.this
											.updateLaunchConfigurationDialog();
								}
							});

						dialog.setDefaultButton(ok);
						dialog.pack();
						dialog.open();
					}
				});

		this.minimalQualityCriteriaValueButton2 = this.createButton(minimalQualityCriteriaValueSettingsButtons, "Remove Objective",	false, SWT.PUSH, null, new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					TerminationCriteriaTab.this.minimalQualityCriteriaValueTable.remove(TerminationCriteriaTab.this.minimalQualityCriteriaValueTable.getSelectionIndices());
					TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
				}
			});

		this.contentMap.put(MENU_MINIMAL_QUALITY_CRITERIA_VALUE,
				minimalQualityCriteriaValueComposite);

	}

	private void initAndAddInsignificantSetQualityImprovementContent() {

		this.insignificantSetQualityImprovementComposite = new Composite(
				this.bodyContainer, SWT.TOP);
		this.insignificantSetQualityImprovementComposite
				.setLayout(new GridLayout());

		this.insignificantSetQualityImprovementActivate = this.createButton(
				insignificantSetQualityImprovementComposite,
				"Activate this criterion", true, SWT.CHECK, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// enable level and half-with fields if and only if
						// check
						// box is checked
						boolean selected = insignificantSetQualityImprovementActivate
								.getSelection();
						insignificantSetQualityImprovementLabel
								.setEnabled(selected);
						insignificantSetQualityImprovementSpinner
								.setEnabled(selected);
						insignificantSetQualityImprovementLabel1
								.setEnabled(selected);
						insignificantSetQualityImprovementLabel2
								.setEnabled(selected);
						insignificantSetQualityImprovementTable
								.setEnabled(selected);
						insignificantSetQualityImprovementButton
								.setEnabled(selected);
						insignificantSetQualityImprovementButton1
								.setEnabled(selected);
						insignificantSetQualityImprovementButton2
								.setEnabled(selected);
						insignificantSetQualityImprovementTable
								.setEnabled(selected);

						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}

				});

		Group insignificantSetQualityImprovementSettings = new Group(
				this.insignificantSetQualityImprovementComposite, SWT.NONE);
		insignificantSetQualityImprovementSettings
				.setLayout(this.threeBlocksGrid);
		insignificantSetQualityImprovementSettings.setText("Configuration");
		insignificantSetQualityImprovementSettings.setLayoutData(new GridData(
				SWT.FILL, SWT.TOP, true, false));
		insignificantSetQualityImprovementSettings.setEnabled(true);

		Group insignificantSetQualityImprovementSettingsInternal = new Group(
				insignificantSetQualityImprovementSettings, SWT.NONE);
		insignificantSetQualityImprovementSettingsInternal
				.setLayout(this.threeBlocksGrid);
		insignificantSetQualityImprovementSettingsInternal
				.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		insignificantSetQualityImprovementSettingsInternal.setEnabled(true);

		this.insignificantSetQualityImprovementLabel = this.createLabel(
				insignificantSetQualityImprovementSettingsInternal,
				"Number of the n -  ", false, SWT.HORIZONTAL | SWT.LEFT, null);

		this.insignificantSetQualityImprovementSpinner = new Spinner(
				insignificantSetQualityImprovementSettingsInternal, SWT.NONE);
		this.insignificantSetQualityImprovementSpinner.setValues(1, 1, 100, 0,
				1, 1);
		this.insignificantSetQualityImprovementSpinner.setEnabled(false);

		this.insignificantSetQualityImprovementLabel1 = this.createLabel(insignificantSetQualityImprovementSettingsInternal," generation.", false, SWT.HORIZONTAL | SWT.LEFT, null);

		(this.createLabel(insignificantSetQualityImprovementSettings, "", true,	SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);
		(this.createLabel(insignificantSetQualityImprovementSettings, "", true,	SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.insignificantSetQualityImprovementLabel2 = this.createLabel(insignificantSetQualityImprovementSettings, "Configured Objectives.", false, SWT.HORIZONTAL | SWT.LEFT, null);

		(this.createLabel(insignificantSetQualityImprovementSettings, "", true,	SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);
		(this.createLabel(insignificantSetQualityImprovementSettings, "", true,	SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.insignificantSetQualityImprovementTable = new Table(insignificantSetQualityImprovementSettings, SWT.BORDER	| SWT.V_SCROLL | SWT.H_SCROLL);

		TableColumn tc1 = new TableColumn(
				this.insignificantSetQualityImprovementTable, SWT.CENTER);
		TableColumn tc2 = new TableColumn(
				this.insignificantSetQualityImprovementTable, SWT.CENTER);
		TableColumn tc3 = new TableColumn(
				this.insignificantSetQualityImprovementTable, SWT.CENTER);
		tc1.setText("Objective");
		tc2.setText("Average Improvemenr");
		tc3.setText("Max/Min Value");
		tc1.setWidth(150);
		tc2.setWidth(150);
		tc3.setWidth(150);
		this.insignificantSetQualityImprovementTable.setHeaderVisible(true);
		this.insignificantSetQualityImprovementTable.setEnabled(false);

		Group insignificantSetQualityImprovementSettingsButtons = new Group(
				insignificantSetQualityImprovementSettings, SWT.NONE);
		insignificantSetQualityImprovementSettingsButtons
				.setLayout(this.oneBlocksGrid);
		insignificantSetQualityImprovementSettingsButtons
				.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		insignificantSetQualityImprovementSettingsButtons.setEnabled(true);

		(this.createLabel(insignificantSetQualityImprovementSettings, "", true,
				SWT.HORIZONTAL | SWT.LEFT, null)).setVisible(false);

		this.insignificantSetQualityImprovementButton = this.createButton(
				insignificantSetQualityImprovementSettingsButtons,
				"Add Objective", false, SWT.PUSH, null, new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final Shell dialog = new Shell(
								insignificantSetQualityImprovementButton
										.getShell(), SWT.DIALOG_TRIM
										| SWT.APPLICATION_MODAL);
						dialog.setText("Configure an objective");
						FormLayout formLayout = new FormLayout();
						formLayout.marginWidth = 10;
						formLayout.marginHeight = 10;
						formLayout.spacing = 10;
						dialog.setLayout(formLayout);

						FormData data = new FormData();

						Label label = createLabel(dialog, "Select Objective: ",
								true, SWT.NONE, data);

						final Combo objectivesCombo = new Combo(dialog,
								SWT.READ_ONLY);
						objectivesCombo.setEnabled(true);

						List<EvaluationAspectWithContext> objectivesList = qmlManager.getActivatedObjectives();

						String[] items = new String[objectivesList.size()];
						for (int index = 0; index < objectivesList.size(); index++) {
							items[index] = objectivesList.get(index).getCriterion().getDimension().getEntityName() + "-" + objectivesList.get(index).getCriterion().getId();
						}

						objectivesCombo.setItems(items);
						objectivesCombo.select(0);
						data = new FormData();
						data.top = new FormAttachment(label, 0, SWT.DEFAULT);
						objectivesCombo.setLayoutData(data);

						data = new FormData();
						data.left = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label1 = createLabel(dialog,
								"Average Improvement:", true, SWT.NONE, data);

						final Spinner averageSpinner = new Spinner(dialog,
								SWT.NONE);
						averageSpinner.setValues(1, 1, 100, 0, 1, 1);
						averageSpinner.setEnabled(true);
						data = new FormData();
						data.top = new FormAttachment(label1, 0, SWT.DEFAULT);
						data.left = new FormAttachment(objectivesCombo, 0,
								SWT.DEFAULT);
						averageSpinner.setLayoutData(data);

						data = new FormData();
						data.left = new FormAttachment(label1, 0, SWT.DEFAULT);
						Label label2 = createLabel(dialog,
								"Min/Max Improvement:", true, SWT.NONE, data);

						final Spinner minMaxSpinner = new Spinner(dialog,
								SWT.NONE);
						minMaxSpinner.setValues(1, 1, 100, 0, 1, 1);
						minMaxSpinner.setEnabled(true);
						data = new FormData();
						data.top = new FormAttachment(label2, 0, SWT.DEFAULT);
						data.left = new FormAttachment(averageSpinner, 0,
								SWT.DEFAULT);
						minMaxSpinner.setLayoutData(data);

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(100, 0);
						data.bottom = new FormAttachment(100, 0);
						data.top = new FormAttachment(minMaxSpinner, 0,
								SWT.DEFAULT);

						Button cancel = createButton(dialog, "Cancel", true,
								SWT.PUSH, data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										dialog.close();
									}
								});

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(cancel, 0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);
						Button ok = createButton(dialog, "OK", true, SWT.PUSH,
								data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										new TableItem(TerminationCriteriaTab.this.insignificantSetQualityImprovementTable,SWT.NONE)
												.setText(new String[] {	objectivesCombo.getItem(objectivesCombo.getSelectionIndex()),
														Integer.toString(averageSpinner.getSelection()),Integer.toString(minMaxSpinner.getSelection()) });
										dialog.close();
										TerminationCriteriaTab.this.updateLaunchConfigurationDialog();
									}
								});

						dialog.setDefaultButton(ok);
						dialog.pack();
						dialog.open();
					}
				});

		this.insignificantSetQualityImprovementButton1 = this.createButton(
				insignificantSetQualityImprovementSettingsButtons,
				"Edit Objective", false, SWT.PUSH, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final Shell dialog = new Shell(
								insignificantSetQualityImprovementButton
										.getShell(), SWT.DIALOG_TRIM
										| SWT.APPLICATION_MODAL);
						int itemIndex = TerminationCriteriaTab.this.insignificantSetQualityImprovementTable
								.getSelectionIndex();

						if (itemIndex < 0) {
							dialog.dispose();
							return;
						}

						final TableItem item = TerminationCriteriaTab.this.insignificantSetQualityImprovementTable
								.getItem(itemIndex);

						dialog.setText("Edit an objective");
						FormLayout formLayout = new FormLayout();
						formLayout.marginWidth = 10;
						formLayout.marginHeight = 10;
						formLayout.spacing = 10;
						dialog.setLayout(formLayout);

						FormData data = new FormData();
						Label label = createLabel(dialog, "Select Objective: ",
								true, SWT.NONE, data);

						data = new FormData();
						data.top = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label3 = createLabel(dialog, item.getText(0),
								true, SWT.NONE, data);

						data = new FormData();
						data.left = new FormAttachment(label, 0, SWT.DEFAULT);
						Label label1 = createLabel(dialog,
								"Average Improvement:", true, SWT.NONE, data);

						final Spinner averageSpinner = new Spinner(dialog,
								SWT.NONE);
						averageSpinner.setValues(1, 1, 100, 0, 1, 1);
						averageSpinner.setEnabled(true);
						averageSpinner.setSelection(Integer.parseInt(item
								.getText(1)));
						data = new FormData();
						data.top = new FormAttachment(label1, 0, SWT.DEFAULT);
						data.left = new FormAttachment(label3, 0, SWT.DEFAULT);
						averageSpinner.setLayoutData(data);

						data = new FormData();
						data.left = new FormAttachment(label1, 0, SWT.DEFAULT);
						Label label2 = createLabel(dialog,
								"Min/Max Improvement:", true, SWT.NONE, data);

						final Spinner minMaxSpinner = new Spinner(dialog,
								SWT.NONE);
						minMaxSpinner.setValues(1, 1, 100, 0, 1, 1);
						minMaxSpinner.setEnabled(true);
						minMaxSpinner.setSelection(Integer.parseInt(item
								.getText(2)));
						data = new FormData();
						data.top = new FormAttachment(label2, 0, SWT.DEFAULT);
						data.left = new FormAttachment(averageSpinner, 0,
								SWT.DEFAULT);
						minMaxSpinner.setLayoutData(data);

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(100, 0);
						data.bottom = new FormAttachment(100, 0);
						data.top = new FormAttachment(minMaxSpinner, 0,
								SWT.DEFAULT);
						Button cancel = createButton(dialog, "Cencel", true,
								SWT.PUSH, data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										dialog.close();
									}
								});

						data = new FormData();
						data.width = 60;
						data.right = new FormAttachment(cancel, 0, SWT.DEFAULT);
						data.bottom = new FormAttachment(100, 0);
						Button ok = createButton(dialog, "OK", true, SWT.PUSH,
								data, new SelectionAdapter() {
									@Override
									public void widgetSelected(SelectionEvent e) {
										item.setText(1, Integer
												.toString(averageSpinner
														.getSelection()));
										item.setText(2, Integer
												.toString(minMaxSpinner
														.getSelection()));
										dialog.close();
										TerminationCriteriaTab.this
												.updateLaunchConfigurationDialog();
									}
								});

						dialog.setDefaultButton(ok);
						dialog.pack();
						dialog.open();
					}
				});

		this.insignificantSetQualityImprovementButton2 = this.createButton(
				insignificantSetQualityImprovementSettingsButtons,
				"Remove Selected", false, SWT.PUSH, null,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						TerminationCriteriaTab.this.insignificantSetQualityImprovementTable
								.remove(TerminationCriteriaTab.this.insignificantSetQualityImprovementTable
										.getSelectionIndices());
						TerminationCriteriaTab.this
								.updateLaunchConfigurationDialog();
					}
				});

		this.contentMap.put(MENU_INSIGNIFICANT_SET_QUALITY_IMPROVEMENT,
				insignificantSetQualityImprovementComposite);

	}

	@Override
	public String getName() {
		return TAB_NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// General
		try {
			this.useTerminationCriteria
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_GENERAL_USE_TERMINATION_CRITERIA,
									false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_GENERAL_USE_TERMINATION_CRITERIA,
					e.getMessage());
		}

		try {
			this.runInComparisionMode.setSelection(configuration.getAttribute(
					DSEConstantsContainer.TC_GENERAL_COMPARISION_MODE, false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_GENERAL_COMPARISION_MODE, e
							.getMessage());
		}

		// Composed Criteria
		try {
			this.activateComposedCriteria
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_COMPOSED_CRITERIA_ACTIVATE,
									false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_COMPOSED_CRITERIA_ACTIVATE, e
							.getMessage());
		}

		try {
			this.composedExpression.setText(configuration.getAttribute(
					DSEConstantsContainer.TC_COMPOSED_CRITERIA_EXPRESSION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_COMPOSED_CRITERIA_EXPRESSION, e
							.getMessage());
		}

		// Maximum Generation Number Criterion
		try {
			this.maxGenNumActivate.setSelection(configuration.getAttribute(
					DSEConstantsContainer.TC_MAX_NUM_OF_GEN_ACTIVATE, false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_MAX_NUM_OF_GEN_ACTIVATE, e
							.getMessage());
		}

		try {
			this.maxGenNumSpinner.setSelection(configuration.getAttribute(
					DSEConstantsContainer.TC_MAX_NUM_OF_GEN_LIMIT, 1));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_MAX_NUM_OF_GEN_LIMIT, e
							.getMessage());
		}

		// Elapsed Time Criterion
		try {
			this.elapsedTimeActivate.setSelection(configuration.getAttribute(
					DSEConstantsContainer.TC_ELAPSED_TIME_ACTIVATE, false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_ELAPSED_TIME_ACTIVATE, e
							.getMessage());
		}

		try {
			if (!configuration.getAttribute(
					DSEConstantsContainer.TC_ELAPSED_TIME_TYPE, "USER_TIME")
					.equalsIgnoreCase("CPU_TIME")) {
				this.elapsedTimeCombo.select(0);
			} else {
				this.elapsedTimeCombo.select(1);
			}
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_ELAPSED_TIME_TYPE, e.getMessage());
		}

		try {
			this.elapsedTimeSpinner.setSelection(configuration.getAttribute(
					DSEConstantsContainer.TC_ELAPSED_TIME_TIME_LIMIT, 1));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_ELAPSED_TIME_TIME_LIMIT, e
							.getMessage());
		}

		// No New Pareto Optimal Candidates Found Criterion
		try {
			this.noNewParetoOptimalCandidatesFoundActivate
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ACTIVATE,
									false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ACTIVATE, e
							.getMessage());
		}

		try {
			this.noNewParetoOptimalCandidatesFoundSpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ITERATIONS_WITHOUT,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ITERATIONS_WITHOUT,
							e.getMessage());
		}

		// Pareto Optimal Set Stability
		try {
			this.paretoOptimalSetStabilityActivate.setSelection(configuration
					.getAttribute(
							DSEConstantsContainer.TC_SET_STABILITY_ACTIVATE,
							false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_SET_STABILITY_ACTIVATE, e
							.getMessage());
		}

		try {
			if (!configuration
					.getAttribute(DSEConstantsContainer.TC_SET_STABILITY_MODE,
							"EXACT_NUMBER").equalsIgnoreCase("PERCENTAGE")) {
				this.paretoOptimalSetStabilityCombo.select(0);
			} else {
				this.paretoOptimalSetStabilityCombo.select(1);
			}
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(getName(),
							DSEConstantsContainer.TC_SET_STABILITY_MODE, e
									.getMessage());
		}

		try {
			this.paretoOptimalSetStabilitySpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_SET_STABILITY_MINIMUM_ITERATION_TO_SURVIVE,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_SET_STABILITY_MINIMUM_ITERATION_TO_SURVIVE,
							e.getMessage());
		}

		try {
			this.paretoOptimalSetStabilitySpinner1
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_EXACT,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_EXACT,
							e.getMessage());
		}

		try {
			this.paretoOptimalSetStabilitySpinner2
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_PERCENTAGE,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_PERCENTAGE,
							e.getMessage());
		}

		// Minimal Quality Criteria Value
		try {
			this.minimalQualityCriteriaValueActivate.setSelection(configuration
					.getAttribute(
							DSEConstantsContainer.TC_MINIMAL_VALUES_ACTIVATE,
							false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_MINIMAL_VALUES_ACTIVATE, e
							.getMessage());
		}

		try {
			this.minimalQualityCriteriaValueSpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_MINIMAL_VALUES_CANDIDATES_TO_CONFORM,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_MINIMAL_VALUES_CANDIDATES_TO_CONFORM,
							e.getMessage());
		}

		this.minimalQualityCriteriaValueTable.removeAll();

		String tableItems = "";

		try {
			tableItems = configuration
					.getAttribute(
							DSEConstantsContainer.TC_MINIMAL_VALUES_CONFIGURED_OBJECTIVES,
							"");
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_MINIMAL_VALUES_CONFIGURED_OBJECTIVES,
							e.getMessage());
		}

		if (!tableItems.isEmpty()) {
			String[] items = tableItems.split(";");
			for (String item : items) {
				String[] values = item.split("\\|");
				new TableItem(this.minimalQualityCriteriaValueTable, SWT.NONE)
						.setText(new String[] { values[0], values[1] });
			}
		}

		// A Given Pareto Front is Reached
		try {
			this.aGivenParetoFrontIsReachedActivate
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_ACTIVATE,
									false));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_ACTIVATE,
					e.getMessage());
		}

		try {
			this.aGivenParetoFrontIsReachedSpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PERCENTAGES_TO_COVER,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PERCENTAGES_TO_COVER,
							e.getMessage());
		}

		try {
			this.aGivenParetoFrontIsReachedText
					.setText(configuration
							.getAttribute(
									DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PATH_TO_FRONT_FILE,
									""));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PATH_TO_FRONT_FILE,
							e.getMessage());
		}

		// Insignificant Set Quality Improvement
		try {
			this.insignificantSetQualityImprovementActivate
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_ACTIVATE,
									false));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_ACTIVATE,
							e.getMessage());
		}

		try {
			this.insignificantSetQualityImprovementSpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_GENERATION_X,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_GENERATION_X,
							e.getMessage());
		}

		this.insignificantSetQualityImprovementTable.removeAll();

		String tableItems2 = "";

		try {
			tableItems2 = configuration
					.getAttribute(
							DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_CONFIGURED_OBJECTIVES,
							"");
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_CONFIGURED_OBJECTIVES,
							e.getMessage());
		}

		if (!tableItems2.isEmpty()) {
			String[] items = tableItems2.split("\\;");
			for (String item : items) {
				String[] values = item.split("\\|");
				new TableItem(this.insignificantSetQualityImprovementTable,
						SWT.NONE).setText(new String[] { values[0], values[1],
						values[2] });
			}
		}

		// Insignificant Pareto Front Change
		try {
			this.insignificantParetoFrontChangeActivate
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_ACTIVATE,
									false));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_ACTIVATE,
							e.getMessage());
		}

		try {
			this.insignificantParetoFrontChangeSpinner
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_GENERATION_X,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_GENERATION_X,
							e.getMessage());
		}

		try {
			this.insignificantParetoFrontChangeSpinner1
					.setSelection(configuration
							.getAttribute(
									DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_IMPROVEMENT,
									1));
		} catch (CoreException e) {
			RunConfigPlugin
					.errorLogger(
							getName(),
							DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_IMPROVEMENT,
							e.getMessage());
		}

		this.updateAvailabilities();
	}

	private void updateAvailabilities() {
		boolean selected = activateComposedCriteria.getSelection();
		expAnd.setEnabled(selected);
		expOr.setEnabled(selected);
		expNot.setEnabled(selected);
		expBrackets.setEnabled(selected);
		expCrit.setEnabled(selected);
		composedExpression.setEnabled(selected);
		expValidate.setEnabled(selected);
		expressionIsValid.setEnabled(selected);

		selected = maxGenNumActivate.getSelection();
		maxGenNumLabel.setEnabled(selected);
		maxGenNumSpinner.setEnabled(selected);

		selected = elapsedTimeActivate.getSelection();
		elapsedTimeLabel.setEnabled(selected);
		elapsedTimeLabel2.setEnabled(selected);
		elapsedTimeSpinner.setEnabled(selected);
		elapsedTimeCombo.setEnabled(selected);

		selected = noNewParetoOptimalCandidatesFoundActivate.getSelection();
		noNewParetoOptimalCandidatesFoundLabel.setEnabled(selected);
		noNewParetoOptimalCandidatesFoundSpinner.setEnabled(selected);

		selected = paretoOptimalSetStabilityActivate.getSelection();
		paretoOptimalSetStabilityLabel.setEnabled(selected);
		paretoOptimalSetStabilityCombo.setEnabled(selected);
		paretoOptimalSetStabilityLabel1.setEnabled(selected);
		paretoOptimalSetStabilitySpinner.setEnabled(selected);
		paretoOptimalSetStabilityLabel2.setEnabled(selected);
		paretoOptimalSetStabilitySpinner1.setEnabled(selected);
		paretoOptimalSetStabilityLabel3.setEnabled(selected);
		paretoOptimalSetStabilitySpinner2.setEnabled(selected);

		selected = aGivenParetoFrontIsReachedActivate.getSelection();
		aGivenParetoFrontIsReachedLabel.setEnabled(selected);
		aGivenParetoFrontIsReachedSpinner.setEnabled(selected);
		aGivenParetoFrontIsReachedLabel1.setEnabled(selected);
		aGivenParetoFrontIsReachedText.setEnabled(selected);
		aGivenParetoFrontIsReachedBrowse.setEnabled(selected);

		selected = insignificantParetoFrontChangeActivate.getSelection();
		insignificantParetoFrontChangeLabel.setEnabled(selected);
		insignificantParetoFrontChangeSpinner.setEnabled(selected);
		insignificantParetoFrontChangeLabel1.setEnabled(selected);
		insignificantParetoFrontChangeLabel2.setEnabled(selected);
		insignificantParetoFrontChangeSpinner1.setEnabled(selected);

		selected = minimalQualityCriteriaValueActivate.getSelection();
		minimalQualityCriteriaValueLabel.setEnabled(selected);
		minimalQualityCriteriaValueSpinner.setEnabled(selected);
		minimalQualityCriteriaValueLabel1.setEnabled(selected);
		minimalQualityCriteriaValueTable.setEnabled(selected);
		minimalQualityCriteriaValueButton.setEnabled(selected);
		minimalQualityCriteriaValueButton1.setEnabled(selected);
		minimalQualityCriteriaValueButton2.setEnabled(selected);

		selected = insignificantSetQualityImprovementActivate.getSelection();
		insignificantSetQualityImprovementLabel.setEnabled(selected);
		insignificantSetQualityImprovementSpinner.setEnabled(selected);
		insignificantSetQualityImprovementLabel1.setEnabled(selected);
		insignificantSetQualityImprovementLabel2.setEnabled(selected);
		insignificantSetQualityImprovementTable.setEnabled(selected);
		insignificantSetQualityImprovementButton.setEnabled(selected);
		insignificantSetQualityImprovementButton1.setEnabled(selected);
		insignificantSetQualityImprovementButton2.setEnabled(selected);
		insignificantSetQualityImprovementTable.setEnabled(selected);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// General
		configuration.setAttribute(
				DSEConstantsContainer.TC_GENERAL_USE_TERMINATION_CRITERIA,
				this.useTerminationCriteria.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.TC_GENERAL_COMPARISION_MODE,
				this.runInComparisionMode.getSelection());

		// Composed Criteria
		configuration.setAttribute(
				DSEConstantsContainer.TC_COMPOSED_CRITERIA_ACTIVATE,
				this.activateComposedCriteria.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.TC_COMPOSED_CRITERIA_EXPRESSION,
				this.composedExpression.getText());

		// Maximum Generation Number Criterion
		configuration.setAttribute(
				DSEConstantsContainer.TC_MAX_NUM_OF_GEN_ACTIVATE,
				this.maxGenNumActivate.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.TC_MAX_NUM_OF_GEN_LIMIT,
				this.maxGenNumSpinner.getSelection());

		// Elapsed Time Criterion
		configuration.setAttribute(
				DSEConstantsContainer.TC_ELAPSED_TIME_ACTIVATE,
				this.elapsedTimeActivate.getSelection());
		configuration.setAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_TYPE,
				this.elapsedTimeCombo.getItem(this.elapsedTimeCombo
						.getSelectionIndex()));
		configuration.setAttribute(
				DSEConstantsContainer.TC_ELAPSED_TIME_TIME_LIMIT,
				this.elapsedTimeSpinner.getSelection());

		// No New Pareto Candidates Found Criterion
		configuration.setAttribute(
				DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ACTIVATE,
				this.noNewParetoOptimalCandidatesFoundActivate.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ITERATIONS_WITHOUT,
				this.noNewParetoOptimalCandidatesFoundSpinner.getSelection());

		// Pareto Optimal Set Stability
		configuration.setAttribute(
				DSEConstantsContainer.TC_SET_STABILITY_ACTIVATE,
				this.paretoOptimalSetStabilityActivate.getSelection());
		configuration.setAttribute(DSEConstantsContainer.TC_SET_STABILITY_MODE,
				this.paretoOptimalSetStabilityCombo
						.getItem(this.paretoOptimalSetStabilityCombo
								.getSelectionIndex()));
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_SET_STABILITY_MINIMUM_ITERATION_TO_SURVIVE,
						this.paretoOptimalSetStabilitySpinner.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_EXACT,
						this.paretoOptimalSetStabilitySpinner1.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_PERCENTAGE,
						this.paretoOptimalSetStabilitySpinner2.getSelection());

		// Minimal Quality Criteria Value
		configuration.setAttribute(
				DSEConstantsContainer.TC_MINIMAL_VALUES_ACTIVATE,
				this.minimalQualityCriteriaValueActivate.getSelection());
		configuration.setAttribute(
				DSEConstantsContainer.TC_MINIMAL_VALUES_CANDIDATES_TO_CONFORM,
				this.minimalQualityCriteriaValueSpinner.getSelection());
		this.minimalQualityCriteriaValueTable.getItems();

		StringBuilder tableItems = new StringBuilder();

		for (int i = 0; i < this.minimalQualityCriteriaValueTable
				.getItemCount(); i++) {
			tableItems.append(this.minimalQualityCriteriaValueTable.getItem(i)
					.getText(0)
					+ "|"
					+ this.minimalQualityCriteriaValueTable.getItem(i).getText(
							1) + ";");
		}

		configuration.setAttribute(
				DSEConstantsContainer.TC_MINIMAL_VALUES_CONFIGURED_OBJECTIVES,
				tableItems.toString());

		// A Given Pareto Front is Reached
		configuration.setAttribute(
				DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_ACTIVATE,
				this.aGivenParetoFrontIsReachedActivate.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PERCENTAGES_TO_COVER,
						this.aGivenParetoFrontIsReachedSpinner.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PATH_TO_FRONT_FILE,
						this.aGivenParetoFrontIsReachedText.getText());

		// Insignificant Set Quality Improvement
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_ACTIVATE,
						this.insignificantSetQualityImprovementActivate
								.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_GENERATION_X,
						this.insignificantSetQualityImprovementSpinner
								.getSelection());

		StringBuilder tableItems2 = new StringBuilder();
		TableItem[] items = this.insignificantSetQualityImprovementTable
				.getItems();
		for (int i = 0; i < items.length; i++) {
			tableItems2.append(items[i].getText(0) + "|" + items[i].getText(1)
					+ "|" + items[i].getText(2) + ";");
		}

		configuration
				.setAttribute(
						DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_CONFIGURED_OBJECTIVES,
						tableItems2.toString());

		// Insignificant Pareto Front Change
		configuration.setAttribute(
				DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_ACTIVATE,
				this.insignificantParetoFrontChangeActivate.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_GENERATION_X,
						this.insignificantParetoFrontChangeSpinner
								.getSelection());
		configuration
				.setAttribute(
						DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_IMPROVEMENT,
						this.insignificantParetoFrontChangeSpinner1
								.getSelection());

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

}
