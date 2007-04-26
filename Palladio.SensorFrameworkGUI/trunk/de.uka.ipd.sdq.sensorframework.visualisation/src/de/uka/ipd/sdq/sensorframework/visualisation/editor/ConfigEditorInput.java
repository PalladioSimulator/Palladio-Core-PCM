/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.internal.part.NullEditorInput;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

/**
 * @author admin
 *
 */
public class ConfigEditorInput implements IEditorInput {
	
	
	private List<RunEntry> runEntrys;
	
	/**
	 * @param runEntrys
	 */
	public ConfigEditorInput() {
		this.runEntrys = new ArrayList<RunEntry>();
	}
	
	public ConfigEditorInput(ExperimentRun run) {
		this.runEntrys = new ArrayList<RunEntry>();
		runEntrys.add(new RunEntry(run));
	}

	public void addNewEntry(ExperimentRun run){
		runEntrys.add(new RunEntry(run));
	}
	
	// TODO equals
	public void removeRunEntry(ExperimentRun run){
		
		for(RunEntry re : runEntrys){
			if (re.getExperimentRun().equals(run))
				runEntrys.remove(re);
		}
	}
	
	public RunEntry getRunEntry(ExperimentRun run){
		for(RunEntry re : runEntrys){
			if (re.getExperimentRun().equals(run))
				return re;
		}
		return null;
	}

	/**
	 * @return the runEntrys
	 */
	public List<RunEntry> getRunEntrys() {
		return runEntrys;
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
		return null;
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
		return null;
	}

}
