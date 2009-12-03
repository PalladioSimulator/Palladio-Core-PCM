package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.Individual.State;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.NonListenableIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.PCMPhenotype;

public abstract class PredefinedInstanceEvaluator {

	private List<DoubleGenotype> genotypes = new ArrayList<DoubleGenotype>();
	private DSEDecoder decoder = new DSEDecoder();
	private DSEEvaluator evaluator;

	public PredefinedInstanceEvaluator() throws CoreException {
		super();
		this.evaluator = new DSEEvaluator();
	}

	/**
	 * Subclasses should provide genotypes before calling this
	 * @throws CoreException 
	 */
	public void start() throws CoreException {
		
			this.genotypes = this.getGenotypes();
		
			List<Individual> individuals = new ArrayList<Individual>(); 
			for (DoubleGenotype genotype : this.genotypes) {
				
				PCMPhenotype pheno = this.decoder.decode(genotype);
				Objectives o = this.evaluator.evaluate(pheno);
				Individual i = new NonListenableIndividual();
				i.setGenotype(genotype);
				i.setPhenotype(pheno);
				o.submit();
				i.setObjectives(o);
				i.setState(State.EVALUATED);
				
				individuals.add(i);
			}
			
			List<Individual> optimalCandidates = new ArrayList<Individual>();
			optimalCandidates.addAll(individuals);
			
			// If two have the same objective values, both are kept. 
			for (Individual individual1 : individuals) {
				Objectives o1 = individual1.getObjectives();
				for (Individual individual2 : individuals) {
					Objectives o2 = individual2.getObjectives();
					if (individual1 != individual2){
						if (o2.dominates(o1)){
							optimalCandidates.remove(individual1);
						} else if (o1.dominates(o2)){
							optimalCandidates.remove(individual2);
						}
					}
				}
			}
			
			// TODO: If two have the same objective values, probably any one is removed. 
			//Copied from org.opt4j.common.archive.PopulationArchive.java
	//		Objectives o1, o2;
	//		for (int i = 0; i < optimalCandidates.size() - 1; i++) {
	//			o1 = optimalCandidates.get(i).getObjectives();
	//			for (int j = i + 1; j < optimalCandidates.size(); j++) {
	//				o2 = optimalCandidates.get(j).getObjectives();
	//				if (o2.weaklyDominates(o1)) {
	//					optimalCandidates.remove(i);
	//					i--;
	//					break;
	//				} else if (o1.weaklyDominates(o2)) {
	//					optimalCandidates.remove(j);
	//					j--;
	//				}
	//			}
	//		}
			
			List<Exception> exceptionList = new ArrayList<Exception>();
			
			ResultsWriter.writeIndividualsToFile(individuals, "allCandidates", 1, exceptionList);
			
			ResultsWriter.writeIndividualsToFile(optimalCandidates, "optimalCandidates", 1, exceptionList);

			
			ResultsWriter.printOutIndividuals(individuals, "Predefined instances");
			
			ResultsWriter.printOutIndividuals(optimalCandidates, "Pareto-optimal predefined instances");
			
			
			
		}
	
	protected abstract List<DoubleGenotype> getGenotypes() throws CoreException;

}