package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ConcurrentProcessingSystemImplCatia;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.DecreaseProcessingRateImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.IncreaseProcessingRateImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ReallocateForReduceLinkUsage;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ReallocationImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ServerConsolidationImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ServerExpansionImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;

public class TacticOperatorsFactory {
	
	/**
	 * Returns a collection of all actived heuristics.
	 */
	public static Collection<ITactic> getActivatedInstances(Copy<Genotype> copy, DSEIndividualFactory individualFactory, DSEWorkflowConfiguration configuration) {
		
		Collection<ITactic> activatedHeuristics = new ArrayList<ITactic>();
		if (configuration.getUseReallocation()) {
			activatedHeuristics.add(new ReallocationImpl(copy, individualFactory, configuration));
		}
		if (configuration.getUseProcessingRate()) {
			activatedHeuristics.add(new IncreaseProcessingRateImpl(copy, individualFactory, configuration));
			activatedHeuristics.add(new DecreaseProcessingRateImpl(copy, individualFactory, configuration));
		}
		if (configuration.getUseServerConsolidation()) {
			activatedHeuristics.add(new ServerConsolidationImpl(copy, individualFactory, configuration));
		}
		if (configuration.getUseServerExpansion()) {
			activatedHeuristics.add(new ServerExpansionImpl(copy, individualFactory, configuration));
		}
		
		if (configuration.getUseLinkReallocationTactic()){
			activatedHeuristics.add(new ReallocateForReduceLinkUsage(copy, individualFactory, configuration));
		}
		
		if (configuration.getUseAntipatternKnowledge()) {
			activatedHeuristics.add(new ConcurrentProcessingSystemImplCatia(copy, individualFactory, configuration));
		}
		return activatedHeuristics;
	}

}
