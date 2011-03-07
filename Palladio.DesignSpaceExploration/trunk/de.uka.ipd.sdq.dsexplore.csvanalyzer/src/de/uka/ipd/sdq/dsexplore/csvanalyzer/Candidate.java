package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import java.util.List;

public class Candidate {

	double cost;
	double responseTime; 
	
	List<String> genome;

	public Candidate(double cost, double responseTime, List<String> genome) {
		super();
		this.cost = cost;
		this.responseTime = responseTime;
		this.genome = genome;
	}

	public double getCost() {
		return cost;
	}

	public double getResponseTime() {
		return responseTime;
	}
	
	public boolean hasGenome(List<String> genome){
		return this.genome.equals(genome);
	}
	
}
