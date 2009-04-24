package org.somox.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

public class SomoxProjectPage extends WizardPage implements Listener {
	
	IWorkbench workbench;
	IStructuredSelection selection;
	
	// widgets on this page 
	Text sourceDirectory;
	Button workspaceButton;
	Button fileSystemButton;
	
	// status variable for the possible errors on this page
	// sourceDirectoryStatus holds an error if the source directory is empty.
	IStatus sourceDirectoryStatus;
	
	/**
	 * Constructor for SomoxProjectPage.
	 */
	public SomoxProjectPage(IWorkbench workbench, IStructuredSelection selection) {
		super("Page1");
		setTitle("New SoMoX Project");
		setDescription("Create a new SoMoX Project");
		this.workbench = workbench;
		this.selection = selection;	
		sourceDirectoryStatus = new Status(IStatus.ERROR, "not_used", 0, "Input directory cannot be null!", null);  
	}
	
	public void createControl(Composite parent) {
		
		// create the composite to hold the widgets
		GridData gd;
		Composite composite =  new Composite(parent, SWT.NULL);
		
		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		gl.numColumns = 3;
		composite.setLayout(gl);
		
		new Label(composite, SWT.NONE).setText("Input directory of source code:");
		sourceDirectory = new Text(composite, SWT.BORDER);
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		sourceDirectory.setLayoutData(gd);
		workspaceButton = new Button(composite,
				SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						sourceDirectory));	

		fileSystemButton = new Button(
				composite, SWT.NONE);
		fileSystemButton.setLayoutData(new GridData());
		fileSystemButton.setText("File System...");
		fileSystemButton
				.addSelectionListener(new SelectionAdapter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @seeorg.eclipse.swt.events.SelectionAdapter#
					 * widgetSelected
					 * (org.eclipse.swt.events.SelectionEvent)
					 */
					public void widgetSelected(SelectionEvent e) {
						String resultOpenFileDialog = "";

						DirectoryDialog dialog = new DirectoryDialog(
								getShell(), SWT.OPEN);
						dialog.setText("Select a folder.");

						if (dialog.open() != null) {
							resultOpenFileDialog = dialog
									.getFilterPath();
						}

						if (!resultOpenFileDialog
								.equals(new String(""))) {
							sourceDirectory.setText(resultOpenFileDialog);
						}
					}
				});
		
		// set the composite as the control for this page
		setControl(composite);		
		addListeners();
	
	}
	
	
	/** Button SelectionListener - call a WorkspaceResourceDialog */
	class WorkspaceButtonSelectionListener extends SelectionAdapter {

		private Text field;

		public WorkspaceButtonSelectionListener(Text field) {
			this.field = field;

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String resultOpenFileDialog = "";
			/** create the dialog message */
			String msg = "Select a folder.";

			IResource dir = null;
			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			IContainer[] dirs = WorkspaceResourceDialog.openFolderSelection(
					getShell(), null, msg, false, null, filters);
			try {
				if (dirs.length != 0) {
					dir = dirs[0];
				}
				if (dir != null) {
					resultOpenFileDialog = dir.getLocation().toOSString();
				}
			} catch (Exception ce) {
				ce.printStackTrace();
			}
			if (!resultOpenFileDialog.equals(new String(""))) {
				field.setText(resultOpenFileDialog);
			}
		}
	}
		
	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {
	    // Initialize a variable with the no error status
	    Status status = new Status(IStatus.OK, "not_used", 0, "", null);
	    // If the event is triggered by the destination or departure fields
	    // set the corresponding status variable to the right value)
	    if ((event.widget == sourceDirectory) || (event.widget == workspaceButton) || (event.widget == fileSystemButton)) {
	        if (!isTextNonEmpty(sourceDirectory)) {
	            status = new Status(IStatus.ERROR, "not_used", 0, 
	                "Input directory cannot be null!", null);        
	            sourceDirectoryStatus = status;
	        } else {
	            sourceDirectoryStatus = status;
	        }
	    }

	    // Show the most serious error
	    applyToStatusLine(sourceDirectoryStatus);
	    setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}
	
	/**
	 * Applies the status to the status line of a dialog page.
	 */
	private void applyToStatusLine(IStatus status) {
		String message= status.getMessage();
		if (message.length() == 0) message= null;
		switch (status.getSeverity()) {
			case IStatus.OK:
				setErrorMessage(null);
				setMessage(message);
				break;
			case IStatus.WARNING:
				setErrorMessage(null);
				setMessage(message, WizardPage.WARNING);
				break;				
			case IStatus.INFO:
				setErrorMessage(null);
				setMessage(message, WizardPage.INFORMATION);
				break;			
			default:
				setErrorMessage(message);
				setMessage(null);
				break;		
		}
	}	
	
	private void addListeners(){
		sourceDirectory.addListener(SWT.KeyUp, this);
		fileSystemButton.addListener(SWT.Selection, this);
		workspaceButton.addListener(SWT.Selection, this);
		
	}
	
	/**
	 * @see IWizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage()
	{
		// There is no more page in the wizard path.
		return false;
	}
	
	private boolean isTextNonEmpty(Text t)
	{
		String s = t.getText();
		if ((s!=null) && (s.trim().length() >0)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Sets the completed field on the wizard class when all the information 
	 * is entered and the wizard can be completed
	 */	 
	public boolean isPageComplete() {
		SomoxProjectWizard wizard = (SomoxProjectWizard)getWizard();
		if (!isTextNonEmpty(sourceDirectory)) {
			wizard.setSomoxProjectPageCompleted(false);
			return false;
		}
		saveDataToModel();
		return true;
	}
	
	private void saveDataToModel()
	{
		SomoxProjectWizard wizard = (SomoxProjectWizard)getWizard();
		wizard.getSomoxProjectWizardModel().setSourceDirectory(sourceDirectory.getText());
		wizard.setSomoxProjectPageCompleted(true);
	}	

}
