package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Decoder;
import org.opt4j.genotype.DoubleGenotype;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
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

	@Inject
	public DSEDecoder(){
		//XXX like this you can only set the problem once. Maybe dont save the reference. 
		this.problem = Opt4JStarter.problem;
	}

	@Override
	public PCMPhenotype decode(DoubleGenotype genotype) {
		//copy PCM Instance
		PCMInstance pcm = this.problem.deepCopyPCMInstance();
		
		int index = 0;
		//adjust values as in genotype
		for (Double doubleGene : genotype) {
			applyChange(this.problem.getDesignDecision(index), pcm, doubleGene);
			index++;
		}
		
		//encapsulate as phenotype 
		return new PCMPhenotype(pcm);
	}

	/**
	 * This methods should never be called, as specialised methods should 
	 * exist for all types of design decisions. 
	 * 
	 * 
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene The new value the design decision should take. 
	 */
	private void applyChange(DesignDecision designDecision, PCMInstance pcm,
			Double doubleGene) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDecision.class.isInstance(designDecision)){
			this.applyChange((ProcessingRateDecision)designDecision, pcm, doubleGene);
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
	}
	
	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene
	 */
	@SuppressWarnings("unused")
	private void applyChange(ProcessingRateDecision designDecision, PCMInstance pcm,
			Double doubleGene) {
		designDecision.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().setSpecification("\""+doubleGene.toString()+"\"");
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+doubleGene.toString());
	}

}
