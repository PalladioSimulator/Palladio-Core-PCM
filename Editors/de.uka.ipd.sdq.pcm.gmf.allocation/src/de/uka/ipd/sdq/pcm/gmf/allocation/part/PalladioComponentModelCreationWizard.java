/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class PalladioComponentModelCreationWizard extends Wizard implements
		INewWizard {

	private ResourceEnvironmentSelectorPage myResourceEnvironmentSelectorPage;
	private SystemSelectorPage mySystemSelectorPage;

	public PalladioComponentModelCreationWizard() {
		myResourceEnvironmentSelectorPage = new ResourceEnvironmentSelectorPage(
				null);
		mySystemSelectorPage = new SystemSelectorPage(null);
	}

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected PalladioComponentModelCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected PalladioComponentModelCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(
			boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.PalladioComponentModelCreationWizardTitle);
		setDefaultPageImageDescriptor(PalladioComponentModelAllocationDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewAllocationWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated not
	 */
	public void addPages() {
		diagramModelFilePage = new PalladioComponentModelCreationWizardPage(
				"DiagramModelFile", getSelection(), "allocation_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle("Create allocation Diagram");
		diagramModelFilePage
				.setDescription("Select file that will contain diagram model.");
		addPage(diagramModelFilePage);

		domainModelFilePage = new PalladioComponentModelCreationWizardPage(
				"DomainModelFile", getSelection(), "allocation"); //$NON-NLS-1$ //$NON-NLS-2$
		domainModelFilePage.setTitle("Create allocation Diagram");
		domainModelFilePage
				.setDescription("Select file that will contain domain model.");
		addPage(domainModelFilePage);

		addPage(myResourceEnvironmentSelectorPage);
		addPage(mySystemSelectorPage);
	}

	/**
	 * @generated not
	 * 
	 * @return a boolean
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				diagram = PalladioComponentModelDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(),
								domainModelFilePage.getURI(),
								mySystemSelectorPage.getSelectedSystem(),
								myResourceEnvironmentSelectorPage
										.getSelectedResourceEnvironment(),
								monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						PalladioComponentModelDiagramEditorUtil
								.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								"Error opening diagram editor", null, e
										.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						"Creation Problems", null, ((CoreException) e
								.getTargetException()).getStatus());
			} else {
				PalladioComponentModelAllocationDiagramEditorPlugin
						.getInstance()
						.logError(
								"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
