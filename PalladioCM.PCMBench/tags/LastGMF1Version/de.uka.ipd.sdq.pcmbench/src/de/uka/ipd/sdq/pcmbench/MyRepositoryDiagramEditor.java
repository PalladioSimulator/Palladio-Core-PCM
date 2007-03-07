package de.uka.ipd.sdq.pcmbench;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import de.uka.ipd.sdq.pcm.gmf.repository.part.RepositoryDiagramEditor;

public class MyRepositoryDiagramEditor extends RepositoryDiagramEditor {

	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain"; //$NON-NLS-1$

	public static final String ID = "de.uka.ipd.sdq.pcm.gmf.repository.part.MyRepositoryDiagramEditorID"; //$NON-NLS-1$

	public MyRepositoryDiagramEditor() {
		super();
	}

	protected String getEditingDomainID() {
		return EDITING_DOMAIN_ID; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub
		super.initializeGraphicalViewer();

		getDiagramGraphicalViewer().addDropTargetListener(
				(TransferDropTargetListener) new DiagramDropTargetListener(
						getDiagramGraphicalViewer(), LocalSelectionTransfer
								.getInstance()) {
					protected List getObjectsBeingDropped() {
						TransferData[] data = getCurrentEvent().dataTypes;
						List eObjects = new ArrayList();

						for (int i = 0; i < data.length; i++) {
							if (LocalSelectionTransfer.getInstance().isSupportedType(
									data[i])) {
								IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
										.getInstance().nativeToJava(data[i]);
								eObjects.addAll(selection.toList());
							}
						}
						return eObjects;
					}

					public boolean isEnabled(DropTargetEvent event) {
						if (super.isEnabled(event)) {
							Object modelObj = getViewer().getContents()
									.getModel();
							if (modelObj instanceof EObject) {
								List eObjects = getDropObjectsRequest()
										.getObjects();

								if (eObjects == null)
									return false;

								return true;
							}
						}

						return false;
					}
				});
	}
}
