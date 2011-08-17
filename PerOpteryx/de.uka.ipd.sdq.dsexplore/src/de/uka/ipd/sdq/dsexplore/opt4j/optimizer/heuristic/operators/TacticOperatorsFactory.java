package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ConcurrentProcessingSystemImplCatia;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.DecreaseProcessingRateImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.IncreaseProcessingRateImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ReallocationImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ServerConsolidationImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ServerExpansionImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;

public class TacticOperatorsFactory {
	
	/**
	 * Returns a collection of all actived heuristics.
	 */
	public static Collection<ITactic> getActivatedInstances(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		
		Collection<ITactic> activatedHeuristics = new ArrayList<ITactic>();
		if (configuration.getUseReallocation()) {
			activatedHeuristics.add(new ReallocationImpl(copy, individualBuilder, configuration));
		}
		if (configuration.getUseProcessingRate()) {
			activatedHeuristics.add(new IncreaseProcessingRateImpl(copy, individualBuilder, configuration));
			activatedHeuristics.add(new DecreaseProcessingRateImpl(copy, individualBuilder, configuration));
		}
		if (configuration.getUseServerConsolidation()) {
			activatedHeuristics.add(new ServerConsolidationImpl(copy, individualBuilder, configuration));
		}
		if (configuration.getUseServerExpansion()) {
			activatedHeuristics.add(new ServerExpansionImpl(copy, individualBuilder, configuration));
		}
		if (configuration.getUseAntipatternKnowledge()) {
			activatedHeuristics.add(new ConcurrentProcessingSystemImplCatia(copy, individualBuilder, configuration));
		}
		
		//activatedHeuristics.add(new ConcurrentProcessingSystemImpl(copy, individualBuilder, configuration));
		//activatedHeuristics.add(new ConcurrentProcessingSystemImplCatia(copy, individualBuilder, configuration));
		return activatedHeuristics;
	}

}
