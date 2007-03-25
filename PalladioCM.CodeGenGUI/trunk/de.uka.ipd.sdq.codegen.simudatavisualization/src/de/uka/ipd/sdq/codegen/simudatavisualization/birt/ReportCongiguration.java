/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * @author admin
 *
 */
public class ReportCongiguration {
	
	private List<RunEntry> runEntrys;
	
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

	/**
	 * @return the runEntrys
	 */
	public List<RunEntry> getRunEntrys() {
		return runEntrys;
	}
}

