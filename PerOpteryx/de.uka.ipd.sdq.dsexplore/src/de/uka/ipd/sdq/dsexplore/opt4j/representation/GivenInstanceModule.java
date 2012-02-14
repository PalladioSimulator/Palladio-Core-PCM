package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.Genotype;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.operator.copy.Copy;

import com.google.inject.TypeLiteral;

import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.PredefinedInstanceEvaluator;

public class GivenInstanceModule extends OptimizerModule {

	@Override
	protected void config() {
		bindOptimizer(PredefinedInstanceEvaluator.class);
		
		bind(IndividualFactory.class).to(DSEIndividualFactory.class);
		
		bind(new TypeLiteral<Copy<Genotype>>() {}).to((Class<? extends Copy<Genotype>>) CopyDesignDecisionGenotype.class);
				
	}

}
