package de.uka.ipd.sdq.simulation.abstractsimengine.preferences;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import de.uka.ipd.sdq.simulation.abstractsimengine.Activator;
import de.uka.ipd.sdq.simulation.abstractsimengine.util.AbstractSimEnginePreferencesHelper;

/**
 * Initialises the preferences for {@link AbstractSimEnginePreferencePage}.
 * 
 * @author Philipp Merkle
 * 
 */
public class AbstractSimEnginePreferenceInitialiser extends AbstractPreferenceInitializer {

    private static final Logger logger = Logger.getLogger(AbstractSimEnginePreferenceInitialiser.class);

    @Override
    public void initializeDefaultPreferences() {
        // retrieve all available simulation engines and set the first engine as default.
        String firstEngineId = AbstractSimEnginePreferencesHelper.getDefaultEngineId();

        // set the default simulation engine
        IEclipsePreferences preferences = new DefaultScope().getNode(Activator.PLUGIN_ID);
        preferences.put(AbstractSimEnginePreferencePage.PREFERENCE_SIMULATION_ENGINE_ID, firstEngineId);
    }

}
