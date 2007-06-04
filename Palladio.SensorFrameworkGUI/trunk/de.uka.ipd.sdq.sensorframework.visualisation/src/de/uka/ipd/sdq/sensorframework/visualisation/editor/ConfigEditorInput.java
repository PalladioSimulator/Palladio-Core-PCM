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

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;

/** @author roman */
public class ConfigEditorInput extends Observable
		implements IEditorInput, IPersistableElement,IAdaptable, Observer {
	
	private List<ConfigEntry> configEntrys;
	
	public ConfigEditorInput() {
		this.configEntrys = new ArrayList<ConfigEntry>();
	}
	
	/** Edit command of ConfigEctry	 */
	public void editConfigEntry(ExperimentRun run, Experiment experiment, Sensor sensor) {
		ConfigEntry configEntry = getConfigEntryToRun(run);
		
		if (configEntry == null) {
			ConfigEntry confEntry = new ConfigEntry(run,experiment,sensor);
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
		ConfigEditorInputFactory.saveState(memento, this);
	}

	public void notifyObserver(){
		setChanged();
		notifyObservers();
	}

	public void update(Observable o, Object arg) {
		notifyObserver();
	}
	
	/**
	 * Return absolute path of the config file. It develops out location in the
	 * local file system of the plug-in state area for this plug-in and defined
	 * name.
	 */
	static String getPathToConfigFile() {
		IPath path = SimuPlugin.getDefault().getStateLocation();

		return path.toPortableString() + "/" + "persistable_element.xml";
	}
}
