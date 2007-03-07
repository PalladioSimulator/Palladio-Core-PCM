/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class PcmDiagramPreferenceInitializer extends
		DiagramPreferenceInitializer {

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return de.uka.ipd.sdq.pcm.gmf.repository.part.RepositoryDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
