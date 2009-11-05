package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionSwitch;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class FixDesignDecisionReferenceSwitch extends designdecisionSwitch<EObject> {

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

	public FixDesignDecisionReferenceSwitch(PCMInstance initialInstance) {
		this.initialInstance = initialInstance;
	}

	@Override
	public EObject caseAllocationDegree(AllocationDegree object) {
		String id = object.getChangeableEntity().getId();
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		AllocationContext rightOne = (AllocationContext)EMFHelper.retrieveEntityByID(acs,id);
		object.setChangeableEntity(rightOne);
		
		
		List<Entity> allCurrentServers = new ArrayList<Entity>();
		allCurrentServers.addAll(this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment());
		
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
		allCurrentComponents.addAll(this.initialInstance.getRepository().getComponents__Repository());
		
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
	public EObject caseProcessingRateDegree(ProcessingRateDegree object) {
		String id = ((ResourceContainer)object.getChangeableEntity()).getId();
			
		List<ResourceContainer> rcs = this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment();
		ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(rcs, id);
		object.setChangeableEntity(rightOne);
		return object;
	}

	@Override
	public EObject caseResourceContainerReplicationDegree(
			ResourceContainerReplicationDegree object) {
		// TODO Auto-generated method stub
		return super.caseResourceContainerReplicationDegree(object);
	}

	
	
}
