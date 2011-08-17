package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import de.uka.ipd.sdq.dsexplore.csvanalyzer.Starter.TacticClass;

/**
 * Depends quite strongly on the layout of the heuristic file. Assumes the follwing layout in csv format with separator ";":
 * <ul>
 * <li> First column contains the date of applying this tactic in format 2010-07-10 11:15:38
 * <li> Second column contains the applied heuristic class, e.g. ReallocationImpl
 * <li> Next x columns contain the genome of the newly created candidate
 * <li> One empty column
 * <li> Next x columns contain the genome of the parent
 * </ul>
 * 
 * @author martens
 *
 */
public class TacticApplicationResult implements Comparable<TacticApplicationResult> {
	
	private int iteration;
	private double oldResponseTime;
	private double newResponseTime;
	private double oldCost;
	private double newCost;
	private TacticClass tactic;
	private int run;
	
	public TacticApplicationResult(int iteration, double oldResponseTime,
			double newResponseTime, double oldCost, double newCost, Starter.TacticClass tactic, int run) {
		super();
		this.iteration = iteration;
		this.oldResponseTime = oldResponseTime;
		this.newResponseTime = newResponseTime;
		this.oldCost = oldCost;
		this.newCost = newCost;
		this.tactic = tactic;
		this.run = run;
	}

	public TacticClass getTactic() {
		return tactic;
	}

	public int getIteration() {
		return iteration;
	}

	public double getOldResponseTime() {
		return oldResponseTime;
	}

	public double getNewResponseTime() {
		return newResponseTime;
	}

	public double getOldCost() {
		return oldCost;
	}

	public double getNewCost() {
		return newCost;
	}
	
	public double getResponseTimeDelta(){
		return oldResponseTime - newResponseTime;
	}
	
	public double getCostDelta(){
		return oldCost - newCost;
	}
	
	public double getRelativeResponseTimeImprovement(){
		return (newResponseTime - oldResponseTime)/oldResponseTime;
	}
	
	public double getRelativeCostImprovement(){
		return (newCost - oldCost)/oldCost;
	}

	/**
	 * Returns this.iteration - o.getIteration().
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(TacticApplicationResult o) {
		return this.iteration - o.getIteration();
	}

	public int getRun() {
		return this.run;
	}
	

}
