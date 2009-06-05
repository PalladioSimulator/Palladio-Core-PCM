/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.gmfintegration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PcmDocumentProvider;
import de.uka.ipd.sdq.pcmbench.PCMBenchActivator;

/**
 * @author Snowball
 *
 */
public class PcmMultipleDocumentProvider extends PcmDocumentProvider {
	
	private String diagramElementUri;
	
	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		// TODO Unload the diagram resource only if it was the last open
		// super.disposeElementInfo(element, info);
		if (info instanceof FileInfo) {
			FileInfo fileInfo= (FileInfo) info;
			if (fileInfo.fFileSynchronizer != null)
				fileInfo.fFileSynchronizer.uninstall();
		}
	}

	@Override
	protected void handleElementContentChanged(IFileEditorInput fileEditorInput) {
		// TODO Unload diagram only if the closed diagram was the last diagram
		// super.handleElementContentChanged(fileEditorInput);
	}

	@Override
	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		if (editorInput instanceof FileAndDiagramElementEditorInput)
		{
			FileAndDiagramElementEditorInput input = (FileAndDiagramElementEditorInput)editorInput;
			diagramElementUri = input.getDiagramRootElementUriFragment();
		}
		return super.createInputWithEditingDomain(editorInput, domain);
	}

	@Override
	protected void setDocumentContentFromStorage(IDocument document, IStorage storage) throws CoreException {
		Diagram diagram = (Diagram)document.getContent();
		if(diagram != null) {
			Resource resource = diagram.eResource();
			IFile resourceFile = WorkspaceSynchronizer.getFile(resource);
			// unload if the resourceFile and storage is same.
			// if not same throw exception.
			if(resourceFile != null) {
				if(resourceFile.equals(storage)) {
					document.setContent(null);
				} else {
					throw new CoreException(new Status(IStatus.ERROR, PCMBenchActivator.PLUGIN_ID, -1, "Content changed unexpectedly", null));
				}
			}
		}
		IDiagramDocument diagramDocument = (IDiagramDocument)document;
		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();

		URI uri = URI.createPlatformResourceURI(storage.getFullPath()
                .toString(), true);
		Resource diagramResource = domain.getResourceSet().getResource(uri, true);
		diagram = (Diagram)diagramResource.getEObject(diagramElementUri);
		document.setContent(diagram);
	}
}
