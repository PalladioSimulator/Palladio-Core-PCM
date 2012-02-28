package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.core.Archive;
import org.opt4j.core.Criterion;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.IntegerValue;
import org.opt4j.core.Population;
import org.opt4j.core.Value;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import edu.kit.ipd.descartes.reconfiguration.opt4j.optimizer.TacticsManager;

public class StaReconfigurator extends AbstractOptimizer {

	private static final double TARGET_RESP_TIME = 5.0;
	private static final double RESP_TIME_DELTA = 0.1;
	private List<Double> prevRespTimes = new ArrayList<Double>();
	private boolean strategyTargetAchieved = false;
	TacticsManager staManager;
	private int iteration = 0;

	/** Logger for log4j. */
	private static Logger logger = Logger
			.getLogger(StaReconfigurator.class);

	@Inject
	public StaReconfigurator(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control, Copy<Genotype> copy) {
		super(population, archive, individualBuilder, completer, control);
		staManager = new TacticsManager(copy,
				(DSEIndividualBuilder) individualBuilder);
	}

	@Override
	public void optimize() throws StopException, TerminationException {

		logger.info("Starting reconfiguration using Strategy/Tactics/Action approach");
		DSEIndividual currentCandidate = null;

		staManager.setActiveTacticNumber(TacticsManager.INCREASE_CPU);

		Individual ind = individualBuilder.build();
		this.population.add(ind);
		nextIteration();
		evaluateCurrentPopulation();

		while (!isStrategyTargetAchieved() && iteration <= 10) {

			List<Individual> nextGeneration = new LinkedList<Individual>();
			
			for (Individual individual : this.population) {
				if (individual instanceof DSEIndividual) {
					currentCandidate = (DSEIndividual) individual;
					// 1. Apply a tactic. Tactic is chosen according to the
					// weights. Applying a tactic returns a new "candidate".
					List<TacticsResultCandidate> candidateResults = staManager
							.applyTactic(currentCandidate);
					nextGeneration.addAll(candidateResults);
				} else {
					throw new RuntimeException(
							"Encountered a non-DSEIndividual in rule based search that I cannot handle. Aborting.");
				}

			}

			int nextGenerationSize = nextGeneration.size();
			// If population is zero but we have tactics left
			if (nextGenerationSize == 0)
			{
				staManager.setActiveTacticNumber(TacticsManager.MIGRATE_COMPONENT);
				continue;
			}
			nextGeneration.removeAll(population);
			nextGeneration.removeAll(archive);
			logger
					.info("Removed "
							+ (nextGeneration.size() - nextGenerationSize)
							+ " duplicate candidate (that were in the previous population or in the archive).");

			completer.complete(nextGeneration);

			
			this.population.clear();
			this.population.addAll(nextGeneration);

			// 2. Evaluate new candidate according to the target of the strategy
			nextIteration();
			evaluateCurrentPopulation();
			
			
			if (this.population.size() == 0) {
				 logger.warn("No more individuals in population, aborting after iteration "+iteration);
				 break;
			}
		}

		// teardown

		ResultsWriter writer = new ResultsWriter(Opt4JStarter
				.getDSEWorkflowConfig().getResultFolder()
				+ "rule-based search results");
		for (Individual individual : this.archive) {
			if (individual instanceof DSEIndividual) {
				DSEIndividual dseIndiv = (DSEIndividual) individual;
				writer.writeIndividual(dseIndiv);
			} else {
				logger
						.error("Encountered a non DSE-Individual in the rule based search, aborting to write results.");
			}
		}
		writer.flush();
	}

	private void evaluateCurrentPopulation() {
		DSEIndividual currentCandidate;
		assert this.population.size() == 1;
		for (Individual individual : this.population) {
			if (individual instanceof DSEIndividual) {
				currentCandidate = (DSEIndividual) individual;
				evaluateCandidate(currentCandidate);
			}
		}
	}

	private boolean isStrategyTargetAchieved() {
		return strategyTargetAchieved;
	}
	
	private void evaluateCandidate(DSEIndividual currentCandidate)
	{
		double respTime = getResponseTime(currentCandidate);
		strategyTargetAchieved = respTime < TARGET_RESP_TIME;

		prevRespTimes.add(respTime);
		logger.info("Current candidate response time " + respTime);
		double respTimeImprovement = calcRespTimeImprovement();
		
		if(Double.isNaN(respTimeImprovement)){
			// Stick to the current tactic
			staManager.setActiveTacticNumber(staManager.getActiveTactic());
		} else if (respTimeImprovement > RESP_TIME_DELTA) {
			// Stick to the current tactic
			staManager.setActiveTacticNumber(staManager.getActiveTactic());
		} else {
			// switch tactic
			staManager.setActiveTacticNumber(TacticsManager.INCREASE_CPU);
		}
	}

	private double calcRespTimeImprovement() {
		int lastEntry = prevRespTimes.size();
		if (lastEntry == 0 || lastEntry == 1)
			return Double.NaN;
		else
			return prevRespTimes.get(lastEntry - 2) - prevRespTimes.get(lastEntry - 1);
	}

	private double getResponseTime(DSEIndividual currentCandidate) {

		DSEObjectives objs = currentCandidate.getObjectives();
		List<Criterion> criteriaToSave = ResultsWriter
				.determineCriterionsToSave(currentCandidate);
		return formatValue(objs.getValueForCriterion(criteriaToSave.get(1)));

	}

	private static double formatValue(Value<?> value) {

		if (value instanceof IntegerValue) {
			IntegerValue intValue = (IntegerValue) value;
			return intValue.getDouble();

		} else {
			double d = value.getDouble();
			return d;
		}

	}

}
