package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * Cache for one individual. 
 * 
 * TODO check individual when passed to this{@link #getUnusedAvailableResourceContainers(DSEIndividual)} 
 * to make sure it is still the same one. 
 * 
 * XXX also cache min result etc. 
 * 
 * @author martens
 *
 */
public class UtilisationResultCacheAndHelper {
	
	private Collection<ResourceContainer> unusedAvailableResourceContainers;
	private Collection<ResourceContainer> availableResourceContainer;
	
	// maps must permit null values, as resource type is null if any resource in meant. 
	private Map<ResourceType, ProcessingResourceSpecificationResult> minProcResultMap = new HashMap<ResourceType, ProcessingResourceSpecificationResult>();
	private Map<ResourceType, ProcessingResourceSpecificationResult> maxProcResultMap = new HashMap<ResourceType, ProcessingResourceSpecificationResult>();
	
	private LinkingResourceResults maxLinkResult;
	private Set<ResourceType> resourceTypes;

	/**
	 * Get all resource containers that are available in the design decisions but that have no components.
	 * Determines unused containers based on the allocation degrees of freedom.
	 * @param individual
	 * @return
	 */
	public Collection<ResourceContainer> getUnusedAvailableResourceContainers(DSEIndividual individual) {
		if (this.unusedAvailableResourceContainers == null){
			this.unusedAvailableResourceContainers = determineUnusedAvailableResourceContainers(individual);
		}
		return this.unusedAvailableResourceContainers;
	}
	
	/**
	 * Return all {@link ResourceContainer}s available in the design decisions.   
	 * @param individual
	 * @return
	 */
	public Collection<ResourceContainer> getAvailableResourceContainers(
			DSEIndividual individual) {
		if (this.availableResourceContainer == null){
			this.availableResourceContainer = determineAvailaibleResourceContainer(individual);
		}
		return this.availableResourceContainer;
	}
	
	private Collection<ResourceContainer> determineAvailaibleResourceContainer(
			DSEIndividual individual) {
		Collection<ResourceContainer> availableResourceContainers = new ArrayList<ResourceContainer>();
		DesignDecisionGenotype genotype = individual.getGenotype();
		
		// add all resource containers that can be found in the design decisions
		for (Choice choice : genotype) {
			if (choice instanceof ClassChoice) {
				ClassChoice ClassChoice = (ClassChoice) choice;
				if (ClassChoice.getDegreeOfFreedomInstance() instanceof AllocationDegree) {
					AllocationDegree allocationDegree = (AllocationDegree) ClassChoice.getDegreeOfFreedomInstance();
					for (EObject entity : allocationDegree.getClassDesignOptions()) {
						if (entity instanceof ResourceContainer) {
							availableResourceContainers.add((ResourceContainer)entity);
						}
					}
				}
			}
		}
		return availableResourceContainers;
	}


	private Collection<ResourceContainer> determineUnusedAvailableResourceContainers(DSEIndividual individual) {

		DesignDecisionGenotype genotype = individual.getGenotype();
		
		Collection<ResourceContainer> unusedResourceContainers = new HashSet<ResourceContainer>();
		unusedResourceContainers.addAll(this.getAvailableResourceContainers(individual));
		
		// remove all resource containers that are used
		for (Choice choice : genotype) {
			if (choice instanceof ClassChoice) {
				ClassChoice classChoice = (ClassChoice) choice;
				unusedResourceContainers.remove(classChoice.getChosenValue());
			}
		}
		return unusedResourceContainers;
	}
	
	public ProcessingResourceSpecificationResult getMinProcUtilisationResult(DSEIndividual individual) {
		return this.getMinProcUtilisationResult(individual, null);
	}
	
	/**
	 * Returns the {@link ProcessingResourceSpecificationResult} with the lowest utilisation.
	 * Only of used resource containers. 
	 * @param individual
	 * @param resourceType may be null if any resource type is fine
	 * @return
	 */
	public ProcessingResourceSpecificationResult getMinProcUtilisationResult(DSEIndividual individual, ResourceType resourceType) {
		
		ProcessingResourceSpecificationResult minProcResult = minProcResultMap.get(resourceType);
		if (minProcResult == null){

			EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
			ProcessingResourceSpecificationResult minUtilisationResult = null;
			if (utilisationResults != null) {
				for (UtilisationResult currentUtilisationResult : utilisationResults) {
					if (currentUtilisationResult instanceof ProcessingResourceSpecificationResult){
						ProcessingResourceSpecificationResult procUtilisationResult = (ProcessingResourceSpecificationResult)currentUtilisationResult;
						// only look at used servers
						if (EMFHelper.contains(this.getAvailableResourceContainers(individual),
								procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification())
								&& !EMFHelper.contains(this.getUnusedAvailableResourceContainers(individual),
										procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification() )
								// and has matching resource type if resource type is not null
								&& checkResourceType(procUtilisationResult, resourceType)){
							
							if (minUtilisationResult == null 
									|| minUtilisationResult.getResourceUtilisation() > procUtilisationResult.getResourceUtilisation()) {
								minUtilisationResult = procUtilisationResult;
							}
						}
					}
				}
				minProcResultMap.put(resourceType, minProcResult);
				minProcResult = minUtilisationResult;
			} 
		}
		return minProcResult;
		
	}

	private boolean checkResourceType(ProcessingResourceSpecificationResult procUtilisationResult, ResourceType resourceType) {
		return resourceType != null 
			? (EMFHelper.checkIdentity(procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification(),resourceType)
					&& 	!resourceType.getEntityName().equals("DELAY"))
				: true;
	}

	/**
	 * Link Resource types are not distinguished. 
	 * @param individual
	 * @return
	 */
	public LinkingResourceResults getMaxLinkUtilisationResult(DSEIndividual individual){
		if (maxLinkResult == null){
			EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
			LinkingResourceResults maxUtilisationResult = null;
			if (utilisationResults != null) {
				for (UtilisationResult currentUtilisationResult : utilisationResults) {
					if (currentUtilisationResult instanceof LinkingResourceResults){
						LinkingResourceResults linkUtilisationResult = (LinkingResourceResults)currentUtilisationResult;
						// only look at used links, decide by utilisation
						if (linkUtilisationResult.getResourceUtilisation() > 0){
							if (maxUtilisationResult == null 
									|| maxUtilisationResult.getResourceUtilisation() < linkUtilisationResult.getResourceUtilisation()) {
								maxUtilisationResult = linkUtilisationResult;
							}
						}
					}
				}
				maxLinkResult = maxUtilisationResult;
			}
		}
		return maxLinkResult;
	}

	public ProcessingResourceSpecificationResult getMaxProcUtilisationResult(DSEIndividual individual) {
		return this.getMaxProcUtilisationResult(individual, null);
	}

	/**
	 * Returns the {@link ProcessingResourceSpecificationResult} with the highest utilisation.
	 * Only of used resource containers. 
	 * @param individual
	 * @param resourceType may be null if any resource type is fine
	 * @return
	 */
	public ProcessingResourceSpecificationResult getMaxProcUtilisationResult(DSEIndividual individual, ResourceType resourceType) {

		ProcessingResourceSpecificationResult maxProcResult = maxProcResultMap.get(resourceType);
		if (maxProcResult == null){

			EList<UtilisationResult> utilisationResults = getUtilisationResult(individual);
			ProcessingResourceSpecificationResult maxUtilisationResult = null;
			if (utilisationResults != null) {
				for (UtilisationResult currentUtilisationResult : utilisationResults) {
					if (currentUtilisationResult instanceof ProcessingResourceSpecificationResult){
						ProcessingResourceSpecificationResult procUtilisationResult = (ProcessingResourceSpecificationResult)currentUtilisationResult;
						// only look at used servers
						if (EMFHelper.contains(this.getAvailableResourceContainers(individual), procUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification())
								// and has matching resource type if resource type is not null
								&& checkResourceType(procUtilisationResult, resourceType) ){
							if (maxUtilisationResult == null || maxUtilisationResult.getResourceUtilisation() < procUtilisationResult.getResourceUtilisation()) {
								maxUtilisationResult = procUtilisationResult;
							}
						}
					}
				}
				maxProcResultMap.put(resourceType, maxUtilisationResult);
				maxProcResult = maxUtilisationResult;
			} 
		}
		return maxProcResult;
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
			if (o.getName().contains("response time") 
					|| o.getName().contains("performance")
					|| o.getName().contains("throughput")) {
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



	public Set<ResourceType> getResourceTypes(DSEIndividual individual) {
		
		if (this.resourceTypes == null){
			resourceTypes = new HashSet<ResourceType>();
			
			DecisionSpace problem = individual.getProblem();
			for (DegreeOfFreedomInstance dof : problem.getDegreesOfFreedom()) {
				if (dof instanceof AllocationDegree){
					List<EObject> entities = ((AllocationDegree) dof).getClassDesignOptions();
					for (EObject entity : entities) {
						if (entity instanceof ResourceContainer){
							List<ProcessingResourceSpecification> resources = 
								((ResourceContainer) entity)
								.getActiveResourceSpecifications_ResourceContainer();
							for (ProcessingResourceSpecification processingResourceSpecification : resources) {
								resourceTypes.add(processingResourceSpecification.getActiveResourceType_ActiveResourceSpecification());
							}
						}
					}
					
				} else if (dof instanceof ProcessingResourceDegree){
					resourceTypes.add(((ProcessingResourceDegree) dof).getProcessingresourcetype());
				}
			}
			
		}
		
		return this.resourceTypes;
	}
	
}






