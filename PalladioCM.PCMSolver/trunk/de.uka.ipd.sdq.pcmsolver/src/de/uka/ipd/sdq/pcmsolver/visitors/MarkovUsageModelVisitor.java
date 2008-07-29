package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class MarkovUsageModelVisitor extends UsagemodelSwitch {
	
	private static Logger logger = Logger.getLogger(UsageModelVisitor.class
			.getName());

	private PCMInstance pcmInstance;
	
	/**
	 * @param inst
	 *            an instance of the Palladio Component Metamodel
	 */
	public MarkovUsageModelVisitor(PCMInstance inst) {
		pcmInstance = inst;
	}

}
