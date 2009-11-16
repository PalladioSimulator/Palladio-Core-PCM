package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;

public class RmiResult implements Serializable {

	private static final long serialVersionUID = 1280234602814873872L;
	
	private long[] results = null;
			
	public void setResults(long[] results) {
		this.results = results;
	}
	
	public long[] getResults() {
		return results;
	}

}
