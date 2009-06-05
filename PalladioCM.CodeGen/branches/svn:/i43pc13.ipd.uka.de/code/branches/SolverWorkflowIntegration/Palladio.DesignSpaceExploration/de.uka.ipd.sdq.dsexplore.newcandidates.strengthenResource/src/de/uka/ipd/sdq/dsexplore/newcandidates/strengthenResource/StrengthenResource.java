package de.uka.ipd.sdq.dsexplore.newcandidates.strengthenResource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sun.org.apache.bcel.internal.classfile.CodeException;
import com.sun.org.apache.bcel.internal.generic.ALOAD;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.Triple;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.system.System;


public class StrengthenResource implements INewCandidates {
	
	/** Logger for log4j. */
	protected static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	private double threshold = 0.70;
	//strengthen the processing rate or capacity of each resource by this amount. 
	private double increaseFactor = 1.1;

	public StrengthenResource() {
	}
	
	@Override
	public List<PCMInstance> generateNewCandidates(IAnalysisResult currentSolution) throws CoreException {
		
		logger.debug("StrengthenResource called");
	
		try {
			
		// Find highly utilised resources (i.e. > 90 % utilisation, here > threshold)
		List<ContainerResourceUtilADT> utilisedResourcesResults = getResourceUtilisation(currentSolution);
		
		// TODO: Generate new candidates that have increased processing rates / capacity
		List<PCMInstance> resultingPCMInstances = new ArrayList<PCMInstance>();
		//If no resource is available with such a high utilisation, return an empty solution list
		if (utilisedResourcesResults.size() == 0)
			return resultingPCMInstances;
		
		//Only strengthen the first result, i.e. the resource with the highest utilisation. 
		PCMInstance instance = strengthenResource(currentSolution.getPCMInstance(), utilisedResourcesResults.get(0));
		resultingPCMInstances.add(instance);
		
		return resultingPCMInstances;
		
		} catch (AnalysisFailedException e) {
			e.printStackTrace();
			Status st = new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore",e.getMessage());
			throw new CoreException(st);
		}
	}

	/**
	 * Increases the processing rate of the passed resource by {@link #increaseFactor} and creates a new {@link PCMInstance} with the improved resource. 
	 * @param instance
	 * @param containerResourceUtilADT
	 * @return
	 */
	private PCMInstance strengthenResource(PCMInstance instance,
			ContainerResourceUtilADT cru) {
		
		PCMInstance newPCM = instance.shallowCopy();
		
		String suffix = "-incr"+cru.getSecond().getActiveResourceType_ActiveResourceSpecification().getEntityName()+cru.getFirst().getEntityName().charAt(cru.getFirst().getEntityName().length()-1);
		
		newPCM.setName(newPCM.getName()+suffix);
		
		ResourceEnvironment re = (ResourceEnvironment)EcoreUtil.copy(newPCM.getResourceenvironment());
		newPCM.setResourceenvironment(re);
		newPCM.appendToResEnvFileName("-"+suffix);
		
		Allocation alloc = (Allocation)EcoreUtil.copy(newPCM.getAllocation());
		newPCM.setAllocation(alloc);
		newPCM.appendToAllocationFileName("-"+suffix);
		
		alloc.setTargetResourceEnvironment_Allocation(re);
		
		ProcessingResourceSpecification r = findResourceIn(cru, newPCM);
		
		increaseProcessingRate(r);
		
		//newPCM.saveUpdatesToFile();
		
		return newPCM;
	}

	private ProcessingResourceSpecification findResourceIn(
			ContainerResourceUtilADT cru, PCMInstance newPCM) {
		List<ResourceContainer> resourceContainers = newPCM.getAllResourceContainers();
		
		ResourceContainer ourContainer = null;
		
		for (Iterator<ResourceContainer> iterator = resourceContainers
				.iterator(); iterator.hasNext();) {
			ResourceContainer resourceContainer = iterator.next();
			if (resourceContainer.getId().equals(cru.getFirst().getId())){
				ourContainer = resourceContainer;
				break;
			}
		}
		//found our container or null. 
		if (ourContainer == null){
			logger.error("Did not find our resource container "+cru.getFirst().getEntityName());
			return null;
		}
		
		List<ProcessingResourceSpecification> resources = ourContainer.getActiveResourceSpecifications_ResourceContainer();
		ProcessingResourceSpecification ourResource = null;
		
		for (Iterator<ProcessingResourceSpecification> iterator = resources
				.iterator(); iterator.hasNext();) {
			ProcessingResourceSpecification processingResourceSpecification = iterator
					.next();
			//XXX this only works as long each resource container has only one resource per type
			if (processingResourceSpecification.getActiveResourceType_ActiveResourceSpecification().getId().equals(cru.getSecond().getActiveResourceType_ActiveResourceSpecification().getId())){
				ourResource = processingResourceSpecification;
				break;
			}
		}
		//found our resource or null
		if (ourResource == null ) {
			logger.error("Did not find our resource of type"+cru.getSecond().getActiveResourceType_ActiveResourceSpecification().getEntityName());
			return null;
		}
		
		return ourResource;
	}

	private void increaseProcessingRate(
			ProcessingResourceSpecification ourResource) {
		String oldProcessingRate = ourResource.getProcessingRate_ProcessingResourceSpecification().getSpecification();
		ourResource.getProcessingRate_ProcessingResourceSpecification().setSpecification("("+oldProcessingRate+")*"+increaseFactor);
		//ourResource.getProcessingRate_ProcessingResourceSpecification().setSpecification("10.0");
		
		String newProcessingRate = ourResource.getProcessingRate_ProcessingResourceSpecification().getSpecification();
		
		logger.debug("Old rate: "+oldProcessingRate);
		logger.debug("New rate: "+newProcessingRate);
	}

	/**
	 * Gets a Triple<ResourceContainer, ProcessingResourceSpecification,
	 * Double> (latter is the utilisation) for resources in the given PCM
	 * Instance. Returns all resources for which the utilisation is higher that the {@link #threshold}.
	 * 
	 * TODO: Better create a decorator model for the PCM that encapsulates this information and provides it?
	 * 
	 * @param currentSolution
	 * @return A list of found resources with their containers and utilisation.  
	 * @throws AnalysisFailedException
	 */
	private List<ContainerResourceUtilADT> getResourceUtilisation(
			IAnalysisResult currentSolution) throws AnalysisFailedException {
		Collection<ResourceContainer> containers = currentSolution.getPCMInstance().getAllResourceContainers();
		
		List<ContainerResourceUtilADT> results = new ArrayList<ContainerResourceUtilADT>();
		
		for (Iterator<ResourceContainer> iterator = containers.iterator(); iterator
				.hasNext();) {
			ResourceContainer resourceContainer = iterator.next();
			
			Collection<ProcessingResourceSpecification> resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
				for (Iterator<ProcessingResourceSpecification> iterator2 = resources
						.iterator(); iterator2.hasNext();) {
					ProcessingResourceSpecification prs = iterator2
							.next();

						double utilisation = currentSolution.getUtilisationOfResource(resourceContainer, prs);
						logger.debug("Utilisation of "+resourceContainer.getEntityName()+": "+prs.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" is "+utilisation);
						if (utilisation > threshold){
							results.add(new ContainerResourceUtilADT(resourceContainer, prs, utilisation));
						}
					
				}
		}
		
		Collections.sort(results, Collections.reverseOrder());
		
		for (Iterator<ContainerResourceUtilADT> iterator = results.iterator(); iterator
				.hasNext();) {
			ContainerResourceUtilADT c = iterator.next();
			logger.debug("Result: Container "+c.getFirst().getEntityName()
					+" resource "+c.getSecond().getActiveResourceType_ActiveResourceSpecification().getEntityName()
					+" utilisation:  "+c.getThird());
		}
		return results;
	}

	@Override
	public void setConfiguration(ILaunchConfiguration conf) {
		try {
			this.increaseFactor = Double.parseDouble(conf.getAttribute(DSEConstantsContainer.INCR_FACTOR, "1.1"));
			this.threshold = Double.parseDouble(conf.getAttribute(DSEConstantsContainer.THRESHOLD, "0.7"));
		} catch (NumberFormatException e) {
			logger.error("Could not parse configuration in strengthen resource: NumberFormatException");
			e.printStackTrace();
		} catch (CoreException e) {
			logger.error("Could not parse configuration in strengthen resource: CoreException");
			e.printStackTrace();
		}

	}

}

class ContainerResourceUtilADT extends Triple<ResourceContainer, ProcessingResourceSpecification, Double> implements Comparable{

	public ContainerResourceUtilADT() {
		super();
	}

	public ContainerResourceUtilADT(ResourceContainer first,
			ProcessingResourceSpecification second, Double third) {
		super(first, second, third);
	}

	/**
	 * Compares based on utilisation. 
	 * {@inheritDoc}
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object other) {
		if (!ContainerResourceUtilADT.class.isInstance(other))
			return 0;
		else {
			ContainerResourceUtilADT cru = (ContainerResourceUtilADT) other;
			return this.getThird().compareTo(cru.getThird()); 
		}
	}
	
}
