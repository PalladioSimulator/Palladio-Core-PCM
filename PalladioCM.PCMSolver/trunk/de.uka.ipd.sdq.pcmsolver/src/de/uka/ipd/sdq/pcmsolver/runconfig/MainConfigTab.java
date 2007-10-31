package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class MainConfigTab extends AbstractLaunchConfigurationTab {

	private Text textSamplingDist;
	private Text textMaxDomain;
	private Button checkVerboseLogging = null;
	private Combo comboSolver;
	
	private class MainConfigTabListener extends SelectionAdapter implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	}

	private class ComboBoxListener extends SelectionAdapter implements SelectionListener{
		public void widgetSelected(SelectionEvent e) {

			// TODO Auto-generated method stub
			super.widgetSelected(e);
		}
	}

	
	private MainConfigTabListener listener = new MainConfigTabListener();
	private ComboBoxListener comboListener = new ComboBoxListener();
	
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		comboSolver = new Combo (container, SWT.READ_ONLY);
		comboSolver.setItems (new String [] {"SRE-Solver", "LQNS", "LQSIM"});
		comboSolver.setSize (200, 200);
		comboSolver.addModifyListener(listener);
		comboSolver.addSelectionListener(comboListener);
		
		createSREWidgets(container);
	}

	private void createSREWidgets(Composite container) {
		final GridLayout analysisGL = new GridLayout();
		analysisGL.numColumns = 2;

		final Group analysisConfigGroup = new Group(container, SWT.NONE);
		analysisConfigGroup.setLayout(analysisGL);
		analysisConfigGroup.setText("Analysis Configuration");
		analysisConfigGroup.setLayoutData(new GridData(500, SWT.DEFAULT));

		Label samplingDist = new Label(analysisConfigGroup, SWT.NONE);
		samplingDist.setText("Sampling Distance:");
		samplingDist.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textSamplingDist = new Text(analysisConfigGroup, SWT.SINGLE | SWT.BORDER);
		textSamplingDist.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textSamplingDist.addModifyListener(listener);
		
		Label maxDomain = new Label(analysisConfigGroup, SWT.NONE);
		maxDomain.setText("Maximum Domain Size:");
		maxDomain.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textMaxDomain = new Text(analysisConfigGroup, SWT.SINGLE | SWT.BORDER);
		textMaxDomain.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textMaxDomain.addModifyListener(listener);
		
		checkVerboseLogging = new Button(container, SWT.CHECK);
		checkVerboseLogging.setText("Enable verbose logging");
		checkVerboseLogging.setSelection(false);
		checkVerboseLogging.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				updateLaunchConfigurationDialog();
			}
		});
		
		//analysisConfigGroup.setP
	}

	public String getName() {
		return "Main Config";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			String solver = configuration.getAttribute("solver", "SRE-Solver");
			String[] items = comboSolver.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(solver)){
					comboSolver.select(i);
				}
			}
		} catch(CoreException e){
			comboSolver.select(0);
		}
		try{
			textSamplingDist.setText(configuration.getAttribute("samplingDist", "1.0"));
		} catch(CoreException e){
			textSamplingDist.setText("1.0");
		}
		try{
			textMaxDomain.setText(configuration.getAttribute("maxDomain", "256"));
		} catch(CoreException e){
			textMaxDomain.setText("256");
		}
		try{
			checkVerboseLogging.setSelection(configuration.getAttribute("verboseLogging", false));
		}catch(CoreException e){
			checkVerboseLogging.setSelection(false);
		}
		
		updateLaunchConfigurationDialog();
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("solver", comboSolver.getText());
		configuration.setAttribute("samplingDist", textSamplingDist.getText());
		configuration.setAttribute("maxDomain", textMaxDomain.getText());
		configuration.setAttribute("verboseLogging", checkVerboseLogging.getSelection());
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

}
