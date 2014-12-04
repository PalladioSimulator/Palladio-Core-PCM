	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

	/**
 * @generated
 */
public class PalladioComponentModelMatchingStrategy implements org.eclipse.ui.IEditorMatchingStrategy {

		/**
 * @generated
 */
public boolean matches(org.eclipse.ui.IEditorReference editorRef, org.eclipse.ui.IEditorInput input) {
	org.eclipse.ui.IEditorInput editorInput;
	try {
		editorInput = editorRef.getEditorInput();
	} catch (org.eclipse.ui.PartInitException e) {
		return false;
	}
        
	if (editorInput.equals(input)) {
		return true;
	}
	if (editorInput instanceof org.eclipse.emf.common.ui.URIEditorInput && input instanceof org.eclipse.emf.common.ui.URIEditorInput) {
		return ((org.eclipse.emf.common.ui.URIEditorInput) editorInput).getURI().equals(((org.eclipse.emf.common.ui.URIEditorInput) input).getURI());
	}
	return false;
}

}
