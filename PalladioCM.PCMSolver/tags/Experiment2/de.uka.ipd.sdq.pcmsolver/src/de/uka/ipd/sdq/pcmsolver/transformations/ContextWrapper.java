package de.uka.ipd.sdq.pcmsolver.transformations;

import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class ContextWrapper {

	AssemblyContext assCtx;
	AllocationContext allCtx;
	UsageContext usgCtx;
	PCMInstance pcmInstance;
	
	
	public ContextWrapper(EntryLevelSystemCall elsa, 
						  PCMInstance pcmInstance){
		this.pcmInstance = pcmInstance;
	}
	
	private ContextWrapper(AssemblyContext assCtx,
						  AllocationContext allCtx,
						  UsageContext usgCtx,
						  PCMInstance pcmInstance){
		this.assCtx = assCtx;
		this.allCtx = allCtx;
		this.usgCtx = usgCtx;
		this.pcmInstance = pcmInstance;
	}


	public double getBranchProbability(AbstractBranchTransition abt){
		return 0.0;
	}
	
	public IProbabilityMassFunction getLoopIterations(AbstractLoopAction ala){
		return null;
	}
	
	public IProbabilityDensityFunction getTimeConsumption(ParametricResourceDemand prd){
		return null;
	}
	
	public IProbabilityDensityFunction getDelayOnLinkingResource(ExternalCallAction eca, CommunicationLinkResourceSpecification clrs){
		return null;
	}
	
	public ContextWrapper getContextWrapperFor(ExternalCallAction eca){
		return this;
	}

	public ContextWrapper getContextWrapperFor(EntryLevelSystemCall elsa){
		return this;
	}
	
	public ProcessingResourceSpecification getConcreteProcessingResource(ParametricResourceDemand prd){
		return null;
	}

	public PassiveResourceSpecification getConcretePassiveResource(AquireAction aa){
		return null;
	}
	
	public PassiveResourceSpecification getConcretePassiveResource(ReleaseAction ra){
		return null;
	}
	
	public CommunicationLinkResourceSpecification getConcreteLinkingResource(ExternalCallAction eca){
		return null;
	}
	
	public AssemblyContext getAssCtx() {
		return assCtx;
	}


	public void setAssCtx(AssemblyContext assCtx) {
		this.assCtx = assCtx;
	}


	public AllocationContext getAllCtx() {
		return allCtx;
	}


	public void setAllCtx(AllocationContext allCtx) {
		this.allCtx = allCtx;
	}


	public UsageContext getUsgCtx() {
		return usgCtx;
	}


	public void setUsgCtx(UsageContext usgCtx) {
		this.usgCtx = usgCtx;
	}


	public PCMInstance getPcmInstance() {
		return pcmInstance;
	}


	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}
	
}
