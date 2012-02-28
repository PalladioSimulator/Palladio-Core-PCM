package edu.kit.ipd.descartes.reconfiguration.opt4j.optimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.ITactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.IncreaseProcessingRateImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl.ReallocationImpl;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

public class TacticsManager {

	private static Logger logger = Logger
			.getLogger("edu.kit.ipd.descartes.reconfiguration.opt4j.optimizer.TacticsManager");

	public static final int INCREASE_CPU = 0;
	public static final int MIGRATE_COMPONENT = 1;
	public static final int LOOP_INCREASE_CPU = 2;

	protected ResultsWriter writer;
	protected ITactic increaseProcRate;
	protected ITactic relieveHighUtilizedServer;

	private int activeTactic = -1;
	private Set<Integer> unusedTactics;
	
	
	public TacticsManager(Copy<Genotype> copy,
			DSEIndividualBuilder individualBuilder) {
		this.writer = new ResultsWriter(Opt4JStarter.getDSEWorkflowConfig()
				.getResultFolder()
				+ "heuristicsInfo");

		increaseProcRate = new IncreaseProcessingRateImpl(copy,
				individualBuilder, Opt4JStarter.getDSEWorkflowConfig());
		relieveHighUtilizedServer = new ReallocationImpl(copy,
				individualBuilder, Opt4JStarter.getDSEWorkflowConfig());
		unusedTactics = new HashSet<Integer>();
		unusedTactics.add(INCREASE_CPU);
		unusedTactics.add(MIGRATE_COMPONENT);
		unusedTactics.add(LOOP_INCREASE_CPU);
	}

	/**
	 * Chooses the tactic from the set of tactics according to the weight
	 * 
	 * @param currentCandidate
	 * 
	 * @return {@link DSEIndividual} newIndividual
	 */
	public List<TacticsResultCandidate> applyTactic(
			DSEIndividual currentCandidate) {

		List<TacticsResultCandidate> resultList = null;

		switch (getActiveTactic()) {
		case TacticsManager.INCREASE_CPU:
			logger.info("Applying INCREASE_PRCOCESSING_RATE_TACTIC");
			resultList = increaseProcessingRate(currentCandidate);
			unusedTactics.remove(INCREASE_CPU);
			break;
		case TacticsManager.MIGRATE_COMPONENT:
			logger.info("Applying RELIEVE_HIGH_UTILIZED_SERVER_TACTIC");
			resultList = relieveHighUtilizedServer(currentCandidate);
			unusedTactics.remove(MIGRATE_COMPONENT);
			break;
		case TacticsManager.LOOP_INCREASE_CPU:
			logger.info("Applying LOOP_INCREASE_TACTIC");
			// FIXME Remove constant loop iteration number
			resultList = increaseProcessingRate(currentCandidate, 2);
			unusedTactics.remove(LOOP_INCREASE_CPU);
			break;
		default:
			break;
		}

		// FIXME: Remove this hard-coded access to the first element in the list
		assert resultList.size() == 1;
		return resultList;
	}

	private List<TacticsResultCandidate> increaseProcessingRate(
			DSEIndividual currentCandidate, int loopCount) {
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper();
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		List<TacticsResultCandidate> candidatesFromCurrentHeuristic = new ArrayList<TacticsResultCandidate>();

		for (int i = 0; i < loopCount;)
		{
			candidatesFromCurrentHeuristic = increaseProcRate
				.getHeuristicCandidates(currentCandidate, resultsCache);
			currentCandidate = candidatesFromCurrentHeuristic.get(0);
			i++;
		}
		
		if (candidatesFromCurrentHeuristic.size() > 0) {
			//TODO niko DO I have to change this, too?
			this.writer.writeTacticCandidateInfo(increaseProcRate,
					candidatesFromCurrentHeuristic);
			result.addAll(candidatesFromCurrentHeuristic);
		}

		return result;
		
	}

	private List<TacticsResultCandidate> increaseProcessingRate(
			DSEIndividual currentCandidate) {

		// results cache for the current candidate.
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper();
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;

		candidatesFromCurrentHeuristic = increaseProcRate
				.getHeuristicCandidates(currentCandidate, resultsCache);
		if (candidatesFromCurrentHeuristic.size() > 0) {
			this.writer.writeTacticCandidateInfo(increaseProcRate,
					candidatesFromCurrentHeuristic);
			result.addAll(candidatesFromCurrentHeuristic);
		}

		return result;
	}

	private List<TacticsResultCandidate> relieveHighUtilizedServer(
			DSEIndividual currentCandidate) {

		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper();
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;

		candidatesFromCurrentHeuristic = relieveHighUtilizedServer
				.getHeuristicCandidates(currentCandidate, resultsCache);
		if (candidatesFromCurrentHeuristic.size() > 0) {
			this.writer.writeTacticCandidateInfo(relieveHighUtilizedServer,
					candidatesFromCurrentHeuristic);
			result.addAll(candidatesFromCurrentHeuristic);
		}
		return result;

	}

	public void setActiveTacticNumber(int activeTactic) {
		this.activeTactic = activeTactic;
	}

	public int getActiveTactic() {
		return activeTactic;
	}

	/**
	 * Is there a tactic that has not been applied before? If yes, its number is
	 * returned, -1 otherwise.
	 * 
	 * @return -1 if all tactics have been used, else the number of the tactic
	 */
	public int unusedTactic() {
		if (unusedTactics.isEmpty())
			return -1;
		else
		{
			Iterator<Integer> it = unusedTactics.iterator();
			return it.next();
		}
	}

}
