/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

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
        setPreferenceStore(PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getPreferenceStore());
    }
}
