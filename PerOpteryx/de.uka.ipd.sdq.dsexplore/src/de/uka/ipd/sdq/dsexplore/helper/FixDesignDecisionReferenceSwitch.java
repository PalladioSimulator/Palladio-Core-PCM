package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ConcurrentProcessingSystemImplCatia;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionSwitch;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

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
		object.setChangeableEntity(rightOne);
		
		
		List<Entity> allCurrentServers = new ArrayList<Entity>();
		allCurrentServers.addAll(this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment());
		
		fixEntitiesForDomain(object, allCurrentServers);
		
		return object;
	}

	@Override
	public EObject caseAssembledComponentDegree(
			AssembledComponentDegree object) {
		
		String id = object.getChangeableEntity().getId();
		List<AssemblyContext> acs = this.initialInstance.getSystem().getAssemblyContexts_ComposedStructure();
		AssemblyContext rightOne = (AssemblyContext)EMFHelper.retrieveEntityByID(acs, id);
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
		object.setChangeableEntity(rightOne);
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
		logger.warn("Could not find "+object.getChangeableEntity().getEntityName()+" in design decision reference switch, errors may occur.");
		return object;
	}

	@Override
	public EObject caseResourceContainerReplicationDegree(
			ResourceContainerReplicationDegree object) {
		// TODO Auto-generated method stub
		return super.caseResourceContainerReplicationDegree(object);
	}
	
	

	
	
}
