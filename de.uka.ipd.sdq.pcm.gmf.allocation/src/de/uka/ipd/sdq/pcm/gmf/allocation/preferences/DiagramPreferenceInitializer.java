/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.preferences;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {

	/**
 * @generated
 */
	public void initializeDefaultPreferences() {
		org.eclipse.jface.preference.IPreferenceStore store = getPreferenceStore();
		de.uka.ipd.sdq.pcm.gmf.allocation.preferences.DiagramGeneralPreferencePage.initDefaults(store);
de.uka.ipd.sdq.pcm.gmf.allocation.preferences.DiagramAppearancePreferencePage.initDefaults(store);
de.uka.ipd.sdq.pcm.gmf.allocation.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
de.uka.ipd.sdq.pcm.gmf.allocation.preferences.DiagramPrintingPreferencePage.initDefaults(store);
de.uka.ipd.sdq.pcm.gmf.allocation.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
 * @generated
 */
	protected org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {
		return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
} 
