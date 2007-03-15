/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;

import org.eclipse.gmf.runtime.notation.Diagram;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class PalladioComponentModelMatchingStrategy implements
		IEditorMatchingStrategy {

	/**
	 * @generated
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput input) {
		IEditorInput editorInput;
		try {
			editorInput = editorRef.getEditorInput();
		} catch (PartInitException e) {
			return false;
		}

		if (editorInput.equals(input)) {
			return true;
		}

		if (editorInput instanceof IFileEditorInput
				&& input instanceof IFileEditorInput) {
			return ((IFileEditorInput) editorInput).getFile().equals(
					((IFileEditorInput) input).getFile());
		}

		IEditorPart editor = editorRef.getEditor(false);
		if (input instanceof DiagramEditorInput
				&& editor instanceof PalladioComponentModelUsageDiagramEditor) {
			Diagram editorDiagram = ((PalladioComponentModelUsageDiagramEditor) editor)
					.getDiagram();
			Diagram otherDiagram = ((DiagramEditorInput) input).getDiagram();
			return equals(editorDiagram, otherDiagram);
		}
		return false;
	}

	/**
	 * @generated
	 */
	private boolean equals(Diagram editorDiagram, Diagram otherDiagram) {
		Resource editorResource = editorDiagram.eResource();
		Resource otherResource = otherDiagram.eResource();
		if (editorResource != null && otherResource != null) {
			URI editorURI = editorResource.getURI();
			URI otherURI = otherResource.getURI();
			String editorURIFragment = editorResource
					.getURIFragment(editorDiagram);
			String otherURIFragment = otherResource
					.getURIFragment(otherDiagram);
			return editorURI.equals(otherURI)
					&& editorURIFragment.equals(otherURIFragment);
		}
		return false;
	}

}