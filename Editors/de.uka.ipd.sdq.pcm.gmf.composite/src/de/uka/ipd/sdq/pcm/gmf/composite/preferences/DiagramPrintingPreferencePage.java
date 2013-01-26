/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;

/**
 * The Class DiagramPrintingPreferencePage.
 * 
 * @generated
 */
public class DiagramPrintingPreferencePage extends PrintingPreferencePage {

    /**
     * Instantiates a new diagram printing preference page.
     * 
     * @generated
     */
    public DiagramPrintingPreferencePage() {
        setPreferenceStore(PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance()
                .getPreferenceStore());
    }
}
