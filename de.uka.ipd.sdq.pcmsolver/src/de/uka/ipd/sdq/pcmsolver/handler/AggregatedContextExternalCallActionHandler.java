package de.uka.ipd.sdq.pcmsolver.handler;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.AggregatedContextSEFFVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

/**
 * Extends the {@link ExternalCallActionHandler} by overwriting {@link ExternalCallActionHandler#visitSEFF(ServiceEffectSpecification, ContextWrapper)}.
 * Creates a new {@link AggregatedContextSEFFVisitor} instead of a normal {@link SeffVisitor}.
 * @author martens
 *
 */
public class AggregatedContextExternalCallActionHandler extends
		ExternalCallActionHandler {

	private double frequency;
	private UsageScenario usageScenario;
	private ServiceEffectSpecification calledSEFF;
	private AssemblyContext calledAssemblyCtxt;
	private AllocationContext calledAllocationContext;

	public AggregatedContextExternalCallActionHandler(AggregatedContextSEFFVisitor seffVisitor, UsageScenario usageScenario) {
		super(seffVisitor);
		this.frequency = seffVisitor.getCurrentFrequency();
		this.usageScenario = usageScenario;
	}

	/**
	 * Creates a new {@link AggregatedContextSEFFVisitor} instead of a normal {@link SeffVisitor}, which adds the calculation 
	 * of execution frequencies to the context model. 
	 */
	@Override
	SeffVisitor visitSEFF(ServiceEffectSpecification seff,
			ContextWrapper contextWrapper) {
		AggregatedContextSEFFVisitor seffVisitor = new AggregatedContextSEFFVisitor(contextWrapper, this.frequency, seff, this.usageScenario);
		
		this.calledSEFF = seff;
		this.calledAssemblyCtxt = contextWrapper.getAssCtx();
		this.calledAllocationContext = contextWrapper.getAllCtx();
		
		seffVisitor.doSwitch(seff);
		return seffVisitor;
	}
	
	
	public ServiceEffectSpecification getCalledSEFF() {
		return calledSEFF;
	}

	public AssemblyContext getCalledAssemblyCtxt() {
		return calledAssemblyCtxt;
	}	

	public AllocationContext getCalledAllocationContext() {
		return calledAllocationContext;
	}
}
