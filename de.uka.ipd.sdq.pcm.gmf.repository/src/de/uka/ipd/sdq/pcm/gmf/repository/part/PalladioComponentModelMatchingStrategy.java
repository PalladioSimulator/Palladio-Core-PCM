/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class PalladioComponentModelMatchingStrategy implements IEditorMatchingStrategy {

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
        if (editorInput instanceof URIEditorInput && input instanceof URIEditorInput) {
            return ((URIEditorInput) editorInput).getURI().equals(((URIEditorInput) input).getURI());
        }
        return false;
    }

}