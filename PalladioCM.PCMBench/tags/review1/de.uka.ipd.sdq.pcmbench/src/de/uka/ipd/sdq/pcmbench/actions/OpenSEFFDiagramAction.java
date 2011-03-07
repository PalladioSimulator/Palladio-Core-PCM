package de.uka.ipd.sdq.pcmbench.actions;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.MySeffDiagramEditor;
import de.uka.ipd.sdq.pcmbench.gmfintegration.FileAndDiagramElementEditorInput;

public class OpenSEFFDiagramAction extends Action {

	public final static String ID = "de.uka.ipd.sdq.pcmbench.actions.OpenSEFFDiagramAction";
	private IWorkbenchWindow window = null;
	private Shell shell = null;
	private EObject selectedEObject;
	private IWorkbenchPage page;
	private ISelectionProvider provider;
	private IProject selectedProject;
	
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	
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

		final Resource diagramResource = editingDomain.getResourceSet()
				.getResource(URI.createPlatformResourceURI(diagramFile
						.getFullPath().toString()),true);
		boolean diagramExists = false;
		Diagram diagramRoot = null;
		for (Iterator it = diagramResource.getContents().iterator(); it.hasNext(); )
	    {
	    	EObject node = (EObject)it.next();
	    	if (node instanceof Diagram)
	    	{
	    		Diagram foundDiagram = (Diagram)node;
	    		if (foundDiagram.getElement() == selectedEObject)
	    		{
	    			diagramExists = true;
	    			diagramRoot = foundDiagram;
	    			break;
	    		}
	    	}
	    }

		if (!diagramExists)
		{	
			int diagramVID = PcmVisualIDRegistry.getDiagramVisualID(myDiagramRoot);
			if (diagramVID != ResourceDemandingSEFFEditPart.VISUAL_ID) {
				PcmDiagramEditorPlugin.getInstance().logError(
						"Unable to create diagram - diagram root invalid"); //$NON-NLS-1$
				return;
			}
			final Diagram diagram = ViewService.createDiagram(myDiagramRoot,
							ResourceDemandingSEFFEditPart.MODEL_ID,
							PcmDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			// TODO: We need a transaction to modify the resource here.
			RecordingCommand cmd = new RecordingCommand(editingDomain){

				@Override
				protected void doExecute() {
					diagramResource.getContents().add(diagram);
				}
				
			};
			editingDomain.getCommandStack().execute(cmd);
			diagramRoot = diagram;
		}
		try {
			// diagramResource.save(Collections.EMPTY_MAP);
			page.openEditor(new FileAndDiagramElementEditorInput(diagramFile,diagramRoot), MySeffDiagramEditor.ID);
		} catch (PartInitException ex) {
			PcmDiagramEditorPlugin.getInstance().logError(
					"Unable to open editor", ex); //$NON-NLS-1$
		}
	}

	private IFile createFile() {
		IFile newFile = selectedProject.getFile("diagram.my_seff_diagram");
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
				if (sSelection instanceof TreeSelection)
				{
					TreeSelection treeSelection = ((TreeSelection)sSelection);
					if (treeSelection.getPaths()[0].getFirstSegment() instanceof IProject)
					{
						selectedProject = (IProject)treeSelection.getPaths()[0].getFirstSegment();
						return true;
					}
				}
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
