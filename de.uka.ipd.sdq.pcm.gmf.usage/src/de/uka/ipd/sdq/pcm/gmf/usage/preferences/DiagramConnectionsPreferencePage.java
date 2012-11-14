/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * The Class DiagramConnectionsPreferencePage.
 *
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

    /**
     * Instantiates a new diagram connections preference page.
     *
     * @generated
     */
    public DiagramConnectionsPreferencePage() {
        setPreferenceStore(PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getPreferenceStore());
    }
}
