package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Decoder;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;

/**
 * The {@link DSEDecoder} is responsible for converting the genotypes into 
 * proper PCM instances that can then be analysed.
 *  
 * @author Anne
 *
 */
public class DSEDecoder implements Decoder<DoubleGenotype, PCMPhenotype> {
	
	private DSEProblem problem;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public DSEDecoder(DSEProblem problem){
		this.problem = problem;
	}

	@Override
	public PCMPhenotype decode(DoubleGenotype arg0) {
		//copy PCM Instance
		PCMInstance pcm = this.problem.deepCopyPCMInstance();
		
		int index = 0;
		//adjust values as in genotype
		for (Double double1 : arg0) {
			applyChange(this.problem.getDesignDecision(index), pcm, double1);
			index++;
		}
		
		//encapsulate as phenotype 
		return null;
	}

	/**
	 * This methods should never be called, as specialised methods should 
	 * exist for all types of design decisions. 
	 * 
	 * 
	 * @param designDecision
	 * @param pcm
	 * @param double1 The new value the design decision should take. 
	 */
	private void applyChange(DesignDecision designDecision, PCMInstance pcm,
			Double double1) {
		
		logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		
	}
	
	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param double1
	 */
	@SuppressWarnings("unused")
	private void applyChange(ProcessingRateDecision designDecision, PCMInstance pcm,
			Double double1) {
		logger.debug("Handling a "+designDecision.getClass());
	}

}
