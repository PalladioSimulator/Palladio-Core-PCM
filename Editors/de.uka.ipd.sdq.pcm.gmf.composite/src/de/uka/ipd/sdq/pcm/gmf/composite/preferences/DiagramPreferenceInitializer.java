/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;

/**
 * The Class DiagramPreferenceInitializer.
 * 
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

    /**
     * Initialize default preferences.
     * 
     * @generated
     */
    public void initializeDefaultPreferences() {
        IPreferenceStore store = getPreferenceStore();
        DiagramGeneralPreferencePage.initDefaults(store);
        DiagramAppearancePreferencePage.initDefaults(store);
        DiagramConnectionsPreferencePage.initDefaults(store);
        DiagramPrintingPreferencePage.initDefaults(store);
        DiagramRulersAndGridPreferencePage.initDefaults(store);

    }

    /**
     * Gets the preference store.
     * 
     * @return the preference store
     * @generated
     */
    protected IPreferenceStore getPreferenceStore() {
        return PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().getPreferenceStore();
    }
}
