package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * Cache for one individual. 
 * 
 * TODO check individual when passed to this{@link #getUnusedResourceContainers(DSEIndividual)} 
 * to make sure it is still the same one. 
 * 
 * XXX also cache min result etc. 
 * 
 * @author martens
 *
 */
public class UtilisationResultCacheAndHelper {
	
	private Collection<ResourceContainer> unusedResourceContainers;

	/**
	 * Get all resource containers that have no components.
	 * Determines unused containers based on the allocation degrees of freedom.
	 * @param individual
	 * @return
	 */
	public Collection<ResourceContainer> getUnusedResourceContainers(DSEIndividual individual) {
		if (this.unusedResourceContainers == null){
			this.unusedResourceContainers = determineUnusedResourceContainers(individual);
		}
		return this.unusedResourceContainers;
	}
	
	private Collection<ResourceContainer> determineUnusedResourceContainers(DSEIndividual individual) {
		Collection<ResourceContainer> unusedResourceContainers = new HashSet<ResourceContainer>();
		DesignDecisionGenotype genotype = individual.getGenotype();
		// add all resource containers that can be found in the degrees of freedom
		for (Choice choice : genotype) {
			if (choice instanceof ClassChoice) {
				ClassChoice ClassChoice = (ClassChoice) choice;
				if (ClassChoice.getDegreeOfFreedom() instanceof AllocationDegree) {
					AllocationDegree allocationDegree = (AllocationDegree) ClassChoice.getDegreeOfFreedom();
					for (Entity entity : allocationDegree.getDesignOptions()) {
						if (entity instanceof ResourceContainer) {
							unusedResourceContainers.add((ResourceContainer)entity);
						}
					}
				}
			}
		}
		// remove all resource containers that are used
		for (Choice choice : genotype) {
			if (choice instanceof ClassChoice) {
				ClassChoice ClassChoice = (ClassChoice) choice;
				unusedResourceContainers.remove(ClassChoice.getEntity());
			}
		}
		return unusedResourceContainers;
	}
	
	/**
	 * Returns the {@link ProcessingResourceSpecificationResult} with the lowest utilisation.
	 * Only of used resource containers. 
	 * @param individual
	 * @return
	 */
	public ProcessingResourceSpecificationResult getMinProcUtilisationResult(DSEIndividual individual) {
		EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		ProcessingResourceSpecificationResult minUtilisationResult = null;
		if (utilisationResults != null) {
			for (UtilisationResult currentUtilisationResult : utilisationResults) {
				if (currentUtilisationResult instanceof ProcessingResourceSpecificationResult){
					ProcessingResourceSpecificationResult procUtilisationResult = (ProcessingResourceSpecificationResult)currentUtilisationResult;
					// only look at used servers
					if (!this.getUnusedResourceContainers(individual).contains(procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification())){
						if (minUtilisationResult == null) {
							minUtilisationResult = procUtilisationResult;
						} else if (minUtilisationResult.getResourceUtilisation() > procUtilisationResult.getResourceUtilisation()) {
							minUtilisationResult = procUtilisationResult;
						}
					}
				}
			}
		return minUtilisationResult;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the {@link ProcessingResourceSpecificationResult} with the highest utilisation.
	 * Only of used resource containers. 
	 * @param individual
	 * @return
	 */
	public ProcessingResourceSpecificationResult getMaxProcUtilisationResult(DSEIndividual individual) {
		EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		ProcessingResourceSpecificationResult maxUtilisationResult = null;
		if (utilisationResults != null) {
			for (UtilisationResult currentUtilisationResult : utilisationResults) {
				if (currentUtilisationResult instanceof ProcessingResourceSpecificationResult){
					ProcessingResourceSpecificationResult procUtilisationResult = (ProcessingResourceSpecificationResult)currentUtilisationResult;
					// only look at used servers
					if (!this.getUnusedResourceContainers(individual).contains(procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification())){
						if (maxUtilisationResult == null) {
							maxUtilisationResult = procUtilisationResult;
						} else if (maxUtilisationResult.getResourceUtilisation() < procUtilisationResult.getResourceUtilisation()) {
							maxUtilisationResult = procUtilisationResult;
						}
					}
				}
			}
		return maxUtilisationResult;
		} else {
			return null;
		}
	}
	
	/**
	 * Finds 2nd lowest UtilisationResult
	 * @param individual
	 * @return 2nd lowest UtilisationResult
	 */
	public UtilisationResult get2ndMinUtilisationResult(DSEIndividual individual) {
		EList<UtilisationResult> utilisationResults = UtilisationResultCacheAndHelper.getUtilisationResult(individual);
		UtilisationResult result = null;
		UtilisationResult minUtilisationResult = getMinProcUtilisationResult(individual);
		if (utilisationResults != null) {
			for (UtilisationResult currentUtilisationResult : utilisationResults) {
				if (result == null && currentUtilisationResult != minUtilisationResult) {
					result = currentUtilisationResult;
				}
				if (result != null
						&& result.getResourceUtilisation() > currentUtilisationResult.getResourceUtilisation()
						&& currentUtilisationResult != minUtilisationResult) {
					result = currentUtilisationResult;
				}
			}
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets utilisation result of an individual
	 * @param individual
	 * @return
	 */
	private static EList<UtilisationResult> getUtilisationResult(DSEIndividual individual) {
		DSEObjectives objectives = (DSEObjectives) individual.getObjectives();
		Objective resonseTimeObjective = null;
		//FIXME get name not hard coded
		for (Objective o : objectives.getKeys()) {
			if (o.getName().contains("response time")) {
				resonseTimeObjective = o;
			}
		}
		ResultDecoratorRepository resultDecoratorRepository = objectives.getResultDecoratorFor(resonseTimeObjective);
		
		if (resultDecoratorRepository != null) {
			return resultDecoratorRepository.getUtilisationResults_ResultDecoratorRepository();
		} else {
			return null;
		}
	}
	
	/**
	 * Returns maximum value of a Collection
	 * @param c Collection with elements of type Double
	 * @return Maximum element of c or Double.NEGATIVE_INFINITY of c is empty
	 */
	private static double getMaxElement(Collection<Double> c) {
		Double max = Double.NEGATIVE_INFINITY;
		for (Double d : c) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}
	
	/**
	 * Returns minimum value of a Collection
	 * @param c Collection with elements of type Double
	 * @return Minimum element of c or Double.POSITIVE_INFINITY of c is empty
	 */
	private static double getMinElement(Collection<Double> c) {
		Double min = Double.POSITIVE_INFINITY;
		for (Double d : c) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}
	
	public static double getMaxUtilisation(DSEIndividual individual){ 
		EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		ArrayList<Double> results = new ArrayList<Double>();
		for (UtilisationResult utilisationResult : utilisationResults) {
			utilisationResult.getEntityName();
			results.add(utilisationResult.getResourceUtilisation());
		}
		return getMaxElement(results);
	}
	
	/**
	 * Returns the smallest overall utilisation (linking and processing). 
	 * @param individual
	 * @return
	 */
	public static double getMinUtilisation(DSEIndividual individual){ 
		EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		ArrayList<Double> results = new ArrayList<Double>();
		for (UtilisationResult utilisationResult : utilisationResults) {
			results.add(utilisationResult.getResourceUtilisation());
		}
		return getMinElement(results);
	}
	
	/**
	 * Returns the largest utilisation (linking and processing).
	 * @param individual
	 * @return
	 */
	/*public static UtilisationResult getMaxUtilisationResult(DSEIndividual individual) {
		EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		UtilisationResult maxUtilisationResult = null;
		if (utilisationResults != null) {
			for (UtilisationResult currentUtilisationResult : utilisationResults) {
				if (maxUtilisationResult == null) {
					maxUtilisationResult = currentUtilisationResult;
				}
				if (maxUtilisationResult.getResourceUtilisation() < currentUtilisationResult.getResourceUtilisation()) {
					maxUtilisationResult = currentUtilisationResult;
				}
			}
			return maxUtilisationResult;
		} else {
			return null;
		}
	}*/
	

	public static List<ProcessingResourceSpecificationResult> getProcessingResourceUtilisationResults(DSEIndividual individual){
		List<UtilisationResult> utilisationResults = getUtilisationResult(individual);
		List<ProcessingResourceSpecificationResult> procUtils = new ArrayList<ProcessingResourceSpecificationResult>(utilisationResults.size());
		for (UtilisationResult utilisationResult : utilisationResults) {
			if (utilisationResult instanceof ProcessingResourceSpecificationResult){
				procUtils.add((ProcessingResourceSpecificationResult)utilisationResult);
			}
		}
		return procUtils;
	}
	

	
	/**
	 * Compares two UtilisationResults based on their resourceUtilisation.
	 * The compare method returns the same as calling
	 * {@link Double#compare(double, double)} with o1.getResourceUtilisation() and 
	 * o2.getResourceUtilisation().
	 * 
	 * @author martens
	 *
	 */
	public static class UtilisationComparator implements Comparator<UtilisationResult>{

		@Override
		public int compare(UtilisationResult o1, UtilisationResult o2) {
			double utilO1 = o1.getResourceUtilisation();
			double utilO2 = o2.getResourceUtilisation();
			return Double.compare(utilO1, utilO2);
		}
		
	}
	
}






