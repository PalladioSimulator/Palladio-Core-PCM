/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;

/**
 * The Class PalladioComponentModelMatchingStrategy.
 *
 * @generated
 */
public class PalladioComponentModelMatchingStrategy implements IEditorMatchingStrategy {

    /**
     * Matches.
     *
     * @param editorRef the editor ref
     * @param input the input
     * @return true, if successful
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