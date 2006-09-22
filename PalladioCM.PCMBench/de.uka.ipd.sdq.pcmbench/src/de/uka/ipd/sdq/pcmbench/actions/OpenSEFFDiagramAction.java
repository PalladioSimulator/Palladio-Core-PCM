package de.uka.ipd.sdq.pcmbench.actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.MySeffDiagramEditor;

public class OpenSEFFDiagramAction extends Action {

	public final static String ID = "de.uka.ipd.sdq.pcmbench.actions.OpenSEFFDiagramAction";
	private IWorkbenchWindow window = null;
	private Shell shell = null;
	private EObject selectedEObject;
	private IWorkbenchPage page;
	private ISelectionProvider provider;
	
	
	public OpenSEFFDiagramAction(IWorkbenchPage p, ISelectionProvider selectionProvider) {
		setText("Open Property"); //$NON-NLS-1$
		page = p;
		provider = selectionProvider;
	}	
	
	public void dispose() {
	}
	
	public void init(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Open SEFF Diagram");
		setToolTipText("Opens a new SEFF diagramm on the respective SEFF");
		shell = window.getShell();
	}

	public void run(IAction action) {
		final EObject myDiagramRoot = selectedEObject;
		IFile diagramFile = createFile();
		try {
			diagramFile.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			PcmDiagramEditorPlugin.getInstance().logError(
					"Unable to set charset for diagram file", e); //$NON-NLS-1$
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		final Resource diagramResource = resourceSet
				.createResource(URI.createPlatformResourceURI(diagramFile
						.getFullPath().toString()));

		int diagramVID = PcmVisualIDRegistry.getDiagramVisualID(myDiagramRoot);
		if (diagramVID != ResourceDemandingSEFFEditPart.VISUAL_ID) {
			PcmDiagramEditorPlugin.getInstance().logError(
					"Unable to create diagram - diagram root invalid"); //$NON-NLS-1$
			return;
		}
		Diagram diagram = ViewService.createDiagram(myDiagramRoot,
						ResourceDemandingSEFFEditPart.MODEL_ID,
						PcmDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		diagramResource.getContents().add(diagram);
		try {
			diagramResource.save(Collections.EMPTY_MAP);
			page.openEditor(new FileEditorInput(diagramFile), MySeffDiagramEditor.ID);
		} catch (IOException ex) {
			PcmDiagramEditorPlugin
					.getInstance()
					.logError(
							"Save operation failed for: " + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$
		} catch (PartInitException ex) {
			PcmDiagramEditorPlugin.getInstance().logError(
					"Unable to open editor", ex); //$NON-NLS-1$
		}
	}

	private IFile createFile() {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject myProject = myWorkspaceRoot.getProject("x");
		IFile newFile = myProject.getFile("diagram.my_seff_diagram");
		InputStream is = new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<xmi:XMI xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"/>");
		try {
			if (!newFile.exists())
				newFile.create(is, true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFile;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	public boolean isEnabled() {
		ISelection selection = provider.getSelection();
		if(!selection.isEmpty()) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			if(sSelection.size() == 1 && 
			   sSelection.getFirstElement() instanceof ResourceDemandingSEFF) 
			{
				selectedEObject = ((ResourceDemandingSEFF)sSelection.getFirstElement()); 				
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		run(this);
	}

}
