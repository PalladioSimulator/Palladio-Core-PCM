package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.problem.Creator;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;

/**
 * The {@link DSECreator} is responsible for randomly creating genotypes 
 * in the solution space. It can query the {@link DSEProblem} for the 
 * available design space.
 *  
 * @author Anne
 *
 */
public class DSECreator implements Creator<DesignDecisionGenotype> {

	private DSEProblem problem;
	private Random random;
	
	private int numberOfNotEvaluatedPredefinedOnes;

	@Inject
	public DSECreator(){
		//XXX like this you can only set the problem once. Maybe dont save the reference. 
		this.problem = Opt4JStarter.getProblem();
		this.random = new Random();
		this.numberOfNotEvaluatedPredefinedOnes = this.problem.getInitialGenotypeList().size();
	}
	

	@Override
	public DesignDecisionGenotype create() {
		
		if (this.numberOfNotEvaluatedPredefinedOnes > 0){
			DesignDecisionGenotype genome = this.problem.getInitialGenotypeList().get(this.problem.getInitialGenotypeList().size()-this.numberOfNotEvaluatedPredefinedOnes);
			numberOfNotEvaluatedPredefinedOnes --;
			return genome;

		}
		
		DesignDecisionGenotype genotype = new DesignDecisionGenotype();
		
		List<DegreeOfFreedomInstance> degrees = problem.getDesignDecisions();
		for (DegreeOfFreedomInstance DegreeOfFreedomInstance : degrees) {
			genotype.add(createRandomChoice(DegreeOfFreedomInstance));
		}
		
		return genotype;
	}


	private int createIntegerValue(DiscreteDegree discDegree) {

		if (discDegree instanceof DiscreteRangeDegree){
			DiscreteRangeDegree dicRangeDegree = (DiscreteRangeDegree)discDegree;
			int range = dicRangeDegree.getTo() - dicRangeDegree.getFrom();
			if (!dicRangeDegree.isLowerBoundIncluded()) range--;
			if (!dicRangeDegree.isUpperBoundIncluded()) range--;
			//random.nextInt creates a random value between 0 <= x < param. I want one 0 <= x <= range. Thus, I add  1  
			int value = dicRangeDegree.getFrom() + this.random.nextInt(range+1);
			return value;
		} else if (discDegree instanceof OrderedIntegerDegree){
			OrderedIntegerDegree orderedIntegerDegree = (OrderedIntegerDegree) discDegree;
			int randomIndex = this.random.nextInt(orderedIntegerDegree.getListOfIntegers().size());
			return orderedIntegerDegree.getListOfIntegers().get(randomIndex);
		} else throw new RuntimeException("Unknown degree "+discDegree.getClass().getName());

	}


	private double createDoubleValue(ContinuousRangeDegree contDegree) {
		double lowerMargin = 0;
		if (contDegree.isLowerBoundIncluded()){
			lowerMargin = Double.MIN_VALUE;
		}
		double upperMargin = 0;
		if (contDegree.isUpperBoundIncluded()){
			upperMargin = Double.MIN_VALUE;
		}
		double factor = contDegree.getTo() - upperMargin - contDegree.getFrom() - lowerMargin;


		return contDegree.getFrom() + lowerMargin + this.random.nextDouble()*factor;

	}



	public Choice createRandomChoice(DegreeOfFreedomInstance degree) {
		designdecisionFactory factory = designdecisionFactoryImpl.init();
		Choice choice;
		if (degree instanceof DiscreteDegree){
			DiscreteRangeChoice discChoice = factory.createDiscreteRangeChoice() ;
			discChoice.setChosenValue(createIntegerValue((DiscreteDegree)degree));
			choice = discChoice;
		} else if (degree instanceof ContinuousRangeDegree){
			ContinousRangeChoice contChoice = factory.createContinousRangeChoice();
			contChoice.setChosenValue(createDoubleValue((ContinuousRangeDegree)degree));
			choice = contChoice;
		} else if (degree instanceof ClassDegree){
			ClassChoice enumChoice = factory.createClassChoice();
			enumChoice.setChosenValue(createRandomEntity((ClassDegree)degree));
			choice = enumChoice;
		} else throw new RuntimeException("Unknown degree "+degree.getClass().getName());
		choice.setDegreeOfFreedomInstance(degree);
		return choice;
	}


	private EObject createRandomEntity(ClassDegree enumDegree) {
		List<EObject> domain = enumDegree.getClassDesignOptions();
		int index = this.random.nextInt(domain.size()); 
		return domain.get(index);

	}
	
	public void setNumberOfNotEvaluatedPredefinedOnes(
			int numberOfNotEvaluatedPredefinedOnes) {
		this.numberOfNotEvaluatedPredefinedOnes = numberOfNotEvaluatedPredefinedOnes;
	}
	
	public int getNumberOfNotEvaluatedPredefinedOnes(){
		return this.numberOfNotEvaluatedPredefinedOnes;
	}
}
