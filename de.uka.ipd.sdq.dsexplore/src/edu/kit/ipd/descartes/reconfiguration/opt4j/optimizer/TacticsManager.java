package edu.kit.ipd.descartes.reconfiguration.opt4j.optimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.optimizer.TacticsManager");
	
	public static final int INCREASE_CPU = 1;
	public static final int MIGRATE_COMPONENT = 2;

	
	protected ResultsWriter writer;
	protected ITactic increaseProcRate;
	protected ITactic relieveHighUtilizedServer;
	private int activeTactic = -1;
	
	public TacticsManager(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder) {
		this.writer = new ResultsWriter(Opt4JStarter.getDSEWorkflowConfig().getResultFolder()+"heuristicsInfo");
		
		increaseProcRate = new IncreaseProcessingRateImpl(copy, individualBuilder, Opt4JStarter.getDSEWorkflowConfig());
		relieveHighUtilizedServer = new ReallocationImpl(copy, individualBuilder, Opt4JStarter.getDSEWorkflowConfig());
	}
	
	/**
	 * Chooses the tactic from the set of tactics according to the weight
	 * @param currentCandidate 
	 * 
	 * @return {@link DSEIndividual} newIndividual
	 */
	public List<TacticsResultCandidate> applyTactic(DSEIndividual currentCandidate) {

		List<TacticsResultCandidate> resultList = null;
		
		switch (getActiveTacticNumber()) {
		case 1:
			logger.info("Applying INCREASE_PRCOCESSING_RATE_TACTIC");
			resultList = increaseProcessingRate(currentCandidate);
			break;
		case 2:
			logger.info("Applying RELIEVE_HIGH_UTILIZED_SERVER_TACTIC");
			resultList = relieveHighUtilizedServer(currentCandidate);
			break;
		default:
			break;
		}

		// FIXME: Remove this hard-coded access to the first element in the list 
		assert resultList.size() == 1;
		return resultList;
	}

	private List<TacticsResultCandidate> increaseProcessingRate(
			DSEIndividual currentCandidate) {

		//results cache for the current candidate. 
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper(); 
				List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;
		
		candidatesFromCurrentHeuristic = increaseProcRate.getHeuristicCandidates(currentCandidate, resultsCache);
		if (candidatesFromCurrentHeuristic.size() > 0) {
			this.writer.writeTacticCandidateInfo(increaseProcRate, candidatesFromCurrentHeuristic);
			result.addAll(candidatesFromCurrentHeuristic);
		}

		return result;		
	}
	
	private List<TacticsResultCandidate> relieveHighUtilizedServer(
			DSEIndividual currentCandidate) {
		
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper(); 
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;
		
		
		candidatesFromCurrentHeuristic = relieveHighUtilizedServer.getHeuristicCandidates(currentCandidate, resultsCache);
		if (candidatesFromCurrentHeuristic.size() > 0) {
			this.writer.writeTacticCandidateInfo(relieveHighUtilizedServer, candidatesFromCurrentHeuristic);
			result.addAll(candidatesFromCurrentHeuristic);
		}
		return result;
		
	}

	public void setActiveTacticNumber(int activeTactic) {
		this.activeTactic = activeTactic;
	}

	public int getActiveTacticNumber() {
		return activeTactic;
	}

}
