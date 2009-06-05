package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.filter.FilteredCollectionsManager;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;

/** @author Roman Andrej */
public class ConfigEditorInput extends Observable
		implements IEditorInput, IPersistableElement,IAdaptable, Observer {
	
	/** Create the filter manager instance. */
	private FilteredCollectionsManager filtersManager = new FilteredCollectionsManager();
	
	private List<ConfigEntry> configEntrys;
	private String adapterFactoryID;
	
	public ConfigEditorInput(String adapterFactoryID) {
		this.configEntrys = new ArrayList<ConfigEntry>();
		this.adapterFactoryID = adapterFactoryID;
	}
	
	public ConfigEditorInput(String adapterFactoryID, ConfigEntry configEntry) {
		this.configEntrys = new ArrayList<ConfigEntry>();
		this.adapterFactoryID = adapterFactoryID;
		addConfigEntry(configEntry);
	}
	
	/** Edit command of ConfigEntry */
	public void editConfigEntry(IDAOFactory datasource, ExperimentRun run, Experiment experiment, Sensor sensor, String adapterFactoryID) {
		ConfigEntry configEntry = getConfigEntryToRun(run);
		
		if (configEntry == null) {
			ConfigEntry confEntry = new ConfigEntry(datasource,run,experiment,sensor);
			confEntry.addObserver(this);
			configEntrys.add(confEntry);
		} else
			configEntry.setSensorChecked(sensor);
		notifyObserver();
	}
	
	/** Add new ConfigEntry */
	public void addConfigEntry(ConfigEntry configEntry){
		configEntry.addObserver(this);
		configEntrys.add(configEntry);
		notifyObserver();
	}
	
	/** Remove a ConfigEntry */
	public void removeConfigEntry(ConfigEntry entry){
		if (configEntrys.contains(entry)){
			entry.deleteObserver(this);
			configEntrys.remove(entry);
			notifyObserver();
		}
	}
	
	public ConfigEntry getConfigEntryToRun(ExperimentRun run){
		for(ConfigEntry re : configEntrys){
			if (re.getExperimentRun().equals(run))
				return re;
		}
		return null;
	}
	
	public List<ConfigEntry> getConfigEntrys() {
		return configEntrys;
	}
	
	public boolean isEmpty(){
		return configEntrys.isEmpty();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	public boolean exists() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	public ImageDescriptor getImageDescriptor() {
		 return ImageDescriptor.getMissingImageDescriptor();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	public String getName() {
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	public IPersistableElement getPersistable() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	public String getToolTipText() {
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == ConfigEditorInput.class)
			return this;
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	public String getFactoryId() {
		return ConfigEditorInputFactory.getFactoryId();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {
		try
		{
			ConfigEditorInputFactory.saveState(memento, this);
		} catch (Exception e) {
			/* ignore errors if they happen, most likely the corresponding  
			 * sensor entities have been deleted meanwhile
			 */
		}
	}

	/**Set the status of this class to changed and notifies all
	 * listening observers.
	 */
	private void notifyObserver() {
		setChanged();
		notifyObservers(this);
	}

	/** {@inheritDoc}
	 */
	public void update(Observable o, Object arg) {
		// call the local method.
		notifyObserver();
	}
	
	/**
	 * Return absolute path of the config file. It develops out location in the
	 * local file system of the plug-in state area for this plug-in and defined
	 * name.
	 * 
	 * @return path to configurations file.
	 */
	public static String getPathToConfigFile() {
		IPath path = VisualisationPlugin.getDefault().getStateLocation();

		return path.toPortableString() + "/" + "persistable_element.xml";
	}

	public String getAdapterFactoryID() {
		return this.adapterFactoryID;
	}

	public FilteredCollectionsManager getFiltersManager() {
		return filtersManager;
	}
}
