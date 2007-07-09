package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This wizard allows the user to select a resource. It can be passed an
 * already selected resource which then can be changed. A value of null
 * will leave it up to the user to locate the resource.
 * 
 * The dialog will only succeed if a valid resource file has been selected.
 */
class ResourceSelectorPage extends WizardPage {
	private Text mySelectionText;
	private EObject myResolvedObject;

	/**
	 * @return a valid resource, or null if no valid one has been selected
	 */	
	protected EObject getResolvedObject() {
		return myResolvedObject;
	}

	protected ResourceSelectorPage(String name, EObject selectedResource) {
		super(name);
		setTitle("Diagram resource");
		setDescription("Select the resource to be used for the diagram.");
		myResolvedObject = selectedResource;
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		setControl(topLevel);
		createPageContent(topLevel);
		setPageComplete(validatePage());
	}
	
	/**
	 * creates the SWT widgets used to select and display the resource and initializes them
	 */
	private void createPageContent(Composite parent) {
		Composite panel = new Composite(parent, SWT.NONE);
		panel.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		panel.setLayout(layout);

		Label label = new Label(panel, SWT.NONE);
		label.setText("Selected resource:");
		label.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_BEGINNING));

		mySelectionText = new Text(panel, SWT.READ_ONLY);
		mySelectionText.setText("none");
		if (myResolvedObject != null) {
			mySelectionText.setText(myResolvedObject.eResource().getURI().path());
		}
		mySelectionText.setLayoutData(new GridData(
				GridData.CENTER));
		mySelectionText.pack();

		Button button = new Button(panel, SWT.NONE);
		button.setText("Change");
		button.setLayoutData(new GridData(
				GridData.END));

		button.addMouseListener(new changeButtonHandler());
		setPageComplete(validatePage());
	}

	/** 
	 * @return true, if a valid resource file has been selected and resolved
	 */	
	protected boolean validatePage() {
		if (myResolvedObject == null) {
			setErrorMessage("No or invalid resource selected");
			return false;
		}

		setErrorMessage(null);
		return true;
	}

	/**
	 * checks if the selected file is a valid resource
	 */	
	private void resolveSelection() {
		myResolvedObject = null;
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
		.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		try {
			Resource resource = resourceSet.getResource(URI.createURI(mySelectionText.getText(),true), true);
			myResolvedObject = (EObject) resource.getContents().get(0);

		} catch (WrappedException ex) {
			//do nothing
		}	
	}

	private class changeButtonHandler  implements
	org.eclipse.swt.events.MouseListener {

		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			//do nothing
		}

		public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
			LoadResourceDialog loadResourceDialog = new LoadResourceDialog(getShell());
			if (loadResourceDialog.open() == Window.OK) {
				if (loadResourceDialog.getURIText() != "") {
					mySelectionText.setText(loadResourceDialog.getURIText());
				}
			}
			mySelectionText.pack();
			resolveSelection();
			setPageComplete(validatePage());
		}

		public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
			//do nothing
		}
	}	
}