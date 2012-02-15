package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.Set;

import org.apache.log4j.Logger;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objectives;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;


public class DSEIndividual extends Individual {


	private DecisionSpace problem;

	public DSEIndividual(DecisionSpace problem){
		this.problem = problem;
	}
	
	protected DSEIndividual(){
		this.problem = Opt4JStarter.getProblem().getEMFProblem();
	}
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual");
	
	
	@Override
	public DesignDecisionGenotype getGenotype(){
		return (DesignDecisionGenotype)super.getGenotype();
	}
	


	/**
	 * Checks the equality of this and o. 
	 * Returns false if o is not a DSEIndividual or subtype. 
	 * If both this and o are not genotyped, super.equals(o) is called. 
	 * Returns false if either this or o (exclusive) are not genotyped. 
	 * Finally, if none of the above matches, this method returns whether the 
	 * genotype strings of o and this are equal.  
	 * @param o The other object
	 * @return true if o and this are equal as defined above. 
	 */
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
		if (!(o instanceof DSEIndividual)){
			return false;
		} else {
			DSEIndividual other = (DSEIndividual)o;
			String otherGenotypeString = other.getGenotypeString();
			String myGenotypeString = this.getGenotypeString();
			if (otherGenotypeString == null && myGenotypeString == null){
				return super.equals(other);
			} else if (otherGenotypeString == null || myGenotypeString == null){
				// I need to say we are not equal and cannot ask my super type,
				// because of the hash code equivalence rule. 
				// If the other does not have a genotype string, but I do, and 
				// my super type says we are equal, then there is a conflict 
				// because the hash codes are not equal.
				return false;
			} else {
				return otherGenotypeString.equals(myGenotypeString);
			}
		}
		
		
	}

	/**
	 * 
	 * @return may be null if this individual does not have a genotype yet. 
	 */
	public String getGenotypeString() {
		if (genotype instanceof DesignDecisionGenotype){
			String genotypeString = DSEDecoder.getGenotypeString((DesignDecisionGenotype)genotype);
			return genotypeString;
		} else {
			throw new RuntimeException("DSEIndividual cannot handle arbitrary genotypes yet, fix the code");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIndividualStatusListeners(
			Set<IndividualStateListener> individualStateListeners) {
		super.setIndividualStatusListeners(individualStateListeners);
	}
	
	/**
	 * Returns the hash code of the getGenotypeString() string if this individual
	 * is already genotyped. Returns super.hashCode() if this inidividual is not
	 * yet genotyped.     
	 */
	@Override
	public int hashCode(){
		if (this.genotype != null){
			return this.getGenotypeString().hashCode();
		} else {
			return super.hashCode();
		}
		
	}
	
	/**
	 * Returns the objectives.
	 * 
	 * @return the objectives
	 */
	@Override
	public DSEObjectives getObjectives() {
		return (DSEObjectives)super.getObjectives();
	}
	
	/**
	 * Sets the objectives. They have to be instances of type {@link DSEObjective}, or 
	 * an {@link IllegalArgumentException} is thrown
	 * 
	 * @param objectives
	 *            the objectives to be set
	 * @throws IllegalArgumentException if objectives are not of type 
	 *            {@link DSEObjective}.
	 */
	@Override
	public void setObjectives(Objectives objectives) {
		if (! (objectives instanceof DSEObjectives)){
			String error = "DSEIndividual only supports DSEObjectives to contain the analysis results. Contact developers.";
			logger.error(error);
			throw new IllegalArgumentException(error);
		}
		super.setObjectives(objectives);
	}

	public String getID() {
		return this.getGenotypeString();
	}
	
	public long getNumericID() {
		return this.getGenotype().getNumericID();
	}
	
	public DecisionSpace getProblem(){
		return this.problem;
	}

}
