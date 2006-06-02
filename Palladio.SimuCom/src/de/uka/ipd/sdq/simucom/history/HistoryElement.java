package de.uka.ipd.sdq.simucom.history;

import desmoj.core.simulator.SimTime;

public class HistoryElement {
	protected SimTime when;
	protected String what;
	
	public HistoryElement(SimTime when, String what){
		this.when = when;
		this.what = what;
	}
	
	@Override
	public String toString(){
		return what;
	}

	/**
	 * @return Returns the what.
	 */
	public String getWhat() {
		return what;
	}

	/**
	 * @return Returns the when.
	 */
	public SimTime getWhen() {
		return when;
	}
}
