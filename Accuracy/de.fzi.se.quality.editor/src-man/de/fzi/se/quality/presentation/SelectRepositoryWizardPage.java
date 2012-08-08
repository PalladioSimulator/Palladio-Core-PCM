/**
 * 
 */
package de.fzi.se.quality.presentation;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**Allows to select a Palladio repository file.
 * Supports preselection of files.
 * @author groenda
 *
 */
public class SelectRepositoryWizardPage extends WizardPage implements ModifyListener {
	/** Default value for the repository. */
	private String DEFAULT_REPOSITORY_URI = "";
	/** Text field for the repository URI. */
	protected Text txtRepository;
	/** The selection used to determine the repository. */
	protected IStructuredSelection selection;
	
	/**Creates a new page.
	 * @param pageName Name of the page.
	 */
	public SelectRepositoryWizardPage(String pageName) {
		super(pageName);
		setMessage("Select the repository for which the defaults should be created.");
	}

	/**Initializes the page.
	 * @param selection Preselected repository file.
	 */
	public void init(IStructuredSelection selection) {
		this.selection = selection;
	}
	
	/**
	 * @return EMF-parsable URI of the selected repository file.
	 */
	public String getRepositoryFileUri() {
		return txtRepository.getText();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		setControl(root);
		root.setLayout(new GridLayout());
		txtRepository = new Text(root, SWT.BORDER);
		txtRepository.setText(DEFAULT_REPOSITORY_URI);
		TabHelper.createFileInputSection(root, this, "Repository", ConstantsContainer.REPOSITORY_EXTENSION, txtRepository, "Select Repository file", getShell(), DEFAULT_REPOSITORY_URI);
		// Preselect File if possible
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
		            String portableString = selectedResource.getFullPath().toOSString();
		            String target = "platform:/resource" + portableString;
		            if (target.endsWith(".repository")) {
						txtRepository.setText(target);
		            }
				}
			}
		}
		validate();
	}

	/** Validates the input on this pages and set the status accordingly.
	 */
	protected void validate() {
		if (txtRepository.getText().equals(DEFAULT_REPOSITORY_URI)) {
			setErrorMessage("Select a repository file.");
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}
	}
	
	@Override
	public void modifyText(ModifyEvent e) {
		validate();
	}

}
