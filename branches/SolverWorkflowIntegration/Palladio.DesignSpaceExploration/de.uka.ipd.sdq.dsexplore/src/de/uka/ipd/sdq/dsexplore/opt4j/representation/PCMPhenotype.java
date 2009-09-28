package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Objective;
import org.opt4j.core.Phenotype;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * Just holds a PCM Instance and the evaluated ConfidenceIntervals, if available. 
 * @author Anne
 *
 */
public class PCMPhenotype implements Phenotype {
	
	PCMInstance pcm = null;
	
	private Map<Objective, ConfidenceInterval> confidence = new HashMap<Objective, ConfidenceInterval>();
	
	
	public PCMPhenotype(PCMInstance pcm){
		this.pcm = pcm;
	}

	public PCMInstance getPcm() {
		return pcm;
	}
	
	public void addConfidence(Objective o, ConfidenceInterval c){
		this.confidence.put(o, c);
	}
	
	/**
	 * 
	 * @return The Map of ConfidenceIntervals, which is not null, but may be empty. 
	 */
	public Map<Objective, ConfidenceInterval> getConfidenceIntervals(){
		return this.confidence;
	}
	
	/**
	 * Can be null
	 * @param o
	 * @return The confidence interval for the given Objective or null if it does not exist. 
	 */
	public ConfidenceInterval getConfidenceIntervalForObjective(Objective o){
		return this.confidence.get(o);
	}

}
