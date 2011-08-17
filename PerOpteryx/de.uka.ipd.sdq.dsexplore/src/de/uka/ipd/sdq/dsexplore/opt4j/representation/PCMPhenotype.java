package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import org.opt4j.core.problem.Phenotype;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

/**
 * Just holds a PCM Instance and the evaluated ConfidenceIntervals, if available. 
 * @author Anne
 *
 */
public class PCMPhenotype implements Phenotype {
	
	
	/**
	 * Field to store the characteristic hash of the underlying genotype. This allows to detect duplicated genotypes and not evaluate one twice. 
	 */
	private String genotypeID;
	
	/**
	 * TODO: create a separate partition in the blackboard to store
	 * this phenotype's PCM instance? right now there is only a single model
	 * The current implicit assumption is that each candidate is evaluated right after 
	 * it has been decoded, or never. 
	 * 
	 * @param pcm2 not yet used, as this points always to a same instance. 
	 * @param genotypeID
	 */
	public PCMPhenotype(PCMInstance pcm2, String genotypeID){
		this.genotypeID = genotypeID;
	}
	
	public String getGenotypeID() {
		return genotypeID;
	}


}
