package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.problem.Creator;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

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


	private int createIntegerValue(DiscreteRangeDegree discDegree) {

		int range = discDegree.getTo() - discDegree.getFrom();
		if (!discDegree.isLowerBoundIncluded()) range--;
		if (!discDegree.isUpperBoundIncluded()) range--;
		//random.nextInt creates a random value between 0 <= x < param. I want one 0 <= x <= range. Thus, I add  1  
		int value = discDegree.getFrom() + this.random.nextInt(range+1);
		return value;


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
		if (degree instanceof DiscreteRangeDegree){
			DiscreteRangeChoice discChoice = factory.createDiscreteRangeChoice() ;
			discChoice.setChosenValue(createIntegerValue((DiscreteRangeDegree)degree));
			choice = discChoice;
		} else if (degree instanceof ContinuousRangeDegree){
			ContinousRangeChoice contChoice = factory.createContinousRangeChoice();
			contChoice.setChosenValue(createDoubleValue((ContinuousRangeDegree)degree));
			choice = contChoice;
		} else if (degree instanceof ClassDegree){
			ClassChoice enumChoice = factory.createClassChoice();
			enumChoice.setChosenValue(createRandomEntity((ClassDegree)degree));
			choice = enumChoice;
		} else if (degree instanceof SchedulingPolicyDegree){
			SchedulingPolicyChoice schedChoice = factory.createSchedulingPolicyChoice();
			schedChoice.setChosenValue(createRandomSchedulingPolicy((SchedulingPolicyDegree)degree));	
			choice = schedChoice;
		} else throw new RuntimeException("Unknown degree "+degree.getClass().getName());
		choice.setDegreeOfFreedomInstance(degree);
		return choice;
	}



	private SchedulingPolicy createRandomSchedulingPolicy(
			SchedulingPolicyDegree degree) {
		List<SchedulingPolicy> domain = degree.getDomainOfAllowedSchedulingPolicies();
		int index = this.random.nextInt(domain.size()); 
		return domain.get(index);
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
