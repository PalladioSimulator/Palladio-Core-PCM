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
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
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

	public void fixEntitiesForDomain(EnumerationDegree degree, List<Entity> memoryEntityList) {

		List<Entity> newList = new ArrayList<Entity>();
		
		for (Entity entity : degree.getDomainOfEntities()) {
			Entity rightOne = EMFHelper.retrieveEntityByID(memoryEntityList, entity.getId());
			newList.add(rightOne);
		}

		degree.getDomainOfEntities().clear();
		degree.getDomainOfEntities().addAll(newList);
	}

	private PCMInstance initialInstance;

	public FixDesignDecisionReferenceSwitch(PCMInstance initialInstance2) {
		this.initialInstance = initialInstance2;
	}

	@Override
	public EObject caseAllocationDegree(AllocationDegree object) {
		String id = object.getChangeableEntity().getId();
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		AllocationContext rightOne = (AllocationContext)EMFHelper.retrieveEntityByID(acs,id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find AllocationContext "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setChangeableEntity(rightOne);
		
		
		List<Entity> allCurrentServers = new ArrayList<Entity>();
		allCurrentServers.addAll(this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment());
		
		fixEntitiesForDomain(object, allCurrentServers);
		
		return object;
	}

	@Override
	public EObject caseCandidate(Candidate object) {
		List<Choice> choices = object.getChoice();
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
		
		Problem inMemoryProblem = Opt4JStarter.getProblem().getEMFProblem();
				
		DegreeOfFreedom originalDegree = object.getDegreeOfFreedom();
		doSwitch(originalDegree);
		
		boolean foundDegree = false;
		
		for (DegreeOfFreedom inMemoryDegree : inMemoryProblem.getDesigndecision()) {
			// Need to initialize this every time anew, because otherwise it will remember old comparisons and compares with previous matches. 
			EqualityHelper equalityHelper = new EqualityHelper();
			if (equalityHelper.equals(inMemoryDegree, originalDegree)){
				object.setDegreeOfFreedom(inMemoryDegree);
				foundDegree = true;
				break;
			}
		}
		
		if (!foundDegree){
			throw new RuntimeException("Fixing design decision references failed, could not find in memory degree for "+object.getDegreeOfFreedom());
		}
		return object;
	}

	@Override
	public EObject caseEnumerationChoice(EnumerationChoice object) {
		
		//First need to fix the references of the degrees of freedom  
		caseChoice(object);
	
		// Fix the chosen entity. Is one of the degree of freedoms domain (which must have been fixed before). 
		DegreeOfFreedom degree = object.getDegreeOfFreedom();
		if (degree instanceof EnumerationDegree){
			EnumerationDegree enumDegree = (EnumerationDegree)degree;
			Entity inMemoryEntity = EMFHelper.retrieveEntityByID(enumDegree.getDomainOfEntities(), object.getEntity().getId());
			
			if (inMemoryEntity == null){
				throw new RuntimeException("Cannot find Entity "+object.getEntity().getId()+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
			}
			
			object.setEntity(inMemoryEntity);
		} else {
			throw new RuntimeException("Invalid enumeration choice encountered: Referenced degree of freedom must be of type EnumerationDegree.");
		}
		
		return object;
	}

	@Override
	public EObject caseAssembledComponentDegree(
			AssembledComponentDegree object) {
		
		String id = object.getChangeableEntity().getId();
		List<AssemblyContext> acs = this.initialInstance.getSystem().getAssemblyContexts_ComposedStructure();
		AssemblyContext rightOne = (AssemblyContext)EMFHelper.retrieveEntityByID(acs, id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find AssemblyContext "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setChangeableEntity(rightOne);
		
		List<Entity> allCurrentComponents = new ArrayList<Entity>();
		List<Repository> repositories = this.initialInstance.getRepositories();
		for (Repository repository : repositories) {
			allCurrentComponents.addAll(repository.getComponents__Repository());
		}
		
		fixEntitiesForDomain(object, allCurrentComponents);

		return object;
	}


	@Override
	public EObject caseProblem(Problem object) {
		for (DegreeOfFreedom dd : object.getDesigndecision()) {
			doSwitch(dd);
		};
		return object;
	}

	@Override
	public EObject caseProcessingResourceDegree(ProcessingResourceDegree object) {
		String id = ((ResourceContainer)object.getChangeableEntity()).getId();
			
		List<ResourceContainer> rcs = this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(rcs, id);
		
		if (rightOne == null){
			throw new RuntimeException("Cannot find ResourceContainer "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
		}
		
		object.setChangeableEntity(rightOne);
		
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
		
		String id = (object.getChangeableEntity()).getId();
		
		List<Repository> repos = this.initialInstance.getRepositories();
		for (Repository repository : repos) {
			List<RepositoryComponent> components = repository.getComponents__Repository();
			for (RepositoryComponent component : components) {
				if (component instanceof BasicComponent){
					List<PassiveResource> prs = ((BasicComponent)component).getPassiveResource_BasicComponent();
					PassiveResource rightOne = (PassiveResource)EMFHelper.retrieveEntityByID(prs, id);
					if (rightOne != null){
						object.setChangeableEntity(rightOne);
						return object;
					}
				}
			}
		}
		//logger.warn("Could not find "+object.getChangeableEntity().getEntityName()+" in design decision reference switch, errors may occur.");
		throw new RuntimeException("Cannot find PassiveResource "+id+" in the specified PCM ALlocation Model. Maybe the design decision file does not match the analysed PCM instance?");
	}

	@Override
	public EObject caseResourceContainerReplicationDegree(
			ResourceContainerReplicationDegree object) {
		// TODO Auto-generated method stub
		return super.caseResourceContainerReplicationDegree(object);
	}
	
	

	
	
}
