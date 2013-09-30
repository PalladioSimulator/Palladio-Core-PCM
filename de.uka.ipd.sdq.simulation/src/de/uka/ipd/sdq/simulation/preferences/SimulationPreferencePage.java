package de.uka.ipd.sdq.simulation.preferences;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.uka.ipd.sdq.simulation.Activator;
import de.uka.ipd.sdq.simulation.abstractsimengine.util.AbstractSimEngineExtensionHelper;

/**
 * The preference page for the abstract simulation engine.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private static final Logger logger = Logger.getLogger(SimulationPreferencePage.class);

    /** the id for the simulation engine preference **/
    public static final String PREFERENCE_SIMULATION_ENGINE_ID = "simulationEngineField";

    /**
     * Default constructor.
     */
    public SimulationPreferencePage() {
        // use grid layout
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        this.setDescription("Select the simulation engine to be used for simulation runs.");
        this.setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        // retrieve simulation engine names and ids
        String[][] engineNamesAndIds = null;
        try {
            engineNamesAndIds = AbstractSimEngineExtensionHelper.getEngineNamesAndIds();
        } catch (CoreException e) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Could not retrieve simulation engine names and ids.", e);
        }

        // create field editor
        ComboFieldEditor simulationEngineEditor = new ComboFieldEditor(PREFERENCE_SIMULATION_ENGINE_ID,
                "Simulation Engine", engineNamesAndIds, getFieldEditorParent());
        addField(simulationEngineEditor);

    }

}
