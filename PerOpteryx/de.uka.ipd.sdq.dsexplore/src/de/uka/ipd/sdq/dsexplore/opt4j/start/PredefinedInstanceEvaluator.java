package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Objectives;
import org.opt4j.core.Individual.State;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.NonListenableIndividual;

public abstract class PredefinedInstanceEvaluator {

	private List<DesignDecisionGenotype> genotypes = new ArrayList<DesignDecisionGenotype>();
	private DSEDecoder decoder;
	private DSEEvaluator evaluator;
	private String resultFolder;
	private boolean storeAsEMF;
	private boolean storeAsCSV;

	public PredefinedInstanceEvaluator(DSEWorkflowConfiguration dseConfig) throws CoreException {
		super();
		
		this.resultFolder = dseConfig.getResultFolder();
		this.storeAsEMF = dseConfig.isResultsAsEMF();
		this.storeAsCSV = dseConfig.isResultsAsCSV();
		
		this.evaluator = Opt4JStarter.getDSEEvaluator();
		this.decoder = Opt4JStarter.getDSEDecoder();
	}

	/**
	 * Subclasses should provide genotypes before calling this
	 * @throws CoreException 
	 */
	public void start() throws CoreException {
		
			this.genotypes = this.getGenotypes();
			//ResultsWriter myResultWriter = new ResultsWriter(this.resultFolder+"AllPredefinedCandidatesDirectly");
		
			List<DSEIndividual> individuals = new ArrayList<DSEIndividual>(); 
			for (DesignDecisionGenotype genotype : this.genotypes) {
				
				PCMPhenotype pheno = this.decoder.decode(genotype);
				DSEObjectives o = this.evaluator.evaluate(pheno);
				DSEIndividual i = new NonListenableIndividual();
				i.setGenotype(genotype);
				i.setPhenotype(pheno);
				o.array();
				i.setObjectives(o);
				i.setState(State.EVALUATED);
				
				individuals.add(i);
				
				//myResultWriter.writeIndividual(i);
			}
			
			List<DSEIndividual> optimalCandidates = new ArrayList<DSEIndividual>();
			optimalCandidates.addAll(individuals);
			
			// If two have the same objective values, both are kept. 
			for (DSEIndividual individual1 : individuals) {
				Objectives o1 = individual1.getObjectives();
				for (DSEIndividual individual2 : individuals) {
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
			
			ResultsWriter.writeDSEIndividualsToFile(individuals, this.resultFolder+"allCandidates", 1, storeAsEMF, storeAsCSV, exceptionList);
			
			ResultsWriter.writeDSEIndividualsToFile(optimalCandidates, this.resultFolder+"optimalCandidates", 1, storeAsEMF, storeAsCSV, exceptionList);

			
			ResultsWriter.printOutIndividuals(individuals, "Predefined instances");
			
			ResultsWriter.printOutIndividuals(optimalCandidates, "Pareto-optimal predefined instances");
			
			
			
		}
	
	protected abstract List<DesignDecisionGenotype> getGenotypes() throws CoreException;

}