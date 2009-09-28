package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDecision;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision;
import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionSwitch;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class FixDesignDecisionReferenceSwitch extends designdecisionSwitch<EObject> {

	@Override
	public EObject caseAvailableServers(AvailableServers object) {
		List<ResourceContainer> rcs = object.getResourcecontainer();
		List<ResourceContainer> memoryRcs = this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment();
		
		List<ResourceContainer> newList = new ArrayList<ResourceContainer>();
		
		for (ResourceContainer resourceContainer : rcs) {
			ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(memoryRcs, resourceContainer.getId());
			newList.add(rightOne);
		}
		object.getResourcecontainer().clear();
		object.getResourcecontainer().addAll(newList);
		
		return object;
	}

	@Override
	public EObject caseEquivalentComponents(EquivalentComponents object) {
		List<RepositoryComponent> rcs = object.getRepositorycomponent();
		List<RepositoryComponent> memoryRcs = this.initialInstance.getRepository().getComponents__Repository();
		
		List<RepositoryComponent> newList = new ArrayList<RepositoryComponent>();
		
		for (RepositoryComponent repositoryComponent : rcs) {
			RepositoryComponent rightOne = (RepositoryComponent)EMFHelper.retrieveEntityByID(memoryRcs, repositoryComponent.getId());
			newList.add(rightOne);
		}
		object.getRepositorycomponent().clear();
		object.getRepositorycomponent().addAll(newList);
		
		return object;
	}

	private PCMInstance initialInstance;

	public FixDesignDecisionReferenceSwitch(PCMInstance initialInstance) {
		this.initialInstance = initialInstance;
	}

	@Override
	public EObject caseAllocationDecision(AllocationDecision object) {
		String id = object.getAllocationcontext().getId();
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		AllocationContext rightOne = (AllocationContext)EMFHelper.retrieveEntityByID(acs,id);
		object.setAllocationcontext(rightOne);
		doSwitch(object.getDomain());
		return object;
	}

	@Override
	public EObject caseAssembledComponentDecision(
			AssembledComponentDecision object) {
		
		String id = object.getAssemblycontext().getId();
		List<AssemblyContext> acs = this.initialInstance.getSystem().getAssemblyContexts_ComposedStructure();
		AssemblyContext rightOne = (AssemblyContext)EMFHelper.retrieveEntityByID(acs, id);
		object.setAssemblycontext(rightOne);
		doSwitch(object.getDomain());
		return object;
	}

	@Override
	public EObject caseConnectorConfigDecision(ConnectorConfigDecision object) {
		// TODO Auto-generated method stub
		return super.caseConnectorConfigDecision(object);
	}

	@Override
	public EObject caseProblem(Problem object) {
		for (DesignDecision dd : object.getDesigndecision()) {
			doSwitch(dd);
		};
		return object;
	}

	@Override
	public EObject caseProcessingRateDecision(ProcessingRateDecision object) {
		String id = ((ResourceContainer)object.getProcessingresourcespecification().eContainer()).getId();
		String idProcSpec = object.getProcessingresourcespecification().getActiveResourceType_ActiveResourceSpecification().getId();
			
		List<ResourceContainer> rcs = this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment();
		ResourceContainer rightOne = (ResourceContainer)EMFHelper.retrieveEntityByID(rcs, id);
		List<ProcessingResourceSpecification> prs = rightOne.getActiveResourceSpecifications_ResourceContainer();
		for (ProcessingResourceSpecification processingResourceSpecification : prs) {
			if (processingResourceSpecification.getActiveResourceType_ActiveResourceSpecification().getId().equals(idProcSpec)){
				object.setProcessingresourcespecification(processingResourceSpecification);
				break;
			}
		}
		doSwitch(object.getDomain());
		return object;
	}

	@Override
	public EObject caseResourceContainerReplicationDecision(
			ResourceContainerReplicationDecision object) {
		// TODO Auto-generated method stub
		return super.caseResourceContainerReplicationDecision(object);
	}

	
	
}
