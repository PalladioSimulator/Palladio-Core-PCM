package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Decoder;
import org.opt4j.genotype.DoubleGenotype;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.cost.util.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDecision;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * The {@link DSEDecoder} is responsible for converting the genotypes into 
 * proper PCM instances that can then be analysed.
 *  
 * @author Anne
 *
 */
public class DSEDecoder implements Decoder<DoubleGenotype, PCMPhenotype> {
	
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
	private void applyChange(DesignDecision designDecision, Double doubleGene) {
		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDecision.class.isInstance(designDecision)){
			this.applyChangeProcessingRateDecision((ProcessingRateDecision)designDecision, doubleGene);
		} else if (AssembledComponentDecision.class.isInstance(designDecision)){
			this.applyChangeAssembledComponentDecision((AssembledComponentDecision)designDecision, doubleGene);
		} else if (AllocationDecision.class.isInstance(designDecision)){
			this.applyChangeAllocationDecision((AllocationDecision)designDecision, doubleGene);
		} else {
			logger.warn("There was an unrecognised design decision "+designDecision.getClass());
		}
	}
	
	private void applyChangeAllocationDecision(
			AllocationDecision designDecision, Double doubleGene) {
		int gene = doubleGene.intValue();
		
		ResourceContainer rc = ((AvailableServers)designDecision.getDomain()).getResourcecontainer().get(gene);
		
		designDecision.getAllocationcontext().setResourceContainer_AllocationContext(rc);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting resource container to "+rc.getEntityName()+ " for allocation context "+designDecision.getAllocationcontext().getEntityName());
		
	}

	/**
	 * @see applyChange(DesignDecision, PCMInstance, Double)
	 * @param designDecision
	 * @param pcm
	 * @param doubleGene
	 */
	private void applyChangeProcessingRateDecision (ProcessingRateDecision designDecision, Double doubleGene) {
		//XXX The value is changed in the original model, not in a copy. 

		//old spec for adjusting MTTF
		String oldRateString = designDecision.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().getSpecification();
		double oldRate = CostUtil.getDoubleFromSpecification(oldRateString);
		
		double oldMTTF = designDecision.getProcessingresourcespecification().getMTTF();
		
		//FIXME: This will introduce rounding errors sooner or later
		double mttf = oldMTTF * doubleGene.doubleValue() / oldRate;
		
		//round to just four digits after decimal sign, to maybe have no errors by the above 
		//long l = (int)Math.round(mttf * 100000000); // truncates  
		//mttf = l / 100000000.0;  
		
		designDecision.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().setSpecification(doubleGene.toString());
		designDecision.getProcessingresourcespecification().setMTTF(mttf);
		
		logger.debug("Handling a "+designDecision.getClass()+", setting rate to "+doubleGene.toString()+" and MTTF to "+mttf+" (old rate: "+oldMTTF+")");
	}
	
	private void applyChangeAssembledComponentDecision ( AssembledComponentDecision designDecision, Double doubleGene) {
		//get component by rounding down
		int gene = doubleGene.intValue();
		
		//use the order of the enumeration of EquivalentComponents in the Domain
		RepositoryComponent componentToBeAssembled = ((EquivalentComponents)designDecision.getDomain()).getRepositorycomponent().get(gene);
		
		AssemblyContext changedAssemblyContext = designDecision.getAssemblycontext();
		RepositoryComponent currentComponent = changedAssemblyContext.getEncapsulatedComponent_AssemblyContext();
		
		//Do not replace component if it is already assembled.  
		if (!EMFHelper.checkIdentity(currentComponent, componentToBeAssembled)){
			AlternativeComponent.getInstance().applyChange(changedAssemblyContext, componentToBeAssembled);
		}
		
		
		logger.debug("Handling a "+designDecision.getClass()+", using component "+componentToBeAssembled.getEntityName());
	}
	
	public static String getDecisionString(int index, double gene){
		DesignDecision designDecision = Opt4JStarter.problem.getDesignDecision(index);
		String result = getDecisionString(gene, designDecision);
		return result;
	}

	private static String getDecisionString(double gene, DesignDecision designDecision) {
		String result = "";
		int intgene = (int)gene;		
		/**
		 * TODO Make the selection of the appropriate applyChange method more implicit. Maybe move the method to DesignDecision itself.  
		 */
		if (ProcessingRateDecision.class.isInstance(designDecision)){
			result = String.valueOf(gene);
		} else if (AssembledComponentDecision.class.isInstance(designDecision)){
			result = ((EquivalentComponents)designDecision.getDomain()).getRepositorycomponent().get(intgene).getEntityName();
		} else if (AllocationDecision.class.isInstance(designDecision)){
			result = ((AvailableServers)designDecision.getDomain()).getResourcecontainer().get(intgene).getEntityName();
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
		
		DesignDecision designDecision = Opt4JStarter.problem.getDesignDecision(index); 
		
		double value = getDoubleValueFor(decisionString, designDecision);
		
		return value;
		
}

	public static double getDoubleValueFor(String decisionString,
			DesignDecision designDecision) {
		double value = 0.0;
		try {
			value = Double.parseDouble(decisionString);
			
		} catch (NumberFormatException e){
			//No Double, obviously..
			if (AssembledComponentDecision.class.isInstance(designDecision)){
				value = getDoubleValueFor((AssembledComponentDecision)designDecision, decisionString);
			} else if (AllocationDecision.class.isInstance(designDecision)){
				value = getDoubleValueFor((AllocationDecision)designDecision, decisionString);
			} else {
				logger.warn("There was an unrecognised design decision "+designDecision.getClass());
			}
		}
		return value;
	}

	private static double getDoubleValueFor(AllocationDecision designDecision,
			String decisionString) {
		List<ResourceContainer> range = ((AvailableServers)designDecision.getDomain()).getResourcecontainer();
		List<Entity> entities = new ArrayList<Entity>();
		entities.addAll(range);
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

	private static double getDoubleValueFor(AssembledComponentDecision designDecision,
			String decisionString) {
		List<RepositoryComponent> range = ((EquivalentComponents)designDecision.getDomain()).getRepositorycomponent();
		List<Entity> entities = new ArrayList<Entity>();
		entities.addAll(range);
		return getEntityPositionByName(entities, decisionString);
	}
	
	

}
