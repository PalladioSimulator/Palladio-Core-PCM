package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.internal.runtime.ResourceTranslator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.genotype.DoubleGenotype;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
//import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.cost.util.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * The {@link DSEDecoder} is responsible for converting the genotypes into 
 * proper PCM instances that can then be analysed.
 *  
 * @author Anne
 *
 */
public class DSEDecoder implements Decoder<DoubleGenotype, PCMPhenotype> {
	
	/* TODO: Move this to some other class, e.g. a configuration class */
	private DecimalFormat format = new DecimalFormat("0.#######");
	
	//private final DSEProblem problem;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	@Inject
	public DSEDecoder(){
		//XXX like this you can only set the problem once. Maybe don't save the reference. 
		//this.problem = Opt4JStarter.problem;
	}

	@Override
	public PCMPhenotype decode(DoubleGenotype genotype) {
		
		//copy PCM Instance
		PCMInstance pcm = Opt4JStarter.problem.getInitialInstance();

		
		int index = 0;
		//adjust values as in genotype
		for (Double doubleGene : genotype) {
			//Check first if value is NaN or infinite. If it is, use the value from the initialGenotype (thats maybe the last one as it changes?)
			
			if (doubleGene.isNaN() || doubleGene.isInfinite()){
				Double oldGene = Opt4JStarter.problem.getInitialGenotypeList().get(0).get(index);
				logger.warn("A double gene was not applicable for instance "+pcm.getName()+" : "+doubleGene.toString()+". Setting it to the older value "+oldGene.toString());
				doubleGene = oldGene;
				genotype.set(index, oldGene);
			}
			applyChange(Opt4JStarter.problem.getDesignDecision(index), doubleGene);

			index++;
		}
		
		//encapsulate as phenotype 
		return new PCMPhenotype(pcm.deepCopy());
	}

	/**
	 * Applies the given change to the initial pcm instance (as this is 
	 * referenced by the design decisions. More precisely, this one calls 
	 * calls specialized methods for dealing with different types of design 
	 * decisions.  
	 * 
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene The new value the design decision should take. 
	 */
	private void applyChange(DegreeOfFreedom designDecision, Double doubleGene) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDegree.class.isInstance(designDecision)){
			this.applyChangeProcessingRateDecision((ProcessingRateDegree)designDecision, doubleGene);
		} else if (AssembledComponentDegree.class.isInstance(designDecision)){
			this.applyChangeAssembledComponentDecision((AssembledComponentDegree)designDecision, doubleGene);
		} else if (AllocationDegree.class.isInstance(designDecision)){
			this.applyChangeAllocationDecision((AllocationDegree)designDecision, doubleGene);
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
	}
	
	private void applyChangeAllocationDecision(
			AllocationDegree designDecision, Double doubleGene) {
		int gene = doubleGene.intValue();
		
		ResourceContainer rc = (ResourceContainer)designDecision.getDomainOfEntities().get(gene);
		
		((AllocationContext)designDecision.getChangeableEntity()).setResourceContainer_AllocationContext(rc);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting resource container to "+rc.getEntityName()+ " for allocation context "+designDecision.getChangeableEntity().getEntityName());
		
	}

	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene
	 */
	private void applyChangeProcessingRateDecision (ProcessingRateDegree designDecision, Double doubleGene) {
		//XXX The value is changed in the original model, not in a copy. 

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
		
		//old spec for adjusting MTTF
		String oldRateString = rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification();
		double oldRate = CostUtil.getDoubleFromSpecification(oldRateString);
		
		double oldMTTF = rightPrs.getMTTF();
		
		//FIXME: This will introduce rounding errors sooner or later
		double mttf = oldMTTF * doubleGene.doubleValue() / oldRate;
		
		//round to just four digits after decimal sign, to maybe have no errors by the above 
		//long l = (int)Math.round(mttf * 100000000); // truncates  
		//mttf = l / 100000000.0;  
		
		rightPrs.getProcessingRate_ProcessingResourceSpecification().setSpecification(doubleGene.toString());
		rightPrs.setMTTF(mttf);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+doubleGene.toString()+" and MTTF to "+mttf+" (old rate: "+oldMTTF+")");
	}
	
	private void applyChangeAssembledComponentDecision ( AssembledComponentDegree designDecision, Double doubleGene) {
		//get component by rounding down
		int gene = doubleGene.intValue();
		
		//use the order of the enumeration of EquivalentComponents in the Domain
		RepositoryComponent componentToBeAssembled = (RepositoryComponent)designDecision.getDomainOfEntities().get(gene);
		
		AssemblyContext changedAssemblyContext = (AssemblyContext)designDecision.getChangeableEntity();
		RepositoryComponent currentComponent = changedAssemblyContext.getEncapsulatedComponent_AssemblyContext();
		
		//Do not replace component if it is already assembled.  
		if (!EMFHelper.checkIdentity(currentComponent, componentToBeAssembled)){
			AlternativeComponent.getInstance().applyChange(changedAssemblyContext, componentToBeAssembled);
		}
		
		
		logger.debug("Handling a "+designDecision.getClass()+", using component "+componentToBeAssembled.getEntityName());
	}
	
	public static String getDecisionString(int index, double gene){
		DegreeOfFreedom designDecision = Opt4JStarter.problem.getDesignDecision(index);
		String result = getDecisionString(gene, designDecision);
		return result;
	}

	private static String getDecisionString(double gene, DegreeOfFreedom designDecision) {
		String result = "";
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDegree.class.isInstance(designDecision)){
			result = new ResultsWriter().formatDouble(gene);
		} else if (EnumerationDegree.class.isInstance(designDecision)){
			int intgene = (int)gene;		
			result = ((EnumerationDegree)designDecision).getDomainOfEntities().get(intgene).getEntityName();
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
	 */
	public static double getDoubleValueFor(int index, String decisionString){
		
		DegreeOfFreedom designDecision = Opt4JStarter.problem.getDesignDecision(index); 
		
		double value = getDoubleValueFor(decisionString, designDecision);
		
		return value;
		
}

	public static double getDoubleValueFor(String decisionString,
			DegreeOfFreedom designDecision) {
		double value = 0.0;
		try {
			value = Double.parseDouble(decisionString);
			
		} catch (NumberFormatException e){
			//No Double, obviously..
			if (EnumerationDegree.class.isInstance(designDecision)){
				value = getDoubleValueFor((EnumerationDegree)designDecision, decisionString);
			} /*else if (AllocationDegree.class.isInstance(designDecision)){
				value = getDoubleValueFor((AllocationDecision)designDecision, decisionString);
			}*/ else {
				logger.warn("There was an unrecognised design decision "+designDecision.getClass());
			}
		}
		return value;
	}

	private static double getDoubleValueFor(EnumerationDegree designDecision,
			String decisionString) {
		List<Entity> entities = new ArrayList<Entity>();
		entities.addAll(designDecision.getDomainOfEntities());
		return getEntityPositionByName(entities, decisionString);
	}

	private static double getEntityPositionByName(List<Entity> entities,
			String decisionString) {
		for (Entity entity : entities) {
			if (entity.getEntityName().equals(decisionString)){
				return entities.indexOf(entity);
			}
		}
		return Double.NaN;
	}
}
