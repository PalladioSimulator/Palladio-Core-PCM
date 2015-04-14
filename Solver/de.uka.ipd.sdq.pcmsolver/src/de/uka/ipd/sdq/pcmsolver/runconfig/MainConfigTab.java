/*
 * 
 */
package de.uka.ipd.sdq.pcmsolver.runconfig;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

public class MainConfigTab extends FileNamesInputTab {


	private Text textSamplingDist;
	private Text textMaxDomain;

	private Text lqnsConfig1;
	private Text lqnsConfig2;
	private Text lqnsConfig3;
	private Text lqnsConfig4;
	private Button  lqnsConfigStopOnMessageLoss;

	private Button  debugButton;

	private Button  lqnsConfigInfTaskMult;
	protected Combo comboLqnsOutput;

	private Text lqsimConfig1;
	private Text lqsimConfig2;
	private Text lqsimConfig3;
	private Button  lqsimConfigStopOnMessageLoss;
	protected Combo comboLqsimOutput;

	private Text lqnsConfigPragma;
	private Text lqnsimConfigPragma;

	private Group sresConfigGroup; 
	private Group lqnsConfigGroup; 
	private Group lqsimConfigGroup;
	private Group perfengineConfigGroup; 

	private StackLayout stackLayout;

	protected Combo comboSolver;

	/** The text output directory of the analytical LQN Solver. */
	private Text textLqnsOutputDir;	

	/** The text performance engine output directory. */
	private Text textPerfEngOutputDir;	

	/** The text performance engine output directory. */
	private Text textPerfEngPropFile;

	/** The text output directory of the LQN simulator lqsim. */
	private Text textLqsimOutputDir;

	private Text textSREOutputFile;

	private Button checkboxUseExpressionAsInput;

	// Create a listener for GUI modification events:
	final ModifyListener listener = new ModifyListener() {

		public void modifyText(ModifyEvent e) {
			MainConfigTab.this.setDirty(true);
			MainConfigTab.this.updateLaunchConfigurationDialog();
		}
	};

	//	private class MainConfigTabListener extends SelectionAdapter implements ModifyListener {
	//		public void modifyText(ModifyEvent e) {
	//			updateLaunchConfigurationDialog();
	//			MainConfigTab.this.setDirty(true);
	//		}
	//	}

	/**
	 * The listener interface for receiving comboBox events.
	 * The class that is interested in processing a comboBox
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addComboBoxListener<code> method. When
	 * the comboBox event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see ComboBoxEvent
	 */
	private class ComboBoxListener extends SelectionAdapter implements SelectionListener{

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);
			String selectedText = ((Combo)e.getSource()).getText();
			setVisibleConfigurationOptions(selectedText);
		}
	}


	//private MainConfigTabListener listener = new MainConfigTabListener();
	private ComboBoxListener comboListener = new ComboBoxListener();




	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		comboSolver = new Combo (container, SWT.READ_ONLY);
		comboSolver.setItems (new String [] {
				MessageStrings.SRE_SOLVER,
				MessageStrings.LQNS_SOLVER,
				MessageStrings.LQSIM_SOLVER,
				MessageStrings.PERFENGINE_SOLVER
		});
		comboSolver.setSize (400, 200);
		comboSolver.addModifyListener(listener);
		comboSolver.addSelectionListener(comboListener);

		Composite innerContainer = new Composite(container, SWT.NONE);
		stackLayout = new StackLayout();
		innerContainer.setLayout(stackLayout);
		innerContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));


		sresConfigGroup = createSREWidgets(innerContainer);
		lqnsConfigGroup = createLQNSWidgets(innerContainer);
		lqsimConfigGroup = createLQSIMWidgets(innerContainer);
		perfengineConfigGroup = createPerfEngWidgets(innerContainer);
	}



	private Group createLQSIMWidgets(Composite container) {

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}
		};

		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 4;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration (see LQSim manual for details or use defaults)");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		GridData threeColumnGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		threeColumnGridData.horizontalSpan = 3;

		Label label1 = new Label(group, SWT.NONE);
		label1.setText("Run Time (optional):");
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqsimConfig1 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig1.setLayoutData(threeColumnGridData);
		lqsimConfig1.addModifyListener(listener);

		Label label2 = new Label(group, SWT.NONE);
		label2.setText("Blocks (optional):");
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqsimConfig2 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig2.setLayoutData(threeColumnGridData);
		lqsimConfig2.addModifyListener(listener);

		Label label3 = new Label(group, SWT.NONE);
		label3.setText("Processor Sharing Time Quantum:");
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqsimConfig3 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig3.setLayoutData(threeColumnGridData);
		lqsimConfig3.addModifyListener(listener);

		Label labelStopOnMessageLoss = new Label(group, SWT.NONE);
		labelStopOnMessageLoss.setText("\"Stop On Message Loss\" Pragma:");
		labelStopOnMessageLoss.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqsimConfigStopOnMessageLoss = new Button(group,  SWT.CHECK);
		lqsimConfigStopOnMessageLoss.setEnabled(true);
		lqsimConfigStopOnMessageLoss.setText("Stop on message loss");
		lqsimConfigStopOnMessageLoss.addSelectionListener(selectionListener);
		lqsimConfigStopOnMessageLoss.setSelection(true);
		lqsimConfigStopOnMessageLoss.setLayoutData(threeColumnGridData);

		Label label4 = new Label(group, SWT.NONE);
		label4.setText("Output Type:");
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		comboLqsimOutput = new Combo(group, SWT.READ_ONLY);
		comboLqsimOutput.setItems (new String [] {
				MessageStrings.LQN_OUTPUT_HTML,
				MessageStrings.LQN_OUTPUT_HUMAN,
				MessageStrings.LQN_OUTPUT_XML
		});
		comboLqsimOutput.setSize (400, 200);
		comboLqsimOutput.setLayoutData(threeColumnGridData);
		comboLqsimOutput.addModifyListener(listener);
		//		comboLqsimOutput.addSelectionListener(comboListener);

		Label label5 = new Label(group, SWT.NONE);
		label5.setText("Output Dir:");
		label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		textLqsimOutputDir = new Text(group, SWT.SINGLE | SWT.BORDER);
		textLqsimOutputDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textLqsimOutputDir.addModifyListener(listener);

		createFolderSelectionButtons(group,textLqsimOutputDir);

		Label labelPragma = new Label(group, SWT.NONE);
		labelPragma.setText("Additional Pragmas:");
		labelPragma.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsimConfigPragma = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsimConfigPragma.setLayoutData(threeColumnGridData);
		lqnsimConfigPragma.addModifyListener(listener);

		return group;
	}



	private Group createLQNSWidgets(Composite container) {
		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}
		};

		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 4;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration (see LQNS manual for details or use defaults)");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		GridData threeColumnGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		threeColumnGridData.horizontalSpan = 3;

		Label label1 = new Label(group, SWT.NONE);
		label1.setText("Convergence Value:");
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfig1 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig1.setLayoutData(threeColumnGridData);
		lqnsConfig1.addModifyListener(listener);

		Label label2 = new Label(group, SWT.NONE);
		label2.setText("Iteration Limit:");
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfig2 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig2.setLayoutData(threeColumnGridData);
		lqnsConfig2.addModifyListener(listener);

		Label label3 = new Label(group, SWT.NONE);
		label3.setText("Print Interval Intermediate Results:");
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfig3 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig3.setLayoutData(threeColumnGridData);
		lqnsConfig3.addModifyListener(listener);

		Label label4 = new Label(group, SWT.NONE);
		label4.setText("Under-relaxation Coefficient:");
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfig4 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig4.setLayoutData(threeColumnGridData);
		lqnsConfig4.addModifyListener(listener);

		Label labelStopOnMessageLoss = new Label(group, SWT.NONE);
		labelStopOnMessageLoss.setText("\"Stop On Message Loss\" Pragma:");
		labelStopOnMessageLoss.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfigStopOnMessageLoss = new Button(group,  SWT.CHECK);
		lqnsConfigStopOnMessageLoss.setEnabled(true);
		lqnsConfigStopOnMessageLoss.setText("Stop on message loss");
		lqnsConfigStopOnMessageLoss.addSelectionListener(selectionListener);
		lqnsConfigStopOnMessageLoss.setSelection(true);
		lqnsConfigStopOnMessageLoss.setLayoutData(threeColumnGridData);

		Label labelInfTaskMult = new Label(group, SWT.NONE);
		labelInfTaskMult.setText("Infinite Task Multiplicity:");
		labelInfTaskMult.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfigInfTaskMult = new Button(group,  SWT.CHECK);
		lqnsConfigInfTaskMult.setEnabled(true);
		lqnsConfigInfTaskMult.setText("");
		lqnsConfigInfTaskMult.addSelectionListener(selectionListener);
		lqnsConfigInfTaskMult.setSelection(true);
		lqnsConfigInfTaskMult.setLayoutData(threeColumnGridData);

		Label label5 = new Label(group, SWT.NONE);
		label5.setText("Output Type:");
		label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		comboLqnsOutput = new Combo(group, SWT.READ_ONLY);
		comboLqnsOutput.setItems (new String [] {
				MessageStrings.LQN_OUTPUT_HTML,
				MessageStrings.LQN_OUTPUT_HUMAN,
				MessageStrings.LQN_OUTPUT_XML
		});
		comboLqnsOutput.setSize (400, 200);
		comboLqnsOutput.setLayoutData(threeColumnGridData);
		comboLqnsOutput.addModifyListener(listener);
		comboLqnsOutput.addSelectionListener(comboListener);

		Label label6 = new Label(group, SWT.NONE);
		label6.setText("Output Dir:");
		label6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		textLqnsOutputDir = new Text(group, SWT.SINGLE | SWT.BORDER);
		textLqnsOutputDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textLqnsOutputDir.addModifyListener(listener);

		createFolderSelectionButtons(group,textLqnsOutputDir);

		Label labelPragma = new Label(group, SWT.NONE);
		labelPragma.setText("Additional Pragmas:");
		labelPragma.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		lqnsConfigPragma = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfigPragma.setLayoutData(threeColumnGridData);
		lqnsConfigPragma.addModifyListener(listener);

		return group;
	}

	private Group createPerfEngWidgets(Composite container) {
		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}
		};

		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 4;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration (Definition of parameters)");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		GridData threeColumnGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		threeColumnGridData.horizontalSpan = 3;

	

		Label labelOutFolder = new Label(group, SWT.NONE);
		labelOutFolder.setText("Output Dir:");
		labelOutFolder.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		textPerfEngOutputDir = new Text(group, SWT.SINGLE | SWT.BORDER);
		textPerfEngOutputDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textPerfEngOutputDir.addModifyListener(listener);


		createFolderSelectionButtons(group,textPerfEngOutputDir);
		
		Label labelPerfFile = new Label(group, SWT.NONE);
		labelPerfFile.setText("LINE property file:");
		labelPerfFile.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		textPerfEngPropFile = new Text(group, SWT.SINGLE | SWT.BORDER);
		textPerfEngPropFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textPerfEngPropFile.addModifyListener(listener);
		
		createFileSelectionButtons(group,textPerfEngPropFile);

		debugButton = new Button(group,  SWT.CHECK);
		debugButton.setEnabled(true);
		debugButton.setText("Verbose Debugging");
		debugButton.addSelectionListener(selectionListener);
		debugButton.setSelection(true);
		debugButton.setLayoutData(threeColumnGridData);	
		return group;
	}



	/**
	 * Creates the folder selection buttons.
	 *
	 * @param group the group
	 * @param text the text
	 */
	private void createFolderSelectionButtons(final Group group, Text text) {
		final Button workspaceButton = new Button(group, SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton.addSelectionListener(new WorkspaceButtonSelectionListener(text));

		final Button fileSystemButton = new Button(group, SWT.NONE);
		fileSystemButton.setText("File System...");
		fileSystemButton.addSelectionListener(new FileSystemButtonSelectionAdapter(text));
	}

	private void createFileSelectionButtons(final Group group, Text text) {
		final Button workspaceButton = new Button(group, SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton.addSelectionListener(new WorkspaceFileButtonSelectionListener(text));

		final Button fileSystemButton = new Button(group, SWT.NONE);
		fileSystemButton.setText("File System...");
		fileSystemButton.addSelectionListener(new FileSystemButtonSelectionAdapter(text));
	}


	private Group createSREWidgets(Composite container) {

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				MainConfigTab.this.setDirty(true);
				MainConfigTab.this.updateLaunchConfigurationDialog();
			}
		};

		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 4;

		GridData threeColumnGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		threeColumnGridData.horizontalSpan = 3;


		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		Label samplingDist = new Label(group, SWT.NONE);
		samplingDist.setText("Sampling Distance:");
		samplingDist.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		textSamplingDist = new Text(group, SWT.SINGLE | SWT.BORDER);
		textSamplingDist.setLayoutData(threeColumnGridData);
		textSamplingDist.addModifyListener(listener);

		Label maxDomain = new Label(group, SWT.NONE);
		maxDomain.setText("Maximum Domain Size:");
		maxDomain.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		textMaxDomain = new Text(group, SWT.SINGLE | SWT.BORDER);
		textMaxDomain.setLayoutData(threeColumnGridData);
		textMaxDomain.addModifyListener(listener);

		Label useExpressionLabel = new Label(group, SWT.NONE);
		useExpressionLabel.setText("Use of Expression Model File:");
		useExpressionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		// Create the check box to choose whether Expression model should be read in
		checkboxUseExpressionAsInput = new Button(group,  SWT.CHECK);
		checkboxUseExpressionAsInput.setEnabled(true);
		checkboxUseExpressionAsInput.setText("Use expression file below as input. If not checked, file is used as output file.");
		checkboxUseExpressionAsInput.addSelectionListener(selectionListener);
		checkboxUseExpressionAsInput.setLayoutData(threeColumnGridData);
		checkboxUseExpressionAsInput.setSelection(false);

		Label label6 = new Label(group, SWT.NONE);
		label6.setText("Expression Model File:");
		label6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		textSREOutputFile = new Text(group, SWT.SINGLE | SWT.BORDER);
		textSREOutputFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textSREOutputFile.addModifyListener(listener);

		//createFolderSelectionButtons(group,textSREOutputFile);
		//String[] filenameExtensions = {".expression", ".spa"};
		//this.createFileInputSection(group, modifyListener, "Expression Model File (use as input or output):", filenameExtensions, textSREOutputFile);
		createFolderSelectionButtons(group,textSREOutputFile);

		return group;

	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ProtocomFileNamesInputTab#getName()
	 */
	@Override
	public String getName() {
		return "Solver";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			String solverStr = configuration.getAttribute(MessageStrings.SOLVER, 
					MessageStrings.SRE_SOLVER);
			String[] items = comboSolver.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(solverStr)){
					comboSolver.select(i);
				}
			}
			setVisibleConfigurationOptions(solverStr);
		} catch(CoreException e){
			comboSolver.select(0);
		}
		try{
			String outputStr = configuration.getAttribute(MessageStrings.LQNS_OUTPUT, 
					MessageStrings.LQN_OUTPUT_HUMAN);
			String[] items = comboLqnsOutput.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(outputStr)){
					comboLqnsOutput.select(i);
				}
			}
		} catch(CoreException e){
			comboLqnsOutput.select(0);
		} try {
			String outputStr = configuration.getAttribute(MessageStrings.LQSIM_OUTPUT, 
					MessageStrings.LQN_OUTPUT_HUMAN);
			String[] items = comboLqsimOutput.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(outputStr)){
					comboLqsimOutput.select(i);
				}
			}
		} catch(CoreException e){
			comboLqsimOutput.select(0);
		}
		try{
			textSamplingDist.setText(configuration.getAttribute(MessageStrings.SAMPLING_DIST, "1.0"));
		} catch(CoreException e){
			textSamplingDist.setText("1.0");
		}
		try{
			textMaxDomain.setText(configuration.getAttribute(MessageStrings.MAX_DOMAIN, "256"));
		} catch(CoreException e){
			textMaxDomain.setText("256");
		}
		try{
			textSREOutputFile.setText(configuration.getAttribute(MessageStrings.SRE_OUTPUT_FILE, System.getProperty("user.dir")));
		} catch(CoreException e){
			textSREOutputFile.setText(System.getProperty("user.dir"));
		}


		try{
			lqnsConfig1.setText(configuration.getAttribute(MessageStrings.CONV_VALUE, "0.001"));
		} catch(CoreException e){
			lqnsConfig1.setText("0.001");
		}
		try{
			lqnsConfig2.setText(configuration.getAttribute(MessageStrings.IT_LIMIT, "50"));
		} catch(CoreException e){
			lqnsConfig2.setText("50");
		}
		try{
			lqnsConfig3.setText(configuration.getAttribute(MessageStrings.PRINT_INT, "10"));
		} catch(CoreException e){
			lqnsConfig3.setText("10");
		}
		try{
			lqnsConfig4.setText(configuration.getAttribute(MessageStrings.UNDER_COEFF, "0.5"));
		} catch(CoreException e){
			lqnsConfig4.setText("0.5");
		}

		try{
			textLqnsOutputDir.setText(configuration.getAttribute(MessageStrings.LQNS_OUTPUT_DIR, System.getProperty("user.dir")));
		} catch(CoreException e){
			textLqnsOutputDir.setText(System.getProperty("user.dir"));
		}

		try{
			textPerfEngOutputDir.setText(configuration.getAttribute(MessageStrings.PERF_ENG_OUT_DIR, System.getProperty("user.dir")));
		} catch(CoreException e){
			textPerfEngOutputDir.setText(System.getProperty("user.dir"));
		}

		try{
			textPerfEngPropFile.setText(configuration.getAttribute(MessageStrings.PERF_ENG_PROP_FILE, System.getProperty("user.dir")+"LINE.properties"));
		} catch(CoreException e){
			textPerfEngPropFile.setText(System.getProperty("user.dir")+"LINE.properties");
		}

		try{
			lqnsConfigPragma.setText(configuration.getAttribute(MessageStrings.PRAGMAS, ""));
		} catch(CoreException e){
			lqnsConfigPragma.setText("");
		}

		try{
			lqsimConfig1.setText(configuration.getAttribute(MessageStrings.RUN_TIME, ""));
		} catch(CoreException e){
			lqsimConfig1.setText("");
		}
		try{
			lqsimConfig2.setText(configuration.getAttribute(MessageStrings.BLOCKS, ""));
		} catch(CoreException e){
			lqsimConfig2.setText("");
		}
		try{
			lqsimConfig3.setText(configuration.getAttribute(MessageStrings.PS_QUANTUM, "0.001"));
		} catch(CoreException e){
			lqsimConfig3.setText("0.001");
		}
		try{
			textLqsimOutputDir.setText(configuration.getAttribute(MessageStrings.LQSIM_OUTPUT_DIR, System.getProperty("user.dir")));
		} catch(CoreException e){
			textLqsimOutputDir.setText(System.getProperty("user.dir"));
		}

		try {
			this.checkboxUseExpressionAsInput.setSelection(configuration.getAttribute(
					MessageStrings.SRE_IS_USE_INPUT_MODEL, false));
		} catch (CoreException e) {
			this.checkboxUseExpressionAsInput.setSelection(false);
		}
		try {
			this.lqnsConfigStopOnMessageLoss.setSelection(configuration.getAttribute(
					MessageStrings.STOP_ON_MESSAGE_LOSS_LQNS, true));
		} catch (CoreException e) {
			this.lqnsConfigStopOnMessageLoss.setSelection(true);
		}
		try {
			this.debugButton.setSelection(configuration.getAttribute(
					MessageStrings.DEBUG_PERF_ENG, true));
		} catch (CoreException e) {
			this.debugButton.setSelection(true);
		}
		try {
			this.lqsimConfigStopOnMessageLoss.setSelection(configuration.getAttribute(
					MessageStrings.STOP_ON_MESSAGE_LOSS_LQSIM, true));
		} catch (CoreException e) {
			this.lqsimConfigStopOnMessageLoss.setSelection(true);
		}

		try{
			lqnsimConfigPragma.setText(configuration.getAttribute(MessageStrings.PRAGMAS, ""));
		} catch(CoreException e){
			lqnsimConfigPragma.setText("");
		}

		try {
			this.lqnsConfigInfTaskMult.setSelection(configuration.getAttribute(
					MessageStrings.INFINITE_TASK_MULTIPLICITY, true));
		} catch (CoreException e) {
			this.lqnsConfigInfTaskMult.setSelection(true);
		}

		updateLaunchConfigurationDialog();
	}

	/**
	 * Sets the visible configuration options.
	 *
	 * @param solverStr the new visible configuration options
	 */
	private void setVisibleConfigurationOptions(String solverStr) {
		if (solverStr.equals("SRES (Stochastic Regular Expression Solver)"))
			stackLayout.topControl = sresConfigGroup;
		else if (solverStr.equals("LQNS (Layered Queueing Network Solver)"))
			stackLayout.topControl = lqnsConfigGroup;
		else if (solverStr.equals("LQSIM (Layered Queueing Simulation)"))
			stackLayout.topControl = lqsimConfigGroup;
		else if (solverStr.equals(MessageStrings.PERFENGINE_SOLVER))
			stackLayout.topControl = perfengineConfigGroup;

		lqsimConfigGroup.getParent().layout();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(MessageStrings.SOLVER, comboSolver.getText());
		configuration.setAttribute(MessageStrings.SAMPLING_DIST, textSamplingDist.getText());
		configuration.setAttribute(MessageStrings.MAX_DOMAIN, Integer.parseInt(textMaxDomain.getText()));

		configuration.setAttribute(MessageStrings.CONV_VALUE, lqnsConfig1.getText());
		configuration.setAttribute(MessageStrings.IT_LIMIT, lqnsConfig2.getText());
		configuration.setAttribute(MessageStrings.PRINT_INT, lqnsConfig3.getText());
		configuration.setAttribute(MessageStrings.UNDER_COEFF, lqnsConfig4.getText());
		configuration.setAttribute(MessageStrings.LQNS_OUTPUT, comboLqnsOutput.getText());
		configuration.setAttribute(MessageStrings.LQSIM_OUTPUT, comboLqsimOutput.getText());

		configuration.setAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQNS, lqnsConfigStopOnMessageLoss.getSelection());
		configuration.setAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQSIM, lqsimConfigStopOnMessageLoss.getSelection());
		configuration.setAttribute(MessageStrings.DEBUG_PERF_ENG, debugButton.getSelection());

		configuration.setAttribute(MessageStrings.INFINITE_TASK_MULTIPLICITY, lqnsConfigInfTaskMult.getSelection());

		configuration.setAttribute(MessageStrings.RUN_TIME, lqsimConfig1.getText());
		configuration.setAttribute(MessageStrings.BLOCKS, lqsimConfig2.getText());
		configuration.setAttribute(MessageStrings.PS_QUANTUM, lqsimConfig3.getText());

		configuration.setAttribute(MessageStrings.PRAGMAS, lqnsimConfigPragma.getText());
		configuration.setAttribute(MessageStrings.PRAGMAS, lqnsConfigPragma.getText());

		configuration.setAttribute(MessageStrings.PERF_ENG_OUT_DIR, textPerfEngOutputDir.getText());
		configuration.setAttribute(MessageStrings.PERF_ENG_PROP_FILE, textPerfEngPropFile.getText());
		configuration.setAttribute(MessageStrings.LQNS_OUTPUT_DIR, textLqnsOutputDir.getText());
		configuration.setAttribute(MessageStrings.LQSIM_OUTPUT_DIR, textLqsimOutputDir.getText());
		configuration.setAttribute(MessageStrings.SRE_OUTPUT_FILE, textSREOutputFile.getText());

		configuration.setAttribute(MessageStrings.SRE_IS_USE_INPUT_MODEL, checkboxUseExpressionAsInput.getSelection());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		String sampDist = textSamplingDist.getText();
		if (sampDist.equals("")){
			setErrorMessage("Sampling distance is missing!");
			return false;
		}
		try {	
			Double.parseDouble(sampDist);
		} catch (NumberFormatException e){
			setErrorMessage("Sampling distance is not a Double Value!");
			return false;
		}

		String maxDom = textMaxDomain.getText();
		if (maxDom.equals("")){
			setErrorMessage("Maximum domain size is missing!");
			return false;
		}
		try {	
			Integer.parseInt(maxDom);
		} catch (NumberFormatException e){
			setErrorMessage("Maximum domain is not an Integer Value!");
			return false;
		}

		String outputDir = textLqnsOutputDir.getText();
		if(outputDir.equals("")){
			setErrorMessage("Output folder must be set!");
			return false;
		}
		if (outputDir.contains(" ")){
			setErrorMessage("Output folder must not contain a space character, as the LQN solvers cannot handle that.");
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ProtocomFileNamesInputTab#activated(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ProtocomFileNamesInputTab#deactivated(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

	class FileSystemButtonSelectionAdapter extends SelectionAdapter {

		private Text field;

		public FileSystemButtonSelectionAdapter(Text field){
			this.field = field;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFileDialog = openFileSystemFileDialog();
			if (!resultOpenFileDialog.equals(new String(""))) {
				field.setText(resultOpenFileDialog);			
			}
		}
	}

	class FileSystemFileButtonSelectionAdapter extends SelectionAdapter {

		/** The field. */
		private Text field;

		/**
		 * Instantiates a new file system button selection adapter.
		 *
		 * @param field the field
		 */
		public FileSystemFileButtonSelectionAdapter(Text field){
			this.field = field;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFileDialog = openFileSystemFileDialog();
			if (!resultOpenFileDialog.equals(new String(""))) {
				field.setText(resultOpenFileDialog);			
			}
		}
	}

	/**
	 * Button SelectionListener - call a WorkspaceResourceDialog.
	 *
	 * @see WorkspaceButtonSelectionEvent
	 */
	class WorkspaceButtonSelectionListener extends SelectionAdapter {

		private Text field;

		public WorkspaceButtonSelectionListener(Text field) {
			this.field = field;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFolderDialog = openWorkspaceResourceFolderDialog();
			if (!resultOpenFolderDialog.equals(new String(""))) {
				field.setText(resultOpenFolderDialog);			
			}
		}
	}
	
	class WorkspaceFileButtonSelectionListener extends SelectionAdapter {

		/** The field. */
		private Text field;

		/**
		 * Instantiates a new workspace button selection listener.
		 *
		 * @param field the field
		 */
		public WorkspaceFileButtonSelectionListener(Text field) {
			this.field = field;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFileDialog = openWorkspaceResourceFileDialog();
			if (!resultOpenFileDialog.equals(new String(""))) {
				field.setText(resultOpenFileDialog);			
			}
		}
	}

	private String openFileSystemFolderDialog(){
		String folderName = "";

		DirectoryDialog dirDialog = new DirectoryDialog(getShell(), SWT.OPEN);
		dirDialog.setText("Select a folder.");

		if (dirDialog.open() != null) {
			folderName = dirDialog.getFilterPath();

		}	
		return folderName;
	}
	
	private String openFileSystemFileDialog(){
		String fileName = "";
		FileDialog fDialog = new FileDialog(getShell(), SWT.OPEN);		
		fDialog.setText("Select a file.");

		if (fDialog.open() != null) {
			fileName = fDialog.getFilterPath()+System.getProperty("file.separator")+fDialog.getFileName();

		}	
		return fileName;
	}

	private String openWorkspaceResourceFolderDialog(){
		String msg = "Select a folder.";

		IContainer container = null;
		IContainer[] containers = WorkspaceResourceDialog.openFolderSelection(getShell(), 
				null, msg, false, null, new ArrayList<ViewerFilter>());

		if (containers.length != 0)
			container = containers[0];
		if (container != null)
			return container.getLocation().toOSString();

		return "";
	}
	
	private String openWorkspaceResourceFileDialog(){
		String msg = "Select a file.";

		IFile file = null;
		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), 
				null, msg, false, null, new ArrayList<ViewerFilter>());

		if (files.length != 0)
			file = files[0];
		if (file != null)
			return file.getLocation().toOSString();

		return "";
	}
}
