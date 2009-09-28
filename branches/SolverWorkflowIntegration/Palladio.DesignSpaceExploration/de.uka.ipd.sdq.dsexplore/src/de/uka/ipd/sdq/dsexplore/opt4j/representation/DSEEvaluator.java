package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.problem.Evaluator;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * The Evaluator is responsible for determining the objective functions values 
 * for an individual based on the phenotype (i.e. the PCM instance). Thus, 
 * it calls the simulation or LQN solver for performance and also a cost 
 * evaluator. 
 * 
 * It is a singleton  
 * 
 * @author Anne
 * 
 */
public class DSEEvaluator implements Evaluator<PCMPhenotype>{
	
	protected final List<Objective> objectives = new ArrayList<Objective>();
	
	private List<Exception> exceptionList = new ArrayList<Exception>();
	
	private boolean firstRunSuccessful = false;

	private Map<Objective,DSEConstraint> constraints;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	public DSEEvaluator() {
		
		List <IAnalysis> evaluators = Opt4JStarter.evaluators;
		for (IAnalysis analysis : evaluators) {
			try {
			Objective quality = new Objective(analysis.getQualityAttribute(), Objective.Sign.MIN);
			this.objectives.add(quality);
			} catch (CoreException e){
				logger.error("Could not load quality attribute evaluator "+analysis.getClass());
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

/*		Objective cost = new Objective("cost", Objective.Sign.MIN);
		this.objectives.add(cost);*/
		
		this.constraints = new HashMap<Objective,DSEConstraint>();
		int i = 0;
		for (Value<Double> constraint : Opt4JStarter.upperConstraints) {
			//We only have upper constraints so far
			DSEConstraint c = new DSEConstraint(null, constraint,this.objectives.get(i));
			this.constraints.put(this.objectives.get(i),c);
			i++;
		}

		
	}
	
	public void reset(){
		this.firstRunSuccessful = false;
		this.exceptionList = new ArrayList<Exception>();
	}

	@Override
	public Objectives evaluate(PCMPhenotype pheno) {
		
		Objectives obj = new Objectives();
		try{
			
			for (int i = 0; i < objectives.size() ; i++) {
				retrieveQuality(pheno, obj, this.objectives.get(i), Opt4JStarter.evaluators.get(i));
			}

			//retrieveCost(pheno, obj, this.objectives.get(objectives.size() -1));
			
			firstRunSuccessful = true;

			return obj;
			
		} catch (UserCanceledException e){
			throw new RuntimeException("User cancelled.", e);
			
		} catch (Exception e){
			
			//If this is the first evaluation, then something severe seems to be wrong, throw an exception 
			if (!firstRunSuccessful){
				e.printStackTrace();
				throw new RuntimeException("An exception was raised at the beginning, I assume it makes no sense to continue. See stacktrace for details.",e);
			} else {
				//if this is just a failure during the course of the run, ignore it and output it later
				this.exceptionList.add(new Exception("Evaluation of a candidate failed. Filling objectves with NaN.",e));
				
				for (int i = 0; i < objectives.size(); i++) {
					//Check if the given quality is there. If not, add a value at that index.
					if (obj.size() == i){
						addInfeasibleValue(obj,i);
					}
				}
				
				return obj;
			}
		}
	}

/*	private void retrieveCost(PCMPhenotype pheno, Objectives obj, Objective o) {
		//retrieve cost
		double cost = Opt4JStarter.costEvaluator.getTotalCost(pheno.getPcm(), 0);
		addValueIfValid(obj,o,cost);
	}*/

	private void addValueIfValid(Objectives obj, Objective o, double value) {
		//if (this.constraints.get(o).isValid(new DoubleValue(value))){
			obj.add(o,value);
		/*} else {
			obj.add(o,Objective.INFEASIBLE);
		}*/
		
	}

	private void retrieveQuality(PCMPhenotype pheno, Objectives obj, Objective o, IAnalysis analysis)
			throws AnalysisFailedException, CoreException, UserCanceledException, JobFailedException {
		//retrieve response time
		IAnalysisResult result = analysis.analyse(pheno.getPcm());
		addValueIfValid(obj,o,result.getMeanValue());
		
		if (result instanceof IStatisticAnalysisResult){
			IStatisticAnalysisResult statisticResult = (IStatisticAnalysisResult) result;
			ConfidenceInterval c = statisticResult.getConfidenceInterval();
			if (c != null){
				pheno.addConfidence(o, c);
			}
		}
		//Maybe handle a demand too large exception in the simulation separately by setting the objective to infinity. 
		
	}
	
	@Override
	public Collection<Objective> getObjectives() {
		return objectives;
	}
	
	//TODO: Add an interface ExceptionTracker to unify exception handling. 
	public List<Exception> getExceptionList(){
		return this.exceptionList;
	}
	
	private Double getInfeasibleValue(Objective o){
		if (o.getSign().equals(Objective.Sign.MAX)){
			return Double.NEGATIVE_INFINITY;
		} else {
			return Double.POSITIVE_INFINITY;
		}
			
	}
	
	private void addInfeasibleValue(Objectives obj, int objectiveIndex){
		obj.add(this.objectives.get(objectiveIndex), getInfeasibleValue(this.objectives.get(objectiveIndex)));
	}

}
