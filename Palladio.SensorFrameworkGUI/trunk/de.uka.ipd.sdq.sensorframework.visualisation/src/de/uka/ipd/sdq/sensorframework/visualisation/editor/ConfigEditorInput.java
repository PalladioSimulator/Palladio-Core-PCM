package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/** @author roman */
public class ConfigEditorInput extends Observable
		implements IEditorInput, IAdaptable, Observer {
	
	/**
	 * 
	 */
	private List<ConfigEntry> configEntrys;
	
	public ConfigEditorInput() {
		this.configEntrys = new ArrayList<ConfigEntry>();
	}
	
	public ConfigEditorInput(ExperimentRun run, Experiment experiment) {
		this.configEntrys = new ArrayList<ConfigEntry>();
		ConfigEntry confEntry = new ConfigEntry(run,experiment);
		confEntry.addObserver(this);
		configEntrys.add(confEntry);
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
	
	public void addNewConfigEntry(ExperimentRun run, Experiment experiment){
		ConfigEntry confEntry = new ConfigEntry(run, experiment);
		confEntry.addObserver(this);
		configEntrys.add(confEntry);
		notifyObserver();
	}
	
//	public void addNewConfigEntry(ConfigEntry runEntry){
//		configEntrys.add(runEntry);
//		notifyObserver();
//	}
	
	// TODO equals
	public void removeConfigEntryToRun(ExperimentRun run){
		for(ConfigEntry ce : configEntrys){
			if (ce.getExperimentRun().equals(run)) {
				ce.deleteObserver(this);
				configEntrys.remove(ce);
			}
		}
		notifyObserver();
	}
	
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
		return new IPersistableElement (){

			public String getFactoryId() {
				return "de.uka.ipd.sdq.sensorframework.visualisation.configEditorInputFactory";
			}

			public void saveState(IMemento memento) {
			}
			
		};
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
	
	public void notifyObserver(){
		setChanged();
		notifyObservers();
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}
}
