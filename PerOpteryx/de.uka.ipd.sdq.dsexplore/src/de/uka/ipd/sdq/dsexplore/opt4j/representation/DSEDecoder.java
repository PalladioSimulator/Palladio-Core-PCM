package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.problem.Decoder;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.exception.ChoiceOutOfBoundsException;
import de.uka.ipd.sdq.dsexplore.exception.ExceptionHelper;
import de.uka.ipd.sdq.dsexplore.exception.InvalidChoiceForDegreeException;
import de.uka.ipd.sdq.dsexplore.helper.DegreeOfFreedomHelper;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.cost.helper.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.RangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

/**
 * The {@link DSEDecoder} is responsible for converting the genotypes into 
 * proper PCM instances that can then be analysed.
 *  
 * @author Anne
 *
 */
public class DSEDecoder implements Decoder<DesignDecisionGenotype, PCMPhenotype> {
	
	//private final DSEProblem problem;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/** Store first MTTF and rate values to adjust later MTTF with (see {@link #applyChangeProcessingRateDecision(ContinuousProcessingRateDegree, Choice)}).*/
	private double initialMTTF = Double.NaN;
	/** @see #initialMTTF */
	private double initialRate = Double.NaN;

	@Inject
	public DSEDecoder(){
		//XXX like this you can only set the problem once. Maybe don't save the reference. 
		//this.problem = Opt4JStarter.problem;
	}

	@Override
	public PCMPhenotype decode(DesignDecisionGenotype genotype) {
		
		//get PCM Instance
		PCMInstance pcm = Opt4JStarter.getProblem().getInitialInstance();
		
		//adjust values as in genotype
		for (Choice doubleGene : genotype) {
			
			applyChange(doubleGene.getDegreeOfFreedomInstance(), doubleGene);
		}
		
		String genotypeString = getGenotypeString(genotype);
		
		//encapsulate as phenotype 
		//return new PCMPhenotype(pcm.deepCopy(),genotypeStringBuilder.toString());
		return new PCMPhenotype(pcm,genotypeString, genotype.getNumericID());
	}

	/**
	 * Applies the given change to the initial pcm instance (as this is 
	 * referenced by the design decisions. More precisely, this one calls 
	 * calls specialized methods for dealing with different types of design 
	 * decisions.  
	 * 
	 * @param designDecision
	 * @param pcm
	 * @param choice The new value the design decision should take. 
	 */
	private void applyChange(DegreeOfFreedomInstance designDecision, Choice choice) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDegree.class.isInstance(designDecision)){
			this.applyChangeProcessingRateDecision((ProcessingRateDegree)designDecision, choice);
		} else if (AssembledComponentDegree.class.isInstance(designDecision)){
			this.applyChangeAssembledComponentDecision((AssembledComponentDegree)designDecision, choice);
		} else if (AllocationDegree.class.isInstance(designDecision)){
			this.applyChangeAllocationDecision((AllocationDegree)designDecision, choice);
		} else if (SchedulingPolicyDegree.class.isInstance(designDecision)){
			this.applyChangeSchedulingDecision((SchedulingPolicyDegree)designDecision, choice);
		} else if (CapacityDegree.class.isInstance(designDecision)){
			this.applyChangeCapacityDecision((CapacityDegree)designDecision, choice);
		} else if (NumberOfCoresDegree.class.isInstance(designDecision)){
			this.applyChangeNumberOfCoresDecision((NumberOfCoresDegree)designDecision, choice);
		} else if (ResourceContainerReplicationDegree.class.isInstance(designDecision)){
			this.applyChangeResourceContainerReplicationDegree((ResourceContainerReplicationDegree)designDecision, choice);
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
	}

	private void applyChangeResourceContainerReplicationDegree(
			ResourceContainerReplicationDegree designDecision, Choice choice) {
		
		if (!(choice instanceof DiscreteRangeChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice;
				
		int numberOfServers = discreteChoice.getChosenValue();
		
		EObject changeableEntity = designDecision.getPrimaryChanged();
		if (!(changeableEntity instanceof ResourceContainer)){
			throwInvalidEntityException(designDecision, changeableEntity, ResourceContainer.class);
		}
		ResourceContainer server = (ResourceContainer)changeableEntity;
		
		if (numberOfServers < 1){
			throw new ChoiceOutOfBoundsException(discreteChoice);
		}
		
		PCMInstance pcm = Opt4JStarter.getProblem().getInitialInstance();
		
		// first reset the changes possibly made for earlier candidates
		List<ResourceContainer> allServers = pcm.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		List<ResourceContainer> previousReplicasToRemove = new ArrayList<ResourceContainer>();
		for (ResourceContainer resourceContainer : allServers) {
			if (resourceContainer.getId().contains(server.getId()) && resourceContainer.getEntityName().contains("Replica")){
				previousReplicasToRemove.add(resourceContainer);
			}
		}
		allServers.removeAll(previousReplicasToRemove);
		// also remove them from linking resources
		List<LinkingResource> linkingResources = pcm.getResourceEnvironment().getLinkingResources__ResourceEnvironment();
		for (LinkingResource linkingResource : linkingResources) {
			linkingResource.getConnectedResourceContainers_LinkingResource().removeAll(previousReplicasToRemove);
		}
		
		List<AllocationContext> allocationContextsToRemove = new ArrayList<AllocationContext>();
		for (AllocationContext allocationContext : pcm.getAllocation().getAllocationContexts_Allocation()) {
			if (previousReplicasToRemove.contains(allocationContext.getResourceContainer_AllocationContext())){
				allocationContextsToRemove.add(allocationContext);
			}
		}
		pcm.getAllocation().getAllocationContexts_Allocation().removeAll(allocationContextsToRemove);
		
		// Apply the current value of the genome.
		if (numberOfServers == 1){
			// no replication, keep original model with just one resource container.
			// XXX: assumes that the original model has no replication. 
		} else {
			 // retrieve components deployed to this server
			 List<AllocationContext> allocationContexts = pcm.getAllocation().getAllocationContexts_Allocation();
			 List<AllocationContext> allocationContextsOnServer = getAllocationContextsOnServer(allocationContexts, server);
			
			// the initial server is already there, so add numberOfServers - 1 new servers 
			for (int i = 1; i < numberOfServers; i++){
				// add a server, replicate all components on it.
				
				ResourceContainer serverCopy = (ResourceContainer) EcoreUtil.copy(server);
				serverCopy.setId(serverCopy.getId()+i);
				serverCopy.setEntityName(serverCopy.getEntityName()+"Replica"+i);
				pcm.getResourceEnvironment().getResourceContainer_ResourceEnvironment().add(serverCopy);
				
				// connect the new server copy to all linking resources that the old one is connected to
				for (LinkingResource linkingResource : linkingResources) {
					if (linkingResource.getConnectedResourceContainers_LinkingResource().contains(server)){
						linkingResource.getConnectedResourceContainers_LinkingResource().add(serverCopy);
					}
				}
				
				for (AllocationContext allocationContext : allocationContextsOnServer) {
					AllocationContext allocationContextCopy = (AllocationContext) EcoreUtil.copy(allocationContext);
					allocationContextCopy.setId(allocationContextCopy.getId()+i);
					allocationContextCopy.setEntityName(allocationContextCopy.getEntityName()+"Replica"+i);
					
					allocationContextCopy.setResourceContainer_AllocationContext(serverCopy);
					
					pcm.getAllocation().getAllocationContexts_Allocation().add(allocationContextCopy);
				}
			}
		}
	}

	private List<AllocationContext> getAllocationContextsOnServer(
			List<AllocationContext> allocationContexts, ResourceContainer server) {
		List<AllocationContext> allocationContextsOnThisServer = new LinkedList<AllocationContext>();
		for (AllocationContext allocationContext : allocationContexts) {
			if (EMFHelper.checkIdentity(allocationContext.getResourceContainer_AllocationContext(), server)){
				allocationContextsOnThisServer.add(allocationContext);
			}
		}
		return allocationContextsOnThisServer;
	}

	private void applyChangeNumberOfCoresDecision(
			NumberOfCoresDegree designDecision, Choice choice) {
		if (!(choice instanceof DiscreteRangeChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		
		DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice;
		
		ProcessingResourceSpecification rightPrs = getProcessingRateSpecification(designDecision);
		rightPrs.setNumberOfReplicas(discreteChoice.getChosenValue());
		
	}

	private void applyChangeCapacityDecision(CapacityDegree designDecision,
			Choice choice) {
		if (!(choice instanceof DiscreteRangeChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		
		DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice;
		
		PassiveResource passiveResource = (PassiveResource)designDecision.getPrimaryChanged();
		passiveResource.getCapacity_PassiveResource().setSpecification(String.valueOf(discreteChoice.getChosenValue()));
		
	}

	private void applyChangeAllocationDecision(
			AllocationDegree designDecision, Choice choice) {
		
		if (!(choice instanceof ClassChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		ClassChoice enumChoice = (ClassChoice)choice;
		
		EObject entity = enumChoice.getChosenValue();
		if (!(entity instanceof ResourceContainer)){
			throwInvalidEntityException(designDecision,entity,ResourceContainer.class);
		}
				
		ResourceContainer rc = (ResourceContainer)entity;
		
		((AllocationContext)designDecision.getPrimaryChanged()).setResourceContainer_AllocationContext(rc);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting resource container to "+rc.getEntityName()+ " for allocation context "+designDecision.getPrimaryChanged());
		
	}
	
	private void applyChangeSchedulingDecision(
			SchedulingPolicyDegree designDecision, Choice choice) {
		if (!(choice instanceof ClassChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		
		ClassChoice schedChoice = (ClassChoice)choice;
		SchedulingPolicy chosenPolicy = (SchedulingPolicy) schedChoice.getChosenValue();
		
		ProcessingResourceSpecification rightPrs = getProcessingRateSpecification(designDecision);
		
		rightPrs.setSchedulingPolicy(chosenPolicy);
		
	}

	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene
	 */
	private void applyChangeProcessingRateDecision (ProcessingRateDegree designDecision, Choice choice) {
		//XXX The value is changed in the original model, not in a copy. 

		if (!(choice instanceof ContinousRangeChoice || choice instanceof DiscreteRangeChoice)){
			throwNewInvalidChoiceException(designDecision,choice);
		}
		
		double newRate = 0;
		if (choice instanceof ContinousRangeChoice){
			ContinousRangeChoice doubleGene = (ContinousRangeChoice)choice;
			newRate = doubleGene.getChosenValue();
		} else {
			DiscreteRangeChoice doubleGene = (DiscreteRangeChoice)choice;
			DiscreteProcessingRateDegree degree = (DiscreteProcessingRateDegree)designDecision;
			newRate = degree.getFrom() + ((degree.getTo() - degree.getFrom()) / degree.getNumberOfSteps()) * doubleGene.getChosenValue();

		}
		
		ProcessingResourceSpecification rightPrs = getProcessingRateSpecification(designDecision);
		
		// get initial models MTTF and rate to scale upcoming candidates MTTF with
		if (Double.isNaN(this.initialRate)){
			//old spec for adjusting MTTF
			String oldRateString = rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification();
			this.initialRate = CostUtil.getInstance().getDoubleFromSpecification(oldRateString);
		}
		if (Double.isNaN(this.initialMTTF)){
			this.initialMTTF = rightPrs.getMTTF();
		}
		
		double mttf = this.initialMTTF * newRate / this.initialRate;
		
		//round to just four digits after decimal sign, to maybe have no errors by the above 
		//long l = (int)Math.round(mttf * 100000000); // truncates  
		//mttf = l / 100000000.0;  
		
		rightPrs.getProcessingRate_ProcessingResourceSpecification().setSpecification(String.valueOf(newRate));
		rightPrs.setMTTF(mttf);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+newRate+" and MTTF to "+mttf+" (inital MTTF: "+this.initialMTTF+")");
	}

	private ProcessingResourceSpecification getProcessingRateSpecification(
			ProcessingResourceDegree designDecision) {
		ResourceContainer rc = ((ResourceContainer)designDecision.getPrimaryChanged());
		ProcessingResourceType prt = designDecision.getProcessingresourcetype();
		
		ProcessingResourceSpecification rightPrs = null;
		for (ProcessingResourceSpecification prs : rc.getActiveResourceSpecifications_ResourceContainer()) {
			if (EMFHelper.checkIdentity(prs.getActiveResourceType_ActiveResourceSpecification(),prt)){
				rightPrs = prs;
				break;
			}
		}
		
		if (rightPrs == null){
			throw new RuntimeException("Invalid degree of freedom "+designDecision.toString()+". The references ProcessingResourceType is not available in the given ResourceContainer.");
		}
		return rightPrs;
	}
	
	private void throwNewInvalidChoiceException(
			DegreeOfFreedomInstance designDecision, Choice choice) {
		throw new InvalidChoiceForDegreeException(choice);
		
	}

	private void applyChangeAssembledComponentDecision ( AssembledComponentDegree designDecision, Choice choice) {
		
		if (!(choice instanceof ClassChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		ClassChoice enumChoice = (ClassChoice)choice;
		
		//use the order of the enumeration of EquivalentComponents in the Domain
		EObject entity = enumChoice.getChosenValue();
		if (!(entity instanceof RepositoryComponent)){
			throwInvalidEntityException(designDecision,entity,RepositoryComponent.class);
		}
		RepositoryComponent componentToBeAssembled = (RepositoryComponent)entity;
		
		AssemblyContext changedAssemblyContext = (AssemblyContext)designDecision.getPrimaryChanged();
		RepositoryComponent currentComponent = changedAssemblyContext.getEncapsulatedComponent__AssemblyContext();
		
		//Do not replace component if it is already assembled.  
		if (!EMFHelper.checkIdentity(currentComponent, componentToBeAssembled)){
			AlternativeComponent.getInstance().applyChange(changedAssemblyContext, componentToBeAssembled);
		}
		
		
		logger.debug("Handling a "+designDecision.getClass()+", using component "+componentToBeAssembled.getEntityName());
	}
	
	private void throwInvalidEntityException(
			DegreeOfFreedomInstance designDecision, EObject changeableEntity,
			Class<?> expectedClass) {
		throw new RuntimeException("Entity "+changeableEntity+" of type "+changeableEntity.getClass().getName()+" is not an applicable value for degree of freedom "+designDecision.getClass().getName()+", required type is "+expectedClass.getName());
		
	}

	public static String getGenotypeString(DesignDecisionGenotype genotype) {
		StringBuilder genotypeStringBuilder = new StringBuilder(100);
		for (Choice choice : genotype) {
			genotypeStringBuilder.append(DSEDecoder.getDecisionString(choice)+";");
		}
		return genotypeStringBuilder.toString();
	}
	
	public static String getDecisionString(Choice choice){
		DegreeOfFreedomInstance designDecision = choice.getDegreeOfFreedomInstance();
		
		String result = "";
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (choice instanceof ContinousRangeChoice){
			result = ResultsWriter.formatDouble(((ContinousRangeChoice) choice).getChosenValue());
		} else if (choice instanceof ClassChoice){
			if (((ClassChoice) choice).getChosenValue() instanceof Entity){
				result = ((Entity)((ClassChoice)choice).getChosenValue()).getEntityName();
			} else {
				result = ((ClassChoice)choice).getChosenValue().toString();
			}
		} else if (choice instanceof DiscreteRangeChoice){
			result = String.valueOf(((DiscreteRangeChoice)choice).getChosenValue());
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
		return result;
	}

	/**
	 * Calls getDoubleValueFor(String decisionString, DesignDecision designDecision)
	 * @param index
	 * @param decisionString
	 * @return
	 * @throws CoreException 
	 */
	public static Choice getChoiceForIndex(int index, String decisionString) throws CoreException{
		
		DegreeOfFreedomInstance designDecision = Opt4JStarter.getProblem().getDesignDecision(index); 
		
		Choice value = getChoiceFor(decisionString, designDecision);
		
		return value;
		
}

	public static Choice getChoiceFor(String decisionString,
			DegreeOfFreedomInstance designDecision) throws CoreException {
		Choice choice;
		
		designdecisionFactory factory = designdecisionFactoryImpl.init();
		
		if (designDecision instanceof ContinuousRangeDegree){
			ContinuousRangeDegree contDegree = (ContinuousRangeDegree) designDecision;
			double d = Double.parseDouble(decisionString);
			if (!validRange(d, contDegree, contDegree.getFrom(), contDegree.getTo())){
				throw ExceptionHelper.createNewCoreException("Error: Value "+d+" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			ContinousRangeChoice contChoice = factory.createContinousRangeChoice();
			contChoice.setChosenValue(d);
			choice = contChoice;
		} else if (designDecision instanceof DiscreteRangeDegree){
			DiscreteRangeDegree discDegree = (DiscreteRangeDegree) designDecision;
			int i = Integer.parseInt(decisionString);
			if (!validRange(i, discDegree, discDegree.getFrom(), discDegree.getTo())){
				throw ExceptionHelper.createNewCoreException("Error: Value "+i+"\" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			DiscreteRangeChoice discChoice = factory.createDiscreteRangeChoice();
			discChoice.setChosenValue(i);
			choice = discChoice;
		} else if (designDecision instanceof ClassDegree){
			
			ClassChoice enumChoice = factory.createClassChoice();
			Entity entity = getEntityFor((ClassDegree)designDecision, decisionString);
			if (entity == null){
				throw ExceptionHelper.createNewCoreException("Error: Decision string \""+decisionString+"\" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			enumChoice.setChosenValue(entity);
			choice = enumChoice;
		} else if (designDecision instanceof SchedulingPolicyDegree){
			
			ClassChoice schedChoice = factory.createClassChoice();
			SchedulingPolicy chosenPolicy = null;
			
			List<EObject> options = ((SchedulingPolicyDegree) designDecision).getClassDesignOptions();
			for (EObject option : options) {
				if (option instanceof SchedulingPolicy){
					SchedulingPolicy policy = (SchedulingPolicy)option;
					if (policy.getEntityName().equals(decisionString));
					chosenPolicy = policy;
				}
			}
					
			if (chosenPolicy == null){
				throw ExceptionHelper.createNewCoreException("Error: Decision string \""+decisionString+"\" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			schedChoice.setChosenValue(chosenPolicy);
			choice = schedChoice;
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
			return null;
		}
		choice.setDegreeOfFreedomInstance(designDecision);
		return choice;
	}

	private static boolean validRange(double value, RangeDegree designDecision, double from,
			double to) {
		return (value >= from && value <= to);
	}

	private static Entity getEntityFor(ClassDegree designDecision,
			String decisionString) {
		List<Entity> entities = new ArrayList<Entity>();
		for (EObject entity : designDecision.getClassDesignOptions()) {
			if (entity instanceof Entity){
				entities.add((Entity) entity);
			}
		}
		return getEntityByName(entities, decisionString);
	}

	private static Entity getEntityByName(List<Entity> entities,
			String decisionString) {
		for (Entity entity : entities) {
			if (entity.getEntityName().equals(decisionString)){
				return entity;
			}
		}
		return null;
	}
	
	/**
	 * Edits the passed genotype by inserting the passed choice at the index 
	 * for the passed {@link DegreeOfFreedomInstance}. 
	 * @param genotype
	 * @param degree
	 * @param choice
	 */
	public static void applyChangeToGenotype(DesignDecisionGenotype genotype, DegreeOfFreedomInstance degree, Choice choice){
		int index = Opt4JStarter.getProblem().getDesignDecisions().indexOf(degree);
		genotype.set(index, choice);
	}

}
