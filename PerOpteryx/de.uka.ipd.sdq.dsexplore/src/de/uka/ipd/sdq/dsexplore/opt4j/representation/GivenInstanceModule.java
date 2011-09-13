package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.operator.copy.CopyModule;

import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.PredefinedInstanceEvaluator;

public class GivenInstanceModule extends OptimizerModule {

	@Override
	protected void config() {
		bindOptimizer(PredefinedInstanceEvaluator.class);
		
		bind(IndividualBuilder.class).to(DSEIndividualBuilder.class);
		
		CopyModule.addCopy(binder(), CopyDesignDecisionGenotype.class);
		
	}

}
