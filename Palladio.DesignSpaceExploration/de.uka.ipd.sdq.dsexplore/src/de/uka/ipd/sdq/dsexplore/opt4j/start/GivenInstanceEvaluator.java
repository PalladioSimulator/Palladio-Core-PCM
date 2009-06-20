package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.Individual.State;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.NonListenableIndividual;


public class GivenInstanceEvaluator {

	private ILaunchConfiguration configuration;
	private List<DoubleGenotype> genotypes;
	private DSEDecoder decoder;
	private DSEEvaluator evaluator;

	public GivenInstanceEvaluator(ILaunchConfiguration configuration) throws CoreException {
		this.configuration = configuration;
		
		this.decoder = new DSEDecoder();
		this.evaluator = new DSEEvaluator();
		
		
		String filename = configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "");
		File file = new File(filename);
		
	    try {
	    	String line = "";
	    	List<DoubleGenotype> results = new ArrayList<DoubleGenotype>();
	        BufferedReader in = new BufferedReader(
	                            new InputStreamReader(
	                            new FileInputStream( file ) ) );
	        while( null != (line = in.readLine()) ) {
	        	DoubleGenotype genotype = new DoubleGenotype();
	        	String[] lineArray = line.split(";");
	        	for (String string : lineArray) {
					Double gene = Double.parseDouble(string);
					genotype.add(gene);
				}
	        	results.add(genotype);
	        }
	        in.close();
	        
	        this.genotypes = results;
	        
	      } catch( Exception ex ) {
	        throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, ex.getMessage(), ex));
	      }
	}

	public void start() {
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
		
		Opt4JStarter.printOutIndividuals(individuals, "Predefined instances");
		
		Opt4JStarter.printOutIndividuals(optimalCandidates, "Pareto-optimal predefined instances");
		
	}


}
