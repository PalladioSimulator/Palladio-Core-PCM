package de.uka.ipd.sdq.simulation.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import de.uka.ipd.sdq.simulation.abstractsimengine.Activator;

/**
 * Initialises the preferences for {@link SimulationPreferencePage}.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulationPreferenceInitialiser extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        // retrieve all available simulation engines and set the first engine as default.
        String firstEngineId = SimulationPreferencesHelper.getDefaultEngineId();

        // set the default simulation engine
        IEclipsePreferences preferences = DefaultScope.INSTANCE.getNode(Activator.PLUGIN_ID);
        preferences.put(SimulationPreferencePage.PREFERENCE_SIMULATION_ENGINE_ID, firstEngineId);
    }

}
