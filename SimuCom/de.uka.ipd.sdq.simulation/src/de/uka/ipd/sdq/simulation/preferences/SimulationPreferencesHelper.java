package de.uka.ipd.sdq.simulation.preferences;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.simulation.Activator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.util.AbstractSimEngineExtensionHelper;

public class SimulationPreferencesHelper {

    private static final Logger logger = Logger.getLogger(SimulationPreferencesHelper.class);

    /**
     * Returns the default simulation engine. The default engine is the first entry in the list of
     * extensions.
     */
    public static String getDefaultEngineId() {
        // retrieve all available simulation engines and set the first engine as default.
        String firstEngineId = null;
        try {
            String[][] engineNamesAndIds = AbstractSimEngineExtensionHelper.getEngineNamesAndIds();
            if (engineNamesAndIds.length > 0) {
                firstEngineId = engineNamesAndIds[0][1];
            }
        } catch (CoreException e) {
            logger.warn("Could not retrieve simulation engine names and ids.", e);
        }
        return firstEngineId;
    }

    public static ISimEngineFactory getPreferredSimulationEngine() {
        // retrieve the id of the preferred engine
        String preferredEngineId = Platform.getPreferencesService().getString(Activator.PLUGIN_ID,
                SimulationPreferencePage.PREFERENCE_SIMULATION_ENGINE_ID, getDefaultEngineId(), null);

        // retrieve simulation engine factory for the preferred engine
        ISimEngineFactory engineFactory = null;
        try {
            engineFactory = AbstractSimEngineExtensionHelper.getEngineFactory(preferredEngineId);
        } catch (CoreException e) {
            logger.warn("Could not retrieve simulation engine factory.", e);
        }
        
        return engineFactory;
    }

}
