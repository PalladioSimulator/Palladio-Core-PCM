package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.ui.editors.text.TextEditor;

/**
 * An xml editor.
 */
public class XMLEditor extends TextEditor {

    /**
     * A color manager.
     */
    private ColorManager colorManager;

    /**
     * Initialized the xml editor.
     */
    public XMLEditor() {
        super();
        colorManager = new ColorManager();
        setSourceViewerConfiguration(new XMLConfiguration(colorManager));
        setDocumentProvider(new XMLDocumentProvider());
    }

    /**
     * Disposes the xml editor.
     */
    public void dispose() {
        colorManager.dispose();
        super.dispose();
    }

}
