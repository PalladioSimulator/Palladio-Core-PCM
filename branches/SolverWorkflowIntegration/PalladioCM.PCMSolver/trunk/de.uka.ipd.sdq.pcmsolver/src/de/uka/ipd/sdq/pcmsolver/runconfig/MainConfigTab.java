package de.uka.ipd.sdq.pcmsolver.runconfig;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MainConfigTab extends AbstractLaunchConfigurationTab {

	private Text textSamplingDist;
	private Text textMaxDomain;
	
	private Text lqnsConfig1;
	private Text lqnsConfig2;
	private Text lqnsConfig3;
	private Text lqnsConfig4;
	protected Combo comboLqnsOutput;
		
	private Text lqsimConfig1;
	private Text lqsimConfig2;
	private Text lqsimConfig3;
	protected Combo comboLqsimOutput;
	
	private Group sresConfigGroup; 
	private Group lqnsConfigGroup; 
	private Group lqsimConfigGroup;

	private StackLayout stackLayout;
	
	protected Combo comboSolver;
	
	private class MainConfigTabListener extends SelectionAdapter implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	}

	private class ComboBoxListener extends SelectionAdapter implements SelectionListener{
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);
			String selectedText = ((Combo)e.getSource()).getText();
			setVisibleConfigurationOptions(selectedText);
		}
	}

	
	private MainConfigTabListener listener = new MainConfigTabListener();
	private ComboBoxListener comboListener = new ComboBoxListener();
	
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		comboSolver = new Combo (container, SWT.READ_ONLY);
		comboSolver.setItems (new String [] {
				MessageStrings.SRE_SOLVER,
				MessageStrings.LQNS_SOLVER,
				MessageStrings.LQSIM_SOLVER
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
	}

	
	
	private Group createLQSIMWidgets(Composite container) {
		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 2;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		Label label1 = new Label(group, SWT.NONE);
		label1.setText("Run Time:");
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqsimConfig1 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqsimConfig1.addModifyListener(listener);

		Label label2 = new Label(group, SWT.NONE);
		label2.setText("Blocks:");
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqsimConfig2 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqsimConfig2.addModifyListener(listener);

		Label label3 = new Label(group, SWT.NONE);
		label3.setText("Processor Sharing Time Quantum:");
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqsimConfig3 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqsimConfig3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqsimConfig3.addModifyListener(listener);
				
		Label label4 = new Label(group, SWT.NONE);
		label4.setText("Output Type:");
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		comboLqsimOutput = new Combo(group, SWT.READ_ONLY);
		comboLqsimOutput.setItems (new String [] {
				MessageStrings.LQN_OUTPUT_HUMAN,
				MessageStrings.LQN_OUTPUT_XML
				});
		comboLqsimOutput.setSize (400, 200);
		comboLqsimOutput.addModifyListener(listener);
//		comboLqsimOutput.addSelectionListener(comboListener);

		return group;
	}



	private Group createLQNSWidgets(Composite container) {
		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 2;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		Label label1 = new Label(group, SWT.NONE);
		label1.setText("Convergence Value:");
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqnsConfig1 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqnsConfig1.addModifyListener(listener);
		
		Label label2 = new Label(group, SWT.NONE);
		label2.setText("Iteration Limit:");
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqnsConfig2 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqnsConfig2.addModifyListener(listener);
		
		Label label3 = new Label(group, SWT.NONE);
		label3.setText("Print Interval Intermediate Results:");
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqnsConfig3 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqnsConfig3.addModifyListener(listener);
		
		Label label4 = new Label(group, SWT.NONE);
		label4.setText("Under-relaxation Coefficient:");
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		lqnsConfig4 = new Text(group, SWT.SINGLE | SWT.BORDER);
		lqnsConfig4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lqnsConfig4.addModifyListener(listener);
		
		Label label5 = new Label(group, SWT.NONE);
		label5.setText("Output Type:");
		label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		comboLqnsOutput = new Combo(group, SWT.READ_ONLY);
		comboLqnsOutput.setItems (new String [] {
				MessageStrings.LQN_OUTPUT_HUMAN,
				MessageStrings.LQN_OUTPUT_XML
				});
		comboLqnsOutput.setSize (400, 200);
		comboLqnsOutput.addModifyListener(listener);
		comboLqnsOutput.addSelectionListener(comboListener);
		
		return group;
	}



	private Group createSREWidgets(Composite container) {
		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 2;

		final Group group = new Group(container, SWT.NONE);
		group.setLayout(analysisGL);
		group.setText("Configuration");
		group.setLayoutData(new GridData(500, SWT.DEFAULT));

		Label samplingDist = new Label(group, SWT.NONE);
		samplingDist.setText("Sampling Distance:");
		samplingDist.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textSamplingDist = new Text(group, SWT.SINGLE | SWT.BORDER);
		textSamplingDist.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textSamplingDist.addModifyListener(listener);
		
		Label maxDomain = new Label(group, SWT.NONE);
		maxDomain.setText("Maximum Domain Size:");
		maxDomain.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textMaxDomain = new Text(group, SWT.SINGLE | SWT.BORDER);
		textMaxDomain.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textMaxDomain.addModifyListener(listener);
		
		return group;

	}

	public String getName() {
		return "Solver";
	}

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
		}
		try{
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
			lqnsConfig1.setText(configuration.getAttribute(MessageStrings.CONV_VALUE, "1e-005"));
		} catch(CoreException e){
			lqnsConfig1.setText("1e-005");
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

		updateLaunchConfigurationDialog();
	}

	private void setVisibleConfigurationOptions(String solverStr) {
		if (solverStr.equals("SRES (Stochastic Regular Expression Solver)"))
			stackLayout.topControl = sresConfigGroup;
		else if (solverStr.equals("LQNS (Layered Queueing Network Solver)"))
			stackLayout.topControl = lqnsConfigGroup;
		else if (solverStr.equals("LQSIM (Layered Queueing Simulation)"))
			stackLayout.topControl = lqsimConfigGroup;
		
		lqsimConfigGroup.getParent().layout();
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(MessageStrings.SOLVER, comboSolver.getText());
		configuration.setAttribute(MessageStrings.SAMPLING_DIST, textSamplingDist.getText());
		configuration.setAttribute(MessageStrings.MAX_DOMAIN, textMaxDomain.getText());

		configuration.setAttribute(MessageStrings.CONV_VALUE, lqnsConfig1.getText());
		configuration.setAttribute(MessageStrings.IT_LIMIT, lqnsConfig2.getText());
		configuration.setAttribute(MessageStrings.PRINT_INT, lqnsConfig3.getText());
		configuration.setAttribute(MessageStrings.UNDER_COEFF, lqnsConfig4.getText());
		configuration.setAttribute(MessageStrings.LQNS_OUTPUT, comboLqnsOutput.getText());
		configuration.setAttribute(MessageStrings.LQSIM_OUTPUT, comboLqsimOutput.getText());

		configuration.setAttribute(MessageStrings.RUN_TIME, lqsimConfig1.getText());
		configuration.setAttribute(MessageStrings.BLOCKS, lqsimConfig2.getText());
		configuration.setAttribute(MessageStrings.PS_QUANTUM, lqsimConfig3.getText());
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}
	
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
