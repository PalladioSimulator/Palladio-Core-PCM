package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MainConfigTab extends AbstractLaunchConfigurationTab {

	private Text textSamplingDist;
	private Text textMaxDomain;
	
	private class MainConfigTabListener extends SelectionAdapter implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	}
	
	private MainConfigTabListener listener = new MainConfigTabListener();
	
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
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

	}

	@Override
	public String getName() {
		return "Main Config";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			textSamplingDist.setText(configuration.getAttribute("samplingDist", "n/a"));
		} catch(CoreException e){
			textSamplingDist.setText("n/a");
		}
		try{
			textMaxDomain.setText(configuration.getAttribute("maxDomain", "n/a"));
		} catch(CoreException e){
			textMaxDomain.setText("n/a");
		}
		updateLaunchConfigurationDialog();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("samplingDist", textSamplingDist.getText());
		configuration.setAttribute("maxDomain", textMaxDomain.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(ILaunchConfiguration launchConfig) {
	    setErrorMessage(null);
	    if (textSamplingDist.getText().equals("")){
	    	setErrorMessage("Sampling distance is missing!");
	    	return false;
	    }
	    if (textMaxDomain.getText().equals("")){
	    	setErrorMessage("Maximum domain size is missing!");
	    	return false;
	    }
	    return true;
	}

}
