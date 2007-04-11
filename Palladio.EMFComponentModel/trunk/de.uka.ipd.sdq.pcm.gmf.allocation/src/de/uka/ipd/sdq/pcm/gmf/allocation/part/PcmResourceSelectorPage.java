package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

class ResourceSelectorPage extends WizardPage {
	private Text mySelectionText;
	private EObject myResolvedObject;

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

	protected boolean validatePage() {
		if (myResolvedObject == null) {
			setErrorMessage("No resource selected");
			return false;
		}

		setErrorMessage(null);
		return true;
	}

	private void resolveSelection() {
		myResolvedObject = null;
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
		.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		try {
			Resource resource = resourceSet.getResource(URI.createURI(mySelectionText.getText(),true), true);
			myResolvedObject = (EObject) resource.getContents().get(0);

		} catch (WrappedException ex) {
			PcmDiagramEditorPlugin
			.getInstance()
			.logError(
					"Unable to load resource: " + mySelectionText.getText(), ex); //$NON-NLS-1$
		}	
	}

	private class changeButtonHandler  implements
	org.eclipse.swt.events.MouseListener {

		@Override
		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			//do nothing

		}

		@Override
		public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
			LoadResourceDialog loadResourceDialog = new LoadResourceDialog(getShell());
			loadResourceDialog.open();
			mySelectionText.setText(loadResourceDialog.getURIText());
			mySelectionText.pack();
			resolveSelection();
			setPageComplete(validatePage());

		}

		@Override
		public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
			//do nothing

		}
	}	
}