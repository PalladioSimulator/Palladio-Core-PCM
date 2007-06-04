/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

/**
 * @author roman
 *
 */
public class ConfigEditorInputFactory implements IElementFactory {

	/**
	 * Factory id. The workbench plug-in registers a factory by this name with
	 * the "org.eclipse.ui.elementFactories" extension point.
	 */
	private static final String ID_FACTORY = "de.uka.ipd.sdq.sensorframework.visualisation.configEditorInputFactory"; 
	
	/** Tags */
    private static final String EXPERIMENT = "Experiment"; //$NON-NLS-1$
    private static final String EXPERIMENT_RUN = "ExperimentRun"; //$NON-NLS-1$
    private static final String SENSOR_NAME = "SensorName"; //$NON-NLS-1$
    private static final String SENSOR_ID = "SensorId"; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	public IAdaptable createElement(IMemento memento) {
		ConfigEntry configEntry = new ConfigEntry(getExperimentRun(memento),
				getExperiment(memento), getSensor(memento));
		return new ConfigEditorInput(configEntry);
	}

	 /**
     * Returns the element factory id for this class.
     * 
     * @return the element factory id
     */
    public static String getFactoryId() {
        return ID_FACTORY;
    }

    /**
     * Saves the state of the given file editor input into the given memento.
     *
     * @param memento the storage area for element state
     * @param input the file editor input
     */
    public static void saveState(IMemento memento, ConfigEditorInput input) {
		for (ConfigEntry entry : input.getConfigEntrys()) {
			memento.putString(EXPERIMENT, Long.toString(entry.getExperiment()
					.getExperimentID()));
			memento.putString(EXPERIMENT_RUN, Long.toString(entry.getExperimentRun()
					.getExperimentRunID()));
			for (Sensor sensor : entry.getSensors()) {
				memento.putString(SENSOR_NAME, sensor.getSensorName());
				memento.putString(SENSOR_ID, sensor.getSensorID() + "");
			}
		}
	}
	
    private Sensor getSensor(IMemento memento) {
		String sensorId = memento.getString(SENSOR_ID);
		String sensorName = memento.getString(SENSOR_NAME);

		//TODO Datasource mit abspeichern
		IDAOFactory data = SensorFrameworkDataset
				.singleton().getMemoryDataset();
		return data.createSensorDAO().get(Long.parseLong(sensorId));
	}
    
    private ExperimentRun getExperimentRun(IMemento memento) {
		String experimentRun = memento.getString(EXPERIMENT_RUN);

		//TODO Datasource mit abspeichern
		IDAOFactory data = SensorFrameworkDataset
				.singleton().getMemoryDataset();
		return data.createExperimentRunDAO().get(Long.parseLong(experimentRun));
	}
    
    private Experiment getExperiment(IMemento memento) {
		String experiment = memento.getString(EXPERIMENT);

		//TODO Datasource mit abspeichern
		IDAOFactory data = SensorFrameworkDataset
				.singleton().getMemoryDataset();
		return data.createExperimentDAO().get(Long.parseLong(experiment));
	}
}
