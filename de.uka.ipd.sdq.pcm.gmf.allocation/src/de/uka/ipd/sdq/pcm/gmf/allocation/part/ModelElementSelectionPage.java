/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * Wizard page that allows to select element from model.
 * @generated
 */
public class ModelElementSelectionPage extends org.eclipse.jface.wizard.WizardPage {
	/**
 * @generated
 */
protected org.eclipse.emf.ecore.EObject selectedModelElement;

/**
 * @generated
 */
private org.eclipse.jface.viewers.TreeViewer modelViewer;

	/**
 * @generated
 */
public ModelElementSelectionPage(String pageName) {
	super(pageName);
}

	/**
 * @generated
 */
public org.eclipse.emf.ecore.EObject getModelElement() {
	return selectedModelElement;
}

	/**
 * @generated
 */
public void setModelElement(org.eclipse.emf.ecore.EObject modelElement) {
	selectedModelElement = modelElement;
	if (modelViewer != null) {
		if (selectedModelElement != null) {
			modelViewer.setInput(selectedModelElement.eResource());
			modelViewer.setSelection(new org.eclipse.jface.viewers.StructuredSelection(selectedModelElement));
		} else {
			modelViewer.setInput(null);
		}
		setPageComplete(validatePage());
	}
}

	/**
 * @generated
 */
public void createControl(org.eclipse.swt.widgets.Composite parent) {
	initializeDialogUnits(parent);

	org.eclipse.swt.widgets.Composite plate = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
	plate.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_BOTH));
	org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
	layout.marginWidth = 0;
	plate.setLayout(layout);
	setControl(plate);

	org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(plate, org.eclipse.swt.SWT.NONE);
	label.setText(getSelectionTitle());
	label.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING));

	modelViewer = new org.eclipse.jface.viewers.TreeViewer(
			plate, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.H_SCROLL | org.eclipse.swt.SWT.V_SCROLL | org.eclipse.swt.SWT.BORDER);
	org.eclipse.swt.layout.GridData layoutData = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_BOTH);
	layoutData.heightHint = 300;
	layoutData.widthHint = 300;
	modelViewer.getTree().setLayoutData(layoutData);
	modelViewer.setContentProvider(new org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
	modelViewer.setLabelProvider(new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
	if (selectedModelElement != null) {
		modelViewer.setInput(selectedModelElement.eResource());
		modelViewer.setSelection(new org.eclipse.jface.viewers.StructuredSelection(selectedModelElement));
	}
	modelViewer.addSelectionChangedListener(new org.eclipse.jface.viewers.ISelectionChangedListener() {
		public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
			ModelElementSelectionPage.this.updateSelection((org.eclipse.jface.viewers.IStructuredSelection) event.getSelection());
		}
	});

	setPageComplete(validatePage());
}

	/**
 * Override to provide custom model element description.
 * @generated
 */
protected String getSelectionTitle() {
	return de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.ModelElementSelectionPageMessage;
}

	/**
 * @generated
 */
protected void updateSelection(org.eclipse.jface.viewers.IStructuredSelection selection) {
	selectedModelElement = null;
	if (selection.size() == 1) {
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof org.eclipse.emf.edit.provider.IWrapperItemProvider) {
			selectedElement = ((org.eclipse.emf.edit.provider.IWrapperItemProvider) selectedElement).getValue();
		}
		if (selectedElement instanceof org.eclipse.emf.ecore.util.FeatureMap.Entry) {
			selectedElement = ((org.eclipse.emf.ecore.util.FeatureMap.Entry) selectedElement).getValue();
		}
		if (selectedElement instanceof org.eclipse.emf.ecore.EObject) {
			selectedModelElement = (org.eclipse.emf.ecore.EObject) selectedElement;
		}
	}
	setPageComplete(validatePage());
}

	/**
 * Override to provide specific validation of the selected model element.
 * @generated
 */
protected boolean validatePage() {
	return true;
}

	}
