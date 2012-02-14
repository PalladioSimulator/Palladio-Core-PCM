package de.uka.ipd.sdq.dsexplore.analysis;


import org.opt4j.core.Phenotype;

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
	
	private long numericId;
	
	/**
	 * Careful: This is the one PCM instance that is modified, it may not be in the right state when using it. 
	 */
	private PCMInstance pcmInstance;
	
	/**
	 * TODO: create a separate partition in the blackboard to store
	 * this phenotype's PCM instance? right now there is only a single model
	 * The current implicit assumption is that each candidate is evaluated right after 
	 * it has been decoded, or never. 
	 * 
	 * @param pcm2 not yet used, as this points always to a same instance. 
	 * @param genotypeID
	 */
	public PCMPhenotype(PCMInstance pcm2, String genotypeID, long numericId){
		this.genotypeID = genotypeID;
		this.numericId = numericId;
		this.pcmInstance = pcm2;
	}
	
	public String getGenotypeID() {
		return genotypeID;
	}
	
	public long getNumericID() {
		return this.numericId;
	}

	public PCMInstance getPCMInstance() {
		return this.pcmInstance;
	}

}
