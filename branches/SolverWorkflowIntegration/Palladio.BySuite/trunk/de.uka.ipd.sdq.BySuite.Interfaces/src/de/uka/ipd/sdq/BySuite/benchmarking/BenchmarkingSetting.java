package de.uka.ipd.sdq.BySuite.benchmarking;

import java.io.Serializable;

/** The description of the setting where the benchmarking 
 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
 * Needs to be filled with fields - see Martin's study thesis
 * @author Michael Kuperberg
 */
public class BenchmarkingSetting implements Serializable, Comparable<BenchmarkingSetting>{
	
	/**
	 * As usual.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO
	 */
	private long timestamp;

	/**
	 * TODO
	 */
	public BenchmarkingSetting(){
		System.err.println("BenchmarkingSetting class is empty");
		timestamp = System.currentTimeMillis();
	}

	/**
	 * TODO
	 * @param timestamp
	 */
	public BenchmarkingSetting(long timestamp){
		System.err.println("BenchmarkingSetting class is empty");
		this.timestamp = timestamp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BenchmarkingSetting o) {
		return new Long(this.timestamp).compareTo(new Long(o.timestamp));
	}
}
