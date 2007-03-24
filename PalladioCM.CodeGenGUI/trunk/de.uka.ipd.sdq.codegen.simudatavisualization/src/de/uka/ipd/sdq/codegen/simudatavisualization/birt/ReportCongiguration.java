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

class RunEntry{
	
	private List<Sensor> sensors;
	private ExperimentRun experimentRun;
	
	RunEntry(ExperimentRun experimentRun){
		this.experimentRun = experimentRun;
		this.sensors = new ArrayList<Sensor>();
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	public void addSensor(Sensor sensor) {
		sensors.add(sensor);
	}
	
	public void removeSensor(Sensor sensor){
		sensors.remove(sensor);
	}
	
	public ExperimentRun getExperimentRun() {
		return experimentRun;
	}
}
