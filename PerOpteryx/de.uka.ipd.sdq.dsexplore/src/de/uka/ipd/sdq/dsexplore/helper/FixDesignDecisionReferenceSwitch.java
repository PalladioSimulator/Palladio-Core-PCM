package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.Candidate;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegreeWithComponentChange;
import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionSwitch;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

/**
 * This class fixes the references of designdecision models. The problem 
 * addressed is, that if you separately load a PCM model and a designdecision
 * model, the object identities of the loaded elements are not the same. For 
 * example, a basic component A may be represented by a Java object A1 when 
 * loaded directly from the repository file. When a degree of freedom model is 
 * loaded, and the PCM instance is accessed usingthe references in that model,
 * the PCM model is loaded again and the component A is represented by a second
 * Java object A2. Calling equals on A1 and A2 results in false. Thus,
 * collection.contains(A1) will fail even if A2 is contained. 
 * 
 * Thus, this class fixes the references by replacing each reference to A2 to 
 * a reference to A1, so that only one consistent object tree represents the 
 * models at the end. 
 * 
 * XXX: Maybe this could be done more generically based on EObject and the structural 
 * features, without being meta model dependent. 
 * 
 * One solution idea was to just use the same EMF resource set when loading more models 
 * and then resolve proxies using ECoreUtil#resolveAll. Although this worked before 2011-02-24,
 * it did not work anymore afterwards, so I reenabled this switch. 
 * 
 * @author martens
 */
public class FixDesignDecisionReferenceSwitch extends designdecisionSwitch<EObject> {
	
	protected static Logger logger = Logger
		.getLogger(FixDesignDecisionReferenceSwitch.class.getName());

	public void fixEntitiesForDomain(List<EObject> eListToUpdate, List<Entity> memoryEntityList) {

		List<Entity> newList = new ArrayList<Entity>();
		
		for (EObject entity : eListToUpdate) {
			Entity rightOne = EMFHelper.retrieveEntityByID(memoryEntityList, entity);
			newList.add(rightOne);
		}

		eListToUpdate.clear();
		eListToUpdate.addAll(newList);
	}

	private PCMInstance initialInstance;

	public FixDesignDecisionReferenceSwitch(PCMInstance initialInstance2) {
		this.initialInstance = initialInstance2;
	}

	@Override
	public EObject caseAllocationDegree(AllocationDegree object) {
		String id = ((AllocationContext)object.getPrimaryChanged()).getId();
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		AllocationContext rightOne = (AllocationContext)EMFHelper.retrieveEntityByID(acs,id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find AllocationContext "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setPrimaryChanged(rightOne);
		
		
		List<Entity> allCurrentServers = new ArrayList<Entity>();
		allCurrentServers.addAll(this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment());
		
		fixEntitiesForDomain(object.getClassDesignOptions(), allCurrentServers);
		
		return object;
	}

	@Override
	public EObject caseCandidate(Candidate object) {
		List<Choice> choices = object.getChoices();
		for (Choice choice : choices) {
			doSwitch(choice);
		}
		
		return object;
	}

	@Override
	public EObject caseCandidates(Candidates object) {
		
		object.setProblem(Opt4JStarter.getProblem().getEMFProblem());
		
		for (Candidate candidate: object.getCandidate()) {
			doSwitch(candidate);
		}
		return object;
	}

	@Override
	public EObject caseChoice(Choice object) {
		
		DecisionSpace inMemoryProblem = Opt4JStarter.getProblem().getEMFProblem();
		
		DegreeOfFreedomInstance originalDegree = object.getDegreeOfFreedomInstance();		
		
		doSwitch(originalDegree);
		
		boolean foundDegree = false;
		
		for (DegreeOfFreedomInstance inMemoryDegree : inMemoryProblem.getDegreesOfFreedom()) {
			// Need to initialize this every time anew, because otherwise it will remember old comparisons and compares with previous matches. 
			EqualityHelper equalityHelper = new EqualityHelper();
			if (equalityHelper.equals(inMemoryDegree, originalDegree)){
				object.setDegreeOfFreedomInstance(inMemoryDegree);
				foundDegree = true;
				break;
			}
		}
		
		if (!foundDegree){
			throw new RuntimeException("Fixing design decision references failed, could not find in memory degree for "+object.getDegreeOfFreedomInstance());
		}
		return object;
	}

	@Override
	public EObject caseClassChoice(ClassChoice object) {
		
		//First need to fix the references of the degrees of freedom  
		caseChoice(object);
	
		// Fix the chosen entity. Is one of the degree of freedoms domain (which must have been fixed before). 
		DegreeOfFreedomInstance degree = object.getDegreeOfFreedomInstance();
		if (degree instanceof ClassDegree){
			ClassDegree enumDegree = (ClassDegree)degree;
			Entity inMemoryEntity = EMFHelper.retrieveEntityByID(enumDegree.getClassDesignOptions(), object.getChosenValue());
			
			if (inMemoryEntity == null){
				throw new RuntimeException("Cannot find Entity "+((Entity)object.getChosenValue()).getId()+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
			}
			
			object.setChosenValue(inMemoryEntity);
		} else {
			throw new RuntimeException("Invalid enumeration choice encountered: Referenced degree of freedom must be of type ClassDegree.");
		}
		
		return object;
	}

	@Override
	public EObject caseAssembledComponentDegree(
			AssembledComponentDegree object) {
		
		String id = ((Entity)object.getPrimaryChanged()).getId();
		List<AssemblyContext> acs = this.initialInstance.getSystem().getAssemblyContexts__ComposedStructure();
		AssemblyContext rightOne = (AssemblyContext)EMFHelper.retrieveEntityByID(acs, id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find AssemblyContext "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setPrimaryChanged(rightOne);
		
		List<Entity> allCurrentComponents = new ArrayList<Entity>();
		List<Repository> repositories = this.initialInstance.getRepositories();
		for (Repository repository : repositories) {
			allCurrentComponents.addAll(repository.getComponents__Repository());
		}
		
		fixEntitiesForDomain(object.getClassDesignOptions(), allCurrentComponents);

		return object;
	}


	@Override
	public EObject caseDecisionSpace(DecisionSpace object) {
		
		try {
			for (DegreeOfFreedomInstance dd : object.getDegreesOfFreedom()) {
				doSwitch(dd);
			};
		} catch (ClassCastException e){
			logger.error("Class cast exception when visiting .designdecision model. Please check your model for validity using the Ecore tree editor. References might be broken.");
			throw e;
		}
		return object;
	}

	@Override
	public EObject caseProcessingResourceDegree(ProcessingResourceDegree object) {
		String id = ((ResourceContainer)object.getPrimaryChanged()).getId();
			
		List<ResourceContainer> rcs = this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(rcs, id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find ResourceContainer "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setPrimaryChanged(rightOne);
		
		ProcessingResourceType originalType = object.getProcessingresourcetype();
		List<ProcessingResourceSpecification> resources = rightOne.getActiveResourceSpecifications_ResourceContainer();
		boolean foundResourceType = false;
		for (ProcessingResourceSpecification resource : resources) {
			if (EMFHelper.checkIdentity(resource.getActiveResourceType_ActiveResourceSpecification(), originalType)){
				object.setProcessingresourcetype(resource.getActiveResourceType_ActiveResourceSpecification());
				foundResourceType = true;
				break;
			}
		}
		if (!foundResourceType){
			throw new RuntimeException("Fixing design decision references failed, could not find in memory resource type for "+object.getProcessingresourcetype());
		}
		
		return object;
	}

	@Override
	public EObject caseCapacityDegree(CapacityDegree object) {
		
		String id = ((Entity)object.getPrimaryChanged()).getId();
		
		List<Repository> repos = this.initialInstance.getRepositories();
		for (Repository repository : repos) {
			List<RepositoryComponent> components = repository.getComponents__Repository();
			for (RepositoryComponent component : components) {
				if (component instanceof BasicComponent){
					List<PassiveResource> prs = ((BasicComponent)component).getPassiveResource_BasicComponent();
					PassiveResource rightOne = (PassiveResource)EMFHelper.retrieveEntityByID(prs, id);
					if (rightOne != null){
						object.setPrimaryChanged(rightOne);
						return object;
					}
				}
			}
		}
		//logger.warn("Could not find "+object.getPrimaryChanged().getEntityName()+" in design decision reference switch, errors may occur.");
		throw new RuntimeException("Cannot find PassiveResource "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
	}

	@Override
	public EObject caseResourceContainerReplicationDegree(
			ResourceContainerReplicationDegree object) {
		String id = ((Entity)object.getPrimaryChanged()).getId();
		List<ResourceContainer> acs = this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(acs,id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find ResourceContainer "+id+" in the specified PCM ResourceEnvironment Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setPrimaryChanged(rightOne);
		
		return object;
	}

	@Override
	public EObject caseResourceContainerReplicationDegreeWithComponentChange(
			ResourceContainerReplicationDegreeWithComponentChange object) {
		
		caseResourceContainerReplicationDegree(object);
		
		for (ExchangeComponentRule rule : object.getExchangeComponentRule()) {
			String id = rule.getAllocationContext().getId();
			
			List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
			AllocationContext rightOne = (AllocationContext)EMFHelper.retrieveEntityByID(acs, id);
			rule.setAllocationContext(rightOne);
			
			List<Entity> allCurrentComponents = new ArrayList<Entity>();
			List<Repository> repositories = this.initialInstance.getRepositories();
			for (Repository repository : repositories) {
				allCurrentComponents.addAll(repository.getComponents__Repository());
			}
			
			List<RepositoryComponent> newList = new ArrayList<RepositoryComponent>();
			
			for (RepositoryComponent entity : rule.getRepositoryComponent()) {
				RepositoryComponent rightOne2 = (RepositoryComponent)EMFHelper.retrieveEntityByID(allCurrentComponents, entity);
				newList.add(rightOne2);
			}

			rule.getRepositoryComponent().clear();
			rule.getRepositoryComponent().addAll(newList);
		}
		
		return object; 
	}
	
	
	
	

	
	
}
