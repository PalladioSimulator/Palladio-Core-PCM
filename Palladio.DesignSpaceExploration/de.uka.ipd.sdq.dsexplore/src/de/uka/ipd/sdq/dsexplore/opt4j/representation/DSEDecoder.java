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
		PCMInstance pcm = this.problem.getInitialInstance();

		
		int index = 0;
		//adjust values as in genotype
		for (Double doubleGene : genotype) {
			if (!doubleGene.isNaN() || doubleGene.isInfinite()){
				applyChange(this.problem.getDesignDecision(index), doubleGene);
			}  else { // TODO Handle wrong double genes properly, this is not the best way to solve it.
				logger.warn("A double gene was not applicable for instance "+pcm.getName()+" : "+doubleGene.toString());
				//set gene back to initial value
				//XXX: maybe better set back to last value or find out why NaN happens
				genotype.set(index, this.problem.getInitialGenotype().get(index));
			}
			index++;
		}
		
		//encapsulate as phenotype 
		return new PCMPhenotype(pcm.deepCopy());
	}

	/**
	 * Applies the given change to the initial pcm instance (as this is 
	 * referenced by the design decisions. More precisely, this one calls 
	 * calls specialized methods for dealing with different types of design 
	 * decisions.  
	 * 
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene The new value the design decision should take. 
	 */
	private void applyChange(DesignDecision designDecision, Double doubleGene) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDecision.class.isInstance(designDecision)){
			this.applyChange((ProcessingRateDecision)designDecision, doubleGene);
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
	private void applyChange(ProcessingRateDecision designDecision, Double doubleGene) {
		//XXX The value is changed in the original model, not in a copy. 

		designDecision.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().setSpecification(doubleGene.toString());
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+doubleGene.toString());
	}

}
