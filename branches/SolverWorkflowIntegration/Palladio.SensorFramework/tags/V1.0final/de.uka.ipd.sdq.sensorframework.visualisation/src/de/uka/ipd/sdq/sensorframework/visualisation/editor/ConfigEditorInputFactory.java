package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

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
    private static final String DATASOURCE = "Datasource"; //$NON-NLS-1$
    private static final String EXPERIMENT = "Experiment"; //$NON-NLS-1$
    private static final String EXPERIMENT_RUN = "ExperimentRun"; //$NON-NLS-1$
    private static final String SENSOR_NAME = "SensorName"; //$NON-NLS-1$
    private static final String SENSOR_ID = "SensorId"; //$NON-NLS-1$

	private static final String ADAPTER_FACTORY_ID_ID = "AdpaterFactoryIDID";
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	public IAdaptable createElement(IMemento memento) {
		ConfigEntry configEntry = null;
		try
		{
			configEntry =new ConfigEntry(
				getDatasource(memento),
				getExperimentRun(memento),
				getExperiment(memento), 
				getSensor(memento));
		} catch(Exception e) {
			return null;
		}
		return new ConfigEditorInput(getAdapterFactoryID(memento),configEntry);
	}

	 private String getAdapterFactoryID(IMemento memento) {
		// TODO Auto-generated method stub
		return memento.getString(ADAPTER_FACTORY_ID_ID);
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
			memento.putString(DATASOURCE, Long.toString(entry.getDatasource().
					getID()));
			memento.putString(EXPERIMENT, Long.toString(entry.getExperiment()
					.getExperimentID()));
			memento.putString(EXPERIMENT_RUN, Long.toString(entry.getExperimentRun()
					.getExperimentRunID()));
			for (Sensor sensor : entry.getSensors()) {
				memento.putString(SENSOR_NAME, sensor.getSensorName());
				memento.putString(SENSOR_ID, sensor.getSensorID() + "");
			}
		}
		memento.putString(ADAPTER_FACTORY_ID_ID, input.getAdapterFactoryID());
	}
	
    private Sensor getSensor(IMemento memento) {
		String sensorId = memento.getString(SENSOR_ID);
		if (sensorId == null)
			return null;

		IDAOFactory data = getDatasource(memento);
		return data.createSensorDAO().get(Long.parseLong(sensorId));
	}
    
    private ExperimentRun getExperimentRun(IMemento memento) {
		String experimentRun = memento.getString(EXPERIMENT_RUN);
		if (experimentRun == null)
			return null;
		IDAOFactory data = getDatasource(memento);
		return data.createExperimentRunDAO().get(Long.parseLong(experimentRun));
	}

    private IDAOFactory getDatasource(IMemento memento) {
		String datasource = memento.getString(DATASOURCE);
		if (datasource == null)
			return null;
		IDAOFactory data = SensorFrameworkDataset
				.singleton().getDataSourceByID(Long.parseLong(datasource));
		return data;
	}
    
    private Experiment getExperiment(IMemento memento) {
		String experiment = memento.getString(EXPERIMENT);
		if (experiment == null)
			return null;
		IDAOFactory data = getDatasource(memento);
		return data.createExperimentDAO().get(Long.parseLong(experiment));
	}
}
