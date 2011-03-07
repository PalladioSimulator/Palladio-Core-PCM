package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.problem.Decoder;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
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
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.RangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
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
		
		int index = 0;
		//adjust values as in genotype
		for (Choice doubleGene : genotype) {
			
			applyChange(doubleGene.getDegreeOfFreedom(), doubleGene);

			index++;
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
	private void applyChange(DegreeOfFreedom designDecision, Choice choice) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ContinuousProcessingRateDegree.class.isInstance(designDecision)){
			this.applyChangeProcessingRateDecision((ContinuousProcessingRateDegree)designDecision, choice);
		} else if (AssembledComponentDegree.class.isInstance(designDecision)){
			this.applyChangeAssembledComponentDecision((AssembledComponentDegree)designDecision, choice);
		} else if (AllocationDegree.class.isInstance(designDecision)){
			this.applyChangeAllocationDecision((AllocationDegree)designDecision, choice);
		} else if (SchedulingPolicyDegree.class.isInstance(designDecision)){
			this.applyChangeSchedulingDecision((SchedulingPolicyDegree)designDecision, choice);
		} else if (CapacityDegree.class.isInstance(designDecision)){
			this.applyChangeCapacityDecision((CapacityDegree)designDecision, choice);
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
	}
	


	private void applyChangeCapacityDecision(CapacityDegree designDecision,
			Choice choice) {
		if (!(choice instanceof DiscreteRangeChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		
		DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice;
		
		PassiveResource passiveResource = (PassiveResource)designDecision.getChangeableEntity();
		passiveResource.getCapacity_PassiveResource().setSpecification(String.valueOf(discreteChoice.getChosenValue()));
		
	}

	private void applyChangeAllocationDecision(
			AllocationDegree designDecision, Choice choice) {
		
		if (!(choice instanceof EnumerationChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		EnumerationChoice enumChoice = (EnumerationChoice)choice;
		
		Entity entity = enumChoice.getEntity();
		if (!(entity instanceof ResourceContainer)){
			throwInvalidEntityException(designDecision,entity,ResourceContainer.class);
		}
				
		ResourceContainer rc = (ResourceContainer)entity;
		
		((AllocationContext)designDecision.getChangeableEntity()).setResourceContainer_AllocationContext(rc);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting resource container to "+rc.getEntityName()+ " for allocation context "+designDecision.getChangeableEntity().getEntityName());
		
	}
	
	private void applyChangeSchedulingDecision(
			SchedulingPolicyDegree designDecision, Choice choice) {
		if (!(choice instanceof SchedulingPolicyChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		
		SchedulingPolicyChoice schedChoice = (SchedulingPolicyChoice)choice;
		SchedulingPolicy chosenPolicy = schedChoice.getChosenValue();
		
		ProcessingResourceSpecification rightPrs = getProcessingRateSpecification(designDecision);
		
		rightPrs.setSchedulingPolicy(chosenPolicy);
		
	}

	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene
	 */
	private void applyChangeProcessingRateDecision (ContinuousProcessingRateDegree designDecision, Choice choice) {
		//XXX The value is changed in the original model, not in a copy. 

		if (!(choice instanceof ContinousRangeChoice)){
			throwNewInvalidChoiceException(designDecision,choice);
		}
		ContinousRangeChoice doubleGene = (ContinousRangeChoice)choice;
		
		ProcessingResourceSpecification rightPrs = getProcessingRateSpecification(designDecision);
		
		// get initial models MTTF and rate to scale upcoming candidates MTTF with
		if (Double.isNaN(this.initialRate)){
			//old spec for adjusting MTTF
			String oldRateString = rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification();
			this.initialRate = CostUtil.getDoubleFromSpecification(oldRateString);
		}
		if (Double.isNaN(this.initialMTTF)){
			this.initialMTTF = rightPrs.getMTTF();
		}
		
		double mttf = this.initialMTTF * doubleGene.getChosenValue() / this.initialRate;
		
		//round to just four digits after decimal sign, to maybe have no errors by the above 
		//long l = (int)Math.round(mttf * 100000000); // truncates  
		//mttf = l / 100000000.0;  
		
		rightPrs.getProcessingRate_ProcessingResourceSpecification().setSpecification(String.valueOf(doubleGene.getChosenValue()));
		rightPrs.setMTTF(mttf);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+doubleGene.getChosenValue()+" and MTTF to "+mttf+" (inital MTTF: "+this.initialMTTF+")");
	}

	private ProcessingResourceSpecification getProcessingRateSpecification(
			ProcessingResourceDegree designDecision) {
		ResourceContainer rc = ((ResourceContainer)designDecision.getChangeableEntity());
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
			DegreeOfFreedom designDecision, Choice choice) {
		throw new InvalidChoiceForDegreeException(choice);
		
	}

	private void applyChangeAssembledComponentDecision ( AssembledComponentDegree designDecision, Choice choice) {
		
		if (!(choice instanceof EnumerationChoice)){
			throwNewInvalidChoiceException(designDecision, choice);
		}
		EnumerationChoice enumChoice = (EnumerationChoice)choice;
		
		//use the order of the enumeration of EquivalentComponents in the Domain
		Entity entity = enumChoice.getEntity();
		if (!(entity instanceof RepositoryComponent)){
			throwInvalidEntityException(designDecision,entity,RepositoryComponent.class);
		}
		RepositoryComponent componentToBeAssembled = (RepositoryComponent)entity;
		
		AssemblyContext changedAssemblyContext = (AssemblyContext)designDecision.getChangeableEntity();
		RepositoryComponent currentComponent = changedAssemblyContext.getEncapsulatedComponent_AssemblyContext();
		
		//Do not replace component if it is already assembled.  
		if (!EMFHelper.checkIdentity(currentComponent, componentToBeAssembled)){
			AlternativeComponent.getInstance().applyChange(changedAssemblyContext, componentToBeAssembled);
		}
		
		
		logger.debug("Handling a "+designDecision.getClass()+", using component "+componentToBeAssembled.getEntityName());
	}
	
	@SuppressWarnings("unchecked")
	private void throwInvalidEntityException(
			DegreeOfFreedom designDecision, Entity entity,
			Class clazz) {
		throw new RuntimeException("Entity "+entity.getEntityName()+" of type "+entity.getClass().getName()+" is not an applicable value for degree of freedom "+designDecision.getClass().getName()+", required type is "+clazz.getName());
		
	}

	public static String getGenotypeString(DesignDecisionGenotype genotype) {
		StringBuilder genotypeStringBuilder = new StringBuilder(100);
		for (Choice choice : genotype) {
			genotypeStringBuilder.append(DSEDecoder.getDecisionString(choice)+";");
		}
		return genotypeStringBuilder.toString();
	}
	
	public static String getDecisionString(Choice choice){
		DegreeOfFreedom designDecision = choice.getDegreeOfFreedom();
		
		String result = "";
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (choice instanceof ContinousRangeChoice){
			result = ResultsWriter.formatDouble(((ContinousRangeChoice) choice).getChosenValue());
		} else if (choice instanceof EnumerationChoice){
			result = ((EnumerationChoice)choice).getEntity().getEntityName();
		} else if (choice instanceof DiscreteRangeChoice){
			result = String.valueOf(((DiscreteRangeChoice)choice).getChosenValue());
		} else if (choice instanceof SchedulingPolicyChoice){
			result = ((SchedulingPolicyChoice)choice).getChosenValue().getLiteral();
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
		
		DegreeOfFreedom designDecision = Opt4JStarter.getProblem().getDesignDecision(index); 
		
		Choice value = getChoiceFor(decisionString, designDecision);
		
		return value;
		
}

	public static Choice getChoiceFor(String decisionString,
			DegreeOfFreedom designDecision) throws CoreException {
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
		} else if (designDecision instanceof EnumerationDegree){
			
			EnumerationChoice enumChoice = factory.createEnumerationChoice();
			Entity entity = getEntityFor((EnumerationDegree)designDecision, decisionString);
			if (entity == null){
				throw ExceptionHelper.createNewCoreException("Error: Decision string \""+decisionString+"\" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			enumChoice.setEntity(entity);
			choice = enumChoice;
		} else if (designDecision instanceof SchedulingPolicyDegree){
			
			SchedulingPolicyChoice schedChoice = factory.createSchedulingPolicyChoice();
			
			SchedulingPolicy chosenPolicy = SchedulingPolicy.get(decisionString);
			
			if (chosenPolicy == null){
				throw ExceptionHelper.createNewCoreException("Error: Decision string \""+decisionString+"\" is not a valid value for degree "+designDecision+" "+DegreeOfFreedomHelper.getDegreeDescription(designDecision));
			}
			schedChoice.setChosenValue(chosenPolicy);
			choice = schedChoice;
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
			return null;
		}
		choice.setDegreeOfFreedom(designDecision);
		return choice;
	}

	private static boolean validRange(double value, RangeDegree designDecision, double from,
			double to) {
		return (value >= from && value <= to);
	}

	private static Entity getEntityFor(EnumerationDegree designDecision,
			String decisionString) {
		List<Entity> entities = new ArrayList<Entity>();
		entities.addAll(designDecision.getDomainOfEntities());
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
	 * for the passed {@link DegreeOfFreedom}. 
	 * @param genotype
	 * @param degree
	 * @param choice
	 */
	public static void applyChangeToGenotype(DesignDecisionGenotype genotype, DegreeOfFreedom degree, Choice choice){
		int index = Opt4JStarter.getProblem().getDesignDecisions().indexOf(degree);
		genotype.set(index, choice);
	}

}
