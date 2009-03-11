package org.somox.ui.runconfig.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

/**
 * The class defines a tab, which is responsible for the input for a model extraction
 * 
 * @author Michael Hauck
 */
public class ModelExtractionInputTab extends AbstractLaunchConfigurationTab {

    private Text testTextField;
    
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
    	configuration.setAttribute(
    	   "test1",
    	   (String)testTextField.getText());
    	
    }
    
    /* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				ModelExtractionInputTab.this.setDirty(true);
				ModelExtractionInputTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		
		/**
		 * Create repository section
		 */
		final Group repositoryGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryGroup = new GridLayout();
		glReposetoryGroup.numColumns = 3;
		repositoryGroup.setLayout(glReposetoryGroup);
		repositoryGroup.setText("Repository File");
		repositoryGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		testTextField = new Text(repositoryGroup, SWT.SINGLE | SWT.BORDER);
		final GridData gd_textRepository = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_textRepository.widthHint = 200;
		testTextField.setLayoutData(gd_textRepository);
		testTextField.addModifyListener(modifyListener);

		

	}
    
    public void initializeFrom(ILaunchConfiguration config) {
    	testTextField.setText("200");
    }
    
    public boolean isValid(ILaunchConfiguration launchConfig) {
        setErrorMessage(null);
        try {
         Integer.parseInt(testTextField.getText().trim());
        } catch(NumberFormatException nfe) {
         setErrorMessage("testTextField is not an integer");
            return false;
        }
     return true;
    }


	@Override
	public String getName() {
		return "Test123";
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				"test1",
		    	   "200");
		
	}

}
