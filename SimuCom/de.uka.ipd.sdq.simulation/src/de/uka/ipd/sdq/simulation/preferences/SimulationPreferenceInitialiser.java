package de.uka.ipd.sdq.simulation.preferences;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import de.uka.ipd.sdq.simulation.Activator;

/**
 * Initialises the preferences for {@link SimulationPreferencePage}.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulationPreferenceInitialiser extends AbstractPreferenceInitializer {

    private static final Logger logger = Logger.getLogger(SimulationPreferenceInitialiser.class);

    @Override
    public void initializeDefaultPreferences() {
        // retrieve all available simulation engines and set the first engine as default.
        String firstEngineId = SimulationPreferencesHelper.getDefaultEngineId();

        // set the default simulation engine
        IEclipsePreferences preferences = new DefaultScope().getNode(Activator.PLUGIN_ID);
        preferences.put(SimulationPreferencePage.PREFERENCE_SIMULATION_ENGINE_ID, firstEngineId);
    }

}
