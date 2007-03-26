/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;


import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

/**
 * @author admin
 *
 */
public class ReportCongiguration {
	
	private List<RunEntry> runEntrys;
	private Set<IStructuredContentProvider> changeListeners = new HashSet<IStructuredContentProvider>();
	
	// TODO
	//private String REPORT_ID;
	
	/**
	 * @param runEntrys
	 */
	public ReportCongiguration() {
		this.runEntrys = new ArrayList<RunEntry>();
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
	
	/**
	 * @param viewer
	 */
	public void removeChangeListener(IStructuredContentProvider viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(IStructuredContentProvider viewer) {
		changeListeners.add(viewer);
	}
}

