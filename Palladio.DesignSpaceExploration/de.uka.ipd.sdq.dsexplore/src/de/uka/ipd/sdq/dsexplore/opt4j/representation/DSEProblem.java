package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import java.util.List;

import org.opt4j.genotype.Bounds;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.cost.util.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.DoubleRange;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * The {@link DSEProblem} defines the problem. Therefore, it reads in the 
 * current PCM instances and identifies the available design options to define 
 * the design space. 
 * 
 * @author Anne
 *
 */
public class DSEProblem {
	
	private DimensionBounds bounds;
	private PCMInstance initialInstance;
	
	private Problem pcmProblem;
	private designdecisionFactory designDecisionFactory;
	
	/**
	 * @param initialInstance
	 */
	@Inject
	public DSEProblem(PCMInstance initialInstance){
		this.initialInstance = initialInstance;
		
		this.designDecisionFactory = designdecisionFactoryImpl.init();
		
		this.pcmProblem = this.designDecisionFactory.createProblem();
		
		//analyse PCM Instance and create design decisions
		//TODO: could this be possible with a M2M transformation? 
		//First, only get design decisions for making resources faster. 
		List<ResourceContainer> resourceContainers = this.initialInstance.getAllResourceContainers();
		for (ResourceContainer resourceContainer : resourceContainers) {
			List<ProcessingResourceSpecification> resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification resource : resources) {
				ProcessingRateDecision decision = this.designDecisionFactory.createProcessingRateDecision();
				DoubleRange range = this.designDecisionFactory.createDoubleRange();
				range.setFrom(0);
				double currentRate = CostUtil.getDoubleFromSpecification(resource.getProcessingRate_ProcessingResourceSpecification().getSpecification());
				//XXX initial assumption: the highest possible processingRate is 10 times the current one.
				range.setTo(currentRate * 10.0);
				decision.setDomain(range);
				this.pcmProblem.getDesigndecision().add(decision);
			}
		}
		
		this.bounds = new DimensionBounds(this.pcmProblem);

		//TODO: mapping of design decisions to bounds. 
		/*
		 * Meta model design decisions?? Each design decision would know its
		 * bounds and the annotated element or more specific the annotated
		 * property of this element that is exactly the value range than the
		 * bound of the decision. 
		 * 
		 * But what about the genotype? With a ordered list
		 * of design decisions, I can map the genotype entry to a design
		 * decisions. Better group in integer and double, then. -> require CompositeGenotype
		 * 
		 * Also meta-model the genotype as a choice within the range.
		 */		
	}


	public int getNumberOfDimensions(){
		return bounds.numberOfDimensions();
	}
	
	public DimensionBounds getBounds(){
		return this.bounds;
	}


	protected PCMInstance deepCopyPCMInstance() {
		return this.initialInstance.deepCopy();
	}
	
	protected DesignDecision getDesignDecision(int index){
		return this.pcmProblem.getDesigndecision().get(index);
	}
	
}
