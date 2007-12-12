/**
 * 
 */
package de.uka.ipd.sdq.code2model.preferences;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;

/**
 * Initializes the plugin's preferences with their default values when the
 * plugin is loaded.
 * 
 * @author thomas
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
	private static final String wantedApiPkgs = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore prefStore = Activator.getDefault()
				.getPreferenceStore();

		if (prefStore.getDefaultString(
				Code2ModelPreferences.alwaysInternalAction).length() == 0) {
			initializePreferences(prefStore);
		}
	}

	/**
	 * Initialize the settings with sane defaults.
	 * 
	 * @param prefStore
	 *            the {@link IPreferenceStore} to hold the settings
	 */
	private void initializePreferences(IPreferenceStore prefStore) {
		// prefStore.setDefault(Code2ModelPreferences.treatSuperPackageAsExternalPref,
		// false);
		prefStore.setDefault(Code2ModelPreferences.alwaysInternalAction, false);
		prefStore.setDefault(Code2ModelPreferences.separateInternalActionsforAPI, false);
		prefStore.setDefault(Code2ModelPreferences.methodsMustBeInIFace, false);
		prefStore.setDefault(Code2ModelPreferences.repositoryOutputDir, "");
		prefStore.setDefault(Code2ModelPreferences.externalMethods, "");
		prefStore.setDefault(Code2ModelPreferences.wantedApiParts,
				wantedApiPkgs);
		prefStore.setDefault(Code2ModelPreferences.externalClassificationMode,
				Code2ModelPreferences.EXT_CLASSIFICATION_USER);
		prefStore.setDefault(Code2ModelPreferences.treatRelatedPackageAsSelf,
				false);
		prefStore.setDefault(Code2ModelPreferences.log4jConfigDir,
				ResourcesPlugin.getPlugin().getStateLocation().toOSString());
	}

}